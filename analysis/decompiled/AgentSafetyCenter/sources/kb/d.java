package kb;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends e implements RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public final e f7394f;

    /* renamed from: g, reason: collision with root package name */
    public final int f7395g;

    /* renamed from: h, reason: collision with root package name */
    public final int f7396h;

    public d(e eVar, int i, int i3) {
        this.f7394f = eVar;
        this.f7395g = i;
        td.h.i(i, i3, eVar.a());
        this.f7396h = i3 - i;
    }

    @Override // jb.n
    public final int a() {
        return this.f7396h;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i3 = this.f7396h;
        if (i < 0 || i >= i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return null;
        }
        return this.f7394f.get(this.f7395g + i);
    }

    @Override // kb.e, java.util.List
    public final List subList(int i, int i3) {
        td.h.i(i, i3, this.f7396h);
        int i10 = this.f7395g;
        return new d(this.f7394f, i + i10, i10 + i3);
    }
}
