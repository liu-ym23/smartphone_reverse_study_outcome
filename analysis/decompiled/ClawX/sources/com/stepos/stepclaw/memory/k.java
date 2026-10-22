package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.MemoryDumpCommandHandler;
import com.stepos.stepclaw.memory.MemoryEngine;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1618a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Exception f1619b;

    public /* synthetic */ k(Exception exc, int i8) {
        this.f1618a = i8;
        this.f1619b = exc;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1618a;
        Exception exc = this.f1619b;
        switch (i8) {
            case 0:
                return MemoryDumpCommandHandler.C00311.invokeSuspend$lambda$3(exc);
            case 1:
                return MemoryDumpCommandHandler.AnonymousClass3.invokeSuspend$lambda$3(exc);
            case 2:
                return MemoryEngine.AnonymousClass3.invokeSuspend$lambda$0$6(exc);
            case 3:
                return MemoryEngine.AnonymousClass1.invokeSuspend$lambda$2(exc);
            case 4:
                return MemoryEngine.autoRecall$lambda$3$0(exc);
            case 5:
                return MemoryEngine.writeCategoryMemoryToDailyRemote$lambda$1(exc);
            case 6:
                return MemoryEngine.backfillEmbeddingsInternal$lambda$3(exc);
            default:
                return MemoryEngine.writeCategoryMemoryToDaily$lambda$3(exc);
        }
    }
}
