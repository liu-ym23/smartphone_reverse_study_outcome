package z5;

import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f11821a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11822b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11823c;

    public i(String str, String str2, String str3) {
        this.f11821a = str;
        this.f11822b = str2;
        this.f11823c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return k.a(this.f11821a, iVar.f11821a) && k.a(this.f11822b, iVar.f11822b) && k.a(this.f11823c, iVar.f11823c);
    }

    public final int hashCode() {
        return this.f11823c.hashCode() + x.g(this.f11822b, this.f11821a.hashCode() * 31, 31);
    }

    public final String toString() {
        return a1.a.m(a1.a.p("Context(traceId=", this.f11821a, ", agentId=", this.f11822b, ", sessionId="), this.f11823c, ")");
    }
}
