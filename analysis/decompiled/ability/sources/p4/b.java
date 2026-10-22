package p4;

import kotlin.jvm.internal.k;
import s4.f;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final f f5539a;
    public final long b;

    public b(f fVar, long j5) {
        this.f5539a = fVar;
        this.b = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.b(this.f5539a, bVar.f5539a) && this.b == bVar.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.f5539a.hashCode() * 31);
    }

    public final String toString() {
        return "Entry(table=" + this.f5539a + ", at=" + this.b + ")";
    }
}
