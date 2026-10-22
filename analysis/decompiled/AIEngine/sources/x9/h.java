package x9;

import com.stepos.deepbinder.core.exception.IPCException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        public static final a f13769c = new a(new int[0], -1);

        /* renamed from: a, reason: collision with root package name */
        public final int f13770a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f13771b;

        public a(int[] iArr, int i10) {
            this.f13770a = i10;
            this.f13771b = iArr;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!a.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type com.stepos.deepbinder.core.utils.TypeUtils.MatchResult");
            a aVar = (a) obj;
            return this.f13770a == aVar.f13770a && Arrays.equals(this.f13771b, aVar.f13771b);
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f13771b) + (this.f13770a * 31);
        }

        public final String toString() {
            return "MatchResult(score=" + this.f13770a + ", parameterMapping=" + Arrays.toString(this.f13771b) + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13772a;

        /* renamed from: b, reason: collision with root package name */
        public final a f13773b;

        public b(Method method, a aVar) {
            this.f13772a = method;
            this.f13773b = aVar;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return kotlin.jvm.internal.g.b(this.f13772a, bVar.f13772a) && kotlin.jvm.internal.g.b(this.f13773b, bVar.f13773b);
        }

        public final int hashCode() {
            return this.f13773b.hashCode() + (this.f13772a.hashCode() * 31);
        }

        public final String toString() {
            return "MethodMatchResult(method=" + this.f13772a + ", matchResult=" + this.f13773b + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t8, T t10) {
            return ob.b.a(Integer.valueOf(((b) t8).f13773b.f13770a), Integer.valueOf(((b) t10).f13773b.f13770a));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a a(Class[] clsArr, Class[] clsArr2) {
        int iE;
        int length = clsArr2.length;
        int length2 = clsArr.length;
        a aVar = a.f13769c;
        if (length > length2) {
            return aVar;
        }
        int i10 = 0;
        if (clsArr2.length != clsArr.length) {
            int length3 = clsArr.length;
            int[] iArr = new int[length3];
            while (i10 < length3) {
                iArr[i10] = -1;
                i10++;
            }
            a aVarD = d(clsArr, clsArr2, 0, 0, iArr, 0);
            return aVarD == null ? aVar : aVarD;
        }
        int length4 = clsArr2.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length4; i12++) {
            Class cls = clsArr[i12];
            Class cls2 = clsArr2[i12];
            if (b(cls, cls2)) {
                iE = 0;
            } else {
                if (!cls.isAssignableFrom(cls2)) {
                    return aVar;
                }
                iE = e(cls2, cls);
            }
            i11 += iE;
        }
        int length5 = clsArr.length;
        int[] iArr2 = new int[length5];
        while (i10 < length5) {
            iArr2[i10] = i10;
            i10++;
        }
        return new a(iArr2, i11);
    }

    public static boolean b(Class class1, Class class2) {
        kotlin.jvm.internal.g.f(class1, "class1");
        kotlin.jvm.internal.g.f(class2, "class2");
        if (class1.equals(class2)) {
            return true;
        }
        boolean zEquals = class1.equals(Boolean.class);
        Class cls = Boolean.TYPE;
        if (zEquals && class2.equals(cls)) {
            return true;
        }
        boolean zEquals2 = class1.equals(Byte.class);
        Class cls2 = Byte.TYPE;
        if (zEquals2 && class2.equals(cls2)) {
            return true;
        }
        boolean zEquals3 = class1.equals(Character.class);
        Class cls3 = Character.TYPE;
        if (zEquals3 && class2.equals(cls3)) {
            return true;
        }
        boolean zEquals4 = class1.equals(Short.class);
        Class cls4 = Short.TYPE;
        if (zEquals4 && class2.equals(cls4)) {
            return true;
        }
        boolean zEquals5 = class1.equals(Integer.class);
        Class cls5 = Integer.TYPE;
        if (zEquals5 && class2.equals(cls5)) {
            return true;
        }
        boolean zEquals6 = class1.equals(Long.class);
        Class cls6 = Long.TYPE;
        if (zEquals6 && class2.equals(cls6)) {
            return true;
        }
        boolean zEquals7 = class1.equals(Float.class);
        Class cls7 = Float.TYPE;
        if (zEquals7 && class2.equals(cls7)) {
            return true;
        }
        boolean zEquals8 = class1.equals(Double.class);
        Class cls8 = Double.TYPE;
        if (zEquals8 && class2.equals(cls8)) {
            return true;
        }
        boolean zEquals9 = class1.equals(Void.class);
        Class cls9 = Void.TYPE;
        if (zEquals9 && class2.equals(cls9)) {
            return true;
        }
        if (class1.equals(cls) && class2.equals(Boolean.class)) {
            return true;
        }
        if (class1.equals(cls2) && class2.equals(Byte.class)) {
            return true;
        }
        if (class1.equals(cls3) && class2.equals(Character.class)) {
            return true;
        }
        if (class1.equals(cls4) && class2.equals(Short.class)) {
            return true;
        }
        if (class1.equals(cls5) && class2.equals(Integer.class)) {
            return true;
        }
        if (class1.equals(cls6) && class2.equals(Long.class)) {
            return true;
        }
        if (class1.equals(cls7) && class2.equals(Float.class)) {
            return true;
        }
        if (class1.equals(cls8) && class2.equals(Double.class)) {
            return true;
        }
        return class1.equals(cls9) && class2.equals(Void.class);
    }

    public static void c(Object obj, LinkedList linkedList, int i10) {
        Field[] declaredFields;
        if (obj == null || (declaredFields = obj.getClass().getDeclaredFields()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (Field field : declaredFields) {
            if ((field.getModifiers() & 4112) == 4112) {
                arrayList.add(field);
            }
        }
        int size = arrayList.size();
        while (i11 < size) {
            Object obj2 = arrayList.get(i11);
            i11++;
            Field field2 = (Field) obj2;
            kotlin.jvm.internal.g.c(field2);
            linkedList.add(new x9.b(obj, field2, i10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a d(Class[] clsArr, Class[] clsArr2, int i10, int i11, int[] iArr, int i12) {
        if (i11 >= clsArr2.length) {
            int length = ((clsArr.length - clsArr2.length) * 100) + i12;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            kotlin.jvm.internal.g.e(iArrCopyOf, "copyOf(...)");
            return new a(iArrCopyOf, length);
        }
        if (i10 >= clsArr.length) {
            return null;
        }
        Class cls = clsArr2[i11];
        int length2 = clsArr.length;
        a aVar = null;
        for (int i13 = i10; i13 < length2; i13++) {
            Class cls2 = clsArr[i13];
            int iE = b(cls2, cls) ? 0 : cls2.isAssignableFrom(cls) ? e(cls, cls2) : -1;
            if (iE >= 0) {
                int[] iArrCopyOf2 = Arrays.copyOf(iArr, iArr.length);
                kotlin.jvm.internal.g.e(iArrCopyOf2, "copyOf(...)");
                iArrCopyOf2[i13] = i11;
                a aVarD = d(clsArr, clsArr2, i13 + 1, i11 + 1, iArrCopyOf2, i12 + iE);
                if (aVarD != null && (aVar == null || aVarD.f13770a < aVar.f13770a)) {
                    aVar = aVarD;
                }
            }
        }
        return aVar;
    }

    public static int e(Class cls, Class cls2) {
        Class superclass = cls.getSuperclass();
        int i10 = 1;
        while (superclass != null && !superclass.equals(cls2)) {
            i10++;
            superclass = superclass.getSuperclass();
        }
        if (superclass == null && cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            kotlin.jvm.internal.g.e(interfaces, "getInterfaces(...)");
            if (l.a0(cls2, interfaces)) {
                return 10;
            }
            superclass = cls.getSuperclass();
            while (superclass != null) {
                Class<?>[] interfaces2 = superclass.getInterfaces();
                kotlin.jvm.internal.g.e(interfaces2, "getInterfaces(...)");
                if (l.a0(cls2, interfaces2)) {
                    return i10 + 10;
                }
                superclass = superclass.getSuperclass();
                i10++;
            }
        }
        if (superclass == null) {
            return 1000;
        }
        return i10;
    }

    public static b f(Class cls, String methodName, Class[] clsArr, boolean z) throws SecurityException {
        kotlin.jvm.internal.g.f(methodName, "methodName");
        if (methodName.length() == 0) {
            methodName = "getInstance";
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        kotlin.jvm.internal.g.e(declaredMethods, "getDeclaredMethods(...)");
        ArrayList arrayList = new ArrayList();
        for (Method method : declaredMethods) {
            if (kotlin.jvm.internal.g.b(method.getName(), methodName)) {
                arrayList.add(method);
            }
        }
        if (arrayList.isEmpty()) {
            throw new IPCException(35, ai.onnxruntime.a.l("Method ", methodName, " not found in ", cls.getName()));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Method method2 = (Method) obj;
            Class<?>[] parameterTypes = method2.getParameterTypes();
            kotlin.jvm.internal.g.e(parameterTypes, "getParameterTypes(...)");
            a aVarA = a(parameterTypes, clsArr);
            b bVar = aVarA.f13770a >= 0 ? new b(method2, aVarA) : null;
            if (bVar != null) {
                arrayList2.add(bVar);
            }
        }
        if (arrayList2.isEmpty()) {
            String name = cls.getName();
            String strJ0 = l.j0(clsArr, new o6.a(11), 31);
            StringBuilder sbS = ai.onnxruntime.a.s("No matching method ", methodName, " found in ", name, " for parameters: ");
            sbS.append(strJ0);
            throw new IPCException(35, sbS.toString());
        }
        List listI0 = kotlin.collections.a.I0(arrayList2, new c());
        if (listI0.size() > 1 && ((b) listI0.get(0)).f13773b.f13770a == ((b) listI0.get(1)).f13773b.f13770a) {
            throw new IPCException(33, h0.e.c("Ambiguous method call: More than one method named ", methodName, " in ", cls.getName(), " with equal match score"));
        }
        b bVar2 = (b) kotlin.collections.a.t0(listI0);
        Method method3 = bVar2.f13772a;
        method3.setAccessible(true);
        if (z || kotlin.jvm.internal.g.b(method3.getReturnType(), cls)) {
            return bVar2;
        }
        throw new IPCException(34, ai.onnxruntime.a.p(ai.onnxruntime.a.s("Return type mismatch for ", methodName, " in ", cls.getName(), ": expected "), cls.getName(), ", got ", method3.getReturnType().getName()));
    }
}
