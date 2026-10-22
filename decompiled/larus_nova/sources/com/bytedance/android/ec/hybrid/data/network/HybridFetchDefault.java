package com.bytedance.android.ec.hybrid.data.network;

import android.os.Looper;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.utils.ECHybridChunkedApiHelper;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import yj.n;

/* JADX INFO: loaded from: classes44.dex */
public final class HybridFetchDefault implements d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f46790k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f46791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f46792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.ec.hybrid.data.g f46793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f46794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f46795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f46796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f46797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f46798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f46799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f46800j;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridFetchDefault f46801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f46802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f46803c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ HashMap f46804d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.hybrid.data.entity.a f46805e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f46806f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f46807g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f46808h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f46809i;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ECHybridNetworkVO f46810a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f46811b;

            public a(ECHybridNetworkVO r100, b r101) {
                this.f46810a = r100;
                this.f46811b = r101;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                b r100 = this.f46811b;     // Catch: Throwable -> L4
                HybridFetchDefault.n(r100.f46801a, this.f46810a, r100.f46808h, (ECHybridMainApiPreferredCallback) r100.f46807g.element, r100.f46805e);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(HybridFetchDefault r100, List r101, List r102, HashMap r103, com.bytedance.android.ec.hybrid.data.entity.a r104, boolean r105, Ref.ObjectRef r106, boolean r107, int r108) {
            this.f46801a = r100;
            this.f46802b = r101;
            this.f46803c = r102;
            this.f46804d = r103;
            this.f46805e = r104;
            this.f46806f = r105;
            this.f46807g = r106;
            this.f46808h = r107;
            this.f46809i = r108;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            List r100 = this.f46802b;
            ArrayList r101 = new ArrayList();
            Iterator r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L27;
            String r103 = (String) r102.next();
            HybridFetchDefault r104 = this.f46801a;
            List r105 = this.f46803c;
            if (r105 != null) goto L8;
        L10:
            boolean r106 = false;
        L11:
            ECHybridNetworkVO r107 = HybridFetchDefault.q(r104, r103, r106, null, false, null, this.f46804d, this.f46805e, 28);
            ECHybridNetworkVO r108 = null;
            if (r107 != null) goto L14;
        L25:
            if (r108 == null) goto L4;
            r101.add(r108);
            goto L4
        L14:
            if (r107.f46675j == false) goto L18;
            if (this.f46806f == false) goto L18;
        L23:
            HybridFetchDefault.n(this.f46801a, r107, this.f46808h, (ECHybridMainApiPreferredCallback) this.f46807g.element, this.f46805e);
            r107 = null;
        L24:
            r108 = r107;
        L18:
            if (((ECHybridMainApiPreferredCallback) this.f46807g.element) == null) goto L24;
            if (Intrinsics.areEqual(r103, "marketing_resource_get") == false) goto L24;
            if (((Boolean) this.f46801a.f46799i.getValue()).booleanValue() == false) goto L24;
        L8:
            if (r105.contains(r103) != true) goto L10;
            r106 = true;
            goto L11
        L27:
            Iterator r109 = r101.iterator();
        L29:
            if (r109.hasNext() == false) goto L43;
            ECHybridNetworkVO r110 = (ECHybridNetworkVO) r109.next();
            a r111 = new a(r110, this);
            if (this.f46809i != 1) goto L38;
            if (r110.f46675j == true) goto L38;
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L38;
            this.f46801a.getClass();
            Single.fromCallable(new e(r111)).subscribeOn(Schedulers.io()).subscribe();
        L38:
            if (Intrinsics.areEqual(r110.f46676k, "negfeedback") == false) goto L42;
            if (((Boolean) this.f46801a.f46800j.getValue()).booleanValue() == false) goto L42;
            HybridFetchDefault r112 = this.f46801a;
            TimeUnit r113 = TimeUnit.SECONDS;
            r112.getClass();
            Single.timer(3, r113).subscribeOn(Schedulers.io()).subscribe(new f(r111), g.f46819a);
        L42:
            r111.run();
            goto L29
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final Map<String, ECHybridNetworkDTO> p() {
        return (Map) this.f46792b.getValue();
    }

    public final ECHybridNetworkFetcher r() {
        return (ECHybridNetworkFetcher) this.f46791a.getValue();
    }

    public HybridFetchDefault() {
        this.f46791a = LazyKt.lazy(HybridFetchDefault$networkFetcher$2.INSTANCE);
        this.f46792b = LazyKt.lazy(HybridFetchDefault$apiKeyToNetworkDTOMap$2.INSTANCE);
        this.f46794d = new ConcurrentHashMap();
        this.f46795e = LazyKt.lazy(HybridFetchDefault$apiPrefetchOptValue$2.INSTANCE);
        this.f46796f = LazyKt.lazy(HybridFetchDefault$apiPrefetchReuseOptEnable$2.INSTANCE);
        this.f46797g = LazyKt.lazy(HybridFetchDefault$apiFetchOptCount$2.INSTANCE);
        this.f46798h = LazyKt.lazy(HybridFetchDefault$firstScreenApiOptAB$2.INSTANCE);
        this.f46799i = LazyKt.lazy(new HybridFetchDefault$enableMarketingResourceApiOpt$2(this));
        this.f46800j = LazyKt.lazy(new HybridFetchDefault$enableDelayFeedbackApiOpt$2(this));
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void f() {
        ECHybridNetworkFetcher r100 = r();
        r100.f().clear();
        Lazy r101 = ECMallNegFeedbackCache.f46789a;
        Iterator<Map.Entry<String, ECHybridNetworkTask>> r102 = r100.e().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        ECHybridNetworkTask r103 = r102.next().getValue();
        ((CopyOnWriteArrayList) r103.c().f46774a.getValue()).clear();
        Disposable r104 = r103.f46770d;
        if (r104 == null) goto L8;
        r104.dispose();
    L8:
        r103.f46767a = true;
        goto L4
    L9:
        r100.e().clear();
        Iterator r105 = ((CopyOnWriteArrayList) r100.f46743c.getValue()).iterator();
    L11:
        if (r105.hasNext() == false) goto L15;
        Disposable r106 = (Disposable) r105.next();
        if (r106.isDisposed() == true) goto L11;
        r106.dispose();
        goto L11
    L15:
        ((CopyOnWriteArrayList) r100.f46743c.getValue()).clear();
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void b(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Iterator<Map.Entry<String, ? extends Object>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<String, ? extends Object> r102 = r101.next();
        if (r102.getValue() == null) goto L7;
        ConcurrentHashMap<String, Object> r103 = this.f46794d;
        String r104 = r102.getKey();
        Object r105 = r102.getValue();
        if (r105 == null) goto L12;
        r103.put(r104, r105);
        goto L4
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());
    L7:
        this.f46794d.remove(r102.getKey());
        goto L4
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        ECHybridNetworkFetcher r101 = r();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        r101.f().remove(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter("homepage", "apiKey");
        ECHybridNetworkFetcher r101 = r();
        r101.getClass();
        Intrinsics.checkNotNullParameter("homepage", "apiKey");
        if (r100 == null) goto L5;
        r101.f().put("homepage", r100);
        return;
    L5:
        r101.f().remove("homepage");
    }

    @Override // com.bytedance.android.ec.hybrid.data.network.d
    public final void k(Map<String, ECHybridNetworkDTO> r100) {
        Intrinsics.checkNotNullParameter(r100, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
        p().putAll(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.data.network.d
    public final void l(com.bytedance.android.ec.hybrid.data.g r100) {
        this.f46793c = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final String m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        ECHybridNetworkFetcher r101 = r();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        return r101.f().get(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void a(List<String> r100, ECHybridNetworkTask.a r101) {
        Intrinsics.checkNotNullParameter(r100, "apiKeyList");
        Intrinsics.checkNotNullParameter(r101, "callback");
        j(r100, null, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void j(List<String> r100, com.bytedance.android.ec.hybrid.data.entity.a r101, ECHybridNetworkTask.a r110) {
        Intrinsics.checkNotNullParameter(r100, "apiKeyList");
        Intrinsics.checkNotNullParameter(r110, "callback");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        Object r104 = r103.next();
        String r105 = (String) r104;
        boolean r106 = p().containsKey(r105);
        if (r106 == true) goto L8;
        r110.e(r105, new Throwable("can not find " + r105 + " in " + p()), null, false);
    L8:
        if (r106 == false) goto L4;
        r102.add(r104);
        goto L4
    L10:
        o(r102, null, false, r110, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.data.network.d
    public final void h(final List<String> r100, ECHybridNetworkTask.a r101, boolean r102, com.bytedance.android.ec.hybrid.data.entity.a r110) {
        Intrinsics.checkNotNullParameter(r100, "prefetchKeys");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r102 == true) goto L5;
    L7:
        o(r100, null, true, r101, r110);
        return;
    L5:
        if (((Boolean) this.f46796f.getValue()).booleanValue() == false) goto L7;
        kk.d.c(new HybridFetchDefault$prefetch$1(this, r100));
        goto L7
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void i(String r110, Map<String, ? extends Object> r111, Map<String, String> r112, ECHybridNetworkTask.a r113) {
        Intrinsics.checkNotNullParameter(r110, "apiKey");
        Intrinsics.checkNotNullParameter(r113, "callback");
        ECHybridNetworkVO r100 = q(this, r110, false, null, false, null, null, null, 124);
        if (r100 == null) goto L10;
        if (r111 == null) goto L6;
        r100.b().putAll(r111);
    L6:
        if (r112 == null) goto L8;
        r100.a().putAll(r112);
    L8:
        ECHybridNetworkFetcher.c(r(), r110, r100, r113);
        return;
    }

    public static final void n(HybridFetchDefault r100, ECHybridNetworkVO r110, boolean r111, ECHybridMainApiPreferredCallback r112, com.bytedance.android.ec.hybrid.data.entity.a r113) {
        r100.getClass();
        if (Intrinsics.areEqual(r110.b().get("page_name"), "personal_homepage_ecom") == true) goto L5;
    L7:
        ECHybridNetworkFetcher r101 = r100.r();
        String r102 = r110.f46676k;
        int r103 = r110.f46674i;
        if (r103 != 0) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L18;
        if (r111 == false) goto L18;
        r112 = null;
    L18:
        r101.b(r102, r110, r112, r111, r113);
        return;
    L10:
        if (r103 == 2) goto L13;
        r104 = false;
        goto L14
    L5:
        if (((Number) r100.f46797g.getValue()).intValue() <= 0) goto L7;
        r110.b().put("count", Integer.valueOf(((Number) r100.f46797g.getValue()).intValue()));
        goto L7
    }

    @Override // com.bytedance.android.ec.hybrid.data.network.d
    public final void e(final List<String> r100, final List<String> r101, ECHybridNetworkTask.a r102, boolean r110, com.bytedance.android.ec.hybrid.data.entity.a r111) {
        Intrinsics.checkNotNullParameter(r100, "prefetchKeys");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r110 == true) goto L5;
    L7:
        o(r100, r101, true, r102, r111);
        return;
    L5:
        if (((Boolean) this.f46796f.getValue()).booleanValue() == false) goto L7;
        kk.d.c(new HybridFetchDefault$prefetch$2(this, r100, r101));
        goto L7
    }

    @Override // com.bytedance.android.ec.hybrid.data.f
    public final void g(String r110, List r111, boolean r112, Map r113, ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1.a r210) {
        Intrinsics.checkNotNullParameter(r110, "tabId");
        Intrinsics.checkNotNullParameter(r111, "apiKeyList");
        Intrinsics.checkNotNullParameter(r210, "callback");
        ArrayList r100 = new ArrayList();
        Iterator r101 = r111.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        String r103 = (String) r102;
        boolean r104 = p().containsKey(r103);
        if (r104 == true) goto L8;
        r210.e(r103, new Throwable("can not find " + r103 + " in " + p()), null, false);
    L8:
        if (r104 == false) goto L4;
        r100.add(r102);
        goto L4
    L10:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r100.iterator();
    L12:
        if (r106.hasNext() == false) goto L19;
        String r114 = (String) r106.next();
        ECHybridNetworkVO r107 = q(this, r114, false, r110, r112, r113, null, null, 96);
        if (r107 == null) goto L16;
        Pair r108 = TuplesKt.to(r114, r107);
    L17:
        if (r108 == null) goto L12;
        r105.add(r108);
        goto L12
    L16:
        r108 = null;
        goto L17
    L19:
        Iterator r109 = r105.iterator();
    L21:
        if (r109.hasNext() == false) goto L23;
        Pair r115 = (Pair) r109.next();
        ECHybridNetworkFetcher.c(r(), (String) r115.getFirst(), (ECHybridNetworkVO) r115.getSecond(), r210);
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, com.bytedance.android.ec.hybrid.data.network.ECHybridMainApiPreferredCallback] */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, com.bytedance.android.ec.hybrid.data.network.ECHybridMainApiPreferredCallback] */
    public final void o(final List<String> r210, final List<String> r211, final boolean r212, ECHybridNetworkTask.a r213, final com.bytedance.android.ec.hybrid.data.entity.a r214) {
        if (((Number) this.f46795e.getValue()).intValue() < 2) goto L5;
        boolean r110 = true;
    L6:
        final Ref.ObjectRef r111 = new Ref.ObjectRef();
        Object r100 = null;
        r111.element = null;
        final HashMap r112 = new HashMap();
        int r101 = com.bytedance.android.ec.hybrid.tools.f.f47635a;
        Object r102 = 0;
        int r103 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L84
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_mall_fetch_execute_opt");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L84
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L84
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L84
        if (r109 != null) goto L91;
        IHybridHostService r113 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L84
        if (r113 == null) goto L74;
        Object r114 = r113.getHostABValue("ec_mall_fetch_execute_opt", r102);     // Catch: Throwable -> L84
    L75:
        if (r114 != null) goto L77;
    L92:
        int r115 = ((Number) r102).intValue();
        final String r116 = "homepage";
        Iterator<T> r117 = r210.iterator();
        String r118 = "";
    L94:
        if (r117.hasNext() == false) goto L105;
        String r119 = (String) r117.next();
        ECHybridNetworkDTO r120 = p().get(r119);
        if (r120 == null) goto L94;
        if (r120.getUrl() == null) goto L94;
        if (r120.getMethod() == null) goto L94;
        if (r120.isMain() != 1) goto L94;
        r111.element = new ECHybridMainApiPreferredCallback(r213, r119);
        r118 = r119;
        goto L94
    L105:
        if (((ECHybridMainApiPreferredCallback) r111.element) != null) goto L107;
        r111.element = new ECHybridMainApiPreferredCallback(r213, r118);
    L107:
        if (r115 == 2) goto L109;
    L115:
        List<String> r121 = r210;
    L116:
        b r122 = new b(this, r121, r211, r112, r214, r110, r111, r212, r115);
        if (r115 == 2) goto L119;
    L124:
        r122.run();
        return;
    L119:
        if (r210.contains("homepage") == false) goto L124;
        if (r121.size() == r210.size()) goto L124;
        Single.fromCallable(new e(r122)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L109:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L115;
        if (r210.contains("homepage") == false) goto L115;
        if (Intrinsics.areEqual(r118, "homepage") == false) goto L115;
        r121 = (List) kk.d.a(r210, new HybridFetchDefault$fetchListInternal$apiKeys$1(this, r116, r211, r112, r214, r212, r111, r210));
        goto L116
    L77:
        if ((r114 instanceof Integer) == false) goto L80;
        r100 = r114;
    L80:
        Object r123 = (Integer) r100;     // Catch: Throwable -> L84
        if (r123 == null) goto L92;
        r102 = r123;
        goto L92
    L74:
        r114 = null;
    L91:
        r102 = r109;
        goto L92
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r124 = null;
    L15:
        r106 = (Integer) r124;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r125 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r125 instanceof Integer) == true) goto L25;
        r125 = null;
    L25:
        r106 = (Integer) r125;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r126 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r126 instanceof Integer) == true) goto L31;
        r126 = null;
    L31:
        r106 = (Integer) r126;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r127 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r127 instanceof Integer) == true) goto L40;
        r127 = null;
    L40:
        r106 = (Integer) r127;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L126:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r128 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r128 instanceof Integer) == true) goto L48;
        r128 = null;
    L48:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L50
    L52:
        r106 = r129;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L57
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r124 = r105;
    L57:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L84
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r133 = Result.m9452exceptionOrNullimpl(r109);
        if (r133 == null) goto L89;
        EnsureManager.ensureNotReachHere(r133);
    L89:
        if (Result.m9455isFailureimpl(r109) == false) goto L91;
    L5:
        r110 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ECHybridNetworkVO q(HybridFetchDefault r110, String r111, boolean r112, String r210, boolean r211, Map r212, HashMap r213, com.bytedance.android.ec.hybrid.data.entity.a r214, int r215) {
        if ((r215 & 4) == 0) goto L5;
        String r100 = null;
    L6:
        boolean r101 = false;
        if ((r215 & 8) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r215 & 16) == 0) goto L13;
        Map r103 = null;
    L15:
        if ((r215 & 32) == 0) goto L17;
        HashMap r104 = null;
    L19:
        if ((r215 & 64) == 0) goto L21;
        com.bytedance.android.ec.hybrid.data.entity.a r105 = null;
    L22:
        ECHybridNetworkDTO r113 = r110.p().get(r111);
        if (r113 == null) goto L34;
        com.bytedance.android.ec.hybrid.data.g r106 = r110.f46793c;
        if (r106 == null) goto L28;
        Map<String, Object> r114 = r106.a(r111);
    L29:
        if (r114 == null) goto L31;
        Object r107 = r114.get("is_ai_prefetch");
    L32:
        ECHybridNetworkVO r115 = r113.transformToVO(r111, Intrinsics.areEqual(r107, "1"));
        if (r115 == null) goto L34;
        List<String> r108 = r113.getClientHeaderKeys();
        if (r108 == null) goto L43;
        Iterator<T> r109 = r108.iterator();
    L39:
        if (r109.hasNext() == false) goto L43;
        String r116 = (String) r109.next();
        com.bytedance.android.ec.hybrid.data.g r117 = r110.f46793c;
        if (r117 == null) goto L39;
        r115.a().putAll(r117.d(r116));
    L43:
        r115.b().putAll(r110.f46794d);
        int r118 = com.bytedance.android.ec.hybrid.tools.f.f47635a;
        Object r119 = 0;
        int r120 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L119
        Object r122 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_tab_opt_interface_params_reuse");     // Catch: Throwable -> L94
        if (r122 != null) goto L49;
    L91:
        Object r123 = null;
    L92:
        Object r124 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L94
    L96:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);     // Catch: Throwable -> L119
        if (r125 == null) goto L100;
        EnsureManager.ensureNotReachHere(r125);     // Catch: Throwable -> L119
    L100:
        if (Result.m9455isFailureimpl(r124) == false) goto L103;
        r124 = null;
    L103:
        if ((r124 instanceof Integer) == true) goto L105;
        r124 = null;
    L105:
        Object r126 = (Integer) r124;     // Catch: Throwable -> L119
        if (r126 != null) goto L126;
        IHybridHostService r127 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L119
        if (r127 == null) goto L111;
        Object r128 = r127.getHostABValue("mall_tab_opt_interface_params_reuse", r119);     // Catch: Throwable -> L119
    L112:
        if (r128 != null) goto L114;
    L128:
        if (((Number) r119).intValue() != 1) goto L157;
        if (r104 != null) goto L131;
    L134:
        boolean r129 = true;
    L135:
        if (r129 == true) goto L137;
        r114 = r104;
    L144:
        if (r104 != null) goto L146;
    L149:
        boolean r130 = true;
    L150:
        if (r130 == true) goto L154;
        com.bytedance.android.ec.hybrid.data.g r131 = r110.f46793c;
        if (r131 == null) goto L154;
        Intrinsics.checkNotNull(r114);
        r131.g(r114, r111);
    L154:
        if (r114 == null) goto L164;
        if (r104 == null) goto L164;
        r104.putAll(r114);
    L164:
        if (r105 == null) goto L166;
        Boolean r132 = r105.f46681c;
    L167:
        Boolean r133 = Boolean.TRUE;
        if (Intrinsics.areEqual(r132, r133) == true) goto L170;
    L173:
        Lazy r134 = ECMallLogUtil.f47441a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "getFullNetworkVO, extraApplier = " + r110.f46793c + ", extraParams = " + r114);
        if (r114 == null) goto L197;
        List<String> r135 = r113.getClientParamKeys();
        if (r135 == null) goto L197;
        Iterator<T> r136 = r135.iterator();
    L179:
        if (r136.hasNext() == false) goto L197;
        String r137 = (String) r136.next();
        Object r138 = r114.get(r137);
        if (r138 == null) goto L184;
        r115.b().put(r137, r138);
    L184:
        if (Intrinsics.areEqual(r137, "plan_report_records") == false) goto L179;
        com.bytedance.android.ec.hybrid.data.g r139 = r110.f46793c;
        if (r139 == null) goto L188;
        Map<String, Object> r140 = r139.c(CollectionsKt.listOf("popup_frequency_record"));
    L189:
        if (r140 == null) goto L179;
        if (r140.containsKey("popup_frequency_record") != true) goto L179;
        Map<String, Object> r141 = r115.b();
        Object r142 = r140.get("popup_frequency_record");
        if (r142 != null) goto L195;
        r142 = CollectionsKt.emptyList();
    L195:
        r141.put("plan_report_records", r142);
        goto L179
    L188:
        r140 = null;
    L197:
        if (r102 == false) goto L204;
        if (r100 == null) goto L204;
        com.bytedance.android.ec.hybrid.data.g r143 = r110.f46793c;
        if (r143 == null) goto L242;
        Map<String, Object> r144 = r143.e(r100, r111);
        if (r144 == null) goto L242;
        Lazy r145 = ECMallLogUtil.f47441a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "getFullNetworkVO, extraApplier = " + r110.f46793c + ", dynamicParams = " + r114);
        r115.b().putAll(r144);
    L242:
        List<String> r146 = r113.getStorageKeys();     // Catch: Exception -> L217
        if (r146 == null) goto L218;
        com.bytedance.android.ec.hybrid.data.g r147 = r110.f46793c;     // Catch: Exception -> L217
        if (r147 == null) goto L218;
        Map<String, Object> r148 = r147.c(r146);     // Catch: Exception -> L217
        if (r148 == null) goto L218;
        r115.b().put("storage", new Gson().toJson(r148));     // Catch: Exception -> L217
    L218:
        LinkedHashMap r149 = new LinkedHashMap();
        Lazy r150 = HybridAppInfoService.f47530a;
        if (HybridAppInfoService.m() == false) goto L221;
        Map<String, Object> r151 = r115.b();
        r151.put("ecom_page_type", "native");
        r151.put("ecom_appid", "7386");
        r151.put("ecom_sdk_version", String.valueOf(44700));
        Map<String, String> r152 = r115.a();
        r152.put("ecom_page_type", "native");
        r152.put("ecom_appid", "7386");
        r152.put("ecom_sdk_version", String.valueOf(44700));
    L221:
        IHybridHostService r153 = com.bytedance.android.ec.hybrid.a.h();
        if (r153 == null) goto L228;
        n r154 = r153.getIHybridHostNetService();
        if (r154 == null) goto L228;
        Map<String, String> r155 = r154.b();
        if (r155 == null) goto L228;
        r149.putAll(r155);
    L228:
        r115.a().putAll(r149);
        IHybridHostService r156 = com.bytedance.android.ec.hybrid.a.h();
        if (r156 == null) goto L235;
        n r157 = r156.getIHybridHostNetService();
        if (r157 == null) goto L235;
        Map<String, String> r158 = r157.commonParams();
        if (r158 == null) goto L235;
        r115.b().putAll(r158);
    L235:
        Lazy r159 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "getFullNetworkVO, apikey = " + r111 + ", params = " + r115.b());
        if (r112 == false) goto L238;
        Lazy r160 = ECHybridChunkedApiHelper.f46820a;
        r101 = ECHybridChunkedApiHelper.c(r115);
    L238:
        r115.f46666a = r101;
        return r115;
    L204:
        com.bytedance.android.ec.hybrid.data.g r161 = r110.f46793c;
        if (r161 == null) goto L242;
        Map<String, Object> r162 = r161.f(r111, r114);
        if (r162 == null) goto L242;
        Lazy r163 = ECMallLogUtil.f47441a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "getFullNetworkVO, extraApplier = " + r110.f46793c + ", dynamicParams = " + r114);
        r115.b().putAll(r162);
        goto L242
    L170:
        if (Intrinsics.areEqual(r111, "favorite_feed") == false) goto L173;
        if (r114 == null) goto L173;
        r114.put("is_load_more", r133);
        goto L173
    L166:
        r132 = null;
        goto L167
    L146:
        if (r104.isEmpty() == true) goto L149;
        r130 = false;
        goto L150
    L137:
        if (r103 != null) goto L139;
        if (r102 == false) goto L144;
    L139:
        if (r100 == null) goto L144;
        com.bytedance.android.ec.hybrid.data.g r164 = r110.f46793c;
        if (r164 == 0) goto L143;
        r114 = r164.b(r100, r111, r103);
        goto L144
    L143:
        r114 = null;
        goto L144
    L131:
        if (r104.isEmpty() == true) goto L134;
        r129 = false;
        goto L135
    L157:
        if (r103 != null) goto L159;
        if (r102 == false) goto L164;
    L159:
        if (r100 == null) goto L164;
        com.bytedance.android.ec.hybrid.data.g r165 = r110.f46793c;
        if (r165 == 0) goto L163;
        r114 = r165.b(r100, r111, r103);
        goto L164
    L163:
        r114 = null;
        goto L164
    L114:
        if ((r128 instanceof Integer) == true) goto L116;
        r128 = null;
    L116:
        r126 = (Integer) r128;     // Catch: Throwable -> L119
        if (r126 != null) goto L126;
    L111:
        r128 = null;
    L126:
        r119 = r126;
        goto L128
    L49:
        if ((r122 instanceof Integer) == true) goto L51;
        Object r166 = null;
    L52:
        r123 = (Integer) r166;     // Catch: Throwable -> L94
        if (r123 != null) goto L92;
        if ((r122 instanceof Number) == false) goto L79;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L64;
        Float r167 = Float.valueOf(((Number) r122).floatValue());     // Catch: Throwable -> L94
        if ((r167 instanceof Integer) == true) goto L62;
        r167 = null;
    L62:
        r123 = (Integer) r167;     // Catch: Throwable -> L94
        goto L92
    L64:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L70;
        Double r168 = Double.valueOf(((Number) r122).doubleValue());     // Catch: Throwable -> L94
        if ((r168 instanceof Integer) == true) goto L68;
        r168 = null;
    L68:
        r123 = (Integer) r168;     // Catch: Throwable -> L94
        goto L92
    L70:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L73;
        r123 = Integer.valueOf(((Number) r122).intValue());     // Catch: Throwable -> L94
        goto L92
    L73:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L79;
        Long r169 = Long.valueOf(((Number) r122).longValue());     // Catch: Throwable -> L94
        if ((r169 instanceof Integer) == true) goto L77;
        r169 = null;
    L77:
        r123 = (Integer) r169;     // Catch: Throwable -> L94
    L79:
        if ((r122 instanceof JSONObject) == false) goto L81;
    L246:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L87
        Object r170 = SDKSettingsCacheManager.a().fromJson(r122.toString(), Integer.class);     // Catch: Throwable -> L87
        if ((r170 instanceof Integer) == true) goto L85;
        r170 = null;
    L85:
        Object r171 = Result.m9449constructorimpl((Integer) r170);     // Catch: Throwable -> L87
    L89:
        r123 = r171;
        if (Result.m9455isFailureimpl(r123) == false) goto L92;
    L87:
        th = move-exception;
        Result.Companion r172 = Result.Companion;     // Catch: Throwable -> L94
        r171 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L94
        goto L89
    L81:
        if ((r122 instanceof JSONArray) == false) goto L91;
    L51:
        r166 = r122;
    L94:
        th = move-exception;
        Result.Companion r173 = Result.Companion;     // Catch: Throwable -> L119
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L119
    L119:
        th = move-exception;
        Result.Companion r174 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r175 = Result.m9452exceptionOrNullimpl(r126);
        if (r175 == null) goto L124;
        EnsureManager.ensureNotReachHere(r175);
    L124:
        if (Result.m9455isFailureimpl(r126) == false) goto L126;
    L31:
        r107 = null;
        goto L32
    L28:
        r114 = null;
    L34:
        return null;
    L21:
        r105 = r214;
        goto L22
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L6
    }
}
