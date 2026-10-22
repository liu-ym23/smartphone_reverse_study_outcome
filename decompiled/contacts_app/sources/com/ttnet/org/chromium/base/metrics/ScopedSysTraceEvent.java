package com.ttnet.org.chromium.base.metrics;

import android.os.Trace;

/* JADX INFO: loaded from: classes4.dex */
public class ScopedSysTraceEvent implements AutoCloseable {
    public static ScopedSysTraceEvent scoped(String r1) {
        return new ScopedSysTraceEvent(r1);
    }

    private ScopedSysTraceEvent(String r1) {
        Trace.beginSection(r1);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Trace.endSection();
    }
}
