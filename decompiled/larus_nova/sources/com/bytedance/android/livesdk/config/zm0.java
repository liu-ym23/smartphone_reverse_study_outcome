package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zm0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zm0 f121777a = null;

    static {
        f121777a = new zm0();
    }

    public zm0() {
        Boolean r100 = Boolean.TRUE;
        super("live_reset_has_bgm_flag", "演唱结束需要重置hasBgm", r100, r100);
    }
}
