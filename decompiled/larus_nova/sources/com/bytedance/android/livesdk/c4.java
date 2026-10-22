package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class c4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c4 f104413a = null;

    static {
        f104413a = new c4();
    }

    public c4() {
        Boolean r100 = Boolean.TRUE;
        super("live_admin_danmaku_label_fix", "管理员弹幕我的标签问题修复", r100, r100);
    }
}
