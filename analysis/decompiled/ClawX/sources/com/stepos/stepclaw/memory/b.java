package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.MemoryDumpCommandHandler;
import com.stepos.stepclaw.memory.MemoryEngine;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1571a;

    public /* synthetic */ b(int i8) {
        this.f1571a = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1571a) {
            case 0:
                return MemoryDumpCommandHandler.AnonymousClass1.invokeSuspend$lambda$0();
            case 1:
                return MemoryDumpCommandHandler.AnonymousClass1.invokeSuspend$lambda$3();
            case 2:
                return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$1();
            case 3:
                return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$2();
            case 4:
                return MemoryDumpCommandHandler.C00311.invokeSuspend$lambda$2();
            case 5:
                return MemoryDumpCommandHandler.C00321.invokeSuspend$lambda$0();
            case 6:
                return MemoryDumpCommandHandler.C00321.invokeSuspend$lambda$2();
            case 7:
                return MemoryDumpCommandHandler.AnonymousClass2.invokeSuspend$lambda$0();
            case 8:
                return MemoryDumpCommandHandler.AnonymousClass2.invokeSuspend$lambda$2();
            case 9:
                return MemoryEngine.AnonymousClass3.invokeSuspend$lambda$0$1();
            case 10:
                return MemoryDumpCommandHandler.dumpOfflineTrigger$lambda$3();
            case BERTags.EMBEDDED_PDV /* 11 */:
                return MemoryEngine.autoRecall$lambda$0();
            case 12:
                return MemoryEngine.autoRecall$lambda$1();
            case BERTags.RELATIVE_OID /* 13 */:
                return MemoryEngine.maybeAutoTriggerEvolution$lambda$0();
            case BERTags.TIME /* 14 */:
                return MemoryEngine.runOfflineEvolutionEpisodicPipeline$lambda$0();
            case 15:
                return MemoryEngine.autoCapture$lambda$0();
            case 16:
                return MemoryEngine.autoCapture$lambda$1();
            case 17:
                return MemoryEngine.searchConfig;
            case BERTags.NUMERIC_STRING /* 18 */:
                return MemoryEngine.buildDefaultProviderRegistry$lambda$0();
            case 19:
                return MemoryEngine.buildDefaultProviderRegistry$lambda$1("https://api.siliconflow.cn/v1");
            case 20:
                return MemoryEngine.buildDefaultProviderRegistry$lambda$2("https://api.siliconflow.cn/v1");
            default:
                return MemoryEngine.updateEmbeddingConfig$lambda$0();
        }
    }
}
