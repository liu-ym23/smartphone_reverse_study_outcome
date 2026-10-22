package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextOrImageView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import he3.f1;
import he3.h1;
import he3.p0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductAbilityBuyAndCart;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextView;", "getAbilityBuy", "()Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextView;", "abilityBuy", "Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextOrImageView;", "b", "Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextOrImageView;", "getAbilityAddCart", "()Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextOrImageView;", "abilityAddCart", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductAbilityBuyAndCart extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProductTextView f174026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProductTextOrImageView f174027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.deepfeed.ui.view.a f174028c;

    public DeepFeedProductAbilityBuyAndCart(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedProductAbilityBuyAndCart(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ProductTextOrImageView getAbilityAddCart() {
        return this.f174027b;
    }

    public final ProductTextView getAbilityBuy() {
        return this.f174026a;
    }

    public final void a(p0 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "product");
        h1 r102 = r100.d();
        if (r102 == null) goto L5;
        Boolean r103 = r102.b();
    L6:
        boolean r104 = Intrinsics.areEqual(r103, Boolean.TRUE);
        h1 r105 = r100.d();
        if (r105 == null) goto L11;
        f1 r106 = r105.a();
        if (r106 == null) goto L11;
        String r107 = r106.a();
    L13:
        if (tc3.f.a() == false) goto L17;
        ProductTextView r108 = this.f174026a;
        com.bytedance.android.shopping.deepfeed.ui.view.a r109 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r108.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16));
    L17:
        if (r104 == false) goto L39;
        if (r107 != null) goto L20;
    L23:
        boolean r110 = true;
    L24:
        if (r110 == true) goto L39;
        this.f174027b.setVisibility(0);
        if (tc3.f.a() == false) goto L29;
        this.f174027b.R5(null, Integer.valueOf(R.drawable.shopping_icon_deepfeed_cart));
        ViewGroup.LayoutParams r111 = this.f174027b.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r112 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r111.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 80);
        this.f174027b.getLayoutParams().height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 38);
        this.f174026a.getLayoutParams().width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 132);
        this.f174026a.getLayoutParams().height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 38);
    L30:
        if (r101 == false) goto L36;
        if (tc3.f.a() == false) goto L34;
        this.f174026a.setBackgroundResource(R.drawable.shopping_bg_deep_feed_buy_new_v3);
    L47:
        Integer r113 = tc3.f.c();
        if (r113 != null) goto L51;
        return;
    L51:
        if (r113.intValue() != 1) goto L54;
        d2.d(this, 0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 14), 0, 0);
        return;
    L54:
        return;
    L34:
        this.f174026a.setBackgroundResource(R.drawable.shopping_bg_deep_feed_buy_new);
        goto L47
    L36:
        if (tc3.f.a() == false) goto L38;
        this.f174026a.setBackgroundResource(R.drawable.shopping_bg_deepfeed_buy_20);
        goto L47
    L38:
        this.f174026a.setBackgroundResource(R.drawable.shopping_bg_deepfeed_buy);
        goto L47
    L29:
        this.f174027b.R5("加入购物车", null);
        ViewGroup.LayoutParams r114 = this.f174027b.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r115 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r114.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 117);
        this.f174026a.getLayoutParams().width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 108);
        goto L30
    L20:
        if (r107.length() == 0) goto L23;
        r110 = false;
    L39:
        this.f174027b.setVisibility(8);
        if (r101 == false) goto L42;
        this.f174026a.setBackgroundResource(R.drawable.shopping_bg_deep_feed_buy_new_v2);
    L44:
        if (tc3.f.a() == false) goto L46;
        ViewGroup.LayoutParams r116 = this.f174026a.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r117 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r116.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 212);
        this.f174026a.getLayoutParams().height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 38);
        goto L47
    L46:
        ViewGroup.LayoutParams r118 = this.f174026a.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r119 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r118.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 225);
        goto L47
    L42:
        this.f174026a.setBackgroundResource(R.drawable.shopping_bg_deepfeed_buy_v2);
    L11:
        r107 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        com.bytedance.android.shopping.deepfeed.ui.view.a r102 = this.f174028c;
        if (r102 == null) goto L5;
        Pair<Integer, Integer> r103 = r102.b(r100, r101);
    L6:
        if (r103 == null) goto L8;
        super.onMeasure(r103.getFirst().intValue(), r103.getSecond().intValue());
        return;
    L8:
        super.onMeasure(r100, r101);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public DeepFeedProductAbilityBuyAndCart(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f174028c = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        LinearLayout.inflate(r100, R.layout.shopping_deepfeed_product_ability_buy_and_cart, this);
        this.f174027b = (ProductTextOrImageView) findViewById(R.id.infeed_product_cart);
        ProductTextView r103 = (ProductTextView) findViewById(R.id.infeed_product_buy);
        this.f174026a = r103;
        r103.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r100, 13));
    }

    public /* synthetic */ DeepFeedProductAbilityBuyAndCart(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
