package com.stepos.stepclaw.openclaw.memory;

import a6.y;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.framework.ServiceLocator;
import com.stepos.stepclaw.bridge.openclaw.IOpenClawClient;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import d5.g;
import h5.c;
import h5.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ2\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u001d\u0010\u001bJ \u0010 \u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b \u0010!J4\u0010%\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b%\u0010&J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/stepos/stepclaw/openclaw/memory/MemoryTools;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/json/JsonElement;", "result", "Lcom/stepos/stepclaw/openclaw/memory/MemorySearchResult;", "parseSearchResult", "(Ljava/util/Map;)Lcom/stepos/stepclaw/openclaw/memory/MemorySearchResult;", "Lcom/stepos/stepclaw/openclaw/memory/MemoryGetResult;", "parseGetResult", "(Ljava/util/Map;)Lcom/stepos/stepclaw/openclaw/memory/MemoryGetResult;", "query", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "maxResults", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "minScore", "search", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Lf5/c;)Ljava/lang/Object;", "path", "from", "lines", "get", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lf5/c;)Ljava/lang/Object;", "searchAndCombine", "(Ljava/lang/String;ILf5/c;)Ljava/lang/Object;", "limit", "lcmGrep", "content", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "fsAppend", "(Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "embeddingThreshold", "jaccardThreshold", "Lcom/stepos/stepclaw/openclaw/memory/FsAppendMmrResult;", "fsAppendMmr", "(Ljava/lang/String;Ljava/lang/String;DDLf5/c;)Ljava/lang/Object;", "getOrEmpty", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryTools {
    public static final MemoryTools INSTANCE = new MemoryTools();
    private static final String TAG = "MemoryTools";

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.openclaw.memory.MemoryTools", f = "MemoryTools.kt", l = {212}, m = "fsAppend", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.openclaw.memory.MemoryTools$fsAppend$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryTools.this.fsAppend(null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.openclaw.memory.MemoryTools", f = "MemoryTools.kt", l = {250}, m = "fsAppendMmr", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.openclaw.memory.MemoryTools$fsAppendMmr$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00751 extends c {
        double D$0;
        double D$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C00751(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryTools.this.fsAppendMmr(null, null, 0.0d, 0.0d, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.openclaw.memory.MemoryTools", f = "MemoryTools.kt", l = {285}, m = "getOrEmpty", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.openclaw.memory.MemoryTools$getOrEmpty$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00761 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C00761(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryTools.this.getOrEmpty(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.openclaw.memory.MemoryTools", f = "MemoryTools.kt", l = {186}, m = "lcmGrep", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.openclaw.memory.MemoryTools$lcmGrep$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00771 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C00771(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryTools.this.lcmGrep(null, 0, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.openclaw.memory.MemoryTools", f = "MemoryTools.kt", l = {151}, m = "searchAndCombine", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.openclaw.memory.MemoryTools$searchAndCombine$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00781 extends c {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C00781(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryTools.this.searchAndCombine(null, 0, this);
        }
    }

    private MemoryTools() {
    }

    public static /* synthetic */ Object fsAppendMmr$default(MemoryTools memoryTools, String str, String str2, double d, double d9, f5.c cVar, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            d = 0.9d;
        }
        return memoryTools.fsAppendMmr(str, str2, d, (i8 & 8) != 0 ? 0.7d : d9, cVar);
    }

    public static /* synthetic */ Object get$default(MemoryTools memoryTools, String str, Integer num, Integer num2, f5.c cVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            num = null;
        }
        if ((i8 & 4) != 0) {
            num2 = null;
        }
        return memoryTools.get(str, num, num2, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemoryGetResult get$lambda$1(Map result, Json json) {
        p.e(result, "result");
        p.e(json, "json");
        return INSTANCE.parseGetResult(result);
    }

    public static /* synthetic */ Object lcmGrep$default(MemoryTools memoryTools, String str, int i8, f5.c cVar, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 10;
        }
        return memoryTools.lcmGrep(str, i8, cVar);
    }

    private final MemoryGetResult parseGetResult(Map<String, ? extends JsonElement> result) {
        String str;
        JsonPrimitive jsonPrimitive;
        String str2;
        JsonPrimitive jsonPrimitive2;
        JsonPrimitive jsonPrimitive3;
        JsonPrimitive jsonPrimitive4;
        JsonPrimitive jsonPrimitive5;
        JsonPrimitive jsonPrimitive6;
        String content;
        JsonPrimitive jsonPrimitive7;
        String content2;
        JsonPrimitive jsonPrimitive8;
        JsonPrimitive jsonPrimitive9;
        JsonElement jsonElement = result.get("disabled");
        boolean z = (jsonElement == null || (jsonPrimitive9 = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? false : JsonElementKt.getBoolean(jsonPrimitive9);
        JsonElement jsonElement2 = result.get("error");
        Integer numValueOf = null;
        if (jsonElement2 == null || (jsonPrimitive8 = JsonElementKt.getJsonPrimitive(jsonElement2)) == null || (content = jsonPrimitive8.getContent()) == null) {
            JsonElement jsonElement3 = result.get(ConfigIpcContract.KEY_ERROR_MESSAGE);
            if (jsonElement3 == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement3)) == null) {
                str = null;
            } else {
                String content3 = jsonPrimitive.getContent();
                str = content3;
            }
        } else {
            str = content3;
        }
        if (z || !(str == null || n.t1(str))) {
            return new MemoryGetResult((String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, Boolean.valueOf(z), (Boolean) null, str, (String) null, (String) null, 863, (i) null);
        }
        JsonElement jsonElement4 = result.get("path");
        String content4 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        String str3 = (jsonElement4 == null || (jsonPrimitive7 = JsonElementKt.getJsonPrimitive(jsonElement4)) == null || (content2 = jsonPrimitive7.getContent()) == null) ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : content2;
        JsonElement jsonElement5 = result.get("text");
        if (jsonElement5 == null || (jsonPrimitive6 = JsonElementKt.getJsonPrimitive(jsonElement5)) == null || (content = jsonPrimitive6.getContent()) == null) {
            JsonElement jsonElement6 = result.get("content");
            if (jsonElement6 != null && (jsonPrimitive2 = JsonElementKt.getJsonPrimitive(jsonElement6)) != null) {
                content4 = jsonPrimitive2.getContent();
            }
            str2 = content4;
        } else {
            str2 = content;
        }
        JsonElement jsonElement7 = result.get("startLine");
        Integer numValueOf2 = (jsonElement7 == null || (jsonPrimitive5 = JsonElementKt.getJsonPrimitive(jsonElement7)) == null) ? null : Integer.valueOf(JsonElementKt.getInt(jsonPrimitive5));
        JsonElement jsonElement8 = result.get("endLine");
        Integer numValueOf3 = (jsonElement8 == null || (jsonPrimitive4 = JsonElementKt.getJsonPrimitive(jsonElement8)) == null) ? null : Integer.valueOf(JsonElementKt.getInt(jsonPrimitive4));
        JsonElement jsonElement9 = result.get("lines");
        if (jsonElement9 != null && (jsonPrimitive3 = JsonElementKt.getJsonPrimitive(jsonElement9)) != null) {
            numValueOf = Integer.valueOf(JsonElementKt.getInt(jsonPrimitive3));
        }
        return new MemoryGetResult(str3, str2, numValueOf2, numValueOf3, numValueOf, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, 992, (i) null);
    }

    private final MemorySearchResult parseSearchResult(Map<String, ? extends JsonElement> result) {
        String str;
        JsonPrimitive jsonPrimitive;
        List arrayList;
        JsonPrimitive jsonPrimitive2;
        JsonPrimitive jsonPrimitive3;
        JsonPrimitive jsonPrimitive4;
        JsonPrimitive jsonPrimitive5;
        JsonPrimitive jsonPrimitive6;
        JsonPrimitive jsonPrimitive7;
        JsonPrimitive jsonPrimitive8;
        String content;
        JsonPrimitive jsonPrimitive9;
        JsonPrimitive jsonPrimitive10;
        JsonPrimitive jsonPrimitive11;
        JsonPrimitive jsonPrimitive12;
        JsonPrimitive jsonPrimitive13;
        String content2;
        JsonPrimitive jsonPrimitive14;
        JsonPrimitive jsonPrimitive15;
        JsonPrimitive jsonPrimitive16;
        JsonPrimitive jsonPrimitive17;
        JsonElement jsonElement = result.get("disabled");
        boolean z = (jsonElement == null || (jsonPrimitive17 = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? false : JsonElementKt.getBoolean(jsonPrimitive17);
        JsonElement jsonElement2 = result.get("unavailable");
        boolean z2 = (jsonElement2 == null || (jsonPrimitive16 = JsonElementKt.getJsonPrimitive(jsonElement2)) == null) ? false : JsonElementKt.getBoolean(jsonPrimitive16);
        JsonElement jsonElement3 = result.get("error");
        String content3 = null;
        if (jsonElement3 == null || (jsonPrimitive15 = JsonElementKt.getJsonPrimitive(jsonElement3)) == null || (content = jsonPrimitive15.getContent()) == null) {
            JsonElement jsonElement4 = result.get(ConfigIpcContract.KEY_ERROR_MESSAGE);
            if (jsonElement4 == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement4)) == null) {
                str = null;
            } else {
                String content4 = jsonPrimitive.getContent();
                str = content4;
            }
        } else {
            str = content4;
        }
        if (z || z2 || !(str == null || n.t1(str))) {
            return new MemorySearchResult((List) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, Boolean.valueOf(z), Boolean.valueOf(z2), str, (String) null, (String) null, 1599, (i) null);
        }
        JsonElement jsonElement5 = result.get("results");
        JsonArray jsonArray = jsonElement5 != null ? JsonElementKt.getJsonArray(jsonElement5) : null;
        if (jsonArray != null) {
            arrayList = new ArrayList();
            Iterator<JsonElement> it = jsonArray.iterator();
            while (it.hasNext()) {
                JsonObject jsonObject = JsonElementKt.getJsonObject(it.next());
                JsonElement jsonElement6 = (JsonElement) jsonObject.get((Object) "path");
                String str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                if (jsonElement6 == null || (jsonPrimitive14 = JsonElementKt.getJsonPrimitive(jsonElement6)) == null || (content = jsonPrimitive14.getContent()) == null) {
                    content = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                }
                JsonElement jsonElement7 = (JsonElement) jsonObject.get((Object) "snippet");
                if (jsonElement7 != null && (jsonPrimitive13 = JsonElementKt.getJsonPrimitive(jsonElement7)) != null && (content2 = jsonPrimitive13.getContent()) != null) {
                    str2 = content2;
                }
                JsonElement jsonElement8 = (JsonElement) jsonObject.get((Object) "startLine");
                int i8 = (jsonElement8 == null || (jsonPrimitive12 = JsonElementKt.getJsonPrimitive(jsonElement8)) == null) ? 0 : JsonElementKt.getInt(jsonPrimitive12);
                JsonElement jsonElement9 = (JsonElement) jsonObject.get((Object) "endLine");
                int i9 = (jsonElement9 == null || (jsonPrimitive11 = JsonElementKt.getJsonPrimitive(jsonElement9)) == null) ? 0 : JsonElementKt.getInt(jsonPrimitive11);
                JsonElement jsonElement10 = (JsonElement) jsonObject.get((Object) "score");
                double d = (jsonElement10 == null || (jsonPrimitive10 = JsonElementKt.getJsonPrimitive(jsonElement10)) == null) ? 0.0d : JsonElementKt.getDouble(jsonPrimitive10);
                JsonElement jsonElement11 = (JsonElement) jsonObject.get((Object) "citation");
                arrayList.add(new MemorySearchEntry(content, str2, i8, i9, d, (jsonElement11 == null || (jsonPrimitive9 = JsonElementKt.getJsonPrimitive(jsonElement11)) == null) ? null : jsonPrimitive9.getContent()));
            }
        } else {
            arrayList = s.f1092a;
        }
        List list = arrayList;
        JsonElement jsonElement12 = result.get(ConfigIpcContract.KEY_PROVIDER);
        String content5 = (jsonElement12 == null || (jsonPrimitive8 = JsonElementKt.getJsonPrimitive(jsonElement12)) == null) ? null : jsonPrimitive8.getContent();
        JsonElement jsonElement13 = result.get(ConfigIpcContract.KEY_MODEL);
        String content6 = (jsonElement13 == null || (jsonPrimitive7 = JsonElementKt.getJsonPrimitive(jsonElement13)) == null) ? null : jsonPrimitive7.getContent();
        JsonElement jsonElement14 = result.get("fallback");
        Boolean boolValueOf = (jsonElement14 == null || (jsonPrimitive6 = JsonElementKt.getJsonPrimitive(jsonElement14)) == null) ? null : Boolean.valueOf(JsonElementKt.getBoolean(jsonPrimitive6));
        JsonElement jsonElement15 = result.get("citations");
        String content7 = (jsonElement15 == null || (jsonPrimitive5 = JsonElementKt.getJsonPrimitive(jsonElement15)) == null) ? null : jsonPrimitive5.getContent();
        JsonElement jsonElement16 = result.get("mode");
        String content8 = (jsonElement16 == null || (jsonPrimitive4 = JsonElementKt.getJsonPrimitive(jsonElement16)) == null) ? null : jsonPrimitive4.getContent();
        JsonElement jsonElement17 = result.get("warning");
        String content9 = (jsonElement17 == null || (jsonPrimitive3 = JsonElementKt.getJsonPrimitive(jsonElement17)) == null) ? null : jsonPrimitive3.getContent();
        JsonElement jsonElement18 = result.get("action");
        if (jsonElement18 != null && (jsonPrimitive2 = JsonElementKt.getJsonPrimitive(jsonElement18)) != null) {
            content3 = jsonPrimitive2.getContent();
        }
        return new MemorySearchResult(list, content5, content6, boolValueOf, content7, content8, (Boolean) null, (Boolean) null, (String) null, content9, content3, 448, (i) null);
    }

    public static /* synthetic */ Object search$default(MemoryTools memoryTools, String str, Integer num, Double d, f5.c cVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            num = null;
        }
        if ((i8 & 4) != 0) {
            d = null;
        }
        return memoryTools.search(str, num, d, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemorySearchResult search$lambda$1(Map result, Json json) {
        p.e(result, "result");
        p.e(json, "json");
        return INSTANCE.parseSearchResult(result);
    }

    public static /* synthetic */ Object searchAndCombine$default(MemoryTools memoryTools, String str, int i8, f5.c cVar, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 5;
        }
        return memoryTools.searchAndCombine(str, i8, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fsAppend(java.lang.String r11, java.lang.String r12, f5.c r13) {
        /*
            r10 = this;
            java.lang.String r0 = "fsAppend: append failed: "
            boolean r1 = r13 instanceof com.stepos.stepclaw.openclaw.memory.MemoryTools.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r13
            com.stepos.stepclaw.openclaw.memory.MemoryTools$fsAppend$1 r1 = (com.stepos.stepclaw.openclaw.memory.MemoryTools.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.stepclaw.openclaw.memory.MemoryTools$fsAppend$1 r1 = new com.stepos.stepclaw.openclaw.memory.MemoryTools$fsAppend$1
            r1.<init>(r13)
        L1a:
            java.lang.Object r10 = r1.result
            g5.a r13 = g5.a.f2984a
            int r2 = r1.label
            r3 = 0
            r4 = 4
            r5 = 1
            java.lang.String r6 = "MemoryTools"
            r7 = 0
            if (r2 == 0) goto L45
            if (r2 != r5) goto L3d
            java.lang.Object r11 = r1.L$2
            com.stepos.stepclaw.bridge.openclaw.IOpenClawClient r11 = (com.stepos.stepclaw.bridge.openclaw.IOpenClawClient) r11
            java.lang.Object r11 = r1.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r1.L$0
            java.lang.String r11 = (java.lang.String) r11
            a.a.c0(r10)     // Catch: java.lang.Exception -> L3a
            goto L83
        L3a:
            r10 = move-exception
            goto Lae
        L3d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L45:
            a.a.c0(r10)
            com.stepos.stepclaw.base.framework.ServiceLocator r10 = com.stepos.stepclaw.base.framework.ServiceLocator.INSTANCE
            java.lang.Class<com.stepos.stepclaw.bridge.openclaw.IOpenClawClient> r2 = com.stepos.stepclaw.bridge.openclaw.IOpenClawClient.class
            java.lang.Object r10 = r10.get(r2)
            com.stepos.stepclaw.bridge.openclaw.IOpenClawClient r10 = (com.stepos.stepclaw.bridge.openclaw.IOpenClawClient) r10
            if (r10 != 0) goto L5c
            java.lang.String r10 = "fsAppend: OpenClawClient not initialized"
            com.stepos.stepclaw.base.util.ALog.w$default(r6, r10, r7, r4, r7)
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            return r10
        L5c:
            java.lang.String r2 = "append"
            java.lang.String r8 = "path"
            b5.g r9 = new b5.g     // Catch: java.lang.Exception -> L3a
            r9.<init>(r8, r11)     // Catch: java.lang.Exception -> L3a
            java.lang.String r11 = "content"
            b5.g r8 = new b5.g     // Catch: java.lang.Exception -> L3a
            r8.<init>(r11, r12)     // Catch: java.lang.Exception -> L3a
            b5.g[] r11 = new b5.g[]{r9, r8}     // Catch: java.lang.Exception -> L3a
            java.util.Map r11 = c5.z.U(r11)     // Catch: java.lang.Exception -> L3a
            r1.L$0 = r7     // Catch: java.lang.Exception -> L3a
            r1.L$1 = r7     // Catch: java.lang.Exception -> L3a
            r1.L$2 = r7     // Catch: java.lang.Exception -> L3a
            r1.label = r5     // Catch: java.lang.Exception -> L3a
            java.lang.Object r10 = r10.invokeTool(r2, r11, r1)     // Catch: java.lang.Exception -> L3a
            if (r10 != r13) goto L83
            return r13
        L83:
            com.stepos.stepclaw.bridge.openclaw.ToolsInvokeResponse r10 = (com.stepos.stepclaw.bridge.openclaw.ToolsInvokeResponse) r10     // Catch: java.lang.Exception -> L3a
            if (r10 == 0) goto L8c
            boolean r11 = r10.getOk()     // Catch: java.lang.Exception -> L3a
            goto L8d
        L8c:
            r11 = r3
        L8d:
            if (r11 != 0) goto Lac
            if (r10 == 0) goto L9c
            com.stepos.stepclaw.bridge.openclaw.ToolsInvokeError r10 = r10.getError()     // Catch: java.lang.Exception -> L3a
            if (r10 == 0) goto L9c
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Exception -> L3a
            goto L9d
        L9c:
            r10 = r7
        L9d:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3a
            r12.<init>(r0)     // Catch: java.lang.Exception -> L3a
            r12.append(r10)     // Catch: java.lang.Exception -> L3a
            java.lang.String r10 = r12.toString()     // Catch: java.lang.Exception -> L3a
            com.stepos.stepclaw.base.util.ALog.w$default(r6, r10, r7, r4, r7)     // Catch: java.lang.Exception -> L3a
        Lac:
            r3 = r11
            goto Lb7
        Lae:
            java.lang.String r11 = r10.getMessage()
            java.lang.String r12 = "fsAppend: append error: "
            m0.f.l(r12, r11, r6, r10)
        Lb7:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.openclaw.memory.MemoryTools.fsAppend(java.lang.String, java.lang.String, f5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fsAppendMmr(java.lang.String r17, java.lang.String r18, double r19, double r21, f5.c r23) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.openclaw.memory.MemoryTools.fsAppendMmr(java.lang.String, java.lang.String, double, double, f5.c):java.lang.Object");
    }

    public final Object get(String str, Integer num, Integer num2, f5.c cVar) {
        IOpenClawClient iOpenClawClient = (IOpenClawClient) ServiceLocator.INSTANCE.get(IOpenClawClient.class);
        g gVar = new g();
        gVar.put("path", str);
        if (num != null) {
            gVar.put("from", new Integer(num.intValue()));
        }
        if (num2 != null) {
            gVar.put("lines", new Integer(num2.intValue()));
        }
        return iOpenClawClient.invokeTool("memory_get", gVar.b(), new y(4), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getOrEmpty(java.lang.String r13, f5.c r14) {
        /*
            r12 = this;
            java.lang.String r0 = "memory_get error: "
            boolean r1 = r14 instanceof com.stepos.stepclaw.openclaw.memory.MemoryTools.C00761
            if (r1 == 0) goto L16
            r1 = r14
            com.stepos.stepclaw.openclaw.memory.MemoryTools$getOrEmpty$1 r1 = (com.stepos.stepclaw.openclaw.memory.MemoryTools.C00761) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r6 = r1
            goto L1c
        L16:
            com.stepos.stepclaw.openclaw.memory.MemoryTools$getOrEmpty$1 r1 = new com.stepos.stepclaw.openclaw.memory.MemoryTools$getOrEmpty$1
            r1.<init>(r14)
            goto L14
        L1c:
            java.lang.Object r14 = r6.result
            g5.a r1 = g5.a.f2984a
            int r2 = r6.label
            java.lang.String r9 = "MemoryTools"
            r3 = 1
            r10 = 0
            java.lang.String r11 = ""
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r12 = r6.L$0
            java.lang.String r12 = (java.lang.String) r12
            a.a.c0(r14)     // Catch: java.lang.Exception -> L34
            goto L53
        L34:
            r0 = move-exception
            r12 = r0
            goto L7f
        L37:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3f:
            a.a.c0(r14)
            r6.L$0 = r10     // Catch: java.lang.Exception -> L34
            r6.label = r3     // Catch: java.lang.Exception -> L34
            r4 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r12
            r3 = r13
            java.lang.Object r14 = get$default(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L34
            if (r14 != r1) goto L53
            return r1
        L53:
            com.stepos.stepclaw.openclaw.memory.MemoryGetResult r14 = (com.stepos.stepclaw.openclaw.memory.MemoryGetResult) r14     // Catch: java.lang.Exception -> L34
            if (r14 != 0) goto L58
            return r11
        L58:
            boolean r12 = r14.hasError()     // Catch: java.lang.Exception -> L34
            if (r12 == 0) goto L73
            java.lang.String r12 = r14.getError()     // Catch: java.lang.Exception -> L34
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L34
            r13.<init>(r0)     // Catch: java.lang.Exception -> L34
            r13.append(r12)     // Catch: java.lang.Exception -> L34
            java.lang.String r12 = r13.toString()     // Catch: java.lang.Exception -> L34
            r13 = 4
            com.stepos.stepclaw.base.util.ALog.w$default(r9, r12, r10, r13, r10)     // Catch: java.lang.Exception -> L34
            return r11
        L73:
            boolean r12 = r14.hasContent()     // Catch: java.lang.Exception -> L34
            if (r12 == 0) goto L7e
            java.lang.String r12 = r14.getText()     // Catch: java.lang.Exception -> L34
            return r12
        L7e:
            return r11
        L7f:
            java.lang.String r13 = r12.getMessage()
            java.lang.String r14 = "getOrEmpty error: "
            m0.f.l(r14, r13, r9, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.openclaw.memory.MemoryTools.getOrEmpty(java.lang.String, f5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object lcmGrep(java.lang.String r10, int r11, f5.c r12) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.openclaw.memory.MemoryTools.lcmGrep(java.lang.String, int, f5.c):java.lang.Object");
    }

    public final Object search(String str, Integer num, Double d, f5.c cVar) {
        IOpenClawClient iOpenClawClient = (IOpenClawClient) ServiceLocator.INSTANCE.get(IOpenClawClient.class);
        g gVar = new g();
        gVar.put("query", str);
        if (num != null) {
            gVar.put("maxResults", new Integer(num.intValue()));
        }
        if (d != null) {
            gVar.put("minScore", new Double(d.doubleValue()));
        }
        return iOpenClawClient.invokeTool("memory_search", gVar.b(), new y(3), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object searchAndCombine(java.lang.String r13, int r14, f5.c r15) {
        /*
            r12 = this;
            java.lang.String r0 = "memory_search error: "
            boolean r1 = r15 instanceof com.stepos.stepclaw.openclaw.memory.MemoryTools.C00781
            if (r1 == 0) goto L16
            r1 = r15
            com.stepos.stepclaw.openclaw.memory.MemoryTools$searchAndCombine$1 r1 = (com.stepos.stepclaw.openclaw.memory.MemoryTools.C00781) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r6 = r1
            goto L1c
        L16:
            com.stepos.stepclaw.openclaw.memory.MemoryTools$searchAndCombine$1 r1 = new com.stepos.stepclaw.openclaw.memory.MemoryTools$searchAndCombine$1
            r1.<init>(r15)
            goto L14
        L1c:
            java.lang.Object r15 = r6.result
            g5.a r1 = g5.a.f2984a
            int r2 = r6.label
            java.lang.String r9 = "MemoryTools"
            r3 = 1
            r10 = 0
            java.lang.String r11 = ""
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r12 = r6.L$0
            java.lang.String r12 = (java.lang.String) r12
            a.a.c0(r15)     // Catch: java.lang.Exception -> L34
            goto L59
        L34:
            r0 = move-exception
            r12 = r0
            goto L85
        L37:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3f:
            a.a.c0(r15)
            java.lang.Integer r4 = new java.lang.Integer     // Catch: java.lang.Exception -> L34
            r4.<init>(r14)     // Catch: java.lang.Exception -> L34
            r6.L$0 = r10     // Catch: java.lang.Exception -> L34
            r6.I$0 = r14     // Catch: java.lang.Exception -> L34
            r6.label = r3     // Catch: java.lang.Exception -> L34
            r5 = 0
            r7 = 4
            r8 = 0
            r2 = r12
            r3 = r13
            java.lang.Object r15 = search$default(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L34
            if (r15 != r1) goto L59
            return r1
        L59:
            com.stepos.stepclaw.openclaw.memory.MemorySearchResult r15 = (com.stepos.stepclaw.openclaw.memory.MemorySearchResult) r15     // Catch: java.lang.Exception -> L34
            if (r15 != 0) goto L5e
            return r11
        L5e:
            boolean r12 = r15.hasError()     // Catch: java.lang.Exception -> L34
            if (r12 == 0) goto L79
            java.lang.String r12 = r15.getError()     // Catch: java.lang.Exception -> L34
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L34
            r13.<init>(r0)     // Catch: java.lang.Exception -> L34
            r13.append(r12)     // Catch: java.lang.Exception -> L34
            java.lang.String r12 = r13.toString()     // Catch: java.lang.Exception -> L34
            r13 = 4
            com.stepos.stepclaw.base.util.ALog.w$default(r9, r12, r10, r13, r10)     // Catch: java.lang.Exception -> L34
            return r11
        L79:
            boolean r12 = r15.hasResults()     // Catch: java.lang.Exception -> L34
            if (r12 == 0) goto L84
            java.lang.String r12 = r15.getCombinedSnippet()     // Catch: java.lang.Exception -> L34
            return r12
        L84:
            return r11
        L85:
            java.lang.String r13 = r12.getMessage()
            java.lang.String r14 = "searchAndCombine error: "
            m0.f.l(r14, r13, r9, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.openclaw.memory.MemoryTools.searchAndCombine(java.lang.String, int, f5.c):java.lang.Object");
    }
}
