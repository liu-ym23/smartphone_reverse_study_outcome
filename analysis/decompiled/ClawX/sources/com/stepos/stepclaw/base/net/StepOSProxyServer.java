package com.stepos.stepclaw.base.net;

import a6.f0;
import a6.h1;
import a6.i0;
import a6.r0;
import a6.v1;
import a6.w;
import a6.z;
import b5.a0;
import c5.m;
import c5.n;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.net.StepNet;
import com.stepos.stepclaw.base.net.StepOSProxyServer;
import com.stepos.stepclaw.base.net.bean.StepOSHeaders;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.base.util.StepAccount;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.gateway.GatewayReconnectDiagnostics;
import com.stepos.stepclaw.provider.contract.OperationResult;
import h6.d;
import i6.e;
import i6.j;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import m0.f;
import org.tukaani.xz.common.Util;
import p5.l;
import p5.p;
import t3.c;
import x3.g;
import x5.u;
import z3.t0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 R2\u00020\u0001:\u0001RB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0082@¢\u0006\u0004\b\u0019\u0010\u0013J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJJ\u0010(\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0082@¢\u0006\u0004\b(\u0010)J'\u0010,\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010.R$\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020I0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006S"}, d2 = {"Lcom/stepos/stepclaw/base/net/StepOSProxyServer;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_PORT, "<init>", "(I)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_BASE_URL, "Lb5/a0;", "updateBaseUrl", "(Ljava/lang/String;)V", "applyNetEnvBaseUrl", "()V", "La6/f0;", "scope", "start", "(La6/f0;)V", "stop", "drain", "(Lf5/c;)Ljava/lang/Object;", "traceIdFromRequest", "Lcom/stepos/stepclaw/base/net/bean/StepOSHeaders;", "resolveHeaders", "(Ljava/lang/String;)Lcom/stepos/stepclaw/base/net/bean/StepOSHeaders;", "Ljava/net/ServerSocket;", "bindWithRetry", "Ljava/net/Socket;", "client", "handleClient", "(Ljava/net/Socket;Lf5/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/p;", "channel", "Ljava/io/OutputStream;", "outputStream", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "flushPerChunk", "clientId", "upstreamContentType", "Lcom/stepos/stepclaw/base/net/ProxyDiagnostics;", "diagnostics", "pipeChunked", "(Lio/ktor/utils/io/p;Ljava/io/OutputStream;ZLjava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/base/net/ProxyDiagnostics;Lf5/c;)Ljava/lang/Object;", "status", OperationResult.EXTRA_MESSAGE, "sendErrorResponse", "(Ljava/io/OutputStream;ILjava/lang/String;)V", "I", "value", "targetBaseUrl", "Ljava/lang/String;", "getTargetBaseUrl", "()Ljava/lang/String;", "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "headersProvider", "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "getHeadersProvider", "()Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "setHeadersProvider", "(Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;)V", "enablePromptCache", "Z", "getEnablePromptCache", "()Z", "setEnablePromptCache", "(Z)V", "logBffUpstreamUsage", "getLogBffUpstreamUsage", "setLogBffUpstreamUsage", "Lt3/c;", "httpClient", "Lt3/c;", "serverSocket", "Ljava/net/ServerSocket;", "La6/h1;", "serverJob", "La6/h1;", "Li6/e;", "connectionSemaphore", "Li6/e;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "activeJobs", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Companion", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StepOSProxyServer {
    private static final long BIND_RETRY_INITIAL_DELAY_MS = 200;
    private static final int BIND_RETRY_MAX = 10;
    private static final long BIND_RETRY_MAX_DELAY_MS = 2000;
    private static final int CHUNK_BUFFER_SIZE = 8192;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_PORT = 18791;
    private static final int MAX_BODY_BYTES = 10485760;
    private static final int MAX_CONCURRENT_CONNECTIONS = 64;
    public static final String PROD_BASE_URL = "https://biz-gw.stepos.com/model-proxy";
    private static final String TAG = "StepOSProxyServer";
    public static final String TEST_BASE_URL = "https://biz-gw.t-stepos.com/model-proxy/";
    private static volatile StepOSProxyServer instance;
    private final CopyOnWriteArrayList<h1> activeJobs;
    private final e connectionSemaphore;
    private volatile boolean enablePromptCache;
    private StepOSHeadersProvider headersProvider;
    private final c httpClient;
    private volatile boolean logBffUpstreamUsage;
    private final int port;
    private h1 serverJob;
    private ServerSocket serverSocket;
    private volatile String targetBaseUrl;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stepos/stepclaw/base/net/StepOSProxyServer$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "DEFAULT_PORT", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "TEST_BASE_URL", "PROD_BASE_URL", "MAX_BODY_BYTES", "MAX_CONCURRENT_CONNECTIONS", "CHUNK_BUFFER_SIZE", "BIND_RETRY_MAX", "BIND_RETRY_INITIAL_DELAY_MS", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "BIND_RETRY_MAX_DELAY_MS", "instance", "Lcom/stepos/stepclaw/base/net/StepOSProxyServer;", "getOrCreate", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final StepOSProxyServer getOrCreate() {
            StepOSProxyServer stepOSProxyServer;
            synchronized (this) {
                stepOSProxyServer = StepOSProxyServer.instance;
                if (stepOSProxyServer == null) {
                    stepOSProxyServer = new StepOSProxyServer(0, 1, null);
                    StepOSProxyServer.instance = stepOSProxyServer;
                }
            }
            return stepOSProxyServer;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StepNet.NetEnv.values().length];
            try {
                iArr[StepNet.NetEnv.DEV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StepNet.NetEnv.TEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StepNet.NetEnv.STG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StepNet.NetEnv.PROD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.base.net.StepOSProxyServer", f = "StepOSProxyServer.kt", l = {237}, m = "bindWithRetry", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.base.net.StepOSProxyServer$bindWithRetry$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int I$0;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StepOSProxyServer.this.bindWithRetry(this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.base.net.StepOSProxyServer", f = "StepOSProxyServer.kt", l = {560, 404, 405}, m = "handleClient", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.base.net.StepOSProxyServer$handleClient$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00051 extends h5.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C00051(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StepOSProxyServer.this.handleClient(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.base.net.StepOSProxyServer", f = "StepOSProxyServer.kt", l = {457, 475}, m = "pipeChunked", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.base.net.StepOSProxyServer$pipeChunked$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00061 extends h5.c {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C00061(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StepOSProxyServer.this.pipeChunked(null, null, false, null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.base.net.StepOSProxyServer$start$1", f = "StepOSProxyServer.kt", l = {189}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.base.net.StepOSProxyServer$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00071 extends h5.i implements p {
        private /* synthetic */ Object L$0;
        int label;

        public C00071(f5.c cVar) {
            super(2, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final a0 invokeSuspend$lambda$1(StepOSProxyServer stepOSProxyServer, h1 h1Var, Throwable th) {
            stepOSProxyServer.activeJobs.remove(h1Var);
            return a0.f883a;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            C00071 c00071 = StepOSProxyServer.this.new C00071(cVar);
            c00071.L$0 = obj;
            return c00071;
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00071) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws IOException {
            ServerSocket serverSocket;
            f0 f0Var = (f0) this.L$0;
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            a0 a0Var = a0.f883a;
            try {
                if (i8 == 0) {
                    a.a.c0(obj);
                    StepOSProxyServer.this.applyNetEnvBaseUrl();
                    StepOSProxyServer stepOSProxyServer = StepOSProxyServer.this;
                    this.L$0 = f0Var;
                    this.label = 1;
                    obj = stepOSProxyServer.bindWithRetry(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                }
                serverSocket = (ServerSocket) obj;
            } catch (Exception e9) {
                ALog.e(StepOSProxyServer.TAG, "Failed to start SSE proxy server: " + e9.getMessage(), e9);
            }
            if (serverSocket == null) {
                ALog.e$default(StepOSProxyServer.TAG, "Failed to bind port " + StepOSProxyServer.this.port + " after 10 retries — giving up", null, 4, null);
                return a0Var;
            }
            StepOSProxyServer.this.serverSocket = serverSocket;
            ALog.i$default(StepOSProxyServer.TAG, "Chunked SSE proxy started on port " + StepOSProxyServer.this.port + ".", null, 4, null);
            while (!serverSocket.isClosed()) {
                try {
                    Socket socketAccept = serverSocket.accept();
                    h6.e eVar = r0.f210a;
                    final v1 v1VarQ = i0.q(f0Var, d.f3059c, new StepOSProxyServer$start$1$job$1(StepOSProxyServer.this, socketAccept, null), 2);
                    StepOSProxyServer.this.activeJobs.add(v1VarQ);
                    final StepOSProxyServer stepOSProxyServer2 = StepOSProxyServer.this;
                    v1VarQ.A(new l() { // from class: com.stepos.stepclaw.base.net.b
                        @Override // p5.l
                        public final Object invoke(Object obj2) {
                            return StepOSProxyServer.C00071.invokeSuspend$lambda$1(stepOSProxyServer2, v1VarQ, (Throwable) obj2);
                        }
                    });
                } catch (Exception unused) {
                    if (serverSocket.isClosed()) {
                        break;
                    }
                }
            }
            return a0Var;
        }
    }

    public StepOSProxyServer() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0093 -> B:12:0x002e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object bindWithRetry(f5.c r12) throws java.io.IOException {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.stepos.stepclaw.base.net.StepOSProxyServer.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.stepclaw.base.net.StepOSProxyServer$bindWithRetry$1 r0 = (com.stepos.stepclaw.base.net.StepOSProxyServer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.base.net.StepOSProxyServer$bindWithRetry$1 r0 = new com.stepos.stepclaw.base.net.StepOSProxyServer$bindWithRetry$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            long r4 = r0.J$0
            int r2 = r0.I$0
            java.lang.Object r6 = r0.L$0
            java.net.BindException r6 = (java.net.BindException) r6
            a.a.c0(r12)
        L2e:
            r12 = r2
            goto L96
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            a.a.c0(r12)
            r12 = 0
            r4 = 200(0xc8, double:9.9E-322)
        L3e:
            r2 = 10
            r6 = 0
            if (r12 >= r2) goto La1
            int r2 = r12 + 1
            java.net.ServerSocket r12 = new java.net.ServerSocket     // Catch: java.net.BindException -> L5c
            r12.<init>()     // Catch: java.net.BindException -> L5c
            r12.setReuseAddress(r3)     // Catch: java.net.BindException -> L5c
            java.net.InetSocketAddress r7 = new java.net.InetSocketAddress     // Catch: java.net.BindException -> L5c
            java.lang.String r8 = "127.0.0.1"
            int r9 = r11.port     // Catch: java.net.BindException -> L5c
            r7.<init>(r8, r9)     // Catch: java.net.BindException -> L5c
            r8 = 50
            r12.bind(r7, r8)     // Catch: java.net.BindException -> L5c
            return r12
        L5c:
            r12 = move-exception
            int r7 = r11.port
            java.lang.String r12 = r12.getMessage()
            java.lang.String r8 = "/10 on port "
            java.lang.String r9 = " failed: "
            java.lang.String r10 = "bind attempt "
            java.lang.StringBuilder r7 = a8.b.t(r10, r2, r8, r7, r9)
            r7.append(r12)
            java.lang.String r12 = " — retrying in "
            r7.append(r12)
            r7.append(r4)
            java.lang.String r12 = "ms"
            r7.append(r12)
            java.lang.String r12 = r7.toString()
            r7 = 4
            java.lang.String r8 = "StepOSProxyServer"
            com.stepos.stepclaw.base.util.ALog.w$default(r8, r12, r6, r7, r6)
            r0.L$0 = r6
            r0.I$0 = r2
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r12 = a6.i0.g(r4, r0)
            if (r12 != r1) goto L2e
            return r1
        L96:
            r2 = 2
            long r6 = (long) r2
            long r4 = r4 * r6
            r6 = 2000(0x7d0, double:9.88E-321)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L3e
            r4 = r6
            goto L3e
        La1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.net.StepOSProxyServer.bindWithRetry(f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x02cf, code lost:
    
        if (r10 != null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02d1, code lost:
    
        r2 = "HTTP/1.1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02d4, code lost:
    
        r2 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02d5, code lost:
    
        r10 = r9.size();
        r22 = r2;
        r2 = new java.lang.StringBuilder();
        r2.append("[");
        r2.append(r6);
        r27 = r4;
        r2.append("] Request: ");
        r2.append(r8);
        r2.append(r14);
        r2.append(r13);
        r2.append(" (headers: ");
        r2.append(r10);
        r2.append(r7);
        com.stepos.stepclaw.base.util.ALog.d$default(com.stepos.stepclaw.base.net.StepOSProxyServer.TAG, r2.toString(), null, 4, null);
        r2 = new java.util.LinkedHashMap();
        r4 = c5.m.r0(r9, 1).iterator();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x031d, code lost:
    
        r28 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0321, code lost:
    
        if (r4.hasNext() == false) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0323, code lost:
    
        r10 = (java.lang.String) r28.next();
        r29 = r7;
        r30 = r14;
        r31 = r13;
        r7 = x5.n.q1(r10, kotlinx.serialization.json.internal.AbstractJsonLexerKt.COLON, 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0337, code lost:
    
        if (r7 <= 0) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0339, code lost:
    
        r13 = x5.n.T1(x5.n.Q1(r7, r10)).toString().toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.p.d(r13, "toLowerCase(...)");
        r7 = r10.substring(r7 + 1);
        kotlin.jvm.internal.p.d(r7, "substring(...)");
        r7 = x5.n.T1(r7).toString();
        r2.put(r13, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x036a, code lost:
    
        if (kotlin.jvm.internal.p.a(r13, "content-length") == false) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x036c, code lost:
    
        r4 = x5.u.d1(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0370, code lost:
    
        if (r4 == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0372, code lost:
    
        r9 = r4.intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0378, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0379, code lost:
    
        r4 = r28;
        r7 = r29;
        r14 = r30;
        r13 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0382, code lost:
    
        r29 = r7;
        r31 = r13;
        r30 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x038a, code lost:
    
        if (r9 <= com.stepos.stepclaw.base.net.StepOSProxyServer.MAX_BODY_BYTES) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x038c, code lost:
    
        com.stepos.stepclaw.base.util.ALog.w$default(com.stepos.stepclaw.base.net.StepOSProxyServer.TAG, "Request body too large: " + r9 + " bytes, limit is 10485760", null, 4, null);
        kotlin.jvm.internal.p.b(r3);
        r1.sendErrorResponse(r3, 413, "Request Entity Too Large");
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x03b3, code lost:
    
        if (r9 <= 0) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x03b5, code lost:
    
        com.stepos.stepclaw.base.util.ALog.d$default(com.stepos.stepclaw.base.net.StepOSProxyServer.TAG, "[" + r6 + "] Reading body, contentLength=" + r9, null, 4, null);
        r7 = new byte[r9];
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x03d4, code lost:
    
        if (r10 >= r9) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x03d6, code lost:
    
        r13 = r0.read(r7, r10, r9 - r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x03dd, code lost:
    
        if (r13 == (-1)) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x03df, code lost:
    
        r10 = r10 + r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x03e1, code lost:
    
        com.stepos.stepclaw.base.util.ALog.d$default(com.stepos.stepclaw.base.net.StepOSProxyServer.TAG, "[" + r6 + "] Body read complete: " + r10 + " bytes", null, 4, null);
        r0 = java.util.Arrays.copyOf(r7, r10);
        kotlin.jvm.internal.p.d(r0, "copyOf(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x040c, code lost:
    
        r0 = new byte[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0415, code lost:
    
        if (kotlin.jvm.internal.p.a(r8, "POST") != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0417, code lost:
    
        kotlin.jvm.internal.p.b(r3);
        r1.sendErrorResponse(r3, 405, "Method Not Allowed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0423, code lost:
    
        r7 = r1.resolveHeaders((java.lang.String) r2.get("x-stepclaw-trace-id"));
        r8 = x5.n.V1(r1.targetBaseUrl, '/') + "/" + x5.n.X1(r31, '/');
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0479, code lost:
    
        r23 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x047d, code lost:
    
        com.stepos.stepclaw.base.util.ALog.d$default(com.stepos.stepclaw.base.net.StepOSProxyServer.TAG, "[" + r6 + "] Forwarding to: " + r8 + ", headers: " + r7, null, 4, null);
        r11 = new com.stepos.stepclaw.base.net.ProxyDiagnostics(r6, r1.logBffUpstreamUsage);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x048e, code lost:
    
        if (x5.n.g1(r31, "chat/completions", true) == false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0490, code lost:
    
        r0 = r11.injectCacheControl(r0, r1.enablePromptCache);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0497, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0498, code lost:
    
        r2 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x049e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x049f, code lost:
    
        r2 = r33;
        r7 = r1;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x04a6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x04a7, code lost:
    
        r2 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x04ad, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x04ae, code lost:
    
        r2 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x04b4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x04b5, code lost:
    
        r2 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x04bb, code lost:
    
        r10 = r1.httpClient;
        r13 = new f4.c();
        f4.e.a(r13, r8);
        r14 = (java.lang.String) r2.get(r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x04cd, code lost:
    
        if (r14 == null) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x04cf, code lost:
    
        r27 = k4.g.f3611f;
        k4.v.s(r13, b8.h.F(r14));
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x04d9, code lost:
    
        k4.v.s(r13, k4.d.f3601a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x04de, code lost:
    
        r2 = r2.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x04ea, code lost:
    
        if (r2.hasNext() == false) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x04ec, code lost:
    
        r14 = (java.util.Map.Entry) r2.next();
        r1 = (java.lang.String) r14.getKey();
        r14 = (java.lang.String) r14.getValue();
        r27 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0510, code lost:
    
        if (c5.n.k0("host", "content-length", r27, "x-stepclaw-trace-id").contains(r1) != false) goto L315;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0512, code lost:
    
        a.a.O(r13, r1, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0516, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0517, code lost:
    
        r7 = r32;
        r2 = r33;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x051c, code lost:
    
        r1 = r32;
        r2 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0521, code lost:
    
        a.a.O(r13, "zy-trace-id", r7.getTraceId());
        a.a.O(r13, "zy-user-id", r7.getUserId());
        a.a.O(r13, "zy-device-id", r7.getDeviceId());
        a.a.O(r13, "zy-app-id", r7.getAppId());
        a.a.O(r13, "zy-nonce", r7.getNonce());
        a.a.O(r13, "zy-timestamp", r7.getTimestamp());
        a.a.O(r13, "zy-sign", r7.getSign());
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0561, code lost:
    
        if (r0.length != 0) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0566, code lost:
    
        if ((r0 instanceof n4.e) == false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0568, code lost:
    
        r13.a(r0);
        r13.b(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0570, code lost:
    
        r13.a(r0);
        r0 = kotlin.jvm.internal.z.a(byte[].class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0577, code lost:
    
        r1 = kotlin.jvm.internal.z.c(byte[].class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x057c, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0258, code lost:
    
        r10 = (java.lang.String) c5.m.v0(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x025e, code lost:
    
        if (r10 != null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0260, code lost:
    
        r3 = null;
        r9 = 4;
        com.stepos.stepclaw.base.util.ALog.w$default(com.stepos.stepclaw.base.net.StepOSProxyServer.TAG, "[" + r6 + "] No request line received, closing connection", null, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0279, code lost:
    
        r33.close();
        r0 = "[" + r6 + r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02a6, code lost:
    
        r10 = x5.n.G1(r10, new java.lang.String[]{r14}, 3, 2);
        r8 = (java.lang.String) c5.m.w0(0, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02b9, code lost:
    
        if (r8 != null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02bb, code lost:
    
        r8 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02bd, code lost:
    
        r13 = (java.lang.String) c5.m.w0(1, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02c4, code lost:
    
        if (r13 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02c6, code lost:
    
        r13 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02c8, code lost:
    
        r10 = (java.lang.String) c5.m.w0(2, r10);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:182:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0740  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x078e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleClient(java.net.Socket r33, f5.c r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.net.StepOSProxyServer.handleClient(java.net.Socket, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handleClient$lambda$2(h4.c cVar, String it) {
        kotlin.jvm.internal.p.e(it, "it");
        return cVar.a().d(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 handleClient$lambda$3(StringBuilder sb, String key, List values) {
        kotlin.jvm.internal.p.e(key, "key");
        kotlin.jvm.internal.p.e(values, "values");
        String lowerCase = key.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        if (!n.k0("content-length", "transfer-encoding", "connection").contains(lowerCase)) {
            Iterator it = values.iterator();
            while (it.hasNext()) {
                sb.append(key + ": " + ((String) it.next()) + "\r\n");
            }
        }
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0(t3.d HttpClient) {
        kotlin.jvm.internal.p.e(HttpClient, "$this$HttpClient");
        HttpClient.a(t0.f6509b, new z(11));
        HttpClient.d = new b6.e(HttpClient.d, 2, new z(12));
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0$0(z3.r0 install) {
        kotlin.jvm.internal.p.e(install, "$this$install");
        install.b(Long.valueOf(GatewayReconnectDiagnostics.AUTO_START_COOLDOWN_MS));
        install.d(600000L);
        install.c(Long.valueOf(Util.VLI_MAX));
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0$1(g engine) {
        kotlin.jvm.internal.p.e(engine, "$this$engine");
        engine.f6269a = 15000;
        engine.f6270b = 600000;
        engine.d = new z(10);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0$1$0(HttpURLConnection httpURLConnection) {
        kotlin.jvm.internal.p.e(httpURLConnection, "<this>");
        httpURLConnection.setRequestProperty("Connection", "close");
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x00fd, code lost:
    
        r7 = r5;
        r8 = r6;
        r4 = r12;
        r12 = r14;
        r3 = r20;
        r5 = r7;
        r14 = r10;
        r10 = r0;
        r0 = r15;
        r15 = 1;
     */
    /* JADX WARN: Path cross not found for [B:39:0x0151, B:46:0x0164], limit reached: 147 */
    /* JADX WARN: Removed duplicated region for block: B:100:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x026e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x021f -> B:77:0x022d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object pipeChunked(io.ktor.utils.io.p r24, java.io.OutputStream r25, boolean r26, java.lang.String r27, java.lang.String r28, com.stepos.stepclaw.base.net.ProxyDiagnostics r29, f5.c r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.net.StepOSProxyServer.pipeChunked(io.ktor.utils.io.p, java.io.OutputStream, boolean, java.lang.String, java.lang.String, com.stepos.stepclaw.base.net.ProxyDiagnostics, f5.c):java.lang.Object");
    }

    public static /* synthetic */ Object pipeChunked$default(StepOSProxyServer stepOSProxyServer, io.ktor.utils.io.p pVar, OutputStream outputStream, boolean z, String str, String str2, ProxyDiagnostics proxyDiagnostics, f5.c cVar, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i8 & 8) != 0) {
            str = "unknown";
        }
        String str3 = str;
        if ((i8 & 16) != 0) {
            str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        String str4 = str2;
        if ((i8 & 32) != 0) {
            proxyDiagnostics = null;
        }
        return stepOSProxyServer.pipeChunked(pVar, outputStream, z2, str3, str4, proxyDiagnostics, cVar);
    }

    private final StepOSHeaders resolveHeaders(String traceIdFromRequest) {
        StepOSHeaders stepOSHeaders;
        StepOSHeaders stepOSHeadersProvide;
        StepOSHeadersProvider stepOSHeadersProvider = this.headersProvider;
        if (stepOSHeadersProvider == null || (stepOSHeadersProvide = stepOSHeadersProvider.provide()) == null) {
            ALog.w$default(TAG, "headersProvider is null, using fallback headers. Auth may fail.", null, 4, null);
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.p.d(string, "toString(...)");
            StepAccount stepAccount = StepAccount.INSTANCE;
            stepOSHeaders = new StepOSHeaders(string, stepAccount.getLocalAccountId(), stepAccount.getOAID(), SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        } else {
            stepOSHeaders = stepOSHeadersProvide;
        }
        return traceIdFromRequest != null ? StepOSHeaders.copy$default(stepOSHeaders, traceIdFromRequest, null, null, null, null, null, null, 126, null) : stepOSHeaders;
    }

    private final void sendErrorResponse(OutputStream outputStream, int status, String message) throws IOException {
        String strD = f.d("{\"error\":\"", u.a1(u.a1(u.a1(u.a1(message, "\\", "\\\\"), "\"", "\\\""), "\n", "\\n"), "\r", "\\r"), "\"}");
        Charset charset = x5.a.f6276a;
        byte[] bytes = strD.getBytes(charset);
        kotlin.jvm.internal.p.d(bytes, "getBytes(...)");
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 " + status + " " + message + "\r\n");
        sb.append("Content-Type: application/json; charset=utf-8\r\n");
        sb.append("Content-Length: " + bytes.length + "\r\n");
        sb.append("Connection: close\r\n\r\n");
        sb.append(strD);
        try {
            byte[] bytes2 = sb.toString().getBytes(charset);
            kotlin.jvm.internal.p.d(bytes2, "getBytes(...)");
            outputStream.write(bytes2);
            outputStream.flush();
        } catch (Exception unused) {
        }
    }

    public final void applyNetEnvBaseUrl() {
        String str;
        StepNet stepNet = StepNet.INSTANCE;
        int i8 = WhenMappings.$EnumSwitchMapping$0[stepNet.getNetEnv().ordinal()];
        if (i8 == 1 || i8 == 2) {
            str = TEST_BASE_URL;
        } else {
            if (i8 != 3 && i8 != 4) {
                throw new w();
            }
            str = PROD_BASE_URL;
        }
        this.targetBaseUrl = str;
        ALog.i$default(TAG, "applyNetEnvBaseUrl: targetBaseUrl=" + this.targetBaseUrl + " (env=" + stepNet.getNetEnv() + ")", null, 4, null);
    }

    public final Object drain(f5.c cVar) {
        Object objP = i0.p(m.N0(this.activeJobs), cVar);
        return objP == g5.a.f2984a ? objP : a0.f883a;
    }

    public final boolean getEnablePromptCache() {
        return this.enablePromptCache;
    }

    public final StepOSHeadersProvider getHeadersProvider() {
        return this.headersProvider;
    }

    public final boolean getLogBffUpstreamUsage() {
        return this.logBffUpstreamUsage;
    }

    public final String getTargetBaseUrl() {
        return this.targetBaseUrl;
    }

    public final void setEnablePromptCache(boolean z) {
        this.enablePromptCache = z;
    }

    public final void setHeadersProvider(StepOSHeadersProvider stepOSHeadersProvider) {
        this.headersProvider = stepOSHeadersProvider;
    }

    public final void setLogBffUpstreamUsage(boolean z) {
        this.logBffUpstreamUsage = z;
    }

    public final void start(f0 scope) {
        kotlin.jvm.internal.p.e(scope, "scope");
        ServerSocket serverSocket = this.serverSocket;
        if (serverSocket != null && !serverSocket.isClosed()) {
            ALog.d$default(TAG, a8.b.k(this.port, "SSE proxy already running on port ", " — skipping start()"), null, 4, null);
        } else {
            h6.e eVar = r0.f210a;
            this.serverJob = i0.q(scope, d.f3059c, new C00071(null), 2);
        }
    }

    public final void stop() throws IOException {
        try {
            ServerSocket serverSocket = this.serverSocket;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception unused) {
        }
        this.serverSocket = null;
        h1 h1Var = this.serverJob;
        if (h1Var != null) {
            h1Var.e(null);
        }
        this.serverJob = null;
        ALog.i$default(TAG, "SSE proxy server stopped", null, 4, null);
    }

    public final void updateBaseUrl(String baseUrl) {
        kotlin.jvm.internal.p.e(baseUrl, "baseUrl");
        this.targetBaseUrl = baseUrl;
    }

    public StepOSProxyServer(int i8) {
        this.port = i8;
        this.targetBaseUrl = PROD_BASE_URL;
        this.enablePromptCache = true;
        this.logBffUpstreamUsage = true;
        this.httpClient = v.a(x3.a.f6253a, new z(13));
        int i9 = j.f3164a;
        this.connectionSemaphore = new i6.i(64);
        this.activeJobs = new CopyOnWriteArrayList<>();
    }

    public /* synthetic */ StepOSProxyServer(int i8, int i9, i iVar) {
        this((i9 & 1) != 0 ? DEFAULT_PORT : i8);
    }
}
