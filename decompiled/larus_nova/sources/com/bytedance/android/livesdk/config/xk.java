package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xk extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xk f121612a = null;

    static {
        f121612a = new xk();
    }

    public xk() {
        Boolean r100 = Boolean.TRUE;
        super("live_clear_screen_fling_exit", "是否支持在清屏状态下右滑退出直播间的兜底开关", r100, r100);
    }
}
