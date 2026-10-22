package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.MemoryDumpCommandHandler;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1574a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1575b;

    public /* synthetic */ d(String str, int i8) {
        this.f1574a = i8;
        this.f1575b = str;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1574a;
        String str = this.f1575b;
        switch (i8) {
            case 0:
                return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$0(str);
            case 1:
                return MemoryEngine$autoRecall$4$1.invokeSuspend$lambda$2(str);
            case 2:
                return MemoryDumpCommandHandler.dumpOfflineTrigger$lambda$1(str);
            case 3:
                return MemoryEngine.resolveInitialProvider$lambda$1(str);
            case 4:
                return MemoryEngine.autoRecall$lambda$2(str);
            case 5:
                return MemoryEngine.autoRecall$lambda$4$0(str);
            case 6:
                return MemoryEngine.switchEmbeddingProvider$lambda$0$0(str);
            default:
                return MemoryEngine.resolveInitialProvider$lambda$0(str);
        }
    }
}
