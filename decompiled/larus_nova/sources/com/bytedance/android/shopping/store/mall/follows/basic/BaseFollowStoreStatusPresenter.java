package com.bytedance.android.shopping.store.mall.follows.basic;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class BaseFollowStoreStatusPresenter<T extends BaseFollowStoreViewModel> extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LazyStatusView f185577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f185578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class<T> f185579h;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFollowStoreStatusPresenter f185580a;

        public a(BaseFollowStoreStatusPresenter r100) {
            this.f185580a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            LoadStatus r101 = (LoadStatus) r100;
            if (r101 != LoadStatus.InitializeEmpty) goto L5;
        L24:
            BaseFollowStoreStatusPresenter.d0(this.f185580a).b(com.bytedance.android.ec.store.status.b.C0841b.f48652a);
            ExtensionsKt.visible(BaseFollowStoreStatusPresenter.d0(this.f185580a));
            return;
        L5:
            if (r101 == LoadStatus.InitializeError) goto L24;
            if (r101 != LoadStatus.InitializeSuccess) goto L10;
        L23:
            ExtensionsKt.gone(BaseFollowStoreStatusPresenter.d0(this.f185580a));
            return;
        L10:
            if (r101 == LoadStatus.LoadMoreSuccess) goto L23;
            if (r101 == LoadStatus.LoadMoreEnd) goto L23;
            if (r101 != LoadStatus.Initialize) goto L17;
        L22:
            ExtensionsKt.visible(BaseFollowStoreStatusPresenter.d0(this.f185580a));
            BaseFollowStoreStatusPresenter.d0(this.f185580a).b(com.bytedance.android.ec.store.status.b.c.f48653a);
            return;
        L17:
            if (r101 == LoadStatus.RefreshWhenError) goto L22;
            if (r101 != LoadStatus.RefreshError) goto L26;
            UIUtils.displayToast(this.f185580a.Y().c(), R.string.shopping_fail_and_please_retry);
            return;
        }
    }

    public static final /* synthetic */ LazyStatusView d0(BaseFollowStoreStatusPresenter r100) {
        LazyStatusView r101 = r100.f185577f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L5:
        return r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        LazyStatusView r101 = (LazyStatusView) Z().b(R.id.ec_follow_store_status_view).f();
        this.f185577f = r101;
        r101.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.c.f48653a, new com.bytedance.android.ec.store.status.c(new BaseFollowStoreStatusPresenter$initStatusView$1(this), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.C0841b.f48652a, new com.bytedance.android.ec.store.status.c(new BaseFollowStoreStatusPresenter$initStatusView$2(this), null, 6))}));
        ((BaseFollowStoreViewModel) this.f185578g.getValue()).getLoadStatus().b(Y().e(), new a(this));
    }

    public BaseFollowStoreStatusPresenter(Fragment r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "f");
        Intrinsics.checkNotNullParameter(r101, "vmClazz");
        super(r100);
        this.f185579h = r101;
        this.f185578g = LazyKt.lazy(new BaseFollowStoreStatusPresenter$viewModel$2(this));
    }
}
