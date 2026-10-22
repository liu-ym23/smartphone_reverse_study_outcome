package f8;

import java.util.List;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final e9.b f3462a;

    /* renamed from: b, reason: collision with root package name */
    public final List f3463b;

    public b0(e9.b bVar, List list) {
        q7.k.e(bVar, "classId");
        this.f3462a = bVar;
        this.f3463b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return q7.k.a(this.f3462a, b0Var.f3462a) && q7.k.a(this.f3463b, b0Var.f3463b);
    }

    public final int hashCode() {
        return this.f3463b.hashCode() + (this.f3462a.hashCode() * 31);
    }

    public final String toString() {
        return "ClassRequest(classId=" + this.f3462a + ", typeParametersCount=" + this.f3463b + ')';
    }
}
