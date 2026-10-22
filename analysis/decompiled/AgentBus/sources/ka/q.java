package ka;

/* loaded from: classes.dex */
public final class q extends g {

    /* renamed from: p, reason: collision with root package name */
    public final a f5715p;

    public q(int i2, a aVar) {
        super(i2);
        this.f5715p = aVar;
        if (aVar != a.f5661f) {
            if (i2 < 1) {
                throw new IllegalArgumentException(a1.a.f(i2, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + q7.w.f8821a.b(g.class).t() + " instead").toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            ka.a r1 = r15.f5715p
            ka.a r2 = ka.a.f5663h
            c7.r r8 = c7.r.f1986a
            if (r1 != r2) goto L17
            java.lang.Object r0 = super.u(r16)
            boolean r1 = r0 instanceof ka.m
            if (r1 == 0) goto L16
            boolean r1 = r0 instanceof ka.l
            if (r1 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r0
        L17:
            f8.x r6 = ka.i.f5691d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = ka.g.f5681k
            java.lang.Object r1 = r1.get(r15)
            ka.o r1 = (ka.o) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = ka.g.f5677g
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.w(r2, r7)
            int r9 = ka.i.f5689b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.f6927c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            ka.o r2 = ka.g.b(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r0 = r15.r()
            ka.l r1 = new ka.l
            r1.<init>(r0)
            return r1
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = ka.g.f(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb7
            r3 = 1
            if (r12 == r3) goto Lb6
            r3 = 2
            if (r12 == r3) goto L90
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.b()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = ka.g.f5678h
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.b()
        L7e:
            java.lang.Throwable r0 = r15.r()
            ka.l r1 = new ka.l
            r1.<init>(r0)
            return r1
        L88:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            r0.<init>(r1)
            throw r0
        L90:
            if (r7 == 0) goto L9f
            r1.i()
            java.lang.Throwable r0 = r15.r()
            ka.l r1 = new ka.l
            r1.<init>(r0)
            return r1
        L9f:
            boolean r3 = r6 instanceof ia.g2
            if (r3 == 0) goto La6
            ia.g2 r6 = (ia.g2) r6
            goto La7
        La6:
            r6 = 0
        La7:
            if (r6 == 0) goto Lae
            int r12 = r2 + r9
            r6.b(r1, r12)
        Lae:
            long r3 = r1.f6927c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.k(r3)
        Lb6:
            return r8
        Lb7:
            r1.b()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.q.L(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // ka.g, ka.z
    public final Object l(g7.d dVar, Object obj) throws Throwable {
        if (L(obj, true) instanceof l) {
            throw r();
        }
        return c7.r.f1986a;
    }

    @Override // ka.g, ka.z
    public final Object u(Object obj) {
        return L(obj, false);
    }

    @Override // ka.g
    public final boolean z() {
        return this.f5715p == a.f5662g;
    }
}
