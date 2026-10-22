package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gj extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gj f120291a = null;

    static {
        f120291a = new gj();
    }

    public gj() {
        Boolean r100 = Boolean.TRUE;
        super("live_card_show_intercept_on_screen_lock", "横屏锁屏状态下不展示讲解卡容器", r100, r100);
    }
}
