package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class i8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i8 f132645a = null;

    static {
        f132645a = new i8();
    }

    public i8() {
        Boolean r100 = Boolean.TRUE;
        super("live_vr_landscape_no_castscreen", "VR直播间横屏流VR场景没有投屏按钮", r100, r100);
    }
}
