package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class h0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f132622a = null;

    static {
        f132622a = new h0();
    }

    public h0() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_anniex_revenue_factory_inject", "营收Anniex容器是否传入factory", r100, r100);
    }
}
