package com.bytedance.android.ec.window.base.product.presenter.element.source;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yo.i;

/* JADX INFO: loaded from: classes44.dex */
public class ECWindowProductCardSourceInfoElementPresenter extends i<WindowV2ProductItemVO> implements View.OnClickListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f49410m = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f49411l;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        ((TextView) Z().b(R.id.store_product_card_source).f()).setText("");
    }

    public ECWindowProductCardSourceInfoElementPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f49411l = LazyKt.lazy(new ECWindowProductCardSourceInfoElementPresenter$sourceWrapperView$2(this));
    }

    @Override // yo.i
    public void d0(WindowV2ProductItemVO r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (a2.b(r100.f49469g) == false) goto L17;
        View r101 = (View) this.f49411l.getValue();
        if (r101 == null) goto L9;
        r101.setVisibility(0);
    L9:
        h0(r100);
        ((TextView) Z().b(R.id.store_product_card_source).f()).setText(r100.f49469g);
        if (a2.d(r100.f49480r) == null) goto L15;
        Drawable r102 = ag4.a.c(R.drawable.ec_shop_ic_product_card_store_entrance);
        if (r102 == null) goto L14;
        r102.setBounds(0, b.b(Double.valueOf(1.5d)), b.b(12), b.b(Double.valueOf(12.5d)));
    L14:
        TextView r103 = (TextView) Z().b(R.id.store_product_card_source).f();
        r103.setCompoundDrawables(null, null, r102, null);
        r103.setCompoundDrawablePadding(b.b(Float.valueOf(1.0f)));
    L16:
        this.f568602g.e(r100);
        return;
    L15:
        ((TextView) Z().b(R.id.store_product_card_source).f()).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        Unit r104 = Unit.INSTANCE;
        goto L16
    L17:
        View r105 = (View) this.f49411l.getValue();
        if (r105 == null) goto L22;
        r105.setVisibility(8);
        return;
    }

    @Override // yo.i
    public final void e0(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        WindowV2ProductItemVO r101 = this.f568605j;
        if (r101 == null) goto L6;
        this.f568602g.d(r101);
        return;
    }

    public void h0(WindowV2ProductItemVO r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        SimpleDraweeView r101 = (SimpleDraweeView) Z().b(R.id.store_product_card_store_logo).f();
        if (r100.f49486x == null) goto L9;
        r101.setVisibility(0);
        ECUrlModel r102 = r100.f49486x;
        Intrinsics.checkNotNullParameter(r101, "draweeView");
        if (r102 == null) goto L7;
        List<String> r103 = r102.getUrlList();
    L8:
        Intrinsics.checkNotNullParameter(r101, "draweeView");
        h0.f(r101, r103, this.f568601f.h(), null, null, 96);
        return;
    L7:
        r103 = null;
        goto L8
    L9:
        r101.setVisibility(8);
    }
}
