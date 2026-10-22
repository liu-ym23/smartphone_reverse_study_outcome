package com.bytedance.vmsdk.jsbridge.utils;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public interface ReadableMap {
    ReadableArray getArray(String r1);

    ReadableArray getArray(String r1, ReadableArray r2);

    boolean getBoolean(String r1);

    boolean getBoolean(String r1, boolean r2);

    byte[] getByteArray(String r1);

    byte[] getByteArray(String r1, byte[] r2);

    double getDouble(String r1);

    double getDouble(String r1, double r2);

    b getDynamic(String r1);

    int getInt(String r1);

    int getInt(String r1, int r2);

    long getLong(String r1);

    long getLong(String r1, long r2);

    ReadableMap getMap(String r1);

    ReadableMap getMap(String r1, ReadableMap r2);

    NativeHostObject getNativeHostObject(String r1);

    String getString(String r1);

    String getString(String r1, String r2);

    ReadableType getType(String r1);

    boolean hasKey(String r1);

    boolean isNull(String r1);

    ReadableMapKeySetIterator keySetIterator();

    int size();

    androidx.b.a<String, Object> toArrayMap();

    HashMap<String, Object> toHashMap();
}
