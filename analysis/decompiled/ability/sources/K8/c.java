package K8;

import H4.o;
import X8.N;
import X8.w;
import Y8.i;
import h8.InterfaceC1524g;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final N f910a;
    public i b;

    public c(N projection) {
        k.f(projection, "projection");
        this.f910a = projection;
        projection.a();
        Variance variance = Variance.c;
    }

    @Override // K8.b
    public final N a() {
        return this.f910a;
    }

    @Override // X8.K
    public final e8.i c() {
        e8.i iVarC = this.f910a.b().Q().c();
        k.e(iVarC, "getBuiltIns(...)");
        return iVarC;
    }

    @Override // X8.K
    public final /* bridge */ /* synthetic */ InterfaceC1524g d() {
        return null;
    }

    @Override // X8.K
    public final Collection e() {
        N n = this.f910a;
        w wVarB = n.a() == Variance.e ? n.b() : c().o();
        k.c(wVarB);
        return o.M(wVarB);
    }

    @Override // X8.K
    public final boolean f() {
        return false;
    }

    @Override // X8.K
    public final List getParameters() {
        return EmptyList.f4893a;
    }

    public final String toString() {
        return "CapturedTypeConstructor(" + this.f910a + ')';
    }
}
