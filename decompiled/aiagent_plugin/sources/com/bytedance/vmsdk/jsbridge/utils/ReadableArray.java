package com.bytedance.vmsdk.jsbridge.utils;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface ReadableArray {
    ReadableArray getArray(int r1);

    boolean getBoolean(int r1);

    byte getByte(int r1);

    byte[] getByteArray(int r1);

    char getChar(int r1);

    double getDouble(int r1);

    b getDynamic(int r1);

    int getInt(int r1);

    long getLong(int r1);

    ReadableMap getMap(int r1);

    NativeHostObject getNativeHostObject(int r1);

    short getShort(int r1);

    String getString(int r1);

    ReadableType getType(int r1);

    boolean isNull(int r1);

    int size();

    ArrayList<Object> toArrayList();
}
