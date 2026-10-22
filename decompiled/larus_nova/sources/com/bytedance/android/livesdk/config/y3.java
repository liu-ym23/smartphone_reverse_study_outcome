package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class y3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y3 f121651a = null;

    static {
        y3 r100 = new y3();
        f121651a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public y3() {
        Boolean r100 = Boolean.FALSE;
        super("enable_multi_player", "是否开启多播放器", r100, r100);
    }
}
