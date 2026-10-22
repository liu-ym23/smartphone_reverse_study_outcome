package p0;

import java.lang.reflect.Type;
import l0.AbstractC0822a;
import o0.C0888a;
import o0.C0894g;
import o0.EnumC0889b;
import o0.InterfaceC0890c;

/* renamed from: p0.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0911A implements t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0911A f19280a = new C0911A();

    @Override // p0.t
    public int d() {
        return 12;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() == 8) {
            interfaceC0890c.nextToken();
            return null;
        }
        if (interfaceC0890c.U() != 12 && interfaceC0890c.U() != 16) {
            throw new l0.d("syntax error: " + C0894g.a(interfaceC0890c.U()));
        }
        int iV = 0;
        String strN = null;
        String strN2 = null;
        String strN3 = null;
        while (true) {
            String strD = interfaceC0890c.D(c0888a.L());
            if (strD == null) {
                if (interfaceC0890c.U() == 13) {
                    interfaceC0890c.A(16);
                    break;
                }
                if (interfaceC0890c.U() != 16 || !interfaceC0890c.I(EnumC0889b.AllowArbitraryCommas)) {
                }
            }
            interfaceC0890c.L(4);
            if ("className".equals(strD)) {
                if (interfaceC0890c.U() == 8) {
                    strN = null;
                } else {
                    if (interfaceC0890c.U() != 4) {
                        throw new l0.d("syntax error");
                    }
                    strN = interfaceC0890c.N();
                }
            } else if ("methodName".equals(strD)) {
                if (interfaceC0890c.U() == 8) {
                    strN2 = null;
                } else {
                    if (interfaceC0890c.U() != 4) {
                        throw new l0.d("syntax error");
                    }
                    strN2 = interfaceC0890c.N();
                }
            } else if ("fileName".equals(strD)) {
                if (interfaceC0890c.U() == 8) {
                    strN3 = null;
                } else {
                    if (interfaceC0890c.U() != 4) {
                        throw new l0.d("syntax error");
                    }
                    strN3 = interfaceC0890c.N();
                }
            } else if ("lineNumber".equals(strD)) {
                if (interfaceC0890c.U() == 8) {
                    iV = 0;
                } else {
                    if (interfaceC0890c.U() != 2) {
                        throw new l0.d("syntax error");
                    }
                    iV = interfaceC0890c.v();
                }
            } else if ("nativeMethod".equals(strD)) {
                if (interfaceC0890c.U() != 8 && interfaceC0890c.U() != 6 && interfaceC0890c.U() != 7) {
                    throw new l0.d("syntax error");
                }
                interfaceC0890c.A(16);
            } else if (strD == AbstractC0822a.f18018c) {
                if (interfaceC0890c.U() == 4) {
                    String strN4 = interfaceC0890c.N();
                    if (!strN4.equals("java.lang.StackTraceElement")) {
                        throw new l0.d("syntax error : " + strN4);
                    }
                } else if (interfaceC0890c.U() != 8) {
                    throw new l0.d("syntax error");
                }
            } else if ("moduleName".equals(strD)) {
                if (interfaceC0890c.U() != 8) {
                    if (interfaceC0890c.U() != 4) {
                        throw new l0.d("syntax error");
                    }
                    interfaceC0890c.N();
                }
            } else if ("moduleVersion".equals(strD)) {
                if (interfaceC0890c.U() != 8) {
                    if (interfaceC0890c.U() != 4) {
                        throw new l0.d("syntax error");
                    }
                    interfaceC0890c.N();
                }
            } else {
                if (!"classLoaderName".equals(strD)) {
                    throw new l0.d("syntax error : " + strD);
                }
                if (interfaceC0890c.U() != 8) {
                    if (interfaceC0890c.U() != 4) {
                        throw new l0.d("syntax error");
                    }
                    interfaceC0890c.N();
                }
            }
            if (interfaceC0890c.U() == 13) {
                interfaceC0890c.A(16);
                break;
            }
        }
        return (T) new StackTraceElement(strN, strN2, strN3, iV);
    }
}
