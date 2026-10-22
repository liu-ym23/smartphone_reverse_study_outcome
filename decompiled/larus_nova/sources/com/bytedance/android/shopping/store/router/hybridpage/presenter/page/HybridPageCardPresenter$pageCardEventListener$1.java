package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class HybridPageCardPresenter$pageCardEventListener$1 implements com.bytedance.android.shopping.store.router.hybridpage.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridPageCardPresenter f185915a;

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void a() {
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$viewDisappeared$1(this));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void d() {
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$appResignActive$1(this));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void j() {
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$appBecomeActive$1(this));
    }

    public HybridPageCardPresenter$pageCardEventListener$1(HybridPageCardPresenter r100) {
        this.f185915a = r100;
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void b(final boolean r100) {
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$viewAppeared$1(this, r100));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void h(final boolean r100) {
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$sliceFinishLoad$1(this, r100));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void i(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridListId");
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$hybridListRequestLoadMore$1(this, r100));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void k(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$sliceLoadError$1(this, r100));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void m(final String r100, final Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$publishXEvent$1(this, r100, r101));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void f(final String r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "searchQuery");
        Intrinsics.checkNotNullParameter(r101, "searchSource");
        Intrinsics.checkNotNullParameter(r102, "suggestGroupId");
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$searchResultSearch$1(this, r100, r101, r102));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void l(final String r100, final Object r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "apiName");
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$firstScreenApiCompleted$1(this, r100, r101, r102));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void e(final String r100, final int r110, final int r111, final ECHybridListItemVO r112) {
        Intrinsics.checkNotNullParameter(r100, "hybridListId");
        Intrinsics.checkNotNullParameter(r112, "itemModel");
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$hybridListCardClicked$1(this, r100, r110, r111, r112));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void g(final String r110, final int r111, final int r112, final int r113, final ECHybridListItemVO r114) {
        Intrinsics.checkNotNullParameter(r110, "hybridListId");
        Intrinsics.checkNotNullParameter(r114, "itemModel");
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$hybridListCardDisappeared$1(this, r110, r111, r112, r113, r114));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void c(final String r110, final int r111, final int r112, final int r113, final ECHybridListItemVO r114, final boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "hybridListId");
        Intrinsics.checkNotNullParameter(r114, "itemModel");
        HybridPageCardPresenter.e0(this.f185915a, new HybridPageCardPresenter$pageCardEventListener$1$hybridListCardAppeared$1(this, r110, r111, r112, r113, r114, r115));
    }
}
