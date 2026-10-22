package t1;

/* renamed from: t1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1113f extends C1112e {

    /* renamed from: a, reason: collision with root package name */
    float f22321a = -1.0f;

    @Override // t1.C1112e
    public void a(n nVar, float f5, float f6, float f7) {
        float f8 = f7 * f6;
        nVar.o(0.0f, f8, 180.0f, 180.0f - f5);
        double d6 = f8;
        nVar.m((float) (Math.sin(Math.toRadians(f5)) * d6), (float) (Math.sin(Math.toRadians(90.0f - f5)) * d6));
    }
}
