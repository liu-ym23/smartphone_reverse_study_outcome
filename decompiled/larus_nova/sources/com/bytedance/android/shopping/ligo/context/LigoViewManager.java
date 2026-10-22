package com.bytedance.android.shopping.ligo.context;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.model.live.ligo.DynamicType;
import com.bytedance.android.shopping.ligo.monitor.LigoMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.k;
import ti.l;
import w83.e;
import w83.f;
import w83.h;
import w83.i;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/ligo/context/LigoViewManager;", "Lw83/i;", "Landroidx/lifecycle/LifecycleEventObserver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LigoViewManager implements i, LifecycleEventObserver {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f176433l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<ViewGroup, HashMap<String, ll.c>> f176434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LigoComponentRegistry f176435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f176436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f176437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f176438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LifecycleOwner f176439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f176440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w83.d<?> f176441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Map<String, Object>> f176442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<x83.a> f176443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.shopping.ligo.monitor.a f176444k;

    public static final class a {
        public static void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Object r101 = r100.getTag(R.id.ec_dynamic_view_lynx);
            if ((r101 instanceof l) == true) goto L5;
            r101 = null;
        L5:
            l r102 = (l) r101;
            if (r102 == null) goto L9;
            dm.a.a("LigoViewManager").i("id: " + r100.getId() + " release component success");
            r102.release();
            return;
        }
    }

    public static final class b implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f176445a;

        public b(l r100) {
            this.f176445a = r100;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "event");
            int r102 = com.bytedance.android.shopping.ligo.context.d.f176457a[r101.ordinal()];
            if (r102 != 1) goto L5;
            l r103 = this.f176445a;
            JSONObject r104 = new JSONObject();
            r104.put("visible", true);
            r104.put("source", "page");
            Unit r105 = Unit.INSTANCE;
            r103.sendJsEvent("pageVisibilityChange", r104);
            return;
        L5:
            if (r102 != 2) goto L11;
            l r106 = this.f176445a;
            JSONObject r107 = new JSONObject();
            r107.put("visible", false);
            r107.put("source", "page");
            Unit r108 = Unit.INSTANCE;
            r106.sendJsEvent("pageVisibilityChange", r107);
            return;
        }
    }

    public static final class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LigoViewManager f176446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ll.a f176447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f176448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f176449d;

        @Override // ti.k
        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            dm.a.a("LigoViewManager").w("load lynx failed by inner fallback!schema=" + this.f176448c, null);
            f r100 = this.f176449d;
            if (r100 == null) goto L5;
            r100.onFallback();
        L5:
            LigoViewManager r101 = this.f176446a;
            int r102 = LigoViewManager.f176433l;
            r101.h().d(this.f176447b, String.valueOf(-1), "");
        }

        @Override // ti.k
        public final void onFirstScreen(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void onLoadSuccess(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            LigoViewManager r101 = this.f176446a;
            int r102 = LigoViewManager.f176433l;
            r101.h().a().b(this.f176447b);
            dm.a.a("LigoViewManager").i("load lynx success, schema=" + this.f176448c);
            f r103 = this.f176449d;
            if (r103 == null) goto L6;
            r103.onLoadSuccess();
            return;
        }

        @Override // ti.k
        public final void onRuntimeReady(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            LigoViewManager r101 = this.f176446a;
            int r102 = LigoViewManager.f176433l;
            com.bytedance.android.shopping.ligo.monitor.c r103 = r101.h().a();
            ll.a r104 = this.f176447b;
            r103.getClass();
            Intrinsics.checkNotNullParameter(r104, "dynamicRegion");
            r103.c(r104.e(), "on_runtime_ready");
        }

        @Override // ti.k
        public final void g(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // ti.k
        public final void onLoadFailed(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            dm.a.a("LigoViewManager").w("load lynx failed! schema=" + this.f176448c, null);
            f r102 = this.f176449d;
            if (r102 == null) goto L5;
            r102.a(r101);
        L5:
            LigoViewManager r103 = this.f176446a;
            int r104 = LigoViewManager.f176433l;
            r103.h().d(this.f176447b, "", r101);
        }

        @Override // ti.k
        public final void onPageStart(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            LigoViewManager r102 = this.f176446a;
            int r103 = LigoViewManager.f176433l;
            com.bytedance.android.shopping.ligo.monitor.c r104 = r102.h().a();
            ll.a r105 = this.f176447b;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, "dynamicRegion");
            r104.c(r105.e(), "on_page_start");
        }

        @Override // ti.k
        public final void s(View r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r100, "view");
            LigoViewManager r103 = this.f176446a;
            int r104 = LigoViewManager.f176433l;
            LigoMonitor r105 = r103.h();
            ll.a r106 = this.f176447b;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, "dynamicRegion");
            Intrinsics.checkNotNullParameter("", "errorCode");
            com.bytedance.android.shopping.ligo.monitor.d r107 = r105.f176460b;
            r107.getClass();
            Intrinsics.checkNotNullParameter(r106, "dynamicRegion");
            Intrinsics.checkNotNullParameter("", "errorCode");
            String r108 = r107.f176464a;
            String r109 = "lynx_runtime_error_" + r106.b();
            Map r110 = com.bytedance.android.shopping.ligo.monitor.d.a(r106, new Pair[]{new Pair("error_code", ""), new Pair("error_msg", r102)});
            xh.b r111 = new xh.b();
            r111.c(r108);
            r111.b(r109);
            r111.a(r110);
            xh.c.a("Ligo").f(5, r111);
        }

        public c(LigoViewManager r100, ll.a r101, String r102, f r103) {
            this.f176446a = r100;
            this.f176447b = r101;
            this.f176448c = r102;
            this.f176449d = r103;
        }
    }

    public static final class d<T> implements Comparator<T> {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((x83.b) r100).f562896b), Integer.valueOf(((x83.b) r101).f562896b));
        }
    }

    static {
    }

    public final LigoMonitor h() {
        return (LigoMonitor) this.f176436c.getValue();
    }

    public static boolean f(ViewGroup r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        int r102 = r101.width;
        if (r102 == (-1)) goto L5;
        if (r102 == (-2)) goto L5;
    L9:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L14;
        r101 = null;
    L14:
        if (r101 != null) goto L18;
        return false;
    L18:
        return true;
    L5:
        int r104 = r101.height;
        if (r104 == (-1)) goto L10;
        if (r104 != (-2)) goto L9;
    L10:
        r103 = true;
        goto L11
    }

    @Override // w83.i
    public final void b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        HashMap<String, ll.c> r101 = this.f176434a.get(r100);
        if (r101 == null) goto L11;
        Iterator<Map.Entry<String, ll.c>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        View r103 = g(r100, r102.next().getValue());
        if (r103 == null) goto L6;
        r100.removeViewAt(r100.indexOfChild(r103));
    L11:
        this.f176434a.remove(r100);
    }

    @Override // w83.i
    public final void d(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        dm.a.a("LigoViewManager").a("unload: parent: " + r100.hashCode());
        l(r100);
        this.f176434a.remove(r100);
    }

    public final void l(ViewGroup r100) {
        HashMap<String, ll.c> r101 = this.f176434a.get(r100);
        if (r101 == null) goto L40;
        Collection<ll.c> r102 = r101.values();
        if (r102 == null) goto L46;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L47;
        ll.c r104 = (ll.c) r103.next();
        dm.a.a("LigoViewManager").a("[unload] cache: {" + r104.getIdentifier() + " data: {name=" + r104.f509661b.b() + " type=" + r104.f509661b.a() + ", url=" + r104.f509661b.e() + ", params" + r104.f509661b.c() + "}}");
        LifecycleOwner r105 = this.f176439f;
        if ((r105 instanceof Fragment) == true) goto L12;
        r105 = null;
    L12:
        Fragment r106 = (Fragment) r105;
        if (r106 == null) goto L15;
        FragmentManager r107 = r106.getChildFragmentManager();
    L16:
        Integer r108 = r104.getIdentifier().f509658a;
        if (r108 == null) goto L27;
        int r109 = r108.intValue();
        View r110 = r100.findViewById(r109);
        if (r110 == null) goto L21;
        m(r100, r110, r104);
        Unit r111 = Unit.INSTANCE;
    L26:
        if (r111 == null) goto L27;
    L38:
        if (r111 != null) goto L8;
        dm.a.a("LigoViewManager").w("[unload] no view find to remove", null);
        goto L8
    L21:
        if (r107 == null) goto L25;
        Fragment r112 = r107.findFragmentById(r109);
        if (r112 == null) goto L25;
        k(r112, r107);
        r111 = Unit.INSTANCE;
    L25:
        r111 = null;
    L27:
        String r113 = r104.getIdentifier().f509659b;
        if (r113 == null) goto L37;
        View r114 = r100.findViewWithTag(r113);
        if (r114 == null) goto L33;
        m(r100, r114, r104);
        Unit r115 = Unit.INSTANCE;
    L32:
        r111 = r115;
        goto L38
    L33:
        if (r107 == null) goto L37;
        Fragment r116 = r107.findFragmentByTag(r113);
        if (r116 == null) goto L37;
        k(r116, r107);
        r115 = Unit.INSTANCE;
    L37:
        r111 = null;
        goto L38
    L15:
        r107 = null;
        goto L16
    L47:
        return;
    L46:
        return;
    }

    public static View g(ViewGroup r100, ll.c r101) {
        Integer r102 = r101.getIdentifier().f509658a;
        if (r102 == null) goto L6;
        View r103 = r100.findViewById(r102.intValue());
        if (r103 == null) goto L6;
    L10:
        if (r103 != null) goto L13;
        return null;
    L13:
        return r103;
    L6:
        String r104 = r101.getIdentifier().f509659b;
        if (r104 == null) goto L9;
        r103 = r100.findViewWithTag(r104);
        goto L10
    L9:
        r103 = null;
        goto L10
    }

    public static void k(Fragment r100, FragmentManager r101) {
        dm.a.a("LigoViewManager").a("[unload] parent has fragment");
        r101.beginTransaction().setTransition(0).setTransitionStyle(0).setCustomAnimations(0, 0, 0, 0).remove(r100).commitNowAllowingStateLoss();
    }

    public final void j(ViewGroup r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        ArrayList r102 = new ArrayList();
        HashMap<String, ll.c> r103 = this.f176434a.get(r100);
        if (r103 == null) goto L16;
        Iterator<Map.Entry<String, ll.c>> r104 = r103.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L16;
        Map.Entry<String, ll.c> r105 = r104.next();
        View r106 = g(r100, r105.getValue());
        if (r106 == null) goto L8;
        int r107 = r100.indexOfChild(r106);
        if (r107 == (-1)) goto L8;
        r102.add(new x83.b(r106, r107, r105));
    L16:
        Function0<x83.a> r108 = this.f176443j;
        if (r108 == null) goto L29;
        x83.a r109 = r108.invoke();
        if (r109 == null) goto L30;
        r109.c(r101, r102);
        return;
    L30:
        return;
    }

    public final boolean n(View r110, ll.a r111) {
        h().a().a(r111);
        int r100 = r111.a();
        Object r101 = null;
        if (r100 != DynamicType.LYNX.getValue()) goto L49;
        String r102 = r111.e();
        if (r102 != null) goto L7;
    L46:
        h().b(r111, "10001", "template_url is null");
        return false;
    L7:
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L46;
        LinkedHashMap r104 = new LinkedHashMap();
        Map<String, Object> r105 = this.f176440g;
        if (r105 == null) goto L18;
        r104.putAll(r105);
    L18:
        Function0<Map<String, Object>> r106 = this.f176442i;
        if (r106 == null) goto L23;
        Map<String, Object> r107 = r106.invoke();
        if (r107 == null) goto L23;
        r104.putAll(r107);
    L23:
        String r108 = r111.c();
        if (r108 == null) goto L26;
        r104.put("dynamic_region_params", r108);
    L26:
        String r109 = r111.e();
        if (r109 != null) goto L29;
    L37:
        Unit r112 = Unit.INSTANCE;
        Map<String, ? extends Object> r113 = MapsKt.mapOf(TuplesKt.to("ecom_dynamic_params", r104));
        UrlBuilderV2 r114 = new UrlBuilderV2(r111.e());
        String r115 = UUID.randomUUID().toString();
        HashMap<String, JSONObject> r116 = j.f44312a;
        j.h(r115, new JSONObject(r113));
        r114.addOrReplaceParam("mega_object_id", r115);
        String r117 = r114.build();
        Object r118 = r110.getTag(R.id.ec_dynamic_view_lynx);
        if ((r118 instanceof l) == false) goto L41;
        r101 = r118;
    L41:
        l r119 = (l) r101;
        if (r119 == null) goto L45;
        dm.a.a("LigoViewManager").i("id: " + r110.getId() + " renderTemplate");
        r119.updateBusinessGlobalProps(r113);
        r119.renderTemplate(r117, r113);
        h().c(r111);
        return true;
    L45:
        h().b(r111, "10005", "cannot get annie card.");
    L71:
        h().b(r111, "10004", "unknown dynamic_type " + r111.a());
        return false;
    L29:
        if (r109.length() <= 0) goto L31;
        boolean r120 = true;
    L32:
        if (r120 == true) goto L35;
        r109 = null;
    L35:
        if (r109 == null) goto L37;
        com.bytedance.android.shopping.ligo.monitor.c r121 = h().a();
        r121.getClass();
        Intrinsics.checkNotNullParameter(r111, "dynamicRegion");
        r104.put("dynamic_region_perf_params", (Map) ((LinkedHashMap) r121.f176462a).get(r111.e()));
        goto L37
    L31:
        r120 = false;
        goto L32
    L9:
        r103 = false;
        goto L10
    L49:
        if (r100 != DynamicType.NATIVE.getValue()) goto L71;
        String r122 = r111.e();
        if (r122 != null) goto L53;
    L69:
        h().b(r111, "10001", "template_url is null");
        return false;
    L53:
        if (r122.length() <= 0) goto L55;
        boolean r123 = true;
    L56:
        if (r123 == false) goto L58;
        r101 = r122;
    L58:
        if (r101 == null) goto L69;
        w83.a r124 = this.f176435b.a(UriProtector.parse(r111.e()));
        if (r124 != null) goto L65;
        h().b(r111, "10005", "cannot get NA component.");
        return false;
    L65:
        if ((r124 instanceof h) == false) goto L67;
        ((h) r124).d(r110, r111);
        dm.a.a("LigoViewManager").i("id: " + r110.getId() + " update compose success");
    L67:
        h().c(r111);
        return true;
    L55:
        r123 = false;
        goto L56
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = com.bytedance.android.shopping.ligo.context.d.f176458b[r101.ordinal()];
        if (r102 != 1) goto L5;
        dm.a.a("LigoViewManager").a("onCreate clear cache");
        this.f176434a.clear();
        ((LinkedHashMap) h().a().f176462a).clear();
        return;
    L5:
        if (r102 != 2) goto L22;
        dm.a.a("LigoViewManager").a("onDestroy clear cache");
        Iterator<T> r103 = this.f176434a.keySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r103.hasNext() == false) goto L12;
        l((ViewGroup) r103.next());     // Catch: Exception -> L14
        goto L10
    L12:
        this.f176434a.clear();     // Catch: Exception -> L14
        ((LinkedHashMap) h().a().f176462a).clear();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        dm.a.a("LigoViewManager").b("dynamicCache clear failed, e = " + e, null);
        return;
    }

    public final void m(ViewGroup r100, View r101, ll.c r102) {
        dm.a.a("LigoViewManager").a("[unload] parent has view");
        int r103 = r100.indexOfChild(r101);
        if (r103 != (-1)) goto L5;
        return;
    L5:
        w83.a r104 = this.f176435b.a(UriProtector.parse(r102.f509661b.e()));
        if (r104 != null) goto L8;
    L10:
        dm.a.b r105 = dm.a.a("LigoViewManager");
        StringBuilder r106 = new StringBuilder("id: ");
        r106.append(r101.getId());
        r106.append(" unload compose error compose: ");
        if (r104 == null) goto L13;
        boolean r107 = true;
    L14:
        r106.append(r107);
        r106.append(" isCompose: ");
        r106.append(r104 instanceof h);
        r105.b(r106.toString(), null);
    L15:
        a.a(r101);
        LifecycleEventObserver r108 = r102.f509662c;
        if (r108 == null) goto L18;
        this.f176439f.getLifecycle().removeObserver(r108);
    L18:
        dm.a.a("LigoViewManager").i("[unload] parent find index: " + r103);
        if (((Boolean) this.f176438e.getValue()).booleanValue() == true) goto L26;
        r100.removeViewAt(r103);
        return;
    L26:
        r100.removeView(r101);     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L13:
        r107 = false;
        goto L14
    L8:
        if ((r104 instanceof h) == false) goto L10;
        ((h) r104).c(r101);
        dm.a.a("LigoViewManager").i("id: " + r101.getId() + " unload compose success");
        goto L15
    }

    public final void o(ViewGroup r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        HashMap<String, ll.c> r103 = this.f176434a.get(r100);
        if (r103 == null) goto L24;
        Map r104 = MapsKt.toMap(r103);
        if (r104 == null) goto L34;
        Iterator r105 = r104.entrySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L35;
        ll.c r106 = (ll.c) ((Map.Entry) r105.next()).getValue();
        if (r106.f509661b.a() != DynamicType.LYNX.getValue()) goto L8;
        Integer r107 = r106.getIdentifier().f509658a;
        if (r107 == null) goto L8;
        View r108 = r100.findViewById(r107.intValue());
        Object r109 = null;
        if (r108 == null) goto L16;
        Object r110 = r108.getTag(R.id.ec_dynamic_view_lynx);
    L18:
        if ((r110 instanceof l) == false) goto L21;
        r109 = r110;
    L21:
        l r111 = (l) r109;
        if (r111 == null) goto L8;
        r111.updateScreenMetrics(r101, r102);
        goto L8
    L16:
        r110 = null;
        goto L18
    L35:
        return;
    L34:
        return;
    }

    @Override // w83.i
    public final ll.b a(ViewGroup r110, ll.a r111, boolean r112, f r113) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, "data");
        LigoMonitor r100 = h();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r111, "dynamicRegion");
        r100.a().a(r111);
        r100.f176461c.b("livesdk_ligo_load_start", com.bytedance.android.shopping.ligo.monitor.b.a(r111));
        dm.a.a("LigoViewManager").a("load: parent: " + r110.hashCode() + " data: {name: " + r111.b() + " type=" + r111.a() + ", url=" + r111.e() + ", params=" + r111.c() + '}');
        HashMap<String, ll.c> r101 = this.f176434a.get(r110);
        if (r101 == null) goto L41;
        String r102 = r111.b();
        String r114 = "";
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        ll.c r103 = r101.get(r102);
        if (r103 == null) goto L41;
        dm.a.a("LigoViewManager").a("cache: {" + r103.getIdentifier() + " data: {name: " + r103.f509661b.b() + " type=" + r103.f509661b.a() + ", url=" + r103.f509661b.e() + ", params" + r103.f509661b.c() + "}}");
        Integer r104 = r103.getIdentifier().f509658a;
        if (r104 == null) goto L41;
        View r105 = r110.findViewById(r104.intValue());
        if (r105 == null) goto L41;
        dm.a.a("LigoViewManager").a("parent has view");
        if (Intrinsics.areEqual(r111, r103.f509661b) == false) goto L18;
        h().c(r111);
        return r103.getIdentifier();
    L18:
        dm.a.a("LigoViewManager").a("data equal not model");
        if (r113 == null) goto L22;
        r113.b(r103.f509661b.e(), r103.f509661b.a());
    L22:
        if (r111.a() == r103.f509661b.a()) goto L30;
        int r106 = r110.indexOfChild(r105);
        dm.a.a("LigoViewManager").i("parent find index: " + r106);
        r110.removeViewAt(r106);
        Pair<Object, ll.b> r107 = i(r110, r106, r111, r112, r113);
        if (r107 == null) goto L26;
        e(r110, r107.getFirst(), r107.getSecond(), r111);
        dm.a.a("LigoViewManager").i("create new view id: " + r107.getSecond());
        return r107.getSecond();
    L26:
        return new ll.b(-1, null);
    L30:
        if (n(r105, r111) == false) goto L40;
        HashMap<String, ll.c> r108 = this.f176434a.get(r110);
        if (r108 != null) goto L34;
        r108 = new HashMap();
    L34:
        String r109 = r111.b();
        if (r109 == null) goto L38;
        r114 = r109;
    L38:
        r108.put(r114, ll.c.a(r103, r111));
        this.f176434a.put(r110, r108);
        dm.a.a("LigoViewManager").a("update cache success");
    L40:
        return r103.getIdentifier();
    L41:
        dm.a.a("LigoViewManager").a("begin init view");
        Pair<Object, ll.b> r115 = i(r110, -1, r111, r112, r113);
        if (r115 == null) goto L44;
        e(r110, r115.getFirst(), r115.getSecond(), r111);
        dm.a.a("LigoViewManager").a("init view " + r115.getSecond());
        return r115.getSecond();
    L44:
        return new ll.b(-1, null);
    }

    public final void e(ViewGroup r100, Object r101, ll.b r102, ll.a r103) {
        b r104 = null;
        if ((r101 instanceof View) == false) goto L16;
        View r105 = (View) r101;
        if (r105.getId() != (-1)) goto L7;
        int r106 = ViewCompat.generateViewId();
        r105.setId(r106);
        r102.f509658a = Integer.valueOf(r106);
        dm.a.a("LigoViewManager").a("generate view id: " + r105.getId());
    L7:
        Integer r107 = Integer.valueOf(r105.getId());
        Object r108 = r105.getTag(R.id.ec_dynamic_view_lynx);
        if ((r108 instanceof l) == true) goto L10;
        r108 = null;
    L10:
        l r109 = (l) r108;
        if (r109 == null) goto L13;
        b r110 = new b(r109);
        this.f176439f.getLifecycle().addObserver(r110);
        Unit r111 = Unit.INSTANCE;
    L14:
        String r112 = null;
        r104 = r110;
    L19:
        HashMap<String, ll.c> r113 = this.f176434a.get(r100);
        if (r113 != null) goto L22;
        r113 = new HashMap();
    L22:
        String r114 = r103.b();
        if (r114 != null) goto L25;
        r114 = "";
    L25:
        r113.put(r114, new ll.c(new ll.b(r107, r112), r103, r104));
        this.f176434a.put(r100, r113);
        if (((Boolean) this.f176437d.getValue()).booleanValue() == false) goto L31;
        cl.d r115 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r115 == null) goto L32;
        r115.e();
        return;
    L32:
        return;
    L31:
        return;
    L13:
        r110 = null;
        goto L14
    L16:
        if ((r101 instanceof Fragment) == false) goto L18;
        r112 = ((Fragment) r101).getTag();
        r107 = null;
        goto L19
    L18:
        r112 = null;
        r107 = null;
        goto L19
    }

    @Override // w83.i
    public final ll.b c(ViewGroup r110, ll.a r111, String r112, boolean r210, f r211) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, "data");
        LigoMonitor r100 = h();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r111, "dynamicRegion");
        r100.a().a(r111);
        r100.f176461c.b("livesdk_ligo_load_start", com.bytedance.android.shopping.ligo.monitor.b.a(r111));
        HashMap<String, ll.c> r101 = this.f176434a.get(r110);
        String r102 = "";
        if (r101 == null) goto L42;
        String r103 = r111.b();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        ll.c r104 = r101.get(r103);
        if (r104 == null) goto L42;
        View r105 = g(r110, r104);
        if (r105 != null) goto L13;
    L108:
        if (r104 != null) goto L116;
        Pair<Object, ll.b> r106 = i(r110, -1, r111, r210, r211);
        if (r106 == null) goto L112;
        e(r110, r106.getFirst(), r106.getSecond(), r111);
        dm.a.a("LigoViewManager").a("init view " + r106.getSecond());
        j(r110, r112);
        return r106.getSecond();
    L112:
        return new ll.b(-1, null);
    L116:
        return new ll.b(-1, null);
    L13:
        if (Intrinsics.areEqual(r111, r104.f509661b) == false) goto L16;
        h().c(r111);
        return r104.getIdentifier();
    L16:
        if (r211 == null) goto L19;
        r211.b(r104.f509661b.e(), r104.f509661b.a());
    L19:
        if (r111.a() == r104.f509661b.a()) goto L31;
        int r107 = r110.indexOfChild(r105);
        if (r107 == (-1)) goto L23;
        r110.removeViewAt(r107);
        Pair<Object, ll.b> r108 = i(r110, r107, r111, r210, r211);
        if (r108 == null) goto L27;
        e(r110, r108.getFirst(), r108.getSecond(), r111);
        j(r110, r112);
        return r108.getSecond();
    L27:
        return new ll.b(-1, null);
    L23:
        return new ll.b(-1, null);
    L31:
        if (n(r105, r111) == false) goto L41;
        HashMap<String, ll.c> r109 = this.f176434a.get(r110);
        if (r109 != null) goto L35;
        r109 = new HashMap();
    L35:
        String r113 = r111.b();
        if (r113 == null) goto L39;
        r102 = r113;
    L39:
        r109.put(r102, ll.c.a(r104, r111));
        this.f176434a.put(r110, r109);
        dm.a.a("LigoViewManager").a("update cache success");
    L41:
        return r104.getIdentifier();
    L42:
        Function0<x83.a> r114 = this.f176443j;
        if (r114 == null) goto L107;
        x83.a r115 = r114.invoke();
        if (r115 == null) goto L107;
        List<x83.b> r116 = r115.b(r112);
        if (r116 == null) goto L107;
        List r117 = CollectionsKt.sortedWith(r116, new d());
        if (r117 == null) goto L107;
        h().a().a(r111);
        List r118 = r117;
        Iterator r119 = r118.iterator();
    L52:
        if (r119.hasNext() == false) goto L59;
        View r120 = ((x83.b) r119.next()).f562895a;
        ViewParent r121 = r120.getParent();
        if ((r121 instanceof ViewGroup) == true) goto L56;
        r121 = null;
    L56:
        ViewGroup r122 = (ViewGroup) r121;
        if (r122 == null) goto L52;
        r122.removeView(r120);
        goto L52
    L59:
        HashMap r123 = new HashMap();
        Iterator r124 = r118.iterator();
    L61:
        if (r124.hasNext() == false) goto L63;
        x83.b r125 = (x83.b) r124.next();
        r110.addView(r125.f562895a);
        r123.put(r125.f562897c.getKey(), r125.f562897c.getValue());
        goto L61
    L63:
        this.f176434a.put(r110, (HashMap<String, ll.c>) r123);
        HashMap<String, ll.c> r126 = this.f176434a.get(r110);
        if (r126 == null) goto L106;
        String r127 = r111.b();
        if (r127 != null) goto L68;
        r127 = "";
    L68:
        ll.c r128 = r126.get(r127);
        if (r128 == null) goto L106;
        View r129 = g(r110, r128);
        if (r129 != null) goto L76;
        return new ll.b(-1, null);
    L76:
        if (Intrinsics.areEqual(r111, r128.f509661b) == false) goto L79;
        h().c(r111);
        return r128.getIdentifier();
    L79:
        if (r211 == null) goto L82;
        r211.b(r128.f509661b.e(), r128.f509661b.a());
    L82:
        if (r111.a() == r128.f509661b.a()) goto L94;
        int r130 = r110.indexOfChild(r129);
        if (r130 == (-1)) goto L86;
        r110.removeViewAt(r130);
        Pair<Object, ll.b> r131 = i(r110, r130, r111, r210, r211);
        if (r131 == null) goto L90;
        e(r110, r131.getFirst(), r131.getSecond(), r111);
        j(r110, r112);
        return r131.getSecond();
    L90:
        return new ll.b(-1, null);
    L86:
        return new ll.b(-1, null);
    L94:
        if (n(r129, r111) == false) goto L104;
        HashMap<String, ll.c> r132 = this.f176434a.get(r110);
        if (r132 != null) goto L98;
        r132 = new HashMap();
    L98:
        String r133 = r111.b();
        if (r133 == null) goto L102;
        r102 = r133;
    L102:
        r132.put(r102, ll.c.a(r128, r111));
        this.f176434a.put(r110, r132);
        dm.a.a("LigoViewManager").a("update cache success");
    L104:
        return r128.getIdentifier();
    L106:
        return new ll.b(-1, null);
    L107:
        r104 = null;
        goto L108
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Pair<Object, ll.b> i(ViewGroup r210, int r211, ll.a r310, boolean r311, f r312) {
        h().a().a(r310);
        int r100 = r310.a();
        boolean r110 = true;
        if (r100 != DynamicType.LYNX.getValue()) goto L66;
        String r101 = r310.e();
        if (r101 != null) goto L7;
    L63:
        h().b(r310, "10001", "template_url is null");
        return null;
    L7:
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L63;
        LinkedHashMap r103 = new LinkedHashMap();
        Map<String, Object> r104 = this.f176440g;
        if (r104 == null) goto L18;
        r103.putAll(r104);
    L18:
        Function0<Map<String, Object>> r105 = this.f176442i;
        if (r105 == null) goto L23;
        Map<String, Object> r106 = r105.invoke();
        if (r106 == null) goto L23;
        r103.putAll(r106);
    L23:
        String r107 = r310.c();
        if (r107 == null) goto L26;
        r103.put("dynamic_region_params", r107);
    L26:
        String r108 = r310.e();
        if (r108 != null) goto L29;
    L37:
        Unit r109 = Unit.INSTANCE;
        Map<String, ? extends Object> r111 = MapsKt.mapOf(TuplesKt.to("ecom_dynamic_params", r103));
        UrlBuilderV2 r112 = new UrlBuilderV2(r310.e());
        String r113 = UUID.randomUUID().toString();
        HashMap<String, JSONObject> r114 = j.f44312a;
        j.h(r113, new JSONObject(r111));
        r112.addOrReplaceParam("mega_object_id", r113);
        String r115 = r112.build();
        l r116 = ECLiveHybridUtil.b(r210.getContext(), r115, r111, null, new c(this, r310, r115, r312), null, null, false, null, null, false, 4072);
        if (r116 == null) goto L58;
        r116.updateBusinessGlobalProps(r111);
        dm.a.a("LigoViewManager").i("create annie component success");
        View r117 = r116.getHybridView();
        if (r117 == null) goto L57;
        if (r311 == true) goto L43;
    L45:
        r110 = false;
    L46:
        if (r110 == false) goto L48;
        LigoViewManager r118 = this;
    L49:
        if (r118 == null) goto L52;
        ViewGroup.LayoutParams r119 = r210.getLayoutParams();
        if (r119 == null) goto L52;
    L53:
        r210.addView(r117, r211, r119);
        if (r117.getId() != (-1)) goto L56;
        r117.setId(ViewCompat.generateViewId());
    L56:
        r117.setTag(R.id.ec_dynamic_view_lynx, r116);
        dm.a.a("LigoViewManager").i("create annie card success");
    L52:
        r119 = new ViewGroup.LayoutParams(-2, -2);
        goto L53
    L48:
        r118 = null;
        goto L49
    L43:
        if (f(r210) == false) goto L45;
    L57:
        View r120 = r116.getHybridView();
    L59:
        if (r120 != null) goto L61;
        h().b(r310, "10003", "lynx component create failed.");
    L61:
        if (r120 == null) goto L152;
        h().c(r310);
        return new Pair(r120, new ll.b(Integer.valueOf(r120.getId()), null));
    L152:
        return null;
    L58:
        r120 = null;
        goto L59
    L29:
        if (r108.length() <= 0) goto L31;
        boolean r121 = true;
    L32:
        if (r121 == true) goto L35;
        r108 = null;
    L35:
        if (r108 == null) goto L37;
        com.bytedance.android.shopping.ligo.monitor.c r122 = h().a();
        r122.getClass();
        Intrinsics.checkNotNullParameter(r310, "dynamicRegion");
        r103.put("dynamic_region_perf_params", (Map) ((LinkedHashMap) r122.f176462a).get(r310.e()));
        goto L37
    L31:
        r121 = false;
        goto L32
    L9:
        r102 = false;
        goto L10
    L66:
        if (r100 != DynamicType.NATIVE.getValue()) goto L148;
        String r123 = r310.e();
        if (r123 != null) goto L70;
    L144:
        if (r312 == null) goto L146;
        r312.a("template_url is null");
    L146:
        h().b(r310, "10001", "template_url is null");
        return null;
    L70:
        if (r123.length() <= 0) goto L72;
        boolean r124 = true;
    L73:
        if (r124 == true) goto L76;
        r123 = null;
    L76:
        if (r123 == null) goto L144;
        w83.a r125 = this.f176435b.a(UriProtector.parse(r310.e()));
        if (r125 != null) goto L84;
        if (r312 == null) goto L82;
        r312.a("component factory is null");
    L82:
        h().b(r310, "10002", "unregistered component.");
        return null;
    L84:
        dm.a.a("LigoViewManager").i("create native component success");
        if ((r125 instanceof h) == false) goto L112;
        w83.d<?> r126 = this.f176441h;
        if (r126 == null) goto L89;
        w83.b r127 = r126.a();
    L90:
        View r128 = ((h) r125).b(r210, r310, r127);
        if (r128 != null) goto L94;
        h().b(r310, "10003", "native component create failed.");
        return null;
    L94:
        if (r311 == true) goto L96;
    L98:
        r110 = false;
    L99:
        if (r110 == false) goto L101;
        LigoViewManager r129 = this;
    L102:
        if (r129 == null) goto L105;
        ViewGroup.LayoutParams r130 = r210.getLayoutParams();
        if (r130 == null) goto L105;
    L106:
        r210.addView(r128, r211, r130);
        dm.a.a("LigoViewManager").i("create native view success");
        h().a().b(r310);
        if (r312 == null) goto L109;
        r312.onLoadSuccess();
    L109:
        h().c(r310);
        return new Pair(r128, new ll.b(Integer.valueOf(r128.getId()), null));
    L105:
        r130 = new ViewGroup.LayoutParams(-2, -2);
        goto L106
    L101:
        r129 = null;
        goto L102
    L96:
        if (f(r210) == false) goto L98;
    L89:
        r127 = null;
        goto L90
    L112:
        if ((r125 instanceof e) == false) goto L141;
        w83.d<?> r131 = this.f176441h;
        if (r131 == null) goto L116;
        r131.a();
    L116:
        Fragment r132 = ((e) r125).a();
        LifecycleOwner r133 = this.f176439f;
        if ((r133 instanceof Fragment) == true) goto L119;
        r133 = null;
    L119:
        Fragment r134 = (Fragment) r133;
        if (r134 == null) goto L122;
        FragmentManager r135 = r134.getChildFragmentManager();
    L123:
        if (r132 == null) goto L130;
        if (r135 == null) goto L130;
        String r136 = "ligo_fragment_" + r132.hashCode();
        FragmentTransaction r137 = r135.beginTransaction().setTransition(0).setTransitionStyle(0).setCustomAnimations(0, 0, 0, 0);
        int r138 = r210.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r137, r132, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r136, r138) == true) goto L129;
        r137 = r137.add(r138, r132, r136);
    L129:
        r137.commitNowAllowingStateLoss();
    L130:
        dm.a.a("LigoViewManager").i("create fragment success");
        if (r132 == null) goto L137;
        h().a().b(r310);
        if (r312 == null) goto L135;
        r312.onLoadSuccess();
    L135:
        h().c(r310);
        return new Pair(r132, new ll.b(null, r132.getTag()));
    L137:
        if (r312 == null) goto L139;
        r312.a("fragment create failed.");
    L139:
        h().b(r310, "10003", "fragment create failed.");
        return null;
    L122:
        r135 = null;
        goto L123
    L141:
        if (r312 == null) goto L143;
        r312.a("unknown native component factory");
    L143:
        h().b(r310, "10006", "unknown native component factory");
        return null;
    L72:
        r124 = false;
        goto L73
    L148:
        if (r312 == null) goto L150;
        r312.a("unknown dynamicType");
    L150:
        h().b(r310, "10004", "unknown dynamic_type " + r310.a());
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LigoViewManager(LifecycleOwner r100, Map<String, ? extends Object> r101, w83.d<?> r102, Function0<? extends Map<String, ? extends Object>> r103, Function0<? extends x83.a> r104, com.bytedance.android.shopping.ligo.monitor.a r105) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r105, "eventTracker");
        this.f176439f = r100;
        this.f176440g = r101;
        this.f176441h = r102;
        this.f176442i = r103;
        this.f176443j = r104;
        this.f176444k = r105;
        this.f176434a = new HashMap();
        this.f176435b = (LigoComponentRegistry) LigoComponentRegistry.f176431b.getValue();
        this.f176436c = LazyKt.lazy(new LigoViewManager$monitor$2(this));
        this.f176437d = LazyKt.lazy(LigoViewManager$isLocalTestChannel$2.INSTANCE);
        this.f176438e = LazyKt.lazy(LigoViewManager$fixLigoCrash$2.INSTANCE);
        r100.getLifecycle().addObserver(this);
    }
}
