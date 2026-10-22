package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class g80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g80 f120260a = null;

    static {
        f120260a = new g80();
    }

    public g80() {
        Boolean r100 = Boolean.TRUE;
        super("live_mem_leak_extra_render", "修复：副视图内存泄漏问题", r100, r100);
    }
}
