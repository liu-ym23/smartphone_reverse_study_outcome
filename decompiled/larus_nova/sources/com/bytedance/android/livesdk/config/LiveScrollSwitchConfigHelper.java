package com.bytedance.android.livesdk.config;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes8.dex */
public final class LiveScrollSwitchConfigHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f119742a = null;

    public static b81 a() {
        return (b81) f119742a.getValue();
    }

    static {
        f119742a = LazyKt.lazy(LiveScrollSwitchConfigHelper$config$2.INSTANCE);
    }
}
