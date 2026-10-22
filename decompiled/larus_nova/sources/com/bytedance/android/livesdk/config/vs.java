package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vs extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vs f121474a = null;

    static {
        f121474a = new vs();
    }

    public vs() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_scale_video", "是否允许直播视频画面放大", r100, r100);
    }
}
