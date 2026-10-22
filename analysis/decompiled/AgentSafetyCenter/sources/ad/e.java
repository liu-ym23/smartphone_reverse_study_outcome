package ad;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f465c;

    /* renamed from: a, reason: collision with root package name */
    public Set f466a;

    /* renamed from: b, reason: collision with root package name */
    public md.c f467b;

    static {
        Set setO0 = kb.l.O0(new ArrayList());
        e eVar = new e();
        eVar.f466a = setO0;
        eVar.f467b = null;
        VarHandle.storeStoreFence();
        f465c = eVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return eVar.f466a.equals(this.f466a) && yb.k.a(eVar.f467b, this.f467b);
    }

    public final int hashCode() {
        int iHashCode = (this.f466a.hashCode() + 1517) * 41;
        md.c cVar = this.f467b;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }
}
