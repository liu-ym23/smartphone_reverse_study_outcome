package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class v5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v5 f65440a = null;

    static {
        f65440a = new v5();
    }

    public v5() {
        Boolean r100 = Boolean.FALSE;
        super("live_vr_handle_crop_and_move_enable", "VR直播间是否处理PK CROP和移动播放器", r100, r100);
    }
}
