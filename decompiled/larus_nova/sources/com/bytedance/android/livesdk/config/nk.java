package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nk extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nk f120840a = null;

    static {
        f120840a = new nk();
    }

    public nk() {
        Boolean r100 = Boolean.FALSE;
        super("live_backend_chunk_enable", "backend数据分段返回", r100, r100);
    }
}
