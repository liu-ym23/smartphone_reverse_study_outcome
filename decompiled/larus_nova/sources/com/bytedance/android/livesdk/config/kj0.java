package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class kj0 extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kj0 f120608a = null;

    static {
        f120608a = new kj0();
    }

    public kj0() {
        super("live_preview_crop_fragment_privacy_delay_time", "图片裁剪fragment隐私权限优化延迟时间", 300L, 300L);
    }
}
