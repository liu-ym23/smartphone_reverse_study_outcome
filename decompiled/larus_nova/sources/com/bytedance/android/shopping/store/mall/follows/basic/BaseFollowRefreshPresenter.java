package com.bytedance.android.shopping.store.mall.follows.basic;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class BaseFollowRefreshPresenter<T extends BaseFollowStoreViewModel> extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f185543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SmartRefreshLayout f185544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class<T> f185545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f185546i;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f185544g = (SmartRefreshLayout) Z().b(R.id.refresh_list_wrapper).f();
        Context r101 = this.f450897e.getContext();
        if (r101 == null) goto L10;
        com.bytedance.android.shopping.store.tabkit.mixframe.f r102 = new com.bytedance.android.shopping.store.tabkit.mixframe.f(r101);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        SmartRefreshLayout r103 = this.f185544g;
        if (r103 == null) goto L9;
        r103.G(r102, -2);
        r103.g(false);
        r103.A = this.f185546i;
        r103.W = new a(this);
        return;
    L9:
        return;
    }

    public final void d0(boolean r110, boolean r111) {
        long r100 = System.currentTimeMillis();
        String r101 = ((BaseFollowStoreViewModel) this.f185543f.getValue()).getSceneId();
        Pair[] r102 = new Pair[1];
        if (r110 == false) goto L5;
        String r112 = "refresh_start";
    L8:
        r102[0] = TuplesKt.to("refresh_status", r112);
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.shop.refresh", r100, r101, false, MapsKt.mutableMapOf(r102), false, 32));
        return;
    L5:
        if (r111 == false) goto L7;
        r112 = "refresh_success";
        goto L8
    L7:
        r112 = "refresh_failed";
        goto L8
    }

    public BaseFollowRefreshPresenter(final Fragment r100, Class<T> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "vmClazz");
        super(r100);
        this.f185545h = r101;
        this.f185546i = r102;
        this.f185543f = LazyKt.lazy(new BaseFollowRefreshPresenter$viewModel$2(this, r100));
    }
}
