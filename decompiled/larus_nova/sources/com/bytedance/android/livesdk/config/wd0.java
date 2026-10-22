package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wd0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wd0 f121516a = null;

    static {
        f121516a = new wd0();
    }

    public wd0() {
        super("live_open_live_monitor_enable", "开播卡顿采集间隔，单位ms", Boolean.FALSE, Boolean.TRUE);
    }
}
