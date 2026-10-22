package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1731a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1732b;

    public /* synthetic */ j(int i8, int i9) {
        this.f1731a = i9;
        this.f1732b = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1731a;
        int i9 = this.f1732b;
        switch (i8) {
            case 0:
                return MemoryIndexManager.C00582.invokeSuspend$lambda$0$4(i9);
            case 1:
                return MemoryIndexManager.C00582.invokeSuspend$lambda$0$10(i9);
            case 2:
                return MemoryIndexManager.C00652.invokeSuspend$lambda$0$0(i9);
            case 3:
                return MemoryIndexManager$scheduleCompactionIfNeeded$1$1$1.invokeSuspend$lambda$0$0(i9);
            case 4:
                return MemoryIndexManager.C00682.invokeSuspend$lambda$0$0(i9);
            case 5:
                return MemoryIndexManager.loadPermanentIndexOptimized$lambda$4(i9);
            default:
                return MemoryIndexManager.loadPermanentIndexOptimized$lambda$8(i9);
        }
    }
}
