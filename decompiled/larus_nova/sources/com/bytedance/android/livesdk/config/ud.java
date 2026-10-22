package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ud extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ud f121362a = null;

    static {
        f121362a = new ud();
    }

    public ud() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_announcement_bugfix_ksong_enable", "预告贴纸与k歌组件不互斥的bugfix端上兜底", r100, r100);
    }
}
