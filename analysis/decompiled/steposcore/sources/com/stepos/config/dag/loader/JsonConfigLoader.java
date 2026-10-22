package com.stepos.config.dag.loader;

import android.util.Log;
import com.stepos.config.dag.ConfigBean;
import com.stepos.config.dag.ConfigNode;
import com.stepos.config.dag.ConfigurationRegistry;
import com.stepos.config.dag.InitializationStrategy;
import com.stepos.config.dag.annotation.DependsOn;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonConfigLoader {
    private static final String TAG = "JsonConfigLoader";
    private final ConfigurationRegistry registry;
    private final Map<String, JSONObject> jsonObjects = new ConcurrentHashMap();
    private final Map<String, Class<? extends ConfigBean>> beanClassMapping = new ConcurrentHashMap();
    private final List<String> jsonPaths = new ArrayList();

    public JsonConfigLoader(ConfigurationRegistry registry) {
        this.registry = registry;
    }

    public void registerBeanClass(String configName, Class<? extends ConfigBean> beanClass) {
        this.beanClassMapping.put(configName, beanClass);
    }

    public void loadJson(String jsonPath) throws Exception {
        Log.i(TAG, "Loading config from: " + jsonPath);
        this.jsonPaths.add(jsonPath);
        String configName = readAndCache(jsonPath);
        Class<? extends ConfigBean> beanClass = getBeanClassForConfig(configName);
        if (beanClass != null) {
            InitializationStrategy strategy = getStrategyFromAnnotation(beanClass);
            int priority = getPriorityFromAnnotation(beanClass);
            List<String> deps = getDependenciesFromAnnotation(beanClass);
            ConfigNode node = new ConfigNode(configName, beanClass, deps, strategy, priority);
            this.registry.registerConfig(node);
        } else {
            Log.w(TAG, "No ConfigBean class found for config: " + configName);
        }
        Log.i(TAG, "Loaded config from: " + jsonPath);
    }

    private String readAndCache(String jsonPath) throws Exception {
        File jsonFile = new File(jsonPath);
        if (!jsonFile.exists()) {
            throw new FileNotFoundException("Config file not found: " + jsonPath);
        }
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8));
        while (true) {
            try {
                String line = reader.readLine();
                if (line != null) {
                    content.append(line);
                } else {
                    reader.close();
                    JSONObject json = new JSONObject(content.toString());
                    String configName = extractConfigName(jsonPath, json);
                    this.jsonObjects.put(configName, json);
                    return configName;
                }
            } catch (Throwable th) {
                try {
                    reader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    private String extractConfigName(String jsonPath, JSONObject json) {
        String fileName = new File(jsonPath).getName();
        String configName = fileName.replace(".json", "");
        if (json.has("configName")) {
            return json.optString("configName", configName);
        }
        if (json.has("name")) {
            return json.optString("name", configName);
        }
        return configName;
    }

    private Class<? extends ConfigBean> getBeanClassForConfig(String configName) {
        return this.beanClassMapping.get(configName);
    }

    private InitializationStrategy getStrategyFromAnnotation(Class<? extends ConfigBean> beanClass) {
        com.stepos.config.dag.annotation.ConfigNode annotation = (com.stepos.config.dag.annotation.ConfigNode) beanClass.getAnnotation(com.stepos.config.dag.annotation.ConfigNode.class);
        return annotation != null ? annotation.strategy() : InitializationStrategy.EAGER;
    }

    private int getPriorityFromAnnotation(Class<? extends ConfigBean> beanClass) {
        com.stepos.config.dag.annotation.ConfigNode annotation = (com.stepos.config.dag.annotation.ConfigNode) beanClass.getAnnotation(com.stepos.config.dag.annotation.ConfigNode.class);
        if (annotation != null) {
            return annotation.priority();
        }
        return 1000;
    }

    private List<String> getDependenciesFromAnnotation(Class<? extends ConfigBean> beanClass) {
        DependsOn dependsOn = (DependsOn) beanClass.getAnnotation(DependsOn.class);
        if (dependsOn != null && dependsOn.value().length > 0) {
            List<String> deps = new ArrayList<>();
            for (String dep : dependsOn.value()) {
                deps.add(dep);
            }
            return deps;
        }
        return Collections.emptyList();
    }

    public JSONObject getJsonObject(String configName) {
        return this.jsonObjects.get(configName);
    }

    public void reloadJson(String jsonPath) throws Exception {
        Log.i(TAG, "Reloading config from: " + jsonPath);
        readAndCache(jsonPath);
    }

    public Set<String> getLoadedConfigNames() {
        return Collections.unmodifiableSet(this.jsonObjects.keySet());
    }
}
