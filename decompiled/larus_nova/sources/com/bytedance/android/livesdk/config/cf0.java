package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class cf0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cf0 f119943a = null;

    static {
        f119943a = new cf0();
    }

    public cf0() {
        Boolean r100 = Boolean.TRUE;
        super("live_paid_live_async_authentication_enable", "付费直播打开流异步鉴权", r100, r100);
    }
}
