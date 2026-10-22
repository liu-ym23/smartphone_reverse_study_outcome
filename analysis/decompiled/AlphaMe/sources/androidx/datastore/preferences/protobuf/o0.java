package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class o0 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f3521a = -1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3522b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f3523c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k0 f3524d;

    public o0(k0 k0Var) {
        this.f3524d = k0Var;
    }

    public final Iterator a() {
        if (this.f3523c == null) {
            this.f3523c = this.f3524d.f3503c.entrySet().iterator();
        }
        return this.f3523c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i4 = this.f3521a + 1;
        k0 k0Var = this.f3524d;
        if (i4 >= k0Var.f3502b.size()) {
            return !k0Var.f3503c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.f3522b = true;
        int i4 = this.f3521a + 1;
        this.f3521a = i4;
        k0 k0Var = this.f3524d;
        return i4 < k0Var.f3502b.size() ? (Map.Entry) k0Var.f3502b.get(this.f3521a) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f3522b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f3522b = false;
        int i4 = k0.f3500g;
        k0 k0Var = this.f3524d;
        k0Var.b();
        if (this.f3521a >= k0Var.f3502b.size()) {
            a().remove();
            return;
        }
        int i5 = this.f3521a;
        this.f3521a = i5 - 1;
        k0Var.n(i5);
    }
}
