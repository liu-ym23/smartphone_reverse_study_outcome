package androidx.lifecycle;

import android.app.Application;
import androidx.datastore.preferences.protobuf.b1;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final List<Class<?>> f2293a = mb.m.b0(Application.class, f0.class);

    /* renamed from: b, reason: collision with root package name */
    public static final List<Class<?>> f2294b = b1.P(f0.class);

    public static final <T> Constructor<T> a(Class<T> cls, List<? extends Class<?>> signature) throws SecurityException {
        kotlin.jvm.internal.g.f(signature, "signature");
        Object[] constructors = cls.getConstructors();
        kotlin.jvm.internal.g.e(constructors, "getConstructors(...)");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.g.e(parameterTypes, "getParameterTypes(...)");
            List listQ0 = mb.l.q0(parameterTypes);
            if (signature.equals(listQ0)) {
                return constructor;
            }
            if (signature.size() == listQ0.size() && listQ0.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends q0> T b(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        try {
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to access " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
        }
    }
}
