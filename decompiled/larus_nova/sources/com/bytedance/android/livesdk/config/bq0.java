package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class bq0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bq0 f119892a = null;

    static {
        f119892a = new bq0();
    }

    public bq0() {
        Boolean r100 = Boolean.FALSE;
        super("live_screencast_capture_monitor_enable", "录屏开播推流内容监控", r100, r100);
    }
}
