package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m implements p, d0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3213f = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "suspensionSlot");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3214g = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_closedCause");
    private volatile int flushBufferSize;

    /* renamed from: b, reason: collision with root package name */
    public final j6.a f3215b = new j6.a();

    /* renamed from: c, reason: collision with root package name */
    public final Object f3216c = new Object();
    volatile /* synthetic */ Object suspensionSlot = c.f3182b;
    public final j6.a d = new j6.a();

    /* renamed from: e, reason: collision with root package name */
    public final j6.a f3217e = new j6.a();
    volatile /* synthetic */ Object _closedCause = null;

    @Override // io.ktor.utils.io.p
    public final Throwable a() {
        j0 j0Var = (j0) this._closedCause;
        if (j0Var != null) {
            return j0Var.a(i0.f3206a);
        }
        return null;
    }

    @Override // io.ktor.utils.io.p
    public final j6.a b() throws Throwable {
        Throwable thA;
        j0 j0Var = (j0) this._closedCause;
        if (j0Var != null && (thA = j0Var.a(k.f3211a)) != null) {
            throw thA;
        }
        if (this.d.q()) {
            l();
        }
        return this.d;
    }

    @Override // io.ktor.utils.io.p
    public final void c(Throwable th) {
        if (this._closedCause != null) {
            return;
        }
        j0 j0Var = new j0(th);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3214g;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, j0Var) && atomicReferenceFieldUpdater.get(this) == null) {
        }
        f(j0Var.a(i0.f3206a));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // io.ktor.utils.io.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(int r13, h5.c r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.m.d(int, h5.c):java.lang.Object");
    }

    @Override // io.ktor.utils.io.p
    public final boolean e() {
        if (a() == null) {
            return k() && this.flushBufferSize == 0 && this.d.q();
        }
        return true;
    }

    public final void f(Throwable th) {
        a aVar;
        if (th != null) {
            aVar = new a(th);
        } else {
            g.f3192a.getClass();
            aVar = b.f3178b;
        }
        g gVar = (g) f3213f.getAndSet(this, aVar);
        if (gVar instanceof e) {
            ((e) gVar).a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(h5.c r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.m.g(h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(f5.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.utils.io.j
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.j r0 = (io.ktor.utils.io.j) r0
            int r1 = r0.f3209c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3209c = r1
            goto L18
        L13:
            io.ktor.utils.io.j r0 = new io.ktor.utils.io.j
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f3207a
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3209c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            a.a.c0(r5)     // Catch: java.lang.Throwable -> L27
            goto L40
        L27:
            r5 = move-exception
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            a.a.c0(r5)
            r0.f3209c = r3     // Catch: java.lang.Throwable -> L27
            java.lang.Object r5 = r4.g(r0)     // Catch: java.lang.Throwable -> L27
            if (r5 != r1) goto L40
            return r1
        L3d:
            a.a.o(r5)
        L40:
            io.ktor.utils.io.j0 r5 = io.ktor.utils.io.h0.f3202b
        L42:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = io.ktor.utils.io.m.f3214g
            r1 = 0
            boolean r2 = r0.compareAndSet(r4, r1, r5)
            b5.a0 r3 = b5.a0.f883a
            if (r2 == 0) goto L51
            r4.f(r1)
            return r3
        L51:
            java.lang.Object r0 = r0.get(r4)
            if (r0 == 0) goto L42
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.m.h(f5.c):java.lang.Object");
    }

    public final void i() {
        if (this.f3217e.q()) {
            return;
        }
        synchronized (this.f3216c) {
            j6.a aVar = this.f3217e;
            int i8 = (int) aVar.f3512c;
            this.f3215b.j(aVar);
            this.flushBufferSize += i8;
        }
        g gVar = (g) this.suspensionSlot;
        if (gVar instanceof d) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3213f;
            c cVar = c.f3182b;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, gVar, cVar)) {
                if (atomicReferenceFieldUpdater.get(this) != gVar) {
                    return;
                }
            }
            ((e) gVar).c();
        }
    }

    public final j6.a j() {
        Throwable thA;
        if (!k()) {
            return this.f3217e;
        }
        j0 j0Var = (j0) this._closedCause;
        if (j0Var == null || (thA = j0Var.a(l.f3212a)) == null) {
            throw new m0(null, null);
        }
        throw thA;
    }

    public final boolean k() {
        return this._closedCause != null;
    }

    public final void l() {
        synchronized (this.f3216c) {
            this.f3215b.l(this.d);
            this.flushBufferSize = 0;
        }
        g gVar = (g) this.suspensionSlot;
        if (gVar instanceof f) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3213f;
            c cVar = c.f3182b;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, gVar, cVar)) {
                if (atomicReferenceFieldUpdater.get(this) != gVar) {
                    return;
                }
            }
            ((e) gVar).c();
        }
    }

    public final String toString() {
        return "ByteChannel[" + hashCode() + AbstractJsonLexerKt.END_LIST;
    }
}
