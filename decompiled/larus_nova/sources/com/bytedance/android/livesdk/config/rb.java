package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rb extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rb f121118a = null;

    static {
        f121118a = new rb();
    }

    public rb() {
        Boolean r100 = Boolean.FALSE;
        super("live_anchor_enable_video_mock_push_stream", "支持视频mock推流", r100, r100);
    }
}
