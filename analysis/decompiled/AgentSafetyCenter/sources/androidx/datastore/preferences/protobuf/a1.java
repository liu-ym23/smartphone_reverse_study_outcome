package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a1 implements Iterator {

    /* renamed from: c, reason: collision with root package name */
    public int f1083c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1084f;

    /* renamed from: g, reason: collision with root package name */
    public Iterator f1085g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ y0 f1086h;

    public final Iterator a() {
        if (this.f1085g == null) {
            this.f1085g = this.f1086h.f1225f.entrySet().iterator();
        }
        return this.f1085g;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f1083c + 1;
        y0 y0Var = this.f1086h;
        return i < y0Var.f1224c.size() || (!y0Var.f1225f.isEmpty() && a().hasNext());
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.f1084f = true;
        int i = this.f1083c + 1;
        this.f1083c = i;
        y0 y0Var = this.f1086h;
        return i < y0Var.f1224c.size() ? (Map.Entry) y0Var.f1224c.get(this.f1083c) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        y0 y0Var = this.f1086h;
        if (!this.f1084f) {
            od.f.e("remove() was called before next()");
            return;
        }
        this.f1084f = false;
        int i = y0.f1223j;
        y0Var.b();
        if (this.f1083c >= y0Var.f1224c.size()) {
            a().remove();
            return;
        }
        int i3 = this.f1083c;
        this.f1083c = i3 - 1;
        y0Var.h(i3);
    }
}
