package com.stepos.stepclaw.memory.lightmem.evolution;

import a6.f0;
import a6.i0;
import a6.r0;
import b5.a0;
import c5.m;
import c5.o;
import c5.s;
import c5.t;
import c5.u;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionModelsKt;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineSearchGroup;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateGroupMessage;
import com.stepos.stepclaw.memory.search.MemoryEntry;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011JJ\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionRecaller;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;", "indexManager", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineSearchGroup;", "group", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "topKPerQuery", "maxEntriesPerGroup", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "categories", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/MemoryEntry;", "recallEntriesForGroup", "(Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineSearchGroup;IILjava/util/Set;Lf5/c;)Ljava/lang/Object;", "searchGroups", "Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionRecaller$OfflineUpdateBuildResult;", "buildUpdateRequest", "(Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;Ljava/util/List;IILjava/util/Set;Lf5/c;)Ljava/lang/Object;", "OfflineUpdateBuildResult", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OfflineEvolutionRecaller {
    public static final OfflineEvolutionRecaller INSTANCE = new OfflineEvolutionRecaller();

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionRecaller$OfflineUpdateBuildResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "messages", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateGroupMessage;", "memoryIndexToDocId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getMessages", "()Ljava/util/List;", "getMemoryIndexToDocId", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OfflineUpdateBuildResult {
        private final Map<Long, String> memoryIndexToDocId;
        private final List<OfflineUpdateGroupMessage> messages;

        public OfflineUpdateBuildResult(List<OfflineUpdateGroupMessage> messages, Map<Long, String> memoryIndexToDocId) {
            p.e(messages, "messages");
            p.e(memoryIndexToDocId, "memoryIndexToDocId");
            this.messages = messages;
            this.memoryIndexToDocId = memoryIndexToDocId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OfflineUpdateBuildResult copy$default(OfflineUpdateBuildResult offlineUpdateBuildResult, List list, Map map, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                list = offlineUpdateBuildResult.messages;
            }
            if ((i8 & 2) != 0) {
                map = offlineUpdateBuildResult.memoryIndexToDocId;
            }
            return offlineUpdateBuildResult.copy(list, map);
        }

        public final List<OfflineUpdateGroupMessage> component1() {
            return this.messages;
        }

        public final Map<Long, String> component2() {
            return this.memoryIndexToDocId;
        }

        public final OfflineUpdateBuildResult copy(List<OfflineUpdateGroupMessage> messages, Map<Long, String> memoryIndexToDocId) {
            p.e(messages, "messages");
            p.e(memoryIndexToDocId, "memoryIndexToDocId");
            return new OfflineUpdateBuildResult(messages, memoryIndexToDocId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OfflineUpdateBuildResult)) {
                return false;
            }
            OfflineUpdateBuildResult offlineUpdateBuildResult = (OfflineUpdateBuildResult) other;
            return p.a(this.messages, offlineUpdateBuildResult.messages) && p.a(this.memoryIndexToDocId, offlineUpdateBuildResult.memoryIndexToDocId);
        }

        public final Map<Long, String> getMemoryIndexToDocId() {
            return this.memoryIndexToDocId;
        }

        public final List<OfflineUpdateGroupMessage> getMessages() {
            return this.messages;
        }

        public int hashCode() {
            return this.memoryIndexToDocId.hashCode() + (this.messages.hashCode() * 31);
        }

        public String toString() {
            return "OfflineUpdateBuildResult(messages=" + this.messages + ", memoryIndexToDocId=" + this.memoryIndexToDocId + ")";
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionRecaller$OfflineUpdateBuildResult;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionRecaller$OfflineUpdateBuildResult;"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionRecaller$buildUpdateRequest$2", f = "OfflineEvolutionRecaller.kt", l = {60}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionRecaller$buildUpdateRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends h5.i implements p5.p {
        final /* synthetic */ Set<String> $categories;
        final /* synthetic */ MemoryIndexManager $indexManager;
        final /* synthetic */ int $maxEntriesPerGroup;
        final /* synthetic */ List<OfflineSearchGroup> $searchGroups;
        final /* synthetic */ int $topKPerQuery;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<OfflineSearchGroup> list, int i8, int i9, Set<String> set, MemoryIndexManager memoryIndexManager, f5.c cVar) {
            super(2, cVar);
            this.$searchGroups = list;
            this.$topKPerQuery = i8;
            this.$maxEntriesPerGroup = i9;
            this.$categories = set;
            this.$indexManager = memoryIndexManager;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass2(this.$searchGroups, this.$topKPerQuery, this.$maxEntriesPerGroup, this.$categories, this.$indexManager, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM;
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                if (this.$searchGroups.isEmpty()) {
                    OfflineEvolutionLog.INSTANCE.step(3, 5, "BM25 recall skipped (empty search_groups)");
                    return new OfflineUpdateBuildResult(s.f1092a, t.f1093a);
                }
                OfflineEvolutionLog offlineEvolutionLog = OfflineEvolutionLog.INSTANCE;
                int size = this.$searchGroups.size();
                int i9 = this.$topKPerQuery;
                int i10 = this.$maxEntriesPerGroup;
                int size2 = this.$categories.size();
                StringBuilder sbT = a8.b.t("BM25 recall begin: groups=", size, " topK=", i9, " maxPerGroup=");
                sbT.append(i10);
                sbT.append(" cats=");
                sbT.append(size2);
                offlineEvolutionLog.step(3, 5, sbT.toString());
                OfflineEvolutionRecaller$buildUpdateRequest$2$perGroupEntries$1 offlineEvolutionRecaller$buildUpdateRequest$2$perGroupEntries$1 = new OfflineEvolutionRecaller$buildUpdateRequest$2$perGroupEntries$1(m.J0(this.$searchGroups, new Comparator() { // from class: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionRecaller$buildUpdateRequest$2$invokeSuspend$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t8, T t9) {
                        return a.a.l(Integer.valueOf(((OfflineSearchGroup) t8).getGroup_id()), Integer.valueOf(((OfflineSearchGroup) t9).getGroup_id()));
                    }
                }), this.$indexManager, this.$topKPerQuery, this.$maxEntriesPerGroup, this.$categories, null);
                this.L$0 = null;
                this.label = 1;
                f6.p pVar = new f6.p(this, getContext());
                objM = b8.h.M(pVar, true, pVar, offlineEvolutionRecaller$buildUpdateRequest$2$perGroupEntries$1);
                if (objM == aVar) {
                    return aVar;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
                objM = obj;
            }
            List<b5.g> list = (List) objM;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList arrayList = new ArrayList(o.n0(list, 10));
            for (b5.g gVar : list) {
                int iIntValue = ((Number) gVar.f892a).intValue();
                List<MemoryEntry> list2 = (List) gVar.f893b;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (MemoryEntry memoryEntry : list2) {
                    long jNewMemoryIndexId = OfflineEvolutionIds.INSTANCE.newMemoryIndexId();
                    linkedHashMap.put(new Long(jNewMemoryIndexId), memoryEntry.getId());
                    CatchMemoryItem catchMemoryItem = new CatchMemoryItem(memoryEntry.getContent(), 0.8d, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, MemoryFile.INSTANCE.formatAsIso8601(memoryEntry.getCreatedAt()), EpisodicMemoryEvolutionState.PENDING, new Long(jNewMemoryIndexId), (List) null, 64, (kotlin.jvm.internal.i) null);
                    String string = n.T1(memoryEntry.getCategory()).toString();
                    if (n.t1(string)) {
                        string = "unknown";
                    }
                    Object arrayList2 = linkedHashMap2.get(string);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap2.put(string, arrayList2);
                    }
                    ((List) arrayList2).add(catchMemoryItem);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(z.T(linkedHashMap2.size()));
                for (Map.Entry entry : linkedHashMap2.entrySet()) {
                    linkedHashMap3.put(entry.getKey(), m.N0((Iterable) entry.getValue()));
                }
                arrayList.add(new OfflineUpdateGroupMessage(iIntValue, linkedHashMap3));
            }
            int size3 = arrayList.size();
            int iMemoryBucketItemCount = 0;
            int i11 = 0;
            while (i11 < size3) {
                Object obj2 = arrayList.get(i11);
                i11++;
                iMemoryBucketItemCount += OfflineEvolutionModelsKt.memoryBucketItemCount(((OfflineUpdateGroupMessage) obj2).getSearch_memories());
            }
            OfflineEvolutionLog offlineEvolutionLog2 = OfflineEvolutionLog.INSTANCE;
            int size4 = arrayList.size();
            int size5 = linkedHashMap.size();
            StringBuilder sbT2 = a8.b.t("BM25 recall done: update_groups=", size4, " search_memories=", iMemoryBucketItemCount, " memory_index_map=");
            sbT2.append(size5);
            offlineEvolutionLog2.step(3, 5, sbT2.toString());
            return new OfflineUpdateBuildResult(arrayList, linkedHashMap);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionRecaller", f = "OfflineEvolutionRecaller.kt", l = {122}, m = "recallEntriesForGroup", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionRecaller$recallEntriesForGroup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfflineEvolutionRecaller.this.recallEntriesForGroup(null, null, 0, 0, null, this);
        }
    }

    private OfflineEvolutionRecaller() {
    }

    public static /* synthetic */ Object buildUpdateRequest$default(OfflineEvolutionRecaller offlineEvolutionRecaller, MemoryIndexManager memoryIndexManager, List list, int i8, int i9, Set set, f5.c cVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            i8 = 30;
        }
        int i11 = i8;
        if ((i10 & 8) != 0) {
            i9 = 40;
        }
        int i12 = i9;
        if ((i10 & 16) != 0) {
            set = u.f1094a;
        }
        return offlineEvolutionRecaller.buildUpdateRequest(memoryIndexManager, list, i11, i12, set, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object recallEntriesForGroup(com.stepos.stepclaw.memory.storage.index.MemoryIndexManager r15, com.stepos.stepclaw.memory.lightmem.remote.OfflineSearchGroup r16, int r17, int r18, java.util.Set<java.lang.String> r19, f5.c r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionRecaller.recallEntriesForGroup(com.stepos.stepclaw.memory.storage.index.MemoryIndexManager, com.stepos.stepclaw.memory.lightmem.remote.OfflineSearchGroup, int, int, java.util.Set, f5.c):java.lang.Object");
    }

    public final Object buildUpdateRequest(MemoryIndexManager memoryIndexManager, List<OfflineSearchGroup> list, int i8, int i9, Set<String> set, f5.c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(h6.d.f3059c, new AnonymousClass2(list, i8, i9, set, memoryIndexManager, null), cVar);
    }
}
