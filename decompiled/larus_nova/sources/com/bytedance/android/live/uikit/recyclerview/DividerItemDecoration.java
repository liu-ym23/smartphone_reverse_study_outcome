package com.bytedance.android.live.uikit.recyclerview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes7.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = null;
    public static final int HORIZONTAL_LIST = 0;
    public static final int VERTICAL_LIST = 1;
    protected Drawable mDivider;
    private boolean mDrawFirstChildTopLine;
    private boolean mDrawLastChildBottomLine;
    private int mFirstOffset;
    private int mOrientation;

    static {
        ATTRS = new int[]{R.attr.listDivider};
    }

    public void setFirstOffset(int r100) {
        this.mFirstOffset = r100;
    }

    public void setOrientation(int r100) {
        if (r100 != 0) goto L4;
    L8:
        this.mOrientation = r100;
        return;
    L4:
        if (r100 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation");
    }

    public void drawHorizontal(Canvas r100, RecyclerView r110) {
        int r101 = r110.getPaddingTop();
        int r102 = r110.getHeight() - r110.getPaddingBottom();
        int r103 = r110.getChildCount();
        if (this.mDrawLastChildBottomLine == true) goto L5;
        r103 = r103 - 1;
    L5:
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L9;
        View r105 = r110.getChildAt(r104);
        int r106 = r105.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r105.getLayoutParams())).rightMargin;
        this.mDivider.setBounds(r106, r101, this.mDivider.getIntrinsicHeight() + r106, r102);
        this.mDivider.draw(r100);
        r104 = r104 + 1;
        goto L6
    L9:
        if (this.mDrawFirstChildTopLine == false) goto L15;
        View r107 = r110.getChildAt(0);
        if (r110.getChildPosition(r107) != 0) goto L16;
        this.mDivider.setBounds(r107.getLeft() - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r107.getLayoutParams())).leftMargin, r101, this.mDivider.getIntrinsicHeight() + r101, r102);
        this.mDivider.draw(r100);
        return;
    L16:
        return;
    }

    public void drawVertical(Canvas r100, RecyclerView r110) {
        int r101 = r110.getPaddingLeft();
        int r102 = r110.getWidth() - r110.getPaddingRight();
        int r103 = r110.getChildCount();
        if (this.mDrawLastChildBottomLine == true) goto L5;
        r103 = r103 - 1;
    L5:
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L9;
        View r105 = r110.getChildAt(r104);
        int r106 = r105.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r105.getLayoutParams())).bottomMargin;
        this.mDivider.setBounds(r101, r106, r102, (this.mDivider.getIntrinsicHeight() + r106) - 1);
        this.mDivider.draw(r100);
        r104 = r104 + 1;
        goto L6
    L9:
        if (this.mDrawFirstChildTopLine == false) goto L15;
        View r107 = r110.getChildAt(0);
        if (r110.getChildPosition(r107) != 0) goto L16;
        int r108 = r107.getTop() - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r107.getLayoutParams())).topMargin;
        this.mDivider.setBounds(r101, (r108 - this.mDivider.getIntrinsicHeight()) + 1, r102, r108);
        this.mDivider.draw(r100);
        return;
    L16:
        return;
    }

    public DividerItemDecoration(Context r100, int r101, int r102) {
        this(r100, r101, r102, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        if (this.mOrientation != 1) goto L5;
        drawVertical(r100, r101);
        return;
    L5:
        drawHorizontal(r100, r101);
    }

    public DividerItemDecoration(Context r100, int r101, int r102, boolean r110) {
        this(r100, r101, r102, r110, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        int r104 = r102.getChildAdapterPosition(r101);
        if (this.mDrawFirstChildTopLine == false) goto L6;
        if (r104 != 0) goto L6;
        int r105 = this.mDivider.getIntrinsicHeight();
    L8:
        if (this.mOrientation != 1) goto L12;
        if (r104 != 0) goto L11;
        r105 = r105 + ((int) UIUtils.dip2Px(r102.getContext(), this.mFirstOffset));
    L11:
        r100.set(0, r105, 0, this.mDivider.getIntrinsicHeight());
        return;
    L12:
        r100.set(0, r105, this.mDivider.getIntrinsicWidth(), 0);
        return;
    L6:
        r105 = 0;
        goto L8
    }

    public DividerItemDecoration(Context r100, int r101, int r102, boolean r103, boolean r104) {
        TypedArray r105 = r100.obtainStyledAttributes(ATTRS);
        this.mDivider = r100.getResources().getDrawable(r102);
        r105.recycle();
        setOrientation(r101);
        this.mDrawFirstChildTopLine = r103;
        this.mDrawLastChildBottomLine = r104;
    }
}
