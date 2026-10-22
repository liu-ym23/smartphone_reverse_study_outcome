package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gh0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gh0 f120288a = null;

    static {
        f120288a = new gh0();
    }

    public gh0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_kick_out_reset_after_end_success", "浮窗布局下Pk踢人在onEndSuccess中提前reset", r100, r100);
    }
}
