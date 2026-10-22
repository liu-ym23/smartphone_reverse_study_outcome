package h4;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final m f4149b = new m(new s9.d(27));

    /* renamed from: c, reason: collision with root package name */
    public static final m f4150c;

    /* renamed from: a, reason: collision with root package name */
    public final l f4151a;

    static {
        boolean z4 = false;
        f4150c = new m(new n(1, z4));
        new m(new n(3, z4));
        new m(new n(2, z4));
        new m(new s9.d(28));
        new m(new n(0, z4));
        new m(new s9.d(29));
    }

    public m(o oVar) {
        if (x3.a.a()) {
            this.f4151a = new l(oVar, 2);
        } else if ("The Android Project".equals(System.getProperty("java.vendor"))) {
            this.f4151a = new l(oVar, 0);
        } else {
            this.f4151a = new l(oVar, 1);
        }
    }
}
