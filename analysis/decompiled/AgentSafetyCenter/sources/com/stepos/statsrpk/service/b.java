package com.stepos.statsrpk.service;

import android.content.Context;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ com.stepos.statsrpk.a f2879c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ com.stepos.statsrpk.b f2880f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ RpkUsageStatsService.RpkStatsInterface f2881g;

    @Override // java.lang.Runnable
    public final void run() {
        TrackerPayload trackerPayload;
        com.stepos.statsrpk.b bVar = this.f2880f;
        com.stepos.statsrpk.a aVar = this.f2879c;
        RpkUsageStatsService.RpkStatsInterface rpkStatsInterface = this.f2881g;
        if (rpkStatsInterface.rpkEmitterWorker != null) {
            if (aVar.f2844c.equals("action_x")) {
                trackerPayload = new ha.a(rpkStatsInterface.mContext, aVar.f2845f, aVar.f2846g, aVar.f2847h).d();
                trackerPayload.a(aVar.i, "sid");
            } else if (aVar.f2844c.equals("page")) {
                HashMap map = new HashMap();
                map.put("duration2", String.valueOf((String) aVar.f2847h.get("duration2")));
                Context context = rpkStatsInterface.mContext;
                String str = aVar.f2845f;
                String str2 = (String) aVar.f2847h.get("start");
                String str3 = (String) aVar.f2847h.get("end");
                ha.d dVar = new ha.d(context, str, map);
                dVar.f5431d = str2;
                dVar.f5432e = str3;
                VarHandle.storeStoreFence();
                trackerPayload = new TrackerPayload();
                trackerPayload.a((String) dVar.f1652a, "name");
                trackerPayload.a((String) dVar.f1653b, "network");
                trackerPayload.a("page", "type");
                trackerPayload.a(dVar.f5431d, "launch");
                trackerPayload.a(dVar.f5432e, "terminate");
                HashMap map2 = (HashMap) dVar.f1654c;
                if (map2 == null) {
                    ua.c.e("TrackerPayload", "Map passed in is null, returning without adding map.");
                } else {
                    trackerPayload.f2843f.putAll(map2);
                }
                trackerPayload.a(aVar.i, "sid");
            } else {
                trackerPayload = null;
            }
            if (trackerPayload != null) {
                if (rpkStatsInterface.subject != null) {
                    trackerPayload.b(rpkStatsInterface.subject.f10211a.f10209a);
                    trackerPayload.b(rpkStatsInterface.subject.f10212b.f10209a);
                    trackerPayload.b(rpkStatsInterface.subject.f10214d);
                    qa.c cVar = rpkStatsInterface.subject;
                    Context context2 = rpkStatsInterface.mContext;
                    cVar.getClass();
                    trackerPayload.b(qa.c.a(context2));
                }
                rpkStatsInterface.appendRpkInfo(trackerPayload, bVar);
                e eVar = rpkStatsInterface.rpkEmitterWorker;
                String str4 = bVar.i;
                String str5 = bVar.f2848c;
                ScheduledExecutorService scheduledExecutorService = eVar.f2889c;
                com.stepos.statsrpk.c cVar2 = new com.stepos.statsrpk.c(1);
                cVar2.i = eVar;
                cVar2.f2853f = str4;
                cVar2.f2854g = str5;
                cVar2.f2855h = trackerPayload;
                VarHandle.storeStoreFence();
                scheduledExecutorService.execute(cVar2);
            }
        }
    }
}
