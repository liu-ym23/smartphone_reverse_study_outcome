package za;

import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.Action;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6998a;
    public final Action b;
    public final String c;
    public final long d;
    public final boolean e;
    public final boolean f;

    public a(boolean z10, Action action, String str, long j5, int i) {
        j5 = (i & 8) != 0 ? 0L : j5;
        boolean z11 = (i & 16) == 0;
        boolean z12 = (i & 32) == 0;
        k.f(action, "action");
        this.f6998a = z10;
        this.b = action;
        this.c = str;
        this.d = j5;
        this.e = z11;
        this.f = z12;
    }

    public final long a() {
        return this.d;
    }

    public final boolean b() {
        return this.f6998a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6998a == aVar.f6998a && k.b(this.b, aVar.b) && this.c.equals(aVar.c) && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f) + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.c(B7.a.c((this.b.hashCode() + (Boolean.hashCode(this.f6998a) * 31)) * 31, 31, this.c), 31, this.d), 31, this.e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ActionExecutionResult(success=");
        sb.append(this.f6998a);
        sb.append(", action=");
        sb.append(this.b);
        sb.append(", errorMessage=");
        B7.a.y(this.d, this.c, ", executionTime=", sb);
        sb.append(", isTakeoverRequested=");
        sb.append(this.e);
        sb.append(", isStopRequested=");
        sb.append(this.f);
        sb.append(")");
        return sb.toString();
    }
}
