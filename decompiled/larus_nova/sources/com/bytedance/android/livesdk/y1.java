package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class y1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1 f162545a = null;

    static {
        f162545a = new y1();
    }

    public y1() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_background_resolution", "退后台清晰度", r100, r100);
    }
}
