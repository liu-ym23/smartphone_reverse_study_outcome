package o7;

import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements Map.Entry {

    /* renamed from: c, reason: collision with root package name */
    public m f9265c;

    /* renamed from: f, reason: collision with root package name */
    public m f9266f;

    /* renamed from: g, reason: collision with root package name */
    public m f9267g;

    /* renamed from: h, reason: collision with root package name */
    public m f9268h;
    public m i;

    /* renamed from: j, reason: collision with root package name */
    public Object f9269j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9270k;

    /* renamed from: l, reason: collision with root package name */
    public Object f9271l;

    /* renamed from: m, reason: collision with root package name */
    public int f9272m = 1;

    public m(boolean z10, m mVar, Object obj, m mVar2, m mVar3) {
        this.f9265c = mVar;
        this.f9269j = obj;
        this.f9270k = z10;
        this.f9268h = mVar2;
        this.i = mVar3;
        mVar3.f9268h = this;
        mVar2.i = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f9269j;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.f9271l;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9269j;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f9271l;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f9269j;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f9271l;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.f9270k) {
            g5.f.g("value == null");
            return null;
        }
        Object obj2 = this.f9271l;
        this.f9271l = obj;
        return obj2;
    }

    public final String toString() {
        return this.f9269j + "=" + this.f9271l;
    }
}
