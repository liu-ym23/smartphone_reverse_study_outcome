package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class by0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final by0 f119907a = null;

    static {
        f119907a = new by0();
    }

    public by0() {
        Boolean r100 = Boolean.FALSE;
        super("live_vs_paidLive_ban_screenRecord", "付费直播是否禁止录屏", r100, r100);
    }
}
