package com.bytedance.bdtracker;

import com.bytedance.bdtracker.b;

/* loaded from: classes.dex */
public class n0 implements b.f {
    public final /* synthetic */ Throwable a;

    public n0(m0 m0Var, Throwable th) {
        this.a = th;
    }

    @Override // com.bytedance.bdtracker.b.f
    public void a(d dVar) {
        if (dVar.getInitConfig() == null || !dVar.getInitConfig().isMonitorEnabled()) {
            return;
        }
        o2.b(dVar.getMonitor(), this.a);
    }
}
