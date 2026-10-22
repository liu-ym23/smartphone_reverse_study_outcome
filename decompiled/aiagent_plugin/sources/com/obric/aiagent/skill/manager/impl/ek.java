package com.obric.aiagent.skill.manager.impl;

import android.os.SystemClock;
import java.util.Map;

/* JADX INFO: compiled from: SkillScanPerformanceState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ek {
    public static final Map<String, Object> a(ej r3) {
        d.h.b.o.e(r3, "<this>");
        return d.a.ao.a(new d.m[]{d.s.a("processing_poll_count", Integer.valueOf(r3.i())), d.s.a("query_failure_count", Integer.valueOf(r3.j())), d.s.a("query_duration_ms", Long.valueOf(r3.k())), d.s.a("query_max_duration_ms", Long.valueOf(r3.l()))});
    }

    public static final long b(ej r6) {
        d.h.b.o.e(r6, "<this>");
        long r0 = r6.e();
        long r2 = SystemClock.elapsedRealtime();
        if (r0 > 0) goto L5;
        return 0;
    L5:
        if (r2 >= r0) goto L8;
        return 0;
    L8:
        return r2 - r0;
    }
}
