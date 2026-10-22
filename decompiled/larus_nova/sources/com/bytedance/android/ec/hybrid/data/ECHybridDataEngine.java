package com.bytedance.android.ec.hybrid.data;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridApiConfigDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridConfigDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkDTO;
import com.bytedance.android.ec.hybrid.data.gecko.DefaultGeckoDataLoader;
import com.bytedance.android.ec.hybrid.data.gecko.KevaGeckoDataLoader;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.ec.hybrid.data.network.HybridFetchDefault;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.m;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridDataEngine implements f {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f46619q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f46620r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy f46621s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Lazy f46622t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy f46623u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.android.ec.hybrid.data.entity.b> f46624v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final DefaultGeckoDataLoader f46625w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final b f46626x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f46627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f46628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECHybridConfigDTO f46629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f46630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f46631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f46632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f46633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArraySet<Object> f46634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f46635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f46636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f46637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f46638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.ec.hybrid.data.gecko.d f46639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f46640n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f46641o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.ec.hybrid.data.network.d f46642p;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f46643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.bytedance.android.ec.hybrid.data.gecko.d f46644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f46645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f46646d;

        public final ECHybridDataEngine a() {
            if (this.f46644b != null) goto L6;
            this.f46644b = new DefaultGeckoDataLoader();
        L6:
            if (this.f46643a == null) goto L13;
            String r100 = this.f46643a;
            Intrinsics.checkNotNull(r100);
            com.bytedance.android.ec.hybrid.data.gecko.d r101 = this.f46644b;
            if (r101 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("resourceDataLoader");
        L11:
            return new ECHybridDataEngine(r100, r101, this.f46645c, this.f46646d);
        L13:
            throw new Throwable("configJsonPath can not be null");
        }

        public a() {
            this.f46646d = "";
        }
    }

    public static final class b {
        public b() {
        }

        public static boolean b() {
            return ((Boolean) ECHybridDataEngine.f46619q.getValue()).booleanValue();
        }

        public static final void a(b r100, String r101, String r102) {
            r100.getClass();
            Single r103 = Single.fromCallable(new com.bytedance.android.ec.hybrid.data.b(r101, r102));
            if (((Boolean) ECHybridDataEngine.f46622t.getValue()).booleanValue() == false) goto L5;
            Observable.timer(((Number) ECHybridDataEngine.f46623u.getValue()).longValue(), TimeUnit.SECONDS).flatMapSingle(new com.bytedance.android.ec.hybrid.data.a(r103)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe();
            return;
        L5:
            r103.subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe();
        }
    }

    public final class c implements com.bytedance.android.ec.hybrid.data.gecko.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<com.bytedance.android.ec.hybrid.data.gecko.c> f46647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f46648b;

        public c() {
            this.f46647a = new LinkedHashSet();
        }

        public final void d(com.bytedance.android.ec.hybrid.data.gecko.c r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            Set<com.bytedance.android.ec.hybrid.data.gecko.c> r101 = this.f46647a;
            monitor-enter(r101);
            this.f46647a.add(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.android.ec.hybrid.data.gecko.c
        public final void b(Long r100, Map<String, ECHybridNetworkDTO> r101) {
            Intrinsics.checkNotNullParameter(r101, "apiConfigDTOMap");
            Set<com.bytedance.android.ec.hybrid.data.gecko.c> r102 = this.f46647a;
            monitor-enter(r102);
            Iterator<T> r103 = this.f46647a.iterator();     // Catch: Throwable -> L11
        L6:
            if (r103.hasNext() == false) goto L8;
            ((com.bytedance.android.ec.hybrid.data.gecko.c) r103.next()).b(r100, r101);     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r102);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.android.ec.hybrid.data.gecko.c
        public final void a(Throwable r100, String r101, Long r102) {
            Set<com.bytedance.android.ec.hybrid.data.gecko.c> r103 = this.f46647a;
            monitor-enter(r103);
            this.f46648b = true;     // Catch: Throwable -> L12
            Iterator<T> r104 = this.f46647a.iterator();     // Catch: Throwable -> L12
        L7:
            if (r104.hasNext() == false) goto L9;
            ((com.bytedance.android.ec.hybrid.data.gecko.c) r104.next()).a(r100, r101, r102);     // Catch: Throwable -> L12
            goto L7
        L9:
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r103);
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.android.ec.hybrid.data.gecko.c
        public final void c(String r100, Long r101, ECHybridConfigDTO r102, Map<String, ? extends Object> r103) {
            Set<com.bytedance.android.ec.hybrid.data.gecko.c> r104 = this.f46647a;
            monitor-enter(r104);
            this.f46648b = true;     // Catch: Throwable -> L12
            Iterator<T> r105 = this.f46647a.iterator();     // Catch: Throwable -> L12
        L7:
            if (r105.hasNext() == false) goto L9;
            ((com.bytedance.android.ec.hybrid.data.gecko.c) r105.next()).c(r100, r101, r102, null);     // Catch: Throwable -> L12
            goto L7
        L9:
            Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r104);
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void a(List<String> r100, ECHybridNetworkTask.a r101) {
        Intrinsics.checkNotNullParameter(r100, "apiKeyList");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f46642p.a(r100, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void b(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f46642p.b(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        this.f46642p.c(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter("homepage", "apiKey");
        this.f46642p.d(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void f() {
        this.f46642p.f();
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void g(String r100, List r101, boolean r110, Map r111, ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1.a r112) {
        Intrinsics.checkNotNullParameter(r100, "tabId");
        Intrinsics.checkNotNullParameter(r101, "apiKeyList");
        Intrinsics.checkNotNullParameter(r112, "callback");
        this.f46642p.g(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void i(String r100, Map<String, ? extends Object> r101, Map<String, String> r102, ECHybridNetworkTask.a r103) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f46642p.i(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void j(List<String> r100, com.bytedance.android.ec.hybrid.data.entity.a r101, ECHybridNetworkTask.a r102) {
        Intrinsics.checkNotNullParameter(r100, "apiKeyList");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f46642p.j(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final String m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        return this.f46642p.m(r100);
    }

    static {
        f46626x = new b();
        f46619q = LazyKt.lazy(ECHybridDataEngine$Companion$isLoadConfigFromKevaEnable$2.INSTANCE);
        f46620r = LazyKt.lazy(ECHybridDataEngine$Companion$isUpdateConfigToKevaOptEnable$2.INSTANCE);
        f46621s = LazyKt.lazy(ECHybridDataEngine$Companion$mallGeckoLockOpt$2.INSTANCE);
        f46622t = LazyKt.lazy(ECHybridDataEngine$Companion$enableOptGeckoSettingsManagerLock$2.INSTANCE);
        f46623u = LazyKt.lazy(ECHybridDataEngine$Companion$delayUpdateConfigTime$2.INSTANCE);
        f46624v = new ConcurrentHashMap();
        f46625w = new DefaultGeckoDataLoader();
    }

    public final ECHybridApiConfigDTO p() {
        ECHybridConfigDTO r100 = this.f46629c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getApiConfig();
    }

    public final String q() {
        return (String) kk.d.a(null, new ECHybridDataEngine$getFeVersion$1(this));
    }

    public final List<String> r() {
        List<String> r100 = this.f46637k;
        if (r100 != null) goto L9;
        ECHybridApiConfigDTO r101 = p();
        if (r101 == null) goto L7;
        r100 = r101.getFirstScreenKeyList();
        goto L9
    L7:
        r100 = null;
    L9:
        if (((Boolean) this.f46633g.getValue()).booleanValue() == false) goto L21;
        if (r100 == null) goto L27;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L13:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        if ((true ^ Intrinsics.areEqual((String) r104, "popup_get")) == false) goto L13;
        r102.add(r104);
        goto L13
    L17:
        r100 = CollectionsKt.toMutableList(r102);
        if (r100 == null) goto L28;
        r100.remove("marketing_resource_get");
        ListProtector.add(r100, 1, "marketing_resource_get");
        goto L21
    L28:
        return null;
    L27:
        return null;
    L21:
        return r100;
    }

    public final void u() {
        kk.d.c(new ECHybridDataEngine$prefetchImages$1(this));
    }

    public final void v() {
        b r100 = f46626x;
        r100.getClass();
        if (b.b() == false) goto L9;
        KevaGeckoDataLoader r101 = KevaGeckoDataLoader.f46704i;
        String r102 = this.f46638l;
        r101.getClass();
        if (KevaGeckoDataLoader.c(r102) == false) goto L10;
        Lazy r103 = ECMallLogUtil.f47441a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "ECHybridDataEngine#writeConfigToKeva()");
        b.a(r100, this.f46638l, this.f46641o);
        return;
    L10:
        return;
    }

    public static void t(ECHybridDataEngine r100, ECHybridNetworkTask.a r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        List<String> r102 = r100.r();
        if (r102 != null) goto L6;
        Lazy r103 = ECMallLogUtil.f47441a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "ECHybridDataEngine#prefetch(), return because firstScreenKeyList is null");
        return;
    L6:
        if (Intrinsics.areEqual(null, Boolean.TRUE) == true) goto L11;
        r100.f46642p.h(r102, r101, false, null);
        return;
    }

    public final void s(ECHybridConfigDTO r100, Map r101) {
        f46626x.getClass();
        if (r101 == null) goto L5;
        Object r102 = r101.get("is_from_keva");
    L6:
        this.f46627a = Intrinsics.areEqual(r102, Boolean.TRUE);
        if (r100 == null) goto L14;
        this.f46629c = r100;
        ECHybridApiConfigDTO r103 = p();
        if (r103 == null) goto L15;
        Map<String, ECHybridNetworkDTO> r104 = r103.getApiKey2NetworkDTOMap();
        if (r104 == null) goto L16;
        this.f46642p.k(r104);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void n(RequestParams r100, boolean r101, com.bytedance.android.ec.hybrid.data.gecko.c r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (((Boolean) this.f46631e.getValue()).booleanValue() == false) goto L18;
        c r103 = this.f46630d;
        if (r103 == null) goto L17;
        Intrinsics.checkNotNull(r103);
        Set<com.bytedance.android.ec.hybrid.data.gecko.c> r104 = r103.f46647a;
        monitor-enter(r104);
        boolean r105 = r103.f46648b;     // Catch: Throwable -> L14
        monitor-exit(r104);
        if (r105 == true) goto L17;
        Lazy r106 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(m.b.f47508b, "load config callback merge to forwardCallback");
        c r107 = this.f46630d;
        if (r107 == null) goto L22;
        r107.d(r102);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        Lazy r108 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(m.b.f47508b, "load config callback add to forwardCallback");
        c r109 = new c();
        r109.d(r102);
        Unit r110 = Unit.INSTANCE;
        this.f46630d = r109;
        o(r100, r101, new d(this, r109));
        return;
    L18:
        o(r100, r101, new d(this, r102));
    }

    public final void o(RequestParams r100, boolean r101, d r102) {
        b r103 = f46626x;
        com.bytedance.android.ec.hybrid.data.gecko.d r104 = this.f46639m;
        String r105 = this.f46638l;
        String r106 = this.f46641o;
        r103.getClass();
        if (b.b() == false) goto L6;
        r104 = KevaGeckoDataLoader.f46704i;
    L6:
        if ((r104 instanceof KevaGeckoDataLoader) == false) goto L12;
        KevaGeckoDataLoader.f46704i.getClass();
        if (((Boolean) KevaGeckoDataLoader.f46696a.getValue()).booleanValue() == false) goto L12;
        ((KevaGeckoDataLoader) r104).getClass();
        KevaGeckoDataLoader.b r107 = KevaGeckoDataLoader.d(r105, r106);
        if (r107 == null) goto L12;
        r102.b(r107.f46709a, r107.f46711c);
    L12:
        r104.CG(r105, Boolean.valueOf(r101), r100, new com.bytedance.android.ec.hybrid.data.c(r102, r106, r105));
    }

    public ECHybridDataEngine(String r100, com.bytedance.android.ec.hybrid.data.gecko.d r101, g r102, String r103) {
        HybridFetchDefault r104 = new HybridFetchDefault();
        this.f46638l = r100;
        this.f46639m = r101;
        this.f46640n = r102;
        this.f46641o = r103;
        this.f46642p = r104;
        this.f46628b = LazyKt.lazy(ECHybridDataEngine$compositeDisposable$2.INSTANCE);
        this.f46631e = LazyKt.lazy(ECHybridDataEngine$configLoadOptEnable$2.INSTANCE);
        this.f46632f = LazyKt.lazy(ECHybridDataEngine$enableLoadGeckoInThread$2.INSTANCE);
        this.f46633g = LazyKt.lazy(ECHybridDataEngine$enableFirstScreenApiOpt$2.INSTANCE);
        this.f46634h = new CopyOnWriteArraySet();
        this.f46635i = new AtomicInteger(0);
        r104.f46793c = this.f46640n;
    }
}
