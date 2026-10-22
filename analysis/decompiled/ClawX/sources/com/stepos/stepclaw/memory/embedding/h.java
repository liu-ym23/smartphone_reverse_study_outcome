package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1590a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1591b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1592c;

    public /* synthetic */ h(int i8, String str, int i9) {
        this.f1590a = i9;
        this.f1591b = i8;
        this.f1592c = str;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1590a) {
            case 0:
                return EmbeddingStorage.parseEntry$lambda$0(this.f1591b, this.f1592c);
            case 1:
                return EmbeddingStorage.parseEntry$lambda$1(this.f1591b, this.f1592c);
            case 2:
                return OfflineEvolutionService.markPendingAsEvolved$lambda$1(this.f1592c, this.f1591b);
            case 3:
                return MemoryIndexManager.loadPermanentIndexOptimized$lambda$5(this.f1592c, this.f1591b);
            case 4:
                return MemoryIndexManager.loadPermanentIndexOptimized$lambda$7(this.f1592c, this.f1591b);
            case 5:
                return MemoryIndexManager.loadPermanentIndexOptimized$lambda$9(this.f1592c, this.f1591b);
            default:
                return MemoryIndexManager.loadPermanentIndex$lambda$1(this.f1592c, this.f1591b);
        }
    }

    public /* synthetic */ h(String str, int i8, int i9) {
        this.f1590a = i9;
        this.f1592c = str;
        this.f1591b = i8;
    }
}
