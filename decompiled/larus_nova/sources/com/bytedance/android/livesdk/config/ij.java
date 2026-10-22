package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ij extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ij f120457a = null;

    static {
        f120457a = new ij();
    }

    public ij() {
        Boolean r100 = Boolean.TRUE;
        super("live_castscreen_skip_landscape_widget_auth", "跳过横屏投屏widget二级入口校验", r100, r100);
    }
}
