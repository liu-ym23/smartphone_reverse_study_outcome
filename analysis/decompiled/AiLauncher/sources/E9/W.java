package E9;

/* loaded from: classes5.dex */
public interface W {

    /* renamed from: a, reason: collision with root package name */
    public static final W f2444a = new a();

    public static class a implements W {
        public static /* synthetic */ void d(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // E9.W
        public X b() {
            X x10 = X.f2445a;
            if (x10 == null) {
                d(0);
            }
            return x10;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    X b();
}
