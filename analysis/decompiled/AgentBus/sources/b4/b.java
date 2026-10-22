package b4;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import n.t;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements t, v0.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1486a;

    @Override // n.t
    public float a(float f10) {
        return f10;
    }

    @Override // v0.i
    public double b(double d6) {
        switch (this.f1486a) {
            case 13:
                double d10 = d6 < 0.0d ? -d6 : d6;
                return Math.copySign(d10 >= 0.0031308049535603718d ? (Math.pow(d10, 0.4166666666666667d) - 0.05213270142180095d) / 0.9478672985781991d : d10 / 0.07739938080495357d, d6);
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                double d11 = d6 < 0.0d ? -d6 : d6;
                return Math.copySign(d11 >= 0.04045d ? Math.pow((0.9478672985781991d * d11) + 0.05213270142180095d, 2.4d) : d11 * 0.07739938080495357d, d6);
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                float[] fArr = v0.d.f10272a;
                return v0.d.b(v0.d.f10274c, d6);
            case 16:
                float[] fArr2 = v0.d.f10272a;
                return v0.d.a(v0.d.f10274c, d6);
            case 17:
                float[] fArr3 = v0.d.f10272a;
                return v0.d.d(v0.d.f10275d, d6);
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                float[] fArr4 = v0.d.f10272a;
                return v0.d.c(v0.d.f10275d, d6);
            default:
                return d6;
        }
    }
}
