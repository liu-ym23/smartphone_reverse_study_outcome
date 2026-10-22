package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class b70 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b70 f119846a = null;

    static {
        f119846a = new b70();
    }

    public b70() {
        super("live_load_stall_monitor_duration", "起播卡顿采集间隔，单位ms", -1L, -1L);
    }
}
