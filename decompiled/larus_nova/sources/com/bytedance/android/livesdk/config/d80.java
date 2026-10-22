package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class d80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d80 f120005a = null;

    static {
        f120005a = new d80();
    }

    public d80() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_vs_media_publicscreen", "竖屏媒体节目融合是否UI对齐", r100, r100);
    }
}
