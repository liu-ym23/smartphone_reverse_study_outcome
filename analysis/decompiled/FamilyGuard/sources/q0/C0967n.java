package q0;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import o0.C0888a;
import o0.InterfaceC0890c;

/* renamed from: q0.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0967n implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0967n f19866a = new C0967n();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        e0 e0Var = c0946i.f19676k;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            e0Var.d0(f0.WriteNullBooleanAsFalse);
        } else if (bool.booleanValue()) {
            e0Var.write("true");
        } else {
            e0Var.write("false");
        }
    }

    @Override // p0.t
    public int d() {
        return 6;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        Object obj2;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        try {
            if (interfaceC0890c.U() == 6) {
                interfaceC0890c.A(16);
                obj2 = (T) Boolean.TRUE;
            } else if (interfaceC0890c.U() == 7) {
                interfaceC0890c.A(16);
                obj2 = (T) Boolean.FALSE;
            } else if (interfaceC0890c.U() == 2) {
                int iV = interfaceC0890c.v();
                interfaceC0890c.A(16);
                obj2 = iV == 1 ? (T) Boolean.TRUE : (T) Boolean.FALSE;
            } else {
                Object objS = c0888a.S();
                if (objS == null) {
                    return null;
                }
                obj2 = (T) u0.o.k(objS);
            }
            return type == AtomicBoolean.class ? (T) new AtomicBoolean(((Boolean) obj2).booleanValue()) : (T) obj2;
        } catch (Exception e6) {
            throw new l0.d("parseBoolean error, field : " + obj, e6);
        }
    }
}
