package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tg0 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tg0 f121297a = null;

    static {
        f121297a = new tg0();
    }

    public tg0() {
        super("live_ping_anchor_interval_config", "ping间隔配置", 15000L, 15000L, true);
    }
}
