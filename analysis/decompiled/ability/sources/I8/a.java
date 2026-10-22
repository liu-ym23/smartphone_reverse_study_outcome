package I8;

import D7.J;
import a.AbstractC0291a;
import h8.InterfaceC1494B;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import java.util.ArrayList;
import k8.AbstractC1629B;

/* loaded from: classes4.dex */
public final class a implements b {
    public static final a b = new a(0);
    public static final a c = new a(1);
    public static final a d = new a(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f807a;

    public /* synthetic */ a(int i) {
        this.f807a = i;
    }

    public static String b(InterfaceC1524g interfaceC1524g) {
        String strE;
        G8.f name = interfaceC1524g.getName();
        kotlin.jvm.internal.k.e(name, "getName(...)");
        String strD = AbstractC0291a.D(name);
        if (!(interfaceC1524g instanceof InterfaceC1507O)) {
            InterfaceC1527j interfaceC1527jD = interfaceC1524g.d();
            kotlin.jvm.internal.k.e(interfaceC1527jD, "getContainingDeclaration(...)");
            if (interfaceC1527jD instanceof InterfaceC1522e) {
                strE = b((InterfaceC1524g) interfaceC1527jD);
            } else if (interfaceC1527jD instanceof InterfaceC1494B) {
                G8.e eVarI = ((AbstractC1629B) ((InterfaceC1494B) interfaceC1527jD)).e.i();
                kotlin.jvm.internal.k.e(eVarI, "toUnsafe(...)");
                strE = AbstractC0291a.E(eVarI.e());
            } else {
                strE = null;
            }
            if (strE != null && !strE.equals("")) {
                return strE + '.' + strD;
            }
        }
        return strD;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [h8.g, h8.j] */
    /* JADX WARN: Type inference failed for: r1v5, types: [h8.j] */
    /* JADX WARN: Type inference failed for: r1v6, types: [h8.j] */
    @Override // I8.b
    public final String a(InterfaceC1524g interfaceC1524g, g gVar) {
        switch (this.f807a) {
            case 0:
                if (interfaceC1524g instanceof InterfaceC1507O) {
                    G8.f name = ((InterfaceC1507O) interfaceC1524g).getName();
                    kotlin.jvm.internal.k.e(name, "getName(...)");
                    return gVar.M(name, false);
                }
                G8.e eVarG = J8.e.g(interfaceC1524g);
                kotlin.jvm.internal.k.e(eVarG, "getFqName(...)");
                return gVar.m(AbstractC0291a.E(eVarG.e()));
            case 1:
                if (interfaceC1524g instanceof InterfaceC1507O) {
                    G8.f name2 = ((InterfaceC1507O) interfaceC1524g).getName();
                    kotlin.jvm.internal.k.e(name2, "getName(...)");
                    return gVar.M(name2, false);
                }
                ArrayList arrayList = new ArrayList();
                do {
                    arrayList.add(interfaceC1524g.getName());
                    interfaceC1524g = interfaceC1524g.d();
                } while (interfaceC1524g instanceof InterfaceC1522e);
                return AbstractC0291a.E(new J(arrayList));
            default:
                return b(interfaceC1524g);
        }
    }
}
