package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import java.util.List;
import p5.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2826c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f2827f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f2828g;

    public /* synthetic */ d(int i) {
        this.f2826c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2826c) {
            case 0:
                ((V3OfflineEmitter$VccOfflineStatsCallback) this.f2827f).lambda$onRealBulkInsertEvents$1((List) this.f2828g);
                break;
            default:
                f fVar = (f) this.f2827f;
                String str = (String) this.f2828g;
                fVar.getClass();
                i iVar = g.f2838a;
                if (iVar.j(fVar.f2830a)) {
                    try {
                        ((IVccOfflineStatsInterface) iVar.f9731f).emitterUpdateEventSource(str, null);
                        break;
                    } catch (Throwable th) {
                        ua.c.b("V3RemoteServiceReq", "emitterUpdateEventSource error, " + th.getMessage());
                    }
                }
                break;
        }
    }
}
