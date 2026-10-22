package com.bytedance.android.shopping.orderlist.search.viewmodel;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.n;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f180591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f180592b;

    public a(Function1 r100, Function0 r101) {
        this.f180591a = r100;
        this.f180592b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final e r101 = (e) r100;
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderSearchResultRequestUseCase", new OrderSearchResultRequestUseCase$doQuery$4$1(r101));
        if (f.d(r101) == false) goto L7;
        int r103 = n.f179982a;
        n.a(r101.c(), false, false);
        Function1 r104 = this.f180591a;
        if (r104 == null) goto L11;
        Unit r105 = (Unit) r104.invoke(r101);
        return;
    L11:
        return;
    L7:
        int r106 = n.f179982a;
        n.a(r101.b(), false, false);
        Function0 r107 = this.f180592b;
        if (r107 == null) goto L13;
        Unit r108 = (Unit) r107.invoke();
        return;
    }
}
