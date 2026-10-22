package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class j3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j3 f120497a = null;

    static {
        f120497a = new j3();
    }

    public j3() {
        Boolean r100 = Boolean.FALSE;
        super("enable_interpose_similar_room", "false 线上组true 在房间内观看三分钟强插相似直播", r100, r100);
    }
}
