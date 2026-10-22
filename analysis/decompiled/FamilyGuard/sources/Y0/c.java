package Y0;

/* loaded from: classes.dex */
public abstract class c {

    private static class b extends c {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f6398a;

        b() {
            super();
        }

        @Override // Y0.c
        public void b(boolean z5) {
            this.f6398a = z5;
        }

        @Override // Y0.c
        public void c() {
            if (this.f6398a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static c a() {
        return new b();
    }

    abstract void b(boolean z5);

    public abstract void c();

    private c() {
    }
}
