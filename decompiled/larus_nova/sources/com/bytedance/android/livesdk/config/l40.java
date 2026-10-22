package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.VoiceLiveThemeConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class l40 extends SSettingKey<VoiceLiveThemeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l40 f120653a = null;

    static {
        f120653a = new l40();
    }

    public l40() {
        super("live_ktv_support_theme_replace", "语音直播是否支持背景", new VoiceLiveThemeConfig(0, 0), new VoiceLiveThemeConfig(1, 1));
    }
}
