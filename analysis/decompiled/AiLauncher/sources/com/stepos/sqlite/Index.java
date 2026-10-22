package com.stepos.sqlite;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class Index {
    static {
        System.loadLibrary("sqlite-vector");
    }

    private native void nativeLoadFeature(String str);

    private native void nativeUnloadFeature();

    public native void nativeInit(String str);

    public native void nativeRelease();

    public native boolean nativeSaveFeature(int i10, ByteBuffer byteBuffer);

    public native LinkedHashMap<Integer, Float> nativeSearch(float[] fArr, Iterator<Integer> it);

    public native int nativeSyncDeleted(String str);

    public native LinkedHashMap<Integer, Float> nativeTest(float[] fArr);
}
