package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nm extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nm f120844a = null;

    static {
        f120844a = new nm();
    }

    public nm() {
        Boolean r100 = Boolean.TRUE;
        super("live_cross_room_disable_mp4_background", "跨房语音vs视频直播间关闭mp4背景播放", r100, r100);
    }
}
