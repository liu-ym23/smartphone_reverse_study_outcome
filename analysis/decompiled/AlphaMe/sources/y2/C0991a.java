package y2;

/* renamed from: y2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0991a {

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f16327d;

    /* renamed from: a, reason: collision with root package name */
    public final d[] f16328a = new d[6];

    /* renamed from: b, reason: collision with root package name */
    public final g[] f16329b = {new g(), new g(), new g(), new g(), new g(), new g(), new g(), new g()};

    /* renamed from: c, reason: collision with root package name */
    public final float[] f16330c = new float[24];

    static {
        g[] gVarArr = {new g(-1.0f, -1.0f, -1.0f), new g(1.0f, -1.0f, -1.0f), new g(1.0f, 1.0f, -1.0f), new g(-1.0f, 1.0f, -1.0f), new g(-1.0f, -1.0f, 1.0f), new g(1.0f, -1.0f, 1.0f), new g(1.0f, 1.0f, 1.0f), new g(-1.0f, 1.0f, 1.0f)};
        f16327d = new float[24];
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            g gVar = gVarArr[i5];
            float[] fArr = f16327d;
            fArr[i4] = gVar.f16346a;
            int i6 = i4 + 2;
            fArr[i4 + 1] = gVar.f16347b;
            i4 += 3;
            fArr[i6] = gVar.f16348c;
        }
    }

    public C0991a() {
        for (int i4 = 0; i4 < 6; i4++) {
            this.f16328a[i4] = new d(new g());
        }
    }
}
