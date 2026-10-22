package N2;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    long f4224a;

    /* renamed from: b, reason: collision with root package name */
    String f4225b;

    /* renamed from: c, reason: collision with root package name */
    String f4226c;

    /* renamed from: d, reason: collision with root package name */
    int f4227d;

    public a(String str) {
        this.f4226c = str;
    }

    public boolean a() {
        return this.f4224a > System.currentTimeMillis();
    }

    public void b() {
        this.f4224a = 0L;
    }

    public void c(int i5) {
        this.f4227d = i5;
    }

    public void d(long j5) {
        this.f4224a = j5;
    }

    public void e(String str) {
        this.f4225b = str;
    }
}
