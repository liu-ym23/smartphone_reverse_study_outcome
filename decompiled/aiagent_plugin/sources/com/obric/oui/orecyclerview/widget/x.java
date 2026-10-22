package com.obric.oui.orecyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: SimpleItemAnimator.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class x extends RecyclerView.e {
    private static final String TAG = "SimpleItemAnimator";
    boolean h;

    public abstract boolean a(RecyclerView.v r1);

    public abstract boolean a(RecyclerView.v r1, int r2, int r3, int r4, int r5);

    public abstract boolean a(RecyclerView.v r1, RecyclerView.v r2, int r3, int r4, int r5, int r6);

    public abstract boolean b(RecyclerView.v r1);

    public void c(RecyclerView.v r1, boolean r2) {
    }

    public void d(RecyclerView.v r1, boolean r2) {
    }

    public void o(RecyclerView.v r1) {
    }

    public void p(RecyclerView.v r1) {
    }

    public void q(RecyclerView.v r1) {
    }

    public void r(RecyclerView.v r1) {
    }

    public void s(RecyclerView.v r1) {
    }

    public void t(RecyclerView.v r1) {
    }

    public x() {
        this.h = true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public boolean h(RecyclerView.v r1) {
        if (this.h == true) goto L5;
    L8:
        return true;
    L5:
        if (r1.u() == true) goto L8;
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public boolean a(RecyclerView.v r7, RecyclerView.e.c r8, RecyclerView.e.c r9) {
        int r2 = r8.f35614a;
        int r3 = r8.f35615b;
        View r10 = r7.f35660b;
        if (r9 != null) goto L5;
        int r0 = r10.getLeft();
    L6:
        int r4 = r0;
        if (r9 != null) goto L9;
        int r11 = r10.getTop();
    L10:
        int r5 = r11;
        if (r7.x() == true) goto L17;
        if (r2 != r4) goto L14;
        if (r3 == r5) goto L17;
    L14:
        r10.layout(r4, r5, r10.getWidth() + r4, r10.getHeight() + r5);
        return a(r7, r2, r3, r4, r5);
    L17:
        return a(r7);
    L9:
        r11 = r9.f35615b;
        goto L10
    L5:
        r0 = r9.f35614a;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public boolean b(RecyclerView.v r9, RecyclerView.e.c r10, RecyclerView.e.c r11) {
        if (r10 == null) goto L10;
        if (r10.f35614a != r11.f35614a) goto L8;
        if (r10.f35615b == r11.f35615b) goto L10;
    L8:
        return a(r9, r10.f35614a, r10.f35615b, r11.f35614a, r11.f35615b);
    L10:
        return b(r9);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public boolean c(RecyclerView.v r7, RecyclerView.e.c r8, RecyclerView.e.c r9) {
        if (r8.f35614a != r9.f35614a) goto L10;
        if (r8.f35615b != r9.f35615b) goto L10;
        j(r7);
        return false;
    L10:
        return a(r7, r8.f35614a, r8.f35615b, r9.f35614a, r9.f35615b);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public boolean a(RecyclerView.v r8, RecyclerView.v r9, RecyclerView.e.c r10, RecyclerView.e.c r11) {
        int r3 = r10.f35614a;
        int r4 = r10.f35615b;
        if (r9.f() == false) goto L5;
        int r12 = r10.f35614a;
        int r6 = r10.f35615b;
        int r5 = r12;
    L7:
        return a(r8, r9, r3, r4, r5, r6);
    L5:
        int r13 = r11.f35614a;
        r5 = r13;
        r6 = r11.f35615b;
        goto L7
    }

    public final void i(RecyclerView.v r1) {
        p(r1);
        f(r1);
    }

    public final void j(RecyclerView.v r1) {
        t(r1);
        f(r1);
    }

    public final void k(RecyclerView.v r1) {
        r(r1);
        f(r1);
    }

    public final void a(RecyclerView.v r1, boolean r2) {
        d(r1, r2);
        f(r1);
    }

    public final void l(RecyclerView.v r1) {
        o(r1);
    }

    public final void m(RecyclerView.v r1) {
        s(r1);
    }

    public final void n(RecyclerView.v r1) {
        q(r1);
    }

    public final void b(RecyclerView.v r1, boolean r2) {
        c(r1, r2);
    }
}
