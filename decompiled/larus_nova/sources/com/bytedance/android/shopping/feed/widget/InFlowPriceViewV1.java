package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.utils.y;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InFlowPriceViewV1;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowPriceViewV1 extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f175890e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriceView f175891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PromotionProductStruct f175892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f175893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PromotionProductPriceStruct f175894d;

    public static final class a {
    }

    static {
    }

    public InFlowPriceViewV1(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InFlowPriceViewV1(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        int r100 = com.bytedance.android.shopping.feed.utils.c.f175441a;
        Long r101 = com.bytedance.android.shopping.feed.utils.c.e(this.f175894d);
        long r102 = 0;
        if (r101 == null) goto L5;
        long r103 = r101.longValue();
    L6:
        PromotionProductPriceStruct r104 = this.f175894d;
        if (r104 == null) goto L9;
        Long r105 = r104.getMaxPrice();
    L10:
        if (r105 == null) goto L12;
        long r106 = r105.longValue();
    L13:
        Long r107 = com.bytedance.android.shopping.feed.utils.c.c(this.f175894d);
        if (r107 == null) goto L16;
        r107.longValue();
    L16:
        Long r108 = com.bytedance.android.shopping.feed.utils.c.b(this.f175894d).getMinPrice();
        if (r108 == null) goto L19;
        r102 = r108.longValue();
    L19:
        long r110 = r102;
        PromotionProductPriceStruct r109 = this.f175894d;
        if (r109 == null) goto L22;
        r109.getHeader();
    L22:
        c(r103, r106, r110);
        return;
    L12:
        r106 = 0;
        goto L13
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public InFlowPriceViewV1(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f175893c = th.a.g(r100, R.string.commerce_tip_price_append_text);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_inflow_card_price_view_v1, this, true);
    L6:
        PriceView r104 = (PriceView) findViewById(R.id.min_price);
        this.f175891a = r104;
        if (ld3.c.h() == false) goto L10;
        r104.B(se3.a.a(24.0f));
        return;
    L10:
        return;
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_inflow_card_price_view_v1, this, true);
        goto L6
    }

    public static final String a(InFlowPriceViewV1 r100, String r101, String r102) {
        r100.getClass();
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        return r101 + ' ' + r102;
    L6:
        if (r101 != null) goto L14;
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102;
    L14:
        return r101;
    }

    public final void c(final long r110, long r111, final long r112) {
        PromotionProductStruct r100 = this.f175892b;
        if (r100 == null) goto L11;
        PromotionDepositPresaleActivity r101 = f53.a.c(r100).getDepositPresaleActivity();
        if (r101 == null) goto L11;
        if (com.bytedance.android.ec.model.n.b(r101) != true) goto L11;
        if (a53.a.a() != 1) goto L11;
        boolean r102 = true;
    L12:
        PromotionProductPriceStruct r103 = this.f175894d;
        if (r103 == null) goto L18;
        PromotionDiscountPrice r104 = r103.getDiscountPrice();
        if (r104 == null) goto L18;
        String r105 = r104.getHeader();
        if (r105 == null) goto L18;
    L21:
        final String r106 = r105;
    L23:
        PromotionProductStruct r107 = this.f175892b;
        if (r107 == null) goto L26;
        r107.setActivityLabel(r106);
    L26:
        int r108 = com.bytedance.android.shopping.feed.utils.c.f175441a;
        PromotionDiscountPrice r109 = com.bytedance.android.shopping.feed.utils.c.b(this.f175894d);
        int r113 = y.f165360a;
        if (y.u(Long.valueOf(r110), r109, Long.valueOf(r112)) == false) goto L37;
        if (r111 <= r110) goto L31;
    L34:
        final String r114 = this.f175893c;
    L35:
        final String r115 = r106;
        this.f175891a.C(new InFlowPriceViewV1$updatePrice$1(this, r112, r114, r115));
    L41:
        if (r102 == false) goto L44;
        this.f175891a.C(new InFlowPriceViewV1$updatePrice$3(this));
        return;
    L44:
        return;
    L31:
        if (y.v(r109) == true) goto L34;
        r114 = null;
        goto L35
    L37:
        if (r111 <= r110) goto L39;
        final String r116 = this.f175893c;
    L40:
        this.f175891a.C(new InFlowPriceViewV1$updatePrice$2(this, r110, r112, r116, r106));
        goto L41
    L39:
        r116 = null;
    L18:
        PromotionProductPriceStruct r117 = this.f175894d;
        if (r117 == null) goto L22;
        r105 = r117.getHeader();
        goto L21
    L22:
        r106 = null;
    L11:
        r102 = false;
        goto L12
    }

    public /* synthetic */ InFlowPriceViewV1(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
