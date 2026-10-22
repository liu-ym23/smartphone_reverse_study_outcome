package r;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public float f10313a;

    /* renamed from: b, reason: collision with root package name */
    public float f10314b;

    public k0 a(float f5) {
        double dB = b(f5);
        double d7 = m0.f10318a;
        double d10 = d7 - 1.0d;
        float fExp = (float) (Math.exp((d7 / d10) * dB) * this.f10313a * this.f10314b);
        long jExp = (long) (Math.exp(dB / d10) * 1000.0d);
        k0 k0Var = new k0();
        k0Var.f10309a = f5;
        k0Var.f10310b = fExp;
        k0Var.f10311c = jExp;
        VarHandle.storeStoreFence();
        return k0Var;
    }

    public double b(float f5) {
        float[] fArr = b.f10245a;
        return Math.log((Math.abs(f5) * 0.35f) / (this.f10313a * this.f10314b));
    }
}
