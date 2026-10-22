package com.bytedance.android.live.core.log;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.log.ALoggerConfig;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes45.dex */
public final class ALoggerConfigHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f64881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f64882b = null;

    public static ALoggerConfig a() {
        return (ALoggerConfig) f64882b.getValue();
    }

    static {
        f64882b = LazyKt.lazy(ALoggerConfigHelper$alogConfig$2.INSTANCE);
    }
}
