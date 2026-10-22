package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qd0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qd0 f121046a = null;

    static {
        f121046a = new qd0();
    }

    public qd0() {
        Boolean r100 = Boolean.TRUE;
        super("live_old_long_press_panel_support_show_and_dismiss_callback", "旧版长按面板支持Item的onShow和onDismiss回调", r100, r100);
    }
}
