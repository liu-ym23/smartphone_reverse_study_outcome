package com.stepos.stepclaw.memory.embedding;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.gateway.GatewayReconnectDiagnostics;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import java.util.Iterator;
import java.util.List;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import x5.u;
import z3.r0;
import z3.t0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u00015B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u001b\u0010\u001b\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u0017J\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J$\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0096@¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b)\u0010(R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010*R$\u0010\u0005\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b,\u0010(R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010-R$\u0010\b\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b.\u0010(R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/RemoteEmbeddingProvider;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "id", "displayName", ConfigIpcContract.KEY_BASE_URL, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "apiKeys", ConfigIpcContract.KEY_MODEL, "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "status", "body", ConfigIpcContract.KEY_API_KEY, "Lcom/stepos/stepclaw/memory/embedding/EmbeddingException;", "parseErrorResponse", "(ILjava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/embedding/EmbeddingException;", "newUrl", "Lb5/a0;", "updateBaseUrl", "(Ljava/lang/String;)V", "newKey", "updateApiKey", "newKeys", "updateApiKeys", "(Ljava/util/List;)V", "newModel", "updateModel", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isAvailable", "()Z", "texts", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "embed", "(Ljava/util/List;Lf5/c;)Ljava/lang/Object;", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getDisplayName", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "value", "getBaseUrl", "Ljava/util/List;", "getModel", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "Lt3/c;", "httpClient", "Lt3/c;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RemoteEmbeddingProvider implements EmbeddingProvider {
    private static final String TAG = "RemoteEmbeddingProvider";
    private volatile List<String> apiKeys;
    private volatile String baseUrl;
    private final String displayName;
    private final t3.c httpClient;
    private final String id;
    private final Json json;
    private final MemoryLogger logger;
    private volatile String model;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.embedding.RemoteEmbeddingProvider", f = "RemoteEmbeddingProvider.kt", l = {191, 102}, m = "embed", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.embedding.RemoteEmbeddingProvider$embed$1, reason: invalid class name */
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
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteEmbeddingProvider.this.embed(null, this);
        }
    }

    public RemoteEmbeddingProvider(String id, String displayName, String baseUrl, List<String> apiKeys, String model, MemoryLogger logger) {
        p.e(id, "id");
        p.e(displayName, "displayName");
        p.e(baseUrl, "baseUrl");
        p.e(apiKeys, "apiKeys");
        p.e(model, "model");
        p.e(logger, "logger");
        this.id = id;
        this.displayName = displayName;
        this.logger = logger;
        EmbeddingProvider.INSTANCE.requireValidId(getId());
        if (!u.c1(getId(), "remote-", false)) {
            throw new IllegalArgumentException(m0.f.d("RemoteEmbeddingProvider id '", getId(), "' must start with 'remote-'").toString());
        }
        this.baseUrl = baseUrl;
        this.apiKeys = c5.m.N0(apiKeys);
        this.model = model;
        this.json = JsonKt.Json$default(null, new d(3), 1, null);
        this.httpClient = v.a(x3.a.f6253a, new n(1, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 embed$lambda$0$0(List list, JsonArrayBuilder putJsonArray) {
        p.e(putJsonArray, "$this$putJsonArray");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            putJsonArray.add(JsonElementKt.JsonPrimitive((String) it.next()));
        }
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String embed$lambda$2(RemoteEmbeddingProvider remoteEmbeddingProvider, List list, String str) {
        String id = remoteEmbeddingProvider.getId();
        int size = list.size();
        String str2 = remoteEmbeddingProvider.model;
        String strQ1 = x5.n.Q1(80, str);
        StringBuilder sbU = a8.b.u("embed ok (", size, id, ", ", " texts, model=");
        sbU.append(str2);
        sbU.append("): ");
        sbU.append(strQ1);
        return sbU.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0(RemoteEmbeddingProvider remoteEmbeddingProvider, t3.d HttpClient) {
        p.e(HttpClient, "$this$HttpClient");
        HttpClient.a(b4.i.d, new n(0, remoteEmbeddingProvider));
        HttpClient.a(t0.f6509b, new d(2));
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0$0(RemoteEmbeddingProvider remoteEmbeddingProvider, b4.c install) {
        p.e(install, "$this$install");
        q4.c.a(install, remoteEmbeddingProvider.json);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0$1(r0 install) {
        p.e(install, "$this$install");
        install.b(Long.valueOf(GatewayReconnectDiagnostics.AUTO_START_COOLDOWN_MS));
        install.d(30000L);
        install.c(60000L);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        return a0.f883a;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.stepclaw.memory.embedding.EmbeddingException parseErrorResponse(int r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.embedding.RemoteEmbeddingProvider.parseErrorResponse(int, java.lang.String, java.lang.String):com.stepos.stepclaw.memory.embedding.EmbeddingException");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parseErrorResponse$lambda$2(RemoteEmbeddingProvider remoteEmbeddingProvider, String str) {
        return a8.b.p("embed error (", remoteEmbeddingProvider.getId(), "): ", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.stepos.stepclaw.memory.embedding.EmbeddingProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object embed(java.util.List<java.lang.String> r18, f5.c r19) throws b4.a, com.stepos.stepclaw.memory.embedding.EmbeddingException {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.embedding.RemoteEmbeddingProvider.embed(java.util.List, f5.c):java.lang.Object");
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Override // com.stepos.stepclaw.memory.embedding.EmbeddingProvider
    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.stepos.stepclaw.memory.embedding.EmbeddingProvider
    public String getId() {
        return this.id;
    }

    public final String getModel() {
        return this.model;
    }

    @Override // com.stepos.stepclaw.memory.embedding.EmbeddingProvider
    public boolean isAvailable() {
        return (x5.n.t1(this.baseUrl) || this.apiKeys.isEmpty()) ? false : true;
    }

    public final void updateApiKey(String newKey) {
        p.e(newKey, "newKey");
        this.apiKeys = a.a.S(newKey);
    }

    public final void updateApiKeys(List<String> newKeys) {
        p.e(newKeys, "newKeys");
        this.apiKeys = c5.m.N0(newKeys);
    }

    public final void updateBaseUrl(String newUrl) {
        p.e(newUrl, "newUrl");
        this.baseUrl = newUrl;
    }

    public final void updateModel(String newModel) {
        p.e(newModel, "newModel");
        this.model = newModel;
    }

    public /* synthetic */ RemoteEmbeddingProvider(String str, String str2, String str3, List list, String str4, MemoryLogger memoryLogger, int i8, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, list, str4, (i8 & 32) != 0 ? new AndroidMemoryLogger() : memoryLogger);
    }
}
