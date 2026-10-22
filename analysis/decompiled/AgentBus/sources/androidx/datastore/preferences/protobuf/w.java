package androidx.datastore.preferences.protobuf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class w extends a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, w> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected j1 unknownFields;

    public w() {
        this.memoizedHashCode = UNINITIALIZED_HASH_CODE;
        this.memoizedSerializedSize = -1;
        this.unknownFields = j1.f886f;
    }

    public static w d(Class cls) throws ClassNotFoundException {
        w wVar = defaultInstanceMap.get(cls);
        if (wVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                wVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = (w) ((w) s1.b(cls)).c(6);
        if (wVar2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, wVar2);
        return wVar2;
    }

    public static Object e(Method method, w wVar, Object... objArr) {
        try {
            return method.invoke(wVar, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean f(w wVar, boolean z4) {
        byte bByteValue = ((Byte) wVar.c(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        w0 w0Var = w0.f962c;
        w0Var.getClass();
        boolean zC = w0Var.a(wVar.getClass()).c(wVar);
        if (z4) {
            wVar.c(2);
        }
        return zC;
    }

    public static void j(Class cls, w wVar) {
        wVar.h();
        defaultInstanceMap.put(cls, wVar);
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final int a(z0 z0Var) {
        int i2;
        int i10;
        if (g()) {
            if (z0Var == null) {
                w0 w0Var = w0.f962c;
                w0Var.getClass();
                i10 = w0Var.a(getClass()).i(this);
            } else {
                i10 = z0Var.i(this);
            }
            if (i10 >= 0) {
                return i10;
            }
            throw new IllegalStateException(n.f.c(i10, "serialized size must be non-negative, was "));
        }
        int i11 = this.memoizedSerializedSize;
        if ((i11 & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i11 & Integer.MAX_VALUE;
        }
        if (z0Var == null) {
            w0 w0Var2 = w0.f962c;
            w0Var2.getClass();
            i2 = w0Var2.a(getClass()).i(this);
        } else {
            i2 = z0Var.i(this);
        }
        k(i2);
        return i2;
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final void b(m mVar) {
        w0 w0Var = w0.f962c;
        w0Var.getClass();
        z0 z0VarA = w0Var.a(getClass());
        i0 i0Var = mVar.f903c;
        if (i0Var == null) {
            i0Var = new i0(mVar);
        }
        z0VarA.e(this, i0Var);
    }

    public abstract Object c(int i2);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        w0 w0Var = w0.f962c;
        w0Var.getClass();
        return w0Var.a(getClass()).g(this, (w) obj);
    }

    public final boolean g() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void h() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final int hashCode() {
        if (g()) {
            w0 w0Var = w0.f962c;
            w0Var.getClass();
            return w0Var.a(getClass()).f(this);
        }
        if (this.memoizedHashCode == 0) {
            w0 w0Var2 = w0.f962c;
            w0Var2.getClass();
            this.memoizedHashCode = w0Var2.a(getClass()).f(this);
        }
        return this.memoizedHashCode;
    }

    public final w i() {
        return (w) c(4);
    }

    public final void k(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException(n.f.c(i2, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i2 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = p0.f915a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(string);
        p0.c(this, sb2, UNINITIALIZED_HASH_CODE);
        return sb2.toString();
    }
}
