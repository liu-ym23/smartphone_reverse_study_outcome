package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class lj0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lj0 f120686a = null;

    static {
        f120686a = new lj0();
    }

    public lj0() {
        Boolean r100 = Boolean.TRUE;
        super("live_preview_crop_rotation_opt_enable", "图片裁剪旋转角度获取优化", r100, r100, true);
    }
}
