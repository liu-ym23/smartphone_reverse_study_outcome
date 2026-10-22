package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.MemoryDumpCommandHandler;
import com.stepos.stepclaw.memory.MemoryEngine;
import com.stepos.stepclaw.memory.MemoryFormatMigrator;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import com.stepos.stepclaw.memory.lightmem.remote.AutoCatchResponse;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateFirstRequest;
import com.stepos.stepclaw.memory.search.SearchPipelineResult;
import java.io.IOException;
import java.util.Set;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1572a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1573b;

    public /* synthetic */ c(int i8, Object obj) {
        this.f1572a = i8;
        this.f1573b = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1572a;
        Object obj = this.f1573b;
        switch (i8) {
            case 0:
                return MemoryDumpCommandHandler.AnonymousClass1.invokeSuspend$lambda$2((StringBuilder) obj);
            case 1:
                return MemoryEngine.AnonymousClass3.invokeSuspend$lambda$0$5((AutoCatchResponse) obj);
            case 2:
                return MemoryEngine.AnonymousClass3.invokeSuspend$lambda$0$3((w) obj);
            case 3:
                return MemoryEngine$autoRecall$4$1.invokeSuspend$lambda$0$0((SearchPipelineResult) obj);
            case 4:
                return MemoryEngine.C00363.invokeSuspend$lambda$0$0((OfflineEvolutionService) obj);
            case 5:
                return MemoryEngine.C00363.invokeSuspend$lambda$1((MemoryFormatMigrator.MigrationResult) obj);
            case 6:
                return MemoryDumpCommandHandler.dumpOfflineUpdateSubmit$lambda$2((OfflineUpdateFirstRequest) obj);
            case 7:
                return MemoryDumpCommandHandler.handle$lambda$0((IOException) obj);
            default:
                return MemoryEngine.cleanupLegacyEmbeddingDirs$lambda$0((Set) obj);
        }
    }
}
