package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import A6.l;
import com.stepos.ability.App;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class d extends com.stepos.statsapp.v3.lib.plugin.emitter.b {
    public final V3OfflineEmitter$VccOfflineStatsCallback d;
    public final ThreadPoolExecutor e;
    public final V5.a f;
    public long g;
    public final String h;

    public d(App app, String str, String str2) throws Throwable {
        super(app, str, str2);
        this.g = 0L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        c cVar = new c();
        cVar.f3971a = new AtomicInteger(0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, timeUnit, linkedBlockingQueue, cVar, new U5.b(1));
        this.e = threadPoolExecutor;
        this.h = app.getPackageName();
        try {
            String strA = T5.b.a(app);
            if (strA == null || strA.equals(app.getPackageName())) {
                this.f = new V5.a(app, "com.stepos.statsapp.v3.events_cache");
            } else {
                this.f = new V5.a(app, "com.stepos.statsapp.v3.events_cache_".concat(strA));
            }
            threadPoolExecutor.execute(new l(this, 25));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = new V3OfflineEmitter$VccOfflineStatsCallback(this, null);
        e.f3972a.v(app, this);
    }

    public final void c() {
        u1.d dVar = e.f3972a;
        String str = this.h;
        V3OfflineEmitter$VccOfflineStatsCallback v3OfflineEmitter$VccOfflineStatsCallback = this.d;
        if (dVar.H(this.f3966a)) {
            try {
                ((IVccOfflineStatsInterface) dVar.c).setCallback(str, v3OfflineEmitter$VccOfflineStatsCallback);
            } catch (Throwable th) {
                W5.c.b("V3RemoteServiceReq", "setCallback error, " + th.getMessage());
            }
        }
        this.e.execute(new O5.b(this, false, 1));
    }

    public final void d(TrackerPayload trackerPayload) {
        if (this.b.isActive()) {
            this.e.execute(new A4.e(this, trackerPayload, trackerPayload.toString(), 4));
        }
    }
}
