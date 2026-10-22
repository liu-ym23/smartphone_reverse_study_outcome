package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class J implements i0 {

    /* renamed from: b, reason: collision with root package name */
    private static final Q f9942b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Q f9943a;

    static class a implements Q {
        a() {
        }

        @Override // androidx.datastore.preferences.protobuf.Q
        public P a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.datastore.preferences.protobuf.Q
        public boolean b(Class<?> cls) {
            return false;
        }
    }

    private static class b implements Q {

        /* renamed from: a, reason: collision with root package name */
        private Q[] f9944a;

        b(Q... qArr) {
            this.f9944a = qArr;
        }

        @Override // androidx.datastore.preferences.protobuf.Q
        public P a(Class<?> cls) {
            for (Q q5 : this.f9944a) {
                if (q5.b(cls)) {
                    return q5.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // androidx.datastore.preferences.protobuf.Q
        public boolean b(Class<?> cls) {
            for (Q q5 : this.f9944a) {
                if (q5.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public J() {
        this(b());
    }

    private static Q b() {
        return new b(C0503x.c(), c());
    }

    private static Q c() {
        try {
            return (Q) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f9942b;
        }
    }

    private static boolean d(P p5) {
        return p5.c() == c0.PROTO2;
    }

    private static <T> h0<T> e(Class<T> cls, P p5) {
        return AbstractC0504y.class.isAssignableFrom(cls) ? d(p5) ? V.N(cls, p5, Z.b(), H.b(), j0.M(), C0498s.b(), O.b()) : V.N(cls, p5, Z.b(), H.b(), j0.M(), null, O.b()) : d(p5) ? V.N(cls, p5, Z.a(), H.a(), j0.H(), C0498s.a(), O.a()) : V.N(cls, p5, Z.a(), H.a(), j0.I(), null, O.a());
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public <T> h0<T> a(Class<T> cls) {
        j0.J(cls);
        P pA = this.f9943a.a(cls);
        return pA.a() ? AbstractC0504y.class.isAssignableFrom(cls) ? W.l(j0.M(), C0498s.b(), pA.b()) : W.l(j0.H(), C0498s.a(), pA.b()) : e(cls, pA);
    }

    private J(Q q5) {
        this.f9943a = (Q) A.b(q5, "messageInfoFactory");
    }
}
