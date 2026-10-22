package androidx.datastore.preferences.protobuf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class v extends a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, v> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected b1 unknownFields;

    public v() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = b1.f451f;
    }

    public static v d(Class cls) throws ClassNotFoundException {
        v vVar = defaultInstanceMap.get(cls);
        if (vVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                vVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e9) {
                throw new IllegalStateException("Class initialization cannot fail.", e9);
            }
        }
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = (v) ((v) h1.d(cls)).c(6);
        if (vVar2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, vVar2);
        return vVar2;
    }

    public static Object e(Method method, v vVar, Object... objArr) {
        try {
            return method.invoke(vVar, objArr);
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e9);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean f(v vVar, boolean z) {
        byte bByteValue = ((Byte) vVar.c(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        r0 r0Var = r0.f559c;
        r0Var.getClass();
        boolean zC = r0Var.a(vVar.getClass()).c(vVar);
        if (z) {
            vVar.c(2);
        }
        return zC;
    }

    public static void j(Class cls, v vVar) {
        vVar.h();
        defaultInstanceMap.put(cls, vVar);
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final int a(u0 u0Var) {
        int i8;
        int i9;
        if (g()) {
            if (u0Var == null) {
                r0 r0Var = r0.f559c;
                r0Var.getClass();
                i9 = r0Var.a(getClass()).i(this);
            } else {
                i9 = u0Var.i(this);
            }
            if (i9 >= 0) {
                return i9;
            }
            throw new IllegalStateException(a8.b.j(i9, "serialized size must be non-negative, was "));
        }
        int i10 = this.memoizedSerializedSize;
        if ((i10 & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i10 & Integer.MAX_VALUE;
        }
        if (u0Var == null) {
            r0 r0Var2 = r0.f559c;
            r0Var2.getClass();
            i8 = r0Var2.a(getClass()).i(this);
        } else {
            i8 = u0Var.i(this);
        }
        k(i8);
        return i8;
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final void b(l lVar) {
        r0 r0Var = r0.f559c;
        r0Var.getClass();
        u0 u0VarA = r0Var.a(getClass());
        e0 e0Var = lVar.f509a;
        if (e0Var == null) {
            e0Var = new e0(lVar);
        }
        u0VarA.e(this, e0Var);
    }

    public abstract Object c(int i8);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r0 r0Var = r0.f559c;
        r0Var.getClass();
        return r0Var.a(getClass()).g(this, (v) obj);
    }

    public final boolean g() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void h() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final int hashCode() {
        if (g()) {
            r0 r0Var = r0.f559c;
            r0Var.getClass();
            return r0Var.a(getClass()).f(this);
        }
        if (this.memoizedHashCode == 0) {
            r0 r0Var2 = r0.f559c;
            r0Var2.getClass();
            this.memoizedHashCode = r0Var2.a(getClass()).f(this);
        }
        return this.memoizedHashCode;
    }

    public final v i() {
        return (v) c(4);
    }

    public final void k(int i8) {
        if (i8 < 0) {
            throw new IllegalStateException(a8.b.j(i8, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i8 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = l0.f513a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        l0.c(this, sb, 0);
        return sb.toString();
    }
}
