package p0;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import o0.C0888a;
import o0.EnumC0889b;
import o0.InterfaceC0890c;

/* loaded from: classes.dex */
public class s implements t {

    /* renamed from: a, reason: collision with root package name */
    public static final s f19339a = new s();

    @Override // p0.t
    public int d() {
        return 2;
    }

    /* JADX WARN: Type inference failed for: r10v7, types: [T, java.math.BigDecimal] */
    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        int iU = interfaceC0890c.U();
        Class cls = Byte.TYPE;
        Class cls2 = Short.TYPE;
        Class cls3 = Double.TYPE;
        if (iU == 2) {
            if (type == cls3 || type == Double.class) {
                String strW0 = interfaceC0890c.w0();
                interfaceC0890c.A(16);
                return (T) Double.valueOf(Double.parseDouble(strW0));
            }
            long jF = interfaceC0890c.f();
            interfaceC0890c.A(16);
            if (type == cls2 || type == Short.class) {
                if (jF <= 32767 && jF >= -32768) {
                    return (T) Short.valueOf((short) jF);
                }
                throw new l0.d("short overflow : " + jF);
            }
            if (type != cls && type != Byte.class) {
                return (jF < -2147483648L || jF > 2147483647L) ? (T) Long.valueOf(jF) : (T) Integer.valueOf((int) jF);
            }
            if (jF <= 127 && jF >= -128) {
                return (T) Byte.valueOf((byte) jF);
            }
            throw new l0.d("short overflow : " + jF);
        }
        if (interfaceC0890c.U() == 3) {
            if (type == cls3 || type == Double.class) {
                String strW02 = interfaceC0890c.w0();
                interfaceC0890c.A(16);
                return (T) Double.valueOf(Double.parseDouble(strW02));
            }
            if (type == cls2 || type == Short.class) {
                BigDecimal bigDecimalC = interfaceC0890c.C();
                interfaceC0890c.A(16);
                return (T) Short.valueOf(u0.o.M0(bigDecimalC));
            }
            if (type == cls || type == Byte.class) {
                BigDecimal bigDecimalC2 = interfaceC0890c.C();
                interfaceC0890c.A(16);
                return (T) Byte.valueOf(u0.o.e(bigDecimalC2));
            }
            ?? r10 = (T) interfaceC0890c.C();
            interfaceC0890c.A(16);
            return interfaceC0890c.I(EnumC0889b.UseBigDecimal) ? r10 : (T) Double.valueOf(r10.doubleValue());
        }
        if (interfaceC0890c.U() == 18 && "NaN".equals(interfaceC0890c.N())) {
            interfaceC0890c.nextToken();
            if (type == Double.class) {
                return (T) Double.valueOf(Double.NaN);
            }
            if (type == Float.class) {
                return (T) Float.valueOf(Float.NaN);
            }
            return null;
        }
        Object objS = c0888a.S();
        if (objS == null) {
            return null;
        }
        if (type == cls3 || type == Double.class) {
            try {
                return (T) u0.o.q(objS);
            } catch (Exception e6) {
                throw new l0.d("parseDouble error, field : " + obj, e6);
            }
        }
        if (type == cls2 || type == Short.class) {
            try {
                return (T) u0.o.w(objS);
            } catch (Exception e7) {
                throw new l0.d("parseShort error, field : " + obj, e7);
            }
        }
        if (type != cls && type != Byte.class) {
            return (T) u0.o.i(objS);
        }
        try {
            return (T) u0.o.l(objS);
        } catch (Exception e8) {
            throw new l0.d("parseByte error, field : " + obj, e8);
        }
    }
}
