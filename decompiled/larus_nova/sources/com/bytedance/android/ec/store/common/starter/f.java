package com.bytedance.android.ec.store.common.starter;

import com.bytedance.android.ec.store.common.datachannel.ECSShopSourceMethod;
import com.bytedance.android.ec.store.common.datachannel.ECShopStoreType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECShopStoreType f48226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECSShopSourceMethod f48227b;

    public f(ECShopStoreType r100, ECSShopSourceMethod r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD);
        this.f48226a = r100;
        this.f48227b = r101;
    }
}
