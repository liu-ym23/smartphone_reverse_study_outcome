package z7;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e0 implements q7.d {

    /* renamed from: f, reason: collision with root package name */
    public static final ga.i f11860f = new ga.i("<v#(\\d+)>");

    public static Method E(Class cls, String str, Class[] clsArr, Class cls2, boolean z4) throws NoSuchMethodException, SecurityException {
        Class clsN0;
        Method methodE;
        if (z4) {
            clsArr[0] = cls;
        }
        Method methodG = G(cls, str, clsArr, cls2);
        if (methodG != null) {
            return methodG;
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null && (methodE = E(superclass, str, clsArr, cls2, z4)) != null) {
            return methodE;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        q7.k.d(interfaces, "interfaces");
        for (Class<?> cls3 : interfaces) {
            q7.k.d(cls3, "superInterface");
            Method methodE2 = E(cls3, str, clsArr, cls2, z4);
            if (methodE2 != null) {
                return methodE2;
            }
            if (z4 && (clsN0 = s7.a.n0(l8.d.d(cls3), cls3.getName().concat("$DefaultImpls"))) != null) {
                clsArr[0] = cls3;
                Method methodG2 = G(clsN0, str, clsArr, cls2);
                if (methodG2 != null) {
                    return methodG2;
                }
            }
        }
        return null;
    }

    public static Method G(Class cls, String str, Class[] clsArr, Class cls2) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (q7.k.a(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            q7.k.d(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                if (q7.k.a(method.getName(), str) && q7.k.a(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List A(o9.n r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            q7.k.e(r8, r0)
            java.lang.String r0 = "belonginess"
            m.x.t(r9, r0)
            z7.d0 r0 = new z7.d0
            r1 = 24
            r0.<init>(r1, r7)
            r7 = 3
            r1 = 0
            java.util.Collection r7 = o9.p.getContributedDescriptors$default(r8, r1, r1, r7, r1)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r7 = r7.iterator()
        L22:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L62
            java.lang.Object r2 = r7.next()
            f8.j r2 = (f8.j) r2
            boolean r3 = r2 instanceof f8.c
            if (r3 == 0) goto L5b
            r3 = r2
            f8.c r3 = (f8.c) r3
            f8.n r4 = r3.c()
            f8.n r5 = f8.o.f3495h
            boolean r4 = q7.k.a(r4, r5)
            if (r4 != 0) goto L5b
            int r3 = r3.getKind()
            r4 = 2
            r5 = 0
            r6 = 1
            if (r3 == r4) goto L4c
            r3 = r6
            goto L4d
        L4c:
            r3 = r5
        L4d:
            if (r9 != r6) goto L50
            r5 = r6
        L50:
            if (r3 != r5) goto L5b
            c7.r r3 = c7.r.f1986a
            java.lang.Object r2 = r2.P(r0, r3)
            z7.s r2 = (z7.s) r2
            goto L5c
        L5b:
            r2 = r1
        L5c:
            if (r2 == 0) goto L22
            r8.add(r2)
            goto L22
        L62:
            java.util.List r7 = d7.r.m1(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: z7.e0.A(o9.n, int):java.util.List");
    }

    public Class B() {
        Class clsC = c();
        List list = l8.d.f5857a;
        q7.k.e(clsC, "<this>");
        Class cls = (Class) l8.d.f5859c.get(clsC);
        return cls == null ? c() : cls;
    }

    public abstract Collection C(e9.f fVar);

    public final ArrayList D(String str) {
        int iQ0;
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (str.charAt(i2) != ')') {
            int i10 = i2;
            while (str.charAt(i10) == '[') {
                i10++;
            }
            char cCharAt = str.charAt(i10);
            if (ga.k.l0("VZCBSIFJD", cCharAt)) {
                iQ0 = i10 + 1;
            } else {
                if (cCharAt != 'L') {
                    throw new c7.i("Unknown type prefix in the method signature: ".concat(str), 3);
                }
                iQ0 = ga.k.q0(str, ';', i2, 4) + 1;
            }
            arrayList.add(F(str, i2, iQ0));
            i2 = iQ0;
        }
        return arrayList;
    }

    public final Class F(String str, int i2, int i10) throws ClassNotFoundException {
        char cCharAt = str.charAt(i2);
        if (cCharAt == 'L') {
            ClassLoader classLoaderD = l8.d.d(c());
            String strSubstring = str.substring(i2 + 1, i10 - 1);
            q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Class<?> clsLoadClass = classLoaderD.loadClass(ga.r.d0(strSubstring, '/', '.'));
            q7.k.d(clsLoadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return clsLoadClass;
        }
        if (cCharAt == '[') {
            Class clsF = F(str, i2 + 1, i10);
            e9.c cVar = x1.f11989a;
            q7.k.e(clsF, "<this>");
            return Array.newInstance((Class<?>) clsF, 0).getClass();
        }
        if (cCharAt == 'V') {
            Class cls = Void.TYPE;
            q7.k.d(cls, "TYPE");
            return cls;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == 'C') {
            return Character.TYPE;
        }
        if (cCharAt == 'B') {
            return Byte.TYPE;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'D') {
            return Double.TYPE;
        }
        throw new c7.i("Unknown type prefix in the method signature: ".concat(str), 3);
    }

    public final void j(ArrayList arrayList, String str, boolean z4) {
        ArrayList arrayListD = D(str);
        arrayList.addAll(arrayListD);
        int size = (arrayListD.size() + 31) / 32;
        for (int i2 = 0; i2 < size; i2++) {
            Class cls = Integer.TYPE;
            q7.k.d(cls, "TYPE");
            arrayList.add(cls);
        }
        if (!z4) {
            arrayList.add(Object.class);
        } else {
            arrayList.remove(q7.f.class);
            arrayList.add(q7.f.class);
        }
    }

    public final Method u(String str, String str2) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method methodE;
        q7.k.e(str, "name");
        q7.k.e(str2, "desc");
        if (str.equals("<init>")) {
            return null;
        }
        Class[] clsArr = (Class[]) D(str2).toArray(new Class[0]);
        Class clsF = F(str2, ga.k.q0(str2, ')', 0, 6) + 1, str2.length());
        Method methodE2 = E(B(), str, clsArr, clsF, false);
        if (methodE2 != null) {
            return methodE2;
        }
        if (!B().isInterface() || (methodE = E(Object.class, str, clsArr, clsF, false)) == null) {
            return null;
        }
        return methodE;
    }

    public abstract Collection x();

    public abstract Collection y(e9.f fVar);

    public abstract f8.l0 z(int i2);
}
