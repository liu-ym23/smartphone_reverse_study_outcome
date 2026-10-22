package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InFlowPriceViewV2;", "Lcom/bytedance/android/shopping/feed/widget/BasePriceViewV2;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowPriceViewV2 extends BasePriceViewV2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f175895f = 0;

    public static final class a {
    }

    static {
    }

    public InFlowPriceViewV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InFlowPriceViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.widget.BasePriceViewV2
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r101 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_inflow_price_view_v2, this, true);
        return;
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_inflow_price_view_v2, this, true);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);     // Catch: Exception -> L4
    L6:
        int r102 = com.bytedance.android.shopping.extensions.b.b(12);
        int r103 = (k1.m(getContext()) - r102) - com.bytedance.android.shopping.extensions.b.b(12);
        measureChild(getMainPriceView(), r100, r101);
        measureChild(getSubPriceView(), r100, r101);
        PriceView r104 = getMainPriceView();
        if (r104 == null) goto L9;
        int r105 = r104.getMeasuredWidth();
    L10:
        PriceView r106 = getSubPriceView();
        if (r106 == null) goto L13;
        int r107 = r106.getMeasuredWidth();
    L14:
        int r108 = r105 + r107;
        PriceView r109 = getMainPriceView();
        ViewGroup.LayoutParams r110 = null;
        if (r109 == null) goto L17;
        ViewGroup.LayoutParams r111 = r109.getLayoutParams();
    L19:
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == true) goto L21;
        r111 = null;
    L21:
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        PriceView r113 = getMainPriceView();
        if (r113 == null) goto L24;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
    L26:
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == true) goto L28;
        r114 = null;
    L28:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        PriceView r116 = getSubPriceView();
        if (r116 == null) goto L31;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
    L33:
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == true) goto L35;
        r117 = null;
    L35:
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117;
        PriceView r119 = getSubPriceView();
        if (r119 == null) goto L38;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
    L40:
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == false) goto L43;
        r110 = r120;
    L43:
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r110;
        if (r108 <= r103) goto L51;
        PriceView r122 = getSubPriceView();
        if (r122 == null) goto L52;
        wg.a.h(r122, false);
        return;
    L52:
        return;
    L51:
        return;
    L38:
        r120 = null;
        goto L40
    L31:
        r117 = null;
        goto L33
    L24:
        r114 = null;
        goto L26
    L17:
        r111 = null;
        goto L19
    L13:
        r107 = 0;
        goto L14
    L9:
        r105 = 0;
    L4:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L6
    }

    public InFlowPriceViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ InFlowPriceViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
