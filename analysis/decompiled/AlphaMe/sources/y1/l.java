package y1;

import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class l extends B0.f {
    @Override // B0.f
    public final void A(float f4, float f5, x xVar) {
        float f6 = f5 * f4;
        xVar.d(f6, 180.0f, 90.0f);
        float f7 = f6 * 2.0f;
        t tVar = new t(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, f7, f7);
        tVar.f16308f = 180.0f;
        tVar.f16309g = 90.0f;
        xVar.f16321g.add(tVar);
        r rVar = new r(tVar);
        xVar.a(180.0f);
        xVar.f16322h.add(rVar);
        xVar.f16319e = 270.0f;
        float f8 = (Property.DEFAULT_FLOAT_VALUE + f7) * 0.5f;
        float f9 = (f7 - Property.DEFAULT_FLOAT_VALUE) / 2.0f;
        double d4 = 270.0f;
        xVar.f16317c = (((float) Math.cos(Math.toRadians(d4))) * f9) + f8;
        xVar.f16318d = (f9 * ((float) Math.sin(Math.toRadians(d4)))) + f8;
    }
}
