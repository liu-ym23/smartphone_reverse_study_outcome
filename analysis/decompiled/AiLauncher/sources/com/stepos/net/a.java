package com.stepos.net;

import D7.b;
import E7.d;
import E7.f;
import E7.g;
import E7.h;
import E7.i;
import E7.k;
import G7.HttpMetrics;
import G7.e;
import J7.c;
import La.D;
import La.H;
import Y8.t;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.GsonBuilder;
import com.stepos.net.HttpConfig;
import com.stepos.net.cache.CacheTagStore;
import com.stepos.net.exception.ApiException;
import com.stepos.net.response.BaseResponseTypeAdapterFactory;
import com.stepos.net.token.TokenAuthenticator;
import com.stepos.net.token.TokenProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import tb.C5541h;
import tb.C5544k;
import tb.C5548o;
import tb.InterfaceC5549p;
import tb.z;
import yc.h;
import yc.w;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\nJ\u0017\u0010\"\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\"\u0010\u000fJ\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0004\b'\u0010(J'\u0010+\u001a\u00020\u0002*\u00020\u00022\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0)H\u0002¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010/R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u00102R \u00105\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0001018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u00102R\u0014\u00107\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u00106R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010.R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010=R\u0014\u0010@\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010?¨\u0006A"}, d2 = {"Lcom/stepos/net/a;", "", "Lcom/stepos/net/HttpConfig;", "cfg", "<init>", "(Lcom/stepos/net/HttpConfig;)V", "f", "()Lcom/stepos/net/HttpConfig;", "Ltb/z;", "m", "()Ltb/z;", "", "baseUrlKey", "Lyc/w;", "k", "(Ljava/lang/String;)Lyc/w;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "service", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "LD7/b;", "e", "()LD7/b;", "key", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/lang/String;", "url", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "o", "()V", "c", Const.INTENT_KEY_UMID, "Lzc/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lzc/a;", "LI7/c;", "n", "(Lcom/stepos/net/HttpConfig;)LI7/c;", "", "baseUrls", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/net/HttpConfig;Ljava/util/Map;)Lcom/stepos/net/HttpConfig;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/net/HttpConfig;", "Ltb/z;", "okHttp", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "retrofitCache", "Lcom/stepos/net/a$a;", "serviceCache", "Ljava/lang/Object;", "lock", "currentConfig", "LE7/g;", "LE7/g;", "multiBaseUrlInterceptor", "Lcom/stepos/net/cache/CacheTagStore;", "Lcom/stepos/net/cache/CacheTagStore;", "cacheTagStore", "LD7/b;", "tagInvalidator", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final HttpConfig cfg;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile z okHttp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<String, w> retrofitCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<ServiceKey, Object> serviceCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public volatile HttpConfig currentConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final g multiBaseUrlInterceptor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final CacheTagStore cacheTagStore;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final b tagInvalidator;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/stepos/net/a$a;", "", "Ljava/lang/Class;", "cls", "", "baseUrlKey", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/Class;", "getCls", "()Ljava/lang/Class;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.net.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class ServiceKey {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final Class<?> cls;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String baseUrlKey;

        public ServiceKey(Class<?> cls, String baseUrlKey) {
            p.i(cls, "cls");
            p.i(baseUrlKey, "baseUrlKey");
            this.cls = cls;
            this.baseUrlKey = baseUrlKey;
        }

        /* renamed from: a, reason: from getter */
        public final String getBaseUrlKey() {
            return this.baseUrlKey;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServiceKey)) {
                return false;
            }
            ServiceKey serviceKey = (ServiceKey) other;
            return p.d(this.cls, serviceKey.cls) && p.d(this.baseUrlKey, serviceKey.baseUrlKey);
        }

        public int hashCode() {
            return (this.cls.hashCode() * 31) + this.baseUrlKey.hashCode();
        }

        public String toString() {
            return "ServiceKey(cls=" + this.cls + ", baseUrlKey=" + this.baseUrlKey + ")";
        }
    }

    public a(HttpConfig cfg) {
        p.i(cfg, "cfg");
        this.cfg = cfg;
        this.retrofitCache = new ConcurrentHashMap<>();
        this.serviceCache = new ConcurrentHashMap<>();
        this.lock = new Object();
        this.currentConfig = cfg;
        this.multiBaseUrlInterceptor = new g(new InterfaceC5074l() { // from class: C7.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return com.stepos.net.a.l(this.f1726a, (String) obj);
            }
        });
        CacheTagStore cacheTagStore = new CacheTagStore();
        this.cacheTagStore = cacheTagStore;
        cfg.getCache();
        this.tagInvalidator = new b(null, cacheTagStore);
    }

    public static final String l(a aVar, String key) {
        p.i(key, "key");
        return aVar.currentConfig.baseUrlOf(key);
    }

    public void b(String key, String url) {
        p.i(key, "key");
        p.i(url, "url");
        if (!D.K(url, "/", false, 2, null)) {
            throw new IllegalArgumentException(("BaseUrl '" + url + "' must end with '/'").toString());
        }
        synchronized (this.lock) {
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap(this.currentConfig.getBaseUrls());
                linkedHashMap.put(key, url);
                this.currentConfig = g(this.currentConfig, linkedHashMap);
                this.retrofitCache.remove(key);
                this.multiBaseUrlInterceptor.a();
                Set<ServiceKey> setKeySet = this.serviceCache.keySet();
                p.h(setKeySet, "<get-keys>(...)");
                ArrayList arrayList = new ArrayList();
                for (Object obj : setKeySet) {
                    if (p.d(((ServiceKey) obj).getBaseUrlKey(), key)) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.serviceCache.remove((ServiceKey) it.next());
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final z c() {
        HttpConfig httpConfig = this.currentConfig;
        z.a aVar = new z.a();
        long connectTimeoutMs = httpConfig.getConnectTimeoutMs();
        HttpConfig.Companion companion = HttpConfig.INSTANCE;
        z.a aVarU = aVar.g(connectTimeoutMs, companion.a()).T(httpConfig.getReadTimeoutMs(), companion.a()).W(httpConfig.getWriteTimeoutMs(), companion.a()).e(httpConfig.getCallTimeoutMs(), companion.a()).U(httpConfig.getRetryOnConnectionFailure());
        InterfaceC5063a<Boolean> privacyGate = httpConfig.getPrivacyGate();
        if (privacyGate != null) {
            aVarU.a(new h(privacyGate));
        }
        httpConfig.getNetworkMonitor();
        aVarU.a(this.multiBaseUrlInterceptor);
        aVarU.a(new d(httpConfig.getHeaders(), httpConfig.getTokenProvider()));
        InterfaceC5063a interfaceC5063a = null;
        Object[] objArr = 0;
        if (httpConfig.getEnableTraceId()) {
            aVarU.a(new k(httpConfig.getTraceIdHeader(), interfaceC5063a, 2, objArr == true ? 1 : 0));
        }
        if (httpConfig.getEnableDeviceHeaders()) {
            if (httpConfig.getPrivacyGate() == null) {
                c.d(httpConfig.getContext());
            }
            aVarU.a(new E7.c(httpConfig.getContext(), null, httpConfig.getPrivacyGate() != null, 2, null));
        }
        I7.c cVarN = n(httpConfig);
        aVarU.a(new i(cVarN));
        Iterator<T> it = httpConfig.getInterceptors().iterator();
        while (it.hasNext()) {
            aVarU.a((tb.w) it.next());
        }
        aVarU.a(new D7.a(this.cacheTagStore));
        aVarU.a(new G7.d());
        aVarU.a(f.c(f.f2399a, httpConfig.getDebug(), httpConfig.getRedactedHeaders(), null, 4, null));
        Iterator<T> it2 = httpConfig.getNetworkInterceptors().iterator();
        while (it2.hasNext()) {
            aVarU.b((tb.w) it2.next());
        }
        InterfaceC5549p dns = httpConfig.getDns();
        if (dns != null) {
            aVarU.k(dns);
        }
        httpConfig.getCache();
        List<okhttp3.b> connectionSpecs = httpConfig.getConnectionSpecs();
        if (connectionSpecs != null) {
            aVarU.i(connectionSpecs);
        }
        C5541h c5541hResolveCertificatePinner$net_release = httpConfig.resolveCertificatePinner$net_release();
        if (c5541hResolveCertificatePinner$net_release != null) {
            aVarU.f(c5541hResolveCertificatePinner$net_release);
        }
        httpConfig.getSslPair();
        TokenProvider tokenProvider = httpConfig.getTokenProvider();
        if (tokenProvider != null) {
            aVarU.c(new TokenAuthenticator(tokenProvider, cVarN));
        }
        C5544k connectionPool = httpConfig.getConnectionPool();
        if (connectionPool != null) {
            aVarU.h(connectionPool);
        }
        C5548o dispatcher = httpConfig.getDispatcher() != null ? httpConfig.getDispatcher() : (httpConfig.getMaxRequests() == null && httpConfig.getMaxRequestsPerHost() == null) ? null : new C5548o();
        if (dispatcher != null) {
            Integer maxRequests = httpConfig.getMaxRequests();
            if (maxRequests != null) {
                dispatcher.i(maxRequests.intValue());
            }
            Integer maxRequestsPerHost = httpConfig.getMaxRequestsPerHost();
            if (maxRequestsPerHost != null) {
                dispatcher.j(maxRequestsPerHost.intValue());
            }
            aVarU.j(dispatcher);
        }
        InterfaceC5074l<HttpMetrics, t> metricsListener = httpConfig.getMetricsListener();
        if (metricsListener != null) {
            aVarU.l(new e.a(metricsListener, httpConfig.getTraceIdHeader()));
        }
        if (httpConfig.getInspectorEnabled() && !G7.b.c()) {
            G7.b.b(0, 1, null);
        }
        return aVarU.d();
    }

    public final w d(String baseUrlKey) {
        HttpConfig httpConfig = this.currentConfig;
        String strBaseUrlOf = httpConfig.baseUrlOf(baseUrlKey);
        if (strBaseUrlOf != null) {
            h.a converterFactory = httpConfig.getConverterFactory();
            if (converterFactory == null) {
                converterFactory = i();
            }
            w wVarD = new w.b().b(strBaseUrlOf).f(m()).a(converterFactory).d();
            p.h(wVarD, "build(...)");
            return wVarD;
        }
        throw new IllegalStateException(("BaseUrl key '" + baseUrlKey + "' is not registered. Call HttpManager.addBaseUrl(\"" + baseUrlKey + "\", \"...\") first.").toString());
    }

    /* renamed from: e, reason: from getter */
    public b getTagInvalidator() {
        return this.tagInvalidator;
    }

    /* renamed from: f, reason: from getter */
    public HttpConfig getCurrentConfig() {
        return this.currentConfig;
    }

    public final HttpConfig g(HttpConfig httpConfig, Map<String, String> map) {
        Context context = httpConfig.getContext();
        boolean debug = httpConfig.getDebug();
        long connectTimeoutMs = httpConfig.getConnectTimeoutMs();
        long readTimeoutMs = httpConfig.getReadTimeoutMs();
        long writeTimeoutMs = httpConfig.getWriteTimeoutMs();
        long callTimeoutMs = httpConfig.getCallTimeoutMs();
        Map<String, String> headers = httpConfig.getHeaders();
        List<tb.w> interceptors = httpConfig.getInterceptors();
        List<tb.w> networkInterceptors = httpConfig.getNetworkInterceptors();
        TokenProvider tokenProvider = httpConfig.getTokenProvider();
        h.a converterFactory = httpConfig.getConverterFactory();
        httpConfig.getSslPair();
        boolean retryOnConnectionFailure = httpConfig.getRetryOnConnectionFailure();
        InterfaceC5074l<Integer, Boolean> successCodeChecker = httpConfig.getSuccessCodeChecker();
        InterfaceC5074l<ApiException, t> globalErrorListener = httpConfig.getGlobalErrorListener();
        I7.c signatureProvider = httpConfig.getSignatureProvider();
        boolean enableTraceId = httpConfig.getEnableTraceId();
        String traceIdHeader = httpConfig.getTraceIdHeader();
        boolean enableDeviceHeaders = httpConfig.getEnableDeviceHeaders();
        String appId = httpConfig.getAppId();
        String appSecret = httpConfig.getAppSecret();
        Set<String> redactedHeaders = httpConfig.getRedactedHeaders();
        InterfaceC5074l<HttpMetrics, t> metricsListener = httpConfig.getMetricsListener();
        boolean inspectorEnabled = httpConfig.getInspectorEnabled();
        C5548o dispatcher = httpConfig.getDispatcher();
        C5544k connectionPool = httpConfig.getConnectionPool();
        Integer maxRequests = httpConfig.getMaxRequests();
        Integer maxRequestsPerHost = httpConfig.getMaxRequestsPerHost();
        InterfaceC5549p dns = httpConfig.getDns();
        httpConfig.getCache();
        List<okhttp3.b> connectionSpecs = httpConfig.getConnectionSpecs();
        httpConfig.getNetworkMonitor();
        httpConfig.getPinningFailureListener();
        httpConfig.getCrashReporter();
        return new HttpConfig(context, debug, map, connectTimeoutMs, readTimeoutMs, writeTimeoutMs, callTimeoutMs, headers, interceptors, networkInterceptors, tokenProvider, converterFactory, null, retryOnConnectionFailure, successCodeChecker, globalErrorListener, signatureProvider, enableTraceId, traceIdHeader, enableDeviceHeaders, appId, appSecret, redactedHeaders, metricsListener, inspectorEnabled, dispatcher, connectionPool, maxRequests, maxRequestsPerHost, dns, null, connectionSpecs, null, null, null, httpConfig.getPrivacyGate(), httpConfig.getPinSpecs$net_release(), httpConfig.getExplicitCertificatePinner());
    }

    public <T> T h(Class<T> service, String baseUrlKey) {
        p.i(service, "service");
        p.i(baseUrlKey, "baseUrlKey");
        ServiceKey serviceKey = new ServiceKey(service, baseUrlKey);
        T t10 = (T) this.serviceCache.get(serviceKey);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) k(baseUrlKey).c(service);
        this.serviceCache.put(serviceKey, t11);
        p.f(t11);
        return t11;
    }

    public final zc.a i() {
        zc.a aVarG = zc.a.g(new GsonBuilder().registerTypeAdapterFactory(new BaseResponseTypeAdapterFactory()).create());
        p.h(aVarG, "create(...)");
        return aVarG;
    }

    public String j(String key) {
        p.i(key, "key");
        return this.currentConfig.baseUrlOf(key);
    }

    public w k(String baseUrlKey) {
        w wVar;
        p.i(baseUrlKey, "baseUrlKey");
        w wVar2 = this.retrofitCache.get(baseUrlKey);
        if (wVar2 != null) {
            return wVar2;
        }
        synchronized (this.lock) {
            try {
                ConcurrentHashMap<String, w> concurrentHashMap = this.retrofitCache;
                w wVar3 = concurrentHashMap.get(baseUrlKey);
                if (wVar3 == null) {
                    w wVarD = d(baseUrlKey);
                    w wVarPutIfAbsent = concurrentHashMap.putIfAbsent(baseUrlKey, wVarD);
                    wVar3 = wVarPutIfAbsent == null ? wVarD : wVarPutIfAbsent;
                }
                wVar = wVar3;
            } catch (Throwable th) {
                throw th;
            }
        }
        p.h(wVar, "synchronized(...)");
        return wVar;
    }

    public z m() {
        z zVarC;
        z zVar = this.okHttp;
        if (zVar != null) {
            return zVar;
        }
        synchronized (this.lock) {
            zVarC = this.okHttp;
            if (zVarC == null) {
                zVarC = c();
                this.okHttp = zVarC;
            }
        }
        return zVarC;
    }

    public final I7.c n(HttpConfig c10) {
        String appSecret;
        I7.c signatureProvider = c10.getSignatureProvider();
        if (signatureProvider != null) {
            return signatureProvider;
        }
        String appId = c10.getAppId();
        if (appId == null || H.x0(appId) || (appSecret = c10.getAppSecret()) == null || H.x0(appSecret)) {
            return new I7.e("agentframework", "KIBn9xhmgp5O3JjfGTV8");
        }
        String appId2 = c10.getAppId();
        p.f(appId2);
        String appSecret2 = c10.getAppSecret();
        p.f(appSecret2);
        return new I7.e(appId2, appSecret2);
    }

    public void o() {
        C5548o dispatcher;
        ExecutorService executorServiceC;
        synchronized (this.lock) {
            try {
                z zVar = this.okHttp;
                if (zVar != null && (dispatcher = zVar.getDispatcher()) != null && (executorServiceC = dispatcher.c()) != null) {
                    executorServiceC.shutdown();
                }
                this.okHttp = null;
                this.retrofitCache.clear();
                this.serviceCache.clear();
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
