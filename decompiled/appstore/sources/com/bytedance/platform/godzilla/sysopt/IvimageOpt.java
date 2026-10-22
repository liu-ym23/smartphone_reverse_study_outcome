package com.bytedance.platform.godzilla.sysopt;

/* JADX INFO: loaded from: classes.dex */
public final class IvimageOpt {
    static {
        System.loadLibrary("godzilla-sysopt");
    }

    public static native void end();

    public static native void start();
}
