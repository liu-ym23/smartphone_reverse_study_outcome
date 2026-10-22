package e0;

import d7.f;
import f0.c;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: f, reason: collision with root package name */
    public final c f3042f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3043g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3044h;

    public a(c cVar, int i2, int i10) {
        this.f3042f = cVar;
        this.f3043g = i2;
        a.a.i(i2, i10, cVar.a());
        this.f3044h = i10 - i2;
    }

    @Override // d7.a
    public final int a() {
        return this.f3044h;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        a.a.g(i2, this.f3044h);
        return this.f3042f.get(this.f3043g + i2);
    }

    @Override // d7.f, java.util.List
    public final List subList(int i2, int i10) {
        a.a.i(i2, i10, this.f3044h);
        int i11 = this.f3043g;
        return new a(this.f3042f, i2 + i11, i11 + i10);
    }
}
