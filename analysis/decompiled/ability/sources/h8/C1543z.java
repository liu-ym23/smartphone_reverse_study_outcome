package h8;

import java.util.List;

/* renamed from: h8.z, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1543z {

    /* renamed from: a, reason: collision with root package name */
    public final G8.b f4592a;
    public final List b;

    public C1543z(G8.b classId, List typeParametersCount) {
        kotlin.jvm.internal.k.f(classId, "classId");
        kotlin.jvm.internal.k.f(typeParametersCount, "typeParametersCount");
        this.f4592a = classId;
        this.b = typeParametersCount;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1543z)) {
            return false;
        }
        C1543z c1543z = (C1543z) obj;
        return kotlin.jvm.internal.k.b(this.f4592a, c1543z.f4592a) && kotlin.jvm.internal.k.b(this.b, c1543z.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f4592a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ClassRequest(classId=");
        sb.append(this.f4592a);
        sb.append(", typeParametersCount=");
        return B7.a.r(sb, this.b, ')');
    }
}
