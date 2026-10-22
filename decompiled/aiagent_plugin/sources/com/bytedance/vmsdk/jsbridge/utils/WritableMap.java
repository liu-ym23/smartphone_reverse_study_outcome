package com.bytedance.vmsdk.jsbridge.utils;

/* JADX INFO: loaded from: classes.dex */
public interface WritableMap extends ReadableMap {
    void merge(ReadableMap r1);

    void putArray(String r1, WritableArray r2);

    void putBoolean(String r1, boolean r2);

    void putByteArray(String r1, byte[] r2);

    void putByteArrayAsString(byte[] r1, byte[] r2);

    void putDouble(String r1, double r2);

    void putInt(String r1, int r2);

    void putLong(String r1, long r2);

    void putMap(String r1, WritableMap r2);

    void putNativeHostObject(String r1, NativeHostObject r2);

    void putNull(String r1);

    void putString(String r1, String r2);
}
