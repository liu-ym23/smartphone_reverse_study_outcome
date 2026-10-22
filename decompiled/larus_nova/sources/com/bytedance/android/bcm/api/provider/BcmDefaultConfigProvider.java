package com.bytedance.android.bcm.api.provider;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BcmDefaultConfigProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f41762a = null;

    static {
        f41762a = LazyKt.lazy(BcmDefaultConfigProvider$configService$2.INSTANCE);
    }

    public static boolean a() {
        IBcmDefaultConfig r100 = (IBcmDefaultConfig) f41762a.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isLazyOpt();
    }
}
