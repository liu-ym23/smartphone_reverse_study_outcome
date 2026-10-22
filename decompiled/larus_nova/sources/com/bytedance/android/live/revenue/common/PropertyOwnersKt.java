package com.bytedance.android.live.revenue.common;

import io.reactivex.Observable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class PropertyOwnersKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(com.bytedance.revenue.platform.api.core.rx.n r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$valueNullable");
        Intrinsics.checkNotNullParameter(r100, "$this$valueNullable");
        return sh6.c.b((sh6.b) r100.f267520d);
    }

    public static final <T> com.bytedance.revenue.platform.api.core.rx.n<T> b(T r100) {
        Intrinsics.checkNotNullParameter(r100, "initialValue");
        return new com.bytedance.revenue.platform.api.core.rx.n(r100, PropertyOwnersKt$propertyOwner$1.INSTANCE);
    }

    public static final <T> Observable<T> c(final com.bytedance.revenue.platform.api.core.rx.m<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$withLatest");
        com.bytedance.revenue.platform.api.core.rx.l r101 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        final Function0<Observable<T>> r102 = new PropertyOwnersKt$withLatest$1(r100);
        return Observable.defer(new a0(r102));
    }
}
