package Ea;

import stepai.aios.guiagent.takeover.TakeoverErrorType;

/* loaded from: classes4.dex */
public final class b extends d {

    /* renamed from: a, reason: collision with root package name */
    public final TakeoverErrorType f501a;
    public final String b;
    public final boolean c;

    public b(TakeoverErrorType takeoverErrorType, String str, boolean z10) {
        this.f501a = takeoverErrorType;
        this.b = str;
        this.c = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f501a == bVar.f501a && this.b.equals(bVar.b) && this.c == bVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + B7.a.c(this.f501a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Failure(errorType=");
        sb.append(this.f501a);
        sb.append(", message=");
        sb.append(this.b);
        sb.append(", canRetry=");
        return B7.a.s(sb, this.c, ")");
    }
}
