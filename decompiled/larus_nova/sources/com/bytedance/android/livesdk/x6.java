package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class x6 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x6 f162539a = null;

    static {
        f162539a = new x6();
    }

    public x6() {
        Boolean r100 = Boolean.TRUE;
        super("live_privilege_danmaku_show_error_fix", "特殊字符导致的特权弹幕展示问题修复", r100, r100);
    }
}
