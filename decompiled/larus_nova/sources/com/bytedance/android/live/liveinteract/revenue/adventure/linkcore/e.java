package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f77931a;

    public e(f.a r100) {
        this.f77931a = r100;
    }

    public final void a() {
        String r100 = ei0.a.f472759a;
        JSONObject r101 = new JSONObject();
        r101.put("adventure_call_user_type", ei0.a.f472759a);
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.AdventureCall, "adventure_call_leave_multi_link_result", 0, null, r101, 88);
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        ALogger.d("AdventureFullLinkMonitor", String.format("leaveMultiLinkSuccess, extra: %s", Arrays.copyOf(new Object[]{r101}, 1)));
        m.a r104 = this.f77931a.f77933a.f77932a;
        if (r104 == null) goto L6;
        r104.a();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
