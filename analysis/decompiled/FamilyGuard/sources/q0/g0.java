package q0;

import java.lang.reflect.Type;
import o0.C0888a;
import o0.InterfaceC0890c;

/* loaded from: classes.dex */
public class g0 implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static g0 f19851a = new g0();

    public static <T> T f(C0888a c0888a) {
        InterfaceC0890c interfaceC0890cG = c0888a.G();
        if (interfaceC0890cG.U() == 4) {
            T t5 = (T) interfaceC0890cG.N();
            interfaceC0890cG.A(16);
            return t5;
        }
        if (interfaceC0890cG.U() == 2) {
            T t6 = (T) interfaceC0890cG.w0();
            interfaceC0890cG.A(16);
            return t6;
        }
        Object objS = c0888a.S();
        if (objS == null) {
            return null;
        }
        return (T) objS.toString();
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        g(c0946i, (String) obj);
    }

    @Override // p0.t
    public int d() {
        return 4;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        if (type == StringBuffer.class) {
            InterfaceC0890c interfaceC0890c = c0888a.f18948f;
            if (interfaceC0890c.U() == 4) {
                String strN = interfaceC0890c.N();
                interfaceC0890c.A(16);
                return (T) new StringBuffer(strN);
            }
            Object objS = c0888a.S();
            if (objS == null) {
                return null;
            }
            return (T) new StringBuffer(objS.toString());
        }
        if (type != StringBuilder.class) {
            return (T) f(c0888a);
        }
        InterfaceC0890c interfaceC0890c2 = c0888a.f18948f;
        if (interfaceC0890c2.U() == 4) {
            String strN2 = interfaceC0890c2.N();
            interfaceC0890c2.A(16);
            return (T) new StringBuilder(strN2);
        }
        Object objS2 = c0888a.S();
        if (objS2 == null) {
            return null;
        }
        return (T) new StringBuilder(objS2.toString());
    }

    public void g(C0946I c0946i, String str) {
        e0 e0Var = c0946i.f19676k;
        if (str == null) {
            e0Var.d0(f0.WriteNullStringAsEmpty);
        } else {
            e0Var.h0(str);
        }
    }
}
