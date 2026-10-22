package com.stepos.net;

import D7.q;
import D7.v;
import F9.A;
import F9.AbstractC0225c;
import F9.C0230h;
import F9.C0233k;
import F9.C0235m;
import F9.C0238p;
import F9.InterfaceC0239q;
import S7.k;
import android.content.Context;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.agentframework.adapter.bff.BuildConfig;
import com.stepos.net.token.TokenProvider;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import okhttp3.a;
import qa.AbstractC1858j;
import t5.C2016a;
import u5.C2039c;
import u5.C2040d;
import u5.e;
import x5.AbstractC2115a;
import y5.InterfaceC2131a;
import z5.AbstractC2177a;
import z5.AbstractC2178b;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b[\u0018\u0000 \u0098\u00012\u00020\u0001:\u0005>\u0099\u0001\u009a\u0001B±\u0003\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u001a\u0012\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070'\u0012\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\b\u00100\u001a\u0004\u0018\u00010\u001b\u0012\b\u00101\u001a\u0004\u0018\u00010\u001b\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\u000e\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000f\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u000f\u0012\b\u0010A\u001a\u0004\u0018\u00010@¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u0004\u0018\u00010\u00072\u0006\u0010D\u001a\u00020\u0007¢\u0006\u0004\bE\u0010FJ\u0011\u0010I\u001a\u0004\u0018\u00010@H\u0000¢\u0006\u0004\bG\u0010HR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010M\u001a\u0004\bN\u0010OR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010P\u001a\u0004\bQ\u0010RR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010S\u001a\u0004\bT\u0010UR\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010S\u001a\u0004\bV\u0010UR\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010S\u001a\u0004\bW\u0010UR\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\r\u0010S\u001a\u0004\bX\u0010UR#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010P\u001a\u0004\bY\u0010RR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010Z\u001a\u0004\b[\u0010\\R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010Z\u001a\u0004\b]\u0010\\R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010^\u001a\u0004\b_\u0010`R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010a\u001a\u0004\bb\u0010cR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010d\u001a\u0004\be\u0010fR\u0017\u0010\u0019\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010M\u001a\u0004\bg\u0010OR#\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u001a8\u0006¢\u0006\f\n\u0004\b\u001c\u0010h\u001a\u0004\bi\u0010jR%\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001f\u0010h\u001a\u0004\bk\u0010jR\u0019\u0010!\u001a\u0004\u0018\u00010 8\u0006¢\u0006\f\n\u0004\b!\u0010l\u001a\u0004\bm\u0010nR\u0017\u0010\"\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010M\u001a\u0004\bo\u0010OR\u0017\u0010#\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b#\u0010p\u001a\u0004\bq\u0010rR\u0017\u0010$\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b$\u0010M\u001a\u0004\bs\u0010OR\u0019\u0010%\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b%\u0010p\u001a\u0004\bt\u0010rR\u0019\u0010&\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b&\u0010p\u001a\u0004\bu\u0010rR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070'8\u0006¢\u0006\f\n\u0004\b(\u0010v\u001a\u0004\bw\u0010xR%\u0010*\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b*\u0010h\u001a\u0004\by\u0010jR\u0017\u0010+\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b+\u0010M\u001a\u0004\bz\u0010OR\u0019\u0010-\u001a\u0004\u0018\u00010,8\u0006¢\u0006\f\n\u0004\b-\u0010{\u001a\u0004\b|\u0010}R\u001a\u0010/\u001a\u0004\u0018\u00010.8\u0006¢\u0006\r\n\u0004\b/\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001c\u00100\u001a\u0004\u0018\u00010\u001b8\u0006¢\u0006\u000f\n\u0005\b0\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u00101\u001a\u0004\u0018\u00010\u001b8\u0006¢\u0006\u000f\n\u0005\b1\u0010\u0081\u0001\u001a\u0006\b\u0084\u0001\u0010\u0083\u0001R\u001c\u00103\u001a\u0004\u0018\u0001028\u0006¢\u0006\u000f\n\u0005\b3\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u00105\u001a\u0004\u0018\u0001048\u0006¢\u0006\u000f\n\u0005\b5\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R \u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000f8\u0006¢\u0006\r\n\u0004\b7\u0010Z\u001a\u0005\b\u008b\u0001\u0010\\R\u001c\u00109\u001a\u0004\u0018\u0001088\u0006¢\u0006\u000f\n\u0005\b9\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010;\u001a\u0004\u0018\u00010:8\u0006¢\u0006\u000f\n\u0005\b;\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010=\u001a\u0004\u0018\u00010<8\u0006¢\u0006\u000f\n\u0005\b=\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R!\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u000f8\u0000X\u0080\u0004¢\u0006\r\n\u0004\b?\u0010Z\u001a\u0005\b\u0095\u0001\u0010\\R\u001e\u0010A\u001a\u0004\u0018\u00010@8\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\bA\u0010\u0096\u0001\u001a\u0005\b\u0097\u0001\u0010H¨\u0006\u009b\u0001"}, d2 = {"Lcom/stepos/net/HttpConfig;", "", "Landroid/content/Context;", "context", "", BuildConfig.BUILD_TYPE, "", "", "baseUrls", "", "connectTimeoutMs", "readTimeoutMs", "writeTimeoutMs", "callTimeoutMs", "headers", "", "LF9/A;", "interceptors", "networkInterceptors", "Lcom/stepos/net/token/TokenProvider;", "tokenProvider", "Lqa/j;", "converterFactory", "Lz5/b;", "sslPair", "retryOnConnectionFailure", "Lkotlin/Function1;", "", "successCodeChecker", "Lcom/stepos/net/exception/ApiException;", "LC7/r;", "globalErrorListener", "LA5/a;", "signatureProvider", "enableTraceId", "traceIdHeader", "enableDeviceHeaders", "appId", "appSecret", "", "redactedHeaders", "Ly5/d;", "metricsListener", "inspectorEnabled", "LF9/p;", "dispatcher", "LF9/k;", "connectionPool", "maxRequests", "maxRequestsPerHost", "LF9/q;", "dns", "LF9/c;", "cache", "LF9/m;", "connectionSpecs", "Lx5/a;", "networkMonitor", "Lz5/a;", "pinningFailureListener", "Ly5/a;", "crashReporter", "Lu5/d;", "pinSpecs", "Lokhttp3/a;", "explicitCertificatePinner", AppAgent.CONSTRUCT, "(Landroid/content/Context;ZLjava/util/Map;JJJJLjava/util/Map;Ljava/util/List;Ljava/util/List;Lcom/stepos/net/token/TokenProvider;Lqa/j;Lz5/b;ZLS7/k;LS7/k;LA5/a;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/Set;LS7/k;ZLF9/p;LF9/k;Ljava/lang/Integer;Ljava/lang/Integer;LF9/q;LF9/c;Ljava/util/List;Lx5/a;Lz5/a;Ly5/a;Ljava/util/List;Lokhttp3/a;)V", "key", "baseUrlOf", "(Ljava/lang/String;)Ljava/lang/String;", "resolveCertificatePinner$net_debug", "()Lokhttp3/a;", "resolveCertificatePinner", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Z", "getDebug", "()Z", "Ljava/util/Map;", "getBaseUrls", "()Ljava/util/Map;", "J", "getConnectTimeoutMs", "()J", "getReadTimeoutMs", "getWriteTimeoutMs", "getCallTimeoutMs", "getHeaders", "Ljava/util/List;", "getInterceptors", "()Ljava/util/List;", "getNetworkInterceptors", "Lcom/stepos/net/token/TokenProvider;", "getTokenProvider", "()Lcom/stepos/net/token/TokenProvider;", "Lqa/j;", "getConverterFactory", "()Lqa/j;", "Lz5/b;", "getSslPair", "()Lz5/b;", "getRetryOnConnectionFailure", "LS7/k;", "getSuccessCodeChecker", "()LS7/k;", "getGlobalErrorListener", "LA5/a;", "getSignatureProvider", "()LA5/a;", "getEnableTraceId", "Ljava/lang/String;", "getTraceIdHeader", "()Ljava/lang/String;", "getEnableDeviceHeaders", "getAppId", "getAppSecret", "Ljava/util/Set;", "getRedactedHeaders", "()Ljava/util/Set;", "getMetricsListener", "getInspectorEnabled", "LF9/p;", "getDispatcher", "()LF9/p;", "LF9/k;", "getConnectionPool", "()LF9/k;", "Ljava/lang/Integer;", "getMaxRequests", "()Ljava/lang/Integer;", "getMaxRequestsPerHost", "LF9/q;", "getDns", "()LF9/q;", "LF9/c;", "getCache", "()LF9/c;", "getConnectionSpecs", "Lx5/a;", "getNetworkMonitor", "()Lx5/a;", "Lz5/a;", "getPinningFailureListener", "()Lz5/a;", "Ly5/a;", "getCrashReporter", "()Ly5/a;", "getPinSpecs$net_debug", "Lokhttp3/a;", "getExplicitCertificatePinner$net_debug", "Companion", "Builder", "u5/c", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HttpConfig {
    public static final C2039c Companion = new C2039c();
    private static final TimeUnit MILLISECONDS = TimeUnit.MILLISECONDS;
    private final String appId;
    private final String appSecret;
    private final Map<String, String> baseUrls;
    private final AbstractC0225c cache;
    private final long callTimeoutMs;
    private final long connectTimeoutMs;
    private final C0233k connectionPool;
    private final List<C0235m> connectionSpecs;
    private final Context context;
    private final AbstractC1858j converterFactory;
    private final InterfaceC2131a crashReporter;
    private final boolean debug;
    private final C0238p dispatcher;
    private final InterfaceC0239q dns;
    private final boolean enableDeviceHeaders;
    private final boolean enableTraceId;
    private final a explicitCertificatePinner;
    private final k globalErrorListener;
    private final Map<String, String> headers;
    private final boolean inspectorEnabled;
    private final List<A> interceptors;
    private final Integer maxRequests;
    private final Integer maxRequestsPerHost;
    private final k metricsListener;
    private final List<A> networkInterceptors;
    private final AbstractC2115a networkMonitor;
    private final List<C2040d> pinSpecs;
    private final AbstractC2177a pinningFailureListener;
    private final long readTimeoutMs;
    private final Set<String> redactedHeaders;
    private final boolean retryOnConnectionFailure;
    private final A5.a signatureProvider;
    private final AbstractC2178b sslPair;
    private final k successCodeChecker;
    private final TokenProvider tokenProvider;
    private final String traceIdHeader;
    private final long writeTimeoutMs;

    @Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\nJ!\u0010\u0010\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J!\u0010\u0019\u001a\u00020\u00002\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0017\"\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010!\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00062\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0017\"\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\r\u0010(\u001a\u00020'¢\u0006\u0004\b(\u0010)R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\"\u0010D\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010<\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\"\u0010G\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010<\u001a\u0004\bH\u0010>\"\u0004\bI\u0010@R$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010R\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010X\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010/\u001a\u0004\bY\u00101\"\u0004\bZ\u00103R.\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020-0[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR0\u0010e\u001a\u0010\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020d\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010^\u001a\u0004\bf\u0010`\"\u0004\bg\u0010bR$\u0010i\u001a\u0004\u0018\u00010h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010o\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010/\u001a\u0004\bp\u00101\"\u0004\bq\u00103R\"\u0010r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u00105\u001a\u0004\bs\u00107\"\u0004\bt\u00109R\"\u0010u\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010/\u001a\u0004\bv\u00101\"\u0004\bw\u00103R$\u0010x\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u00105\u001a\u0004\by\u00107\"\u0004\bz\u00109R$\u0010{\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u00105\u001a\u0004\b|\u00107\"\u0004\b}\u00109R2\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u00020d\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010^\u001a\u0005\b\u0080\u0001\u0010`\"\u0005\b\u0081\u0001\u0010bR&\u0010\u0082\u0001\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010/\u001a\u0005\b\u0083\u0001\u00101\"\u0005\b\u0084\u0001\u00103R,\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R,\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R+\u0010\u0093\u0001\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R+\u0010\u0099\u0001\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u0094\u0001\u001a\u0006\b\u009a\u0001\u0010\u0096\u0001\"\u0006\b\u009b\u0001\u0010\u0098\u0001R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R,\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R3\u0010¬\u0001\u001a\f\u0012\u0005\u0012\u00030«\u0001\u0018\u00010ª\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R,\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R,\u0010º\u0001\u001a\u0005\u0018\u00010¹\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R,\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R,\u0010È\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060Ç\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001R,\u0010Ì\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060Ç\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÌ\u0001\u0010É\u0001\u001a\u0006\bÍ\u0001\u0010Ë\u0001R&\u0010Ï\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120Î\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÏ\u0001\u0010\u00ad\u0001\u001a\u0006\bÐ\u0001\u0010¯\u0001R&\u0010Ñ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120Î\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÑ\u0001\u0010\u00ad\u0001\u001a\u0006\bÒ\u0001\u0010¯\u0001R+\u0010Ó\u0001\u001a\u0004\u0018\u00010\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÓ\u0001\u0010Ô\u0001\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R'\u0010Ú\u0001\u001a\n\u0012\u0005\u0012\u00030Ù\u00010Î\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÚ\u0001\u0010\u00ad\u0001\u001a\u0006\bÛ\u0001\u0010¯\u0001R)\u0010%\u001a\u0004\u0018\u00010#8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b%\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R&\u0010â\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060á\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bâ\u0001\u0010ã\u0001\u001a\u0006\bä\u0001\u0010å\u0001¨\u0006æ\u0001"}, d2 = {"Lcom/stepos/net/HttpConfig$Builder;", "", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "", "key", BffConstant.Type.Url, "addBaseUrl", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/net/HttpConfig$Builder;", HintConstants.AUTOFILL_HINT_NAME, "value", "addHeader", "", "map", "addHeaders", "(Ljava/util/Map;)Lcom/stepos/net/HttpConfig$Builder;", "LF9/A;", "interceptor", "addInterceptor", "(LF9/A;)Lcom/stepos/net/HttpConfig$Builder;", "addNetworkInterceptor", "", "names", "redactHeaders", "([Ljava/lang/String;)Lcom/stepos/net/HttpConfig$Builder;", "Lokhttp3/a;", "pinner", "certificatePinner", "(Lokhttp3/a;)Lcom/stepos/net/HttpConfig$Builder;", "hostname", "sha256Pins", "pinHost", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/stepos/net/HttpConfig$Builder;", "Lz5/b;", "pair", "sslPair", "(Lz5/b;)Lcom/stepos/net/HttpConfig$Builder;", "Lcom/stepos/net/HttpConfig;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcom/stepos/net/HttpConfig;", "Landroid/content/Context;", "getContext$net_debug", "()Landroid/content/Context;", "", BuildConfig.BUILD_TYPE, "Z", "getDebug", "()Z", "setDebug", "(Z)V", "defaultBaseUrl", "Ljava/lang/String;", "getDefaultBaseUrl", "()Ljava/lang/String;", "setDefaultBaseUrl", "(Ljava/lang/String;)V", "", "connectTimeoutMs", "J", "getConnectTimeoutMs", "()J", "setConnectTimeoutMs", "(J)V", "readTimeoutMs", "getReadTimeoutMs", "setReadTimeoutMs", "writeTimeoutMs", "getWriteTimeoutMs", "setWriteTimeoutMs", "callTimeoutMs", "getCallTimeoutMs", "setCallTimeoutMs", "Lcom/stepos/net/token/TokenProvider;", "tokenProvider", "Lcom/stepos/net/token/TokenProvider;", "getTokenProvider", "()Lcom/stepos/net/token/TokenProvider;", "setTokenProvider", "(Lcom/stepos/net/token/TokenProvider;)V", "Lqa/j;", "converterFactory", "Lqa/j;", "getConverterFactory", "()Lqa/j;", "setConverterFactory", "(Lqa/j;)V", "retryOnConnectionFailure", "getRetryOnConnectionFailure", "setRetryOnConnectionFailure", "Lkotlin/Function1;", "", "successCodeChecker", "LS7/k;", "getSuccessCodeChecker", "()LS7/k;", "setSuccessCodeChecker", "(LS7/k;)V", "Lcom/stepos/net/exception/ApiException;", "LC7/r;", "globalErrorListener", "getGlobalErrorListener", "setGlobalErrorListener", "LA5/a;", "signatureProvider", "LA5/a;", "getSignatureProvider", "()LA5/a;", "setSignatureProvider", "(LA5/a;)V", "enableTraceId", "getEnableTraceId", "setEnableTraceId", "traceIdHeader", "getTraceIdHeader", "setTraceIdHeader", "enableDeviceHeaders", "getEnableDeviceHeaders", "setEnableDeviceHeaders", "appId", "getAppId", "setAppId", "appSecret", "getAppSecret", "setAppSecret", "Ly5/d;", "metricsListener", "getMetricsListener", "setMetricsListener", "inspectorEnabled", "getInspectorEnabled", "setInspectorEnabled", "LF9/p;", "dispatcher", "LF9/p;", "getDispatcher", "()LF9/p;", "setDispatcher", "(LF9/p;)V", "LF9/k;", "connectionPool", "LF9/k;", "getConnectionPool", "()LF9/k;", "setConnectionPool", "(LF9/k;)V", "maxRequests", "Ljava/lang/Integer;", "getMaxRequests", "()Ljava/lang/Integer;", "setMaxRequests", "(Ljava/lang/Integer;)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "LF9/q;", "dns", "LF9/q;", "getDns", "()LF9/q;", "setDns", "(LF9/q;)V", "LF9/c;", "cache", "LF9/c;", "getCache", "()LF9/c;", "setCache", "(LF9/c;)V", "", "LF9/m;", "connectionSpecs", "Ljava/util/List;", "getConnectionSpecs", "()Ljava/util/List;", "setConnectionSpecs", "(Ljava/util/List;)V", "Lx5/a;", "networkMonitor", "Lx5/a;", "getNetworkMonitor", "()Lx5/a;", "setNetworkMonitor", "(Lx5/a;)V", "Lz5/a;", "pinningFailureListener", "Lz5/a;", "getPinningFailureListener", "()Lz5/a;", "setPinningFailureListener", "(Lz5/a;)V", "Ly5/a;", "crashReporter", "Ly5/a;", "getCrashReporter", "()Ly5/a;", "setCrashReporter", "(Ly5/a;)V", "", "baseUrlMap", "Ljava/util/Map;", "getBaseUrlMap$net_debug", "()Ljava/util/Map;", "headerMap", "getHeaderMap$net_debug", "", "interceptorList", "getInterceptorList$net_debug", "networkInterceptorList", "getNetworkInterceptorList$net_debug", "explicitCertificatePinner", "Lokhttp3/a;", "getExplicitCertificatePinner$net_debug", "()Lokhttp3/a;", "setExplicitCertificatePinner$net_debug", "(Lokhttp3/a;)V", "Lu5/d;", "pinSpecs", "getPinSpecs$net_debug", "Lz5/b;", "getSslPair$net_debug", "()Lz5/b;", "setSslPair$net_debug", "(Lz5/b;)V", "", "redactedHeaderSet", "Ljava/util/Set;", "getRedactedHeaderSet$net_debug", "()Ljava/util/Set;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private String appId;
        private String appSecret;
        private final Map<String, String> baseUrlMap;
        private AbstractC0225c cache;
        private long callTimeoutMs;
        private long connectTimeoutMs;
        private C0233k connectionPool;
        private List<C0235m> connectionSpecs;
        private final Context context;
        private AbstractC1858j converterFactory;
        private InterfaceC2131a crashReporter;
        private boolean debug;
        private String defaultBaseUrl;
        private C0238p dispatcher;
        private InterfaceC0239q dns;
        private boolean enableDeviceHeaders;
        private boolean enableTraceId;
        private a explicitCertificatePinner;
        private k globalErrorListener;
        private final Map<String, String> headerMap;
        private boolean inspectorEnabled;
        private final List<A> interceptorList;
        private Integer maxRequests;
        private Integer maxRequestsPerHost;
        private k metricsListener;
        private final List<A> networkInterceptorList;
        private AbstractC2115a networkMonitor;
        private final List<C2040d> pinSpecs;
        private AbstractC2177a pinningFailureListener;
        private long readTimeoutMs;
        private final Set<String> redactedHeaderSet;
        private boolean retryOnConnectionFailure;
        private A5.a signatureProvider;
        private AbstractC2178b sslPair;
        private k successCodeChecker;
        private TokenProvider tokenProvider;
        private String traceIdHeader;
        private long writeTimeoutMs;

        public Builder(Context context) {
            kotlin.jvm.internal.k.f(context, "context");
            this.context = context;
            this.defaultBaseUrl = "";
            this.connectTimeoutMs = 15000L;
            this.readTimeoutMs = 20000L;
            this.writeTimeoutMs = 20000L;
            this.callTimeoutMs = 30000L;
            this.retryOnConnectionFailure = true;
            this.successCodeChecker = new C2016a(22);
            this.enableTraceId = true;
            this.traceIdHeader = "X-Request-Id";
            this.enableDeviceHeaders = true;
            this.baseUrlMap = new LinkedHashMap();
            this.headerMap = new LinkedHashMap();
            this.interceptorList = new ArrayList();
            this.networkInterceptorList = new ArrayList();
            this.pinSpecs = new ArrayList();
            this.redactedHeaderSet = v.i1(e.f6710a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean successCodeChecker$lambda$0(int i) {
            return i == 0;
        }

        public final Builder addBaseUrl(String key, String url) {
            kotlin.jvm.internal.k.f(key, "key");
            kotlin.jvm.internal.k.f(url, "url");
            if (m.s0(key)) {
                throw new IllegalArgumentException("BaseUrl key must not be blank");
            }
            if (!t.W(url, "/", false)) {
                throw new IllegalArgumentException(B7.a.m("BaseUrl '", url, "' must end with '/'").toString());
            }
            this.baseUrlMap.put(key, url);
            return this;
        }

        public final Builder addHeader(String name, String value) {
            kotlin.jvm.internal.k.f(name, "name");
            kotlin.jvm.internal.k.f(value, "value");
            this.headerMap.put(name, value);
            return this;
        }

        public final Builder addHeaders(Map<String, String> map) {
            kotlin.jvm.internal.k.f(map, "map");
            this.headerMap.putAll(map);
            return this;
        }

        public final Builder addInterceptor(A interceptor) {
            kotlin.jvm.internal.k.f(interceptor, "interceptor");
            this.interceptorList.add(interceptor);
            return this;
        }

        public final Builder addNetworkInterceptor(A interceptor) {
            kotlin.jvm.internal.k.f(interceptor, "interceptor");
            this.networkInterceptorList.add(interceptor);
            return this;
        }

        public final HttpConfig build() {
            if (m.s0(this.defaultBaseUrl)) {
                throw new IllegalArgumentException("defaultBaseUrl must be configured");
            }
            if (!t.W(this.defaultBaseUrl, "/", false)) {
                throw new IllegalArgumentException(B7.a.m("defaultBaseUrl '", this.defaultBaseUrl, "' must end with '/'").toString());
            }
            if (this.connectTimeoutMs <= 0 || this.readTimeoutMs <= 0 || this.writeTimeoutMs <= 0) {
                throw new IllegalArgumentException("Timeouts must be positive");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.baseUrlMap.size() + 1);
            linkedHashMap.put("__default__", this.defaultBaseUrl);
            linkedHashMap.putAll(this.baseUrlMap);
            Context applicationContext = this.context.getApplicationContext();
            kotlin.jvm.internal.k.e(applicationContext, "getApplicationContext(...)");
            return new HttpConfig(applicationContext, this.debug, kotlin.collections.a.Y(linkedHashMap), this.connectTimeoutMs, this.readTimeoutMs, this.writeTimeoutMs, this.callTimeoutMs, kotlin.collections.a.Y(this.headerMap), v.f1(this.interceptorList), v.f1(this.networkInterceptorList), this.tokenProvider, this.converterFactory, null, this.retryOnConnectionFailure, this.successCodeChecker, this.globalErrorListener, this.signatureProvider, this.enableTraceId, this.traceIdHeader, this.enableDeviceHeaders, this.appId, this.appSecret, v.j1(this.redactedHeaderSet), this.metricsListener, this.inspectorEnabled, this.dispatcher, this.connectionPool, this.maxRequests, this.maxRequestsPerHost, this.dns, null, this.connectionSpecs, null, null, null, v.f1(this.pinSpecs), this.explicitCertificatePinner);
        }

        public final Builder certificatePinner(a pinner) {
            kotlin.jvm.internal.k.f(pinner, "pinner");
            this.explicitCertificatePinner = pinner;
            return this;
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getAppSecret() {
            return this.appSecret;
        }

        public final Map<String, String> getBaseUrlMap$net_debug() {
            return this.baseUrlMap;
        }

        public final AbstractC0225c getCache() {
            return null;
        }

        public final long getCallTimeoutMs() {
            return this.callTimeoutMs;
        }

        public final long getConnectTimeoutMs() {
            return this.connectTimeoutMs;
        }

        public final C0233k getConnectionPool() {
            return this.connectionPool;
        }

        public final List<C0235m> getConnectionSpecs() {
            return this.connectionSpecs;
        }

        /* renamed from: getContext$net_debug, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        public final AbstractC1858j getConverterFactory() {
            return this.converterFactory;
        }

        public final InterfaceC2131a getCrashReporter() {
            return null;
        }

        public final boolean getDebug() {
            return this.debug;
        }

        public final String getDefaultBaseUrl() {
            return this.defaultBaseUrl;
        }

        public final C0238p getDispatcher() {
            return this.dispatcher;
        }

        public final InterfaceC0239q getDns() {
            return this.dns;
        }

        public final boolean getEnableDeviceHeaders() {
            return this.enableDeviceHeaders;
        }

        public final boolean getEnableTraceId() {
            return this.enableTraceId;
        }

        /* renamed from: getExplicitCertificatePinner$net_debug, reason: from getter */
        public final a getExplicitCertificatePinner() {
            return this.explicitCertificatePinner;
        }

        public final k getGlobalErrorListener() {
            return this.globalErrorListener;
        }

        public final Map<String, String> getHeaderMap$net_debug() {
            return this.headerMap;
        }

        public final boolean getInspectorEnabled() {
            return this.inspectorEnabled;
        }

        public final List<A> getInterceptorList$net_debug() {
            return this.interceptorList;
        }

        public final Integer getMaxRequests() {
            return this.maxRequests;
        }

        public final Integer getMaxRequestsPerHost() {
            return this.maxRequestsPerHost;
        }

        public final k getMetricsListener() {
            return this.metricsListener;
        }

        public final List<A> getNetworkInterceptorList$net_debug() {
            return this.networkInterceptorList;
        }

        public final AbstractC2115a getNetworkMonitor() {
            return null;
        }

        public final List<C2040d> getPinSpecs$net_debug() {
            return this.pinSpecs;
        }

        public final AbstractC2177a getPinningFailureListener() {
            return null;
        }

        public final long getReadTimeoutMs() {
            return this.readTimeoutMs;
        }

        public final Set<String> getRedactedHeaderSet$net_debug() {
            return this.redactedHeaderSet;
        }

        public final boolean getRetryOnConnectionFailure() {
            return this.retryOnConnectionFailure;
        }

        public final A5.a getSignatureProvider() {
            return this.signatureProvider;
        }

        public final AbstractC2178b getSslPair$net_debug() {
            return null;
        }

        public final k getSuccessCodeChecker() {
            return this.successCodeChecker;
        }

        public final TokenProvider getTokenProvider() {
            return this.tokenProvider;
        }

        public final String getTraceIdHeader() {
            return this.traceIdHeader;
        }

        public final long getWriteTimeoutMs() {
            return this.writeTimeoutMs;
        }

        public final Builder pinHost(String hostname, String... sha256Pins) {
            kotlin.jvm.internal.k.f(hostname, "hostname");
            kotlin.jvm.internal.k.f(sha256Pins, "sha256Pins");
            if (sha256Pins.length == 0) {
                throw new IllegalArgumentException("At least one pin is required");
            }
            this.pinSpecs.add(new C2040d(hostname, q.I0(sha256Pins)));
            return this;
        }

        public final Builder redactHeaders(String... names) {
            kotlin.jvm.internal.k.f(names, "names");
            D7.A.g0(this.redactedHeaderSet, names);
            return this;
        }

        public final void setAppId(String str) {
            this.appId = str;
        }

        public final void setAppSecret(String str) {
            this.appSecret = str;
        }

        public final void setCache(AbstractC0225c abstractC0225c) {
        }

        public final void setCallTimeoutMs(long j5) {
            this.callTimeoutMs = j5;
        }

        public final void setConnectTimeoutMs(long j5) {
            this.connectTimeoutMs = j5;
        }

        public final void setConnectionPool(C0233k c0233k) {
            this.connectionPool = c0233k;
        }

        public final void setConnectionSpecs(List<C0235m> list) {
            this.connectionSpecs = list;
        }

        public final void setConverterFactory(AbstractC1858j abstractC1858j) {
            this.converterFactory = abstractC1858j;
        }

        public final void setCrashReporter(InterfaceC2131a interfaceC2131a) {
        }

        public final void setDebug(boolean z10) {
            this.debug = z10;
        }

        public final void setDefaultBaseUrl(String str) {
            kotlin.jvm.internal.k.f(str, "<set-?>");
            this.defaultBaseUrl = str;
        }

        public final void setDispatcher(C0238p c0238p) {
            this.dispatcher = c0238p;
        }

        public final void setDns(InterfaceC0239q interfaceC0239q) {
            this.dns = interfaceC0239q;
        }

        public final void setEnableDeviceHeaders(boolean z10) {
            this.enableDeviceHeaders = z10;
        }

        public final void setEnableTraceId(boolean z10) {
            this.enableTraceId = z10;
        }

        public final void setExplicitCertificatePinner$net_debug(a aVar) {
            this.explicitCertificatePinner = aVar;
        }

        public final void setGlobalErrorListener(k kVar) {
            this.globalErrorListener = kVar;
        }

        public final void setInspectorEnabled(boolean z10) {
            this.inspectorEnabled = z10;
        }

        public final void setMaxRequests(Integer num) {
            this.maxRequests = num;
        }

        public final void setMaxRequestsPerHost(Integer num) {
            this.maxRequestsPerHost = num;
        }

        public final void setMetricsListener(k kVar) {
            this.metricsListener = kVar;
        }

        public final void setNetworkMonitor(AbstractC2115a abstractC2115a) {
        }

        public final void setPinningFailureListener(AbstractC2177a abstractC2177a) {
        }

        public final void setReadTimeoutMs(long j5) {
            this.readTimeoutMs = j5;
        }

        public final void setRetryOnConnectionFailure(boolean z10) {
            this.retryOnConnectionFailure = z10;
        }

        public final void setSignatureProvider(A5.a aVar) {
            this.signatureProvider = aVar;
        }

        public final void setSslPair$net_debug(AbstractC2178b abstractC2178b) {
        }

        public final void setSuccessCodeChecker(k kVar) {
            kotlin.jvm.internal.k.f(kVar, "<set-?>");
            this.successCodeChecker = kVar;
        }

        public final void setTokenProvider(TokenProvider tokenProvider) {
            this.tokenProvider = tokenProvider;
        }

        public final void setTraceIdHeader(String str) {
            kotlin.jvm.internal.k.f(str, "<set-?>");
            this.traceIdHeader = str;
        }

        public final void setWriteTimeoutMs(long j5) {
            this.writeTimeoutMs = j5;
        }

        public final Builder sslPair(AbstractC2178b pair) {
            kotlin.jvm.internal.k.f(pair, "pair");
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpConfig(Context context, boolean z10, Map<String, String> baseUrls, long j5, long j6, long j10, long j11, Map<String, String> headers, List<? extends A> interceptors, List<? extends A> networkInterceptors, TokenProvider tokenProvider, AbstractC1858j abstractC1858j, AbstractC2178b abstractC2178b, boolean z11, k successCodeChecker, k kVar, A5.a aVar, boolean z12, String traceIdHeader, boolean z13, String str, String str2, Set<String> redactedHeaders, k kVar2, boolean z14, C0238p c0238p, C0233k c0233k, Integer num, Integer num2, InterfaceC0239q interfaceC0239q, AbstractC0225c abstractC0225c, List<C0235m> list, AbstractC2115a abstractC2115a, AbstractC2177a abstractC2177a, InterfaceC2131a interfaceC2131a, List<C2040d> pinSpecs, a aVar2) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(baseUrls, "baseUrls");
        kotlin.jvm.internal.k.f(headers, "headers");
        kotlin.jvm.internal.k.f(interceptors, "interceptors");
        kotlin.jvm.internal.k.f(networkInterceptors, "networkInterceptors");
        kotlin.jvm.internal.k.f(successCodeChecker, "successCodeChecker");
        kotlin.jvm.internal.k.f(traceIdHeader, "traceIdHeader");
        kotlin.jvm.internal.k.f(redactedHeaders, "redactedHeaders");
        kotlin.jvm.internal.k.f(pinSpecs, "pinSpecs");
        this.context = context;
        this.debug = z10;
        this.baseUrls = baseUrls;
        this.connectTimeoutMs = j5;
        this.readTimeoutMs = j6;
        this.writeTimeoutMs = j10;
        this.callTimeoutMs = j11;
        this.headers = headers;
        this.interceptors = interceptors;
        this.networkInterceptors = networkInterceptors;
        this.tokenProvider = tokenProvider;
        this.converterFactory = abstractC1858j;
        this.retryOnConnectionFailure = z11;
        this.successCodeChecker = successCodeChecker;
        this.globalErrorListener = kVar;
        this.signatureProvider = aVar;
        this.enableTraceId = z12;
        this.traceIdHeader = traceIdHeader;
        this.enableDeviceHeaders = z13;
        this.appId = str;
        this.appSecret = str2;
        this.redactedHeaders = redactedHeaders;
        this.metricsListener = kVar2;
        this.inspectorEnabled = z14;
        this.dispatcher = c0238p;
        this.connectionPool = c0233k;
        this.maxRequests = num;
        this.maxRequestsPerHost = num2;
        this.dns = interfaceC0239q;
        this.connectionSpecs = list;
        this.pinSpecs = pinSpecs;
        this.explicitCertificatePinner = aVar2;
    }

    public final String baseUrlOf(String key) {
        kotlin.jvm.internal.k.f(key, "key");
        return this.baseUrls.get(key);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppSecret() {
        return this.appSecret;
    }

    public final Map<String, String> getBaseUrls() {
        return this.baseUrls;
    }

    public final AbstractC0225c getCache() {
        return null;
    }

    public final long getCallTimeoutMs() {
        return this.callTimeoutMs;
    }

    public final long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public final C0233k getConnectionPool() {
        return this.connectionPool;
    }

    public final List<C0235m> getConnectionSpecs() {
        return this.connectionSpecs;
    }

    public final Context getContext() {
        return this.context;
    }

    public final AbstractC1858j getConverterFactory() {
        return this.converterFactory;
    }

    public final InterfaceC2131a getCrashReporter() {
        return null;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final C0238p getDispatcher() {
        return this.dispatcher;
    }

    public final InterfaceC0239q getDns() {
        return this.dns;
    }

    public final boolean getEnableDeviceHeaders() {
        return this.enableDeviceHeaders;
    }

    public final boolean getEnableTraceId() {
        return this.enableTraceId;
    }

    /* renamed from: getExplicitCertificatePinner$net_debug, reason: from getter */
    public final a getExplicitCertificatePinner() {
        return this.explicitCertificatePinner;
    }

    public final k getGlobalErrorListener() {
        return this.globalErrorListener;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final boolean getInspectorEnabled() {
        return this.inspectorEnabled;
    }

    public final List<A> getInterceptors() {
        return this.interceptors;
    }

    public final Integer getMaxRequests() {
        return this.maxRequests;
    }

    public final Integer getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final k getMetricsListener() {
        return this.metricsListener;
    }

    public final List<A> getNetworkInterceptors() {
        return this.networkInterceptors;
    }

    public final AbstractC2115a getNetworkMonitor() {
        return null;
    }

    public final List<C2040d> getPinSpecs$net_debug() {
        return this.pinSpecs;
    }

    public final AbstractC2177a getPinningFailureListener() {
        return null;
    }

    public final long getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    public final Set<String> getRedactedHeaders() {
        return this.redactedHeaders;
    }

    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public final A5.a getSignatureProvider() {
        return this.signatureProvider;
    }

    public final AbstractC2178b getSslPair() {
        return null;
    }

    public final k getSuccessCodeChecker() {
        return this.successCodeChecker;
    }

    public final TokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    public final String getTraceIdHeader() {
        return this.traceIdHeader;
    }

    public final long getWriteTimeoutMs() {
        return this.writeTimeoutMs;
    }

    public final a resolveCertificatePinner$net_debug() {
        if (this.pinSpecs.isEmpty() && this.explicitCertificatePinner == null) {
            return null;
        }
        if (this.pinSpecs.isEmpty()) {
            return this.explicitCertificatePinner;
        }
        ArrayList arrayList = new ArrayList();
        for (C2040d c2040d : this.pinSpecs) {
            Iterator it = c2040d.b.iterator();
            while (it.hasNext()) {
                arrayList.add(new C0230h(c2040d.f6709a, new String[]{(String) it.next()}[0]));
            }
        }
        return new a(v.j1(arrayList), null);
    }
}
