package com.apm.insight;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.MonitorCrash;
import e2.C1404a;
import e2.C1406c;
import java.util.HashMap;
import w2.AbstractC2095a;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f2155a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ MonitorCrash c;

    public a(MonitorCrash monitorCrash, boolean z10, Context context) {
        this.c = monitorCrash;
        this.f2155a = z10;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.isAppLogInit) {
            return;
        }
        if (!AbstractC2095a.f) {
            AbstractC2095a.j();
        }
        z2.d dVar = (z2.d) z2.d.c.get(this.c.mConfig.f2147a);
        if (dVar == null || dVar.e()) {
            this.c.isAppLogInit = true;
            if (MonitorCrash.sDefaultApplogUrl != null) {
                F.g gVar = new F.g(6);
                gVar.b = B7.a.q(new StringBuilder(), MonitorCrash.sDefaultApplogUrl, "/apm/device_register");
                gVar.c = new String[]{B7.a.q(new StringBuilder(), MonitorCrash.sDefaultApplogUrl, "/monitor/collect/c/session")};
                this.c.mApmApplogConfig.f = new A5.c(gVar);
            }
            if (this.f2155a) {
                C1406c c1406c = this.c.mApmApplogConfig;
                MonitorCrash monitorCrash = this.c;
                c1406c.i = (int) monitorCrash.mConfig.d;
                C1406c c1406c2 = monitorCrash.mApmApplogConfig;
                MonitorCrash monitorCrash2 = this.c;
                c1406c2.h = (int) monitorCrash2.mConfig.d;
                C1406c c1406c3 = monitorCrash2.mApmApplogConfig;
                MonitorCrash monitorCrash3 = this.c;
                c1406c3.f4336j = monitorCrash3.mConfig.e;
                C1406c c1406c4 = monitorCrash3.mApmApplogConfig;
                String str = this.c.mConfig.e;
                c1406c4.getClass();
                this.c.mApmApplogConfig.g = this.c.mConfig.e;
            } else {
                String strF = n2.c.f(f.b);
                HashMap map = new HashMap();
                map.put("host_app_id", strF);
                map.put("sdk_version", this.c.mConfig.e);
                this.c.mApmApplogConfig.k = map;
            }
            if (!TextUtils.isEmpty(this.c.mConfig.getDeviceId())) {
                this.c.mApmApplogConfig.l = this.c.mConfig.getDeviceId();
            }
            if (!TextUtils.isEmpty(this.c.mConfig.c)) {
                this.c.mApmApplogConfig.c = this.c.mConfig.c;
            }
            C1406c c1406c5 = this.c.mApmApplogConfig;
            MonitorCrash monitorCrash4 = this.c;
            MonitorCrash.Config config = monitorCrash4.mConfig;
            c1406c5.m = config.f2150r;
            if (config.p == null) {
                C1404a.d(this.b, monitorCrash4.mApmApplogConfig, null);
            } else {
                C1404a.d(this.b, monitorCrash4.mApmApplogConfig, this.c.mConfig.p);
            }
        }
    }
}
