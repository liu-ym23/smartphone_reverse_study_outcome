package d7;

import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class e extends f implements RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public final f f2957f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2958g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2959h;

    public e(f fVar, int i2, int i10) {
        this.f2957f = fVar;
        this.f2958g = i2;
        s7.a.h(i2, i10, fVar.a());
        this.f2959h = i10 - i2;
    }

    @Override // d7.a
    public final int a() {
        return this.f2959h;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        int i10 = this.f2959h;
        if (i2 < 0 || i2 >= i10) {
            throw new IndexOutOfBoundsException(m.x.k("index: ", i2, i10, ", size: "));
        }
        return this.f2957f.get(this.f2958g + i2);
    }
}
