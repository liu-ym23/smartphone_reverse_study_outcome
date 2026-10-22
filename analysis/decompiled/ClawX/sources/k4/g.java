package k4;

import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends a2.g {

    /* renamed from: f, reason: collision with root package name */
    public static final g f3611f = new g("*", "*", c5.s.f1092a);
    public final String d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3612e;

    public g(String str, String str2, String str3, List list) {
        super(str3, list);
        this.d = str;
        this.f3612e = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return x5.u.W0(this.d, gVar.d) && x5.u.W0(this.f3612e, gVar.f3612e) && kotlin.jvm.internal.p.a((List) this.f89c, (List) gVar.f89c);
    }

    public final int hashCode() {
        Locale locale = Locale.ROOT;
        String lowerCase = this.d.toLowerCase(locale);
        kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.f3612e.toLowerCase(locale);
        kotlin.jvm.internal.p.d(lowerCase2, "toLowerCase(...)");
        int iHashCode2 = lowerCase2.hashCode();
        return (((List) this.f89c).hashCode() * 31) + iHashCode2 + (iHashCode * 31) + iHashCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean u(k4.g r7) {
        /*
            r6 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.p.e(r7, r0)
            java.lang.String r0 = r7.f3612e
            java.lang.String r1 = r7.d
            java.lang.String r2 = "*"
            boolean r3 = kotlin.jvm.internal.p.a(r1, r2)
            r4 = 0
            if (r3 != 0) goto L1c
            java.lang.String r3 = r6.d
            boolean r1 = x5.u.W0(r1, r3)
            if (r1 != 0) goto L1c
            goto L8b
        L1c:
            boolean r1 = kotlin.jvm.internal.p.a(r0, r2)
            if (r1 != 0) goto L2b
            java.lang.String r1 = r6.f3612e
            boolean r0 = x5.u.W0(r0, r1)
            if (r0 != 0) goto L2b
            goto L8b
        L2b:
            java.lang.Object r7 = r7.f89c
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
        L33:
            boolean r0 = r7.hasNext()
            r1 = 1
            if (r0 == 0) goto L8c
            java.lang.Object r0 = r7.next()
            k4.l r0 = (k4.l) r0
            java.lang.String r3 = r0.f3628a
            java.lang.String r0 = r0.f3629b
            boolean r5 = kotlin.jvm.internal.p.a(r3, r2)
            if (r5 == 0) goto L78
            boolean r3 = kotlin.jvm.internal.p.a(r0, r2)
            if (r3 == 0) goto L51
            goto L89
        L51:
            java.lang.Object r3 = r6.f89c
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L5f
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L5f
        L5d:
            r1 = r4
            goto L89
        L5f:
            java.util.Iterator r3 = r3.iterator()
        L63:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L5d
            java.lang.Object r5 = r3.next()
            k4.l r5 = (k4.l) r5
            java.lang.String r5 = r5.f3629b
            boolean r5 = x5.u.W0(r5, r0)
            if (r5 == 0) goto L63
            goto L89
        L78:
            java.lang.String r3 = r6.t(r3)
            boolean r5 = kotlin.jvm.internal.p.a(r0, r2)
            if (r5 == 0) goto L85
            if (r3 == 0) goto L5d
            goto L89
        L85:
            boolean r1 = x5.u.W0(r3, r0)
        L89:
            if (r1 != 0) goto L33
        L8b:
            return r4
        L8c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.g.u(k4.g):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (x5.u.W0(r1.f3629b, r7) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k4.g v(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f89c
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            r2 = 1
            if (r1 == 0) goto L4d
            if (r1 == r2) goto L35
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L14
            goto L4d
        L14:
            java.util.Iterator r1 = r0.iterator()
        L18:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L4d
            java.lang.Object r3 = r1.next()
            k4.l r3 = (k4.l) r3
            java.lang.String r4 = r3.f3628a
            boolean r4 = x5.u.W0(r4, r6)
            if (r4 == 0) goto L18
            java.lang.String r3 = r3.f3629b
            boolean r3 = x5.u.W0(r3, r7)
            if (r3 == 0) goto L18
            goto L4c
        L35:
            r1 = 0
            java.lang.Object r1 = r0.get(r1)
            k4.l r1 = (k4.l) r1
            java.lang.String r3 = r1.f3628a
            boolean r3 = x5.u.W0(r3, r6)
            if (r3 == 0) goto L4d
            java.lang.String r1 = r1.f3629b
            boolean r1 = x5.u.W0(r1, r7)
            if (r1 == 0) goto L4d
        L4c:
            return r5
        L4d:
            k4.g r1 = new k4.g
            java.lang.Object r3 = r5.f88b
            java.lang.String r3 = (java.lang.String) r3
            k4.l r4 = new k4.l
            r4.<init>(r6, r7)
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = r0.size()
            int r7 = r7 + r2
            r6.<init>(r7)
            r6.addAll(r0)
            r6.add(r4)
            java.lang.String r7 = r5.d
            java.lang.String r5 = r5.f3612e
            r1.<init>(r7, r5, r3, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.g.v(java.lang.String, java.lang.String):k4.g");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(String contentType, String contentSubtype, List parameters) {
        this(contentType, contentSubtype, contentType + '/' + contentSubtype, parameters);
        kotlin.jvm.internal.p.e(contentType, "contentType");
        kotlin.jvm.internal.p.e(contentSubtype, "contentSubtype");
        kotlin.jvm.internal.p.e(parameters, "parameters");
    }
}
