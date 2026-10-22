package g8;

import D7.N;
import Z7.t;
import e8.o;
import h8.InterfaceC1522e;
import j8.InterfaceC1604c;
import java.util.Collection;
import k8.C1642k;
import k8.z;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.PropertyReference1Impl;

/* renamed from: g8.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1471g implements InterfaceC1604c {
    public static final C1469e d;
    public static final /* synthetic */ t[] e;
    public static final G8.c f;
    public static final G8.f g;
    public static final G8.b h;

    /* renamed from: a, reason: collision with root package name */
    public final z f4494a;
    public final S7.k b = C1470f.b;
    public final W8.h c;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        e = new t[]{nVar.g(new PropertyReference1Impl(nVar.b(C1471g.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
        d = new C1469e();
        f = o.l;
        G8.e eVar = e8.n.c;
        G8.f fVarF = eVar.f();
        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
        g = fVarF;
        G8.c cVarG = eVar.g();
        G8.c cVarE = cVarG.e();
        G8.f fVarF2 = cVarG.f();
        kotlin.jvm.internal.k.e(fVarF2, "shortName(...)");
        h = new G8.b(cVarE, fVarF2);
    }

    public C1471g(W8.i iVar, z zVar) {
        this.f4494a = zVar;
        this.c = new W8.h(iVar, new J4.e(9, this, iVar));
    }

    @Override // j8.InterfaceC1604c
    public final InterfaceC1522e a(G8.b classId) {
        kotlin.jvm.internal.k.f(classId, "classId");
        if (!classId.equals(h)) {
            return null;
        }
        return (C1642k) S0.b.g1(this.c, e[0]);
    }

    @Override // j8.InterfaceC1604c
    public final boolean b(G8.c packageFqName, G8.f name) {
        kotlin.jvm.internal.k.f(packageFqName, "packageFqName");
        kotlin.jvm.internal.k.f(name, "name");
        return name.equals(g) && packageFqName.equals(f);
    }

    @Override // j8.InterfaceC1604c
    public final Collection c(G8.c packageFqName) {
        kotlin.jvm.internal.k.f(packageFqName, "packageFqName");
        if (!packageFqName.equals(f)) {
            return EmptySet.f4895a;
        }
        return N.Q((C1642k) S0.b.g1(this.c, e[0]));
    }
}
