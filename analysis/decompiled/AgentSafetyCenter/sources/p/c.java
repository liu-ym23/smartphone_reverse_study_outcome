package p;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Iterator, Map.Entry {

    /* renamed from: c, reason: collision with root package name */
    public int f9525c;

    /* renamed from: f, reason: collision with root package name */
    public int f9526f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9527g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ e f9528h;

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        e eVar = this.f9528h;
        if (!this.f9527g) {
            od.f.e("This container does not support retaining Map.Entry objects");
            return false;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return yb.k.a(entry.getKey(), eVar.e(this.f9526f)) && yb.k.a(entry.getValue(), eVar.h(this.f9526f));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f9527g) {
            return this.f9528h.e(this.f9526f);
        }
        od.f.e("This container does not support retaining Map.Entry objects");
        return null;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f9527g) {
            return this.f9528h.h(this.f9526f);
        }
        od.f.e("This container does not support retaining Map.Entry objects");
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9526f < this.f9525c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        e eVar = this.f9528h;
        if (!this.f9527g) {
            od.f.e("This container does not support retaining Map.Entry objects");
            return 0;
        }
        Object objE = eVar.e(this.f9526f);
        Object objH = eVar.h(this.f9526f);
        return (objE == null ? 0 : objE.hashCode()) ^ (objH != null ? objH.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            g5.f.k();
            return null;
        }
        this.f9526f++;
        this.f9527g = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f9527g) {
            throw new IllegalStateException();
        }
        this.f9528h.f(this.f9526f);
        this.f9526f--;
        this.f9525c--;
        this.f9527g = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f9527g) {
            return this.f9528h.g(this.f9526f, obj);
        }
        od.f.e("This container does not support retaining Map.Entry objects");
        return null;
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
