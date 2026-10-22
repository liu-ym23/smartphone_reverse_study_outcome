package z7;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class s1 {

    /* renamed from: f, reason: collision with root package name */
    public static final w4.a f11954f = new w4.a();

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0105  */
    /* JADX WARN: Type inference failed for: r0v40, types: [c7.f, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final a8.h a(z7.e1 r8, boolean r9) throws java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z7.s1.a(z7.e1, boolean):a8.h");
    }

    public static final String d(Method method) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        q7.k.d(parameterTypes, "parameterTypes");
        sb2.append(d7.n.o0(parameterTypes, "", "(", ")", b.f11846s, 24));
        Class<?> returnType = method.getReturnType();
        q7.k.d(returnType, "returnType");
        sb2.append(l8.d.b(returnType));
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final a8.w h(z7.e1 r4, boolean r5, java.lang.reflect.Field r6) {
        /*
            z7.k1 r0 = r4.F()
            f8.l0 r0 = r0.B()
            f8.j r1 = r0.p()
            java.lang.String r2 = "containingDeclaration"
            q7.k.d(r1, r2)
            boolean r2 = h9.f.l(r1)
            r3 = 1
            if (r2 != 0) goto L19
            goto L3a
        L19:
            f8.j r1 = r1.p()
            r2 = 2
            boolean r2 = h9.f.n(r1, r2)
            if (r2 != 0) goto L2b
            r2 = 5
            boolean r1 = h9.f.n(r1, r2)
            if (r1 == 0) goto L44
        L2b:
            boolean r1 = r0 instanceof t9.q
            if (r1 == 0) goto L3a
            t9.q r0 = (t9.q) r0
            z8.f0 r0 = r0.F
            boolean r0 = d9.h.d(r0)
            if (r0 == 0) goto L3a
            goto L44
        L3a:
            int r0 = r6.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 != 0) goto L84
        L44:
            java.lang.String r0 = "field"
            if (r5 == 0) goto L62
            boolean r5 = r4.D()
            if (r5 == 0) goto L58
            a8.k r5 = new a8.k
            java.lang.Object r4 = k(r4)
            r5.<init>(r6, r4)
            return r5
        L58:
            a8.m r4 = new a8.m
            q7.k.e(r6, r0)
            r5 = 0
            r4.<init>(r6, r3, r5)
            return r4
        L62:
            boolean r5 = r4.D()
            if (r5 == 0) goto L76
            a8.o r5 = new a8.o
            boolean r0 = i(r4)
            java.lang.Object r4 = k(r4)
            r5.<init>(r6, r0, r4)
            return r5
        L76:
            a8.q r5 = new a8.q
            boolean r4 = i(r4)
            q7.k.e(r6, r0)
            r0 = 0
            r5.<init>(r6, r4, r3, r0)
            return r5
        L84:
            z7.k1 r0 = r4.F()
            f8.l0 r0 = r0.B()
            g8.j r0 = r0.getAnnotations()
            e9.c r1 = z7.x1.f11989a
            boolean r0 = r0.g(r1)
            r1 = 0
            if (r0 == 0) goto Lc9
            if (r5 == 0) goto Lae
            boolean r4 = r4.D()
            if (r4 == 0) goto La7
            a8.l r4 = new a8.l
            r4.<init>(r6, r1)
            return r4
        La7:
            a8.m r4 = new a8.m
            r5 = 1
            r4.<init>(r6, r3, r5)
            return r4
        Lae:
            boolean r5 = r4.D()
            if (r5 == 0) goto Lbe
            a8.p r5 = new a8.p
            boolean r4 = i(r4)
            r5.<init>(r6, r4, r1)
            return r5
        Lbe:
            a8.q r5 = new a8.q
            boolean r4 = i(r4)
            r0 = 1
            r5.<init>(r6, r4, r3, r0)
            return r5
        Lc9:
            if (r5 == 0) goto Ld2
            a8.m r4 = new a8.m
            r5 = 2
            r4.<init>(r6, r1, r5)
            return r4
        Ld2:
            a8.q r5 = new a8.q
            boolean r4 = i(r4)
            r0 = 2
            r5.<init>(r6, r4, r1, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z7.s1.h(z7.e1, boolean, java.lang.reflect.Field):a8.w");
    }

    public static final boolean i(e1 e1Var) {
        return !v9.x0.e(e1Var.F().B().getType());
    }

    public static final Object k(e1 e1Var) {
        k1 k1VarF = e1Var.F();
        return ib.k.p(k1VarF.f11897m, k1VarF.B());
    }

    public static q1 l(f8.c cVar, p7.a aVar) {
        if (aVar != null) {
            return new q1(cVar, aVar);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
    }

    public abstract String f();
}
