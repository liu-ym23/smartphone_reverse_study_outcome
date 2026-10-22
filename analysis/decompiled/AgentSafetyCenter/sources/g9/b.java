package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: a, reason: collision with root package name */
    public int f4406a;

    /* renamed from: b, reason: collision with root package name */
    public String f4407b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4406a == bVar.f4406a && this.f4407b.equals(bVar.f4407b);
    }

    public final int hashCode() {
        return this.f4407b.hashCode() + (Integer.hashCode(this.f4406a) * 31);
    }

    public final String toString() {
        return "Fail(code=" + this.f4406a + ", message=" + this.f4407b + ")";
    }
}
