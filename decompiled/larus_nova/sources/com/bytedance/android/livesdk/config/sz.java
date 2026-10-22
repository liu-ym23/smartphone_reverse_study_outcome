package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sz extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sz f121263a = null;

    static {
        f121263a = new sz();
    }

    public sz() {
        Boolean r100 = Boolean.TRUE;
        super("live_hamlet_avatar_enable_mix_game_audio", "hamlet avatar是否支持混音游戏声音", r100, r100);
    }
}
