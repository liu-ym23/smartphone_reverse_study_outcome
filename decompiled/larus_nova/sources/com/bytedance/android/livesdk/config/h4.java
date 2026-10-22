package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class h4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h4 f120340a = null;

    static {
        f120340a = new h4();
    }

    public h4() {
        Boolean r100 = Boolean.FALSE;
        super("enable_setting_state_value_cache", "SettingState的setting缓存", r100, r100);
    }
}
