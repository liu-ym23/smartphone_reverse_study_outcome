package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class br extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final br f119893a = null;

    static {
        f119893a = new br();
    }

    public br() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_banner_a11y_fix", "banner无障碍焦点bugfix", r100, r100);
    }
}
