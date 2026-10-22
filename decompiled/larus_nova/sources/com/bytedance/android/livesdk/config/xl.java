package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xl extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xl f121614a = null;

    static {
        f121614a = new xl();
    }

    public xl() {
        Boolean r100 = Boolean.FALSE;
        super("live_common_share_params_enable", "是否开启分享参数透传", r100, r100);
    }
}
