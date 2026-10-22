package V8;

import H8.AbstractC0241b;
import X8.A;
import X8.AbstractC0272c;
import X8.H;
import X8.K;
import X8.S;
import h8.AbstractC1538u;
import h8.C1531n;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import h8.InterfaceC1528k;
import i8.InterfaceC1561g;
import java.util.List;
import k8.AbstractC1637f;
import k8.C1635d;
import k8.C1636e;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class t extends AbstractC1637f implements k {
    public final ProtoBuf$TypeAlias i;

    /* renamed from: j, reason: collision with root package name */
    public final D8.f f1410j;
    public final D8.j k;
    public final D8.k l;
    public final j m;
    public A n;
    public A o;
    public List p;

    /* renamed from: q, reason: collision with root package name */
    public A f1411q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(W8.l storageManager, InterfaceC1527j containingDeclaration, InterfaceC1561g interfaceC1561g, G8.f fVar, C1531n visibility, ProtoBuf$TypeAlias proto, D8.f nameResolver, D8.j typeTable, D8.k versionRequirementTable, j jVar) {
        super(storageManager, containingDeclaration, interfaceC1561g, fVar, visibility);
        kotlin.jvm.internal.k.f(storageManager, "storageManager");
        kotlin.jvm.internal.k.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.k.f(visibility, "visibility");
        kotlin.jvm.internal.k.f(proto, "proto");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.k.f(typeTable, "typeTable");
        kotlin.jvm.internal.k.f(versionRequirementTable, "versionRequirementTable");
        this.i = proto;
        this.f1410j = nameResolver;
        this.k = typeTable;
        this.l = versionRequirementTable;
        this.m = jVar;
    }

    @Override // V8.k
    public final j B() {
        return this.m;
    }

    public final InterfaceC1522e R0() {
        if (AbstractC0272c.k(S0())) {
            return null;
        }
        InterfaceC1524g interfaceC1524gD = S0().Q().d();
        if (interfaceC1524gD instanceof InterfaceC1522e) {
            return (InterfaceC1522e) interfaceC1524gD;
        }
        return null;
    }

    public final A S0() {
        A a3 = this.o;
        if (a3 != null) {
            return a3;
        }
        kotlin.jvm.internal.k.n("expandedType");
        throw null;
    }

    public final A T0() {
        A a3 = this.n;
        if (a3 != null) {
            return a3;
        }
        kotlin.jvm.internal.k.n("underlyingType");
        throw null;
    }

    public final void U0(List declaredTypeParameters, A underlyingType, A expandedType) {
        Q8.o oVarR;
        A aW;
        kotlin.jvm.internal.k.f(declaredTypeParameters, "declaredTypeParameters");
        kotlin.jvm.internal.k.f(underlyingType, "underlyingType");
        kotlin.jvm.internal.k.f(expandedType, "expandedType");
        this.g = declaredTypeParameters;
        this.n = underlyingType;
        this.o = expandedType;
        this.p = AbstractC1538u.c(this);
        InterfaceC1522e interfaceC1522eR0 = R0();
        if (interfaceC1522eR0 == null || (oVarR = interfaceC1522eR0.R()) == null) {
            oVarR = Q8.n.b;
        }
        Q8.o oVar = oVarR;
        C1635d c1635d = new C1635d();
        Z8.g gVar = S.f1527a;
        if (Z8.i.f(this)) {
            aW = Z8.i.c(ErrorTypeKind.k, toString());
        } else {
            K kM = m();
            if (kM == null) {
                S.a(12);
                throw null;
            }
            List listD = S.d(((C1636e) kM).getParameters());
            H.b.getClass();
            aW = AbstractC0272c.w(H.c, kM, listD, false, oVar, c1635d);
        }
        this.f1411q = aW;
    }

    @Override // h8.InterfaceC1505M
    public final InterfaceC1528k b(kotlin.reflect.jvm.internal.impl.types.a substitutor) {
        kotlin.jvm.internal.k.f(substitutor, "substitutor");
        if (substitutor.f5144a.e()) {
            return this;
        }
        InterfaceC1527j interfaceC1527jD = d();
        kotlin.jvm.internal.k.e(interfaceC1527jD, "getContainingDeclaration(...)");
        InterfaceC1561g annotations = getAnnotations();
        kotlin.jvm.internal.k.e(annotations, "<get-annotations>(...)");
        G8.f name = getName();
        kotlin.jvm.internal.k.e(name, "getName(...)");
        t tVar = new t(this.e, interfaceC1527jD, annotations, name, this.f, this.i, this.f1410j, this.k, this.l, this.m);
        List listH = h();
        A aT0 = T0();
        Variance variance = Variance.c;
        tVar.U0(listH, AbstractC0272c.b(substitutor.g(aT0, variance)), AbstractC0272c.b(substitutor.g(S0(), variance)));
        return tVar;
    }

    @Override // V8.k
    public final AbstractC0241b d0() {
        return this.i;
    }

    @Override // h8.InterfaceC1524g
    public final A g() {
        A a3 = this.f1411q;
        if (a3 != null) {
            return a3;
        }
        kotlin.jvm.internal.k.n("defaultTypeImpl");
        throw null;
    }

    @Override // V8.k
    public final D8.j v() {
        return this.k;
    }

    @Override // V8.k
    public final D8.f y() {
        return this.f1410j;
    }
}
