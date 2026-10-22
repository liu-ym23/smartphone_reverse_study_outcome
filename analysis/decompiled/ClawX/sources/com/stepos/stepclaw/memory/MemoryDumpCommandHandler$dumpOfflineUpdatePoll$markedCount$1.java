package com.stepos.stepclaw.memory;

import a6.f0;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)I"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineUpdatePoll$markedCount$1", f = "MemoryDumpCommandHandler.kt", l = {423}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class MemoryDumpCommandHandler$dumpOfflineUpdatePoll$markedCount$1 extends h5.i implements p5.p {
    final /* synthetic */ OfflineEvolutionService $service;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryDumpCommandHandler$dumpOfflineUpdatePoll$markedCount$1(OfflineEvolutionService offlineEvolutionService, f5.c cVar) {
        super(2, cVar);
        this.$service = offlineEvolutionService;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new MemoryDumpCommandHandler$dumpOfflineUpdatePoll$markedCount$1(this.$service, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((MemoryDumpCommandHandler$dumpOfflineUpdatePoll$markedCount$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
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
        OfflineEvolutionService offlineEvolutionService = this.$service;
        this.label = 1;
        Object objMarkPendingAsEvolved$default = OfflineEvolutionService.markPendingAsEvolved$default(offlineEvolutionService, null, this, 1, null);
        return objMarkPendingAsEvolved$default == aVar ? aVar : objMarkPendingAsEvolved$default;
    }
}
