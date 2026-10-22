package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fn0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fn0 f120218a = null;

    static {
        f120218a = new fn0();
    }

    public fn0() {
        Boolean r100 = Boolean.TRUE;
        super("live_revenue_interaction_sei_monitor", "交互层透传sei监控 开关", r100, r100);
    }
}
