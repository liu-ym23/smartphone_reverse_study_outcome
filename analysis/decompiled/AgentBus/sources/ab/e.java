package ab;

import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f525c = new e(d7.r.q1(new ArrayList()), null);

    /* renamed from: a, reason: collision with root package name */
    public final Set f526a;

    /* renamed from: b, reason: collision with root package name */
    public final w7.e0 f527b;

    public e(Set set, w7.e0 e0Var) {
        this.f526a = set;
        this.f527b = e0Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return q7.k.a(eVar.f526a, this.f526a) && q7.k.a(eVar.f527b, this.f527b);
    }

    public final int hashCode() {
        int iHashCode = (this.f526a.hashCode() + 1517) * 41;
        w7.e0 e0Var = this.f527b;
        return iHashCode + (e0Var != null ? e0Var.hashCode() : 0);
    }
}
