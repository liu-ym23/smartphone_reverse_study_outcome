package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pf extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pf f120974a = null;

    static {
        f120974a = new pf();
    }

    public pf() {
        Boolean r100 = Boolean.TRUE;
        super("paid_live_auto_open_payment_page_check", "付费直播试看结束后自动拉提单是否检查当前提单页拉起状态", r100, r100);
    }
}
