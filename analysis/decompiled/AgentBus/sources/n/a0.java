package n;

import b0.b3;
import b0.o1;

/* loaded from: classes.dex */
public final class a0 implements b3 {

    /* renamed from: f, reason: collision with root package name */
    public Number f6527f;

    /* renamed from: g, reason: collision with root package name */
    public Number f6528g;

    /* renamed from: h, reason: collision with root package name */
    public final q6.b f6529h;

    /* renamed from: i, reason: collision with root package name */
    public final o1 f6530i;

    /* renamed from: j, reason: collision with root package name */
    public s0 f6531j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6532k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6533l;

    /* renamed from: m, reason: collision with root package name */
    public long f6534m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d0 f6535n;

    public a0(d0 d0Var, Number number, Number number2, q6.b bVar, z zVar) {
        this.f6535n = d0Var;
        this.f6527f = number;
        this.f6528g = number2;
        this.f6529h = bVar;
        this.f6530i = b0.b.n(number);
        this.f6531j = new s0(zVar, bVar, this.f6527f, this.f6528g, null);
    }

    @Override // b0.b3
    public final Object getValue() {
        return this.f6530i.getValue();
    }
}
