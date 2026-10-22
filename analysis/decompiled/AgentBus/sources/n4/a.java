package n4;

import java.util.Map;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f6837a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6838b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6839c;

    public a(String str, String str2, Map map) {
        this.f6837a = str;
        this.f6838b = str2;
        this.f6839c = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6837a.equals(aVar.f6837a) && k.a(this.f6838b, aVar.f6838b) && this.f6839c.equals(aVar.f6839c);
    }

    public final int hashCode() {
        int iHashCode = this.f6837a.hashCode() * 31;
        String str = this.f6838b;
        return this.f6839c.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("AgentAttachment(kind=", this.f6837a, ", uri=", this.f6838b, ", metadata=");
        sbP.append(this.f6839c);
        sbP.append(")");
        return sbP.toString();
    }
}
