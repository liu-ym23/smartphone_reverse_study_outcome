package com.bytedance.monitor.collector;

import android.util.Pair;

/* JADX INFO: compiled from: AtraceMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    @Override // com.bytedance.monitor.collector.b
    public void b(int r1) {
    }

    public c(int r2) {
        super(r2, "atrace_event");
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> c() {
    L8:
        return null;
    L4:
        if (k.f9012a == true) goto L6;
        return null;
    L6:
        return new Pair(this.f8950a, d());
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> a(long r4, long r6) {
    L8:
        return null;
    L4:
        if (k.f9012a == true) goto L6;
        return null;
    L6:
        return new Pair(this.f8950a, b(r4, r6));
    }

    public void a(long r2) {
        if (k.f9012a == true) goto L5;
        return;
    L5:
        MonitorJni.doEnableAtrace(this.f8952c, r2);     // Catch: Throwable -> L7
        return;
    }

    private String d() {
        if (k.f9012a == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtrace();
    }

    private String b(long r1, long r3) {
        if (k.f9012a == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtraceRange(r1, r3);
    }
}
