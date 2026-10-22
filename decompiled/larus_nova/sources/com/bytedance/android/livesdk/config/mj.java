package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mj extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mj f120760a = null;

    static {
        f120760a = new mj();
    }

    public mj() {
        Boolean r100 = Boolean.FALSE;
        super("live_cast_screen_log_fetch_url_enable", "是否上报投屏fetchUrl埋点", r100, r100);
    }
}
