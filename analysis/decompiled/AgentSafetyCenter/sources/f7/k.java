package f7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends td.h {
    @Override // td.h
    public final void t(v vVar, float f5, float f10) {
        float f11 = f10 * f5;
        vVar.d(f11, 180.0f, 90.0f);
        float f12 = f11 * 2.0f;
        r rVar = new r(0.0f, 0.0f, f12, f12);
        rVar.f4017f = 180.0f;
        rVar.f4018g = 90.0f;
        vVar.f4027f.add(rVar);
        p pVar = new p(rVar);
        vVar.a(180.0f);
        vVar.f4028g.add(pVar);
        vVar.f4025d = 270.0f;
        float f13 = (0.0f + f12) * 0.5f;
        float f14 = (f12 - 0.0f) / 2.0f;
        double d7 = 270.0f;
        vVar.f4023b = (((float) Math.cos(Math.toRadians(d7))) * f14) + f13;
        vVar.f4024c = (f14 * ((float) Math.sin(Math.toRadians(d7)))) + f13;
    }
}
