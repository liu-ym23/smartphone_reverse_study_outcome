package com.chad.library.adapter.base.dragswipe;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.R;
import com.chad.library.adapter.base.module.BaseDraggableModule;

/* JADX INFO: loaded from: classes2.dex */
public class DragAndSwipeCallback extends ItemTouchHelper.e {
    private int mDragMoveFlags;
    private BaseDraggableModule mDraggableModule;
    private float mMoveThreshold;
    private int mSwipeMoveFlags;
    private float mSwipeThreshold;

    public DragAndSwipeCallback(BaseDraggableModule r10) {
        this.mMoveThreshold = 0.1f;
        this.mSwipeThreshold = 0.7f;
        this.mDragMoveFlags = 15;
        this.mSwipeMoveFlags = 32;
        this.mDraggableModule = r10;
    }

    private boolean isViewCreateByAdapter(@NonNull RecyclerView.ViewHolder r10) {
        int r11 = r10.getItemViewType();
        if (r11 != 268435729) goto L5;
    L12:
        return true;
    L5:
        if (r11 == 268436002) goto L12;
        if (r11 == 268436275) goto L12;
        if (r11 == 268436821) goto L12;
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public void clearView(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11) {
        super.clearView(r10, r11);
        if (isViewCreateByAdapter(r11) == false) goto L5;
        return;
    L5:
        View r12 = r11.itemView;
        int r13 = R.id.BaseQuickAdapter_dragging_support;
        if (r12.getTag(r13) != null) goto L8;
    L13:
        View r14 = r11.itemView;
        int r15 = R.id.BaseQuickAdapter_swiping_support;
        if (r14.getTag(r15) != null) goto L16;
        return;
    L16:
        if (((Boolean) r11.itemView.getTag(r15)).booleanValue() == false) goto L23;
        BaseDraggableModule r16 = this.mDraggableModule;
        if (r16 == null) goto L20;
        r16.onItemSwipeClear(r11);
    L20:
        r11.itemView.setTag(r15, Boolean.FALSE);
        return;
    L23:
        return;
    L8:
        if (((Boolean) r11.itemView.getTag(r13)).booleanValue() == false) goto L13;
        BaseDraggableModule r17 = this.mDraggableModule;
        if (r17 == null) goto L12;
        r17.onItemDragEnd(r11);
    L12:
        r11.itemView.setTag(r13, Boolean.FALSE);
        goto L13
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public float getMoveThreshold(@NonNull RecyclerView.ViewHolder r10) {
        return this.mMoveThreshold;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public int getMovementFlags(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11) {
        if (isViewCreateByAdapter(r11) == false) goto L7;
        return ItemTouchHelper.e.makeMovementFlags(0, 0);
    L7:
        return ItemTouchHelper.e.makeMovementFlags(this.mDragMoveFlags, this.mSwipeMoveFlags);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder r10) {
        return this.mSwipeThreshold;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public boolean isItemViewSwipeEnabled() {
        BaseDraggableModule r10 = this.mDraggableModule;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.isSwipeEnabled();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public boolean isLongPressDragEnabled() {
        BaseDraggableModule r10 = this.mDraggableModule;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.isDragEnabled() == true) goto L7;
        return false;
    L7:
        if (this.mDraggableModule.hasToggleView() == true) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public void onChildDrawOver(@NonNull Canvas r10, @NonNull RecyclerView r11, @NonNull RecyclerView.ViewHolder r12, float r13, float r14, int r15, boolean r16) {
        super.onChildDrawOver(r10, r11, r12, r13, r14, r15, r16);
        if (r15 == 1) goto L5;
        return;
    L5:
        if (isViewCreateByAdapter(r12) == true) goto L16;
        View r17 = r12.itemView;
        r10.save();
        if (r13 <= 0.0f) goto L9;
        r10.clipRect(r17.getLeft(), r17.getTop(), r17.getLeft() + r13, r17.getBottom());
        r10.translate(r17.getLeft(), r17.getTop());
    L10:
        BaseDraggableModule r18 = this.mDraggableModule;
        if (r18 == null) goto L13;
        r18.onItemSwiping(r10, r12, r13, r14, r16);
    L13:
        r10.restore();
        return;
    L9:
        r10.clipRect(r17.getRight() + r13, r17.getTop(), r17.getRight(), r17.getBottom());
        r10.translate(r17.getRight() + r13, r17.getTop());
        goto L10
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public boolean onMove(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11, @NonNull RecyclerView.ViewHolder r12) {
        if (r11.getItemViewType() != r12.getItemViewType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public void onMoved(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11, int r12, @NonNull RecyclerView.ViewHolder r13, int r14, int r15, int r16) {
        super.onMoved(r10, r11, r12, r13, r14, r15, r16);
        BaseDraggableModule r17 = this.mDraggableModule;
        if (r17 == null) goto L6;
        r17.onItemDragMoving(r11, r13);
        return;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public void onSelectedChanged(RecyclerView.ViewHolder r10, int r11) {
        if (r11 != 2) goto L11;
        if (isViewCreateByAdapter(r10) == true) goto L11;
        BaseDraggableModule r12 = this.mDraggableModule;
        if (r12 == null) goto L9;
        r12.onItemDragStart(r10);
    L9:
        r10.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, Boolean.TRUE);
    L18:
        super.onSelectedChanged(r10, r11);
        return;
    L11:
        if (r11 != 1) goto L18;
        if (isViewCreateByAdapter(r10) == true) goto L18;
        BaseDraggableModule r13 = this.mDraggableModule;
        if (r13 == null) goto L17;
        r13.onItemSwipeStart(r10);
    L17:
        r10.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, Boolean.TRUE);
        goto L18
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.e
    public void onSwiped(@NonNull RecyclerView.ViewHolder r10, int r11) {
        if (isViewCreateByAdapter(r10) == true) goto L8;
        BaseDraggableModule r12 = this.mDraggableModule;
        if (r12 == null) goto L9;
        r12.onItemSwiped(r10);
        return;
    L9:
        return;
    }

    public void setDragMoveFlags(int r10) {
        this.mDragMoveFlags = r10;
    }

    public void setMoveThreshold(float r10) {
        this.mMoveThreshold = r10;
    }

    public void setSwipeMoveFlags(int r10) {
        this.mSwipeMoveFlags = r10;
    }

    public void setSwipeThreshold(float r10) {
        this.mSwipeThreshold = r10;
    }
}
