package J1;

import f1.AbstractC0557a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class b extends AbstractC0557a {

    /* renamed from: i, reason: collision with root package name */
    public final Method f876i = Class.class.getMethod("isRecord", new Class[0]);

    /* renamed from: j, reason: collision with root package name */
    public final Method f877j;

    /* renamed from: k, reason: collision with root package name */
    public final Method f878k;

    /* renamed from: l, reason: collision with root package name */
    public final Method f879l;

    public b() throws NoSuchMethodException, SecurityException {
        Method method = Class.class.getMethod("getRecordComponents", new Class[0]);
        this.f877j = method;
        Class<?> componentType = method.getReturnType().getComponentType();
        this.f878k = componentType.getMethod("getName", new Class[0]);
        this.f879l = componentType.getMethod("getType", new Class[0]);
    }

    @Override // f1.AbstractC0557a
    public final String[] A(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f877j.invoke(cls, new Object[0]);
            String[] strArr = new String[objArr.length];
            for (int i4 = 0; i4 < objArr.length; i4++) {
                strArr[i4] = (String) this.f878k.invoke(objArr[i4], new Object[0]);
            }
            return strArr;
        } catch (ReflectiveOperationException e4) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e4);
        }
    }

    @Override // f1.AbstractC0557a
    public final boolean J(Class cls) {
        try {
            return ((Boolean) this.f876i.invoke(cls, new Object[0])).booleanValue();
        } catch (ReflectiveOperationException e4) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e4);
        }
    }

    @Override // f1.AbstractC0557a
    public final Method t(Class cls, Field field) {
        try {
            return cls.getMethod(field.getName(), new Class[0]);
        } catch (ReflectiveOperationException e4) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e4);
        }
    }

    @Override // f1.AbstractC0557a
    public final Constructor v(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f877j.invoke(cls, new Object[0]);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i4 = 0; i4 < objArr.length; i4++) {
                clsArr[i4] = (Class) this.f879l.invoke(objArr[i4], new Object[0]);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e4) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e4);
        }
    }
}
