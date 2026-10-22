package l3;

/* loaded from: classes3.dex */
public final class i extends h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5274a;
    public y b;
    public y c;

    private final void p(long j5) {
    }

    private final void q(long j5) {
    }

    @Override // l3.h, l3.y
    public void a(y yVar) {
        switch (this.f5274a) {
            case 0:
                this.c = yVar;
                break;
            default:
                super.a(yVar);
                break;
        }
    }

    @Override // l3.h, l3.y
    public y b() {
        switch (this.f5274a) {
            case 0:
                return this.c;
            default:
                return super.b();
        }
    }

    @Override // l3.h, l3.y
    public y c() {
        switch (this.f5274a) {
            case 1:
                return this.b;
            default:
                return super.c();
        }
    }

    @Override // l3.h, l3.y
    public y e() {
        switch (this.f5274a) {
            case 0:
                return this.b;
            default:
                return super.e();
        }
    }

    @Override // l3.h, l3.y
    public y f() {
        switch (this.f5274a) {
            case 1:
                return this.c;
            default:
                return super.f();
        }
    }

    @Override // l3.h, l3.y
    public long h() {
        switch (this.f5274a) {
            case 1:
                return Long.MAX_VALUE;
            default:
                return super.h();
        }
    }

    @Override // l3.h, l3.y
    public void i(y yVar) {
        switch (this.f5274a) {
            case 0:
                this.b = yVar;
                break;
            default:
                super.i(yVar);
                break;
        }
    }

    @Override // l3.h, l3.y
    public void j(long j5) {
        switch (this.f5274a) {
            case 0:
                break;
            default:
                super.j(j5);
                break;
        }
    }

    @Override // l3.h, l3.y
    public long l() {
        switch (this.f5274a) {
            case 0:
                return Long.MAX_VALUE;
            default:
                return super.l();
        }
    }

    @Override // l3.h, l3.y
    public void m(long j5) {
        switch (this.f5274a) {
            case 1:
                break;
            default:
                super.m(j5);
                break;
        }
    }

    @Override // l3.h, l3.y
    public void n(y yVar) {
        switch (this.f5274a) {
            case 1:
                this.c = yVar;
                break;
            default:
                super.n(yVar);
                break;
        }
    }

    @Override // l3.h, l3.y
    public void o(y yVar) {
        switch (this.f5274a) {
            case 1:
                this.b = yVar;
                break;
            default:
                super.o(yVar);
                break;
        }
    }
}
