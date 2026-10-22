package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: SimpleItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class y extends RecyclerView.e {
    private static final String TAG = "SimpleItemAnimator";
    boolean h;

    public abstract boolean a(RecyclerView.u r1);

    public abstract boolean a(RecyclerView.u r1, int r2, int r3, int r4, int r5);

    public abstract boolean a(RecyclerView.u r1, RecyclerView.u r2, int r3, int r4, int r5, int r6);

    public abstract boolean b(RecyclerView.u r1);

    public void c(RecyclerView.u r1, boolean r2) {
    }

    public void d(RecyclerView.u r1, boolean r2) {
    }

    public void o(RecyclerView.u r1) {
    }

    public void p(RecyclerView.u r1) {
    }

    public void q(RecyclerView.u r1) {
    }

    public void r(RecyclerView.u r1) {
    }

    public void s(RecyclerView.u r1) {
    }

    public void t(RecyclerView.u r1) {
    }

    public y() {
        this.h = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public boolean h(RecyclerView.u r1) {
        if (this.h == true) goto L5;
    L8:
        return true;
    L5:
        if (r1.q() == true) goto L8;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public boolean a(RecyclerView.u r7, RecyclerView.e.c r8, RecyclerView.e.c r9) {
        int r2 = r8.f2342a;
        int r3 = r8.f2343b;
        View r10 = r7.f2390a;
        if (r9 != null) goto L5;
        int r0 = r10.getLeft();
    L6:
        int r4 = r0;
        if (r9 != null) goto L9;
        int r11 = r10.getTop();
    L10:
        int r5 = r11;
        if (r7.t() == true) goto L17;
        if (r2 != r4) goto L14;
        if (r3 == r5) goto L17;
    L14:
        r10.layout(r4, r5, r10.getWidth() + r4, r10.getHeight() + r5);
        return a(r7, r2, r3, r4, r5);
    L17:
        return a(r7);
    L9:
        r11 = r9.f2343b;
        goto L10
    L5:
        r0 = r9.f2342a;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public boolean b(RecyclerView.u r9, RecyclerView.e.c r10, RecyclerView.e.c r11) {
        if (r10 == null) goto L10;
        if (r10.f2342a != r11.f2342a) goto L8;
        if (r10.f2343b == r11.f2343b) goto L10;
    L8:
        return a(r9, r10.f2342a, r10.f2343b, r11.f2342a, r11.f2343b);
    L10:
        return b(r9);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public boolean c(RecyclerView.u r7, RecyclerView.e.c r8, RecyclerView.e.c r9) {
        if (r8.f2342a != r9.f2342a) goto L10;
        if (r8.f2343b != r9.f2343b) goto L10;
        j(r7);
        return false;
    L10:
        return a(r7, r8.f2342a, r8.f2343b, r9.f2342a, r9.f2343b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public boolean a(RecyclerView.u r8, RecyclerView.u r9, RecyclerView.e.c r10, RecyclerView.e.c r11) {
        int r3 = r10.f2342a;
        int r4 = r10.f2343b;
        if (r9.c() == false) goto L5;
        int r12 = r10.f2342a;
        int r6 = r10.f2343b;
        int r5 = r12;
    L7:
        return a(r8, r9, r3, r4, r5, r6);
    L5:
        int r13 = r11.f2342a;
        r5 = r13;
        r6 = r11.f2343b;
        goto L7
    }

    public final void i(RecyclerView.u r1) {
        p(r1);
        f(r1);
    }

    public final void j(RecyclerView.u r1) {
        t(r1);
        f(r1);
    }

    public final void k(RecyclerView.u r1) {
        r(r1);
        f(r1);
    }

    public final void a(RecyclerView.u r1, boolean r2) {
        d(r1, r2);
        f(r1);
    }

    public final void l(RecyclerView.u r1) {
        o(r1);
    }

    public final void m(RecyclerView.u r1) {
        s(r1);
    }

    public final void n(RecyclerView.u r1) {
        q(r1);
    }

    public final void b(RecyclerView.u r1, boolean r2) {
        c(r1, r2);
    }
}
