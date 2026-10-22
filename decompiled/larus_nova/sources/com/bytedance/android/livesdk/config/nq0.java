package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nq0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nq0 f120853a = null;

    static {
        f120853a = new nq0();
    }

    public nq0() {
        Boolean r100 = Boolean.TRUE;
        super("live_screen_capture_with_timon_enable", "截图分享面板监听接入Timon", r100, r100);
    }
}
