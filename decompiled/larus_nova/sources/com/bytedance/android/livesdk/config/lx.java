package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lx extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lx f120714a = null;

    static {
        f120714a = new lx();
    }

    public lx() {
        Boolean r100 = Boolean.TRUE;
        super("live_follow_log_enable", "关注Log上报开关", r100, r100, true);
    }
}
