package w2;

import q7.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f10655a;

    public d(String str) {
        k.e(str, "name");
        this.f10655a = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        return k.a(this.f10655a, ((d) obj).f10655a);
    }

    public final int hashCode() {
        return this.f10655a.hashCode();
    }

    public final String toString() {
        return this.f10655a;
    }
}
