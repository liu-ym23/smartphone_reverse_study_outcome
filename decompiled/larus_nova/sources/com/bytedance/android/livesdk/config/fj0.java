package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fj0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fj0 f120208a = null;

    static {
        f120208a = new fj0();
    }

    public fj0() {
        Boolean r100 = Boolean.FALSE;
        super("live_prefetch_avoid_thread_switching", "避免 prefetch 回调线程切换", r100, r100);
    }
}
