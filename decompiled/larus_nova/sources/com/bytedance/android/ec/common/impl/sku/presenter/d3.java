package com.bytedance.android.ec.common.impl.sku.presenter;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.sku.TradeModeComponent;
import com.bytedance.android.ec.model.sku.TradeModeSelection;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d3 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f43199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f43200h;

    public d3(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final void d0(d3 r110) {
        if (r110.f43200h == true) goto L47;
        Rect r100 = new Rect();
        LinearLayout r101 = r110.f43199g;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L8:
        if (r101.getLocalVisibleRect(r100) == false) goto L48;
        SkuViewModel r102 = r110.f43198f;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        SkuInfoVO r103 = r102.getSkuInfo().a();
        if (r103 == null) goto L40;
        TradeModeComponent r104 = r103.getTradeModeComponent();
        if (r104 == null) goto L40;
        List<TradeModeSelection> r105 = r104.getSelections();
        if (r105 == null) goto L40;
        Iterator<T> r106 = r105.iterator();
    L20:
        if (r106.hasNext() == false) goto L30;
        Object r107 = r106.next();
        Integer r108 = ((TradeModeSelection) r107).getType();
        if (r108 != null) goto L25;
    L27:
        boolean r109 = false;
    L28:
        if (r109 == false) goto L20;
    L31:
        TradeModeSelection r111 = (TradeModeSelection) r107;
        if (r111 == null) goto L40;
        SkuViewModel r112 = r110.f43198f;
        if (r112 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L36:
        Pair[] r113 = new Pair[4];
        r113[0] = TuplesKt.to("trade_in_page", ECPromotion.SKU);
        SkuViewModel r114 = r110.f43198f;
        if (r114 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        r113[1] = TuplesKt.to("product_id", r114.getSkuParams().getProductId());
        r113[2] = TuplesKt.to("trade_benefit_id", String.valueOf(r111.getBenefitType()));
        r113[3] = TuplesKt.to("trade_benefit_text", r111.getSubContent());
        SkuViewModel.doSkuEventAction$default(r112, "show_product_trade_in", r113, null, null, null, 28, null);
        goto L40
    L25:
        if (r108.intValue() != 2) goto L27;
        r109 = true;
        goto L28
    L30:
        r107 = null;
    L40:
        r110.f43200h = true;
        return;
    L48:
        return;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r110) {
        this.f43198f = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f43199g = (LinearLayout) Z().b(R.id.ll_sku_trade_container).f();
        SkuViewModel r111 = this.f43198f;
        if (r111 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r112 = r111.getSkuInfo().a();
        Integer r100 = null;
        if (r112 == null) goto L8;
        TradeModeComponent r113 = r112.getTradeModeComponent();
    L10:
        if (r113 == null) goto L80;
        List<TradeModeSelection> r101 = r113.getSelections();
        if (TextUtils.isEmpty(r113.getTitle()) == true) goto L14;
        ((TextView) Z().b(R.id.tv_sku_trade_title).f()).setText(r113.getTitle());
    L14:
        if (r101 != null) goto L16;
        r101 = CollectionsKt.emptyList();
    L16:
        int r102 = 0;
        if (r101.isEmpty() == false) goto L19;
        Y().d().q(dg.u.class, 8);
    L54:
        SkuViewModel r114 = this.f43198f;
        if (r114 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        r114.getOnItemChange().b(Y().e(), new a3(this));
        SkuViewModel r115 = this.f43198f;
        if (r115 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        r115.getCurrentTradeModeIndex().b(ECQuickUtilKt.a(Y()), new b3(this));
        SkuViewModel r116 = this.f43198f;
        if (r116 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        r116.getScrollViewScrollY().b(ECQuickUtilKt.a(Y()), new c3(this));
        SkuViewModel r117 = this.f43198f;
        if (r117 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        QLiveData<Integer> r118 = r117.getCurrentTradeModeIndex();
        com.bytedance.android.ec.common.impl.sku.utils.q.a r103 = com.bytedance.android.ec.common.impl.sku.utils.q.f43371a;
        SkuViewModel r104 = this.f43198f;
        if (r104 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L69:
        String r105 = r104.getSkuParams().getPromotionId();
        Intrinsics.checkNotNullParameter(r105, "promotionId");
        com.bytedance.android.ec.common.impl.sku.utils.r r106 = com.bytedance.android.ec.common.impl.sku.utils.q.f43371a.get(r105);
        if (r106 != null) goto L72;
    L77:
        if (r100 == null) goto L79;
        r102 = r100.intValue();
    L79:
        r118.g(Integer.valueOf(r102));
        return;
    L72:
        if ((System.currentTimeMillis() - r106.f43373b) > 1800000) goto L74;
        boolean r107 = true;
    L75:
        if (r107 == false) goto L77;
        r100 = Integer.valueOf(r106.f43372a);
        goto L77
    L74:
        r107 = false;
        goto L75
    L19:
        Iterator<T> r119 = r101.iterator();
    L21:
        if (r119.hasNext() == false) goto L54;
        TradeModeSelection r108 = (TradeModeSelection) r119.next();
        LinearLayout r109 = this.f43199g;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L25:
        SkuViewModel r120 = this.f43198f;
        if (r120 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        com.bytedance.android.ec.common.impl.sku.view.j r121 = new com.bytedance.android.ec.common.impl.sku.view.j(r120, Y().c());
        int r122 = r101.indexOf(r108);
        int r123 = r101.size();
        Intrinsics.checkNotNullParameter(r108, "selection");
        String r124 = r108.getContent();
        if (r124 == null) goto L31;
        r121.f43519b.setText(r124);
    L31:
        String r125 = r108.getSubContent();
        if (r125 == null) goto L34;
        r121.f43520c.setText(r125);
    L34:
        String r126 = r108.getCornerText();
        if (r126 == null) goto L37;
        r121.f43521d.setText(r126);
    L37:
        jg.g.d(r121.f43520c, jg.g.a(r108.getSubContent()));
        jg.g.d(r121.f43521d, jg.g.a(r108.getCornerText()));
        if (r122 != 0) goto L46;
        ViewGroup.LayoutParams r127 = r121.f43522e.getLayoutParams();
        if ((r127 instanceof ViewGroup.MarginLayoutParams) == true) goto L42;
        r127 = null;
    L42:
        ViewGroup.MarginLayoutParams r128 = (ViewGroup.MarginLayoutParams) r127;
        if (r128 == null) goto L53;
        r128.leftMargin = 0;
    L53:
        r121.setClipChildren(false);
        r121.f43522e.setOnClickListener(new com.bytedance.android.ec.common.impl.sku.view.i(r121, r122, r108));
        Unit r129 = Unit.INSTANCE;
        r109.addView(r121);
        goto L21
    L46:
        if (r122 != (r123 - 1)) goto L53;
        ViewGroup.LayoutParams r130 = r121.f43522e.getLayoutParams();
        if ((r130 instanceof ViewGroup.MarginLayoutParams) == true) goto L50;
        r130 = null;
    L50:
        ViewGroup.MarginLayoutParams r131 = (ViewGroup.MarginLayoutParams) r130;
        if (r131 == null) goto L53;
        r131.rightMargin = 0;
        goto L53
    L80:
        Y().d().q(dg.u.class, 8);
        return;
    L8:
        r113 = null;
        goto L10
    }
}
