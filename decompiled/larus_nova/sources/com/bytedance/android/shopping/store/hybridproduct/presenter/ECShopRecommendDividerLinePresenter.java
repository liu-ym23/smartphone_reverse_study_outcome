package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.recommend.widget.ShopRecommendDividerView;
import com.bytedance.android.shopping.store.utils.ECImageHelper;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopRecommendDividerLinePresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f185236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ShopRecommendDividerView f185237g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopRecommendDividerLinePresenter f185238a;

        public a(ECShopRecommendDividerLinePresenter r100) {
            this.f185238a = r100;
        }

        public final void a() {
            Object r100 = this.f185238a.a0().getParent();
            if ((r100 instanceof View) == true) goto L5;
            r100 = null;
        L5:
            View r101 = (View) r100;
            if (r101 != null) goto L8;
            r101 = this.f185238a.a0();
        L8:
            ECShopHybridProductViewModel r102 = (ECShopHybridProductViewModel) this.f185238a.f185236f.getValue();
            if (r102 == null) goto L24;
            PageFinder r103 = PageFinder.via(r101);
            Pair[] r104 = new Pair[2];
            r104[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "products");
            ECShopHybridProductViewModel r105 = (ECShopHybridProductViewModel) this.f185238a.f185236f.getValue();
            if (r105 == null) goto L21;
            jm.a<com.bytedance.android.ec.store.repository.vo.n> r106 = r105.getDiscountButton();
            if (r106 == null) goto L21;
            com.bytedance.android.ec.store.repository.vo.n r107 = r106.getValue();
            if (r107 == null) goto L21;
            List<com.bytedance.android.ec.store.repository.dto.c> r108 = r107.f48473a;
            if (r108 == null) goto L21;
            if ((!r108.isEmpty()) != true) goto L21;
            String r109 = "shop_recommend";
        L22:
            r104[1] = TuplesKt.to("module_name", r109);
            r102.doAnyEventActionWithBtm("a1.b6269.c2429.d63444", r103, "show_ecom_component", MapsKt.mapOf(r104), new Pair[0]);
            return;
        L21:
            r109 = "feed_product";
            goto L22
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        if ((r100 instanceof pj3.a) == true) goto L5;
        r100 = null;
    L5:
        pj3.a r101 = (pj3.a) r100;
        if (r101 == null) goto L8;
        Lazy r102 = ECImageHelper.f186905a;
        ECImageHelper.b(this.f185237g.getImageView(), r101.f529456a);
    L8:
        a0().post(new a(this));
    }

    public ECShopRecommendDividerLinePresenter(final Fragment r100, ShopRecommendDividerView r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "dividerView");
        super(r100);
        this.f185237g = r101;
        this.f185236f = LazyKt.lazy(new ECShopRecommendDividerLinePresenter$viewModel$2(this, r100));
    }
}
