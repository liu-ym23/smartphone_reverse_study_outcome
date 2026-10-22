package a6;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final Set f272a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f273b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f274c;

    public a0(HashSet hashSet, Set set, Boolean bool) {
        this.f272a = hashSet;
        this.f273b = set;
        this.f274c = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return q7.k.a(this.f272a, a0Var.f272a) && q7.k.a(this.f273b, a0Var.f273b) && q7.k.a(this.f274c, a0Var.f274c);
    }

    public final int hashCode() {
        Set set = this.f272a;
        int iHashCode = (set == null ? 0 : set.hashCode()) * 31;
        Set set2 = this.f273b;
        int iHashCode2 = (iHashCode + (set2 == null ? 0 : set2.hashCode())) * 31;
        Boolean bool = this.f274c;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "ToolFilter(types=" + this.f272a + ", tagsAny=" + this.f273b + ", enabled=" + this.f274c + ")";
    }
}
