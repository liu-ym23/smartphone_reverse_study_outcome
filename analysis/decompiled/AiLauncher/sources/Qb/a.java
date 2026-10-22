package Qb;

import Yb.u;
import Yb.z;
import bc.InterfaceC1477a;
import bc.InterfaceC1478b;
import com.fasterxml.jackson.core.JsonPointer;

/* loaded from: classes5.dex */
public class a implements InterfaceC1477a {
    @Override // bc.InterfaceC1477a
    public int a(InterfaceC1478b interfaceC1478b, InterfaceC1478b interfaceC1478b2) {
        return (interfaceC1478b.length() < 2 || interfaceC1478b2.length() < 2) ? 0 : 2;
    }

    @Override // bc.InterfaceC1477a
    public char b() {
        return JsonPointer.ESC;
    }

    @Override // bc.InterfaceC1477a
    public int c() {
        return 2;
    }

    @Override // bc.InterfaceC1477a
    public char d() {
        return JsonPointer.ESC;
    }

    @Override // bc.InterfaceC1477a
    public void e(z zVar, z zVar2, int i10) {
        Pb.a aVar = new Pb.a();
        u uVarE = zVar.e();
        while (uVarE != null && uVarE != zVar2) {
            u uVarE2 = uVarE.e();
            aVar.b(uVarE);
            uVarE = uVarE2;
        }
        zVar.h(aVar);
    }
}
