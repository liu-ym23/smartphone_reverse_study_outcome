package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tw0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tw0 f121331a = null;

    static {
        f121331a = new tw0();
    }

    public tw0() {
        Boolean r100 = Boolean.TRUE;
        super("live_video_chorus_conflict_multi_chorus_enable", "视频合唱和一起唱互斥开关", r100, r100);
    }
}
