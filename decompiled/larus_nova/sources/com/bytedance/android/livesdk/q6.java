package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class q6 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q6 f156879a = null;

    static {
        f156879a = new q6();
    }

    public q6() {
        Boolean r100 = Boolean.TRUE;
        super("live_pad_keyboard_v3_optimize", "pad上V3输入面板融合的兜底开关", r100, r100);
    }
}
