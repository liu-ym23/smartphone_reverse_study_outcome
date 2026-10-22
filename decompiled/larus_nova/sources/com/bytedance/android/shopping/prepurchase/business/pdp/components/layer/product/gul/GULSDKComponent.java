package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.shopping.anchorv4.log.GULShowManager;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;
import com.bytedance.android.shopping.api.mall.feed.InitGYLComponentBehavior;
import com.bytedance.android.shopping.api.mall.feed.d;
import com.bytedance.android.shopping.api.mall.feed.f;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.e;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.MultiRecyclerNestedScrollView;
import com.bytedance.android.shopping.utils.z;
import com.larus.nova.R;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import vg3.d0;
import vg3.j;

/* JADX INFO: loaded from: classes13.dex */
public final class GULSDKComponent extends m implements j {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f181734t = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MultiRecyclerNestedScrollView f181735m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f181736n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Deferred<? extends d> f181737o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f181738p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f181739q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f181740r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f181741s;

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f181742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GULSDKComponent f181743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f181744c;

        @Override // com.bytedance.android.shopping.api.mall.feed.f
        public final void a(ECMallFeedState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            int r101 = b.f181751a[r100.ordinal()];
            if (r101 == 1) goto L9;
            if (r101 != 4) goto L6;
        L8:
            int r102 = z.f187162a;
            z.c("gul init success state=" + r100, "gul", 4);
            this.f181744c.b();
            return;
        L6:
            if (r101 == 5) goto L8;
            return;
        L9:
            int r103 = z.f187162a;
            z.c("gul init failed state=" + r100, "gul", 4);
            if (this.f181742a == true) goto L14;
            this.f181742a = true;
            this.f181743b.i2(this.f181744c);
            return;
        }

        public a(GULSDKComponent r100, d r101) {
            this.f181743b = r100;
            this.f181744c = r101;
        }
    }

    @Override // vg3.j
    public final void u0() {
        this.f181741s = false;
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "forceInitGULComponent");
        k2();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(d0.class);
    }

    public final void k2() {
        if (this.f181739q == true) goto L10;
        this.f181739q = true;
        d r100 = this.f181736n;
        if (r100 != null) goto L7;
        BuildersKt.launch$default(Q1(), Dispatchers.getMain().getImmediate(), null, new GULSDKComponent$tryInitGulSdkComponent$1(this, null), 2, null);
        return;
    L7:
        if (r100 == null) goto L12;
        j2(r100);
        return;
    L12:
        return;
    }

    public GULSDKComponent() {
        this.f181741s = true;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, j.class, this, false, 12);
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "onAttach");
        BuildersKt.launch$default(Q1(), Dispatchers.getMain().getImmediate(), null, new GULSDKComponent$onAttach$1(this, null), 2, null);
    }

    public static final d h2(GULSDKComponent r100) {
        r100.getClass();
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(r100, "safeCreateGulComponent");
        FragmentActivity r101 = r100.O1().getContainerAbility().getContext();
        Object r102 = null;
        if (r101 == null) goto L24;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        GULShowManager.a r104 = GULShowManager.f167043i;     // Catch: Throwable -> L11
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.a r105 = new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.a(r100.O1(), r100);     // Catch: Throwable -> L11
        boolean r106 = ECServiceManager.f42805a;     // Catch: Throwable -> L11
        if (((IECHostService) ECServiceManager.c(IECHostService.class)).getRecommendStatus() == false) goto L8;
        int r107 = R.string.commerce_anchor_v3_guess_u_like;
    L9:
        String r108 = th.a.g(r101, r107);     // Catch: Throwable -> L11
        boolean r109 = ((e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r100.O1())).f181849b.f181035a;     // Catch: Throwable -> L11
        r104.getClass();     // Catch: Throwable -> L11
        d r110 = GULShowManager.a.a(r101, r105, r108, r109);     // Catch: Throwable -> L11
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(r100, "safeCreateGulComponent finish: " + r110);     // Catch: Throwable -> L11
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L11
    L13:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L17;
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.b(r100, "create gul component error", r112);
    L17:
        if (Result.m9455isFailureimpl(r111) == true) goto L21;
        r102 = r111;
    L21:
        return (d) r102;
    L8:
        r107 = R.string.commerce_anchor_v3_guess_u_like_recommend_switch_off;
    L11:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L24:
        return null;
    }

    public final void i2(d r100) {
        int r101 = z.f187162a;
        z.c("call handleGulInit fromScroll=" + this.f181741s, "gul", 4);
        if (this.f181741s == false) goto L5;
        r100.f(InitGYLComponentBehavior.PRODUCT_DETAIL_SCROLL_TO_GYL);
        return;
    L5:
        r100.f(InitGYLComponentBehavior.PRODUCT_DETAIL_CLICK_RECOMMEND);
    }

    public final void j2(d r100) {
        RecyclerView r101 = r100.getFeedView();
        if (r101 == null) goto L10;
        r101.setOverScrollMode(2);
        wg.a.a(r101);
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "add gul to scrollView");
        MultiRecyclerNestedScrollView r102 = this.f181735m;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("parentNestScrollView");
    L7:
        int r103 = MultiRecyclerNestedScrollView.f182245n;
        if (r102.f182248c != null) goto L10;
        r102.f182248c = r101;
        r102.f182246a.addView(r101);
        r101.addOnScrollListener(r102.f182258m);
    L10:
        r100.setFeedStateListener(new a(this, r100));
        i2(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final void b2(ViewGroup r100, ViewGroup.LayoutParams r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        this.f181735m = (MultiRecyclerNestedScrollView) r100;
    }
}
