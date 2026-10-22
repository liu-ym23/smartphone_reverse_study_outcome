package m0;

import q7.k;
import w7.e0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f6122a;

    public b(e0 e0Var, Integer num) {
        this.f6122a = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return k.a(null, null) && k.a(this.f6122a, ((b) obj).f6122a);
        }
        return false;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "ComposeStackTraceFrame(sourceInfo=" + ((Object) null) + ", groupOffset=" + this.f6122a + ')';
    }
}
