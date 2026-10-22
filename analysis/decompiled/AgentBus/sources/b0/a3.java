package b0;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class a3 implements Iterable, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final p2 f1101f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1102g;

    /* renamed from: h, reason: collision with root package name */
    public final b f1103h;

    public a3(p2 p2Var, int i2, q0 q0Var, b bVar) {
        this.f1101f = p2Var;
        this.f1102g = i2;
        this.f1103h = bVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new p0(this.f1101f, this.f1102g, null, this.f1103h);
    }
}
