package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.shopping.store.home.event.ChangeStateType;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.home.view.ECStoreHeaderFrameLayout;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u0010\b\u001a\u00020\u0003H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopAutoCollapsePresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", WidgetCostModule.TYPE_ON_CREATE, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopAutoCollapsePresenter extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int C = 0;
    public final b A;
    public boolean B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Disposable f183876u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f183877v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ShopStatus f183878w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Set<String> f183879x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f183880y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f183881z;

    public static final class a {
    }

    public static final class b implements ti.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAutoCollapsePresenter f183882a;

        public b(ECShopAutoCollapsePresenter r100) {
            this.f183882a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            dm.a.b r101 = dm.a.f469202a;
            int r102 = ECShopAutoCollapsePresenter.C;
            dm.a.a("ECShopAutoCollapsePresenter").i("lynxDialogCloseEventListener, onReceiveJsEvent() called with: params = " + r100);
            ECShopAutoCollapsePresenter.q0(this.f183882a, r100.optString("dialog_name"), false);
        }
    }

    public static final class c implements ti.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAutoCollapsePresenter f183883a;

        public c(ECShopAutoCollapsePresenter r100) {
            this.f183883a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            dm.a.b r101 = dm.a.f469202a;
            int r102 = ECShopAutoCollapsePresenter.C;
            dm.a.a("ECShopAutoCollapsePresenter").i("lynxDialogShowEventListener, onReceiveJsEvent() called with: params = " + r100);
            ECShopAutoCollapsePresenter.q0(this.f183883a, r100.optString("dialog_name"), true);
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAutoCollapsePresenter f183884a;

        public d(ECShopAutoCollapsePresenter r100) {
            this.f183884a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f183884a.B = true;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAutoCollapsePresenter f183885a;

        public e(ECShopAutoCollapsePresenter r100) {
            this.f183885a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            uj3.j r101 = (uj3.j) r100;
            ECShopAutoCollapsePresenter r102 = this.f183885a;
            r102.B = false;
            r102.t0(((com.bytedance.android.ec.store.setting.e) r102.f183880y.getValue()).c());
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAutoCollapsePresenter f183886a;

        public f(ECShopAutoCollapsePresenter r100) {
            this.f183886a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ShopStatus r101 = (ShopStatus) r100;
            if (r101 != ShopStatus.PREVIEW_COLLAPSE) goto L19;
            ECShopAutoCollapsePresenter r102 = this.f183886a;
            if (r102.f183878w == r101) goto L19;
            if (r102.T().getSlideByAuto() == true) goto L9;
            int r103 = ECShopAutoCollapsePresenter.C;
        L17:
            String r104 = "hand";
        L18:
            this.f183886a.T().doAnyEventActionWithBtm("a1.b6269.c0.d0", PageFinder.via(this.f183886a.y()), "store_head_live_fade", null, new Pair[]{TuplesKt.to("fade_type", r104)});
            goto L19
        L9:
            ui3.c r105 = this.f183886a.T().getChangeStateEvent().getValue();
            if (r105 == null) goto L12;
            ChangeStateType r106 = r105.f550147b;
        L14:
            if (r106 != ChangeStateType.AUTO) goto L16;
            int r107 = ECShopAutoCollapsePresenter.C;
            r104 = "auto";
            goto L18
        L16:
            int r108 = ECShopAutoCollapsePresenter.C;
            goto L17
        L12:
            r106 = null;
        L19:
            this.f183886a.f183878w = r101;
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAutoCollapsePresenter f183887a;

        public g(ECShopAutoCollapsePresenter r100) {
            this.f183887a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Float) r100).floatValue() >= 1.0f) goto L5;
            return;
        L5:
            if (this.f183887a.T().getUpglideFactorChangeByUser() == false) goto L7;
            int r101 = ECShopAutoCollapsePresenter.C;
            String r102 = "hand";
        L8:
            ECStoreViewModel r103 = this.f183887a.T();
            PageFinder r104 = PageFinder.via(this.f183887a.y());
            Pair<String, ? extends Object>[] r105 = new Pair[2];
            uj3.j r106 = this.f183887a.T().getCurrentTab();
            if (r106 == null) goto L11;
            String r107 = r106.b();
        L12:
            r105[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r107);
            r105[1] = TuplesKt.to("fade_type", r102);
            r103.doAnyEventActionWithBtm("a1.b6269.c0.d0", r104, "store_head_info_fade", null, r105);
            return;
        L11:
            r107 = null;
            goto L12
        L7:
            int r108 = ECShopAutoCollapsePresenter.C;
            r102 = "auto";
            goto L8
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        ECLiveHybridUtil.p("ecom_shop_lynx_dialog_show", this.f183881z);
        ECLiveHybridUtil.p("ecom_shop_lynx_dialog_close", this.A);
        s0();
        k0().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ECLiveHybridUtil.p("ecom_shop_lynx_dialog_show", this.f183881z);
        ECLiveHybridUtil.p("ecom_shop_lynx_dialog_close", this.A);
    }

    public final void r0() {
        boolean r100 = true;
        if ((!this.f183879x.isEmpty()) == false) goto L5;
        return;
    L5:
        dm.a.b r101 = dm.a.a("ECShopAutoCollapsePresenter");
        StringBuilder r102 = new StringBuilder("collapseHeaderIfNeed: changeStatus:");
        ui3.c r103 = T().getChangeStateEvent().getValue();
        if (r103 == null) goto L8;
        ShopStatus r104 = r103.f550148c;
    L9:
        r102.append(r104);
        r102.append(", currentStatus:");
        r102.append(T().getShopStatus().getValue());
        r102.append(",upglide=");
        r102.append(T().getUpglideFactor().getValue());
        r101.a(r102.toString());
        if (T().getShopStatus().getValue() != ShopStatus.PREVIEW_EXPANDED) goto L12;
        T().onImmediateCollapseChangeStateUpdate(new ui3.c(3, ChangeStateType.AUTO, ShopStatus.PREVIEW_COLLAPSE));
        boolean r105 = true;
    L14:
        if (com.bytedance.android.shopping.extensions.k.d(T().getUpglideFactor().getValue()) >= 1) goto L16;
        T().onImmediateCollapseHeaderStateUpdate(new ui3.e(1, ChangeStateType.AUTO));
    L17:
        if (r100 == false) goto L20;
        T().onLynxEvent("ecom.shop_info_area.close_prompt_bubble", null);
        return;
    L20:
        return;
    L16:
        r100 = r105;
        goto L17
    L12:
        r105 = false;
        goto L14
    L8:
        r104 = null;
        goto L9
    }

    public final void s0() {
        Disposable r100 = this.f183876u;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L12;
        Disposable r101 = this.f183876u;
        if (r101 == null) goto L9;
        r101.dispose();
    L9:
        this.f183876u = null;
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        T().setEnterOtherPageCollaspeHeader(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        uj3.j r100 = T().getCurrentTab();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.i() == true) goto L7;
        return;
    L7:
        if (T().getEnterOtherPageCollaspeHeader() == false) goto L12;
        r0();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        s0();
    }

    public ECShopAutoCollapsePresenter(Fragment r100) {
        super(r100);
        this.f183878w = ShopStatus.NORMAL;
        this.f183879x = new LinkedHashSet();
        this.f183880y = LazyKt.lazy(ECShopAutoCollapsePresenter$animationConfig$2.INSTANCE);
        this.f183881z = new c(this);
        this.A = new b(this);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        k0().addObserver(this);
        ECLiveHybridUtil.n("ecom_shop_lynx_dialog_show", this.f183881z);
        ECLiveHybridUtil.n("ecom_shop_lynx_dialog_close", this.A);
        View r101 = T().findContainer(ShopContainerType.LIVE_PREVIEW_CONTAINER);
        if (r101 == null) goto L5;
        r101.setOnTouchListener(new h(this));
    L5:
        ECStoreViewModel r102 = T();
        ShopContainerType r103 = ShopContainerType.SHOP_INFO_CONTAINER;
        View r104 = r102.findContainer(r103);
        if (r104 == null) goto L8;
        r104.setOnTouchListener(new i(this));
    L8:
        View r105 = T().findContainer(r103);
        if ((r105 instanceof ECStoreHeaderFrameLayout) == true) goto L11;
        r105 = null;
    L11:
        ECStoreHeaderFrameLayout r106 = (ECStoreHeaderFrameLayout) r105;
        if (r106 == null) goto L14;
        r106.setOnClickContentListener(new j(this));
    L14:
        T().getSlideOrTouchByUserEvent().a(W(), new d(this), false);
        Lazy r107 = ECTaskManager.f48688b;
        ECTaskManager.a.a().a(T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopAutoCollapsePresenter$onBind$2(this));
        T().getCurrentTabLiveData().a(W(), new e(this), false);
        T().getShopStatus().a(W(), new f(this), false);
        T().getUpglideFactor().a(W(), new g(this), false);
    }

    public final void t0(long r100) {
        if (this.f183877v == true) goto L5;
        return;
    L5:
        if ((!this.f183879x.isEmpty()) == true) goto L17;
        uj3.j r101 = T().getCurrentTab();
        if (r101 == null) goto L12;
        if (r101.i() != true) goto L12;
    L13:
        s0();
        this.f183876u = bg4.b.b(Observable.timer(r100, TimeUnit.MILLISECONDS)).subscribe(new com.bytedance.android.shopping.store.home.presenter.f(this), com.bytedance.android.shopping.store.home.presenter.g.f184176a);
        return;
    L12:
        if (com.bytedance.android.shopping.store.settings.a.a() == true) goto L13;
        return;
    }

    public static final void q0(ECShopAutoCollapsePresenter r100, String r101, boolean r102) {
        if (r102 == false) goto L4;
        r100.f183879x.add(r101);
        r100.s0();
    L5:
        dm.a.a("ECShopAutoCollapsePresenter").a("handleLynxDialogVisibilityChange dialogName=" + r101 + " isShow=" + r102 + " activeDialogs=" + r100.f183879x);
        return;
    L4:
        r100.f183879x.remove(r101);
        r100.t0(((com.bytedance.android.ec.store.setting.e) r100.f183880y.getValue()).b());
        goto L5
    }
}
