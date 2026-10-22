package com.stepos.stepclaw.memory.lightmem;

import b4.i;
import b5.a0;
import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.net.StepOSHeadersProvider;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.memory.lightmem.remote.AsyncTaskStatus;
import com.stepos.stepclaw.memory.lightmem.remote.AsyncTaskStatusKt;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionDeleteMemory;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionGroup;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerFirstRequest;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerPollRequest;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerResponse;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateFirstRequest;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdatePollRequest;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import java.io.IOException;
import java.nio.channels.UnresolvedAddressException;
import java.util.List;
import java.util.Map;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.w;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.bouncycastle.asn1.x509.DisplayText;
import x5.n;
import x5.u;
import z3.r0;
import z3.t0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ]2\u00020\u0001:\u0001]B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ2\u0010\u001e\u001a\u00020\u001d2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u001e\u0010\u001cJ\u0018\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0086@¢\u0006\u0004\b\"\u0010#J\u0018\u0010%\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b%\u0010&J\u0018\u0010)\u001a\u00020(2\u0006\u0010 \u001a\u00020'H\u0086@¢\u0006\u0004\b)\u0010*J\u0018\u0010+\u001a\u00020(2\u0006\u0010$\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b+\u0010&J\u0018\u0010-\u001a\u00020(2\u0006\u0010,\u001a\u00020'H\u0086@¢\u0006\u0004\b-\u0010*J\u000f\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100J3\u00105\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b5\u00106J\u001f\u00109\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0002H\u0002¢\u0006\u0004\b9\u0010:J#\u0010>\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u00022\n\u0010=\u001a\u00060;j\u0002`<H\u0002¢\u0006\u0004\b>\u0010?J \u0010C\u001a\u00020!2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010B\u001a\u00020AH\u0082@¢\u0006\u0004\bC\u0010DJ \u0010F\u001a\u00020(2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010E\u001a\u00020AH\u0082@¢\u0006\u0004\bF\u0010DJ\u0017\u0010H\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020(H\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020(H\u0002¢\u0006\u0004\bJ\u0010IR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010KR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010P\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010Q\u001a\u0004\bR\u0010SR$\u0010T\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006^"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_BASE_URL, "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "headersProvider", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Ljava/lang/String;Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", "newUrl", "Lb5/a0;", "updateBaseUrl", "(Ljava/lang/String;)V", "Lcom/stepos/stepclaw/memory/lightmem/LightMemException;", "exception", "getFriendlyErrorMessage", "(Lcom/stepos/stepclaw/memory/lightmem/LightMemException;)Ljava/lang/String;", "Lcom/stepos/stepclaw/memory/lightmem/remote/HealthResponse;", "health", "(Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", "messages", "modelName", "apiToken", "Lcom/stepos/stepclaw/memory/lightmem/remote/AutoRecallResponse;", "autoRecall", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/memory/lightmem/remote/AutoCatchResponse;", "autoCaptureV1", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerFirstRequest;", "request", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", "offlineTriggerFirst", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerFirstRequest;Lf5/c;)Ljava/lang/Object;", "uniqueId", "offlineTriggerPoll", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateFirstRequest;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", "offlineUpdateFirst", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateFirstRequest;Lf5/c;)Ljava/lang/Object;", "offlineUpdatePoll", "first", "offlineUpdateWithPolling", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "effectiveOfflineAsyncPollIntervalMs", "()J", "tag", "label", "text", "sessionId", "logLongToDebug", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "endpoint", "rawBody", "throwIfSpringStyleErrorJsonBody", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "handleError", "(Ljava/lang/String;Ljava/lang/Exception;)Lcom/stepos/stepclaw/memory/lightmem/LightMemException;", "body", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "messageCount", "postOfflineTrigger", "(Ljava/lang/Object;ILf5/c;)Ljava/lang/Object;", "groupCount", "postOfflineUpdate", "resp", "logEvolutionGroupsSummary", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;)V", "requireTerminalOfflineUpdateResponse", "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "value", "Ljava/lang/String;", "getBaseUrl", "()Ljava/lang/String;", "offlineAsyncPollIntervalMsOverride", "Ljava/lang/Long;", "getOfflineAsyncPollIntervalMsOverride", "()Ljava/lang/Long;", "setOfflineAsyncPollIntervalMsOverride", "(Ljava/lang/Long;)V", "Lt3/c;", "httpClient", "Lt3/c;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LightMemClient {
    private static final int OFFLINE_ASYNC_MAX_POLLS = 10;
    private static final long OFFLINE_ASYNC_POLL_INTERVAL_MS = 120000;
    public static final long OFFLINE_ASYNC_POLL_INTERVAL_TEST_MS = 10000;
    private static final String TAG = "LightMemClient";
    private volatile String baseUrl;
    private final StepOSHeadersProvider headersProvider;
    private final t3.c httpClient;
    private final Json json;
    private final MemoryLogger logger;
    private volatile Long offlineAsyncPollIntervalMsOverride;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.LightMemClient", f = "LightMemClient.kt", l = {602, 302}, m = "autoCaptureV1", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.LightMemClient$autoCaptureV1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LightMemClient.this.autoCaptureV1(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.LightMemClient", f = "LightMemClient.kt", l = {602, 270}, m = "autoRecall", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.LightMemClient$autoRecall$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00441 extends h5.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C00441(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LightMemClient.this.autoRecall(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.LightMemClient", f = "LightMemClient.kt", l = {570, 571, 590}, m = "health", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.LightMemClient$health$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00451 extends h5.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C00451(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LightMemClient.this.health(this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.LightMemClient", f = "LightMemClient.kt", l = {488, 506, 508}, m = "offlineUpdateWithPolling", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.LightMemClient$offlineUpdateWithPolling$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00461 extends h5.c {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C00461(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LightMemClient.this.offlineUpdateWithPolling(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.LightMemClient", f = "LightMemClient.kt", l = {636, 356, 378}, m = "postOfflineTrigger", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.LightMemClient$postOfflineTrigger$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00471 extends h5.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C00471(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LightMemClient.this.postOfflineTrigger(null, 0, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.LightMemClient", f = "LightMemClient.kt", l = {637, 440, 461}, m = "postOfflineUpdate", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.LightMemClient$postOfflineUpdate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00481 extends h5.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C00481(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LightMemClient.this.postOfflineUpdate(null, 0, this);
        }
    }

    public LightMemClient(String baseUrl, StepOSHeadersProvider stepOSHeadersProvider, MemoryLogger memoryLogger) {
        p.e(baseUrl, "baseUrl");
        this.headersProvider = stepOSHeadersProvider;
        this.logger = memoryLogger;
        this.json = JsonKt.Json$default(null, new com.stepos.stepclaw.gateway.d(4), 1, null);
        this.baseUrl = baseUrl;
        this.httpClient = v.a(x3.a.f6253a, new h(this, 0));
    }

    public static /* synthetic */ Object autoCaptureV1$default(LightMemClient lightMemClient, List list, String str, String str2, f5.c cVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if ((i8 & 4) != 0) {
            str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        return lightMemClient.autoCaptureV1(list, str, str2, cVar);
    }

    public static /* synthetic */ Object autoRecall$default(LightMemClient lightMemClient, List list, String str, String str2, f5.c cVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if ((i8 & 4) != 0) {
            str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        return lightMemClient.autoRecall(list, str, str2, cVar);
    }

    private final long effectiveOfflineAsyncPollIntervalMs() {
        Long l3 = this.offlineAsyncPollIntervalMsOverride;
        return l3 != null ? l3.longValue() : OFFLINE_ASYNC_POLL_INTERVAL_MS;
    }

    private final LightMemException handleError(String endpoint, Exception e9) {
        if (!(e9 instanceof z3.e)) {
            return e9 instanceof IOException ? new LightMemException(a8.b.p("LightMem ", endpoint, " failed: Network error - ", e9.getMessage()), null, e9) : e9 instanceof UnresolvedAddressException ? new LightMemException(a8.b.p("LightMem ", endpoint, " failed: Cannot resolve server - ", e9.getMessage()), null, e9) : new LightMemException(a8.b.p("LightMem ", endpoint, " failed: ", e9.getMessage()), null, e9);
        }
        h4.c cVar = ((z3.e) e9).f6523a;
        int i8 = cVar.g().f3651a;
        String str = cVar.g().f3652b;
        StringBuilder sbU = a8.b.u("LightMem ", i8, endpoint, " failed with HTTP ", ": ");
        sbU.append(str);
        return new LightMemException(sbU.toString(), Integer.valueOf(cVar.g().f3651a), e9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0(LightMemClient lightMemClient, t3.d HttpClient) {
        p.e(HttpClient, "$this$HttpClient");
        HttpClient.a(i.d, new h(lightMemClient, 1));
        HttpClient.a(t0.f6509b, new com.stepos.stepclaw.gateway.d(5));
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0$0(LightMemClient lightMemClient, b4.c install) {
        p.e(install, "$this$install");
        q4.c.a(install, lightMemClient.json);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0$1(r0 install) {
        p.e(install, "$this$install");
        install.b(30000L);
        install.d(60000L);
        install.c(Long.valueOf(OFFLINE_ASYNC_POLL_INTERVAL_MS));
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    private final void logEvolutionGroupsSummary(OfflineUpdateResponse resp) {
        int i8 = 0;
        for (OfflineEvolutionGroup offlineEvolutionGroup : resp.getEvolution_groups()) {
            int i9 = i8 + 1;
            Map<String, List<CatchMemoryItem>> add_memories = offlineEvolutionGroup.getAdd_memories();
            String strA0 = m.A0(add_memories.entrySet(), null, null, null, new com.stepos.stepclaw.gateway.d(3), 31);
            MemoryLogger memoryLogger = this.logger;
            if (memoryLogger != null) {
                memoryLogger.logI(TAG, null, new c(i8, offlineEvolutionGroup, strA0));
            }
            for (Map.Entry<String, List<CatchMemoryItem>> entry : add_memories.entrySet()) {
                String key = entry.getKey();
                int i10 = 0;
                for (CatchMemoryItem catchMemoryItem : entry.getValue()) {
                    int i11 = i10 + 1;
                    MemoryLogger memoryLogger2 = this.logger;
                    if (memoryLogger2 != null) {
                        memoryLogger2.logD(TAG, null, new d(i8, key, i10, catchMemoryItem));
                    }
                    i10 = i11;
                }
            }
            int i12 = 0;
            for (OfflineEvolutionDeleteMemory offlineEvolutionDeleteMemory : offlineEvolutionGroup.getDelete_memories()) {
                int i13 = i12 + 1;
                MemoryLogger memoryLogger3 = this.logger;
                if (memoryLogger3 != null) {
                    memoryLogger3.logD(TAG, null, new e(offlineEvolutionDeleteMemory, i8, i12, 0));
                }
                i12 = i13;
            }
            i8 = i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence logEvolutionGroupsSummary$lambda$0(Map.Entry it) {
        p.e(it, "it");
        return it.getKey() + "=" + ((List) it.getValue()).size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String logEvolutionGroupsSummary$lambda$1(int i8, OfflineEvolutionGroup offlineEvolutionGroup, String str) {
        int group_id = offlineEvolutionGroup.getGroup_id();
        int size = offlineEvolutionGroup.getDelete_memories().size();
        StringBuilder sbT = a8.b.t("[offlineUpdate] evolution_groups[", i8, "] group_id=", group_id, ": add(");
        sbT.append(str);
        sbT.append("), delete=");
        sbT.append(size);
        return sbT.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String logEvolutionGroupsSummary$lambda$2(int i8, String str, int i9, CatchMemoryItem catchMemoryItem) {
        return "[offlineUpdate] group[" + i8 + "] add." + str + "[" + i9 + "]: content=" + n.Q1(80, catchMemoryItem.getContent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String logEvolutionGroupsSummary$lambda$3(int i8, int i9, OfflineEvolutionDeleteMemory offlineEvolutionDeleteMemory) {
        long memory_index = offlineEvolutionDeleteMemory.getMemory_index();
        String memory_type = offlineEvolutionDeleteMemory.getMemory_type();
        String strQ1 = n.Q1(80, offlineEvolutionDeleteMemory.getContent());
        StringBuilder sbT = a8.b.t("[offlineUpdate] group[", i8, "] delete[", i9, "]: memory_index=");
        sbT.append(memory_index);
        sbT.append(", memory_type=");
        sbT.append(memory_type);
        return m0.f.f(sbT, ", content=", strQ1);
    }

    private final void logLongToDebug(String tag, String label, String text, String sessionId) {
        final String str;
        final String str2;
        if (text.length() <= 3500) {
            MemoryLogger memoryLogger = this.logger;
            if (memoryLogger != null) {
                memoryLogger.logD(tag, sessionId, new f((Object) label, 0, (Object) text));
                return;
            }
            return;
        }
        final int length = (text.length() + 3499) / 3500;
        final w wVar = new w();
        final w wVar2 = new w();
        while (wVar.f3684a < text.length()) {
            final int iMin = Math.min(wVar.f3684a + 3500, text.length());
            wVar2.f3684a++;
            MemoryLogger memoryLogger2 = this.logger;
            if (memoryLogger2 != null) {
                str = label;
                str2 = text;
                memoryLogger2.logD(tag, sessionId, new p5.a() { // from class: com.stepos.stepclaw.memory.lightmem.g
                    @Override // p5.a
                    public final Object invoke() {
                        return LightMemClient.logLongToDebug$lambda$1(str, wVar2, length, str2, wVar, iMin);
                    }
                });
            } else {
                str = label;
                str2 = text;
            }
            wVar.f3684a = iMin;
            label = str;
            text = str2;
        }
    }

    public static /* synthetic */ void logLongToDebug$default(LightMemClient lightMemClient, String str, String str2, String str3, String str4, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            str4 = null;
        }
        lightMemClient.logLongToDebug(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String logLongToDebug$lambda$0(String str, String str2) {
        return a8.b.o(str, ": ", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String logLongToDebug$lambda$1(String str, w wVar, int i8, String str2, w wVar2, int i9) {
        int i10 = wVar.f3684a;
        String strSubstring = str2.substring(wVar2.f3684a, i9);
        p.d(strSubstring, "substring(...)");
        return str + " [" + i10 + "/" + i8 + "]: " + strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x037e, code lost:
    
        if (r2 == r12) goto L149;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x027e A[Catch: Exception -> 0x0188, LightMemException -> 0x018b, e -> 0x024c, TryCatch #8 {e -> 0x024c, blocks: (B:102:0x0278, B:104:0x027e, B:105:0x0288, B:109:0x0296, B:111:0x02b0, B:113:0x02bb, B:115:0x02bf, B:116:0x02ca, B:93:0x0234, B:95:0x0240, B:99:0x0251), top: B:166:0x0234 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02bf A[Catch: Exception -> 0x0188, LightMemException -> 0x018b, e -> 0x024c, TryCatch #8 {e -> 0x024c, blocks: (B:102:0x0278, B:104:0x027e, B:105:0x0288, B:109:0x0296, B:111:0x02b0, B:113:0x02bb, B:115:0x02bf, B:116:0x02ca, B:93:0x0234, B:95:0x0240, B:99:0x0251), top: B:166:0x0234 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0240 A[Catch: Exception -> 0x0188, LightMemException -> 0x018b, e -> 0x024c, TryCatch #8 {e -> 0x024c, blocks: (B:102:0x0278, B:104:0x027e, B:105:0x0288, B:109:0x0296, B:111:0x02b0, B:113:0x02bb, B:115:0x02bf, B:116:0x02ca, B:93:0x0234, B:95:0x0240, B:99:0x0251), top: B:166:0x0234 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object postOfflineTrigger(java.lang.Object r23, int r24, f5.c r25) throws com.stepos.stepclaw.memory.lightmem.LightMemException {
        /*
            Method dump skipped, instructions count: 969
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.LightMemClient.postOfflineTrigger(java.lang.Object, int, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String postOfflineTrigger$lambda$0(String str, String str2, int i8) {
        StringBuilder sbV = a8.b.v("[offlineTrigger] start, url=", str, ", pollId=", str2, ", messages=");
        sbV.append(i8);
        return sbV.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String postOfflineTrigger$lambda$2(h4.c cVar, long j4) {
        return "[offlineTrigger] HTTP response received, status=" + cVar.g().f3651a + ", elapsed=" + j4 + "ms";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String postOfflineTrigger$lambda$3(String str) {
        return "[offlineTrigger] response body length=" + str.length() + ", preview=" + n.Q1(DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String postOfflineTrigger$lambda$4(h4.c cVar) {
        return "[offlineTrigger] HTTP error: " + cVar.g().f3651a + " " + cVar.g().f3652b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String postOfflineTrigger$lambda$5(OfflineTriggerResponse offlineTriggerResponse, long j4) {
        String status = offlineTriggerResponse.getStatus();
        String strEffectiveTaskStatus = AsyncTaskStatusKt.effectiveTaskStatus(offlineTriggerResponse);
        String strEffectiveUniqueId = AsyncTaskStatusKt.effectiveUniqueId(offlineTriggerResponse);
        int size = offlineTriggerResponse.getSearch_groups().size();
        long jCurrentTimeMillis = System.currentTimeMillis() - j4;
        StringBuilder sbV = a8.b.v("[offlineTrigger] done, status=", status, ", task_status=", strEffectiveTaskStatus, ", unique_id=");
        sbV.append(strEffectiveUniqueId);
        sbV.append(", search_groups=");
        sbV.append(size);
        sbV.append(", elapsed=");
        return a8.b.r(sbV, jCurrentTimeMillis, "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String postOfflineTrigger$lambda$6(long j4, z3.e eVar) {
        return "[offlineTrigger] ClientRequestException after " + j4 + "ms: " + eVar.f6435b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String postOfflineTrigger$lambda$7(long j4, LightMemException lightMemException) {
        return "[offlineTrigger] LightMemException after " + (System.currentTimeMillis() - j4) + "ms: " + lightMemException.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String postOfflineTrigger$lambda$8(long j4, Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder("[offlineTrigger] Exception after ");
        sb.append(j4);
        sb.append("ms: ");
        sb.append(simpleName);
        return m0.f.f(sb, " - ", message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:32|(1:34)(2:35|(1:37)(2:126|127))|38|(1:40)(12:(12:43|(0)|47|(1:49)|131|50|(2:52|(1:54)(4:57|129|58|61))(2:62|(2:64|(1:66)(4:67|132|68|71))(2:112|113))|72|(1:76)|77|(3:80|140|81)|120)|46|47|(0)|131|50|(0)(0)|72|(2:74|76)|77|(0)|120)|41|47|(0)|131|50|(0)(0)|72|(0)|77|(0)|120) */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x030d, code lost:
    
        if (r2 == r12) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x016c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x016d, code lost:
    
        r5 = r26;
        r9 = r17;
        r7 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0233, code lost:
    
        if (r2 != r12) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0161 A[Catch: Exception -> 0x0085, e -> 0x016c, LightMemException -> 0x02e9, TryCatch #1 {e -> 0x016c, blocks: (B:84:0x0237, B:88:0x0253, B:90:0x026d, B:91:0x0278, B:93:0x0282, B:95:0x0286, B:50:0x014e, B:52:0x0161, B:54:0x0165, B:72:0x01ad, B:74:0x01b1, B:76:0x01b7, B:77:0x01db, B:57:0x0175, B:61:0x0181, B:62:0x018a, B:64:0x018e, B:66:0x0192, B:67:0x0199, B:71:0x01a5), top: B:131:0x014e }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018a A[Catch: Exception -> 0x0085, e -> 0x016c, LightMemException -> 0x02e9, TryCatch #1 {e -> 0x016c, blocks: (B:84:0x0237, B:88:0x0253, B:90:0x026d, B:91:0x0278, B:93:0x0282, B:95:0x0286, B:50:0x014e, B:52:0x0161, B:54:0x0165, B:72:0x01ad, B:74:0x01b1, B:76:0x01b7, B:77:0x01db, B:57:0x0175, B:61:0x0181, B:62:0x018a, B:64:0x018e, B:66:0x0192, B:67:0x0199, B:71:0x01a5), top: B:131:0x014e }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b1 A[Catch: Exception -> 0x0085, e -> 0x016c, LightMemException -> 0x02e9, TryCatch #1 {e -> 0x016c, blocks: (B:84:0x0237, B:88:0x0253, B:90:0x026d, B:91:0x0278, B:93:0x0282, B:95:0x0286, B:50:0x014e, B:52:0x0161, B:54:0x0165, B:72:0x01ad, B:74:0x01b1, B:76:0x01b7, B:77:0x01db, B:57:0x0175, B:61:0x0181, B:62:0x018a, B:64:0x018e, B:66:0x0192, B:67:0x0199, B:71:0x01a5), top: B:131:0x014e }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object postOfflineUpdate(java.lang.Object r24, int r25, f5.c r26) throws com.stepos.stepclaw.memory.lightmem.LightMemException {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.LightMemClient.postOfflineUpdate(java.lang.Object, int, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String postOfflineUpdate$lambda$1(String str, String str2, int i8) {
        StringBuilder sbV = a8.b.v("[offlineUpdate] start, url=", str, ", pollId=", str2, ", groups=");
        sbV.append(i8);
        return sbV.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String postOfflineUpdate$lambda$3(OfflineUpdateResponse offlineUpdateResponse) {
        String status = offlineUpdateResponse.getStatus();
        String strEffectiveTaskStatus = AsyncTaskStatusKt.effectiveTaskStatus(offlineUpdateResponse);
        String strEffectiveUniqueId = AsyncTaskStatusKt.effectiveUniqueId(offlineUpdateResponse);
        int size = offlineUpdateResponse.getEvolution_groups().size();
        StringBuilder sbV = a8.b.v("[offlineUpdate] done, status=", status, ", task_status=", strEffectiveTaskStatus, ", unique_id=");
        sbV.append(strEffectiveUniqueId);
        sbV.append(", evolution_groups=");
        sbV.append(size);
        return sbV.toString();
    }

    private final void requireTerminalOfflineUpdateResponse(OfflineUpdateResponse resp) throws LightMemException {
        AsyncTaskStatus asyncTaskStatus = AsyncTaskStatus.INSTANCE;
        if (asyncTaskStatus.isUpdateFailed(resp)) {
            return;
        }
        String strEffectiveTaskStatus = AsyncTaskStatusKt.effectiveTaskStatus(resp);
        if (asyncTaskStatus.isCompleted(strEffectiveTaskStatus)) {
            return;
        }
        if (n.t1(strEffectiveTaskStatus)) {
            strEffectiveTaskStatus = "(blank)";
        }
        throw new LightMemException("offline_update: requires terminal task_status completed or failed, got '" + ((Object) strEffectiveTaskStatus) + "' (status=" + resp.getStatus() + ")", null, null);
    }

    private final void throwIfSpringStyleErrorJsonBody(String endpoint, String rawBody) throws LightMemException {
        Integer numD1;
        JsonPrimitive jsonPrimitive;
        JsonPrimitive jsonPrimitive2;
        try {
            JsonObject jsonObject = JsonElementKt.getJsonObject(this.json.parseToJsonElement(rawBody));
            JsonElement jsonElement = (JsonElement) jsonObject.get((Object) "status");
            if (jsonElement == null) {
                return;
            }
            JsonPrimitive jsonPrimitive3 = JsonElementKt.getJsonPrimitive(jsonElement);
            if (jsonPrimitive3.getIsString() || (numD1 = u.d1(jsonPrimitive3.getContent())) == null) {
                return;
            }
            int iIntValue = numD1.intValue();
            JsonElement jsonElement2 = (JsonElement) jsonObject.get((Object) "error");
            String content = (jsonElement2 == null || (jsonPrimitive2 = JsonElementKt.getJsonPrimitive(jsonElement2)) == null) ? null : jsonPrimitive2.getContent();
            JsonElement jsonElement3 = (JsonElement) jsonObject.get((Object) "path");
            String content2 = (jsonElement3 == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement3)) == null) ? null : jsonPrimitive.getContent();
            if (content == null) {
                content = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (content2 == null) {
                content2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            StringBuilder sbU = a8.b.u("LightMem ", iIntValue, endpoint, " failed: HTTP ", " ");
            a8.b.A(sbU, content, " path=", content2, " | ");
            sbU.append(rawBody);
            throw new LightMemException(sbU.toString(), numD1, null);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0136, code lost:
    
        if (r12 == r3) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object autoCaptureV1(java.util.List<com.stepos.stepclaw.memory.lightmem.remote.MessageItem> r9, java.lang.String r10, java.lang.String r11, f5.c r12) throws com.stepos.stepclaw.memory.lightmem.LightMemException {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.LightMemClient.autoCaptureV1(java.util.List, java.lang.String, java.lang.String, f5.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0136, code lost:
    
        if (r12 == r2) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object autoRecall(java.util.List<com.stepos.stepclaw.memory.lightmem.remote.MessageItem> r9, java.lang.String r10, java.lang.String r11, f5.c r12) throws com.stepos.stepclaw.memory.lightmem.LightMemException {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.LightMemClient.autoRecall(java.util.List, java.lang.String, java.lang.String, f5.c):java.lang.Object");
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getFriendlyErrorMessage(LightMemException exception) {
        p.e(exception, "exception");
        Integer httpStatus = exception.getHttpStatus();
        if (httpStatus != null && httpStatus.intValue() == 502) {
            return "Health check failed: Server temporarily unavailable (502 Bad Gateway)";
        }
        Integer httpStatus2 = exception.getHttpStatus();
        if (httpStatus2 != null && httpStatus2.intValue() == 503) {
            return "Health check failed: Service temporarily unavailable (503 Service Unavailable)";
        }
        Integer httpStatus3 = exception.getHttpStatus();
        if (httpStatus3 != null && httpStatus3.intValue() == 500) {
            return "Health check failed: Internal server error (500)";
        }
        Integer httpStatus4 = exception.getHttpStatus();
        if (httpStatus4 != null && httpStatus4.intValue() == 404) {
            return "Health check failed: Endpoint not found (404)";
        }
        String message = exception.getMessage();
        if (message != null && n.g1(message, "Network error", true)) {
            return "Health check failed: Could not connect to server. Please check your network connection.";
        }
        String message2 = exception.getMessage();
        if (message2 != null && n.g1(message2, "Cannot resolve server", true)) {
            return "Health check failed: Server address cannot be resolved. Please check the server URL.";
        }
        String message3 = exception.getMessage();
        if (message3 != null && n.g1(message3, "Expected JSON but received", true)) {
            return "Health check failed: Server returned unexpected response format.";
        }
        String message4 = exception.getMessage();
        if (message4 == null) {
            message4 = "Unknown error";
        }
        return "Health check failed: ".concat(message4);
    }

    public final Long getOfflineAsyncPollIntervalMsOverride() {
        return this.offlineAsyncPollIntervalMsOverride;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x015e A[Catch: Exception -> 0x0050, TryCatch #0 {Exception -> 0x0050, blocks: (B:14:0x004b, B:55:0x015e, B:57:0x0161, B:58:0x0168, B:74:0x01c4, B:76:0x01f2, B:77:0x01f9, B:78:0x020d, B:24:0x0088, B:37:0x0108, B:41:0x0118, B:45:0x0126, B:47:0x012f, B:51:0x013d, B:59:0x0169, B:60:0x017d, B:27:0x0090, B:29:0x0094, B:31:0x009a, B:33:0x00b9, B:34:0x00dd), top: B:82:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0161 A[Catch: Exception -> 0x0050, TryCatch #0 {Exception -> 0x0050, blocks: (B:14:0x004b, B:55:0x015e, B:57:0x0161, B:58:0x0168, B:74:0x01c4, B:76:0x01f2, B:77:0x01f9, B:78:0x020d, B:24:0x0088, B:37:0x0108, B:41:0x0118, B:45:0x0126, B:47:0x012f, B:51:0x013d, B:59:0x0169, B:60:0x017d, B:27:0x0090, B:29:0x0094, B:31:0x009a, B:33:0x00b9, B:34:0x00dd), top: B:82:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b2 A[Catch: Exception -> 0x01c4, TRY_ENTER, TryCatch #3 {Exception -> 0x01c4, blocks: (B:21:0x0067, B:70:0x01b2, B:71:0x01bb, B:72:0x01c2), top: B:87:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01bb A[Catch: Exception -> 0x01c4, TryCatch #3 {Exception -> 0x01c4, blocks: (B:21:0x0067, B:70:0x01b2, B:71:0x01bb, B:72:0x01c2), top: B:87:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object health(f5.c r18) throws com.stepos.stepclaw.memory.lightmem.LightMemException {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.LightMemClient.health(f5.c):java.lang.Object");
    }

    public final Object offlineTriggerFirst(OfflineTriggerFirstRequest offlineTriggerFirstRequest, f5.c cVar) {
        return postOfflineTrigger(offlineTriggerFirstRequest, offlineTriggerFirstRequest.getMessages().size(), cVar);
    }

    public final Object offlineTriggerPoll(String str, f5.c cVar) {
        return postOfflineTrigger(new OfflineTriggerPollRequest(str), 0, cVar);
    }

    public final Object offlineUpdateFirst(OfflineUpdateFirstRequest offlineUpdateFirstRequest, f5.c cVar) {
        return postOfflineUpdate(offlineUpdateFirstRequest, offlineUpdateFirstRequest.getMessages().size(), cVar);
    }

    public final Object offlineUpdatePoll(String str, f5.c cVar) {
        return postOfflineUpdate(new OfflineUpdatePollRequest(str), 0, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x013f -> B:42:0x0140). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object offlineUpdateWithPolling(com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateFirstRequest r19, f5.c r20) throws com.stepos.stepclaw.memory.lightmem.LightMemException {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.LightMemClient.offlineUpdateWithPolling(com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateFirstRequest, f5.c):java.lang.Object");
    }

    public final void setOfflineAsyncPollIntervalMsOverride(Long l3) {
        this.offlineAsyncPollIntervalMsOverride = l3;
    }

    public final void updateBaseUrl(String newUrl) {
        p.e(newUrl, "newUrl");
        this.baseUrl = newUrl;
    }

    public /* synthetic */ LightMemClient(String str, StepOSHeadersProvider stepOSHeadersProvider, MemoryLogger memoryLogger, int i8, kotlin.jvm.internal.i iVar) {
        this(str, (i8 & 2) != 0 ? null : stepOSHeadersProvider, (i8 & 4) != 0 ? null : memoryLogger);
    }
}
