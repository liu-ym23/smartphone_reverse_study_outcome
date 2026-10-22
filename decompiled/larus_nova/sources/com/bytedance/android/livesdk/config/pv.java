package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pv extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pv f121009a = null;

    static {
        f121009a = new pv();
    }

    public pv() {
        Boolean r100 = Boolean.FALSE;
        super("disable_show_live_button_in_feed_drawer", "抽屉更多直播隐藏开播按钮", r100, r100);
    }
}
