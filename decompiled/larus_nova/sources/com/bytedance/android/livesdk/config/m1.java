package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class m1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f120724a = null;

    static {
        f120724a = new m1();
    }

    public m1() {
        Boolean r100 = Boolean.TRUE;
        super("live_clear_screen_fix_vs_portrait_click", "修复节目竖屏直播间单击进入清屏而不是唤起播控进度条的bug", r100, r100);
    }
}
