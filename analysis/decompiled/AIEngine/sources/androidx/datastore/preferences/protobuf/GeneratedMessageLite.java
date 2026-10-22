package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.a;
import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.q;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends androidx.datastore.preferences.protobuf.a<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected d1 unknownFields = d1.f1800f;
    protected int memoizedSerializedSize = -1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class MethodToInvoke {

        /* renamed from: a, reason: collision with root package name */
        public static final MethodToInvoke f1740a;

        /* renamed from: b, reason: collision with root package name */
        public static final MethodToInvoke f1741b;

        /* renamed from: c, reason: collision with root package name */
        public static final MethodToInvoke f1742c;

        /* renamed from: d, reason: collision with root package name */
        public static final MethodToInvoke f1743d;

        /* renamed from: e, reason: collision with root package name */
        public static final MethodToInvoke f1744e;
        public static final MethodToInvoke h;

        /* renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ MethodToInvoke[] f1745j;

        static {
            MethodToInvoke methodToInvoke = new MethodToInvoke("GET_MEMOIZED_IS_INITIALIZED", 0);
            f1740a = methodToInvoke;
            MethodToInvoke methodToInvoke2 = new MethodToInvoke("SET_MEMOIZED_IS_INITIALIZED", 1);
            f1741b = methodToInvoke2;
            MethodToInvoke methodToInvoke3 = new MethodToInvoke("BUILD_MESSAGE_INFO", 2);
            f1742c = methodToInvoke3;
            MethodToInvoke methodToInvoke4 = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 3);
            f1743d = methodToInvoke4;
            MethodToInvoke methodToInvoke5 = new MethodToInvoke("NEW_BUILDER", 4);
            f1744e = methodToInvoke5;
            MethodToInvoke methodToInvoke6 = new MethodToInvoke("GET_DEFAULT_INSTANCE", 5);
            h = methodToInvoke6;
            f1745j = new MethodToInvoke[]{methodToInvoke, methodToInvoke2, methodToInvoke3, methodToInvoke4, methodToInvoke5, methodToInvoke6, new MethodToInvoke("GET_PARSER", 6)};
        }

        public MethodToInvoke() {
            throw null;
        }

        public static MethodToInvoke valueOf(String str) {
            return (MethodToInvoke) Enum.valueOf(MethodToInvoke.class, str);
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) f1745j.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.AbstractC0012a<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        public final MessageType f1746a;

        /* renamed from: b, reason: collision with root package name */
        public MessageType f1747b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1748c = false;

        public a(MessageType messagetype) {
            this.f1746a = messagetype;
            this.f1747b = (MessageType) messagetype.i(MethodToInvoke.f1743d);
        }

        public static void j(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
            s0 s0Var = s0.f1880c;
            s0Var.getClass();
            s0Var.a(generatedMessageLite.getClass()).f(generatedMessageLite, generatedMessageLite2);
        }

        public final Object clone() {
            a aVar = (a) this.f1746a.i(MethodToInvoke.f1744e);
            GeneratedMessageLite generatedMessageLiteH = h();
            aVar.i();
            j(aVar.f1747b, generatedMessageLiteH);
            return aVar;
        }

        public final MessageType g() {
            MessageType messagetype = (MessageType) h();
            if (messagetype.l()) {
                return messagetype;
            }
            throw new UninitializedMessageException();
        }

        public final MessageType h() {
            if (this.f1748c) {
                return this.f1747b;
            }
            MessageType messagetype = this.f1747b;
            messagetype.getClass();
            s0 s0Var = s0.f1880c;
            s0Var.getClass();
            s0Var.a(messagetype.getClass()).b(messagetype);
            this.f1748c = true;
            return this.f1747b;
        }

        public final void i() {
            if (this.f1748c) {
                MessageType messagetype = (MessageType) this.f1747b.i(MethodToInvoke.f1743d);
                j(messagetype, this.f1747b);
                this.f1747b = messagetype;
                this.f1748c = false;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b<T extends GeneratedMessageLite<T, ?>> extends androidx.datastore.preferences.protobuf.b<T> {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements j0 {
        protected q<d> extensions = q.f1875d;

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.i0
        public final a b() {
            a aVar = (a) i(MethodToInvoke.f1744e);
            aVar.i();
            a.j(aVar.f1747b, this);
            return aVar;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.i0
        public final a d() {
            return (a) i(MethodToInvoke.f1744e);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.j0
        public final GeneratedMessageLite e() {
            return (GeneratedMessageLite) i(MethodToInvoke.h);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d implements q.a<d> {
        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            ((d) obj).getClass();
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.q.a
        public final WireFormat$JavaType f() {
            throw null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e<ContainingType extends i0, Type> extends f {
    }

    public static <T extends GeneratedMessageLite<?, ?>> T j(Class<T> cls) throws ClassNotFoundException {
        T t8 = (T) defaultInstanceMap.get(cls);
        if (t8 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t8 = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (t8 != null) {
            return t8;
        }
        T t10 = (T) ((GeneratedMessageLite) g1.a(cls)).i(MethodToInvoke.h);
        if (t10 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, t10);
        return t10;
    }

    public static Object k(Method method, GeneratedMessageLite generatedMessageLite, Object... objArr) {
        try {
            return method.invoke(generatedMessageLite, objArr);
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

    public static <T extends GeneratedMessageLite<?, ?>> void m(Class<T> cls, T t8) {
        defaultInstanceMap.put(cls, t8);
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final int a() {
        return this.memoizedSerializedSize;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public a b() {
        a aVar = (a) i(MethodToInvoke.f1744e);
        aVar.i();
        a.j(aVar.f1747b, this);
        return aVar;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final int c() {
        if (this.memoizedSerializedSize == -1) {
            s0 s0Var = s0.f1880c;
            s0Var.getClass();
            this.memoizedSerializedSize = s0Var.a(getClass()).c(this);
        }
        return this.memoizedSerializedSize;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public a d() {
        return (a) i(MethodToInvoke.f1744e);
    }

    @Override // androidx.datastore.preferences.protobuf.j0
    public GeneratedMessageLite e() {
        return (GeneratedMessageLite) i(MethodToInvoke.h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((GeneratedMessageLite) i(MethodToInvoke.h)).getClass().isInstance(obj)) {
            return false;
        }
        s0 s0Var = s0.f1880c;
        s0Var.getClass();
        return s0Var.a(getClass()).i(this, (GeneratedMessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final void f(CodedOutputStream codedOutputStream) {
        s0 s0Var = s0.f1880c;
        s0Var.getClass();
        w0 w0VarA = s0Var.a(getClass());
        j jVar = codedOutputStream.f1723b;
        if (jVar == null) {
            jVar = new j(codedOutputStream);
        }
        w0VarA.h(this, jVar);
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final void h(int i10) {
        this.memoizedSerializedSize = i10;
    }

    public final int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        s0 s0Var = s0.f1880c;
        s0Var.getClass();
        int iG = s0Var.a(getClass()).g(this);
        this.memoizedHashCode = iG;
        return iG;
    }

    public abstract Object i(MethodToInvoke methodToInvoke);

    public final boolean l() {
        byte bByteValue = ((Byte) i(MethodToInvoke.f1740a)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        s0 s0Var = s0.f1880c;
        s0Var.getClass();
        boolean zD = s0Var.a(getClass()).d(this);
        i(MethodToInvoke.f1741b);
        return zD;
    }

    public final String toString() {
        String string = super.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(string);
        k0.c(this, sb2, 0);
        return sb2.toString();
    }
}
