package q0;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* renamed from: q0.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0976x implements U {

    /* renamed from: b, reason: collision with root package name */
    public static final C0976x f19877b = new C0976x();

    /* renamed from: a, reason: collision with root package name */
    private DecimalFormat f19878a;

    public C0976x() {
        this.f19878a = null;
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws IOException {
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.d0(f0.WriteNullNumberAsZero);
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
            e0Var.Y();
            return;
        }
        DecimalFormat decimalFormat = this.f19878a;
        if (decimalFormat == null) {
            e0Var.A(dDoubleValue, true);
        } else {
            e0Var.write(decimalFormat.format(dDoubleValue));
        }
    }

    public C0976x(DecimalFormat decimalFormat) {
        this.f19878a = decimalFormat;
    }

    public C0976x(String str) {
        this(new DecimalFormat(str));
    }
}
