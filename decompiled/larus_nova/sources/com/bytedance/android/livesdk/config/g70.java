package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class g70 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g70 f120259a = null;

    static {
        f120259a = new g70();
    }

    public g70() {
        Boolean r100 = Boolean.FALSE;
        super("live_log_anr_optimize", "优化无用高频调用导致的ANR问题", r100, r100);
    }
}
