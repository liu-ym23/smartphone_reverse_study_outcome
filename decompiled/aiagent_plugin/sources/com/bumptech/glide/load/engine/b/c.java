package com.bumptech.glide.load.engine.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: DiskCacheWriteLocker.java */
/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f3559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f3560b;

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Lock f3561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3562b;

        a() {
            this.f3561a = new ReentrantLock();
        }
    }

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<a> f3563a;

        b() {
            this.f3563a = new ArrayDeque();
        }

        a a() {
            Queue<a> r0 = this.f3563a;
            monitor-enter(r0);
            a r3 = (a) ZeusTransformUtils.preCheckCast(this.f3563a.poll(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (r3 == null) goto L8;
            return r3;
        L8:
            return new a();
        L9:
            th = move-exception;
            throw th;
        }

        void a(a r4) {
            Queue<a> r0 = this.f3563a;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.f3563a.size() >= 10) goto L7;
            this.f3563a.offer(r4);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }
    }

    c() {
        this.f3559a = new HashMap();
        this.f3560b = new b();
    }

    void a(String r4) {
        monitor-enter(this);
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f3559a.get(r4), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
        r0 = this.f3560b.a();     // Catch: Throwable -> L10
        this.f3559a.put(r4, r0);     // Catch: Throwable -> L10
    L6:
        r0.f3562b++;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r0.f3561a.lock();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void b(String r6) {
        monitor-enter(this);
        a r0 = (a) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(this.f3559a.get(r6)), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r0.f3562b < 1) goto L16;
        r0.f3562b--;     // Catch: Throwable -> L17
        if (r0.f3562b != 0) goto L12;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f3559a.remove(r6), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r1.equals(r0) == false) goto L11;
        this.f3560b.a(r1);     // Catch: Throwable -> L17
        goto L12
    L11:
        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + r0 + ", but actually removed: " + r1 + ", safeKey: " + r6);     // Catch: Throwable -> L17
    L12:
        monitor-exit(this);     // Catch: Throwable -> L17
        r0.f3561a.unlock();
        return;
    L16:
        throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + r6 + ", interestedThreads: " + r0.f3562b);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}
