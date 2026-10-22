package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class r1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f156922a = null;

    static {
        f156922a = new r1();
    }

    public r1() {
        Boolean r100 = Boolean.FALSE;
        super("live_performance_manager_init_opt", "直播PerformanceManager多线程初始化优化", r100, r100);
    }
}
