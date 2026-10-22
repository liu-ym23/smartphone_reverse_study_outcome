package com.bytedance.android.window.shop.search.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.ec.window.base.status.WindowSearchProductLoadingStatusView;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchFragmentProductViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class t extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WindowSearchFragmentProductViewModel f189760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f189761g;

    public t(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f189760f = (WindowSearchFragmentProductViewModel) Y().g(WindowSearchFragmentProductViewModel.class);
        Context r101 = Y().c();
        ViewGroup r102 = (ViewGroup) Z().b(R.id.sv_product_list_status).f();
        final WindowLazyStatusView r103 = new WindowLazyStatusView(r101, null);
        r102.addView(r103);
        r103.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.window.base.status.c.b.f49703a, new com.bytedance.android.ec.window.base.status.d(new WindowSearchStatusPresenter$initOptStatusView$1(this, r103), null, null)), TuplesKt.to(com.bytedance.android.ec.window.base.status.c.C0852c.f49704a, new com.bytedance.android.ec.window.base.status.d(new WindowSearchStatusPresenter$initOptStatusView$2(this, r103), null, null))}));
        Map<? extends com.bytedance.android.ec.window.base.status.c, com.bytedance.android.ec.window.base.status.d<? extends View>> r104 = new WindowSearchProductLoadingStatusView(r101).a();
        Intrinsics.checkNotNullParameter(r104, "viewCreators");
        r103.removeAllViews();
        ((LinkedHashMap) r103.f49691b).clear();
        r103.f49690a.putAll(r104);
        WindowSearchFragmentProductViewModel r105 = this.f189760f;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r105.getLoadStatus().b(ECQuickUtilKt.a(Y()), new s(this, r102, r103, r101));
    }
}
