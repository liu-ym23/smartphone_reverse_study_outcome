package a4;

import java.util.Objects;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Class f188a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f189b;

    public n(Class cls, Class cls2) {
        this.f188a = cls;
        this.f189b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.f188a.equals(this.f188a) && nVar.f189b.equals(this.f189b);
    }

    public final int hashCode() {
        return Objects.hash(this.f188a, this.f189b);
    }

    public final String toString() {
        return this.f188a.getSimpleName() + " with primitive type: " + this.f189b.getSimpleName();
    }
}
