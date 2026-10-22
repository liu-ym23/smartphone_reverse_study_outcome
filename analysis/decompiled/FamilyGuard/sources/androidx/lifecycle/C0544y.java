package androidx.lifecycle;

import W3.C0403n;
import com.stepos.minor.Minor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.libpag.BuildConfig;
import r4.C1031n;

/* renamed from: androidx.lifecycle.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0544y {

    /* renamed from: a, reason: collision with root package name */
    public static final C0544y f10907a = new C0544y();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, Integer> f10908b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<?>, List<Constructor<? extends InterfaceC0530j>>> f10909c = new HashMap();

    private C0544y() {
    }

    private final InterfaceC0530j a(Constructor<? extends InterfaceC0530j> constructor, Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            InterfaceC0530j interfaceC0530jNewInstance = constructor.newInstance(obj);
            j4.k.f(interfaceC0530jNewInstance, "{\n            constructo…tance(`object`)\n        }");
            return interfaceC0530jNewInstance;
        } catch (IllegalAccessException e6) {
            throw new RuntimeException(e6);
        } catch (InstantiationException e7) {
            throw new RuntimeException(e7);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    private final Constructor<? extends InterfaceC0530j> b(Class<?> cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Package r32 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r32 != null ? r32.getName() : BuildConfig.FLAVOR;
            j4.k.f(name, "fullPackage");
            if (name.length() != 0) {
                j4.k.f(canonicalName, Minor.COLUMN_NAME);
                canonicalName = canonicalName.substring(name.length() + 1);
                j4.k.f(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            j4.k.f(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(canonicalName);
            if (name.length() != 0) {
                strC = name + '.' + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            j4.k.e(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static final String c(String str) {
        j4.k.g(str, "className");
        return C1031n.o(str, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    private final int d(Class<?> cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Map<Class<?>, Integer> map = f10908b;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    private final boolean e(Class<?> cls) {
        return cls != null && InterfaceC0538s.class.isAssignableFrom(cls);
    }

    public static final InterfaceC0537q f(Object obj) {
        j4.k.g(obj, "object");
        boolean z5 = obj instanceof InterfaceC0537q;
        boolean z6 = obj instanceof InterfaceC0527g;
        if (z5 && z6) {
            return new C0528h((InterfaceC0527g) obj, (InterfaceC0537q) obj);
        }
        if (z6) {
            return new C0528h((InterfaceC0527g) obj, null);
        }
        if (z5) {
            return (InterfaceC0537q) obj;
        }
        Class<?> cls = obj.getClass();
        C0544y c0544y = f10907a;
        if (c0544y.d(cls) != 2) {
            return new G(obj);
        }
        List<Constructor<? extends InterfaceC0530j>> list = f10909c.get(cls);
        j4.k.d(list);
        List<Constructor<? extends InterfaceC0530j>> list2 = list;
        if (list2.size() == 1) {
            return new S(c0544y.a(list2.get(0), obj));
        }
        int size = list2.size();
        InterfaceC0530j[] interfaceC0530jArr = new InterfaceC0530j[size];
        for (int i5 = 0; i5 < size; i5++) {
            interfaceC0530jArr[i5] = f10907a.a(list2.get(i5), obj);
        }
        return new C0523c(interfaceC0530jArr);
    }

    private final int g(Class<?> cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends InterfaceC0530j> constructorB = b(cls);
        if (constructorB != null) {
            f10909c.put(cls, C0403n.b(constructorB));
            return 2;
        }
        if (C0522b.f10855c.d(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (e(superclass)) {
            j4.k.f(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            List<Constructor<? extends InterfaceC0530j>> list = f10909c.get(superclass);
            j4.k.d(list);
            arrayList = new ArrayList(list);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        j4.k.f(interfaces, "klass.interfaces");
        for (Class<?> cls2 : interfaces) {
            if (e(cls2)) {
                j4.k.f(cls2, "intrface");
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                List<Constructor<? extends InterfaceC0530j>> list2 = f10909c.get(cls2);
                j4.k.d(list2);
                arrayList.addAll(list2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f10909c.put(cls, arrayList);
        return 2;
    }
}
