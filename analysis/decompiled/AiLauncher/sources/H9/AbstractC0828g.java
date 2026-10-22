package H9;

import E9.AbstractC0811p;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.InterfaceC0806k;
import E9.a0;
import E9.b0;
import H9.T;
import Z8.C1173v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ra.InterfaceC5238k;
import w9.InterfaceC5752k;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.H0;
import ya.v0;

/* renamed from: H9.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0828g extends AbstractC0835n implements a0 {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f3108j = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(AbstractC0828g.class, "constructors", "getConstructors()Ljava/util/Collection;", 0))};

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5869l f3109e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC0811p f3110f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5865h f3111g;

    /* renamed from: h, reason: collision with root package name */
    public List<? extends b0> f3112h;

    /* renamed from: i, reason: collision with root package name */
    public final a f3113i;

    /* renamed from: H9.g$a */
    public static final class a implements v0 {
        public a() {
        }

        @Override // ya.v0
        public v0 a(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
            kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this;
        }

        @Override // ya.v0
        public Collection<ya.S> e() {
            Collection<ya.S> collectionE = d().n0().H0().e();
            kotlin.jvm.internal.p.h(collectionE, "getSupertypes(...)");
            return collectionE;
        }

        @Override // ya.v0
        public boolean f() {
            return true;
        }

        @Override // ya.v0
        public C9.j g() {
            return DescriptorUtilsKt.m(d());
        }

        @Override // ya.v0
        public List<b0> getParameters() {
            return AbstractC0828g.this.L0();
        }

        @Override // ya.v0
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public a0 d() {
            return AbstractC0828g.this;
        }

        public String toString() {
            return "[typealias " + d().getName().b() + ']';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0828g(InterfaceC5869l storageManager, InterfaceC0803h containingDeclaration, F9.g annotations, ga.e name, E9.W sourceElement, AbstractC0811p visibilityImpl) {
        super(containingDeclaration, annotations, name, sourceElement);
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.p.i(annotations, "annotations");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(sourceElement, "sourceElement");
        kotlin.jvm.internal.p.i(visibilityImpl, "visibilityImpl");
        this.f3109e = storageManager;
        this.f3110f = visibilityImpl;
        this.f3111g = storageManager.i(new C0825d(this));
        this.f3113i = new a();
    }

    public static final AbstractC5990d0 H0(AbstractC0828g abstractC0828g, kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        InterfaceC0799d interfaceC0799dF = cVar.f(abstractC0828g);
        if (interfaceC0799dF != null) {
            return interfaceC0799dF.n();
        }
        return null;
    }

    public static final Collection I0(AbstractC0828g abstractC0828g) {
        return abstractC0828g.K0();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Boolean N0(H9.AbstractC0828g r1, ya.K0 r2) {
        /*
            kotlin.jvm.internal.p.f(r2)
            boolean r0 = ya.W.a(r2)
            if (r0 != 0) goto L23
            ya.v0 r2 = r2.H0()
            E9.d r2 = r2.d()
            boolean r0 = r2 instanceof E9.b0
            if (r0 == 0) goto L23
            E9.b0 r2 = (E9.b0) r2
            E9.h r2 = r2.b()
            boolean r1 = kotlin.jvm.internal.p.d(r2, r1)
            if (r1 != 0) goto L23
            r1 = 1
            goto L24
        L23:
            r1 = 0
        L24:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: H9.AbstractC0828g.N0(H9.g, ya.K0):java.lang.Boolean");
    }

    public final AbstractC5990d0 G0() {
        InterfaceC5238k interfaceC5238kR;
        InterfaceC0797b interfaceC0797bR = r();
        if (interfaceC0797bR == null || (interfaceC5238kR = interfaceC0797bR.R()) == null) {
            interfaceC5238kR = InterfaceC5238k.b.f38898b;
        }
        AbstractC5990d0 abstractC5990d0U = H0.u(this, interfaceC5238kR, new C0827f(this));
        kotlin.jvm.internal.p.h(abstractC5990d0U, "makeUnsubstitutedType(...)");
        return abstractC5990d0U;
    }

    public final InterfaceC5869l I() {
        return this.f3109e;
    }

    @Override // H9.AbstractC0835n
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public a0 a() {
        InterfaceC0806k interfaceC0806kA = super.a();
        kotlin.jvm.internal.p.g(interfaceC0806kA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (a0) interfaceC0806kA;
    }

    public final Collection<Q> K0() {
        InterfaceC0797b interfaceC0797bR = r();
        if (interfaceC0797bR == null) {
            return C1173v.m();
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collectionH = interfaceC0797bR.h();
        kotlin.jvm.internal.p.h(collectionH, "getConstructors(...)");
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar : collectionH) {
            T.a aVar = T.f3075I;
            InterfaceC5869l interfaceC5869l = this.f3109e;
            kotlin.jvm.internal.p.f(bVar);
            Q qB = aVar.b(interfaceC5869l, this, bVar);
            if (qB != null) {
                arrayList.add(qB);
            }
        }
        return arrayList;
    }

    public abstract List<b0> L0();

    public final void M0(List<? extends b0> declaredTypeParameters) {
        kotlin.jvm.internal.p.i(declaredTypeParameters, "declaredTypeParameters");
        this.f3112h = declaredTypeParameters;
    }

    @Override // E9.InterfaceC0816v
    public boolean S() {
        return false;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return false;
    }

    @Override // E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        return this.f3110f;
    }

    @Override // E9.InterfaceC0816v
    public boolean isExternal() {
        return false;
    }

    @Override // E9.InterfaceC0799d
    public v0 j() {
        return this.f3113i;
    }

    @Override // E9.InterfaceC0800e
    public List<b0> o() {
        List list = this.f3112h;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.p.A("declaredTypeParametersImpl");
        return null;
    }

    @Override // H9.AbstractC0834m
    public String toString() {
        return "typealias " + getName().b();
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> visitor, D d10) {
        kotlin.jvm.internal.p.i(visitor, "visitor");
        return visitor.c(this, d10);
    }

    @Override // E9.InterfaceC0800e
    public boolean x() {
        return H0.c(n0(), new C0826e(this));
    }
}
