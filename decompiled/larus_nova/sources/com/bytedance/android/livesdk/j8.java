package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class j8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j8 f142021a = null;

    static {
        f142021a = new j8();
    }

    public j8() {
        Boolean r100 = Boolean.TRUE;
        super("live_vr_landscape_no_orientation_enable", "VR直播间横屏流竖屏场景下不自动转屏", r100, r100);
    }
}
