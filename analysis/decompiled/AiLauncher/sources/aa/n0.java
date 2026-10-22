package aa;

import E9.InterfaceC0797b;
import S9.C1004c;
import W9.C1101j;
import Z8.C1173v;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import ya.H0;
import ya.J0;
import za.C6468n;

/* loaded from: classes5.dex */
public final class n0 extends AbstractC1257e<F9.c> {

    /* renamed from: a, reason: collision with root package name */
    public final F9.a f8166a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8167b;

    /* renamed from: c, reason: collision with root package name */
    public final V9.k f8168c;

    /* renamed from: d, reason: collision with root package name */
    public final AnnotationQualifierApplicabilityType f8169d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f8170e;

    public n0(F9.a aVar, boolean z10, V9.k containerContext, AnnotationQualifierApplicabilityType containerApplicabilityType, boolean z11) {
        kotlin.jvm.internal.p.i(containerContext, "containerContext");
        kotlin.jvm.internal.p.i(containerApplicabilityType, "containerApplicabilityType");
        this.f8166a = aVar;
        this.f8167b = z10;
        this.f8168c = containerContext;
        this.f8169d = containerApplicabilityType;
        this.f8170e = z11;
    }

    @Override // aa.AbstractC1257e
    public ga.d A(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        InterfaceC0797b interfaceC0797bF = H0.f((ya.S) gVar);
        if (interfaceC0797bF != null) {
            return C4828h.m(interfaceC0797bF);
        }
        return null;
    }

    @Override // aa.AbstractC1257e
    public boolean D() {
        return this.f8170e;
    }

    @Override // aa.AbstractC1257e
    public boolean F(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return C9.j.f0((ya.S) gVar);
    }

    @Override // aa.AbstractC1257e
    public boolean G() {
        return this.f8167b;
    }

    @Override // aa.AbstractC1257e
    public boolean H(Ca.g gVar, Ca.g other) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        return this.f8168c.a().k().c((ya.S) gVar, (ya.S) other);
    }

    @Override // aa.AbstractC1257e
    public boolean I(Ca.o oVar) {
        kotlin.jvm.internal.p.i(oVar, "<this>");
        return oVar instanceof W9.Z;
    }

    @Override // aa.AbstractC1257e
    public boolean J(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return ((ya.S) gVar).K0() instanceof C1262j;
    }

    @Override // aa.AbstractC1257e
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public boolean o(F9.c cVar, Ca.g gVar) {
        kotlin.jvm.internal.p.i(cVar, "<this>");
        if ((cVar instanceof U9.f) && ((U9.f) cVar).k()) {
            return true;
        }
        if ((cVar instanceof C1101j) && !x() && (((C1101j) cVar).m() || t() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS)) {
            return true;
        }
        return gVar != null && C9.j.r0((ya.S) gVar) && p().p(cVar) && !this.f8168c.a().q().d();
    }

    @Override // aa.AbstractC1257e
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public C1004c p() {
        return this.f8168c.a().a();
    }

    @Override // aa.AbstractC1257e
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public ya.S y(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return J0.a((ya.S) gVar);
    }

    @Override // aa.AbstractC1257e
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public Ca.t E() {
        return C6468n.f45422a;
    }

    @Override // aa.AbstractC1257e
    public Iterable<F9.c> q(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return ((ya.S) gVar).getAnnotations();
    }

    @Override // aa.AbstractC1257e
    public Iterable<F9.c> s() {
        F9.g annotations;
        F9.a aVar = this.f8166a;
        return (aVar == null || (annotations = aVar.getAnnotations()) == null) ? C1173v.m() : annotations;
    }

    @Override // aa.AbstractC1257e
    public AnnotationQualifierApplicabilityType t() {
        return this.f8169d;
    }

    @Override // aa.AbstractC1257e
    public S9.B u() {
        return this.f8168c.b();
    }

    @Override // aa.AbstractC1257e
    public boolean v() {
        F9.a aVar = this.f8166a;
        return (aVar instanceof E9.i0) && ((E9.i0) aVar).p0() != null;
    }

    @Override // aa.AbstractC1257e
    public C1263k w(C1263k c1263k, S9.t tVar) {
        C1263k c1263kB;
        if (c1263k != null && (c1263kB = C1263k.b(c1263k, NullabilityQualifier.NOT_NULL, false, 2, null)) != null) {
            return c1263kB;
        }
        if (tVar != null) {
            return tVar.d();
        }
        return null;
    }

    @Override // aa.AbstractC1257e
    public boolean x() {
        return this.f8168c.a().q().c();
    }

    public /* synthetic */ n0(F9.a aVar, boolean z10, V9.k kVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
        this(aVar, z10, kVar, annotationQualifierApplicabilityType, (i10 & 16) != 0 ? false : z11);
    }
}
