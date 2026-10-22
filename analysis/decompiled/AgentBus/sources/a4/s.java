package a4;

import java.util.Objects;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final Class f201a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f202b;

    public s(Class cls, Class cls2) {
        this.f201a = cls;
        this.f202b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return sVar.f201a.equals(this.f201a) && sVar.f202b.equals(this.f202b);
    }

    public final int hashCode() {
        return Objects.hash(this.f201a, this.f202b);
    }

    public final String toString() {
        return this.f201a.getSimpleName() + " with serialization type: " + this.f202b.getSimpleName();
    }
}
