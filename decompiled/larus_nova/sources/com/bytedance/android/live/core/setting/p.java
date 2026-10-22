package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: classes45.dex */
public final class p extends SettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f65378a = null;

    static {
        p r100 = new p();
        f65378a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public p() {
        Float r100 = Float.valueOf(7.5f);
        super("live_device_model_overall_score", "针对观众端：观众当前机型的综合打分", r100, r100);
    }
}
