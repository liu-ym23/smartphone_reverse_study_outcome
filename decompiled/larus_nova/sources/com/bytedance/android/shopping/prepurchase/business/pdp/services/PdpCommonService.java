package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import vg3.f0;
import vg3.h0;
import vg3.u;
import vg3.x;

/* JADX INFO: loaded from: classes13.dex */
public final class PdpCommonService extends b0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f182019l = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f182020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f182021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f182022k;

    public static final class a implements h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpCommonService f182023a;

        public a(PdpCommonService r100) {
            this.f182023a = r100;
        }

        @Override // vg3.h0
        public final void A0(int r100) {
            PdpCommonService r101 = this.f182023a;
            r101.f182021j = Integer.valueOf(r100);
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{x.class, u.class});
    }

    public final AVCoordinationServiceImpl b2() {
        return (AVCoordinationServiceImpl) this.f182020i.getValue();
    }

    public PdpCommonService() {
        this.f182020i = LazyKt.lazy(new PdpCommonService$avCoordinationService$2(this));
        this.f182022k = new a(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        b2().p().s();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, f0.class, new e(O1()), false, 12);
        AbsComponent.Y1(this, vg3.a.class, b2(), false, 12);
        O1().e().r().J1(h0.class, this.f182022k);
        AnchorV4PlayerStateManager r100 = b2().p();
        AnchorV4PlayerStateManager.b r101 = AnchorV4PlayerStateManager.f167506t;
        boolean r102 = r100.f167522p.a();
        r101.getClass();
        AnchorV4PlayerStateManager.b.b();
        r100.f167510d = Boolean.valueOf(r102);
        FragmentActivity r103 = O1().getContainerAbility().getContext();
        r101.getClass();
        AnchorV4PlayerStateManager.b.a(r103);
        b2().p().p();
        Z1(u.class, new PdpCommonService$onAttach$1(this, null));
        Z1(x.class, new PdpCommonService$onAttach$2(this, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        b2().p().q();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        b2().p().r();
    }
}
