package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class D implements a0 {

    /* renamed from: b, reason: collision with root package name */
    public static final J f13435b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final J f13436a;

    public static class a implements J {
        @Override // androidx.datastore.preferences.protobuf.J
        public boolean isSupported(Class<?> cls) {
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.J
        public I messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    public static class b implements J {

        /* renamed from: a, reason: collision with root package name */
        public J[] f13437a;

        public b(J... jArr) {
            this.f13437a = jArr;
        }

        @Override // androidx.datastore.preferences.protobuf.J
        public boolean isSupported(Class<?> cls) {
            for (J j10 : this.f13437a) {
                if (j10.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.J
        public I messageInfoFor(Class<?> cls) {
            for (J j10 : this.f13437a) {
                if (j10.isSupported(cls)) {
                    return j10.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    public D() {
        this(a());
    }

    public static J a() {
        return new b(C1357u.a(), b());
    }

    public static J b() {
        try {
            return (J) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f13435b;
        }
    }

    public static boolean c(I i10) {
        return i10.getSyntax() == ProtoSyntax.PROTO2;
    }

    public static <T> Z<T> d(Class<T> cls, I i10) {
        return GeneratedMessageLite.class.isAssignableFrom(cls) ? c(i10) ? N.G(cls, i10, S.b(), B.b(), b0.M(), C1354q.b(), H.b()) : N.G(cls, i10, S.b(), B.b(), b0.M(), null, H.b()) : c(i10) ? N.G(cls, i10, S.a(), B.a(), b0.H(), C1354q.a(), H.a()) : N.G(cls, i10, S.a(), B.a(), b0.I(), null, H.a());
    }

    @Override // androidx.datastore.preferences.protobuf.a0
    public <T> Z<T> createSchema(Class<T> cls) {
        b0.J(cls);
        I iMessageInfoFor = this.f13436a.messageInfoFor(cls);
        return iMessageInfoFor.isMessageSetWireFormat() ? GeneratedMessageLite.class.isAssignableFrom(cls) ? O.e(b0.M(), C1354q.b(), iMessageInfoFor.getDefaultInstance()) : O.e(b0.H(), C1354q.a(), iMessageInfoFor.getDefaultInstance()) : d(cls, iMessageInfoFor);
    }

    public D(J j10) {
        this.f13436a = (J) C1359w.b(j10, "messageInfoFactory");
    }
}
