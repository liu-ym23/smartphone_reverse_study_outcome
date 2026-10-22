package com.bytedance.android.annie.bridge;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.method.abs.ResultCodeEnumSerializer;
import com.bytedance.android.annie.card.base.HybridDomainUtils;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.xbridge.mix.DefaultMixMethodCache;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import e7.j0;
import e7.k0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.FutureTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class JSBridgeManager implements y6.c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f38427w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.annie.param.a f38428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnnieXLiveContext f38429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f38430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f0 f38431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentLinkedQueue<String> f38432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IHybridComponent f38433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<IHybridComponent> f38434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f38435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<Context> f38436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ConcurrentLinkedQueue<q> f38437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RegisterPolicy f38438k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f38439l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f38440m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f38441n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f38442o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f38443p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FutureTask<Unit> f38444q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f38445r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f38446s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.bytedance.android.annie.card.g f38447t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f38448u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public DefaultMixMethodCache f38449v;

    public static final class a {
    }

    public static final class b extends com.bytedance.ies.web.jsbridge2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.b f38450c;

        @Override // com.bytedance.ies.web.jsbridge2.a
        public final View b() {
            com.bytedance.ies.web.jsbridge2.b r100 = this.f38450c;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.g();
        }

        public b(com.bytedance.ies.web.jsbridge2.b r100) {
            this.f38450c = r100;
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ies.web.jsbridge2.q f38451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Gson f38452b;

        public c() {
            this.f38451a = ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).n1();
            this.f38452b = new Gson().newBuilder().registerTypeHierarchyAdapter(j0.class, new ResultCodeEnumSerializer()).create();
        }

        @Override // com.bytedance.ies.web.jsbridge2.q
        public final <T> String a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            Class<?> r101 = r100.getClass();
            if (Intrinsics.areEqual(r101, JsonObject.class) == false) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            return r100.toString();
        L9:
            if (Intrinsics.areEqual(r101, String.class) == false) goto L12;
            return r100.toString();
        L12:
            if ((r100 instanceof k0) == false) goto L15;
            return GsonProtectorUtils.toJson(this.f38452b, r100);
        L15:
            return this.f38451a.a(r100);
        L5:
            r102 = Intrinsics.areEqual(r101, JsonArray.class);
            goto L6
        }

        @Override // com.bytedance.ies.web.jsbridge2.q
        public final <T> T b(String r100, Type r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "type");
            return (T) GsonProtectorUtils.fromJson(this.f38452b, r100, r101);
        }
    }

    public static final class d<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSBridgeManager f38453a;

        public d(JSBridgeManager r100) {
            this.f38453a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final Unit call() {
            JSBridgeManager r100 = this.f38453a;
            int r101 = JSBridgeManager.f38427w;
            r100.h();
            this.f38453a.f38443p = true;
            JSBridgeManager r102 = this.f38453a;
            com.bytedance.android.annie.param.a r103 = r102.f38428a;
            if (r103 == null) goto L7;
            x8.b r104 = r103.f39696d;
            if (r104 == null) goto L7;
            r104.e(r102.f38445r, "===JSB futureTask end:url:" + this.f38453a.f38440m + "===");
            return Unit.INSTANCE;
        L7:
            return null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
    }

    public /* synthetic */ JSBridgeManager() {
        this(null);
    }

    @Override // y6.c
    public final f0 a() {
        return new f0(null, this.f38430c);
    }

    @Override // y6.c
    public final IHybridComponent c() {
        IHybridComponent r100 = this.f38433f;
        if (r100 != null) goto L9;
        WeakReference<IHybridComponent> r101 = this.f38434g;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.get();
    L9:
        return r100;
    }

    @Override // y6.c
    public final d0 d() {
        if (this.f38448u == false) goto L8;
        d0 r100 = this.f38430c;
        if (r100 != null) goto L12;
        d0.a r101 = d0.f249336g;
        return new d0(new com.bytedance.ies.web.jsbridge2.o(), Boolean.TRUE);
    L12:
        return r100;
    L8:
        d0 r102 = this.f38430c;
        if (r102 != null) goto L13;
        d0.a r103 = d0.f249336g;
        return new com.bytedance.ies.web.jsbridge2.o().a();
    L13:
        return r102;
    }

    public final String g() {
        com.bytedance.android.annie.param.a r100 = this.f38428a;
        if (r100 == null) goto L6;
        String r101 = r100.getBizKey();
        if (r101 == null) goto L6;
        return r101;
    L6:
        AnnieXLiveContext r102 = this.f38429b;
        if (r102 != null) goto L12;
        return "host";
    L12:
        return r102.getBizKey();
    }

    @Override // y6.c
    public Activity getActivity() {
        if (this.f38448u == false) goto L12;
        WeakReference<Context> r100 = this.f38436i;
        if (r100 == null) goto L16;
        Context r101 = r100.get();
        if (r101 != null) goto L9;
        return null;
    L9:
        if ((r101 instanceof Activity) == true) goto L11;
        return null;
    L11:
        return (Activity) r101;
    L16:
        return null;
    L12:
        Context r102 = this.f38435h;
        if ((r102 instanceof Activity) == true) goto L15;
        return null;
    L15:
        return (Activity) r102;
    }

    public final void h() {
        d0 r100 = this.f38430c;
        if (r100 == null) goto L5;
        r100.f249345e = this.f38431d;
    L5:
        IHybridComponent r101 = this.f38433f;
        if (r101 == null) goto L20;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r102 = com.bytedance.android.annie.bridge.method.j0.c(this, r101).entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r103 = r102.next();
        registerMethod(r103.getKey(), r103.getValue());
        goto L9
    L11:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r104 = com.bytedance.android.annie.bridge.method.j0.b(this, r101).entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r105 = r104.next();
        registerMethod(r105.getKey(), r105.getValue());
        goto L13
    L15:
        Iterator<Map.Entry<String, n56.c>> r106 = com.bytedance.android.annie.bridge.method.j0.a(this, r101).entrySet().iterator();
    L17:
        if (r106.hasNext() == false) goto L20;
        Map.Entry<String, n56.c> r107 = r106.next();
        registerMethod(r107.getKey(), r107.getValue());
    L20:
        if (this.f38448u == false) goto L37;
        WeakReference<IHybridComponent> r108 = this.f38434g;
        if (r108 == null) goto L37;
        IHybridComponent r109 = r108.get();
        if (r109 == null) goto L37;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r110 = com.bytedance.android.annie.bridge.method.j0.c(this, r109).entrySet().iterator();
    L27:
        if (r110.hasNext() == false) goto L29;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r111 = r110.next();
        registerMethod(r111.getKey(), r111.getValue());
        goto L27
    L29:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r112 = com.bytedance.android.annie.bridge.method.j0.b(this, r109).entrySet().iterator();
    L31:
        if (r112.hasNext() == false) goto L33;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r113 = r112.next();
        registerMethod(r113.getKey(), r113.getValue());
        goto L31
    L33:
        Iterator<Map.Entry<String, n56.c>> r114 = com.bytedance.android.annie.bridge.method.j0.a(this, r109).entrySet().iterator();
    L35:
        if (r114.hasNext() == false) goto L37;
        Map.Entry<String, n56.c> r115 = r114.next();
        registerMethod(r115.getKey(), r115.getValue());
    L37:
        Iterator r116 = ((CopyOnWriteArraySet) a9.j.f2218c).iterator();
    L39:
        if (r116.hasNext() == false) goto L84;
        y6.a r117 = (y6.a) r116.next();
        if (this.f38438k == RegisterPolicy.SPECIFIED) goto L42;
        Iterator<Map.Entry<String, n56.c>> r118 = r117.d(this).entrySet().iterator();
    L74:
        if (r118.hasNext() == false) goto L76;
        Map.Entry<String, n56.c> r119 = r118.next();
        registerMethod(r119.getKey(), r119.getValue());
        goto L74
    L76:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r120 = r117.k(this).entrySet().iterator();
    L78:
        if (r120.hasNext() == false) goto L80;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r121 = r120.next();
        registerMethod(r121.getKey(), r121.getValue());
        goto L78
    L80:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r122 = r117.n(this).entrySet().iterator();
    L82:
        if (r122.hasNext() == false) goto L39;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r123 = r122.next();
        registerMethod(r123.getKey(), r123.getValue());
        goto L82
    L42:
        Map<String, n56.c> r124 = r117.e(this);
        if (r124.isEmpty() == false) goto L48;
        Iterator<Map.Entry<String, n56.c>> r125 = r117.d(this).entrySet().iterator();
    L46:
        if (r125.hasNext() == false) goto L52;
        Map.Entry<String, n56.c> r126 = r125.next();
        registerMethod(r126.getKey(), r126.getValue());
    L52:
        Map<String, com.bytedance.ies.web.jsbridge2.f.b> r127 = r117.l(this);
        if (r127.isEmpty() == false) goto L58;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r128 = r117.k(this).entrySet().iterator();
    L56:
        if (r128.hasNext() == false) goto L62;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r129 = r128.next();
        registerMethod(r129.getKey(), r129.getValue());
    L62:
        Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r130 = r117.o(this);
        if (r130.isEmpty() == true) goto L64;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r131 = r130.entrySet().iterator();
    L70:
        if (r131.hasNext() == false) goto L39;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r132 = r131.next();
        registerMethod(r132.getKey(), r132.getValue());
        goto L70
    L64:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r133 = r117.n(this).entrySet().iterator();
    L66:
        if (r133.hasNext() == false) goto L39;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r134 = r133.next();
        registerMethod(r134.getKey(), r134.getValue());
        goto L66
    L58:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r135 = r127.entrySet().iterator();
    L60:
        if (r135.hasNext() == false) goto L62;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r136 = r135.next();
        registerMethod(r136.getKey(), r136.getValue());
        goto L60
    L48:
        Iterator<Map.Entry<String, n56.c>> r137 = r124.entrySet().iterator();
    L50:
        if (r137.hasNext() == false) goto L52;
        Map.Entry<String, n56.c> r138 = r137.next();
        registerMethod(r138.getKey(), r138.getValue());
        goto L50
    L84:
        w8.c r139 = (w8.c) Annie.getService$default(w8.c.class, null, 2, null);
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r140 = r139.provideDefaultStatelessMethods(this.f38430c, this.f38438k).entrySet().iterator();
    L86:
        if (r140.hasNext() == false) goto L88;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r141 = r140.next();
        registerMethod(r141.getKey(), r141.getValue());
        goto L86
    L88:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r142 = r139.provideDefaultStatefulMethods(this.f38430c, this.f38438k).entrySet().iterator();
    L90:
        if (r142.hasNext() == false) goto L92;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r143 = r142.next();
        registerMethod(r143.getKey(), r143.getValue());
        goto L90
    L92:
        Iterator r144 = r139.N(this.f38438k).entrySet().iterator();
    L94:
        if (r144.hasNext() == false) goto L96;
        Map.Entry r145 = (Map.Entry) r144.next();
        registerMethod((String) r145.getKey(), (n56.c) r145.getValue());
        goto L94
    }

    public final void i() {
        ConcurrentLinkedQueue<q> r100 = this.f38437j;
        if (r100 == null) goto L8;
        Iterator<q> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().release();
    L8:
        this.f38449v = null;
        this.f38435h = null;
        this.f38436i = null;
        this.f38429b = null;
        this.f38433f = null;
        this.f38434g = null;
        this.f38437j = null;
        a9.j r102 = a9.j.f2216a;
        a9.j.I1(this);
    }

    @Override // y6.c
    public final void release() {
        com.bytedance.android.annie.param.a r100 = this.f38428a;
        if (r100 == null) goto L7;
        x8.b r101 = r100.f39696d;
        if (r101 == null) goto L7;
        r101.e(this.f38445r, "===JSBridgeManager release url:" + this.f38440m + " ===");
    L7:
        this.f38446s = true;
        a9.j.I1(this);
        this.f38444q.cancel(true);
        ConcurrentLinkedQueue<q> r102 = this.f38437j;
        if (r102 == null) goto L13;
        Iterator<q> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        r103.next().release();
    L13:
        d0 r104 = this.f38430c;
        if (r104 == null) goto L16;
        r104.e();
    L16:
        f0 r105 = this.f38431d;
        if (r105 == null) goto L22;
        n56.a r106 = r105.f249350b;
        r106.f518017a = null;
        n56.a.HandlerC6893a r107 = r106.f518024h;
        if (r107 == null) goto L21;
        r107.removeCallbacksAndMessages(null);
    L21:
        r106.f518022f = null;
    L22:
        d0 r108 = this.f38430c;
        if (r108 == null) goto L27;
        Set<d0> r109 = h.f38458a;
        Intrinsics.checkNotNullParameter(r108, "owner");
        h.f38458a.remove(r108);
        return;
    }

    public JSBridgeManager(com.bytedance.android.annie.param.a r100) {
        this.f38432e = new ConcurrentLinkedQueue();
        this.f38437j = new ConcurrentLinkedQueue();
        this.f38438k = RegisterPolicy.DEFAULT;
        this.f38440m = "";
        this.f38441n = LazyKt.lazy(JSBridgeManager$asyncJsbMethodAB$2.INSTANCE);
        this.f38442o = LazyKt.lazy(JSBridgeManager$jsbMethodCallbackAB$2.INSTANCE);
        this.f38443p = true;
        this.f38444q = new FutureTask(new d(this));
        this.f38445r = "JSBridgeManager";
        this.f38447t = new com.bytedance.android.annie.card.g();
        this.f38428a = r100;
    }

    @Override // y6.c
    public final void b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (this.f38448u == false) goto L5;
        this.f38436i = new WeakReference(r100);
        return;
    L5:
        this.f38435h = r100;
    }

    public final void j(String r110, String r111) {
        if (((Boolean) this.f38441n.getValue()).booleanValue() == false) goto L10;
        this.f38443p = false;
        com.bytedance.android.annie.param.a r100 = this.f38428a;
        if (r100 == null) goto L9;
        x8.b r101 = r100.f39696d;
        if (r101 == null) goto L9;
        r101.e(this.f38445r, "===JSB futureTask execute:url:" + this.f38440m + "===");
    L9:
        AsyncTask.THREAD_POOL_EXECUTOR.execute(this.f38444q);
    L17:
        if (Intrinsics.areEqual(r110, "none") == true) goto L27;
        long r102 = SystemClock.elapsedRealtime();
        ((da.b) Annie.getService$default(da.b.class, null, 2, null)).J(this, r110);
        ((da.b) Annie.getService(da.b.class, r111)).J(this, r110);
        long r112 = SystemClock.elapsedRealtime() - r102;
        j9.b r103 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        String r104 = this.f38440m;
        JSONObject r105 = new JSONObject();
        r105.put(ChameleonOpenTracker.ParamKey.COST, r112);
        Unit r113 = Unit.INSTANCE;
        JSONObject r114 = new JSONObject();
        com.bytedance.android.annie.ng.a r115 = com.bytedance.android.annie.ng.g.f39671c.get(g());
        if (r115 == null) goto L24;
        o8.f r116 = r115.f39644b;
        if (r116 == null) goto L24;
        String r117 = r116.f522331a;
        if (r117 == null) goto L24;
    L25:
        r114.put("virtual_aid", r117);
        j9.b.a.a(r103, null, "latch_reg_xbridge_cost", r104, null, r105, null, r114, 0, 256);
    L24:
        r117 = "88888";
    L27:
        if (this.f38439l == true) goto L32;
        d0 r118 = this.f38430c;
        if (r118 == null) goto L33;
        ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).l1(r118);
        return;
    L33:
        return;
    L32:
        return;
    L10:
        com.bytedance.android.annie.param.a r106 = this.f38428a;
        if (r106 == null) goto L15;
        x8.b r107 = r106.f39696d;
        if (r107 == null) goto L15;
        r107.e(this.f38445r, "===JSB normal execute:url:" + this.f38440m + "===");
    L15:
        h();
        goto L17
    }

    @Override // y6.c
    public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        d0 r102 = this.f38430c;
        q r103 = null;
        if (r102 == null) goto L30;
        Intrinsics.checkNotNull(r102);
        if (r102.f249346f == true) goto L30;
        if (this.f38446s == true) goto L30;
        if (Intrinsics.areEqual(r100, "getStorage") == false) goto L11;
    L12:
        com.bytedance.android.annie.param.a r104 = this.f38428a;
        if (r104 == null) goto L18;
        x8.b r105 = r104.f39696d;
        if (r105 == null) goto L18;
        r105.f(this.f38445r, "register_method", "===registerMethod url:" + this.f38440m + "  methodName:" + r100 + "===");
    L18:
        if ((r101 instanceof q) == false) goto L20;
        q r106 = (q) r101;
    L21:
        if (r106 == null) goto L25;
        ConcurrentLinkedQueue<q> r107 = this.f38437j;
        if (r107 == null) goto L25;
        r107.add(r106);
    L25:
        d0 r108 = this.f38430c;
        if (r108 == null) goto L28;
        r108.c(r100, r101);
    L28:
        this.f38432e.add(r100);
        ((c9.d) Annie.getService$default(c9.d.class, null, 2, null)).registerMethod(r100, r101);
        goto L30
    L20:
        r106 = null;
        goto L21
    L11:
        if (Intrinsics.areEqual(r100, "setStorage") == false) goto L18;
    L30:
        if (this.f38448u == true) goto L32;
        return;
    L32:
        if ((r101 instanceof q) == false) goto L34;
        r103 = (q) r101;
    L34:
        if (r103 == null) goto L38;
        ConcurrentLinkedQueue<q> r109 = this.f38437j;
        if (r109 == null) goto L38;
        r109.add(r103);
    L38:
        DefaultMixMethodCache r110 = this.f38449v;
        if (r110 == null) goto L43;
        r110.b(r100, r101);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.android.annie.api.card.IHybridComponent] */
    /* JADX WARN: Type inference failed for: r15v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    @Override // y6.c
    public final <T> void sendJSEvent(String r110, T r111) {
        Intrinsics.checkNotNullParameter(r110, "name");
        d0 r100 = this.f38430c;
        if (r100 == null) goto L45;
        Boolean r101 = Boolean.valueOf(r100.f249346f);
        Intrinsics.checkNotNull(r101);
        if (r101.booleanValue() == true) goto L45;
        if (this.f38446s == true) goto L45;
        d0 r102 = this.f38430c;
        if (r102 == null) goto L11;
        r102.f(r110, r111);
    L11:
        com.bytedance.android.annie.param.a r103 = this.f38428a;
        if (r103 == null) goto L17;
        x8.b r104 = r103.f39696d;
        if (r104 == null) goto L17;
        r104.e(this.f38445r, "x, eventName:" + r110 + ", url:" + this.f38440m);
    L17:
        if (Intrinsics.areEqual("onDegradeHappened", r110) == false) goto L45;
        com.bytedance.android.annie.param.a r105 = this.f38428a;
        String r106 = null;
        if (r105 == null) goto L21;
        String r107 = r105.getBizKey();
    L22:
        if (r107 != null) goto L55;
    L35:
        String r108 = "88888";
    L36:
        j9.b r109 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        String r112 = this.f38440m;
        if ((r111 instanceof JSONObject) == false) goto L39;
        JSONObject r113 = (JSONObject) r111;
    L40:
        JSONObject r114 = new JSONObject();
        r114.put("virtual_aid", r108);
        Unit r115 = Unit.INSTANCE;
        com.bytedance.android.annie.param.a r116 = this.f38428a;
        if (r116 == null) goto L43;
        r106 = r116.getMonitorID();
    L43:
        r109.b(null, "annie_container_degrade_event", r112, r113, null, null, r114, 0, r106);
        goto L45
    L39:
        r113 = null;
        goto L40
    L55:
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r117 = com.bytedance.android.annie.ng.g.f39671c;     // Catch: Exception -> L54
        com.bytedance.android.annie.param.a r118 = this.f38428a;     // Catch: Exception -> L54
        if (r118 == null) goto L28;
        String r119 = r118.getBizKey();     // Catch: Exception -> L54
        if (r119 == null) goto L28;
    L29:
        com.bytedance.android.annie.ng.a r120 = r117.get(r119);     // Catch: Exception -> L54
        if (r120 == null) goto L35;
        o8.f r121 = r120.f39644b;     // Catch: Exception -> L54
        if (r121 == null) goto L35;
        r108 = r121.f522331a;     // Catch: Exception -> L54
        if (r108 != null) goto L36;
    L28:
        r119 = "webcast";
        goto L29
    L21:
        r107 = null;
    L45:
        if (this.f38448u == false) goto L57;
        WeakReference<IHybridComponent> r122 = this.f38434g;
        if (r122 == null) goto L58;
        IHybridComponent r123 = r122.get();
        ?? r124 = r111;
        if (r123 == 0) goto L59;
        if (r111 != 0) goto L52;
        r124 = (T) new Object();
    L52:
        r123.sendJsEvent(r110, r124);
        return;
    L59:
        return;
    L58:
        return;
    }

    @Override // y6.c
    public final <P, R> void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        d0 r102 = this.f38430c;
        if (r102 == null) goto L22;
        Boolean r103 = Boolean.valueOf(r102.f249346f);
        Intrinsics.checkNotNull(r103);
        if (r103.booleanValue() == true) goto L22;
        if (this.f38446s == true) goto L22;
        if (Intrinsics.areEqual(r100, "getStorage") == false) goto L11;
    L12:
        com.bytedance.android.annie.param.a r104 = this.f38428a;
        if (r104 == null) goto L17;
        x8.b r105 = r104.f39696d;
        if (r105 == null) goto L17;
        r105.f(this.f38445r, "register_method", "===registerMethod url:" + this.f38440m + "  methodName:" + r100 + "===");
    L17:
        d0 r106 = this.f38430c;
        if (r106 == null) goto L20;
        r106.d(r100, r101);
    L20:
        this.f38432e.add(r100);
        ((c9.d) Annie.getService$default(c9.d.class, null, 2, null)).registerMethod(r100, r101);
        goto L22
    L11:
        if (Intrinsics.areEqual(r100, "setStorage") == false) goto L17;
    L22:
        if (this.f38448u == false) goto L27;
        DefaultMixMethodCache r107 = this.f38449v;
        if (r107 == null) goto L28;
        r107.c(r100, r101);
        return;
    L28:
        return;
    }

    @Override // y6.c
    public final void registerMethod(String r100, n56.c r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        if (this.f38446s == true) goto L9;
        f0 r102 = this.f38431d;
        if (r102 == null) goto L7;
        r102.d(r100, r101);
    L7:
        this.f38432e.add(r100);
    L9:
        if (this.f38448u == false) goto L14;
        DefaultMixMethodCache r103 = this.f38449v;
        if (r103 == null) goto L15;
        r103.d(r100, r101);
        return;
    L15:
        return;
    }

    public JSBridgeManager(AnnieXLiveContext r100, IHybridComponent r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "annieContext");
        Intrinsics.checkNotNullParameter(r101, "hybridComponent");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f38432e = new ConcurrentLinkedQueue();
        this.f38437j = new ConcurrentLinkedQueue();
        this.f38438k = RegisterPolicy.DEFAULT;
        this.f38440m = "";
        this.f38441n = LazyKt.lazy(JSBridgeManager$asyncJsbMethodAB$2.INSTANCE);
        this.f38442o = LazyKt.lazy(JSBridgeManager$jsbMethodCallbackAB$2.INSTANCE);
        this.f38443p = true;
        this.f38444q = new FutureTask(new d(this));
        this.f38445r = "JSBridgeManager";
        this.f38447t = new com.bytedance.android.annie.card.g();
        this.f38429b = r100;
        this.f38434g = new WeakReference(r101);
        this.f38448u = true;
        this.f38436i = new WeakReference(r102);
    }

    public final d0 f(Context r100, com.bytedance.ies.web.jsbridge2.o r101, com.bytedance.ies.web.jsbridge2.b r102, List<? extends com.bytedance.ies.web.jsbridge2.u> r103, final String r104) {
        String r105 = null;
        ((f9.b) Annie.getService$default(f9.b.class, null, 2, null)).m1();
        if (((Boolean) this.f38441n.getValue()).booleanValue() == false) goto L5;
        ((o) Annie.getService$default(o.class, null, 2, null)).h1(r101, new JSBridgeManager$createRealJSBridge$1(this, r104));
    L5:
        com.bytedance.android.annie.param.a r106 = this.f38428a;
        if (r106 == null) goto L9;
        String r107 = r106.getBizKey();
        if (r107 == null) goto L9;
    L10:
        r101.f249414s = r107;
        r101.f249402g = com.bytedance.android.annie.ng.g.b().f39657a.f522322a;
        r101.f249401f = r100;
        r101.f249398c = r102;
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r108 = com.bytedance.android.annie.ng.g.f39671c;
        com.bytedance.android.annie.ng.a r109 = r108.get(r101.b());
        if (r109 == null) goto L15;
        o8.e r110 = r109.f39645c;
        if (r110 == null) goto L15;
        String r111 = r110.f522328a;
    L16:
        r101.f249406k = r111;
        com.bytedance.android.annie.ng.a r112 = r108.get(r101.b());
        if (r112 == null) goto L21;
        o8.e r113 = r112.f39645c;
        if (r113 == null) goto L21;
        r105 = r113.f522329b;
    L21:
        r101.f249399d = r105;
        com.bytedance.android.annie.ng.a r114 = r108.get(r101.b());
        if (r114 == null) goto L26;
        o8.e r115 = r114.f39645c;
        if (r115 == null) goto L26;
        boolean r116 = r115.f522330c;
    L27:
        r101.f249403h = r116;
        if (o7.e.a() == false) goto L31;
        r101.f249410o = true;
    L31:
        if (AnnieConfigSettingKeys.JSB_USE_CORRECT_PERMISSION_SETTING.a().booleanValue() == false) goto L33;
        r101.f249404i = AnnieConfigSettingKeys.JSB_ENABLE_PERMISSION_CHECK.a().booleanValue();
    L33:
        r101.f249407l.addAll((List) HybridDomainUtils.f39133a.getValue());
        r101.c(new c());
        Iterator<T> r117 = r103.iterator();
    L35:
        if (r117.hasNext() == false) goto L37;
        r101.f249405j.add((com.bytedance.ies.web.jsbridge2.u) r117.next());
        goto L35
    L37:
        final d0 r118 = r101.a();
        if (((Boolean) this.f38442o.getValue()).booleanValue() == false) goto L40;
        ((r) Annie.getService(r.class, r118.f249343c.b())).K0(r118, new JSBridgeManager$createRealJSBridge$3$1(r104, r118));
    L40:
        return r118;
    L26:
        r116 = false;
    L15:
        r111 = null;
    L9:
        r107 = "host";
        goto L10
    }

    public final void e(IHybridComponent r100, Context r110, com.bytedance.ies.web.jsbridge2.b r111, List<? extends com.bytedance.ies.web.jsbridge2.u> r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "hybridComponent");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "jsbListeners");
        Intrinsics.checkNotNullParameter(r114, "xBridgeRegisterStrategy");
        this.f38433f = r100;
        this.f38435h = r110;
        this.f38440m = r113;
        b r101 = new b(r111);
        d0.a r102 = d0.f249336g;
        d0 r115 = f(r110, new com.bytedance.ies.web.jsbridge2.o(r101), r111, r112, r113);
        this.f38430c = r115;
        this.f38431d = new f0(null, r115);
        d0 r116 = this.f38430c;
        if (r116 == null) goto L5;
        Set<d0> r117 = h.f38458a;
        Intrinsics.checkNotNullParameter(r116, "owner");
    L5:
        j(r114, r100.getBizKey());
        a9.j r103 = a9.j.f2216a;
        a9.j.H1(this);
    }
}
