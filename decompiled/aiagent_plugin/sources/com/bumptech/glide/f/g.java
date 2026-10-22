package com.bumptech.glide.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class g<T, Y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<T, Y> f3329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f3330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3332d;

    public int a(Y r1) {
        return 1;
    }

    public void a(T r1, Y r2) {
    }

    public g(long r5) {
        this.f3329a = new LinkedHashMap(100, 0.75f, true);
        this.f3330b = r5;
        this.f3331c = r5;
    }

    public synchronized void a(float r3) {
        monitor-enter(this);
        if (r3 < 0.0f) goto L11;
        this.f3331c = Math.round(this.f3330b * r3);     // Catch: Throwable -> L8
        d();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalArgumentException("Multiplier must be >= 0");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized long b() {
        monitor-enter(this);
        long r0 = this.f3331c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long a() {
        monitor-enter(this);
        long r0 = this.f3332d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Y b(T r2) {
        monitor-enter(this);
        Y r3 = this.f3329a.get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Y b(T r6, Y r7) {
        monitor-enter(this);
        long r0 = a(r7);     // Catch: Throwable -> L19
        if (r0 < this.f3331c) goto L9;
        a(r6, r7);     // Catch: Throwable -> L19
        monitor-exit(this);
        return null;
    L9:
        if (r7 == null) goto L11;
        this.f3332d += r0;     // Catch: Throwable -> L19
    L11:
        Y r1 = this.f3329a.put(r6, r7);     // Catch: Throwable -> L19
        if (r1 == null) goto L16;
        this.f3332d -= (long) a(r1);     // Catch: Throwable -> L19
        if (r1.equals(r7) == true) goto L16;
        a(r6, r1);     // Catch: Throwable -> L19
    L16:
        d();     // Catch: Throwable -> L19
        monitor-exit(this);
        return r1;
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized Y c(T r5) {
        monitor-enter(this);
        Y r6 = this.f3329a.remove(r5);     // Catch: Throwable -> L8
        if (r6 == null) goto L6;
        this.f3332d -= (long) a(r6);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r6;
    L8:
        th = move-exception;
        throw th;
    }

    public void c() {
        a(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void a(long r8) {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f3332d <= r8) goto L7;
        Iterator<Map.Entry<T, Y>> r0 = this.f3329a.entrySet().iterator();     // Catch: Throwable -> L9
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        Object r2 = r1.getValue();     // Catch: Throwable -> L9
        this.f3332d -= (long) a(r2);     // Catch: Throwable -> L9
        Object r3 = r1.getKey();     // Catch: Throwable -> L9
        r0.remove();     // Catch: Throwable -> L9
        a(r3, r2);     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    private void d() {
        a(this.f3331c);
    }
}
