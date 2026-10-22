package v8;

import D7.v;
import H4.o;
import X8.A;
import X8.AbstractC0285p;
import X8.H;
import X8.N;
import X8.U;
import X8.w;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import j9.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.k;

/* renamed from: v8.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2071g extends AbstractC0285p {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2071g(A lowerBound, A upperBound) {
        super(lowerBound, upperBound);
        k.f(lowerBound, "lowerBound");
        k.f(upperBound, "upperBound");
        Y8.d.f1572a.b(lowerBound, upperBound);
    }

    public static final String C0(String str, String str2) {
        if (!m.i0(str, '<')) {
            return str;
        }
        return m.K0(str, '<') + '<' + str2 + '>' + m.I0('>', str, str);
    }

    public static final ArrayList y0(I8.g gVar, w wVar) throws IOException {
        List<N> listL = wVar.L();
        ArrayList arrayList = new ArrayList(D7.w.c0(listL, 10));
        for (N typeProjection : listL) {
            k.f(typeProjection, "typeProjection");
            StringBuilder sb = new StringBuilder();
            v.H0(o.M(typeProjection), sb, ", ", null, null, new I8.f(gVar, 0), 60);
            String string = sb.toString();
            k.e(string, "toString(...)");
            arrayList.add(string);
        }
        return arrayList;
    }

    @Override // X8.w
    /* renamed from: Y */
    public final w j0(Y8.f kotlinTypeRefiner) {
        k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        A type = this.b;
        k.f(type, "type");
        A type2 = this.c;
        k.f(type2, "type");
        return new C2071g(type, type2);
    }

    @Override // X8.U
    public final U f0(boolean z10) {
        return new C2071g(this.b.f0(z10), this.c.f0(z10));
    }

    @Override // X8.U
    public final U j0(Y8.f kotlinTypeRefiner) {
        k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        A type = this.b;
        k.f(type, "type");
        A type2 = this.c;
        k.f(type2, "type");
        return new C2071g(type, type2);
    }

    @Override // X8.U
    public final U m0(H newAttributes) {
        k.f(newAttributes, "newAttributes");
        return new C2071g(this.b.m0(newAttributes), this.c.m0(newAttributes));
    }

    @Override // X8.AbstractC0285p
    public final A n0() {
        return this.b;
    }

    @Override // X8.AbstractC0285p
    public final String s0(I8.g gVar, I8.g gVar2) throws IOException {
        A a3 = this.b;
        String strW = gVar.W(a3);
        A a4 = this.c;
        String strW2 = gVar.W(a4);
        if (gVar2.f813a.l()) {
            return "raw (" + strW + ".." + strW2 + ')';
        }
        if (a4.L().isEmpty()) {
            return gVar.D(strW, strW2, U7.a.x(this));
        }
        ArrayList arrayListY0 = y0(gVar, a3);
        ArrayList arrayListY02 = y0(gVar, a4);
        String strI0 = v.I0(arrayListY0, ", ", null, null, C2070f.f6793a, 30);
        ArrayList arrayListM1 = v.m1(arrayListY0, arrayListY02);
        if (arrayListM1.isEmpty()) {
            strW2 = C0(strW2, strI0);
        } else {
            Iterator it = arrayListM1.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str = (String) pair.f4886a;
                String str2 = (String) pair.b;
                if (!k.b(str, m.y0("out ", str2)) && !str2.equals("*")) {
                    break;
                }
            }
            strW2 = C0(strW2, strI0);
        }
        String strC0 = C0(strW, strI0);
        return k.b(strC0, strW2) ? strC0 : gVar.D(strC0, strW2, U7.a.x(this));
    }

    @Override // X8.AbstractC0285p, X8.w
    public final Q8.o w() {
        InterfaceC1524g interfaceC1524gD = Q().d();
        InterfaceC1522e interfaceC1522e = interfaceC1524gD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD : null;
        if (interfaceC1522e != null) {
            Q8.o oVarD = interfaceC1522e.D(new C2069e());
            k.e(oVarD, "getMemberScope(...)");
            return oVarD;
        }
        throw new IllegalStateException(("Incorrect classifier: " + Q().d()).toString());
    }
}
