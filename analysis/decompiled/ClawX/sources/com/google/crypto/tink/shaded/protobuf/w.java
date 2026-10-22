package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class w extends a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, w> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected e1 unknownFields;

    public w() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = e1.f1454f;
    }

    public static void g(w wVar) throws c0 {
        if (!m(wVar, true)) {
            throw new c0(new d1().getMessage());
        }
    }

    public static w j(Class cls) throws ClassNotFoundException {
        w wVar = defaultInstanceMap.get(cls);
        if (wVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                wVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e9) {
                throw new IllegalStateException("Class initialization cannot fail.", e9);
            }
        }
        if (wVar != null) {
            return wVar;
        }
        w wVarA = ((w) n1.b(cls)).a();
        if (wVarA == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, wVarA);
        return wVarA;
    }

    public static Object l(Method method, w wVar, Object... objArr) {
        try {
            return method.invoke(wVar, objArr);
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

    public static final boolean m(w wVar, boolean z) {
        byte bByteValue = ((Byte) wVar.i(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        y0 y0Var = y0.f1540c;
        y0Var.getClass();
        boolean zC = y0Var.a(wVar.getClass()).c(wVar);
        if (z) {
            wVar.i(2);
        }
        return zC;
    }

    public static w r(w wVar, i iVar, o oVar) throws c0 {
        h hVar = (h) iVar;
        j jVarH = a2.e.h(hVar.d, hVar.k(), hVar.size(), true);
        w wVarS = s(wVar, jVarH, oVar);
        jVarH.b(0);
        g(wVarS);
        return wVarS;
    }

    public static w s(w wVar, a2.e eVar, o oVar) throws c0 {
        w wVarQ = wVar.q();
        try {
            y0 y0Var = y0.f1540c;
            y0Var.getClass();
            b1 b1VarA = y0Var.a(wVarQ.getClass());
            androidx.datastore.preferences.protobuf.j jVar = (androidx.datastore.preferences.protobuf.j) eVar.f86b;
            if (jVar == null) {
                jVar = new androidx.datastore.preferences.protobuf.j(eVar, (byte) 0);
            }
            b1VarA.j(wVarQ, jVar, oVar);
            b1VarA.b(wVarQ);
            return wVarQ;
        } catch (c0 e9) {
            if (e9.f1436a) {
                throw new c0(e9.getMessage(), e9);
            }
            throw e9;
        } catch (d1 e10) {
            throw new c0(e10.getMessage());
        } catch (IOException e11) {
            if (e11.getCause() instanceof c0) {
                throw ((c0) e11.getCause());
            }
            throw new c0(e11.getMessage(), e11);
        } catch (RuntimeException e12) {
            if (e12.getCause() instanceof c0) {
                throw ((c0) e12.getCause());
            }
            throw e12;
        }
    }

    public static void t(Class cls, w wVar) {
        wVar.o();
        defaultInstanceMap.put(cls, wVar);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    public final int b(b1 b1Var) {
        int iE;
        int iE2;
        if (n()) {
            if (b1Var == null) {
                y0 y0Var = y0.f1540c;
                y0Var.getClass();
                iE2 = y0Var.a(getClass()).e(this);
            } else {
                iE2 = b1Var.e(this);
            }
            if (iE2 >= 0) {
                return iE2;
            }
            throw new IllegalStateException(a8.b.j(iE2, "serialized size must be non-negative, was "));
        }
        int i8 = this.memoizedSerializedSize;
        if ((i8 & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i8 & Integer.MAX_VALUE;
        }
        if (b1Var == null) {
            y0 y0Var2 = y0.f1540c;
            y0Var2.getClass();
            iE = y0Var2.a(getClass()).e(this);
        } else {
            iE = b1Var.e(this);
        }
        u(iE);
        return iE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        y0 y0Var = y0.f1540c;
        y0Var.getClass();
        return y0Var.a(getClass()).g(this, (w) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    public final void f(l lVar) {
        y0 y0Var = y0.f1540c;
        y0Var.getClass();
        b1 b1VarA = y0Var.a(getClass());
        l0 l0Var = lVar.f1488c;
        if (l0Var == null) {
            l0Var = new l0(lVar);
        }
        b1VarA.h(this, l0Var);
    }

    public final u h() {
        return (u) i(5);
    }

    public final int hashCode() {
        if (n()) {
            y0 y0Var = y0.f1540c;
            y0Var.getClass();
            return y0Var.a(getClass()).i(this);
        }
        if (this.memoizedHashCode == 0) {
            y0 y0Var2 = y0.f1540c;
            y0Var2.getClass();
            this.memoizedHashCode = y0Var2.a(getClass()).i(this);
        }
        return this.memoizedHashCode;
    }

    public abstract Object i(int i8);

    @Override // com.google.crypto.tink.shaded.protobuf.q0
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final w a() {
        return (w) i(6);
    }

    public final boolean n() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void o() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final u d() {
        return (u) i(5);
    }

    public final w q() {
        return (w) i(4);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = r0.f1515a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        r0.c(this, sb, 0);
        return sb.toString();
    }

    public final void u(int i8) {
        if (i8 < 0) {
            throw new IllegalStateException(a8.b.j(i8, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i8 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
    }

    public final u v() {
        u uVar = (u) i(5);
        if (!uVar.f1536a.equals(this)) {
            uVar.e();
            u.f(uVar.f1537b, this);
        }
        return uVar;
    }
}
