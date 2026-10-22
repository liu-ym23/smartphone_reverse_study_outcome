package com.stepos.stepclaw.memory.lightmem.evolution;

import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1637a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f1638b;

    public /* synthetic */ a(int i8, w wVar) {
        this.f1637a = i8;
        this.f1638b = wVar;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1637a;
        w wVar = this.f1638b;
        switch (i8) {
            case 0:
                return OfflineEvolutionService.runPipeline$lambda$6(wVar);
            default:
                return OfflineEvolutionService.clearStaleCaches$lambda$1(wVar);
        }
    }
}
