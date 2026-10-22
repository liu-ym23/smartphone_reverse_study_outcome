package Cc;

/* loaded from: classes5.dex */
public class b implements j {

    /* renamed from: a, reason: collision with root package name */
    public final float f1965a;

    /* renamed from: b, reason: collision with root package name */
    public final float f1966b;

    public b(float f10, int i10, int i11) {
        this(f10, i10, i11, 10.0f);
    }

    @Override // Cc.j
    public float a() {
        return this.f1965a;
    }

    public String toString() {
        return "BasicStroke{width=" + this.f1965a + ", miterLimit=" + this.f1966b + '}';
    }

    public b(float f10, int i10, int i11, float f11) {
        this.f1965a = f10;
        this.f1966b = f11;
    }
}
