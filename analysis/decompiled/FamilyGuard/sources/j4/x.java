package j4;

import p4.InterfaceC0929b;
import p4.InterfaceC0930c;
import p4.InterfaceC0931d;

/* loaded from: classes.dex */
public class x {
    public InterfaceC0931d a(i iVar) {
        return iVar;
    }

    public InterfaceC0929b b(Class cls) {
        return new e(cls);
    }

    public InterfaceC0930c c(Class cls, String str) {
        return new m(cls, str);
    }

    public p4.f d(n nVar) {
        return nVar;
    }

    public p4.g e(p pVar) {
        return pVar;
    }

    public String f(h hVar) {
        String string = hVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String g(l lVar) {
        return f(lVar);
    }
}
