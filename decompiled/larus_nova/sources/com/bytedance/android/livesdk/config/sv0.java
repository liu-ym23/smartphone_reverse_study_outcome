package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sv0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sv0 f121256a = null;

    static {
        f121256a = new sv0();
    }

    public sv0() {
        Boolean r100 = Boolean.TRUE;
        super("ktv_update_singer_on_song_change", "歌曲变化是否更新isSinger标记", r100, r100);
    }
}
