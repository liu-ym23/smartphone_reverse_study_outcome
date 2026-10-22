package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        this.memoizedHashCode = UNINITIALIZED_HASH_CODE;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d1.f2196f;
    }

    public static void f(v vVar) throws b0 {
        if (!l(vVar, true)) {
            throw new b0(new c1().getMessage());
        }
    }

    public static v i(Class cls) throws ClassNotFoundException {
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
        v defaultInstanceForType = ((v) m1.b(cls)).getDefaultInstanceForType();
        if (defaultInstanceForType == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, defaultInstanceForType);
        return defaultInstanceForType;
    }

    public static Object k(Method method, v vVar, Object... objArr) {
        try {
            return method.invoke(vVar, objArr);
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

    public static final boolean l(v vVar, boolean z4) {
        byte bByteValue = ((Byte) vVar.h(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        x0 x0Var = x0.f2290c;
        x0Var.getClass();
        boolean zC = x0Var.a(vVar.getClass()).c(vVar);
        if (z4) {
            vVar.h(2);
        }
        return zC;
    }

    public static v q(v vVar, h hVar, n nVar) throws b0 {
        g gVar = (g) hVar;
        i iVarH = androidx.datastore.preferences.protobuf.j.h(gVar.f2207i, gVar.k(), gVar.size(), true);
        v vVarR = r(vVar, iVarH, nVar);
        iVarH.b(UNINITIALIZED_HASH_CODE);
        f(vVarR);
        return vVarR;
    }

    public static v r(v vVar, androidx.datastore.preferences.protobuf.j jVar, n nVar) throws b0 {
        v vVarP = vVar.p();
        try {
            x0 x0Var = x0.f2290c;
            x0Var.getClass();
            a1 a1VarA = x0Var.a(vVarP.getClass());
            androidx.datastore.preferences.protobuf.k kVar = (androidx.datastore.preferences.protobuf.k) jVar.f882b;
            if (kVar == null) {
                kVar = new androidx.datastore.preferences.protobuf.k(jVar, (byte) 0);
            }
            a1VarA.j(vVarP, kVar, nVar);
            a1VarA.b(vVarP);
            return vVarP;
        } catch (b0 e10) {
            if (e10.f2177f) {
                throw new b0(e10.getMessage(), e10);
            }
            throw e10;
        } catch (c1 e11) {
            throw new b0(e11.getMessage());
        } catch (IOException e12) {
            if (e12.getCause() instanceof b0) {
                throw ((b0) e12.getCause());
            }
            throw new b0(e12.getMessage(), e12);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof b0) {
                throw ((b0) e13.getCause());
            }
            throw e13;
        }
    }

    public static void s(Class cls, v vVar) {
        vVar.n();
        defaultInstanceMap.put(cls, vVar);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    public final int a(a1 a1Var) {
        int iE;
        int iE2;
        if (m()) {
            if (a1Var == null) {
                x0 x0Var = x0.f2290c;
                x0Var.getClass();
                iE2 = x0Var.a(getClass()).e(this);
            } else {
                iE2 = a1Var.e(this);
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
        if (a1Var == null) {
            x0 x0Var2 = x0.f2290c;
            x0Var2.getClass();
            iE = x0Var2.a(getClass()).e(this);
        } else {
            iE = a1Var.e(this);
        }
        t(iE);
        return iE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    public final void e(k kVar) {
        x0 x0Var = x0.f2290c;
        x0Var.getClass();
        a1 a1VarA = x0Var.a(getClass());
        k0 k0Var = kVar.f2234a;
        if (k0Var == null) {
            k0Var = new k0(kVar);
        }
        a1VarA.h(this, k0Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        x0 x0Var = x0.f2290c;
        x0Var.getClass();
        return x0Var.a(getClass()).g(this, (v) obj);
    }

    public final t g() {
        return (t) h(5);
    }

    public abstract Object h(int i2);

    public final int hashCode() {
        if (m()) {
            x0 x0Var = x0.f2290c;
            x0Var.getClass();
            return x0Var.a(getClass()).i(this);
        }
        if (this.memoizedHashCode == 0) {
            x0 x0Var2 = x0.f2290c;
            x0Var2.getClass();
            this.memoizedHashCode = x0Var2.a(getClass()).i(this);
        }
        return this.memoizedHashCode;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.p0
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final v getDefaultInstanceForType() {
        return (v) h(6);
    }

    public final boolean m() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void n() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final t c() {
        return (t) h(5);
    }

    public final v p() {
        return (v) h(4);
    }

    public final void t(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException(n.f.c(i2, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i2 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = q0.f2264a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(string);
        q0.c(this, sb2, UNINITIALIZED_HASH_CODE);
        return sb2.toString();
    }

    public final t u() {
        t tVar = (t) h(5);
        if (!tVar.f2286f.equals(this)) {
            tVar.d();
            t.e(tVar.f2287g, this);
        }
        return tVar;
    }
}
