package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse;
import java.io.File;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1677a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1678b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1679c;

    public /* synthetic */ q(Object obj, boolean z, int i8) {
        this.f1677a = i8;
        this.f1679c = obj;
        this.f1678b = z;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1677a) {
            case 0:
                return MemoryEngine.switchEmbeddingProvider$lambda$0$2((File) this.f1679c, this.f1678b);
            default:
                return OfflineEvolutionService.runPipeline$lambda$13((OfflineUpdateResponse) this.f1679c, this.f1678b);
        }
    }
}
