package rc;

/* loaded from: classes5.dex */
public class J0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public int f39107d;

    /* renamed from: e, reason: collision with root package name */
    public int f39108e;

    /* renamed from: f, reason: collision with root package name */
    public int f39109f;

    /* renamed from: g, reason: collision with root package name */
    public float f39110g;

    /* renamed from: h, reason: collision with root package name */
    public float f39111h;

    /* renamed from: i, reason: collision with root package name */
    public float f39112i;

    public J0(int i10, float f10, int i11, float f11, int i12, float f12) {
        this.f39107d = i10;
        this.f39108e = i11;
        this.f39109f = i12;
        this.f39110g = f10;
        this.f39111h = f11;
        this.f39112i = f12;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        return new S(this.f39111h * R0.j(this.f39108e, y02), this.f39110g * R0.j(this.f39107d, y02), this.f39112i * R0.j(this.f39109f, y02));
    }
}
