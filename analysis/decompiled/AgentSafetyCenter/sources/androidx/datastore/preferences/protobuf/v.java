package androidx.datastore.preferences.protobuf;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class v extends a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, v> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected d1 unknownFields;

    public v() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d1.f1097f;
    }

    public static v d(Class cls) throws ClassNotFoundException {
        v vVar = defaultInstanceMap.get(cls);
        if (vVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                vVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = (v) ((v) j1.d(cls)).c(6);
        if (vVar2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, vVar2);
        return vVar2;
    }

    public static Object e(Method method, v vVar, Object... objArr) {
        try {
            return method.invoke(vVar, objArr);
        } catch (IllegalAccessException e10) {
            od.f.g("Couldn't use Java reflection to implement protocol message reflection.", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            od.f.g("Unexpected exception thrown by generated accessor method.", cause);
            return null;
        }
    }

    public static final boolean f(v vVar, boolean z10) {
        byte bByteValue = ((Byte) vVar.c(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        t0 t0Var = t0.f1207c;
        t0Var.getClass();
        boolean zIsInitialized = t0Var.a(vVar.getClass()).isInitialized(vVar);
        if (z10) {
            vVar.c(2);
        }
        return zIsInitialized;
    }

    public static v0 i(v vVar, String str, Object[] objArr) {
        char cCharAt;
        v0 v0Var = new v0();
        v0Var.f1214a = vVar;
        v0Var.f1215b = str;
        v0Var.f1216c = objArr;
        char cCharAt2 = str.charAt(0);
        if (cCharAt2 < 55296) {
            v0Var.f1217d = cCharAt2;
        } else {
            int i = cCharAt2 & 8191;
            int i3 = 13;
            int i10 = 1;
            while (true) {
                int i11 = i10 + 1;
                cCharAt = str.charAt(i10);
                if (cCharAt < 55296) {
                    break;
                }
                i |= (cCharAt & 8191) << i3;
                i3 += 13;
                i10 = i11;
            }
            v0Var.f1217d = i | (cCharAt << i3);
        }
        VarHandle.storeStoreFence();
        return v0Var;
    }

    public static void k(Class cls, v vVar) {
        vVar.h();
        defaultInstanceMap.put(cls, vVar);
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final int a(w0 w0Var) {
        int iB;
        int iB2;
        if (g()) {
            if (w0Var == null) {
                t0 t0Var = t0.f1207c;
                t0Var.getClass();
                iB2 = t0Var.a(getClass()).b(this);
            } else {
                iB2 = w0Var.b(this);
            }
            if (iB2 >= 0) {
                return iB2;
            }
            od.f.e(k0.a.j(iB2, "serialized size must be non-negative, was "));
            return 0;
        }
        int i = this.memoizedSerializedSize;
        if ((i & Reader.READ_DONE) != Integer.MAX_VALUE) {
            return i & Reader.READ_DONE;
        }
        if (w0Var == null) {
            t0 t0Var2 = t0.f1207c;
            t0Var2.getClass();
            iB = t0Var2.a(getClass()).b(this);
        } else {
            iB = w0Var.b(this);
        }
        l(iB);
        return iB;
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final void b(l lVar) {
        t0 t0Var = t0.f1207c;
        t0Var.getClass();
        w0 w0VarA = t0Var.a(getClass());
        f0 f0Var = lVar.f1150a;
        if (f0Var == null) {
            f0Var = new f0();
            Charset charset = x.f1218a;
            f0Var.f1110a = lVar;
            lVar.f1150a = f0Var;
            VarHandle.storeStoreFence();
        }
        w0VarA.a(this, f0Var);
    }

    public abstract Object c(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        t0 t0Var = t0.f1207c;
        t0Var.getClass();
        return t0Var.a(getClass()).d(this, (v) obj);
    }

    public final boolean g() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }

    public final void h() {
        this.memoizedSerializedSize &= Reader.READ_DONE;
    }

    public final int hashCode() {
        if (g()) {
            t0 t0Var = t0.f1207c;
            t0Var.getClass();
            return t0Var.a(getClass()).c(this);
        }
        if (this.memoizedHashCode == 0) {
            t0 t0Var2 = t0.f1207c;
            t0Var2.getClass();
            this.memoizedHashCode = t0Var2.a(getClass()).c(this);
        }
        return this.memoizedHashCode;
    }

    public final v j() {
        return (v) c(4);
    }

    public final void l(int i) {
        if (i < 0) {
            od.f.e(k0.a.j(i, "serialized size must be non-negative, was "));
        } else {
            this.memoizedSerializedSize = (i & Reader.READ_DONE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        }
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = m0.f1156a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(string);
        m0.c(this, sb2, 0);
        return sb2.toString();
    }
}
