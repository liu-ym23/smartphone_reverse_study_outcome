package w7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public String f15298a;

    /* renamed from: b, reason: collision with root package name */
    public c8.a f15299b;

    /* renamed from: c, reason: collision with root package name */
    public n f15300c;

    /* renamed from: d, reason: collision with root package name */
    public c8.a f15301d;

    /* renamed from: e, reason: collision with root package name */
    public Object[] f15302e;

    /* renamed from: f, reason: collision with root package name */
    public String f15303f;

    /* renamed from: g, reason: collision with root package name */
    public Supplier f15304g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap f15305h;

    public final String a() {
        return (String) this.f15304g.get();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.f15298a;
        String str2 = eVar.f15298a;
        if (str != null) {
            if (!str.equals(str2)) {
                return false;
            }
        } else if (str2 != null) {
            return false;
        }
        c8.a aVar = this.f15301d;
        c8.a aVar2 = eVar.f15301d;
        if (aVar != null) {
            if (!aVar.equals(aVar2)) {
                return false;
            }
        } else if (aVar2 != null) {
            return false;
        }
        c8.a aVar3 = this.f15299b;
        c8.a aVar4 = eVar.f15299b;
        if (aVar3 != null) {
            if (!aVar3.equals(aVar4)) {
                return false;
            }
        } else if (aVar4 != null) {
            return false;
        }
        HashMap map = this.f15305h;
        HashMap map2 = eVar.f15305h;
        if (map != null) {
            if (!map.equals(map2)) {
                return false;
            }
        } else if (map2 != null) {
            return false;
        }
        String str3 = this.f15303f;
        String str4 = eVar.f15303f;
        if (str3 != null) {
            if (!str3.equals(str4)) {
                return false;
            }
        } else if (str4 != null) {
            return false;
        }
        return Arrays.equals(this.f15302e, eVar.f15302e);
    }

    public final int hashCode() {
        String str = this.f15298a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        c8.a aVar = this.f15301d;
        int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        c8.a aVar2 = this.f15299b;
        int iHashCode3 = (iHashCode2 + (aVar2 != null ? aVar2.hashCode() : 0)) * 31;
        HashMap map = this.f15305h;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Object[] objArr = this.f15302e;
        int iHashCode5 = (iHashCode4 + (objArr != null ? Arrays.hashCode(objArr) : 0)) * 31;
        String str2 = this.f15303f;
        return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        c8.a aVar = this.f15301d;
        if (aVar != null) {
            sb2.append(aVar.toString());
        } else {
            n nVar = this.f15300c;
            if (nVar != null) {
                sb2.append(nVar.toString());
            }
        }
        sb2.append(": ");
        sb2.append((String) this.f15304g.get());
        return sb2.toString();
    }
}
