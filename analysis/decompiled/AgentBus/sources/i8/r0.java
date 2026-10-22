package i8;

import f8.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import v9.v0;

/* loaded from: classes.dex */
public class r0 extends s0 implements f8.j0, t0 {

    /* renamed from: k, reason: collision with root package name */
    public final int f4845k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f4846l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f4847m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f4848n;

    /* renamed from: o, reason: collision with root package name */
    public final v9.v f4849o;

    /* renamed from: p, reason: collision with root package name */
    public final r0 f4850p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(f8.b bVar, r0 r0Var, int i2, g8.j jVar, e9.f fVar, v9.v vVar, boolean z4, boolean z10, boolean z11, v9.v vVar2, f8.n0 n0Var) {
        super(bVar, jVar, fVar, vVar, n0Var);
        q7.k.e(bVar, "containingDeclaration");
        q7.k.e(jVar, "annotations");
        q7.k.e(fVar, "name");
        q7.k.e(vVar, "outType");
        q7.k.e(n0Var, "source");
        this.f4845k = i2;
        this.f4846l = z4;
        this.f4847m = z10;
        this.f4848n = z11;
        this.f4849o = vVar2;
        this.f4850p = r0Var == null ? this : r0Var;
    }

    @Override // f8.t0
    public final boolean F() {
        return false;
    }

    public r0 G0(d8.g gVar, e9.f fVar, int i2) {
        g8.j annotations = getAnnotations();
        q7.k.d(annotations, "annotations");
        v9.v type = getType();
        q7.k.d(type, "type");
        return new r0(gVar, null, i2, annotations, fVar, type, H0(), this.f4847m, this.f4848n, this.f4849o, f8.n0.f3487b);
    }

    public final boolean H0() {
        return this.f4846l && ((f8.c) p()).getKind() != 2;
    }

    @Override // i8.n, f8.j
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public final f8.b p() {
        f8.j jVarP = super.p();
        q7.k.c(jVarP, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (f8.b) jVarP;
    }

    @Override // i8.n, i8.m, f8.j
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public final r0 a() {
        r0 r0Var = this.f4850p;
        return r0Var == this ? this : r0Var.a();
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.A(this, obj);
    }

    @Override // f8.m, f8.w
    public final f8.n c() {
        f8.n nVar = f8.o.f3493f;
        q7.k.d(nVar, "LOCAL");
        return nVar;
    }

    @Override // f8.p0
    public final f8.k d(v0 v0Var) {
        q7.k.e(v0Var, "substitutor");
        if (v0Var.f10596a.e()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // f8.t0
    public final /* bridge */ /* synthetic */ j9.g q0() {
        return null;
    }

    @Override // f8.b
    public final Collection r() {
        Collection collectionR = p().r();
        q7.k.d(collectionR, "containingDeclaration.overriddenDescriptors");
        Collection collection = collectionR;
        ArrayList arrayList = new ArrayList(d7.t.A0(collection, 10));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((r0) ((f8.b) it.next()).x0().get(this.f4845k));
        }
        return arrayList;
    }
}
