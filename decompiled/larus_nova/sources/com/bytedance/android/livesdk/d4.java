package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class d4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d4 f121932a = null;

    static {
        f121932a = new d4();
    }

    public d4() {
        Boolean r100 = Boolean.TRUE;
        super("live_admin_comment_report_params_bugfix_enable", "管理员公屏举报问题修复开关", r100, r100);
    }
}
