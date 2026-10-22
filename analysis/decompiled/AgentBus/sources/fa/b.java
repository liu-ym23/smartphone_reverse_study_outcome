package fa;

import d7.d0;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class b implements j, c {

    /* renamed from: a, reason: collision with root package name */
    public final j f3615a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3616b;

    public b(j jVar, int i2) {
        q7.k.e(jVar, "sequence");
        this.f3615a = jVar;
        this.f3616b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // fa.c
    public final j a(int i2) {
        int i10 = this.f3616b + i2;
        return i10 < 0 ? new b(this, i2) : new b(this.f3615a, i10);
    }

    @Override // fa.j
    public final Iterator iterator() {
        return new d0(this);
    }
}
