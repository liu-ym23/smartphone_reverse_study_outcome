package com.bytedance.android.window.shop.search.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.search.history.ECWindowHistoryView;
import com.bytedance.android.ec.window.base.search.history.WindowHistoryBanner;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/search/presenter/WindowSearchHistoryPresenter;", "Lcom/bytedance/android/window/shop/search/presenter/WindowSearchBasePresenter;", "", "onResume", "onPause", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchHistoryPresenter extends WindowSearchBasePresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WindowSearchViewModel f189687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ECWindowHistoryView f189688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WindowHistoryBanner f189689h;

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        WindowHistoryBanner r100 = this.f189689h;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        ECWindowHistoryView r100 = this.f189688g;
        if (r100 == null) goto L5;
        r100.removeAllViews();
        r100.f49539b = null;
        r100.f49541d = 3;
        r100.f49540c = false;
    L5:
        WindowHistoryBanner r101 = this.f189689h;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
        return;
    }

    public WindowSearchHistoryPresenter() {
    }

    public static final /* synthetic */ WindowSearchViewModel E(WindowSearchHistoryPresenter r100) {
        WindowSearchViewModel r101 = r100.f189687f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    @Override // com.bytedance.android.window.shop.search.presenter.WindowSearchBasePresenter, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        super.A(r100);
        this.f189687f = (WindowSearchViewModel) ECQuickUtilKt.c(u(), WindowSearchViewModel.class);
        this.f189688g = (ECWindowHistoryView) w().b(R.id.commerce_store_search_history_view).f();
        WindowHistoryBanner r101 = (WindowHistoryBanner) w().b(R.id.commerce_store_search_history_banner).f();
        this.f189689h = r101;
        r101.setActionPerformListener(new c(this));
        ECWindowHistoryView r102 = this.f189688g;
        if (r102 == null) goto L5;
        r102.setActionListener(new g(this));
    L5:
        WindowSearchViewModel r103 = this.f189687f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r103.doEventAction("search_history", new Pair[]{TuplesKt.to("action_type", "show"), TuplesKt.to("enter_from", "search_window")});
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        WindowSearchViewModel r104 = this.f189687f;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r104.getPostKeyword().a(ECQuickUtilKt.a(u()), new d(this), false);
        WindowSearchViewModel r105 = this.f189687f;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r105.getStoreSearchHistories().b(ECQuickUtilKt.a(u()), new e(this));
        WindowSearchViewModel r106 = this.f189687f;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        r106.getHistoryEditing().b(ECQuickUtilKt.a(u()), new f(this));
    }
}
