package com.bytedance.apm.config;

import com.bytedance.apm.ApmAgent;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f190488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j.a f190489b;

    public final void a() {
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L4
        r100.put("looper_monitor", this.f190488a);     // Catch: JSONException -> L4
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L4
        r101.put(LocationMonitorConst.IS_MAIN_PROCESS, this.f190489b.f190510a.f190506q);     // Catch: JSONException -> L4
        ApmAgent.monitorEvent("apm_cost", r101, r100, null);     // Catch: JSONException -> L4
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

    public i(j.a r100, long r101) {
        this.f190489b = r100;
        this.f190488a = r101;
    }
}
