package y1;

import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class e extends B0.f {
    @Override // B0.f
    public final void A(float f4, float f5, x xVar) {
        float f6 = f5 * f4;
        xVar.d(f6, 180.0f, 90.0f);
        double d4 = f6;
        xVar.c((float) (Math.sin(Math.toRadians(90.0f)) * d4), (float) (Math.sin(Math.toRadians(Property.DEFAULT_FLOAT_VALUE)) * d4));
    }
}
