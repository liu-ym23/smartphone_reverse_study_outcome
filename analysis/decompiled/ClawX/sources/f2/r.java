package f2;

import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2579a;

    /* renamed from: b, reason: collision with root package name */
    public final m2.a f2580b;

    public r(Class cls, m2.a aVar) {
        this.f2579a = cls;
        this.f2580b = aVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return rVar.f2579a.equals(this.f2579a) && rVar.f2580b.equals(this.f2580b);
    }

    public final int hashCode() {
        return Objects.hash(this.f2579a, this.f2580b);
    }

    public final String toString() {
        return this.f2579a.getSimpleName() + ", object identifier: " + this.f2580b;
    }
}
