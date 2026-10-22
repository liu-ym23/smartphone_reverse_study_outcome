package ec;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public long f3762c;

    /* renamed from: f, reason: collision with root package name */
    public long f3763f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3764g;

    /* renamed from: h, reason: collision with root package name */
    public long f3765h;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3764g;
    }

    @Override // java.util.Iterator
    public final Object next() {
        long j10 = this.f3765h;
        if (j10 != this.f3763f) {
            this.f3765h = this.f3762c + j10;
        } else {
            if (!this.f3764g) {
                g5.f.k();
                return null;
            }
            this.f3764g = false;
        }
        return Long.valueOf(j10);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
