package com.stepos.stepclaw.memory.lightmem.evolution;

import com.stepos.stepclaw.memory.storage.file.DailyMemoryFile;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1641a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1642b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DailyMemoryFile f1643c;

    public /* synthetic */ c(int i8, DailyMemoryFile dailyMemoryFile, int i9) {
        this.f1641a = i9;
        this.f1642b = i8;
        this.f1643c = dailyMemoryFile;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1641a) {
            case 0:
                return OfflineEvolutionService.collectPendingFromDaily$lambda$0(this.f1642b, this.f1643c);
            default:
                return MemoryIndexManager.indexDailyFile$lambda$0(this.f1642b, this.f1643c);
        }
    }
}
