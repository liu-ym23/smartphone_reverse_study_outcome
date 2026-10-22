package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class c6 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c6 f104415a = null;

    static {
        f104415a = new c6();
    }

    public c6() {
        Boolean r100 = Boolean.FALSE;
        super("live_keyboard_check_error_height_intercept", "键盘检测异常高度拦截开关", r100, r100);
    }
}
