package F5;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final long f552a;
    public final long b;
    public final LinkedHashMap c;

    public e(long j5, long j6, LinkedHashMap linkedHashMap) {
        this.f552a = j5;
        this.b = j6;
        this.c = linkedHashMap;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f552a == eVar.f552a && this.b == eVar.b && k.b(this.c, eVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + androidx.appfunctions.metadata.a.c(Long.hashCode(this.f552a) * 31, 31, this.b);
    }

    public final String toString() {
        return "BucketRecord(startMs=" + this.f552a + ", endMs=" + this.b + ", json=" + this.c + ")";
    }
}
