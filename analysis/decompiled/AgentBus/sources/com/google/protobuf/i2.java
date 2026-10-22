package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class i2 extends c {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Class<?>, i2> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected c4 unknownFields;

    public i2() {
        this.memoizedHashCode = UNINITIALIZED_HASH_CODE;
        this.memoizedSerializedSize = -1;
        this.unknownFields = c4.f2327f;
    }

    public static void c(i2 i2Var) throws r2 {
        if (i2Var != null && !g(i2Var, true)) {
            throw new r2(new b4().getMessage());
        }
    }

    public static i2 e(Class cls) throws ClassNotFoundException {
        i2 i2Var = defaultInstanceMap.get(cls);
        if (i2Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                i2Var = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (i2Var != null) {
            return i2Var;
        }
        i2 i2Var2 = (i2) ((i2) i4.b(cls)).d(6, null);
        if (i2Var2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, i2Var2);
        return i2Var2;
    }

    public static Object f(Method method, i2 i2Var, Object... objArr) {
        try {
            return method.invoke(i2Var, objArr);
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

    public static final boolean g(i2 i2Var, boolean z4) {
        byte bByteValue = ((Byte) i2Var.d(1, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        q3 q3Var = q3.f2501c;
        q3Var.getClass();
        boolean zC = q3Var.a(i2Var.getClass()).c(i2Var);
        if (z4) {
            i2Var.d(2, zC ? i2Var : null);
        }
        return zC;
    }

    public static i2 l(i2 i2Var, l lVar) throws r2 {
        u1 u1VarB = u1.b();
        k kVar = (k) lVar;
        m mVarF = o.f(kVar.f2418i, kVar.k(), kVar.size(), true);
        i2 i2VarK = i2Var.k();
        try {
            q3 q3Var = q3.f2501c;
            q3Var.getClass();
            t3 t3VarA = q3Var.a(i2VarK.getClass());
            androidx.datastore.preferences.protobuf.k kVar2 = mVarF.f2465b;
            if (kVar2 == null) {
                kVar2 = new androidx.datastore.preferences.protobuf.k(mVarF);
            }
            t3VarA.j(i2VarK, kVar2, u1VarB);
            t3VarA.b(i2VarK);
            mVarF.a(UNINITIALIZED_HASH_CODE);
            c(i2VarK);
            c(i2VarK);
            return i2VarK;
        } catch (b4 e10) {
            throw new r2(e10.getMessage());
        } catch (r2 e11) {
            if (e11.f2512f) {
                throw new r2(e11.getMessage(), e11);
            }
            throw e11;
        } catch (IOException e12) {
            if (e12.getCause() instanceof r2) {
                throw ((r2) e12.getCause());
            }
            throw new r2(e12.getMessage(), e12);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof r2) {
                throw ((r2) e13.getCause());
            }
            throw e13;
        }
    }

    public static i2 m(i2 i2Var, byte[] bArr) throws r2 {
        int length = bArr.length;
        u1 u1VarB = u1.b();
        if (length != 0) {
            i2 i2VarK = i2Var.k();
            try {
                q3 q3Var = q3.f2501c;
                q3Var.getClass();
                t3 t3VarA = q3Var.a(i2VarK.getClass());
                t3VarA.h(i2VarK, bArr, UNINITIALIZED_HASH_CODE, length, new g(u1VarB));
                t3VarA.b(i2VarK);
                i2Var = i2VarK;
            } catch (b4 e10) {
                throw new r2(e10.getMessage());
            } catch (r2 e11) {
                if (e11.f2512f) {
                    throw new r2(e11.getMessage(), e11);
                }
                throw e11;
            } catch (IOException e12) {
                if (e12.getCause() instanceof r2) {
                    throw ((r2) e12.getCause());
                }
                throw new r2(e12.getMessage(), e12);
            } catch (IndexOutOfBoundsException unused) {
                throw r2.g();
            }
        }
        c(i2Var);
        return i2Var;
    }

    public static void n(Class cls, i2 i2Var) {
        i2Var.j();
        defaultInstanceMap.put(cls, i2Var);
    }

    @Override // com.google.protobuf.c
    public final int a(t3 t3Var) {
        int iE;
        int iE2;
        if (h()) {
            if (t3Var == null) {
                q3 q3Var = q3.f2501c;
                q3Var.getClass();
                iE2 = q3Var.a(getClass()).e(this);
            } else {
                iE2 = t3Var.e(this);
            }
            if (iE2 >= 0) {
                return iE2;
            }
            throw new IllegalStateException(n.f.c(iE2, "serialized size must be non-negative, was "));
        }
        int i2 = this.memoizedSerializedSize;
        if ((i2 & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i2 & Integer.MAX_VALUE;
        }
        if (t3Var == null) {
            q3 q3Var2 = q3.f2501c;
            q3Var2.getClass();
            iE = q3Var2.a(getClass()).e(this);
        } else {
            iE = t3Var.e(this);
        }
        o(iE);
        return iE;
    }

    public abstract Object d(int i2, i2 i2Var);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q3 q3Var = q3.f2501c;
        q3Var.getClass();
        return q3Var.a(getClass()).g(this, (i2) obj);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    public MessageLite getDefaultInstanceForType() {
        return (i2) d(6, null);
    }

    @Override // com.google.protobuf.MessageLite
    public final p3 getParserForType() {
        return (p3) d(7, null);
    }

    @Override // com.google.protobuf.MessageLite
    public final int getSerializedSize() {
        return a(null);
    }

    public final boolean h() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final int hashCode() {
        if (h()) {
            q3 q3Var = q3.f2501c;
            q3Var.getClass();
            return q3Var.a(getClass()).i(this);
        }
        if (this.memoizedHashCode == 0) {
            q3 q3Var2 = q3.f2501c;
            q3Var2.getClass();
            this.memoizedHashCode = q3Var2.a(getClass()).i(this);
        }
        return this.memoizedHashCode;
    }

    public final void i() {
        q3 q3Var = q3.f2501c;
        q3Var.getClass();
        q3Var.a(getClass()).b(this);
        j();
    }

    @Override // com.google.protobuf.MessageLite
    public final boolean isInitialized() {
        return g(this, true);
    }

    public final void j() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final i2 k() {
        return (i2) d(4, null);
    }

    @Override // com.google.protobuf.MessageLite
    public MessageLite.Builder newBuilderForType() {
        return (f2) d(5, null);
    }

    public final void o(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException(n.f.c(i2, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i2 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
    }

    @Override // com.google.protobuf.MessageLite
    public MessageLite.Builder toBuilder() {
        f2 f2Var = (f2) d(5, null);
        if (f2Var.f2350f.equals(this)) {
            return f2Var;
        }
        f2Var.d();
        f2.h(f2Var.f2351g, this);
        return f2Var;
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = f3.f2352a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(string);
        f3.c(this, sb2, UNINITIALIZED_HASH_CODE);
        return sb2.toString();
    }

    @Override // com.google.protobuf.MessageLite
    public final void writeTo(r rVar) {
        q3 q3Var = q3.f2501c;
        q3Var.getClass();
        t3 t3VarA = q3Var.a(getClass());
        z2 z2Var = rVar.f2506a;
        if (z2Var == null) {
            z2Var = new z2(rVar);
        }
        t3VarA.f(this, z2Var);
    }
}
