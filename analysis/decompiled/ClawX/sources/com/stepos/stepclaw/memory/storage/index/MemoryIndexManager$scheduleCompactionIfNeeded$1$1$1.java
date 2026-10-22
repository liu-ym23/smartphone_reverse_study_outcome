package com.stepos.stepclaw.memory.storage.index;

import a6.f0;
import b5.a0;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$scheduleCompactionIfNeeded$1$1$1", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class MemoryIndexManager$scheduleCompactionIfNeeded$1$1$1 extends h5.i implements p5.p {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MemoryIndexManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryIndexManager$scheduleCompactionIfNeeded$1$1$1(MemoryIndexManager memoryIndexManager, f5.c cVar) {
        super(2, cVar);
        this.this$0 = memoryIndexManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$0$0(int i8) {
        return a8.b.k(i8, "Background compaction evicted ", " documents");
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new MemoryIndexManager$scheduleCompactionIfNeeded$1$1$1(this.this$0, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((MemoryIndexManager$scheduleCompactionIfNeeded$1$1$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        i6.a aVar;
        MemoryIndexManager memoryIndexManager;
        int iCompactDynamic$default;
        g5.a aVar2 = g5.a.f2984a;
        int i8 = this.label;
        if (i8 == 0) {
            a.a.c0(obj);
            i6.a aVar3 = this.this$0.indexMutex;
            MemoryIndexManager memoryIndexManager2 = this.this$0;
            this.L$0 = aVar3;
            this.L$1 = memoryIndexManager2;
            this.I$0 = 0;
            this.label = 1;
            i6.c cVar = (i6.c) aVar3;
            if (cVar.c(this) == aVar2) {
                return aVar2;
            }
            aVar = cVar;
            memoryIndexManager = memoryIndexManager2;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            memoryIndexManager = (MemoryIndexManager) this.L$1;
            aVar = (i6.a) this.L$0;
            a.a.c0(obj);
        }
        try {
            if (memoryIndexManager.getIndex().isDynamicFull() && (iCompactDynamic$default = BM25Index.compactDynamic$default(memoryIndexManager.getIndex(), 0L, 1, null)) > 0) {
                memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                MemoryLogger.logD$default(memoryIndexManager.logger, "MemoryIndexManager", null, new j(iCompactDynamic$default, 3), 2, null);
            }
            memoryIndexManager.pendingCompaction = false;
            ((i6.c) aVar).e(null);
            return a0.f883a;
        } catch (Throwable th) {
            ((i6.c) aVar).e(null);
            throw th;
        }
    }
}
