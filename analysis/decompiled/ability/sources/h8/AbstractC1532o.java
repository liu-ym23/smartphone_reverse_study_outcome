package h8;

import d9.C1394o;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.Set;

/* renamed from: h8.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1532o {

    /* renamed from: a, reason: collision with root package name */
    public static final C1531n f4583a;
    public static final C1531n b;
    public static final C1531n c;
    public static final C1531n d;
    public static final C1531n e;
    public static final C1531n f;
    public static final C1531n g;
    public static final C1531n h;
    public static final C1531n i;

    /* renamed from: j, reason: collision with root package name */
    public static final Set f4584j;
    public static final Map k;
    public static final C1531n l;
    public static final C1504L m;
    public static final C1504L n;
    public static final C1504L o;
    public static final C1394o p;

    /* renamed from: q, reason: collision with root package name */
    public static final HashMap f4585q;

    static {
        C1515X c1515x = C1515X.c;
        C1531n c1531n = new C1531n(c1515x, 0);
        f4583a = c1531n;
        C1516Y c1516y = C1516Y.c;
        C1531n c1531n2 = new C1531n(c1516y, 1);
        b = c1531n2;
        C1517Z c1517z = C1517Z.c;
        C1531n c1531n3 = new C1531n(c1517z, 2);
        c = c1531n3;
        C1512U c1512u = C1512U.c;
        C1531n c1531n4 = new C1531n(c1512u, 3);
        d = c1531n4;
        a0 a0Var = a0.c;
        C1531n c1531n5 = new C1531n(a0Var, 4);
        e = c1531n5;
        C1514W c1514w = C1514W.c;
        C1531n c1531n6 = new C1531n(c1514w, 5);
        f = c1531n6;
        C1511T c1511t = C1511T.c;
        C1531n c1531n7 = new C1531n(c1511t, 6);
        g = c1531n7;
        C1513V c1513v = C1513V.c;
        C1531n c1531n8 = new C1531n(c1513v, 7);
        h = c1531n8;
        b0 b0Var = b0.c;
        C1531n c1531n9 = new C1531n(b0Var, 8);
        i = c1531n9;
        f4584j = Collections.unmodifiableSet(D7.q.K0(new C1531n[]{c1531n, c1531n2, c1531n4, c1531n6}));
        HashMap map = new HashMap(6);
        map.put(c1531n2, 0);
        map.put(c1531n, 0);
        map.put(c1531n4, 1);
        map.put(c1531n3, 1);
        map.put(c1531n5, 2);
        k = Collections.unmodifiableMap(map);
        l = c1531n5;
        m = new C1504L(2);
        n = new C1504L(3);
        o = new C1504L(4);
        try {
            Iterator it = Arrays.asList(new C1394o[0]).iterator();
            p = it.hasNext() ? (C1394o) it.next() : C1394o.f4313a;
            HashMap map2 = new HashMap();
            f4585q = map2;
            map2.put(c1515x, c1531n);
            map2.put(c1516y, c1531n2);
            map2.put(c1517z, c1531n3);
            map2.put(c1512u, c1531n4);
            map2.put(a0Var, c1531n5);
            map2.put(c1514w, c1531n6);
            map2.put(c1511t, c1531n7);
            map2.put(c1513v, c1531n8);
            map2.put(b0Var, c1531n9);
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r3
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: h8.AbstractC1532o.a(int):void");
    }

    public static Integer b(C1531n c1531n, C1531n c1531n2) {
        if (c1531n == null) {
            a(12);
            throw null;
        }
        d0 d0Var = c1531n.f4582a;
        if (c1531n2 == null) {
            a(13);
            throw null;
        }
        d0 d0Var2 = c1531n2.f4582a;
        Integer numA = d0Var.a(d0Var2);
        if (numA != null) {
            return numA;
        }
        Integer numA2 = d0Var2.a(d0Var);
        if (numA2 != null) {
            return Integer.valueOf(-numA2.intValue());
        }
        return null;
    }

    public static InterfaceC1530m c(R8.d dVar, InterfaceC1530m interfaceC1530m, InterfaceC1527j interfaceC1527j) {
        InterfaceC1530m interfaceC1530mC;
        if (interfaceC1530m == null) {
            a(8);
            throw null;
        }
        if (interfaceC1527j == null) {
            a(9);
            throw null;
        }
        for (InterfaceC1530m interfaceC1530m2 = (InterfaceC1530m) interfaceC1530m.a(); interfaceC1530m2 != null && interfaceC1530m2.getVisibility() != f; interfaceC1530m2 = (InterfaceC1530m) J8.e.i(interfaceC1530m2, InterfaceC1530m.class, true)) {
            if (!interfaceC1530m2.getVisibility().a(dVar, interfaceC1530m2, interfaceC1527j)) {
                return interfaceC1530m2;
            }
        }
        if (!(interfaceC1530m instanceof k8.M) || (interfaceC1530mC = c(dVar, ((k8.N) ((k8.M) interfaceC1530m)).f4841F, interfaceC1527j)) == null) {
            return null;
        }
        return interfaceC1530mC;
    }

    public static boolean d(InterfaceC1530m interfaceC1530m, InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j == null) {
            a(7);
            throw null;
        }
        C1504L c1504lF = J8.e.f(interfaceC1527j);
        if (c1504lF != C1504L.b) {
            return c1504lF.equals(J8.e.f(interfaceC1530m));
        }
        return false;
    }

    public static boolean e(C1531n c1531n) {
        if (c1531n != null) {
            return c1531n == f4583a || c1531n == b;
        }
        a(14);
        throw null;
    }

    public static C1531n f(d0 d0Var) {
        if (d0Var == null) {
            a(15);
            throw null;
        }
        C1531n c1531n = (C1531n) f4585q.get(d0Var);
        if (c1531n != null) {
            return c1531n;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + d0Var);
    }
}
