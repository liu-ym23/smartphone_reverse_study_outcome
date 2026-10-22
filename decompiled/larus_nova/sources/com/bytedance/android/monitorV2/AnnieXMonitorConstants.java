package com.bytedance.android.monitorV2;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes12.dex */
public final class AnnieXMonitorConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f162978a = null;

    static {
        f162978a = LazyKt.lazy(AnnieXMonitorConstants$ANNIEX_VERSION_CODE$2.INSTANCE);
    }

    public static long a() {
        return ((Number) f162978a.getValue()).longValue();
    }
}
