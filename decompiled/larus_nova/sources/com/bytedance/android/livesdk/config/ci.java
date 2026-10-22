package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ci extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ci f119954a = null;

    static {
        f119954a = new ci();
    }

    public ci() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_stable_mode_enable", "开播稳定模式", r100, r100);
    }
}
