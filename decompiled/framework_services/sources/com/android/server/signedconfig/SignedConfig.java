package com.android.server.signedconfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SignedConfig {
    private static final String CONFIG_KEY_MAX_SDK = "max_sdk";
    private static final String CONFIG_KEY_MIN_SDK = "min_sdk";
    private static final String CONFIG_KEY_VALUES = "values";
    private static final String KEY_CONFIG = "config";
    private static final String KEY_VERSION = "version";
    public final List<PerSdkConfig> perSdkConfig;
    public final int version;

    public static class PerSdkConfig {
        public final int maxSdk;
        public final int minSdk;
        public final Map<String, String> values;

        public PerSdkConfig(int minSdk, int maxSdk, Map<String, String> values) {
            this.minSdk = minSdk;
            this.maxSdk = maxSdk;
            this.values = Collections.unmodifiableMap(values);
        }
    }

    public SignedConfig(int version, List<PerSdkConfig> perSdkConfig) {
        this.version = version;
        this.perSdkConfig = Collections.unmodifiableList(perSdkConfig);
    }

    public PerSdkConfig getMatchingConfig(int sdkVersion) {
        Iterator<PerSdkConfig> r0 = this.perSdkConfig.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        PerSdkConfig config = r0.next();
        if (config.minSdk > sdkVersion) goto L4;
        if (sdkVersion > config.maxSdk) goto L4;
        return config;
    L11:
        return null;
    }

    public static SignedConfig parse(String config, Set<String> allowedKeys, Map<String, Map<String, String>> keyValueMappers) throws InvalidConfigException {
        JSONObject json = new JSONObject(config);     // Catch: JSONException -> L6
        int version = json.getInt(KEY_VERSION);     // Catch: JSONException -> L6
        JSONArray perSdkConfig = json.getJSONArray(KEY_CONFIG);     // Catch: JSONException -> L6
        List<PerSdkConfig> parsedConfigs = new ArrayList();     // Catch: JSONException -> L6
        int i = 0;
    L4:
        if (i >= perSdkConfig.length()) goto L8;
        parsedConfigs.add(parsePerSdkConfig(perSdkConfig.getJSONObject(i), allowedKeys, keyValueMappers));     // Catch: JSONException -> L6
        i = i + 1;     // Catch: JSONException -> L6
        goto L4
    L8:
        return new SignedConfig(version, parsedConfigs);
    L6:
        e = move-exception;
        throw new InvalidConfigException("Could not parse JSON", e);
    }

    private static CharSequence quoted(Object s) {
        if (s != null) goto L6;
        return "null";
    L6:
        return "\"" + s + "\"";
    }

    static PerSdkConfig parsePerSdkConfig(JSONObject json, Set<String> allowedKeys, Map<String, Map<String, String>> keyValueMappers) throws JSONException, InvalidConfigException {
        int minSdk = json.getInt(CONFIG_KEY_MIN_SDK);
        int maxSdk = json.getInt(CONFIG_KEY_MAX_SDK);
        JSONObject valuesJson = json.getJSONObject(CONFIG_KEY_VALUES);
        Map<String, String> values = new HashMap();
        Iterator r4 = valuesJson.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L24;
        String key = (String) r4.next();
        Object valueObject = valuesJson.get(key);
        if (valueObject == JSONObject.NULL) goto L10;
        if (valueObject == null) goto L10;
        String value = valueObject.toString();
    L12:
        if (allowedKeys.contains(key) == false) goto L22;
        if (keyValueMappers.containsKey(key) == false) goto L20;
        Map<String, String> mapper = keyValueMappers.get(key);
        if (mapper.containsKey(value) == false) goto L19;
        value = mapper.get(value);
        goto L20
    L19:
        throw new InvalidConfigException("Config key " + key + " contains unsupported value " + quoted(value));
    L20:
        values.put(key, value);
        goto L4
    L22:
        throw new InvalidConfigException("Config key " + key + " is not allowed");
    L10:
        value = null;
        goto L12
    L24:
        return new PerSdkConfig(minSdk, maxSdk, values);
    }
}
