package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final List f1447a = ac.a.F(Application.class, p0.class);

    /* renamed from: b, reason: collision with root package name */
    public static final List f1448b = ac.a.E(p0.class);

    public static final Constructor a(Class cls, List list) throws SecurityException {
        list.getClass();
        Constructor<?>[] constructors = cls.getConstructors();
        constructors.getClass();
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            parameterTypes.getClass();
            List listU0 = kb.k.u0(parameterTypes);
            if (list.equals(listU0)) {
                return constructor;
            }
            if (list.size() == listU0.size() && listU0.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final y0 b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (y0) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e10) {
            b8.z.v(e10, cls, "Failed to access ");
            return null;
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            od.f.g("An exception happened in constructor of " + cls, e12.getCause());
            return null;
        }
    }
}
