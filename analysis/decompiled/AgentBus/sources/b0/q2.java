package b0;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class q2 implements Iterable, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final p2 f1322f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1323g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1324h;

    public q2(p2 p2Var, int i2, int i10) {
        this.f1322f = p2Var;
        this.f1323g = i2;
        this.f1324h = i10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        p2 p2Var = this.f1322f;
        if (p2Var.f1313m != this.f1324h) {
            r2.f();
        }
        int i2 = this.f1323g;
        p2Var.j(i2);
        return new p0(p2Var, i2 + 1, r2.a(i2, p2Var.f1306f) + i2);
    }
}
