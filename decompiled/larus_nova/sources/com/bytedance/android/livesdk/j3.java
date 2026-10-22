package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class j3 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j3 f142016a = null;

    static {
        f142016a = new j3();
    }

    public j3() {
        super("live_upload_led_stage_max_size", "自定LED舞台礼物裁剪完后上传的图片最大大小(KB)，超过则进行尺寸压缩", 60, 60);
    }
}
