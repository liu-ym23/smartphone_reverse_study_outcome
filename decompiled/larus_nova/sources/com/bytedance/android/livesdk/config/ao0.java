package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ao0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ao0 f119808a = null;

    static {
        f119808a = new ao0();
    }

    public ao0() {
        Boolean r100 = Boolean.TRUE;
        super("live_room_close_jsb_enable", "是否支持通过JS关闭当前直播间", r100, r100);
    }
}
