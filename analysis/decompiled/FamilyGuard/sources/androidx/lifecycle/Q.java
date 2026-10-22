package androidx.lifecycle;

import W3.C0396g;
import W3.C0403n;
import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class Q {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Class<?>> f10837a = C0403n.k(Application.class, J.class);

    /* renamed from: b, reason: collision with root package name */
    private static final List<Class<?>> f10838b = C0403n.b(J.class);

    public static final <T> Constructor<T> c(Class<T> cls, List<? extends Class<?>> list) throws SecurityException {
        j4.k.g(cls, "modelClass");
        j4.k.g(list, "signature");
        Object[] constructors = cls.getConstructors();
        j4.k.f(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            j4.k.f(parameterTypes, "constructor.parameterTypes");
            List listU = C0396g.u(parameterTypes);
            if (j4.k.b(list, listU)) {
                j4.k.e(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (list.size() == listU.size() && listU.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends T> T d(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        j4.k.g(cls, "modelClass");
        j4.k.g(constructor, "constructor");
        j4.k.g(objArr, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("Failed to access " + cls, e6);
        } catch (InstantiationException e7) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e7);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e8.getCause());
        }
    }
}
