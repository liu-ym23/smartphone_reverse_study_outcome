package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class p9 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p9 f120960a = null;

    static {
        f120960a = new p9();
    }

    public p9() {
        Boolean r100 = Boolean.TRUE;
        super("live_accessibility_enable", "黑名单机型不启用", r100, r100);
    }
}
