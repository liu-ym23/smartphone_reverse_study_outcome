package com.bytedance.android.shopping.deepfeed.slice.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.deepfeed.slice.action.n;
import com.bytedance.android.shopping.deepfeed.slice.action.s;
import com.bytedance.android.shopping.deepfeed.slice.action.t;
import com.bytedance.android.shopping.deepfeed.slice.action.u;
import com.bytedance.android.shopping.deepfeed.slice.action.v;
import com.bytedance.android.shopping.deepfeed.slice.action.w;
import com.bytedance.android.shopping.deepfeed.slice.g;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.utlis.DataUtilsKt$createDefaultIAction$1;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.google.gson.internal.LinkedTreeMap;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements com.bytedance.android.shopping.deepfeed.ui.c, w, u, com.bytedance.android.shopping.deepfeed.slice.service.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f173429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f173430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.shopping.deepfeed.slice.a f173431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f173432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f173433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w f173434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f173435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f173436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, v> f173437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f173438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f173439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f173440l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final wc3.b f173441m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f173442n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Fragment f173443o;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.a$a, reason: collision with other inner class name */
    public static final class C2592a {
    }

    static {
    }

    public final Map<String, Object> E() {
        Pair[] r100 = new Pair[3];
        DeepFeedFoldHelper.f();
        r100[0] = TuplesKt.to("is_fold", Boolean.FALSE);
        r100[1] = TuplesKt.to("screen_width", Integer.valueOf(DeepFeedFoldHelper.c(this.f173443o.getContext())));
        nj.d r101 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r101 == null) goto L5;
        r101.isPad();
    L5:
        r100[2] = TuplesKt.to("is_pad", false);
        return MapsKt.mapOf(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void H() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void J(int r100, int r101, boolean r102, boolean r103) {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final int L() {
        return 0;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void N(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void Q() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.u
    public final void a() {
        this.f173432d = true;
        Lazy r100 = DeepFeedFoldHelper.f173363a;
        DeepFeedFoldHelper.b(this.f173443o.getActivity());
        FragmentActivity r101 = this.f173443o.getActivity();
        if (r101 == null) goto L6;
        r101.finish();
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxUrl");
        Intrinsics.checkNotNullParameter(r101, "popupType");
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void l(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.y
    public final void p(int r100, int r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r102, "data");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final boolean v() {
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void z(int r100, String r101) {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final DeepFeedProductEventTracker A() {
        w r100 = this.f173434f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.A();
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void B() {
        this.f173435g.put("config", E());
        D();
    }

    public final void D() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(this.f173435g);
        r100.put("state", this.f173436h);
        com.bytedance.android.shopping.deepfeed.slice.a r101 = this.f173431c;
        if (r101 == null) goto L6;
        r101.updateData(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final com.bytedance.android.shopping.deepfeed.action.d c() {
        w r100 = this.f173434f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final boolean i() {
        w r100 = this.f173434f;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.i();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.b q() {
        w r100 = this.f173434f;
        if (r100 == null) goto L7;
        vc3.b r101 = r100.q();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new vc3.b(null);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final LifecycleOwner k() {
        return this.f173443o;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final boolean o() {
        return this.f173432d;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.y
    public final void C(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r101 = xc3.a.f563207a;
        Map<String, Object> r102 = this.f173435g;
        Map<String, Object> r103 = this.f173436h;
        Intrinsics.checkNotNullParameter(r102, "nonStateMap");
        Intrinsics.checkNotNullParameter(r103, "stateMap");
        Intrinsics.checkNotNullParameter(r100, "data");
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r105 = r100.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L9;
        Map.Entry<String, ? extends Object> r106 = r105.next();
        if ((!Intrinsics.areEqual(r106.getKey(), "state")) == false) goto L4;
        r104.put(r106.getKey(), r106.getValue());
        goto L4
    L9:
        if ((!r104.isEmpty()) == false) goto L11;
        xc3.a.a(r102, r104);
    L11:
        Object r107 = r100.get("state");
        if ((r107 instanceof Map) == true) goto L14;
        r107 = null;
    L14:
        Map r108 = (Map) r107;
        if (r108 == null) goto L17;
        xc3.a.a(r103, r108);
    L17:
        D();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void I(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Intrinsics.checkNotNullParameter(r100, "list");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void K(com.bytedance.android.shopping.deepfeed.slice.service.a r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleObserver");
        Intrinsics.checkNotNullParameter(r100, "lifecycleObserver");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void M(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void P(com.bytedance.android.shopping.deepfeed.slice.service.a r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleObserver");
        Intrinsics.checkNotNullParameter(r100, "lifecycleObserver");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void b(boolean r100) {
        w r101 = this.f173434f;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void e(float r100) {
        Map<? extends String, ? extends Object> r101 = MapsKt.mapOf(TuplesKt.to("shop_alpha", Float.valueOf(r100)));
        this.f173436h.putAll(r101);
        D();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.c j(vc3.d r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        w r100 = this.f173434f;
        if (r100 == null) goto L7;
        vc3.c r111 = r100.j(r110);
        if (r111 == null) goto L7;
        return r111;
    L7:
        return new vc3.c(null, 0, null, null, null, null, null, "");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final v r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        v r101 = this.f173437i.get(r100);
        if (r101 != null) goto L9;
        w r102 = this.f173434f;
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.r(r100);
    L9:
        return r101;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final String s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "link");
        w r101 = this.f173434f;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.s(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void t(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        r100.invoke(null);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void w(int r100) {
        w r101 = this.f173434f;
        if (r101 == null) goto L6;
        r101.w(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void x(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "afterAction");
        w r101 = this.f173434f;
        if (r101 == null) goto L6;
        r101.x(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void y(boolean r100) {
        w r101 = this.f173434f;
        if (r101 == null) goto L6;
        r101.y(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void h(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "viewName");
        w r102 = this.f173434f;
        if (r102 == null) goto L6;
        r102.h(r100, r101);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void m(Boolean r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "targetView");
        w r102 = this.f173434f;
        if (r102 == null) goto L6;
        r102.m(r100, r101);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void u(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "mainArea");
        w r102 = this.f173434f;
        if (r102 == null) goto L6;
        r102.u(r100, r101);
        return;
    }

    public a(com.bytedance.android.shopping.deepfeed.slice.e r100, View r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r100, "slcManager");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        this.f173441m = r100;
        this.f173442n = r101;
        this.f173443o = r102;
        this.f173429a = "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/eccs/gecko/resource/ecom_deep_feed_template/top_bar_card/main.json";
        LinkedHashMap r103 = new LinkedHashMap();
        this.f173435g = r103;
        this.f173436h = new LinkedHashMap();
        LinkedHashMap r104 = new LinkedHashMap();
        this.f173437i = r104;
        this.f173439k = -1;
        this.f173440l = new b(this);
        r104.put("UpdateModel", new s(this));
        r104.put("PageFinish", new n(this));
        r104.put("EventChain", new com.bytedance.android.shopping.deepfeed.slice.action.e(this));
        r103.putAll(MapsKt.mapOf(TuplesKt.to("config", E())));
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void O(String r100, Map<String, ? extends Object> r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r100, "actionName");
        DataUtilsKt$createDefaultIAction$1 r103 = new DataUtilsKt$createDefaultIAction$1(r100, r101);
        v r104 = this.f173440l.a(r100);
        if (r104 == null) goto L6;
        r104.m(r103, r102);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void d(String r100, List<String> r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r101, "featureInfoList");
        Intrinsics.checkNotNullParameter(r102, "targetView");
        w r103 = this.f173434f;
        if (r103 == null) goto L6;
        r103.d(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void f(DeepFeedProductViewModel r100, com.bytedance.android.shopping.deepfeed.action.b r101, Function0<? extends AbsDeepFeedProductVH> r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "deepFeedContext");
        Intrinsics.checkNotNullParameter(r102, "curVH");
        ViewGroup r103 = (ViewGroup) this.f173442n.findViewById(R.id.slice_top_bar);
        if (r103 == null) goto L5;
        this.f173430b = r103;
    L5:
        ViewGroup r104 = this.f173430b;
        if (r104 == null) goto L27;
        r104.removeAllViews();
        com.bytedance.android.shopping.deepfeed.slice.a r105 = new com.bytedance.android.shopping.deepfeed.slice.a(this.f173441m, UUID.randomUUID().toString());
        this.f173431c = r105;
        Map<String, LinkedTreeMap<String, Object>> r106 = g.f173418a;
        g r107 = (g) ((LinkedHashMap) g.a.a()).get("top_bar_card");
        if (r107 == null) goto L17;
        String r108 = r107.c();
        if (r108 == null) goto L17;
        if (r108.length() <= 0) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == false) goto L17;
    L18:
        r105.a(new com.bytedance.android.shopping.deepfeed.slice.b(r108, "top_bar_card", "1.0.0", r104, this.f173440l));
        com.bytedance.android.shopping.deepfeed.slice.a r110 = this.f173431c;
        if (r110 == null) goto L25;
        Intrinsics.checkNotNullParameter(this, "service");
        r r111 = r110.f173382a;
        if (r111 == null) goto L25;
        SlcTemplateContext r112 = r111.f50700b;
        if (r112 == null) goto L25;
        r112.s(com.bytedance.android.shopping.deepfeed.slice.service.b.class, this);
    L25:
        Function1<com.bytedance.android.shopping.deepfeed.data.e, Unit> r113 = new DeepFeedSlcTopBar$slcListener$1(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r113, "listener");
        Intrinsics.checkNotNullParameter(r113, "listener");
        return;
    L14:
        r109 = false;
    L17:
        r108 = this.f173429a;
        goto L18
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.a n(String r100, String r110, String r111, boolean r112, View r113) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r110, "area");
        Intrinsics.checkNotNullParameter(r111, "btm");
        Intrinsics.checkNotNullParameter(r113, "view");
        w r101 = this.f173434f;
        if (r101 == null) goto L7;
        vc3.a r102 = r101.n(r100, r110, r111, r112, r113);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new vc3.a(null, null, 0, null, null, null, null);
    }
}
