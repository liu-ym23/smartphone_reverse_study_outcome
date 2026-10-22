package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class c5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c5 f104414a = null;

    static {
        f104414a = new c5();
    }

    public c5() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_voice_wave_cache", "是否开启声波私有缓存", r100, r100);
    }
}
