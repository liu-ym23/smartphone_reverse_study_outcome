package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageLite;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public abstract class GeneratedMessageV3 extends AbstractC0924c implements Serializable {
    public final M2 b;

    public GeneratedMessageV3() {
        this.b = M2.b;
    }

    public static InterfaceC0985r1 A(InterfaceC0985r1 interfaceC0985r1) {
        int size = interfaceC0985r1.size();
        int i = size >= 0 ? size * 2 : 0;
        if (i <= 0) {
            i = 10;
        }
        return interfaceC0985r1.mutableCopyWithCapacity(i);
    }

    public static void D(C0980q c0980q, int i, Object obj) throws CodedOutputStream$OutOfSpaceException {
        if (!(obj instanceof String)) {
            c0980q.X(i, (ByteString) obj);
        } else {
            c0980q.k0(i, 2);
            c0980q.j0((String) obj);
        }
    }

    public static Method t(Class cls, String str, Class[] clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    public static Object u(Method method, Object obj, Object[] objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new IllegalStateException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static int v(int i, Object obj) {
        if (!(obj instanceof String)) {
            return C0980q.K(i, (ByteString) obj);
        }
        return C0980q.Q((String) obj) + C0980q.R(i);
    }

    public static int w(Object obj) {
        return obj instanceof String ? C0980q.Q((String) obj) : C0980q.L((ByteString) obj);
    }

    public abstract AbstractC0916a B(F1 f12);

    public abstract Object C();

    @Override // com.google.protobuf.InterfaceC0919a2
    public Object a(D0 d02) {
        return C0868b.f(y(), d02).a(this);
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public Map b() {
        return Collections.unmodifiableMap(x());
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public boolean d(D0 d02) {
        return C0868b.f(y(), d02).b(this);
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return (C1004w0) y().b;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final M2 f() {
        return this.b;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a r(C0986r2 c0986r2) {
        return B(new F1(c0986r2, 3));
    }

    public Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    public final TreeMap x() {
        TreeMap treeMap = new TreeMap();
        List listH = ((C1004w0) y().b).h();
        int i = 0;
        while (i < listH.size()) {
            D0 d0A = (D0) listH.get(i);
            H0 h02 = d0A.f2763j;
            if (h02 != null) {
                i += h02.f - 1;
                if (C0868b.e(y(), h02).b(this)) {
                    d0A = C0868b.e(y(), h02).a(this);
                    treeMap.put(d0A, a(d0A));
                }
            } else if (d0A.isRepeated()) {
                List list = (List) a(d0A);
                if (!list.isEmpty()) {
                    treeMap.put(d0A, list);
                }
            } else if (d(d0A)) {
                treeMap.put(d0A, a(d0A));
            }
            i++;
        }
        return treeMap;
    }

    public abstract C0868b y();

    public AbstractC1002v2 z(int i) {
        throw new IllegalArgumentException("No map fields found in ".concat(getClass().getName()));
    }

    public static abstract class ExtendableMessage<MessageT extends ExtendableMessage<MessageT>> extends GeneratedMessageV3 {
        public final Y0 c;

        public ExtendableMessage() {
            this.c = new Y0();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.InterfaceC0919a2
        public final Object a(D0 d02) {
            if (!d02.b.L()) {
                return super.a(d02);
            }
            if (d02.h != ((C1004w0) y().b)) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            Object obj = this.c.f2903a.get(d02);
            return obj == null ? d02.isRepeated() ? Collections.EMPTY_LIST : d02.g.f2824a == Descriptors$FieldDescriptor$JavaType.MESSAGE ? M0.t(d02.i()) : d02.f() : obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.InterfaceC0919a2
        public final Map b() {
            TreeMap treeMapX = x();
            treeMapX.putAll(this.c.h());
            return Collections.unmodifiableMap(treeMapX);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.InterfaceC0919a2
        public final boolean d(D0 d02) {
            if (!d02.b.L()) {
                return super.d(d02);
            }
            if (d02.h == ((C1004w0) y().b)) {
                return this.c.l(d02);
            }
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        public ExtendableMessage(AbstractC0930d1 abstractC0930d1) {
            Y0 y0B;
            super(abstractC0930d1);
            W0 w02 = abstractC0930d1.e;
            if (w02 == null) {
                y0B = Y0.d;
            } else {
                y0B = w02.b(true);
            }
            this.c = y0B;
        }
    }

    public GeneratedMessageV3(AbstractC0926c1 abstractC0926c1) {
        this.b = abstractC0926c1.f();
    }
}
