package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wx0 extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wx0 f121560a = null;

    static {
        f121560a = new wx0();
    }

    public wx0() {
        Float r100 = Float.valueOf(7.09f);
        super("live_vs_inside_record_performance_limit", "直播录屏最低机型打分要求", r100, r100);
    }
}
