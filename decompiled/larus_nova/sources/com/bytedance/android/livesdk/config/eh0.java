package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class eh0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final eh0 f120126a = null;

    static {
        f120126a = new eh0();
    }

    public eh0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_guest_stop_forward_opt_enable", "是否支持PK嘉宾侧停止转推逻辑兜底", r100, r100);
    }
}
