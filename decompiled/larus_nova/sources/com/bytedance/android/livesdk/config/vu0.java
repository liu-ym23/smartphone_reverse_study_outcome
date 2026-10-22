package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class vu0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vu0 f121479a = null;

    static {
        f121479a = new vu0();
    }

    public vu0() {
        Boolean r100 = Boolean.TRUE;
        super("live_toolbar_button_dynamic_enable", "toolBar button 入口PK、连线使用 Room 信息", r100, r100, true);
    }
}
