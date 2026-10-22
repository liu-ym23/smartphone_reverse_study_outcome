package f2;

import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2569a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f2570b;

    public n(Class cls, Class cls2) {
        this.f2569a = cls;
        this.f2570b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.f2569a.equals(this.f2569a) && nVar.f2570b.equals(this.f2570b);
    }

    public final int hashCode() {
        return Objects.hash(this.f2569a, this.f2570b);
    }

    public final String toString() {
        return this.f2569a.getSimpleName() + " with primitive type: " + this.f2570b.getSimpleName();
    }
}
