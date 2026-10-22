package com.stepos.stepclaw.memory.upload;

import b4.i;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.net.StepOSHeadersProvider;
import com.stepos.stepclaw.base.net.bean.StepOSHeaders;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.gateway.d;
import h5.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k4.n;
import k4.o;
import k4.q;
import k4.t;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import t3.c;
import z3.r0;
import z3.t0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J<\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ(\u0010#\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0086@¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/stepos/stepclaw/memory/upload/MemoryUploadClient;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_BASE_URL, "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "headersProvider", "<init>", "(Ljava/lang/String;Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;)V", "Lf4/c;", "Lb5/a0;", "injectAuthHeaders", "(Lf4/c;)V", "objectKey", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "fileSize", "Lcom/stepos/stepclaw/memory/upload/SignatureData;", "getSignature", "(Ljava/lang/String;JLf5/c;)Ljava/lang/Object;", "uploadUrl", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "formFields", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "fileBytes", "fileName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "uploadToTos", "(Ljava/lang/String;Ljava/util/Map;[BLjava/lang/String;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/memory/upload/UploadConfirmRequest;", "request", "confirmUpload", "(Lcom/stepos/stepclaw/memory/upload/UploadConfirmRequest;Lf5/c;)Ljava/lang/Object;", "deviceId", "Ljava/io/File;", "file", "Lcom/stepos/stepclaw/memory/upload/FileUploadResult;", "uploadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lf5/c;)Ljava/lang/Object;", "Ljava/lang/String;", "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "Lt3/c;", "httpClient", "Lt3/c;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryUploadClient {
    private static final String CONFIRM_PATH = "/data-hub-service/api/client/upload/confirm";
    private static final int MAX_RETRIES = 2;
    private static final String SIGNATURE_PATH = "/data-hub-service/api/client/upload/signature";
    private static final String TAG = "MemoryUploadClient";
    private final String baseUrl;
    private final StepOSHeadersProvider headersProvider;
    private final c httpClient;
    private final Json json;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.memory.upload.MemoryUploadClient", f = "MemoryUploadClient.kt", l = {253, 120}, m = "confirmUpload", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.upload.MemoryUploadClient$confirmUpload$1, reason: invalid class name */
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
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryUploadClient.this.confirmUpload(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.memory.upload.MemoryUploadClient", f = "MemoryUploadClient.kt", l = {253, 67}, m = "getSignature", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.upload.MemoryUploadClient$getSignature$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00691 extends h5.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
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

        public C00691(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryUploadClient.this.getSignature(null, 0L, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.memory.upload.MemoryUploadClient", f = "MemoryUploadClient.kt", l = {144, 147, 149, 161, 178}, m = "uploadFile", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.upload.MemoryUploadClient$uploadFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00701 extends h5.c {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C00701(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryUploadClient.this.uploadFile(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.memory.upload.MemoryUploadClient", f = "MemoryUploadClient.kt", l = {260}, m = "uploadToTos", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.upload.MemoryUploadClient$uploadToTos$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00711 extends h5.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$10;
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

        public C00711(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryUploadClient.this.uploadToTos(null, null, null, null, this);
        }
    }

    public MemoryUploadClient(String baseUrl, StepOSHeadersProvider stepOSHeadersProvider) {
        p.e(baseUrl, "baseUrl");
        this.baseUrl = baseUrl;
        this.headersProvider = stepOSHeadersProvider;
        this.json = JsonKt.Json$default(null, new d(8), 1, null);
        this.httpClient = v.a(x3.a.f6253a, new a(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0(MemoryUploadClient memoryUploadClient, t3.d HttpClient) {
        p.e(HttpClient, "$this$HttpClient");
        HttpClient.a(i.d, new a(memoryUploadClient, 1));
        HttpClient.a(t0.f6509b, new d(9));
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0$0(MemoryUploadClient memoryUploadClient, b4.c install) {
        p.e(install, "$this$install");
        q4.c.a(install, memoryUploadClient.json);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 httpClient$lambda$0$1(r0 install) {
        p.e(install, "$this$install");
        install.b(30000L);
        install.d(120000L);
        install.c(180000L);
        return a0.f883a;
    }

    private final void injectAuthHeaders(f4.c cVar) {
        StepOSHeaders stepOSHeadersProvide;
        StepOSHeadersProvider stepOSHeadersProvider = this.headersProvider;
        if (stepOSHeadersProvider == null || (stepOSHeadersProvide = stepOSHeadersProvider.provide()) == null) {
            return;
        }
        a.a.O(cVar, "zy-app-id", stepOSHeadersProvide.getAppId());
        a.a.O(cVar, "zy-nonce", stepOSHeadersProvide.getNonce());
        a.a.O(cVar, "zy-timestamp", stepOSHeadersProvide.getTimestamp());
        a.a.O(cVar, "zy-sign", stepOSHeadersProvide.getSign());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    private static final a0 uploadToTos$lambda$0(Map map, byte[] value, String str, g4.a formData) {
        p.e(formData, "$this$formData");
        ArrayList arrayList = formData.f2963a;
        for (Map.Entry entry : map.entrySet()) {
            String key = (String) entry.getKey();
            String value2 = (String) entry.getValue();
            o.f3633a.getClass();
            p.e(key, "key");
            p.e(value2, "value");
            arrayList.add(new g4.d(key, value2, k4.i.f3621c));
        }
        n nVar = o.f3633a;
        k4.p pVar = new k4.p(0);
        List list = t.f3636a;
        pVar.b("Content-Disposition", "filename=\"" + str + "\"");
        q qVarN = pVar.n();
        p.e(value, "value");
        arrayList.add(new g4.d("file", value, qVarN));
        return a0.f883a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0115, code lost:
    
        if (r14 == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object confirmUpload(com.stepos.stepclaw.memory.upload.UploadConfirmRequest r13, f5.c r14) throws b4.a {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.upload.MemoryUploadClient.confirmUpload(com.stepos.stepclaw.memory.upload.UploadConfirmRequest, f5.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0115, code lost:
    
        if (r14 == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getSignature(java.lang.String r11, long r12, f5.c r14) throws com.stepos.stepclaw.memory.upload.MemoryUploadException, b4.a {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.upload.MemoryUploadClient.getSignature(java.lang.String, long, f5.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:33|(1:124)|59|60|130|61|62|122|63|(4:66|120|67|(3:72|73|74)(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(10:33|124|59|60|130|61|62|122|63|(4:66|120|67|(3:72|73|74)(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(5:(1:54)(7:(1:42)(1:44)|43|113|45|46|134|47)|55|117|56|(10:33|124|59|60|130|61|62|122|63|(4:66|120|67|(3:72|73|74)(0)))) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(1:42)(1:44)|43|113|45|46|134|47) */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0250, code lost:
    
        r39 = r9;
        r10 = r2;
        r9 = r3;
        r2 = r6;
        r3 = r8;
        r8 = r4;
        r6 = r27;
        r4 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x014e, code lost:
    
        if (a6.i0.g(r12, r6) == r7) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0152, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0153, code lost:
    
        r39 = r9;
        r10 = r2;
        r9 = r3;
        r2 = r6;
        r3 = r8;
        r8 = r4;
        r6 = r5;
        r4 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0160, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0225, code lost:
    
        if (confirmUpload(r28, r2) == r7) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x023b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x023c, code lost:
    
        r2 = r6;
        r3 = r8;
        r8 = r13;
        r6 = r39;
        r4 = r9;
        r9 = r14;
        r10 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0245, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0246, code lost:
    
        r16 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x024e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0285 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c3 A[PHI: r0 r2 r3 r4 r6 r8 r9 r10
      0x00c3: PHI (r0v9 java.lang.Object) = (r0v18 java.lang.Object), (r0v1 java.lang.Object) binds: [B:57:0x0187, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r2v5 com.stepos.stepclaw.memory.upload.MemoryUploadClient$uploadFile$1) = 
      (r2v10 com.stepos.stepclaw.memory.upload.MemoryUploadClient$uploadFile$1)
      (r2v2 com.stepos.stepclaw.memory.upload.MemoryUploadClient$uploadFile$1)
     binds: [B:57:0x0187, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r3v2 int) = (r3v7 int), (r3v23 int) binds: [B:57:0x0187, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r4v5 long) = (r4v26 long), (r4v27 long) binds: [B:57:0x0187, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r6v2 byte[]) = (r6v6 byte[]), (r6v23 byte[]) binds: [B:57:0x0187, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r8v1 java.io.File) = (r8v5 java.io.File), (r8v17 java.io.File) binds: [B:57:0x0187, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r9v4 java.lang.String) = (r9v28 java.lang.String), (r9v29 java.lang.String) binds: [B:57:0x0187, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r10v3 java.lang.String) = (r10v21 java.lang.String), (r10v22 java.lang.String) binds: [B:57:0x0187, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01cf A[Catch: Exception -> 0x01eb, TryCatch #4 {Exception -> 0x01eb, blocks: (B:67:0x01c7, B:69:0x01cf, B:72:0x01f3), top: B:120:0x01c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f3 A[Catch: Exception -> 0x01eb, TRY_LEAVE, TryCatch #4 {Exception -> 0x01eb, blocks: (B:67:0x01c7, B:69:0x01cf, B:72:0x01f3), top: B:120:0x01c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r41v0, types: [com.stepos.stepclaw.memory.upload.MemoryUploadClient] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x01cf -> B:90:0x027b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x01ec -> B:89:0x0250). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0225 -> B:24:0x0079). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x023c -> B:89:0x0250). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x024f -> B:89:0x0250). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadFile(java.lang.String r42, java.lang.String r43, java.io.File r44, f5.c r45) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.upload.MemoryUploadClient.uploadFile(java.lang.String, java.lang.String, java.io.File, f5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadToTos(java.lang.String r18, java.util.Map<java.lang.String, java.lang.String> r19, byte[] r20, java.lang.String r21, f5.c r22) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.upload.MemoryUploadClient.uploadToTos(java.lang.String, java.util.Map, byte[], java.lang.String, f5.c):java.lang.Object");
    }

    public /* synthetic */ MemoryUploadClient(String str, StepOSHeadersProvider stepOSHeadersProvider, int i8, kotlin.jvm.internal.i iVar) {
        this(str, (i8 & 2) != 0 ? null : stepOSHeadersProvider);
    }
}
