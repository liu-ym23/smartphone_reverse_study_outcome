package y5;

import q7.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f11677a;

    public c(String str) {
        this.f11677a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && k.a(this.f11677a, ((c) obj).f11677a);
    }

    public final int hashCode() {
        String str = this.f11677a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return a1.a.j("CloudWakeEvent(traceId=", this.f11677a, ")");
    }
}
