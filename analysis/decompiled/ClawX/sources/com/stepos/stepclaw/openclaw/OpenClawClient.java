package com.stepos.stepclaw.openclaw;

import b5.a0;
import c5.o;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.bridge.openclaw.IOpenClawClient;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.gateway.d;
import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import h5.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import t3.c;
import t3.f;
import x5.n;
import z3.r0;
import z3.t0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001'B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J0\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0096@¢\u0006\u0004\b\u0016\u0010\u0015J\\\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00172\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2$\u0010\u001a\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0018H\u0096@¢\u0006\u0004\b\u0014\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cH\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010&¨\u0006("}, d2 = {"Lcom/stepos/stepclaw/openclaw/OpenClawClient;", "Lcom/stepos/stepclaw/bridge/openclaw/IOpenClawClient;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_BASE_URL, "Lt3/c;", "httpClient", "Lkotlinx/serialization/json/Json;", "json", "<init>", "(Ljava/lang/String;Lt3/c;Lkotlinx/serialization/json/Json;)V", "toolName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "args", "Lkotlinx/serialization/json/JsonObject;", "buildRequestBody", "(Ljava/lang/String;Ljava/util/Map;)Lkotlinx/serialization/json/JsonObject;", "getJson", "()Lkotlinx/serialization/json/Json;", "Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResponse;", "invokeTool", "(Ljava/lang/String;Ljava/util/Map;Lf5/c;)Ljava/lang/Object;", "invokeToolRaw", "T", "Lkotlin/Function2;", "Lkotlinx/serialization/json/JsonElement;", "parser", "(Ljava/lang/String;Ljava/util/Map;Lp5/p;Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "healthCheck", "(Lf5/c;)Ljava/lang/Object;", "Lb5/a0;", "close", "()V", "Ljava/lang/String;", "getBaseUrl", "()Ljava/lang/String;", "Lt3/c;", "Lkotlinx/serialization/json/Json;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OpenClawClient implements IOpenClawClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "OpenClawClient";
    private static volatile OpenClawClient instance;
    private final String baseUrl;
    private final c httpClient;
    private final Json json;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/stepclaw/openclaw/OpenClawClient$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "instance", "Lcom/stepos/stepclaw/openclaw/OpenClawClient;", "getInstance", ConfigIpcContract.KEY_BASE_URL, "create", "Lcom/stepos/stepclaw/bridge/openclaw/IOpenClawClient;", "init", "reconfigure", "createInstance", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private final OpenClawClient createInstance(String baseUrl) {
            Json jsonJson$default = JsonKt.Json$default(null, new d(12), 1, null);
            c cVarA = v.a(f.f5582a, new d(13));
            ALog.i$default(OpenClawClient.TAG, m0.f.c("OpenClawClient initialized: ", baseUrl), null, 4, null);
            return new OpenClawClient(n.V1(baseUrl, '/'), cVarA, jsonJson$default, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final a0 createInstance$lambda$0(JsonBuilder Json) {
            p.e(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
            Json.setEncodeDefaults(true);
            Json.setLenient(true);
            return a0.f883a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final a0 createInstance$lambda$1(t3.d HttpClient) {
            p.e(HttpClient, "$this$HttpClient");
            HttpClient.a(t0.f6509b, new d(11));
            return a0.f883a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final a0 createInstance$lambda$1$0(r0 install) {
            p.e(install, "$this$install");
            install.b(Long.valueOf(LightMemClient.OFFLINE_ASYNC_POLL_INTERVAL_TEST_MS));
            install.d(30000L);
            install.c(60000L);
            return a0.f883a;
        }

        public static /* synthetic */ OpenClawClient getInstance$default(Companion companion, String str, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = null;
            }
            return companion.getInstance(str);
        }

        public final IOpenClawClient create() {
            OpenClawClient openClawClient = OpenClawClient.instance;
            if (openClawClient != null) {
                return openClawClient;
            }
            throw new IllegalStateException("OpenClawClient not initialized; call OpenClawClient.init(baseUrl) first (typically from GatewayRuntime.onConnected)");
        }

        public final OpenClawClient getInstance(String baseUrl) {
            OpenClawClient openClawClientCreateInstance;
            if (baseUrl == null || n.t1(baseUrl)) {
                return OpenClawClient.instance;
            }
            OpenClawClient openClawClient = OpenClawClient.instance;
            if (openClawClient != null) {
                return openClawClient;
            }
            synchronized (this) {
                openClawClientCreateInstance = OpenClawClient.instance;
                if (openClawClientCreateInstance == null) {
                    openClawClientCreateInstance = OpenClawClient.INSTANCE.createInstance(baseUrl);
                    OpenClawClient.instance = openClawClientCreateInstance;
                }
            }
            return openClawClientCreateInstance;
        }

        public final OpenClawClient init(String baseUrl) {
            p.e(baseUrl, "baseUrl");
            ALog.i$default(OpenClawClient.TAG, "OpenClaw Gateway initialized: ".concat(baseUrl), null, 4, null);
            OpenClawClient openClawClient = OpenClawClient.instance;
            if (openClawClient != null && p.a(openClawClient.getBaseUrl(), baseUrl)) {
                return openClawClient;
            }
            synchronized (this) {
                OpenClawClient openClawClient2 = OpenClawClient.instance;
                if (openClawClient2 != null && p.a(openClawClient2.getBaseUrl(), baseUrl)) {
                    return openClawClient2;
                }
                OpenClawClient openClawClientCreateInstance = OpenClawClient.INSTANCE.createInstance(baseUrl);
                OpenClawClient.instance = openClawClientCreateInstance;
                return openClawClientCreateInstance;
            }
        }

        public final OpenClawClient reconfigure(String baseUrl) {
            OpenClawClient openClawClientCreateInstance;
            p.e(baseUrl, "baseUrl");
            synchronized (this) {
                try {
                    OpenClawClient openClawClient = OpenClawClient.instance;
                    if (openClawClient != null) {
                        openClawClient.close();
                    }
                    openClawClientCreateInstance = OpenClawClient.INSTANCE.createInstance(baseUrl);
                    OpenClawClient.instance = openClawClientCreateInstance;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return openClawClientCreateInstance;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.openclaw.OpenClawClient", f = "OpenClawClient.kt", l = {267}, m = "healthCheck", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.openclaw.OpenClawClient$healthCheck$1, reason: invalid class name */
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
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OpenClawClient.this.healthCheck(this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.openclaw.OpenClawClient", f = "OpenClawClient.kt", l = {295, 296}, m = "invokeTool", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.openclaw.OpenClawClient$invokeTool$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00731 extends h5.c {
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
        int label;
        /* synthetic */ Object result;

        public C00731(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OpenClawClient.this.invokeTool(null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @e(c = "com.stepos.stepclaw.openclaw.OpenClawClient", f = "OpenClawClient.kt", l = {162}, m = "invokeTool", v = 1)
    /* renamed from: com.stepos.stepclaw.openclaw.OpenClawClient$invokeTool$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends h5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OpenClawClient.this.invokeTool(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.openclaw.OpenClawClient", f = "OpenClawClient.kt", l = {295, 296}, m = "invokeToolRaw", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.openclaw.OpenClawClient$invokeToolRaw$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00741 extends h5.c {
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
        int label;
        /* synthetic */ Object result;

        public C00741(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OpenClawClient.this.invokeToolRaw(null, null, this);
        }
    }

    public /* synthetic */ OpenClawClient(String str, c cVar, Json json, i iVar) {
        this(str, cVar, json);
    }

    private final JsonObject buildRequestBody(String toolName, Map<String, ? extends Object> args) {
        JsonElement jsonElementJsonPrimitive;
        String string;
        String string2;
        JsonElement jsonElementJsonPrimitive2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(z.T(args.size()));
        Iterator<T> it = args.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                jsonElementJsonPrimitive = JsonElementKt.JsonPrimitive((String) value);
            } else if (value instanceof Number) {
                jsonElementJsonPrimitive = JsonElementKt.JsonPrimitive((Number) value);
            } else if (value instanceof Boolean) {
                jsonElementJsonPrimitive = JsonElementKt.JsonPrimitive((Boolean) value);
            } else if (value instanceof JsonElement) {
                jsonElementJsonPrimitive = (JsonElement) value;
            } else if (value instanceof Map) {
                jsonElementJsonPrimitive = new JsonObject((Map) value);
            } else {
                boolean z = value instanceof List;
                String str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                if (z) {
                    Iterable iterable = (Iterable) value;
                    ArrayList arrayList = new ArrayList(o.n0(iterable, 10));
                    for (Object obj : iterable) {
                        if (obj instanceof String) {
                            jsonElementJsonPrimitive2 = JsonElementKt.JsonPrimitive((String) obj);
                        } else if (obj instanceof Number) {
                            jsonElementJsonPrimitive2 = JsonElementKt.JsonPrimitive((Number) obj);
                        } else if (obj instanceof Boolean) {
                            jsonElementJsonPrimitive2 = JsonElementKt.JsonPrimitive((Boolean) obj);
                        } else if (obj instanceof JsonElement) {
                            jsonElementJsonPrimitive2 = (JsonElement) obj;
                        } else {
                            if (obj == null || (string2 = obj.toString()) == null) {
                                string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                            }
                            jsonElementJsonPrimitive2 = JsonElementKt.JsonPrimitive(string2);
                        }
                        arrayList.add(jsonElementJsonPrimitive2);
                    }
                    jsonElementJsonPrimitive = new JsonArray(arrayList);
                } else {
                    if (value != null && (string = value.toString()) != null) {
                        str = string;
                    }
                    jsonElementJsonPrimitive = JsonElementKt.JsonPrimitive(str);
                }
            }
            linkedHashMap.put(key, jsonElementJsonPrimitive);
        }
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, ExtensionCallContract.KIND_TOOL, toolName);
        jsonObjectBuilder.put("args", new JsonObject(linkedHashMap));
        return jsonObjectBuilder.build();
    }

    public static final IOpenClawClient create() {
        return INSTANCE.create();
    }

    public final void close() {
        try {
            this.httpClient.close();
            ALog.i$default(TAG, "OpenClawClient closed", null, 4, null);
        } catch (Exception e9) {
            ALog.w$default(TAG, m0.f.c("close error: ", e9.getMessage()), null, 4, null);
        }
    }

    @Override // com.stepos.stepclaw.bridge.openclaw.IOpenClawClient
    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Override // com.stepos.stepclaw.bridge.openclaw.IOpenClawClient
    public Json getJson() {
        return this.json;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.stepclaw.bridge.openclaw.IOpenClawClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object healthCheck(f5.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stepos.stepclaw.openclaw.OpenClawClient.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.stepclaw.openclaw.OpenClawClient$healthCheck$1 r0 = (com.stepos.stepclaw.openclaw.OpenClawClient.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.openclaw.OpenClawClient$healthCheck$1 r0 = new com.stepos.stepclaw.openclaw.OpenClawClient$healthCheck$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            r5 = 0
            if (r2 == 0) goto L4b
            if (r2 != r3) goto L43
            java.lang.Object r6 = r0.L$5
            t3.c r6 = (t3.c) r6
            java.lang.Object r6 = r0.L$4
            f4.c r6 = (f4.c) r6
            java.lang.Object r6 = r0.L$3
            t3.c r6 = (t3.c) r6
            java.lang.Object r6 = r0.L$2
            t3.c r6 = (t3.c) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            t3.c r6 = (t3.c) r6
            a.a.c0(r7)     // Catch: java.lang.Exception -> L41
            goto L94
        L41:
            r6 = move-exception
            goto La8
        L43:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L4b:
            a.a.c0(r7)
            t3.c r7 = r6.httpClient     // Catch: java.lang.Exception -> L41
            java.lang.String r6 = r6.getBaseUrl()     // Catch: java.lang.Exception -> L41
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L41
            r2.<init>()     // Catch: java.lang.Exception -> L41
            r2.append(r6)     // Catch: java.lang.Exception -> L41
            java.lang.String r6 = "/health"
            r2.append(r6)     // Catch: java.lang.Exception -> L41
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Exception -> L41
            f4.c r2 = new f4.c     // Catch: java.lang.Exception -> L41
            r2.<init>()     // Catch: java.lang.Exception -> L41
            f4.e.a(r2, r6)     // Catch: java.lang.Exception -> L41
            k4.w r6 = k4.w.f3637b     // Catch: java.lang.Exception -> L41
            r2.c(r6)     // Catch: java.lang.Exception -> L41
            androidx.emoji2.text.p r6 = new androidx.emoji2.text.p     // Catch: java.lang.Exception -> L41
            r6.<init>(r2, r7)     // Catch: java.lang.Exception -> L41
            r0.L$0 = r5     // Catch: java.lang.Exception -> L41
            r0.L$1 = r5     // Catch: java.lang.Exception -> L41
            r0.L$2 = r5     // Catch: java.lang.Exception -> L41
            r0.L$3 = r5     // Catch: java.lang.Exception -> L41
            r0.L$4 = r5     // Catch: java.lang.Exception -> L41
            r0.L$5 = r5     // Catch: java.lang.Exception -> L41
            r0.I$0 = r4     // Catch: java.lang.Exception -> L41
            r0.I$1 = r4     // Catch: java.lang.Exception -> L41
            r0.I$2 = r4     // Catch: java.lang.Exception -> L41
            r0.I$3 = r4     // Catch: java.lang.Exception -> L41
            r0.label = r3     // Catch: java.lang.Exception -> L41
            java.lang.Object r7 = r6.j(r0)     // Catch: java.lang.Exception -> L41
            if (r7 != r1) goto L94
            return r1
        L94:
            h4.c r7 = (h4.c) r7     // Catch: java.lang.Exception -> L41
            k4.y r6 = r7.g()     // Catch: java.lang.Exception -> L41
            int r6 = r6.f3651a     // Catch: java.lang.Exception -> L41
            r7 = 200(0xc8, float:2.8E-43)
            if (r7 > r6) goto La5
            r7 = 300(0x12c, float:4.2E-43)
            if (r6 >= r7) goto La5
            goto La6
        La5:
            r3 = r4
        La6:
            r4 = r3
            goto Lb8
        La8:
            java.lang.String r6 = r6.getMessage()
            java.lang.String r7 = "healthCheck failed: "
            java.lang.String r6 = m0.f.c(r7, r6)
            r7 = 4
            java.lang.String r0 = "OpenClawClient"
            com.stepos.stepclaw.base.util.ALog.w$default(r0, r6, r5, r7, r5)
        Lb8:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.openclaw.OpenClawClient.healthCheck(f5.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:4|(1:6)(1:7))(0)|8|51|(1:(1:(3:12|13|(2:46|58)(2:47|48))(2:17|18))(2:19|20))(6:22|23|(4:25|56|26|29)(4:30|52|31|34)|35|(1:37)|44)|38|54|39|42|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0105, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0123, code lost:
    
        if (r15 == r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.stepclaw.bridge.openclaw.IOpenClawClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invokeTool(java.lang.String r13, java.util.Map<java.lang.String, ? extends java.lang.Object> r14, f5.c r15) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.openclaw.OpenClawClient.invokeTool(java.lang.String, java.util.Map, f5.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:4|(1:6)(1:7))(0)|8|60|(1:(1:(3:12|13|(2:46|(1:67)(2:54|68))(2:56|57))(2:17|18))(2:19|20))(6:22|23|(4:25|65|26|29)(4:30|61|31|34)|35|(1:37)|44)|38|63|39|42|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0105, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0123, code lost:
    
        if (r15 == r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.stepclaw.bridge.openclaw.IOpenClawClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invokeToolRaw(java.lang.String r13, java.util.Map<java.lang.String, ? extends java.lang.Object> r14, f5.c r15) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.openclaw.OpenClawClient.invokeToolRaw(java.lang.String, java.util.Map, f5.c):java.lang.Object");
    }

    private OpenClawClient(String str, c cVar, Json json) {
        this.baseUrl = str;
        this.httpClient = cVar;
        this.json = json;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.stepclaw.bridge.openclaw.IOpenClawClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> java.lang.Object invokeTool(java.lang.String r6, java.util.Map<java.lang.String, ? extends java.lang.Object> r7, p5.p r8, f5.c r9) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.openclaw.OpenClawClient.invokeTool(java.lang.String, java.util.Map, p5.p, f5.c):java.lang.Object");
    }
}
