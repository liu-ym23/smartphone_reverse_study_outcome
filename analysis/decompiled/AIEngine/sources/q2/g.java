package q2;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f11493a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11494b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11495c;

    public g(String workSpecId, int i10, int i11) {
        kotlin.jvm.internal.g.f(workSpecId, "workSpecId");
        this.f11493a = workSpecId;
        this.f11494b = i10;
        this.f11495c = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.g.b(this.f11493a, gVar.f11493a) && this.f11494b == gVar.f11494b && this.f11495c == gVar.f11495c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11495c) + ai.onnxruntime.a.d(this.f11494b, this.f11493a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SystemIdInfo(workSpecId=");
        sb2.append(this.f11493a);
        sb2.append(", generation=");
        sb2.append(this.f11494b);
        sb2.append(", systemId=");
        return a0.a.l(sb2, this.f11495c, ')');
    }
}
