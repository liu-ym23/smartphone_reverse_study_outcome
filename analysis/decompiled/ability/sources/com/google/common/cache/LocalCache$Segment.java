package com.google.common.cache;

import com.google.common.cache.LocalCache$Strength;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import l3.C1658b;
import l3.r;
import l3.y;

/* loaded from: classes3.dex */
class LocalCache$Segment<K, V> extends ReentrantLock {

    /* renamed from: a, reason: collision with root package name */
    public final e f2730a;
    public volatile int b;
    public long c;
    public int d;
    public int e;
    public volatile AtomicReferenceArray f;
    public final long g;
    public final ReferenceQueue h;
    public final ReferenceQueue i;

    /* renamed from: j, reason: collision with root package name */
    public final AbstractQueue f2731j;
    public final AtomicInteger k = new AtomicInteger();
    public final AbstractQueue l;
    public final AbstractQueue m;
    public final C1658b n;

    public LocalCache$Segment(e eVar, int i, long j5, C1658b c1658b) {
        this.f2730a = eVar;
        this.g = j5;
        c1658b.getClass();
        this.n = c1658b;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i);
        int length = (atomicReferenceArray.length() * 3) / 4;
        this.e = length;
        if (eVar.f2741j == CacheBuilder$OneWeigher.f2724a && length == j5) {
            this.e = length + 1;
        }
        this.f = atomicReferenceArray;
        LocalCache$Strength localCache$Strength = eVar.g;
        LocalCache$Strength.AnonymousClass1 anonymousClass1 = LocalCache$Strength.f2732a;
        this.h = localCache$Strength != anonymousClass1 ? new ReferenceQueue() : null;
        this.i = eVar.h != anonymousClass1 ? new ReferenceQueue() : null;
        this.f2731j = (eVar.d() || eVar.b()) ? new ConcurrentLinkedQueue() : e.f2739w;
        this.l = eVar.e() ? new c(1) : e.f2739w;
        this.m = (eVar.d() || eVar.b()) ? new c(0) : e.f2739w;
    }

    public final y a(y yVar, y yVar2) {
        Object key = yVar.getKey();
        if (key == null) {
            return null;
        }
        r rVarD = yVar.d();
        Object obj = rVarD.get();
        if (obj == null && rVarD.isActive()) {
            return null;
        }
        y yVarB = this.f2730a.p.b(this, yVar, yVar2, key);
        yVarB.k(rVarD.d(this.i, obj, yVarB));
        return yVarB;
    }

    public final void b() {
        while (true) {
            y yVar = (y) this.f2731j.poll();
            if (yVar == null) {
                return;
            }
            AbstractQueue abstractQueue = this.m;
            if (abstractQueue.contains(yVar)) {
                abstractQueue.add(yVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        r1.d++;
        r2 = r1.n(r3, r3, r3.getKey(), r3.d().get(), r3.d(), r7);
        r3 = r1.b - 1;
        r11.set(r12, r2);
        r1.b = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fc, code lost:
    
        r1.p();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache$Segment.c():void");
    }

    public final void d(Object obj, Object obj2, int i, RemovalCause removalCause) {
        this.c -= i;
        if (removalCause.a()) {
            this.n.getClass();
        }
        e eVar = this.f2730a;
        if (eVar.m != e.f2739w) {
            eVar.m.offer(new RemovalNotification(obj, obj2));
        }
    }

    public final void e(y yVar) {
        if (this.f2730a.b()) {
            b();
            long weight = yVar.d().getWeight();
            long j5 = this.g;
            RemovalCause removalCause = RemovalCause.e;
            if (weight > j5 && !m(yVar, yVar.g(), removalCause)) {
                throw new AssertionError();
            }
            while (this.c > j5) {
                for (y yVar2 : this.m) {
                    if (yVar2.d().getWeight() > 0) {
                        if (!m(yVar2, yVar2.g(), removalCause)) {
                            throw new AssertionError();
                        }
                    }
                }
                throw new AssertionError();
            }
        }
    }

    public final void f() {
        AtomicReferenceArray atomicReferenceArray = this.f;
        int length = atomicReferenceArray.length();
        if (length >= 1073741824) {
            return;
        }
        int i = this.b;
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(length << 1);
        this.e = (atomicReferenceArray2.length() * 3) / 4;
        int length2 = atomicReferenceArray2.length() - 1;
        for (int i6 = 0; i6 < length; i6++) {
            y next = (y) atomicReferenceArray.get(i6);
            if (next != null) {
                y next2 = next.getNext();
                int iG = next.g() & length2;
                if (next2 == null) {
                    atomicReferenceArray2.set(iG, next);
                } else {
                    y yVar = next;
                    while (next2 != null) {
                        int iG2 = next2.g() & length2;
                        if (iG2 != iG) {
                            yVar = next2;
                            iG = iG2;
                        }
                        next2 = next2.getNext();
                    }
                    atomicReferenceArray2.set(iG, yVar);
                    while (next != yVar) {
                        int iG3 = next.g() & length2;
                        y yVarA = a(next, (y) atomicReferenceArray2.get(iG3));
                        if (yVarA != null) {
                            atomicReferenceArray2.set(iG3, yVarA);
                        } else {
                            l(next);
                            i--;
                        }
                        next = next.getNext();
                    }
                }
            }
        }
        this.f = atomicReferenceArray2;
        this.b = i;
    }

    public final void g(long j5) {
        y yVar;
        RemovalCause removalCause;
        y yVar2;
        b();
        do {
            yVar = (y) this.l.peek();
            removalCause = RemovalCause.d;
            e eVar = this.f2730a;
            if (yVar == null || !eVar.g(yVar, j5)) {
                do {
                    yVar2 = (y) this.m.peek();
                    if (yVar2 == null || !eVar.g(yVar2, j5)) {
                        return;
                    }
                } while (m(yVar2, yVar2.g(), removalCause));
                throw new AssertionError();
            }
        } while (m(yVar, yVar.g(), removalCause));
        throw new AssertionError();
    }

    public final y h(int i, Object obj) {
        for (y next = (y) this.f.get((r0.length() - 1) & i); next != null; next = next.getNext()) {
            if (next.g() == i) {
                Object key = next.getKey();
                if (key == null) {
                    r();
                } else if (this.f2730a.e.d(obj, key)) {
                    return next;
                }
            }
        }
        return null;
    }

    public final void i() {
        if ((this.k.incrementAndGet() & 63) == 0) {
            o(this.f2730a.o.a());
            p();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        unlock();
        p();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(int r10, java.lang.Object r11, boolean r12, java.lang.Object r13) {
        /*
            r9 = this;
            r9.lock()
            com.google.common.cache.e r0 = r9.f2730a     // Catch: java.lang.Throwable -> L1a
            k3.e r0 = r0.o     // Catch: java.lang.Throwable -> L1a
            long r0 = r0.a()     // Catch: java.lang.Throwable -> L1a
            r9.o(r0)     // Catch: java.lang.Throwable -> L1a
            int r2 = r9.b     // Catch: java.lang.Throwable -> L1a
            int r2 = r2 + 1
            int r3 = r9.e     // Catch: java.lang.Throwable -> L1a
            if (r2 <= r3) goto L1d
            r9.f()     // Catch: java.lang.Throwable -> L1a
            goto L1d
        L1a:
            r10 = move-exception
            goto Lc3
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r9.f     // Catch: java.lang.Throwable -> L1a
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L1a
            int r3 = r3 + (-1)
            r3 = r3 & r10
            java.lang.Object r4 = r2.get(r3)     // Catch: java.lang.Throwable -> L1a
            l3.y r4 = (l3.y) r4     // Catch: java.lang.Throwable -> L1a
            r5 = r4
        L2d:
            r6 = 0
            if (r5 == 0) goto La5
            java.lang.Object r7 = r5.getKey()     // Catch: java.lang.Throwable -> L1a
            int r8 = r5.g()     // Catch: java.lang.Throwable -> L1a
            if (r8 != r10) goto La0
            if (r7 == 0) goto La0
            com.google.common.cache.e r8 = r9.f2730a     // Catch: java.lang.Throwable -> L1a
            com.google.common.base.a r8 = r8.e     // Catch: java.lang.Throwable -> L1a
            boolean r7 = r8.d(r11, r7)     // Catch: java.lang.Throwable -> L1a
            if (r7 == 0) goto La0
            l3.r r10 = r5.d()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r2 = r10.get()     // Catch: java.lang.Throwable -> L1a
            if (r2 != 0) goto L7e
            int r12 = r9.d     // Catch: java.lang.Throwable -> L1a
            int r12 = r12 + 1
            r9.d = r12     // Catch: java.lang.Throwable -> L1a
            boolean r12 = r10.isActive()     // Catch: java.lang.Throwable -> L1a
            if (r12 == 0) goto L6b
            int r10 = r10.getWeight()     // Catch: java.lang.Throwable -> L1a
            com.google.common.cache.RemovalCause r12 = com.google.common.cache.RemovalCause.c     // Catch: java.lang.Throwable -> L1a
            r9.d(r11, r2, r10, r12)     // Catch: java.lang.Throwable -> L1a
            r9.q(r5, r13, r0)     // Catch: java.lang.Throwable -> L1a
            int r10 = r9.b     // Catch: java.lang.Throwable -> L1a
            goto L72
        L6b:
            r9.q(r5, r13, r0)     // Catch: java.lang.Throwable -> L1a
            int r10 = r9.b     // Catch: java.lang.Throwable -> L1a
            int r10 = r10 + 1
        L72:
            r9.b = r10     // Catch: java.lang.Throwable -> L1a
            r9.e(r5)     // Catch: java.lang.Throwable -> L1a
        L77:
            r9.unlock()
            r9.p()
            return r6
        L7e:
            if (r12 == 0) goto L8a
            r9.k(r5, r0)     // Catch: java.lang.Throwable -> L1a
        L83:
            r9.unlock()
            r9.p()
            return r2
        L8a:
            int r12 = r9.d     // Catch: java.lang.Throwable -> L1a
            int r12 = r12 + 1
            r9.d = r12     // Catch: java.lang.Throwable -> L1a
            int r10 = r10.getWeight()     // Catch: java.lang.Throwable -> L1a
            com.google.common.cache.RemovalCause r12 = com.google.common.cache.RemovalCause.b     // Catch: java.lang.Throwable -> L1a
            r9.d(r11, r2, r10, r12)     // Catch: java.lang.Throwable -> L1a
            r9.q(r5, r13, r0)     // Catch: java.lang.Throwable -> L1a
            r9.e(r5)     // Catch: java.lang.Throwable -> L1a
            goto L83
        La0:
            l3.y r5 = r5.getNext()     // Catch: java.lang.Throwable -> L1a
            goto L2d
        La5:
            int r12 = r9.d     // Catch: java.lang.Throwable -> L1a
            int r12 = r12 + 1
            r9.d = r12     // Catch: java.lang.Throwable -> L1a
            com.google.common.cache.e r12 = r9.f2730a     // Catch: java.lang.Throwable -> L1a
            com.google.common.cache.LocalCache$EntryFactory r12 = r12.p     // Catch: java.lang.Throwable -> L1a
            l3.y r10 = r12.d(r9, r11, r10, r4)     // Catch: java.lang.Throwable -> L1a
            r9.q(r10, r13, r0)     // Catch: java.lang.Throwable -> L1a
            r2.set(r3, r10)     // Catch: java.lang.Throwable -> L1a
            int r11 = r9.b     // Catch: java.lang.Throwable -> L1a
            int r11 = r11 + 1
            r9.b = r11     // Catch: java.lang.Throwable -> L1a
            r9.e(r10)     // Catch: java.lang.Throwable -> L1a
            goto L77
        Lc3:
            r9.unlock()
            r9.p()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache$Segment.j(int, java.lang.Object, boolean, java.lang.Object):java.lang.Object");
    }

    public final void k(y yVar, long j5) {
        if (this.f2730a.d()) {
            yVar.j(j5);
        }
        this.m.add(yVar);
    }

    public final void l(y yVar) {
        Object key = yVar.getKey();
        yVar.g();
        d(key, yVar.d().get(), yVar.d().getWeight(), RemovalCause.c);
        this.l.remove(yVar);
        this.m.remove(yVar);
    }

    public final boolean m(y yVar, int i, RemovalCause removalCause) {
        AtomicReferenceArray atomicReferenceArray = this.f;
        int length = i & (atomicReferenceArray.length() - 1);
        y yVar2 = (y) atomicReferenceArray.get(length);
        for (y next = yVar2; next != null; next = next.getNext()) {
            if (next == yVar) {
                this.d++;
                y yVarN = n(yVar2, next, next.getKey(), next.d().get(), next.d(), removalCause);
                int i6 = this.b - 1;
                atomicReferenceArray.set(length, yVarN);
                this.b = i6;
                return true;
            }
        }
        return false;
    }

    public final y n(y yVar, y yVar2, Object obj, Object obj2, r rVar, RemovalCause removalCause) {
        d(obj, obj2, rVar.getWeight(), removalCause);
        this.l.remove(yVar2);
        this.m.remove(yVar2);
        if (rVar.b()) {
            rVar.a(null);
            return yVar;
        }
        int i = this.b;
        y next = yVar2.getNext();
        while (yVar != yVar2) {
            y yVarA = a(yVar, next);
            if (yVarA != null) {
                next = yVarA;
            } else {
                l(yVar);
                i--;
            }
            yVar = yVar.getNext();
        }
        this.b = i;
        return next;
    }

    public final void o(long j5) {
        if (tryLock()) {
            try {
                c();
                g(j5);
                this.k.set(0);
            } finally {
                unlock();
            }
        }
    }

    public final void p() {
        if (isHeldByCurrentThread()) {
            return;
        }
        while (true) {
            e eVar = this.f2730a;
            if (((RemovalNotification) eVar.m.poll()) == null) {
                return;
            }
            try {
                eVar.n.getClass();
            } catch (Throwable th) {
                e.u.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    public final void q(y yVar, Object obj, long j5) {
        r rVarD = yVar.d();
        e eVar = this.f2730a;
        eVar.f2741j.getClass();
        yVar.k(eVar.h.b(this, yVar, obj));
        b();
        this.c++;
        if (eVar.d()) {
            yVar.j(j5);
        }
        if (eVar.e()) {
            yVar.m(j5);
        }
        this.m.add(yVar);
        this.l.add(yVar);
        rVarD.a(obj);
    }

    public final void r() {
        if (tryLock()) {
            try {
                c();
            } finally {
                unlock();
            }
        }
    }
}
