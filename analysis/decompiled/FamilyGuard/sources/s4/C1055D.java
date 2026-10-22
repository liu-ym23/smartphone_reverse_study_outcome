package s4;

import Z3.i;

/* renamed from: s4.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1055D {

    /* renamed from: s4.D$a */
    static final class a extends j4.l implements i4.p<Z3.i, i.b, Z3.i> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f20294a = new a();

        a() {
            super(2);
        }

        @Override // i4.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Z3.i invoke(Z3.i iVar, i.b bVar) {
            return bVar instanceof InterfaceC1054C ? iVar.C(((InterfaceC1054C) bVar).I()) : iVar.C(bVar);
        }
    }

    /* renamed from: s4.D$b */
    static final class b extends j4.l implements i4.p<Z3.i, i.b, Z3.i> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j4.v<Z3.i> f20295a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f20296b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(j4.v<Z3.i> vVar, boolean z5) {
            super(2);
            this.f20295a = vVar;
            this.f20296b = z5;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [T, Z3.i] */
        @Override // i4.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Z3.i invoke(Z3.i iVar, i.b bVar) {
            if (!(bVar instanceof InterfaceC1054C)) {
                return iVar.C(bVar);
            }
            i.b bVarA = this.f20295a.f17836a.a(bVar.getKey());
            if (bVarA == null) {
                return iVar.C(this.f20296b ? ((InterfaceC1054C) bVar).I() : (InterfaceC1054C) bVar);
            }
            j4.v<Z3.i> vVar = this.f20295a;
            vVar.f17836a = vVar.f17836a.W(bVar.getKey());
            return iVar.C(((InterfaceC1054C) bVar).A(bVarA));
        }
    }

    /* renamed from: s4.D$c */
    static final class c extends j4.l implements i4.p<Boolean, i.b, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f20297a = new c();

        c() {
            super(2);
        }

        public final Boolean b(boolean z5, i.b bVar) {
            return Boolean.valueOf(z5 || (bVar instanceof InterfaceC1054C));
        }

        @Override // i4.p
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, i.b bVar) {
            return b(bool.booleanValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final Z3.i a(Z3.i iVar, Z3.i iVar2, boolean z5) {
        boolean zC = c(iVar);
        boolean zC2 = c(iVar2);
        if (!zC && !zC2) {
            return iVar.C(iVar2);
        }
        j4.v vVar = new j4.v();
        vVar.f17836a = iVar2;
        Z3.j jVar = Z3.j.f6656a;
        Z3.i iVar3 = (Z3.i) iVar.o(jVar, new b(vVar, z5));
        if (zC2) {
            vVar.f17836a = ((Z3.i) vVar.f17836a).o(jVar, a.f20294a);
        }
        return iVar3.C((Z3.i) vVar.f17836a);
    }

    public static final String b(Z3.i iVar) {
        return null;
    }

    private static final boolean c(Z3.i iVar) {
        return ((Boolean) iVar.o(Boolean.FALSE, c.f20297a)).booleanValue();
    }

    public static final Z3.i d(Z3.i iVar, Z3.i iVar2) {
        return !c(iVar2) ? iVar.C(iVar2) : a(iVar, iVar2, false);
    }

    public static final Z3.i e(I i5, Z3.i iVar) {
        Z3.i iVarA = a(i5.G(), iVar, true);
        return (iVarA == W.a() || iVarA.a(Z3.f.f6654N) != null) ? iVarA : iVarA.C(W.a());
    }

    public static final J0<?> f(kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof T) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof J0) {
                return (J0) eVar;
            }
        }
        return null;
    }

    public static final J0<?> g(Z3.e<?> eVar, Z3.i iVar, Object obj) {
        if (!(eVar instanceof kotlin.coroutines.jvm.internal.e) || iVar.a(K0.f20314a) == null) {
            return null;
        }
        J0<?> j0F = f((kotlin.coroutines.jvm.internal.e) eVar);
        if (j0F != null) {
            j0F.O0(iVar, obj);
        }
        return j0F;
    }
}
