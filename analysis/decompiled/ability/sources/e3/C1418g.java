package e3;

/* renamed from: e3.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1418g extends C1417f {
    public final float c;

    public C1418g(float f) {
        super(0);
        this.c = f - 0.001f;
    }

    @Override // e3.C1417f
    public final void n(float f, float f7, float f9, z zVar) {
        double d = this.c;
        float fSqrt = (float) ((Math.sqrt(2.0d) * d) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(d, 2.0d) - Math.pow(fSqrt, 2.0d));
        zVar.d(f7 - fSqrt, ((float) (-((Math.sqrt(2.0d) * d) - d))) + fSqrt2, 270.0f, 0.0f);
        zVar.c(f7, (float) (-((Math.sqrt(2.0d) * d) - d)));
        zVar.c(f7 + fSqrt, ((float) (-((Math.sqrt(2.0d) * d) - d))) + fSqrt2);
    }
}
