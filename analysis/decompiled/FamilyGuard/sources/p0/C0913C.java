package p0;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;
import o0.C0888a;
import o0.C0893f;
import o0.InterfaceC0890c;

/* renamed from: p0.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0913C implements t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0913C f19281a = new C0913C();

    @Override // p0.t
    public int d() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) throws NumberFormatException {
        long timeInMillis;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() == 16) {
            interfaceC0890c.A(4);
            if (interfaceC0890c.U() != 4) {
                throw new l0.d("syntax error");
            }
            interfaceC0890c.L(2);
            if (interfaceC0890c.U() != 2) {
                throw new l0.d("syntax error");
            }
            long jF = interfaceC0890c.f();
            interfaceC0890c.A(13);
            if (interfaceC0890c.U() != 13) {
                throw new l0.d("syntax error");
            }
            interfaceC0890c.A(16);
            return (T) new Time(jF);
        }
        T t5 = (T) c0888a.S();
        if (t5 == 0) {
            return null;
        }
        if (t5 instanceof Time) {
            return t5;
        }
        if (t5 instanceof BigDecimal) {
            return (T) new Time(u0.o.D0((BigDecimal) t5));
        }
        if (t5 instanceof Number) {
            return (T) new Time(((Number) t5).longValue());
        }
        if (!(t5 instanceof String)) {
            throw new l0.d("parse error");
        }
        String str = (String) t5;
        if (str.length() == 0) {
            return null;
        }
        C0893f c0893f = new C0893f(str);
        if (c0893f.s1()) {
            timeInMillis = c0893f.F0().getTimeInMillis();
        } else {
            for (int i5 = 0; i5 < str.length(); i5++) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    c0893f.close();
                    return (T) Time.valueOf(str);
                }
            }
            timeInMillis = Long.parseLong(str);
        }
        c0893f.close();
        return (T) new Time(timeInMillis);
    }
}
