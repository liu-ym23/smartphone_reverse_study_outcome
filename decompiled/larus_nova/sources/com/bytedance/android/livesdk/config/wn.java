package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class wn extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wn f121539a = null;

    static {
        f121539a = new wn();
    }

    public wn() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_enter_anim_widget_landscape", "横屏不加载EnterAnimWidget", r100, r100);
    }
}
