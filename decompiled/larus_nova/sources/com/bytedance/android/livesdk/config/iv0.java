package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class iv0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final iv0 f120482a = null;

    static {
        f120482a = new iv0();
    }

    public iv0() {
        Boolean r100 = Boolean.TRUE;
        super("LIVE_TRANSLATION_AND_SCALE_OPT", "横屏看播缩放大小适配", r100, r100);
    }
}
