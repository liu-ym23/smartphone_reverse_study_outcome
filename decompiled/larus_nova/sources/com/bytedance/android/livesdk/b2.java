package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class b2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b2 f104231a = null;

    static {
        f104231a = new b2();
    }

    public b2() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_monitor_feature", "monitor feature 开关", r100, r100);
    }
}
