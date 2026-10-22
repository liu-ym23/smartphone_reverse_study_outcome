package H9;

import E9.AbstractC0811p;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.b0;
import E9.g0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import p9.InterfaceC5074l;
import ra.InterfaceC5238k;
import ya.AbstractC5990d0;
import ya.C5967B;
import ya.C6013t;
import ya.C6016w;
import ya.E0;
import ya.H0;
import ya.v0;

/* renamed from: H9.y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0845y extends z {

    /* renamed from: b, reason: collision with root package name */
    public final z f3225b;

    /* renamed from: c, reason: collision with root package name */
    public final TypeSubstitutor f3226c;

    /* renamed from: d, reason: collision with root package name */
    public TypeSubstitutor f3227d;

    /* renamed from: e, reason: collision with root package name */
    public List<b0> f3228e;

    /* renamed from: f, reason: collision with root package name */
    public List<b0> f3229f;

    /* renamed from: g, reason: collision with root package name */
    public v0 f3230g;

    /* renamed from: H9.y$a */
    public class a implements InterfaceC5074l<b0, Boolean> {
        public a() {
        }

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(b0 b0Var) {
            return Boolean.valueOf(!b0Var.M());
        }
    }

    /* renamed from: H9.y$b */
    public class b implements InterfaceC5074l<AbstractC5990d0, AbstractC5990d0> {
        public b() {
        }

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC5990d0 invoke(AbstractC5990d0 abstractC5990d0) {
            return C0845y.this.G0(abstractC5990d0);
        }
    }

    public C0845y(z zVar, TypeSubstitutor typeSubstitutor) {
        this.f3225b = zVar;
        this.f3226c = typeSubstitutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void y0(int r15) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H9.C0845y.y0(int):void");
    }

    @Override // E9.InterfaceC0797b
    public kotlin.reflect.jvm.internal.impl.descriptors.b B() {
        return this.f3225b.B();
    }

    @Override // E9.InterfaceC0797b
    public boolean C0() {
        return this.f3225b.C0();
    }

    @Override // E9.InterfaceC0797b
    public E9.S D0() {
        throw new UnsupportedOperationException();
    }

    public final TypeSubstitutor E0() {
        if (this.f3227d == null) {
            if (this.f3226c.l()) {
                this.f3227d = this.f3226c;
            } else {
                List<b0> parameters = this.f3225b.j().getParameters();
                this.f3228e = new ArrayList(parameters.size());
                this.f3227d = C5967B.b(parameters, this.f3226c.k(), this, this.f3228e);
                this.f3229f = Z8.F.m0(this.f3228e, new a());
            }
        }
        return this.f3227d;
    }

    @Override // E9.Y
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public InterfaceC0797b c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            y0(23);
        }
        return typeSubstitutor.l() ? this : new C0845y(this, TypeSubstitutor.i(typeSubstitutor.k(), E0().k()));
    }

    public final AbstractC5990d0 G0(AbstractC5990d0 abstractC5990d0) {
        return (abstractC5990d0 == null || this.f3226c.l()) ? abstractC5990d0 : (AbstractC5990d0) E0().q(abstractC5990d0, Variance.INVARIANT);
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k O() {
        InterfaceC5238k interfaceC5238kO = this.f3225b.O();
        if (interfaceC5238kO == null) {
            y0(28);
        }
        return interfaceC5238kO;
    }

    @Override // E9.InterfaceC0797b
    public g0<AbstractC5990d0> P() {
        g0<AbstractC5990d0> g0VarP = this.f3225b.P();
        if (g0VarP == null) {
            return null;
        }
        return g0VarP.b(new b());
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k R() {
        InterfaceC5238k interfaceC5238kC0 = c0(DescriptorUtilsKt.r(C4828h.g(this.f3225b)));
        if (interfaceC5238kC0 == null) {
            y0(12);
        }
        return interfaceC5238kC0;
    }

    @Override // E9.InterfaceC0816v
    public boolean S() {
        return this.f3225b.S();
    }

    @Override // H9.z
    public InterfaceC5238k T(E0 e02, kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        if (e02 == null) {
            y0(5);
        }
        if (cVar == null) {
            y0(6);
        }
        InterfaceC5238k interfaceC5238kT = this.f3225b.T(e02, cVar);
        if (!this.f3226c.l()) {
            return new ra.t(interfaceC5238kT, E0());
        }
        if (interfaceC5238kT == null) {
            y0(7);
        }
        return interfaceC5238kT;
    }

    @Override // E9.InterfaceC0797b
    public List<E9.S> V() {
        List<E9.S> list = Collections.EMPTY_LIST;
        if (list == null) {
            y0(17);
        }
        return list;
    }

    @Override // E9.InterfaceC0797b
    public boolean W() {
        return this.f3225b.W();
    }

    @Override // E9.InterfaceC0797b
    public boolean Z() {
        return this.f3225b.Z();
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0804i, E9.InterfaceC0803h
    public InterfaceC0803h b() {
        InterfaceC0803h interfaceC0803hB = this.f3225b.b();
        if (interfaceC0803hB == null) {
            y0(22);
        }
        return interfaceC0803hB;
    }

    @Override // H9.z
    public InterfaceC5238k c0(kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        if (cVar == null) {
            y0(13);
        }
        InterfaceC5238k interfaceC5238kC0 = this.f3225b.c0(cVar);
        if (!this.f3226c.l()) {
            return new ra.t(interfaceC5238kC0, E0());
        }
        if (interfaceC5238kC0 == null) {
            y0(14);
        }
        return interfaceC5238kC0;
    }

    @Override // E9.InterfaceC0806k
    public E9.W e() {
        E9.W w10 = E9.W.f2444a;
        if (w10 == null) {
            y0(29);
        }
        return w10;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return this.f3225b.e0();
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k g0() {
        InterfaceC5238k interfaceC5238kG0 = this.f3225b.g0();
        if (interfaceC5238kG0 == null) {
            y0(15);
        }
        return interfaceC5238kG0;
    }

    @Override // F9.a
    public F9.g getAnnotations() {
        F9.g annotations = this.f3225b.getAnnotations();
        if (annotations == null) {
            y0(19);
        }
        return annotations;
    }

    @Override // E9.InterfaceC0797b
    public ClassKind getKind() {
        ClassKind kind = this.f3225b.getKind();
        if (kind == null) {
            y0(25);
        }
        return kind;
    }

    @Override // E9.A
    public ga.e getName() {
        ga.e name = this.f3225b.getName();
        if (name == null) {
            y0(20);
        }
        return name;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p visibility = this.f3225b.getVisibility();
        if (visibility == null) {
            y0(27);
        }
        return visibility;
    }

    @Override // E9.InterfaceC0797b
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> h() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collectionH = this.f3225b.h();
        ArrayList arrayList = new ArrayList(collectionH.size());
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar : collectionH) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.b) bVar.s().l(bVar.a()).i(bVar.p()).r(bVar.getVisibility()).q(bVar.getKind()).m(false).build()).c(E0()));
        }
        return arrayList;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC0797b h0() {
        return this.f3225b.h0();
    }

    @Override // E9.InterfaceC0816v
    public boolean isExternal() {
        return this.f3225b.isExternal();
    }

    @Override // E9.InterfaceC0797b
    public boolean isInline() {
        return this.f3225b.isInline();
    }

    @Override // E9.InterfaceC0799d
    public v0 j() {
        v0 v0VarJ = this.f3225b.j();
        if (this.f3226c.l()) {
            if (v0VarJ == null) {
                y0(0);
            }
            return v0VarJ;
        }
        if (this.f3230g == null) {
            TypeSubstitutor typeSubstitutorE0 = E0();
            Collection<ya.S> collectionE = v0VarJ.e();
            ArrayList arrayList = new ArrayList(collectionE.size());
            Iterator<ya.S> it = collectionE.iterator();
            while (it.hasNext()) {
                arrayList.add(typeSubstitutorE0.q(it.next(), Variance.INVARIANT));
            }
            this.f3230g = new C6013t(this, this.f3228e, arrayList, LockBasedStorageManager.f36050e);
        }
        v0 v0Var = this.f3230g;
        if (v0Var == null) {
            y0(1);
        }
        return v0Var;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k k0(E0 e02) {
        if (e02 == null) {
            y0(10);
        }
        InterfaceC5238k interfaceC5238kT = T(e02, DescriptorUtilsKt.r(C4828h.g(this)));
        if (interfaceC5238kT == null) {
            y0(11);
        }
        return interfaceC5238kT;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0799d
    public AbstractC5990d0 n() {
        AbstractC5990d0 abstractC5990d0O = ya.V.o(C6016w.f44130a.a(getAnnotations(), null, null), j(), H0.g(j().getParameters()), false, R());
        if (abstractC5990d0O == null) {
            y0(16);
        }
        return abstractC5990d0O;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0800e
    public List<b0> o() {
        E0();
        List<b0> list = this.f3229f;
        if (list == null) {
            y0(30);
        }
        return list;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public Modality p() {
        Modality modalityP = this.f3225b.p();
        if (modalityP == null) {
            y0(26);
        }
        return modalityP;
    }

    @Override // E9.InterfaceC0797b
    public boolean q() {
        return this.f3225b.q();
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return interfaceC0805j.a(this, d10);
    }

    @Override // E9.InterfaceC0800e
    public boolean x() {
        return this.f3225b.x();
    }

    @Override // H9.z, E9.InterfaceC0803h
    public InterfaceC0797b a() {
        InterfaceC0797b interfaceC0797bA = this.f3225b.a();
        if (interfaceC0797bA == null) {
            y0(21);
        }
        return interfaceC0797bA;
    }
}
