package f8;

import C7.r;
import D7.v;
import D7.w;
import Q8.n;
import X8.K;
import e8.o;
import h8.AbstractC1508P;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1494B;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k8.AbstractC1633b;
import k8.C1640i;
import k8.O;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import s2.C1912a;

/* renamed from: f8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1442c extends AbstractC1633b {
    public static final G8.b l = new G8.b(o.l, G8.f.e("Function"));
    public static final G8.b m = new G8.b(o.i, G8.f.e("KFunction"));
    public final W8.i e;
    public final InterfaceC1494B f;
    public final j g;
    public final int h;
    public final C1441b i;

    /* renamed from: j, reason: collision with root package name */
    public final C1443d f4444j;
    public final List k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1442c(W8.i iVar, U8.b containingDeclaration, j jVar, int i) {
        super(iVar, jVar.a(i));
        kotlin.jvm.internal.k.f(containingDeclaration, "containingDeclaration");
        this.e = iVar;
        this.f = containingDeclaration;
        this.g = jVar;
        this.h = i;
        this.i = new C1441b(this);
        this.f4444j = new C1443d(iVar, this);
        ArrayList arrayList = new ArrayList();
        Y7.f fVar = new Y7.f(1, i, 1);
        ArrayList arrayList2 = new ArrayList(w.c0(fVar, 10));
        Y7.e it = fVar.iterator();
        while (it.c) {
            int iNextInt = it.nextInt();
            arrayList.add(O.U0(this, Variance.d, G8.f.e("P" + iNextInt), arrayList.size(), this.e));
            arrayList2.add(r.f317a);
        }
        arrayList.add(O.U0(this, Variance.e, G8.f.e("R"), arrayList.size(), this.e));
        this.k = v.f1(arrayList);
        C1912a c1912a = FunctionClassKind.f4946a;
        j functionTypeKind = this.g;
        c1912a.getClass();
        kotlin.jvm.internal.k.f(functionTypeKind, "functionTypeKind");
        if (functionTypeKind.equals(C1445f.c) || functionTypeKind.equals(C1448i.c) || functionTypeKind.equals(C1446g.c)) {
            return;
        }
        functionTypeKind.equals(C1447h.c);
    }

    @Override // k8.y
    public final Q8.o A(Y8.f fVar) {
        return this.f4444j;
    }

    @Override // h8.InterfaceC1522e
    public final boolean A0() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final AbstractC1508P P() {
        return null;
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean X() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean c0() {
        return false;
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        return this.f;
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return false;
    }

    @Override // i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        return C1560f.f4611a;
    }

    @Override // h8.InterfaceC1522e
    public final ClassKind getKind() {
        return ClassKind.b;
    }

    @Override // h8.InterfaceC1528k
    public final InterfaceC1503K getSource() {
        return InterfaceC1503K.f4577I;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n PUBLIC = AbstractC1532o.e;
        kotlin.jvm.internal.k.e(PUBLIC, "PUBLIC");
        return PUBLIC;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1525h
    public final List h() {
        return this.k;
    }

    @Override // h8.InterfaceC1522e
    public final /* bridge */ /* synthetic */ Q8.o h0() {
        return n.b;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final Modality i() {
        return Modality.e;
    }

    @Override // h8.InterfaceC1539v
    public final boolean isExternal() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean isInline() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean j() {
        return false;
    }

    @Override // h8.InterfaceC1524g
    public final K m() {
        return this.i;
    }

    @Override // h8.InterfaceC1522e
    public final Collection n() {
        return EmptyList.f4893a;
    }

    @Override // h8.InterfaceC1522e
    public final Collection p() {
        return EmptyList.f4893a;
    }

    @Override // h8.InterfaceC1525h
    public final boolean q() {
        return false;
    }

    public final String toString() {
        String strB = getName().b();
        kotlin.jvm.internal.k.e(strB, "asString(...)");
        return strB;
    }

    @Override // h8.InterfaceC1522e
    public final /* bridge */ /* synthetic */ C1640i u() {
        return null;
    }
}
