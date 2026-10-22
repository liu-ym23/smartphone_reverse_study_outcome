package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sl extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sl f121236a = null;

    static {
        f121236a = new sl();
    }

    public sl() {
        Boolean r100 = Boolean.TRUE;
        super("live_commerce_mini_window_transparent_fix", "兜底修复小窗路径中有透明activity的异常", r100, r100);
    }
}
