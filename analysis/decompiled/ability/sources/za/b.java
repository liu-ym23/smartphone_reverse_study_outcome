package za;

import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f6999a;

    public b(String pathDesc) {
        k.f(pathDesc, "pathDesc");
        this.f6999a = pathDesc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && k.b(this.f6999a, ((b) obj).f6999a);
    }

    public final int hashCode() {
        return this.f6999a.hashCode();
    }

    public final String toString() {
        return B7.a.m("ActionPath(pathDesc=", this.f6999a, ")");
    }
}
