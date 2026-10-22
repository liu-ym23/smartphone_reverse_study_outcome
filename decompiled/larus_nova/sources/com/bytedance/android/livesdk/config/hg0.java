package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hg0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hg0 f120375a = null;

    static {
        f120375a = new hg0();
    }

    public hg0() {
        Boolean r100 = Boolean.FALSE;
        super("live_perf_monitor_collect_full_gc", "性能埋点收集全量gc info", r100, r100);
    }
}
