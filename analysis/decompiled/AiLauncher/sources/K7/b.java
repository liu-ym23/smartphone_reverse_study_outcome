package K7;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public long f4102a;

    /* renamed from: b, reason: collision with root package name */
    public String f4103b;

    /* renamed from: c, reason: collision with root package name */
    public String f4104c;

    /* renamed from: d, reason: collision with root package name */
    public int f4105d;

    public b(String str) {
        this.f4104c = str;
    }

    public boolean a() {
        return this.f4102a > System.currentTimeMillis();
    }

    public void b() {
        this.f4102a = 0L;
    }

    public void c(int i10) {
        this.f4105d = i10;
    }

    public void d(long j10) {
        this.f4102a = j10;
    }

    public void e(String str) {
        this.f4103b = str;
    }
}
