package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ki extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ki f120604a = null;

    static {
        f120604a = new ki();
    }

    public ki() {
        Boolean r100 = Boolean.FALSE;
        super("live_broadcast_rebuild_opt", "开播Activity重建时恢复直播", r100, r100);
    }
}
