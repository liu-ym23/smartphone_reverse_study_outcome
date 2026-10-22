package com.bytedance.android.shopping.orderlist.common.widgets.yata;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonYataErrorView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/yata/OrderCommonYataView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/orderlist/common/widgets/yata/a;", "Landroidx/recyclerview/widget/RecyclerView;", "getYataRecyclerView", "Lkotlin/Function0;", "", "action", "setErrorRetryListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonYataView extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OrderCommonYataRecyclerView f180089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OrderCommonYataErrorView f180090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f180091c;

    public final boolean a() {
        if (this.f180091c == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f180089a.canScrollVertically(-1) == false) goto L7;
        return true;
    }

    public final boolean b() {
        if (this.f180091c == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f180089a.canScrollVertically(1) == false) goto L7;
        return true;
    }

    public final void c() {
        final boolean r100 = false;
        OrderCommonErrorMonitorKt.c(null, "OrderCommonYataView-scrollToBottom", new OrderCommonYataView$scrollToBottom$1(this, r100));
    }

    public final void d() {
        final boolean r100 = false;
        OrderCommonErrorMonitorKt.c(null, "OrderCommonYataView-scrollToTop", new OrderCommonYataView$scrollToTop$1(this, r100));
    }

    public RecyclerView getYataRecyclerView() {
        return this.f180089a;
    }

    public void setErrorRetryListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f180090b.setErrorRetryListener(r100);
    }

    @Override // android.view.View, com.bytedance.android.shopping.orderlist.common.widgets.yata.a
    public final void scrollBy(int r100, int r101) {
        this.f180089a.scrollBy(r100, r101);
    }

    public OrderCommonYataView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        AttributeSet r103 = null;
        int r104 = 6;
        int r105 = 0;
        OrderCommonYataRecyclerView r106 = new OrderCommonYataRecyclerView(r100, r103, r104, r105);
        this.f180089a = r106;
        OrderCommonYataErrorView r107 = new OrderCommonYataErrorView(r100, r103, r104, r105);
        this.f180090b = r107;
        removeAllViews();
        addView(r106, new FrameLayout.LayoutParams(-1, -2));
        addView(r107, new FrameLayout.LayoutParams(-1, -2));
        r107.setVisibility(8);
    }
}
