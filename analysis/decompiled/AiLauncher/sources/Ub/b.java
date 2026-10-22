package Ub;

import Yb.i;
import Yb.u;
import Yb.y;
import Yb.z;
import bc.InterfaceC1477a;
import bc.InterfaceC1478b;

/* loaded from: classes5.dex */
public abstract class b implements InterfaceC1477a {

    /* renamed from: a, reason: collision with root package name */
    public final char f6418a;

    public b(char c10) {
        this.f6418a = c10;
    }

    @Override // bc.InterfaceC1477a
    public int a(InterfaceC1478b interfaceC1478b, InterfaceC1478b interfaceC1478b2) {
        if ((interfaceC1478b.a() || interfaceC1478b2.c()) && interfaceC1478b2.b() % 3 != 0 && (interfaceC1478b.b() + interfaceC1478b2.b()) % 3 == 0) {
            return 0;
        }
        return (interfaceC1478b.length() < 2 || interfaceC1478b2.length() < 2) ? 1 : 2;
    }

    @Override // bc.InterfaceC1477a
    public char b() {
        return this.f6418a;
    }

    @Override // bc.InterfaceC1477a
    public int c() {
        return 1;
    }

    @Override // bc.InterfaceC1477a
    public char d() {
        return this.f6418a;
    }

    @Override // bc.InterfaceC1477a
    public void e(z zVar, z zVar2, int i10) {
        u yVar;
        String strValueOf = String.valueOf(d());
        if (i10 == 1) {
            yVar = new i(strValueOf);
        } else {
            yVar = new y(strValueOf + strValueOf);
        }
        u uVarE = zVar.e();
        while (uVarE != null && uVarE != zVar2) {
            u uVarE2 = uVarE.e();
            yVar.b(uVarE);
            uVarE = uVarE2;
        }
        zVar.h(yVar);
    }
}
