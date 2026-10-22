package y4;

import y4.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends xb.a {
    @Override // xb.a
    public final void d(m mVar, float f8, float f9) {
        float f10 = f9 * f8;
        mVar.d(f10, 180.0f, 90.0f);
        float f11 = f10 * 2.0f;
        mVar.getClass();
        m.c cVar = new m.c(0.0f, 0.0f, f11, f11);
        cVar.f14110f = 180.0f;
        cVar.f14111g = 90.0f;
        mVar.f14101f.add(cVar);
        m.a aVar = new m.a(cVar);
        float f12 = 180.0f + 90.0f;
        boolean z = 90.0f < 0.0f;
        float f13 = z ? (180.0f + 180.0f) % 360.0f : 180.0f;
        float f14 = z ? (180.0f + f12) % 360.0f : f12;
        mVar.a(f13);
        mVar.f14102g.add(aVar);
        mVar.f14099d = f14;
        double d8 = f12;
        mVar.f14097b = (((f11 - 0.0f) / 2.0f) * ((float) Math.cos(Math.toRadians(d8)))) + ((0.0f + f11) * 0.5f);
        mVar.f14098c = (((f11 - 0.0f) / 2.0f) * ((float) Math.sin(Math.toRadians(d8)))) + ((0.0f + f11) * 0.5f);
    }
}
