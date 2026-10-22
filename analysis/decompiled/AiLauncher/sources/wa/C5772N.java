package wa;

import E9.AbstractC0811p;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.W;
import E9.a0;
import E9.b0;
import E9.f0;
import H9.AbstractC0828g;
import ea.InterfaceC4020d;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.F0;

/* renamed from: wa.N, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5772N extends AbstractC0828g implements InterfaceC5794r {

    /* renamed from: k, reason: collision with root package name */
    public final ProtoBuf$TypeAlias f43161k;

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC4020d f43162l;

    /* renamed from: m, reason: collision with root package name */
    public final ea.h f43163m;

    /* renamed from: n, reason: collision with root package name */
    public final ea.j f43164n;

    /* renamed from: o, reason: collision with root package name */
    public final InterfaceC5793q f43165o;

    /* renamed from: p, reason: collision with root package name */
    public AbstractC5990d0 f43166p;

    /* renamed from: q, reason: collision with root package name */
    public AbstractC5990d0 f43167q;

    /* renamed from: r, reason: collision with root package name */
    public List<? extends b0> f43168r;

    /* renamed from: s, reason: collision with root package name */
    public AbstractC5990d0 f43169s;

    /* JADX WARN: Illegal instructions before constructor call */
    public C5772N(InterfaceC5869l storageManager, InterfaceC0803h containingDeclaration, F9.g annotations, ga.e name, AbstractC0811p visibility, ProtoBuf$TypeAlias proto, InterfaceC4020d nameResolver, ea.h typeTable, ea.j versionRequirementTable, InterfaceC5793q interfaceC5793q) {
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.p.i(annotations, "annotations");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(visibility, "visibility");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(typeTable, "typeTable");
        kotlin.jvm.internal.p.i(versionRequirementTable, "versionRequirementTable");
        W NO_SOURCE = W.f2444a;
        kotlin.jvm.internal.p.h(NO_SOURCE, "NO_SOURCE");
        super(storageManager, containingDeclaration, annotations, name, NO_SOURCE, visibility);
        this.f43161k = proto;
        this.f43162l = nameResolver;
        this.f43163m = typeTable;
        this.f43164n = versionRequirementTable;
        this.f43165o = interfaceC5793q;
    }

    @Override // wa.InterfaceC5794r
    public ea.h C() {
        return this.f43163m;
    }

    @Override // E9.a0
    public AbstractC5990d0 E() {
        AbstractC5990d0 abstractC5990d0 = this.f43167q;
        if (abstractC5990d0 != null) {
            return abstractC5990d0;
        }
        kotlin.jvm.internal.p.A("expandedType");
        return null;
    }

    @Override // wa.InterfaceC5794r
    public InterfaceC4020d F() {
        return this.f43162l;
    }

    @Override // wa.InterfaceC5794r
    public InterfaceC5793q G() {
        return this.f43165o;
    }

    @Override // H9.AbstractC0828g
    public List<b0> L0() {
        List list = this.f43168r;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.p.A("typeConstructorParameters");
        return null;
    }

    @Override // wa.InterfaceC5794r
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$TypeAlias a0() {
        return this.f43161k;
    }

    public ea.j P0() {
        return this.f43164n;
    }

    public final void Q0(List<? extends b0> declaredTypeParameters, AbstractC5990d0 underlyingType, AbstractC5990d0 expandedType) {
        kotlin.jvm.internal.p.i(declaredTypeParameters, "declaredTypeParameters");
        kotlin.jvm.internal.p.i(underlyingType, "underlyingType");
        kotlin.jvm.internal.p.i(expandedType, "expandedType");
        M0(declaredTypeParameters);
        this.f43166p = underlyingType;
        this.f43167q = expandedType;
        this.f43168r = f0.g(this);
        this.f43169s = G0();
    }

    @Override // E9.Y
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public a0 c(TypeSubstitutor substitutor) {
        kotlin.jvm.internal.p.i(substitutor, "substitutor");
        if (substitutor.l()) {
            return this;
        }
        InterfaceC5869l interfaceC5869lI = I();
        InterfaceC0803h interfaceC0803hB = b();
        kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
        F9.g annotations = getAnnotations();
        kotlin.jvm.internal.p.h(annotations, "<get-annotations>(...)");
        ga.e name = getName();
        kotlin.jvm.internal.p.h(name, "getName(...)");
        C5772N c5772n = new C5772N(interfaceC5869lI, interfaceC0803hB, annotations, name, getVisibility(), a0(), F(), C(), P0(), G());
        List<b0> listO = o();
        AbstractC5990d0 abstractC5990d0N0 = n0();
        Variance variance = Variance.INVARIANT;
        ya.S sO = substitutor.o(abstractC5990d0N0, variance);
        kotlin.jvm.internal.p.h(sO, "safeSubstitute(...)");
        AbstractC5990d0 abstractC5990d0A = F0.a(sO);
        ya.S sO2 = substitutor.o(E(), variance);
        kotlin.jvm.internal.p.h(sO2, "safeSubstitute(...)");
        c5772n.Q0(listO, abstractC5990d0A, F0.a(sO2));
        return c5772n;
    }

    @Override // E9.InterfaceC0799d
    public AbstractC5990d0 n() {
        AbstractC5990d0 abstractC5990d0 = this.f43169s;
        if (abstractC5990d0 != null) {
            return abstractC5990d0;
        }
        kotlin.jvm.internal.p.A("defaultTypeImpl");
        return null;
    }

    @Override // E9.a0
    public AbstractC5990d0 n0() {
        AbstractC5990d0 abstractC5990d0 = this.f43166p;
        if (abstractC5990d0 != null) {
            return abstractC5990d0;
        }
        kotlin.jvm.internal.p.A("underlyingType");
        return null;
    }

    @Override // E9.a0
    public InterfaceC0797b r() {
        if (ya.W.a(E())) {
            return null;
        }
        InterfaceC0799d interfaceC0799dD = E().H0().d();
        if (interfaceC0799dD instanceof InterfaceC0797b) {
            return (InterfaceC0797b) interfaceC0799dD;
        }
        return null;
    }
}
