package f8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final n f3488a;

    /* renamed from: b, reason: collision with root package name */
    public static final n f3489b;

    /* renamed from: c, reason: collision with root package name */
    public static final n f3490c;

    /* renamed from: d, reason: collision with root package name */
    public static final n f3491d;

    /* renamed from: e, reason: collision with root package name */
    public static final n f3492e;

    /* renamed from: f, reason: collision with root package name */
    public static final n f3493f;

    /* renamed from: g, reason: collision with root package name */
    public static final n f3494g;

    /* renamed from: h, reason: collision with root package name */
    public static final n f3495h;

    /* renamed from: i, reason: collision with root package name */
    public static final n f3496i;

    /* renamed from: j, reason: collision with root package name */
    public static final n f3497j;

    /* renamed from: k, reason: collision with root package name */
    public static final o0 f3498k;

    /* renamed from: l, reason: collision with root package name */
    public static final o0 f3499l;

    /* renamed from: m, reason: collision with root package name */
    public static final o0 f3500m;

    /* renamed from: n, reason: collision with root package name */
    public static final ba.p f3501n;

    /* renamed from: o, reason: collision with root package name */
    public static final HashMap f3502o;

    static {
        y0 y0Var = y0.f3522c;
        n nVar = new n(y0Var, 0);
        f3488a = nVar;
        z0 z0Var = z0.f3523c;
        n nVar2 = new n(z0Var, 1);
        f3489b = nVar2;
        a1 a1Var = a1.f3461c;
        n nVar3 = new n(a1Var, 2);
        f3490c = nVar3;
        v0 v0Var = v0.f3517c;
        n nVar4 = new n(v0Var, 3);
        f3491d = nVar4;
        b1 b1Var = b1.f3464c;
        n nVar5 = new n(b1Var, 4);
        f3492e = nVar5;
        x0 x0Var = x0.f3521c;
        n nVar6 = new n(x0Var, 5);
        f3493f = nVar6;
        u0 u0Var = u0.f3515c;
        n nVar7 = new n(u0Var, 6);
        f3494g = nVar7;
        w0 w0Var = w0.f3518c;
        n nVar8 = new n(w0Var, 7);
        f3495h = nVar8;
        c1 c1Var = c1.f3468c;
        n nVar9 = new n(c1Var, 8);
        f3496i = nVar9;
        Collections.unmodifiableSet(d7.n.x0(new n[]{nVar, nVar2, nVar4, nVar6}));
        HashMap map = new HashMap(6);
        map.put(nVar2, 0);
        map.put(nVar, 0);
        map.put(nVar4, 1);
        map.put(nVar3, 1);
        map.put(nVar5, 2);
        Collections.unmodifiableMap(map);
        f3497j = nVar5;
        f3498k = new o0(2);
        f3499l = new o0(3);
        f3500m = new o0(4);
        try {
            Iterator it = Arrays.asList(new ba.p[0]).iterator();
            f3501n = it.hasNext() ? (ba.p) it.next() : ba.p.f1622a;
            HashMap map2 = new HashMap();
            f3502o = map2;
            map2.put(y0Var, nVar);
            map2.put(z0Var, nVar2);
            map2.put(a1Var, nVar3);
            map2.put(v0Var, nVar4);
            map2.put(b1Var, nVar5);
            map2.put(x0Var, nVar6);
            map2.put(u0Var, nVar7);
            map2.put(w0Var, nVar8);
            map2.put(c1Var, nVar9);
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
        throw new UnsupportedOperationException("Method not decompiled: f8.o.a(int):void");
    }

    public static Integer b(n nVar, n nVar2) {
        if (nVar == null) {
            a(12);
            throw null;
        }
        e1 e1Var = nVar.f3485a;
        if (nVar2 == null) {
            a(13);
            throw null;
        }
        e1 e1Var2 = nVar2.f3485a;
        Integer numA = e1Var.a(e1Var2);
        if (numA != null) {
            return numA;
        }
        Integer numA2 = e1Var2.a(e1Var);
        if (numA2 != null) {
            return Integer.valueOf(-numA2.intValue());
        }
        return null;
    }

    public static m c(p9.d dVar, m mVar, j jVar) {
        m mVarC;
        if (mVar == null) {
            a(8);
            throw null;
        }
        if (jVar == null) {
            a(9);
            throw null;
        }
        for (m mVar2 = (m) mVar.a(); mVar2 != null && mVar2.c() != f3493f; mVar2 = (m) h9.f.i(mVar2, m.class, true)) {
            if (!mVar2.c().a(dVar, mVar2, jVar)) {
                return mVar2;
            }
        }
        if (!(mVar instanceof i8.n0) || (mVarC = c(dVar, ((i8.o0) ((i8.n0) mVar)).K, jVar)) == null) {
            return null;
        }
        return mVarC;
    }

    public static boolean d(m mVar, j jVar) {
        if (jVar == null) {
            a(7);
            throw null;
        }
        o0 o0VarF = h9.f.f(jVar);
        if (o0VarF != o0.f3503g) {
            return o0VarF.equals(h9.f.f(mVar));
        }
        return false;
    }

    public static boolean e(n nVar) {
        if (nVar != null) {
            return nVar == f3488a || nVar == f3489b;
        }
        a(14);
        throw null;
    }

    public static n f(e1 e1Var) {
        if (e1Var == null) {
            a(15);
            throw null;
        }
        n nVar = (n) f3502o.get(e1Var);
        if (nVar != null) {
            return nVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + e1Var);
    }
}
