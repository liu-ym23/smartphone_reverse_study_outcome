package G2;

import com.bytedance.apm.common.utility.reflect.ReflectException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f661a;
    public final boolean b = true;

    public a(Class cls) {
        this.f661a = cls;
    }

    public static boolean b(Method method) {
        if (!method.getName().equals("currentProcessName")) {
            return false;
        }
        int length = method.getParameterTypes().length;
        throw null;
    }

    public static a c(Method method, Object obj, Object... objArr) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (method != null) {
            try {
                if ((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers())) && !method.isAccessible()) {
                    method.setAccessible(true);
                }
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }
        if (method.getReturnType() != Void.TYPE) {
            return new a(method.invoke(obj, objArr));
        }
        method.invoke(obj, objArr);
        return new a(obj);
    }

    public final Method a() throws NoSuchMethodException, SecurityException {
        Class clsE = e();
        try {
            return clsE.getMethod("currentProcessName", null);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return clsE.getDeclaredMethod("currentProcessName", null);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    clsE = clsE.getSuperclass();
                }
            } while (clsE != null);
            for (Method method : this.e().getMethods()) {
                if ("currentProcessName".equals(method.getName()) && method.getParameterTypes() != null) {
                    throw null;
                }
            }
            throw new NoSuchMethodException();
        }
    }

    public final Method d() throws NoSuchMethodException, SecurityException {
        Class clsE = e();
        for (Method method : clsE.getMethods()) {
            b(method);
        }
        do {
            for (Method method2 : clsE.getDeclaredMethods()) {
                b(method2);
            }
            clsE = clsE.getSuperclass();
        } while (clsE != null);
        throw new NoSuchMethodException("No similar method currentProcessName with params " + Arrays.toString((Object[]) null) + " could be found on type " + e() + ".");
    }

    public final Class e() {
        boolean z10 = this.b;
        Object obj = this.f661a;
        return z10 ? (Class) obj : obj.getClass();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f661a.equals(((a) obj).f661a);
    }

    public final int hashCode() {
        return this.f661a.hashCode();
    }

    public final String toString() {
        return this.f661a.toString();
    }

    public a(Object obj) {
        this.f661a = obj;
    }
}
