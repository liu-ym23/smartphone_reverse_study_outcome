package e3;

/* loaded from: classes3.dex */
public final class n extends com.stepos.statsrpk.d {
    @Override // com.stepos.statsrpk.d
    public final void z(z zVar, float f, float f7) {
        float f9 = f7 * f;
        zVar.d(0.0f, f9, 180.0f, 90.0f);
        float f10 = f9 * 2.0f;
        v vVar = new v(0.0f, 0.0f, f10, f10);
        vVar.f = 180.0f;
        vVar.g = 90.0f;
        zVar.g.add(vVar);
        t tVar = new t(vVar);
        zVar.a(180.0f);
        zVar.h.add(tVar);
        zVar.e = 270.0f;
        float f11 = (0.0f + f10) * 0.5f;
        float f12 = (f10 - 0.0f) / 2.0f;
        double d = 270.0f;
        zVar.c = (((float) Math.cos(Math.toRadians(d))) * f12) + f11;
        zVar.d = (f12 * ((float) Math.sin(Math.toRadians(d)))) + f11;
    }
}
