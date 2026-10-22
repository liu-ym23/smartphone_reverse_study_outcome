package com.stepos.stepclaw.memory.lightmem.evolution;

import com.stepos.stepclaw.memory.storage.persist.IndexPersistence;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1639a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1640b;

    public /* synthetic */ b(int i8, int i9) {
        this.f1639a = i9;
        this.f1640b = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1639a;
        int i9 = this.f1640b;
        switch (i8) {
            case 0:
                return OfflineEvolutionService.runPipeline$lambda$11(i9);
            default:
                return IndexPersistence.loadPersistedMeta$lambda$0(i9);
        }
    }
}
