package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rk extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rk f121138a = null;

    static {
        f121138a = new rk();
    }

    public rk() {
        Boolean r100 = Boolean.FALSE;
        super("live_clean_mode_hide_gradient_layer", "看播端竖屏清屏模式下是否隐藏上下蒙层", r100, r100);
    }
}
