package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class he0 extends SSettingKey<bd1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final he0 f120367a = null;

    static {
        f120367a = new he0();
    }

    public he0() {
        bd1 r100 = new bd1();
        r100.anchorFequency = 4.0f;
        r100.anchorMaximumCount = 5;
        r100.audienceFrequency = 4.0f;
        r100.audienceMaximumCount = 5;
        r100.permitUploadSizeForAndroid = 0;
        bd1 r101 = new bd1();
        r101.anchorFequency = 4.0f;
        r101.anchorMaximumCount = 5;
        r101.audienceFrequency = 4.0f;
        r101.audienceMaximumCount = 5;
        r101.permitUploadSizeForAndroid = 0;
        super("live_openplatform_snapshot_setting", "开放平台举报配置", r100, r101);
    }
}
