package u3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f6697a;
    public final A3.a b;
    public final j c;
    public final A3.a d;
    public final Object[] e;
    public final String f;
    public final Supplier g;
    public final Map h;

    public e(String str, A3.a aVar, j jVar, A3.a aVar2, Object[] objArr, HashMap map, String str2, Supplier supplier) {
        this.f6697a = str;
        this.d = aVar2;
        this.c = jVar;
        this.b = aVar;
        this.e = objArr;
        this.h = map;
        this.f = str2;
        this.g = supplier;
    }

    public final String a() {
        return (String) this.g.get();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        String str = eVar.f;
        Map map = eVar.h;
        A3.a aVar = eVar.b;
        A3.a aVar2 = eVar.d;
        String str2 = eVar.f6697a;
        String str3 = this.f6697a;
        if (str3 == null ? str2 != null : !str3.equals(str2)) {
            return false;
        }
        A3.a aVar3 = this.d;
        if (aVar3 == null ? aVar2 != null : !aVar3.equals(aVar2)) {
            return false;
        }
        A3.a aVar4 = this.b;
        if (aVar4 == null ? aVar != null : !aVar4.equals(aVar)) {
            return false;
        }
        Map map2 = this.h;
        if (map2 == null ? map != null : !map2.equals(map)) {
            return false;
        }
        String str4 = this.f;
        if (str4 == null ? str == null : str4.equals(str)) {
            return Arrays.equals(this.e, eVar.e);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f6697a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        A3.a aVar = this.d;
        int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        A3.a aVar2 = this.b;
        int iHashCode3 = (iHashCode2 + (aVar2 != null ? aVar2.hashCode() : 0)) * 31;
        Map map = this.h;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Object[] objArr = this.e;
        int iHashCode5 = (iHashCode4 + (objArr != null ? Arrays.hashCode(objArr) : 0)) * 31;
        String str2 = this.f;
        return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        A3.a aVar = this.d;
        if (aVar != null) {
            sb.append(aVar.toString());
        } else {
            j jVar = this.c;
            if (jVar != null) {
                sb.append(jVar.toString());
            }
        }
        sb.append(": ");
        sb.append((String) this.g.get());
        return sb.toString();
    }
}
