package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends RecyclerView.ItemAnimator {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4430g;

    public m() {
        this.f4430g = true;
    }

    public abstract boolean B(RecyclerView.ViewHolder r10);

    public abstract boolean C(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11, int r12, int r13, int r14, int r15);

    public abstract boolean D(RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14);

    public abstract boolean E(RecyclerView.ViewHolder r10);

    public final void F(RecyclerView.ViewHolder r10) {
        N(r10);
        h(r10);
    }

    public final void G(RecyclerView.ViewHolder r10) {
        O(r10);
    }

    public final void H(RecyclerView.ViewHolder r10, boolean r11) {
        P(r10, r11);
        h(r10);
    }

    public final void I(RecyclerView.ViewHolder r10, boolean r11) {
        Q(r10, r11);
    }

    public final void J(RecyclerView.ViewHolder r10) {
        R(r10);
        h(r10);
    }

    public final void K(RecyclerView.ViewHolder r10) {
        S(r10);
    }

    public final void L(RecyclerView.ViewHolder r10) {
        T(r10);
        h(r10);
    }

    public final void M(RecyclerView.ViewHolder r10) {
        U(r10);
    }

    public void N(RecyclerView.ViewHolder r10) {
    }

    public void O(RecyclerView.ViewHolder r10) {
    }

    public void P(RecyclerView.ViewHolder r10, boolean r11) {
    }

    public void Q(RecyclerView.ViewHolder r10, boolean r11) {
    }

    public void R(RecyclerView.ViewHolder r10) {
    }

    public void S(RecyclerView.ViewHolder r10) {
    }

    public void T(RecyclerView.ViewHolder r10) {
    }

    public void U(RecyclerView.ViewHolder r10) {
    }

    public void V(boolean r10) {
        this.f4430g = r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean a(RecyclerView.ViewHolder r10, RecyclerView.ItemAnimator.ItemHolderInfo r11, RecyclerView.ItemAnimator.ItemHolderInfo r12) {
        if (r11 == null) goto L10;
        int r13 = r11.f4193a;
        int r14 = r12.f4193a;
        if (r13 != r14) goto L8;
        if (r11.f4194b == r12.f4194b) goto L10;
    L8:
        return D(r10, r13, r11.f4194b, r14, r12.f4194b);
    L10:
        return B(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean b(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11, RecyclerView.ItemAnimator.ItemHolderInfo r12, RecyclerView.ItemAnimator.ItemHolderInfo r13) {
        int r14 = r12.f4193a;
        int r15 = r12.f4194b;
        if (r11.shouldIgnore() == false) goto L5;
        int r16 = r12.f4193a;
        int r17 = r12.f4194b;
        int r18 = r16;
    L7:
        return C(r10, r11, r14, r15, r18, r17);
    L5:
        int r19 = r13.f4193a;
        r18 = r19;
        r17 = r13.f4194b;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean c(RecyclerView.ViewHolder r10, RecyclerView.ItemAnimator.ItemHolderInfo r11, RecyclerView.ItemAnimator.ItemHolderInfo r12) {
        int r13 = r11.f4193a;
        int r14 = r11.f4194b;
        View r15 = r10.itemView;
        if (r12 != null) goto L6;
        int r16 = r15.getLeft();
    L5:
        int r17 = r16;
        if (r12 != null) goto L10;
        int r18 = r15.getTop();
    L9:
        int r19 = r18;
        if (r10.isRemoved() == true) goto L18;
        if (r13 != r17) goto L15;
        if (r14 == r19) goto L18;
    L15:
        r15.layout(r17, r19, r15.getWidth() + r17, r15.getHeight() + r19);
        return D(r10, r13, r14, r17, r19);
    L18:
        return E(r10);
    L10:
        r18 = r12.f4194b;
        goto L9
    L6:
        r16 = r12.f4193a;
        goto L5
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean d(RecyclerView.ViewHolder r10, RecyclerView.ItemAnimator.ItemHolderInfo r11, RecyclerView.ItemAnimator.ItemHolderInfo r12) {
        int r13 = r11.f4193a;
        int r14 = r12.f4193a;
        if (r13 != r14) goto L10;
        if (r11.f4194b != r12.f4194b) goto L10;
        J(r10);
        return false;
    L10:
        return D(r10, r13, r11.f4194b, r14, r12.f4194b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean f(RecyclerView.ViewHolder r10) {
        if (this.f4430g == true) goto L5;
    L8:
        return true;
    L5:
        if (r10.isInvalid() == true) goto L8;
        return false;
    }
}
