package q0;

import java.lang.reflect.Type;
import java.math.BigInteger;
import o0.C0888a;
import o0.InterfaceC0890c;

/* renamed from: q0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0966m implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    private static final BigInteger f19863a = BigInteger.valueOf(-9007199254740991L);

    /* renamed from: b, reason: collision with root package name */
    private static final BigInteger f19864b = BigInteger.valueOf(9007199254740991L);

    /* renamed from: c, reason: collision with root package name */
    public static final C0966m f19865c = new C0966m();

    public static <T> T f(C0888a c0888a) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() != 2) {
            Object objS = c0888a.S();
            if (objS == null) {
                return null;
            }
            return (T) u0.o.j(objS);
        }
        String strW0 = interfaceC0890c.w0();
        interfaceC0890c.A(16);
        if (strW0.length() <= 65535) {
            return (T) new BigInteger(strW0);
        }
        throw new l0.d("decimal overflow");
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.d0(f0.WriteNullNumberAsZero);
            return;
        }
        BigInteger bigInteger = (BigInteger) obj;
        String string = bigInteger.toString();
        if (string.length() < 16 || !f0.d(i5, e0Var.f19798c, f0.BrowserCompatible) || (bigInteger.compareTo(f19863a) >= 0 && bigInteger.compareTo(f19864b) <= 0)) {
            e0Var.write(string);
        } else {
            e0Var.h0(string);
        }
    }

    @Override // p0.t
    public int d() {
        return 2;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        return (T) f(c0888a);
    }
}
