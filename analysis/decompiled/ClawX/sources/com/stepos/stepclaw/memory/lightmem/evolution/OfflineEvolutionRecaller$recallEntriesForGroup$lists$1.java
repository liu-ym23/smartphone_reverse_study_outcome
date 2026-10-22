package com.stepos.stepclaw.memory.lightmem.evolution;

import a6.f0;
import a6.i0;
import b5.a0;
import c5.o;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/MemoryEntry;", "<anonymous>", "(La6/f0;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionRecaller$recallEntriesForGroup$lists$1", f = "OfflineEvolutionRecaller.kt", l = {134}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class OfflineEvolutionRecaller$recallEntriesForGroup$lists$1 extends h5.i implements p {
    final /* synthetic */ Set<String> $categories;
    final /* synthetic */ MemoryIndexManager $indexManager;
    final /* synthetic */ List<String> $queries;
    final /* synthetic */ int $topKPerQuery;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineEvolutionRecaller$recallEntriesForGroup$lists$1(List<String> list, MemoryIndexManager memoryIndexManager, int i8, Set<String> set, f5.c cVar) {
        super(2, cVar);
        this.$queries = list;
        this.$indexManager = memoryIndexManager;
        this.$topKPerQuery = i8;
        this.$categories = set;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        OfflineEvolutionRecaller$recallEntriesForGroup$lists$1 offlineEvolutionRecaller$recallEntriesForGroup$lists$1 = new OfflineEvolutionRecaller$recallEntriesForGroup$lists$1(this.$queries, this.$indexManager, this.$topKPerQuery, this.$categories, cVar);
        offlineEvolutionRecaller$recallEntriesForGroup$lists$1.L$0 = obj;
        return offlineEvolutionRecaller$recallEntriesForGroup$lists$1;
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((OfflineEvolutionRecaller$recallEntriesForGroup$lists$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        f0 f0Var = (f0) this.L$0;
        g5.a aVar = g5.a.f2984a;
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return obj;
        }
        a.a.c0(obj);
        List<String> list = this.$queries;
        MemoryIndexManager memoryIndexManager = this.$indexManager;
        int i9 = this.$topKPerQuery;
        Set<String> set = this.$categories;
        ArrayList arrayList = new ArrayList(o.n0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(i0.d(f0Var, null, new OfflineEvolutionRecaller$recallEntriesForGroup$lists$1$1$1(memoryIndexManager, (String) it.next(), i9, set, null), 3));
        }
        this.L$0 = null;
        this.label = 1;
        Object objE = i0.e(arrayList, this);
        return objE == aVar ? aVar : objE;
    }
}
