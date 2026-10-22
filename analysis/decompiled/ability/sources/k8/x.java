package k8;

import X8.AbstractC0272c;
import X8.C0276g;
import X8.C0278i;
import a9.InterfaceC0311c;
import h8.AbstractC1508P;
import h8.C1531n;
import h8.C1537t;
import h8.C1541x;
import h8.InterfaceC1503K;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import h8.InterfaceC1528k;
import h8.InterfaceC1529l;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class x extends y {

    /* renamed from: a, reason: collision with root package name */
    public final y f4874a;
    public final kotlin.reflect.jvm.internal.impl.types.a b;
    public kotlin.reflect.jvm.internal.impl.types.a c;
    public ArrayList d;
    public ArrayList e;
    public C0278i f;

    public x(y yVar, kotlin.reflect.jvm.internal.impl.types.a aVar) {
        this.f4874a = yVar;
        this.b = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void C(int r15) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x.C(int):void");
    }

    @Override // k8.y
    public final Q8.o A(Y8.f fVar) {
        Q8.o oVarA = this.f4874a.A(fVar);
        if (!this.b.f5144a.e()) {
            return new Q8.t(oVarA, G());
        }
        if (oVarA != null) {
            return oVarA;
        }
        C(14);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final boolean A0() {
        return this.f4874a.A0();
    }

    @Override // h8.InterfaceC1522e
    public final u B0() {
        throw new UnsupportedOperationException();
    }

    @Override // h8.InterfaceC1522e
    public final Q8.o D(X8.P p) {
        kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(J8.e.d(this));
        return k(p, Y8.f.f1574a);
    }

    public final kotlin.reflect.jvm.internal.impl.types.a G() {
        if (this.c == null) {
            kotlin.reflect.jvm.internal.impl.types.a aVar = this.b;
            if (aVar.f5144a.e()) {
                this.c = aVar;
            } else {
                List parameters = this.f4874a.m().getParameters();
                this.d = new ArrayList(parameters.size());
                this.c = AbstractC0272c.A(parameters, aVar.f(), this, this.d);
                ArrayList arrayList = this.d;
                kotlin.jvm.internal.k.f(arrayList, "<this>");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (!((InterfaceC1507O) obj).K()) {
                        arrayList2.add(obj);
                    }
                }
                this.e = arrayList2;
            }
        }
        return this.c;
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.g(this, obj);
    }

    @Override // h8.InterfaceC1522e
    public final Q8.o O() {
        Q8.o oVarO = this.f4874a.O();
        if (oVarO != null) {
            return oVarO;
        }
        C(28);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final AbstractC1508P P() {
        AbstractC1508P abstractC1508PP = this.f4874a.P();
        if (abstractC1508PP == null) {
            return null;
        }
        boolean z10 = abstractC1508PP instanceof C1537t;
        kotlin.reflect.jvm.internal.impl.types.a aVar = this.b;
        if (z10) {
            C1537t c1537t = (C1537t) abstractC1508PP;
            G8.f fVar = c1537t.f4588a;
            X8.A a3 = (X8.A) c1537t.b;
            if (a3 != null && !aVar.f5144a.e()) {
                a3 = (X8.A) G().i(a3, Variance.c);
            }
            return new C1537t(fVar, a3);
        }
        if (!(abstractC1508PP instanceof C1541x)) {
            throw new NoWhenBranchMatchedException();
        }
        ArrayList<Pair> arrayList = ((C1541x) abstractC1508PP).f4590a;
        ArrayList arrayList2 = new ArrayList(D7.w.c0(arrayList, 10));
        for (Pair pair : arrayList) {
            G8.f fVar2 = (G8.f) pair.f4886a;
            X8.A a4 = (X8.A) ((InterfaceC0311c) pair.b);
            if (a4 != null && !aVar.f5144a.e()) {
                a4 = (X8.A) G().i(a4, Variance.c);
            }
            arrayList2.add(new Pair(fVar2, a4));
        }
        return new C1541x(arrayList2);
    }

    @Override // h8.InterfaceC1522e
    public final Q8.o R() {
        kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(J8.e.d(this.f4874a));
        return A(Y8.f.f1574a);
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        return this.f4874a.S();
    }

    @Override // h8.InterfaceC1522e
    public final List T() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C(17);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final boolean X() {
        return this.f4874a.X();
    }

    @Override // k8.y, h8.InterfaceC1522e, h8.InterfaceC1527j
    public final InterfaceC1522e a() {
        InterfaceC1522e interfaceC1522eA = this.f4874a.a();
        if (interfaceC1522eA != null) {
            return interfaceC1522eA;
        }
        C(21);
        throw null;
    }

    @Override // h8.InterfaceC1505M
    public final InterfaceC1528k b(kotlin.reflect.jvm.internal.impl.types.a aVar) {
        if (aVar != null) {
            return aVar.f5144a.e() ? this : new x(this, kotlin.reflect.jvm.internal.impl.types.a.e(aVar.f(), G().f()));
        }
        C(23);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final boolean c0() {
        return this.f4874a.c0();
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        InterfaceC1527j interfaceC1527jD = this.f4874a.d();
        if (interfaceC1527jD != null) {
            return interfaceC1527jD;
        }
        C(22);
        throw null;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1524g
    public final X8.A g() {
        X8.H hL;
        List listD = X8.S.d(m().getParameters());
        InterfaceC1561g annotations = getAnnotations();
        if (annotations.isEmpty()) {
            X8.H.b.getClass();
            hL = X8.H.c;
        } else {
            O2.a aVar = X8.H.b;
            List listM = H4.o.M(new C0276g(annotations));
            aVar.getClass();
            hL = O2.a.l(listM);
        }
        return AbstractC0272c.v(R(), hL, m(), listD, false);
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return this.f4874a.g0();
    }

    @Override // i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        InterfaceC1561g annotations = this.f4874a.getAnnotations();
        if (annotations != null) {
            return annotations;
        }
        C(19);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final ClassKind getKind() {
        ClassKind kind = this.f4874a.getKind();
        if (kind != null) {
            return kind;
        }
        C(25);
        throw null;
    }

    @Override // h8.InterfaceC1527j
    public final G8.f getName() {
        G8.f name = this.f4874a.getName();
        if (name != null) {
            return name;
        }
        C(20);
        throw null;
    }

    @Override // h8.InterfaceC1528k
    public final InterfaceC1503K getSource() {
        return InterfaceC1503K.f4577I;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n visibility = this.f4874a.getVisibility();
        if (visibility != null) {
            return visibility;
        }
        C(27);
        throw null;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1525h
    public final List h() {
        G();
        ArrayList arrayList = this.e;
        if (arrayList != null) {
            return arrayList;
        }
        C(30);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Q8.o h0() {
        Q8.o oVarH0 = this.f4874a.h0();
        if (oVarH0 != null) {
            return oVarH0;
        }
        C(15);
        throw null;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final Modality i() {
        Modality modalityI = this.f4874a.i();
        if (modalityI != null) {
            return modalityI;
        }
        C(26);
        throw null;
    }

    @Override // h8.InterfaceC1539v
    public final boolean isExternal() {
        return this.f4874a.isExternal();
    }

    @Override // h8.InterfaceC1522e
    public final boolean isInline() {
        return this.f4874a.isInline();
    }

    @Override // h8.InterfaceC1522e
    public final boolean j() {
        return this.f4874a.j();
    }

    @Override // k8.y
    public final Q8.o k(X8.P p, Y8.f fVar) {
        Q8.o oVarK = this.f4874a.k(p, fVar);
        if (!this.b.f5144a.e()) {
            return new Q8.t(oVarK, G());
        }
        if (oVarK != null) {
            return oVarK;
        }
        C(7);
        throw null;
    }

    @Override // h8.InterfaceC1524g
    public final X8.K m() {
        X8.K kM = this.f4874a.m();
        if (this.b.f5144a.e()) {
            if (kM != null) {
                return kM;
            }
            C(0);
            throw null;
        }
        if (this.f == null) {
            kotlin.reflect.jvm.internal.impl.types.a aVarG = G();
            Collection collectionE = kM.e();
            ArrayList arrayList = new ArrayList(collectionE.size());
            Iterator it = collectionE.iterator();
            while (it.hasNext()) {
                arrayList.add(aVarG.i((X8.w) it.next(), Variance.c));
            }
            this.f = new C0278i(this, this.d, arrayList, W8.i.e);
        }
        C0278i c0278i = this.f;
        if (c0278i != null) {
            return c0278i;
        }
        C(1);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Collection n() {
        Collection<C1640i> collectionN = this.f4874a.n();
        ArrayList arrayList = new ArrayList(collectionN.size());
        for (C1640i c1640i : collectionN) {
            C1640i c1640i2 = c1640i;
            c1640i2.getClass();
            C1649s c1649sX0 = c1640i2.X0(kotlin.reflect.jvm.internal.impl.types.a.b);
            c1649sX0.e = c1640i.Q0();
            c1649sX0.s(c1640i2.i());
            c1649sX0.r(c1640i2.getVisibility());
            c1649sX0.z(c1640i2.getKind());
            c1649sX0.m = false;
            arrayList.add(((C1640i) c1649sX0.f4860x.U0(c1649sX0)).b(G()));
        }
        return arrayList;
    }

    @Override // h8.InterfaceC1522e
    public final Collection p() {
        Collection collectionP = this.f4874a.p();
        if (collectionP != null) {
            return collectionP;
        }
        C(31);
        throw null;
    }

    @Override // h8.InterfaceC1525h
    public final boolean q() {
        return this.f4874a.q();
    }

    @Override // h8.InterfaceC1522e
    public final C1640i u() {
        return this.f4874a.u();
    }
}
