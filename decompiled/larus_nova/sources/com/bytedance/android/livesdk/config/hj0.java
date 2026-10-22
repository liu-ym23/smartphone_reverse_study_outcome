package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hj0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hj0 f120381a = null;

    static {
        f120381a = new hj0();
    }

    public hj0() {
        Boolean r100 = Boolean.TRUE;
        super("live_prefetch_support_async_callback", "prefetch支持异步回掉", r100, r100);
    }
}
