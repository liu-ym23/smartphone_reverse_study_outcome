package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.Range;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractFullFillLayoutHelper extends BaseLayoutHelper {
    private static final String TAG = "FullFillLayoutHelper";
    protected boolean hasFooter;
    protected boolean hasHeader;
    protected boolean mLayoutWithAnchor;
    private LayoutManagerHelper mTempLayoutHelper;

    public AbstractFullFillLayoutHelper() {
        this.hasHeader = false;
        this.hasFooter = false;
        this.mLayoutWithAnchor = false;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void afterLayout(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, int r14, LayoutManagerHelper r15) {
        super.afterLayout(r10, r11, r12, r13, r14, r15);
        this.mLayoutWithAnchor = false;
    }

    public void calculateRect(int r10, Rect r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutManagerHelper r13) {
        int r14 = 0;
        if (r13.getOrientation() != 1) goto L22;
        r11.left = (r13.getPaddingLeft() + this.mMarginLeft) + this.mPaddingLeft;
        r11.right = ((r13.getContentWidth() - r13.getPaddingRight()) - this.mMarginRight) - this.mPaddingRight;
        if (r12.getLayoutDirection() != (-1)) goto L14;
        int r15 = r12.getOffset();
        if (this.mLayoutWithAnchor == false) goto L10;
    L13:
        int r16 = r15 - r14;
        r11.bottom = r16;
        r11.top = r16 - r10;
        return;
    L10:
        if (this.hasFooter == true) goto L13;
        r14 = this.mMarginBottom + this.mPaddingBottom;
        goto L13
    L14:
        int r17 = r12.getOffset();
        if (this.mLayoutWithAnchor == false) goto L18;
    L21:
        int r18 = r17 + r14;
        r11.top = r18;
        r11.bottom = r18 + r10;
        return;
    L18:
        if (this.hasHeader == true) goto L21;
        r14 = this.mMarginTop + this.mPaddingTop;
        goto L21
    L22:
        r11.top = (r13.getPaddingTop() + this.mMarginTop) + this.mPaddingTop;
        r11.bottom = ((r13.getContentHeight() - r13.getPaddingBottom()) - this.mMarginBottom) - this.mPaddingBottom;
        if (r12.getLayoutDirection() != (-1)) goto L32;
        int r19 = r12.getOffset();
        if (this.mLayoutWithAnchor == false) goto L28;
    L31:
        int r20 = r19 - r14;
        r11.right = r20;
        r11.left = r20 - r10;
        return;
    L28:
        if (this.hasFooter == true) goto L31;
        r14 = this.mMarginRight + this.mPaddingRight;
        goto L31
    L32:
        int r21 = r12.getOffset();
        if (this.mLayoutWithAnchor == false) goto L36;
    L39:
        int r22 = r21 + r14;
        r11.left = r22;
        r11.right = r22 + r10;
        return;
    L36:
        if (this.hasHeader == true) goto L39;
        r14 = this.mMarginLeft + this.mPaddingLeft;
        goto L39
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void checkAnchorInfo(RecyclerView.State r10, VirtualLayoutManager.AnchorInfoWrapper r11, LayoutManagerHelper r12) {
        if (r11.layoutFromEnd == false) goto L8;
        if (this.hasFooter == true) goto L10;
        r11.position = ((Integer) getRange().getUpper()).intValue();
    L10:
        this.mLayoutWithAnchor = true;
        return;
    L8:
        if (this.hasHeader == true) goto L10;
        r11.position = ((Integer) getRange().getLower()).intValue();
        goto L10
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return true;
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computeAlignOffset(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (r13.getOrientation() != 1) goto L9;
        if (r11 == false) goto L8;
        return this.mMarginBottom + this.mPaddingBottom;
    L8:
        return (-this.mMarginTop) - this.mPaddingTop;
    L9:
        if (r11 == false) goto L13;
        return this.mMarginRight + this.mPaddingRight;
    L13:
        return (-this.mMarginLeft) - this.mPaddingLeft;
    }

    public void doLayoutView(RecyclerView.Recycler r10, RecyclerView.State r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutChunkResult r13, LayoutManagerHelper r14) {
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new ViewGroup.LayoutParams(r10);
    }

    public int getAllChildren(View[] r10, RecyclerView.Recycler r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutChunkResult r13, LayoutManagerHelper r14) {
        int r15 = 0;
        boolean r16 = true;
        if (r12.getItemDirection() == 1) goto L6;
        r16 = false;
    L6:
        Range<Integer> r17 = getRange();
        if (r16 == false) goto L10;
        Comparable r18 = r17.getLower();
    L11:
        int r19 = ((Integer) r18).intValue();
        int r20 = r12.getCurrentPosition();
        if (r16 == false) goto L15;
        if (r20 > r19) goto L16;
    L17:
        int r21 = 0;
    L19:
        if (r21 >= r10.length) goto L33;
        if (isOutOfRange(r12.getCurrentPosition()) == true) goto L33;
        View r22 = nextView(r11, r12, r14, r13);
        if (r22 == null) goto L33;
        r10[r21] = r22;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 != null) goto L30;
        r22.setLayoutParams(generateDefaultLayoutParams());
    L32:
        r21 = r21 + 1;
        goto L19
    L30:
        if (checkLayoutParams(r23) == true) goto L32;
        r22.setLayoutParams(generateLayoutParams(r23));
    L33:
        if (r21 <= 0) goto L38;
        if (r16 == true) goto L38;
        int r24 = r21 - 1;
    L36:
        if (r15 >= r24) goto L38;
        View r25 = r10[r15];
        r10[r15] = r10[r24];
        r10[r24] = r25;
        r15 = r15 + 1;
        r24 = r24 - 1;
    L38:
        return r21;
    L16:
        Log.w(TAG, "Please handle strange order views carefully");
        goto L17
    L15:
        if (r20 <= r19) goto L17;
    L10:
        r18 = r17.getUpper();
        goto L11
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public boolean isRecyclable(int r10, int r11, int r12, LayoutManagerHelper r13, boolean r14) {
        Range<Integer> r15 = getRange();
        if (r15.contains(Integer.valueOf(r10)) == true) goto L5;
        Log.w(TAG, "Child item not match");
        return true;
    L5:
        if (this.hasHeader == false) goto L10;
        if (r10 != ((Integer) getRange().getLower()).intValue()) goto L10;
        return true;
    L10:
        if (this.hasFooter == true) goto L12;
    L14:
        Range r16 = Range.create(Integer.valueOf(((Integer) r15.getLower()).intValue() + (this.hasHeader ? 1 : 0)), Integer.valueOf(((Integer) r15.getUpper()).intValue() - (this.hasFooter ? 1 : 0)));
        return Range.create(Integer.valueOf(r11), Integer.valueOf(r12)).contains(r16);
    L12:
        if (r10 != ((Integer) getRange().getUpper()).intValue()) goto L14;
        return true;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r10, RecyclerView.State r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutChunkResult r13, LayoutManagerHelper r14) {
        this.mTempLayoutHelper = r14;
        doLayoutView(r10, r11, r12, r13, r14);
        this.mTempLayoutHelper = null;
    }

    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
    }

    public void onMeasure(int r10, int r11) {
    }

    public void setHasFooter(boolean r10) {
        this.hasFooter = r10;
    }

    public void setHasHeader(boolean r10) {
        this.hasHeader = r10;
    }

    public final void setMeasuredDimension(int r10, int r11) {
    }
}
