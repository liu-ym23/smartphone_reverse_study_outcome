package com.bytedance.android.window.shop.home.tab.presenter;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBasePresenter;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/presenter/WindowH5TabPresenter;", "Lcom/bytedance/android/window/shop/holder/presenter/ECWindowHolderBasePresenter;", "Landroidx/lifecycle/LifecycleEventObserver;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowH5TabPresenter extends ECWindowHolderBasePresenter implements LifecycleEventObserver {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f188861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f188862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f188863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function2<com.bytedance.android.window.shop.repository.tab.entity.v, ECLynxCardEvent, Unit> f188864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Fragment f188865k;

    public final BaseWindowTabViewModel F() {
        return (BaseWindowTabViewModel) this.f188861g.getValue();
    }

    public WindowH5TabPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f188864j = null;
        this.f188865k = r100;
        this.f188861g = LazyKt.lazy(new WindowH5TabPresenter$windowTabViewModel$2(this));
        this.f188862h = LazyKt.lazy(new WindowH5TabPresenter$bindOnce$2(this));
        this.f188863i = LazyKt.lazy(new WindowH5TabPresenter$statusView$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f188865k.getLifecycle().addObserver(this);
        ((WindowLazyStatusView) this.f188863i.getValue()).b(com.bytedance.android.ec.window.base.status.c.d.f49705a);
        Unit r101 = (Unit) this.f188862h.getValue();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "event");
        Lifecycle.Event r102 = Lifecycle.Event.ON_RESUME;
        Lifecycle.Event r103 = Lifecycle.Event.ON_PAUSE;
        Lifecycle.Event.Companion r104 = Lifecycle.Event.Companion;
    }
}
