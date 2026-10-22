package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class n9 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n9 f120813a = null;

    static {
        f120813a = new n9();
    }

    public n9() {
        Boolean r100 = Boolean.FALSE;
        super("live_3d_effect_enable", "手机端3D特效开播开关", r100, r100);
    }
}
