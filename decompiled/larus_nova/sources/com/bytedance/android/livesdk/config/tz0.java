package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tz0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tz0 f121337a = null;

    static {
        f121337a = new tz0();
    }

    public tz0() {
        Boolean r100 = Boolean.TRUE;
        super("live_xplay_pause_or_resume_game_switch", "主播退后台是否调用 pauseGame 开关", r100, r100);
    }
}
