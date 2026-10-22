package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class g60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g60 f120257a = null;

    static {
        f120257a = new g60();
    }

    public g60() {
        Boolean r100 = Boolean.TRUE;
        super("live_link_and_game_change_fix", "游戏直播刷到连屏后无法横屏fix", r100, r100);
    }
}
