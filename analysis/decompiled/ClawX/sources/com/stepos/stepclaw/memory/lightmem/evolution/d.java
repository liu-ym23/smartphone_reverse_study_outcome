package com.stepos.stepclaw.memory.lightmem.evolution;

import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1644a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1645b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1646c;

    public /* synthetic */ d(Object obj, int i8, Object obj2) {
        this.f1644a = i8;
        this.f1645b = obj;
        this.f1646c = obj2;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1644a) {
            case 0:
                return OfflineEvolutionService.collectPendingFromDaily$lambda$2((OfflineEvolutionService.EpisodicLoadStats) this.f1645b, (Exception) this.f1646c);
            case 1:
                return OfflineEvolutionService.loadAllPendingEpisodic$lambda$3((OfflineEvolutionService.EpisodicLoadStats) this.f1645b, (List) this.f1646c);
            default:
                return OfflineEvolutionService.applyEvolutionResult$lambda$7((Long) this.f1645b, (String) this.f1646c);
        }
    }
}
