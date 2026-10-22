package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class cv0 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cv0 f119982a = null;

    static {
        f119982a = new cv0();
    }

    public cv0() {
        super("live_toolbar_load_time_stats_sampling", "toolbar加载耗时统计采样率0-100000", 10, 10);
    }
}
