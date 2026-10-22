package com.bytedance.android.ec.store.sortbar;

import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.store.repository.vo.t;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class HorizonFilterItemPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f48593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f48594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f48595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f48596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<QModel, Unit> f48597j;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        Boolean r101 = null;
        if ((r100 instanceof t) == true) goto L5;
        r100 = null;
    L5:
        t r102 = (t) r100;
        if (r102 == null) goto L19;
        ((TextView) this.f48594g.getValue()).setText(r102.c());
        this.f48596i = r102.f48499a;
        GradientDrawable r103 = new GradientDrawable();
        if (this.f48596i == false) goto L10;
        ((TextView) this.f48594g.getValue()).setTextColor(ContextCompat.getColor(Y().c(), R.color.ec_shopping_FFFF3B52));
        int r104 = qc3.a.d(Y().c(), R.color.ec_shopping_FFFF3B52);
        int r105 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r103.setStroke(RangesKt.coerceAtLeast(com.bytedance.android.ec.hybrid.list.util.c.d(Double.valueOf(0.5d)), 1), r104);
        r103.setColor(qc3.a.d(Y().c(), R.color.ec_shopping_ODFF3B52));
    L11:
        r103.setCornerRadius(q.a(4));
        FrameLayout r106 = (FrameLayout) this.f48595h.getValue();
        Intrinsics.checkNotNullParameter(r106, "$this$setBackgroundCompat");
        r106.setBackground(r103);
        a0().setOnClickListener(new b(this, r102));
        String r107 = new BtmItemBuilder("a1.b741019.c902181", r101, 2, null == true ? 1 : 0).withPageFinder(PageFinder.via(this.f450897e)).obtainEventBtmParams();
        if (CollectionsKt.contains(((ShopAggregatePageProductViewModel) this.f48593f.getValue()).getFilterIdRecords(), r102.b()) == true) goto L20;
        String r108 = r102.b();
        if (r108 == null) goto L17;
        ((ShopAggregatePageProductViewModel) this.f48593f.getValue()).getFilterIdRecords().add(r108);
    L17:
        ((ShopAggregatePageProductViewModel) this.f48593f.getValue()).doEventAction("store_discount_filter_button_show", new Pair[]{TuplesKt.to("activity_id", r102.b()), TuplesKt.to("name", r102.c()), TuplesKt.to("btm_id", r107)});
        return;
    L20:
        return;
    L10:
        ((TextView) this.f48594g.getValue()).setTextColor(ContextCompat.getColor(Y().c(), R.color.ec_shop_100161823));
        r103.setColor(qc3.a.d(Y().c(), R.color.ec_shopping_OD161823));
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HorizonFilterItemPresenter(Fragment r100, Function1<? super QModel, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f48597j = r101;
        this.f48593f = LazyKt.lazy(new HorizonFilterItemPresenter$viewModel$2(this));
        this.f48594g = LazyKt.lazy(new HorizonFilterItemPresenter$filterText$2(this));
        this.f48595h = LazyKt.lazy(new HorizonFilterItemPresenter$itemBg$2(this));
    }
}
