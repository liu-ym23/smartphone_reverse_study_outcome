package q0;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import o0.C0888a;
import o0.InterfaceC0890c;

/* renamed from: q0.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0965l implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    static final BigDecimal f19860a = BigDecimal.valueOf(-9007199254740991L);

    /* renamed from: b, reason: collision with root package name */
    static final BigDecimal f19861b = BigDecimal.valueOf(9007199254740991L);

    /* renamed from: c, reason: collision with root package name */
    public static final C0965l f19862c = new C0965l();

    public static <T> T f(C0888a c0888a) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() == 2) {
            T t5 = (T) interfaceC0890c.C();
            interfaceC0890c.A(16);
            return t5;
        }
        if (interfaceC0890c.U() == 3) {
            T t6 = (T) interfaceC0890c.C();
            interfaceC0890c.A(16);
            return t6;
        }
        Object objS = c0888a.S();
        if (objS == null) {
            return null;
        }
        return (T) u0.o.i(objS);
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.d0(f0.WriteNullNumberAsZero);
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        int iScale = bigDecimal.scale();
        String string = (!f0.d(i5, e0Var.f19798c, f0.WriteBigDecimalAsPlain) || iScale < -100 || iScale >= 100) ? bigDecimal.toString() : bigDecimal.toPlainString();
        if (iScale == 0 && string.length() >= 16 && f0.d(i5, e0Var.f19798c, f0.BrowserCompatible) && (bigDecimal.compareTo(f19860a) < 0 || bigDecimal.compareTo(f19861b) > 0)) {
            e0Var.h0(string);
            return;
        }
        e0Var.write(string);
        if (e0Var.v(f0.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
            e0Var.write(46);
        }
    }

    @Override // p0.t
    public int d() {
        return 2;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        try {
            return (T) f(c0888a);
        } catch (Exception e6) {
            throw new l0.d("parseDecimal error, field : " + obj, e6);
        }
    }
}
