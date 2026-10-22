package q0;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;
import o0.C0888a;
import o0.InterfaceC0890c;

/* renamed from: q0.O, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0952O implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static C0952O f19713a = new C0952O();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.d0(f0.WriteNullNumberAsZero);
            return;
        }
        long jLongValue = ((Long) obj).longValue();
        e0Var.X(jLongValue);
        if (!e0Var.v(f0.WriteClassName) || jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class || type == Long.TYPE) {
            return;
        }
        e0Var.write(76);
    }

    @Override // p0.t
    public int d() {
        return 2;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        Object objV;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        try {
            int iU = interfaceC0890c.U();
            if (iU == 2) {
                long jF = interfaceC0890c.f();
                interfaceC0890c.A(16);
                objV = (T) Long.valueOf(jF);
            } else if (iU == 3) {
                Object objValueOf = Long.valueOf(u0.o.D0(interfaceC0890c.C()));
                interfaceC0890c.A(16);
                objV = (T) objValueOf;
            } else {
                if (iU == 12) {
                    l0.e eVar = new l0.e(true);
                    c0888a.l0(eVar);
                    objV = (T) u0.o.v(eVar);
                } else {
                    objV = u0.o.v(c0888a.S());
                }
                if (objV == null) {
                    return null;
                }
            }
            return type == AtomicLong.class ? (T) new AtomicLong(((Long) objV).longValue()) : (T) objV;
        } catch (Exception e6) {
            throw new l0.d("parseLong error, field : " + obj, e6);
        }
    }
}
