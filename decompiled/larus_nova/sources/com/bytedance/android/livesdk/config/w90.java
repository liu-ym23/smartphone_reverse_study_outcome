package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class w90 extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w90 f121506a = null;

    static {
        f121506a = new w90();
    }

    public w90() {
        Float r100 = Float.valueOf(0.1f);
        super("live_monitor_rtc_resolutio_redundancy_threshold", "pk及多人主播连线监控推流分辨率阈值", r100, r100);
    }
}
