package r8;

import D7.v;
import W8.l;
import X8.A;
import X8.w;
import Z7.t;
import h8.InterfaceC1503K;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import t8.C2024a;
import x8.InterfaceC2118a;

/* renamed from: r8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1880b implements s8.f {
    public static final /* synthetic */ t[] e;

    /* renamed from: a, reason: collision with root package name */
    public final G8.c f5680a;
    public final InterfaceC1503K b;
    public final W8.h c;
    public final InterfaceC2118a d;

    static {
        n nVar = m.f4928a;
        e = new t[]{nVar.g(new PropertyReference1Impl(nVar.b(C1880b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    }

    public C1880b(K1.a c, n8.d dVar, G8.c fqName) {
        k.f(c, "c");
        C2024a c2024a = (C2024a) c.f903a;
        k.f(fqName, "fqName");
        this.f5680a = fqName;
        this.b = dVar != null ? c2024a.f6671j.b(dVar) : InterfaceC1503K.f4577I;
        l lVar = c2024a.f6670a;
        J4.e eVar = new J4.e(16, c, this);
        W8.i iVar = (W8.i) lVar;
        iVar.getClass();
        this.c = new W8.h(iVar, eVar);
        this.d = dVar != null ? (InterfaceC2118a) v.B0(dVar.b()) : null;
    }

    @Override // i8.InterfaceC1556b
    public Map a() {
        return kotlin.collections.a.M();
    }

    @Override // i8.InterfaceC1556b
    public final G8.c b() {
        return this.f5680a;
    }

    @Override // i8.InterfaceC1556b
    public final InterfaceC1503K getSource() {
        return this.b;
    }

    @Override // i8.InterfaceC1556b
    public final w getType() {
        return (A) S0.b.g1(this.c, e[0]);
    }
}
