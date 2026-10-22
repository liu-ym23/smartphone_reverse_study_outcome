package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ph0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ph0 f120980a = null;

    static {
        f120980a = new ph0();
    }

    public ph0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_support_link", "是否支持PK中观众上麦", r100, r100);
    }
}
