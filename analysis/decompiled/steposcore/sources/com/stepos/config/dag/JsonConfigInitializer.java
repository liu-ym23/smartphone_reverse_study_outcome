package com.stepos.config.dag;

import android.util.Log;
import com.stepos.config.dag.ConfigBean;
import com.stepos.config.dag.loader.ConfigLoader;
import com.stepos.config.dag.loader.JsonConfigLoader;
import com.stepos.config.dag.util.JsonBeanMapper;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class JsonConfigInitializer<T extends ConfigBean> {
    private static final String DEFAULT_TAG = "JsonConfigInit";

    protected abstract Class<T> getConfigClass();

    protected abstract String getConfigName();

    protected abstract String getConfigPath();

    protected String getLogTag() {
        return DEFAULT_TAG;
    }

    protected InitializationStrategy getInitStrategy() {
        return InitializationStrategy.EAGER;
    }

    protected int getInitPriority() {
        return 100;
    }

    public synchronized void initialize() {
        ConfigurationRegistry registry;
        String tag = getLogTag();
        String configName = getConfigName();
        String configPath = getConfigPath();
        Class<T> configClass = getConfigClass();
        try {
            registry = ConfigurationRegistry.getInstance();
        } catch (Exception e) {
            Log.e(tag, "Failed to initialize " + configName, e);
        }
        if (isConfigRegistered(registry, configName)) {
            Log.w(tag, configName + " already initialized");
            return;
        }
        JsonConfigLoader jsonLoader = new JsonConfigLoader(registry);
        jsonLoader.registerBeanClass(configName, configClass);
        try {
            jsonLoader.loadJson(configPath);
            Log.i(tag, "Loaded config from: " + configPath);
        } catch (Exception e2) {
            Log.w(tag, "Config file not found at " + configPath + ", will use default config");
        }
        GenericJsonConfigLoader<T> configLoader = new GenericJsonConfigLoader<>(jsonLoader);
        registry.registerConfigLoader(configName, configLoader);
        registry.registerConfig(new ConfigNode(configName, configClass, Collections.emptyList(), getInitStrategy(), getInitPriority()));
        Log.i(tag, configName + " initialization completed");
    }

    public synchronized void lateInitialize() {
        ConfigurationRegistry registry;
        String tag = getLogTag();
        String configName = getConfigName();
        String configPath = getConfigPath();
        Class<T> configClass = getConfigClass();
        try {
            registry = ConfigurationRegistry.getInstance();
        } catch (Exception e) {
            Log.e(tag, "Failed to lateInitialize " + configName, e);
        }
        if (isConfigRegistered(registry, configName)) {
            Log.w(tag, configName + " already initialized");
            return;
        }
        if (!registry.isFrameworkInitialized()) {
            initialize();
            return;
        }
        JsonConfigLoader jsonLoader = new JsonConfigLoader(registry);
        jsonLoader.registerBeanClass(configName, configClass);
        try {
            jsonLoader.loadJson(configPath);
        } catch (Exception e2) {
            Log.w(tag, "Config file not found at " + configPath + ", will use default config");
        }
        GenericJsonConfigLoader<T> configLoader = new GenericJsonConfigLoader<>(jsonLoader);
        registry.registerConfigLoader(configName, configLoader);
        registry.lateAddAndInit(new ConfigNode(configName, configClass, Collections.emptyList(), getInitStrategy(), getInitPriority()));
        Log.i(tag, configName + " late initialization completed");
    }

    public T getConfig() {
        try {
            return (T) ConfigurationRegistry.getInstance().getConfig(getConfigName());
        } catch (ConfigInitException e) {
            Log.e(getLogTag(), "Failed to get " + getConfigName(), e);
            return null;
        }
    }

    public void reloadConfig() {
        String tag = getLogTag();
        String configName = getConfigName();
        String configPath = getConfigPath();
        try {
            ConfigurationRegistry registry = ConfigurationRegistry.getInstance();
            JsonConfigLoader jsonLoader = getJsonLoader(registry, configName);
            if (jsonLoader != null) {
                jsonLoader.reloadJson(configPath);
            }
            registry.reloadConfig(configName);
            Log.i(tag, configName + " reloaded");
        } catch (Exception e) {
            Log.e(tag, "Failed to reload " + configName, e);
        }
    }

    private boolean isConfigRegistered(ConfigurationRegistry registry, String configName) {
        try {
            registry.getConfig(configName);
            return true;
        } catch (ConfigInitException e) {
            return false;
        }
    }

    private JsonConfigLoader getJsonLoader(ConfigurationRegistry registry, String configName) {
        try {
            ConfigLoader loader = registry.getConfigLoader(configName);
            if (loader instanceof GenericJsonConfigLoader) {
                return ((GenericJsonConfigLoader) loader).getJsonLoader();
            }
            return null;
        } catch (Exception e) {
            Log.w(getLogTag(), "Failed to get JsonConfigLoader", e);
            return null;
        }
    }

    private static class GenericJsonConfigLoader<T extends ConfigBean> implements ConfigLoader {
        private final JsonConfigLoader jsonLoader;

        GenericJsonConfigLoader(JsonConfigLoader loader) {
            this.jsonLoader = loader;
        }

        @Override // com.stepos.config.dag.loader.ConfigLoader
        public Object getConfigData(String configName) {
            return this.jsonLoader.getJsonObject(configName);
        }

        @Override // com.stepos.config.dag.loader.ConfigLoader
        public void parseConfig(String configName, ConfigBean bean, ConfigurationRegistry registry) throws IllegalAccessException, IllegalArgumentException, ConfigInitException, InvocationTargetException {
            JSONObject json = this.jsonLoader.getJsonObject(configName);
            if (json != null && bean != null) {
                try {
                    if (hasParseFromJsonMethod(bean)) {
                        bean.getClass().getMethod("parseFromJson", JSONObject.class, ConfigurationRegistry.class).invoke(bean, json, registry);
                    } else {
                        JsonBeanMapper.mapJsonToBean(json, bean);
                    }
                } catch (Exception e) {
                    throw new ConfigInitException("Failed to parse config: " + configName, e);
                }
            }
        }

        private boolean hasParseFromJsonMethod(ConfigBean bean) throws NoSuchMethodException, SecurityException {
            try {
                bean.getClass().getMethod("parseFromJson", JSONObject.class, ConfigurationRegistry.class);
                return true;
            } catch (NoSuchMethodException e) {
                return false;
            }
        }

        JsonConfigLoader getJsonLoader() {
            return this.jsonLoader;
        }
    }
}
