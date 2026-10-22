package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lg0 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lg0 f120677a = null;

    static {
        f120677a = new lg0();
    }

    public lg0() {
        super("live_picked_emoji_photo_max_size", "订阅会员自定义表情选择用于裁剪的图片最大大小(KB)，超过则重新选择", 8192, 8192);
    }
}
