package s9;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f24547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f24548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q9.a f24550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f24551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f24552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f24553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f24554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f24555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f24556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f24557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f24558l;

    public b(String r10, int r11) {
        this.f24547a = r10;
        this.f24556j = r11;
        this.f24555i = 0;
    }

    public long a() {
        return this.f24553g;
    }

    public float b() {
        return this.f24552f;
    }

    public String c() {
        return this.f24548b;
    }

    public float d() {
        return this.f24551e;
    }

    public int e() {
        return this.f24556j;
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L4;
        return false;
    L4:
        if ((r10 instanceof b) == false) goto L11;
        String r11 = ((b) r10).g();
        if (this.f24547a.equals(r11) == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public int f() {
        return this.f24555i;
    }

    public String g() {
        return this.f24547a;
    }

    public boolean h() {
        if (e() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void i(long r10) {
        this.f24553g = r10;
    }

    public void j(long r10) {
        this.f24557k = r10;
    }

    public void k(int r10) {
        this.f24558l = r10;
    }

    public void l(q9.a r10) {
        this.f24550d = r10;
    }

    public void m(float r10) {
        this.f24552f = r10;
    }

    public void n(String r10) {
        this.f24548b = r10;
        this.f24549c = true;
    }

    public void o(float r10) {
        this.f24551e = r10;
    }

    public void p(int r10) {
        this.f24555i = r10;
    }

    public void q(int r10) {
        this.f24554h = r10;
    }
}
