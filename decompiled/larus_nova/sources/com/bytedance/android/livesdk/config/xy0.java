package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xy0 extends SSettingKey<j91> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xy0 f121641a = null;

    static {
        xy0 r100 = new xy0();
        f121641a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public xy0() {
        super("live_widget_priority_config", "widget优先级配置", new j91(), new j91());
    }
}
