package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qh0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qh0 f121056a = null;

    static {
        f121056a = new qh0();
    }

    public qh0() {
        Boolean r100 = Boolean.TRUE;
        super("live_support_start_pk_with_audience", "是否支持主播带嘉宾发起 PK", r100, r100);
    }
}
