package com.bytedance.android.ecom.bcm.track.api.provider;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class EcomDefaultConfigProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f51065a = null;

    static {
        f51065a = LazyKt.lazy(EcomDefaultConfigProvider$service$2.INSTANCE);
    }

    public static boolean a() {
        IEcomDefaultConfig r100 = (IEcomDefaultConfig) f51065a.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isLazyOpt();
    }
}
