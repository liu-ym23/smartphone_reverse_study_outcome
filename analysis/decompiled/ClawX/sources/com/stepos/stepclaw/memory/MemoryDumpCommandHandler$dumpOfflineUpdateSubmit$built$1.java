package com.stepos.stepclaw.memory;

import a6.f0;
import b5.a0;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionRecaller;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineSearchGroup;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerResponse;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionRecaller$OfflineUpdateBuildResult;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionRecaller$OfflineUpdateBuildResult;"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineUpdateSubmit$built$1", f = "MemoryDumpCommandHandler.kt", l = {584}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class MemoryDumpCommandHandler$dumpOfflineUpdateSubmit$built$1 extends h5.i implements p5.p {
    final /* synthetic */ Set<String> $categories;
    final /* synthetic */ MemoryIndexManager $idxMgr;
    final /* synthetic */ OfflineTriggerResponse $trigger;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryDumpCommandHandler$dumpOfflineUpdateSubmit$built$1(MemoryIndexManager memoryIndexManager, OfflineTriggerResponse offlineTriggerResponse, Set<String> set, f5.c cVar) {
        super(2, cVar);
        this.$idxMgr = memoryIndexManager;
        this.$trigger = offlineTriggerResponse;
        this.$categories = set;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new MemoryDumpCommandHandler$dumpOfflineUpdateSubmit$built$1(this.$idxMgr, this.$trigger, this.$categories, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((MemoryDumpCommandHandler$dumpOfflineUpdateSubmit$built$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
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
        OfflineEvolutionRecaller offlineEvolutionRecaller = OfflineEvolutionRecaller.INSTANCE;
        MemoryIndexManager memoryIndexManager = this.$idxMgr;
        List<OfflineSearchGroup> search_groups = this.$trigger.getSearch_groups();
        Set<String> set = this.$categories;
        this.label = 1;
        Object objBuildUpdateRequest = offlineEvolutionRecaller.buildUpdateRequest(memoryIndexManager, search_groups, 30, 40, set, this);
        return objBuildUpdateRequest == aVar ? aVar : objBuildUpdateRequest;
    }
}
