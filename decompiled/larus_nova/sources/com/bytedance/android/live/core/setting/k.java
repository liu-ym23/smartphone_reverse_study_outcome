package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: classes45.dex */
public final class k extends SettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f65335a = null;

    static {
        f65335a = new k();
    }

    public k() {
        Float r100 = Float.valueOf(7.5f);
        super("live_device_model_record_score", "针对主播端：主播当前机型的录制打分", r100, r100);
    }
}
