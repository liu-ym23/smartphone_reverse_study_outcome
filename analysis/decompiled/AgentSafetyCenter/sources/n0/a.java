package n0;

import java.util.List;
import kb.e;
import o0.c;
import p5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: f, reason: collision with root package name */
    public final c f8617f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8618g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8619h;

    public a(c cVar, int i, int i3) {
        this.f8617f = cVar;
        this.f8618g = i;
        f.m(i, i3, cVar.a());
        this.f8619h = i3 - i;
    }

    @Override // jb.n
    public final int a() {
        return this.f8619h;
    }

    @Override // java.util.List
    public final Object get(int i) {
        f.j(i, this.f8619h);
        return this.f8617f.get(this.f8618g + i);
    }

    @Override // kb.e, java.util.List
    public final List subList(int i, int i3) {
        f.m(i, i3, this.f8619h);
        int i10 = this.f8618g;
        return new a(this.f8617f, i + i10, i10 + i3);
    }
}
