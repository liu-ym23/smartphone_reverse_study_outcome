package g0;

import java.util.Map;

/* loaded from: classes.dex */
public class a implements Map.Entry, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3667f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3668g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f3669h;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f3667f = i2;
        this.f3668g = obj;
        this.f3669h = obj2;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        switch (this.f3667f) {
            case 0:
                Map.Entry entry = obj instanceof Map.Entry ? (Map.Entry) obj : null;
                return entry != null && q7.k.a(entry.getKey(), this.f3668g) && q7.k.a(entry.getValue(), getValue());
            default:
                return super.equals(obj);
        }
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        switch (this.f3667f) {
        }
        return this.f3668g;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        switch (this.f3667f) {
        }
        return this.f3669h;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        switch (this.f3667f) {
            case 0:
                Object obj = this.f3668g;
                int iHashCode = obj != null ? obj.hashCode() : 0;
                Object value = getValue();
                return iHashCode ^ (value != null ? value.hashCode() : 0);
            default:
                return super.hashCode();
        }
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        switch (this.f3667f) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public String toString() {
        switch (this.f3667f) {
            case 0:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f3668g);
                sb2.append('=');
                sb2.append(getValue());
                return sb2.toString();
            default:
                return super.toString();
        }
    }
}
