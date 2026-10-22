package j;

import java.util.Map;

/* loaded from: classes.dex */
public final class c implements Map.Entry {

    /* renamed from: f, reason: collision with root package name */
    public final Object f5055f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f5056g;

    /* renamed from: h, reason: collision with root package name */
    public c f5057h;

    /* renamed from: i, reason: collision with root package name */
    public c f5058i;

    public c(Object obj, Object obj2) {
        this.f5055f = obj;
        this.f5056g = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5055f.equals(cVar.f5055f) && this.f5056g.equals(cVar.f5056g);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5055f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f5056g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f5056g.hashCode() ^ this.f5055f.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f5055f + "=" + this.f5056g;
    }
}
