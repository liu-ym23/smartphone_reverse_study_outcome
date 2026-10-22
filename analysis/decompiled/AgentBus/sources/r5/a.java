package r5;

import java.util.Map;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8983a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f8984b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8985c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8986d;

    public a(boolean z4, Map map, String str, String str2, int i2) {
        map = (i2 & 2) != 0 ? null : map;
        str = (i2 & 4) != 0 ? null : str;
        str2 = (i2 & 8) != 0 ? null : str2;
        this.f8983a = z4;
        this.f8984b = map;
        this.f8985c = str;
        this.f8986d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8983a == aVar.f8983a && k.a(this.f8984b, aVar.f8984b) && k.a(this.f8985c, aVar.f8985c) && k.a(this.f8986d, aVar.f8986d);
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f8983a) * 31;
        Map map = this.f8984b;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.f8985c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f8986d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "LocalInvokeOutcome(ok=" + this.f8983a + ", payload=" + this.f8984b + ", errorCode=" + this.f8985c + ", errorMessage=" + this.f8986d + ")";
    }
}
