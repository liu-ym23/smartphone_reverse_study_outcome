package s4;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f5983a;
    public final boolean b;
    public final String c;

    public d(String str, boolean z10, String groupId) {
        k.f(groupId, "groupId");
        this.f5983a = str;
        this.b = z10;
        this.c = groupId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.b(this.f5983a, dVar.f5983a) && this.b == dVar.b && k.b(this.c, dVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + androidx.appfunctions.metadata.a.d(this.f5983a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return B7.a.q(androidx.constraintlayout.core.dsl.a.l("ScopeDef(dataLevel=", this.f5983a, ", redline=", ", groupId=", this.b), this.c, ")");
    }
}
