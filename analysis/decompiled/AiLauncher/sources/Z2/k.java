package Z2;

/* loaded from: classes2.dex */
public class k extends e {

    /* renamed from: a, reason: collision with root package name */
    public float f7182a = -1.0f;

    @Override // Z2.e
    public void a(n nVar, float f10, float f11, float f12) {
        float f13 = f12 * f11;
        nVar.o(0.0f, f13, 180.0f, 180.0f - f10);
        float f14 = f13 * 2.0f;
        nVar.a(0.0f, 0.0f, f14, f14, 180.0f, f10);
    }
}
