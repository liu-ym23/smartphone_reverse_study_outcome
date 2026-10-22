package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = null;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "DividerItem";
    public static final int VERTICAL = 1;
    private final Rect mBounds;
    private Drawable mDivider;
    private int mOrientation;

    static {
        ATTRS = new int[]{R.attr.listDivider};
    }

    public Drawable getDrawable() {
        return this.mDivider;
    }

    public void setDrawable(Drawable r100) {
        if (r100 == null) goto L6;
        this.mDivider = r100;
        return;
    L6:
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int r100) {
        if (r100 != 0) goto L4;
    L8:
        this.mOrientation = r100;
        return;
    L4:
        if (r100 == 1) goto L8;
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    public DividerItemDecoration(Context r100, int r101) {
        this.mBounds = new Rect();
        TypedArray r102 = r100.obtainStyledAttributes(ATTRS);
        this.mDivider = r102.getDrawable(0);
        r102.recycle();
        setOrientation(r101);
    }

    private void drawHorizontal(Canvas r100, RecyclerView r101) {
        r100.save();
        int r102 = 0;
        if (r101.getClipToPadding() == false) goto L5;
        int r103 = r101.getPaddingTop();
        int r104 = r101.getHeight() - r101.getPaddingBottom();
        r100.clipRect(r101.getPaddingLeft(), r103, r101.getWidth() - r101.getPaddingRight(), r104);
    L6:
        int r105 = r101.getChildCount();
    L7:
        if (r102 >= r105) goto L9;
        View r106 = r101.getChildAt(r102);
        r101.getLayoutManager().getDecoratedBoundsWithMargins(r106, this.mBounds);
        int r107 = this.mBounds.right + Math.round(r106.getTranslationX());
        int r108 = r107 - this.mDivider.getIntrinsicWidth();
        this.mDivider.setBounds(r108, r103, r107, r104);
        this.mDivider.draw(r100);
        r102 = r102 + 1;
        goto L7
    L9:
        r100.restore();
        return;
    L5:
        r104 = r101.getHeight();
        r103 = 0;
        goto L6
    }

    private void drawVertical(Canvas r100, RecyclerView r101) {
        r100.save();
        int r102 = 0;
        if (r101.getClipToPadding() == false) goto L5;
        int r103 = r101.getPaddingLeft();
        int r104 = r101.getWidth() - r101.getPaddingRight();
        r100.clipRect(r103, r101.getPaddingTop(), r104, r101.getHeight() - r101.getPaddingBottom());
    L6:
        int r105 = r101.getChildCount();
    L7:
        if (r102 >= r105) goto L9;
        View r106 = r101.getChildAt(r102);
        r101.getDecoratedBoundsWithMargins(r106, this.mBounds);
        int r107 = this.mBounds.bottom + Math.round(r106.getTranslationY());
        int r108 = r107 - this.mDivider.getIntrinsicHeight();
        this.mDivider.setBounds(r103, r108, r104, r107);
        this.mDivider.draw(r100);
        r102 = r102 + 1;
        goto L7
    L9:
        r100.restore();
        return;
    L5:
        r104 = r101.getWidth();
        r103 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        if (r101.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.mDivider != null) goto L8;
        return;
    L8:
        if (this.mOrientation != 1) goto L10;
        drawVertical(r100, r101);
        return;
    L10:
        drawHorizontal(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Drawable r104 = this.mDivider;
        if (r104 != null) goto L7;
        r100.set(0, 0, 0, 0);
        return;
    L7:
        if (this.mOrientation != 1) goto L9;
        r100.set(0, 0, 0, r104.getIntrinsicHeight());
        return;
    L9:
        r100.set(0, 0, r104.getIntrinsicWidth(), 0);
    }
}
