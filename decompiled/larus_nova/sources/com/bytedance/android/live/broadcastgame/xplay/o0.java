package com.bytedance.android.live.broadcastgame.xplay;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XplayMonitorSession f62290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f62291b;

    public o0(XplayMonitorSession r100, long r101) {
        this.f62290a = r100;
        this.f62291b = r101;
    }

    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.put("service", "ttlive_xplay_start");
        JSONObject r101 = new JSONObject();
        r101.put("duration", this.f62291b);
        Unit r102 = Unit.INSTANCE;
        r100.put("metric", r101);
        String r103 = com.bytedance.android.live.broadcastgame.api.h.a(this.f62290a.f61953e.getContext(), r100.toString());
        int r104 = XplayLog.f61931a;
        XplayLog.c("XplayMonitorSession", "storageXplayStartDuration, path " + r103);
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
