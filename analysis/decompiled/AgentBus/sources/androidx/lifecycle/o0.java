package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final List f1017a = d7.s.u0(Application.class, g0.class);

    /* renamed from: b, reason: collision with root package name */
    public static final List f1018b = a.a.S(g0.class);

    public static final Constructor a(Class cls, List list) throws SecurityException {
        q7.k.e(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        q7.k.d(constructors, "getConstructors(...)");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            q7.k.d(parameterTypes, "getParameterTypes(...)");
            List listW0 = d7.n.w0(parameterTypes);
            if (list.equals(listW0)) {
                return constructor;
            }
            if (list.size() == listW0.size() && listW0.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final p0 b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (p0) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(a1.a.g(cls, "Failed to access "), e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(a1.a.g(cls, "An exception happened in constructor of "), e12.getCause());
        }
    }
}
