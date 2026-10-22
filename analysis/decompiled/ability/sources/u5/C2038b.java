package u5;

import C5.f;
import F9.A;
import F9.C0233k;
import F9.C0235m;
import F9.C0238p;
import F9.E;
import F9.F;
import F9.InterfaceC0239q;
import N9.j;
import S7.k;
import android.content.Context;
import com.google.gson.GsonBuilder;
import com.stepos.net.HttpConfig;
import com.stepos.net.response.BaseResponseTypeAdapterFactory;
import com.stepos.net.token.TokenAuthenticator;
import com.stepos.net.token.TokenProvider;
import com.stepos.taskrobot.llmapi.stepfun.g;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import okhttp3.logging.HttpLoggingInterceptor$Level;
import qa.AbstractC1858j;
import qa.N;
import ra.C1884a;
import v0.C2054a;
import v5.C2059a;
import w5.C2102b;
import w5.C2103c;

/* renamed from: u5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2038b {

    /* renamed from: a, reason: collision with root package name */
    public volatile F f6708a;
    public volatile HttpConfig e;
    public final C2059a h;
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final Object d = new Object();
    public final C2103c f = new C2103c(new g(this, 15));
    public final C2054a g = new C2054a(11);

    public C2038b(HttpConfig httpConfig) {
        this.e = httpConfig;
        httpConfig.getCache();
        this.h = new C2059a();
    }

    public static HttpConfig c(HttpConfig httpConfig, LinkedHashMap linkedHashMap) {
        Context context = httpConfig.getContext();
        boolean debug = httpConfig.getDebug();
        long connectTimeoutMs = httpConfig.getConnectTimeoutMs();
        long readTimeoutMs = httpConfig.getReadTimeoutMs();
        long writeTimeoutMs = httpConfig.getWriteTimeoutMs();
        long callTimeoutMs = httpConfig.getCallTimeoutMs();
        Map<String, String> headers = httpConfig.getHeaders();
        List<A> interceptors = httpConfig.getInterceptors();
        List<A> networkInterceptors = httpConfig.getNetworkInterceptors();
        TokenProvider tokenProvider = httpConfig.getTokenProvider();
        AbstractC1858j converterFactory = httpConfig.getConverterFactory();
        httpConfig.getSslPair();
        boolean retryOnConnectionFailure = httpConfig.getRetryOnConnectionFailure();
        k successCodeChecker = httpConfig.getSuccessCodeChecker();
        k globalErrorListener = httpConfig.getGlobalErrorListener();
        A5.a signatureProvider = httpConfig.getSignatureProvider();
        boolean enableTraceId = httpConfig.getEnableTraceId();
        String traceIdHeader = httpConfig.getTraceIdHeader();
        boolean enableDeviceHeaders = httpConfig.getEnableDeviceHeaders();
        String appId = httpConfig.getAppId();
        String appSecret = httpConfig.getAppSecret();
        Set<String> redactedHeaders = httpConfig.getRedactedHeaders();
        k metricsListener = httpConfig.getMetricsListener();
        boolean inspectorEnabled = httpConfig.getInspectorEnabled();
        C0238p dispatcher = httpConfig.getDispatcher();
        C0233k connectionPool = httpConfig.getConnectionPool();
        Integer maxRequests = httpConfig.getMaxRequests();
        Integer maxRequestsPerHost = httpConfig.getMaxRequestsPerHost();
        InterfaceC0239q dns = httpConfig.getDns();
        httpConfig.getCache();
        List<C0235m> connectionSpecs = httpConfig.getConnectionSpecs();
        httpConfig.getNetworkMonitor();
        httpConfig.getPinningFailureListener();
        httpConfig.getCrashReporter();
        return new HttpConfig(context, debug, linkedHashMap, connectTimeoutMs, readTimeoutMs, writeTimeoutMs, callTimeoutMs, headers, interceptors, networkInterceptors, tokenProvider, converterFactory, null, retryOnConnectionFailure, successCodeChecker, globalErrorListener, signatureProvider, enableTraceId, traceIdHeader, enableDeviceHeaders, appId, appSecret, redactedHeaders, metricsListener, inspectorEnabled, dispatcher, connectionPool, maxRequests, maxRequestsPerHost, dns, null, connectionSpecs, null, null, null, httpConfig.getPinSpecs$net_debug(), httpConfig.getExplicitCertificatePinner());
    }

    public final F a() {
        String appSecret;
        Object objA;
        Object objA2;
        HttpConfig httpConfig = this.e;
        E e = new E();
        long connectTimeoutMs = httpConfig.getConnectTimeoutMs();
        HttpConfig.Companion.getClass();
        e.b(connectTimeoutMs, HttpConfig.MILLISECONDS);
        e.c(httpConfig.getReadTimeoutMs(), HttpConfig.MILLISECONDS);
        e.e(httpConfig.getWriteTimeoutMs(), HttpConfig.MILLISECONDS);
        long callTimeoutMs = httpConfig.getCallTimeoutMs();
        TimeUnit unit = HttpConfig.MILLISECONDS;
        kotlin.jvm.internal.k.f(unit, "unit");
        e.f609w = G9.b.b(callTimeoutMs, unit);
        e.f = httpConfig.getRetryOnConnectionFailure();
        httpConfig.getNetworkMonitor();
        e.a(this.f);
        e.a(new C2103c(httpConfig.getHeaders(), httpConfig.getTokenProvider()));
        if (httpConfig.getEnableTraceId()) {
            e.a(new C2103c(httpConfig.getTraceIdHeader()));
        }
        int i = 1;
        C0238p c0238p = null;
        if (httpConfig.getEnableDeviceHeaders()) {
            Context context = httpConfig.getContext();
            kotlin.jvm.internal.k.f(context, "context");
            if (!B5.b.b) {
                synchronized (B5.b.c) {
                    if (!B5.b.b) {
                        Context applicationContext = context.getApplicationContext();
                        kotlin.jvm.internal.k.c(applicationContext);
                        try {
                            objA = j.y(applicationContext);
                        } catch (Throwable th) {
                            objA = kotlin.b.a(th);
                        }
                        if (objA instanceof Result.Failure) {
                            objA = null;
                        }
                        String str = (String) objA;
                        if (str == null) {
                            str = "";
                        }
                        B5.b.f194a = str;
                        B5.a aVar = new B5.a(applicationContext, 0);
                        try {
                            f fVarC = f.c();
                            synchronized (fVarC) {
                                fVarC.h = aVar;
                            }
                        } catch (Throwable th2) {
                            kotlin.b.a(th2);
                        }
                        try {
                            objA2 = j.y(applicationContext);
                        } catch (Throwable th3) {
                            objA2 = kotlin.b.a(th3);
                        }
                        if (objA2 instanceof Result.Failure) {
                            objA2 = null;
                        }
                        String str2 = (String) objA2;
                        if (str2 == null) {
                            str2 = "";
                        }
                        B5.b.f194a = str2;
                        B5.b.b = true;
                    }
                }
            }
            e.a(new C2102b(httpConfig.getContext()));
        }
        A5.a signatureProvider = httpConfig.getSignatureProvider();
        if (signatureProvider == null) {
            String appId = httpConfig.getAppId();
            if (appId == null || m.s0(appId) || (appSecret = httpConfig.getAppSecret()) == null || m.s0(appSecret)) {
                signatureProvider = new A5.c("agentframework", "KIBn9xhmgp5O3JjfGTV8");
            } else {
                String appId2 = httpConfig.getAppId();
                kotlin.jvm.internal.k.c(appId2);
                String appSecret2 = httpConfig.getAppSecret();
                kotlin.jvm.internal.k.c(appSecret2);
                signatureProvider = new A5.c(appId2, appSecret2);
            }
        }
        e.a(new K9.a(signatureProvider, 2));
        Iterator<T> it = httpConfig.getInterceptors().iterator();
        while (it.hasNext()) {
            e.a((A) it.next());
        }
        e.a(new com.stepos.net.cache.a(this.g));
        e.a(new K9.b(i));
        boolean debug = httpConfig.getDebug();
        Set<String> redactedHeaders = httpConfig.getRedactedHeaders();
        kotlin.jvm.internal.k.f(redactedHeaders, "redactedHeaders");
        T9.b bVar = new T9.b(new androidx.constraintlayout.core.state.a("StepOsHttp", 7));
        bVar.b = debug ? HttpLoggingInterceptor$Level.c : HttpLoggingInterceptor$Level.f5476a;
        Iterator<T> it2 = redactedHeaders.iterator();
        while (it2.hasNext()) {
            bVar.b((String) it2.next());
        }
        e.a(bVar);
        for (A interceptor : httpConfig.getNetworkInterceptors()) {
            kotlin.jvm.internal.k.f(interceptor, "interceptor");
            e.d.add(interceptor);
        }
        InterfaceC0239q dns = httpConfig.getDns();
        if (dns != null) {
            if (!dns.equals(e.k)) {
                e.f601B = null;
            }
            e.k = dns;
        }
        httpConfig.getCache();
        List<C0235m> connectionSpecs = httpConfig.getConnectionSpecs();
        if (connectionSpecs != null) {
            if (!connectionSpecs.equals(e.f605r)) {
                e.f601B = null;
            }
            e.f605r = G9.b.w(connectionSpecs);
        }
        okhttp3.a aVarResolveCertificatePinner$net_debug = httpConfig.resolveCertificatePinner$net_debug();
        if (aVarResolveCertificatePinner$net_debug != null) {
            if (!aVarResolveCertificatePinner$net_debug.equals(e.u)) {
                e.f601B = null;
            }
            e.u = aVarResolveCertificatePinner$net_debug;
        }
        httpConfig.getSslPair();
        TokenProvider tokenProvider = httpConfig.getTokenProvider();
        if (tokenProvider != null) {
            e.g = new TokenAuthenticator(tokenProvider, signatureProvider);
        }
        C0233k connectionPool = httpConfig.getConnectionPool();
        if (connectionPool != null) {
            e.b = connectionPool;
        }
        if (httpConfig.getDispatcher() != null) {
            c0238p = httpConfig.getDispatcher();
        } else if (httpConfig.getMaxRequests() != null || httpConfig.getMaxRequestsPerHost() != null) {
            c0238p = new C0238p();
        }
        if (c0238p != null) {
            Integer maxRequests = httpConfig.getMaxRequests();
            if (maxRequests != null) {
                c0238p.f(maxRequests.intValue());
            }
            Integer maxRequestsPerHost = httpConfig.getMaxRequestsPerHost();
            if (maxRequestsPerHost != null) {
                c0238p.g(maxRequestsPerHost.intValue());
            }
            e.f602a = c0238p;
        }
        k metricsListener = httpConfig.getMetricsListener();
        if (metricsListener != null) {
            e.e = new M0.k(metricsListener, httpConfig.getTraceIdHeader());
        }
        if (httpConfig.getInspectorEnabled() && !y5.c.f6899a) {
            boolean z10 = y5.c.f6899a;
            y5.c.f6899a = true;
        }
        return new F(e);
    }

    public final N b(String str) {
        F fA;
        HttpConfig httpConfig = this.e;
        String strBaseUrlOf = httpConfig.baseUrlOf(str);
        if (strBaseUrlOf == null) {
            throw new IllegalStateException(("BaseUrl key '" + str + "' is not registered. Call HttpManager.addBaseUrl(\"" + str + "\", \"...\") first.").toString());
        }
        AbstractC1858j converterFactory = httpConfig.getConverterFactory();
        if (converterFactory == null) {
            converterFactory = C1884a.c(new GsonBuilder().registerTypeAdapterFactory(new BaseResponseTypeAdapterFactory()).create());
        }
        u1.d dVar = new u1.d(20);
        dVar.I(strBaseUrlOf);
        F f = this.f6708a;
        if (f == null) {
            synchronized (this.d) {
                fA = this.f6708a;
                if (fA == null) {
                    fA = a();
                    this.f6708a = fA;
                }
            }
            f = fA;
        }
        dVar.b = f;
        ((ArrayList) dVar.d).add(converterFactory);
        return dVar.J();
    }

    public final N d(String str) {
        N n;
        N n7 = (N) this.b.get(str);
        if (n7 != null) {
            return n7;
        }
        synchronized (this.d) {
            try {
                ConcurrentHashMap concurrentHashMap = this.b;
                Object obj = concurrentHashMap.get(str);
                if (obj == null) {
                    N nB = b(str);
                    Object objPutIfAbsent = concurrentHashMap.putIfAbsent(str, nB);
                    obj = objPutIfAbsent == null ? nB : objPutIfAbsent;
                }
                n = (N) obj;
            } catch (Throwable th) {
                throw th;
            }
        }
        return n;
    }

    public final void e() {
        C0238p c0238p;
        synchronized (this.d) {
            try {
                F f = this.f6708a;
                if (f != null && (c0238p = f.f616a) != null) {
                    ((ThreadPoolExecutor) c0238p.b()).shutdown();
                }
                this.f6708a = null;
                this.b.clear();
                this.c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
