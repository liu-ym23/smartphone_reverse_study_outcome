package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class p2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p2 f120950a = null;

    static {
        f120950a = new p2();
    }

    public p2() {
        Boolean r100 = Boolean.TRUE;
        super("drawer_similar_room_merge", "抽屉内相似直播的类型 false：普通相似直播  true：聚合相似直播", r100, r100);
    }
}
