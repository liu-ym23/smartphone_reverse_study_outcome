package Z2;

/* loaded from: classes2.dex */
public class f extends e {

    /* renamed from: a, reason: collision with root package name */
    public float f7119a = -1.0f;

    @Override // Z2.e
    public void a(n nVar, float f10, float f11, float f12) {
        float f13 = f12 * f11;
        nVar.o(0.0f, f13, 180.0f, 180.0f - f10);
        double d10 = f13;
        nVar.m((float) (Math.sin(Math.toRadians(f10)) * d10), (float) (Math.sin(Math.toRadians(90.0f - f10)) * d10));
    }
}
