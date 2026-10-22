package androidx.datastore.preferences.protobuf;

import d.C0527a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class A extends AbstractC0247b {
    private static Map<Object, A> defaultInstanceMap = new ConcurrentHashMap();
    protected int memoizedSerializedSize;
    protected q0 unknownFields;

    public A() {
        this.memoizedHashCode = 0;
        this.unknownFields = q0.f3526f;
        this.memoizedSerializedSize = -1;
    }

    public static A e(Class cls) throws ClassNotFoundException {
        A a4 = defaultInstanceMap.get(cls);
        if (a4 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                a4 = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (a4 == null) {
            a4 = (A) ((A) z0.a(cls)).d(6);
            if (a4 == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, a4);
        }
        return a4;
    }

    public static Object f(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static void h(Class cls, A a4) {
        defaultInstanceMap.put(cls, a4);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0247b
    public final int a() {
        if (this.memoizedSerializedSize == -1) {
            C0254e0 c0254e0 = C0254e0.f3467c;
            c0254e0.getClass();
            this.memoizedSerializedSize = c0254e0.a(getClass()).g(this);
        }
        return this.memoizedSerializedSize;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0247b
    public final void c(AbstractC0268o abstractC0268o) {
        C0254e0 c0254e0 = C0254e0.f3467c;
        c0254e0.getClass();
        InterfaceC0262i0 interfaceC0262i0A = c0254e0.a(getClass());
        C0527a c0527a = abstractC0268o.f3520c;
        if (c0527a == null) {
            c0527a = new C0527a(abstractC0268o);
        }
        interfaceC0262i0A.c(this, c0527a);
    }

    public abstract Object d(int i4);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((A) d(6)).getClass().isInstance(obj)) {
            return false;
        }
        C0254e0 c0254e0 = C0254e0.f3467c;
        c0254e0.getClass();
        return c0254e0.a(getClass()).f(this, (A) obj);
    }

    public final boolean g() {
        byte bByteValue = ((Byte) d(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        C0254e0 c0254e0 = C0254e0.f3467c;
        c0254e0.getClass();
        boolean zE = c0254e0.a(getClass()).e(this);
        d(2);
        return zE;
    }

    public final int hashCode() {
        int i4 = this.memoizedHashCode;
        if (i4 != 0) {
            return i4;
        }
        C0254e0 c0254e0 = C0254e0.f3467c;
        c0254e0.getClass();
        int i5 = c0254e0.a(getClass()).i(this);
        this.memoizedHashCode = i5;
        return i5;
    }

    public final String toString() {
        String string = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        X.i(this, sb, 0);
        return sb.toString();
    }
}
