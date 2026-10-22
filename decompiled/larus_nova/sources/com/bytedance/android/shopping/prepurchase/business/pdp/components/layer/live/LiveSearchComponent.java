package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv3.i;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import com.larus.nova.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.l;
import vg3.q;
import vg3.w;

/* JADX INFO: loaded from: classes13.dex */
public final class LiveSearchComponent extends m implements q {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f181148w = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g f181149m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f181150n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ECHotAtmosphere f181151o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public i f181152p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public hn.c f181153q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TopBannerVO f181154r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f181155s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f181156t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f181157u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f181158v;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{w.class, l.class});
    }

    public LiveSearchComponent() {
        this.f181155s = LazyKt.lazy(new LiveSearchComponent$statusBarHeight$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        if (g2().getNativeParams().getFromLive() == false) goto L9;
        String r100 = g2().getNativeParams().getLiveRoomId();
        if (r100 == null) goto L9;
        g r101 = new g(this, r100);
        this.f181150n = r101;
        boolean r102 = ECServiceManager.f42805a;
        cf.l r103 = (cf.l) ECServiceManager.c(cf.l.class);
        if (r103 == null) goto L9;
        r103.Ka(r100, r101);
    L9:
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(O1().d().getData().f(), this, new d(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181038d, this, new e(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181037c, this, new f(this));
        AbsComponent.Y1(this, q.class, this, false, 12);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        g r100 = this.f181150n;
        if (r100 == null) goto L8;
        boolean r101 = ECServiceManager.f42805a;
        cf.l r102 = (cf.l) ECServiceManager.c(cf.l.class);
        if (r102 == null) goto L9;
        r102.Ca(r100.f181169b, r100);
        return;
    L9:
        return;
    }

    @Override // vg3.q
    public final hn.c G() {
        return this.f181153q;
    }

    @Override // vg3.q
    public final i j() {
        return this.f181152p;
    }

    public final boolean i2(ECHotAtmosphere r100) {
        if (r100.getNumInt() > 0) goto L5;
        return false;
    L5:
        int r101 = r100.type;
        if (r101 == 1) goto L16;
        if (r101 != 2) goto L10;
        return true;
    L10:
        if (r101 == 3) goto L16;
        if (r101 == 4) goto L16;
        return false;
    L16:
        return ECSettingKeys.q0();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        FrameLayout r102 = new FrameLayout(r100.getContext());
        r102.setId(R.id.live_hot_sale);
        return r102;
    }

    public static final void h2(LiveSearchComponent r100, i r101, TopBannerVO r102) {
        r100.getClass();
        c r103 = new c(r100, r101, r102);
        if (PdpPerfOpt.c() == false) goto L5;
        r100.O1().b().e1(r103);
        return;
    L5:
        r103.run();
    }
}
