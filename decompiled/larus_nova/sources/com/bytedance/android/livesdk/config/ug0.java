package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ug0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ug0 f121372a = null;

    static {
        f121372a = new ug0();
    }

    public ug0() {
        Boolean r100 = Boolean.FALSE;
        super("live_ping_anchor_interval_config_enable", "ping间隔配置是否生效", r100, r100, true);
    }
}
