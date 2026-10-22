package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rp0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rp0 f121149a = null;

    static {
        f121149a = new rp0();
    }

    public rp0() {
        Boolean r100 = Boolean.FALSE;
        super("live_sandbox_miniapp_bootconfig_enable", "沙盒小程序屏蔽bootconfig请求开关", r100, r100);
    }
}
