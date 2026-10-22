package com.bytedance.android.shopping.anchorv4.components;

import android.content.Context;
import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.anchorv3.PdpTaskManager;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.shopping.anchorv4.containers.page.PdContext;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.log.GULShowManager;
import com.bytedance.android.shopping.anchorv4.widgets.BasePdpNestedScrollView;
import com.bytedance.android.shopping.anchorv4.widgets.PdpNestedScrollView;
import com.bytedance.android.shopping.api.mall.feed.InitGYLComponentBehavior;
import com.larus.nova.R;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class GulComponent extends b73.a implements a73.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f165958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.shopping.api.mall.feed.d f165959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f165960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f165961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f165962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PdContext f165963h;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.components.GulComponent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends com.bytedance.android.ec.core.anchorv3.q {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ GulComponent f165964e;

        @Override // com.bytedance.android.ec.core.anchorv3.q
        public final void c() {
            Control r100 = this.f165964e.f165963h.f166272c.control();
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.getGulControl() != true) goto L11;
            Lazy r101 = PdpAB.f166747a;
            if (PdpAB.f166748b == false) goto L12;
            GulComponent r102 = this.f165964e;
            Function0<Unit> r103 = new GulComponent$1$onExecute$1(this);
            r102.getClass();
            Single.create(new k(r102)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(r102, r103));
            return;
        L12:
            return;
        }

        public AnonymousClass1(GulComponent r100) {
            this.f165964e = r100;
            super(3);
        }
    }

    @Override // a73.c
    public final void f() {
        this.f165961f = false;
        k0();
        com.bytedance.android.shopping.anchorv4.containers.page.s r100 = this.f165963h.f166275f;
        if (r100 == null) goto L5;
        PdpNestedScrollView r101 = r100.f166315i;
    L6:
        if (r101 == null) goto L9;
        r101.i();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // a73.c
    public final boolean C() {
        com.bytedance.android.shopping.anchorv4.containers.page.s r100 = this.f165963h.f166275f;
        if (r100 == null) goto L5;
        PdpNestedScrollView r101 = r100.f166315i;
    L7:
        if (r101 != null) goto L9;
        return true;
    L9:
        if (r101.h() != true) goto L14;
        return false;
    L14:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public final com.bytedance.android.shopping.api.mall.feed.d i0() {
        GULShowManager.a r100 = GULShowManager.f167043i;
        Context r101 = this.f165963h.getContext();
        com.bytedance.android.shopping.anchorv4.log.a r102 = new com.bytedance.android.shopping.anchorv4.log.a(this.f165963h.f166272c);
        Context r103 = this.f165963h.getContext();
        boolean r104 = ECServiceManager.f42805a;
        if (((IECHostService) ECServiceManager.c(IECHostService.class)).getRecommendStatus() == false) goto L5;
        int r105 = R.string.commerce_anchor_v3_guess_u_like;
    L6:
        String r106 = th.a.g(r103, r105);
        boolean r107 = this.f165963h.f166272c.isInSplit();
        r100.getClass();
        return GULShowManager.a.a(r101, r102, r106, r107);
    L5:
        r105 = R.string.commerce_anchor_v3_guess_u_like_recommend_switch_off;
        goto L6
    }

    public final void k0() {
        if (this.f165960e == true) goto L21;
        this.f165960e = true;
        if (this.f165959d != null) goto L7;
        this.f165959d = i0();
    L7:
        com.bytedance.android.shopping.api.mall.feed.d r100 = this.f165959d;
        if (r100 == null) goto L22;
        RecyclerView r101 = r100.getFeedView();
        if (r101 == null) goto L19;
        r101.setOverScrollMode(2);
        wg.a.a(r101);
        com.bytedance.android.shopping.anchorv4.containers.page.s r102 = this.f165963h.f166275f;
        if (r102 == null) goto L14;
        PdpNestedScrollView r103 = r102.f166315i;
    L15:
        if (r103 == null) goto L19;
        int r104 = BasePdpNestedScrollView.f170134g;
        if (r103.f170137c != null) goto L19;
        r103.f170137c = r101;
        r103.f170135a.addView(r101);
        r101.addOnScrollListener(r103.f170140f);
        goto L19
    L14:
        r103 = null;
    L19:
        r100.setFeedStateListener(new j(this, r100));
        j0(r100);
        return;
    L22:
        return;
    }

    public GulComponent(PdContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pdContext");
        this.f165963h = r100;
        this.f165961f = true;
        this.f165962g = LazyKt.lazy(new GulComponent$gulPreLoader$2(this));
        PdpTaskManager r101 = r100.f166272c.getPdpTaskManager();
        AnonymousClass1 r102 = new AnonymousClass1(this);
        Handler r103 = PdpTaskManager.f43777k;
        r101.i(r102, false);
    }

    public final void j0(com.bytedance.android.shopping.api.mall.feed.d r100) {
        int r101 = com.bytedance.android.shopping.utils.z.f187162a;
        com.bytedance.android.shopping.utils.z.c("call handleGulInit fromScroll=" + this.f165961f, "gul", 4);
        if (this.f165961f == false) goto L5;
        r100.f(InitGYLComponentBehavior.PRODUCT_DETAIL_SCROLL_TO_GYL);
        return;
    L5:
        r100.f(InitGYLComponentBehavior.PRODUCT_DETAIL_CLICK_RECOMMEND);
    }
}
