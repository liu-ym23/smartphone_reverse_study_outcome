package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class g3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g3 f120252a = null;

    static {
        f120252a = new g3();
    }

    public g3() {
        Boolean r100 = Boolean.FALSE;
        super(LiveInitSettingKeys.ENABLE_ASSET_DOWNLOAD_INFO_LOG, "启用 记录特效下载顺序，用于礼物下载顺序、限速优化 测试验证", r100, r100);
    }
}
