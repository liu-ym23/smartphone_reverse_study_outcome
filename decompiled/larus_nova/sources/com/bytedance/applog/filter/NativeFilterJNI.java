package com.bytedance.applog.filter;

/* JADX INFO: loaded from: classes14.dex */
public class NativeFilterJNI {
    public NativeFilterJNI() {
    }

    public static native void nativeClearCache(String r100);

    public static native int nativeInitServerFilter(String r100, String r101);

    public static native boolean nativeIsEventAllowed(String r100, String r101);

    public static native boolean nativeIsServerFilterEmpty(String r100);

    public static native int nativeSetServerFilterConfig(String r100, String r101);
}
