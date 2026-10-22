package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ef0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ef0 f120121a = null;

    static {
        f120121a = new ef0();
    }

    public ef0() {
        Boolean r100 = Boolean.TRUE;
        super("live_paid_live_enable_linkmic", "付费直播间支持用户连线能力", r100, r100);
    }
}
