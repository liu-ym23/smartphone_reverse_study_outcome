package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hh0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hh0 f120377a = null;

    static {
        f120377a = new hh0();
    }

    public hh0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_monitor_rtc_resolution_enable", "pk及多人主播连线监控推流分辨率开关", r100, r100);
    }
}
