package com.android.webview.chromium;

/* JADX INFO: loaded from: classes3.dex */
public class DrawFunctor {
    public DrawFunctor() {
    }

    private static native long nativeGetFunctionTable();

    public static long a() {
        return nativeGetFunctionTable();
    }
}
