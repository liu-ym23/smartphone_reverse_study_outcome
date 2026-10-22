package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class me extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final me f120748a = null;

    static {
        f120748a = new me();
    }

    public me() {
        Boolean r100 = Boolean.TRUE;
        super("live_assets_manager_preload_optimize", "AssetsManager预热开关", r100, r100);
    }
}
