package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.tabkit.mixframe.MixFrameViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECTabKitMixFrameStatusPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f186804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public StatusView f186805g;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECTabKitMixFrameStatusPresenter f186806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECHybridListContainer f186807b;

        public a(ECTabKitMixFrameStatusPresenter r100, ECHybridListContainer r101) {
            this.f186806a = r100;
            this.f186807b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            LoadStatus r101 = (LoadStatus) r100;
            if (r101 == LoadStatus.InitializeEmpty) goto L7;
            if (r101 == LoadStatus.InitializeError) goto L7;
        L16:
            if (r101 != LoadStatus.InitializeSuccess) goto L23;
            StatusView r102 = this.f186806a.f186805g;
            if (r102 == null) goto L20;
            ExtensionsKt.gone(r102);
        L20:
            ExtensionsKt.visible(this.f186807b);
            return;
        L23:
            return;
        L7:
            if (((MixFrameViewModel) this.f186806a.f186804f.getValue()).getFirstRequestSuccess() == true) goto L16;
            StatusView r103 = this.f186806a.f186805g;
            if (r103 == null) goto L11;
            ExtensionsKt.visible(r103);
        L11:
            StatusView r104 = this.f186806a.f186805g;
            if (r104 == null) goto L14;
            r104.setVisibility(0);
            r104.setECStatus(2);
        L14:
            ExtensionsKt.gone(this.f186807b);
        }
    }

    public ECTabKitMixFrameStatusPresenter(final Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f186804f = LazyKt.lazy(new ECTabKitMixFrameStatusPresenter$viewModel$2(this, r100));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        StatusView r101 = (StatusView) a0().findViewById(R.id.ec_store_mix_frame_tab_status);
        this.f186805g = r101;
        if (r101 == null) goto L8;
        View r102 = th.a.c(Y().c(), R.layout.shopping_layout_store_v2_default, r101, false);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        Unit r104 = Unit.INSTANCE;
        r102.setLayoutParams(r103);
        View r105 = r102.findViewById(R.id.store_v2_tv_refresh);
        if (r105 == null) goto L7;
        r105.setOnClickListener(new e(this));
    L7:
        r101.b(null, r102, true);
    L8:
        ECHybridListContainer r106 = (ECHybridListContainer) Z().b(R.id.ec_store_mix_tab_hybridContainer).f();
        ((MixFrameViewModel) this.f186804f.getValue()).getLoadStatus().b(Y().e(), new a(this, r106));
    }
}
