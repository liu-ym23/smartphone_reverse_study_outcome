package Ea;

import kotlin.jvm.internal.k;
import stepai.aios.guiagent.takeover.TakeoverOperationType;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f503a;
    public final String b;
    public final long c;
    public final TakeoverOperationType d;
    public boolean e;
    public boolean f;

    public e(String sessionId, String reason, long j5, TakeoverOperationType takeoverOperationType) {
        k.f(sessionId, "sessionId");
        k.f(reason, "reason");
        this.f503a = sessionId;
        this.b = reason;
        this.c = j5;
        this.d = takeoverOperationType;
        this.e = true;
        this.f = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return k.b(this.f503a, eVar.f503a) && k.b(this.b, eVar.b) && this.c == eVar.c && this.d == eVar.d && this.e == eVar.e && this.f == eVar.f;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f) + androidx.appfunctions.metadata.a.d((this.d.hashCode() + androidx.appfunctions.metadata.a.c(B7.a.c(this.f503a.hashCode() * 31, 31, this.b), 31, this.c)) * 31, 31, this.e);
    }

    public final String toString() {
        boolean z10 = this.e;
        boolean z11 = this.f;
        StringBuilder sbW = B7.a.w("TakeoverOperation(sessionId=", this.f503a, ", reason=", this.b, ", startTime=");
        sbW.append(this.c);
        sbW.append(", type=");
        sbW.append(this.d);
        sbW.append(", _isActive=");
        sbW.append(z10);
        sbW.append(", _isTimeout=");
        sbW.append(z11);
        sbW.append(")");
        return sbW.toString();
    }
}
