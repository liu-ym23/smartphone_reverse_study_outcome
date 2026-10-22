package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class u9 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u9 f121353a = null;

    static {
        f121353a = new u9();
    }

    public u9() {
        Boolean r100 = Boolean.FALSE;
        super("live_add_audio_metrics_model_enable", "音质打分能力开关", r100, r100);
    }
}
