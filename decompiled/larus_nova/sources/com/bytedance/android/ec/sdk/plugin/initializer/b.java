package com.bytedance.android.ec.sdk.plugin.initializer;

import com.bytedance.android.ec.core.cart.CartPerformanceOpt$cartCachePrefetch$action$1;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends com.bytedance.android.ec.sdk.initalizer.a {
    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object b() {
        return Boxing.boxBoolean(true);
    }

    public b() {
    }

    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object c(Continuation<? super Unit> r100) {
        if (com.bytedance.android.ec.core.cart.b.f43915a == false) goto L9;
        CartPerformanceOpt$cartCachePrefetch$action$1 r101 = new CartPerformanceOpt$cartCachePrefetch$action$1();
        int r102 = ECSdk.f48106a;
        s83.g r103 = (s83.g) ECSdk.a(s83.g.class);
        if (r103 == null) goto L9;
        r103.v(r101);
    L9:
        return Unit.INSTANCE;
    }
}
