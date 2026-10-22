package com.bytedance.android.shopping.store.moments.module.presenter;

import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.moments.viewmodel.ECStoreMomentViewModel;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECStoreShortVideoLoadMorePresenter extends QFragmentPresenter implements IHybridListViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f185652f;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECStoreShortVideoLoadMorePresenter f185653a;

        public a(ECStoreShortVideoLoadMorePresenter r100) {
            this.f185653a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            LoadStatus r101 = (LoadStatus) r100;
            if (r101 == null) goto L7;
            this.f185653a.d0(r101);
            return;
        }
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final boolean C3() {
        return false;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void D() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void D1(Long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void K() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void g1(int r100, int r101, double r102) {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void m1(int r100, double r101) {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void o() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void onHide() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void onRelease() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void onShow() {
    }

    public ECStoreShortVideoLoadMorePresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f185652f = LazyKt.lazy(new ECStoreShortVideoLoadMorePresenter$viewModel$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        LoadMoreStatusView r101 = (LoadMoreStatusView) Z().b(R.id.sv_product_load_more).f();
        d0(((ECStoreMomentViewModel) this.f185652f.getValue()).getLoadStatus().a());
        ((ECStoreMomentViewModel) this.f185652f.getValue()).getLoadStatus().b(ECQuickUtilKt.a(Y()), new a(this));
    }

    public final void d0(LoadStatus r100) {
        if (r100 == null) goto L11;
        int r101 = i.f185683a[r100.ordinal()];
        if (r101 != 1) goto L8;
        ((LoadMoreStatusView) Z().b(R.id.sv_product_load_more).f()).setVisibility(8);
        ((LinearLayout) Z().b(R.id.rl_product_no_more).f()).setVisibility(0);
        return;
    L8:
        if (r101 != 2) goto L10;
        ((LoadMoreStatusView) Z().b(R.id.sv_product_load_more).f()).a();
        ((LinearLayout) Z().b(R.id.rl_product_no_more).f()).setVisibility(8);
        ((LinearLayout) Z().b(R.id.rl_product_no_more).f()).setVisibility(8);
        return;
    L10:
        if (r101 != 3) goto L11;
        ((LoadMoreStatusView) Z().b(R.id.sv_product_load_more).f()).b();
        ((LinearLayout) Z().b(R.id.rl_product_no_more).f()).setVisibility(8);
        ECToast.showToast$default(ECToast.INSTANCE, Y().c(), R.string.shopping_fail_and_please_retry, null, 4, null);
        return;
    L11:
        ((LoadMoreStatusView) Z().b(R.id.sv_product_load_more).f()).b();
        ((LinearLayout) Z().b(R.id.rl_product_no_more).f()).setVisibility(8);
    }
}
