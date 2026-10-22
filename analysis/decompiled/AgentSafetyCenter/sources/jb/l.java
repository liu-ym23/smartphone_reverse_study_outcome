package jb;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Serializable f6769c;

    /* renamed from: f, reason: collision with root package name */
    public final Serializable f6770f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f6771g;

    public l(Serializable serializable, Serializable serializable2, Object obj) {
        this.f6769c = serializable;
        this.f6770f = serializable2;
        this.f6771g = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f6769c.equals(lVar.f6769c) && this.f6770f.equals(lVar.f6770f) && this.f6771g.equals(lVar.f6771g);
    }

    public final int hashCode() {
        return this.f6771g.hashCode() + ((this.f6770f.hashCode() + (this.f6769c.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "(" + this.f6769c + ", " + this.f6770f + ", " + this.f6771g + ')';
    }
}
