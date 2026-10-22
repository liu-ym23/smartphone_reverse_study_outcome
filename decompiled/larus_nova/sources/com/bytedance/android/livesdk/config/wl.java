package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wl extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wl f121535a = null;

    static {
        f121535a = new wl();
    }

    public wl() {
        Boolean r100 = Boolean.TRUE;
        super("live_common_minor_intercept", "未成年拦截开关", r100, r100, true);
    }
}
