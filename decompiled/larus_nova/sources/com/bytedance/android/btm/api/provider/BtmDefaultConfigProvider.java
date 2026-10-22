package com.bytedance.android.btm.api.provider;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BtmDefaultConfigProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f42071a = null;

    public static IBtmDefaultConfig a() {
        return (IBtmDefaultConfig) f42071a.getValue();
    }

    static {
        f42071a = LazyKt.lazy(BtmDefaultConfigProvider$service$2.INSTANCE);
    }

    public static boolean b() {
        IBtmDefaultConfig r100 = a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isLazyOpt();
    }
}
