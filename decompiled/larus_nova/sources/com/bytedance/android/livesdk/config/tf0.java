package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tf0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tf0 f121295a = null;

    static {
        f121295a = new tf0();
    }

    public tf0() {
        Boolean r100 = Boolean.FALSE;
        super("live_performance_enable_auto_defence", "开启自动防劣化开关", r100, r100);
    }
}
