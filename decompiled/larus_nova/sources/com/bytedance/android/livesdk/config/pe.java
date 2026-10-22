package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pe extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pe f120972a = null;

    static {
        f120972a = new pe();
    }

    public pe() {
        Boolean r100 = Boolean.FALSE;
        super("live_async_report_wto_enable", "TEA埋点异步上报接入WTO", r100, r100);
    }
}
