package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class rj0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rj0 f121137a = null;

    static {
        f121137a = new rj0();
    }

    public rj0() {
        Boolean r100 = Boolean.TRUE;
        super("live_preview_fix_cover_crop_fragment_privacy", "图片裁剪fragment隐私权限优化", r100, r100, true);
    }
}
