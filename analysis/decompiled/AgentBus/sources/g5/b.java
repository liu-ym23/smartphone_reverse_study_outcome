package g5;

import d7.z;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f3848c;

    /* renamed from: a, reason: collision with root package name */
    public final Object f3849a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3850b;

    static {
        z zVar = z.f2978f;
        f3848c = new b(zVar, zVar);
    }

    public b(List list, List list2) {
        this.f3849a = list;
        this.f3850b = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3849a.equals(bVar.f3849a) && this.f3850b.equals(bVar.f3850b);
    }

    public final int hashCode() {
        return this.f3850b.hashCode() + (this.f3849a.hashCode() * 31);
    }

    public final String toString() {
        return "CapsUpdate(added=" + this.f3849a + ", removed=" + this.f3850b + ")";
    }
}
