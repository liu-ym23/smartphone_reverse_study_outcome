package android.view;

import La.D;
import Z8.C1172u;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C4851b;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\f2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00152\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00152\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u001e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0004\u0012\u00020\u00150\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001dR2\u0010 \u001a \u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u001f0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001d¨\u0006!"}, d2 = {"Landroidx/lifecycle/v;", "", "<init>", "()V", "object", "Landroidx/lifecycle/m;", "f", "(Ljava/lang/Object;)Landroidx/lifecycle/m;", "", "className", "c", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/reflect/Constructor;", "Landroidx/lifecycle/h;", "constructor", Const.INTENT_KEY_APIKEY, "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)Landroidx/lifecycle/h;", "Ljava/lang/Class;", "klass", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;", "", Const.INTENT_KEY_UMID, "(Ljava/lang/Class;)I", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "e", "(Ljava/lang/Class;)Z", "", "Ljava/util/Map;", "callbackCache", "", "classToAdapters", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.lifecycle.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1403v {

    /* renamed from: a, reason: collision with root package name */
    public static final C1403v f14292a = new C1403v();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Map<Class<?>, Integer> callbackCache = new HashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Map<Class<?>, List<Constructor<? extends InterfaceC1390h>>> classToAdapters = new HashMap();

    public static final String c(String className) {
        p.i(className, "className");
        return D.T(className, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    public static final InterfaceC1395m f(Object object) {
        p.i(object, "object");
        boolean z10 = object instanceof InterfaceC1395m;
        boolean z11 = object instanceof InterfaceC1387e;
        if (z10 && z11) {
            return new C1388f((InterfaceC1387e) object, (InterfaceC1395m) object);
        }
        if (z11) {
            return new C1388f((InterfaceC1387e) object, null);
        }
        if (z10) {
            return (InterfaceC1395m) object;
        }
        Class<?> cls = object.getClass();
        C1403v c1403v = f14292a;
        if (c1403v.d(cls) != 2) {
            return new D(object);
        }
        List<Constructor<? extends InterfaceC1390h>> list = classToAdapters.get(cls);
        p.f(list);
        List<Constructor<? extends InterfaceC1390h>> list2 = list;
        if (list2.size() == 1) {
            return new P(c1403v.a(list2.get(0), object));
        }
        int size = list2.size();
        InterfaceC1390h[] interfaceC1390hArr = new InterfaceC1390h[size];
        for (int i10 = 0; i10 < size; i10++) {
            interfaceC1390hArr[i10] = f14292a.a(list2.get(i10), object);
        }
        return new C1386d(interfaceC1390hArr);
    }

    public final InterfaceC1390h a(Constructor<? extends InterfaceC1390h> constructor, Object object) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            InterfaceC1390h interfaceC1390hNewInstance = constructor.newInstance(object);
            p.f(interfaceC1390hNewInstance);
            return interfaceC1390hNewInstance;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    public final Constructor<? extends InterfaceC1390h> b(Class<?> klass) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Package r32 = klass.getPackage();
            String canonicalName = klass.getCanonicalName();
            String name = r32 != null ? r32.getName() : "";
            p.f(name);
            if (name.length() != 0) {
                p.f(canonicalName);
                canonicalName = canonicalName.substring(name.length() + 1);
                p.h(canonicalName, "substring(...)");
            }
            p.f(canonicalName);
            String strC = c(canonicalName);
            if (name.length() != 0) {
                strC = name + '.' + strC;
            }
            Class<?> cls = Class.forName(strC);
            p.g(cls, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor declaredConstructor = cls.getDeclaredConstructor(klass);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final int d(Class<?> klass) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Map<Class<?>, Integer> map = callbackCache;
        Integer num = map.get(klass);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(klass);
        map.put(klass, Integer.valueOf(iG));
        return iG;
    }

    public final boolean e(Class<?> klass) {
        return klass != null && InterfaceC1397o.class.isAssignableFrom(klass);
    }

    public final int g(Class<?> klass) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        ArrayList arrayList;
        if (klass.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends InterfaceC1390h> constructorB = b(klass);
        if (constructorB != null) {
            classToAdapters.put(klass, C1172u.e(constructorB));
            return 2;
        }
        if (C1385c.f14264c.d(klass)) {
            return 1;
        }
        Class<? super Object> superclass = klass.getSuperclass();
        if (e(superclass)) {
            p.f(superclass);
            if (d(superclass) == 1) {
                return 1;
            }
            List<Constructor<? extends InterfaceC1390h>> list = classToAdapters.get(superclass);
            p.f(list);
            arrayList = new ArrayList(list);
        } else {
            arrayList = null;
        }
        Iterator itA = C4851b.a(klass.getInterfaces());
        while (itA.hasNext()) {
            Class<?> cls = (Class) itA.next();
            if (e(cls)) {
                p.f(cls);
                if (d(cls) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                List<Constructor<? extends InterfaceC1390h>> list2 = classToAdapters.get(cls);
                p.f(list2);
                arrayList.addAll(list2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        classToAdapters.put(klass, arrayList);
        return 2;
    }
}
