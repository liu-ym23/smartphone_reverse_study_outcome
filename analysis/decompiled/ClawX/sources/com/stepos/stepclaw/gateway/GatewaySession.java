package com.stepos.stepclaw.gateway;

import a6.f0;
import a6.h1;
import a6.i0;
import a6.p1;
import a6.r;
import a6.r0;
import a6.s;
import b7.h;
import c5.o;
import c6.g;
import c6.j;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.config.GatewayAuthConstants;
import com.stepos.stepclaw.gateway.GatewaySession;
import com.stepos.stepclaw.memory.lightmem.evolution.EpisodicMemoryEvolutionState;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import n6.a0;
import n6.b0;
import n6.u;
import okhttp3.internal.platform.Platform;
import p5.l;
import p5.p;
import p5.q;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 r2\u00020\u0001:\nsrtuvwxyz{BÑ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012$\u0010\u000b\u001a \u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\f\u0012\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e\u0012&\b\u0002\u0010\u0013\u001a \b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e\u0012\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J=\u0010!\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\n¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\n¢\u0006\u0004\b%\u0010$J\r\u0010&\u001a\u00020\n¢\u0006\u0004\b&\u0010$J\u000f\u0010'\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b)\u0010(J,\u0010.\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010-\u001a\u00020,H\u0086@¢\u0006\u0004\b.\u0010/J\u001a\u00101\u001a\u0002002\b\b\u0002\u0010-\u001a\u00020,H\u0086@¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\nH\u0082@¢\u0006\u0004\b3\u00104J\u0018\u00107\u001a\u00020\n2\u0006\u00106\u001a\u000205H\u0082@¢\u0006\u0004\b7\u00108J+\u0010;\u001a\u0004\u0018\u00010\t2\b\u00109\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010:\u001a\u000200H\u0002¢\u0006\u0004\b;\u0010<J/\u0010B\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\tH\u0002¢\u0006\u0004\bB\u0010CJ\u0019\u0010F\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0004\bF\u0010GJ\u0019\u0010H\u001a\u0002002\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bH\u0010IR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010JR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010KR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010LR2\u0010\u000b\u001a \u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010MR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010NR*\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010OR2\u0010\u0013\u001a \b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010OR(\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010OR\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010PR\u0016\u0010Q\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010RR\u0016\u0010T\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Z\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R \u0010^\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020]0\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010dR\u0018\u0010f\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020\n0k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u001c\u0010o\u001a\b\u0018\u00010nR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010q\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010U¨\u0006|"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "La6/f0;", "scope", "Lcom/stepos/stepclaw/gateway/DeviceIdentityStore;", "identityStore", "Lcom/stepos/stepclaw/gateway/DeviceAuthTokenStore;", "deviceAuthStore", "Lkotlin/Function3;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lb5/a0;", "onConnected", "Lkotlin/Function1;", "onDisconnected", "Lkotlin/Function2;", "onEvent", "Lcom/stepos/stepclaw/gateway/GatewaySession$InvokeRequest;", "Lf5/c;", "Lcom/stepos/stepclaw/gateway/GatewaySession$InvokeResult;", "onInvoke", "onTlsFingerprint", "Lkotlin/Function0;", "onPersistentConnectFailure", "<init>", "(La6/f0;Lcom/stepos/stepclaw/gateway/DeviceIdentityStore;Lcom/stepos/stepclaw/gateway/DeviceAuthTokenStore;Lp5/q;Lp5/l;Lp5/p;Lp5/p;Lp5/p;Lp5/a;)V", "Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "endpoint", GatewayAuthConstants.AUTH_MODE, "password", "Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;", "options", "Lcom/stepos/stepclaw/gateway/GatewayTlsParams;", "tls", "connect", "(Lcom/stepos/stepclaw/gateway/GatewayEndpoint;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;Lcom/stepos/stepclaw/gateway/GatewayTlsParams;)V", "disconnect", "()V", "wakeIfNotOnline", "reconnect", "currentCanvasHostUrl", "()Ljava/lang/String;", "currentMainSessionKey", "method", "paramsJson", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "timeoutMs", "request", "(Ljava/lang/String;Ljava/lang/String;JLf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "refreshNodeCanvasCapability", "(JLf5/c;)Ljava/lang/Object;", "runLoop", "(Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/gateway/GatewaySession$DesiredConnection;", "target", "connectOnce", "(Lcom/stepos/stepclaw/gateway/GatewaySession$DesiredConnection;Lf5/c;)Ljava/lang/Object;", "raw", "isTlsConnection", "normalizeCanvasHostUrl", "(Ljava/lang/String;Lcom/stepos/stepclaw/gateway/GatewayEndpoint;Z)Ljava/lang/String;", "host", "scheme", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_PORT, "suffix", "buildCanvasUrl", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;", "Ljava/net/URI;", "uri", "buildUrlSuffix", "(Ljava/net/URI;)Ljava/lang/String;", "isLoopbackHost", "(Ljava/lang/String;)Z", "La6/f0;", "Lcom/stepos/stepclaw/gateway/DeviceIdentityStore;", "Lcom/stepos/stepclaw/gateway/DeviceAuthTokenStore;", "Lp5/q;", "Lp5/l;", "Lp5/p;", "Lp5/a;", "consecutiveBusinessFailures", "I", "consecutiveTransportFailures", "connectFailureRecoveryAttempted", "Z", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "Li6/a;", "writeLock", "Li6/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/stepclaw/gateway/GatewaySession$PendingEntry;", EpisodicMemoryEvolutionState.PENDING, "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/stepclaw/gateway/GatewaySession$PingIntervalTracker;", "pingTracker", "Lcom/stepos/stepclaw/gateway/GatewaySession$PingIntervalTracker;", "canvasHostUrl", "Ljava/lang/String;", "mainSessionKey", "desired", "Lcom/stepos/stepclaw/gateway/GatewaySession$DesiredConnection;", "La6/h1;", "job", "La6/h1;", "Lc6/g;", "reconnectSignal", "Lc6/g;", "Lcom/stepos/stepclaw/gateway/GatewaySession$Connection;", "currentConnection", "Lcom/stepos/stepclaw/gateway/GatewaySession$Connection;", "sessionOnline", "Companion", "BusinessLayerFailure", "InvokeRequest", "InvokeResult", "ErrorShape", "DesiredConnection", "RpcResponse", "PendingEntry", "Connection", "PingIntervalTracker", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewaySession {
    private static final long CONNECT_RPC_TIMEOUT_MS = 12000;
    private static final long FIRST_CONNECT_DELAY_MS = 2000;
    private static final long OFFLINE_FALLBACK_RETRY_MS = 1800000;
    private static final long PENDING_EXPIRY_MS = 60000;
    private volatile String canvasHostUrl;
    private volatile boolean connectFailureRecoveryAttempted;
    private volatile int consecutiveBusinessFailures;
    private volatile int consecutiveTransportFailures;
    private volatile Connection currentConnection;
    private DesiredConnection desired;
    private final DeviceAuthTokenStore deviceAuthStore;
    private final DeviceIdentityStore identityStore;
    private h1 job;
    private final Json json;
    private volatile String mainSessionKey;
    private final q onConnected;
    private final l onDisconnected;
    private final p onEvent;
    private final p onInvoke;
    private final p5.a onPersistentConnectFailure;
    private final p onTlsFingerprint;
    private final ConcurrentHashMap<String, PendingEntry> pending;
    private final PingIntervalTracker pingTracker;
    private final g reconnectSignal;
    private final f0 scope;
    private volatile boolean sessionOnline;
    private final i6.a writeLock;
    private static final Companion Companion = new Companion(null);
    private static volatile boolean firstConnectInProcess = true;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$BusinessLayerFailure;", "Ljava/lang/Exception;", "Lkotlin/Exception;", OperationResult.EXTRA_MESSAGE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "cause", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BusinessLayerFailure extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BusinessLayerFailure(String message, Throwable th) {
            super(message, th);
            kotlin.jvm.internal.p.e(message, "message");
        }

        public /* synthetic */ BusinessLayerFailure(String str, Throwable th, int i8, i iVar) {
            this(str, (i8 & 2) != 0 ? null : th);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "CONNECT_RPC_TIMEOUT_MS", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "FIRST_CONNECT_DELAY_MS", "PENDING_EXPIRY_MS", "OFFLINE_FALLBACK_RETRY_MS", "firstConnectInProcess", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "takeFirstConnectDelay", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long takeFirstConnectDelay() {
            if (!GatewaySession.firstConnectInProcess) {
                return 0L;
            }
            GatewaySession.firstConnectInProcess = false;
            return GatewaySession.FIRST_CONNECT_DELAY_MS;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001^B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u001c\u0010\u000fJ\r\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*J1\u0010/\u001a\u00020\u00182\u0006\u0010,\u001a\u00020+2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b/\u00100J\u0018\u00102\u001a\u00020\r2\u0006\u00101\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b2\u0010&J\u0017\u00104\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0018H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0018H\u0002¢\u0006\u0004\b6\u00105J\u0010\u00107\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b7\u0010\u000fJ\u001b\u00109\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0004H\u0002¢\u0006\u0004\b;\u0010<J2\u0010B\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00042\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010\u0013H\u0082@¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020?2\u0006\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\rH\u0002¢\u0006\u0004\bH\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010IR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010JR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010JR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010KR\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010LR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\r0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\r0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010OR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010OR\u0014\u0010U\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\bZ\u0010JR\u0017\u0010[\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b[\u0010J\u001a\u0004\b\\\u0010]¨\u0006_"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$Connection;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "endpoint", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, GatewayAuthConstants.AUTH_MODE, "password", "Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;", "options", "Lcom/stepos/stepclaw/gateway/GatewayTlsParams;", "tls", "<init>", "(Lcom/stepos/stepclaw/gateway/GatewaySession;Lcom/stepos/stepclaw/gateway/GatewayEndpoint;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;Lcom/stepos/stepclaw/gateway/GatewayTlsParams;)V", "Lb5/a0;", "connect", "(Lf5/c;)Ljava/lang/Object;", "method", "Lkotlinx/serialization/json/JsonElement;", "params", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "timeoutMs", "Lcom/stepos/stepclaw/gateway/GatewaySession$RpcResponse;", "request", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;JLf5/c;)Ljava/lang/Object;", "Lkotlinx/serialization/json/JsonObject;", "obj", "sendJson", "(Lkotlinx/serialization/json/JsonObject;Lf5/c;)Ljava/lang/Object;", "awaitClose", "closeQuietly", "()V", "cleanupExpiredPending", "pingIntervalSeconds", "Ln6/q;", "buildClient", "(J)Ln6/q;", "connectNonce", "sendConnect", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "res", "deviceId", "handleConnectSuccess", "(Lcom/stepos/stepclaw/gateway/GatewaySession$RpcResponse;Ljava/lang/String;)V", "Lcom/stepos/stepclaw/gateway/DeviceIdentity;", "identity", "authToken", "authPassword", "buildConnectParams", "(Lcom/stepos/stepclaw/gateway/DeviceIdentity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/serialization/json/JsonObject;", "text", "handleMessage", "frame", "handleResponse", "(Lkotlinx/serialization/json/JsonObject;)V", "handleEvent", "awaitConnectNonce", "payloadJson", "extractConnectNonce", "(Ljava/lang/String;)Ljava/lang/String;", "handleInvokeEvent", "(Ljava/lang/String;)V", "id", "nodeId", "Lcom/stepos/stepclaw/gateway/GatewaySession$InvokeResult;", "result", "invokeTimeoutMs", "sendInvokeResult", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/gateway/GatewaySession$InvokeResult;Ljava/lang/Long;Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "err", "invokeErrorFromThrowable", "(Ljava/lang/Throwable;)Lcom/stepos/stepclaw/gateway/GatewaySession$InvokeResult;", "failPending", "Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "Ljava/lang/String;", "Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;", "Lcom/stepos/stepclaw/gateway/GatewayTlsParams;", "La6/r;", "connectDeferred", "La6/r;", "closedDeferred", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "connectNonceDeferred", "client", "Ln6/q;", "Ln6/a0;", "socket", "Ln6/a0;", "loggerTag", "remoteAddress", "getRemoteAddress", "()Ljava/lang/String;", "Listener", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class Connection {
        private final n6.q client;
        private final r closedDeferred;
        private final r connectDeferred;
        private final r connectNonceDeferred;
        private final GatewayEndpoint endpoint;
        private final AtomicBoolean isClosed;
        private final String loggerTag;
        private final GatewayConnectOptions options;
        private final String password;
        private final String remoteAddress;
        private a0 socket;
        final /* synthetic */ GatewaySession this$0;
        private final GatewayTlsParams tls;
        private final String token;

        /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$Connection$Listener;", "Ln6/b0;", "<init>", "(Lcom/stepos/stepclaw/gateway/GatewaySession$Connection;)V", "Ln6/a0;", "webSocket", "Ln6/u;", "response", "Lb5/a0;", "onOpen", "(Ln6/a0;Ln6/u;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "text", "onMessage", "(Ln6/a0;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "t", "onFailure", "(Ln6/a0;Ljava/lang/Throwable;Ln6/u;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "code", "reason", "onClosed", "(Ln6/a0;ILjava/lang/String;)V", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public final class Listener extends b0 {
            public Listener() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // n6.b0
            public void onClosed(a0 webSocket, int code, String reason) {
                kotlin.jvm.internal.p.e(webSocket, "webSocket");
                kotlin.jvm.internal.p.e(reason, "reason");
                if (!((p1) Connection.this.connectDeferred).Q()) {
                    s sVar = (s) Connection.this.connectDeferred;
                    sVar.f0(new BusinessLayerFailure("Gateway closed: ".concat(reason), null, 2, 0 == true ? 1 : 0));
                }
                if (Connection.this.isClosed.compareAndSet(false, true)) {
                    Connection.this.failPending();
                    ((s) Connection.this.closedDeferred).S(b5.a0.f883a);
                    Connection.this.this$0.onDisconnected.invoke("Gateway closed: ".concat(reason));
                }
            }

            @Override // n6.b0
            public void onFailure(a0 webSocket, Throwable t8, u response) {
                kotlin.jvm.internal.p.e(webSocket, "webSocket");
                kotlin.jvm.internal.p.e(t8, "t");
                if (!((p1) Connection.this.connectDeferred).Q()) {
                    ((s) Connection.this.connectDeferred).f0(t8);
                }
                if (Connection.this.isClosed.compareAndSet(false, true)) {
                    Connection.this.failPending();
                    ((s) Connection.this.closedDeferred).S(b5.a0.f883a);
                    l lVar = Connection.this.this$0.onDisconnected;
                    String message = t8.getMessage();
                    if (message == null) {
                        message = t8.getClass().getSimpleName();
                    }
                    lVar.invoke("Gateway error: ".concat(message));
                }
            }

            @Override // n6.b0
            public void onMessage(a0 webSocket, String text) {
                kotlin.jvm.internal.p.e(webSocket, "webSocket");
                kotlin.jvm.internal.p.e(text, "text");
                i0.q(Connection.this.this$0.scope, null, new GatewaySession$Connection$Listener$onMessage$1(Connection.this, text, null), 3);
            }

            @Override // n6.b0
            public void onOpen(a0 webSocket, u response) {
                kotlin.jvm.internal.p.e(webSocket, "webSocket");
                kotlin.jvm.internal.p.e(response, "response");
                i0.q(Connection.this.this$0.scope, null, new GatewaySession$Connection$Listener$onOpen$1(Connection.this, null), 3);
            }
        }

        public Connection(GatewaySession gatewaySession, GatewayEndpoint endpoint, String str, String str2, GatewayConnectOptions options, GatewayTlsParams gatewayTlsParams) {
            String str3;
            kotlin.jvm.internal.p.e(endpoint, "endpoint");
            kotlin.jvm.internal.p.e(options, "options");
            this.this$0 = gatewaySession;
            this.endpoint = endpoint;
            this.token = str;
            this.password = str2;
            this.options = options;
            this.tls = gatewayTlsParams;
            this.connectDeferred = i0.a();
            this.closedDeferred = i0.a();
            this.isClosed = new AtomicBoolean(false);
            this.connectNonceDeferred = i0.a();
            this.client = buildClient(gatewaySession.pingTracker.intervalSeconds());
            this.loggerTag = "OpenClawGateway";
            if (n.g1(endpoint.getHost(), ":", false)) {
                str3 = "[" + endpoint.getHost() + "]:" + endpoint.getPort();
            } else {
                str3 = endpoint.getHost() + ":" + endpoint.getPort();
            }
            this.remoteAddress = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object awaitConnectNonce(f5.c r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof com.stepos.stepclaw.gateway.GatewaySession$Connection$awaitConnectNonce$1
                if (r0 == 0) goto L13
                r0 = r5
                com.stepos.stepclaw.gateway.GatewaySession$Connection$awaitConnectNonce$1 r0 = (com.stepos.stepclaw.gateway.GatewaySession$Connection$awaitConnectNonce$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.stepclaw.gateway.GatewaySession$Connection$awaitConnectNonce$1 r0 = new com.stepos.stepclaw.gateway.GatewaySession$Connection$awaitConnectNonce$1
                r0.<init>(r4, r5)
            L18:
                java.lang.Object r5 = r0.result
                g5.a r1 = g5.a.f2984a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                a.a.c0(r5)     // Catch: java.lang.Throwable -> L46
                goto L43
            L27:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L2f:
                a.a.c0(r5)
                com.stepos.stepclaw.gateway.GatewaySession$Connection$awaitConnectNonce$2 r5 = new com.stepos.stepclaw.gateway.GatewaySession$Connection$awaitConnectNonce$2     // Catch: java.lang.Throwable -> L46
                r2 = 0
                r5.<init>(r4, r2)     // Catch: java.lang.Throwable -> L46
                r0.label = r3     // Catch: java.lang.Throwable -> L46
                r2 = 2000(0x7d0, double:9.88E-321)
                java.lang.Object r5 = a6.i0.B(r2, r5, r0)     // Catch: java.lang.Throwable -> L46
                if (r5 != r1) goto L43
                return r1
            L43:
                java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L46
                return r5
            L46:
                r4 = move-exception
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "connect challenge timeout"
                r5.<init>(r0, r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.Connection.awaitConnectNonce(f5.c):java.lang.Object");
        }

        private final n6.q buildClient(long pingIntervalSeconds) {
            n6.p pVar = new n6.p();
            TimeUnit unit = TimeUnit.SECONDS;
            kotlin.jvm.internal.p.e(unit, "unit");
            pVar.y = o6.f.b(60L, "timeout");
            pVar.f4095x = o6.f.b(0L, "timeout");
            pVar.z = o6.f.b(pingIntervalSeconds, "interval");
            GatewayTlsParams gatewayTlsParams = this.tls;
            final GatewaySession gatewaySession = this.this$0;
            GatewayTlsConfig gatewayTlsConfigBuildGatewayTlsConfig = GatewayTlsKt.buildGatewayTlsConfig(gatewayTlsParams, new l() { // from class: com.stepos.stepclaw.gateway.e
                @Override // p5.l
                public final Object invoke(Object obj) {
                    return GatewaySession.Connection.buildClient$lambda$0(gatewaySession, this, (String) obj);
                }
            });
            if (gatewayTlsConfigBuildGatewayTlsConfig != null) {
                SSLSocketFactory sslSocketFactory = gatewayTlsConfigBuildGatewayTlsConfig.getSslSocketFactory();
                X509TrustManager trustManager = gatewayTlsConfigBuildGatewayTlsConfig.getTrustManager();
                kotlin.jvm.internal.p.e(sslSocketFactory, "sslSocketFactory");
                kotlin.jvm.internal.p.e(trustManager, "trustManager");
                if (!sslSocketFactory.equals(pVar.f4087p) || !trustManager.equals(pVar.f4088q)) {
                    pVar.C = null;
                }
                pVar.f4087p = sslSocketFactory;
                z6.d.Companion.getClass();
                pVar.f4093v = Platform.INSTANCE.get().buildCertificateChainCleaner(trustManager);
                pVar.f4088q = trustManager;
                HostnameVerifier hostnameVerifier = gatewayTlsConfigBuildGatewayTlsConfig.getHostnameVerifier();
                kotlin.jvm.internal.p.e(hostnameVerifier, "hostnameVerifier");
                if (!hostnameVerifier.equals(pVar.f4091t)) {
                    pVar.C = null;
                }
                pVar.f4091t = hostnameVerifier;
            }
            return new n6.q(pVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final b5.a0 buildClient$lambda$0(GatewaySession gatewaySession, Connection connection, String fingerprint) {
            String stableId;
            kotlin.jvm.internal.p.e(fingerprint, "fingerprint");
            p pVar = gatewaySession.onTlsFingerprint;
            if (pVar != null) {
                GatewayTlsParams gatewayTlsParams = connection.tls;
                if (gatewayTlsParams == null || (stableId = gatewayTlsParams.getStableId()) == null) {
                    stableId = connection.endpoint.getStableId();
                }
                pVar.invoke(stableId, fingerprint);
            }
            return b5.a0.f883a;
        }

        private final JsonObject buildConnectParams(DeviceIdentity identity, String connectNonce, String authToken, String authPassword) {
            JsonObject jsonObjectBuild;
            JsonObject jsonObjectBuild2;
            String string;
            GatewayClientInfo client = this.options.getClient();
            String languageTag = Locale.getDefault().toLanguageTag();
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            jsonObjectBuilder.put("id", JsonElementKt.JsonPrimitive(client.getId()));
            String displayName = client.getDisplayName();
            if (displayName != null) {
                jsonObjectBuilder.put("displayName", JsonElementKt.JsonPrimitive(displayName));
            }
            jsonObjectBuilder.put("version", JsonElementKt.JsonPrimitive(client.getVersion()));
            jsonObjectBuilder.put("platform", JsonElementKt.JsonPrimitive(client.getPlatform()));
            jsonObjectBuilder.put("mode", JsonElementKt.JsonPrimitive(client.getMode()));
            String instanceId = client.getInstanceId();
            if (instanceId != null) {
                jsonObjectBuilder.put("instanceId", JsonElementKt.JsonPrimitive(instanceId));
            }
            String deviceFamily = client.getDeviceFamily();
            if (deviceFamily != null) {
                jsonObjectBuilder.put("deviceFamily", JsonElementKt.JsonPrimitive(deviceFamily));
            }
            String modelIdentifier = client.getModelIdentifier();
            if (modelIdentifier != null) {
                jsonObjectBuilder.put("modelIdentifier", JsonElementKt.JsonPrimitive(modelIdentifier));
            }
            JsonObject jsonObjectBuild3 = jsonObjectBuilder.build();
            String string2 = authPassword != null ? n.T1(authPassword).toString() : null;
            if (string2 == null) {
                string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (authToken.length() > 0) {
                JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
                jsonObjectBuilder2.put(GatewayAuthConstants.AUTH_MODE, JsonElementKt.JsonPrimitive(authToken));
                jsonObjectBuild = jsonObjectBuilder2.build();
            } else if (string2.length() > 0) {
                JsonObjectBuilder jsonObjectBuilder3 = new JsonObjectBuilder();
                jsonObjectBuilder3.put("password", JsonElementKt.JsonPrimitive(string2));
                jsonObjectBuild = jsonObjectBuilder3.build();
            } else {
                jsonObjectBuild = null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strSignPayload = this.this$0.identityStore.signPayload(DeviceAuthPayload.INSTANCE.buildV3(identity.getDeviceId(), client.getId(), client.getMode(), this.options.getRole(), this.options.getScopes(), jCurrentTimeMillis, authToken.length() > 0 ? authToken : null, connectNonce, client.getPlatform(), client.getDeviceFamily()), identity);
            String strPublicKeyBase64Url = this.this$0.identityStore.publicKeyBase64Url(identity);
            if (strSignPayload == null || n.t1(strSignPayload) || strPublicKeyBase64Url == null || n.t1(strPublicKeyBase64Url)) {
                jsonObjectBuild2 = null;
            } else {
                JsonObjectBuilder jsonObjectBuilder4 = new JsonObjectBuilder();
                jsonObjectBuilder4.put("id", JsonElementKt.JsonPrimitive(identity.getDeviceId()));
                jsonObjectBuilder4.put("publicKey", JsonElementKt.JsonPrimitive(strPublicKeyBase64Url));
                jsonObjectBuilder4.put("signature", JsonElementKt.JsonPrimitive(strSignPayload));
                jsonObjectBuilder4.put("signedAt", JsonElementKt.JsonPrimitive(Long.valueOf(jCurrentTimeMillis)));
                jsonObjectBuilder4.put("nonce", JsonElementKt.JsonPrimitive(connectNonce));
                jsonObjectBuild2 = jsonObjectBuilder4.build();
            }
            JsonObjectBuilder jsonObjectBuilder5 = new JsonObjectBuilder();
            jsonObjectBuilder5.put("minProtocol", JsonElementKt.JsonPrimitive((Number) 3));
            jsonObjectBuilder5.put("maxProtocol", JsonElementKt.JsonPrimitive((Number) 3));
            jsonObjectBuilder5.put("client", jsonObjectBuild3);
            if (!this.options.getCaps().isEmpty()) {
                List<String> caps = this.options.getCaps();
                ArrayList arrayList = new ArrayList(o.n0(caps, 10));
                Iterator<T> it = caps.iterator();
                while (it.hasNext()) {
                    arrayList.add(JsonElementKt.JsonPrimitive((String) it.next()));
                }
                jsonObjectBuilder5.put("caps", new JsonArray(arrayList));
            }
            if (!this.options.getCommands().isEmpty()) {
                List<String> commands = this.options.getCommands();
                ArrayList arrayList2 = new ArrayList(o.n0(commands, 10));
                Iterator<T> it2 = commands.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(JsonElementKt.JsonPrimitive((String) it2.next()));
                }
                jsonObjectBuilder5.put("commands", new JsonArray(arrayList2));
            }
            if (!this.options.getPermissions().isEmpty()) {
                JsonObjectBuilder jsonObjectBuilder6 = new JsonObjectBuilder();
                for (Map.Entry<String, Boolean> entry : this.options.getPermissions().entrySet()) {
                    String key = entry.getKey();
                    Boolean value = entry.getValue();
                    value.booleanValue();
                    jsonObjectBuilder6.put(key, JsonElementKt.JsonPrimitive(value));
                }
                jsonObjectBuilder5.put("permissions", jsonObjectBuilder6.build());
            }
            jsonObjectBuilder5.put("role", JsonElementKt.JsonPrimitive(this.options.getRole()));
            if (!this.options.getScopes().isEmpty()) {
                List<String> scopes = this.options.getScopes();
                ArrayList arrayList3 = new ArrayList(o.n0(scopes, 10));
                Iterator<T> it3 = scopes.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(JsonElementKt.JsonPrimitive((String) it3.next()));
                }
                jsonObjectBuilder5.put("scopes", new JsonArray(arrayList3));
            }
            if (jsonObjectBuild != null) {
                jsonObjectBuilder5.put("auth", jsonObjectBuild);
            }
            if (jsonObjectBuild2 != null) {
                jsonObjectBuilder5.put("device", jsonObjectBuild2);
            }
            jsonObjectBuilder5.put("locale", JsonElementKt.JsonPrimitive(languageTag));
            String userAgent = this.options.getUserAgent();
            if (userAgent != null && (string = n.T1(userAgent).toString()) != null) {
                String str = string.length() > 0 ? string : null;
                if (str != null) {
                    jsonObjectBuilder5.put("userAgent", JsonElementKt.JsonPrimitive(str));
                }
            }
            return jsonObjectBuilder5.build();
        }

        private final void cleanupExpiredPending() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it = this.this$0.pending.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (jCurrentTimeMillis - ((PendingEntry) entry.getValue()).getCreatedAt() > GatewaySession.PENDING_EXPIRY_MS) {
                    it.remove();
                    ((p1) ((PendingEntry) entry.getValue()).getDeferred()).e(null);
                }
            }
        }

        private final String extractConnectNonce(String payloadJson) {
            JsonElement jsonOrNull;
            JsonObject jsonObjectAsObjectOrNull;
            if (payloadJson == null || n.t1(payloadJson) || (jsonOrNull = GatewaySessionKt.parseJsonOrNull(payloadJson)) == null || (jsonObjectAsObjectOrNull = GatewaySessionKt.asObjectOrNull(jsonOrNull)) == null) {
                return null;
            }
            return GatewaySessionKt.asStringOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "nonce"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void failPending() {
            Iterator it = this.this$0.pending.entrySet().iterator();
            while (it.hasNext()) {
                ((p1) ((PendingEntry) ((Map.Entry) it.next()).getValue()).getDeferred()).e(null);
            }
            this.this$0.pending.clear();
        }

        private final void handleConnectSuccess(RpcResponse res, String deviceId) {
            String payloadJson = res.getPayloadJson();
            if (payloadJson == null) {
                throw new IllegalStateException("connect failed: missing payload");
            }
            JsonObject jsonObjectAsObjectOrNull = GatewaySessionKt.asObjectOrNull(this.this$0.json.parseToJsonElement(payloadJson));
            if (jsonObjectAsObjectOrNull == null) {
                throw new IllegalStateException("connect failed");
            }
            JsonObject jsonObjectAsObjectOrNull2 = GatewaySessionKt.asObjectOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "server"));
            String strAsStringOrNull = GatewaySessionKt.asStringOrNull(jsonObjectAsObjectOrNull2 != null ? (JsonElement) jsonObjectAsObjectOrNull2.get((Object) "host") : null);
            JsonObject jsonObjectAsObjectOrNull3 = GatewaySessionKt.asObjectOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "auth"));
            String strAsStringOrNull2 = GatewaySessionKt.asStringOrNull(jsonObjectAsObjectOrNull3 != null ? (JsonElement) jsonObjectAsObjectOrNull3.get((Object) "deviceToken") : null);
            String strAsStringOrNull3 = GatewaySessionKt.asStringOrNull(jsonObjectAsObjectOrNull3 != null ? (JsonElement) jsonObjectAsObjectOrNull3.get((Object) "role") : null);
            if (strAsStringOrNull3 == null) {
                strAsStringOrNull3 = this.options.getRole();
            }
            if (strAsStringOrNull2 != null && !n.t1(strAsStringOrNull2)) {
                this.this$0.deviceAuthStore.saveToken(deviceId, strAsStringOrNull3, strAsStringOrNull2);
            }
            String strAsStringOrNull4 = GatewaySessionKt.asStringOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "canvasHostUrl"));
            GatewaySession gatewaySession = this.this$0;
            gatewaySession.canvasHostUrl = gatewaySession.normalizeCanvasHostUrl(strAsStringOrNull4, this.endpoint, this.tls != null);
            JsonObject jsonObjectAsObjectOrNull4 = GatewaySessionKt.asObjectOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "snapshot"));
            JsonObject jsonObjectAsObjectOrNull5 = GatewaySessionKt.asObjectOrNull(jsonObjectAsObjectOrNull4 != null ? (JsonElement) jsonObjectAsObjectOrNull4.get((Object) "sessionDefaults") : null);
            this.this$0.mainSessionKey = GatewaySessionKt.asStringOrNull(jsonObjectAsObjectOrNull5 != null ? (JsonElement) jsonObjectAsObjectOrNull5.get((Object) "mainSessionKey") : null);
            this.this$0.sessionOnline = true;
            this.this$0.onConnected.invoke(strAsStringOrNull, this.remoteAddress, this.this$0.mainSessionKey);
        }

        private final void handleEvent(JsonObject frame) {
            String strAsStringOrNull;
            String strAsStringOrNull2 = GatewaySessionKt.asStringOrNull((JsonElement) frame.get("event"));
            if (strAsStringOrNull2 == null) {
                return;
            }
            JsonElement jsonElement = (JsonElement) frame.get("payload");
            if (jsonElement == null || (strAsStringOrNull = jsonElement.toString()) == null) {
                strAsStringOrNull = GatewaySessionKt.asStringOrNull((JsonElement) frame.get("payloadJSON"));
            }
            if (strAsStringOrNull2.equals("connect.challenge")) {
                String strExtractConnectNonce = extractConnectNonce(strAsStringOrNull);
                if (((p1) this.connectNonceDeferred).Q() || strExtractConnectNonce == null || n.t1(strExtractConnectNonce)) {
                    return;
                }
                ((s) this.connectNonceDeferred).S(n.T1(strExtractConnectNonce).toString());
                return;
            }
            if (strAsStringOrNull2.equals("node.invoke.request") && strAsStringOrNull != null && this.this$0.onInvoke != null) {
                handleInvokeEvent(strAsStringOrNull);
                return;
            }
            p pVar = this.this$0.onEvent;
            if (pVar != null) {
                pVar.invoke(strAsStringOrNull2, strAsStringOrNull);
            }
        }

        private final void handleInvokeEvent(String payloadJson) {
            JsonObject jsonObjectAsObjectOrNull;
            String strAsStringOrNull;
            String strAsStringOrNull2;
            String strAsStringOrNull3;
            String str;
            try {
                jsonObjectAsObjectOrNull = GatewaySessionKt.asObjectOrNull(this.this$0.json.parseToJsonElement(payloadJson));
            } catch (Throwable unused) {
                jsonObjectAsObjectOrNull = null;
            }
            if (jsonObjectAsObjectOrNull == null || (strAsStringOrNull = GatewaySessionKt.asStringOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "id"))) == null || (strAsStringOrNull2 = GatewaySessionKt.asStringOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "nodeId"))) == null || (strAsStringOrNull3 = GatewaySessionKt.asStringOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "command"))) == null) {
                return;
            }
            String strAsStringOrNull4 = GatewaySessionKt.asStringOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "paramsJSON"));
            if (strAsStringOrNull4 != null) {
                str = strAsStringOrNull4;
            } else {
                JsonElement jsonElement = (JsonElement) jsonObjectAsObjectOrNull.get((Object) "params");
                if (jsonElement != null) {
                    strAsStringOrNull4 = jsonElement instanceof JsonNull ? null : jsonElement.toString();
                    str = strAsStringOrNull4;
                } else {
                    str = null;
                }
            }
            i0.q(this.this$0.scope, null, new GatewaySession$Connection$handleInvokeEvent$1(this.this$0, strAsStringOrNull, strAsStringOrNull2, strAsStringOrNull3, str, GatewaySessionKt.asLongOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "timeoutMs")), GatewaySessionKt.asStringOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "toolCallId")), this, null), 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object handleMessage(String str, f5.c cVar) {
            this.this$0.pingTracker.onUserActivity();
            JsonObject jsonObjectAsObjectOrNull = GatewaySessionKt.asObjectOrNull(this.this$0.json.parseToJsonElement(str));
            b5.a0 a0Var = b5.a0.f883a;
            if (jsonObjectAsObjectOrNull == null) {
                return a0Var;
            }
            cleanupExpiredPending();
            String strAsStringOrNull = GatewaySessionKt.asStringOrNull((JsonElement) jsonObjectAsObjectOrNull.get("type"));
            if (kotlin.jvm.internal.p.a(strAsStringOrNull, "res")) {
                handleResponse(jsonObjectAsObjectOrNull);
            } else if (kotlin.jvm.internal.p.a(strAsStringOrNull, "event")) {
                handleEvent(jsonObjectAsObjectOrNull);
            }
            return a0Var;
        }

        private final void handleResponse(JsonObject frame) {
            r deferred;
            JsonObject jsonObjectAsObjectOrNull;
            String strAsStringOrNull = GatewaySessionKt.asStringOrNull((JsonElement) frame.get("id"));
            if (strAsStringOrNull == null) {
                return;
            }
            Boolean boolAsBooleanOrNull = GatewaySessionKt.asBooleanOrNull((JsonElement) frame.get(ConfigIpcContract.KEY_OK));
            boolean zBooleanValue = boolAsBooleanOrNull != null ? boolAsBooleanOrNull.booleanValue() : false;
            JsonElement jsonElement = (JsonElement) frame.get("payload");
            ErrorShape errorShape = null;
            String string = jsonElement != null ? jsonElement.toString() : null;
            JsonElement jsonElement2 = (JsonElement) frame.get("error");
            if (jsonElement2 != null && (jsonObjectAsObjectOrNull = GatewaySessionKt.asObjectOrNull(jsonElement2)) != null) {
                String strAsStringOrNull2 = GatewaySessionKt.asStringOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) "code"));
                if (strAsStringOrNull2 == null) {
                    strAsStringOrNull2 = "UNAVAILABLE";
                }
                String strAsStringOrNull3 = GatewaySessionKt.asStringOrNull((JsonElement) jsonObjectAsObjectOrNull.get((Object) OperationResult.EXTRA_MESSAGE));
                if (strAsStringOrNull3 == null) {
                    strAsStringOrNull3 = "request failed";
                }
                errorShape = new ErrorShape(strAsStringOrNull2, strAsStringOrNull3);
            }
            PendingEntry pendingEntry = (PendingEntry) this.this$0.pending.remove(strAsStringOrNull);
            if (pendingEntry == null || (deferred = pendingEntry.getDeferred()) == null) {
                return;
            }
            ((s) deferred).S(new RpcResponse(strAsStringOrNull, zBooleanValue, string, errorShape));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final InvokeResult invokeErrorFromThrowable(Throwable err) {
            ParsedInvokeError invokeErrorFromThrowable = InvokeErrorParserKt.parseInvokeErrorFromThrowable(err, err.getClass().getSimpleName());
            return InvokeResult.INSTANCE.error(invokeErrorFromThrowable.getCode(), invokeErrorFromThrowable.getMessage());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object sendConnect(java.lang.String r9, f5.c r10) {
            /*
                Method dump skipped, instructions count: 230
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.Connection.sendConnect(java.lang.String, f5.c):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object sendInvokeResult(java.lang.String r9, java.lang.String r10, com.stepos.stepclaw.gateway.GatewaySession.InvokeResult r11, java.lang.Long r12, f5.c r13) {
            /*
                Method dump skipped, instructions count: 291
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.Connection.sendInvokeResult(java.lang.String, java.lang.String, com.stepos.stepclaw.gateway.GatewaySession$InvokeResult, java.lang.Long, f5.c):java.lang.Object");
        }

        public final Object awaitClose(f5.c cVar) {
            Object objW = ((s) this.closedDeferred).w(cVar);
            return objW == g5.a.f2984a ? objW : b5.a0.f883a;
        }

        public final void closeQuietly() {
            if (this.isClosed.compareAndSet(false, true)) {
                a0 a0Var = this.socket;
                if (a0Var != null) {
                    ((h) a0Var).b(1000, "bye");
                }
                this.socket = null;
                ((s) this.closedDeferred).S(b5.a0.f883a);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object connect(f5.c r22) {
            /*
                Method dump skipped, instructions count: 690
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.Connection.connect(f5.c):java.lang.Object");
        }

        public final String getRemoteAddress() {
            return this.remoteAddress;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object request(java.lang.String r17, kotlinx.serialization.json.JsonElement r18, long r19, f5.c r21) {
            /*
                Method dump skipped, instructions count: 276
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.Connection.request(java.lang.String, kotlinx.serialization.json.JsonElement, long, f5.c):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object sendJson(kotlinx.serialization.json.JsonObject r6, f5.c r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof com.stepos.stepclaw.gateway.GatewaySession$Connection$sendJson$1
                if (r0 == 0) goto L13
                r0 = r7
                com.stepos.stepclaw.gateway.GatewaySession$Connection$sendJson$1 r0 = (com.stepos.stepclaw.gateway.GatewaySession$Connection$sendJson$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.stepclaw.gateway.GatewaySession$Connection$sendJson$1 r0 = new com.stepos.stepclaw.gateway.GatewaySession$Connection$sendJson$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.result
                g5.a r1 = g5.a.f2984a
                int r2 = r0.label
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L3c
                if (r2 != r3) goto L34
                java.lang.Object r6 = r0.L$2
                i6.a r6 = (i6.a) r6
                java.lang.Object r1 = r0.L$1
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r0 = r0.L$0
                kotlinx.serialization.json.JsonObject r0 = (kotlinx.serialization.json.JsonObject) r0
                a.a.c0(r7)
                goto L5f
            L34:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L3c:
                a.a.c0(r7)
                java.lang.String r6 = r6.toString()
                com.stepos.stepclaw.gateway.GatewaySession r7 = r5.this$0
                i6.a r7 = com.stepos.stepclaw.gateway.GatewaySession.access$getWriteLock$p(r7)
                r0.L$0 = r4
                r0.L$1 = r6
                r0.L$2 = r7
                r2 = 0
                r0.I$0 = r2
                r0.label = r3
                i6.c r7 = (i6.c) r7
                java.lang.Object r0 = r7.c(r0)
                if (r0 != r1) goto L5d
                return r1
            L5d:
                r1 = r6
                r6 = r7
            L5f:
                n6.a0 r5 = r5.socket     // Catch: java.lang.Throwable -> L70
                if (r5 == 0) goto L68
                b7.h r5 = (b7.h) r5     // Catch: java.lang.Throwable -> L70
                r5.f(r1)     // Catch: java.lang.Throwable -> L70
            L68:
                i6.c r6 = (i6.c) r6
                r6.e(r4)
                b5.a0 r5 = b5.a0.f883a
                return r5
            L70:
                r5 = move-exception
                i6.c r6 = (i6.c) r6
                r6.e(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.Connection.sendJson(kotlinx.serialization.json.JsonObject, f5.c):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$DesiredConnection;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "endpoint", "Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", GatewayAuthConstants.AUTH_MODE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "password", "options", "Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;", "tls", "Lcom/stepos/stepclaw/gateway/GatewayTlsParams;", "<init>", "(Lcom/stepos/stepclaw/gateway/GatewayEndpoint;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;Lcom/stepos/stepclaw/gateway/GatewayTlsParams;)V", "getEndpoint", "()Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "getToken", "()Ljava/lang/String;", "getPassword", "getOptions", "()Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;", "getTls", "()Lcom/stepos/stepclaw/gateway/GatewayTlsParams;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DesiredConnection {
        private final GatewayEndpoint endpoint;
        private final GatewayConnectOptions options;
        private final String password;
        private final GatewayTlsParams tls;
        private final String token;

        public DesiredConnection(GatewayEndpoint endpoint, String str, String str2, GatewayConnectOptions options, GatewayTlsParams gatewayTlsParams) {
            kotlin.jvm.internal.p.e(endpoint, "endpoint");
            kotlin.jvm.internal.p.e(options, "options");
            this.endpoint = endpoint;
            this.token = str;
            this.password = str2;
            this.options = options;
            this.tls = gatewayTlsParams;
        }

        public static /* synthetic */ DesiredConnection copy$default(DesiredConnection desiredConnection, GatewayEndpoint gatewayEndpoint, String str, String str2, GatewayConnectOptions gatewayConnectOptions, GatewayTlsParams gatewayTlsParams, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                gatewayEndpoint = desiredConnection.endpoint;
            }
            if ((i8 & 2) != 0) {
                str = desiredConnection.token;
            }
            if ((i8 & 4) != 0) {
                str2 = desiredConnection.password;
            }
            if ((i8 & 8) != 0) {
                gatewayConnectOptions = desiredConnection.options;
            }
            if ((i8 & 16) != 0) {
                gatewayTlsParams = desiredConnection.tls;
            }
            GatewayTlsParams gatewayTlsParams2 = gatewayTlsParams;
            String str3 = str2;
            return desiredConnection.copy(gatewayEndpoint, str, str3, gatewayConnectOptions, gatewayTlsParams2);
        }

        /* renamed from: component1, reason: from getter */
        public final GatewayEndpoint getEndpoint() {
            return this.endpoint;
        }

        /* renamed from: component2, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPassword() {
            return this.password;
        }

        /* renamed from: component4, reason: from getter */
        public final GatewayConnectOptions getOptions() {
            return this.options;
        }

        /* renamed from: component5, reason: from getter */
        public final GatewayTlsParams getTls() {
            return this.tls;
        }

        public final DesiredConnection copy(GatewayEndpoint endpoint, String token, String password, GatewayConnectOptions options, GatewayTlsParams tls) {
            kotlin.jvm.internal.p.e(endpoint, "endpoint");
            kotlin.jvm.internal.p.e(options, "options");
            return new DesiredConnection(endpoint, token, password, options, tls);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DesiredConnection)) {
                return false;
            }
            DesiredConnection desiredConnection = (DesiredConnection) other;
            return kotlin.jvm.internal.p.a(this.endpoint, desiredConnection.endpoint) && kotlin.jvm.internal.p.a(this.token, desiredConnection.token) && kotlin.jvm.internal.p.a(this.password, desiredConnection.password) && kotlin.jvm.internal.p.a(this.options, desiredConnection.options) && kotlin.jvm.internal.p.a(this.tls, desiredConnection.tls);
        }

        public final GatewayEndpoint getEndpoint() {
            return this.endpoint;
        }

        public final GatewayConnectOptions getOptions() {
            return this.options;
        }

        public final String getPassword() {
            return this.password;
        }

        public final GatewayTlsParams getTls() {
            return this.tls;
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            int iHashCode = this.endpoint.hashCode() * 31;
            String str = this.token;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.password;
            int iHashCode3 = (this.options.hashCode() + ((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
            GatewayTlsParams gatewayTlsParams = this.tls;
            return iHashCode3 + (gatewayTlsParams != null ? gatewayTlsParams.hashCode() : 0);
        }

        public String toString() {
            return "DesiredConnection(endpoint=" + this.endpoint + ", token=" + this.token + ", password=" + this.password + ", options=" + this.options + ", tls=" + this.tls + ")";
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$ErrorShape;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "code", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_MESSAGE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ErrorShape {
        private final String code;
        private final String message;

        public ErrorShape(String code, String message) {
            kotlin.jvm.internal.p.e(code, "code");
            kotlin.jvm.internal.p.e(message, "message");
            this.code = code;
            this.message = message;
        }

        public static /* synthetic */ ErrorShape copy$default(ErrorShape errorShape, String str, String str2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = errorShape.code;
            }
            if ((i8 & 2) != 0) {
                str2 = errorShape.message;
            }
            return errorShape.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ErrorShape copy(String code, String message) {
            kotlin.jvm.internal.p.e(code, "code");
            kotlin.jvm.internal.p.e(message, "message");
            return new ErrorShape(code, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorShape)) {
                return false;
            }
            ErrorShape errorShape = (ErrorShape) other;
            return kotlin.jvm.internal.p.a(this.code, errorShape.code) && kotlin.jvm.internal.p.a(this.message, errorShape.message);
        }

        public final String getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode() + (this.code.hashCode() * 31);
        }

        public String toString() {
            return a8.b.q("ErrorShape(code=", this.code, ", message=", this.message, ")");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JP\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$InvokeRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "nodeId", "command", "paramsJson", "timeoutMs", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toolCallId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getNodeId", "getCommand", "getParamsJson", "getTimeoutMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getToolCallId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/stepos/stepclaw/gateway/GatewaySession$InvokeRequest;", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InvokeRequest {
        private final String command;
        private final String id;
        private final String nodeId;
        private final String paramsJson;
        private final Long timeoutMs;
        private final String toolCallId;

        public InvokeRequest(String id, String nodeId, String command, String str, Long l3, String str2) {
            kotlin.jvm.internal.p.e(id, "id");
            kotlin.jvm.internal.p.e(nodeId, "nodeId");
            kotlin.jvm.internal.p.e(command, "command");
            this.id = id;
            this.nodeId = nodeId;
            this.command = command;
            this.paramsJson = str;
            this.timeoutMs = l3;
            this.toolCallId = str2;
        }

        public static /* synthetic */ InvokeRequest copy$default(InvokeRequest invokeRequest, String str, String str2, String str3, String str4, Long l3, String str5, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = invokeRequest.id;
            }
            if ((i8 & 2) != 0) {
                str2 = invokeRequest.nodeId;
            }
            if ((i8 & 4) != 0) {
                str3 = invokeRequest.command;
            }
            if ((i8 & 8) != 0) {
                str4 = invokeRequest.paramsJson;
            }
            if ((i8 & 16) != 0) {
                l3 = invokeRequest.timeoutMs;
            }
            if ((i8 & 32) != 0) {
                str5 = invokeRequest.toolCallId;
            }
            Long l6 = l3;
            String str6 = str5;
            return invokeRequest.copy(str, str2, str3, str4, l6, str6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getNodeId() {
            return this.nodeId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getCommand() {
            return this.command;
        }

        /* renamed from: component4, reason: from getter */
        public final String getParamsJson() {
            return this.paramsJson;
        }

        /* renamed from: component5, reason: from getter */
        public final Long getTimeoutMs() {
            return this.timeoutMs;
        }

        /* renamed from: component6, reason: from getter */
        public final String getToolCallId() {
            return this.toolCallId;
        }

        public final InvokeRequest copy(String id, String nodeId, String command, String paramsJson, Long timeoutMs, String toolCallId) {
            kotlin.jvm.internal.p.e(id, "id");
            kotlin.jvm.internal.p.e(nodeId, "nodeId");
            kotlin.jvm.internal.p.e(command, "command");
            return new InvokeRequest(id, nodeId, command, paramsJson, timeoutMs, toolCallId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvokeRequest)) {
                return false;
            }
            InvokeRequest invokeRequest = (InvokeRequest) other;
            return kotlin.jvm.internal.p.a(this.id, invokeRequest.id) && kotlin.jvm.internal.p.a(this.nodeId, invokeRequest.nodeId) && kotlin.jvm.internal.p.a(this.command, invokeRequest.command) && kotlin.jvm.internal.p.a(this.paramsJson, invokeRequest.paramsJson) && kotlin.jvm.internal.p.a(this.timeoutMs, invokeRequest.timeoutMs) && kotlin.jvm.internal.p.a(this.toolCallId, invokeRequest.toolCallId);
        }

        public final String getCommand() {
            return this.command;
        }

        public final String getId() {
            return this.id;
        }

        public final String getNodeId() {
            return this.nodeId;
        }

        public final String getParamsJson() {
            return this.paramsJson;
        }

        public final Long getTimeoutMs() {
            return this.timeoutMs;
        }

        public final String getToolCallId() {
            return this.toolCallId;
        }

        public int hashCode() {
            int iF = a8.b.f(a8.b.f(this.id.hashCode() * 31, 31, this.nodeId), 31, this.command);
            String str = this.paramsJson;
            int iHashCode = (iF + (str == null ? 0 : str.hashCode())) * 31;
            Long l3 = this.timeoutMs;
            int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
            String str2 = this.toolCallId;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            String str = this.id;
            String str2 = this.nodeId;
            String str3 = this.command;
            String str4 = this.paramsJson;
            Long l3 = this.timeoutMs;
            String str5 = this.toolCallId;
            StringBuilder sbV = a8.b.v("InvokeRequest(id=", str, ", nodeId=", str2, ", command=");
            a8.b.A(sbV, str3, ", paramsJson=", str4, ", timeoutMs=");
            sbV.append(l3);
            sbV.append(", toolCallId=");
            sbV.append(str5);
            sbV.append(")");
            return sbV.toString();
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$InvokeResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_OK, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "payloadJson", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "error", "Lcom/stepos/stepclaw/gateway/GatewaySession$ErrorShape;", "<init>", "(ZLjava/lang/String;Lcom/stepos/stepclaw/gateway/GatewaySession$ErrorShape;)V", "getOk", "()Z", "getPayloadJson", "()Ljava/lang/String;", "getError", "()Lcom/stepos/stepclaw/gateway/GatewaySession$ErrorShape;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InvokeResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ErrorShape error;
        private final boolean ok;
        private final String payloadJson;

        /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$InvokeResult$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", ConfigIpcContract.KEY_OK, "Lcom/stepos/stepclaw/gateway/GatewaySession$InvokeResult;", "payloadJson", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "error", "code", OperationResult.EXTRA_MESSAGE, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(i iVar) {
                this();
            }

            public final InvokeResult error(String code, String message) {
                kotlin.jvm.internal.p.e(code, "code");
                kotlin.jvm.internal.p.e(message, "message");
                return new InvokeResult(false, null, new ErrorShape(code, message));
            }

            public final InvokeResult ok(String payloadJson) {
                return new InvokeResult(true, payloadJson, null);
            }

            private Companion() {
            }
        }

        public InvokeResult(boolean z, String str, ErrorShape errorShape) {
            this.ok = z;
            this.payloadJson = str;
            this.error = errorShape;
        }

        public static /* synthetic */ InvokeResult copy$default(InvokeResult invokeResult, boolean z, String str, ErrorShape errorShape, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                z = invokeResult.ok;
            }
            if ((i8 & 2) != 0) {
                str = invokeResult.payloadJson;
            }
            if ((i8 & 4) != 0) {
                errorShape = invokeResult.error;
            }
            return invokeResult.copy(z, str, errorShape);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getOk() {
            return this.ok;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPayloadJson() {
            return this.payloadJson;
        }

        /* renamed from: component3, reason: from getter */
        public final ErrorShape getError() {
            return this.error;
        }

        public final InvokeResult copy(boolean ok, String payloadJson, ErrorShape error) {
            return new InvokeResult(ok, payloadJson, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvokeResult)) {
                return false;
            }
            InvokeResult invokeResult = (InvokeResult) other;
            return this.ok == invokeResult.ok && kotlin.jvm.internal.p.a(this.payloadJson, invokeResult.payloadJson) && kotlin.jvm.internal.p.a(this.error, invokeResult.error);
        }

        public final ErrorShape getError() {
            return this.error;
        }

        public final boolean getOk() {
            return this.ok;
        }

        public final String getPayloadJson() {
            return this.payloadJson;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.ok) * 31;
            String str = this.payloadJson;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            ErrorShape errorShape = this.error;
            return iHashCode2 + (errorShape != null ? errorShape.hashCode() : 0);
        }

        public String toString() {
            return "InvokeResult(ok=" + this.ok + ", payloadJson=" + this.payloadJson + ", error=" + this.error + ")";
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$PingIntervalTracker;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lb5/a0;", "onUserActivity", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "intervalSeconds", "()J", "lastActivityTime", "J", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PingIntervalTracker {
        private static final long ACTIVE_INTERVAL_SECONDS = 10;
        private static final long IDLE_THRESHOLD_MS = 300000;
        private static final long INACTIVE_INTERVAL_SECONDS = 30;
        private volatile long lastActivityTime = System.currentTimeMillis();

        public final long intervalSeconds() {
            return System.currentTimeMillis() - this.lastActivityTime > IDLE_THRESHOLD_MS ? 30L : 10L;
        }

        public final void onUserActivity() {
            this.lastActivityTime = System.currentTimeMillis();
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$RpcResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_OK, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "payloadJson", "error", "Lcom/stepos/stepclaw/gateway/GatewaySession$ErrorShape;", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lcom/stepos/stepclaw/gateway/GatewaySession$ErrorShape;)V", "getId", "()Ljava/lang/String;", "getOk", "()Z", "getPayloadJson", "getError", "()Lcom/stepos/stepclaw/gateway/GatewaySession$ErrorShape;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RpcResponse {
        private final ErrorShape error;
        private final String id;
        private final boolean ok;
        private final String payloadJson;

        public RpcResponse(String id, boolean z, String str, ErrorShape errorShape) {
            kotlin.jvm.internal.p.e(id, "id");
            this.id = id;
            this.ok = z;
            this.payloadJson = str;
            this.error = errorShape;
        }

        public static /* synthetic */ RpcResponse copy$default(RpcResponse rpcResponse, String str, boolean z, String str2, ErrorShape errorShape, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = rpcResponse.id;
            }
            if ((i8 & 2) != 0) {
                z = rpcResponse.ok;
            }
            if ((i8 & 4) != 0) {
                str2 = rpcResponse.payloadJson;
            }
            if ((i8 & 8) != 0) {
                errorShape = rpcResponse.error;
            }
            return rpcResponse.copy(str, z, str2, errorShape);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getOk() {
            return this.ok;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPayloadJson() {
            return this.payloadJson;
        }

        /* renamed from: component4, reason: from getter */
        public final ErrorShape getError() {
            return this.error;
        }

        public final RpcResponse copy(String id, boolean ok, String payloadJson, ErrorShape error) {
            kotlin.jvm.internal.p.e(id, "id");
            return new RpcResponse(id, ok, payloadJson, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RpcResponse)) {
                return false;
            }
            RpcResponse rpcResponse = (RpcResponse) other;
            return kotlin.jvm.internal.p.a(this.id, rpcResponse.id) && this.ok == rpcResponse.ok && kotlin.jvm.internal.p.a(this.payloadJson, rpcResponse.payloadJson) && kotlin.jvm.internal.p.a(this.error, rpcResponse.error);
        }

        public final ErrorShape getError() {
            return this.error;
        }

        public final String getId() {
            return this.id;
        }

        public final boolean getOk() {
            return this.ok;
        }

        public final String getPayloadJson() {
            return this.payloadJson;
        }

        public int hashCode() {
            int iG = a8.b.g(this.id.hashCode() * 31, 31, this.ok);
            String str = this.payloadJson;
            int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
            ErrorShape errorShape = this.error;
            return iHashCode + (errorShape != null ? errorShape.hashCode() : 0);
        }

        public String toString() {
            return "RpcResponse(id=" + this.id + ", ok=" + this.ok + ", payloadJson=" + this.payloadJson + ", error=" + this.error + ")";
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession$connect$1", f = "GatewaySession.kt", l = {177}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.gateway.GatewaySession$connect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.i implements p {
        int label;

        public AnonymousClass1(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return GatewaySession.this.new AnonymousClass1(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass1) create(f0Var, cVar)).invokeSuspend(b5.a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                GatewaySession gatewaySession = GatewaySession.this;
                this.label = 1;
                if (gatewaySession.runLoop(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
            }
            return b5.a0.f883a;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession$connectOnce$2", f = "GatewaySession.kt", l = {868, 869}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.gateway.GatewaySession$connectOnce$2, reason: invalid class name */
    public static final class AnonymousClass2 extends h5.i implements p {
        final /* synthetic */ DesiredConnection $target;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DesiredConnection desiredConnection, f5.c cVar) {
            super(2, cVar);
            this.$target = desiredConnection;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return GatewaySession.this.new AnonymousClass2(this.$target, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(b5.a0.f883a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        
            if (r1.awaitClose(r13) == r0) goto L23;
         */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                g5.a r0 = g5.a.f2984a
                int r1 = r13.label
                r2 = 0
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L29
                if (r1 == r4) goto L21
                if (r1 != r3) goto L19
                java.lang.Object r0 = r13.L$0
                com.stepos.stepclaw.gateway.GatewaySession$Connection r0 = (com.stepos.stepclaw.gateway.GatewaySession.Connection) r0
                a.a.c0(r14)     // Catch: java.lang.Throwable -> L16
                goto L6d
            L16:
                r0 = move-exception
                r14 = r0
                goto L84
            L19:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L21:
                java.lang.Object r1 = r13.L$0
                com.stepos.stepclaw.gateway.GatewaySession$Connection r1 = (com.stepos.stepclaw.gateway.GatewaySession.Connection) r1
                a.a.c0(r14)     // Catch: java.lang.Throwable -> L16
                goto L62
            L29:
                a.a.c0(r14)
                com.stepos.stepclaw.gateway.GatewaySession$Connection r6 = new com.stepos.stepclaw.gateway.GatewaySession$Connection
                com.stepos.stepclaw.gateway.GatewaySession r7 = com.stepos.stepclaw.gateway.GatewaySession.this
                com.stepos.stepclaw.gateway.GatewaySession$DesiredConnection r14 = r13.$target
                com.stepos.stepclaw.gateway.GatewayEndpoint r8 = r14.getEndpoint()
                com.stepos.stepclaw.gateway.GatewaySession$DesiredConnection r14 = r13.$target
                java.lang.String r9 = r14.getToken()
                com.stepos.stepclaw.gateway.GatewaySession$DesiredConnection r14 = r13.$target
                java.lang.String r10 = r14.getPassword()
                com.stepos.stepclaw.gateway.GatewaySession$DesiredConnection r14 = r13.$target
                com.stepos.stepclaw.gateway.GatewayConnectOptions r11 = r14.getOptions()
                com.stepos.stepclaw.gateway.GatewaySession$DesiredConnection r14 = r13.$target
                com.stepos.stepclaw.gateway.GatewayTlsParams r12 = r14.getTls()
                r6.<init>(r7, r8, r9, r10, r11, r12)
                com.stepos.stepclaw.gateway.GatewaySession r14 = com.stepos.stepclaw.gateway.GatewaySession.this
                com.stepos.stepclaw.gateway.GatewaySession.access$setCurrentConnection$p(r14, r6)
                r13.L$0 = r6     // Catch: java.lang.Throwable -> L16
                r13.label = r4     // Catch: java.lang.Throwable -> L16
                java.lang.Object r14 = r6.connect(r13)     // Catch: java.lang.Throwable -> L16
                if (r14 != r0) goto L61
                goto L6c
            L61:
                r1 = r6
            L62:
                r13.L$0 = r5     // Catch: java.lang.Throwable -> L16
                r13.label = r3     // Catch: java.lang.Throwable -> L16
                java.lang.Object r14 = r1.awaitClose(r13)     // Catch: java.lang.Throwable -> L16
                if (r14 != r0) goto L6d
            L6c:
                return r0
            L6d:
                com.stepos.stepclaw.gateway.GatewaySession r14 = com.stepos.stepclaw.gateway.GatewaySession.this
                com.stepos.stepclaw.gateway.GatewaySession.access$setSessionOnline$p(r14, r2)
                com.stepos.stepclaw.gateway.GatewaySession r14 = com.stepos.stepclaw.gateway.GatewaySession.this
                com.stepos.stepclaw.gateway.GatewaySession.access$setCurrentConnection$p(r14, r5)
                com.stepos.stepclaw.gateway.GatewaySession r14 = com.stepos.stepclaw.gateway.GatewaySession.this
                com.stepos.stepclaw.gateway.GatewaySession.access$setCanvasHostUrl$p(r14, r5)
                com.stepos.stepclaw.gateway.GatewaySession r13 = com.stepos.stepclaw.gateway.GatewaySession.this
                com.stepos.stepclaw.gateway.GatewaySession.access$setMainSessionKey$p(r13, r5)
                b5.a0 r13 = b5.a0.f883a
                return r13
            L84:
                com.stepos.stepclaw.gateway.GatewaySession r0 = com.stepos.stepclaw.gateway.GatewaySession.this
                com.stepos.stepclaw.gateway.GatewaySession.access$setSessionOnline$p(r0, r2)
                com.stepos.stepclaw.gateway.GatewaySession r0 = com.stepos.stepclaw.gateway.GatewaySession.this
                com.stepos.stepclaw.gateway.GatewaySession.access$setCurrentConnection$p(r0, r5)
                com.stepos.stepclaw.gateway.GatewaySession r0 = com.stepos.stepclaw.gateway.GatewaySession.this
                com.stepos.stepclaw.gateway.GatewaySession.access$setCanvasHostUrl$p(r0, r5)
                com.stepos.stepclaw.gateway.GatewaySession r13 = com.stepos.stepclaw.gateway.GatewaySession.this
                com.stepos.stepclaw.gateway.GatewaySession.access$setMainSessionKey$p(r13, r5)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession$disconnect$1", f = "GatewaySession.kt", l = {185}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.gateway.GatewaySession$disconnect$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00261 extends h5.i implements p {
        int label;

        public C00261(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return GatewaySession.this.new C00261(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00261) create(f0Var, cVar)).invokeSuspend(b5.a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            b5.a0 a0Var = b5.a0.f883a;
            if (i8 == 0) {
                a.a.c0(obj);
                h1 h1Var = GatewaySession.this.job;
                if (h1Var != null) {
                    this.label = 1;
                    h1Var.e(null);
                    Object objJ = h1Var.j(this);
                    if (objJ != aVar) {
                        objJ = a0Var;
                    }
                    if (objJ == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
            }
            GatewaySession.this.job = null;
            GatewaySession.this.canvasHostUrl = null;
            GatewaySession.this.mainSessionKey = null;
            GatewaySession.this.onDisconnected.invoke("Offline");
            return a0Var;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession", f = "GatewaySession.kt", l = {232}, m = "refreshNodeCanvasCapability", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.gateway.GatewaySession$refreshNodeCanvasCapability$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00271 extends h5.c {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C00271(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewaySession.this.refreshNodeCanvasCapability(0L, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession", f = "GatewaySession.kt", l = {222}, m = "request", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.gateway.GatewaySession$request$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00281 extends h5.c {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C00281(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewaySession.this.request(null, null, 0L, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession", f = "GatewaySession.kt", l = {768, 784, 792, 797, 853}, m = "runLoop", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.gateway.GatewaySession$runLoop$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00291 extends h5.c {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C00291(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewaySession.this.runLoop(this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession$runLoop$2", f = "GatewaySession.kt", l = {784}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.gateway.GatewaySession$runLoop$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00302 extends h5.i implements p {
        int label;

        public C00302(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return GatewaySession.this.new C00302(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00302) create(f0Var, cVar)).invokeSuspend(b5.a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                g gVar = GatewaySession.this.reconnectSignal;
                this.label = 1;
                if (gVar.c(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
            }
            return b5.a0.f883a;
        }
    }

    public GatewaySession(f0 scope, DeviceIdentityStore identityStore, DeviceAuthTokenStore deviceAuthStore, q onConnected, l onDisconnected, p pVar, p pVar2, p pVar3, p5.a aVar) {
        kotlin.jvm.internal.p.e(scope, "scope");
        kotlin.jvm.internal.p.e(identityStore, "identityStore");
        kotlin.jvm.internal.p.e(deviceAuthStore, "deviceAuthStore");
        kotlin.jvm.internal.p.e(onConnected, "onConnected");
        kotlin.jvm.internal.p.e(onDisconnected, "onDisconnected");
        this.scope = scope;
        this.identityStore = identityStore;
        this.deviceAuthStore = deviceAuthStore;
        this.onConnected = onConnected;
        this.onDisconnected = onDisconnected;
        this.onEvent = pVar;
        this.onInvoke = pVar2;
        this.onTlsFingerprint = pVar3;
        this.onPersistentConnectFailure = aVar;
        this.json = JsonKt.Json$default(null, new d(2), 1, null);
        this.writeLock = new i6.c();
        this.pending = new ConcurrentHashMap<>();
        this.pingTracker = new PingIntervalTracker();
        this.reconnectSignal = j.a(-1, null, 6);
    }

    private final String buildCanvasUrl(String host, String scheme, int port, String suffix) {
        String lowerCase = scheme.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        if (n.g1(host, ":", false)) {
            host = m0.f.d("[", host, "]");
        }
        return lowerCase + "://" + host + (((lowerCase.equals("https") && port == 443) || (lowerCase.equals("http") && port == 80)) ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : a8.b.j(port, ":")) + suffix;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String buildUrlSuffix(java.net.URI r5) {
        /*
            r4 = this;
            java.lang.String r4 = ""
            if (r5 != 0) goto L5
            return r4
        L5:
            java.lang.String r0 = r5.getRawPath()
            r1 = 0
            if (r0 == 0) goto L16
            boolean r2 = x5.n.t1(r0)
            if (r2 != 0) goto L13
            goto L14
        L13:
            r0 = r1
        L14:
            if (r0 != 0) goto L17
        L16:
            r0 = r4
        L17:
            java.lang.String r2 = r5.getRawQuery()
            if (r2 == 0) goto L2f
            boolean r3 = x5.n.t1(r2)
            if (r3 != 0) goto L24
            goto L25
        L24:
            r2 = r1
        L25:
            if (r2 == 0) goto L2f
            java.lang.String r3 = "?"
            java.lang.String r2 = r3.concat(r2)
            if (r2 != 0) goto L30
        L2f:
            r2 = r4
        L30:
            java.lang.String r5 = r5.getRawFragment()
            if (r5 == 0) goto L49
            boolean r3 = x5.n.t1(r5)
            if (r3 != 0) goto L3d
            r1 = r5
        L3d:
            if (r1 == 0) goto L49
            java.lang.String r5 = "#"
            java.lang.String r5 = r5.concat(r1)
            if (r5 != 0) goto L48
            goto L49
        L48:
            r4 = r5
        L49:
            java.lang.String r4 = a8.b.o(r0, r2, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.buildUrlSuffix(java.net.URI):java.lang.String");
    }

    public static /* synthetic */ void connect$default(GatewaySession gatewaySession, GatewayEndpoint gatewayEndpoint, String str, String str2, GatewayConnectOptions gatewayConnectOptions, GatewayTlsParams gatewayTlsParams, int i8, Object obj) {
        if ((i8 & 16) != 0) {
            gatewayTlsParams = null;
        }
        gatewaySession.connect(gatewayEndpoint, str, str2, gatewayConnectOptions, gatewayTlsParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object connectOnce(DesiredConnection desiredConnection, f5.c cVar) {
        h6.e eVar = r0.f210a;
        Object objA = i0.A(h6.d.f3059c, new AnonymousClass2(desiredConnection, null), cVar);
        return objA == g5.a.f2984a ? objA : b5.a0.f883a;
    }

    private final boolean isLoopbackHost(String raw) {
        String lowerCase;
        String string;
        if (raw == null || (string = n.T1(raw).toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase == null) {
            lowerCase = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (lowerCase.length() == 0) {
            return false;
        }
        if (lowerCase.equals("localhost") || lowerCase.equals("::1") || lowerCase.equals("0.0.0.0") || lowerCase.equals("::")) {
            return true;
        }
        return x5.u.c1(lowerCase, "127.", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b5.a0 json$lambda$0(JsonBuilder Json) {
        kotlin.jvm.internal.p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        return b5.a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeCanvasHostUrl(String raw, GatewayEndpoint endpoint, boolean isTlsConnection) {
        Object objO;
        URI uri;
        Integer canvasPort;
        String scheme;
        String host;
        String string = raw != null ? n.T1(raw).toString() : null;
        String str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (string == null) {
            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        String str2 = !n.t1(string) ? string : null;
        if (str2 != null) {
            try {
                objO = new URI(str2);
            } catch (Throwable th) {
                objO = a.a.o(th);
            }
            if (objO instanceof b5.h) {
                objO = null;
            }
            uri = (URI) objO;
        } else {
            uri = null;
        }
        String string2 = (uri == null || (host = uri.getHost()) == null) ? null : n.T1(host).toString();
        if (string2 == null) {
            string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        int port = uri != null ? uri.getPort() : -1;
        String string3 = (uri == null || (scheme = uri.getScheme()) == null) ? null : n.T1(scheme).toString();
        if (string3 != null) {
            str = string3;
        }
        if (n.t1(str)) {
            str = "http";
        }
        String strBuildUrlSuffix = buildUrlSuffix(uri);
        if (!n.t1(string) && !n.t1(string2) && !isLoopbackHost(string2)) {
            return (!isTlsConnection || (str.equalsIgnoreCase("https") && ((port <= 0 || port == endpoint.getPort()) && (port > 0 || endpoint.getPort() == 443)))) ? string : buildCanvasUrl(string2, "https", endpoint.getPort(), strBuildUrlSuffix);
        }
        String tailnetDns = endpoint.getTailnetDns();
        String string4 = tailnetDns != null ? n.T1(tailnetDns).toString() : null;
        if (string4 == null || string4.length() == 0) {
            string4 = null;
        }
        if (string4 == null) {
            String lanHost = endpoint.getLanHost();
            string4 = lanHost != null ? n.T1(lanHost).toString() : null;
            if (string4 == null || string4.length() == 0) {
                string4 = null;
            }
            if (string4 == null) {
                string4 = n.T1(endpoint.getHost()).toString();
            }
        }
        if (string4.length() == 0) {
            if (n.t1(string)) {
                return null;
            }
            return string;
        }
        if (isTlsConnection) {
            str = "https";
        }
        return buildCanvasUrl(string4, str, (isTlsConnection || (canvasPort = endpoint.getCanvasPort()) == null) ? endpoint.getPort() : canvasPort.intValue(), strBuildUrlSuffix);
    }

    public static /* synthetic */ Object refreshNodeCanvasCapability$default(GatewaySession gatewaySession, long j4, f5.c cVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j4 = 8000;
        }
        return gatewaySession.refreshNodeCanvasCapability(j4, cVar);
    }

    public static /* synthetic */ Object request$default(GatewaySession gatewaySession, String str, String str2, long j4, f5.c cVar, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            j4 = GatewayReconnectDiagnostics.AUTO_START_COOLDOWN_MS;
        }
        return gatewaySession.request(str, str2, j4, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x025f, code lost:
    
        if (r0 == r3) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bc, code lost:
    
        if (r4 < 15) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00be, code lost:
    
        android.util.Log.w("OpenClawGateway", "Maximum retry count (15) reached. Suspending retries (fallback retry every 1800000ms) until manual reconnect / network recovery.");
        r20.onDisconnected.invoke("Offline: maximum retries reached");
        r12 = r12;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d2, code lost:
    
        if ((r20.reconnectSignal.i() instanceof c6.i) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d5, code lost:
    
        r0 = new com.stepos.stepclaw.gateway.GatewaySession.C00302(r20, r13);
        r2.L$0 = r13;
        r2.L$1 = r13;
        r2.I$0 = r4;
        r2.label = r8;
        r12 = r12;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e9, code lost:
    
        if (a6.i0.C(com.stepos.stepclaw.gateway.GatewaySession.OFFLINE_FALLBACK_RETRY_MS, r0, r2) != r3) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ed, code lost:
    
        r14 = com.stepos.stepclaw.gateway.GatewaySession.Companion.takeFirstConnectDelay();
        r12 = r12;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f7, code lost:
    
        if (r14 <= 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f9, code lost:
    
        r20.onDisconnected.invoke("Connecting…");
        r2.L$0 = r9;
        r2.L$1 = r13;
        r2.I$0 = r4;
        r2.J$0 = r14;
        r2.label = r7;
        r12 = r12;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010c, code lost:
    
        if (a6.i0.g(r14, r2) != r3) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x012b, code lost:
    
        if (connectOnce(r9, r2) == r3) goto L101;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:70:0x015f, B:85:0x01cc], limit reached: 115 */
    /* JADX WARN: Path cross not found for [B:87:0x01f9, B:82:0x01c5], limit reached: 115 */
    /* JADX WARN: Removed duplicated region for block: B:107:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0272 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0248  */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v6, types: [com.stepos.stepclaw.gateway.GatewaySession$Connection, f5.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x025f -> B:102:0x0262). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0082 -> B:28:0x0083). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0135 -> B:28:0x0083). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x0244 -> B:105:0x0267). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runLoop(f5.c r21) {
        /*
            Method dump skipped, instructions count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.runLoop(f5.c):java.lang.Object");
    }

    public final void connect(GatewayEndpoint endpoint, String token, String password, GatewayConnectOptions options, GatewayTlsParams tls) {
        kotlin.jvm.internal.p.e(endpoint, "endpoint");
        kotlin.jvm.internal.p.e(options, "options");
        this.desired = new DesiredConnection(endpoint, token, password, options, tls);
        if (this.job == null) {
            f0 f0Var = this.scope;
            h6.e eVar = r0.f210a;
            this.job = i0.q(f0Var, h6.d.f3059c, new AnonymousClass1(null), 2);
        }
    }

    /* renamed from: currentCanvasHostUrl, reason: from getter */
    public final String getCanvasHostUrl() {
        return this.canvasHostUrl;
    }

    /* renamed from: currentMainSessionKey, reason: from getter */
    public final String getMainSessionKey() {
        return this.mainSessionKey;
    }

    public final void disconnect() {
        this.desired = null;
        Connection connection = this.currentConnection;
        if (connection != null) {
            connection.closeQuietly();
        }
        f0 f0Var = this.scope;
        h6.e eVar = r0.f210a;
        i0.q(f0Var, h6.d.f3059c, new C00261(null), 2);
    }

    public final void reconnect() {
        this.sessionOnline = false;
        Connection connection = this.currentConnection;
        if (connection != null) {
            connection.closeQuietly();
        }
        this.reconnectSignal.k(b5.a0.f883a);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshNodeCanvasCapability(long r10, f5.c r12) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.refreshNodeCanvasCapability(long, f5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object request(java.lang.String r6, java.lang.String r7, long r8, f5.c r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof com.stepos.stepclaw.gateway.GatewaySession.C00281
            if (r0 == 0) goto L14
            r0 = r10
            com.stepos.stepclaw.gateway.GatewaySession$request$1 r0 = (com.stepos.stepclaw.gateway.GatewaySession.C00281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r10 = r0
            goto L1a
        L14:
            com.stepos.stepclaw.gateway.GatewaySession$request$1 r0 = new com.stepos.stepclaw.gateway.GatewaySession$request$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r0 = r10.result
            g5.a r1 = g5.a.f2984a
            int r2 = r10.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r5 = r10.L$3
            kotlinx.serialization.json.JsonElement r5 = (kotlinx.serialization.json.JsonElement) r5
            java.lang.Object r5 = r10.L$2
            com.stepos.stepclaw.gateway.GatewaySession$Connection r5 = (com.stepos.stepclaw.gateway.GatewaySession.Connection) r5
            java.lang.Object r5 = r10.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r10.L$0
            java.lang.String r5 = (java.lang.String) r5
            a.a.c0(r0)
            goto L6e
        L39:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L41:
            a.a.c0(r0)
            r0 = r5
            com.stepos.stepclaw.gateway.GatewaySession$Connection r5 = r0.currentConnection
            if (r5 == 0) goto La3
            r2 = 0
            if (r7 == 0) goto L5a
            boolean r4 = x5.n.t1(r7)
            if (r4 == 0) goto L53
            goto L5a
        L53:
            kotlinx.serialization.json.Json r0 = r0.json
            kotlinx.serialization.json.JsonElement r7 = r0.parseToJsonElement(r7)
            goto L5b
        L5a:
            r7 = r2
        L5b:
            r10.L$0 = r2
            r10.L$1 = r2
            r10.L$2 = r2
            r10.L$3 = r2
            r10.J$0 = r8
            r10.label = r3
            java.lang.Object r0 = r5.request(r6, r7, r8, r10)
            if (r0 != r1) goto L6e
            return r1
        L6e:
            com.stepos.stepclaw.gateway.GatewaySession$RpcResponse r0 = (com.stepos.stepclaw.gateway.GatewaySession.RpcResponse) r0
            boolean r5 = r0.getOk()
            if (r5 == 0) goto L7f
            java.lang.String r5 = r0.getPayloadJson()
            if (r5 != 0) goto L7e
            java.lang.String r5 = ""
        L7e:
            return r5
        L7f:
            com.stepos.stepclaw.gateway.GatewaySession$ErrorShape r5 = r0.getError()
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            if (r5 == 0) goto L8d
            java.lang.String r7 = r5.getCode()
            if (r7 != 0) goto L8f
        L8d:
            java.lang.String r7 = "UNAVAILABLE"
        L8f:
            if (r5 == 0) goto L97
            java.lang.String r5 = r5.getMessage()
            if (r5 != 0) goto L99
        L97:
            java.lang.String r5 = "request failed"
        L99:
            java.lang.String r8 = ": "
            java.lang.String r5 = a8.b.o(r7, r8, r5)
            r6.<init>(r5)
            throw r6
        La3:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "not connected"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession.request(java.lang.String, java.lang.String, long, f5.c):java.lang.Object");
    }

    public final void wakeIfNotOnline() {
        if (this.sessionOnline) {
            return;
        }
        this.reconnectSignal.k(b5.a0.f883a);
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewaySession$PendingEntry;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "La6/r;", "Lcom/stepos/stepclaw/gateway/GatewaySession$RpcResponse;", "deferred", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "createdAt", "<init>", "(La6/r;J)V", "component1", "()La6/r;", "component2", "()J", "copy", "(La6/r;J)Lcom/stepos/stepclaw/gateway/GatewaySession$PendingEntry;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "()Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "La6/r;", "getDeferred", "J", "getCreatedAt", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PendingEntry {
        private final long createdAt;
        private final r deferred;

        public PendingEntry(r deferred, long j4) {
            kotlin.jvm.internal.p.e(deferred, "deferred");
            this.deferred = deferred;
            this.createdAt = j4;
        }

        public static /* synthetic */ PendingEntry copy$default(PendingEntry pendingEntry, r rVar, long j4, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                rVar = pendingEntry.deferred;
            }
            if ((i8 & 2) != 0) {
                j4 = pendingEntry.createdAt;
            }
            return pendingEntry.copy(rVar, j4);
        }

        /* renamed from: component1, reason: from getter */
        public final r getDeferred() {
            return this.deferred;
        }

        /* renamed from: component2, reason: from getter */
        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final PendingEntry copy(r deferred, long createdAt) {
            kotlin.jvm.internal.p.e(deferred, "deferred");
            return new PendingEntry(deferred, createdAt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingEntry)) {
                return false;
            }
            PendingEntry pendingEntry = (PendingEntry) other;
            return kotlin.jvm.internal.p.a(this.deferred, pendingEntry.deferred) && this.createdAt == pendingEntry.createdAt;
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final r getDeferred() {
            return this.deferred;
        }

        public int hashCode() {
            return Long.hashCode(this.createdAt) + (this.deferred.hashCode() * 31);
        }

        public String toString() {
            return "PendingEntry(deferred=" + this.deferred + ", createdAt=" + this.createdAt + ")";
        }

        public /* synthetic */ PendingEntry(r rVar, long j4, int i8, i iVar) {
            this(rVar, (i8 & 2) != 0 ? System.currentTimeMillis() : j4);
        }
    }

    public /* synthetic */ GatewaySession(f0 f0Var, DeviceIdentityStore deviceIdentityStore, DeviceAuthTokenStore deviceAuthTokenStore, q qVar, l lVar, p pVar, p pVar2, p pVar3, p5.a aVar, int i8, i iVar) {
        this(f0Var, deviceIdentityStore, deviceAuthTokenStore, qVar, lVar, (i8 & 32) != 0 ? null : pVar, (i8 & 64) != 0 ? null : pVar2, (i8 & 128) != 0 ? null : pVar3, (i8 & 256) != 0 ? null : aVar);
    }
}
