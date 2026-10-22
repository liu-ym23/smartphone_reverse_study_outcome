package ba;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class s extends a {

    /* renamed from: f, reason: collision with root package name */
    public final v9.g f1627f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1628g;

    public s(int i2, v9.g gVar) {
        this.f1627f = gVar;
        this.f1628g = i2;
    }

    @Override // ba.a
    public final int a() {
        return 1;
    }

    @Override // ba.a
    public final void f(int i2, v9.g gVar) {
        throw new IllegalStateException();
    }

    @Override // ba.a
    public final Object get(int i2) {
        if (i2 == this.f1628g) {
            return this.f1627f;
        }
        return null;
    }

    @Override // ba.a, java.lang.Iterable
    public final Iterator iterator() {
        return new r(0, this);
    }
}
