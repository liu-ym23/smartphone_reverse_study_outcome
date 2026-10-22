package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class kt extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kt f120627a = null;

    static {
        f120627a = new kt();
    }

    public kt() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_timon_calendar", "是否使用Timon的日历功能", r100, r100);
    }
}
