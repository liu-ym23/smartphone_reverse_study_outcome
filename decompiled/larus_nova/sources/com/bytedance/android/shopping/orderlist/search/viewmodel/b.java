package com.bytedance.android.shopping.orderlist.search.viewmodel;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f180593a;

    public b(Function0 r100) {
        this.f180593a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final Throwable r101 = (Throwable) r100;
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.b("OrderSearchResultRequestUseCase", new OrderSearchResultRequestUseCase$doQuery$5$1(r101));
        Function0 r103 = this.f180593a;
        if (r103 == null) goto L6;
        Unit r104 = (Unit) r103.invoke();
        return;
    }
}
