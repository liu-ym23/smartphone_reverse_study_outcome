package n8;

import java.util.Collection;
import kotlin.collections.EmptyList;
import x8.InterfaceC2119b;

/* loaded from: classes4.dex */
public final class r extends l implements InterfaceC2119b {

    /* renamed from: a, reason: collision with root package name */
    public final G8.c f5363a;

    public r(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        this.f5363a = fqName;
    }

    @Override // x8.InterfaceC2119b
    public final d a(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return kotlin.jvm.internal.k.b(this.f5363a, ((r) obj).f5363a);
        }
        return false;
    }

    @Override // x8.InterfaceC2119b
    public final Collection getAnnotations() {
        return EmptyList.f4893a;
    }

    public final int hashCode() {
        return this.f5363a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.dsl.a.z(sb, r.class, ": ");
        sb.append(this.f5363a);
        return sb.toString();
    }
}
