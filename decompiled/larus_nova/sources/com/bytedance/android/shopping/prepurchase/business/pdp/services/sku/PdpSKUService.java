package com.bytedance.android.shopping.prepurchase.business.pdp.services.sku;

import android.os.SystemClock;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ProductPriceInfo;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuSpecInfo;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.g;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.q;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.state.e;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.LynxAbilityImpl;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.utils.a0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import fi3.c0;
import j73.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ti.j;
import vg3.e0;
import vg3.x;

/* JADX INFO: loaded from: classes13.dex */
public final class PdpSKUService extends b0 implements e0, Function1<SkuProductDetailInfo, Unit> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f182102v = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f182103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SkuRestoreState f182104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<Function1<SkuProductDetailInfo, Unit>> f182105k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f182106l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f182107m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f182108n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f182109o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f182110p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f182111q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f182112r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<Function0<Unit>> f182113s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f182114t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a f182115u;

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpSKUService f182116a;

        public a(PdpSKUService r100) {
            this.f182116a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.d
        public final void b(JSONObject r110) {
            Intrinsics.checkNotNullParameter(r110, "param");
            int r100 = com.bytedance.android.shopping.anchorv3.utils.a.f165300a;
            CommonMeta r101 = this.f182116a.b2();
            Integer r102 = null;
            if (r101 == null) goto L5;
            ECAdLogExtra r103 = r101.getAdLogExtra();
        L6:
            CommonMeta r104 = this.f182116a.b2();
            if (r104 == null) goto L9;
            String r105 = r104.getPromotionId();
        L10:
            CommonMeta r106 = this.f182116a.b2();
            if (r106 == null) goto L13;
            r102 = Integer.valueOf((int) r106.getPromotionSource());
        L13:
            com.bytedance.android.shopping.anchorv3.utils.a.b(r103, r105, r102, Long.valueOf(r110.optLong("price")), SystemClock.uptimeMillis() - r110.optLong("sku_resume_time"), "large_stabilization");
            return;
        L9:
            r105 = null;
            goto L10
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.d
        public final void c(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            PdpSKUService r101 = this.f182116a;
            r101.f182109o = r101.f182106l;
            LynxAbilityImpl r102 = r101.O1().e().D0();
            JSONObject r103 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r103, LocationMonitorConst.IDENTIFIER, this.f182116a.a2().getSessionId());
            KtSafeMethodExtensionKt.safePut(r103, "hide", "0");
            Unit r104 = Unit.INSTANCE;
            r102.B("ecom_pdp_sku_panel_status_change", r103);
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.d
        public final void a(JSONObject r210, a0 r211) {
            Intrinsics.checkNotNullParameter(r210, "params");
            String r100 = null;
            if (r211 == null) goto L5;
            vh3.a r101 = r211.f187046b;
        L6:
            ArrayList r102 = new ArrayList();
            if (r101 == null) goto L23;
            List<String> r103 = r101.c();
            if (r103 == null) goto L23;
            Iterator<T> r104 = r103.iterator();
        L12:
            if (r104.hasNext() == false) goto L23;
            String r105 = (String) r104.next();
            if (r105 != null) goto L16;
        L19:
            boolean r106 = true;
        L20:
            if (r106 == true) goto L21;
            r102.add(r105);
            goto L12
        L21:
            r102.add(null);
            goto L12
        L16:
            if (r105.length() == 0) goto L19;
            r106 = false;
        L23:
            CommonMeta r107 = this.f182116a.b2();
            if (r107 == null) goto L28;
            List<SkuSpecInfo> r108 = r107.getSkuSpecInfo();
            if (r108 == null) goto L28;
            int r109 = r108.size();
        L29:
            SkuRestoreState r110 = new SkuRestoreState(r109);
            Object[] r111 = r102.toArray(new String[0]);
            if (r111 == null) goto L58;
            String[] r112 = (String[]) r111;
            if (r101 == null) goto L36;
            String r113 = r101.a();
            if (r113 == null) goto L36;
            Long r114 = StringsKt.toLongOrNull(r113);
        L37:
            if (r101 == null) goto L41;
            uh3.b r115 = r101.d();
            if (r115 == null) goto L41;
            String r116 = r115.h();
        L42:
            SkuRestoreState.saveSelectedSpec$default(r110, r112, r114, r116, null, null, null, 0, 120, null);
            this.f182116a.d2(r110, true);
            if (com.bytedance.android.ec.core.abtest.d.D() == true) goto L45;
        L47:
            if (r211 == null) goto L50;
            r100 = r211.f187045a;
        L50:
            if ((!Intrinsics.areEqual(r100, String.valueOf(102))) == false) goto L55;
            Iterator r117 = ((ArrayList) this.f182116a.f182113s).iterator();
        L53:
            if (r117.hasNext() == false) goto L55;
            ((Function0) r117.next()).invoke();
        L55:
            LynxAbilityImpl r118 = this.f182116a.O1().e().D0();
            JSONObject r119 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r119, LocationMonitorConst.IDENTIFIER, this.f182116a.a2().getSessionId());
            KtSafeMethodExtensionKt.safePut(r119, "hide", "1");
            Unit r120 = Unit.INSTANCE;
            r118.B("ecom_pdp_sku_panel_status_change", r119);
            return;
        L45:
            if (this.f182116a.f182114t.h0() == true) goto L47;
            this.f182116a.f182114t.f0();
        L41:
            r116 = null;
        L36:
            r114 = null;
            goto L37
        L58:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L28:
            r109 = 1;
            goto L29
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.d
        public final void d(JSONObject r210, vh3.a r211) {
            Intrinsics.checkNotNullParameter(r210, "params");
            Intrinsics.checkNotNullParameter(r211, "statusInfo");
            String r100 = r211.b();
            uh3.b r101 = r211.d();
            String r110 = null;
            if (r101 == null) goto L5;
            Long r102 = r101.d();
        L6:
            uh3.b r103 = r211.d();
            if (r103 == null) goto L9;
            Long r104 = r103.g();
        L10:
            uh3.b r105 = r211.d();
            if (r105 == null) goto L13;
            Long r111 = r105.b();
        L14:
            uh3.b r106 = r211.d();
            if (r106 == null) goto L18;
            String r107 = r106.c();
            if (r107 == null) goto L18;
        L19:
            ProductPriceInfo r108 = new ProductPriceInfo(r102, r104, new PromotionDiscountPrice(r111, null, r107, null, 10, null), null, null, 24, null);
            uh3.b r109 = r211.d();
            if (r109 == null) goto L24;
            uh3.a r112 = r109.a();
            if (r112 == null) goto L24;
            Object r113 = r112.a();
        L25:
            List<uh3.c> r114 = r211.f();
            if (r114 == null) goto L32;
            List<uh3.c> r115 = r114;
            ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
            Iterator<T> r117 = r115.iterator();
        L29:
            if (r117.hasNext() == false) goto L31;
            r116.add(((uh3.c) r117.next()).a());
            goto L29
        L31:
            String r118 = CollectionsKt.joinToString$default(r116, " ", null, null, 0, null, null, 62, null);
        L33:
            List<String> r119 = r211.c();
            int r120 = 0;
            if (r119 == null) goto L40;
            Object[] r121 = r119.toArray(new String[0]);
            if (r121 == null) goto L39;
            String[] r122 = (String[]) r121;
        L41:
            SkuProductDetailInfo r123 = new SkuProductDetailInfo(r100, r108, r113, r118, false, r122, false, 64, null);
            CommonMeta r124 = this.f182116a.b2();
            if (r124 == null) goto L44;
            List<SkuSpecInfo> r125 = r124.getSkuSpecInfo();
        L45:
            if (r125 == null) goto L74;
            CommonMeta r126 = this.f182116a.b2();
            if (r126 == null) goto L49;
            String r127 = r126.getChoosePanelText();
        L51:
            if (a2.b(r127) == false) goto L55;
            PdpSKUService r128 = this.f182116a;
            if (r128.f182108n == true) goto L55;
            r128.l(r123);
            return;
        L55:
            String[] r129 = r123.getSpecArray();
            if (r129 == null) goto L86;
            int r130 = r129.length;
            int r131 = 0;
        L58:
            if (r120 >= r130) goto L88;
            String r132 = r129[r120];
            int r133 = r131 + 1;
            SkuRestoreState r134 = this.f182116a.f182104j;
            if (r134 == null) goto L64;
            String[] r135 = r134.getSelectSkuKeys();
            if (r135 == null) goto L64;
            String r136 = (String) ArraysKt.getOrNull(r135, r131);
        L66:
            if ((!Intrinsics.areEqual(r136, r132)) == false) goto L73;
            PdpSKUService r137 = this.f182116a;
            SkuRestoreState r138 = r137.f182104j;
            if (r138 == null) goto L70;
            String[] r139 = r123.getSpecArray();
            Intrinsics.checkNotNull(r139);
            r138.setSelectSkuKeys(r139);
            Unit r140 = Unit.INSTANCE;
            r137.q(r138, !com.bytedance.android.ec.core.abtest.d.D());
        L71:
            this.f182116a.l(SkuProductDetailInfo.copy$default(r123, null, null, null, null, true, null, false, 111, null));
            goto L73
        L70:
            String[] r141 = r123.getSpecArray();
            Intrinsics.checkNotNull(r141);
            SkuRestoreState r142 = new SkuRestoreState(r141.length);
            String[] r143 = r123.getSpecArray();
            Intrinsics.checkNotNull(r143);
            r142.setSelectSkuKeys(r143);
            Unit r144 = Unit.INSTANCE;
            r137.q(r142, !com.bytedance.android.ec.core.abtest.d.D());
        L73:
            r120 = r120 + 1;
            r131 = r133;
            r123 = r123;
        L64:
            r136 = null;
            goto L66
        L88:
            return;
        L86:
            return;
        L49:
            r127 = null;
            goto L51
        L74:
            CommonMeta r145 = this.f182116a.b2();
            if (r145 == null) goto L78;
            r110 = r145.getChoosePanelText();
        L78:
            if (a2.b(r110) == false) goto L87;
            this.f182116a.l(r123);
            return;
        L87:
            return;
        L44:
            r125 = null;
            goto L45
        L39:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L40:
            r122 = null;
            goto L41
        L32:
            r118 = null;
        L24:
            r113 = null;
        L18:
            r107 = "";
            goto L19
        L13:
            r111 = null;
            goto L14
        L9:
            r104 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpSKUService f182117a;

        @Override // j73.m
        public final boolean I() {
            return this.f182117a.f182111q;
        }

        @Override // j73.m
        public final SkuRestoreState P() {
            return this.f182117a.f182104j;
        }

        @Override // j73.m
        public final boolean X() {
            return this.f182117a.f182108n;
        }

        @Override // j73.m
        public final void f0() {
            x r100 = this.f182117a.c2();
            if (r100 == null) goto L5;
            x.a.a(r100, false, "sku_select_finish", null, 28);
        L5:
            this.f182117a.f182109o = null;
        }

        @Override // j73.m
        public final boolean h0() {
            PdpSKUService r100 = this.f182117a;
            return Intrinsics.areEqual(r100.f182109o, r100.f182106l);
        }

        @Override // j73.m
        public final void v() {
            Iterator r100 = ((ArrayList) this.f182117a.f182113s).iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((Function0) r100.next()).invoke();
            goto L4
        }

        @Override // j73.m
        public final void z() {
            PdpSKUService r100 = this.f182117a;
            r100.f182109o = r100.f182106l;
        }

        public b(PdpSKUService r100) {
            this.f182117a = r100;
        }

        @Override // j73.m
        public final void S(String r110) {
            Intrinsics.checkNotNullParameter(r110, "specId");
            CommonMeta r100 = this.f182117a.b2();
            if (r100 == null) goto L34;
            List<SkuSpecInfo> r101 = r100.getSkuSpecInfo();
            if (r101 == null) goto L34;
            int r102 = r101.size();
            SkuRestoreState r103 = this.f182117a.f182104j;
            if (r103 == null) goto L21;
            String[] r104 = r103.getSelectSkuKeys();
            if (r104 != null) goto L11;
        L17:
            boolean r105 = true;
        L18:
            if (r105 == true) goto L20;
            r103.getSelectSkuKeys()[0] = r110;
        L20:
            Unit r106 = Unit.INSTANCE;
            q(r103, true);
            goto L34
        L11:
            if (r104.length != 0) goto L13;
            boolean r107 = true;
        L14:
            if (r107 == true) goto L17;
            r105 = false;
            goto L18
        L13:
            r107 = false;
            goto L14
        L21:
            SkuRestoreState r108 = new SkuRestoreState(r102);
            String[] r109 = r108.getSelectSkuKeys();
            if (r109 != null) goto L24;
        L30:
            boolean r111 = true;
        L31:
            if (r111 == true) goto L33;
            r108.getSelectSkuKeys()[0] = r110;
        L33:
            Unit r112 = Unit.INSTANCE;
            q(r108, true);
            goto L34
        L24:
            if (r109.length != 0) goto L26;
            boolean r113 = true;
        L27:
            if (r113 == true) goto L30;
            r111 = false;
            goto L31
        L26:
            r113 = false;
        L34:
            l(new SkuProductDetailInfo(null, new ProductPriceInfo(null, null, new PromotionDiscountPrice(null, null, null, null, 15, null), null, null, 24, null), null, null, true, null, false, 108, null));
        }

        @Override // j73.m
        public final void d0(int r100) {
            this.f182117a.f182112r = r100;
        }

        @Override // j73.m
        public final void e0(SkuRestoreState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f182117a.d2(r100, true);
        }

        @Override // j73.m
        public final void l(SkuProductDetailInfo r100) {
            this.f182117a.l(r100);
        }

        @Override // j73.m
        public final void n0(boolean r100) {
            this.f182117a.f182111q = false;
        }

        @Override // j73.m
        public final void F(String r100, a0 r101) {
            Intrinsics.checkNotNullParameter(r100, "skuSessionId");
            Intrinsics.checkNotNullParameter(r101, "params");
            c r102 = this.f182117a.f182110p;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("skuSchemaEventCenter");
        L5:
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "skuSessionId");
            Intrinsics.checkNotNullParameter(r101, "eventParams");
            if (r100.length() != 0) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == true) goto L13;
            r102.b("ecom.sku.buynow", (PdpSchemaSkuEventCenter$skuBuyNowJsEventSubscriber$2.a) r102.f182135f.getValue());
            r102.b("ecom.sku.show", (PdpSchemaSkuEventCenter$skuShowJsEventSubscriber$2.a) r102.f182132c.getValue());
            r102.b("ecom.sku.dismiss", (PdpSchemaSkuEventCenter$skuDismissJsEventSubscriber$2.a) r102.f182134e.getValue());
            r102.b("ecom.sku.spec.change", (PdpSchemaSkuEventCenter$skuSpecChangeJsEventSubscriber$2.a) r102.f182133d.getValue());
            r102.b("ecom.sku.add.cart", (PdpSchemaSkuEventCenter$skuAddCartJsEventSubscriber$2.a) r102.f182136g.getValue());
            r102.f182131b.put(r100, r101);
            return;
        L13:
            return;
        L8:
            r103 = false;
            goto L9
        }

        @Override // j73.m
        public final void q(SkuRestoreState r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f182117a.q(r100, r101);
        }
    }

    @Override // vg3.e0
    public final String H1() {
        SkuRestoreState r100 = this.f182104j;
        if (r100 == null) goto L7;
        String[] r101 = r100.getSelectSkuKeys();
        if (r101 == null) goto L7;
        return (String) ArraysKt.firstOrNull(r101);
    L7:
        return null;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(x.class);
    }

    public final x c2() {
        return (x) N1(x.class);
    }

    public PdpSKUService() {
        this.f182103i = LazyKt.lazy(PdpSKUService$skuRefreshAB$2.INSTANCE);
        this.f182105k = new LinkedHashSet();
        this.f182111q = true;
        this.f182113s = new ArrayList();
        this.f182114t = new b(this);
        this.f182115u = new a(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, e0.class, this, false, 12);
        Z1(x.class, new PdpSKUService$onAttach$1(this, null));
        O1().e().C1(new q(), true, new com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.b(this));
        this.f182110p = new c(O1().e(), this.f182115u);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        c r100 = this.f182110p;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("skuSchemaEventCenter");
    L5:
        g.c(r100.f182137h, "ecom.sku.buynow", (PdpSchemaSkuEventCenter$skuBuyNowJsEventSubscriber$2.a) r100.f182135f.getValue());
        g.c(r100.f182137h, "ecom.sku.show", (PdpSchemaSkuEventCenter$skuShowJsEventSubscriber$2.a) r100.f182132c.getValue());
        g.c(r100.f182137h, "ecom.sku.dismiss", (PdpSchemaSkuEventCenter$skuDismissJsEventSubscriber$2.a) r100.f182134e.getValue());
        g.c(r100.f182137h, "ecom.sku.spec.change", (PdpSchemaSkuEventCenter$skuSpecChangeJsEventSubscriber$2.a) r100.f182133d.getValue());
        g.c(r100.f182137h, "ecom.sku.add.cart", (PdpSchemaSkuEventCenter$skuAddCartJsEventSubscriber$2.a) r100.f182136g.getValue());
        Iterator r101 = ((LinkedHashMap) r100.f182130a).entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        Map.Entry r102 = (Map.Entry) r101.next();
        g.c(r100.f182137h, (String) r102.getKey(), (j) r102.getValue());
        goto L7
    L9:
        ((LinkedHashMap) r100.f182130a).clear();
        ((LinkedHashMap) r100.f182131b).clear();
    }

    @Override // vg3.e0
    public final List<SkuSpecInfo> Z0() {
        CommonMeta r100 = b2();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSkuSpecInfo();
    }

    public final CommonMeta b2() {
        x r100 = c2();
        if (r100 == null) goto L9;
        PdpDataStore r101 = r100.getData();
        if (r101 == null) goto L9;
        e<CommonMeta> r102 = r101.a();
        if (r102 == null) goto L9;
        return r102.a();
    L9:
        return null;
    }

    @Override // vg3.e0
    public final int G0() {
        return this.f182112r;
    }

    @Override // vg3.e0
    public final b b() {
        return this.f182114t;
    }

    @Override // vg3.e0
    public final SkuRestoreState g0() {
        return this.f182104j;
    }

    @Override // vg3.e0
    public final void f1(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        ((ArrayList) this.f182113s).add(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(SkuProductDetailInfo r110) {
        SkuProductDetailInfo r111 = r110;
        x r100 = c2();
        if (r100 == null) goto L9;
        PdpDataStore r101 = r100.getData();
        if (r101 == null) goto L9;
        e<CommonMeta> r102 = r101.a();
        if (r102 == null) goto L9;
        CommonMeta r103 = r102.a();
    L10:
        String r104 = "";
        if (r111 != null) goto L13;
    L35:
        int r105 = c0.f477247e;
        if (r111 != null) goto L38;
    L43:
        String r112 = null;
    L44:
        if (r112 != null) goto L46;
        r112 = "";
    L46:
        f.a.a(O1().e().r(), c0.a.a("SkuSpecifications", MapsKt.mapOf(TuplesKt.to("selected_specification", r112)), null, 10), new com.bytedance.android.ecom.arch.slice.action.c(null, null), true, 4);
    L47:
        SkuRestoreState r113 = this.f182104j;
        if (r113 == null) goto L52;
        String[] r114 = r113.getSelectSkuKeys();
        if (r114 == null) goto L52;
        String r115 = (String) ArraysKt.firstOrNull(r114);
    L53:
        if (r115 == null) goto L56;
        r104 = r115;
    L56:
        int r116 = c0.f477247e;
        SlcCommonAction r106 = c0.a.a("SkuPreview", MapsKt.mapOf(TuplesKt.to("spec_id", r104)), null, 10);
        SlcCommonAction r117 = c0.a.a("head_sku_info", MapsKt.mapOf(TuplesKt.to("spec_id", r104)), null, 10);
        f.a.a(O1().e().r(), r106, new com.bytedance.android.ecom.arch.slice.action.c(null, null), true, 4);
        f.a.a(O1().e().r(), r117, new com.bytedance.android.ecom.arch.slice.action.c(null, null), true, 4);
        return Unit.INSTANCE;
    L52:
        r115 = null;
        goto L53
    L38:
        if (com.bytedance.android.ec.model.m.a(r111.getSkuPrice()) == true) goto L41;
        r111 = null;
    L41:
        if (r111 == null) goto L43;
        r112 = r111.getSkuName();
        goto L44
    L13:
        if (r111.isSkuInfo() != true) goto L35;
        if (r103 == null) goto L19;
        List<SkuSpecInfo> r107 = r103.getSkuSpecInfo();
        if (r107 == null) goto L19;
        if (r107.isEmpty() == true) goto L35;
    L19:
        if (r103 == null) goto L47;
        SkuRestoreState r118 = this.f182104j;
        if (r118 == null) goto L23;
        String[] r119 = r118.getSelectSkuKeys();
    L24:
        String r120 = h73.a.e(r103, r119);
        if (r120 == null) goto L47;
        SkuRestoreState r108 = this.f182104j;
        if (r108 == null) goto L29;
        Boolean r109 = Boolean.valueOf(r108.hasSelectedSku());
    L30:
        int r121 = c0.f477247e;
        if (Intrinsics.areEqual(r109, Boolean.TRUE) == true) goto L34;
        r120 = "";
    L34:
        f.a.a(O1().e().r(), c0.a.a("SkuSpecifications", MapsKt.mapOf(TuplesKt.to("selected_specification", r120)), null, 10), new com.bytedance.android.ecom.arch.slice.action.c(null, null), true, 4);
        goto L47
    L29:
        r109 = null;
        goto L30
    L23:
        r119 = null;
    L9:
        r103 = null;
        goto L10
    }

    @Override // vg3.e0
    public final void l(SkuProductDetailInfo r100) {
        CommonMeta r101 = b2();
        if (r101 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r101.getEnablePDPOptimize());
    L7:
        if (k.i(r102) == false) goto L13;
        Iterator<T> r103 = this.f182105k.iterator();
    L10:
        if (r103.hasNext() == false) goto L44;
        ((Function1) r103.next()).invoke(r100);
        goto L10
    L44:
        return;
    L13:
        if (r100 != null) goto L15;
    L20:
        if (r100 == null) goto L33;
        String r104 = r100.getSkuBigImageUrl();
        if (r104 == null) goto L33;
        if (a2.b(r104) != true) goto L33;
        if (com.bytedance.android.ec.model.m.a(r100.getSkuPrice()) == false) goto L33;
        Iterator<T> r105 = this.f182105k.iterator();
    L29:
        if (r105.hasNext() == false) goto L31;
        ((Function1) r105.next()).invoke(r100);
        goto L29
    L31:
        this.f182107m = true;
        return;
    L33:
        if (this.f182107m == false) goto L43;
        this.f182107m = false;
        Iterator<T> r106 = this.f182105k.iterator();
    L36:
        if (r106.hasNext() == false) goto L46;
        ((Function1) r106.next()).invoke(null);
        goto L36
    L46:
        return;
    L43:
        return;
    L15:
        if (r100.isSkuInfo() != true) goto L20;
        Iterator<T> r107 = this.f182105k.iterator();
    L18:
        if (r107.hasNext() == false) goto L45;
        ((Function1) r107.next()).invoke(r100);
        goto L18
    L45:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // vg3.e0
    public final void u(Function1<? super SkuProductDetailInfo, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f182105k.add(r100);
    }

    public final void d2(SkuRestoreState r100, boolean r101) {
        CommonMeta r102 = b2();
        boolean r103 = false;
        if (this.f182104j != null) goto L21;
        if (r102 == null) goto L21;
        List<SkuSpecInfo> r104 = r102.getSkuSpecInfo();
        if (r104 == null) goto L21;
        if (r104.size() != r100.getSelectSkuKeys().length) goto L21;
        List<SkuSpecInfo> r105 = Z0();
        if (r105 == null) goto L21;
        Iterator<T> r106 = r105.iterator();
        int r107 = 0;
    L13:
        if (r106.hasNext() == false) goto L21;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        SkuSpecInfo r110 = (SkuSpecInfo) r108;
        if (com.bytedance.android.shopping.anchorv3.a.b(r110.getSelectSpecId()) == false) goto L20;
        r100.getSelectSkuKeys()[r107] = r110.getSelectSpecId();
        this.f182106l = r100.joinedKey();
    L20:
        r107 = r109;
    L21:
        this.f182104j = r100;
        CommonMeta r111 = b2();
        String r112 = r100.joinedKey();
        if (Intrinsics.areEqual(this.f182106l, r112) == false) goto L24;
    L27:
        r103 = true;
    L28:
        this.f182106l = r112;
        if (r103 == false) goto L31;
        return;
    L31:
        if (r111 == null) goto L33;
        String r113 = r111.getForbidSkuSwitch();
    L35:
        if (Intrinsics.areEqual(r113, "1") == false) goto L37;
        return;
    L37:
        if (((Boolean) this.f182103i.getValue()).booleanValue() == false) goto L53;
        if (r101 == true) goto L41;
        return;
    L41:
        if (com.bytedance.android.ec.core.abtest.d.D() == false) goto L43;
        String r114 = "sku_select_finish";
    L44:
        x r115 = c2();
        if (r115 == null) goto L54;
        x.a.a(r115, true, r114, null, 28);
        return;
    L54:
        return;
    L43:
        r114 = "sku_select";
        goto L44
    L53:
        return;
    L33:
        r113 = null;
        goto L35
    L24:
        if (this.f182106l != null) goto L28;
        if (Intrinsics.areEqual(r112, "") == false) goto L28;
        goto L27
    }

    @Override // vg3.e0
    public final void q(SkuRestoreState r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        r100.setSelectedSkuId(null);
        d2(r100, r101);
    }
}
