package com.bytedance.android.ec.hybrid.data.network;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.data.ECHybridRequestSchedulerTransformConfig;
import com.bytedance.android.ec.hybrid.data.ECHybridRequestTransformConfig;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yj.n;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridNetworkTask {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f46759h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f46760i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f46761j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f46762k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f46763l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f46764m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f46765n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f46766o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f46767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f46768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f46769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f46770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f46771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECHybridNetworkVO f46772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f46773g;

    public static final class CallbackList implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f46774a;

        public CallbackList() {
            this.f46774a = LazyKt.lazy(ECHybridNetworkTask$CallbackList$list$2.INSTANCE);
        }

        @Override // com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask.a
        public final void c(String r100, String r101, ECHybridNetworkVO r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "apiKey");
            Intrinsics.checkNotNullParameter(r101, "result");
            Intrinsics.checkNotNullParameter(r102, "requestVO");
            Iterator r104 = ((CopyOnWriteArrayList) this.f46774a.getValue()).iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            ((a) r104.next()).c(r100, r101, r102, r103);
            goto L4
        }

        @Override // com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask.a
        public final void d(String r100, String r101, ECHybridNetworkVO r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "apiKey");
            Intrinsics.checkNotNullParameter(r101, "result");
            Intrinsics.checkNotNullParameter(r102, "requestVO");
            Iterator r104 = ((CopyOnWriteArrayList) this.f46774a.getValue()).iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            ((a) r104.next()).d(r100, r101, r102, r103);
            goto L4
        }

        @Override // com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask.a
        public final void e(String r100, Throwable r101, ECHybridNetworkVO r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "apiKey");
            Intrinsics.checkNotNullParameter(r101, "t");
            Iterator r104 = ((CopyOnWriteArrayList) this.f46774a.getValue()).iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            ((a) r104.next()).e(r100, r101, r102, r103);
            goto L4
        }

        @Override // com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask.a
        public final void f(String r100, String r101, ECHybridNetworkVO r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "apiKey");
            Intrinsics.checkNotNullParameter(r101, "result");
            Intrinsics.checkNotNullParameter(r102, "requestVO");
            a.C0818a.b(r100, r101, r102);
        }
    }

    public static final class ChunkObserver implements com.bytedance.android.chunkstreamprediction.network.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f46775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f46776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f46777c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ECHybridNetworkVO f46778d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f46779e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final CallbackList f46780f;

        @Override // com.bytedance.android.chunkstreamprediction.network.a
        public final void onComplete() {
            Lazy r100 = ECMallLogUtil.f47441a;
            ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "ChunkObserver#onComplete(), apiKey = " + this.f46777c + ", networkVO = " + this.f46778d + ", isPrefetchMode = " + this.f46779e);
            ECHybridExtensionsKt.f(new ECHybridNetworkTask$ChunkObserver$onComplete$1(this));
        }

        @Override // com.bytedance.android.chunkstreamprediction.network.a
        public final void onFailed(final Throwable r100) {
            Lazy r101 = ECMallLogUtil.f47441a;
            ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "ChunkObserver#onFailed(), apiKey = " + this.f46777c + ", networkVO = " + this.f46778d + ", isPrefetchMode = " + this.f46779e + ", error = " + r100);
            ECHybridExtensionsKt.f(new ECHybridNetworkTask$ChunkObserver$onFailed$1(this, r100));
        }

        @Override // com.bytedance.android.chunkstreamprediction.network.a
        public final void onNext(String r100) {
            long r101 = System.currentTimeMillis();
            Lazy r102 = ECMallLogUtil.f47441a;
            ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "ChunkObserver#onNext(), timestamp = " + r101 + ", apiKey = " + this.f46777c + ", networkVO = " + this.f46778d + ", isPrefetchMode = " + this.f46779e);
            ECHybridNetworkTask$ChunkObserver$onNext$callbackBlock$1 r103 = new ECHybridNetworkTask$ChunkObserver$onNext$callbackBlock$1(this, r100, r101);
            if (((Boolean) this.f46775a.getValue()).booleanValue() == false) goto L5;
            ((CopyOnWriteArrayList) this.f46776b).add(new c(r103));
            ECHybridExtensionsKt.g(new ECHybridNetworkTask$ChunkObserver$onNext$1(this));
            return;
        L5:
            ECHybridExtensionsKt.g(r103);
        }

        public ChunkObserver(String r100, ECHybridNetworkVO r101, boolean r102, CallbackList r103) {
            Intrinsics.checkNotNullParameter(r100, "apiKey");
            Intrinsics.checkNotNullParameter(r101, "networkVO");
            Intrinsics.checkNotNullParameter(r103, "callbackList");
            this.f46777c = r100;
            this.f46778d = r101;
            this.f46779e = r102;
            this.f46780f = r103;
            this.f46775a = LazyKt.lazy(ECHybridNetworkTask$ChunkObserver$isStrictOrder$2.INSTANCE);
            this.f46776b = new CopyOnWriteArrayList();
        }
    }

    public interface a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask$a$a, reason: collision with other inner class name */
        public static final class C0818a {
            public static void b(String r100, String r101, ECHybridNetworkVO r102) {
                Intrinsics.checkNotNullParameter(r100, "apiKey");
                Intrinsics.checkNotNullParameter(r101, "result");
                Intrinsics.checkNotNullParameter(r102, "requestVO");
            }

            public static void c(String r100, String r101, ECHybridNetworkVO r102) {
                Intrinsics.checkNotNullParameter(r100, "apiKey");
                Intrinsics.checkNotNullParameter(r101, "result");
                Intrinsics.checkNotNullParameter(r102, "requestVO");
            }

            public static /* synthetic */ void a(a r100, String r101, Throwable r102, ECHybridNetworkVO r103) {
                r100.e(r101, r102, r103, false);
            }
        }

        void c(String r100, String r101, ECHybridNetworkVO r102, boolean r103);

        void d(String r100, String r101, ECHybridNetworkVO r102, boolean r103);

        void e(String r100, Throwable r101, ECHybridNetworkVO r102, boolean r103);

        void f(String r100, String r101, ECHybridNetworkVO r102, boolean r103);
    }

    public static final class b {
        public static final ECHybridRequestSchedulerTransformConfig a() {
            Lazy r100 = ECHybridNetworkTask.f46759h;
            return (ECHybridRequestSchedulerTransformConfig) ECHybridNetworkTask.f46759h.getValue();
        }

        public b() {
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f46781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f46782b;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.f46781a == true) goto L10;
            this.f46781a = true;     // Catch: Throwable -> L7
            this.f46782b.invoke();     // Catch: Throwable -> L7
            return;
        }

        public c(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "once");
            this.f46782b = r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHybridNetworkTask f46783a;

        public d(ECHybridNetworkTask r100) {
            this.f46783a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.chunkstreamprediction.network.b r101 = (com.bytedance.android.chunkstreamprediction.network.b) r100;
            ECHybridNetworkTask r102 = this.f46783a;     // Catch: IOException -> L5
            r101.a(new ChunkObserver(r102.f46771e, r102.f46772f, r102.f46773g, r102.c()));     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            ECHybridExtensionsKt.f(new ECHybridNetworkTask$run$3$1(this, e));
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f46784a = null;

        static {
            f46784a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            com.bytedance.android.chunkstreamprediction.network.b r101 = (com.bytedance.android.chunkstreamprediction.network.b) r100;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHybridNetworkTask f46785a;

        public f(ECHybridNetworkTask r100) {
            this.f46785a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            final Throwable r101 = (Throwable) r100;
            ECHybridExtensionsKt.f(new ECHybridNetworkTask$run$5$1(this, r101));
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHybridNetworkTask f46786a;

        public g(ECHybridNetworkTask r100) {
            this.f46786a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CallbackList r101 = this.f46786a.c();
            ECHybridNetworkTask r102 = this.f46786a;
            String r103 = r102.f46771e;
            r101.c(r103, (String) r100, r102.f46772f, r102.f46773g);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHybridNetworkTask f46787a;

        public h(ECHybridNetworkTask r100) {
            this.f46787a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            final String r101 = (String) r100;
            Lazy r102 = ECHybridNetworkTask.f46759h;
            if (((Number) ECHybridNetworkTask.f46766o.getValue()).intValue() == 1) goto L5;
            ECHybridExtensionsKt.f(new ECHybridNetworkTask$run$7$2(this, r101));
            return;
        L5:
            ECHybridExtensionsKt.h(new ECHybridNetworkTask$run$7$1(this, r101));
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHybridNetworkTask f46788a;

        public i(ECHybridNetworkTask r100) {
            this.f46788a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            final Throwable r101 = (Throwable) r100;
            Lazy r102 = ECHybridNetworkTask.f46759h;
            if (((Number) ECHybridNetworkTask.f46766o.getValue()).intValue() == 1) goto L5;
            ECHybridExtensionsKt.f(new ECHybridNetworkTask$run$8$2(this, r101));
            return;
        L5:
            ECHybridExtensionsKt.h(new ECHybridNetworkTask$run$8$1(this, r101));
        }
    }

    public final CallbackList c() {
        return (CallbackList) this.f46769c.getValue();
    }

    static {
        new b();
        f46759h = LazyKt.lazy(ECHybridNetworkTask$Companion$requestSchedulerTransformConfig$2.INSTANCE);
        f46760i = LazyKt.lazy(ECHybridNetworkTask$Companion$singleThreadScheduler$2.INSTANCE);
        f46761j = LazyKt.lazy(ECHybridNetworkTask$Companion$threadPoolScheduler$2.INSTANCE);
        f46762k = LazyKt.lazy(ECHybridNetworkTask$Companion$requestMethodConfig$2.INSTANCE);
        f46763l = LazyKt.lazy(ECHybridNetworkTask$Companion$requestQueryStringifyOptEnable$2.INSTANCE);
        f46764m = LazyKt.lazy(ECHybridNetworkTask$Companion$requestBodyToJsonOptEnable$2.INSTANCE);
        f46765n = LazyKt.lazy(ECHybridNetworkTask$Companion$requestBodyTransformOptEnable$2.INSTANCE);
        f46766o = LazyKt.lazy(ECHybridNetworkTask$Companion$prefetchCallBackType$2.INSTANCE);
    }

    public final void d() {
        if (this.f46767a == false) goto L6;
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, this.f46771e + " is canceled, ignore run, isChunked = " + this.f46772f.f46666a + ", vo = " + this.f46772f);
        return;
    L6:
        List<String> r101 = b.a().getSingleThreadUrls();
        if (r101 != null) goto L9;
    L11:
        List<String> r102 = b.a().getThreadPoolUrls();
        if (r102 != null) goto L14;
    L16:
        Pair r103 = TuplesKt.to(Schedulers.io(), "IOScheduler");
    L17:
        Scheduler r104 = (Scheduler) r103.component1();
        String r105 = (String) r103.component2();
        Lazy r106 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "start fetch, scheduler: " + r105 + ", apiKey: " + this.f46771e + ", vo: " + this.f46772f + ", isChunked = " + this.f46772f.f46666a);
        ECHybridRequestTransformConfig.TransformStrategy r107 = ((ECHybridRequestTransformConfig) f46762k.getValue()).transformStrategyOf(this.f46772f.f46672g);
        n r108 = null;
        if (r107 == null) goto L20;
        String r109 = r107.getMethod();
    L21:
        boolean r110 = false;
        if (r109 != null) goto L24;
    L32:
        if (r107 == null) goto L34;
        Map<String, String> r111 = r107.getHeaders();
    L35:
        if (r111 != null) goto L37;
    L40:
        boolean r112 = true;
    L41:
        if (r112 == true) goto L43;
        this.f46772f.a().putAll(r111);
    L43:
        if (r107 == null) goto L45;
        Map<String, Object> r113 = r107.getParams();
    L46:
        if (r113 != null) goto L48;
    L51:
        boolean r114 = true;
    L52:
        if (r114 == true) goto L54;
        this.f46772f.b().putAll(r113);
    L54:
        if (r107 == null) goto L56;
        Boolean r115 = Boolean.valueOf(r107.getTransferFormData());
    L58:
        if (r115 == null) goto L61;
        this.f46772f.f46677l = r115.booleanValue();
    L67:
        if (r107 == null) goto L69;
        List<String> r116 = r107.getMigrateToBodyParams();
    L70:
        ECHybridNetworkVO r117 = this.f46772f;
        if (r117.f46667b == false) goto L88;
        if (StringsKt.equals(r117.f46673h, UGCMonitor.TYPE_POST, true) == false) goto L88;
        List<String> r118 = r116;
        if (r118 != null) goto L77;
    L78:
        r110 = true;
    L79:
        if (r110 == true) goto L88;
        LinkedHashMap r119 = new LinkedHashMap();
        Iterator<T> r120 = r116.iterator();
    L82:
        if (r120.hasNext() == false) goto L86;
        String r121 = (String) r120.next();
        Object r122 = this.f46772f.b().remove(r121);
        if (r122 == null) goto L82;
        r119.put(r121, r122);
        goto L82
    L86:
        this.f46772f.f46670e = r119;
        goto L88
    L77:
        if (r118.isEmpty() == false) goto L79;
    L88:
        if (this.f46772f.f46666a == false) goto L127;
        IHybridHostService r123 = com.bytedance.android.ec.hybrid.a.h();
        if (r123 == null) goto L92;
        r108 = r123.getIHybridHostNetService();
    L92:
        if (r108 != null) goto L94;
        Observable<com.bytedance.android.chunkstreamprediction.network.b<String>> r124 = Observable.error(new Throwable("can't find networkService"));
    L124:
        Disposable r125 = r124.doOnNext(new d(this)).subscribeOn(r104).observeOn(AndroidSchedulers.mainThread()).subscribe(e.f46784a, new f(this));
    L164:
        this.f46770d = r125;
        return;
    L94:
        Map<String, Object> r126 = this.f46772f.b();
        Map<String, Object> r127 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r128 = r126.entrySet().iterator();
    L96:
        if (r128.hasNext() == false) goto L100;
        Map.Entry<String, Object> r129 = r128.next();
        if ((!Intrinsics.areEqual(r129.getValue(), "")) == false) goto L96;
        r127.put(r129.getKey(), r129.getValue());
        goto L96
    L100:
        this.f46772f.a().put("X-nx-chunk", "1.0");
        this.f46772f.a().put("E-Api-Chunk", "1");
        String r130 = this.f46772f.f46673h;
        Locale r131 = Locale.ROOT;
        if (r130 == null) goto L126;
        String r132 = r130.toLowerCase(r131);
        int r133 = r132.hashCode();
        if (r133 == 102230) goto L117;
        if (r133 == 3446944) goto L107;
    L123:
        r124 = Observable.error(new Throwable("illegal method name: " + this.f46772f.f46673h));
        goto L124
    L107:
        if (r132.equals(UGCMonitor.TYPE_POST) == false) goto L123;
        Map<String, ? extends Object> r134 = this.f46772f.f46670e;
        if (r134 != null) goto L111;
        Pair r135 = TuplesKt.to(new LinkedHashMap(), r127);
    L112:
        Map r136 = (Map) r135.component1();
        final Map r137 = (Map) r135.component2();
        ECHybridNetworkVO r138 = this.f46772f;
        if (r138.f46677l == false) goto L115;
        IECHybridNetworkApi r139 = (IECHybridNetworkApi) r108.create(r138.f46672g, IECHybridNetworkApi.class, new ECHybridChunkedDataConverterFactory(), this.f46772f.b());
        ECHybridNetworkVO r140 = this.f46772f;
        r124 = r139.postFormChunked(r140.f46672g, this.f46768b, r140.a(), b(r136), b(r137));
        goto L124
    L115:
        JsonObject r141 = (JsonObject) kk.d.b(new ECHybridNetworkTask$getNetworkObservableChunked$body$1(r137), new ECHybridNetworkTask$getNetworkObservableChunked$body$2(r137));
        IECHybridNetworkApi r142 = (IECHybridNetworkApi) r108.create(this.f46772f.f46672g, IECHybridNetworkApi.class, new ECHybridChunkedDataConverterFactory(), this.f46772f.b());
        ECHybridNetworkVO r143 = this.f46772f;
        r124 = r142.postChunked(r143.f46672g, this.f46768b, r143.a(), b(r136), r141);
        goto L124
    L111:
        r135 = TuplesKt.to(r127, r134);
        goto L112
    L117:
        if (r132.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L123;
        IECHybridNetworkApi r144 = (IECHybridNetworkApi) r108.create(this.f46772f.f46672g, IECHybridNetworkApi.class, new ECHybridChunkedDataConverterFactory(), this.f46772f.b());
        ECHybridNetworkVO r145 = this.f46772f;
        String r146 = r145.f46672g;
        String r147 = this.f46768b;
        Map<String, String> r148 = r145.a();
        if (((Boolean) f46763l.getValue()).booleanValue() == false) goto L122;
        r127 = b(r127);
    L122:
        r124 = r144.getChunked(r146, r147, r148, r127);
        goto L124
    L126:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L127:
        IHybridHostService r149 = com.bytedance.android.ec.hybrid.a.h();
        if (r149 == null) goto L130;
        n r150 = r149.getIHybridHostNetService();
    L131:
        if (r150 != null) goto L133;
        Observable<String> r151 = Observable.error(new Throwable("can't find networkService"));
    L163:
        r125 = r151.doOnNext(new g(this)).subscribeOn(r104).subscribe(new h(this), new i(this));
        goto L164
    L133:
        Map<String, Object> r152 = this.f46772f.b();
        Map<String, Object> r153 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r154 = r152.entrySet().iterator();
    L135:
        if (r154.hasNext() == false) goto L139;
        Map.Entry<String, Object> r155 = r154.next();
        if ((!Intrinsics.areEqual(r155.getValue(), "")) == false) goto L135;
        r153.put(r155.getKey(), r155.getValue());
        goto L135
    L139:
        Lazy r156 = ECMallLogUtil.f47441a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "getNetworkObservable, url = " + this.f46772f.f46672g + ", cookie = " + this.f46768b + ", query = " + r153);
        String r157 = this.f46772f.f46673h;
        Locale r158 = Locale.ROOT;
        if (r157 == null) goto L167;
        String r159 = r157.toLowerCase(r158);
        int r160 = r159.hashCode();
        if (r160 == 102230) goto L156;
        if (r160 == 3446944) goto L146;
    L162:
        r151 = Observable.error(new Throwable("illegal method name: " + this.f46772f.f46673h));
        goto L163
    L146:
        if (r159.equals(UGCMonitor.TYPE_POST) == false) goto L162;
        Map<String, ? extends Object> r161 = this.f46772f.f46670e;
        if (r161 != null) goto L150;
        Pair r162 = TuplesKt.to(new LinkedHashMap(), r153);
    L151:
        Map r163 = (Map) r162.component1();
        final Map r164 = (Map) r162.component2();
        ECHybridNetworkVO r165 = this.f46772f;
        if (r165.f46677l == false) goto L154;
        IECHybridNetworkApi r166 = (IECHybridNetworkApi) r150.create(r165.f46672g, IECHybridNetworkApi.class, null, r165.b());
        ECHybridNetworkVO r167 = this.f46772f;
        r151 = r166.postForm(r167.f46672g, this.f46768b, r167.a(), b(r163), b(r164));
        goto L163
    L154:
        JsonObject r168 = (JsonObject) kk.d.b(new ECHybridNetworkTask$getNetworkObservable$body$1(r164), new ECHybridNetworkTask$getNetworkObservable$body$2(r164));
        ECHybridNetworkVO r169 = this.f46772f;
        IECHybridNetworkApi r170 = (IECHybridNetworkApi) r150.create(r169.f46672g, IECHybridNetworkApi.class, null, r169.b());
        ECHybridNetworkVO r171 = this.f46772f;
        r151 = r170.post(r171.f46672g, this.f46768b, r171.a(), b(r163), r168);
        goto L163
    L150:
        r162 = TuplesKt.to(r153, r161);
        goto L151
    L156:
        if (r159.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L162;
        ECHybridNetworkVO r172 = this.f46772f;
        IECHybridNetworkApi r173 = (IECHybridNetworkApi) r150.create(r172.f46672g, IECHybridNetworkApi.class, null, r172.b());
        ECHybridNetworkVO r174 = this.f46772f;
        String r175 = r174.f46672g;
        String r176 = this.f46768b;
        Map<String, String> r177 = r174.a();
        if (((Boolean) f46763l.getValue()).booleanValue() == false) goto L161;
        r153 = b(r153);
    L161:
        r151 = r173.get(r175, r176, r177, r153);
        goto L163
    L167:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L130:
        r150 = null;
        goto L131
    L69:
        r116 = null;
        goto L70
    L61:
        if (((Boolean) f46765n.getValue()).booleanValue() == false) goto L67;
        if (StringsKt.equals(this.f46772f.f46673h, UGCMonitor.TYPE_POST, true) == false) goto L67;
        if (this.f46772f.f46677l == true) goto L67;
        kk.d.c(new ECHybridNetworkTask$run$1(this));
        goto L67
    L56:
        r115 = null;
        goto L58
    L48:
        if (r113.isEmpty() == true) goto L51;
        r114 = false;
        goto L52
    L45:
        r113 = null;
        goto L46
    L37:
        if (r111.isEmpty() == true) goto L40;
        r112 = false;
        goto L41
    L34:
        r111 = null;
        goto L35
    L24:
        if (r109.length() <= 0) goto L26;
        boolean r178 = true;
    L27:
        if (r178 != true) goto L32;
        if (StringsKt.equals(this.f46772f.f46673h, r109, true) == true) goto L31;
        this.f46772f.f46667b = true;
    L31:
        ECHybridNetworkVO r179 = this.f46772f;
        r179.getClass();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r179.f46673h = r109;
        goto L32
    L26:
        r178 = false;
        goto L27
    L20:
        r109 = null;
        goto L21
    L14:
        if (r102.contains(this.f46772f.f46672g) != true) goto L16;
        r103 = TuplesKt.to((Scheduler) f46761j.getValue(), "ThreadPoolScheduler");
        goto L17
    L9:
        if (r101.contains(this.f46772f.f46672g) != true) goto L11;
        r103 = TuplesKt.to((Scheduler) f46760i.getValue(), "SingleThreadScheduler");
        goto L17
    }

    public static Map b(final Map r100) {
        return (Map) kk.d.b(new ECHybridNetworkTask$convertToStringifyParams$1(r100), new ECHybridNetworkTask$convertToStringifyParams$2(r100));
    }

    public final void a(a r100) {
        if (r100 == null) goto L5;
        CallbackList r101 = c();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "cb");
        ((CopyOnWriteArrayList) r101.f46774a.getValue()).add(r100);
        return;
    }

    public ECHybridNetworkTask(String r100, ECHybridNetworkVO r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r101, "networkVO");
        this.f46771e = r100;
        this.f46772f = r101;
        this.f46773g = r102;
        this.f46769c = LazyKt.lazy(ECHybridNetworkTask$callbackList$2.INSTANCE);
    }
}
