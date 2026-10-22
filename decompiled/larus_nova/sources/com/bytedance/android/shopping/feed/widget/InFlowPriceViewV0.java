package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InFlowPriceViewV0;", "Landroid/widget/FrameLayout;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowPriceViewV0 extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f175883g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriceView f175884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f175885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriceView f175886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PriceView f175887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PromotionProductPriceStruct f175888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PromotionProductStruct f175889f;

    public static final class a {
    }

    static {
    }

    public InFlowPriceViewV0(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InFlowPriceViewV0(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        int r100 = com.bytedance.android.shopping.feed.utils.c.f175441a;
        Long r101 = com.bytedance.android.shopping.feed.utils.c.e(this.f175888e);
        long r102 = 0;
        if (r101 == null) goto L5;
        long r103 = r101.longValue();
    L6:
        Long r104 = com.bytedance.android.shopping.feed.utils.c.c(this.f175888e);
        if (r104 == null) goto L9;
        long r110 = r104.longValue();
    L10:
        Long r105 = com.bytedance.android.shopping.feed.utils.c.b(this.f175888e).getMinPrice();
        if (r105 == null) goto L13;
        r102 = r105.longValue();
    L13:
        b(r103, r102, r110);
        return;
    L9:
        r110 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public InFlowPriceViewV0(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_inflow_card_price_view_v0, this, true);
    L6:
        PriceView r104 = (PriceView) findViewById(R.id.min_price);
        this.f175884a = r104;
        PriceView r105 = (PriceView) findViewById(R.id.market_price);
        this.f175886c = r105;
        this.f175885b = (ViewGroup) findViewById(R.id.container_discount_price);
        PriceView r106 = (PriceView) findViewById(R.id.tv_discount_price);
        this.f175887d = r106;
        if (ld3.c.h() == false) goto L10;
        r104.B(se3.a.a(26.0f));
        r105.B(se3.a.a(15.0f));
        r106.B(se3.a.a(19.0f));
    L10:
        if (ld3.c.d() == false) goto L13;
        PriceView.z(r104, 0, 6);
        PriceView.z(r106, 0, 6);
        PriceView.z(r105, 0, 6);
        return;
    L13:
        return;
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_inflow_card_price_view_v0, this, true);
        goto L6
    }

    public final void b(final long r100, final long r110, final long r111) {
        PromotionProductStruct r101 = this.f175889f;
        if (r101 == null) goto L11;
        PromotionDepositPresaleActivity r102 = f53.a.c(r101).getDepositPresaleActivity();
        if (r102 == null) goto L11;
        boolean r103 = true;
        if (com.bytedance.android.ec.model.n.b(r102) != true) goto L11;
        if (a53.a.a() != 1) goto L11;
    L13:
        if (r100 <= 0) goto L31;
        this.f175884a.C(new InFlowPriceViewV0$updatePrice$1(this, r100));
        if (r103 == false) goto L18;
        this.f175884a.C(new InFlowPriceViewV0$updatePrice$2(this));
    L18:
        if (r110 <= 0) goto L28;
        this.f175886c.setVisibility(8);
        this.f175885b.setVisibility(0);
        this.f175887d.C(new InFlowPriceViewV0$updatePrice$3(this, r110));
        if (r103 == false) goto L33;
        Drawable r104 = this.f175885b.getBackground();
        if ((r104 instanceof GradientDrawable) == true) goto L24;
        r104 = null;
    L24:
        GradientDrawable r105 = (GradientDrawable) r104;
        if (r105 == null) goto L34;
        int r106 = g1.f45599a;
        r105.setColor(g1.a.a(getContext(), R.color.ec_inner_flow_presale_activity_color));
        return;
    L34:
        return;
    L33:
        return;
    L28:
        if (r111 <= 0) goto L30;
        this.f175886c.setVisibility(0);
        this.f175885b.setVisibility(8);
        this.f175886c.C(new InFlowPriceViewV0$updatePrice$4(r111));
        return;
    L30:
        this.f175886c.setVisibility(8);
        this.f175885b.setVisibility(8);
        return;
    L31:
        setVisibility(8);
        return;
    L11:
        r103 = false;
        goto L13
    }

    public /* synthetic */ InFlowPriceViewV0(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
