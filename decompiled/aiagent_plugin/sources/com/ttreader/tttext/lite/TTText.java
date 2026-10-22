package com.ttreader.tttext.lite;

/* JADX INFO: loaded from: classes4.dex */
public class TTText {
    private static native void nativeInitialCache();

    public TTText() {
    }

    public static void Initial() {
        Initial(true);
    }

    public static void Initial(boolean r0) {
        if (r0 == false) goto L4;
        System.loadLibrary("tttext_lite");
    L4:
        nativeInitialCache();
    }
}
