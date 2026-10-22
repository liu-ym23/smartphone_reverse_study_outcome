package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ok extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ok f120912a = null;

    public ok() {
        super("live_backend_chunk_sleep_time", "backend卡顿优化，数据分段返回延迟时间", 0, 0);
    }

    static {
        f120912a = new ok();
    }
}
