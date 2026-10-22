package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class go0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final go0 f120303a = null;

    static {
        f120303a = new go0();
    }

    public go0() {
        Boolean r100 = Boolean.TRUE;
        super("live_room_end_vip_enable", "直播间结束后用户等待优化功能开启", r100, r100, false);
    }
}
