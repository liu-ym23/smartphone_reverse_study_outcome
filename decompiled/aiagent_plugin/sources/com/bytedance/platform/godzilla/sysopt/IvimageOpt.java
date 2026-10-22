package com.bytedance.platform.godzilla.sysopt;

/* JADX INFO: loaded from: classes.dex */
public final class IvimageOpt {
    public static native void end();

    public static native void start();

    static {
        System.loadLibrary("godzilla-sysopt");
    }

    private IvimageOpt() {
    }
}
