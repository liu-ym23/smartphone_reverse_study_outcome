package c9;

import kotlin.jvm.internal.k;

/* renamed from: c9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0888a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2103a;
    public final Object b;

    public C0888a(Object obj, Object obj2) {
        this.f2103a = obj;
        this.b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0888a)) {
            return false;
        }
        C0888a c0888a = (C0888a) obj;
        return k.b(this.f2103a, c0888a.f2103a) && k.b(this.b, c0888a.b);
    }

    public final int hashCode() {
        Object obj = this.f2103a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ApproximationBounds(lower=");
        sb.append(this.f2103a);
        sb.append(", upper=");
        return androidx.compose.foundation.b.t(sb, this.b, ')');
    }
}
