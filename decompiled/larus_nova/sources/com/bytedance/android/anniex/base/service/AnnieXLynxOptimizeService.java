package com.bytedance.android.anniex.base.service;

import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieXLynxOptimizeService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f40310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f40311b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f40312c = null;

    static {
        f40310a = LazyKt.lazy(AnnieXLynxOptimizeService$lynxModelCacheMap$2.INSTANCE);
        f40311b = LazyKt.lazy(AnnieXLynxOptimizeService$lynxViewCacheMap$2.INSTANCE);
        f40312c = LazyKt.lazy(AnnieXLynxOptimizeService$lynxAsyncManager$2.INSTANCE);
    }

    public static HashMap a() {
        return (HashMap) f40310a.getValue();
    }

    public static HashMap b() {
        return (HashMap) f40311b.getValue();
    }
}
