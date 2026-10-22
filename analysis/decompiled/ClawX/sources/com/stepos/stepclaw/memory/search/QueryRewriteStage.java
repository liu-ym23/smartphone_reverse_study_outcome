package com.stepos.stepclaw.memory.search;

import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import com.stepos.stepclaw.memory.lightmem.LightMemException;
import com.stepos.stepclaw.memory.lightmem.local.LocalInferenceEngine;
import com.stepos.stepclaw.memory.lightmem.local.MemoryRecallDecision;
import com.stepos.stepclaw.memory.lightmem.remote.AutoRecallResponse;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import org.bouncycastle.asn1.x509.DisplayText;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001%BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0016\u0010\u0015J)\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u001e\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\"R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010#R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010$¨\u0006&"}, d2 = {"Lcom/stepos/stepclaw/memory/search/QueryRewriteStage;", "Lcom/stepos/stepclaw/memory/search/SearchStage;", "Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;", "client", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "modelName", "apiToken", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "allCategories", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "maxQueryLength", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine;", "localInferenceEngine", "<init>", "(Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;ILcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine;)V", "Lcom/stepos/stepclaw/memory/search/SearchContext;", "context", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "tryLocalInfer", "(Lcom/stepos/stepclaw/memory/search/SearchContext;Lf5/c;)Ljava/lang/Object;", "tryRemote", "type", "sessionId", "resolveCategories", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lb5/a0;", "fallback", "(Lcom/stepos/stepclaw/memory/search/SearchContext;)V", "execute", "Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;", "Ljava/lang/String;", "Ljava/util/List;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "I", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class QueryRewriteStage implements SearchStage {
    private static final String TAG = "QueryRewriteStage";
    private final List<String> allCategories;
    private final String apiToken;
    private final LightMemClient client;
    private final LocalInferenceEngine localInferenceEngine;
    private final MemoryLogger logger;
    private final int maxQueryLength;
    private final String modelName;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.search.QueryRewriteStage", f = "QueryRewriteStage.kt", l = {50, 65}, m = "execute", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.search.QueryRewriteStage$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QueryRewriteStage.this.execute(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.search.QueryRewriteStage", f = "QueryRewriteStage.kt", l = {80}, m = "tryLocalInfer", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.search.QueryRewriteStage$tryLocalInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00511 extends h5.c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C00511(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QueryRewriteStage.this.tryLocalInfer(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.search.QueryRewriteStage", f = "QueryRewriteStage.kt", l = {104}, m = "tryRemote", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.search.QueryRewriteStage$tryRemote$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00521 extends h5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C00521(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QueryRewriteStage.this.tryRemote(null, this);
        }
    }

    public QueryRewriteStage(LightMemClient client, String modelName, String apiToken, List<String> allCategories, MemoryLogger logger, int i8, LocalInferenceEngine localInferenceEngine) {
        p.e(client, "client");
        p.e(modelName, "modelName");
        p.e(apiToken, "apiToken");
        p.e(allCategories, "allCategories");
        p.e(logger, "logger");
        p.e(localInferenceEngine, "localInferenceEngine");
        this.client = client;
        this.modelName = modelName;
        this.apiToken = apiToken;
        this.allCategories = allCategories;
        this.logger = logger;
        this.maxQueryLength = i8;
        this.localInferenceEngine = localInferenceEngine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String execute$lambda$0(String str) {
        return a8.b.k(str.length(), "[PERF][MEMORY] queryRewrite fastPath: needRecall=true, queryLength=", ", saved 1.6s by skipping LLM");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String execute$lambda$1() {
        return "queryRewrite: empty query, skip retrieval";
    }

    private final void fallback(SearchContext context) {
        List<QueryItem> listS;
        String strQ1 = n.Q1(this.maxQueryLength, context.getUserQuery());
        if (n.t1(strQ1)) {
            listS = s.f1092a;
        } else {
            this.logger.logD(TAG, context.getSessionId(), new com.stepos.stepclaw.memory.lightmem.b(strQ1, 2));
            listS = a.a.S(new QueryItem(strQ1, this.allCategories));
        }
        context.setQueryItems(listS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String fallback$lambda$0(String str) {
        return m0.f.d("fallback: userQuery='", n.Q1(50, str), "'");
    }

    private final List<String> resolveCategories(String type, String sessionId) {
        if (type.length() == 0) {
            return this.allCategories;
        }
        if (this.allCategories.contains(type)) {
            return a.a.S(type);
        }
        this.logger.logW(TAG, sessionId, new com.stepos.stepclaw.memory.lightmem.b(type, 3));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolveCategories$lambda$0(String str) {
        return m0.f.d("autoRecall: unknown category '", str, "' in search, skipping SearchItem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8 A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:13:0x0030, B:26:0x007e, B:28:0x0086, B:29:0x0099, B:31:0x009f, B:36:0x00ac, B:35:0x00a8, B:23:0x005e), top: B:41:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object tryLocalInfer(com.stepos.stepclaw.memory.search.SearchContext r12, f5.c r13) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.search.QueryRewriteStage.tryLocalInfer(com.stepos.stepclaw.memory.search.SearchContext, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tryLocalInfer$lambda$0() {
        return "localInfer: memory not enabled, skip";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tryLocalInfer$lambda$1(MemoryRecallDecision memoryRecallDecision) {
        String thinkContent = memoryRecallDecision.getThinkContent();
        return a8.b.k(thinkContent != null ? thinkContent.length() : 0, "localInfer: needRecall=false, think=", ", skip retrieval");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tryLocalInfer$lambda$3(MemoryRecallDecision memoryRecallDecision) {
        String query = memoryRecallDecision.getQuery();
        int length = query != null ? query.length() : 0;
        String thinkContent = memoryRecallDecision.getThinkContent();
        return a8.b.i(length, thinkContent != null ? thinkContent.length() : 0, "localInfer: needRecall=true, query=", ", think=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tryLocalInfer$lambda$4(Exception exc) {
        return m0.f.c("localInfer failed, fallback to remote: ", exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object tryRemote(com.stepos.stepclaw.memory.search.SearchContext r8, f5.c r9) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.search.QueryRewriteStage.tryRemote(com.stepos.stepclaw.memory.search.SearchContext, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tryRemote$lambda$0(AutoRecallResponse autoRecallResponse) {
        return m0.f.d("autoRecall: status=", autoRecallResponse.getStatus(), ", fallback to userQuery");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tryRemote$lambda$1(List list, AutoRecallResponse autoRecallResponse) {
        return "autoRecall (search): " + list.size() + " queryItems from " + autoRecallResponse.getSearch().size() + " searchItems";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tryRemote$lambda$2(String str) {
        return m0.f.d("autoRecall (memory): query='", n.Q1(50, str), "'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tryRemote$lambda$3() {
        return "autoRecall: no memory required";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tryRemote$lambda$4(LightMemException lightMemException) {
        return m0.f.d("autoRecall failed (LightMemException): ", lightMemException.getMessage(), ", falling back");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tryRemote$lambda$5(Exception exc) {
        return m0.f.d("autoRecall failed: ", exc.getMessage(), ", falling back");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.stepclaw.memory.search.SearchStage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(com.stepos.stepclaw.memory.search.SearchContext r10, f5.c r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.stepclaw.memory.search.QueryRewriteStage.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.stepclaw.memory.search.QueryRewriteStage$execute$1 r0 = (com.stepos.stepclaw.memory.search.QueryRewriteStage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.memory.search.QueryRewriteStage$execute$1 r0 = new com.stepos.stepclaw.memory.search.QueryRewriteStage$execute$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            b5.a0 r3 = b5.a0.f883a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L44
            if (r2 == r5) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$0
            com.stepos.stepclaw.memory.search.SearchContext r9 = (com.stepos.stepclaw.memory.search.SearchContext) r9
            a.a.c0(r11)
            return r3
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.Object r10 = r0.L$0
            com.stepos.stepclaw.memory.search.SearchContext r10 = (com.stepos.stepclaw.memory.search.SearchContext) r10
            a.a.c0(r11)
            goto L52
        L44:
            a.a.c0(r11)
            r0.L$0 = r10
            r0.label = r5
            java.lang.Object r11 = r9.tryLocalInfer(r10, r0)
            if (r11 != r1) goto L52
            goto Lad
        L52:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L5b
            goto Lae
        L5b:
            java.lang.String r11 = r10.getUserQuery()
            int r2 = r9.maxQueryLength
            java.lang.String r11 = x5.n.Q1(r2, r11)
            boolean r2 = x5.n.t1(r11)
            java.lang.String r5 = "QueryRewriteStage"
            if (r2 != 0) goto L8b
            com.stepos.stepclaw.memory.search.QueryItem r2 = new com.stepos.stepclaw.memory.search.QueryItem
            java.util.List<java.lang.String> r6 = r9.allCategories
            r2.<init>(r11, r6)
            java.util.List r2 = a.a.S(r2)
            r10.setQueryItems(r2)
            com.stepos.stepclaw.memory.utils.MemoryLogger r2 = r9.logger
            java.lang.String r6 = r10.getSessionId()
            com.stepos.stepclaw.memory.lightmem.b r7 = new com.stepos.stepclaw.memory.lightmem.b
            r8 = 1
            r7.<init>(r11, r8)
            r2.logD(r5, r6, r7)
            goto La0
        L8b:
            c5.s r11 = c5.s.f1092a
            r10.setQueryItems(r11)
            com.stepos.stepclaw.memory.utils.MemoryLogger r11 = r9.logger
            java.lang.String r2 = r10.getSessionId()
            a4.b r6 = new a4.b
            r7 = 23
            r6.<init>(r7)
            r11.logD(r5, r2, r6)
        La0:
            r11 = 0
            r0.L$0 = r11
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r9 = r9.tryRemote(r10, r0)
            if (r9 != r1) goto Lae
        Lad:
            return r1
        Lae:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.search.QueryRewriteStage.execute(com.stepos.stepclaw.memory.search.SearchContext, f5.c):java.lang.Object");
    }

    public /* synthetic */ QueryRewriteStage(LightMemClient lightMemClient, String str, String str2, List list, MemoryLogger memoryLogger, int i8, LocalInferenceEngine localInferenceEngine, int i9, i iVar) {
        this(lightMemClient, str, str2, list, memoryLogger, (i9 & 32) != 0 ? DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE : i8, localInferenceEngine);
    }
}
