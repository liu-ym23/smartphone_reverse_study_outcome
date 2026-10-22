package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class o9 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o9 f120885a = null;

    static {
        f120885a = new o9();
    }

    public o9() {
        Boolean r100 = Boolean.TRUE;
        super("live_3d_effect_enable_safe", "手机端3D特效开播开关兜底", r100, r100);
    }
}
