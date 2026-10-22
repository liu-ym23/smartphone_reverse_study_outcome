package k0;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p0 implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7004c = 0;

    /* renamed from: f, reason: collision with root package name */
    public final f2 f7005f;

    /* renamed from: g, reason: collision with root package name */
    public final int f7006g;

    /* renamed from: h, reason: collision with root package name */
    public int f7007h;
    public int i;

    public p0(f2 f2Var, int i, int i3) {
        this.f7005f = f2Var;
        this.f7006g = i3;
        this.f7007h = i;
        this.i = f2Var.f6906l;
        if (f2Var.f6905k) {
            h2.f();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f7004c) {
            case 0:
                return this.f7007h < this.f7006g;
            default:
                throw null;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f7004c) {
            case 0:
                f2 f2Var = this.f7005f;
                int i = f2Var.f6906l;
                int i3 = this.i;
                if (i != i3) {
                    h2.f();
                }
                int i10 = this.f7007h;
                this.f7007h = h2.a(f2Var.f6900c, i10) + i10;
                return new g2(f2Var, i10, i3);
            default:
                throw null;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f7004c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public p0(f2 f2Var, int i, q0 q0Var, z zVar) {
        this.f7005f = f2Var;
        this.f7006g = i;
        this.f7007h = f2Var.f6906l;
    }
}
