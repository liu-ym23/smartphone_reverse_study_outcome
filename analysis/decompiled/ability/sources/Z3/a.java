package Z3;

import java.util.List;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final List f1584a;
    public final boolean b;

    public a(List apps, boolean z10) {
        k.f(apps, "apps");
        this.f1584a = apps;
        this.b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.b(this.f1584a, aVar.f1584a) && this.b == aVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.f1584a.hashCode() * 31);
    }

    public final String toString() {
        return "LocalScanResult(apps=" + this.f1584a + ", localSaved=" + this.b + ")";
    }
}
