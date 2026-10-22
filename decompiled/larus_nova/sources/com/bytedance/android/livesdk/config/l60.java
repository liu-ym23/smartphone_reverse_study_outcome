package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class l60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l60 f120655a = null;

    static {
        f120655a = new l60();
    }

    public l60() {
        Boolean r100 = Boolean.TRUE;
        super("live_link_change_nomal_enable", "连线转成普通直播重置清屏behavior", r100, r100);
    }
}
