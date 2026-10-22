package com.bytedance.android.shopping.orderlist.search.container;

import com.bytedance.android.shopping.orderlist.common.yata.abilities.OrderCommonYataPageCallbackImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface a {
    void a();

    OrderCommonYataPageCallbackImpl b();

    boolean c();

    void d();

    void e();

    void f();

    void g();

    void h(OrderSearchRequestType r100, com.bytedance.kmp.ec.yata.common.protocol.data.e r101);

    void i(OrderSearchRequestType r100);

    void j(OrderSearchRequestType r100, Function1<? super com.bytedance.kmp.ec.yata.common.protocol.data.e, Unit> r101, Function0<Unit> r102);
}
