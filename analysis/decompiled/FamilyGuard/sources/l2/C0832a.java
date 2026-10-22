package l2;

/* renamed from: l2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0832a {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f18156h = {1, 2};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f18157i = {3};

    /* renamed from: a, reason: collision with root package name */
    public Long f18158a;

    /* renamed from: b, reason: collision with root package name */
    public int f18159b;

    /* renamed from: c, reason: collision with root package name */
    public int f18160c;

    /* renamed from: d, reason: collision with root package name */
    public String f18161d;

    /* renamed from: e, reason: collision with root package name */
    public String f18162e;

    /* renamed from: f, reason: collision with root package name */
    public int f18163f;

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public String f18164g;

    public C0832a(int i5, int i6) {
        this.f18159b = i5;
        this.f18160c = i6;
        if (i5 == 2) {
            this.f18163f = 3;
        }
    }

    public String toString() {
        return "Account{id=" + this.f18158a + ", type=" + this.f18159b + ", status=" + this.f18160c + ", phone='" + this.f18161d + "', imei='" + this.f18162e + "', imsi='" + this.f18164g + "'}";
    }
}
