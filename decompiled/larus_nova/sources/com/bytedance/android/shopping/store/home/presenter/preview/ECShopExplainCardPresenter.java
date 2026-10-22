package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/preview/ECShopExplainCardPresenter;", "Lcom/bytedance/android/shopping/store/home/frame/presenter/a;", "Lcom/bytedance/android/ec/store/common/headlive/StoreV3LiveRoomVO;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopExplainCardPresenter extends com.bytedance.android.shopping.store.home.frame.presenter.a<StoreV3LiveRoomVO> implements LifecycleObserver {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f184270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f184271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public cf.d f184272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f184273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f184274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public StoreV3LiveRoomVO f184275o;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        cf.d r100 = this.f184272l;
        if (r100 == null) goto L5;
        r100.onDestroy();
    L5:
        this.f184272l = null;
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void j0() {
        p r100 = (p) this.f184273m.getValue();
        if (r100 == null) goto L6;
        r100.k();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.f184275o != null) goto L5;
        return;
    L5:
        if (this.f184270j == null) goto L9;
        Lazy r100 = ECTaskManager.f48688b;
        ECTaskManager.a.a().a(d0().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopExplainCardPresenter$onResume$$inlined$let$lambda$1(this));
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        e0().removeObserver(this);
    }

    public ECShopExplainCardPresenter(Fragment r100) {
        Intrinsics.checkNotNull(r100);
        super(r100);
        this.f184273m = LazyKt.lazy(new ECShopExplainCardPresenter$modelAdapter$2(this));
        this.f184274n = LazyKt.lazy(new ECShopExplainCardPresenter$behaviorAdapter$2(this));
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void i0(StoreV3LiveRoomVO r100) {
        StoreV3LiveRoomVO r101 = r100;
        p r102 = (p) this.f184273m.getValue();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.j() != true) goto L14;
        this.f184275o = r101;
        this.f184270j = (ViewGroup) Z().b(R.id.store_v3_live_card).f();
        this.f184271k = (ViewGroup) Z().b(R.id.fl_live_container).f();
        p r103 = (p) this.f184273m.getValue();
        if (r103 == null) goto L11;
        jm.a<ShopLiveState> r104 = r103.e();
        if (r104 == null) goto L11;
        r104.a(h0(), new a(this), false);
    L11:
        e0().addObserver(this);
        return;
    }
}
