package q2;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f11498a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11499b;

    public k(String workSpecId, int i10) {
        kotlin.jvm.internal.g.f(workSpecId, "workSpecId");
        this.f11498a = workSpecId;
        this.f11499b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kotlin.jvm.internal.g.b(this.f11498a, kVar.f11498a) && this.f11499b == kVar.f11499b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11499b) + (this.f11498a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("WorkGenerationalId(workSpecId=");
        sb2.append(this.f11498a);
        sb2.append(", generation=");
        return a0.a.l(sb2, this.f11499b, ')');
    }
}
