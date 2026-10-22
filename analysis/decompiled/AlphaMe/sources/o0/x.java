package o0;

/* loaded from: classes.dex */
public final class x extends t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13774a;

    /* renamed from: b, reason: collision with root package name */
    public final y f13775b;

    public x(y yVar, int i4) {
        this.f13774a = i4;
        if (i4 != 1) {
            this.f13775b = yVar;
        } else {
            this.f13775b = yVar;
        }
    }

    @Override // o0.t, o0.q
    public final void d(s sVar) {
        switch (this.f13774a) {
            case 0:
                this.f13775b.f13776B.remove(sVar);
                if (!this.f13775b.s()) {
                    s sVar2 = this.f13775b;
                    sVar2.w(sVar2, r.f13736h0);
                    s sVar3 = this.f13775b;
                    sVar3.f13760r = true;
                    sVar3.w(sVar3, r.f13735g0);
                    break;
                }
                break;
        }
    }

    @Override // o0.t, o0.q
    public final void e(s sVar) {
        switch (this.f13774a) {
            case 1:
                y yVar = this.f13775b;
                if (!yVar.f13779E) {
                    yVar.I();
                    this.f13775b.f13779E = true;
                    break;
                }
                break;
        }
    }

    @Override // o0.q
    public final void f(s sVar) {
        switch (this.f13774a) {
            case 1:
                y yVar = this.f13775b;
                int i4 = yVar.f13778D - 1;
                yVar.f13778D = i4;
                if (i4 == 0) {
                    yVar.f13779E = false;
                    yVar.m();
                }
                sVar.y(this);
                break;
        }
    }
}
