package com.stepos.net;

import G7.HttpMetrics;
import I7.c;
import La.D;
import La.H;
import Y8.t;
import Z8.A;
import Z8.F;
import Z8.r;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.net.HttpConfig;
import com.stepos.net.exception.ApiException;
import com.stepos.net.token.TokenProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import okhttp3.b;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import tb.C5536c;
import tb.C5541h;
import tb.C5544k;
import tb.C5548o;
import tb.InterfaceC5549p;
import tb.w;
import yc.h;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b_\u0018\u0000 \u009d\u00012\u00020\u0001:\u0006\u009e\u0001\u009f\u0001 \u0001BÁ\u0003\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u001a\u0012\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070'\u0012\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\b\u00100\u001a\u0004\u0018\u00010\u001b\u0012\b\u00101\u001a\u0004\u0018\u00010\u001b\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\u000e\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000f\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010>\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u000f\u0012\b\u0010C\u001a\u0004\u0018\u00010B¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u0004\u0018\u00010\u00072\u0006\u0010F\u001a\u00020\u0007¢\u0006\u0004\bG\u0010HJ\u0011\u0010K\u001a\u0004\u0018\u00010BH\u0000¢\u0006\u0004\bI\u0010JR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010L\u001a\u0004\bM\u0010NR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010O\u001a\u0004\bP\u0010QR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010R\u001a\u0004\bS\u0010TR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010U\u001a\u0004\bV\u0010WR\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010U\u001a\u0004\bX\u0010WR\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010U\u001a\u0004\bY\u0010WR\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\r\u0010U\u001a\u0004\bZ\u0010WR#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010R\u001a\u0004\b[\u0010TR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\\\u001a\u0004\b]\u0010^R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\\\u001a\u0004\b_\u0010^R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010`\u001a\u0004\ba\u0010bR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010c\u001a\u0004\bd\u0010eR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010f\u001a\u0004\bg\u0010hR\u0017\u0010\u0019\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010O\u001a\u0004\bi\u0010QR#\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u001a8\u0006¢\u0006\f\n\u0004\b\u001c\u0010j\u001a\u0004\bk\u0010lR%\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001f\u0010j\u001a\u0004\bm\u0010lR\u0019\u0010!\u001a\u0004\u0018\u00010 8\u0006¢\u0006\f\n\u0004\b!\u0010n\u001a\u0004\bo\u0010pR\u0017\u0010\"\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010O\u001a\u0004\bq\u0010QR\u0017\u0010#\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b#\u0010r\u001a\u0004\bs\u0010tR\u0017\u0010$\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b$\u0010O\u001a\u0004\bu\u0010QR\u0019\u0010%\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b%\u0010r\u001a\u0004\bv\u0010tR\u0019\u0010&\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b&\u0010r\u001a\u0004\bw\u0010tR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070'8\u0006¢\u0006\f\n\u0004\b(\u0010x\u001a\u0004\by\u0010zR%\u0010*\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b*\u0010j\u001a\u0004\b{\u0010lR\u0017\u0010+\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b+\u0010O\u001a\u0004\b|\u0010QR\u0019\u0010-\u001a\u0004\u0018\u00010,8\u0006¢\u0006\f\n\u0004\b-\u0010}\u001a\u0004\b~\u0010\u007fR\u001c\u0010/\u001a\u0004\u0018\u00010.8\u0006¢\u0006\u000f\n\u0005\b/\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u00100\u001a\u0004\u0018\u00010\u001b8\u0006¢\u0006\u000f\n\u0005\b0\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u00101\u001a\u0004\u0018\u00010\u001b8\u0006¢\u0006\u000f\n\u0005\b1\u0010\u0083\u0001\u001a\u0006\b\u0086\u0001\u0010\u0085\u0001R\u001c\u00103\u001a\u0004\u0018\u0001028\u0006¢\u0006\u000f\n\u0005\b3\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u00105\u001a\u0004\u0018\u0001048\u0006¢\u0006\u000f\n\u0005\b5\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R \u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000f8\u0006¢\u0006\r\n\u0004\b7\u0010\\\u001a\u0005\b\u008d\u0001\u0010^R\u001c\u00109\u001a\u0004\u0018\u0001088\u0006¢\u0006\u000f\n\u0005\b9\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010;\u001a\u0004\u0018\u00010:8\u0006¢\u0006\u000f\n\u0005\b;\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010=\u001a\u0004\u0018\u00010<8\u0006¢\u0006\u000f\n\u0005\b=\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\"\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010>8\u0006¢\u0006\u000f\n\u0005\b?\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R!\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u000f8\u0000X\u0080\u0004¢\u0006\r\n\u0004\bA\u0010\\\u001a\u0005\b\u009a\u0001\u0010^R\u001e\u0010C\u001a\u0004\u0018\u00010B8\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\bC\u0010\u009b\u0001\u001a\u0005\b\u009c\u0001\u0010J¨\u0006¡\u0001"}, d2 = {"Lcom/stepos/net/HttpConfig;", "", "Landroid/content/Context;", "context", "", Parameters.DEBUG, "", "", "baseUrls", "", "connectTimeoutMs", "readTimeoutMs", "writeTimeoutMs", "callTimeoutMs", "headers", "", "Ltb/w;", "interceptors", "networkInterceptors", "Lcom/stepos/net/token/TokenProvider;", "tokenProvider", "Lyc/h$a;", "converterFactory", "LH7/b;", "sslPair", "retryOnConnectionFailure", "Lkotlin/Function1;", "", "successCodeChecker", "Lcom/stepos/net/exception/ApiException;", "LY8/t;", "globalErrorListener", "LI7/c;", "signatureProvider", "enableTraceId", "traceIdHeader", "enableDeviceHeaders", "appId", "appSecret", "", "redactedHeaders", "LG7/c;", "metricsListener", "inspectorEnabled", "Ltb/o;", "dispatcher", "Ltb/k;", "connectionPool", "maxRequests", "maxRequestsPerHost", "Ltb/p;", "dns", "Ltb/c;", "cache", "Lokhttp3/b;", "connectionSpecs", "LF7/a;", "networkMonitor", "LH7/a;", "pinningFailureListener", "LG7/a;", "crashReporter", "Lkotlin/Function0;", "privacyGate", "Lcom/stepos/net/HttpConfig$b;", "pinSpecs", "Ltb/h;", "explicitCertificatePinner", "<init>", "(Landroid/content/Context;ZLjava/util/Map;JJJJLjava/util/Map;Ljava/util/List;Ljava/util/List;Lcom/stepos/net/token/TokenProvider;Lyc/h$a;LH7/b;ZLp9/l;Lp9/l;LI7/c;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/Set;Lp9/l;ZLtb/o;Ltb/k;Ljava/lang/Integer;Ljava/lang/Integer;Ltb/p;Ltb/c;Ljava/util/List;LF7/a;LH7/a;LG7/a;Lp9/a;Ljava/util/List;Ltb/h;)V", "key", "baseUrlOf", "(Ljava/lang/String;)Ljava/lang/String;", "resolveCertificatePinner$net_release", "()Ltb/h;", "resolveCertificatePinner", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Z", "getDebug", "()Z", "Ljava/util/Map;", "getBaseUrls", "()Ljava/util/Map;", "J", "getConnectTimeoutMs", "()J", "getReadTimeoutMs", "getWriteTimeoutMs", "getCallTimeoutMs", "getHeaders", "Ljava/util/List;", "getInterceptors", "()Ljava/util/List;", "getNetworkInterceptors", "Lcom/stepos/net/token/TokenProvider;", "getTokenProvider", "()Lcom/stepos/net/token/TokenProvider;", "Lyc/h$a;", "getConverterFactory", "()Lyc/h$a;", "LH7/b;", "getSslPair", "()LH7/b;", "getRetryOnConnectionFailure", "Lp9/l;", "getSuccessCodeChecker", "()Lp9/l;", "getGlobalErrorListener", "LI7/c;", "getSignatureProvider", "()LI7/c;", "getEnableTraceId", "Ljava/lang/String;", "getTraceIdHeader", "()Ljava/lang/String;", "getEnableDeviceHeaders", "getAppId", "getAppSecret", "Ljava/util/Set;", "getRedactedHeaders", "()Ljava/util/Set;", "getMetricsListener", "getInspectorEnabled", "Ltb/o;", "getDispatcher", "()Ltb/o;", "Ltb/k;", "getConnectionPool", "()Ltb/k;", "Ljava/lang/Integer;", "getMaxRequests", "()Ljava/lang/Integer;", "getMaxRequestsPerHost", "Ltb/p;", "getDns", "()Ltb/p;", "Ltb/c;", "getCache", "()Ltb/c;", "getConnectionSpecs", "LF7/a;", "getNetworkMonitor", "()LF7/a;", "LH7/a;", "getPinningFailureListener", "()LH7/a;", "LG7/a;", "getCrashReporter", "()LG7/a;", "Lp9/a;", "getPrivacyGate", "()Lp9/a;", "getPinSpecs$net_release", "Ltb/h;", "getExplicitCertificatePinner$net_release", "Companion", Const.INTENT_KEY_PKGNAME, "Builder", Const.INTENT_KEY_APIKEY, "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HttpConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TimeUnit MILLISECONDS = TimeUnit.MILLISECONDS;
    private final String appId;
    private final String appSecret;
    private final Map<String, String> baseUrls;
    private final C5536c cache;
    private final long callTimeoutMs;
    private final long connectTimeoutMs;
    private final C5544k connectionPool;
    private final List<b> connectionSpecs;
    private final Context context;
    private final h.a converterFactory;
    private final G7.a crashReporter;
    private final boolean debug;
    private final C5548o dispatcher;
    private final InterfaceC5549p dns;
    private final boolean enableDeviceHeaders;
    private final boolean enableTraceId;
    private final C5541h explicitCertificatePinner;
    private final InterfaceC5074l<ApiException, t> globalErrorListener;
    private final Map<String, String> headers;
    private final boolean inspectorEnabled;
    private final List<w> interceptors;
    private final Integer maxRequests;
    private final Integer maxRequestsPerHost;
    private final InterfaceC5074l<HttpMetrics, t> metricsListener;
    private final List<w> networkInterceptors;
    private final F7.a networkMonitor;
    private final List<PinSpec> pinSpecs;
    private final H7.a pinningFailureListener;
    private final InterfaceC5063a<Boolean> privacyGate;
    private final long readTimeoutMs;
    private final Set<String> redactedHeaders;
    private final boolean retryOnConnectionFailure;
    private final c signatureProvider;
    private final H7.b sslPair;
    private final InterfaceC5074l<Integer, Boolean> successCodeChecker;
    private final TokenProvider tokenProvider;
    private final String traceIdHeader;
    private final long writeTimeoutMs;

    @Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\nJ!\u0010\u0010\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J!\u0010\u0019\u001a\u00020\u00002\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0017\"\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010!\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00062\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0017\"\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\r\u0010(\u001a\u00020'¢\u0006\u0004\b(\u0010)R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\"\u0010D\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010<\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\"\u0010G\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010<\u001a\u0004\bH\u0010>\"\u0004\bI\u0010@R$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010R\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010X\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010/\u001a\u0004\bY\u00101\"\u0004\bZ\u00103R.\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020-0[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR0\u0010e\u001a\u0010\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020d\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010^\u001a\u0004\bf\u0010`\"\u0004\bg\u0010bR$\u0010i\u001a\u0004\u0018\u00010h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010o\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010/\u001a\u0004\bp\u00101\"\u0004\bq\u00103R\"\u0010r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u00105\u001a\u0004\bs\u00107\"\u0004\bt\u00109R\"\u0010u\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010/\u001a\u0004\bv\u00101\"\u0004\bw\u00103R$\u0010x\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u00105\u001a\u0004\by\u00107\"\u0004\bz\u00109R$\u0010{\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u00105\u001a\u0004\b|\u00107\"\u0004\b}\u00109R2\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u00020d\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010^\u001a\u0005\b\u0080\u0001\u0010`\"\u0005\b\u0081\u0001\u0010bR&\u0010\u0082\u0001\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010/\u001a\u0005\b\u0083\u0001\u00101\"\u0005\b\u0084\u0001\u00103R,\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R,\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R+\u0010\u0093\u0001\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R+\u0010\u0099\u0001\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u0094\u0001\u001a\u0006\b\u009a\u0001\u0010\u0096\u0001\"\u0006\b\u009b\u0001\u0010\u0098\u0001R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R,\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R3\u0010¬\u0001\u001a\f\u0012\u0005\u0012\u00030«\u0001\u0018\u00010ª\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R,\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R,\u0010º\u0001\u001a\u0005\u0018\u00010¹\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R,\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R2\u0010È\u0001\u001a\u000b\u0012\u0004\u0012\u00020-\u0018\u00010Ç\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R,\u0010Ï\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060Î\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÏ\u0001\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001R,\u0010Ó\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060Î\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÓ\u0001\u0010Ð\u0001\u001a\u0006\bÔ\u0001\u0010Ò\u0001R&\u0010Ö\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120Õ\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÖ\u0001\u0010\u00ad\u0001\u001a\u0006\b×\u0001\u0010¯\u0001R&\u0010Ø\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120Õ\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bØ\u0001\u0010\u00ad\u0001\u001a\u0006\bÙ\u0001\u0010¯\u0001R+\u0010Ú\u0001\u001a\u0004\u0018\u00010\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÚ\u0001\u0010Û\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R'\u0010á\u0001\u001a\n\u0012\u0005\u0012\u00030à\u00010Õ\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bá\u0001\u0010\u00ad\u0001\u001a\u0006\bâ\u0001\u0010¯\u0001R)\u0010%\u001a\u0004\u0018\u00010#8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b%\u0010ã\u0001\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001R&\u0010é\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060è\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001¨\u0006í\u0001"}, d2 = {"Lcom/stepos/net/HttpConfig$Builder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "key", "url", "addBaseUrl", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/net/HttpConfig$Builder;", "name", UxipConstants.f30680s, "addHeader", "", C3081a.FOCUS_MAP_NAME, "addHeaders", "(Ljava/util/Map;)Lcom/stepos/net/HttpConfig$Builder;", "Ltb/w;", "interceptor", "addInterceptor", "(Ltb/w;)Lcom/stepos/net/HttpConfig$Builder;", "addNetworkInterceptor", "", "names", "redactHeaders", "([Ljava/lang/String;)Lcom/stepos/net/HttpConfig$Builder;", "Ltb/h;", "pinner", "certificatePinner", "(Ltb/h;)Lcom/stepos/net/HttpConfig$Builder;", "hostname", "sha256Pins", "pinHost", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/stepos/net/HttpConfig$Builder;", "LH7/b;", "pair", "sslPair", "(LH7/b;)Lcom/stepos/net/HttpConfig$Builder;", "Lcom/stepos/net/HttpConfig;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcom/stepos/net/HttpConfig;", "Landroid/content/Context;", "getContext$net_release", "()Landroid/content/Context;", "", Parameters.DEBUG, "Z", "getDebug", "()Z", "setDebug", "(Z)V", "defaultBaseUrl", "Ljava/lang/String;", "getDefaultBaseUrl", "()Ljava/lang/String;", "setDefaultBaseUrl", "(Ljava/lang/String;)V", "", "connectTimeoutMs", "J", "getConnectTimeoutMs", "()J", "setConnectTimeoutMs", "(J)V", "readTimeoutMs", "getReadTimeoutMs", "setReadTimeoutMs", "writeTimeoutMs", "getWriteTimeoutMs", "setWriteTimeoutMs", "callTimeoutMs", "getCallTimeoutMs", "setCallTimeoutMs", "Lcom/stepos/net/token/TokenProvider;", "tokenProvider", "Lcom/stepos/net/token/TokenProvider;", "getTokenProvider", "()Lcom/stepos/net/token/TokenProvider;", "setTokenProvider", "(Lcom/stepos/net/token/TokenProvider;)V", "Lyc/h$a;", "converterFactory", "Lyc/h$a;", "getConverterFactory", "()Lyc/h$a;", "setConverterFactory", "(Lyc/h$a;)V", "retryOnConnectionFailure", "getRetryOnConnectionFailure", "setRetryOnConnectionFailure", "Lkotlin/Function1;", "", "successCodeChecker", "Lp9/l;", "getSuccessCodeChecker", "()Lp9/l;", "setSuccessCodeChecker", "(Lp9/l;)V", "Lcom/stepos/net/exception/ApiException;", "LY8/t;", "globalErrorListener", "getGlobalErrorListener", "setGlobalErrorListener", "LI7/c;", "signatureProvider", "LI7/c;", "getSignatureProvider", "()LI7/c;", "setSignatureProvider", "(LI7/c;)V", "enableTraceId", "getEnableTraceId", "setEnableTraceId", "traceIdHeader", "getTraceIdHeader", "setTraceIdHeader", "enableDeviceHeaders", "getEnableDeviceHeaders", "setEnableDeviceHeaders", "appId", "getAppId", "setAppId", "appSecret", "getAppSecret", "setAppSecret", "LG7/c;", "metricsListener", "getMetricsListener", "setMetricsListener", "inspectorEnabled", "getInspectorEnabled", "setInspectorEnabled", "Ltb/o;", "dispatcher", "Ltb/o;", "getDispatcher", "()Ltb/o;", "setDispatcher", "(Ltb/o;)V", "Ltb/k;", "connectionPool", "Ltb/k;", "getConnectionPool", "()Ltb/k;", "setConnectionPool", "(Ltb/k;)V", "maxRequests", "Ljava/lang/Integer;", "getMaxRequests", "()Ljava/lang/Integer;", "setMaxRequests", "(Ljava/lang/Integer;)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "Ltb/p;", "dns", "Ltb/p;", "getDns", "()Ltb/p;", "setDns", "(Ltb/p;)V", "Ltb/c;", "cache", "Ltb/c;", "getCache", "()Ltb/c;", "setCache", "(Ltb/c;)V", "", "Lokhttp3/b;", "connectionSpecs", "Ljava/util/List;", "getConnectionSpecs", "()Ljava/util/List;", "setConnectionSpecs", "(Ljava/util/List;)V", "LF7/a;", "networkMonitor", "LF7/a;", "getNetworkMonitor", "()LF7/a;", "setNetworkMonitor", "(LF7/a;)V", "LH7/a;", "pinningFailureListener", "LH7/a;", "getPinningFailureListener", "()LH7/a;", "setPinningFailureListener", "(LH7/a;)V", "LG7/a;", "crashReporter", "LG7/a;", "getCrashReporter", "()LG7/a;", "setCrashReporter", "(LG7/a;)V", "Lkotlin/Function0;", "privacyGate", "Lp9/a;", "getPrivacyGate", "()Lp9/a;", "setPrivacyGate", "(Lp9/a;)V", "", "baseUrlMap", "Ljava/util/Map;", "getBaseUrlMap$net_release", "()Ljava/util/Map;", "headerMap", "getHeaderMap$net_release", "", "interceptorList", "getInterceptorList$net_release", "networkInterceptorList", "getNetworkInterceptorList$net_release", "explicitCertificatePinner", "Ltb/h;", "getExplicitCertificatePinner$net_release", "()Ltb/h;", "setExplicitCertificatePinner$net_release", "(Ltb/h;)V", "Lcom/stepos/net/HttpConfig$b;", "pinSpecs", "getPinSpecs$net_release", "LH7/b;", "getSslPair$net_release", "()LH7/b;", "setSslPair$net_release", "(LH7/b;)V", "", "redactedHeaderSet", "Ljava/util/Set;", "getRedactedHeaderSet$net_release", "()Ljava/util/Set;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private String appId;
        private String appSecret;
        private final Map<String, String> baseUrlMap;
        private C5536c cache;
        private long callTimeoutMs;
        private long connectTimeoutMs;
        private C5544k connectionPool;
        private List<b> connectionSpecs;
        private final Context context;
        private h.a converterFactory;
        private G7.a crashReporter;
        private boolean debug;
        private String defaultBaseUrl;
        private C5548o dispatcher;
        private InterfaceC5549p dns;
        private boolean enableDeviceHeaders;
        private boolean enableTraceId;
        private C5541h explicitCertificatePinner;
        private InterfaceC5074l<? super ApiException, t> globalErrorListener;
        private final Map<String, String> headerMap;
        private boolean inspectorEnabled;
        private final List<w> interceptorList;
        private Integer maxRequests;
        private Integer maxRequestsPerHost;
        private InterfaceC5074l<? super HttpMetrics, t> metricsListener;
        private final List<w> networkInterceptorList;
        private F7.a networkMonitor;
        private final List<PinSpec> pinSpecs;
        private H7.a pinningFailureListener;
        private InterfaceC5063a<Boolean> privacyGate;
        private long readTimeoutMs;
        private final Set<String> redactedHeaderSet;
        private boolean retryOnConnectionFailure;
        private c signatureProvider;
        private H7.b sslPair;
        private InterfaceC5074l<? super Integer, Boolean> successCodeChecker;
        private TokenProvider tokenProvider;
        private String traceIdHeader;
        private long writeTimeoutMs;

        public Builder(Context context) {
            p.i(context, "context");
            this.context = context;
            this.defaultBaseUrl = "";
            this.connectTimeoutMs = 15000L;
            this.readTimeoutMs = 20000L;
            this.writeTimeoutMs = 20000L;
            this.callTimeoutMs = 30000L;
            this.retryOnConnectionFailure = true;
            this.successCodeChecker = new InterfaceC5074l() { // from class: C7.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(HttpConfig.Builder.successCodeChecker$lambda$0(((Integer) obj).intValue()));
                }
            };
            this.enableTraceId = true;
            this.traceIdHeader = "X-Request-Id";
            this.enableDeviceHeaders = true;
            this.baseUrlMap = new LinkedHashMap();
            this.headerMap = new LinkedHashMap();
            this.interceptorList = new ArrayList();
            this.networkInterceptorList = new ArrayList();
            this.pinSpecs = new ArrayList();
            this.redactedHeaderSet = F.q1(C7.c.f1727a.a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean successCodeChecker$lambda$0(int i10) {
            return i10 == 0;
        }

        public final Builder addBaseUrl(String key, String url) {
            p.i(key, "key");
            p.i(url, "url");
            if (H.x0(key)) {
                throw new IllegalArgumentException("BaseUrl key must not be blank");
            }
            if (D.K(url, "/", false, 2, null)) {
                this.baseUrlMap.put(key, url);
                return this;
            }
            throw new IllegalArgumentException(("BaseUrl '" + url + "' must end with '/'").toString());
        }

        public final Builder addHeader(String name, String value) {
            p.i(name, "name");
            p.i(value, "value");
            this.headerMap.put(name, value);
            return this;
        }

        public final Builder addHeaders(Map<String, String> map) {
            p.i(map, "map");
            this.headerMap.putAll(map);
            return this;
        }

        public final Builder addInterceptor(w interceptor) {
            p.i(interceptor, "interceptor");
            this.interceptorList.add(interceptor);
            return this;
        }

        public final Builder addNetworkInterceptor(w interceptor) {
            p.i(interceptor, "interceptor");
            this.networkInterceptorList.add(interceptor);
            return this;
        }

        public final HttpConfig build() {
            if (H.x0(this.defaultBaseUrl)) {
                throw new IllegalArgumentException("defaultBaseUrl must be configured");
            }
            if (!D.K(this.defaultBaseUrl, "/", false, 2, null)) {
                throw new IllegalArgumentException(("defaultBaseUrl '" + this.defaultBaseUrl + "' must end with '/'").toString());
            }
            if (this.connectTimeoutMs <= 0 || this.readTimeoutMs <= 0 || this.writeTimeoutMs <= 0) {
                throw new IllegalArgumentException("Timeouts must be positive");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.baseUrlMap.size() + 1);
            linkedHashMap.put("__default__", this.defaultBaseUrl);
            linkedHashMap.putAll(this.baseUrlMap);
            Context applicationContext = this.context.getApplicationContext();
            p.h(applicationContext, "getApplicationContext(...)");
            return new HttpConfig(applicationContext, this.debug, kotlin.collections.a.A(linkedHashMap), this.connectTimeoutMs, this.readTimeoutMs, this.writeTimeoutMs, this.callTimeoutMs, kotlin.collections.a.A(this.headerMap), F.m1(this.interceptorList), F.m1(this.networkInterceptorList), this.tokenProvider, this.converterFactory, null, this.retryOnConnectionFailure, this.successCodeChecker, this.globalErrorListener, this.signatureProvider, this.enableTraceId, this.traceIdHeader, this.enableDeviceHeaders, this.appId, this.appSecret, F.r1(this.redactedHeaderSet), this.metricsListener, this.inspectorEnabled, this.dispatcher, this.connectionPool, this.maxRequests, this.maxRequestsPerHost, this.dns, null, this.connectionSpecs, null, null, null, this.privacyGate, F.m1(this.pinSpecs), this.explicitCertificatePinner);
        }

        public final Builder certificatePinner(C5541h pinner) {
            p.i(pinner, "pinner");
            this.explicitCertificatePinner = pinner;
            return this;
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getAppSecret() {
            return this.appSecret;
        }

        public final Map<String, String> getBaseUrlMap$net_release() {
            return this.baseUrlMap;
        }

        public final C5536c getCache() {
            return null;
        }

        public final long getCallTimeoutMs() {
            return this.callTimeoutMs;
        }

        public final long getConnectTimeoutMs() {
            return this.connectTimeoutMs;
        }

        public final C5544k getConnectionPool() {
            return this.connectionPool;
        }

        public final List<b> getConnectionSpecs() {
            return this.connectionSpecs;
        }

        /* renamed from: getContext$net_release, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        public final h.a getConverterFactory() {
            return this.converterFactory;
        }

        public final G7.a getCrashReporter() {
            return null;
        }

        public final boolean getDebug() {
            return this.debug;
        }

        public final String getDefaultBaseUrl() {
            return this.defaultBaseUrl;
        }

        public final C5548o getDispatcher() {
            return this.dispatcher;
        }

        public final InterfaceC5549p getDns() {
            return this.dns;
        }

        public final boolean getEnableDeviceHeaders() {
            return this.enableDeviceHeaders;
        }

        public final boolean getEnableTraceId() {
            return this.enableTraceId;
        }

        /* renamed from: getExplicitCertificatePinner$net_release, reason: from getter */
        public final C5541h getExplicitCertificatePinner() {
            return this.explicitCertificatePinner;
        }

        public final InterfaceC5074l<ApiException, t> getGlobalErrorListener() {
            return this.globalErrorListener;
        }

        public final Map<String, String> getHeaderMap$net_release() {
            return this.headerMap;
        }

        public final boolean getInspectorEnabled() {
            return this.inspectorEnabled;
        }

        public final List<w> getInterceptorList$net_release() {
            return this.interceptorList;
        }

        public final Integer getMaxRequests() {
            return this.maxRequests;
        }

        public final Integer getMaxRequestsPerHost() {
            return this.maxRequestsPerHost;
        }

        public final InterfaceC5074l<HttpMetrics, t> getMetricsListener() {
            return this.metricsListener;
        }

        public final List<w> getNetworkInterceptorList$net_release() {
            return this.networkInterceptorList;
        }

        public final F7.a getNetworkMonitor() {
            return null;
        }

        public final List<PinSpec> getPinSpecs$net_release() {
            return this.pinSpecs;
        }

        public final H7.a getPinningFailureListener() {
            return null;
        }

        public final InterfaceC5063a<Boolean> getPrivacyGate() {
            return this.privacyGate;
        }

        public final long getReadTimeoutMs() {
            return this.readTimeoutMs;
        }

        public final Set<String> getRedactedHeaderSet$net_release() {
            return this.redactedHeaderSet;
        }

        public final boolean getRetryOnConnectionFailure() {
            return this.retryOnConnectionFailure;
        }

        public final c getSignatureProvider() {
            return this.signatureProvider;
        }

        public final H7.b getSslPair$net_release() {
            return null;
        }

        public final InterfaceC5074l<Integer, Boolean> getSuccessCodeChecker() {
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
            p.i(hostname, "hostname");
            p.i(sha256Pins, "sha256Pins");
            if (sha256Pins.length == 0) {
                throw new IllegalArgumentException("At least one pin is required");
            }
            this.pinSpecs.add(new PinSpec(hostname, r.T0(sha256Pins)));
            return this;
        }

        public final Builder redactHeaders(String... names) {
            p.i(names, "names");
            A.F(this.redactedHeaderSet, names);
            return this;
        }

        public final void setAppId(String str) {
            this.appId = str;
        }

        public final void setAppSecret(String str) {
            this.appSecret = str;
        }

        public final void setCache(C5536c c5536c) {
        }

        public final void setCallTimeoutMs(long j10) {
            this.callTimeoutMs = j10;
        }

        public final void setConnectTimeoutMs(long j10) {
            this.connectTimeoutMs = j10;
        }

        public final void setConnectionPool(C5544k c5544k) {
            this.connectionPool = c5544k;
        }

        public final void setConnectionSpecs(List<b> list) {
            this.connectionSpecs = list;
        }

        public final void setConverterFactory(h.a aVar) {
            this.converterFactory = aVar;
        }

        public final void setCrashReporter(G7.a aVar) {
        }

        public final void setDebug(boolean z10) {
            this.debug = z10;
        }

        public final void setDefaultBaseUrl(String str) {
            p.i(str, "<set-?>");
            this.defaultBaseUrl = str;
        }

        public final void setDispatcher(C5548o c5548o) {
            this.dispatcher = c5548o;
        }

        public final void setDns(InterfaceC5549p interfaceC5549p) {
            this.dns = interfaceC5549p;
        }

        public final void setEnableDeviceHeaders(boolean z10) {
            this.enableDeviceHeaders = z10;
        }

        public final void setEnableTraceId(boolean z10) {
            this.enableTraceId = z10;
        }

        public final void setExplicitCertificatePinner$net_release(C5541h c5541h) {
            this.explicitCertificatePinner = c5541h;
        }

        public final void setGlobalErrorListener(InterfaceC5074l<? super ApiException, t> interfaceC5074l) {
            this.globalErrorListener = interfaceC5074l;
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

        public final void setMetricsListener(InterfaceC5074l<? super HttpMetrics, t> interfaceC5074l) {
            this.metricsListener = interfaceC5074l;
        }

        public final void setNetworkMonitor(F7.a aVar) {
        }

        public final void setPinningFailureListener(H7.a aVar) {
        }

        public final void setPrivacyGate(InterfaceC5063a<Boolean> interfaceC5063a) {
            this.privacyGate = interfaceC5063a;
        }

        public final void setReadTimeoutMs(long j10) {
            this.readTimeoutMs = j10;
        }

        public final void setRetryOnConnectionFailure(boolean z10) {
            this.retryOnConnectionFailure = z10;
        }

        public final void setSignatureProvider(c cVar) {
            this.signatureProvider = cVar;
        }

        public final void setSslPair$net_release(H7.b bVar) {
        }

        public final void setSuccessCodeChecker(InterfaceC5074l<? super Integer, Boolean> interfaceC5074l) {
            p.i(interfaceC5074l, "<set-?>");
            this.successCodeChecker = interfaceC5074l;
        }

        public final void setTokenProvider(TokenProvider tokenProvider) {
            this.tokenProvider = tokenProvider;
        }

        public final void setTraceIdHeader(String str) {
            p.i(str, "<set-?>");
            this.traceIdHeader = str;
        }

        public final void setWriteTimeoutMs(long j10) {
            this.writeTimeoutMs = j10;
        }

        public final Builder sslPair(H7.b pair) {
            p.i(pair, "pair");
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/net/HttpConfig$a;", "", "<init>", "()V", "Ljava/util/concurrent/TimeUnit;", "MILLISECONDS", "Ljava/util/concurrent/TimeUnit;", Const.INTENT_KEY_APIKEY, "()Ljava/util/concurrent/TimeUnit;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.net.HttpConfig$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final TimeUnit a() {
            return HttpConfig.MILLISECONDS;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\tR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/net/HttpConfig$b;", "", "", "hostname", "", "pins", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "()Ljava/util/List;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.net.HttpConfig$b, reason: from toString */
    public static final /* data */ class PinSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String hostname;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<String> pins;

        public PinSpec(String hostname, List<String> pins) {
            p.i(hostname, "hostname");
            p.i(pins, "pins");
            this.hostname = hostname;
            this.pins = pins;
        }

        /* renamed from: a, reason: from getter */
        public final String getHostname() {
            return this.hostname;
        }

        public final List<String> b() {
            return this.pins;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PinSpec)) {
                return false;
            }
            PinSpec pinSpec = (PinSpec) other;
            return p.d(this.hostname, pinSpec.hostname) && p.d(this.pins, pinSpec.pins);
        }

        public int hashCode() {
            return (this.hostname.hashCode() * 31) + this.pins.hashCode();
        }

        public String toString() {
            return "PinSpec(hostname=" + this.hostname + ", pins=" + this.pins + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpConfig(Context context, boolean z10, Map<String, String> baseUrls, long j10, long j11, long j12, long j13, Map<String, String> headers, List<? extends w> interceptors, List<? extends w> networkInterceptors, TokenProvider tokenProvider, h.a aVar, H7.b bVar, boolean z11, InterfaceC5074l<? super Integer, Boolean> successCodeChecker, InterfaceC5074l<? super ApiException, t> interfaceC5074l, c cVar, boolean z12, String traceIdHeader, boolean z13, String str, String str2, Set<String> redactedHeaders, InterfaceC5074l<? super HttpMetrics, t> interfaceC5074l2, boolean z14, C5548o c5548o, C5544k c5544k, Integer num, Integer num2, InterfaceC5549p interfaceC5549p, C5536c c5536c, List<b> list, F7.a aVar2, H7.a aVar3, G7.a aVar4, InterfaceC5063a<Boolean> interfaceC5063a, List<PinSpec> pinSpecs, C5541h c5541h) {
        p.i(context, "context");
        p.i(baseUrls, "baseUrls");
        p.i(headers, "headers");
        p.i(interceptors, "interceptors");
        p.i(networkInterceptors, "networkInterceptors");
        p.i(successCodeChecker, "successCodeChecker");
        p.i(traceIdHeader, "traceIdHeader");
        p.i(redactedHeaders, "redactedHeaders");
        p.i(pinSpecs, "pinSpecs");
        this.context = context;
        this.debug = z10;
        this.baseUrls = baseUrls;
        this.connectTimeoutMs = j10;
        this.readTimeoutMs = j11;
        this.writeTimeoutMs = j12;
        this.callTimeoutMs = j13;
        this.headers = headers;
        this.interceptors = interceptors;
        this.networkInterceptors = networkInterceptors;
        this.tokenProvider = tokenProvider;
        this.converterFactory = aVar;
        this.retryOnConnectionFailure = z11;
        this.successCodeChecker = successCodeChecker;
        this.globalErrorListener = interfaceC5074l;
        this.signatureProvider = cVar;
        this.enableTraceId = z12;
        this.traceIdHeader = traceIdHeader;
        this.enableDeviceHeaders = z13;
        this.appId = str;
        this.appSecret = str2;
        this.redactedHeaders = redactedHeaders;
        this.metricsListener = interfaceC5074l2;
        this.inspectorEnabled = z14;
        this.dispatcher = c5548o;
        this.connectionPool = c5544k;
        this.maxRequests = num;
        this.maxRequestsPerHost = num2;
        this.dns = interfaceC5549p;
        this.connectionSpecs = list;
        this.privacyGate = interfaceC5063a;
        this.pinSpecs = pinSpecs;
        this.explicitCertificatePinner = c5541h;
    }

    public final String baseUrlOf(String key) {
        p.i(key, "key");
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

    public final C5536c getCache() {
        return null;
    }

    public final long getCallTimeoutMs() {
        return this.callTimeoutMs;
    }

    public final long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public final C5544k getConnectionPool() {
        return this.connectionPool;
    }

    public final List<b> getConnectionSpecs() {
        return this.connectionSpecs;
    }

    public final Context getContext() {
        return this.context;
    }

    public final h.a getConverterFactory() {
        return this.converterFactory;
    }

    public final G7.a getCrashReporter() {
        return null;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final C5548o getDispatcher() {
        return this.dispatcher;
    }

    public final InterfaceC5549p getDns() {
        return this.dns;
    }

    public final boolean getEnableDeviceHeaders() {
        return this.enableDeviceHeaders;
    }

    public final boolean getEnableTraceId() {
        return this.enableTraceId;
    }

    /* renamed from: getExplicitCertificatePinner$net_release, reason: from getter */
    public final C5541h getExplicitCertificatePinner() {
        return this.explicitCertificatePinner;
    }

    public final InterfaceC5074l<ApiException, t> getGlobalErrorListener() {
        return this.globalErrorListener;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final boolean getInspectorEnabled() {
        return this.inspectorEnabled;
    }

    public final List<w> getInterceptors() {
        return this.interceptors;
    }

    public final Integer getMaxRequests() {
        return this.maxRequests;
    }

    public final Integer getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final InterfaceC5074l<HttpMetrics, t> getMetricsListener() {
        return this.metricsListener;
    }

    public final List<w> getNetworkInterceptors() {
        return this.networkInterceptors;
    }

    public final F7.a getNetworkMonitor() {
        return null;
    }

    public final List<PinSpec> getPinSpecs$net_release() {
        return this.pinSpecs;
    }

    public final H7.a getPinningFailureListener() {
        return null;
    }

    public final InterfaceC5063a<Boolean> getPrivacyGate() {
        return this.privacyGate;
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

    public final c getSignatureProvider() {
        return this.signatureProvider;
    }

    public final H7.b getSslPair() {
        return null;
    }

    public final InterfaceC5074l<Integer, Boolean> getSuccessCodeChecker() {
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

    public final C5541h resolveCertificatePinner$net_release() {
        if (this.pinSpecs.isEmpty() && this.explicitCertificatePinner == null) {
            return null;
        }
        if (this.pinSpecs.isEmpty()) {
            return this.explicitCertificatePinner;
        }
        C5541h.a aVar = new C5541h.a();
        for (PinSpec pinSpec : this.pinSpecs) {
            Iterator<T> it = pinSpec.b().iterator();
            while (it.hasNext()) {
                aVar.a(pinSpec.getHostname(), (String) it.next());
            }
        }
        return aVar.b();
    }
}
