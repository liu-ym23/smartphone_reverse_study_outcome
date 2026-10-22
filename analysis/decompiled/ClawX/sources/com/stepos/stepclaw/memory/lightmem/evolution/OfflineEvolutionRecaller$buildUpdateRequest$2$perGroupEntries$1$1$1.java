package com.stepos.stepclaw.memory.lightmem.evolution;

import a6.f0;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineSearchGroup;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import java.util.Set;
import kotlin.Metadata;
import org.bouncycastle.crypto.params.SkeinParameters;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"La6/f0;", "Lb5/g;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/MemoryEntry;", "<anonymous>", "(La6/f0;)Lb5/g;"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionRecaller$buildUpdateRequest$2$perGroupEntries$1$1$1", f = "OfflineEvolutionRecaller.kt", l = {SkeinParameters.PARAM_TYPE_OUTPUT}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class OfflineEvolutionRecaller$buildUpdateRequest$2$perGroupEntries$1$1$1 extends h5.i implements p {
    final /* synthetic */ Set<String> $categories;
    final /* synthetic */ OfflineSearchGroup $group;
    final /* synthetic */ MemoryIndexManager $indexManager;
    final /* synthetic */ int $maxEntriesPerGroup;
    final /* synthetic */ int $topKPerQuery;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineEvolutionRecaller$buildUpdateRequest$2$perGroupEntries$1$1$1(OfflineSearchGroup offlineSearchGroup, MemoryIndexManager memoryIndexManager, int i8, int i9, Set<String> set, f5.c cVar) {
        super(2, cVar);
        this.$group = offlineSearchGroup;
        this.$indexManager = memoryIndexManager;
        this.$topKPerQuery = i8;
        this.$maxEntriesPerGroup = i9;
        this.$categories = set;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new OfflineEvolutionRecaller$buildUpdateRequest$2$perGroupEntries$1$1$1(this.$group, this.$indexManager, this.$topKPerQuery, this.$maxEntriesPerGroup, this.$categories, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((OfflineEvolutionRecaller$buildUpdateRequest$2$perGroupEntries$1$1$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Integer num;
        g5.a aVar = g5.a.f2984a;
        int i8 = this.label;
        if (i8 == 0) {
            a.a.c0(obj);
            Integer num2 = new Integer(this.$group.getGroup_id());
            OfflineEvolutionRecaller offlineEvolutionRecaller = OfflineEvolutionRecaller.INSTANCE;
            MemoryIndexManager memoryIndexManager = this.$indexManager;
            OfflineSearchGroup offlineSearchGroup = this.$group;
            int i9 = this.$topKPerQuery;
            int i10 = this.$maxEntriesPerGroup;
            Set<String> set = this.$categories;
            this.L$0 = num2;
            this.label = 1;
            obj = offlineEvolutionRecaller.recallEntriesForGroup(memoryIndexManager, offlineSearchGroup, i9, i10, set, this);
            if (obj == aVar) {
                return aVar;
            }
            num = num2;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            num = (Integer) this.L$0;
            a.a.c0(obj);
        }
        return new b5.g(num, obj);
    }
}
