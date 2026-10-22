package com.bytedance.android.shopping.anchorv4.containers.page;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.anchorv4.containers.ProductDetailHalfFragment;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.anchorv4.voavhs.headgausee.HeadGaussRecyclerView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.jedi.arch.ISubscriber;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/containers/page/HalfScreenProductDetailPage;", "Lcom/bytedance/android/shopping/anchorv4/containers/page/BaseProductDetailPage;", "Lcom/bytedance/android/shopping/anchorv4/containers/page/k;", "Lr83/b;", "event", "", "onProductDetailHalfPageCloseEvent", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HalfScreenProductDetailPage extends BaseProductDetailPage implements k {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f166262w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final i f166263x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final DialogFragment f166264y;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HalfScreenProductDetailPage f166265a;

        public a(HalfScreenProductDetailPage r100) {
            this.f166265a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            this.f166265a.f166248u.k(!((Boolean) r100).booleanValue());
        }
    }

    public final w73.a E() {
        return (w73.a) this.f166262w.getValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.page.BaseProductDetailPage
    public final void C() {
        super.C();
        ISubscriber.DefaultImpls.selectSubscribe$default(this, u(), HalfScreenProductDetailPage$subscribeViewModelAsync$1.INSTANCE, HalfScreenProductDetailPage$subscribeViewModelAsync$2.INSTANCE, HalfScreenProductDetailPage$subscribeViewModelAsync$3.INSTANCE, null, new HalfScreenProductDetailPage$subscribeViewModelAsync$4(this), 8, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, u(), HalfScreenProductDetailPage$subscribeViewModelAsync$5.INSTANCE, null, new HalfScreenProductDetailPage$subscribeViewModelAsync$6(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, u(), HalfScreenProductDetailPage$subscribeViewModelAsync$7.INSTANCE, HalfScreenProductDetailPage$subscribeViewModelAsync$8.INSTANCE, null, new HalfScreenProductDetailPage$subscribeViewModelAsync$9(this), 4, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, u(), HalfScreenProductDetailPage$subscribeViewModelAsync$10.INSTANCE, null, new HalfScreenProductDetailPage$subscribeViewModelAsync$11(this), 2, null);
    }

    public final void G() {
        float r100 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(E().f558495a, 0.0f), 1.0f);
        s r101 = this.f166230c;
        if (r101 == null) goto L8;
        HeadGaussRecyclerView r102 = r101.f166310d;
        if (r102 == null) goto L9;
        r102.setAlpha(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.page.k
    public final boolean Q() {
        CommonMeta r100 = u().commonMeta();
        if (r100 == null) goto L5;
        String r101 = r100.getLastEcomSceneId();
    L6:
        boolean r102 = com.bytedance.android.shopping.anchorv4.helper.e.d(r101);
        Control r103 = u().control();
        if (r103 == null) goto L9;
        boolean r104 = r103.getShouldOptimizeHalfContainerCloseInteraction();
    L10:
        if (r104 == false) goto L14;
        if (r102 == true) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L9:
        r104 = false;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.page.BaseProductDetailPage
    public final void onCreate() {
        super.onCreate();
        int r100 = com.bytedance.android.shopping.base.event.c.f170705a;
        String r101 = getSessionId();
        if (this.f166247t == null) goto L5;
        boolean r102 = true;
    L6:
        com.bytedance.android.shopping.base.event.c.f(false, r101, r102);
        int r103 = u().getPanelHeight();
        if (r103 <= 0) goto L9;
        u().pageStatus().f167747m = r103;
    L9:
        List<ul.c> r104 = ul.b.f550585a;
        ul.b.b(this.f166263x);
        u().setFragmentClose(new AnonymousClass1(this));
        a73.l r105 = this.f166241n.f();
        if (r105 == null) goto L12;
        r105.V();
    L12:
        a73.k r106 = this.f166241n.c();
        if (r106 == null) goto L15;
        r106.k(E());
    L15:
        a73.d r107 = this.f166241n.d();
        if (r107 == null) goto L18;
        r107.k(E());
    L18:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.b r108 = this.f166241n.e();
        if (r108 == null) goto L21;
        r108.k(E());
    L21:
        s0.c(this);
        a73.n r109 = this.f166241n.g();
        if (r109 == null) goto L29;
        LiveData<Boolean> r110 = r109.c0();
        if (r110 == null) goto L29;
        l r111 = this.f166248u;
        Boolean r112 = r110.getValue();
        if (r112 != null) goto L28;
        r112 = Boolean.TRUE;
    L28:
        r111.k(true ^ r112.booleanValue());
        r110.observe(this.f166243p, new a(this));
    L29:
        AnchorV4PlayerStateManager r113 = u().getPlayerStateManager();
        r113.f167511e = new AnonymousClass3(this);
        AnchorV4PlayerStateManager r114 = u().getPlayerStateManager();
        r114.f167512f = new AnonymousClass4(this);
        View r115 = this.f166264y.getView();
        if (r115 != null) goto L32;
        return;
    L32:
        if (ViewCompat.isLaidOut(r115) == true) goto L34;
    L36:
        r115.addOnLayoutChangeListener(new j(this));
        return;
    L34:
        if (r115.isLayoutRequested() == true) goto L36;
        D(this, r115.getHeight());
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.page.BaseProductDetailPage
    public final void onDestroy() {
        super.onDestroy();
        s0.e(this);
        int r100 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r101 = com.bytedance.android.shopping.anchorv4.tracker.a.b(u());
        if (r101 == null) goto L5;
        r101.f167498c = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLOSE_METHOD, "slide"));
        AnchorV4TrackerImpl.b(r101, "close_product_detail", false, null, false, null, 30);
    L5:
        u().pageStatus().f167744j = true;
        List<ul.c> r102 = ul.b.f550585a;
        ul.b.a(this.f166263x);
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.page.BaseProductDetailPage
    public final void z() {
        G();
        s r100 = this.f166230c;
        if (r100 == null) goto L8;
        HeadGaussRecyclerView r101 = r100.f166310d;
        if (r101 == null) goto L9;
        this.f166248u.n(r101);
        return;
    L9:
        return;
    }

    public final void F(float r100) {
        if (r100 <= 0.0f) goto L6;
        r100 = 0.0f;
    L6:
        if (E().f558496b == r100) goto L16;
        E().f558496b = r100;
        float r101 = (-E().f558498d) * E().f558496b;
        s r102 = this.f166230c;
        if (r102 == null) goto L12;
        ViewGroup r103 = r102.f166307a;
        if (r103 == null) goto L12;
        r103.setTranslationY(r101);
    L12:
        com.bytedance.android.shopping.anchorv4.ai.g r104 = this.f166234g;
        if (r104 == null) goto L17;
        r104.D1(r101);
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.page.k
    public final void O(float r100) {
        E().f558495a = r100;
        F(r100);
        u().updateOffset(r100);
        a73.b r101 = this.f166241n.b();
        if (r101 == null) goto L5;
        r101.d0(r100);
    L5:
        a73.k r102 = this.f166241n.c();
        if (r102 == null) goto L8;
        r102.l(r100);
    L8:
        a73.d r103 = this.f166241n.d();
        if (r103 == null) goto L11;
        r103.l(r100);
    L11:
        a73.l r104 = this.f166241n.f();
        if (r104 == null) goto L14;
        r104.h(r100);
    L14:
        a73.e r105 = (a73.e) this.f166241n.f166305a.f166276g.a(a73.e.class);
        if (r105 == null) goto L17;
        r105.h(r100);
    L17:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.b r106 = this.f166241n.e();
        if (r106 == null) goto L20;
        r106.h(r100);
    L20:
        G();
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.page.k
    public final void P(boolean r100) {
        this.f166248u.e(r100);
        a73.m r101 = (a73.m) this.f166241n.f166305a.f166276g.a(a73.m.class);
        if (r101 == null) goto L5;
        r101.K(r100, this.f166264y);
    L5:
        u().updateExpanded(r100);
        if (r100 == false) goto L15;
        u().tryHandleHalfToFullAction();
        int r102 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r103 = com.bytedance.android.shopping.anchorv4.tracker.a.b(u());
        if (r103 == null) goto L11;
        r103.f167498c = MapsKt.mapOf(TuplesKt.to("btm", "a1.b8094.c0.d0"));
        AnchorV4TrackerImpl.b(r103, "draw_product_detail_page", false, null, true, PageFinder.via(this.f166264y), 4);
    L11:
        if (Q() == false) goto L16;
        a73.d r104 = this.f166241n.d();
        if (r104 == null) goto L16;
        r104.disable();
    L16:
        CommonMeta r105 = u().commonMeta();
        if (r105 == null) goto L24;
        String r106 = r105.getEntranceInfo();
        if (r106 == null) goto L25;
        JSONObject r107 = com.bytedance.android.shopping.extensions.k.w(r106);
        if (r107 == null) goto L26;
        String r108 = r107.optString("creative_id");
        s83.g r109 = AdLogUtils.f167035a;
        AdLogUtils.g(r108, r107.optString("log_extra"));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L15:
        u().tryHandleFullToHalfAction();
        goto L16
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onProductDetailHalfPageCloseEvent(r83.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        b(false, false, false);
    }

    public static final void D(HalfScreenProductDetailPage r100, int r101) {
        int r102 = r101 - j56.a.b(r100.getContext());
        r100.F(0.0f);
        w73.a r103 = r100.E();
        r103.f558498d = r100.u().pageStatus().f167747m;
        w73.a r104 = r100.E();
        r104.f558497c = r102 - r100.E().f558498d;
        a73.b r105 = r100.f166241n.b();
        if (r105 == null) goto L5;
        r105.D(r102);
    L5:
        a73.n r106 = r100.f166241n.g();
        if (r106 == null) goto L8;
        r106.H(false, r100.E().f558498d);
    L8:
        a73.j r107 = (a73.j) r100.f166241n.f166305a.f166276g.a(a73.j.class);
        if (r107 == null) goto L12;
        r107.W();
        return;
    }

    public HalfScreenProductDetailPage(DialogFragment r110, FragmentActivity r111, PageLifeCycleOwner r112, ViewModelStore r113, String r114, AnchorV4Param r115, Bundle r116, ProductDetailHalfFragment.b r117) {
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r113, "viewModelStore");
        Intrinsics.checkNotNullParameter(r114, "viewModelKey");
        Intrinsics.checkNotNullParameter(r117, "containerAbility");
        super(r111, r112, r113, r114, r115, r116, r117);
        this.f166264y = r110;
        this.f166262w = LazyKt.lazy(HalfScreenProductDetailPage$sharedUIVariables$2.INSTANCE);
        this.f166263x = new i(this);
    }
}
