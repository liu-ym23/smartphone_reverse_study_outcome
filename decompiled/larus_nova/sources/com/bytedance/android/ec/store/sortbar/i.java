package com.bytedance.android.ec.store.sortbar;

import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f48629f;

    public final void e0() {
        ((ImageView) Z().b(R.id.iv_sort).f()).animate().rotationBy(-180.0f).setDuration(200).start();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r110) {
        QModel r100 = r110;
        ViewGroup.LayoutParams r101 = null;
        if ((r100 instanceof r) == true) goto L5;
        r100 = null;
    L5:
        r r102 = (r) r100;
        if (r102 == null) goto L67;
        ImageView r103 = (ImageView) Z().b(R.id.iv_sort).f();
        boolean r104 = false;
        if (r102.f48483d == false) goto L26;
        r103.setVisibility(0);
        Integer r105 = 16;
        Lazy r111 = ExtensionsKt.f48229a;
        Intrinsics.checkNotNullParameter(r105, "$this$sp");
        float r106 = r105.floatValue();
        Lazy r112 = ExtensionsKt.f48229a;
        int r107 = (int) TypedValue.applyDimension(2, r106, (DisplayMetrics) r112.getValue());
        Integer r108 = 16;
        Intrinsics.checkNotNullParameter(r108, "$this$sp");
        r103.setLayoutParams(new ViewGroup.LayoutParams(r107, (int) TypedValue.applyDimension(2, r108.floatValue(), (DisplayMetrics) r112.getValue())));
        if (r102.f48482c == false) goto L22;
        if (r102.f48484e != 0) goto L18;
        if (this.f48629f == false) goto L16;
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_desc_brand);
    L33:
        CardView r109 = (CardView) Z().b(R.id.sort_item_card).f();
        if (r102.f() == false) goto L36;
    L39:
        int r113 = com.bytedance.android.ec.store.utils.e.f48667a;
        Integer r114 = com.bytedance.android.ec.store.utils.e.a(r102.f48491l);
    L40:
        if (r114 == null) goto L42;
        int r115 = r114.intValue();
    L43:
        r109.setCardBackgroundColor(r115);
        TextView r116 = (TextView) Z().b(R.id.tv_sort).f();
        if (r115 == 0) goto L46;
        r109.post(new g(r109));
        r116.setPadding(ExtensionsKt.a(12), ExtensionsKt.a(2), ExtensionsKt.a(12), ExtensionsKt.a(2));
    L47:
        ImageView r117 = (ImageView) Z().b(R.id.iv_red_dot).f();
        if (r102.f48486g == false) goto L52;
        r117.setVisibility(0);
        if (this.f48629f == false) goto L53;
        r117.setImageResource(R.drawable.ec_shop_brand_sort_red_icon);
    L53:
        ECDraweeView r118 = (ECDraweeView) Z().b(R.id.iv_sort_filter).f();
        TextView r119 = (TextView) Z().b(R.id.tv_sort).f();
        com.bytedance.android.ec.store.repository.dto.e r120 = r102.f48489j;
        if (r120 == null) goto L56;
        ECUrlModel r121 = r120.a();
    L57:
        if (r121 != null) goto L59;
        r118.setVisibility(8);
    L63:
        if (r104 == true) goto L65;
        d0(r102);
    L65:
        a0().setOnClickListener(new h(this, r102));
        return;
    L59:
        r118.setVisibility(0);
        r119.setVisibility(8);
        ViewGroup.LayoutParams r122 = r118.getLayoutParams();
        if (r122 == null) goto L62;
        r122.width = ExtensionsKt.a(Integer.valueOf(r120.a().getWidth()));
        r122.height = ExtensionsKt.a(Integer.valueOf(r120.a().getHeight()));
        Unit r123 = Unit.INSTANCE;
        r101 = r122;
    L62:
        r118.setLayoutParams(r101);
        h0.d(r118, r120.a(), new com.bytedance.android.ec.core.imagex.r("ec_shop", "unknown"), null, null, null, null, 120);
        r104 = true;
        goto L63
    L56:
        r121 = null;
        goto L57
    L52:
        r117.setVisibility(8);
        goto L53
    L46:
        r109.setRadius(0.0f);
        r116.setPadding(0, 0, 0, 0);
        goto L47
    L42:
        r115 = 0;
        goto L43
    L36:
        if (r102.f48495p == true) goto L39;
        int r124 = com.bytedance.android.ec.store.utils.e.f48667a;
        r114 = com.bytedance.android.ec.store.utils.e.a(r102.f48492m);
        goto L40
    L16:
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_desc_pink);
        goto L33
    L18:
        if (this.f48629f == false) goto L20;
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_asc_brand);
        goto L33
    L20:
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_asc_pink);
        goto L33
    L22:
        if (this.f48629f == false) goto L24;
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_unselect_brand);
        goto L33
    L24:
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_unselect_new);
        goto L33
    L26:
        if (r102.e() == false) goto L32;
        r103.setVisibility(0);
        if (r102.f() == false) goto L30;
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_select_arrow_down);
    L31:
        ViewGroup.LayoutParams r125 = r103.getLayoutParams();
        r125.width = ExtensionsKt.a(7);
        r125.height = ExtensionsKt.a(7);
        Unit r126 = Unit.INSTANCE;
        r103.setLayoutParams(r125);
        goto L33
    L30:
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_unselect_arrow_down);
        goto L31
    L32:
        r103.setVisibility(8);
        goto L33
    }

    public final void d0(r r100) {
        if (r100.e() == false) goto L13;
        List<r> r101 = r100.f48493n;
        if (r101 == null) goto L13;
        Iterator<r> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        r r103 = r102.next();
        if (r103.f() == false) goto L8;
        d0(r103);
        return;
    L13:
        TextView r104 = (TextView) Z().b(R.id.tv_sort).f();
        r104.setVisibility(0);
        String r105 = r100.f48490k;
        if (r105 != null) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
        r104.setText(r100.f48481b);
    L24:
        if (r100.f() == true) goto L34;
        if (r100.f48495p == true) goto L34;
        if (this.f48629f == false) goto L31;
        r104.setTextColor(th.a.a(Y().c(), R.color.ec_shop_8A8B91));
    L32:
        r104.setTypeface(Typeface.defaultFromStyle(0));
        return;
    L31:
        r104.setTextColor(th.a.a(Y().c(), R.color.ec_shop_tab_indicator_text_color));
    L34:
        if (this.f48629f == false) goto L36;
        r104.setTextColor(th.a.a(Y().c(), R.color.ec_shop_FF003C));
        return;
    L36:
        r104.setTextColor(th.a.a(Y().c(), R.color.ec_shop_FFFF3344));
        return;
    L22:
        r104.setText(r100.f48490k);
        goto L24
    L16:
        if (r105.length() == 0) goto L19;
        r106 = false;
        goto L20
    }

    public i(Fragment r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f48629f = r101;
    }
}
