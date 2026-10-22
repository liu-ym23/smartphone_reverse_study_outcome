package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECTabKitMixRefreshPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f186808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SmartRefreshLayout f186809g;

    public ECTabKitMixRefreshPresenter(final Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f186808f = LazyKt.lazy(new ECTabKitMixRefreshPresenter$viewModel$2(this, r100));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f186809g = (SmartRefreshLayout) Z().b(R.id.refresh_list_wrapper).f();
        int r101 = eh.b.b(this.f450897e.getContext()) + com.bytedance.android.shopping.extensions.b.b(44);
        SmartRefreshLayout r102 = this.f186809g;
        if (r102 == null) goto L5;
        wg.a.f(r102, 0, r101, 0, 0);
    L5:
        Context r103 = this.f450897e.getContext();
        if (r103 == null) goto L13;
        com.bytedance.android.shopping.store.tabkit.mixframe.f r104 = new com.bytedance.android.shopping.store.tabkit.mixframe.f(r103);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        SmartRefreshLayout r105 = this.f186809g;
        if (r105 == null) goto L12;
        r105.G(r104, -2);
        r105.g(false);
        r105.A = true;
        r105.W = new f(this);
        return;
    L12:
        return;
    }
}
