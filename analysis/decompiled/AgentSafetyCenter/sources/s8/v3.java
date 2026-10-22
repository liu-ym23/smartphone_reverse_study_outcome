package s8;

import android.content.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v3 {

    /* renamed from: b, reason: collision with root package name */
    public static final y3.e f12030b = t.o.n("seen_keys_json");

    /* renamed from: a, reason: collision with root package name */
    public Context f12031a;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable a(pb.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof s8.u3
            if (r0 == 0) goto L13
            r0 = r6
            s8.u3 r0 = (s8.u3) r0
            int r1 = r0.f12013g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12013g = r1
            goto L18
        L13:
            s8.u3 r0 = new s8.u3
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f12011c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f12013g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L2f
            if (r2 != r4) goto L28
            id.c.I(r6)
            goto L52
        L28:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            r5 = 0
            return r5
        L2f:
            id.c.I(r6)
            android.content.Context r5 = r5.f12031a
            r5.getClass()
            x3.b r6 = s8.w3.f12063b
            fc.c[] r2 = s8.w3.f12062a
            r2 = r2[r3]
            stepos.support.v7.app.f r5 = r6.a(r5, r2)
            java.lang.Object r5 = r5.f12315f
            v3.f r5 = (v3.f) r5
            nc.g r5 = r5.getData()
            r0.f12013g = r4
            java.lang.Object r6 = nc.k0.i(r5, r0)
            if (r6 != r1) goto L52
            return r1
        L52:
            y3.b r6 = (y3.b) r6
            y3.e r5 = s8.v3.f12030b
            java.lang.Object r5 = r6.c(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L60
            java.lang.String r5 = ""
        L60:
            boolean r6 = hc.h.g0(r5)
            kb.u r0 = kb.u.f7406c
            if (r6 == 0) goto L69
            return r0
        L69:
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L92
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L92
            lb.i r5 = new lb.i     // Catch: java.lang.Throwable -> L92
            r5.<init>()     // Catch: java.lang.Throwable -> L92
            int r1 = r6.length()     // Catch: java.lang.Throwable -> L92
        L77:
            if (r3 >= r1) goto L97
            java.lang.String r2 = r6.optString(r3)     // Catch: java.lang.Throwable -> L92
            r2.getClass()     // Catch: java.lang.Throwable -> L92
            java.lang.CharSequence r2 = hc.h.w0(r2)     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L92
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L92
            if (r4 <= 0) goto L94
            r5.add(r2)     // Catch: java.lang.Throwable -> L92
            goto L94
        L92:
            r5 = move-exception
            goto L9c
        L94:
            int r3 = r3 + 1
            goto L77
        L97:
            lb.i r5 = h5.t.n(r5)     // Catch: java.lang.Throwable -> L92
            goto La0
        L9c:
            jb.h r5 = id.c.l(r5)
        La0:
            boolean r6 = r5 instanceof jb.h
            if (r6 == 0) goto La5
            goto La6
        La5:
            r0 = r5
        La6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.v3.a(pb.c):java.io.Serializable");
    }
}
