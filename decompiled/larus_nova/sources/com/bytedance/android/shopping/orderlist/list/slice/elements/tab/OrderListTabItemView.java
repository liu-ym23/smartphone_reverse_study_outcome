package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ui.base.widget.button.CornersButton;
import com.bytedance.android.ui.base.widget.round.RoundView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/OrderListTabItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getIndicatorBottomOffset", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListTabItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f180275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f180276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CornersButton f180277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoundView f180278d;

    public OrderListTabItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OrderListTabItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getIndicatorBottomOffset() {
        int r100 = this.f180278d.getBottom();
        Object r101 = this.f180278d.getParent();
        if ((r101 instanceof View) == true) goto L5;
        r101 = null;
    L5:
        View r102 = (View) r101;
    L6:
        if (r102 == null) goto L14;
        if ((!Intrinsics.areEqual(r102, this)) == false) goto L14;
        r100 = r100 + r102.getTop();
        Object r103 = r102.getParent();
        if ((r103 instanceof View) == true) goto L12;
        r103 = null;
    L12:
        r102 = (View) r103;
    L14:
        return RangesKt.coerceAtLeast(getHeight() - r100, 0);
    }

    public OrderListTabItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.order_list_view_tab_item, this, true);
        this.f180275a = findViewById(R.id.item_tab_root);
        this.f180276b = (TextView) findViewById(R.id.item_tab_name);
        CornersButton r104 = (CornersButton) findViewById(R.id.item_tab_count);
        this.f180277c = r104;
        this.f180278d = (RoundView) findViewById(R.id.item_tab_indicator);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r105 = null;
    L5:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r106 == null) goto L8;
        r106.setMargins(r106.leftMargin, r106.topMargin, 0, r106.bottomMargin);
        Unit r107 = Unit.INSTANCE;
        ViewGroup.LayoutParams r108 = r106;
    L9:
        r104.setLayoutParams(r108);
        return;
    L8:
        r108 = r104.getLayoutParams();
        goto L9
    }

    public /* synthetic */ OrderListTabItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
