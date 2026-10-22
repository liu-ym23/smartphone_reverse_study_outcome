package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pm0 extends SSettingKey<p71> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pm0 f120992a = null;

    static {
        f120992a = new pm0();
    }

    public pm0() {
        super("live_record_delay_time_setting_for_compatible", new p71(), "录屏启动延迟导致安卓15录屏崩溃问题兜底");
    }
}
