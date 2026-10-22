package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class se extends SettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final se f121202a = null;

    static {
        se r100 = new se();
        f121202a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public se() {
        Float r100 = Float.valueOf(7.5f);
        super("live_device_model_overall_score", "针对观众端：观众当前机型的综合打分", r100, r100);
    }
}
