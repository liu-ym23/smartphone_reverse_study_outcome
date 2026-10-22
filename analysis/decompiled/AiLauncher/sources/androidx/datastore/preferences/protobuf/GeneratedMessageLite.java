package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.a;
import androidx.datastore.preferences.protobuf.AbstractC1338a;
import androidx.datastore.preferences.protobuf.C1355s;
import androidx.datastore.preferences.protobuf.C1359w;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.a;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC1338a<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected g0 unknownFields = g0.e();
    protected int memoizedSerializedSize = -1;

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC1338a.AbstractC0164a<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        public final MessageType f13447a;

        /* renamed from: b, reason: collision with root package name */
        public MessageType f13448b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f13449c = false;

        public a(MessageType messagetype) {
            this.f13447a = messagetype;
            this.f13448b = (MessageType) messagetype.m(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        @Override // androidx.datastore.preferences.protobuf.K.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public final MessageType build() {
            MessageType messagetype = (MessageType) buildPartial();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw AbstractC1338a.AbstractC0164a.i(messagetype);
        }

        @Override // androidx.datastore.preferences.protobuf.K.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public MessageType buildPartial() {
            if (this.f13449c) {
                return this.f13448b;
            }
            this.f13448b.u();
            this.f13449c = true;
            return this.f13448b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public BuilderType clone() {
            a.C0163a c0163a = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            c0163a.r(buildPartial());
            return c0163a;
        }

        public void o() {
            if (this.f13449c) {
                MessageType messagetype = (MessageType) this.f13448b.m(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                s(messagetype, this.f13448b);
                this.f13448b = messagetype;
                this.f13449c = false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.L
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public MessageType getDefaultInstanceForType() {
            return this.f13447a;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1338a.AbstractC0164a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public BuilderType g(MessageType messagetype) {
            return (BuilderType) r(messagetype);
        }

        public BuilderType r(MessageType messagetype) {
            o();
            s(this.f13448b, messagetype);
            return this;
        }

        public final void s(MessageType messagetype, MessageType messagetype2) {
            V.a().e(messagetype).mergeFrom(messagetype, messagetype2);
        }
    }

    public static class b<T extends GeneratedMessageLite<T, ?>> extends AbstractC1339b<T> {

        /* renamed from: b, reason: collision with root package name */
        public final T f13450b;

        public b(T t10) {
            this.f13450b = t10;
        }

        @Override // androidx.datastore.preferences.protobuf.T
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public T b(AbstractC1345h abstractC1345h, C1351n c1351n) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.z(this.f13450b, abstractC1345h, c1351n);
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements L {
        protected C1355s<d> extensions = C1355s.h();

        public C1355s<d> C() {
            if (this.extensions.o()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.L
        public /* bridge */ /* synthetic */ K getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.K
        public /* bridge */ /* synthetic */ K.a newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.K
        public /* bridge */ /* synthetic */ K.a toBuilder() {
            return super.toBuilder();
        }
    }

    public static final class d implements C1355s.b<d> {

        /* renamed from: a, reason: collision with root package name */
        public final int f13451a;

        /* renamed from: b, reason: collision with root package name */
        public final WireFormat.FieldType f13452b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f13453c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f13454d;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.f13451a - dVar.f13451a;
        }

        public C1359w.d<?> b() {
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.C1355s.b
        public K.a d(K.a aVar, K k10) {
            return ((a) aVar).r((GeneratedMessageLite) k10);
        }

        @Override // androidx.datastore.preferences.protobuf.C1355s.b
        public WireFormat.JavaType getLiteJavaType() {
            return this.f13452b.getJavaType();
        }

        @Override // androidx.datastore.preferences.protobuf.C1355s.b
        public WireFormat.FieldType getLiteType() {
            return this.f13452b;
        }

        @Override // androidx.datastore.preferences.protobuf.C1355s.b
        public int getNumber() {
            return this.f13451a;
        }

        @Override // androidx.datastore.preferences.protobuf.C1355s.b
        public boolean isPacked() {
            return this.f13454d;
        }

        @Override // androidx.datastore.preferences.protobuf.C1355s.b
        public boolean isRepeated() {
            return this.f13453c;
        }
    }

    public static class e<ContainingType extends K, Type> extends AbstractC1349l<ContainingType, Type> {

        /* renamed from: a, reason: collision with root package name */
        public final K f13455a;

        /* renamed from: b, reason: collision with root package name */
        public final d f13456b;

        public WireFormat.FieldType a() {
            return this.f13456b.getLiteType();
        }

        public K b() {
            return this.f13455a;
        }

        public int c() {
            return this.f13456b.getNumber();
        }

        public boolean d() {
            return this.f13456b.f13453c;
        }
    }

    public static <T extends GeneratedMessageLite<?, ?>> void A(Class<T> cls, T t10) {
        defaultInstanceMap.put(cls, t10);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T j(T t10) throws InvalidProtocolBufferException {
        if (t10 == null || t10.isInitialized()) {
            return t10;
        }
        throw t10.f().a().i(t10);
    }

    public static <E> C1359w.i<E> p() {
        return W.e();
    }

    public static <T extends GeneratedMessageLite<?, ?>> T q(Class<T> cls) throws ClassNotFoundException {
        T t10 = (T) defaultInstanceMap.get(cls);
        if (t10 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t10 = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) ((GeneratedMessageLite) j0.i(cls)).getDefaultInstanceForType();
        if (t11 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, t11);
        return t11;
    }

    public static Object s(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
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

    public static final <T extends GeneratedMessageLite<T, ?>> boolean t(T t10, boolean z10) {
        byte bByteValue = ((Byte) t10.m(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zIsInitialized = V.a().e(t10).isInitialized(t10);
        if (z10) {
            t10.n(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, zIsInitialized ? t10 : null);
        }
        return zIsInitialized;
    }

    public static <E> C1359w.i<E> v(C1359w.i<E> iVar) {
        int size = iVar.size();
        return iVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static Object x(K k10, String str, Object[] objArr) {
        return new X(k10, str, objArr);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T y(T t10, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) j(z(t10, AbstractC1345h.f(inputStream), C1351n.b()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T z(T t10, AbstractC1345h abstractC1345h, C1351n c1351n) throws InvalidProtocolBufferException {
        T t11 = (T) t10.m(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Z zE = V.a().e(t11);
            zE.a(t11, C1346i.h(abstractC1345h), c1351n);
            zE.makeImmutable(t11);
            return t11;
        } catch (IOException e10) {
            if (e10.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e10.getCause());
            }
            throw new InvalidProtocolBufferException(e10.getMessage()).i(t11);
        } catch (RuntimeException e11) {
            if (e11.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e11.getCause());
            }
            throw e11;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.K
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) m(MethodToInvoke.NEW_BUILDER);
        buildertype.r(this);
        return buildertype;
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        V.a().e(this).b(this, C1347j.g(codedOutputStream));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1338a
    public int c() {
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getDefaultInstanceForType().getClass().isInstance(obj)) {
            return V.a().e(this).equals(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1338a
    public void g(int i10) {
        this.memoizedSerializedSize = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public final T<MessageType> getParserForType() {
        return (T) m(MethodToInvoke.GET_PARSER);
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = V.a().e(this).getSerializedSize(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = V.a().e(this).hashCode(this);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    public Object i() throws Exception {
        return m(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final boolean isInitialized() {
        return t(this, true);
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType k() {
        return (BuilderType) m(MethodToInvoke.NEW_BUILDER);
    }

    public Object m(MethodToInvoke methodToInvoke) {
        return o(methodToInvoke, null, null);
    }

    public Object n(MethodToInvoke methodToInvoke, Object obj) {
        return o(methodToInvoke, obj, null);
    }

    public abstract Object o(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    @Override // androidx.datastore.preferences.protobuf.L
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) m(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public String toString() {
        return M.e(this, super.toString());
    }

    public void u() {
        V.a().e(this).makeImmutable(this);
    }

    @Override // androidx.datastore.preferences.protobuf.K
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final BuilderType newBuilderForType() {
        return (BuilderType) m(MethodToInvoke.NEW_BUILDER);
    }
}
