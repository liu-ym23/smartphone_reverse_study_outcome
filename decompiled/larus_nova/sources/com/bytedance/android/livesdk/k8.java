package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class k8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k8 f142269a = null;

    static {
        f142269a = new k8();
    }

    public k8() {
        Boolean r100 = Boolean.TRUE;
        super("live_vr_landscape_reinit_position", "VR直播间横屏场景重置position", r100, r100);
    }
}
