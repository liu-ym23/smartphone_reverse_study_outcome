package com.bytedance.android.live.openplatform.impl.miniappanchor.coupon;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f84341a;

    public c(Function1 r100) {
        this.f84341a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        qo0.a.b("AnchorCouponContextService", "get coupon entrance info fail, error: ", r101);
        this.f84341a.invoke(r101);
    }
}
