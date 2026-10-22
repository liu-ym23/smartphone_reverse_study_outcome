package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class h80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h80 f120352a = null;

    static {
        f120352a = new h80();
    }

    public h80() {
        super("live_mem_leak_screen_observer", "修复：屏幕监听内存泄漏问题", Boolean.FALSE, Boolean.TRUE);
    }
}
