package i;

import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3080a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3081b;

    /* renamed from: c, reason: collision with root package name */
    public c f3082c;
    public c d;

    public c(Object obj, Object obj2) {
        this.f3080a = obj;
        this.f3081b = obj2;
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
        return this.f3080a.equals(cVar.f3080a) && this.f3081b.equals(cVar.f3081b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f3080a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f3081b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f3081b.hashCode() ^ this.f3080a.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f3080a + "=" + this.f3081b;
    }
}
