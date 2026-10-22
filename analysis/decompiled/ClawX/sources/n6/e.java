package n6;

import java.util.ArrayList;
import java.util.Set;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f4010c = new e(c5.m.R0(new ArrayList()), null);

    /* renamed from: a, reason: collision with root package name */
    public final Set f4011a;

    /* renamed from: b, reason: collision with root package name */
    public final z6.d f4012b;

    public e(Set set, z6.d dVar) {
        this.f4011a = set;
        this.f4012b = dVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return kotlin.jvm.internal.p.a(eVar.f4011a, this.f4011a) && kotlin.jvm.internal.p.a(eVar.f4012b, this.f4012b);
    }

    public final int hashCode() {
        int iHashCode = (this.f4011a.hashCode() + 1517) * 41;
        z6.d dVar = this.f4012b;
        return iHashCode + (dVar != null ? dVar.hashCode() : 0);
    }
}
