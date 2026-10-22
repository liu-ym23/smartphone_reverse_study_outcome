package com.baidu.platform.comapi.bmsdk;

/* JADX INFO: loaded from: classes39.dex */
public class BmFinalizerObject {
    private static native void nativeFinalizer(long r100);

    private BmFinalizerObject() {
    }

    public static void a(long r100) {
        if (r100 == 0) goto L6;
        nativeFinalizer(r100);
        return;
    }
}
