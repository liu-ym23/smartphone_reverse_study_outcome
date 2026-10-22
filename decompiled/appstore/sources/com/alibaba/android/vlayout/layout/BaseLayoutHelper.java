package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.R;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLayoutHelper extends MarginLayoutHelper {
    public static boolean DEBUG = false;
    private static final String TAG = "BaseLayoutHelper";
    float mAspectRatio;
    int mBgColor;
    private int mItemCount;
    protected Rect mLayoutRegion;
    View mLayoutView;
    private LayoutViewBindListener mLayoutViewBindListener;
    private LayoutViewUnBindListener mLayoutViewUnBindListener;

    public static class DefaultLayoutViewHelper implements LayoutViewBindListener, LayoutViewUnBindListener, LayoutViewHelper {
        private final LayoutViewBindListener mLayoutViewBindListener;
        private final LayoutViewUnBindListener mLayoutViewUnBindListener;

        public DefaultLayoutViewHelper(LayoutViewBindListener r10, LayoutViewUnBindListener r11) {
            this.mLayoutViewBindListener = r10;
            this.mLayoutViewUnBindListener = r11;
        }

        @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper.LayoutViewBindListener
        public void onBind(View r10, BaseLayoutHelper r11) {
            if (r10.getTag(R.id.tag_layout_helper_bg) != null) goto L8;
            LayoutViewBindListener r12 = this.mLayoutViewBindListener;
            if (r12 == null) goto L9;
            r12.onBind(r10, r11);
            return;
        L9:
            return;
        }

        @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper.LayoutViewHelper
        public void onBindViewSuccess(View r10, String r11) {
            r10.setTag(R.id.tag_layout_helper_bg, r11);
        }

        @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper.LayoutViewUnBindListener
        public void onUnbind(View r10, BaseLayoutHelper r11) {
            LayoutViewUnBindListener r12 = this.mLayoutViewUnBindListener;
            if (r12 == null) goto L5;
            r12.onUnbind(r10, r11);
        L5:
            r10.setTag(R.id.tag_layout_helper_bg, null);
        }
    }

    public interface LayoutViewBindListener {
        void onBind(View r10, BaseLayoutHelper r11);
    }

    public interface LayoutViewHelper {
        void onBindViewSuccess(View r10, String r11);
    }

    public interface LayoutViewUnBindListener {
        void onUnbind(View r10, BaseLayoutHelper r11);
    }

    static {
    }

    public BaseLayoutHelper() {
        this.mLayoutRegion = new Rect();
        this.mAspectRatio = Float.NaN;
        this.mItemCount = 0;
    }

    private int calGap(int r10, int r11) {
        if (r10 < r11) goto L4;
        return 0;
    L4:
        return r11 - r10;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void adjustLayout(int r10, int r11, LayoutManagerHelper r12) {
        if (requireLayoutView() == false) goto L30;
        Rect r13 = new Rect();
        OrientationHelperEx r14 = r12.getMainOrientationHelper();
        int r15 = 0;
    L6:
        if (r15 >= r12.getChildCount()) goto L18;
        View r16 = r12.getChildAt(r15);
        int r17 = r12.getPosition(r16);
        if (getRange().contains(Integer.valueOf(r17)) == false) goto L16;
        if (r16.getVisibility() != 8) goto L12;
        r13.setEmpty();
        goto L16
    L12:
        RecyclerView.LayoutParams r18 = (RecyclerView.LayoutParams) r16.getLayoutParams();
        if (r12.getOrientation() != 1) goto L15;
        r13.union(r12.getDecoratedLeft(r16) - ((ViewGroup.MarginLayoutParams) r18).leftMargin, r14.getDecoratedStart(r16), r12.getDecoratedRight(r16) + ((ViewGroup.MarginLayoutParams) r18).rightMargin, r14.getDecoratedEnd(r16));
        goto L16
    L15:
        r13.union(r14.getDecoratedStart(r16), r12.getDecoratedTop(r16) - ((ViewGroup.MarginLayoutParams) r18).topMargin, r14.getDecoratedEnd(r16), r12.getDecoratedBottom(r16) + ((ViewGroup.MarginLayoutParams) r18).bottomMargin);
    L16:
        r15 = r15 + 1;
        goto L6
    L18:
        if (r13.isEmpty() == true) goto L20;
        this.mLayoutRegion.set(r13.left - this.mPaddingLeft, r13.top - this.mPaddingTop, r13.right + this.mPaddingRight, r13.bottom + this.mPaddingBottom);
    L21:
        View r19 = this.mLayoutView;
        if (r19 == null) goto L31;
        Rect r20 = this.mLayoutRegion;
        r19.layout(r20.left, r20.top, r20.right, r20.bottom);
        return;
    L31:
        return;
    L20:
        this.mLayoutRegion.setEmpty();
        goto L21
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void afterLayout(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, int r14, LayoutManagerHelper r15) {
        if (DEBUG == false) goto L6;
        Log.d(TAG, "call afterLayout() on " + getClass().getSimpleName());
    L6:
        if (requireLayoutView() == true) goto L8;
    L39:
        View r16 = this.mLayoutView;
        if (r16 == null) goto L46;
        LayoutViewUnBindListener r17 = this.mLayoutViewUnBindListener;
        if (r17 == null) goto L44;
        r17.onUnbind(r16, this);
    L44:
        r15.removeChildView(this.mLayoutView);
        this.mLayoutView = null;
        return;
    L46:
        return;
    L8:
        if (isValidScrolled(r14) == false) goto L13;
        View r18 = this.mLayoutView;
        if (r18 == null) goto L13;
        this.mLayoutRegion.union(r18.getLeft(), this.mLayoutView.getTop(), this.mLayoutView.getRight(), this.mLayoutView.getBottom());
    L13:
        if (this.mLayoutRegion.isEmpty() == true) goto L39;
        if (isValidScrolled(r14) == true) goto L17;
    L20:
        int r19 = r15.getContentWidth();
        int r20 = r15.getContentHeight();
        if (r15.getOrientation() != 1) goto L26;
        if (this.mLayoutRegion.intersects(0, (-r20) / 4, r19, r20 + (r20 / 4)) == true) goto L28;
    L36:
        this.mLayoutRegion.set(0, 0, 0, 0);
        View r21 = this.mLayoutView;
        if (r21 == null) goto L39;
        r21.layout(0, 0, 0, 0);
    L28:
        if (this.mLayoutView != null) goto L31;
        View r22 = r15.generateLayoutView();
        this.mLayoutView = r22;
        r15.addOffFlowView(r22, true);
    L31:
        if (r15.getOrientation() != 1) goto L33;
        this.mLayoutRegion.left = r15.getPaddingLeft() + this.mMarginLeft;
        this.mLayoutRegion.right = (r15.getContentWidth() - r15.getPaddingRight()) - this.mMarginRight;
    L34:
        bindLayoutView(this.mLayoutView);
        return;
    L33:
        this.mLayoutRegion.top = r15.getPaddingTop() + this.mMarginTop;
        this.mLayoutRegion.bottom = (r15.getContentWidth() - r15.getPaddingBottom()) - this.mMarginBottom;
        goto L34
    L26:
        if (this.mLayoutRegion.intersects((-r19) / 4, 0, r19 + (r19 / 4), r20) == false) goto L36;
    L17:
        if (r15.getOrientation() != 1) goto L19;
        this.mLayoutRegion.offset(0, -r14);
        goto L20
    L19:
        this.mLayoutRegion.offset(-r14, 0);
        goto L20
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void beforeLayout(RecyclerView.Recycler r10, RecyclerView.State r11, LayoutManagerHelper r12) {
        if (DEBUG == false) goto L6;
        Log.d(TAG, "call beforeLayout() on " + getClass().getSimpleName());
    L6:
        if (requireLayoutView() == true) goto L16;
        View r13 = this.mLayoutView;
        if (r13 == null) goto L15;
        LayoutViewUnBindListener r14 = this.mLayoutViewUnBindListener;
        if (r14 == null) goto L13;
        r14.onUnbind(r13, this);
    L13:
        r12.removeChildView(this.mLayoutView);
        this.mLayoutView = null;
        return;
    L15:
        return;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void bindLayoutView(@NonNull View r10) {
        r10.measure(View.MeasureSpec.makeMeasureSpec(this.mLayoutRegion.width(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(this.mLayoutRegion.height(), Ints.MAX_POWER_OF_TWO));
        Rect r11 = this.mLayoutRegion;
        r10.layout(r11.left, r11.top, r11.right, r11.bottom);
        r10.setBackgroundColor(this.mBgColor);
        LayoutViewBindListener r12 = this.mLayoutViewBindListener;
        if (r12 == null) goto L5;
        r12.onBind(r10, this);
    L5:
        this.mLayoutRegion.set(0, 0, 0, 0);
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public final void clear(LayoutManagerHelper r10) {
        View r11 = this.mLayoutView;
        if (r11 == null) goto L8;
        LayoutViewUnBindListener r12 = this.mLayoutViewUnBindListener;
        if (r12 == null) goto L7;
        r12.onUnbind(r11, this);
    L7:
        r10.removeChildView(this.mLayoutView);
        this.mLayoutView = null;
    L8:
        onClear(r10);
    }

    public int computeEndSpace(LayoutManagerHelper r10, boolean r11, boolean r12, boolean r13) {
        if (r11 == false) goto L5;
        int r14 = this.mMarginBottom;
        int r15 = this.mPaddingBottom;
    L6:
        return r14 + r15;
    L5:
        r14 = this.mMarginLeft;
        r15 = this.mPaddingLeft;
        goto L6
    }

    public int computeStartSpace(LayoutManagerHelper r10, boolean r11, boolean r12, boolean r13) {
        MarginLayoutHelper r14 = null;
        if ((r10 instanceof VirtualLayoutManager) == false) goto L5;
        LayoutHelper r15 = ((VirtualLayoutManager) r10).findNeighbourNonfixLayoutHelper(this, r12);
    L6:
        if (r15 != null) goto L8;
    L10:
        if (r15 != this) goto L13;
        return 0;
    L13:
        if (r13 == true) goto L18;
        if (r11 == false) goto L17;
        int r16 = this.mMarginTop;
        int r17 = this.mPaddingTop;
    L41:
        return r16 + r17;
    L17:
        r16 = this.mMarginLeft;
        r17 = this.mPaddingLeft;
        goto L41
    L18:
        if (r14 != null) goto L23;
        if (r11 == false) goto L22;
        int r18 = this.mMarginTop;
        int r19 = this.mPaddingTop;
    L21:
        int r20 = r18 + r19;
    L32:
        if (r11 == false) goto L36;
        if (r12 == false) goto L35;
        int r21 = this.mPaddingTop;
    L40:
        return r20 + r21;
    L35:
        r21 = this.mPaddingBottom;
        goto L40
    L36:
        if (r12 == false) goto L38;
        r21 = this.mPaddingLeft;
        goto L40
    L38:
        r21 = this.mPaddingRight;
        goto L40
    L22:
        r18 = this.mMarginLeft;
        r19 = this.mPaddingLeft;
        goto L21
    L23:
        if (r11 == false) goto L28;
        if (r12 == false) goto L27;
        int r22 = r14.mMarginBottom;
        int r23 = this.mMarginTop;
    L26:
        r20 = calGap(r22, r23);
        goto L32
    L27:
        r22 = r14.mMarginTop;
        r23 = this.mMarginBottom;
        goto L26
    L28:
        if (r12 == false) goto L31;
        int r24 = r14.mMarginRight;
        int r25 = this.mMarginLeft;
    L30:
        r20 = calGap(r24, r25);
        goto L32
    L31:
        r24 = r14.mMarginLeft;
        r25 = this.mMarginRight;
        goto L30
    L8:
        if ((r15 instanceof MarginLayoutHelper) == false) goto L10;
        r14 = (MarginLayoutHelper) r15;
        goto L10
    L5:
        r15 = null;
        goto L6
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void doLayout(RecyclerView.Recycler r10, RecyclerView.State r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutChunkResult r13, LayoutManagerHelper r14) {
        layoutViews(r10, r11, r12, r13, r14);
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public int getBgColor() {
        return this.mBgColor;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public int getItemCount() {
        return this.mItemCount;
    }

    public void handleStateOnResult(LayoutChunkResult r10, View r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        RecyclerView.LayoutParams r12 = (RecyclerView.LayoutParams) r11.getLayoutParams();
        boolean r13 = true;
        if (r12.isItemRemoved() == false) goto L7;
    L8:
        r10.mIgnoreConsumed = true;
    L10:
        if (r10.mFocusable == false) goto L12;
    L15:
        r10.mFocusable = r13;
        return;
    L12:
        if (r11.isFocusable() == true) goto L15;
        r13 = false;
        goto L15
    L7:
        if (r12.isItemChanged() == false) goto L10;
        goto L8
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public boolean isFixLayout() {
        return false;
    }

    public boolean isValidScrolled(int r10) {
        if (r10 != Integer.MAX_VALUE) goto L5;
    L7:
        return false;
    L5:
        if (r10 == Integer.MIN_VALUE) goto L7;
        return true;
    }

    public void layoutChild(View r10, int r11, int r12, int r13, int r14, @NonNull LayoutManagerHelper r15) {
        layoutChild(r10, r11, r12, r13, r14, r15, false);
    }

    public void layoutChildWithMargin(View r10, int r11, int r12, int r13, int r14, @NonNull LayoutManagerHelper r15) {
        layoutChildWithMargin(r10, r11, r12, r13, r14, r15, false);
    }

    public abstract void layoutViews(RecyclerView.Recycler r10, RecyclerView.State r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutChunkResult r13, LayoutManagerHelper r14);

    @Nullable
    public final View nextView(RecyclerView.Recycler r10, VirtualLayoutManager.LayoutStateWrapper r11, LayoutManagerHelper r12, LayoutChunkResult r13) {
        View r14 = r11.next(r10);
        if (r14 == null) goto L5;
        r12.addChildView(r11, r14);
        return r14;
    L5:
        if (DEBUG == true) goto L7;
    L11:
        r13.mFinished = true;
        return null;
    L7:
        if (r11.hasScrapList() == true) goto L11;
        throw new RuntimeException("received null view when unexpected");
    }

    public void onClear(LayoutManagerHelper r10) {
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public boolean requireLayoutView() {
        if (this.mBgColor == 0) goto L5;
    L8:
        return true;
    L5:
        if (this.mLayoutViewBindListener != null) goto L8;
        return false;
    }

    public void setAspectRatio(float r10) {
        this.mAspectRatio = r10;
    }

    public void setBgColor(int r10) {
        this.mBgColor = r10;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void setItemCount(int r10) {
        this.mItemCount = r10;
    }

    public void setLayoutViewBindListener(LayoutViewBindListener r10) {
        this.mLayoutViewBindListener = r10;
    }

    public void setLayoutViewHelper(DefaultLayoutViewHelper r10) {
        this.mLayoutViewBindListener = r10;
        this.mLayoutViewUnBindListener = r10;
    }

    public void setLayoutViewUnBindListener(LayoutViewUnBindListener r10) {
        this.mLayoutViewUnBindListener = r10;
    }

    public void layoutChild(View r10, int r11, int r12, int r13, int r14, @NonNull LayoutManagerHelper r15, boolean r16) {
        r15.layoutChild(r10, r11, r12, r13, r14);
        if (requireLayoutView() == false) goto L8;
        if (r16 == false) goto L6;
        this.mLayoutRegion.union((r11 - this.mPaddingLeft) - this.mMarginLeft, (r12 - this.mPaddingTop) - this.mMarginTop, (r13 + this.mPaddingRight) + this.mMarginRight, (r14 + this.mPaddingBottom) + this.mMarginBottom);
        return;
    L6:
        this.mLayoutRegion.union(r11 - this.mPaddingLeft, r12 - this.mPaddingTop, r13 + this.mPaddingRight, r14 + this.mPaddingBottom);
        return;
    }

    public void layoutChildWithMargin(View r10, int r11, int r12, int r13, int r14, @NonNull LayoutManagerHelper r15, boolean r16) {
        r15.layoutChildWithMargins(r10, r11, r12, r13, r14);
        if (requireLayoutView() == false) goto L8;
        if (r16 == false) goto L6;
        this.mLayoutRegion.union((r11 - this.mPaddingLeft) - this.mMarginLeft, (r12 - this.mPaddingTop) - this.mMarginTop, (r13 + this.mPaddingRight) + this.mMarginRight, (r14 + this.mPaddingBottom) + this.mMarginBottom);
        return;
    L6:
        this.mLayoutRegion.union(r11 - this.mPaddingLeft, r12 - this.mPaddingTop, r13 + this.mPaddingRight, r14 + this.mPaddingBottom);
        return;
    }

    public void handleStateOnResult(LayoutChunkResult r10, View... r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L26;
        View r14 = r11[r13];
        if (r14 == null) goto L25;
        RecyclerView.LayoutParams r15 = (RecyclerView.LayoutParams) r14.getLayoutParams();
        boolean r16 = true;
        if (r15.isItemRemoved() == false) goto L12;
    L13:
        r10.mIgnoreConsumed = true;
    L15:
        if (r10.mFocusable == false) goto L17;
    L20:
        r10.mFocusable = r16;
        if (r16 == false) goto L25;
        if (r10.mIgnoreConsumed == false) goto L25;
        return;
    L17:
        if (r14.isFocusable() == true) goto L20;
        r16 = false;
        goto L20
    L12:
        if (r15.isItemChanged() == false) goto L15;
    L25:
        r13 = r13 + 1;
        goto L5
    }
}
