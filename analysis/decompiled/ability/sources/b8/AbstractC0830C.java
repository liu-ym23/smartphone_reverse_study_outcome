package b8;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import fa.C1449a;
import h8.InterfaceC1501I;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.text.Regex;
import n8.AbstractC1744c;

/* renamed from: b8.C, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0830C implements kotlin.jvm.internal.c {

    /* renamed from: a, reason: collision with root package name */
    public static final Regex f2017a = new Regex("<v#(\\d+)>");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    public static void d(ArrayList arrayList, ArrayList arrayList2, boolean z10) {
        Class cls;
        cls = kotlin.jvm.internal.e.class;
        boolean zB = kotlin.jvm.internal.k.b(D7.v.L0(arrayList2), cls);
        ArrayList arrayListSubList = arrayList2;
        if (zB) {
            arrayListSubList = arrayList2.subList(0, arrayList2.size() - 1);
        }
        arrayList.addAll(arrayListSubList);
        int size = (arrayListSubList.size() + 31) / 32;
        for (int i = 0; i < size; i++) {
            Class TYPE = Integer.TYPE;
            kotlin.jvm.internal.k.e(TYPE, "TYPE");
            arrayList.add(TYPE);
        }
        arrayList.add(z10 ? kotlin.jvm.internal.e.class : Object.class);
    }

    public static Method q(Class cls, String str, Class[] clsArr, Class cls2, boolean z10) throws NoSuchMethodException, SecurityException {
        Class clsY;
        Method methodQ;
        if (z10) {
            clsArr[0] = cls;
        }
        Method methodU = u(cls, str, clsArr, cls2);
        if (methodU != null) {
            return methodU;
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null && (methodQ = q(superclass, str, clsArr, cls2, z10)) != null) {
            return methodQ;
        }
        C7.i iVarJ = kotlin.jvm.internal.k.j(cls.getInterfaces());
        while (iVarJ.hasNext()) {
            Class cls3 = (Class) iVarJ.next();
            kotlin.jvm.internal.k.c(cls3);
            Method methodQ2 = q(cls3, str, clsArr, cls2, z10);
            if (methodQ2 != null) {
                return methodQ2;
            }
            if (z10 && (clsY = U7.a.Y(AbstractC1744c.d(cls3), cls3.getName().concat("$DefaultImpls"))) != null) {
                clsArr[0] = cls3;
                Method methodU2 = u(clsY, str, clsArr, cls2);
                if (methodU2 != null) {
                    return methodU2;
                }
            }
        }
        return null;
    }

    public static Constructor t(Class cls, ArrayList arrayList) {
        try {
            Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Method u(Class cls, String str, Class[] clsArr, Class cls2) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (kotlin.jvm.internal.k.b(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            kotlin.jvm.internal.k.e(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                if (kotlin.jvm.internal.k.b(method.getName(), str) && kotlin.jvm.internal.k.b(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final Method e(String name, String desc, boolean z10) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(desc, "desc");
        if (name.equals(AppAgent.CONSTRUCT)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add(b());
        }
        C1449a c1449aR = r(desc, true);
        d(arrayList, (ArrayList) c1449aR.b, false);
        Class clsO = o();
        String strConcat = name.concat("$default");
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        Class cls = (Class) c1449aR.c;
        kotlin.jvm.internal.k.c(cls);
        return q(clsO, strConcat, clsArr, cls, z10);
    }

    public final Method f(String name, String desc) {
        Method methodQ;
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(desc, "desc");
        if (name.equals(AppAgent.CONSTRUCT)) {
            return null;
        }
        C1449a c1449aR = r(desc, true);
        Class[] clsArr = (Class[]) ((ArrayList) c1449aR.b).toArray(new Class[0]);
        Class cls = (Class) c1449aR.c;
        kotlin.jvm.internal.k.c(cls);
        Method methodQ2 = q(o(), name, clsArr, cls, false);
        if (methodQ2 != null) {
            return methodQ2;
        }
        if (!o().isInterface() || (methodQ = q(Object.class, name, clsArr, cls, false)) == null) {
            return null;
        }
        return methodQ;
    }

    public abstract Collection g();

    public abstract Collection h(G8.f fVar);

    public abstract InterfaceC1501I i(int i);

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection n(Q8.o r8, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.k.f(r8, r0)
            b8.B r0 = new b8.B
            r0.<init>(r7)
            r7 = 3
            r1 = 0
            java.util.Collection r7 = z2.l.z(r8, r1, r7)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L62
            java.lang.Object r2 = r7.next()
            h8.j r2 = (h8.InterfaceC1527j) r2
            boolean r3 = r2 instanceof h8.InterfaceC1520c
            if (r3 == 0) goto L5b
            r3 = r2
            h8.c r3 = (h8.InterfaceC1520c) r3
            h8.n r4 = r3.getVisibility()
            h8.n r5 = h8.AbstractC1532o.h
            boolean r4 = kotlin.jvm.internal.k.b(r4, r5)
            if (r4 != 0) goto L5b
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r3 = r3.getKind()
            r3.getClass()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r4 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind.b
            r5 = 1
            r6 = 0
            if (r3 == r4) goto L49
            r3 = r5
            goto L4a
        L49:
            r3 = r6
        L4a:
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess r4 = kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess.f4938a
            if (r9 != r4) goto L4f
            goto L50
        L4f:
            r5 = r6
        L50:
            if (r3 != r5) goto L5b
            C7.r r3 = C7.r.f317a
            java.lang.Object r2 = r2.N(r0, r3)
            b8.s r2 = (b8.AbstractC0857s) r2
            goto L5c
        L5b:
            r2 = r1
        L5c:
            if (r2 == 0) goto L1b
            r8.add(r2)
            goto L1b
        L62:
            java.util.List r7 = D7.v.f1(r8)
            java.util.Collection r7 = (java.util.Collection) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.AbstractC0830C.n(Q8.o, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    public Class o() {
        Class clsB = b();
        List list = AbstractC1744c.f5355a;
        kotlin.jvm.internal.k.f(clsB, "<this>");
        Class cls = (Class) AbstractC1744c.c.get(clsB);
        return cls == null ? b() : cls;
    }

    public abstract Collection p(G8.f fVar);

    public final C1449a r(String str, boolean z10) {
        int iP0;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int i6 = i;
            while (str.charAt(i6) == '[') {
                i6++;
            }
            char cCharAt = str.charAt(i6);
            if (j9.m.i0("VZCBSIFJD", cCharAt)) {
                iP0 = i6 + 1;
            } else {
                if (cCharAt != 'L') {
                    throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: ".concat(str));
                }
                iP0 = j9.m.p0(str, ';', i, 4) + 1;
            }
            arrayList.add(s(i, iP0, str));
            i = iP0;
        }
        return new C1449a(5, arrayList, false, z10 ? s(i + 1, str.length(), str) : null);
    }

    public final Class s(int i, int i6, String str) throws ClassNotFoundException {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            ClassLoader classLoaderD = AbstractC1744c.d(b());
            String strSubstring = str.substring(i + 1, i6 - 1);
            kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
            Class<?> clsLoadClass = classLoaderD.loadClass(j9.t.b0(strSubstring, JsonPointer.SEPARATOR, '.'));
            kotlin.jvm.internal.k.e(clsLoadClass, "loadClass(...)");
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            Class TYPE = Void.TYPE;
            kotlin.jvm.internal.k.e(TYPE, "TYPE");
            return TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == '[') {
            Class clsS = s(i + 1, i6, str);
            G8.c cVar = v0.f2060a;
            kotlin.jvm.internal.k.f(clsS, "<this>");
            return Array.newInstance((Class<?>) clsS, 0).getClass();
        }
        switch (cCharAt) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                return Byte.TYPE;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            default:
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: ".concat(str));
        }
    }
}
