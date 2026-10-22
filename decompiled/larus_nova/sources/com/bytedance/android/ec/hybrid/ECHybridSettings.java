package com.bytedance.android.ec.hybrid;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f46245a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f46246b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f46247c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f46248d = null;

    public static boolean a() {
        return ((Boolean) f46245a.getValue()).booleanValue();
    }

    static {
        f46245a = LazyKt.lazy(ECHybridSettings$hybridListMemoryOptEnable$2.INSTANCE);
        f46246b = LazyKt.lazy(ECHybridSettings$ecLynxCardMemoryOptEnable$2.INSTANCE);
        f46247c = LazyKt.lazy(ECHybridSettings$mallDeliveryIdDynamicConfig$2.INSTANCE);
        f46248d = LazyKt.lazy(ECHybridSettings$hybridListAppendSectionColumnOptEnable$2.INSTANCE);
    }
}
