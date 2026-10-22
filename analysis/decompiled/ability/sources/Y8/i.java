package Y8;

import X8.N;
import X8.w;
import h8.InterfaceC1507O;
import h8.InterfaceC1524g;
import java.util.Collection;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class i implements K8.b {

    /* renamed from: a, reason: collision with root package name */
    public final N f1576a;
    public S7.a b;
    public final i c;
    public final InterfaceC1507O d;
    public final Object e;

    public i(N projection, S7.a aVar, i iVar, InterfaceC1507O interfaceC1507O) {
        kotlin.jvm.internal.k.f(projection, "projection");
        this.f1576a = projection;
        this.b = aVar;
        this.c = iVar;
        this.d = interfaceC1507O;
        this.e = kotlin.a.b(LazyThreadSafetyMode.b, new I8.e(this, 12));
    }

    @Override // K8.b
    public final N a() {
        return this.f1576a;
    }

    @Override // X8.K
    public final e8.i c() {
        w wVarB = this.f1576a.b();
        kotlin.jvm.internal.k.e(wVarB, "getType(...)");
        return U7.a.x(wVarB);
    }

    @Override // X8.K
    public final InterfaceC1524g d() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // X8.K
    public final Collection e() {
        Collection collection = (List) this.e.getF4884a();
        if (collection == null) {
            collection = EmptyList.f4893a;
        }
        return collection;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!i.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        i iVar = (i) obj;
        i iVar2 = this.c;
        if (iVar2 != null) {
            this = iVar2;
        }
        i iVar3 = iVar.c;
        if (iVar3 != null) {
            obj = iVar3;
        }
        return this == obj;
    }

    @Override // X8.K
    public final boolean f() {
        return false;
    }

    @Override // X8.K
    public final List getParameters() {
        return EmptyList.f4893a;
    }

    public final int hashCode() {
        i iVar = this.c;
        return iVar != null ? iVar.hashCode() : super.hashCode();
    }

    public final String toString() {
        return "CapturedType(" + this.f1576a + ')';
    }

    public /* synthetic */ i(N n, V8.e eVar, InterfaceC1507O interfaceC1507O, int i) {
        this(n, (i & 2) != 0 ? null : eVar, (i) null, (i & 8) != 0 ? null : interfaceC1507O);
    }
}
