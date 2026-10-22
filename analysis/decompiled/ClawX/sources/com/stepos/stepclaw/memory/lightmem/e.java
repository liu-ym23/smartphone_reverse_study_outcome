package com.stepos.stepclaw.memory.lightmem;

import b5.a0;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionLog;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionDeleteMemory;
import java.io.IOException;
import u6.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1634a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1635b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1636c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(Object obj, int i8, int i9, int i10) {
        this.f1634a = i10;
        this.f1635b = i8;
        this.f1636c = i9;
        this.d = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1634a) {
            case 0:
                return LightMemClient.logEvolutionGroupsSummary$lambda$3(this.f1635b, this.f1636c, (OfflineEvolutionDeleteMemory) this.d);
            case 1:
                return OfflineEvolutionLog.step$lambda$0(this.f1635b, this.f1636c, (String) this.d);
            default:
                n nVar = (n) this.d;
                try {
                    nVar.y.l(this.f1635b, this.f1636c, true);
                } catch (IOException e9) {
                    u6.b bVar = u6.b.d;
                    nVar.a(bVar, bVar, e9);
                }
                return a0.f883a;
        }
    }

    public /* synthetic */ e(n nVar, int i8, int i9) {
        this.f1634a = 2;
        this.d = nVar;
        this.f1635b = i8;
        this.f1636c = i9;
    }
}
