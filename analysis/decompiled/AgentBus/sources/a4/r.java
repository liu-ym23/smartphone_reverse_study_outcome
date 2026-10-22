package a4;

import java.util.Objects;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Class f199a;

    /* renamed from: b, reason: collision with root package name */
    public final i4.a f200b;

    public r(Class cls, i4.a aVar) {
        this.f199a = cls;
        this.f200b = aVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return rVar.f199a.equals(this.f199a) && rVar.f200b.equals(this.f200b);
    }

    public final int hashCode() {
        return Objects.hash(this.f199a, this.f200b);
    }

    public final String toString() {
        return this.f199a.getSimpleName() + ", object identifier: " + this.f200b;
    }
}
