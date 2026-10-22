package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class r3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r3 f121101a = null;

    static {
        f121101a = new r3();
    }

    public r3() {
        Boolean r100 = Boolean.TRUE;
        super("enable_live_player_framelayout_exception_margin_fallback", "是否开启播放器流画面高度异常兜底复原逻辑", r100, r100);
    }
}
