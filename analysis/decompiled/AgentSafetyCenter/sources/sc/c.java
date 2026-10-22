package sc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kc.w;
import pc.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends g implements a {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f12175l = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public c() {
        super(1);
        this.owner$volatile = d.f12176a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        r5 = sc.c.f12175l;
        r2 = r0.f12174f;
        r5.set(r2, null);
        r5 = r0.f12173c;
        r0 = new a9.e(14);
        r0.f257f = r2;
        java.lang.invoke.VarHandle.storeStoreFence();
        r2 = r5.f7419g;
        r3 = new e9.e0(1);
        r3.f3643f = r0;
        java.lang.invoke.VarHandle.storeStoreFence();
        r5.A(r1, r2, r3);
     */
    @Override // sc.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(pb.c r6) {
        /*
            r5 = this;
            boolean r0 = r5.f()
            jb.v r1 = jb.v.f6774a
            if (r0 == 0) goto L9
            goto L63
        L9:
            nb.c r6 = td.h.y(r6)
            kc.g r6 = kc.w.o(r6)
            sc.b r0 = new sc.b     // Catch: java.lang.Throwable -> L64
            r0.<init>()     // Catch: java.lang.Throwable -> L64
            r0.f12174f = r5     // Catch: java.lang.Throwable -> L64
            r0.f12173c = r6     // Catch: java.lang.Throwable -> L64
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L64
        L1d:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = sc.g.f12182k     // Catch: java.lang.Throwable -> L64
            int r2 = r2.getAndDecrement(r5)     // Catch: java.lang.Throwable -> L64
            int r3 = r5.f12183c     // Catch: java.lang.Throwable -> L64
            if (r2 > r3) goto L1d
            if (r2 <= 0) goto L50
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = sc.c.f12175l     // Catch: java.lang.Throwable -> L64
            sc.c r2 = r0.f12174f     // Catch: java.lang.Throwable -> L64
            r3 = 0
            r5.set(r2, r3)     // Catch: java.lang.Throwable -> L64
            kc.g r5 = r0.f12173c     // Catch: java.lang.Throwable -> L64
            a9.e r0 = new a9.e     // Catch: java.lang.Throwable -> L64
            r3 = 14
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L64
            r0.f257f = r2     // Catch: java.lang.Throwable -> L64
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L64
            int r2 = r5.f7419g     // Catch: java.lang.Throwable -> L64
            e9.e0 r3 = new e9.e0     // Catch: java.lang.Throwable -> L64
            r4 = 1
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L64
            r3.f3643f = r0     // Catch: java.lang.Throwable -> L64
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L64
            r5.A(r1, r2, r3)     // Catch: java.lang.Throwable -> L64
            goto L56
        L50:
            boolean r2 = r5.b(r0)     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L1d
        L56:
            java.lang.Object r5 = r6.r()
            ob.a r6 = ob.a.f9351c
            if (r5 != r6) goto L5f
            goto L60
        L5f:
            r5 = r1
        L60:
            if (r5 != r6) goto L63
            return r5
        L63:
            return r1
        L64:
            r5 = move-exception
            r6.z()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sc.c.d(pb.c):java.lang.Object");
    }

    @Override // sc.a
    public final void e(Object obj) {
        while (Math.max(g.f12182k.get(this), 0) == 0) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12175l;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            t tVar = d.f12176a;
            if (obj2 != tVar) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, tVar)) {
                    c();
                    return;
                }
            }
        }
        od.f.e("This mutex is not locked");
    }

    public final boolean f() {
        int i;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g.f12182k;
            int i3 = atomicIntegerFieldUpdater.get(this);
            int i10 = this.f12183c;
            if (i3 > i10) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i > i10) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i10));
            } else {
                if (i3 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i3, i3 - 1)) {
                    f12175l.set(this, null);
                    return true;
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Mutex@");
        sb2.append(w.m(this));
        sb2.append("[isLocked=");
        sb2.append(Math.max(g.f12182k.get(this), 0) == 0);
        sb2.append(",owner=");
        sb2.append(f12175l.get(this));
        sb2.append(']');
        return sb2.toString();
    }
}
