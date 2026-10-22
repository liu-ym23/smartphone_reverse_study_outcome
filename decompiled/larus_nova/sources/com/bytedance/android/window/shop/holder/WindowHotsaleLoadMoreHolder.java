package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBaseFragmentPresenter;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHotsaleLoadMoreHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lsq3/e;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ShopWindowLoadMorePresenter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHotsaleLoadMoreHolder extends ShopWindowGenericHolder<sq3.e> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a f187862v;

    public static final class ShopWindowLoadMorePresenter extends ECWindowHolderBaseFragmentPresenter {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Lazy f187863i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public b f187864j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Lazy f187865k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public sq3.e f187866l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f187867m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Lazy f187868n;

        public ShopWindowLoadMorePresenter(Fragment r100) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            super(r100);
            this.f187863i = LazyKt.lazy(new WindowHotsaleLoadMoreHolder$ShopWindowLoadMorePresenter$initClickOnce$2(this));
            this.f187865k = LazyKt.lazy(new WindowHotsaleLoadMoreHolder$ShopWindowLoadMorePresenter$noticeView$2(this));
            this.f187868n = LazyKt.lazy(new WindowHotsaleLoadMoreHolder$ShopWindowLoadMorePresenter$itemDuration$2(this));
        }

        @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
        public final void b0(QModel r100) {
            Unit r101 = (Unit) this.f187863i.getValue();
            if (r100 == null) goto L11;
            sq3.e r102 = (sq3.e) r100;
            this.f187866l = r102;
            if (this.f187867m == true) goto L8;
            this.f187867m = true;
            int r103 = WindowTabEventReporter.f188681a;
            ECWindowViewModel r104 = d0();
            ECWindowParam r105 = d0().getShopParam();
            int r106 = r102.f542976l;
            Intrinsics.checkNotNullParameter(r104, "reporter");
            Intrinsics.checkNotNullParameter(r105, "shopParam");
            WindowTabEventReporter.f(r104, r105, Integer.valueOf(r106), "live_top_list_more_show");
        L8:
            i0(r102);
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.hotsale.WindowLiveHotLoadMoreProductVO");
        }

        public final void i0(sq3.e r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            ((TextView) this.f187865k.getValue()).setText(String.valueOf(r100.f542975k.size()));
        }
    }

    public interface a {
        void a(int r100, sq3.e r101, List<? extends sq3.b> r102);

        void b(int r100, List<? extends sq3.b> r101);
    }

    public interface b {
        void a(List<? extends sq3.b> r100);

        void b(sq3.e r100, List<? extends sq3.b> r101);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowHotsaleLoadMoreHolder(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        ShoppingAsyncInflater.a r101 = ShoppingAsyncInflater.f45268e;
        Context r102 = r100.requireContext();
        r101.getClass();
        super(r100, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r102), R.layout.ec_shop_layout_holder_shopwindow_loadmore, null, 4));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        ShopWindowLoadMorePresenter r101 = new ShopWindowLoadMorePresenter(r100);
        r101.f187864j = new c(this);
        return r101;
    }
}
