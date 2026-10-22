package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class d6 extends SettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d6 f121934a = null;

    static {
        f121934a = new d6();
    }

    public d6() {
        Float r100 = Float.valueOf(80.0f);
        super("live_keyboard_check_threshold", "检测键盘消失的阈值", r100, r100);
    }
}
