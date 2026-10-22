package t;

import u1.s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 extends w0.l implements s1 {

    /* renamed from: s, reason: collision with root package name */
    public v.k f13017s;

    /* renamed from: t, reason: collision with root package name */
    public v.h f13018t;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object B0(t.j0 r4, pb.c r5) {
        /*
            boolean r0 = r5 instanceof t.g0
            if (r0 == 0) goto L13
            r0 = r5
            t.g0 r0 = (t.g0) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            t.g0 r0 = new t.g0
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f12982g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2d
            v.h r4 = r0.f12981f
            t.j0 r0 = r0.f12980c
            id.c.I(r5)
            r5 = r4
            r4 = r0
            goto L4f
        L2d:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L34:
            id.c.I(r5)
            v.h r5 = r4.f13018t
            if (r5 != 0) goto L51
            v.h r5 = new v.h
            r5.<init>()
            v.k r2 = r4.f13017s
            r0.f12980c = r4
            r0.f12981f = r5
            r0.i = r3
            java.lang.Object r0 = r2.a(r5, r0)
            if (r0 != r1) goto L4f
            return r1
        L4f:
            r4.f13018t = r5
        L51:
            jb.v r4 = jb.v.f6774a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: t.j0.B0(t.j0, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object C0(t.j0 r4, pb.c r5) {
        /*
            boolean r0 = r5 instanceof t.h0
            if (r0 == 0) goto L13
            r0 = r5
            t.h0 r0 = (t.h0) r0
            int r1 = r0.f12997h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12997h = r1
            goto L18
        L13:
            t.h0 r0 = new t.h0
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f12995f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f12997h
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L29
            t.j0 r4 = r0.f12994c
            id.c.I(r5)
            goto L49
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L30:
            id.c.I(r5)
            v.h r5 = r4.f13018t
            if (r5 == 0) goto L4c
            v.i r2 = new v.i
            r2.<init>(r5)
            v.k r5 = r4.f13017s
            r0.f12994c = r4
            r0.f12997h = r3
            java.lang.Object r5 = r5.a(r2, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            r5 = 0
            r4.f13018t = r5
        L4c:
            jb.v r4 = jb.v.f6774a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: t.j0.C0(t.j0, pb.c):java.lang.Object");
    }

    @Override // u1.s1
    public final void A() {
        D0();
    }

    public final void D0() {
        v.h hVar = this.f13018t;
        if (hVar != null) {
            this.f13017s.b(new v.i(hVar));
            this.f13018t = null;
        }
    }

    @Override // u1.s1
    public final void q(o1.j jVar, o1.k kVar, long j10) {
        if (kVar == o1.k.f9060f) {
            int i = jVar.f9058c;
            nb.c cVar = null;
            if (i == 4) {
                kc.w.u(p0(), null, null, new i0(this, cVar, 0), 3);
            } else if (i == 5) {
                kc.w.u(p0(), null, null, new i0(this, cVar, 1), 3);
            }
        }
    }

    @Override // w0.l
    public final void u0() {
        D0();
    }
}
