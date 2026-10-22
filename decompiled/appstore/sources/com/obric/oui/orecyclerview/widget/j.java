package com.obric.oui.orecyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j extends RecyclerView.ItemAnimator {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15708g;

    public j() {
        this.f15708g = true;
    }

    public final void A(RecyclerView.t r10) {
        I(r10);
        h(r10);
    }

    public final void B(RecyclerView.t r10) {
        J(r10);
    }

    public final void C(RecyclerView.t r10, boolean r11) {
        K(r10, r11);
        h(r10);
    }

    public final void D(RecyclerView.t r10, boolean r11) {
        L(r10, r11);
    }

    public final void E(RecyclerView.t r10) {
        M(r10);
        h(r10);
    }

    public final void F(RecyclerView.t r10) {
        N(r10);
    }

    public final void G(RecyclerView.t r10) {
        O(r10);
        h(r10);
    }

    public final void H(RecyclerView.t r10) {
        P(r10);
    }

    public void I(RecyclerView.t r10) {
    }

    public void J(RecyclerView.t r10) {
    }

    public void K(RecyclerView.t r10, boolean r11) {
    }

    public void L(RecyclerView.t r10, boolean r11) {
    }

    public void M(RecyclerView.t r10) {
    }

    public void N(RecyclerView.t r10) {
    }

    public void O(RecyclerView.t r10) {
    }

    public void P(RecyclerView.t r10) {
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public boolean a(RecyclerView.t r10, RecyclerView.ItemAnimator.a r11, RecyclerView.ItemAnimator.a r12) {
        if (r11 == null) goto L10;
        int r13 = r11.f15491a;
        int r14 = r12.f15491a;
        if (r13 != r14) goto L8;
        if (r11.f15492b == r12.f15492b) goto L10;
    L8:
        return y(r10, r13, r11.f15492b, r14, r12.f15492b);
    L10:
        return w(r10);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public boolean b(RecyclerView.t r10, RecyclerView.t r11, RecyclerView.ItemAnimator.a r12, RecyclerView.ItemAnimator.a r13) {
        int r14 = r12.f15491a;
        int r15 = r12.f15492b;
        if (r11.L() == false) goto L5;
        int r16 = r12.f15491a;
        int r17 = r12.f15492b;
        int r18 = r16;
    L7:
        return x(r10, r11, r14, r15, r18, r17);
    L5:
        int r19 = r13.f15491a;
        r18 = r19;
        r17 = r13.f15492b;
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public boolean c(RecyclerView.t r10, RecyclerView.ItemAnimator.a r11, RecyclerView.ItemAnimator.a r12) {
        int r13 = r11.f15491a;
        int r14 = r11.f15492b;
        View r15 = r10.f15566a;
        if (r12 != null) goto L6;
        int r16 = r15.getLeft();
    L5:
        int r17 = r16;
        if (r12 != null) goto L10;
        int r18 = r15.getTop();
    L9:
        int r19 = r18;
        if (r10.x() == true) goto L18;
        if (r13 != r17) goto L15;
        if (r14 == r19) goto L18;
    L15:
        r15.layout(r17, r19, r15.getWidth() + r17, r15.getHeight() + r19);
        return y(r10, r13, r14, r17, r19);
    L18:
        return z(r10);
    L10:
        r18 = r12.f15492b;
        goto L9
    L6:
        r16 = r12.f15491a;
        goto L5
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public boolean d(RecyclerView.t r10, RecyclerView.ItemAnimator.a r11, RecyclerView.ItemAnimator.a r12) {
        int r13 = r11.f15491a;
        int r14 = r12.f15491a;
        if (r13 != r14) goto L10;
        if (r11.f15492b != r12.f15492b) goto L10;
        E(r10);
        return false;
    L10:
        return y(r10, r13, r11.f15492b, r14, r12.f15492b);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public boolean f(RecyclerView.t r10) {
        if (this.f15708g == true) goto L5;
    L8:
        return true;
    L5:
        if (r10.v() == true) goto L8;
        return false;
    }

    public abstract boolean w(RecyclerView.t r10);

    public abstract boolean x(RecyclerView.t r10, RecyclerView.t r11, int r12, int r13, int r14, int r15);

    public abstract boolean y(RecyclerView.t r10, int r11, int r12, int r13, int r14);

    public abstract boolean z(RecyclerView.t r10);
}
