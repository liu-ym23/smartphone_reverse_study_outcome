package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class cn0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cn0 f119966a = null;

    static {
        f119966a = new cn0();
    }

    public cn0() {
        Boolean r100 = Boolean.TRUE;
        super("live_restart_live_when_login_protect", "直播间内登录触发重新进房兜底开关", r100, r100, true);
    }
}
