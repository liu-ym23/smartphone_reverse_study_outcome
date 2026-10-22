package com.stepos.stepclaw.memory.search;

import a6.f0;
import b5.a0;
import c5.m;
import c5.n;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import h5.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.bouncycastle.asn1.BERTags;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/memory/search/RetrievalStage;", "Lcom/stepos/stepclaw/memory/search/SearchStage;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/MemoryRetriever;", "retrievers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "topKPerCategory", "rrfK", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Ljava/util/List;IILcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", "Lcom/stepos/stepclaw/memory/search/RetrievalResult;", "lists", "mergeWithRrf", "(Ljava/util/List;)Ljava/util/List;", "Lcom/stepos/stepclaw/memory/search/SearchContext;", "context", "Lb5/a0;", "execute", "(Lcom/stepos/stepclaw/memory/search/SearchContext;Lf5/c;)Ljava/lang/Object;", "Ljava/util/List;", "I", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RetrievalStage implements SearchStage {
    private static final String TAG = "RetrievalStage";
    private final MemoryLogger logger;
    private final List<MemoryRetriever> retrievers;
    private final int rrfK;
    private final int topKPerCategory;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.search.RetrievalStage", f = "RetrievalStage.kt", l = {BERTags.DURATION}, m = "execute", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.search.RetrievalStage$execute$1, reason: invalid class name */
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
            return RetrievalStage.this.execute(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.search.RetrievalStage$execute$2", f = "RetrievalStage.kt", l = {56}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.search.RetrievalStage$execute$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ Map<String, RetrievalResult> $bestByDocId;
        final /* synthetic */ SearchContext $context;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ RetrievalStage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SearchContext searchContext, RetrievalStage retrievalStage, Map<String, RetrievalResult> map, f5.c cVar) {
            super(2, cVar);
            this.$context = searchContext;
            this.this$0 = retrievalStage;
            this.$bestByDocId = map;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$context, this.this$0, this.$bestByDocId, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x014b  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0192  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00bc -> B:22:0x00bf). Please report as a decompilation issue!!! */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 405
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.search.RetrievalStage.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RetrievalStage(List<? extends MemoryRetriever> retrievers, int i8, int i9, MemoryLogger logger) {
        kotlin.jvm.internal.p.e(retrievers, "retrievers");
        kotlin.jvm.internal.p.e(logger, "logger");
        this.retrievers = retrievers;
        this.topKPerCategory = i8;
        this.rrfK = i9;
        this.logger = logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<RetrievalResult> mergeWithRrf(List<? extends List<RetrievalResult>> lists) {
        Double dValueOf;
        ArrayList arrayList = new ArrayList();
        for (Object obj : lists) {
            if (!((List) obj).isEmpty()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return s.f1092a;
        }
        int i8 = 0;
        boolean z = true;
        if (arrayList.size() == 1) {
            return (List) arrayList.get(0);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj2 = arrayList.get(i9);
            i9++;
            int i10 = i8;
            for (Object obj3 : (List) obj2) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    n.m0();
                    throw null;
                }
                RetrievalResult retrievalResult = (RetrievalResult) obj3;
                String docId = retrievalResult.getDocId();
                Double d = (Double) linkedHashMap2.get(retrievalResult.getDocId());
                boolean z2 = z;
                linkedHashMap2.put(docId, Double.valueOf((1.0d / ((this.rrfK + i10) + 1)) + (d != null ? d.doubleValue() : 0.0d)));
                RetrievalResult retrievalResult2 = (RetrievalResult) linkedHashMap.get(retrievalResult.getDocId());
                if (retrievalResult2 == null || retrievalResult.getScore() > retrievalResult2.getScore()) {
                    linkedHashMap.put(retrievalResult.getDocId(), retrievalResult);
                }
                i10 = i11;
                z = z2;
            }
            i8 = 0;
        }
        Collection collectionValues = linkedHashMap2.values();
        kotlin.jvm.internal.p.e(collectionValues, "<this>");
        Iterator it = collectionValues.iterator();
        if (it.hasNext()) {
            double dDoubleValue = ((Number) it.next()).doubleValue();
            while (it.hasNext()) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) it.next()).doubleValue());
            }
            dValueOf = Double.valueOf(dDoubleValue);
        } else {
            dValueOf = null;
        }
        double dDoubleValue2 = dValueOf != null ? dValueOf.doubleValue() : 1.0d;
        List<Map.Entry> listJ0 = m.J0(linkedHashMap2.entrySet(), new Comparator() { // from class: com.stepos.stepclaw.memory.search.RetrievalStage$mergeWithRrf$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t8, T t9) {
                return a.a.l((Double) ((Map.Entry) t9).getValue(), (Double) ((Map.Entry) t8).getValue());
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : listJ0) {
            String str = (String) entry.getKey();
            double dDoubleValue3 = ((Number) entry.getValue()).doubleValue();
            RetrievalResult retrievalResult3 = (RetrievalResult) linkedHashMap.get(str);
            RetrievalResult retrievalResultCopy$default = retrievalResult3 != null ? RetrievalResult.copy$default(retrievalResult3, null, null, (float) (dDoubleValue3 / dDoubleValue2), 0L, null, 0, 0L, null, null, 507, null) : null;
            if (retrievalResultCopy$default != null) {
                arrayList2.add(retrievalResultCopy$default);
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.stepclaw.memory.search.SearchStage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(com.stepos.stepclaw.memory.search.SearchContext r7, f5.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.stepclaw.memory.search.RetrievalStage.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.stepclaw.memory.search.RetrievalStage$execute$1 r0 = (com.stepos.stepclaw.memory.search.RetrievalStage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.memory.search.RetrievalStage$execute$1 r0 = new com.stepos.stepclaw.memory.search.RetrievalStage$execute$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            b5.a0 r3 = b5.a0.f883a
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r6 = r0.L$1
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r7 = r0.L$0
            com.stepos.stepclaw.memory.search.SearchContext r7 = (com.stepos.stepclaw.memory.search.SearchContext) r7
            a.a.c0(r8)
            goto L6e
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            a.a.c0(r8)
            java.util.List r8 = r7.getQueryItems()
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L4c
            c5.s r6 = c5.s.f1092a
            r7.setRawResults(r6)
            return r3
        L4c:
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            com.stepos.stepclaw.memory.search.RetrievalStage$execute$2 r2 = new com.stepos.stepclaw.memory.search.RetrievalStage$execute$2
            r5 = 0
            r2.<init>(r7, r6, r8, r5)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            a6.w1 r6 = new a6.w1
            f5.h r5 = r0.getContext()
            r6.<init>(r0, r5)
            java.lang.Object r6 = b8.h.M(r6, r4, r6, r2)
            if (r6 != r1) goto L6d
            return r1
        L6d:
            r6 = r8
        L6e:
            java.util.Collection r6 = r6.values()
            java.util.List r6 = c5.m.N0(r6)
            r7.setRawResults(r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.search.RetrievalStage.execute(com.stepos.stepclaw.memory.search.SearchContext, f5.c):java.lang.Object");
    }

    public /* synthetic */ RetrievalStage(List list, int i8, int i9, MemoryLogger memoryLogger, int i10, kotlin.jvm.internal.i iVar) {
        this(list, (i10 & 2) != 0 ? 5 : i8, (i10 & 4) != 0 ? 60 : i9, memoryLogger);
    }
}
