package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class k5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k5 f142266a = null;

    static {
        f142266a = new k5();
    }

    public k5() {
        Boolean r100 = Boolean.TRUE;
        super("live_fold_device_keyboard_height_fix", "折叠屏展开状态下键盘高度修复", r100, r100);
    }
}
