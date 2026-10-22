package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class u0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u0 f158610a = null;

    static {
        f158610a = new u0();
    }

    public u0() {
        Boolean r100 = Boolean.TRUE;
        super("live_hybrid_saas_force_new_container", "saas彻底抛弃一代最老的容器", r100, r100);
    }
}
