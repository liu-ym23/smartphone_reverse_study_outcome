package oc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f extends e {

    /* renamed from: h, reason: collision with root package name */
    public final nc.g f9372h;

    public f(nc.g gVar, nb.g gVar2, int i, mc.a aVar) {
        super(gVar2, i, aVar);
        this.f9372h = gVar;
    }

    @Override // oc.e
    public final Object b(mc.r rVar, nb.c cVar) {
        Object objE = e(new x(rVar), cVar);
        return objE == ob.a.f9351c ? objE : jb.v.f6774a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    @Override // oc.e, nc.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(nc.h r6, nb.c r7) {
        /*
            r5 = this;
            int r0 = r5.f9370f
            r1 = -3
            if (r0 != r1) goto L84
            nb.g r0 = r7.getContext()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            k8.d r2 = new k8.d
            r3 = 2
            r2.<init>(r3)
            nb.g r4 = r5.f9369c
            java.lang.Object r1 = r4.fold(r1, r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L24
            nb.g r1 = r0.plus(r4)
            goto L29
        L24:
            r1 = 0
            nb.g r1 = kc.w.j(r0, r4, r1)
        L29:
            boolean r2 = yb.k.a(r1, r0)
            if (r2 == 0) goto L38
            java.lang.Object r5 = r5.e(r6, r7)
            ob.a r6 = ob.a.f9351c
            if (r5 != r6) goto L8d
            return r5
        L38:
            nb.d r2 = nb.d.f8810c
            nb.e r4 = r1.get(r2)
            nb.e r0 = r0.get(r2)
            boolean r0 = yb.k.a(r4, r0)
            if (r0 == 0) goto L84
            nb.g r0 = r7.getContext()
            boolean r2 = r6 instanceof oc.x
            r4 = 0
            if (r2 != 0) goto L70
            boolean r2 = r6 instanceof oc.t
            if (r2 == 0) goto L56
            goto L70
        L56:
            nc.s r2 = new nc.s
            r2.<init>(r3)
            r2.f8916g = r0
            java.lang.Object r0 = pc.a.k(r0)
            r2.f8915f = r0
            androidx.lifecycle.h0 r0 = new androidx.lifecycle.h0
            r3 = 24
            r0.<init>(r6, r4, r3)
            r2.f8917h = r0
            java.lang.invoke.VarHandle.storeStoreFence()
            r6 = r2
        L70:
            androidx.lifecycle.h0 r0 = new androidx.lifecycle.h0
            r2 = 23
            r0.<init>(r5, r4, r2)
            java.lang.Object r5 = pc.a.k(r1)
            java.lang.Object r5 = oc.c.b(r1, r6, r5, r0, r7)
            ob.a r6 = ob.a.f9351c
            if (r5 != r6) goto L8d
            return r5
        L84:
            java.lang.Object r5 = super.collect(r6, r7)
            ob.a r6 = ob.a.f9351c
            if (r5 != r6) goto L8d
            return r5
        L8d:
            jb.v r5 = jb.v.f6774a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: oc.f.collect(nc.h, nb.c):java.lang.Object");
    }

    public abstract Object e(nc.h hVar, nb.c cVar);

    @Override // oc.e
    public final String toString() {
        return this.f9372h + " -> " + super.toString();
    }
}
