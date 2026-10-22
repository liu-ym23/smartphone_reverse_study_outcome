package q0;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import o0.C0888a;
import o0.InterfaceC0890c;

/* renamed from: q0.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0939B implements U, p0.t {

    /* renamed from: b, reason: collision with root package name */
    public static C0939B f19668b = new C0939B();

    /* renamed from: a, reason: collision with root package name */
    private NumberFormat f19669a;

    public C0939B() {
    }

    public static <T> T f(C0888a c0888a) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() == 2) {
            String strW0 = interfaceC0890c.w0();
            interfaceC0890c.A(16);
            return (T) Float.valueOf(Float.parseFloat(strW0));
        }
        if (interfaceC0890c.U() == 3) {
            float fT = interfaceC0890c.T();
            interfaceC0890c.A(16);
            return (T) Float.valueOf(fT);
        }
        Object objS = c0888a.S();
        if (objS == null) {
            return null;
        }
        return (T) u0.o.s(objS);
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws IOException {
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.d0(f0.WriteNullNumberAsZero);
            return;
        }
        float fFloatValue = ((Float) obj).floatValue();
        NumberFormat numberFormat = this.f19669a;
        if (numberFormat != null) {
            e0Var.write(numberFormat.format(fFloatValue));
        } else {
            e0Var.T(fFloatValue, true);
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
            throw new l0.d("parseLong error, field : " + obj, e6);
        }
    }

    public C0939B(DecimalFormat decimalFormat) {
        this.f19669a = decimalFormat;
    }

    public C0939B(String str) {
        this(new DecimalFormat(str));
    }
}
