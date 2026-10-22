package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ci0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ci0 f119955a = null;

    static {
        f119955a = new ci0();
    }

    public ci0() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_memory_leak_fix_enable", "播放器内存泄漏开关", r100, r100);
    }
}
