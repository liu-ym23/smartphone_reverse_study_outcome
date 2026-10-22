package f8;

import H4.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class l {
    public static final l c = new l(o.N(C1445f.c, C1448i.c, C1446g.c, C1447h.c));

    /* renamed from: a, reason: collision with root package name */
    public final List f4447a;
    public final LinkedHashMap b;

    public l(List kinds) {
        kotlin.jvm.internal.k.f(kinds, "kinds");
        this.f4447a = kinds;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : kinds) {
            G8.c cVar = ((j) obj).f4445a;
            Object arrayList = linkedHashMap.get(cVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(cVar, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.b = linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0015 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f8.k a(G8.c r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "packageFqName"
            kotlin.jvm.internal.k.f(r8, r0)
            java.util.LinkedHashMap r7 = r7.b
            java.lang.Object r7 = r7.get(r8)
            java.util.List r7 = (java.util.List) r7
            r8 = 0
            if (r7 != 0) goto L11
            goto L69
        L11:
            java.util.Iterator r7 = r7.iterator()
        L15:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L69
            java.lang.Object r0 = r7.next()
            f8.j r0 = (f8.j) r0
            java.lang.String r1 = r0.b
            r2 = 0
            boolean r1 = j9.t.e0(r9, r1, r2)
            if (r1 == 0) goto L15
            java.lang.String r1 = r0.b
            int r1 = r1.length()
            java.lang.String r1 = r9.substring(r1)
            java.lang.String r3 = "substring(...)"
            kotlin.jvm.internal.k.e(r1, r3)
            int r3 = r1.length()
            if (r3 != 0) goto L41
        L3f:
            r1 = r8
            goto L5e
        L41:
            int r3 = r1.length()
            r4 = r2
        L46:
            if (r2 >= r3) goto L5a
            char r5 = r1.charAt(r2)
            int r5 = r5 + (-48)
            if (r5 < 0) goto L3f
            r6 = 10
            if (r5 >= r6) goto L3f
            int r4 = r4 * 10
            int r4 = r4 + r5
            int r2 = r2 + 1
            goto L46
        L5a:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
        L5e:
            if (r1 == 0) goto L15
            int r7 = r1.intValue()
            f8.k r8 = new f8.k
            r8.<init>(r0, r7)
        L69:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.l.a(G8.c, java.lang.String):f8.k");
    }
}
