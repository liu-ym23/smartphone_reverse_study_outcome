package l3;

import java.util.Map;

/* loaded from: classes3.dex */
public final class x implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5284a;
    public Object b;
    public final /* synthetic */ com.google.common.cache.e c;

    public x(com.google.common.cache.e eVar, Object obj, Object obj2) {
        this.c = eVar;
        this.f5284a = obj;
        this.b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (this.f5284a.equals(entry.getKey()) && this.b.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5284a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.b.hashCode() ^ this.f5284a.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object objPut = this.c.put(this.f5284a, obj);
        this.b = obj;
        return objPut;
    }

    public final String toString() {
        return this.f5284a + "=" + this.b;
    }
}
