package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3970a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f3970a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3970a) {
            case 0:
                ((V3OfflineEmitter$VccOfflineStatsCallback) this.b).lambda$onRealBulkInsertEvents$1((List) this.c);
                break;
            default:
                d dVar = (d) this.b;
                String str = (String) this.c;
                dVar.getClass();
                u1.d dVar2 = e.f3972a;
                if (dVar2.H(dVar.f3966a)) {
                    try {
                        ((IVccOfflineStatsInterface) dVar2.c).emitterUpdateEventSource(str, null);
                        break;
                    } catch (Throwable th) {
                        W5.c.b("V3RemoteServiceReq", "emitterUpdateEventSource error, " + th.getMessage());
                    }
                }
                break;
        }
    }
}
