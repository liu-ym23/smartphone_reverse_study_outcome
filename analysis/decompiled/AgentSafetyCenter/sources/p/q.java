package p;

import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class q implements Map.Entry, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9611c = 0;

    /* renamed from: f, reason: collision with root package name */
    public Object f9612f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9613g;

    public q(Object obj, Object obj2) {
        this.f9612f = obj;
        this.f9613g = obj2;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        switch (this.f9611c) {
            case 1:
                Map.Entry entry = obj instanceof Map.Entry ? (Map.Entry) obj : null;
                return entry != null && yb.k.a(entry.getKey(), this.f9612f) && yb.k.a(entry.getValue(), getValue());
            default:
                return super.equals(obj);
        }
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        switch (this.f9611c) {
        }
        return this.f9612f;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        switch (this.f9611c) {
        }
        return this.f9613g;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        switch (this.f9611c) {
            case 1:
                Object obj = this.f9612f;
                int iHashCode = obj != null ? obj.hashCode() : 0;
                Object value = getValue();
                return iHashCode ^ (value != null ? value.hashCode() : 0);
            default:
                return super.hashCode();
        }
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        switch (this.f9611c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public String toString() {
        switch (this.f9611c) {
            case 1:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f9612f);
                sb2.append('=');
                sb2.append(getValue());
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ q() {
    }
}
