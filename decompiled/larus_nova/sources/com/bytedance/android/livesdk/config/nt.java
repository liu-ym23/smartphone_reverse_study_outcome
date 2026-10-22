package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nt extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nt f120858a = null;

    static {
        f120858a = new nt();
    }

    public nt() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_vs_player_scale", "节目横屏体验框架优化二级面板缩流配置", r100, r100);
    }
}
