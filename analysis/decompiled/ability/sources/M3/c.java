package M3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f965a;
    public final String b;
    public final Object c;
    public final Map d;

    public c(int i, String str, Object obj, LinkedHashMap linkedHashMap) {
        this.f965a = i;
        this.b = str;
        this.c = obj;
        this.d = linkedHashMap;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f965a == cVar.f965a && k.b(this.b, cVar.b) && k.b(this.c, cVar.c) && k.b(this.d, cVar.d);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f965a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Object obj = this.c;
        int iHashCode3 = (iHashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
        Map map = this.d;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(this.f965a, "SplitPayload(code=", ", content=", this.b, ", structuredContent=");
        sbK.append(this.c);
        sbK.append(", meta=");
        sbK.append(this.d);
        sbK.append(")");
        return sbK.toString();
    }
}
