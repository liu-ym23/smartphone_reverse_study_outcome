package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class d5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d5 f121933a = null;

    static {
        f121933a = new d5();
    }

    public d5() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_voice_wave_opt", "是否开启声波锁帧", r100, r100);
    }
}
