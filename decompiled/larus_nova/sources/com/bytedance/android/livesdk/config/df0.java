package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class df0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final df0 f120028a = null;

    static {
        f120028a = new df0();
    }

    public df0() {
        Boolean r100 = Boolean.FALSE;
        super("live_paid_live_continue_timing_enable", "流暂停时是否继续倒计时", r100, r100);
    }
}
