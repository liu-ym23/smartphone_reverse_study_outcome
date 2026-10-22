package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zp0 extends SSettingKey<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zp0 f121783a = null;

    static {
        f121783a = new zp0();
    }

    public zp0() {
        Double r100 = Double.valueOf(-1.0d);
        super("live_scrollable_angle", "直播内流滑动角度调整", r100, r100);
    }
}
