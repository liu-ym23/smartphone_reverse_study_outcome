package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mi0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mi0 f120758a = null;

    static {
        f120758a = new mi0();
    }

    public mi0() {
        Boolean r100 = Boolean.TRUE;
        super(LiveInitSettingKeys.LIVE_PLAYER_STRATEGY_SERVICE_SWITCH, "直播播放器策略服务开关", r100, r100);
    }
}
