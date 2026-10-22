package g0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f2880a;

    /* renamed from: b, reason: collision with root package name */
    public int f2881b;

    /* renamed from: c, reason: collision with root package name */
    public float f2882c;
    public float d;

    /* renamed from: e, reason: collision with root package name */
    public long f2883e;

    /* renamed from: f, reason: collision with root package name */
    public long f2884f;

    /* renamed from: g, reason: collision with root package name */
    public long f2885g;

    /* renamed from: h, reason: collision with root package name */
    public float f2886h;

    /* renamed from: i, reason: collision with root package name */
    public int f2887i;

    public final float a(long j4) {
        if (j4 < this.f2883e) {
            return 0.0f;
        }
        long j8 = this.f2885g;
        if (j8 < 0 || j4 < j8) {
            return c.b((j4 - r0) / this.f2880a, 0.0f, 1.0f) * 0.5f;
        }
        float f3 = this.f2886h;
        return (c.b((j4 - j8) / this.f2887i, 0.0f, 1.0f) * f3) + (1.0f - f3);
    }
}
