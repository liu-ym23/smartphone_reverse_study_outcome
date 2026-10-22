package com.bytedance.android.shopping.orderlist.common.yata.abilities;

import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.kmp.ec.yata.common.biz.callback.h;
import com.bytedance.kmp.ec.yata.common.biz.callback.i;
import com.bytedance.kmp.ec.yata.common.biz.callback.j;
import com.bytedance.kmp.ec.yata.common.biz.callback.k;
import com.bytedance.kmp.ec.yata.store.core.YataStoreData;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v96.f;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonYataPageCallbackImpl implements f.a, com.bytedance.kmp.ec.yata.common.biz.callback.f, com.bytedance.kmp.ec.yata.common.biz.callback.c, com.bytedance.kmp.ec.yata.common.biz.callback.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function0<Unit>> f180093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.controller.f f180094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f180095c;

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.f
    public final void a() {
        this.f180095c.a();
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.d
    public final void b(i r100) {
        Intrinsics.checkNotNullParameter(r100, "requestModel");
        Intrinsics.checkNotNullParameter(r100, "requestModel");
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.e
    public final void c(YataStoreData r100) {
        Intrinsics.checkNotNullParameter(r100, "storeData");
        final aa6.a r101 = r100.f251719c;
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListYataPageCallbackImpl", new OrderCommonYataPageCallbackImpl$onProtocolDispatchEnd$1(r101));
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.b
    public final void e(final com.bytedance.kmp.ec.yata.common.biz.callback.a r100) {
        final aa6.a.b.C0040b r101 = aa6.a.b.C0040b.f2350b;
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListYataPageCallbackImpl", new OrderCommonYataPageCallbackImpl$onFetchBegin$1(r101));
        m.a r103 = m.f179977a;
        m.c(new OrderCommonYataPageCallbackImpl$onFetchBegin$2(this, r101, r100));
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.f
    @Deprecated(message = "老版的临时过渡的接口方法，SDK不再深度维护，最好不要使用")
    public final void l(com.bytedance.kmp.ec.yata.store.node.c r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r100, "node");
    }

    public OrderCommonYataPageCallbackImpl(com.bytedance.android.shopping.orderlist.common.controller.f r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "pageCallback");
        Intrinsics.checkNotNullParameter(r101, "viewHolderCallback");
        this.f180094b = r100;
        this.f180095c = r101;
        this.f180093a = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.e
    public final void f(YataStoreData r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "storeData");
        final aa6.a r102 = r100.f251719c;
        Lazy r103 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListYataPageCallbackImpl", new OrderCommonYataPageCallbackImpl$onProtocolReloadEnd$1(r102));
        m.a r104 = m.f179977a;
        m.c(new OrderCommonYataPageCallbackImpl$onProtocolReloadEnd$2(this, r102));
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.c
    public final void g(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "config");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.e(r100, r101);
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.d
    public final void h(i r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "requestModel");
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r100, "requestModel");
        Intrinsics.checkNotNullParameter(r101, "result");
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.c
    public final void d(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map<String, ? extends View> r102) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.a(r100, r101, r102);
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.c
    public final void i(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map<String, ? extends View> r102) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.c(r100, r101, r102);
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.c
    public final void k(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map<String, ? extends View> r102) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.d(r100, r101, r102);
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.c
    public final void m(com.bytedance.kmp.ec.yata.store.node.c r100, ga6.c r101, Map<String, ? extends View> r102) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.b(r100, r101, r102);
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.callback.b
    public final void j(final aa6.a r100, final Object r101, final com.bytedance.kmp.ec.yata.common.biz.callback.a r102, k r103, h r104, com.bytedance.kmp.ec.yata.event.ability.uplink.b r105) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r104, "responseInfo");
        Lazy r106 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListYataPageCallbackImpl", new OrderCommonYataPageCallbackImpl$onFetchEnd$1(r100));
        m.a r107 = m.f179977a;
        m.c(new OrderCommonYataPageCallbackImpl$onFetchEnd$2(this, r100, r101, r102));
    }
}
