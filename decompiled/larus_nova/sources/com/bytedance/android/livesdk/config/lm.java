package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lm extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lm f120692a = null;

    static {
        f120692a = new lm();
    }

    public lm() {
        super("live_cover_crop_type", "直播封面裁剪方式", 0, 1, new String[]{"0:调用系统裁剪", "1:调用CropFragment"});
    }
}
