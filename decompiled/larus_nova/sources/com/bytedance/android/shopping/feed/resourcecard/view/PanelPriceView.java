package com.bytedance.android.shopping.feed.resourcecard.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelPriceView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelPriceView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriceView f175275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriceView f175276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECDraweeView f175277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f175278d;

    public static final class a {
    }

    static {
    }

    public PanelPriceView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PanelPriceView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public PanelPriceView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        View r104 = ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_panel_price_view, this, true);
    L6:
        this.f175278d = r104;
        this.f175275a = (PriceView) findViewById(R.id.ec_product_pv);
        this.f175276b = (PriceView) findViewById(R.id.ec_strike_through_pv);
        this.f175277c = (ECDraweeView) findViewById(R.id.activity_prefix_icon_dv);
        return;
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        r104 = ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_panel_price_view, this, true);
        goto L6
    }

    public /* synthetic */ PanelPriceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void a(PanelPriceView r100, final long r101, final Long r102, ECUrlModel r103, final String r104, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r110 & 8) == 0) goto L11;
        r104 = null;
    L11:
        r100.f175275a.C(new PanelPriceView$bind$1(r101));
        if (r102 != null) goto L14;
    L17:
        r100.f175276b.setVisibility(8);
    L19:
        if (r103 != null) goto L21;
        r100.f175277c.setVisibility(8);
        View r105 = r100.f175278d;
        float r106 = 5;
        Resources r107 = Resources.getSystem();
        int r108 = MathKt.roundToInt(TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())));
        Resources r109 = Resources.getSystem();
        r105.setPadding(r108, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()))), 0);
    L22:
        if (r104 == null) goto L25;
        PriceView r111 = r100.f175275a;
        Resources r112 = Resources.getSystem();
        r111.setTextSize(MathKt.roundToInt(TypedValue.applyDimension(1, 15, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()))));
        r100.f175275a.C(new PanelPriceView$bind$3(r104));
        return;
    L25:
        return;
    L21:
        View r113 = r100.f175278d;
        Resources r114 = Resources.getSystem();
        r113.setPadding(0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 5, WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics()))), 0);
        r100.f175277c.setVisibility(0);
        y.a(r100.f175277c, r103);
        goto L22
    L14:
        if (r102.longValue() == r101) goto L17;
        r100.f175276b.setVisibility(0);
        r100.f175276b.C(new PanelPriceView$bind$2(r102));
        goto L19
    }
}
