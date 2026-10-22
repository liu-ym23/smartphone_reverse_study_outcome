package com.bytedance.android.shopping.orderlist.common.widgets.yata;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.c1;
import com.bytedance.android.shopping.orderlist.common.controller.OrderCommonPageConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/yata/OrderCommonYataRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/ec/core/utils/c1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getOverflowClickHelp", "()Lcom/bytedance/android/ec/core/utils/c1;", "overflowClickHelp", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonYataRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f180088a;

    public OrderCommonYataRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OrderCommonYataRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final c1 getOverflowClickHelp() {
        return (c1) this.f180088a.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    public final boolean t() {
        Lazy r100 = OrderCommonPageConfig.f179697a;
        if (ECSettingKeys.F().getEnableOverflowClick() == false) goto L23;
        int r101 = getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L13;
        View r103 = getChildAt(r102);
        if ((r103 instanceof ViewGroup) == false) goto L12;
        if (((ViewGroup) r103).getClipChildren() == true) goto L12;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L16;
        return false;
    L16:
        if (getClipChildren() == true) goto L25;
        return true;
    L25:
        return false;
    L12:
        r102 = r102 + 1;
        goto L6
    L13:
        r104 = false;
        goto L14
    L23:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (t() == false) goto L10;
        if (r100 == null) goto L10;
        return getOverflowClickHelp().a(r100);
    L7:
        th = move-exception;
        nq.a.b(th, AnonymousClass1.INSTANCE);
    L10:
        return super.dispatchTouchEvent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        if (t() == false) goto L5;
        getOverflowClickHelp().f45561c = r100;
    L5:
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public static final /* synthetic */ boolean r(OrderCommonYataRecyclerView r100, MotionEvent r101) {
        return super.dispatchTouchEvent(r101);
    }

    public OrderCommonYataRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f180088a = LazyKt.lazy(new OrderCommonYataRecyclerView$overflowClickHelp$2(this));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setLayoutManager(new OrderListCenterLayoutManager(r100));
        Lazy r103 = OrderCommonPageConfig.f179697a;
        setClipChildren(ECSettingKeys.F().getEnableContainerClipChildren());
    }

    public /* synthetic */ OrderCommonYataRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
