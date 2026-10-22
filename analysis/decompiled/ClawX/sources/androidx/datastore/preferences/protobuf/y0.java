package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y0 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f584a = -1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f585b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f586c;
    public final /* synthetic */ w0 d;

    public y0(w0 w0Var) {
        this.d = w0Var;
    }

    public final Iterator a() {
        if (this.f586c == null) {
            this.f586c = this.d.f576b.entrySet().iterator();
        }
        return this.f586c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i8 = this.f584a + 1;
        w0 w0Var = this.d;
        return i8 < w0Var.f575a.size() || (!w0Var.f576b.isEmpty() && a().hasNext());
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.f585b = true;
        int i8 = this.f584a + 1;
        this.f584a = i8;
        w0 w0Var = this.d;
        return i8 < w0Var.f575a.size() ? (Map.Entry) w0Var.f575a.get(this.f584a) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f585b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f585b = false;
        int i8 = w0.f574f;
        w0 w0Var = this.d;
        w0Var.b();
        if (this.f584a >= w0Var.f575a.size()) {
            a().remove();
            return;
        }
        int i9 = this.f584a;
        this.f584a = i9 - 1;
        w0Var.h(i9);
    }
}
