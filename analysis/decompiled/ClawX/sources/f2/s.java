package f2;

import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2581a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f2582b;

    public s(Class cls, Class cls2) {
        this.f2581a = cls;
        this.f2582b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return sVar.f2581a.equals(this.f2581a) && sVar.f2582b.equals(this.f2582b);
    }

    public final int hashCode() {
        return Objects.hash(this.f2581a, this.f2582b);
    }

    public final String toString() {
        return this.f2581a.getSimpleName() + " with serialization type: " + this.f2582b.getSimpleName();
    }
}
