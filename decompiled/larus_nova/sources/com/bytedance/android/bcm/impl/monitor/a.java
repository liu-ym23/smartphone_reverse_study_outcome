package com.bytedance.android.bcm.impl.monitor;

import com.bytedance.android.btm.api.model.k;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f41836a;

    /* JADX INFO: renamed from: com.bytedance.android.bcm.impl.monitor.a$a, reason: collision with other inner class name */
    public static final class RunnableC0770a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f41837a;

        public RunnableC0770a(a r100) {
            this.f41837a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k r100 = new k("bcm_report", this.f41837a.f41836a);     // Catch: Throwable -> L4
            com.bytedance.android.btm.impl.b.f42126e.a().onEventV3(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(JSONObject r100) {
        this.f41836a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.btm.impl.thread.b.f42488e.b(new RunnableC0770a(this), false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
