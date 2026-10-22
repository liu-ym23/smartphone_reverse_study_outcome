package com.stepos.stepclaw.memory.lightmem;

import b5.a0;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import java.io.IOException;
import u6.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1630a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1631b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1632c;
    public final /* synthetic */ Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1633e;

    public /* synthetic */ d(int i8, String str, int i9, CatchMemoryItem catchMemoryItem) {
        this.f1631b = i8;
        this.d = str;
        this.f1632c = i9;
        this.f1633e = catchMemoryItem;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1630a) {
            case 0:
                return LightMemClient.logEvolutionGroupsSummary$lambda$2(this.f1631b, (String) this.d, this.f1632c, (CatchMemoryItem) this.f1633e);
            default:
                n nVar = (n) this.d;
                int i8 = this.f1631b;
                c7.f fVar = (c7.f) this.f1633e;
                int i9 = this.f1632c;
                try {
                    nVar.f5723l.getClass();
                    fVar.skip(i9);
                    nVar.y.n(i8, u6.b.f5675h);
                    synchronized (nVar) {
                        nVar.A.remove(Integer.valueOf(i8));
                    }
                } catch (IOException unused) {
                }
                return a0.f883a;
        }
    }

    public /* synthetic */ d(n nVar, int i8, c7.f fVar, int i9, boolean z) {
        this.d = nVar;
        this.f1631b = i8;
        this.f1633e = fVar;
        this.f1632c = i9;
    }
}
