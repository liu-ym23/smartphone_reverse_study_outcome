package q4;

import q7.k;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f8640a;

    public a(String str) {
        k.e(str, "reason");
        this.f8640a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && k.a(this.f8640a, ((a) obj).f8640a);
    }

    public final int hashCode() {
        return this.f8640a.hashCode();
    }

    public final String toString() {
        return a1.a.j("Offline(reason=", this.f8640a, ")");
    }
}
