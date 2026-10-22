package k0;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g2 implements Iterable, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final f2 f6920c;

    /* renamed from: f, reason: collision with root package name */
    public final int f6921f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6922g;

    public g2(f2 f2Var, int i, int i3) {
        this.f6920c = f2Var;
        this.f6921f = i;
        this.f6922g = i3;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        f2 f2Var = this.f6920c;
        if (f2Var.f6906l != this.f6922g) {
            h2.f();
        }
        int i = this.f6921f;
        f2Var.f(i);
        return new p0(f2Var, i + 1, h2.a(f2Var.f6900c, i) + i);
    }
}
