package G8;

import com.fasterxml.jackson.core.JsonPointer;
import j9.t;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final c f686a;
    public final f b;

    static {
        c.j(h.f);
    }

    public a(c packageName, f fVar) {
        k.f(packageName, "packageName");
        this.f686a = packageName;
        this.b = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.b(this.f686a, aVar.f686a) && this.b.equals(aVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + ((this.f686a.hashCode() + 527) * 961);
    }

    public final String toString() {
        String str = t.b0(this.f686a.b(), '.', JsonPointer.SEPARATOR) + "/" + this.b;
        k.e(str, "toString(...)");
        return str;
    }
}
