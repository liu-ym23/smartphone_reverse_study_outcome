package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv3.utils.a0;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2.PdpEventRegistry;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.DynamicFeatureComponent;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.LynxAbilityImpl;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import vg3.f0;
import vg3.v;
import vg3.w;
import vg3.x;
import vg3.y;

/* JADX INFO: loaded from: classes13.dex */
public final class PdpDynamicFeatureService extends DynamicFeatureComponent<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> implements v {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f182140v = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f182141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> f182142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f182143o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f182144p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f182145q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Runnable f182146r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f182147s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f182148t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f182149u;

    public static final class a implements com.bytedance.android.shopping.anchorv4.voavhs.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpDynamicFeatureService f182150a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.e
        public final String getSessionId() {
            return this.f182150a.O1().f().f523187a.f523190b;
        }

        public a(PdpDynamicFeatureService r100) {
            this.f182150a = r100;
        }
    }

    public static final class b implements com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpDynamicFeatureService f182151a;

        public b(PdpDynamicFeatureService r100) {
            this.f182151a = r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2.g
        public final void a(AbsCommonChainEventImpl r100) {
            Intrinsics.checkNotNullParameter(r100, "eventImpl");
            o r101 = this.f182151a.b2();
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "eventImpl");
            EventChain r102 = r101.f180977e;
            if (r102 == null) goto L6;
            r102.g(r100);
            return;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{y.class, f0.class, w.class, vg3.o.class});
    }

    @Override // vg3.v
    public final d C() {
        return new d(this);
    }

    @Override // vg3.v
    public final t96.a t0() {
        Intrinsics.checkNotNullParameter("PDPPopoverMask", "eventName");
        o r100 = b2();
        r100.getClass();
        Intrinsics.checkNotNullParameter("PDPPopoverMask", "eventName");
        EventChain r101 = r100.f180977e;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.c("PDPPopoverMask");
    }

    public PdpDynamicFeatureService() {
        this.f182141m = true;
        this.f182148t = LazyKt.lazy(new PdpDynamicFeatureService$lynxCardPreloadHelper$2(this));
        this.f182149u = LazyKt.lazy(new PdpDynamicFeatureService$indexActionHelper$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.DynamicFeatureComponent, com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        Z1(x.class, new PdpDynamicFeatureService$listenAndResetServerTime$1(this, null));
        Z1(x.class, new PdpDynamicFeatureService$initActionStorage$1(this, null));
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181848a.getNativeParams().getFullMode() == true) goto L5;
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181038d.b(this, com.bytedance.android.shopping.prepurchase.arch.container.state.j.a(), new e(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181038d, this, new f(this));
    L5:
        b2().M0(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_in_split", Boolean.valueOf(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181035a))}));
        b2().J1("pdp_service_for_slice", new a(this));
        AbsComponent.Y1(this, v.class, this, false, 12);
        Z1(y.class, new PdpDynamicFeatureService$registerPdpShowEvent$1(this, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.DynamicFeatureComponent, com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        LynxAbilityImpl r100 = a2();
        JSONObject r101 = new JSONObject();
        AnchorV4Param r102 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181848a;
        if (r102 == null) goto L7;
        V4NativeParams r103 = r102.getNativeParams();
        if (r103 == null) goto L7;
        String r104 = r103.getPdpEventTransparentId();
    L8:
        r101.put("pdp_event_transparent_id", String.valueOf(r104));
        Unit r105 = Unit.INSTANCE;
        r100.B("ecom.pdp.close", r101);
        Runnable r106 = this.f182146r;
        if (r106 == null) goto L11;
        Lazy r107 = UIUtils.f45548a;
        UIUtils.c().removeCallbacks(r106);
    L11:
        super.U1();
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void X1() {
        super.X1();
        a0 r100 = a0.f165301a;
        BuildersKt.launch$default(Q1(), null, null, new PdpDynamicFeatureService$onStop$1(this, null), 3, null);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
    }

    @Override // vg3.v
    public final void J0(boolean r100) {
        if (this.f182145q != r100) goto L5;
        return;
    L5:
        this.f182145q = r100;
        this.f182144p = null;
    }

    @Override // vg3.v
    public final boolean Y0(boolean r100) {
        boolean r101 = false;
        if (Intrinsics.areEqual(this.f182144p, Boolean.valueOf(r100)) == false) goto L6;
        dm.a.a("PdpSnapshotTransition").b("screen mode update expanded=" + r100 + " dispatched=false reason=duplicate", null);
        return false;
    L6:
        c r102 = this.f182143o;
        if (r102 != null) goto L10;
        dm.a.a("PdpSnapshotTransition").b("screen mode update expanded=" + r100 + " dispatched=false reason=action_not_ready", null);
        return false;
    L10:
        if (r100 == false) goto L15;
        e73.a r103 = r102.f182165a;
        if (r103 == null) goto L19;
        r101 = r102.b(r103.e());
    L19:
        if (r101 == false) goto L21;
        this.f182144p = Boolean.valueOf(r100);
    L21:
        dm.a.a("PdpSnapshotTransition").b("screen mode update expanded=" + r100 + " dispatched=" + r101, null);
        return r101;
    L15:
        e73.a r104 = r102.f182165a;
        if (r104 == null) goto L19;
        r101 = r102.b(r104.d());
        goto L19
    }

    @Override // vg3.v
    public final p73.c S(p73.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "componentId");
        return ((p73.e) this.f182148t.getValue()).a(r100, r101);
    }

    @Override // vg3.v
    public final void i1(com.bytedance.android.ecom.arch.slice.action.v r100, j73.d r101) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        Intrinsics.checkNotNullParameter(r101, "dependency");
        b r102 = new b(this);
        FragmentActivity r103 = O1().getContainerAbility().getContext();
        if (r103 != null) goto L5;
        return;
    L5:
        PdpEventRegistry.a(r102, r100, r103, r101);
    }
}
