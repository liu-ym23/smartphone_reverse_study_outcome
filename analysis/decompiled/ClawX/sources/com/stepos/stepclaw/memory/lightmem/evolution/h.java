package com.stepos.stepclaw.memory.lightmem.evolution;

import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionDeleteMemory;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerResponse;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse;
import java.util.List;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1654a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1655b;

    public /* synthetic */ h(int i8, Object obj) {
        this.f1654a = i8;
        this.f1655b = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1654a;
        Object obj = this.f1655b;
        switch (i8) {
            case 0:
                return OfflineEvolutionService.AnonymousClass2.invokeSuspend$lambda$0((OfflineEvolutionPipelineResult) obj);
            case 1:
                return OfflineEvolutionService.runPipeline$lambda$10((OfflineUpdateResponse) obj);
            case 2:
                return OfflineEvolutionService.cacheTriggerResponse$lambda$0((OfflineTriggerResponse) obj);
            case 3:
                return OfflineEvolutionService.loadAllPendingEpisodic$lambda$0((OfflineEvolutionService) obj);
            case 4:
                return OfflineEvolutionService.applyEvolutionResult$lambda$2((OfflineEvolutionDeleteMemory) obj);
            case 5:
                return OfflineEvolutionService.loadAllPendingEpisodic$lambda$1((List) obj);
            default:
                return OfflineEvolutionService.runPipeline$lambda$4((y) obj);
        }
    }
}
