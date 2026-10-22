package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class on extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final on f120918a = null;

    static {
        f120918a = new on();
    }

    public on() {
        Boolean r100 = Boolean.TRUE;
        super("live_digg_no_recycle_local_bitmap", "点赞不主动回收本地bitmap", r100, r100);
    }
}
