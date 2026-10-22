package l3;

/* loaded from: classes3.dex */
public final class n extends p {
    public final /* synthetic */ int e;
    public volatile long f;
    public y g;
    public y h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Object obj, int i, y yVar, int i6) {
        super(obj, i, yVar);
        this.e = i6;
    }

    @Override // l3.h, l3.y
    public void a(y yVar) {
        switch (this.e) {
            case 0:
                this.h = yVar;
                break;
            default:
                super.a(yVar);
                break;
        }
    }

    @Override // l3.h, l3.y
    public y b() {
        switch (this.e) {
            case 0:
                return this.h;
            default:
                return super.b();
        }
    }

    @Override // l3.h, l3.y
    public y c() {
        switch (this.e) {
            case 1:
                return this.g;
            default:
                return super.c();
        }
    }

    @Override // l3.h, l3.y
    public y e() {
        switch (this.e) {
            case 0:
                return this.g;
            default:
                return super.e();
        }
    }

    @Override // l3.h, l3.y
    public y f() {
        switch (this.e) {
            case 1:
                return this.h;
            default:
                return super.f();
        }
    }

    @Override // l3.h, l3.y
    public long h() {
        switch (this.e) {
            case 1:
                return this.f;
            default:
                return super.h();
        }
    }

    @Override // l3.h, l3.y
    public void i(y yVar) {
        switch (this.e) {
            case 0:
                this.g = yVar;
                break;
            default:
                super.i(yVar);
                break;
        }
    }

    @Override // l3.h, l3.y
    public void j(long j5) {
        switch (this.e) {
            case 0:
                this.f = j5;
                break;
            default:
                super.j(j5);
                break;
        }
    }

    @Override // l3.h, l3.y
    public long l() {
        switch (this.e) {
            case 0:
                return this.f;
            default:
                return super.l();
        }
    }

    @Override // l3.h, l3.y
    public void m(long j5) {
        switch (this.e) {
            case 1:
                this.f = j5;
                break;
            default:
                super.m(j5);
                break;
        }
    }

    @Override // l3.h, l3.y
    public void n(y yVar) {
        switch (this.e) {
            case 1:
                this.h = yVar;
                break;
            default:
                super.n(yVar);
                break;
        }
    }

    @Override // l3.h, l3.y
    public void o(y yVar) {
        switch (this.e) {
            case 1:
                this.g = yVar;
                break;
            default:
                super.o(yVar);
                break;
        }
    }
}
