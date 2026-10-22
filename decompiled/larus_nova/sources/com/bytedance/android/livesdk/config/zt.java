package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zt extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zt f121790a = null;

    static {
        f121790a = new zt();
    }

    public zt() {
        Boolean r100 = Boolean.TRUE;
        super("live_end_page_security_log_fix", "关播页曝光埋点修正", r100, r100, false);
    }
}
