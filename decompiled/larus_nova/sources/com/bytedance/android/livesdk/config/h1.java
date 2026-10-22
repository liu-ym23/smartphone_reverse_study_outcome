package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class h1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h1 f120329a = null;

    static {
        f120329a = new h1();
    }

    public h1() {
        Boolean r100 = Boolean.FALSE;
        super("live_clear_screen_click_player_opt", "清屏状态下点击播放器画面可以退出清屏", r100, r100);
    }
}
