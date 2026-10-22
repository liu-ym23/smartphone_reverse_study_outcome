package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pg0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pg0 f120977a = null;

    static {
        f120977a = new pg0();
    }

    public pg0() {
        Boolean r100 = Boolean.FALSE;
        super("live_pinch_clean_enable", "直播间放大模式是否触发清屏", r100, r100);
    }
}
