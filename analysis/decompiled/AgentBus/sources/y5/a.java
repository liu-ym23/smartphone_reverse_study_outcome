package y5;

import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11668a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11669b;

    public a(String str, String str2) {
        this.f11668a = str;
        this.f11669b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f11668a, aVar.f11668a) && k.a(this.f11669b, aVar.f11669b);
    }

    public final int hashCode() {
        String str = this.f11668a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f11669b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return x.x("BffWakeEvent(packageName=", this.f11668a, ", traceId=", this.f11669b, ")");
    }
}
