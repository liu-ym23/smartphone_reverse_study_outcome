package com.bytedance.android.shopping.orderlist.list.widget.linkedlist;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.gul.EmptyGULView;
import com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataView;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.container.c;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.android.shopping.orderlist.list.widget.gul.OrderListGULView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/linkedlist/OrderListLinkedScrollView;", "Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/BaseLinkedScrollView;", "Lcom/bytedance/android/shopping/orderlist/list/widget/gul/OrderListGULView;", "getGulView", "Lcom/bytedance/android/shopping/orderlist/list/container/c;", "m", "Lcom/bytedance/android/shopping/orderlist/list/container/c;", "getRefreshHelper", "()Lcom/bytedance/android/shopping/orderlist/list/container/c;", "setRefreshHelper", "(Lcom/bytedance/android/shopping/orderlist/list/container/c;)V", "refreshHelper", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListLinkedScrollView extends BaseLinkedScrollView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f180514m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OrderListViewModel f180515n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OrderListGULView f180516o;

    public OrderListLinkedScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OrderListLinkedScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView
    public final jg3.b d() {
        OrderListViewModel r100 = this.f180515n;
        if (r100 == null) goto L11;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r101 = r100.getStaticState();
        if (r101 == null) goto L11;
        OrderListParams r102 = r101.f180392g;
        if (r102 == null) goto L11;
        if (r102.isHideGul() != true) goto L11;
        return new EmptyGULView(getContext());
    L11:
        OrderListGULView r103 = new OrderListGULView(getContext(), null, 0);
        this.f180516o = r103;
        return r103;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView
    public final boolean l() {
        c r100 = this.f180514m;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.c() != true) goto L7;
        return true;
    }

    public final OrderListGULView getGulView() {
        return this.f180516o;
    }

    public final c getRefreshHelper() {
        return this.f180514m;
    }

    public final void setRefreshHelper(c r100) {
        this.f180514m = r100;
    }

    public final void q(OrderListFragment r100, Integer r101) {
        Intrinsics.checkNotNullParameter("OrderListRefreshHelper-onUpScreenFinish", "tag");
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListRefreshHelper-onUpScreenFinish", OrderListLinkedScrollView$initOrReloadGUL$1.INSTANCE);
        jg3.b r103 = getGulContainer();
        if ((r103 instanceof OrderListGULView) == true) goto L5;
        r103 = null;
    L5:
        OrderListGULView r104 = (OrderListGULView) r103;
        if (r104 == null) goto L9;
        r104.q(r100, r101);
        return;
    }

    public OrderListLinkedScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView
    public final com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a c(jg3.b r110, OrderCommonYataView r111, OrderCommonRefreshSloganView r112) {
        Intrinsics.checkNotNullParameter(r110, "gulContainer");
        Intrinsics.checkNotNullParameter(r111, "yataContainer");
        Intrinsics.checkNotNullParameter(r112, "footContainer");
        return new a(getContext(), this, r110, r111, r112, this.f180514m, this.f180515n);
    }

    public /* synthetic */ OrderListLinkedScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
