package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
class OptionalMethod<T> {
    private final String methodName;
    private final Class[] methodParams;
    private final Class<?> returnType;

    public OptionalMethod(Class<?> r10, String r11, Class... r12) {
        this.returnType = r10;
        this.methodName = r11;
        this.methodParams = r12;
    }

    private Method getMethod(Class<?> r10) {
        String r11 = this.methodName;
        if (r11 == null) goto L13;
        Method r12 = getPublicMethod(r10, r11, this.methodParams);
        if (r12 == null) goto L12;
        Class<?> r13 = this.returnType;
        if (r13 == null) goto L12;
        if (r13.isAssignableFrom(r12.getReturnType()) == true) goto L12;
        return null;
    L12:
        return r12;
    L13:
        return null;
    }

    private static Method getPublicMethod(Class<?> r10, String r11, Class[] r12) {
        Method r13 = r10.getMethod(r11, r12);     // Catch: NoSuchMethodException -> L11
        if ((r13.getModifiers() & 1) != 0) goto L9;
        return null;
    L9:
        return r13;
    L17:
        return null;
    }

    public Object invoke(T r10, Object... r11) throws InvocationTargetException {
        Method r12 = getMethod(r10.getClass());
        if (r12 == null) goto L10;
        return r12.invoke(r10, r11);
    L6:
        e = move-exception;
        AssertionError r13 = new AssertionError("Unexpectedly could not call: " + r12);
        r13.initCause(e);
        throw r13;
    L10:
        throw new AssertionError("Method " + this.methodName + " not supported for object " + r10);
    }

    public Object invokeOptional(T r10, Object... r11) throws InvocationTargetException {
        Method r12 = getMethod(r10.getClass());
        if (r12 != null) goto L8;
        return null;
    L8:
        return r12.invoke(r10, r11);
    L7:
        return null;
    }

    public Object invokeOptionalWithoutCheckedException(T r10, Object... r11) {
        return invokeOptional(r10, r11);
    L4:
        e = move-exception;
        Throwable r12 = e.getTargetException();
        if ((r12 instanceof RuntimeException) == true) goto L8;
        AssertionError r13 = new AssertionError("Unexpected exception");
        r13.initCause(r12);
        throw r13;
    L8:
        throw ((RuntimeException) r12);
    }

    public Object invokeWithoutCheckedException(T r10, Object... r11) {
        return invoke(r10, r11);
    L4:
        e = move-exception;
        Throwable r12 = e.getTargetException();
        if ((r12 instanceof RuntimeException) == true) goto L8;
        AssertionError r13 = new AssertionError("Unexpected exception");
        r13.initCause(r12);
        throw r13;
    L8:
        throw ((RuntimeException) r12);
    }

    public boolean isSupported(T r10) {
        if (getMethod(r10.getClass()) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
