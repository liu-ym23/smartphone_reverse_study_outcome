package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tp0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tp0 f121317a = null;

    static {
        f121317a = new tp0();
    }

    public tp0() {
        Boolean r100 = Boolean.TRUE;
        super("live_scale_video_in_multi_people_enable", "是否允许PK直播视频画面放大", r100, r100);
    }
}
