package com.stepos.stepclaw.memory.lightmem.evolution;

import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1656a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Exception f1657b;

    public /* synthetic */ i(Exception exc, int i8) {
        this.f1656a = i8;
        this.f1657b = exc;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1656a;
        Exception exc = this.f1657b;
        switch (i8) {
            case 0:
                return OfflineEvolutionService.AnonymousClass2.invokeSuspend$lambda$1(exc);
            default:
                return OfflineEvolutionService.clearStaleCaches$lambda$0(exc);
        }
    }
}
