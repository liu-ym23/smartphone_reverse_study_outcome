package p4;

import kotlin.jvm.internal.k;
import s4.e;

/* renamed from: p4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1791a {

    /* renamed from: a, reason: collision with root package name */
    public final e f5538a;
    public final long b;

    public C1791a(e eVar, long j5) {
        this.f5538a = eVar;
        this.b = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1791a)) {
            return false;
        }
        C1791a c1791a = (C1791a) obj;
        return k.b(this.f5538a, c1791a.f5538a) && this.b == c1791a.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.f5538a.hashCode() * 31);
    }

    public final String toString() {
        return "Entry(rules=" + this.f5538a + ", at=" + this.b + ")";
    }
}
