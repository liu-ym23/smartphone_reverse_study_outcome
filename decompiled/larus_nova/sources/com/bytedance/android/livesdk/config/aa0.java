package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class aa0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa0 f119773a = null;

    static {
        f119773a = new aa0();
    }

    public aa0() {
        Boolean r100 = Boolean.FALSE;
        super("live_more_dialog_capture_icon_show_enable", "更多面板是否展示摄像头开关", r100, r100);
    }
}
