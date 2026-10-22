package t9;

import d7.i0;

/* loaded from: classes.dex */
public final class l extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9819g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n f9820h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ o f9821i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(n nVar, o oVar, int i2) {
        super(0);
        this.f9819g = i2;
        this.f9820h = nVar;
        this.f9821i = oVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f9819g) {
            case 0:
                return i0.Y(this.f9820h.f9825a.keySet(), this.f9821i.o());
            default:
                return i0.Y(this.f9820h.f9826b.keySet(), this.f9821i.p());
        }
    }
}
