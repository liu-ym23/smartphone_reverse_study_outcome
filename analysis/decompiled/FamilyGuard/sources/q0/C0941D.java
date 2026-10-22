package q0;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;
import o0.C0888a;
import o0.InterfaceC0890c;

/* renamed from: q0.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0941D implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static C0941D f19671a = new C0941D();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        e0 e0Var = c0946i.f19676k;
        Number number = (Number) obj;
        if (number == null) {
            e0Var.d0(f0.WriteNullNumberAsZero);
            return;
        }
        if (obj instanceof Long) {
            e0Var.X(number.longValue());
        } else {
            e0Var.V(number.intValue());
        }
        if (e0Var.v(f0.WriteClassName)) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                e0Var.write(66);
            } else if (cls == Short.class) {
                e0Var.write(83);
            }
        }
    }

    @Override // p0.t
    public int d() {
        return 2;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        Object obj2;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        int iU = interfaceC0890c.U();
        if (iU == 8) {
            interfaceC0890c.A(16);
            return null;
        }
        try {
            if (iU == 2) {
                int iV = interfaceC0890c.v();
                interfaceC0890c.A(16);
                obj2 = (T) Integer.valueOf(iV);
            } else if (iU == 3) {
                Integer numValueOf = Integer.valueOf(u0.o.k0(interfaceC0890c.C()));
                interfaceC0890c.A(16);
                obj2 = (T) numValueOf;
            } else if (iU == 12) {
                l0.e eVar = new l0.e(true);
                c0888a.l0(eVar);
                obj2 = (T) u0.o.t(eVar);
            } else {
                obj2 = (T) u0.o.t(c0888a.S());
            }
            return type == AtomicInteger.class ? (T) new AtomicInteger(((Integer) obj2).intValue()) : (T) obj2;
        } catch (Exception e6) {
            String str = "parseInt error";
            if (obj != null) {
                str = "parseInt error, field : " + obj;
            }
            throw new l0.d(str, e6);
        }
    }
}
