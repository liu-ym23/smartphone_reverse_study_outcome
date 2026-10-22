package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class v0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f159238a = null;

    static {
        f159238a = new v0();
    }

    public v0() {
        Boolean r100 = Boolean.TRUE;
        super("live_hybrid_use_network_service", "跨端使用IMiddlewareNetworkService", r100, r100);
    }
}
