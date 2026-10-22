package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class r1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f121097a = null;

    static {
        f121097a = new r1();
    }

    public r1() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_clear_screen_trans_anim_view_gone", "修复退出清屏位移动画结束后view是gone的bug", r100, r100);
    }
}
