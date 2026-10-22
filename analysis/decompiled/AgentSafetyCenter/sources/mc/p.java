package mc;

import yb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends e {

    /* renamed from: o, reason: collision with root package name */
    public final a f8599o;

    public p(int i, a aVar) {
        super(i);
        this.f8599o = aVar;
        if (aVar == a.f8550c) {
            ad.o.l("This implementation does not support suspension for senders, use ", v.a(e.class).c(), " instead");
            throw null;
        }
        if (i >= 1) {
            return;
        }
        od.f.c(k0.a.k(i, "Buffered channel capacity must be at least 1, but ", " was specified"));
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b9, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            mc.a r1 = r15.f8599o
            mc.a r2 = mc.a.f8552g
            jb.v r8 = jb.v.f6774a
            if (r1 != r2) goto L17
            java.lang.Object r0 = super.h(r16)
            boolean r1 = r0 instanceof mc.k
            if (r1 == 0) goto L16
            boolean r1 = r0 instanceof mc.j
            if (r1 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r0
        L17:
            pc.t r6 = mc.g.f8576d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = mc.e.f8566j
            java.lang.Object r1 = r1.get(r15)
            mc.m r1 = (mc.m) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = mc.e.f8563f
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.v(r2, r7)
            int r9 = mc.g.f8574b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.f9982c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L58
            mc.m r2 = mc.e.d(r15, r2, r1)
            if (r2 != 0) goto L57
            if (r7 == 0) goto L21
            java.lang.Throwable r0 = r15.s()
            mc.j r1 = new mc.j
            r1.<init>()
        L51:
            r1.f8594a = r0
            java.lang.invoke.VarHandle.storeStoreFence()
            return r1
        L57:
            r1 = r2
        L58:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = mc.e.g(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lba
            r3 = 1
            if (r12 == r3) goto Lb9
            r3 = 2
            r13 = 0
            if (r12 == r3) goto L94
            r2 = 3
            if (r12 == r2) goto L8e
            r2 = 4
            if (r12 == r2) goto L77
            r2 = 5
            if (r12 == r2) goto L73
            goto L21
        L73:
            r1.a()
            goto L21
        L77:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = mc.e.f8564g
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L84
            r1.a()
        L84:
            java.lang.Throwable r0 = r15.s()
            mc.j r1 = new mc.j
            r1.<init>()
            goto L51
        L8e:
            java.lang.String r0 = "unexpected"
            od.f.e(r0)
            return r13
        L94:
            if (r7 == 0) goto La3
            r1.h()
            java.lang.Throwable r0 = r15.s()
            mc.j r1 = new mc.j
            r1.<init>()
            goto L51
        La3:
            boolean r3 = r6 instanceof kc.t1
            if (r3 == 0) goto Laa
            r13 = r6
            kc.t1 r13 = (kc.t1) r13
        Laa:
            if (r13 == 0) goto Lb1
            int r12 = r2 + r9
            r13.a(r1, r12)
        Lb1:
            long r3 = r1.f9982c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.n(r3)
        Lb9:
            return r8
        Lba:
            r1.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.p.K(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // mc.e, mc.t
    public final Object h(Object obj) {
        return K(obj, false);
    }

    @Override // mc.e, mc.t
    public final Object j(Object obj, nb.c cVar) throws Throwable {
        if (K(obj, true) instanceof j) {
            throw s();
        }
        return jb.v.f6774a;
    }

    @Override // mc.e
    public final boolean y() {
        return this.f8599o == a.f8551f;
    }
}
