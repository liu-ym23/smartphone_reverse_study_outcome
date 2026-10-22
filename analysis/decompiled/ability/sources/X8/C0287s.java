package X8;

import h8.InterfaceC1507O;
import h8.InterfaceC1524g;

/* renamed from: X8.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0287s extends P {
    public final InterfaceC1507O[] b;
    public final N[] c;
    public final boolean d;

    public C0287s(InterfaceC1507O[] parameters, N[] arguments, boolean z10) {
        kotlin.jvm.internal.k.f(parameters, "parameters");
        kotlin.jvm.internal.k.f(arguments, "arguments");
        this.b = parameters;
        this.c = arguments;
        this.d = z10;
    }

    @Override // X8.P
    public final boolean b() {
        return this.d;
    }

    @Override // X8.P
    public final N d(w wVar) {
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        InterfaceC1507O interfaceC1507O = interfaceC1524gD instanceof InterfaceC1507O ? (InterfaceC1507O) interfaceC1524gD : null;
        if (interfaceC1507O != null) {
            int index = interfaceC1507O.getIndex();
            InterfaceC1507O[] interfaceC1507OArr = this.b;
            if (index < interfaceC1507OArr.length && kotlin.jvm.internal.k.b(interfaceC1507OArr[index].m(), interfaceC1507O.m())) {
                return this.c[index];
            }
        }
        return null;
    }

    @Override // X8.P
    public final boolean e() {
        return this.c.length == 0;
    }
}
