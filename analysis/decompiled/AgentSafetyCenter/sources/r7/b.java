package r7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends ac.a {

    /* renamed from: g, reason: collision with root package name */
    public final Method f10470g = Class.class.getMethod("isRecord", null);

    /* renamed from: h, reason: collision with root package name */
    public final Method f10471h = Class.class.getMethod("getRecordComponents", null);
    public final Method i;

    /* renamed from: j, reason: collision with root package name */
    public final Method f10472j;

    public b() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
        this.i = cls.getMethod("getName", null);
        this.f10472j = cls.getMethod("getType", null);
    }

    @Override // ac.a
    public final boolean D(Class cls) {
        try {
            return ((Boolean) this.f10470g.invoke(cls, null)).booleanValue();
        } catch (ReflectiveOperationException e10) {
            f.g("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e10);
            return false;
        }
    }

    @Override // ac.a
    public final Method u(Class cls, Field field) {
        try {
            return cls.getMethod(field.getName(), null);
        } catch (ReflectiveOperationException e10) {
            f.g("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e10);
            return null;
        }
    }

    @Override // ac.a
    public final Constructor v(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f10471h.invoke(cls, null);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                clsArr[i] = (Class) this.f10472j.invoke(objArr[i], null);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e10) {
            f.g("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e10);
            return null;
        }
    }

    @Override // ac.a
    public final String[] y(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f10471h.invoke(cls, null);
            String[] strArr = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                strArr[i] = (String) this.i.invoke(objArr[i], null);
            }
            return strArr;
        } catch (ReflectiveOperationException e10) {
            f.g("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e10);
            return null;
        }
    }
}
