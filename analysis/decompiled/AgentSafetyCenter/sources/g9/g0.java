package g9;

import android.content.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: b, reason: collision with root package name */
    public static final y3.e f4459b = t.o.n("list_json");

    /* renamed from: c, reason: collision with root package name */
    public static final y3.e f4460c = t.o.k("list_updated_at_ms");

    /* renamed from: d, reason: collision with root package name */
    public static final y3.e f4461d = t.o.n("list_locale");

    /* renamed from: a, reason: collision with root package name */
    public Context f4462a;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(pb.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof g9.c0
            if (r0 == 0) goto L13
            r0 = r6
            g9.c0 r0 = (g9.c0) r0
            int r1 = r0.f4420g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4420g = r1
            goto L18
        L13:
            g9.c0 r0 = new g9.c0
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f4418c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f4420g
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            id.c.I(r6)
            goto L52
        L27:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            r5 = 0
            return r5
        L2e:
            id.c.I(r6)
            android.content.Context r5 = r5.f4462a
            r5.getClass()
            x3.b r6 = g9.h0.f4472b
            fc.c[] r2 = g9.h0.f4471a
            r4 = 0
            r2 = r2[r4]
            stepos.support.v7.app.f r5 = r6.a(r5, r2)
            java.lang.Object r5 = r5.f12315f
            v3.f r5 = (v3.f) r5
            nc.g r5 = r5.getData()
            r0.f4420g = r3
            java.lang.Object r6 = nc.k0.i(r5, r0)
            if (r6 != r1) goto L52
            return r1
        L52:
            y3.b r6 = (y3.b) r6
            y3.e r5 = g9.g0.f4460c
            java.lang.Object r5 = r6.c(r5)
            java.lang.Long r5 = (java.lang.Long) r5
            if (r5 == 0) goto L63
            long r5 = r5.longValue()
            goto L65
        L63:
            r5 = 0
        L65:
            java.lang.Long r0 = new java.lang.Long
            r0.<init>(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.g0.a(pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r6, pb.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof g9.d0
            if (r0 == 0) goto L13
            r0 = r7
            g9.d0 r0 = (g9.d0) r0
            int r1 = r0.f4427h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4427h = r1
            goto L18
        L13:
            g9.d0 r0 = new g9.d0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f4425f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f4427h
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L29
            java.lang.String r6 = r0.f4424c
            id.c.I(r7)
            goto L56
        L29:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            r5 = 0
            return r5
        L30:
            id.c.I(r7)
            android.content.Context r5 = r5.f4462a
            r5.getClass()
            x3.b r7 = g9.h0.f4472b
            fc.c[] r2 = g9.h0.f4471a
            r4 = 0
            r2 = r2[r4]
            stepos.support.v7.app.f r5 = r7.a(r5, r2)
            java.lang.Object r5 = r5.f12315f
            v3.f r5 = (v3.f) r5
            nc.g r5 = r5.getData()
            r0.f4424c = r6
            r0.f4427h = r3
            java.lang.Object r7 = nc.k0.i(r5, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            y3.b r7 = (y3.b) r7
            y3.e r5 = g9.g0.f4459b
            java.lang.Object r5 = r7.c(r5)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r0 = ""
            if (r5 != 0) goto L65
            r5 = r0
        L65:
            boolean r1 = hc.h.g0(r5)
            if (r1 == 0) goto L6c
            goto L84
        L6c:
            y3.e r1 = g9.g0.f4461d
            java.lang.Object r7 = r7.c(r1)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L77
            goto L78
        L77:
            r0 = r7
        L78:
            boolean r7 = hc.h.g0(r0)
            if (r7 != 0) goto L86
            boolean r7 = r0.equals(r6)
            if (r7 != 0) goto L86
        L84:
            r5 = 0
            return r5
        L86:
            g9.p r5 = h5.t.I(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.g0.b(java.lang.String, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(g9.p r17, java.lang.String r18, pb.c r19) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.g0.c(g9.p, java.lang.String, pb.c):java.lang.Object");
    }
}
