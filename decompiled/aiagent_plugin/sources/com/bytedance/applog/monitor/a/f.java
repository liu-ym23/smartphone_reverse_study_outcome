package com.bytedance.applog.monitor.a;

import com.bytedance.applog.monitor.v3.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: HighFrequencyTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f5749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f5750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f5751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedList<a> f5752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, Integer> f5753e;

    /* JADX INFO: compiled from: HighFrequencyTracker.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        i f5754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f5756c;

        public a(i r1, String r2, long r3) {
            this.f5754a = r1;
            this.f5755b = r2;
            this.f5756c = r3;
        }
    }

    /* JADX INFO: compiled from: HighFrequencyTracker.java */
    public interface b {
        void a(Map<String, Integer> r1);
    }

    public synchronized void a(i r3, String r4, long r5) {
        monitor-enter(this);
        this.f5752d.add(new a(r3, r4, r5));     // Catch: Throwable -> L12
        String r6 = r3 + ":" + r4;     // Catch: Throwable -> L12
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(this.f5753e.get(r6), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r7 != null) goto L6;
        this.f5753e.put(r6, 1);     // Catch: Throwable -> L12
    L7:
        a(r5);     // Catch: Throwable -> L12
        if (this.f5752d.size() <= this.f5750b) goto L10;
        a();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        this.f5753e.put(r6, Integer.valueOf(r7.intValue() + 1));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private void a(long r6) {
    L3:
        if (this.f5752d.isEmpty() == true) goto L12;
        if (((a) ZeusTransformUtils.preCheckCast(this.f5752d.getFirst(), a.class, "com.obric.aiagent.plugin")).f5756c >= (r6 - this.f5749a)) goto L22;
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f5752d.removeFirst(), a.class, "com.obric.aiagent.plugin");
        String r1 = r0.f5754a + ":" + r0.f5755b;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.f5753e.get(r1), Integer.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L3;
        if (r2.intValue() > 1) goto L10;
        this.f5753e.remove(r1);
        goto L3
    L10:
        this.f5753e.put(r1, Integer.valueOf(r2.intValue() - 1));
        goto L3
    L22:
        return;
    }

    private void a() {
        HashMap r0 = new HashMap(this.f5753e);
        this.f5753e.clear();
        this.f5752d.clear();
        b r2 = this.f5751c;
        if (r2 == null) goto L6;
        r2.a(r0);
        return;
    }
}
