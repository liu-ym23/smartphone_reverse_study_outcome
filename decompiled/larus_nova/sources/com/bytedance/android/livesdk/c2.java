package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class c2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c2 f104411a = null;

    static {
        f104411a = new c2();
    }

    public c2() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_new_monitor_api", "使用新版onMonitorLog API", r100, r100);
    }
}
