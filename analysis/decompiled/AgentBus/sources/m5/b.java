package m5;

import java.util.Map;
import m.x;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f6378a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6379b;

    /* renamed from: c, reason: collision with root package name */
    public final a f6380c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f6381d;

    public b(long j2, String str, a aVar, Map map) {
        q7.k.e(aVar, "level");
        this.f6378a = j2;
        this.f6379b = str;
        this.f6380c = aVar;
        this.f6381d = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6378a == bVar.f6378a && this.f6379b.equals(bVar.f6379b) && this.f6380c == bVar.f6380c && this.f6381d.equals(bVar.f6381d);
    }

    public final int hashCode() {
        return this.f6381d.hashCode() + ((this.f6380c.hashCode() + x.g(this.f6379b, Long.hashCode(this.f6378a) * 31, 31)) * 31);
    }

    public final String toString() {
        return "AuditRecord(timestamp=" + this.f6378a + ", event=" + this.f6379b + ", level=" + this.f6380c + ", attrs=" + this.f6381d + ")";
    }
}
