package com.stepos.statsrpk.service;

import android.content.Context;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import java.util.HashMap;
import k.RunnableC0653g;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RpkEvent f12376a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RpkInfo f12377b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RpkUsageStatsService.RpkStatsInterface f12378c;

    public b(RpkUsageStatsService.RpkStatsInterface rpkStatsInterface, RpkEvent rpkEvent, RpkInfo rpkInfo) {
        this.f12378c = rpkStatsInterface;
        this.f12376a = rpkEvent;
        this.f12377b = rpkInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrackerPayload trackerPayloadC;
        RpkUsageStatsService.RpkStatsInterface rpkStatsInterface = this.f12378c;
        if (rpkStatsInterface.rpkEmitterWorker != null) {
            RpkEvent rpkEvent = this.f12376a;
            if (rpkEvent.f12344a.equals("action_x")) {
                trackerPayloadC = new H2.a(rpkStatsInterface.mContext, rpkEvent.f12345b, rpkEvent.f12346c, rpkEvent.f12347d).c();
                trackerPayloadC.c(rpkEvent.f12348e, "sid");
            } else if (rpkEvent.f12344a.equals(PersonalContract.KEY_PAGE)) {
                HashMap map = new HashMap();
                map.put("duration2", String.valueOf((String) rpkEvent.f12347d.get("duration2")));
                trackerPayloadC = new H2.b(rpkStatsInterface.mContext, rpkEvent.f12345b, (String) rpkEvent.f12347d.get("start"), (String) rpkEvent.f12347d.get("end"), map).c();
                trackerPayloadC.c(rpkEvent.f12348e, "sid");
            } else {
                trackerPayloadC = null;
            }
            TrackerPayload trackerPayload = trackerPayloadC;
            if (trackerPayload != null) {
                if (rpkStatsInterface.subject != null) {
                    trackerPayload.f(rpkStatsInterface.subject.f1581a.a());
                    trackerPayload.f(rpkStatsInterface.subject.f1582b.a());
                    trackerPayload.f(rpkStatsInterface.subject.f1584d);
                    P2.c cVar = rpkStatsInterface.subject;
                    Context context = rpkStatsInterface.mContext;
                    cVar.getClass();
                    trackerPayload.f(P2.c.b(context));
                }
                RpkInfo rpkInfo = this.f12377b;
                rpkStatsInterface.appendRpkInfo(trackerPayload, rpkInfo);
                d dVar = rpkStatsInterface.rpkEmitterWorker;
                String str = rpkInfo.f12353e;
                String str2 = rpkInfo.f12349a;
                dVar.getClass();
                dVar.f12382d.execute(new RunnableC0653g(4, dVar, str, str2, trackerPayload));
            }
        }
    }
}
