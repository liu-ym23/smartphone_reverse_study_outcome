package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class q50 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q50 f121030a = null;

    static {
        f121030a = new q50();
    }

    public q50() {
        Boolean r100 = Boolean.TRUE;
        super("live_latch_pre_start_init_annie", "latch 提前执行初始化 Annie", r100, r100);
    }
}
