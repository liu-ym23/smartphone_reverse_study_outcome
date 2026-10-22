package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dj0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dj0 f120038a = null;

    static {
        f120038a = new dj0();
    }

    public dj0() {
        Boolean r100 = Boolean.TRUE;
        super("live_power_function_enable", "是否开启直播电池功耗采集", r100, r100);
    }
}
