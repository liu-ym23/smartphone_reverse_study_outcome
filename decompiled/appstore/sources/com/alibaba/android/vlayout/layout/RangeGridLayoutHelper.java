package com.alibaba.android.vlayout.layout;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.Range;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.google.common.primitives.Ints;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class RangeGridLayoutHelper extends BaseLayoutHelper {
    private static boolean DEBUG = false;
    private static final int MAIN_DIR_SPEC = 0;
    private static final String TAG = "RGLayoutHelper";
    private boolean mLayoutWithAnchor;
    private GridRangeStyle mRangeStyle;
    private int mTotalSize;

    public static class GridRangeStyle extends RangeStyle<GridRangeStyle> {
        private float mAspectRatio;
        private int mHGap;
        private boolean mIgnoreExtra;
        private boolean mIsAutoExpand;
        private View[] mSet;
        private int mSizePerSpan;
        private int[] mSpanCols;
        private int mSpanCount;
        private int[] mSpanIndices;

        @NonNull
        private GridLayoutHelper.SpanSizeLookup mSpanSizeLookup;
        private int mVGap;
        private float[] mWeights;

        public GridRangeStyle(RangeGridLayoutHelper r10) {
            super(r10);
            this.mAspectRatio = Float.NaN;
            this.mSpanCount = 4;
            this.mSizePerSpan = 0;
            this.mIsAutoExpand = true;
            this.mIgnoreExtra = false;
            GridLayoutHelper.DefaultSpanSizeLookup r11 = new GridLayoutHelper.DefaultSpanSizeLookup();
            this.mSpanSizeLookup = r11;
            this.mVGap = 0;
            this.mHGap = 0;
            this.mWeights = new float[0];
            r11.setSpanIndexCacheEnabled(true);
        }

        public static /* synthetic */ int access$000(GridRangeStyle r10) {
            return r10.mSizePerSpan;
        }

        public static /* synthetic */ int access$002(GridRangeStyle r10, int r11) {
            r10.mSizePerSpan = r11;
            return r11;
        }

        public static /* synthetic */ int access$100(GridRangeStyle r10) {
            return r10.mSpanCount;
        }

        public static /* synthetic */ int[] access$1000(GridRangeStyle r10) {
            return r10.mSpanIndices;
        }

        public static /* synthetic */ float access$1100(GridRangeStyle r10) {
            return r10.mAspectRatio;
        }

        public static /* synthetic */ int access$200(GridRangeStyle r10) {
            return r10.mHGap;
        }

        public static /* synthetic */ int access$300(GridRangeStyle r10) {
            return r10.mVGap;
        }

        public static /* synthetic */ void access$400(GridRangeStyle r10) {
            r10.ensureSpanCount();
        }

        public static /* synthetic */ GridLayoutHelper.SpanSizeLookup access$500(GridRangeStyle r10) {
            return r10.mSpanSizeLookup;
        }

        public static /* synthetic */ View[] access$600(GridRangeStyle r10) {
            return r10.mSet;
        }

        public static /* synthetic */ boolean access$700(GridRangeStyle r10) {
            return r10.mIsAutoExpand;
        }

        public static /* synthetic */ float[] access$800(GridRangeStyle r10) {
            return r10.mWeights;
        }

        public static /* synthetic */ int[] access$900(GridRangeStyle r10) {
            return r10.mSpanCols;
        }

        public static int computeEndAlignOffset(GridRangeStyle r10, boolean r11) {
            if (r11 == false) goto L5;
            int r12 = r10.mMarginBottom;
            int r13 = r10.mPaddingBottom;
        L4:
            int r14 = r12 + r13;
            int r15 = ((Integer) r10.getRange().getUpper()).intValue();
            int r16 = r10.mChildren.size();
            int r17 = 0;
        L7:
            if (r17 >= r16) goto L24;
            GridRangeStyle r18 = (GridRangeStyle) r10.mChildren.valueAt(r17);
            if (r18.isChildrenEmpty() == true) goto L12;
            r14 = r14 + computeEndAlignOffset(r18, r11);
        L18:
            r17 = r17 + 1;
            goto L7
        L12:
            if (((Integer) r18.mRange.getUpper()).intValue() != r15) goto L18;
            if (r11 == false) goto L16;
            int r19 = r18.mMarginBottom;
            int r20 = r18.mPaddingBottom;
        L19:
            return r14 + (r19 + r20);
        L16:
            r19 = r18.mMarginRight;
            r20 = r18.mPaddingRight;
            goto L19
        L24:
            return r14;
        L5:
            r12 = r10.mMarginRight;
            r13 = r10.mPaddingRight;
            goto L4
        }

        public static int computeStartAlignOffset(GridRangeStyle r10, boolean r11) {
            if (r11 == false) goto L5;
            int r12 = -r10.mMarginTop;
            int r13 = r10.mPaddingTop;
        L4:
            int r14 = r12 - r13;
            int r15 = ((Integer) r10.getRange().getLower()).intValue();
            int r16 = r10.mChildren.size();
            int r17 = 0;
        L7:
            if (r17 >= r16) goto L24;
            GridRangeStyle r18 = (GridRangeStyle) r10.mChildren.valueAt(r17);
            if (r18.isChildrenEmpty() == true) goto L12;
            r14 = r14 + computeStartAlignOffset(r18, r11);
        L18:
            r17 = r17 + 1;
            goto L7
        L12:
            if (((Integer) r18.mRange.getLower()).intValue() != r15) goto L18;
            if (r11 == false) goto L16;
            int r19 = -r18.mMarginTop;
            int r20 = r18.mPaddingTop;
        L19:
            return r14 + (r19 - r20);
        L16:
            r19 = -r18.mMarginLeft;
            r20 = r18.mPaddingLeft;
            goto L19
        L24:
            return r14;
        L5:
            r12 = -r10.mMarginLeft;
            r13 = r10.mPaddingLeft;
            goto L4
        }

        private void ensureSpanCount() {
            View[] r10 = this.mSet;
            if (r10 != null) goto L5;
        L6:
            this.mSet = new View[this.mSpanCount];
        L7:
            int[] r11 = this.mSpanIndices;
            if (r11 != null) goto L10;
        L11:
            this.mSpanIndices = new int[this.mSpanCount];
        L12:
            int[] r12 = this.mSpanCols;
            if (r12 != null) goto L15;
        L16:
            this.mSpanCols = new int[this.mSpanCount];
            return;
        L15:
            if (r12.length != this.mSpanCount) goto L16;
            return;
        L10:
            if (r11.length == this.mSpanCount) goto L12;
        L5:
            if (r10.length == this.mSpanCount) goto L7;
            goto L6
        }

        private GridRangeStyle findRangeStyle(GridRangeStyle r10, int r11) {
            int r12 = r10.mChildren.size();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L13;
            GridRangeStyle r14 = (GridRangeStyle) r10.mChildren.valueAt(r13);
            Range r15 = (Range) r10.mChildren.keyAt(r13);
            if (r14.isChildrenEmpty() == false) goto L7;
            if (r15.contains(Integer.valueOf(r11)) == true) goto L11;
            r13 = r13 + 1;
            goto L3
        L11:
            return (GridRangeStyle) r10.mChildren.valueAt(r13);
        L7:
            return findRangeStyle(r14, r11);
        L13:
            return r10;
        }

        public GridRangeStyle findRangeStyleByPosition(int r10) {
            return findRangeStyle(this, r10);
        }

        public GridRangeStyle findSiblingStyleByPosition(int r10) {
            T r11 = this.mParent;
            if (r11 == 0) goto L12;
            ArrayMap r12 = ((GridRangeStyle) r11).mChildren;
            int r13 = r12.size();
            int r14 = 0;
        L5:
            if (r14 >= r13) goto L12;
            if (((Range) r12.keyAt(r14)).contains(Integer.valueOf(r10)) == true) goto L8;
            r14 = r14 + 1;
            goto L5
        L8:
            GridRangeStyle r15 = (GridRangeStyle) r12.valueAt(r14);
            if (r15.equals(this) == true) goto L12;
            return r15;
        L12:
            return null;
        }

        public float getAspectRatio() {
            return this.mAspectRatio;
        }

        public int getSpanCount() {
            return this.mSpanCount;
        }

        public void onInvalidateSpanIndexCache() {
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            int r10 = this.mChildren.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            ((GridRangeStyle) this.mChildren.valueAt(r11)).onInvalidateSpanIndexCache();
            r11 = r11 + 1;
            goto L3
        }

        public void setAspectRatio(float r10) {
            this.mAspectRatio = r10;
        }

        public void setAutoExpand(boolean r10) {
            this.mIsAutoExpand = r10;
        }

        public void setGap(int r10) {
            setVGap(r10);
            setHGap(r10);
        }

        public void setHGap(int r10) {
            if (r10 >= 0) goto L4;
            r10 = 0;
        L4:
            this.mHGap = r10;
        }

        public void setIgnoreExtra(boolean r10) {
            this.mIgnoreExtra = r10;
        }

        @Override // com.alibaba.android.vlayout.layout.RangeStyle
        public void setRange(int r10, int r11) {
            super.setRange(r10, r11);
            this.mSpanSizeLookup.setStartPosition(r10);
            this.mSpanSizeLookup.invalidateSpanIndexCache();
        }

        public void setSpanCount(int r10) {
            if (r10 != this.mSpanCount) goto L6;
            return;
        L6:
            if (r10 < 1) goto L10;
            this.mSpanCount = r10;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            ensureSpanCount();
            return;
        L10:
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + r10);
        }

        public void setSpanSizeLookup(GridLayoutHelper.SpanSizeLookup r10) {
            if (r10 == null) goto L5;
            r10.setStartPosition(this.mSpanSizeLookup.getStartPosition());
            this.mSpanSizeLookup = r10;
            return;
        }

        public void setVGap(int r10) {
            if (r10 >= 0) goto L4;
            r10 = 0;
        L4:
            this.mVGap = r10;
        }

        public void setWeights(float[] r10) {
            if (r10 == null) goto L4;
            this.mWeights = Arrays.copyOf(r10, r10.length);
            return;
        L4:
            this.mWeights = new float[0];
        }

        public GridRangeStyle() {
            this.mAspectRatio = Float.NaN;
            this.mSpanCount = 4;
            this.mSizePerSpan = 0;
            this.mIsAutoExpand = true;
            this.mIgnoreExtra = false;
            GridLayoutHelper.DefaultSpanSizeLookup r10 = new GridLayoutHelper.DefaultSpanSizeLookup();
            this.mSpanSizeLookup = r10;
            this.mVGap = 0;
            this.mHGap = 0;
            this.mWeights = new float[0];
            r10.setSpanIndexCacheEnabled(true);
        }
    }

    static {
        MAIN_DIR_SPEC = View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    public RangeGridLayoutHelper(int r10) {
        this(r10, -1, -1);
    }

    private void assignSpans(GridRangeStyle r10, RecyclerView.Recycler r11, RecyclerView.State r12, int r13, int r14, boolean r15, LayoutManagerHelper r16) {
        int r17 = 0;
        if (r15 == false) goto L5;
        int r18 = r13;
        int r19 = 0;
        int r20 = 1;
    L7:
        if (r16.getOrientation() == 1) goto L9;
    L11:
        int r110 = 1;
    L12:
        if (r19 == r18) goto L19;
        int r21 = getSpanSize(GridRangeStyle.access$500(r10), r11, r12, r16.getPosition(GridRangeStyle.access$600(r10)[r19]));
        if (r110 != (-1)) goto L17;
        if (r21 <= 1) goto L17;
        GridRangeStyle.access$1000(r10)[r19] = r17 - (r21 - 1);
    L18:
        r17 = r17 + (r21 * r110);
        r19 = r19 + r20;
    L17:
        GridRangeStyle.access$1000(r10)[r19] = r17;
        goto L18
    L19:
        return;
    L9:
        if (r16.isDoLayoutRTL() == false) goto L11;
        r17 = r14 - 1;
        r110 = -1;
        goto L12
    L5:
        r19 = r13 - 1;
        r18 = -1;
        r20 = -1;
        goto L7
    }

    private int getMainDirSpec(GridRangeStyle r10, int r11, int r12, int r13, float r14) {
        if (Float.isNaN(r14) == true) goto L10;
        if (r14 <= 0.0f) goto L10;
        if (r13 <= 0) goto L10;
        return View.MeasureSpec.makeMeasureSpec((int) ((r13 / r14) + 0.5f), Ints.MAX_POWER_OF_TWO);
    L10:
        if (Float.isNaN(GridRangeStyle.access$1100(r10)) == false) goto L12;
    L15:
        if (r11 >= 0) goto L19;
        return MAIN_DIR_SPEC;
    L19:
        return View.MeasureSpec.makeMeasureSpec(r11, Ints.MAX_POWER_OF_TWO);
    L12:
        if (GridRangeStyle.access$1100(r10) <= 0.0f) goto L15;
        return View.MeasureSpec.makeMeasureSpec((int) ((r12 / GridRangeStyle.access$1100(r10)) + 0.5f), Ints.MAX_POWER_OF_TWO);
    }

    private int getSpanIndex(GridLayoutHelper.SpanSizeLookup r10, int r11, RecyclerView.Recycler r12, RecyclerView.State r13, int r14) {
        if (r13.f() == false) goto L5;
        int r15 = r12.f(r14);
        if (r15 != (-1)) goto L11;
        return 0;
    L11:
        return r10.getCachedSpanIndex(r15, r11);
    L5:
        return r10.getCachedSpanIndex(r14, r11);
    }

    private int getSpanSize(GridLayoutHelper.SpanSizeLookup r10, RecyclerView.Recycler r11, RecyclerView.State r12, int r13) {
        if (r12.f() == false) goto L5;
        int r14 = r11.f(r13);
        if (r14 != (-1)) goto L11;
        return 0;
    L11:
        return r10.getSpanSize(r14);
    L5:
        return r10.getSpanSize(r13);
    }

    public void addRangeStyle(int r10, int r11, GridRangeStyle r12) {
        this.mRangeStyle.addChildRangeStyle(r10, r11, r12);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void adjustLayout(int r10, int r11, LayoutManagerHelper r12) {
        this.mRangeStyle.adjustLayout(r10, r11, r12);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void afterLayout(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, int r14, LayoutManagerHelper r15) {
        this.mRangeStyle.afterLayout(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void beforeLayout(RecyclerView.Recycler r10, RecyclerView.State r11, LayoutManagerHelper r12) {
        this.mRangeStyle.beforeLayout(r10, r11, r12);
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void checkAnchorInfo(RecyclerView.State r10, VirtualLayoutManager.AnchorInfoWrapper r11, LayoutManagerHelper r12) {
        if (r10.c() <= 0) goto L21;
        GridRangeStyle r13 = this.mRangeStyle.findRangeStyleByPosition(r11.position);
        int r14 = GridRangeStyle.access$500(r13).getCachedSpanIndex(r11.position, GridRangeStyle.access$100(r13));
        if (r11.layoutFromEnd == true) goto L7;
    L11:
        if (r14 <= 0) goto L15;
        int r15 = r11.position;
        if (r15 <= 0) goto L15;
        r11.position = r15 - 1;
        r14 = GridRangeStyle.access$500(r13).getCachedSpanIndex(r11.position, GridRangeStyle.access$100(r13));
    L15:
        this.mLayoutWithAnchor = true;
        return;
    L7:
        if (r14 >= (GridRangeStyle.access$100(r13) - 1)) goto L15;
        if (r11.position >= ((Integer) getRange().getUpper()).intValue()) goto L15;
        r11.position++;
        r14 = GridRangeStyle.access$500(r13).getCachedSpanIndex(r11.position, GridRangeStyle.access$100(r13));
        goto L7
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computeAlignOffset(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (r13.getOrientation() != 1) goto L5;
        boolean r14 = true;
    L6:
        if (r11 == true) goto L8;
        if (r10 == 0) goto L13;
    L15:
        return super.computeAlignOffset(r10, r11, r12, r13);
    L13:
        return GridRangeStyle.computeStartAlignOffset(this.mRangeStyle, r14);
    L8:
        if (r10 != (getItemCount() - 1)) goto L15;
        return GridRangeStyle.computeEndAlignOffset(this.mRangeStyle, r14);
    L5:
        r14 = false;
        goto L6
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public float getAspectRatio() {
        return this.mRangeStyle.getAspectRatio();
    }

    public int getBorderEndSpace(LayoutManagerHelper r10) {
        int r11 = ((Integer) getRange().getUpper()).intValue();
        GridRangeStyle r12 = this.mRangeStyle.findRangeStyleByPosition(r11);
        if (r10.getOrientation() != 1) goto L7;
        int r13 = r12.getFamilyMarginBottom();
        int r14 = r12.getFamilyPaddingBottom();
    L6:
        return r13 + r14;
    L7:
        r13 = r12.getFamilyMarginRight();
        r14 = r12.getFamilyPaddingRight();
        goto L6
    }

    public int getBorderStartSpace(LayoutManagerHelper r10) {
        int r11 = ((Integer) getRange().getLower()).intValue();
        GridRangeStyle r12 = this.mRangeStyle.findRangeStyleByPosition(r11);
        if (r10.getOrientation() != 1) goto L7;
        int r13 = r12.getFamilyMarginTop();
        int r14 = r12.getFamilyPaddingTop();
    L6:
        return r13 + r14;
    L7:
        r13 = r12.getFamilyMarginLeft();
        r14 = r12.getFamilyPaddingLeft();
        goto L6
    }

    public GridRangeStyle getRootRangeStyle() {
        return this.mRangeStyle;
    }

    public int getSpanCount() {
        return this.mRangeStyle.getSpanCount();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r32, RecyclerView.State r33, VirtualLayoutManager.LayoutStateWrapper r34, LayoutChunkResult r35, LayoutManagerHelper r36) {
        VirtualLayoutManager.LayoutStateWrapper r11 = r34;
        if (isOutOfRange(r34.getCurrentPosition()) == false) goto L5;
        return;
    L5:
        int r14 = r34.getCurrentPosition();
        GridRangeStyle r15 = this.mRangeStyle.findRangeStyleByPosition(r14);
        int r10 = r34.getItemDirection();
        if (r10 != 1) goto L8;
        boolean r16 = true;
    L9:
        OrientationHelperEx r12 = r36.getMainOrientationHelper();
        if (r36.getOrientation() != 1) goto L12;
        boolean r13 = true;
    L14:
        if (r13 == false) goto L16;
        int r17 = (((r36.getContentWidth() - r36.getPaddingRight()) - r36.getPaddingLeft()) - r15.getFamilyHorizontalMargin()) - r15.getFamilyHorizontalPadding();
        this.mTotalSize = r17;
        GridRangeStyle.access$002(r15, (int) ((((r17 - ((GridRangeStyle.access$100(r15) - 1) * GridRangeStyle.access$200(r15))) * 1.0f) / GridRangeStyle.access$100(r15)) + 0.5f));
    L17:
        int r18 = GridRangeStyle.access$100(r15);
        GridRangeStyle.access$400(r15);
        if (r16 == true) goto L69;
        int r23 = r14;
        String r19 = " requires ";
        String r110 = " spans.";
        boolean r111 = r13;
        OrientationHelperEx r24 = r12;
        int r20 = getSpanIndex(GridRangeStyle.access$500(r15), GridRangeStyle.access$100(r15), r32, r33, r34.getCurrentPosition());
        int r21 = getSpanSize(GridRangeStyle.access$500(r15), r32, r33, r34.getCurrentPosition()) + r20;
        boolean r112 = true;
        if (r20 == (GridRangeStyle.access$100(r15) - 1)) goto L67;
        int r22 = r34.getCurrentPosition();
        int r25 = GridRangeStyle.access$100(r15) - r21;
        boolean r26 = false;
        int r27 = 0;
        int r28 = 0;
        boolean r29 = false;
    L23:
        if (r28 >= GridRangeStyle.access$100(r15)) goto L61;
        if (r25 <= 0) goto L61;
        r22 = r22 - r10;
        if (r15.isOutOfRange(r22) == true) goto L61;
        int r30 = getSpanSize(GridRangeStyle.access$500(r15), r32, r33, r22);
        int r210 = r10;
        if (r30 > GridRangeStyle.access$100(r15)) goto L60;
        View r31 = r11.retrieve(r32, r22);
        if (r31 == null) goto L61;
        if (r26 == false) goto L35;
    L43:
        if (r29 == true) goto L55;
        boolean r211 = r36.getReverseLayout();
        GridRangeStyle r37 = this.mRangeStyle;
        if (r211 == false) goto L51;
        if (r22 != ((Integer) r37.getRange().getLower()).intValue()) goto L49;
    L48:
        boolean r38 = true;
    L53:
        r29 = r38;
    L49:
        r38 = false;
        goto L53
    L51:
        if (r22 != ((Integer) r37.getRange().getUpper()).intValue()) goto L49;
    L55:
        r25 = r25 - r30;
        if (r25 < 0) goto L62;
        r27 = r27 + r30;
        GridRangeStyle.access$600(r15)[r28] = r31;
        r28 = r28 + 1;
        r10 = r210;
        r26 = r26;
    L62:
        if (r28 <= 0) goto L66;
        int r39 = r28 - 1;
        int r40 = 0;
    L64:
        if (r40 >= r39) goto L66;
        View r41 = GridRangeStyle.access$600(r15)[r40];
        GridRangeStyle.access$600(r15)[r40] = GridRangeStyle.access$600(r15)[r39];
        GridRangeStyle.access$600(r15)[r39] = r41;
        r40 = r40 + 1;
        r39 = r39 - 1;
    L66:
        int r42 = r28;
        r18 = r21;
        boolean r212 = false;
        int r43 = r27;
        boolean r213 = r29;
        boolean r214 = false;
    L71:
        if (r42 >= GridRangeStyle.access$100(r15)) goto L87;
        if (r11.hasMore(r33) == false) goto L87;
        if (r18 <= 0) goto L87;
        int r44 = r34.getCurrentPosition();
        if (r15.isOutOfRange(r44) == true) goto L78;
        int r45 = getSpanSize(GridRangeStyle.access$500(r15), r32, r33, r44);
        if (r45 > GridRangeStyle.access$100(r15)) goto L144;
        r18 = r18 - r45;
        if (r18 < 0) goto L87;
        View r46 = r11.next(r32);
        if (r46 == null) goto L87;
        if (r26 == false) goto L90;
    L99:
        if (r214 == false) goto L101;
    L115:
        if (r213 == false) goto L117;
    L126:
        if (r212 == true) goto L142;
        if (r15.equals(this.mRangeStyle) == true) goto L142;
        if (this.mLayoutWithAnchor == false) goto L133;
        r44 = r34.getCurrentPosition();
    L133:
        if (r36.getReverseLayout() == false) goto L139;
        if (r44 != ((Integer) r15.getRange().getLower()).intValue()) goto L137;
    L136:
        boolean r47 = r112;
    L141:
        r212 = r47;
    L137:
        r47 = false;
        goto L141
    L139:
        if (r44 != ((Integer) r15.getRange().getUpper()).intValue()) goto L137;
    L142:
        r43 = r43 + r45;
        GridRangeStyle.access$600(r15)[r42] = r46;
        r42 = r42 + 1;
        goto L71
    L117:
        if (r36.getReverseLayout() == false) goto L123;
        if (r44 != ((Integer) this.mRangeStyle.getRange().getLower()).intValue()) goto L121;
    L120:
        boolean r48 = r112;
    L125:
        r213 = r48;
    L121:
        r48 = false;
        goto L125
    L123:
        if (r44 != ((Integer) this.mRangeStyle.getRange().getUpper()).intValue()) goto L121;
    L101:
        if (r15.equals(this.mRangeStyle) == true) goto L115;
        if (this.mLayoutWithAnchor == false) goto L106;
        r44 = r34.getCurrentPosition();
    L106:
        if (r36.getReverseLayout() == false) goto L112;
        if (r44 != ((Integer) r15.getRange().getUpper()).intValue()) goto L110;
    L109:
        boolean r49 = r112;
    L114:
        r214 = r49;
    L110:
        r49 = false;
        goto L114
    L112:
        if (r44 != ((Integer) r15.getRange().getLower()).intValue()) goto L110;
    L90:
        if (r36.getReverseLayout() == false) goto L96;
        if (r44 != ((Integer) this.mRangeStyle.getRange().getUpper()).intValue()) goto L94;
    L93:
        boolean r50 = r112;
    L98:
        r26 = r50;
    L94:
        r50 = false;
        goto L98
    L96:
        if (r44 != ((Integer) this.mRangeStyle.getRange().getLower()).intValue()) goto L94;
    L144:
        throw new IllegalArgumentException("Item at position " + r44 + r19 + r45 + " spans but GridLayoutManager has only " + GridRangeStyle.access$100(r15) + r110);
    L78:
        if (DEBUG == false) goto L87;
        Log.d(TAG, "pos [" + r44 + "] is out of range");
    L87:
        int r113 = r18;
        if (r42 != 0) goto L147;
        return;
    L147:
        int r51 = r43;
        int r114 = r42;
        assignSpans(r15, r32, r33, r42, r43, r16, r36);
        if (r113 <= 0) goto L155;
        if (r114 != r51) goto L155;
        if (GridRangeStyle.access$700(r15) == false) goto L155;
        if (r111 == false) goto L154;
        GridRangeStyle.access$002(r15, (this.mTotalSize - ((r114 - 1) * GridRangeStyle.access$200(r15))) / r114);
    L163:
        int r52 = -1;
        if (GridRangeStyle.access$800(r15) != null) goto L166;
    L195:
        boolean r53 = false;
    L196:
        int r54 = 0;
        int r115 = 0;
    L197:
        if (r54 >= r114) goto L224;
        View r55 = GridRangeStyle.access$600(r15)[r54];
        if (r16 == false) goto L202;
        int r56 = r52;
    L203:
        r36.addChildView(r11, r55, r56);
        int r57 = getSpanSize(GridRangeStyle.access$500(r15), r32, r33, r36.getPosition(r55));
        if (r53 == false) goto L210;
        int r58 = GridRangeStyle.access$1000(r15)[r54];
        int r59 = 0;
        int r60 = 0;
    L206:
        if (r60 >= r57) goto L208;
        r59 = r59 + GridRangeStyle.access$900(r15)[r60 + r58];
        r60 = r60 + 1;
        goto L206
    L208:
        int r61 = View.MeasureSpec.makeMeasureSpec(Math.max(0, r59), Ints.MAX_POWER_OF_TWO);
    L209:
        int r62 = r61;
        VirtualLayoutManager.LayoutParams r63 = (VirtualLayoutManager.LayoutParams) r55.getLayoutParams();
        if (r36.getOrientation() != 1) goto L219;
        View r64 = r55;
        r36.measureChildWithMargins(r64, r62, getMainDirSpec(r15, ((ViewGroup.MarginLayoutParams) r63).height, this.mTotalSize, View.MeasureSpec.getSize(r62), r63.mAspectRatio));
    L218:
        OrientationHelperEx r65 = r24;
        int r66 = r65.getDecoratedMeasurement(r64);
        if (r66 <= r115) goto L223;
        r115 = r66;
    L223:
        r54 = r54 + 1;
        r11 = r34;
        r24 = r65;
        r53 = r53;
        r111 = r111;
        r52 = -1;
        goto L197
    L219:
        r64 = r55;
        r36.measureChildWithMargins(r64, getMainDirSpec(r15, ((ViewGroup.MarginLayoutParams) r63).width, this.mTotalSize, View.MeasureSpec.getSize(r62), r63.mAspectRatio), View.MeasureSpec.getSize(r62));
        goto L218
    L210:
        int r67 = GridRangeStyle.access$000(r15) * r57;
        int r68 = Math.max(0, r57 - 1);
        if (r111 == 0) goto L213;
        int r69 = GridRangeStyle.access$200(r15);
    L214:
        r61 = View.MeasureSpec.makeMeasureSpec(r67 + (r68 * r69), Ints.MAX_POWER_OF_TWO);
        goto L209
    L213:
        r69 = GridRangeStyle.access$300(r15);
        goto L214
    L202:
        r56 = 0;
        goto L203
    L224:
        boolean r116 = r53;
        boolean r215 = r111;
        OrientationHelperEx r70 = r24;
        int r71 = getMainDirSpec(r15, r115, this.mTotalSize, 0, Float.NaN);
        int r72 = 0;
    L225:
        if (r72 >= r114) goto L245;
        View r73 = GridRangeStyle.access$600(r15)[r72];
        if (r70.getDecoratedMeasurement(r73) == r115) goto L243;
        int r74 = getSpanSize(GridRangeStyle.access$500(r15), r32, r33, r36.getPosition(r73));
        if (r116 == false) goto L234;
        int r75 = GridRangeStyle.access$1000(r15)[r72];
        int r76 = 0;
        int r77 = 0;
    L231:
        if (r76 >= r74) goto L233;
        r77 = r77 + GridRangeStyle.access$900(r15)[r76 + r75];
        r76 = r76 + 1;
        goto L231
    L233:
        int r78 = View.MeasureSpec.makeMeasureSpec(Math.max(0, r77), Ints.MAX_POWER_OF_TWO);
        boolean r79 = r215;
    L240:
        if (r36.getOrientation() != 1) goto L242;
        r36.measureChildWithMargins(r73, r78, r71);
    L244:
        r72 = r72 + 1;
        r215 = r79;
        goto L225
    L242:
        r36.measureChildWithMargins(r73, r71, r78);
        goto L244
    L234:
        int r80 = GridRangeStyle.access$000(r15) * r74;
        int r81 = Math.max(0, r74 - 1);
        r79 = r215;
        if (r79 == false) goto L237;
        int r82 = GridRangeStyle.access$200(r15);
    L238:
        r78 = View.MeasureSpec.makeMeasureSpec(r80 + (r81 * r82), Ints.MAX_POWER_OF_TWO);
        goto L240
    L237:
        r82 = GridRangeStyle.access$300(r15);
        goto L238
    L243:
        r79 = r215;
        goto L244
    L245:
        boolean r83 = r215;
        if (r34.getLayoutDirection() != 1) goto L248;
        boolean r84 = true;
    L249:
        boolean r85 = r36.isEnableMarginOverLap();
        if (r26 == false) goto L252;
        int r86 = computeStartSpace(r36, r83, r84, r85);
    L253:
        if (r214 == false) goto L258;
        if (r83 == false) goto L257;
        int r87 = r15.getMarginTop();
        int r88 = r15.getPaddingTop();
    L256:
        int r89 = r87 + r88;
    L259:
        if (r213 == false) goto L265;
        GridRangeStyle r90 = this.mRangeStyle;
        if (r83 == false) goto L264;
        int r91 = r90.getMarginBottom();
        int r92 = this.mRangeStyle.getPaddingBottom();
    L263:
        int r93 = r91 + r92;
    L266:
        if (r212 == false) goto L271;
        if (r83 == false) goto L270;
        int r94 = r15.getMarginBottom();
        int r95 = r15.getPaddingBottom();
    L269:
        int r96 = r94 + r95;
    L272:
        r35.mConsumed = (((r115 + r86) + r93) + r89) + r96;
        if (r34.getLayoutDirection() != (-1)) goto L275;
        boolean r97 = true;
    L276:
        String r117 = "⬆ ";
        OrientationHelperEx r216 = r70;
        if (this.mLayoutWithAnchor == false) goto L279;
        int r310 = r89;
        r96 = r96;
        r115 = r115;
        int r118 = r114;
        int r98 = r23;
        String r119 = TAG;
    L321:
        int r120 = 0;
    L322:
        int r99 = r35.mConsumed + r120;
        r35.mConsumed = r99;
        int r100 = 0;
        if (r99 > 0) goto L326;
        r35.mConsumed = 0;
    L326:
        if (r34.isRefreshLayout() == false) goto L328;
    L351:
        int r101 = 0;
    L353:
        if (DEBUG == false) goto L359;
        StringBuilder r102 = new StringBuilder();
        if (r97 == true) goto L358;
        r117 = "⬇ ";
    L358:
        r102.append(r117);
        r102.append(r98);
        r102.append(" consumed ");
        r102.append(r35.mConsumed);
        r102.append(" startSpace ");
        r102.append(r86);
        r102.append(" endSpace ");
        int r103 = r93;
        r102.append(r103);
        r102.append(" secondStartSpace ");
        int r104 = r310;
        r102.append(r104);
        r102.append(" secondEndSpace ");
        int r105 = r96;
        r102.append(r105);
        r102.append(" lastUnconsumedSpace ");
        r102.append(r101);
        Log.d(r119, r102.toString());
    L360:
        if (r83 == false) goto L365;
        if (r97 == false) goto L364;
        int r106 = (((r34.getOffset() - r103) - r105) - r120) - r101;
        int r107 = r106 - r115;
        int r108 = r106;
    L363:
        int r109 = r100;
    L368:
        int r121 = 0;
        int r122 = r118;
    L369:
        if (r121 >= r122) goto L397;
        View r123 = GridRangeStyle.access$600(r15)[r121];
        int r124 = GridRangeStyle.access$1000(r15)[r121];
        VirtualLayoutManager.LayoutParams r125 = (VirtualLayoutManager.LayoutParams) r123.getLayoutParams();
        if (r83 == false) goto L380;
        if (r116 == false) goto L377;
        r100 = (r36.getPaddingLeft() + r15.getFamilyMarginLeft()) + r15.getFamilyPaddingLeft();
        int r126 = r100;
    L374:
        if (r126 >= r124) goto L376;
        r100 = r100 + (GridRangeStyle.access$900(r15)[r126] + GridRangeStyle.access$200(r15));
        r126 = r126 + 1;
    L376:
        OrientationHelperEx r127 = r216;
        r109 = r127.getDecoratedMeasurementInOther(r123) + r100;
    L379:
        int r217 = r109;
        int r128 = r107;
        int r311 = r100;
        int r129 = r108;
        if (DEBUG == false) goto L391;
        Log.d(r119, "layout item in position: " + r125.getViewPosition() + " with text with SpanIndex: " + r124 + " into (" + r311 + ", " + r128 + ", " + r217 + ", " + r129 + " )");
    L391:
        int r218 = r122;
        boolean r219 = r83;
        r216 = r127;
        r15.layoutChild(r123, r311, r128, r217, r129, r36, false);
        if (r125.isItemRemoved() == false) goto L394;
    L395:
        r35.mIgnoreConsumed = true;
    L396:
        r35.mFocusable |= r123.isFocusable();
        r121 = r121 + 1;
        r109 = r217;
        r100 = r311;
        r108 = r129;
        r83 = r219;
        r107 = r128;
        r122 = r218;
        r100 = 0;
        goto L369
    L394:
        if (r125.isItemChanged() == false) goto L396;
    L377:
        r100 = (((r36.getPaddingLeft() + r15.getFamilyMarginLeft()) + r15.getFamilyPaddingLeft()) + (GridRangeStyle.access$000(r15) * r124)) + (GridRangeStyle.access$200(r15) * r124);
        goto L376
    L380:
        r127 = r216;
        if (r116 == false) goto L385;
        r107 = (r36.getPaddingTop() + r15.getFamilyMarginTop()) + r15.getFamilyPaddingTop();
        int r130 = r100;
    L383:
        if (r130 >= r124) goto L386;
        r107 = r107 + (GridRangeStyle.access$900(r15)[r130] + GridRangeStyle.access$300(r15));
        r130 = r130 + 1;
    L386:
        r108 = r127.getDecoratedMeasurementInOther(r123) + r107;
        goto L379
    L385:
        r107 = (((r36.getPaddingTop() + r15.getFamilyMarginTop()) + r15.getFamilyPaddingTop()) + (GridRangeStyle.access$000(r15) * r124)) + (GridRangeStyle.access$300(r15) * r124);
        goto L386
    L397:
        boolean r131 = r100;
        this.mLayoutWithAnchor = r131;
        Arrays.fill(GridRangeStyle.access$600(r15), null);
        Arrays.fill(GridRangeStyle.access$1000(r15), r131 ? 1 : 0);
        Arrays.fill(GridRangeStyle.access$900(r15), r131 ? 1 : 0);
        return;
    L364:
        int r132 = (((r34.getOffset() + r86) + r104) + r120) + r101;
        r108 = r132 + r115;
        r107 = r132;
        goto L363
    L365:
        if (r97 == false) goto L367;
        r109 = ((r34.getOffset() - r103) - r120) - r101;
        r100 = r109 - r115;
        r107 = 0;
        r108 = 0;
        goto L368
    L367:
        int r133 = ((r34.getOffset() + r86) + r120) + r101;
        r108 = 0;
        r100 = r133;
        r109 = r133 + r115;
        r107 = 0;
        goto L368
    L359:
        r105 = r96;
        r104 = r310;
        r103 = r93;
        goto L360
    L328:
        if (r97 == false) goto L340;
        int r134 = r98 + 1;
        if (isOutOfRange(r134) == true) goto L351;
        GridRangeStyle r135 = this.mRangeStyle.findRangeStyleByPosition(r134);
        if (r135.isFirstPosition(r134) == false) goto L351;
        if (r83 == false) goto L336;
        int r136 = r135.getMarginTop();
        int r137 = r135.getPaddingTop();
    L335:
        r101 = r136 + r137;
        if (DEBUG == false) goto L353;
        Log.d(r119, "⬆ " + r98 + " 1 " + r101 + " last");
        goto L353
    L336:
        r136 = r135.getMarginLeft();
        r137 = r135.getPaddingLeft();
        goto L335
    L340:
        int r138 = r98 - 1;
        if (isOutOfRange(r138) == true) goto L351;
        GridRangeStyle r139 = this.mRangeStyle.findRangeStyleByPosition(r138);
        if (r139.isLastPosition(r138) == false) goto L351;
        if (r83 == false) goto L347;
        int r140 = r139.getMarginBottom();
        int r141 = r139.getPaddingBottom();
    L346:
        r101 = r140 + r141;
        if (DEBUG == false) goto L353;
        Log.d(r119, "⬇ " + r98 + " 2 " + r101 + " last");
        goto L353
    L347:
        r140 = r139.getMarginRight();
        r141 = r139.getPaddingRight();
        goto L346
    L279:
        if (r97 == true) goto L301;
        if (r26 == true) goto L299;
        if (r214 == false) goto L292;
        r118 = r114;
        GridRangeStyle r142 = (GridRangeStyle) r15.mParent;
        if (r83 == false) goto L285;
        r120 = GridRangeStyle.access$300(r142);
    L287:
        if (DEBUG == false) goto L289;
        StringBuilder r143 = new StringBuilder();
        r143.append("⬇ ");
        r98 = r23;
        r143.append(r98);
        r143.append(" 1 ");
        r143.append(r120);
        r143.append(" gap");
        String r144 = r143.toString();
        r119 = TAG;
        Log.d(r119, r144);
    L290:
        r310 = r89;
    L291:
        r93 = r93;
        goto L322
    L289:
        r98 = r23;
        r119 = TAG;
        goto L290
    L285:
        r120 = GridRangeStyle.access$200(r142);
        goto L287
    L292:
        r96 = r96;
        r115 = r115;
        r118 = r114;
        r98 = r23;
        r119 = TAG;
        if (r83 == false) goto L295;
        r120 = GridRangeStyle.access$300(r15);
    L296:
        r310 = r89;
        if (DEBUG == false) goto L291;
        Log.d(r119, "⬇ " + r98 + " 2 " + r120 + " gap");
        goto L291
    L295:
        r120 = GridRangeStyle.access$200(r15);
        goto L296
    L299:
        r310 = r89;
        r96 = r96;
        r115 = r115;
        r118 = r114;
        r98 = r23;
        r119 = TAG;
        goto L321
    L301:
        r310 = r89;
        r96 = r96;
        r115 = r115;
        r118 = r114;
        r98 = r23;
        r119 = TAG;
        if (r213 == true) goto L321;
        if (r212 == false) goto L313;
        GridRangeStyle r145 = (GridRangeStyle) r15.mParent;
        if (r83 == false) goto L307;
        int r146 = GridRangeStyle.access$300(r145);
    L309:
        if (DEBUG == false) goto L311;
        StringBuilder r147 = new StringBuilder();
        r147.append("⬆ ");
        r147.append(r98);
        r93 = r93;
        r147.append(" 3 ");
        r147.append(r146);
        r147.append(" gap");
        Log.d(r119, r147.toString());
    L312:
        r120 = r146;
        goto L322
    L311:
        r93 = r93;
        goto L312
    L307:
        r146 = GridRangeStyle.access$200(r145);
        goto L309
    L313:
        r93 = r93;
        if (r83 == false) goto L316;
        r146 = GridRangeStyle.access$300(r15);
    L318:
        if (DEBUG == false) goto L312;
        Log.d(r119, "⬆ " + r98 + " 4 " + r146 + " gap");
        goto L312
    L316:
        r146 = GridRangeStyle.access$200(r15);
        goto L318
    L275:
        r97 = false;
        goto L276
    L270:
        r94 = r15.getMarginRight();
        r95 = r15.getPaddingRight();
        goto L269
    L271:
        r96 = 0;
        goto L272
    L264:
        r91 = r90.getMarginRight();
        r92 = this.mRangeStyle.getPaddingRight();
        goto L263
    L265:
        r93 = 0;
        goto L266
    L257:
        r87 = r15.getMarginLeft();
        r88 = r15.getPaddingLeft();
        goto L256
    L258:
        r89 = 0;
        goto L259
    L252:
        r86 = 0;
        goto L253
    L248:
        r84 = false;
        goto L249
    L166:
        if (GridRangeStyle.access$800(r15).length <= 0) goto L195;
        if (r111 == false) goto L170;
        int r148 = this.mTotalSize;
        int r149 = r114 - 1;
        int r150 = GridRangeStyle.access$200(r15);
    L169:
        int r151 = r148 - (r149 * r150);
        if (r113 > 0) goto L173;
    L175:
        int r152 = GridRangeStyle.access$100(r15);
    L176:
        int r153 = r151;
        int r154 = 0;
        int r155 = 0;
    L177:
        if (r155 >= r152) goto L187;
        if (r155 < GridRangeStyle.access$800(r15).length) goto L181;
    L185:
        r154 = r154 + 1;
        GridRangeStyle.access$900(r15)[r155] = -1;
    L186:
        r155 = r155 + 1;
        goto L177
    L181:
        if (Float.isNaN(GridRangeStyle.access$800(r15)[r155]) == true) goto L185;
        if (GridRangeStyle.access$800(r15)[r155] < 0.0f) goto L185;
        GridRangeStyle.access$900(r15)[r155] = (int) ((((GridRangeStyle.access$800(r15)[r155] * 1.0f) / 100.0f) * r151) + 0.5f);
        r153 = r153 - GridRangeStyle.access$900(r15)[r155];
        goto L186
    L187:
        if (r154 <= 0) goto L194;
        int r156 = r153 / r154;
        int r157 = 0;
    L189:
        if (r157 >= r152) goto L194;
        if (GridRangeStyle.access$900(r15)[r157] >= 0) goto L193;
        GridRangeStyle.access$900(r15)[r157] = r156;
    L193:
        r157 = r157 + 1;
    L194:
        r53 = true;
        goto L196
    L173:
        if (GridRangeStyle.access$700(r15) == false) goto L175;
        r152 = r114;
        goto L176
    L170:
        r148 = this.mTotalSize;
        r149 = r114 - 1;
        r150 = GridRangeStyle.access$300(r15);
        goto L169
    L154:
        GridRangeStyle.access$002(r15, (this.mTotalSize - ((r114 - 1) * GridRangeStyle.access$300(r15))) / r114);
    L155:
        if (r16 == true) goto L163;
        if (r113 != 0) goto L163;
        if (r114 != r51) goto L163;
        if (GridRangeStyle.access$700(r15) == false) goto L163;
        if (r111 == false) goto L162;
        GridRangeStyle.access$002(r15, (this.mTotalSize - ((r114 - 1) * GridRangeStyle.access$200(r15))) / r114);
        goto L163
    L162:
        GridRangeStyle.access$002(r15, (this.mTotalSize - ((r114 - 1) * GridRangeStyle.access$300(r15))) / r114);
        goto L163
    L35:
        if (r36.getReverseLayout() == false) goto L41;
        if (r22 != ((Integer) this.mRangeStyle.getRange().getUpper()).intValue()) goto L39;
    L38:
        r26 = true;
    L39:
        r26 = false;
        goto L43
    L41:
        if (r22 != ((Integer) this.mRangeStyle.getRange().getLower()).intValue()) goto L39;
    L60:
        throw new IllegalArgumentException("Item at position " + r22 + r19 + r30 + " spans but RangeGridLayoutHelper has only " + GridRangeStyle.access$100(r15) + r110);
    L61:
        r26 = r26;
        goto L62
    L67:
        r18 = r21;
    L68:
        r43 = 0;
        r42 = 0;
        r214 = false;
        r213 = false;
        r212 = false;
        r26 = false;
        goto L71
    L69:
        r110 = " spans.";
        r111 = r13;
        r24 = r12;
        r23 = r14;
        r112 = true;
        r19 = " requires ";
        goto L68
    L16:
        int r158 = (((r36.getContentHeight() - r36.getPaddingBottom()) - r36.getPaddingTop()) - r15.getFamilyVerticalMargin()) - r15.getFamilyVerticalPadding();
        this.mTotalSize = r158;
        GridRangeStyle.access$002(r15, (int) ((((r158 - ((GridRangeStyle.access$100(r15) - 1) * GridRangeStyle.access$300(r15))) * 1.0f) / GridRangeStyle.access$100(r15)) + 0.5f));
        goto L17
    L12:
        r13 = false;
        goto L14
    L8:
        r16 = false;
        goto L9
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper r10) {
        super.onClear(r10);
        this.mRangeStyle.onClear(r10);
        this.mRangeStyle.onInvalidateSpanIndexCache();
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onItemsChanged(LayoutManagerHelper r10) {
        super.onItemsChanged(r10);
        this.mRangeStyle.onInvalidateSpanIndexCache();
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onRangeChange(int r10, int r11) {
        this.mRangeStyle.setRange(r10, r11);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public boolean requireLayoutView() {
        return this.mRangeStyle.requireLayoutView();
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setAspectRatio(float r10) {
        this.mRangeStyle.setAspectRatio(r10);
    }

    public void setAutoExpand(boolean r10) {
        this.mRangeStyle.setAutoExpand(r10);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setBgColor(int r10) {
        this.mRangeStyle.setBgColor(r10);
    }

    public void setGap(int r10) {
        setVGap(r10);
        setHGap(r10);
    }

    public void setHGap(int r10) {
        this.mRangeStyle.setHGap(r10);
    }

    public void setIgnoreExtra(boolean r10) {
        this.mRangeStyle.setIgnoreExtra(r10);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setLayoutViewBindListener(BaseLayoutHelper.LayoutViewBindListener r10) {
        this.mRangeStyle.setLayoutViewBindListener(r10);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setLayoutViewHelper(BaseLayoutHelper.DefaultLayoutViewHelper r10) {
        this.mRangeStyle.setLayoutViewHelper(r10);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setLayoutViewUnBindListener(BaseLayoutHelper.LayoutViewUnBindListener r10) {
        this.mRangeStyle.setLayoutViewUnBindListener(r10);
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper
    public void setMargin(int r10, int r11, int r12, int r13) {
        super.setMargin(r10, r11, r12, r13);
        this.mRangeStyle.setMargin(r10, r11, r12, r13);
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper
    public void setPadding(int r10, int r11, int r12, int r13) {
        super.setPadding(r10, r11, r12, r13);
        this.mRangeStyle.setPadding(r10, r11, r12, r13);
    }

    public void setSpanCount(int r10) {
        this.mRangeStyle.setSpanCount(r10);
    }

    public void setSpanSizeLookup(GridLayoutHelper.SpanSizeLookup r10) {
        this.mRangeStyle.setSpanSizeLookup(r10);
    }

    public void setVGap(int r10) {
        this.mRangeStyle.setVGap(r10);
    }

    public void setWeights(float[] r10) {
        this.mRangeStyle.setWeights(r10);
    }

    public RangeGridLayoutHelper(int r10, int r11) {
        this(r10, r11, 0);
    }

    public RangeGridLayoutHelper(int r10, int r11, int r12) {
        this(r10, r11, r12, r12);
    }

    public RangeGridLayoutHelper(int r10, int r11, int r12, int r13) {
        this.mTotalSize = 0;
        this.mLayoutWithAnchor = false;
        GridRangeStyle r14 = new GridRangeStyle(this);
        this.mRangeStyle = r14;
        r14.setSpanCount(r10);
        this.mRangeStyle.setVGap(r12);
        this.mRangeStyle.setHGap(r13);
        setItemCount(r11);
    }
}
