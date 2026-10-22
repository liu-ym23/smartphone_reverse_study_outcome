package com.stepos.config.dag.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonParseHelper {

    @FunctionalInterface
    public interface BiFunction<T, U, R> {
        R apply(T t, U u);
    }

    public static <T> List<T> parseObjectList(JSONObject json, String key, Function<JSONObject, T> parser) {
        T item;
        List<T> result = new ArrayList<>();
        JSONArray array = json.optJSONArray(key);
        if (array != null) {
            for (int i = 0; i < array.length(); i++) {
                JSONObject itemJson = array.optJSONObject(i);
                if (itemJson != null && (item = parser.apply(itemJson)) != null) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    public static List<String> parseStringList(JSONObject json, String key) {
        List<String> result = new ArrayList<>();
        JSONArray array = json.optJSONArray(key);
        if (array != null) {
            for (int i = 0; i < array.length(); i++) {
                String item = array.optString(i);
                if (item != null && !item.isEmpty()) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    public static List<Integer> parseIntList(JSONObject json, String key) {
        List<Integer> result = new ArrayList<>();
        JSONArray array = json.optJSONArray(key);
        if (array != null) {
            for (int i = 0; i < array.length(); i++) {
                result.add(Integer.valueOf(array.optInt(i)));
            }
        }
        return result;
    }

    public static Map<String, List<String>> parseStringListMap(JSONObject json, String key) {
        Map<String, List<String>> result = new HashMap<>();
        JSONObject mapJson = json.optJSONObject(key);
        if (mapJson != null) {
            Iterator<String> keys = mapJson.keys();
            while (keys.hasNext()) {
                String mapKey = keys.next();
                List<String> list = parseStringList(mapJson, mapKey);
                result.put(mapKey, list);
            }
        }
        return result;
    }

    public static <T> Map<String, T> parseObjectMap(JSONObject json, String key, Function<JSONObject, T> parser) {
        T item;
        Map<String, T> result = new HashMap<>();
        JSONObject mapJson = json.optJSONObject(key);
        if (mapJson != null) {
            Iterator<String> keys = mapJson.keys();
            while (keys.hasNext()) {
                String mapKey = keys.next();
                JSONObject itemJson = mapJson.optJSONObject(mapKey);
                if (itemJson != null && (item = parser.apply(itemJson)) != null) {
                    result.put(mapKey, item);
                }
            }
        }
        return result;
    }

    public static <T> Map<String, T> parseObjectMapWithKeys(JSONObject json, String key, String[] keys, BiFunction<String, JSONObject, T> parser) {
        T item;
        Map<String, T> result = new HashMap<>();
        JSONObject mapJson = json.optJSONObject(key);
        if (mapJson != null) {
            for (String mapKey : keys) {
                if (mapJson.has(mapKey) && (item = parser.apply(mapKey, mapJson)) != null) {
                    result.put(mapKey, item);
                }
            }
        }
        return result;
    }

    public static String getString(JSONObject json, String key, String defaultValue) {
        return json.optString(key, defaultValue);
    }

    public static boolean getBoolean(JSONObject json, String key, boolean defaultValue) {
        return json.optBoolean(key, defaultValue);
    }

    public static int getInt(JSONObject json, String key, int defaultValue) {
        return json.optInt(key, defaultValue);
    }

    public static long getLong(JSONObject json, String key, long defaultValue) {
        return json.optLong(key, defaultValue);
    }

    public static double getDouble(JSONObject json, String key, double defaultValue) {
        return json.optDouble(key, defaultValue);
    }
}
