package o;

import androidx.lifecycle.w;
import androidx.lifecycle.y;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Map.Entry {

    /* renamed from: c, reason: collision with root package name */
    public w f8963c;

    /* renamed from: f, reason: collision with root package name */
    public y f8964f;

    /* renamed from: g, reason: collision with root package name */
    public c f8965g;

    /* renamed from: h, reason: collision with root package name */
    public c f8966h;

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f8963c.equals(cVar.f8963c) && this.f8964f.equals(cVar.f8964f);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f8963c;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f8964f;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f8964f.hashCode() ^ this.f8963c.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f8963c + "=" + this.f8964f;
    }
}
