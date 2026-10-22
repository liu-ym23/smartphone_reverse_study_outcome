package androidx.datastore.preferences.protobuf;

import N.h;
import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.AbstractC0481a;
import androidx.datastore.preferences.protobuf.AbstractC0504y;
import androidx.datastore.preferences.protobuf.AbstractC0504y.a;
import androidx.datastore.preferences.protobuf.C0500u;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.u0;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.datastore.preferences.protobuf.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0504y<MessageType extends AbstractC0504y<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC0481a<MessageType, BuilderType> {
    private static Map<Object, AbstractC0504y<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected p0 unknownFields = p0.e();
    protected int memoizedSerializedSize = -1;

    /* renamed from: androidx.datastore.preferences.protobuf.y$a */
    public static abstract class a<MessageType extends AbstractC0504y<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC0481a.AbstractC0126a<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        private final MessageType f10263a;

        /* renamed from: b, reason: collision with root package name */
        protected MessageType f10264b;

        /* renamed from: c, reason: collision with root package name */
        protected boolean f10265c = false;

        protected a(MessageType messagetype) {
            this.f10263a = messagetype;
            this.f10264b = (MessageType) messagetype.u(f.NEW_MUTABLE_INSTANCE);
        }

        private void A(MessageType messagetype, MessageType messagetype2) {
            d0.a().e(messagetype).a(messagetype, messagetype2);
        }

        @Override // androidx.datastore.preferences.protobuf.S.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public final MessageType build() {
            MessageType messagetype = (MessageType) r();
            if (messagetype.k()) {
                return messagetype;
            }
            throw AbstractC0481a.AbstractC0126a.s(messagetype);
        }

        @Override // androidx.datastore.preferences.protobuf.S.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public MessageType r() {
            if (this.f10265c) {
                return this.f10264b;
            }
            this.f10264b.C();
            this.f10265c = true;
            return this.f10264b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public BuilderType clone() {
            h.a aVar = (BuilderType) b().i();
            aVar.z(r());
            return aVar;
        }

        protected void w() {
            if (this.f10265c) {
                MessageType messagetype = (MessageType) this.f10264b.u(f.NEW_MUTABLE_INSTANCE);
                A(messagetype, this.f10264b);
                this.f10264b = messagetype;
                this.f10265c = false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.T
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public MessageType b() {
            return this.f10263a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.datastore.preferences.protobuf.AbstractC0481a.AbstractC0126a
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public BuilderType p(MessageType messagetype) {
            return (BuilderType) z(messagetype);
        }

        public BuilderType z(MessageType messagetype) {
            w();
            A(this.f10264b, messagetype);
            return this;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.y$b */
    protected static class b<T extends AbstractC0504y<T, ?>> extends AbstractC0482b<T> {

        /* renamed from: b, reason: collision with root package name */
        private final T f10266b;

        public b(T t5) {
            this.f10266b = t5;
        }

        @Override // androidx.datastore.preferences.protobuf.a0
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public T b(AbstractC0489i abstractC0489i, C0496p c0496p) {
            return (T) AbstractC0504y.H(this.f10266b, abstractC0489i, c0496p);
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.y$c */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends AbstractC0504y<MessageType, BuilderType> implements T {
        protected C0500u<d> extensions = C0500u.h();

        C0500u<d> K() {
            if (this.extensions.o()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0504y, androidx.datastore.preferences.protobuf.T
        public /* bridge */ /* synthetic */ S b() {
            return super.b();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0504y, androidx.datastore.preferences.protobuf.S
        public /* bridge */ /* synthetic */ S.a d() {
            return super.d();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0504y, androidx.datastore.preferences.protobuf.S
        public /* bridge */ /* synthetic */ S.a i() {
            return super.i();
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.y$d */
    static final class d implements C0500u.b<d> {

        /* renamed from: a, reason: collision with root package name */
        final int f10267a;

        /* renamed from: b, reason: collision with root package name */
        final u0.b f10268b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f10269c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f10270d;

        @Override // androidx.datastore.preferences.protobuf.C0500u.b
        public u0.c A() {
            return this.f10268b.b();
        }

        @Override // androidx.datastore.preferences.protobuf.C0500u.b
        public boolean B() {
            return this.f10270d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.C0500u.b
        public S.a D(S.a aVar, S s5) {
            return ((a) aVar).z((AbstractC0504y) s5);
        }

        @Override // androidx.datastore.preferences.protobuf.C0500u.b
        public int a() {
            return this.f10267a;
        }

        @Override // java.lang.Comparable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.f10267a - dVar.f10267a;
        }

        @Override // androidx.datastore.preferences.protobuf.C0500u.b
        public boolean c() {
            return this.f10269c;
        }

        public A.d<?> d() {
            return null;
        }

        @Override // androidx.datastore.preferences.protobuf.C0500u.b
        public u0.b f() {
            return this.f10268b;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.y$e */
    public static class e<ContainingType extends S, Type> extends AbstractC0494n<ContainingType, Type> {

        /* renamed from: a, reason: collision with root package name */
        final S f10271a;

        /* renamed from: b, reason: collision with root package name */
        final d f10272b;

        public u0.b a() {
            return this.f10272b.f();
        }

        public S b() {
            return this.f10271a;
        }

        public int c() {
            return this.f10272b.a();
        }

        public boolean d() {
            return this.f10272b.f10269c;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.y$f */
    public enum f {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    static Object A(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e6);
        } catch (InvocationTargetException e7) {
            Throwable cause = e7.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends AbstractC0504y<T, ?>> boolean B(T t5, boolean z5) {
        byte bByteValue = ((Byte) t5.u(f.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zD = d0.a().e(t5).d(t5);
        if (z5) {
            t5.v(f.SET_MEMOIZED_IS_INITIALIZED, zD ? t5 : null);
        }
        return zD;
    }

    protected static <E> A.i<E> D(A.i<E> iVar) {
        int size = iVar.size();
        return iVar.d(size == 0 ? 10 : size * 2);
    }

    protected static Object F(S s5, String str, Object[] objArr) {
        return new f0(s5, str, objArr);
    }

    protected static <T extends AbstractC0504y<T, ?>> T G(T t5, InputStream inputStream) {
        return (T) s(H(t5, AbstractC0489i.f(inputStream), C0496p.b()));
    }

    static <T extends AbstractC0504y<T, ?>> T H(T t5, AbstractC0489i abstractC0489i, C0496p c0496p) throws B {
        T t6 = (T) t5.u(f.NEW_MUTABLE_INSTANCE);
        try {
            h0 h0VarE = d0.a().e(t6);
            h0VarE.b(t6, C0490j.Q(abstractC0489i), c0496p);
            h0VarE.c(t6);
            return t6;
        } catch (IOException e6) {
            if (e6.getCause() instanceof B) {
                throw ((B) e6.getCause());
            }
            throw new B(e6.getMessage()).i(t6);
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof B) {
                throw ((B) e7.getCause());
            }
            throw e7;
        }
    }

    protected static <T extends AbstractC0504y<?, ?>> void I(Class<T> cls, T t5) {
        defaultInstanceMap.put(cls, t5);
    }

    private static <T extends AbstractC0504y<T, ?>> T s(T t5) throws B {
        if (t5 == null || t5.k()) {
            return t5;
        }
        throw t5.n().a().i(t5);
    }

    protected static <E> A.i<E> x() {
        return e0.f();
    }

    static <T extends AbstractC0504y<?, ?>> T y(Class<T> cls) throws ClassNotFoundException {
        T t5 = (T) defaultInstanceMap.get(cls);
        if (t5 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t5 = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e6) {
                throw new IllegalStateException("Class initialization cannot fail.", e6);
            }
        }
        if (t5 != null) {
            return t5;
        }
        T t6 = (T) ((AbstractC0504y) s0.i(cls)).b();
        if (t6 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, t6);
        return t6;
    }

    protected void C() {
        d0.a().e(this).c(this);
    }

    @Override // androidx.datastore.preferences.protobuf.S
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public final BuilderType i() {
        return (BuilderType) u(f.NEW_BUILDER);
    }

    @Override // androidx.datastore.preferences.protobuf.S
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public final BuilderType d() {
        BuilderType buildertype = (BuilderType) u(f.NEW_BUILDER);
        buildertype.z(this);
        return buildertype;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0481a
    int c() {
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (b().getClass().isInstance(obj)) {
            return d0.a().e(this).f(this, (AbstractC0504y) obj);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public int g() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = d0.a().e(this).g(this);
        }
        return this.memoizedSerializedSize;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public void h(AbstractC0491k abstractC0491k) {
        d0.a().e(this).e(this, C0492l.P(abstractC0491k));
    }

    public int hashCode() {
        int i5 = this.memoizedHashCode;
        if (i5 != 0) {
            return i5;
        }
        int i6 = d0.a().e(this).i(this);
        this.memoizedHashCode = i6;
        return i6;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final a0<MessageType> j() {
        return (a0) u(f.GET_PARSER);
    }

    @Override // androidx.datastore.preferences.protobuf.T
    public final boolean k() {
        return B(this, true);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0481a
    void o(int i5) {
        this.memoizedSerializedSize = i5;
    }

    Object q() {
        return u(f.BUILD_MESSAGE_INFO);
    }

    protected final <MessageType extends AbstractC0504y<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType t() {
        return (BuilderType) u(f.NEW_BUILDER);
    }

    public String toString() {
        return U.e(this, super.toString());
    }

    protected Object u(f fVar) {
        return w(fVar, null, null);
    }

    protected Object v(f fVar, Object obj) {
        return w(fVar, obj, null);
    }

    protected abstract Object w(f fVar, Object obj, Object obj2);

    @Override // androidx.datastore.preferences.protobuf.T
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public final MessageType b() {
        return (MessageType) u(f.GET_DEFAULT_INSTANCE);
    }
}
