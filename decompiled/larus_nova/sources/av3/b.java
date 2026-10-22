package av3;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static av3.a f16366a;

    public static class a implements av3.a {
        public a() {
        }

        @Override // av3.a
        public final void a() {
        }

        @Override // av3.a
        public final void b() {
        }

        @Override // av3.a
        public final void d() {
        }

        @Override // av3.a
        public void e(String r100, String r101) {
        }

        @Override // av3.a
        public void e(String r100, String r101, Throwable r102) {
        }

        @Override // av3.a
        public final void i() {
        }
    }

    static {
        f16366a = new a();
    }

    public static void a(String r100, String r101) {
        av3.a r102 = f16366a;
        if (r102 == null) goto L6;
        r102.d();
        return;
    }

    public static void b(String r100, String r101) {
        av3.a r102 = f16366a;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    public static void d(String r100, String r101) {
        av3.a r102 = f16366a;
        if (r102 == null) goto L6;
        r102.i();
        return;
    }

    public static void c(String r100, String r101, Throwable r102) {
        av3.a r103 = f16366a;
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }
}
