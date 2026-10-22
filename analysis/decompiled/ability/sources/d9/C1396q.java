package d9;

import X8.C0276g;
import java.util.Iterator;

/* renamed from: d9.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1396q extends AbstractC1380a {

    /* renamed from: a, reason: collision with root package name */
    public final C0276g f4315a;
    public final int b;

    public C1396q(int i, C0276g c0276g) {
        this.f4315a = c0276g;
        this.b = i;
    }

    @Override // d9.AbstractC1380a
    public final int b() {
        return 1;
    }

    @Override // d9.AbstractC1380a
    public final void e(int i, C0276g c0276g) {
        throw new IllegalStateException();
    }

    @Override // d9.AbstractC1380a
    public final Object get(int i) {
        if (i == this.b) {
            return this.f4315a;
        }
        return null;
    }

    @Override // d9.AbstractC1380a, java.lang.Iterable
    public final Iterator iterator() {
        return new g9.h(this, 2);
    }
}
