package com.baidu.platform.comapi.bmsdk;

/* loaded from: classes.dex */
public class BmFinalizerObject {
    private BmFinalizerObject() {
    }

    public static void a(long j4) {
        if (j4 != 0) {
            nativeFinalizer(j4);
        }
    }

    private static native void nativeFinalizer(long j4);
}
