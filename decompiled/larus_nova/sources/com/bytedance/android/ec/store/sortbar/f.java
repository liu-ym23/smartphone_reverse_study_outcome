package com.bytedance.android.ec.store.sortbar;

import android.graphics.Typeface;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f48625f;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        if ((r100 instanceof r) == true) goto L5;
        r100 = null;
    L5:
        r r101 = (r) r100;
        if (r101 == null) goto L45;
        TextView r102 = (TextView) Z().b(R.id.tv_sort).f();
        ImageView r103 = (ImageView) Z().b(R.id.iv_sort).f();
        ImageView r104 = (ImageView) Z().b(R.id.iv_red_dot).f();
        r102.setText(r101.f48481b);
        if (r101.f48483d == false) goto L25;
        r103.setVisibility(0);
        if (r101.f48482c == false) goto L22;
        if (r101.f48484e != 0) goto L18;
        if (this.f48625f == false) goto L16;
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_desc_brand);
    L27:
        if (r101.f48486g == false) goto L31;
        r104.setVisibility(0);
        if (this.f48625f == false) goto L33;
        r104.setImageResource(R.drawable.ec_shop_brand_sort_red_icon);
    L33:
        if (r101.f48482c == false) goto L39;
        if (this.f48625f == false) goto L37;
        r102.setTextColor(th.a.a(Y().c(), R.color.ec_shop_FF003C));
    L43:
        a0().setOnClickListener(new e(r101));
        return;
    L37:
        r102.setTextColor(th.a.a(Y().c(), R.color.ec_shop_FFFF3344));
        goto L43
    L39:
        if (this.f48625f == false) goto L41;
        r102.setTextColor(th.a.a(Y().c(), R.color.ec_shop_8A8B91));
    L42:
        r102.setTypeface(Typeface.defaultFromStyle(0));
        goto L43
    L41:
        r102.setTextColor(th.a.a(Y().c(), R.color.ec_shop_tab_indicator_text_color));
        goto L42
    L31:
        r104.setVisibility(8);
        goto L33
    L16:
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_desc_pink);
        goto L27
    L18:
        if (this.f48625f == false) goto L20;
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_asc_brand);
        goto L27
    L20:
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_asc_pink);
        goto L27
    L22:
        if (this.f48625f == false) goto L24;
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_unselect_brand);
        goto L27
    L24:
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_unselect_new);
        goto L27
    L25:
        r103.setVisibility(8);
        goto L27
    }

    public f(Fragment r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f48625f = r101;
    }
}
