package com.bytedance.android.window.shop.search.presenter;

import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/search/presenter/WindowSearchGroupPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchGroupPresenter extends QPresenter implements LifecycleObserver {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WindowSearchViewModel f189686e;

    public WindowSearchGroupPresenter() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f189686e = (WindowSearchViewModel) ECQuickUtilKt.c(u(), WindowSearchViewModel.class);
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        LinearLayout r101 = (LinearLayout) w().b(R.id.search_middle_page_container).f();
        RecyclerView r102 = (RecyclerView) w().b(R.id.search_sug_list).f();
        WindowSearchViewModel r103 = this.f189686e;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r103.getSearchContent().b(ECQuickUtilKt.a(u()), new b(this, r101, r102));
    }
}
