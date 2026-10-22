package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class z7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z7 f162564a = null;

    static {
        f162564a = new z7();
    }

    public z7() {
        Boolean r100 = Boolean.TRUE;
        super("live_toolbar_error_report_enable", "Toolbar错误日志上报配置", r100, r100);
    }
}
