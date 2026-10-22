package com.bytedance.apm6.cpu.c.a;

import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;

/* JADX INFO: compiled from: NormalProcessDetectState.java */
/* JADX INFO: loaded from: classes.dex */
class f extends a {
    @Override // com.bytedance.apm6.cpu.c.a.a
    public boolean d() {
        return false;
    }

    public f(com.bytedance.apm6.cpu.c.d r1) {
        super(r1);
    }

    @Override // com.bytedance.apm6.cpu.c.g
    public com.bytedance.apm6.cpu.c.h b() {
        return com.bytedance.apm6.cpu.c.h.f5271a;
    }

    @Override // com.bytedance.apm6.cpu.c.a.a
    public long c() {
        if (this.f5234b != null) goto L10;
        if (this.f5235c == true) goto L14;
        return OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
    L14:
        return 600000;
    L10:
        if (this.f5235c == false) goto L13;
        return 600000;
    L13:
        return ((long) this.f5234b.k()) * 1000;
    }

    @Override // com.bytedance.apm6.cpu.c.a.a
    public boolean b(boolean r2) {
        if (r2 == false) goto L10;
        com.bytedance.apm6.cpu.a.b r0 = com.bytedance.apm6.cpu.c.c.a().d();
        if (r0 != null) goto L6;
    L9:
        this.f5233a.d();
        goto L10
    L6:
        if (r0.a() == false) goto L9;
        return false;
    L10:
        return r2;
    }
}
