package com.stepos.stepclaw;

import a6.f0;
import a6.i0;
import a6.l;
import a6.r0;
import a6.x1;
import a6.z;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import b5.a0;
import b8.h;
import com.stepos.stepclaw.base.framework.ServiceLocator;
import com.stepos.stepclaw.bridge.spi.EdgeServices;
import com.stepos.stepclaw.bridge.spi.EdgeServicesDeps;
import com.stepos.stepclaw.bridge.spi.EdgeServicesEntryPoint;
import com.stepos.stepclaw.config.JsonConfigStore;
import com.stepos.stepclaw.gateway.ConnectionManager;
import com.stepos.stepclaw.gateway.DeviceAuthStore;
import com.stepos.stepclaw.gateway.DeviceIdentityStore;
import com.stepos.stepclaw.gateway.GatewayAutoStart;
import com.stepos.stepclaw.gateway.GatewayDiscovery;
import com.stepos.stepclaw.gateway.GatewayEndpoint;
import com.stepos.stepclaw.gateway.GatewayReconnectDiagnostics;
import com.stepos.stepclaw.gateway.GatewaySession;
import com.stepos.stepclaw.gateway.GatewayTlsParams;
import com.stepos.stepclaw.openclaw.OpenClawClient;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import d6.u;
import d6.v;
import d6.w;
import d6.y;
import h5.e;
import h5.i;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import p5.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 e2\u00020\u0001:\u0001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u0010\u0010\u001c\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b#\u0010\u001dJ\u000f\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&R\u001c\u0010(\u001a\n '*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010GR\u0016\u0010I\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010?R\u0018\u0010J\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010L\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010KR\u0016\u0010M\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020 0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020 0U8\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bV\u0010XR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020\t0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010TR\u0016\u0010Z\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010NR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010NR\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lcom/stepos/stepclaw/GatewayRuntime;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lb5/a0;", "disconnect", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "candidate", "applyMainSessionKey", "(Ljava/lang/String;)V", "updateStatus", "advanceAndroidNodeSessionConnectionGeneration", "resolveMainSessionKey", "()Ljava/lang/String;", "onNetworkRecovered", "ensureLoopbackEndpoint", "reason", "triggerChrootOtaSelfHeal", "refreshGatewayConnection", "Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "endpoint", "connect", "(Lcom/stepos/stepclaw/gateway/GatewayEndpoint;)V", "disconnectMessage", "maybeAutoStartGateway", "initializeAndroidNodeSession", "(Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "generation", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ensureAndroidNodeInitialized", "(ILf5/c;)Ljava/lang/Object;", "refreshBrandingFromGateway", "Lcom/stepos/stepclaw/bridge/spi/EdgeServicesDeps;", "buildEdgeServicesDeps", "()Lcom/stepos/stepclaw/bridge/spi/EdgeServicesDeps;", "kotlin.jvm.PlatformType", "appContext", "Landroid/content/Context;", "La6/f0;", "scope", "La6/f0;", "Lcom/stepos/stepclaw/SecurePrefs;", "prefs", "Lcom/stepos/stepclaw/SecurePrefs;", "Lcom/stepos/stepclaw/gateway/DeviceAuthStore;", "deviceAuthStore", "Lcom/stepos/stepclaw/gateway/DeviceAuthStore;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "Lcom/stepos/stepclaw/gateway/GatewayDiscovery;", "discovery", "Lcom/stepos/stepclaw/gateway/GatewayDiscovery;", "Lcom/stepos/stepclaw/gateway/DeviceIdentityStore;", "identityStore", "Lcom/stepos/stepclaw/gateway/DeviceIdentityStore;", "connectedEndpoint", "Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "gatewayAutoStartAttempts", "I", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lastGatewayAutoStartMs", "J", "Lcom/stepos/stepclaw/gateway/GatewayReconnectDiagnostics;", "gatewayReconnectDiag", "Lcom/stepos/stepclaw/gateway/GatewayReconnectDiagnostics;", "maybeAutoStartLock", "Ljava/lang/Object;", "androidNodeSessionInitLock", "gatewayConnectionGeneration", "androidNodeInitInFlightGeneration", "Ljava/lang/Integer;", "androidNodeInitializedGeneration", "backupOnConnectDone", "Z", "Lcom/stepos/stepclaw/gateway/ConnectionManager;", "connectionManager", "Lcom/stepos/stepclaw/gateway/ConnectionManager;", "Ld6/u;", "_isConnected", "Ld6/u;", "Ld6/w;", "isConnected", "Ld6/w;", "()Ld6/w;", "_mainSessionKey", "nodeConnected", "Lcom/stepos/stepclaw/gateway/GatewaySession;", "gatewaySession", "Lcom/stepos/stepclaw/gateway/GatewaySession;", "didAutoConnect", "Lcom/stepos/stepclaw/bridge/spi/EdgeServices;", "edgeServices", "Lcom/stepos/stepclaw/bridge/spi/EdgeServices;", "Lcom/stepos/stepclaw/NetworkRecoveryMonitor;", "networkRecoveryMonitor", "Lcom/stepos/stepclaw/NetworkRecoveryMonitor;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayRuntime {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "GatewayRuntime";
    private final u _isConnected;
    private final u _mainSessionKey;
    private Integer androidNodeInitInFlightGeneration;
    private Integer androidNodeInitializedGeneration;
    private final Object androidNodeSessionInitLock;
    private final Context appContext;
    private volatile boolean backupOnConnectDone;
    private GatewayEndpoint connectedEndpoint;
    private final ConnectionManager connectionManager;
    private final DeviceAuthStore deviceAuthStore;
    private boolean didAutoConnect;
    private final GatewayDiscovery discovery;
    private final EdgeServices edgeServices;
    private int gatewayAutoStartAttempts;
    private int gatewayConnectionGeneration;
    private final GatewayReconnectDiagnostics gatewayReconnectDiag;
    private final GatewaySession gatewaySession;
    private final DeviceIdentityStore identityStore;
    private final w isConnected;
    private final Json json;
    private long lastGatewayAutoStartMs;
    private final Object maybeAutoStartLock;
    private final NetworkRecoveryMonitor networkRecoveryMonitor;
    private boolean nodeConnected;
    private final SecurePrefs prefs;
    private final f0 scope;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.GatewayRuntime$1", f = "GatewayRuntime.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.GatewayRuntime$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return GatewayRuntime.this.new AnonymousClass1(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            GatewayRuntime.this.prefs.loadGatewayToken();
            return a0.f883a;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.GatewayRuntime$2", f = "GatewayRuntime.kt", l = {187}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.GatewayRuntime$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return GatewayRuntime.this.new AnonymousClass2(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                w gateways = GatewayRuntime.this.discovery.getGateways();
                final GatewayRuntime gatewayRuntime = GatewayRuntime.this;
                d6.c cVar = new d6.c() { // from class: com.stepos.stepclaw.GatewayRuntime.2.1
                    @Override // d6.c
                    public final Object emit(List<GatewayEndpoint> list, f5.c cVar2) {
                        T next;
                        String string;
                        boolean z = gatewayRuntime.didAutoConnect;
                        a0 a0Var = a0.f883a;
                        if (!z && !((Boolean) ((y) gatewayRuntime._isConnected).getValue()).booleanValue()) {
                            boolean zBooleanValue = ((Boolean) gatewayRuntime.prefs.getManualEnabled().getValue()).booleanValue();
                            String str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                            if (zBooleanValue) {
                                String string2 = n.T1((String) gatewayRuntime.prefs.getManualHost().getValue()).toString();
                                int iIntValue = ((Number) gatewayRuntime.prefs.getManualPort().getValue()).intValue();
                                if (string2.length() > 0 && 1 <= iIntValue && iIntValue < 65536) {
                                    if (string2.equals("127.0.0.1")) {
                                        gatewayRuntime.didAutoConnect = true;
                                        gatewayRuntime.connect(GatewayEndpoint.INSTANCE.manual(string2, iIntValue));
                                        return a0Var;
                                    }
                                    if (((Boolean) gatewayRuntime.prefs.getManualTls().getValue()).booleanValue()) {
                                        GatewayEndpoint.Companion companion = GatewayEndpoint.INSTANCE;
                                        String strLoadGatewayTlsFingerprint = gatewayRuntime.prefs.loadGatewayTlsFingerprint(companion.manual(string2, iIntValue).getStableId());
                                        string = strLoadGatewayTlsFingerprint != null ? n.T1(strLoadGatewayTlsFingerprint).toString() : null;
                                        if (string != null) {
                                            str = string;
                                        }
                                        if (str.length() != 0) {
                                            gatewayRuntime.didAutoConnect = true;
                                            gatewayRuntime.connect(companion.manual(string2, iIntValue));
                                            return a0Var;
                                        }
                                    }
                                }
                            } else {
                                String string3 = n.T1((String) gatewayRuntime.prefs.getLastDiscoveredStableId().getValue()).toString();
                                if (string3.length() != 0) {
                                    Iterator<T> it = list.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            next = (T) null;
                                            break;
                                        }
                                        next = it.next();
                                        if (kotlin.jvm.internal.p.a(((GatewayEndpoint) next).getStableId(), string3)) {
                                            break;
                                        }
                                    }
                                    GatewayEndpoint gatewayEndpoint = next;
                                    if (gatewayEndpoint != null) {
                                        String strLoadGatewayTlsFingerprint2 = gatewayRuntime.prefs.loadGatewayTlsFingerprint(gatewayEndpoint.getStableId());
                                        string = strLoadGatewayTlsFingerprint2 != null ? n.T1(strLoadGatewayTlsFingerprint2).toString() : null;
                                        if (string != null) {
                                            str = string;
                                        }
                                        if (str.length() != 0) {
                                            gatewayRuntime.didAutoConnect = true;
                                            gatewayRuntime.connect(gatewayEndpoint);
                                            return a0Var;
                                        }
                                    }
                                }
                            }
                        }
                        return a0Var;
                    }
                };
                this.label = 1;
                if (gateways.collect(cVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
            }
            throw new a6.w();
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f*\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/stepclaw/GatewayRuntime$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "normalizeMainKey", "raw", "isCanonicalMain", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "key", "asObject", "Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "asString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final JsonObject asObject(JsonElement jsonElement) {
            if (jsonElement instanceof JsonObject) {
                return (JsonObject) jsonElement;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String asString(JsonElement jsonElement) {
            if (!(jsonElement instanceof JsonNull) && (jsonElement instanceof JsonPrimitive)) {
                return ((JsonPrimitive) jsonElement).getContent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isCanonicalMain(String key) {
            return kotlin.jvm.internal.p.a(key, "main");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String normalizeMainKey(String raw) {
            String string = raw != null ? n.T1(raw).toString() : null;
            if (string == null) {
                string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (string.length() == 0) {
                return null;
            }
            return string;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GatewayAutoStart.Result.values().length];
            try {
                iArr[GatewayAutoStart.Result.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GatewayAutoStart.Result.ALREADY_RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GatewayAutoStart.Result.INITIALIZING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GatewayAutoStart.Result.NEEDS_CONFIG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.GatewayRuntime", f = "GatewayRuntime.kt", l = {486}, m = "ensureAndroidNodeInitialized", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.GatewayRuntime$ensureAndroidNodeInitialized$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00011 extends h5.c {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public C00011(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewayRuntime.this.ensureAndroidNodeInitialized(0, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.GatewayRuntime$onNetworkRecovered$1", f = "GatewayRuntime.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.GatewayRuntime$onNetworkRecovered$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00021 extends i implements p {
        int label;

        public C00021(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return GatewayRuntime.this.new C00021(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00021) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            if (((Boolean) ((y) GatewayRuntime.this._isConnected).getValue()).booleanValue()) {
                Log.d(GatewayRuntime.TAG, "network recovered but gateway session already connected — skip disruptive reconnect");
                return a0.f883a;
            }
            Log.i(GatewayRuntime.TAG, "network recovered — waking gateway session + re-triggering chroot OTA self-heal");
            Object obj2 = GatewayRuntime.this.maybeAutoStartLock;
            GatewayRuntime gatewayRuntime = GatewayRuntime.this;
            synchronized (obj2) {
                gatewayRuntime.gatewayAutoStartAttempts = 0;
                gatewayRuntime.lastGatewayAutoStartMs = 0L;
            }
            GatewayRuntime.this.ensureLoopbackEndpoint();
            GatewayRuntime.this.gatewaySession.wakeIfNotOnline();
            GatewayRuntime.this.triggerChrootOtaSelfHeal("network recovered");
            return a0.f883a;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.GatewayRuntime", f = "GatewayRuntime.kt", l = {511}, m = "refreshBrandingFromGateway", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.GatewayRuntime$refreshBrandingFromGateway$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00031 extends h5.c {
        int label;
        /* synthetic */ Object result;

        public C00031(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewayRuntime.this.refreshBrandingFromGateway(this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.GatewayRuntime$triggerChrootOtaSelfHeal$1", f = "GatewayRuntime.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.GatewayRuntime$triggerChrootOtaSelfHeal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00041 extends i implements p {
        private /* synthetic */ Object L$0;
        int label;

        public C00041(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            C00041 c00041 = GatewayRuntime.this.new C00041(cVar);
            c00041.L$0 = obj;
            return c00041;
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00041) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            Object objO;
            a0 a0Var = a0.f883a;
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            GatewayRuntime gatewayRuntime = GatewayRuntime.this;
            try {
                GatewayAutoStart gatewayAutoStart = GatewayAutoStart.INSTANCE;
                Context context = gatewayRuntime.appContext;
                kotlin.jvm.internal.p.d(context, "access$getAppContext$p(...)");
                gatewayAutoStart.ensureOpenClawEnvStarted(context);
                objO = a0Var;
            } catch (Throwable th) {
                objO = a.a.o(th);
            }
            Throwable thA = b5.i.a(objO);
            if (thA != null) {
                Log.w(GatewayRuntime.TAG, "ensureOpenClawEnvStarted after ALREADY_RUNNING failed: " + thA.getMessage(), thA);
            }
            return a0Var;
        }
    }

    public GatewayRuntime(Context context) {
        kotlin.jvm.internal.p.e(context, "context");
        Context appContext = context.getApplicationContext();
        this.appContext = appContext;
        x1 x1VarC = i0.c();
        h6.e eVar = r0.f210a;
        l4.a aVarB = i0.b(h.I(x1VarC, h6.d.f3059c));
        this.scope = aVarB;
        kotlin.jvm.internal.p.d(appContext, "appContext");
        SecurePrefs securePrefs = new SecurePrefs(appContext);
        this.prefs = securePrefs;
        DeviceAuthStore deviceAuthStore = new DeviceAuthStore(securePrefs);
        this.deviceAuthStore = deviceAuthStore;
        int i8 = 1;
        this.json = JsonKt.Json$default(null, new z(6), 1, null);
        this.discovery = new GatewayDiscovery(appContext, aVarB);
        DeviceIdentityStore deviceIdentityStore = new DeviceIdentityStore(appContext);
        this.identityStore = deviceIdentityStore;
        this.gatewayReconnectDiag = new GatewayReconnectDiagnostics();
        this.maybeAutoStartLock = new Object();
        this.androidNodeSessionInitLock = new Object();
        this.connectionManager = new ConnectionManager(securePrefs, new b(this, i8));
        y yVarA = d6.z.a(Boolean.FALSE);
        this._isConnected = yVarA;
        this.isConnected = new v(yVarA);
        this._mainSessionKey = d6.z.a("main");
        this.gatewaySession = new GatewaySession(aVarB, deviceIdentityStore, deviceAuthStore, new l(i8, this), new c5.a(i8, this), null, null, new c(0, this), new b(this, 2), 96, null);
        EdgeServices edgeServicesBuild = ((EdgeServicesEntryPoint) ServiceLocator.INSTANCE.get(EdgeServicesEntryPoint.class)).build(buildEdgeServicesDeps());
        this.edgeServices = edgeServicesBuild;
        NetworkRecoveryMonitor networkRecoveryMonitor = new NetworkRecoveryMonitor(appContext, new b(this, 3));
        this.networkRecoveryMonitor = networkRecoveryMonitor;
        edgeServicesBuild.startInterceptServer(aVarB);
        i0.q(aVarB, null, new AnonymousClass1(null), 3);
        i0.q(aVarB, r0.f210a, new AnonymousClass2(null), 2);
        networkRecoveryMonitor.start();
    }

    private final void advanceAndroidNodeSessionConnectionGeneration() {
        synchronized (this.androidNodeSessionInitLock) {
            this.gatewayConnectionGeneration++;
            this.androidNodeInitInFlightGeneration = null;
            this.androidNodeInitializedGeneration = null;
        }
    }

    private final void applyMainSessionKey(String candidate) {
        Companion companion = Companion;
        String strNormalizeMainKey = companion.normalizeMainKey(candidate);
        if (strNormalizeMainKey == null || companion.isCanonicalMain((String) ((y) this._mainSessionKey).getValue()) || kotlin.jvm.internal.p.a(((y) this._mainSessionKey).getValue(), strNormalizeMainKey)) {
            return;
        }
        y yVar = (y) this._mainSessionKey;
        yVar.getClass();
        yVar.c(null, strNormalizeMainKey);
    }

    private final EdgeServicesDeps buildEdgeServicesDeps() {
        Context appContext = this.appContext;
        kotlin.jvm.internal.p.d(appContext, "appContext");
        return new EdgeServicesDeps(appContext, new GatewayRuntimeInvoker(this.gatewaySession), new a4.b(1), false, InstallResultReceiver.class, new b(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean buildEdgeServicesDeps$lambda$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connect(GatewayEndpoint endpoint) {
        GatewayTlsParams gatewayTlsParamsResolveTlsParams = this.connectionManager.resolveTlsParams(endpoint);
        this.connectedEndpoint = endpoint;
        updateStatus();
        this.gatewaySession.connect(endpoint, this.prefs.loadGatewayToken(), this.prefs.loadGatewayPassword(), this.connectionManager.buildOperatorConnectOptions(), gatewayTlsParamsResolveTlsParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean connectionManager$lambda$0(GatewayRuntime gatewayRuntime) {
        return ((Boolean) gatewayRuntime.prefs.getManualTls().getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object ensureAndroidNodeInitialized(int r11, f5.c r12) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.GatewayRuntime.ensureAndroidNodeInitialized(int, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureLoopbackEndpoint() {
        if (this.connectedEndpoint != null) {
            return;
        }
        String string = n.T1((String) this.prefs.getManualHost().getValue()).toString();
        if (string.length() == 0) {
            string = "127.0.0.1";
        }
        Object value = this.prefs.getManualPort().getValue();
        int iIntValue = ((Number) value).intValue();
        if (1 > iIntValue || iIntValue >= 65536) {
            value = null;
        }
        Integer num = (Integer) value;
        int iIntValue2 = num != null ? num.intValue() : 18789;
        if (!((Boolean) this.prefs.getManualEnabled().getValue()).booleanValue() && !string.equals("127.0.0.1")) {
            Log.w(TAG, "ensureLoopbackEndpoint skipped: manual gateway disabled and host is not loopback (" + string + ")");
            return;
        }
        Log.i(TAG, "ensureLoopbackEndpoint: establishing loopback session target " + string + ":" + iIntValue2);
        connect(GatewayEndpoint.INSTANCE.manual(string, iIntValue2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final a0 gatewaySession$lambda$0(GatewayRuntime gatewayRuntime, String str, String str2, String str3) {
        gatewayRuntime.nodeConnected = true;
        gatewayRuntime.advanceAndroidNodeSessionConnectionGeneration();
        gatewayRuntime.gatewayAutoStartAttempts = 0;
        gatewayRuntime.gatewayReconnectDiag.resetSession();
        OpenClawRuntimeConfig openClawRuntimeConfig = null;
        Object[] objArr = 0;
        if (!gatewayRuntime.backupOnConnectDone) {
            gatewayRuntime.backupOnConnectDone = true;
            Context appContext = gatewayRuntime.appContext;
            kotlin.jvm.internal.p.d(appContext, "appContext");
            new JsonConfigStore(appContext, openClawRuntimeConfig, 2, objArr == true ? 1 : 0).backupKnownGood();
            Log.i(TAG, "Backed up known-good config after gateway session connected");
        }
        gatewayRuntime.applyMainSessionKey(str3);
        gatewayRuntime.updateStatus();
        GatewayEndpoint gatewayEndpoint = gatewayRuntime.connectedEndpoint;
        if (gatewayEndpoint != null) {
            String str4 = gatewayEndpoint.getTlsEnabled() ? "https" : "http";
            OpenClawClient.INSTANCE.init(str4 + "://" + gatewayEndpoint.getHost() + ":" + gatewayEndpoint.getPort());
        }
        i0.q(gatewayRuntime.scope, null, new GatewayRuntime$gatewaySession$1$2(gatewayRuntime, null), 3);
        i0.q(gatewayRuntime.scope, null, new GatewayRuntime$gatewaySession$1$3(gatewayRuntime, null), 3);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 gatewaySession$lambda$1(GatewayRuntime gatewayRuntime, String message) {
        kotlin.jvm.internal.p.e(message, "message");
        gatewayRuntime.nodeConnected = false;
        gatewayRuntime.advanceAndroidNodeSessionConnectionGeneration();
        if (!Companion.isCanonicalMain((String) ((y) gatewayRuntime._mainSessionKey).getValue())) {
            y yVar = (y) gatewayRuntime._mainSessionKey;
            yVar.getClass();
            yVar.c(null, "main");
        }
        gatewayRuntime.updateStatus();
        gatewayRuntime.gatewayReconnectDiag.markDisconnect();
        gatewayRuntime.maybeAutoStartGateway(message);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 gatewaySession$lambda$2(GatewayRuntime gatewayRuntime, String stableId, String fingerprint) {
        kotlin.jvm.internal.p.e(stableId, "stableId");
        kotlin.jvm.internal.p.e(fingerprint, "fingerprint");
        gatewayRuntime.prefs.saveGatewayTlsFingerprint(stableId, fingerprint);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 gatewaySession$lambda$3(GatewayRuntime gatewayRuntime) {
        GatewayEndpoint gatewayEndpoint = gatewayRuntime.connectedEndpoint;
        GatewayAutoStart gatewayAutoStart = GatewayAutoStart.INSTANCE;
        Context appContext = gatewayRuntime.appContext;
        kotlin.jvm.internal.p.d(appContext, "appContext");
        GatewayAutoStart.handlePersistentConnectFailure$default(gatewayAutoStart, appContext, gatewayRuntime.scope, gatewayEndpoint != null ? gatewayEndpoint.getPort() : 18789, new a(gatewayRuntime, gatewayEndpoint, 2), new z(5), null, null, 96, null);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 gatewaySession$lambda$3$0(GatewayRuntime gatewayRuntime, GatewayEndpoint gatewayEndpoint) {
        i0.q(gatewayRuntime.scope, null, new GatewayRuntime$gatewaySession$4$1$1(gatewayEndpoint, null), 3);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 gatewaySession$lambda$3$1(String msg) {
        kotlin.jvm.internal.p.e(msg, "msg");
        Log.d("GatewayLog", msg);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object initializeAndroidNodeSession(f5.c cVar) {
        synchronized (this.androidNodeSessionInitLock) {
            if (!((Boolean) ((y) this._isConnected).getValue()).booleanValue()) {
                return a0.f883a;
            }
            Object objEnsureAndroidNodeInitialized = ensureAndroidNodeInitialized(this.gatewayConnectionGeneration, cVar);
            return objEnsureAndroidNodeInitialized == g5.a.f2984a ? objEnsureAndroidNodeInitialized : a0.f883a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        kotlin.jvm.internal.p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        return a0.f883a;
    }

    private final void maybeAutoStartGateway(String disconnectMessage) {
        synchronized (this.maybeAutoStartLock) {
            GatewayEndpoint gatewayEndpoint = this.connectedEndpoint;
            if (gatewayEndpoint == null) {
                Log.w(TAG, "maybeAutoStartGateway skipped: connectedEndpoint is null (msg=" + n.Q1(80, disconnectMessage) + ")");
                return;
            }
            String lowerCase = gatewayEndpoint.getHost().toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
            if (lowerCase.equals("127.0.0.1") || lowerCase.equals("localhost") || x5.u.c1(lowerCase, "127.", false) || lowerCase.equals("::1")) {
                this.gatewayReconnectDiag.getInvocations().incrementAndGet();
                int i8 = this.gatewayAutoStartAttempts;
                boolean z = i8 == 0 || i8 % 5 == 0;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (z && jElapsedRealtime - this.lastGatewayAutoStartMs >= GatewayReconnectDiagnostics.AUTO_START_COOLDOWN_MS) {
                    this.gatewayAutoStartAttempts++;
                    this.lastGatewayAutoStartMs = jElapsedRealtime;
                    this.gatewayReconnectDiag.markAutoStart(jElapsedRealtime);
                    this.gatewayReconnectDiag.getAutoStarts().incrementAndGet();
                    Log.i("GatewayReconnect", "startGateway: attempt=" + this.gatewayAutoStartAttempts + " " + this.gatewayReconnectDiag.summary() + " msg=" + n.Q1(120, disconnectMessage));
                    GatewayAutoStart gatewayAutoStart = GatewayAutoStart.INSTANCE;
                    Context appContext = this.appContext;
                    kotlin.jvm.internal.p.d(appContext, "appContext");
                    int i9 = WhenMappings.$EnumSwitchMapping$0[GatewayAutoStart.startGateway$default(gatewayAutoStart, appContext, this.scope, gatewayEndpoint.getPort(), new a(this, gatewayEndpoint, 1), new z(4), null, 32, null).ordinal()];
                    if (i9 == 1) {
                        this.backupOnConnectDone = false;
                    } else if (i9 == 2) {
                        i0.q(this.scope, null, new GatewayRuntime$maybeAutoStartGateway$1$1(this, null), 3);
                    } else if (i9 != 3 && i9 != 4) {
                        throw new a6.w();
                    }
                    return;
                }
                this.gatewayAutoStartAttempts++;
                if (z) {
                    this.gatewayReconnectDiag.getSkippedCooldown().incrementAndGet();
                } else {
                    this.gatewayReconnectDiag.getSkippedNotTrigger().incrementAndGet();
                }
                long j4 = 0;
                if (this.gatewayReconnectDiag.getInvocations().get() % 25 == 0) {
                    String strSummary = this.gatewayReconnectDiag.summary();
                    int i10 = this.gatewayAutoStartAttempts;
                    long j8 = GatewayReconnectDiagnostics.AUTO_START_COOLDOWN_MS - (jElapsedRealtime - this.lastGatewayAutoStartMs);
                    if (j8 >= 0) {
                        j4 = j8;
                    }
                    Log.i("GatewayReconnect", "sample: " + strSummary + " attempt=" + i10 + " cooldownRemainingMs=" + j4 + " msg=" + n.Q1(80, disconnectMessage));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 maybeAutoStartGateway$lambda$0$0(GatewayRuntime gatewayRuntime, GatewayEndpoint gatewayEndpoint) {
        i0.q(gatewayRuntime.scope, null, new GatewayRuntime$maybeAutoStartGateway$1$result$1$1(gatewayEndpoint, gatewayRuntime, null), 3);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 maybeAutoStartGateway$lambda$0$1(String msg) {
        kotlin.jvm.internal.p.e(msg, "msg");
        Log.d("GatewayLog", msg);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 networkRecoveryMonitor$lambda$0(GatewayRuntime gatewayRuntime) {
        gatewayRuntime.onNetworkRecovered();
        return a0.f883a;
    }

    private final void onNetworkRecovered() {
        i0.q(this.scope, null, new C00021(null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshBrandingFromGateway(f5.c r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stepos.stepclaw.GatewayRuntime.C00031
            if (r0 == 0) goto L14
            r0 = r11
            com.stepos.stepclaw.GatewayRuntime$refreshBrandingFromGateway$1 r0 = (com.stepos.stepclaw.GatewayRuntime.C00031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.stepclaw.GatewayRuntime$refreshBrandingFromGateway$1 r0 = new com.stepos.stepclaw.GatewayRuntime$refreshBrandingFromGateway$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            g5.a r0 = g5.a.f2984a
            int r1 = r6.label
            b5.a0 r9 = b5.a0.f883a
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            a.a.c0(r11)     // Catch: java.lang.Throwable -> La0
            goto L5b
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            a.a.c0(r11)
            d6.u r11 = r10._isConnected
            d6.y r11 = (d6.y) r11
            java.lang.Object r11 = r11.getValue()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L47
            return r9
        L47:
            com.stepos.stepclaw.gateway.GatewaySession r1 = r10.gatewaySession     // Catch: java.lang.Throwable -> La0
            r11 = r2
            java.lang.String r2 = "config.get"
            java.lang.String r3 = "{}"
            r6.label = r11     // Catch: java.lang.Throwable -> La0
            r4 = 0
            r7 = 4
            r8 = 0
            java.lang.Object r11 = com.stepos.stepclaw.gateway.GatewaySession.request$default(r1, r2, r3, r4, r6, r7, r8)     // Catch: java.lang.Throwable -> La0
            if (r11 != r0) goto L5b
            return r0
        L5b:
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> La0
            com.stepos.stepclaw.GatewayRuntime$Companion r0 = com.stepos.stepclaw.GatewayRuntime.Companion     // Catch: java.lang.Throwable -> La0
            kotlinx.serialization.json.Json r1 = r10.json     // Catch: java.lang.Throwable -> La0
            kotlinx.serialization.json.JsonElement r11 = r1.parseToJsonElement(r11)     // Catch: java.lang.Throwable -> La0
            kotlinx.serialization.json.JsonObject r11 = com.stepos.stepclaw.GatewayRuntime.Companion.access$asObject(r0, r11)     // Catch: java.lang.Throwable -> La0
            r1 = 0
            if (r11 == 0) goto L75
            java.lang.String r2 = "config"
            java.lang.Object r11 = r11.get(r2)     // Catch: java.lang.Throwable -> La0
            kotlinx.serialization.json.JsonElement r11 = (kotlinx.serialization.json.JsonElement) r11     // Catch: java.lang.Throwable -> La0
            goto L76
        L75:
            r11 = r1
        L76:
            kotlinx.serialization.json.JsonObject r11 = com.stepos.stepclaw.GatewayRuntime.Companion.access$asObject(r0, r11)     // Catch: java.lang.Throwable -> La0
            if (r11 == 0) goto L85
            java.lang.String r2 = "session"
            java.lang.Object r11 = r11.get(r2)     // Catch: java.lang.Throwable -> La0
            kotlinx.serialization.json.JsonElement r11 = (kotlinx.serialization.json.JsonElement) r11     // Catch: java.lang.Throwable -> La0
            goto L86
        L85:
            r11 = r1
        L86:
            kotlinx.serialization.json.JsonObject r11 = com.stepos.stepclaw.GatewayRuntime.Companion.access$asObject(r0, r11)     // Catch: java.lang.Throwable -> La0
            if (r11 == 0) goto L95
            java.lang.String r1 = "mainKey"
            java.lang.Object r11 = r11.get(r1)     // Catch: java.lang.Throwable -> La0
            r1 = r11
            kotlinx.serialization.json.JsonElement r1 = (kotlinx.serialization.json.JsonElement) r1     // Catch: java.lang.Throwable -> La0
        L95:
            java.lang.String r11 = com.stepos.stepclaw.GatewayRuntime.Companion.access$asString(r0, r1)     // Catch: java.lang.Throwable -> La0
            java.lang.String r11 = com.stepos.stepclaw.GatewayRuntime.Companion.access$normalizeMainKey(r0, r11)     // Catch: java.lang.Throwable -> La0
            r10.applyMainSessionKey(r11)     // Catch: java.lang.Throwable -> La0
        La0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.GatewayRuntime.refreshBrandingFromGateway(f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshGatewayConnection() {
        GatewayEndpoint gatewayEndpoint = this.connectedEndpoint;
        if (gatewayEndpoint == null) {
            return;
        }
        updateStatus();
        this.gatewaySession.connect(gatewayEndpoint, this.prefs.loadGatewayToken(), this.prefs.loadGatewayPassword(), this.connectionManager.buildOperatorConnectOptions(), this.connectionManager.resolveTlsParams(gatewayEndpoint));
        this.gatewaySession.reconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveMainSessionKey() {
        String string = n.T1((String) ((y) this._mainSessionKey).getValue()).toString();
        return string.length() == 0 ? "main" : string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerChrootOtaSelfHeal(String reason) {
        OpenClawRuntimeConfig.Companion companion = OpenClawRuntimeConfig.INSTANCE;
        Context appContext = this.appContext;
        kotlin.jvm.internal.p.d(appContext, "appContext");
        OpenClawRuntimeConfig openClawRuntimeConfigFromContext = companion.fromContext(appContext);
        if (!openClawRuntimeConfigFromContext.getRootfsRoot().isDirectory()) {
            Log.e(TAG, a8.b.q("triggerChrootOtaSelfHeal(", reason, "): rootfs not mounted at ", openClawRuntimeConfigFromContext.getRootfsRoot().getAbsolutePath(), " — cannot npm install until system remounts rootfs (e.g. ubuntu.img restored). If only the gateway npm package is missing, rootfs must still be mounted."));
            return;
        }
        GatewayEndpoint gatewayEndpoint = this.connectedEndpoint;
        if (gatewayEndpoint == null) {
            Log.w(TAG, "triggerChrootOtaSelfHeal(" + reason + "): connectedEndpoint still null after ensureLoopbackEndpoint");
            return;
        }
        String lowerCase = gatewayEndpoint.getHost().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        if (!lowerCase.equals("127.0.0.1") && !lowerCase.equals("localhost") && !x5.u.c1(lowerCase, "127.", false) && !lowerCase.equals("::1")) {
            String host = gatewayEndpoint.getHost();
            int port = gatewayEndpoint.getPort();
            StringBuilder sbV = a8.b.v("triggerChrootOtaSelfHeal(", reason, "): skipping non-loopback endpoint ", host, ":");
            sbV.append(port);
            Log.w(TAG, sbV.toString());
            return;
        }
        Log.i(TAG, "triggerChrootOtaSelfHeal(" + reason + "): invoking GatewayAutoStart.startGateway");
        GatewayAutoStart gatewayAutoStart = GatewayAutoStart.INSTANCE;
        Context appContext2 = this.appContext;
        kotlin.jvm.internal.p.d(appContext2, "appContext");
        GatewayAutoStart.Result resultStartGateway$default = GatewayAutoStart.startGateway$default(gatewayAutoStart, appContext2, this.scope, gatewayEndpoint.getPort(), new a(this, gatewayEndpoint, 0), new z(3), null, 32, null);
        Log.i(TAG, "triggerChrootOtaSelfHeal(" + reason + "): startGateway → " + resultStartGateway$default);
        int i8 = WhenMappings.$EnumSwitchMapping$0[resultStartGateway$default.ordinal()];
        if (i8 == 1) {
            this.backupOnConnectDone = false;
        } else if (i8 == 2) {
            i0.q(this.scope, null, new C00041(null), 3);
        } else if (i8 != 3 && i8 != 4) {
            throw new a6.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 triggerChrootOtaSelfHeal$lambda$0(GatewayRuntime gatewayRuntime, GatewayEndpoint gatewayEndpoint) {
        i0.q(gatewayRuntime.scope, null, new GatewayRuntime$triggerChrootOtaSelfHeal$result$1$1(gatewayEndpoint, gatewayRuntime, null), 3);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 triggerChrootOtaSelfHeal$lambda$1(String msg) {
        kotlin.jvm.internal.p.e(msg, "msg");
        Log.i("GatewayLog", msg);
        return a0.f883a;
    }

    private final void updateStatus() {
        u uVar = this._isConnected;
        Boolean boolValueOf = Boolean.valueOf(this.nodeConnected);
        y yVar = (y) uVar;
        yVar.getClass();
        yVar.c(null, boolValueOf);
    }

    public final void disconnect() {
        this.connectedEndpoint = null;
        this.gatewaySession.disconnect();
    }

    /* renamed from: isConnected, reason: from getter */
    public final w getIsConnected() {
        return this.isConnected;
    }
}
