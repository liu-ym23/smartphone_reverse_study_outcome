package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class x4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x4 f121575a = null;

    static {
        f121575a = new x4();
    }

    public x4() {
        Boolean r100 = Boolean.TRUE;
        super("fix_destroy_live_play_heap_leak_opt", "解决退房拦截造成的泄漏问题", r100, r100, true);
    }
}
