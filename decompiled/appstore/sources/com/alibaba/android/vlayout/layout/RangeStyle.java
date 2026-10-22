package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.Range;
import com.alibaba.android.vlayout.layout.RangeStyle;
import com.google.common.primitives.Ints;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class RangeStyle<T extends RangeStyle> {
    private static final boolean DEBUG = false;
    private static final String TAG = "RangeStyle";
    private int mBgColor;
    protected ArrayMap mChildren;
    protected BaseLayoutHelper mLayoutHelper;
    protected Rect mLayoutRegion;
    private View mLayoutView;
    private BaseLayoutHelper.LayoutViewBindListener mLayoutViewBindListener;
    private BaseLayoutHelper.LayoutViewUnBindListener mLayoutViewUnBindListener;
    protected int mMarginBottom;
    protected int mMarginLeft;
    protected int mMarginRight;
    protected int mMarginTop;
    private int mOriginEndOffset;
    private int mOriginStartOffset;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;
    protected T mParent;
    protected Range<Integer> mRange;

    public static class RangeMap<T> {
        private static final int CAPACITY = 64;
        private int lastIndex;
        private T[] mCardMap;
        private Class<T> mClass;
        private int[] mOffsetMap;

        public RangeMap(Class<T> r10) {
            this.lastIndex = -1;
            this.mOffsetMap = new int[64];
            this.mCardMap = (T[]) ((Object[]) Array.newInstance(this.mClass, 64));
            this.mClass = r10;
        }

        public void addChild(int r10, int r11, T r12) {
            int r13 = this.lastIndex + 1;
            T[] r14 = this.mCardMap;
            if (r13 >= r14.length) goto L5;
            r14[r13] = r12;
        L6:
            this.lastIndex = r13;
        L7:
            if (r10 > r11) goto L9;
            this.mOffsetMap[r10] = r13;
            r10 = r10 + 1;
            goto L7
        L9:
            return;
        L5:
            r13 = r14.length;
            T[] r15 = (T[]) ((Object[]) Array.newInstance(this.mClass, r13 * 2));
            System.arraycopy(this.mCardMap, 0, r15, 0, r13);
            this.mCardMap = r15;
            r15[r13] = r12;
            int[] r16 = this.mOffsetMap;
            int r17 = r16.length;
            int[] r18 = new int[r17 * 2];
            System.arraycopy(r16, 0, r18, 0, r17);
            this.mOffsetMap = r18;
            goto L6
        }

        public T getChild(int r10) {
            return this.mCardMap[this.mOffsetMap[r10]];
        }
    }

    public RangeStyle(BaseLayoutHelper r10) {
        this.mOriginStartOffset = 0;
        this.mOriginEndOffset = 0;
        this.mChildren = new ArrayMap();
        this.mLayoutRegion = new Rect();
        this.mLayoutHelper = r10;
    }

    private void clearChild(LayoutManagerHelper r10, RangeStyle<T> r11) {
        View r12 = r11.mLayoutView;
        if (r12 == null) goto L9;
        BaseLayoutHelper.LayoutViewUnBindListener r13 = r11.mLayoutViewUnBindListener;
        if (r13 == null) goto L7;
        r13.onUnbind(r12, getLayoutHelper());
    L7:
        r10.removeChildView(r11.mLayoutView);
        r11.mLayoutView = null;
    L9:
        if (r11.mChildren.isEmpty() == false) goto L11;
        return;
    L11:
        int r14 = r11.mChildren.size();
        int r15 = 0;
    L12:
        if (r15 >= r14) goto L14;
        clearChild(r10, (RangeStyle) r11.mChildren.valueAt(r15));
        r15 = r15 + 1;
        goto L12
    }

    private void hideChildLayoutViews(LayoutManagerHelper r10, RangeStyle<T> r11) {
        int r12 = r11.mChildren.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        RangeStyle<T> r14 = (RangeStyle) r11.mChildren.valueAt(r13);
        if (r14.isChildrenEmpty() == true) goto L7;
        hideChildLayoutViews(r10, r14);
    L7:
        View r15 = r14.mLayoutView;
        if (r15 == null) goto L10;
        r10.hideView(r15);
    L10:
        r13 = r13 + 1;
        goto L3
    }

    private void hideLayoutViews(LayoutManagerHelper r10) {
        if (isRoot() == false) goto L8;
        hideChildLayoutViews(r10, this);
        View r11 = this.mLayoutView;
        if (r11 == null) goto L9;
        r10.hideView(r11);
        return;
    L9:
        return;
    }

    private boolean isValidScrolled(int r10) {
        if (r10 != Integer.MAX_VALUE) goto L5;
    L7:
        return false;
    L5:
        if (r10 == Integer.MIN_VALUE) goto L7;
        return true;
    }

    private void removeChildViews(LayoutManagerHelper r10, RangeStyle<T> r11) {
        if (r11.isChildrenEmpty() == true) goto L7;
        int r12 = r11.mChildren.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        removeChildViews(r10, (RangeStyle) r11.mChildren.valueAt(r13));
        r13 = r13 + 1;
    L7:
        View r14 = r11.mLayoutView;
        if (r14 == null) goto L15;
        BaseLayoutHelper.LayoutViewUnBindListener r15 = r11.mLayoutViewUnBindListener;
        if (r15 == null) goto L12;
        r15.onUnbind(r14, getLayoutHelper());
    L12:
        r10.removeChildView(r11.mLayoutView);
        r11.mLayoutView = null;
        return;
    }

    private boolean requireChildLayoutView(RangeStyle<T> r10) {
        int r11 = 0;
        if (r10.mBgColor == 0) goto L5;
    L8:
        boolean r12 = true;
    L9:
        int r13 = r10.mChildren.size();
    L10:
        if (r11 >= r13) goto L16;
        RangeStyle<T> r14 = (RangeStyle) r10.mChildren.valueAt(r11);
        if (r14.isChildrenEmpty() == true) goto L15;
        r12 = r12 | requireChildLayoutView(r14);
        r11 = r11 + 1;
        goto L10
    L15:
        return r14.requireLayoutView();
    L16:
        return r12;
    L5:
        if (r10.mLayoutViewBindListener != null) goto L8;
        r12 = false;
        goto L9
    }

    private void unionChildRegion(RangeStyle<T> r10) {
        if (r10.isChildrenEmpty() == true) goto L10;
        int r11 = r10.mChildren.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L14;
        RangeStyle<T> r13 = (RangeStyle) r10.mChildren.valueAt(r12);
        unionChildRegion(r13);
        View r14 = r13.mLayoutView;
        if (r14 == null) goto L9;
        r10.mLayoutRegion.union(r14.getLeft(), r13.mLayoutView.getTop(), r13.mLayoutView.getRight(), r13.mLayoutView.getBottom());
    L9:
        r12 = r12 + 1;
        goto L5
    L14:
        return;
    }

    public void addChildRangeStyle(int r10, int r11, T r12) {
        if (r10 > r11) goto L6;
        if (r12 == null) goto L7;
        r12.setParent(this);
        r12.setOriginStartOffset(r10);
        r12.setOriginEndOffset(r11);
        r12.setRange(r10, r11);
        this.mChildren.put(r12.getRange(), r12);
        return;
    L7:
        return;
    }

    public void adjustLayout(int r10, int r11, LayoutManagerHelper r12) {
        int r13 = 0;
        if (isChildrenEmpty() == true) goto L8;
        int r14 = this.mChildren.size();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L8;
        ((RangeStyle) this.mChildren.valueAt(r15)).adjustLayout(r10, r11, r12);
        r15 = r15 + 1;
    L8:
        if (requireLayoutView() == false) goto L36;
        Rect r16 = new Rect();
        OrientationHelperEx r17 = r12.getMainOrientationHelper();
    L11:
        if (r13 >= r12.getChildCount()) goto L23;
        View r18 = r12.getChildAt(r13);
        if (getRange().contains(Integer.valueOf(r12.getPosition(r18))) == false) goto L21;
        if (r18.getVisibility() != 8) goto L17;
        r16.setEmpty();
        goto L21
    L17:
        RecyclerView.LayoutParams r19 = (RecyclerView.LayoutParams) r18.getLayoutParams();
        if (r12.getOrientation() != 1) goto L20;
        r16.union(r12.getDecoratedLeft(r18) - ((ViewGroup.MarginLayoutParams) r19).leftMargin, r17.getDecoratedStart(r18), r12.getDecoratedRight(r18) + ((ViewGroup.MarginLayoutParams) r19).rightMargin, r17.getDecoratedEnd(r18));
        goto L21
    L20:
        r16.union(r17.getDecoratedStart(r18), r12.getDecoratedTop(r18) - ((ViewGroup.MarginLayoutParams) r19).topMargin, r17.getDecoratedEnd(r18), r12.getDecoratedBottom(r18) + ((ViewGroup.MarginLayoutParams) r19).bottomMargin);
    L21:
        r13 = r13 + 1;
        goto L11
    L23:
        if (r16.isEmpty() == true) goto L25;
        this.mLayoutRegion.set(r16.left - this.mPaddingLeft, r16.top - this.mPaddingTop, r16.right + this.mPaddingRight, r16.bottom + this.mPaddingBottom);
    L26:
        View r20 = this.mLayoutView;
        if (r20 == null) goto L37;
        Rect r21 = this.mLayoutRegion;
        r20.layout(r21.left, r21.top, r21.right, r21.bottom);
        return;
    L37:
        return;
    L25:
        this.mLayoutRegion.setEmpty();
        goto L26
    }

    public void afterLayout(RecyclerView.Recycler r14, RecyclerView.State r15, int r16, int r17, int r18, LayoutManagerHelper r19) {
        if (isChildrenEmpty() == true) goto L8;
        int r11 = this.mChildren.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L8;
        ((RangeStyle) this.mChildren.valueAt(r12)).afterLayout(r14, r15, r16, r17, r18, r19);
        r12 = r12 + 1;
    L8:
        if (requireLayoutView() == true) goto L10;
    L42:
        hideLayoutViews(r19);
        if (isRoot() == false) goto L47;
        removeChildViews(r19, this);
        return;
    L47:
        return;
    L10:
        if (isValidScrolled(r18) == false) goto L15;
        View r10 = this.mLayoutView;
        if (r10 == null) goto L15;
        this.mLayoutRegion.union(r10.getLeft(), this.mLayoutView.getTop(), this.mLayoutView.getRight(), this.mLayoutView.getBottom());
    L15:
        if (this.mLayoutRegion.isEmpty() == true) goto L42;
        if (isValidScrolled(r18) == true) goto L19;
    L22:
        unionChildRegion(this);
        int r13 = r19.getContentWidth();
        int r20 = r19.getContentHeight();
        if (r19.getOrientation() != 1) goto L28;
        if (this.mLayoutRegion.intersects(0, (-r20) / 4, r13, r20 + (r20 / 4)) == true) goto L30;
    L38:
        this.mLayoutRegion.set(0, 0, 0, 0);
        View r21 = this.mLayoutView;
        if (r21 == null) goto L41;
        r21.layout(0, 0, 0, 0);
    L41:
        hideLayoutViews(r19);
    L30:
        if (this.mLayoutView != null) goto L33;
        View r22 = r19.generateLayoutView();
        this.mLayoutView = r22;
        r19.addBackgroundView(r22, true);
    L33:
        if (r19.getOrientation() != 1) goto L35;
        this.mLayoutRegion.left = (r19.getPaddingLeft() + getFamilyMarginLeft()) + getAncestorPaddingLeft();
        this.mLayoutRegion.right = ((r19.getContentWidth() - r19.getPaddingRight()) - getFamilyMarginRight()) - getAncestorPaddingRight();
    L36:
        bindLayoutView(this.mLayoutView);
        hideLayoutViews(r19);
        return;
    L35:
        this.mLayoutRegion.top = (r19.getPaddingTop() + getFamilyMarginTop()) + getAncestorPaddingTop();
        this.mLayoutRegion.bottom = ((r19.getContentWidth() - r19.getPaddingBottom()) - getFamilyMarginBottom()) - getAncestorPaddingBottom();
        goto L36
    L28:
        if (this.mLayoutRegion.intersects((-r13) / 4, 0, r13 + (r13 / 4), r20) == false) goto L38;
    L19:
        if (r19.getOrientation() != 1) goto L21;
        this.mLayoutRegion.offset(0, -r18);
        goto L22
    L21:
        this.mLayoutRegion.offset(-r18, 0);
        goto L22
    }

    public void beforeLayout(RecyclerView.Recycler r10, RecyclerView.State r11, LayoutManagerHelper r12) {
        if (isChildrenEmpty() == true) goto L8;
        int r13 = this.mChildren.size();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L8;
        ((RangeStyle) this.mChildren.valueAt(r14)).beforeLayout(r10, r11, r12);
        r14 = r14 + 1;
    L8:
        if (requireLayoutView() == true) goto L19;
        View r15 = this.mLayoutView;
        if (r15 == null) goto L18;
        BaseLayoutHelper.LayoutViewUnBindListener r16 = this.mLayoutViewUnBindListener;
        if (r16 == null) goto L15;
        r16.onUnbind(r15, getLayoutHelper());
    L15:
        r12.removeChildView(this.mLayoutView);
        this.mLayoutView = null;
        return;
    L18:
        return;
    }

    public void bindLayoutView(@NonNull View r10) {
        r10.measure(View.MeasureSpec.makeMeasureSpec(this.mLayoutRegion.width(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(this.mLayoutRegion.height(), Ints.MAX_POWER_OF_TWO));
        Rect r11 = this.mLayoutRegion;
        r10.layout(r11.left, r11.top, r11.right, r11.bottom);
        r10.setBackgroundColor(this.mBgColor);
        BaseLayoutHelper.LayoutViewBindListener r12 = this.mLayoutViewBindListener;
        if (r12 == null) goto L5;
        r12.onBind(r10, getLayoutHelper());
    L5:
        this.mLayoutRegion.set(0, 0, 0, 0);
    }

    public void fillLayoutRegion(int r10, int r11, int r12, int r13, boolean r14) {
        if (r14 == false) goto L4;
        this.mLayoutRegion.union((r10 - this.mPaddingLeft) - this.mMarginLeft, (r11 - this.mPaddingTop) - this.mMarginTop, (this.mPaddingRight + r12) + this.mMarginRight, (this.mPaddingBottom + r13) + this.mMarginBottom);
    L5:
        T r15 = this.mParent;
        if (r15 == null) goto L9;
        int r16 = r10 - this.mPaddingLeft;
        int r17 = this.mMarginLeft;
        r15.fillLayoutRegion(r16 - r17, (r11 - this.mPaddingTop) - r17, (this.mPaddingRight + r12) + this.mMarginRight, (this.mPaddingBottom + r13) + this.mMarginBottom, r14);
        return;
    L9:
        return;
    L4:
        this.mLayoutRegion.union(r10 - this.mPaddingLeft, r11 - this.mPaddingTop, this.mPaddingRight + r12, this.mPaddingBottom + r13);
        goto L5
    }

    public int getAncestorHorizontalMargin() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorHorizontalMargin() + this.mParent.getHorizontalMargin();
    }

    public int getAncestorHorizontalPadding() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorHorizontalPadding() + this.mParent.getHorizontalPadding();
    }

    public int getAncestorMarginBottom() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorMarginBottom() + this.mParent.getMarginBottom();
    }

    public int getAncestorMarginLeft() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorMarginLeft() + this.mParent.getMarginLeft();
    }

    public int getAncestorMarginRight() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorMarginRight() + this.mParent.getMarginRight();
    }

    public int getAncestorMarginTop() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorMarginTop() + this.mParent.getMarginTop();
    }

    public int getAncestorPaddingBottom() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorPaddingBottom() + this.mParent.getPaddingBottom();
    }

    public int getAncestorPaddingLeft() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorPaddingLeft() + this.mParent.getPaddingLeft();
    }

    public int getAncestorPaddingRight() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorPaddingRight() + this.mParent.getPaddingRight();
    }

    public int getAncestorPaddingTop() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorPaddingTop() + this.mParent.getPaddingTop();
    }

    public int getAncestorVerticalMargin() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorVerticalMargin() + this.mParent.getVerticalMargin();
    }

    public int getAncestorVerticalPadding() {
        T r10 = this.mParent;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getAncestorVerticalPadding() + this.mParent.getVerticalPadding();
    }

    public int getFamilyHorizontalMargin() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyHorizontalMargin();
    L7:
        return r11 + getHorizontalMargin();
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyHorizontalPadding() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyHorizontalPadding();
    L7:
        return r11 + getHorizontalPadding();
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyMarginBottom() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyMarginBottom();
    L7:
        return r11 + this.mMarginBottom;
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyMarginLeft() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyMarginLeft();
    L7:
        return r11 + this.mMarginLeft;
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyMarginRight() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyMarginRight();
    L7:
        return r11 + this.mMarginRight;
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyMarginTop() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyMarginTop();
    L7:
        return r11 + this.mMarginTop;
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyPaddingBottom() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyPaddingBottom();
    L7:
        return r11 + this.mPaddingBottom;
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyPaddingLeft() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyPaddingLeft();
    L7:
        return r11 + this.mPaddingLeft;
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyPaddingRight() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyPaddingRight();
    L7:
        return r11 + this.mPaddingRight;
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyPaddingTop() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyPaddingTop();
    L7:
        return r11 + this.mPaddingTop;
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyVerticalMargin() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyVerticalMargin();
    L7:
        return r11 + getVerticalMargin();
    L5:
        r11 = 0;
        goto L7
    }

    public int getFamilyVerticalPadding() {
        T r10 = this.mParent;
        if (r10 == null) goto L5;
        int r11 = r10.getFamilyVerticalPadding();
    L7:
        return r11 + getVerticalPadding();
    L5:
        r11 = 0;
        goto L7
    }

    public int getHorizontalMargin() {
        return this.mMarginLeft + this.mMarginRight;
    }

    public int getHorizontalPadding() {
        return this.mPaddingLeft + this.mPaddingRight;
    }

    public BaseLayoutHelper getLayoutHelper() {
        BaseLayoutHelper r10 = this.mLayoutHelper;
        if (r10 == null) goto L5;
        return r10;
    L5:
        T r11 = this.mParent;
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.getLayoutHelper();
    }

    public int getMarginBottom() {
        return this.mMarginBottom;
    }

    public int getMarginLeft() {
        return this.mMarginLeft;
    }

    public int getMarginRight() {
        return this.mMarginRight;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public int getOriginEndOffset() {
        return this.mOriginEndOffset;
    }

    public int getOriginStartOffset() {
        return this.mOriginStartOffset;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public Range<Integer> getRange() {
        return this.mRange;
    }

    public int getVerticalMargin() {
        return this.mMarginTop + this.mMarginBottom;
    }

    public int getVerticalPadding() {
        return this.mPaddingTop + this.mPaddingBottom;
    }

    public boolean isChildrenEmpty() {
        return this.mChildren.isEmpty();
    }

    public boolean isFirstPosition(int r10) {
        Range<Integer> r11 = this.mRange;
        if (r11 != null) goto L5;
        return false;
    L5:
        if (((Integer) r11.getLower()).intValue() != r10) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isLastPosition(int r10) {
        Range<Integer> r11 = this.mRange;
        if (r11 != null) goto L5;
        return false;
    L5:
        if (((Integer) r11.getUpper()).intValue() != r10) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isOutOfRange(int r10) {
        Range<Integer> r11 = this.mRange;
        if (r11 != null) goto L5;
        return true;
    L5:
        if (r11.contains(Integer.valueOf(r10)) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isRoot() {
        if (this.mParent != null) goto L5;
        return true;
    L5:
        return false;
    }

    public void layoutChild(View r10, int r11, int r12, int r13, int r14, @NonNull LayoutManagerHelper r15, boolean r16) {
        r15.layoutChildWithMargins(r10, r11, r12, r13, r14);
        fillLayoutRegion(r11, r12, r13, r14, r16);
    }

    public void onClear(LayoutManagerHelper r10) {
        clearChild(r10, this);
    }

    public void onClearChildMap() {
        this.mChildren.clear();
    }

    public boolean requireLayoutView() {
        if (this.mBgColor == 0) goto L5;
    L8:
        boolean r10 = true;
    L10:
        if (isChildrenEmpty() == false) goto L12;
        return r10;
    L12:
        return r10 | requireChildLayoutView(this);
    L5:
        if (this.mLayoutViewBindListener != null) goto L8;
        r10 = false;
        goto L10
    }

    public void setBgColor(int r10) {
        this.mBgColor = r10;
    }

    public void setLayoutViewBindListener(BaseLayoutHelper.LayoutViewBindListener r10) {
        this.mLayoutViewBindListener = r10;
    }

    public void setLayoutViewHelper(BaseLayoutHelper.DefaultLayoutViewHelper r10) {
        this.mLayoutViewBindListener = r10;
        this.mLayoutViewUnBindListener = r10;
    }

    public void setLayoutViewUnBindListener(BaseLayoutHelper.LayoutViewUnBindListener r10) {
        this.mLayoutViewUnBindListener = r10;
    }

    public void setMargin(int r10, int r11, int r12, int r13) {
        this.mMarginLeft = r10;
        this.mMarginTop = r11;
        this.mMarginRight = r12;
        this.mMarginBottom = r13;
    }

    public void setMarginBottom(int r10) {
        this.mMarginBottom = r10;
    }

    public void setMarginLeft(int r10) {
        this.mMarginLeft = r10;
    }

    public void setMarginRight(int r10) {
        this.mMarginRight = r10;
    }

    public void setMarginTop(int r10) {
        this.mMarginTop = r10;
    }

    public void setOriginEndOffset(int r10) {
        this.mOriginEndOffset = r10;
    }

    public void setOriginStartOffset(int r10) {
        this.mOriginStartOffset = r10;
    }

    public void setPadding(int r10, int r11, int r12, int r13) {
        this.mPaddingLeft = r10;
        this.mPaddingRight = r12;
        this.mPaddingTop = r11;
        this.mPaddingBottom = r13;
    }

    public void setPaddingBottom(int r10) {
        this.mPaddingBottom = r10;
    }

    public void setPaddingLeft(int r10) {
        this.mPaddingLeft = r10;
    }

    public void setPaddingRight(int r10) {
        this.mPaddingRight = r10;
    }

    public void setPaddingTop(int r10) {
        this.mPaddingTop = r10;
    }

    public void setParent(T r10) {
        this.mParent = r10;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setRange(int r10, int r11) {
        this.mRange = Range.create(Integer.valueOf(r10), Integer.valueOf(r11));
        if (this.mChildren.isEmpty() == true) goto L10;
        SimpleArrayMap r12 = new SimpleArrayMap();
        int r13 = this.mChildren.size();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L7;
        RangeStyle r15 = (RangeStyle) this.mChildren.valueAt(r14);
        int r16 = r15.getOriginStartOffset() + r10;
        int r17 = r15.getOriginEndOffset() + r10;
        r12.put(Range.create(Integer.valueOf(r16), Integer.valueOf(r17)), r15);
        r15.setRange(r16, r17);
        r14 = r14 + 1;
        goto L5
    L7:
        this.mChildren.clear();
        this.mChildren.putAll(r12);
        return;
    }

    public RangeStyle() {
        this.mOriginStartOffset = 0;
        this.mOriginEndOffset = 0;
        this.mChildren = new ArrayMap();
        this.mLayoutRegion = new Rect();
    }
}
