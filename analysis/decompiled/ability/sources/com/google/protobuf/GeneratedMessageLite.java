package com.google.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class GeneratedMessageLite extends AbstractC0932e {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected N2 unknownFields = N2.f;

    public static abstract class Builder extends AbstractC0928d {
        private final GeneratedMessageLite defaultInstance;
        protected GeneratedMessageLite instance;

        public Builder(GeneratedMessageLite generatedMessageLite) {
            this.defaultInstance = generatedMessageLite;
            if (generatedMessageLite.v()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.instance = generatedMessageLite.y();
        }

        public final void copyOnWrite() {
            if (this.instance.v()) {
                return;
            }
            copyOnWriteInternal();
        }

        public void copyOnWriteInternal() {
            GeneratedMessageLite generatedMessageLiteY = this.defaultInstance.y();
            GeneratedMessageLite generatedMessageLite = this.instance;
            C0963l2 c0963l2 = C0963l2.c;
            c0963l2.getClass();
            c0963l2.a(generatedMessageLiteY.getClass()).mergeFrom(generatedMessageLiteY, generatedMessageLite);
            this.instance = generatedMessageLiteY;
        }

        @Override // com.google.protobuf.Y1
        public final boolean isInitialized() {
            return GeneratedMessageLite.u(this.instance, false);
        }

        @Override // com.google.protobuf.W1
        /* renamed from: build */
        public final GeneratedMessageLite k() {
            GeneratedMessageLite generatedMessageLiteBuildPartial = m();
            generatedMessageLiteBuildPartial.getClass();
            if (GeneratedMessageLite.u(generatedMessageLiteBuildPartial, true)) {
                return generatedMessageLiteBuildPartial;
            }
            throw AbstractC0928d.newUninitializedMessageException(generatedMessageLiteBuildPartial);
        }

        @Override // com.google.protobuf.W1
        /* renamed from: buildPartial */
        public GeneratedMessageLite m() {
            if (!this.instance.v()) {
                return this.instance;
            }
            GeneratedMessageLite generatedMessageLite = this.instance;
            generatedMessageLite.getClass();
            C0963l2 c0963l2 = C0963l2.c;
            c0963l2.getClass();
            c0963l2.a(generatedMessageLite.getClass()).makeImmutable(generatedMessageLite);
            generatedMessageLite.w();
            return this.instance;
        }

        /* renamed from: clear, reason: merged with bridge method [inline-methods] */
        public final Builder m7316clear() {
            if (this.defaultInstance.v()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.instance = this.defaultInstance.y();
            return this;
        }

        @Override // com.google.protobuf.Y1
        public GeneratedMessageLite getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        @Override // com.google.protobuf.AbstractC0928d
        public Builder internalMergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom(generatedMessageLite);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m7319clone() {
            Builder builder = (Builder) getDefaultInstanceForType().r(MethodToInvoke.e);
            builder.instance = m();
            return builder;
        }

        public Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            if (getDefaultInstanceForType().equals(generatedMessageLite)) {
                return this;
            }
            copyOnWrite();
            GeneratedMessageLite generatedMessageLite2 = this.instance;
            C0963l2 c0963l2 = C0963l2.c;
            c0963l2.getClass();
            c0963l2.a(generatedMessageLite2.getClass()).mergeFrom(generatedMessageLite2, generatedMessageLite);
            return this;
        }

        @Override // com.google.protobuf.AbstractC0928d
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m7321mergeFrom(byte[] bArr, int i, int i6, R0 r02) throws InvalidProtocolBufferException {
            copyOnWrite();
            try {
                C0963l2 c0963l2 = C0963l2.c;
                GeneratedMessageLite generatedMessageLite = this.instance;
                c0963l2.getClass();
                c0963l2.a(generatedMessageLite.getClass()).d(this.instance, bArr, i, i + i6, new C0948i(r02));
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e6) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e6);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.g();
            }
        }

        @Override // com.google.protobuf.AbstractC0928d
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m7320mergeFrom(byte[] bArr, int i, int i6) throws InvalidProtocolBufferException {
            return m7321mergeFrom(bArr, i, i6, R0.a());
        }

        @Override // com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
        public Builder mergeFrom(AbstractC0972o abstractC0972o, R0 r02) throws IOException {
            copyOnWrite();
            try {
                C0963l2 c0963l2 = C0963l2.c;
                GeneratedMessageLite generatedMessageLite = this.instance;
                c0963l2.getClass();
                InterfaceC0979p2 interfaceC0979p2A = c0963l2.a(generatedMessageLite.getClass());
                GeneratedMessageLite generatedMessageLite2 = this.instance;
                C0976p c0976p = abstractC0972o.b;
                if (c0976p == null) {
                    c0976p = new C0976p(abstractC0972o);
                }
                interfaceC0979p2A.c(generatedMessageLite2, c0976p, r02);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class MethodToInvoke {

        /* renamed from: a, reason: collision with root package name */
        public static final MethodToInvoke f2836a;
        public static final MethodToInvoke b;
        public static final MethodToInvoke c;
        public static final MethodToInvoke d;
        public static final MethodToInvoke e;
        public static final MethodToInvoke f;
        public static final /* synthetic */ MethodToInvoke[] g;

        static {
            MethodToInvoke methodToInvoke = new MethodToInvoke("GET_MEMOIZED_IS_INITIALIZED", 0);
            f2836a = methodToInvoke;
            MethodToInvoke methodToInvoke2 = new MethodToInvoke("SET_MEMOIZED_IS_INITIALIZED", 1);
            b = methodToInvoke2;
            MethodToInvoke methodToInvoke3 = new MethodToInvoke("BUILD_MESSAGE_INFO", 2);
            c = methodToInvoke3;
            MethodToInvoke methodToInvoke4 = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 3);
            d = methodToInvoke4;
            MethodToInvoke methodToInvoke5 = new MethodToInvoke("NEW_BUILDER", 4);
            e = methodToInvoke5;
            MethodToInvoke methodToInvoke6 = new MethodToInvoke("GET_DEFAULT_INSTANCE", 5);
            f = methodToInvoke6;
            g = new MethodToInvoke[]{methodToInvoke, methodToInvoke2, methodToInvoke3, methodToInvoke4, methodToInvoke5, methodToInvoke6, new MethodToInvoke("GET_PARSER", 6)};
        }

        public static MethodToInvoke valueOf(String str) {
            return (MethodToInvoke) Enum.valueOf(MethodToInvoke.class, str);
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) g.clone();
        }
    }

    public static final class SerializedForm implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class f2837a;
        public final String b;
        public final byte[] c;

        public SerializedForm(GeneratedMessageV3 generatedMessageV3) {
            this.f2837a = generatedMessageV3.getClass();
            this.b = generatedMessageV3.getClass().getName();
            this.c = generatedMessageV3.m();
        }

        public Object readResolve() throws ObjectStreamException, NoSuchFieldException, SecurityException {
            Class cls = this.f2837a;
            byte[] bArr = this.c;
            String str = this.b;
            try {
                try {
                    Field declaredField = cls.getDeclaredField("DEFAULT_INSTANCE");
                    declaredField.setAccessible(true);
                    return ((X1) declaredField.get(null)).q().mergeFrom(bArr).m();
                } catch (InvalidProtocolBufferException e) {
                    throw new RuntimeException("Unable to understand proto buffer", e);
                } catch (ClassNotFoundException e6) {
                    throw new RuntimeException("Unable to find proto buffer class: ".concat(str), e6);
                } catch (IllegalAccessException e9) {
                    throw new RuntimeException("Unable to call parsePartialFrom", e9);
                } catch (NoSuchFieldException e10) {
                    throw new RuntimeException("Unable to find defaultInstance in ".concat(str), e10);
                } catch (SecurityException e11) {
                    throw new RuntimeException("Unable to call defaultInstance in ".concat(str), e11);
                }
            } catch (InvalidProtocolBufferException e12) {
                throw new RuntimeException("Unable to understand proto buffer", e12);
            } catch (ClassNotFoundException e13) {
                throw new RuntimeException("Unable to find proto buffer class: ".concat(str), e13);
            } catch (IllegalAccessException e14) {
                throw new RuntimeException("Unable to call parsePartialFrom", e14);
            } catch (NoSuchFieldException unused) {
                Field declaredField2 = cls.getDeclaredField("defaultInstance");
                declaredField2.setAccessible(true);
                return ((X1) declaredField2.get(null)).q().mergeFrom(bArr).m();
            } catch (SecurityException e15) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in ".concat(str), e15);
            }
        }
    }

    public static GeneratedMessageLite A(GeneratedMessageLite generatedMessageLite, AbstractC0972o abstractC0972o, R0 r02) throws InvalidProtocolBufferException {
        GeneratedMessageLite generatedMessageLiteY = generatedMessageLite.y();
        try {
            C0963l2 c0963l2 = C0963l2.c;
            c0963l2.getClass();
            InterfaceC0979p2 interfaceC0979p2A = c0963l2.a(generatedMessageLiteY.getClass());
            C0976p c0976p = abstractC0972o.b;
            if (c0976p == null) {
                c0976p = new C0976p(abstractC0972o);
            }
            interfaceC0979p2A.c(generatedMessageLiteY, c0976p, r02);
            interfaceC0979p2A.makeImmutable(generatedMessageLiteY);
            return generatedMessageLiteY;
        } catch (InvalidProtocolBufferException e) {
            if (e.f2842a) {
                throw new InvalidProtocolBufferException(e.getMessage(), e);
            }
            throw e;
        } catch (UninitializedMessageException e6) {
            throw e6.a();
        } catch (IOException e9) {
            if (e9.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e9.getCause());
            }
            throw new InvalidProtocolBufferException(e9.getMessage(), e9);
        } catch (RuntimeException e10) {
            if (e10.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e10.getCause());
            }
            throw e10;
        }
    }

    public static GeneratedMessageLite B(GeneratedMessageLite generatedMessageLite, byte[] bArr, int i, R0 r02) throws InvalidProtocolBufferException {
        GeneratedMessageLite generatedMessageLiteY = generatedMessageLite.y();
        try {
            C0963l2 c0963l2 = C0963l2.c;
            c0963l2.getClass();
            InterfaceC0979p2 interfaceC0979p2A = c0963l2.a(generatedMessageLiteY.getClass());
            interfaceC0979p2A.d(generatedMessageLiteY, bArr, 0, i, new C0948i(r02));
            interfaceC0979p2A.makeImmutable(generatedMessageLiteY);
            return generatedMessageLiteY;
        } catch (InvalidProtocolBufferException e) {
            if (e.f2842a) {
                throw new InvalidProtocolBufferException(e.getMessage(), e);
            }
            throw e;
        } catch (UninitializedMessageException e6) {
            throw e6.a();
        } catch (IOException e9) {
            if (e9.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e9.getCause());
            }
            throw new InvalidProtocolBufferException(e9.getMessage(), e9);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.g();
        }
    }

    public static void C(Class cls, GeneratedMessageLite generatedMessageLite) {
        generatedMessageLite.w();
        defaultInstanceMap.put(cls, generatedMessageLite);
    }

    public static void o(GeneratedMessageLite generatedMessageLite) throws InvalidProtocolBufferException {
        if (!u(generatedMessageLite, true)) {
            throw new UninitializedMessageException().a();
        }
    }

    public static GeneratedMessageLite s(Class cls) throws ClassNotFoundException {
        GeneratedMessageLite generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (generatedMessageLite != null) {
            return generatedMessageLite;
        }
        GeneratedMessageLite generatedMessageLite2 = (GeneratedMessageLite) ((GeneratedMessageLite) W2.b(cls)).r(MethodToInvoke.f);
        if (generatedMessageLite2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, generatedMessageLite2);
        return generatedMessageLite2;
    }

    public static Object t(Method method, GeneratedMessageLite generatedMessageLite, Object... objArr) {
        try {
            return method.invoke(generatedMessageLite, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean u(GeneratedMessageLite generatedMessageLite, boolean z10) {
        byte bByteValue = ((Byte) generatedMessageLite.r(MethodToInvoke.f2836a)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        C0963l2 c0963l2 = C0963l2.c;
        c0963l2.getClass();
        boolean zIsInitialized = c0963l2.a(generatedMessageLite.getClass()).isInitialized(generatedMessageLite);
        if (z10) {
            generatedMessageLite.r(MethodToInvoke.b);
        }
        return zIsInitialized;
    }

    public static InterfaceC0985r1 x(InterfaceC0985r1 interfaceC0985r1) {
        int size = interfaceC0985r1.size();
        return interfaceC0985r1.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static GeneratedMessageLite z(GeneratedMessageLite generatedMessageLite, ByteString byteString) throws InvalidProtocolBufferException {
        R0 r0A = R0.a();
        AbstractC0972o abstractC0972oJ = byteString.j();
        GeneratedMessageLite generatedMessageLiteA = A(generatedMessageLite, abstractC0972oJ, r0A);
        abstractC0972oJ.a(0);
        o(generatedMessageLiteA);
        o(generatedMessageLiteA);
        return generatedMessageLiteA;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) {
        C0963l2 c0963l2 = C0963l2.c;
        c0963l2.getClass();
        InterfaceC0979p2 interfaceC0979p2A = c0963l2.a(getClass());
        F1 f12 = c0980q.c;
        if (f12 == null) {
            f12 = new F1(c0980q);
        }
        interfaceC0979p2A.a(this, f12);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0963l2 c0963l2 = C0963l2.c;
        c0963l2.getClass();
        return c0963l2.a(getClass()).f(this, (GeneratedMessageLite) obj);
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return (GeneratedMessageLite) r(MethodToInvoke.f);
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        return i(null);
    }

    @Override // com.google.protobuf.AbstractC0932e
    public final int h() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public final int hashCode() {
        if (v()) {
            C0963l2 c0963l2 = C0963l2.c;
            c0963l2.getClass();
            return c0963l2.a(getClass()).e(this);
        }
        if (this.memoizedHashCode == 0) {
            C0963l2 c0963l22 = C0963l2.c;
            c0963l22.getClass();
            this.memoizedHashCode = c0963l22.a(getClass()).e(this);
        }
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.AbstractC0932e
    public final int i(InterfaceC0979p2 interfaceC0979p2) {
        int iB;
        int iB2;
        if (v()) {
            if (interfaceC0979p2 == null) {
                C0963l2 c0963l2 = C0963l2.c;
                c0963l2.getClass();
                iB2 = c0963l2.a(getClass()).b(this);
            } else {
                iB2 = interfaceC0979p2.b(this);
            }
            if (iB2 >= 0) {
                return iB2;
            }
            throw new IllegalStateException(B7.a.h(iB2, "serialized size must be non-negative, was "));
        }
        if (h() != Integer.MAX_VALUE) {
            return h();
        }
        if (interfaceC0979p2 == null) {
            C0963l2 c0963l22 = C0963l2.c;
            c0963l22.getClass();
            iB = c0963l22.a(getClass()).b(this);
        } else {
            iB = interfaceC0979p2.b(this);
        }
        l(iB);
        return iB;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        return u(this, true);
    }

    @Override // com.google.protobuf.AbstractC0932e
    public final void l(int i) {
        if (i < 0) {
            throw new IllegalStateException(B7.a.h(i, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return (Builder) r(MethodToInvoke.e);
    }

    public final Builder p() {
        return (Builder) r(MethodToInvoke.e);
    }

    public final Builder q(GeneratedMessageLite generatedMessageLite) {
        return p().mergeFrom(generatedMessageLite);
    }

    public abstract Object r(MethodToInvoke methodToInvoke);

    @Override // com.google.protobuf.X1
    public final W1 toBuilder() {
        return ((Builder) r(MethodToInvoke.e)).mergeFrom(this);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = Z1.f2905a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        Z1.c(this, sb, 0);
        return sb.toString();
    }

    public final boolean v() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }

    public final void w() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final GeneratedMessageLite y() {
        return (GeneratedMessageLite) r(MethodToInvoke.d);
    }
}
