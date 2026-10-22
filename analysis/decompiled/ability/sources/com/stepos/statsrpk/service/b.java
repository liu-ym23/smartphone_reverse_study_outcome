package com.stepos.statsrpk.service;

import android.content.Context;
import androidx.autofill.HintConstants;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RpkEvent f3984a;
    public final /* synthetic */ RpkInfo b;
    public final /* synthetic */ RpkUsageStatsService.RpkStatsInterface c;

    public b(RpkUsageStatsService.RpkStatsInterface rpkStatsInterface, RpkEvent rpkEvent, RpkInfo rpkInfo) {
        this.c = rpkStatsInterface;
        this.f3984a = rpkEvent;
        this.b = rpkInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrackerPayload trackerPayload;
        RpkUsageStatsService.RpkStatsInterface rpkStatsInterface = this.c;
        if (rpkStatsInterface.rpkEmitterWorker != null) {
            RpkEvent rpkEvent = this.f3984a;
            if (rpkEvent.f3975a.equals("action_x")) {
                trackerPayload = new J5.a(rpkStatsInterface.mContext, rpkEvent.b, rpkEvent.c, rpkEvent.d).b();
                trackerPayload.addHeader("sid", rpkEvent.e);
            } else if (rpkEvent.f3975a.equals("page")) {
                HashMap map = new HashMap();
                map.put("duration2", String.valueOf((String) rpkEvent.d.get("duration2")));
                J5.d dVar = new J5.d(rpkStatsInterface.mContext, rpkEvent.b, (String) rpkEvent.d.get("start"), (String) rpkEvent.d.get("end"), map);
                trackerPayload = new TrackerPayload();
                trackerPayload.addHeader(HintConstants.AUTOFILL_HINT_NAME, (String) dVar.b);
                trackerPayload.addHeader("network", (String) dVar.c);
                trackerPayload.addHeader("type", "page");
                trackerPayload.addHeader("launch", dVar.e);
                trackerPayload.addHeader("terminate", dVar.f);
                trackerPayload.addValueMap((HashMap) dVar.d);
                trackerPayload.addHeader("sid", rpkEvent.e);
            } else {
                trackerPayload = null;
            }
            TrackerPayload trackerPayload2 = trackerPayload;
            if (trackerPayload2 != null) {
                if (rpkStatsInterface.subject != null) {
                    trackerPayload2.addHeaderMap((HashMap) rpkStatsInterface.subject.f1175a.b);
                    trackerPayload2.addHeaderMap((HashMap) rpkStatsInterface.subject.b.f6811a);
                    trackerPayload2.addHeaderMap(rpkStatsInterface.subject.d);
                    S5.a aVar = rpkStatsInterface.subject;
                    Context context = rpkStatsInterface.mContext;
                    aVar.getClass();
                    trackerPayload2.addHeaderMap(S5.a.b(context));
                }
                RpkInfo rpkInfo = this.b;
                rpkStatsInterface.appendRpkInfo(trackerPayload2, rpkInfo);
                e eVar = rpkStatsInterface.rpkEmitterWorker;
                eVar.c.execute(new H.e(eVar, rpkInfo.e, rpkInfo.f3976a, trackerPayload2, 2));
            }
        }
    }
}
