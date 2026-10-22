package D9;

import C9.AbstractC0200b;

/* loaded from: classes4.dex */
public final class h extends C4.a {
    public final AbstractC0200b e;
    public int f;

    public h(B1.b bVar, AbstractC0200b abstractC0200b) {
        super(bVar);
        this.e = abstractC0200b;
    }

    @Override // C4.a
    public final void h() {
        this.b = true;
        this.f++;
    }

    @Override // C4.a
    public final void i() {
        this.b = false;
        p("\n");
        int i = this.f;
        for (int i6 = 0; i6 < i; i6++) {
            p(this.e.f321a.f);
        }
    }

    @Override // C4.a
    public final void j() {
        if (this.b) {
            this.b = false;
        } else {
            i();
        }
    }

    @Override // C4.a
    public final void s() {
        l(' ');
    }

    @Override // C4.a
    public final void t() {
        this.f--;
    }
}
