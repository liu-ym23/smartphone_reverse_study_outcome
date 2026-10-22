package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.n;
import com.bytedance.android.ecom.arch.slice.p;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.topnav.AnchorV4TopNavComponent;
import com.bytedance.android.shopping.anchorv4.topnav.Config;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import com.bytedance.android.shopping.anchorv4.topnav.TransitionNode;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.l;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.google.gson.internal.LinkedTreeMap;
import com.larus.nova.R;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vg3.d0;
import vg3.e0;
import vg3.i0;
import vg3.n0;
import vg3.s;
import vg3.w;
import vg3.y;

/* JADX INFO: loaded from: classes13.dex */
public final class TopNavigationComponentV2 extends m implements l, i0 {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TopNavVO f181194m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ComponentIDs f181195n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Float f181196o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f181197p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<n0> f181198q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g> f181199r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g f181200s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final IdentityHashMap<com.bytedance.android.ecom.arch.slice.g, com.bytedance.android.ecom.arch.slice.h> f181201t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f181202u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<String, Object> f181203v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f181204w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a f181205x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f181206y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.e f181207z;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TopNavigationComponentV2 f181208c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TopNavVO f181209d;

        @Override // java.lang.Runnable
        public final void run() {
            this.f181208c.i2(this.f181209d);
        }

