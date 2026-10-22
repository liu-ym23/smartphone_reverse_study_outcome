package com.bytedance.android.ec.sdk.plugin.initializer;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.ec.sdk.initalizer.a {
    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object b() {
        return Boxing.boxBoolean(true);
    }

    public a() {
    }

    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object c(Continuation<? super Unit> r100) {
        Boolean r101 = BuyNowPerformanceOpt.f43905a;
        com.bytedance.android.ec.core.buynow.a r102 = com.bytedance.android.ec.core.buynow.a.f43910a;
        int r103 = ECSdk.f48106a;
        s83.g r104 = (s83.g) ECSdk.a(s83.g.class);
        if (r104 == null) goto L6;
        r104.v(r102);
    L6:
        return Unit.INSTANCE;
    }
}
