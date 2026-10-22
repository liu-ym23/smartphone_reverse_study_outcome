package Da;

import kotlin.jvm.internal.k;
import za.e;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final e f449a;
    public long b;

    public a(e eVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f449a = eVar;
        this.b = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.b(this.f449a, aVar.f449a) && this.b == aVar.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.f449a.hashCode() * 31);
    }

    public final String toString() {
        return "SessionEntry(session=" + this.f449a + ", lastAccessTime=" + this.b + ")";
    }
}
