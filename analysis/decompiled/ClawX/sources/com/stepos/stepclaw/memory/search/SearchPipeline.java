package com.stepos.stepclaw.memory.search;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import h5.i;
import java.util.List;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB[\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012*\b\u0002\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR6\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/stepclaw/memory/search/SearchPipeline;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/SearchStage;", "queryRewriteStage", "retrievalStage", "rerankStage", "formatStage", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "Lkotlin/Function2;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/RetrievalResult;", "Lf5/c;", "Lb5/a0;", "onResultsRanked", "<init>", "(Lcom/stepos/stepclaw/memory/search/SearchStage;Lcom/stepos/stepclaw/memory/search/SearchStage;Lcom/stepos/stepclaw/memory/search/SearchStage;Lcom/stepos/stepclaw/memory/search/SearchStage;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;Lp5/p;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "userQuery", "Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", "messages", "sessionId", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult;", "execute", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/memory/search/SearchStage;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Lp5/p;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchPipeline {
    private static final String TAG = "SearchPipeline";
    private final SearchStage formatStage;
    private final MemoryLogger logger;
    private final p onResultsRanked;
    private final SearchStage queryRewriteStage;
    private final SearchStage rerankStage;
    private final SearchStage retrievalStage;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/RetrievalResult;", "it", "Lb5/a0;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.search.SearchPipeline$1", f = "SearchPipeline.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.search.SearchPipeline$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass1(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return a0.f883a;
        }

        @Override // p5.p
        public final Object invoke(List<RetrievalResult> list, f5.c cVar) {
            return ((AnonymousClass1) create(list, cVar)).invokeSuspend(a0.f883a);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.search.SearchPipeline", f = "SearchPipeline.kt", l = {62, 62, 67, 67, 68, 68, 70, 72, 72}, m = "execute", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.search.SearchPipeline$execute$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00531 extends h5.c {
        int I$0;
        int I$1;
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
        int label;
        /* synthetic */ Object result;

        public C00531(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchPipeline.this.execute(null, null, null, this);
        }
    }

    public SearchPipeline(SearchStage queryRewriteStage, SearchStage retrievalStage, SearchStage rerankStage, SearchStage formatStage, MemoryLogger logger, p onResultsRanked) {
        kotlin.jvm.internal.p.e(queryRewriteStage, "queryRewriteStage");
        kotlin.jvm.internal.p.e(retrievalStage, "retrievalStage");
        kotlin.jvm.internal.p.e(rerankStage, "rerankStage");
        kotlin.jvm.internal.p.e(formatStage, "formatStage");
        kotlin.jvm.internal.p.e(logger, "logger");
        kotlin.jvm.internal.p.e(onResultsRanked, "onResultsRanked");
        this.queryRewriteStage = queryRewriteStage;
        this.retrievalStage = retrievalStage;
        this.rerankStage = rerankStage;
        this.formatStage = formatStage;
        this.logger = logger;
        this.onResultsRanked = onResultsRanked;
    }

    public static /* synthetic */ Object execute$default(SearchPipeline searchPipeline, String str, List list, String str2, f5.c cVar, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str2 = null;
        }
        return searchPipeline.execute(str, list, str2, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String execute$lambda$1() {
        return "pipeline: no search needed";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String execute$lambda$5(String str) {
        return a8.b.k(str.length(), "pipeline complete: ", " chars");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String execute$lambda$6(Exception exc) {
        return m0.f.c("pipeline failed: ", exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String execute$lambda$7(long j4) {
        return "[PERF] pipeline total: cost=" + (System.currentTimeMillis() - j4) + "ms";
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0351 A[Catch: Exception -> 0x02ae, TRY_LEAVE, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0377 A[Catch: Exception -> 0x02ae, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03a0 A[Catch: Exception -> 0x02ae, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03d1 A[Catch: Exception -> 0x02ae, TRY_LEAVE, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03f8 A[Catch: Exception -> 0x02ae, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x041d A[Catch: Exception -> 0x02ae, PHI: r2 r5 r8 r10 r14 r15 r25
      0x041d: PHI (r2v85 com.stepos.stepclaw.memory.search.SearchContext) = (r2v76 com.stepos.stepclaw.memory.search.SearchContext), (r2v89 com.stepos.stepclaw.memory.search.SearchContext) binds: [B:136:0x03f6, B:141:0x041c] A[DONT_GENERATE, DONT_INLINE]
      0x041d: PHI (r5v40 g5.a) = (r5v34 g5.a), (r5v42 g5.a) binds: [B:136:0x03f6, B:141:0x041c] A[DONT_GENERATE, DONT_INLINE]
      0x041d: PHI (r8v33 long) = (r8v28 long), (r8v34 long) binds: [B:136:0x03f6, B:141:0x041c] A[DONT_GENERATE, DONT_INLINE]
      0x041d: PHI (r10v34 java.lang.String) = (r10v28 java.lang.String), (r10v35 java.lang.String) binds: [B:136:0x03f6, B:141:0x041c] A[DONT_GENERATE, DONT_INLINE]
      0x041d: PHI (r14v29 java.lang.String) = (r14v23 java.lang.String), (r14v30 java.lang.String) binds: [B:136:0x03f6, B:141:0x041c] A[DONT_GENERATE, DONT_INLINE]
      0x041d: PHI (r15v16 java.lang.String) = (r15v13 java.lang.String), (r15v17 java.lang.String) binds: [B:136:0x03f6, B:141:0x041c] A[DONT_GENERATE, DONT_INLINE]
      0x041d: PHI (r25v25 java.lang.String) = (r25v21 java.lang.String), (r25v26 java.lang.String) binds: [B:136:0x03f6, B:141:0x041c] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0428 A[Catch: Exception -> 0x02ae, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0451 A[Catch: Exception -> 0x02ae, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0481 A[Catch: Exception -> 0x02ae, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x048e A[Catch: Exception -> 0x02ae, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04ac A[Catch: Exception -> 0x02ae, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04b4 A[Catch: Exception -> 0x02ae, TRY_LEAVE, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02d9 A[Catch: Exception -> 0x02ae, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ed A[Catch: Exception -> 0x02ae, TryCatch #2 {Exception -> 0x02ae, blocks: (B:154:0x0481, B:156:0x0488, B:158:0x048e, B:160:0x0497, B:162:0x04ac, B:163:0x04b4, B:142:0x041d, B:144:0x0428, B:149:0x0451, B:125:0x03d1, B:135:0x03ee, B:137:0x03f8, B:103:0x0351, B:113:0x036d, B:115:0x0377, B:120:0x03a0, B:73:0x02a7, B:87:0x02cf, B:89:0x02d9, B:91:0x02ed, B:93:0x02f7, B:98:0x0321), top: B:183:0x02a7 }] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(java.lang.String r22, java.util.List<com.stepos.stepclaw.memory.lightmem.remote.MessageItem> r23, java.lang.String r24, f5.c r25) {
        /*
            Method dump skipped, instructions count: 1290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.search.SearchPipeline.execute(java.lang.String, java.util.List, java.lang.String, f5.c):java.lang.Object");
    }

    public /* synthetic */ SearchPipeline(SearchStage searchStage, SearchStage searchStage2, SearchStage searchStage3, SearchStage searchStage4, MemoryLogger memoryLogger, p pVar, int i8, kotlin.jvm.internal.i iVar) {
        this(searchStage, searchStage2, searchStage3, searchStage4, memoryLogger, (i8 & 32) != 0 ? new AnonymousClass1(null) : pVar);
    }
}
