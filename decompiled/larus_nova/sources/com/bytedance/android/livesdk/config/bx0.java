package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class bx0 extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bx0 f119906a = null;

    static {
        f119906a = new bx0();
    }

    public bx0() {
        Float r100 = Float.valueOf(7.09f);
        super("live_video_ktv_performance_limit", "视频聊天室开启ktv最低机型打分要求", r100, r100);
    }
}
