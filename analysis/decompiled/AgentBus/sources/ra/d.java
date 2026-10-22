package ra;

import f8.x;
import ia.d0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class d extends i implements b {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9117h = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public d() {
        super(1);
        this.owner$volatile = e.f9118a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        r4 = r0.f9116h;
        ra.d.f9117h.set(r4, r0.f9115g);
        r6 = r0.f9114f;
        r6.C(r1, r6.f4976h, new ia.l(0, new b0.b2(8, r4, r0)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(g7.d r5, java.lang.Object r6) throws ia.k0 {
        /*
            r4 = this;
            boolean r0 = r4.d(r6)
            c7.r r1 = c7.r.f1986a
            if (r0 == 0) goto L9
            goto L53
        L9:
            g7.d r5 = ib.k.C(r5)
            ia.m r5 = ia.d0.m(r5)
            ra.c r0 = new ra.c     // Catch: java.lang.Throwable -> L54
            r0.<init>(r4, r5, r6)     // Catch: java.lang.Throwable -> L54
        L16:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = ra.i.f9125g     // Catch: java.lang.Throwable -> L54
            int r6 = r6.getAndDecrement(r4)     // Catch: java.lang.Throwable -> L54
            int r2 = r4.f9126a     // Catch: java.lang.Throwable -> L54
            if (r6 > r2) goto L16
            if (r6 <= 0) goto L40
            ra.d r4 = r0.f9116h     // Catch: java.lang.Throwable -> L54
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = ra.d.f9117h     // Catch: java.lang.Throwable -> L54
            java.lang.Object r2 = r0.f9115g     // Catch: java.lang.Throwable -> L54
            r6.set(r4, r2)     // Catch: java.lang.Throwable -> L54
            ia.m r6 = r0.f9114f     // Catch: java.lang.Throwable -> L54
            b0.b2 r2 = new b0.b2     // Catch: java.lang.Throwable -> L54
            r3 = 8
            r2.<init>(r3, r4, r0)     // Catch: java.lang.Throwable -> L54
            int r4 = r6.f4976h     // Catch: java.lang.Throwable -> L54
            ia.l r0 = new ia.l     // Catch: java.lang.Throwable -> L54
            r3 = 0
            r0.<init>(r3, r2)     // Catch: java.lang.Throwable -> L54
            r6.C(r1, r4, r0)     // Catch: java.lang.Throwable -> L54
            goto L46
        L40:
            boolean r6 = r4.a(r0)     // Catch: java.lang.Throwable -> L54
            if (r6 == 0) goto L16
        L46:
            java.lang.Object r4 = r5.r()
            h7.a r5 = h7.a.f4212f
            if (r4 != r5) goto L4f
            goto L50
        L4f:
            r4 = r1
        L50:
            if (r4 != r5) goto L53
            return r4
        L53:
            return r1
        L54:
            r4 = move-exception
            r5.B()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ra.d.c(g7.d, java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(java.lang.Object r6) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = ra.i.f9125g
            int r1 = r0.get(r5)
            int r2 = r5.f9126a
            if (r1 <= r2) goto L17
        La:
            int r1 = r0.get(r5)
            if (r1 <= r2) goto L0
            boolean r1 = r0.compareAndSet(r5, r1, r2)
            if (r1 == 0) goto La
            goto L0
        L17:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = ra.d.f9117h
            if (r1 > 0) goto L4c
            r1 = 0
            if (r6 != 0) goto L1f
            goto L33
        L1f:
            int r3 = r0.get(r5)
            int r3 = java.lang.Math.max(r3, r1)
            if (r3 != 0) goto L0
            java.lang.Object r3 = r2.get(r5)
            f8.x r4 = ra.e.f9118a
            if (r3 == r4) goto L1f
            if (r3 == r6) goto L34
        L33:
            return r1
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "This mutex is already locked by the specified owner: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L4c:
            int r3 = r1 + (-1)
            boolean r0 = r0.compareAndSet(r5, r1, r3)
            if (r0 == 0) goto L0
            r2.set(r5, r6)
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ra.d.d(java.lang.Object):boolean");
    }

    public final void e(Object obj) {
        while (Math.max(i.f9125g.get(this), 0) == 0) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9117h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            x xVar = e.f9118a;
            if (obj2 != xVar) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, xVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    b();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Mutex@");
        sb2.append(d0.k(this));
        sb2.append("[isLocked=");
        sb2.append(Math.max(i.f9125g.get(this), 0) == 0);
        sb2.append(",owner=");
        sb2.append(f9117h.get(this));
        sb2.append(']');
        return sb2.toString();
    }
}
