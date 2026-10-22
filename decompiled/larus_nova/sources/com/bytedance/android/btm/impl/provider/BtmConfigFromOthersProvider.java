package com.bytedance.android.btm.impl.provider;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BtmConfigFromOthersProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f42431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f42432b = null;

    public static IBtmConfigFromBcm a() {
        return (IBtmConfigFromBcm) f42431a.getValue();
    }

    static {
        f42431a = LazyKt.lazy(BtmConfigFromOthersProvider$bcmService$2.INSTANCE);
        f42432b = LazyKt.lazy(BtmConfigFromOthersProvider$ecomService$2.INSTANCE);
    }
}
