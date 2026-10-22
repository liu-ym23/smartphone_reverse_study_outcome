package okhttp3.internal.connection;

import ch.qos.logback.core.CoreConstants;
import com.baidu.platform.comapi.map.MapBundleKey;
import f1.AbstractC0557a;
import h3.B;
import h3.C0592a;
import h3.C0604m;
import h3.C0605n;
import h3.C0607p;
import h3.C0610t;
import h3.C0611u;
import h3.F;
import h3.G;
import h3.InterfaceC0602k;
import h3.InterfaceC0608q;
import h3.J;
import h3.S;
import h3.T;
import h3.U;
import h3.V;
import h3.a0;
import h3.b0;
import h3.f0;
import h3.g0;
import io.reactivex.annotations.SchedulerSupport;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import k3.C0683E;
import k3.InterfaceC0695j;
import k3.InterfaceC0696k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y0.e;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000  \u00012\u00020\u00012\u00020\u0002:\u0002 \u0001B\u0019\u0012\u0006\u0010q\u001a\u00020p\u0012\u0006\u0010.\u001a\u00020\u001b¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\u0005JE\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010'\u001a\u00020$2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0000¢\u0006\u0004\b%\u0010&J\u0017\u0010-\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0000¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020\u001bH\u0016¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u0003¢\u0006\u0004\b0\u0010\u0005J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0010¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010?\u001a\u00020\u00032\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u0011\u0010B\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0004\bB\u0010CJ'\u0010I\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020EH\u0000¢\u0006\u0004\bG\u0010HJ!\u0010N\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010EH\u0000¢\u0006\u0004\bL\u0010MJ\u000f\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ7\u0010U\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\bU\u0010VJ/\u0010W\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\bW\u0010XJ/\u0010[\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b[\u0010\\J\u0017\u0010]\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020YH\u0002¢\u0006\u0004\b_\u0010`J1\u0010e\u001a\u0004\u0018\u00010a2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020a2\u0006\u0010d\u001a\u00020cH\u0002¢\u0006\u0004\be\u0010fJ\u000f\u0010g\u001a\u00020aH\u0002¢\u0006\u0004\bg\u0010hJ\u001d\u0010j\u001a\u00020\u00102\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020\u00102\u0006\u0010d\u001a\u00020cH\u0002¢\u0006\u0004\bl\u0010mJ\u001f\u0010n\u001a\u00020\u00102\u0006\u0010d\u001a\u00020c2\u0006\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bn\u0010oR\u0017\u0010q\u001a\u00020p8\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0014\u0010.\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010uR\u0018\u0010v\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010wR\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010xR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010yR\u0018\u0010z\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010}\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u001b\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R'\u0010\u0006\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0006\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0017\u0010\b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\b\u0010\u0082\u0001R(\u0010\u0087\u0001\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0005\b\u008b\u0001\u0010^R\u0019\u0010\u008c\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u0088\u0001R\u0019\u0010\u008d\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u0088\u0001R\u0019\u0010\u008e\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u0088\u0001R*\u0010\u0091\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020J0\u0090\u00010\u008f\u00018\u0006¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R*\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0017\u0010\u009d\u0001\u001a\u00020\u00108@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u0084\u0001¨\u0006¡\u0001"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lh3/q;", "", "noNewExchanges$okhttp", "()V", "noNewExchanges", "noCoalescedConnections$okhttp", "noCoalescedConnections", "incrementSuccessCount$okhttp", "incrementSuccessCount", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "Lh3/k;", "call", "Lh3/B;", "eventListener", "connect", "(IIIIZLh3/k;Lh3/B;)V", "Lh3/a;", "address", "", "Lh3/g0;", "routes", "isEligible$okhttp", "(Lh3/a;Ljava/util/List;)Z", "isEligible", "Lh3/S;", "client", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "newCodec$okhttp", "(Lh3/S;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "newCodec", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams$okhttp", "(Lokhttp3/internal/connection/Exchange;)Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "route", "()Lh3/g0;", "cancel", "Ljava/net/Socket;", "socket", "()Ljava/net/Socket;", "doExtensiveChecks", "isHealthy", "(Z)Z", "Lokhttp3/internal/http2/Http2Stream;", "stream", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Settings;", "settings", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "Lh3/F;", "handshake", "()Lh3/F;", "failedRoute", "Ljava/io/IOException;", "failure", "connectFailed$okhttp", "(Lh3/S;Lh3/g0;Ljava/io/IOException;)V", "connectFailed", "Lokhttp3/internal/connection/RealCall;", "e", "trackFailure$okhttp", "(Lokhttp3/internal/connection/RealCall;Ljava/io/IOException;)V", "trackFailure", "Lh3/T;", "protocol", "()Lh3/T;", "", "toString", "()Ljava/lang/String;", "connectTunnel", "(IIILh3/k;Lh3/B;)V", "connectSocket", "(IILh3/k;Lh3/B;)V", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectionSpecSelector", "establishProtocol", "(Lokhttp3/internal/connection/ConnectionSpecSelector;ILh3/k;Lh3/B;)V", "startHttp2", "(I)V", "connectTls", "(Lokhttp3/internal/connection/ConnectionSpecSelector;)V", "Lh3/V;", "tunnelRequest", "Lh3/J;", MapBundleKey.MapObjKey.OBJ_URL, "createTunnel", "(IILh3/V;Lh3/J;)Lh3/V;", "createTunnelRequest", "()Lh3/V;", "candidates", "routeMatchesAny", "(Ljava/util/List;)Z", "supportsUrl", "(Lh3/J;)Z", "certificateSupportHost", "(Lh3/J;Lh3/F;)Z", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "Lh3/g0;", "rawSocket", "Ljava/net/Socket;", "Lh3/F;", "Lh3/T;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "Lk3/k;", "source", "Lk3/k;", "Lk3/j;", "sink", "Lk3/j;", "Z", "getNoNewExchanges", "()Z", "setNoNewExchanges", "(Z)V", "routeFailureCount", "I", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "successCount", "refusedStreamCount", "allocationLimit", "", "Ljava/lang/ref/Reference;", "calls", "Ljava/util/List;", "getCalls", "()Ljava/util/List;", "", "idleAtNs", "J", "getIdleAtNs$okhttp", "()J", "setIdleAtNs$okhttp", "(J)V", "isMultiplexed$okhttp", "isMultiplexed", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lh3/g0;)V", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class RealConnection extends Http2Connection.Listener implements InterfaceC0608q {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;

    @NotNull
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit;

    @NotNull
    private final List<Reference<RealCall>> calls;

    @NotNull
    private final RealConnectionPool connectionPool;

    @Nullable
    private F handshake;

    @Nullable
    private Http2Connection http2Connection;
    private long idleAtNs;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;

    @Nullable
    private T protocol;

    @Nullable
    private Socket rawSocket;
    private int refusedStreamCount;

    @NotNull
    private final g0 route;
    private int routeFailureCount;

    @Nullable
    private InterfaceC0695j sink;

    @Nullable
    private Socket socket;

    @Nullable
    private InterfaceC0696k source;
    private int successCount;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lh3/g0;", "route", "Ljava/net/Socket;", "socket", "", "idleAtNs", "Lokhttp3/internal/connection/RealConnection;", "newTestConnection", "(Lokhttp3/internal/connection/RealConnectionPool;Lh3/g0;Ljava/net/Socket;J)Lokhttp3/internal/connection/RealConnection;", "IDLE_CONNECTION_HEALTHY_NS", "J", "", "MAX_TUNNEL_ATTEMPTS", "I", "", "NPE_THROW_WITH_NULL", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RealConnection newTestConnection(@NotNull RealConnectionPool connectionPool, @NotNull g0 route, @NotNull Socket socket, long idleAtNs) {
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(socket, "socket");
            RealConnection realConnection = new RealConnection(connectionPool, route);
            realConnection.socket = socket;
            realConnection.setIdleAtNs$okhttp(idleAtNs);
            return realConnection;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RealConnection(@NotNull RealConnectionPool connectionPool, @NotNull g0 route) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.connectionPool = connectionPool;
        this.route = route;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = LongCompanionObject.MAX_VALUE;
    }

    private final boolean certificateSupportHost(J url, F handshake) {
        List listA = handshake.a();
        return (listA.isEmpty() ^ true) && OkHostnameVerifier.INSTANCE.verify(url.f12725d, (X509Certificate) listA.get(0));
    }

    private final void connectSocket(int connectTimeout, int readTimeout, InterfaceC0602k call, B eventListener) throws IOException {
        Socket socketCreateSocket;
        g0 g0Var = this.route;
        Proxy proxy = g0Var.f12910b;
        Proxy.Type type = proxy.type();
        int i4 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i4 == 1 || i4 == 2) {
            socketCreateSocket = g0Var.f12909a.f12840b.createSocket();
            Intrinsics.checkNotNull(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.rawSocket = socketCreateSocket;
        InetSocketAddress inetSocketAddress = this.route.f12911c;
        eventListener.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        socketCreateSocket.setSoTimeout(readTimeout);
        try {
            Platform.INSTANCE.get().connectSocket(socketCreateSocket, this.route.f12911c, connectTimeout);
            try {
                this.source = AbstractC0557a.h(AbstractC0557a.c0(socketCreateSocket));
                this.sink = AbstractC0557a.g(AbstractC0557a.b0(socketCreateSocket));
            } catch (NullPointerException e4) {
                if (Intrinsics.areEqual(e4.getMessage(), NPE_THROW_WITH_NULL)) {
                    throw new IOException(e4);
                }
            }
        } catch (ConnectException e5) {
            ConnectException connectException = new ConnectException(Intrinsics.stringPlus("Failed to connect to ", this.route.f12911c));
            connectException.initCause(e5);
            throw connectException;
        }
    }

    private final void connectTls(ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        final C0592a c0592a = this.route.f12909a;
        SSLSocketFactory sSLSocketFactory = c0592a.f12841c;
        J j4 = c0592a.f12847i;
        SSLSocket sSLSocket = null;
        try {
            Intrinsics.checkNotNull(sSLSocketFactory);
            Socket socketCreateSocket = sSLSocketFactory.createSocket(this.rawSocket, j4.f12725d, j4.f12726e, true);
            if (socketCreateSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                C0610t c0610tConfigureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                boolean z4 = c0610tConfigureSecureSocket.f12970b;
                String str = j4.f12725d;
                if (z4) {
                    Platform.INSTANCE.get().configureTlsExtensions(sSLSocket2, str, c0592a.f12848j);
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
                final F fM = C0611u.m(sslSocketSession);
                HostnameVerifier hostnameVerifier = c0592a.f12842d;
                Intrinsics.checkNotNull(hostnameVerifier);
                if (hostnameVerifier.verify(str, sslSocketSession)) {
                    final C0605n c0605n = c0592a.f12843e;
                    Intrinsics.checkNotNull(c0605n);
                    this.handshake = new F(fM.f12707a, fM.f12708b, fM.f12709c, new Function0<List<? extends Certificate>>() { // from class: okhttp3.internal.connection.RealConnection.connectTls.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final List<? extends Certificate> invoke() {
                            CertificateChainCleaner certificateChainCleaner = c0605n.f12939b;
                            Intrinsics.checkNotNull(certificateChainCleaner);
                            return certificateChainCleaner.clean(fM.a(), c0592a.f12847i.f12725d);
                        }
                    });
                    c0605n.a(str, new Function0<List<? extends X509Certificate>>() { // from class: okhttp3.internal.connection.RealConnection.connectTls.2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final List<? extends X509Certificate> invoke() {
                            F f4 = RealConnection.this.handshake;
                            Intrinsics.checkNotNull(f4);
                            List listA = f4.a();
                            ArrayList arrayList = new ArrayList(CollectionsKt.e(listA));
                            Iterator it = listA.iterator();
                            while (it.hasNext()) {
                                arrayList.add((X509Certificate) ((Certificate) it.next()));
                            }
                            return arrayList;
                        }
                    });
                    String selectedProtocol = c0610tConfigureSecureSocket.f12970b ? Platform.INSTANCE.get().getSelectedProtocol(sSLSocket2) : null;
                    this.socket = sSLSocket2;
                    this.source = AbstractC0557a.h(AbstractC0557a.c0(sSLSocket2));
                    this.sink = AbstractC0557a.g(AbstractC0557a.b0(sSLSocket2));
                    this.protocol = selectedProtocol != null ? C0611u.p(selectedProtocol) : T.HTTP_1_1;
                    Platform.INSTANCE.get().afterHandshake(sSLSocket2);
                    return;
                }
                List listA = fM.a();
                if (!(!listA.isEmpty())) {
                    throw new SSLPeerUnverifiedException("Hostname " + str + " not verified (no certificates)");
                }
                X509Certificate x509Certificate = (X509Certificate) listA.get(0);
                StringBuilder sb = new StringBuilder("\n              |Hostname ");
                sb.append(str);
                sb.append(" not verified:\n              |    certificate: ");
                C0605n c0605n2 = C0605n.f12937c;
                sb.append(e.e(x509Certificate));
                sb.append("\n              |    DN: ");
                sb.append((Object) x509Certificate.getSubjectDN().getName());
                sb.append("\n              |    subjectAltNames: ");
                sb.append(OkHostnameVerifier.INSTANCE.allSubjectAltNames(x509Certificate));
                sb.append("\n              ");
                throw new SSLPeerUnverifiedException(StringsKt__IndentKt.trimMargin$default(sb.toString(), null, 1, null));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform.INSTANCE.get().afterHandshake(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util.closeQuietly((Socket) sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void connectTunnel(int connectTimeout, int readTimeout, int writeTimeout, InterfaceC0602k call, B eventListener) throws IOException {
        V vCreateTunnelRequest = createTunnelRequest();
        J j4 = vCreateTunnelRequest.f12826a;
        int i4 = 0;
        while (i4 < 21) {
            i4++;
            connectSocket(connectTimeout, readTimeout, call, eventListener);
            vCreateTunnelRequest = createTunnel(readTimeout, writeTimeout, vCreateTunnelRequest, j4);
            if (vCreateTunnelRequest == null) {
                return;
            }
            Socket socket = this.rawSocket;
            if (socket != null) {
                Util.closeQuietly(socket);
            }
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            g0 g0Var = this.route;
            InetSocketAddress inetSocketAddress = g0Var.f12911c;
            eventListener.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
            Proxy proxy = g0Var.f12910b;
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }
    }

    private final V createTunnel(int readTimeout, int writeTimeout, V tunnelRequest, J url) throws IOException {
        String str = "CONNECT " + Util.toHostHeader(url, true) + " HTTP/1.1";
        while (true) {
            InterfaceC0696k interfaceC0696k = this.source;
            Intrinsics.checkNotNull(interfaceC0696k);
            InterfaceC0695j interfaceC0695j = this.sink;
            Intrinsics.checkNotNull(interfaceC0695j);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, interfaceC0696k, interfaceC0695j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            interfaceC0696k.timeout().timeout(readTimeout, timeUnit);
            interfaceC0695j.timeout().timeout(writeTimeout, timeUnit);
            http1ExchangeCodec.writeRequest(tunnelRequest.f12828c, str);
            http1ExchangeCodec.finishRequest();
            a0 responseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull(responseHeaders);
            responseHeaders.getClass();
            Intrinsics.checkNotNullParameter(tunnelRequest, "request");
            responseHeaders.f12850a = tunnelRequest;
            b0 b0VarA = responseHeaders.a();
            http1ExchangeCodec.skipConnectBody(b0VarA);
            int i4 = b0VarA.f12867d;
            if (i4 == 200) {
                if (interfaceC0696k.f().s() && interfaceC0695j.f().s()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (i4 != 407) {
                throw new IOException(Intrinsics.stringPlus("Unexpected response code for CONNECT: ", Integer.valueOf(i4)));
            }
            g0 g0Var = this.route;
            V vAuthenticate = g0Var.f12909a.f12844f.authenticate(g0Var, b0VarA);
            if (vAuthenticate == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (StringsKt__StringsJVMKt.equals("close", b0.b(b0VarA, "Connection"), true)) {
                return vAuthenticate;
            }
            tunnelRequest = vAuthenticate;
        }
    }

    private final V createTunnelRequest() throws IOException {
        U u4 = new U();
        J url = this.route.f12909a.f12847i;
        Intrinsics.checkNotNullParameter(url, "url");
        u4.f12821a = url;
        u4.d("CONNECT", null);
        u4.c("Host", Util.toHostHeader(this.route.f12909a.f12847i, true));
        u4.c("Proxy-Connection", "Keep-Alive");
        u4.c("User-Agent", Util.userAgent);
        V request = u4.b();
        G g4 = new G();
        Intrinsics.checkNotNullParameter(request, "request");
        T protocol = T.HTTP_1_1;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter("Preemptive Authenticate", "message");
        f0 f0Var = Util.EMPTY_RESPONSE;
        Intrinsics.checkNotNullParameter("Proxy-Authenticate", "name");
        Intrinsics.checkNotNullParameter("OkHttp-Preemptive", "value");
        Intrinsics.checkNotNullParameter("Proxy-Authenticate", "name");
        Intrinsics.checkNotNullParameter("OkHttp-Preemptive", "value");
        C0611u.e("Proxy-Authenticate");
        C0611u.f("OkHttp-Preemptive", "Proxy-Authenticate");
        g4.f("Proxy-Authenticate");
        g4.c("Proxy-Authenticate", "OkHttp-Preemptive");
        b0 b0Var = new b0(request, protocol, "Preemptive Authenticate", 407, null, g4.d(), f0Var, null, null, null, -1L, -1L, null);
        g0 g0Var = this.route;
        V vAuthenticate = g0Var.f12909a.f12844f.authenticate(g0Var, b0Var);
        return vAuthenticate == null ? request : vAuthenticate;
    }

    private final void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int pingIntervalMillis, InterfaceC0602k call, B eventListener) throws Throwable {
        C0592a c0592a = this.route.f12909a;
        if (c0592a.f12841c != null) {
            eventListener.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            connectTls(connectionSpecSelector);
            Intrinsics.checkNotNullParameter(call, "call");
            if (this.protocol == T.HTTP_2) {
                startHttp2(pingIntervalMillis);
                return;
            }
            return;
        }
        List list = c0592a.f12848j;
        T t4 = T.H2_PRIOR_KNOWLEDGE;
        if (!list.contains(t4)) {
            this.socket = this.rawSocket;
            this.protocol = T.HTTP_1_1;
        } else {
            this.socket = this.rawSocket;
            this.protocol = t4;
            startHttp2(pingIntervalMillis);
        }
    }

    private final boolean routeMatchesAny(List<g0> candidates) {
        List<g0> list = candidates;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (g0 g0Var : list) {
            Proxy.Type type = g0Var.f12910b.type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.route.f12910b.type() == type2 && Intrinsics.areEqual(this.route.f12911c, g0Var.f12911c)) {
                return true;
            }
        }
        return false;
    }

    private final void startHttp2(int pingIntervalMillis) throws IOException {
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        InterfaceC0696k interfaceC0696k = this.source;
        Intrinsics.checkNotNull(interfaceC0696k);
        InterfaceC0695j interfaceC0695j = this.sink;
        Intrinsics.checkNotNull(interfaceC0695j);
        socket.setSoTimeout(0);
        Http2Connection http2ConnectionBuild = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(socket, this.route.f12909a.f12847i.f12725d, interfaceC0696k, interfaceC0695j).listener(this).pingIntervalMillis(pingIntervalMillis).build();
        this.http2Connection = http2ConnectionBuild;
        this.allocationLimit = Http2Connection.INSTANCE.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(http2ConnectionBuild, false, null, 3, null);
    }

    private final boolean supportsUrl(J url) {
        F f4;
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        J j4 = this.route.f12909a.f12847i;
        if (url.f12726e != j4.f12726e) {
            return false;
        }
        if (Intrinsics.areEqual(url.f12725d, j4.f12725d)) {
            return true;
        }
        if (this.noCoalescedConnections || (f4 = this.handshake) == null) {
            return false;
        }
        Intrinsics.checkNotNull(f4);
        return certificateSupportHost(url, f4);
    }

    public final void cancel() {
        Socket socket = this.rawSocket;
        if (socket == null) {
            return;
        }
        Util.closeQuietly(socket);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0142 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void connect(int r17, int r18, int r19, int r20, boolean r21, @org.jetbrains.annotations.NotNull h3.InterfaceC0602k r22, @org.jetbrains.annotations.NotNull h3.B r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, h3.k, h3.B):void");
    }

    public final void connectFailed$okhttp(@NotNull S client, @NotNull g0 failedRoute, @NotNull IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.f12910b.type() != Proxy.Type.DIRECT) {
            C0592a c0592a = failedRoute.f12909a;
            c0592a.f12846h.connectFailed(c0592a.f12847i.i(), failedRoute.f12910b.address(), failure);
        }
        client.f12786D.failed(failedRoute);
    }

    @NotNull
    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    @NotNull
    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    /* renamed from: getIdleAtNs$okhttp, reason: from getter */
    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    /* renamed from: getRouteFailureCount$okhttp, reason: from getter */
    public final int getRouteFailureCount() {
        return this.routeFailureCount;
    }

    @Nullable
    /* renamed from: handshake, reason: from getter */
    public F getHandshake() {
        return this.handshake;
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        this.successCount++;
    }

    public final boolean isEligible$okhttp(@NotNull C0592a address, @Nullable List<g0> routes) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !this.route.f12909a.a(address)) {
            return false;
        }
        J j4 = address.f12847i;
        if (Intrinsics.areEqual(j4.f12725d, getRoute().f12909a.f12847i.f12725d)) {
            return true;
        }
        if (this.http2Connection != null && routes != null && routeMatchesAny(routes)) {
            if (address.f12842d != OkHostnameVerifier.INSTANCE || !supportsUrl(j4)) {
                return false;
            }
            try {
                C0605n c0605n = address.f12843e;
                Intrinsics.checkNotNull(c0605n);
                String hostname = j4.f12725d;
                F handshake = getHandshake();
                Intrinsics.checkNotNull(handshake);
                List peerCertificates = handshake.a();
                c0605n.getClass();
                Intrinsics.checkNotNullParameter(hostname, "hostname");
                Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
                c0605n.a(hostname, new C0604m(c0605n, peerCertificates, hostname));
                return true;
            } catch (SSLPeerUnverifiedException unused) {
            }
        }
        return false;
    }

    public final boolean isHealthy(boolean doExtensiveChecks) {
        long idleAtNs;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.rawSocket;
        Intrinsics.checkNotNull(socket);
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        InterfaceC0696k interfaceC0696k = this.source;
        Intrinsics.checkNotNull(interfaceC0696k);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(jNanoTime);
        }
        synchronized (this) {
            idleAtNs = jNanoTime - getIdleAtNs();
        }
        if (idleAtNs < IDLE_CONNECTION_HEALTHY_NS || !doExtensiveChecks) {
            return true;
        }
        return Util.isHealthy(socket2, interfaceC0696k);
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    @NotNull
    public final ExchangeCodec newCodec$okhttp(@NotNull S client, @NotNull RealInterceptorChain chain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        InterfaceC0696k interfaceC0696k = this.source;
        Intrinsics.checkNotNull(interfaceC0696k);
        InterfaceC0695j interfaceC0695j = this.sink;
        Intrinsics.checkNotNull(interfaceC0695j);
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, http2Connection);
        }
        socket.setSoTimeout(chain.readTimeoutMillis());
        C0683E c0683eTimeout = interfaceC0696k.timeout();
        long readTimeoutMillis$okhttp = chain.getReadTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c0683eTimeout.timeout(readTimeoutMillis$okhttp, timeUnit);
        interfaceC0695j.timeout().timeout(chain.getWriteTimeoutMillis(), timeUnit);
        return new Http1ExchangeCodec(client, this, interfaceC0696k, interfaceC0695j);
    }

    @NotNull
    public final RealWebSocket.Streams newWebSocketStreams$okhttp(@NotNull final Exchange exchange) throws SocketException {
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        final InterfaceC0696k interfaceC0696k = this.source;
        Intrinsics.checkNotNull(interfaceC0696k);
        final InterfaceC0695j interfaceC0695j = this.sink;
        Intrinsics.checkNotNull(interfaceC0695j);
        socket.setSoTimeout(0);
        noNewExchanges$okhttp();
        return new RealWebSocket.Streams(interfaceC0695j, exchange) { // from class: okhttp3.internal.connection.RealConnection$newWebSocketStreams$1
            final /* synthetic */ Exchange $exchange;
            final /* synthetic */ InterfaceC0695j $sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true, this.$source, interfaceC0695j);
                this.$sink = interfaceC0695j;
                this.$exchange = exchange;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.$exchange.bodyComplete(-1L, true, true, null);
            }
        };
    }

    public final synchronized void noCoalescedConnections$okhttp() {
        this.noCoalescedConnections = true;
    }

    public final synchronized void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public synchronized void onSettings(@NotNull Http2Connection connection, @NotNull Settings settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.allocationLimit = settings.getMaxConcurrentStreams();
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(@NotNull Http2Stream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // h3.InterfaceC0608q
    @NotNull
    public T protocol() {
        T t4 = this.protocol;
        Intrinsics.checkNotNull(t4);
        return t4;
    }

    @NotNull
    /* renamed from: route, reason: from getter */
    public g0 getRoute() {
        return this.route;
    }

    public final void setIdleAtNs$okhttp(long j4) {
        this.idleAtNs = j4;
    }

    public final void setNoNewExchanges(boolean z4) {
        this.noNewExchanges = z4;
    }

    public final void setRouteFailureCount$okhttp(int i4) {
        this.routeFailureCount = i4;
    }

    @NotNull
    public Socket socket() {
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        return socket;
    }

    @NotNull
    public String toString() {
        C0607p c0607p;
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.route.f12909a.f12847i.f12725d);
        sb.append(CoreConstants.COLON_CHAR);
        sb.append(this.route.f12909a.f12847i.f12726e);
        sb.append(", proxy=");
        sb.append(this.route.f12910b);
        sb.append(" hostAddress=");
        sb.append(this.route.f12911c);
        sb.append(" cipherSuite=");
        F f4 = this.handshake;
        Object obj = SchedulerSupport.NONE;
        if (f4 != null && (c0607p = f4.f12708b) != null) {
            obj = c0607p;
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    public final synchronized void trackFailure$okhttp(@NotNull RealCall call, @Nullable IOException e4) {
        try {
            Intrinsics.checkNotNullParameter(call, "call");
            if (e4 instanceof StreamResetException) {
                if (((StreamResetException) e4).errorCode == ErrorCode.REFUSED_STREAM) {
                    int i4 = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i4;
                    if (i4 > 1) {
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else if (((StreamResetException) e4).errorCode != ErrorCode.CANCEL || !call.getCanceled()) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (!isMultiplexed$okhttp() || (e4 instanceof ConnectionShutdownException)) {
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (e4 != null) {
                        connectFailed$okhttp(call.getClient(), this.route, e4);
                    }
                    this.routeFailureCount++;
                }
            }
        } finally {
        }
    }
}
