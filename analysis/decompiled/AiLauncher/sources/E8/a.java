package E8;

import java.util.Map;

/* loaded from: classes4.dex */
public class a implements Map.Entry<String, String>, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f2408a;

    /* renamed from: b, reason: collision with root package name */
    public String f2409b;

    /* renamed from: c, reason: collision with root package name */
    public b f2410c;

    public a(String str, String str2, b bVar) {
        D8.b.f(str);
        this.f2408a = str.trim();
        D8.b.e(str);
        this.f2409b = str2;
        this.f2410c = bVar;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // java.util.Map.Entry
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return this.f2408a;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f2408a;
            if (str == null ? aVar.f2408a != null : !str.equals(aVar.f2408a)) {
                return false;
            }
            String str2 = this.f2409b;
            if (str2 != null) {
                return str2.equals(aVar.f2409b);
            }
            if (aVar.f2409b == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String getValue() {
        return this.f2409b;
    }

    @Override // java.util.Map.Entry
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public String setValue(String str) {
        int iT;
        String strR = this.f2410c.r(this.f2408a);
        b bVar = this.f2410c;
        if (bVar != null && (iT = bVar.t(this.f2408a)) != -1) {
            this.f2410c.f2414c[iT] = str;
        }
        this.f2409b = str;
        return strR;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.f2408a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f2409b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
