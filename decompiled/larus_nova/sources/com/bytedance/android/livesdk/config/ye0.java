package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class ye0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ye0 f121679a = null;

    static {
        f121679a = new ye0();
    }

    public ye0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pad_clearscreen_close_adapter", "Pad清屏模式关闭按钮适配", r100, r100);
    }
}
