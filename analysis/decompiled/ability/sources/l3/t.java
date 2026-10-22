package l3;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes3.dex */
public final class t extends v {
    public final /* synthetic */ int d;
    public volatile long e;
    public y f;
    public y g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(ReferenceQueue referenceQueue, Object obj, int i, y yVar, int i6) {
        super(referenceQueue, obj, i, yVar);
        this.d = i6;
    }

    @Override // l3.v, l3.y
    public void a(y yVar) {
        switch (this.d) {
            case 0:
                this.g = yVar;
                break;
            default:
                super.a(yVar);
                break;
        }
    }

    @Override // l3.v, l3.y
    public y b() {
        switch (this.d) {
            case 0:
                return this.g;
            default:
                return super.b();
        }
    }

    @Override // l3.v, l3.y
    public y c() {
        switch (this.d) {
            case 1:
                return this.f;
            default:
                return super.c();
        }
    }

    @Override // l3.v, l3.y
    public y e() {
        switch (this.d) {
            case 0:
                return this.f;
            default:
                return super.e();
        }
    }

    @Override // l3.v, l3.y
    public y f() {
        switch (this.d) {
            case 1:
                return this.g;
            default:
                return super.f();
        }
    }

    @Override // l3.v, l3.y
    public long h() {
        switch (this.d) {
            case 1:
                return this.e;
            default:
                return super.h();
        }
    }

    @Override // l3.v, l3.y
    public void i(y yVar) {
        switch (this.d) {
            case 0:
                this.f = yVar;
                break;
            default:
                super.i(yVar);
                break;
        }
    }

    @Override // l3.v, l3.y
    public void j(long j5) {
        switch (this.d) {
            case 0:
                this.e = j5;
                break;
            default:
                super.j(j5);
                break;
        }
    }

    @Override // l3.v, l3.y
    public long l() {
        switch (this.d) {
            case 0:
                return this.e;
            default:
                return super.l();
        }
    }

    @Override // l3.v, l3.y
    public void m(long j5) {
        switch (this.d) {
            case 1:
                this.e = j5;
                break;
            default:
                super.m(j5);
                break;
        }
    }

    @Override // l3.v, l3.y
    public void n(y yVar) {
        switch (this.d) {
            case 1:
                this.g = yVar;
                break;
            default:
                super.n(yVar);
                break;
        }
    }

    @Override // l3.v, l3.y
    public void o(y yVar) {
        switch (this.d) {
            case 1:
                this.f = yVar;
                break;
            default:
                super.o(yVar);
                break;
        }
    }
}
