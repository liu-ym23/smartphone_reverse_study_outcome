package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lm0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lm0 f120693a = null;

    static {
        f120693a = new lm0();
    }

    public lm0() {
        Boolean r100 = Boolean.TRUE;
        super("live_recommend_insert_room_enable", "推荐完成后强插直播间开关", r100, r100);
    }
}