        public a(TopNavigationComponentV2 r100, TopNavVO r101) {
            this.f181208c = r100;
            this.f181209d = r101;
            super("bind_top_nav");
        }
    }

    public static final class b implements j73.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopNavigationComponentV2 f181210a;

        @Override // j73.g
        public final void h(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "extraElementId");
        }

        @Override // j73.g
        public final Boolean i() {
            return null;
        }

        @Override // j73.g
        public final Boolean d() {
            TopNavVO r100 = this.f181210a.f181194m;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.isDisplayShareTouchPoint();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r15v0, types: [java.util.Map] */
        @Override // j73.g
        public final Pair<com.bytedance.android.shopping.anchorv3.i, com.bytedance.android.shopping.anchorv3.widget.f> r0() {
            com.bytedance.android.shopping.anchorv3.i r100 = (com.bytedance.android.shopping.anchorv3.i) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) ((PdpDataStore) this.f181210a.O1().d().getData()).f181900j.getValue()).a();
            CommonMeta r101 = ((PdpDataStore) this.f181210a.O1().d().getData()).a().a();
            boolean r102 = true;
            Object r103 = null;
            if (r101 == null) goto L8;
            if (r101.getProductDeleted() != true) goto L8;
        L32:
            return new Pair(r100, r103);
        L8:
            if (r101 == null) goto L10;
            Boolean r104 = Boolean.valueOf(r101.isLuban());
        L11:
            if (r101 == null) goto L13;
            Boolean r105 = Boolean.valueOf(r101.getThirdParty());
        L14:
            if (r101 == null) goto L16;
            String r106 = r101.getProductId();
        L17:
            Boolean r107 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.f181210a.O1())).f181849b.f181038d.a();
            if (r107 == null) goto L20;
            r102 = r107.booleanValue();
        L20:
            Boolean r110 = Boolean.valueOf(r102);
            if (r101 == null) goto L23;
            String r111 = r101.getSourcePage();
        L25:
            if (r101 == null) goto L27;
            String r112 = r101.getSearchPageSchema();
        L28:
            if (r101 == null) goto L30;
            r103 = r101.getSearchPageParams();
        L30:
            r103 = new com.bytedance.android.shopping.anchorv3.widget.f(r104, r105, r106, r110, r111, null, null, r112, r103, 224);
            goto L32
        L27:
            r112 = null;
            goto L28
        L23:
            r111 = null;
            goto L25
        L16:
            r106 = null;
            goto L17
        L13:
            r105 = null;
            goto L14
        L10:
            r104 = null;
            goto L11
        }

        @Override // j73.g
        public final boolean u() {
            Object r100 = this.f181210a.f181203v.get("collected");
            if ((r100 instanceof Boolean) == true) goto L6;
            r100 = null;
        L6:
            return Intrinsics.areEqual((Boolean) r100, Boolean.TRUE);
        }

        public b(TopNavigationComponentV2 r100) {
            this.f181210a = r100;
        }

        @Override // j73.g
        public final void C(String r100) {
            Intrinsics.checkNotNullParameter(r100, "groupId");
            this.f181210a.p2(r100, true);
        }

        @Override // j73.g
        public final void N(int r100) {
            TopNavigationComponentV2 r101 = this.f181210a;
            TopNavVO r102 = r101.f181194m;
            if (r102 == null) goto L7;
            com.bytedance.android.ecom.arch.slice.g r103 = r102.getTopSlice();
            if (r103 == null) goto L7;
            String r104 = r103.getSliceId();
        L9:
            if (TextUtils.equals(r104, "supermarket_pop_top_nav") == false) goto L42;
            TopNavVO r105 = r101.f181194m;
            if (r105 == null) goto L24;
            com.bytedance.android.ecom.arch.slice.g r106 = r105.getTopSlice();
            if (r106 == null) goto L24;
            Map<String, Object> r107 = r106.getData();
            if (r107 == null) goto L24;
            Object r108 = r107.get("cart_num");
            if (r108 == null) goto L24;
            String r109 = r108.toString();
            if (r109 == null) goto L24;
            Double r110 = StringsKt.toDoubleOrNull(r109);
            if (r110 == null) goto L24;
            int r111 = (int) r110.doubleValue();
        L25:
            if (r100 == r111) goto L43;
            LinkedHashMap r112 = new LinkedHashMap();
            if (r111 != 0) goto L31;
            if (r100 <= 0) goto L31;
            int r113 = 1;
        L35:
            r112.put("cart_num", Integer.valueOf(r100));
            r112.put("animation_type", Integer.valueOf(r113));
            TopNavVO r114 = r101.f181194m;
            if (r114 == null) goto L40;
            com.bytedance.android.ecom.arch.slice.g r115 = r114.getTopSlice();
            if (r115 == null) goto L40;
            com.bytedance.android.ecom.arch.slice.g.a.a(r115, r112, false, 6);
        L40:
            r101.h2(null);
            return;
        L31:
            if (r111 <= 0) goto L34;
            if (r100 != 0) goto L34;
            r113 = 2;
        L34:
            r113 = 0;
            goto L35
        L43:
            return;
        L24:
            r111 = 0;
            goto L25
        L42:
            return;
        L7:
            r104 = null;
            goto L9
        }

        @Override // j73.g
        public final void s(boolean r110) {
            TopNavigationComponentV2 r100 = this.f181210a;
            boolean r101 = true;
            r100.f181202u = true;
            r100.f181203v.put("collected", Boolean.valueOf(r110));
            View r102 = null;
            this.f181210a.h2(null);
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.e r103 = this.f181210a.f181207z;
            if (r103 == null) goto L29;
            FrameLayout r104 = r103.f181247b;
            if (r104 != null) goto L7;
        L15:
            View r105 = null;
        L17:
            if ((r105 instanceof ECDraweeView) == false) goto L20;
            r102 = r105;
        L20:
            ECDraweeView r106 = (ECDraweeView) r102;
            if (r106 == null) goto L30;
            if (r110 == false) goto L24;
            String r111 = r103.f181249d;
        L25:
            String r107 = r111;
            if (r107 == null) goto L31;
            h0.e(r106, r107, null, null, null, 120);
            return;
        L31:
            return;
        L24:
            r111 = r103.f181248c;
            goto L25
        L30:
            return;
        L7:
            if (r104.getChildCount() > 0) goto L10;
            r101 = false;
        L10:
            if (r101 == true) goto L13;
            r104 = null;
        L13:
            if (r104 == null) goto L15;
            r105 = r104.getChildAt(0);
            goto L17
        }
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopNavigationComponentV2 f181211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f181212b;

        public c(TopNavigationComponentV2 r100, Function1 r101) {
            this.f181211a = r100;
            this.f181212b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            this.f181212b.invoke(new Rect(this.f181211a.e2().getLeft(), this.f181211a.e2().getTop(), this.f181211a.e2().getRight(), this.f181211a.e2().getBottom()));
        }
    }

    public static final class d<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopNavigationComponentV2 f181213a;

        public d(TopNavigationComponentV2 r100) {
            this.f181213a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r100) {
            TopNavVO r101 = (TopNavVO) r100;
            if (r101 == null) goto L23;
            y r102 = (y) this.f181213a.N1(y.class);
            if (r102 == null) goto L10;
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r103 = r102.V();
            if (r103 == null) goto L10;
            r103.h();
        L10:
            this.f181213a.h2(r101);
            TopNavigationComponentV2 r104 = this.f181213a;
            r104.getClass();
            final com.bytedance.android.ecom.arch.slice.g r105 = r101.getTopSlice();
            if (r105 == null) goto L13;
            r104.n2(r105);
            r104.O1().e().r().p("top_nav", new TopNavigationComponentV2$addExtraSlices$1$1(r105));
        L13:
            TopNavigationComponentV2 r106 = this.f181213a;
            if (r106.f181204w == true) goto L16;
            r106.f181204w = true;
            r106.O1().b().n0(new TopNavigationComponentV2$processShareButton$1(r106, r101));
        L16:
            if (r102 == null) goto L21;
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r107 = r102.V();
            if (r107 == null) goto L22;
            r107.i();
            return;
        L22:
            return;
        L21:
            return;
        }
    }

    public static final class e<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopNavigationComponentV2 f181214a;

        public e(TopNavigationComponentV2 r100) {
            this.f181214a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r100) {
            com.bytedance.android.shopping.anchorv4.vm.a r101 = (com.bytedance.android.shopping.anchorv4.vm.a) r100;
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L9:
            if ((true ^ Intrinsics.areEqual(Boolean.valueOf(r102), this.f181214a.f181203v.get("collapsed"))) == false) goto L12;
            this.f181214a.f181203v.put("collapsed", Boolean.valueOf(r102));
            this.f181214a.h2(null);
            return;
        L12:
            return;
        L5:
            if (r101.f167729a != true) goto L7;
            r102 = true;
            goto L9
        }
    }

    public static final class f<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopNavigationComponentV2 f181215a;

        public f(TopNavigationComponentV2 r100) {
            this.f181215a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r100) {
            com.bytedance.android.shopping.anchorv3.i r101 = (com.bytedance.android.shopping.anchorv3.i) r100;
            if (r101 == null) goto L28;
            this.f181215a.f181203v.put(Keys.API_PARAM_KEY_SEARCH_KEY, r101.f165115a);
            CommonMeta r102 = null;
            this.f181215a.h2(null);
            TopNavigationComponentV2 r103 = this.f181215a;
            PageMeta r104 = (PageMeta) r103.O1().d().getData().f181892b.a();
            if (r104 == null) goto L7;
            r102 = r104.getCommonMeta();
        L7:
            if (r102 == null) goto L29;
            String r105 = r102.getProductId();
            if (r105 == null) goto L34;
            LinkedTreeMap<String, Object> r106 = r104.getTrackMeta();
            if (r106 == null) goto L17;
            Object r107 = r106.get("page_name");
            if (r107 == null) goto L17;
            String r108 = r107.toString();
            if (r108 == null) goto L17;
        L18:
            String r109 = r108 + "_" + r102.getSourcePage();
            if (Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r103.O1())).f181849b.f181038d.a(), Boolean.TRUE) == false) goto L30;
            w r110 = (w) r103.N1(w.class);
            if (r110 == null) goto L31;
            ProductDetailEventService.b r111 = r110.m();
            if (r111 == null) goto L32;
            com.bytedance.android.shopping.prepurchase.arch.container.ability.m r112 = r111.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("words_source", "search_bar_outer"), TuplesKt.to("words_content", r101.f165115a), TuplesKt.to("impr_id", r101.f165117c), TuplesKt.to("enter_from", "search_product_detail"), TuplesKt.to(ECFindSimilarConfig.ENTER_FROM_SECOND, r109), TuplesKt.to("group_id", r101.f165116b), TuplesKt.to("from_gid", r105), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_GROUP_ID, r105)}));
            if (r112 == null) goto L33;
            com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r112, "trending_words_show", false, null, null, 12);
            return;
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L17:
            r108 = "";
            goto L18
        L34:
            return;
        L29:
            return;
        }
    }

    public static final class g<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopNavigationComponentV2 f181216a;

        public g(TopNavigationComponentV2 r100) {
            this.f181216a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r100) {
            float r101 = ((Number) r100).floatValue();
            this.f181216a.m2(r101);
        }
    }

    public static final class h<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopNavigationComponentV2 f181217a;

        public h(TopNavigationComponentV2 r100) {
            this.f181217a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r100) {
            n0 r101 = (n0) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.f554691c == false) goto L8;
            d0 r102 = (d0) this.f181217a.N1(d0.class);
            if (r102 == null) goto L9;
            r102.scrollTo(r101.f554690b);
            return;
        L9:
            return;
        }
    }

    public static final class i extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TopNavigationComponentV2 f181218c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f181218c.o2();
        }

        public i(TopNavigationComponentV2 r100) {
            this.f181218c = r100;
            super("top_nav_show_action");
        }
    }

    public static final class j implements com.bytedance.android.ecom.arch.slice.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopNavigationComponentV2 f181219a;

        public j(TopNavigationComponentV2 r100) {
            this.f181219a = r100;
        }

        @Override // com.bytedance.android.ecom.arch.slice.h
        public final void f1(boolean r100) {
            this.f181219a.h2(null);
        }
    }

    public static float k2(float r100) {
        if (r100 > 0) goto L7;
        return 0.0f;
    L7:
        if (r100 < 1) goto L10;
        return 1.0f;
    L10:
        return 0.5f;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{d0.class, vg3.l.class, w.class, w.class, e0.class, s.class});
    }

    @Override // vg3.i0
    public final void h(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "extraElementId");
    }

    @Override // vg3.i0
    public final Boolean i() {
        return null;
    }

    @Override // vg3.i0
    public final View N() {
        IAction r100 = null;
        if (this.f181207z != null) goto L11;
        Context r101 = e2().getContext();
        TopNavVO r102 = this.f181194m;
        if (r102 == null) goto L9;
        com.bytedance.android.ecom.arch.slice.g r103 = r102.getTopSlice();
        if (r103 == null) goto L9;
        Map<String, Object> r104 = r103.getData();
    L10:
        this.f181207z = new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.e(r101, r104, Boolean.valueOf(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181035a), new TopNavigationComponentV2$provideTopRightViews$1(this), new TopNavigationComponentV2$provideTopRightViews$2(this));
    L9:
        r104 = null;
    L11:
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.e r105 = this.f181207z;
        if (r105 == null) goto L58;
        LinearLayout r106 = r105.f181246a;
        if (r106 != null) goto L16;
    L17:
        int r107 = com.bytedance.android.shopping.utils.y.f187160a;
        float r108 = com.bytedance.android.shopping.extensions.b.d(Integer.valueOf(com.bytedance.android.shopping.utils.y.e(null, r105.f181252g, 1))) / 390.0f;
        int r109 = com.bytedance.android.shopping.extensions.b.a(Float.valueOf(30 * r108));
        int r110 = com.bytedance.android.shopping.extensions.b.a(Float.valueOf(38 * r108));
        Context r111 = r105.f181250e;
        int r112 = AnchorV4TopNavComponent.f167444q;
        List r113 = AnchorV4TopNavComponent.b.a(r105.f181251f);
        if (r113 == null) goto L66;
        Iterator r114 = r113.iterator();
    L21:
        if (r114.hasNext() == false) goto L66;
        Map r115 = (Map) r114.next();
        if (Intrinsics.areEqual(r115.get("show_in_comment"), Boolean.TRUE) == false) goto L56;
        Object r116 = r115.get("btn_id");
        if ((r116 instanceof String) == true) goto L27;
        r116 = r100;
    L27:
        String r117 = (String) r116;
        Object r118 = r115.get("black_icon");
        if ((r118 instanceof String) == true) goto L30;
        r118 = r100;
    L30:
        String r119 = (String) r118;
        Object r120 = r115.get("collected_black_icon");
        if ((r120 instanceof String) == true) goto L33;
        r120 = r100;
    L33:
        String r121 = (String) r120;
        Object r122 = r115.get("click_action");
        if (r122 == null) goto L36;
        IAction r123 = n.a(r122);
    L37:
        if (r119 == null) goto L56;
        if (r123 == null) goto L56;
        if (Intrinsics.areEqual(r117, "collect_btn") == false) goto L45;
        r105.f181248c = r119;
        r105.f181249d = r121;
        if (r105.f181253h.invoke().booleanValue() == false) goto L45;
        if (r121 == null) goto L45;
        String r124 = r121;
    L47:
        if (r105.f181246a != null) goto L50;
        LinearLayout r125 = new LinearLayout(r105.f181250e);
        r125.setOrientation(0);
        r125.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        r125.setGravity(16);
        Unit r126 = Unit.INSTANCE;
        r105.f181246a = r125;
    L50:
        FrameLayout r127 = new FrameLayout(r111);
        ECDraweeView r128 = new ECDraweeView(r111, null, 0, 6, null);
        h0.e(r128, r124, null, null, null, 120);
        FrameLayout.LayoutParams r129 = new FrameLayout.LayoutParams(r109, r109);
        r129.gravity = 17;
        Unit r130 = Unit.INSTANCE;
        r128.setLayoutParams(r129);
        r127.addView(r128);
        r127.setOnClickListener(new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.d(r127, r123, r105));
        LinearLayout r131 = r105.f181246a;
        if (r131 == null) goto L54;
        r131.addView(r127, r110, r110);
    L54:
        if (Intrinsics.areEqual(r117, "collect_btn") == false) goto L56;
        r105.f181247b = r127;
    L45:
        r124 = r119;
        goto L47
    L36:
        r123 = r100;
    L56:
        r100 = null;
    L66:
        return r105.f181246a;
    L16:
        if (r106.getChildCount() != 0) goto L66;
    L58:
        return null;
    }

    @Override // vg3.i0
    public final void R0() {
        this.f181203v.put("cart_animating", Boolean.TRUE);
        h2(null);
        this.f181203v.put("cart_animating", Boolean.FALSE);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.l
    public final void b1() {
        Float r100 = this.f181196o;
        if (r100 == null) goto L5;
        m2(r100.floatValue());
    L5:
        l2(this.f181197p);
        if (PdpPerfOpt.b().e() == false) goto L8;
        O1().b().e1(new i(this));
        return;
    L8:
        o2();
    }

    public final void j2() {
        Iterator<T> r100 = this.f181201t.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.ecom.arch.slice.g) r100.next()).setSliceRebindTarget(null);
        goto L4
    L6:
        this.f181201t.clear();
    }

    public final void o2() {
        TopNavVO r100 = this.f181194m;
        if (r100 == null) goto L7;
        com.bytedance.android.ecom.arch.slice.g r101 = r100.getTopSlice();
        if (r101 == null) goto L7;
        IAction r102 = r101.getShowAction();
    L8:
        View r103 = e2();
        if (r102 == null) goto L13;
        if (r103 == null) goto L14;
        O1().e().r().O0(null, r102, r103, null);
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public TopNavigationComponentV2() {
        this.f181195n = ComponentIDs.HEAD_SLIDES;
        this.f181198q = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        this.f181201t = new IdentityHashMap();
        Boolean r100 = Boolean.FALSE;
        this.f181203v = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("collapsed", r100), TuplesKt.to("current_tab_index", 0), TuplesKt.to("closed_sku", r100), TuplesKt.to("collected", r100), TuplesKt.to("is_android", Boolean.TRUE), TuplesKt.to("tab_visible", r100), TuplesKt.to("scroll_fraction", Float.valueOf(0.0f))});
        this.f181206y = new b(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        float r100 = 0.0f;
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181848a.getNativeParams().getFullMode() == true) goto L5;
        this.f181196o = Float.valueOf(0.0f);
    L5:
        Map<String, Object> r101 = this.f181203v;
        r101.put("current_group_id", this.f181195n);
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181848a.getNativeParams().getFullMode() == false) goto L8;
        r100 = 1.0f;
    L8:
        r101.put("trans_fraction", Float.valueOf(r100));
        FragmentActivity r102 = O1().getContainerAbility().getContext();
        boolean r103 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181035a;
        if (r102 == null) goto L13;
        com.bytedance.android.shopping.anchorv4.helper.w.f166998b.getClass();
        if (com.bytedance.android.shopping.anchorv4.helper.w.a.b(r102, r103) == false) goto L13;
        int r104 = com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(com.bytedance.android.shopping.utils.d0.a()));
        r101.put("status_bar_height", Integer.valueOf(r104 + 6));
        float r105 = r104;
        r101.put("status_bar_scale_height", Float.valueOf(r105 + (28 - (22 * O1().e().r().b1()))));
    L13:
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r106 = this.f181200s;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L16:
        r106.setOnViewReadyCallback(this);
        AbsComponent.Y1(this, i0.class, this, false, 12);
        PdpDataStore r107 = O1().d().getData();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r107.f181895e.getValue(), this, new d(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r107.f181896f.getValue(), this, new e(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r107.f181900j.getValue(), this, new f(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181037c, this, new g(this));
        Z1(d0.class, new TopNavigationComponentV2$onAttach$5(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(this.f181198q, this, new h(this));
        Z1(e0.class, new TopNavigationComponentV2$onAttach$7(this, null));
        Z1(s.class, new TopNavigationComponentV2$onAttach$8(this, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        j2();
        super.U1();
    }

    @Override // vg3.i0
    public final Rect a1() {
        View r100 = e2();
        return new Rect(r100.getLeft(), r100.getTop(), r100.getLeft() + r100.getWidth(), r100.getTop() + r100.getHeight());
    }

    @Override // vg3.i0
    public final View getContentView() {
        return e2();
    }

    @Override // vg3.i0
    public final j73.g b() {
        return this.f181206y;
    }

    @Override // vg3.i0
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d q1() {
        return this.f181198q;
    }

    @Override // vg3.i0
    public final com.bytedance.android.shopping.prepurchase.business.pdp.view.i H(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sliceKey");
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r101 = this.f181200s;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L5:
        View r102 = r101.a(r100);
        if (r102 != null) goto L10;
        return null;
    L10:
        return new com.bytedance.android.shopping.prepurchase.business.pdp.view.n(r102);
    }

    @Override // vg3.i0
    public final View K(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r101 = this.f181200s;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L6:
        return r101.a(r100);
    }

    public final void h2(TopNavVO r100) {
        if (PdpPerfOpt.b().m(1) == true) goto L5;
    L10:
        i2(r100);
        return;
    L5:
        if (g2().getNativeParams().getFullMode() == true) goto L10;
        a r101 = this.f181205x;
        if (r101 == null) goto L9;
        r101.f180704a.set(true);
    L9:
        a r102 = new a(this, r100);
        O1().b().e1(r102);
        Unit r103 = Unit.INSTANCE;
        this.f181205x = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i2(TopNavVO r100) {
        PdpDataStore r101 = O1().d().getData();
        boolean r102 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r100 == null) goto L24;
        TopNavVO r104 = this.f181194m;
        if (r104 == null) goto L23;
        com.bytedance.android.ecom.arch.slice.g r105 = r104.getTopSlice();
        if (r105 == null) goto L23;
        if (r105 == r100.getTopSlice()) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == true) goto L21;
        r105 = null;
    L21:
        if (r105 == null) goto L23;
        j2();
        goto L23
    L17:
        r106 = false;
    L23:
        this.f181194m = r100;
    L24:
        TopNavVO r107 = this.f181194m;
        if (r107 == null) goto L29;
        com.bytedance.android.ecom.arch.slice.g r108 = r107.getTopSlice();
        if (r108 == null) goto L29;
        n2(r108);
    L29:
        if (r103 == false) goto L38;
        com.bytedance.android.shopping.anchorv4.vm.a r109 = (com.bytedance.android.shopping.anchorv4.vm.a) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r101.f181896f.getValue()).a();
        Map<String, Object> r110 = this.f181203v;
        if (r109 != null) goto L33;
    L35:
        boolean r111 = false;
    L36:
        r110.put("collapsed", Boolean.valueOf(r111));
        goto L38
    L33:
        if (r109.f167729a != true) goto L35;
        r111 = true;
    L38:
        if (this.f181202u == true) goto L45;
        Map<String, Object> r112 = this.f181203v;
        CommonMeta r113 = r101.a().a();
        if (r113 != null) goto L42;
    L44:
        r112.put("collected", Boolean.valueOf(r102));
        goto L45
    L42:
        if (r113.isCollected() != true) goto L44;
        r102 = true;
    L45:
        Map<String, ? extends Object> r114 = MapsKt.mapOf(TuplesKt.to("native", this.f181203v));
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r115 = this.f181200s;
        if (r115 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L48:
        TopNavVO r116 = this.f181194m;
        if (r116 == null) goto L51;
        com.bytedance.android.ecom.arch.slice.g r117 = r116.getTopSlice();
    L52:
        r115.b(r117, r114, null);
        return;
    L51:
        r117 = null;
        goto L52
    L5:
        if (this.f181194m != null) goto L7;
        r103 = true;
        goto L9
    }

    @Override // vg3.i0
    public final void j0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        TopNavVO r101 = this.f181194m;
        if (r101 == null) goto L7;
        com.bytedance.android.ecom.arch.slice.g r102 = r101.getTopSlice();
        if (r102 == null) goto L7;
        Map<String, Object> r103 = r102.getData();
    L8:
        if (r103 == null) goto L10;
        Object r104 = r103.get("nav");
    L12:
        if ((r104 instanceof Map) == true) goto L14;
        r104 = null;
    L14:
        Map r105 = (Map) r104;
        if (r105 == null) goto L17;
        Object r106 = r105.get("right_btns");
    L19:
        if ((r106 instanceof List) == true) goto L21;
        r106 = null;
    L21:
        List r107 = (List) r106;
        if (r107 == null) goto L45;
        Iterator r108 = r107.iterator();
    L25:
        if (r108.hasNext() == false) goto L32;
        Object r109 = r108.next();
        Object r110 = ((Map) r109).get("btn_id");
        if ((r110 instanceof String) == true) goto L30;
        r110 = null;
    L30:
        if (Intrinsics.areEqual((String) r110, "share_btn") == false) goto L25;
    L33:
        Map r111 = (Map) r109;
        if (r111 == null) goto L46;
        Object r112 = r111.get("click_action");
        if (r112 == null) goto L38;
        IAction r113 = n.a(r112);
    L39:
        if (r113 == null) goto L47;
        O1().e().r().O0(null, r113, r100, MapsKt.mapOf(TuplesKt.to("location", "gallery")));
        return;
    L47:
        return;
    L38:
        r113 = null;
        goto L39
    L46:
        return;
    L32:
        r109 = null;
        goto L33
    L45:
        return;
    L17:
        r106 = null;
        goto L19
    L10:
        r104 = null;
    L7:
        r103 = null;
        goto L8
    }

    public final void l2(int r110) {
        this.f181197p = r110;
        float r100 = r110;
        vg3.l r101 = (vg3.l) N1(vg3.l.class);
        float r102 = 0.0f;
        if (r101 == null) goto L5;
        float r103 = r101.B1();
    L6:
        float r104 = r100 / r103;
        TopNavVO r105 = this.f181194m;
        if (r105 == null) goto L11;
        Config r106 = r105.getConfig();
        if (r106 == null) goto L11;
        List<TransitionNode> r107 = r106.getScrollNodes();
    L12:
        q2(r107, r104);
        TopNavVO r108 = this.f181194m;
        if (r108 == null) goto L17;
        Config r109 = r108.getConfig();
        if (r109 == null) goto L17;
        List<TransitionNode> r111 = r109.getSpecialScrollNodes();
    L19:
        if (r111 == null) goto L38;
        Iterator<T> r112 = r111.iterator();
    L22:
        if (r112.hasNext() == false) goto L38;
        TransitionNode r113 = (TransitionNode) r112.next();
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r114 = this.f181200s;
        if (r114 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L26:
        View r115 = r114.a(r113.getSliceKey());
        if (r115 == null) goto L22;
        if (r110 < com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r113.getStartEdge()))) goto L34;
        if (r110 > com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r113.getEndEdge()))) goto L34;
        float r116 = (r100 - com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r113.getStartEdge()))) / (com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r113.getEndEdge())) - com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r113.getStartEdge())));
    L37:
        r115.setAlpha(r116);
    L34:
        if (r110 >= com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r113.getStartEdge()))) goto L36;
        r116 = 0.0f;
        goto L37
    L36:
        com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r113.getEndEdge()));
        r116 = 1.0f;
    L38:
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r117 = this.f181200s;
        if (r117 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L41:
        View r118 = r117.a("tab_bar");
        boolean r119 = true;
        if (r118 != null) goto L44;
    L50:
        boolean r120 = false;
    L51:
        float r121 = k2(r104);
        Object r122 = this.f181203v.get("scroll_fraction");
        if ((r122 instanceof Float) == true) goto L54;
        r122 = null;
    L54:
        Float r123 = (Float) r122;
        if (r123 == null) goto L57;
        float r124 = r123.floatValue();
    L59:
        if (r121 == k2(r124)) goto L68;
        Map<String, Object> r125 = this.f181203v;
        if (r104 > 0) goto L64;
    L67:
        r125.put("scroll_fraction", Float.valueOf(r102));
    L69:
        if (r119 == false) goto L77;
        h2(null);
        return;
    L77:
        return;
    L64:
        if (r104 < 1) goto L66;
        r102 = 1.0f;
        goto L67
    L66:
        r102 = r104;
        goto L67
    L68:
        r119 = r120;
        goto L69
    L57:
        r124 = 0.0f;
        goto L59
    L44:
        if (r118.getAlpha() <= 0) goto L46;
        boolean r126 = true;
    L48:
        if ((!Intrinsics.areEqual(Boolean.valueOf(r126), this.f181203v.get("tab_visible"))) == false) goto L50;
        this.f181203v.put("tab_visible", Boolean.valueOf(r126));
        r120 = true;
        goto L51
    L46:
        r126 = false;
    L17:
        r111 = null;
    L11:
        r107 = null;
        goto L12
    L5:
        r103 = 0.0f;
        goto L6
    }

    public final void m2(float r100) {
        this.f181196o = Float.valueOf(r100);
        boolean r101 = false;
        float r102 = 0;
        if (r100 <= r102) goto L7;
        a r103 = this.f181205x;
        if (r103 == null) goto L7;
        r103.run();
    L7:
        TopNavVO r104 = this.f181194m;
        if (r104 == null) goto L12;
        Config r105 = r104.getConfig();
        if (r105 == null) goto L12;
        List<TransitionNode> r106 = r105.getTransitionNodes();
    L13:
        q2(r106, r100);
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r107 = this.f181200s;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L17:
        if (r100 != 0.0f) goto L19;
        r101 = true;
    L19:
        r107.setDisableTouchEvent(r101);
        float r108 = k2(r100);
        Object r109 = this.f181203v.get("trans_fraction");
        if ((r109 instanceof Float) == true) goto L22;
        r109 = null;
    L22:
        Float r110 = (Float) r109;
        if (r110 == null) goto L25;
        float r111 = r110.floatValue();
    L27:
        if (r108 == k2(r111)) goto L36;
        Map<String, Object> r112 = this.f181203v;
        if (r100 > r102) goto L32;
        r100 = 0.0f;
    L34:
        r112.put("trans_fraction", Float.valueOf(r100));
        h2(null);
        return;
    L32:
        if (r100 < 1) goto L34;
        r100 = 1.0f;
        goto L34
    L36:
        return;
    L25:
        r111 = 0.0f;
    L12:
        r106 = null;
        goto L13
    }

    public final void n2(com.bytedance.android.ecom.arch.slice.g r100) {
        if (this.f181201t.containsKey(r100) == false) goto L5;
        return;
    L5:
        j r101 = new j(this);
        r100.setSliceRebindTarget(r101);
        this.f181201t.put(r100, r101);
        if ((r100 instanceof p) == false) goto L13;
        List<com.bytedance.android.ecom.arch.slice.g> r102 = ((p) r100).a();
        if (r102 == null) goto L15;
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L16;
        n2((com.bytedance.android.ecom.arch.slice.g) r103.next());
        goto L11
    L16:
        return;
    L15:
        return;
    }

    @Override // vg3.i0
    public final void r1(Function1<? super Rect, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        View r101 = e2();
        if (ViewCompat.isLaidOut(r101) == true) goto L5;
    L7:
        r101.addOnLayoutChangeListener(new c(this, r100));
        return;
    L5:
        if (r101.isLayoutRequested() == true) goto L7;
        r100.invoke(new Rect(e2().getLeft(), e2().getTop(), e2().getRight(), e2().getBottom()));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.c r102 = O1().e().r().l0();
        this.f181200s = r102;
        r102.setId(R.id.top_navigation_layout);
        return r102;
    }

    public final void p2(String r100, boolean r101) {
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "trySelectTab " + r100 + ' ' + r101 + " lastIs=" + this.f181203v + "[KEY_SLC_CUR_GROUP_ID]");
        if (Intrinsics.areEqual(this.f181203v.get("current_group_id"), r100) == false) goto L5;
        return;
    L5:
        boolean r102 = Intrinsics.areEqual(this.f181203v.get("collapsed"), Boolean.TRUE);
        if (this.f181199r != null) goto L12;
        TopNavVO r103 = this.f181194m;
        if (r103 == null) goto L10;
        List<com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g> r104 = r103.getTabList();
    L11:
        this.f181199r = r104;
        goto L12
    L10:
        r104 = null;
    L12:
        List<com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g> r105 = this.f181199r;
        if (r105 == null) goto L24;
        Iterator<T> r106 = r105.iterator();
        int r107 = 0;
    L16:
        if (r106.hasNext() == false) goto L24;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g r108 = (com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g) r106.next();
        if (Intrinsics.areEqual(r108.f181255a, r100) == true) goto L25;
        if (r102 == false) goto L23;
        if (Intrinsics.areEqual(r108.f181256b, Boolean.TRUE) == false) goto L16;
    L23:
        r107 = r107 + 1;
    L25:
        if (r107 >= 0) goto L27;
        return;
    L27:
        this.f181203v.put("current_group_id", r100);
        this.f181203v.put("current_tab_index", Integer.valueOf(r107));
        h2(null);
        this.f181198q.g(new n0(r107, r100, r101));
        return;
    L24:
        r107 = -1;
        goto L25
    }

    public final void q2(List<TransitionNode> r100, float r101) {
        if (r100 == null) goto L25;
        Iterator<T> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L34;
        TransitionNode r103 = (TransitionNode) r102.next();
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r104 = this.f181200s;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L9:
        View r105 = r104.a(r103.getSliceKey());
        if (r105 == null) goto L5;
        if ((r103.getEnd() - r103.getStart()) > 0) goto L15;
        float r106 = r101;
    L22:
        if (r103.getReverse() == true) goto L23;
        r105.setAlpha(r106);
        goto L5
    L23:
        r105.setAlpha(1 - r106);
        goto L5
    L15:
        if (r101 >= r103.getStart()) goto L18;
        r106 = 0.0f;
        goto L22
    L18:
        if (r101 <= r103.getEnd()) goto L20;
        r106 = 1.0f;
        goto L22
    L20:
        r106 = (r101 - r103.getStart()) / (r103.getEnd() - r103.getStart());
        goto L22
    L34:
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final void b2(ViewGroup r100, ViewGroup.LayoutParams r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        if (r101 != null) goto L5;
        super.b2(r100, new ViewGroup.LayoutParams(-1, -2), r102);
        return;
    L5:
        super.b2(r100, r101, r102);
    }
}
