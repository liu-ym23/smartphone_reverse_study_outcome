package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations;

    public abstract boolean animateAdd(RecyclerView.ViewHolder r100);

    public abstract boolean animateChange(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101, int r102, int r103, int r104, int r105);

    public abstract boolean animateMove(RecyclerView.ViewHolder r100, int r101, int r102, int r103, int r104);

    public abstract boolean animateRemove(RecyclerView.ViewHolder r100);

    public void onAddFinished(RecyclerView.ViewHolder r100) {
    }

    public void onAddStarting(RecyclerView.ViewHolder r100) {
    }

    public void onChangeFinished(RecyclerView.ViewHolder r100, boolean r101) {
    }

    public void onChangeStarting(RecyclerView.ViewHolder r100, boolean r101) {
    }

    public void onMoveFinished(RecyclerView.ViewHolder r100) {
    }

    public void onMoveStarting(RecyclerView.ViewHolder r100) {
    }

    public void onRemoveFinished(RecyclerView.ViewHolder r100) {
    }

    public void onRemoveStarting(RecyclerView.ViewHolder r100) {
    }

    public SimpleItemAnimator() {
        this.mSupportsChangeAnimations = true;
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder r100) {
        if (this.mSupportsChangeAnimations == true) goto L5;
    L8:
        return true;
    L5:
        if (r100.isInvalid() == true) goto L8;
        return false;
    }

    public final void dispatchAddFinished(RecyclerView.ViewHolder r100) {
        onAddFinished(r100);
        dispatchAnimationFinished(r100);
    }

    public final void dispatchAddStarting(RecyclerView.ViewHolder r100) {
        onAddStarting(r100);
    }

    public final void dispatchMoveFinished(RecyclerView.ViewHolder r100) {
        onMoveFinished(r100);
        dispatchAnimationFinished(r100);
    }

    public final void dispatchMoveStarting(RecyclerView.ViewHolder r100) {
        onMoveStarting(r100);
    }

    public final void dispatchRemoveFinished(RecyclerView.ViewHolder r100) {
        onRemoveFinished(r100);
        dispatchAnimationFinished(r100);
    }

    public final void dispatchRemoveStarting(RecyclerView.ViewHolder r100) {
        onRemoveStarting(r100);
    }

    public void setSupportsChangeAnimations(boolean r100) {
        this.mSupportsChangeAnimations = r100;
    }

    public final void dispatchChangeFinished(RecyclerView.ViewHolder r100, boolean r101) {
        onChangeFinished(r100, r101);
        dispatchAnimationFinished(r100);
    }

    public final void dispatchChangeStarting(RecyclerView.ViewHolder r100, boolean r101) {
        onChangeStarting(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateAppearance(RecyclerView.ViewHolder r100, RecyclerView.ItemAnimator.ItemHolderInfo r101, RecyclerView.ItemAnimator.ItemHolderInfo r102) {
        if (r101 == null) goto L10;
        int r103 = r101.left;
        int r104 = r102.left;
        if (r103 != r104) goto L8;
        if (r101.top == r102.top) goto L10;
    L8:
        return animateMove(r100, r103, r101.top, r104, r102.top);
    L10:
        return animateAdd(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateDisappearance(RecyclerView.ViewHolder r100, RecyclerView.ItemAnimator.ItemHolderInfo r101, RecyclerView.ItemAnimator.ItemHolderInfo r102) {
        int r103 = r101.left;
        int r104 = r101.top;
        View r105 = r100.itemView;
        if (r102 != null) goto L5;
        int r106 = r105.getLeft();
    L6:
        int r107 = r106;
        if (r102 != null) goto L9;
        int r108 = r105.getTop();
    L10:
        int r109 = r108;
        if (r100.isRemoved() == true) goto L17;
        if (r103 != r107) goto L14;
        if (r104 == r109) goto L17;
    L14:
        r105.layout(r107, r109, r105.getWidth() + r107, r105.getHeight() + r109);
        return animateMove(r100, r103, r104, r107, r109);
    L17:
        return animateRemove(r100);
    L9:
        r108 = r102.top;
        goto L10
    L5:
        r106 = r102.left;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animatePersistence(RecyclerView.ViewHolder r100, RecyclerView.ItemAnimator.ItemHolderInfo r101, RecyclerView.ItemAnimator.ItemHolderInfo r102) {
        int r103 = r101.left;
        int r104 = r102.left;
        if (r103 != r104) goto L10;
        if (r101.top != r102.top) goto L10;
        dispatchMoveFinished(r100);
        return false;
    L10:
        return animateMove(r100, r103, r101.top, r104, r102.top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101, RecyclerView.ItemAnimator.ItemHolderInfo r110, RecyclerView.ItemAnimator.ItemHolderInfo r111) {
        int r102 = r110.left;
        int r103 = r110.top;
        if (r101.shouldIgnore() == false) goto L5;
        int r112 = r110.left;
        int r104 = r110.top;
        int r105 = r112;
    L7:
        return animateChange(r100, r101, r102, r103, r105, r104);
    L5:
        int r113 = r111.left;
        r105 = r113;
        r104 = r111.top;
        goto L7
    }
}
