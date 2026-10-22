package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public String f10192a;

    /* renamed from: b, reason: collision with root package name */
    public long f10193b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f10192a.equals(wVar.f10192a) && this.f10193b == wVar.f10193b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f10193b) + (this.f10192a.hashCode() * 31);
    }

    public final String toString() {
        return "InterceptReadEntity(rowKey=" + this.f10192a + ", viewedAtMillis=" + this.f10193b + ")";
    }
}
