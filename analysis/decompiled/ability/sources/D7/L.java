package D7;

/* loaded from: classes3.dex */
public final class L extends AbstractC0210b {
    public int c;
    public int d;
    public final /* synthetic */ M e;

    public L(M m) {
        this.e = m;
        this.c = m.size();
        this.d = m.c;
    }

    @Override // D7.AbstractC0210b
    public final void a() {
        int i = this.c;
        if (i == 0) {
            this.f400a = 2;
            return;
        }
        M m = this.e;
        Object[] objArr = m.f398a;
        int i6 = this.d;
        this.b = objArr[i6];
        this.f400a = 1;
        this.d = (i6 + 1) % m.b;
        this.c = i - 1;
    }
}
