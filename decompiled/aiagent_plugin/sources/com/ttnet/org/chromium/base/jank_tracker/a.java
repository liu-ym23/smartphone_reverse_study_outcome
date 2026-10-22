package com.ttnet.org.chromium.base.jank_tracker;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: FrameMetricsStore.java */
/* JADX INFO: loaded from: classes4.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f37707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<Long> f37708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<Long> f37709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<Integer> f37710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<Integer, Long> f37711e;

    void a(long r3, long r5, int r7) {
        Object r0 = this.f37707a;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f37711e.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.f37708b.add(Long.valueOf(r3));     // Catch: Throwable -> L11
        this.f37709c.add(Long.valueOf(r5));     // Catch: Throwable -> L11
        this.f37710d.add(Integer.valueOf(r7));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }
}
