package ec;

import java.lang.invoke.VarHandle;
import java.util.Iterator;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements d, Iterable, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public char f3753c;

    /* renamed from: f, reason: collision with root package name */
    public char f3754f;

    /* renamed from: g, reason: collision with root package name */
    public int f3755g = 1;

    static {
        new b((char) 1, (char) 0);
    }

    public b(char c9, char c10) {
        this.f3753c = c9;
        this.f3754f = (char) com.stepos.statsrpk.h.r(c9, c10, 1);
    }

    @Override // ec.d
    public final Comparable a() {
        return Character.valueOf(this.f3753c);
    }

    @Override // ec.d
    public final Comparable b() {
        return Character.valueOf(this.f3754f);
    }

    public final boolean equals(Object obj) {
        char c9 = this.f3754f;
        char c10 = this.f3753c;
        if (!(obj instanceof b)) {
            return false;
        }
        if (k.b(c10, c9) > 0) {
            b bVar = (b) obj;
            if (k.b(bVar.f3753c, bVar.f3754f) > 0) {
                return true;
            }
        }
        b bVar2 = (b) obj;
        return c10 == bVar2.f3753c && c9 == bVar2.f3754f;
    }

    public final int hashCode() {
        char c9 = this.f3753c;
        char c10 = this.f3754f;
        if (k.b(c9, c10) > 0) {
            return -1;
        }
        return (c9 * 31) + c10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        char c9 = this.f3753c;
        char c10 = this.f3754f;
        int i = this.f3755g;
        boolean z10 = false;
        a aVar = new a(0);
        aVar.f3750f = i;
        aVar.f3751g = c10;
        if (i <= 0 ? k.b(c9, c10) >= 0 : k.b(c9, c10) <= 0) {
            z10 = true;
        }
        aVar.f3752h = z10;
        if (!z10) {
            c9 = c10;
        }
        aVar.i = c9;
        VarHandle.storeStoreFence();
        return aVar;
    }

    public final String toString() {
        return this.f3753c + ".." + this.f3754f;
    }
}
