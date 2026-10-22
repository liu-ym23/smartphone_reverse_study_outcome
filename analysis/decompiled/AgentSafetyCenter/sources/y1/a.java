package y1;

import i1.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public f f15875a;

    /* renamed from: b, reason: collision with root package name */
    public int f15876b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f15875a.equals(aVar.f15875a) && this.f15876b == aVar.f15876b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f15876b) + (this.f15875a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ImageVectorEntry(imageVector=");
        sb2.append(this.f15875a);
        sb2.append(", configFlags=");
        return androidx.activity.b.l(sb2, this.f15876b, ')');
    }
}
