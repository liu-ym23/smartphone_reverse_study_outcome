package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class es extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final es f120150a = null;

    static {
        f120150a = new es();
    }

    public es() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_log_rankinfo", "是否开启麦序榜上报", r100, r100);
    }
}
