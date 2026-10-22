package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ur0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ur0 f121396a = null;

    static {
        f121396a = new ur0();
    }

    public ur0() {
        super("live_share_enter_room_fallback", Boolean.TRUE, "分享外置进房数据为空，兜底处理");
    }
}
