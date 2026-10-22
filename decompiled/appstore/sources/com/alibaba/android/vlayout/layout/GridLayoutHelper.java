package com.alibaba.android.vlayout.layout;

import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.google.common.primitives.Ints;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutHelper extends BaseLayoutHelper {
    private static boolean DEBUG = false;
    private static final int MAIN_DIR_SPEC = 0;
    private static final String TAG = "GridLayoutHelper";
    private int mHGap;
    private boolean mIgnoreExtra;
    private boolean mIsAutoExpand;
    private boolean mLayoutWithAnchor;
    private View[] mSet;
    private int mSizePerSpan;
    private int[] mSpanCols;
    private int mSpanCount;
    private int[] mSpanIndices;

    @NonNull
    private SpanSizeLookup mSpanSizeLookup;
    private int mTotalSize;
    private int mVGap;
    private float[] mWeights;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public DefaultSpanSizeLookup() {
        }

        @Override // com.alibaba.android.vlayout.layout.GridLayoutHelper.SpanSizeLookup
        public int getSpanIndex(int r10, int r11) {
            return (r10 - this.mStartPosition) % r11;
        }

        @Override // com.alibaba.android.vlayout.layout.GridLayoutHelper.SpanSizeLookup
        public int getSpanSize(int r10) {
            return 1;
        }
    }

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanIndices;
        final SparseIntArray mSpanIndexCache;
        int mStartPosition;

        public SpanSizeLookup() {
            this.mSpanIndexCache = new SparseIntArray();
            this.mCacheSpanIndices = false;
            this.mStartPosition = 0;
        }

        public int findReferenceIndexFromCache(int r10) {
            int r11 = this.mSpanIndexCache.size() - 1;
            int r12 = 0;
        L3:
            if (r12 > r11) goto L8;
            int r13 = (r12 + r11) >>> 1;
            if (this.mSpanIndexCache.keyAt(r13) < r10) goto L6;
            r11 = r13 - 1;
            goto L3
        L6:
            r12 = r13 + 1;
            goto L3
        L8:
            int r14 = r12 - 1;
            if (r14 >= 0) goto L11;
            return -1;
        L11:
            if (r14 < this.mSpanIndexCache.size()) goto L13;
            return -1;
        L13:
            return this.mSpanIndexCache.keyAt(r14);
        }

        public int getCachedSpanIndex(int r10, int r11) {
            if (this.mCacheSpanIndices == false) goto L5;
            int r12 = this.mSpanIndexCache.get(r10, -1);
            if (r12 == (-1)) goto L9;
            return r12;
        L9:
            int r13 = getSpanIndex(r10, r11);
            this.mSpanIndexCache.put(r10, r13);
            return r13;
        L5:
            return getSpanIndex(r10, r11);
        }

        public int getSpanGroupIndex(int r10, int r11) {
            int r12 = getSpanSize(r10);
            int r13 = 0;
            int r14 = 0;
            int r15 = 0;
        L3:
            if (r13 >= r10) goto L11;
            int r16 = getSpanSize(r13);
            r14 = r14 + r16;
            if (r14 != r11) goto L7;
            r15 = r15 + 1;
            r14 = 0;
        L9:
            r13 = r13 + 1;
            goto L3
        L7:
            if (r14 <= r11) goto L9;
            r15 = r15 + 1;
            r14 = r16;
            goto L9
        L11:
            if ((r14 + r12) > r11) goto L13;
            return r15;
        L13:
            return r15 + 1;
        }

        public int getSpanIndex(int r10, int r11) {
            int r12 = getSpanSize(r10);
            if (r12 != r11) goto L5;
            return 0;
        L5:
            int r13 = this.mStartPosition;
            if (this.mCacheSpanIndices == true) goto L8;
        L12:
            int r14 = 0;
        L13:
            if (r13 >= r10) goto L21;
            int r15 = getSpanSize(r13);
            r14 = r14 + r15;
            if (r14 != r11) goto L17;
            r14 = 0;
        L19:
            r13 = r13 + 1;
            goto L13
        L17:
            if (r14 <= r11) goto L19;
            r14 = r15;
            goto L19
        L21:
            if ((r12 + r14) > r11) goto L23;
            return r14;
        L23:
            return 0;
        L8:
            if (this.mSpanIndexCache.size() <= 0) goto L12;
            int r16 = findReferenceIndexFromCache(r10);
            if (r16 < 0) goto L12;
            int r17 = this.mSpanIndexCache.get(r16) + getSpanSize(r16);
            int r18 = r16 + 1;
            r14 = r17;
            r13 = r18;
            goto L13
        }

        public abstract int getSpanSize(int r10);

        public int getStartPosition() {
            return this.mStartPosition;
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanIndexCacheEnabled(boolean r10) {
            this.mCacheSpanIndices = r10;
        }

        public void setStartPosition(int r10) {
            this.mStartPosition = r10;
        }
    }

    static {
        MAIN_DIR_SPEC = View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    public GridLayoutHelper(int r10) {
        this(r10, -1, -1);
    }

    private void assignSpans(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, boolean r14, LayoutManagerHelper r15) {
        int r16 = 0;
        if (r14 == false) goto L5;
        int r17 = r12;
        int r18 = 0;
        int r19 = 1;
    L7:
        if (r15.getOrientation() == 1) goto L9;
    L11:
        int r110 = 1;
    L12:
        if (r18 == r17) goto L19;
        int r20 = getSpanSize(r10, r11, r15.getPosition(this.mSet[r18]));
        if (r110 != (-1)) goto L17;
        if (r20 <= 1) goto L17;
        this.mSpanIndices[r18] = r16 - (r20 - 1);
    L18:
        r16 = r16 + (r20 * r110);
        r18 = r18 + r19;
    L17:
        this.mSpanIndices[r18] = r16;
        goto L18
    L19:
        return;
    L9:
        if (r15.isDoLayoutRTL() == false) goto L11;
        r16 = r13 - 1;
        r110 = -1;
        goto L12
    L5:
        r18 = r12 - 1;
        r17 = -1;
        r19 = -1;
        goto L7
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

    private int getMainDirSpec(int r10, int r11, int r12, float r13) {
        if (Float.isNaN(r13) == true) goto L10;
        if (r13 <= 0.0f) goto L10;
        if (r12 <= 0) goto L10;
        return View.MeasureSpec.makeMeasureSpec((int) ((r12 / r13) + 0.5f), Ints.MAX_POWER_OF_TWO);
    L10:
        if (Float.isNaN(this.mAspectRatio) == true) goto L15;
        float r14 = this.mAspectRatio;
        if (r14 <= 0.0f) goto L15;
        return View.MeasureSpec.makeMeasureSpec((int) ((r11 / r14) + 0.5f), Ints.MAX_POWER_OF_TWO);
    L15:
        if (r10 >= 0) goto L19;
        return MAIN_DIR_SPEC;
    L19:
        return View.MeasureSpec.makeMeasureSpec(r10, Ints.MAX_POWER_OF_TWO);
    }

    private int getSpanIndex(RecyclerView.Recycler r10, RecyclerView.State r11, int r12) {
        if (r11.f() == false) goto L5;
        int r13 = r10.f(r12);
        if (r13 != (-1)) goto L11;
        return 0;
    L11:
        return this.mSpanSizeLookup.getCachedSpanIndex(r13, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanIndex(r12, this.mSpanCount);
    }

    private int getSpanSize(RecyclerView.Recycler r10, RecyclerView.State r11, int r12) {
        if (r11.f() == false) goto L5;
        int r13 = r10.f(r12);
        if (r13 != (-1)) goto L11;
        return 0;
    L11:
        return this.mSpanSizeLookup.getSpanSize(r13);
    L5:
        return this.mSpanSizeLookup.getSpanSize(r12);
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void checkAnchorInfo(RecyclerView.State r10, VirtualLayoutManager.AnchorInfoWrapper r11, LayoutManagerHelper r12) {
        if (r10.c() > 0) goto L5;
        return;
    L5:
        if (r10.f() == true) goto L24;
        int r13 = this.mSpanSizeLookup.getCachedSpanIndex(r11.position, this.mSpanCount);
        if (r11.layoutFromEnd == true) goto L9;
    L13:
        if (r13 <= 0) goto L17;
        int r14 = r11.position;
        if (r14 <= 0) goto L17;
        int r15 = r14 - 1;
        r11.position = r15;
        r13 = this.mSpanSizeLookup.getCachedSpanIndex(r15, this.mSpanCount);
    L17:
        this.mLayoutWithAnchor = true;
        return;
    L9:
        if (r13 >= (this.mSpanCount - 1)) goto L17;
        if (r11.position >= ((Integer) getRange().getUpper()).intValue()) goto L17;
        int r16 = r11.position + 1;
        r11.position = r16;
        r13 = this.mSpanSizeLookup.getCachedSpanIndex(r16, this.mSpanCount);
        goto L9
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computeAlignOffset(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (r13.getOrientation() != 1) goto L5;
        boolean r14 = true;
    L6:
        if (r11 == true) goto L8;
        if (r10 != 0) goto L21;
        if (r14 == false) goto L18;
        int r15 = -this.mMarginTop;
        int r16 = this.mPaddingTop;
    L19:
        return r15 - r16;
    L18:
        r15 = -this.mMarginLeft;
        r16 = this.mPaddingLeft;
    L21:
        return super.computeAlignOffset(r10, r11, r12, r13);
    L8:
        if (r10 != (getItemCount() - 1)) goto L21;
        if (r14 == false) goto L12;
        int r17 = this.mMarginBottom;
        int r18 = this.mPaddingBottom;
    L13:
        return r17 + r18;
    L12:
        r17 = this.mMarginRight;
        r18 = this.mPaddingRight;
        goto L13
    L5:
        r14 = false;
        goto L6
    }

    public int getHGap() {
        return this.mHGap;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public int getVGap() {
        return this.mVGap;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r30, RecyclerView.State r31, VirtualLayoutManager.LayoutStateWrapper r32, LayoutChunkResult r33, LayoutManagerHelper r34) {
        RecyclerView.Recycler r10 = r30;
        RecyclerView.State r11 = r31;
        if (isOutOfRange(r32.getCurrentPosition()) == false) goto L5;
        return;
    L5:
        r32.getCurrentPosition();
        boolean r13 = r34.isEnableMarginOverLap();
        int r12 = r32.getItemDirection();
        if (r12 != 1) goto L8;
        boolean r16 = true;
    L9:
        OrientationHelperEx r14 = r34.getMainOrientationHelper();
        if (r34.getOrientation() != 1) goto L12;
        boolean r15 = true;
    L14:
        if (r15 == false) goto L16;
        int r17 = (((r34.getContentWidth() - r34.getPaddingRight()) - r34.getPaddingLeft()) - getHorizontalMargin()) - getHorizontalPadding();
        this.mTotalSize = r17;
        int r18 = this.mSpanCount;
        this.mSizePerSpan = (int) ((((r17 - ((r18 - 1) * this.mHGap)) * 1.0f) / r18) + 0.5f);
    L17:
        int r19 = this.mSpanCount;
        ensureSpanCount();
        if (r16 == true) goto L69;
        int r20 = getSpanIndex(r10, r11, r32.getCurrentPosition());
        int r110 = getSpanSize(r10, r11, r32.getCurrentPosition()) + r20;
        boolean r21 = r15;
        if (r20 == (this.mSpanCount - 1)) goto L67;
        int r22 = r32.getCurrentPosition();
        int r23 = this.mSpanCount - r110;
        r14 = r14;
        int r25 = r110;
        int r24 = 0;
        boolean r26 = false;
        int r27 = 0;
        boolean r28 = false;
    L23:
        if (r24 >= this.mSpanCount) goto L61;
        if (r23 <= 0) goto L61;
        r22 = r22 - r12;
        if (isOutOfRange(r22) == true) goto L61;
        int r111 = getSpanSize(r10, r11, r22);
        int r29 = r12;
        if (r111 > this.mSpanCount) goto L60;
        View r35 = r32.retrieve(r10, r22);
        if (r35 == null) goto L61;
        if (r26 == false) goto L35;
    L44:
        if (r28 == false) goto L46;
    L55:
        r23 = r23 - r111;
        if (r23 < 0) goto L61;
        r27 = r27 + r111;
        this.mSet[r24] = r35;
        r24 = r24 + 1;
        r12 = r29;
        goto L23
    L46:
        if (r34.getReverseLayout() == false) goto L52;
        if (r22 != ((Integer) getRange().getLower()).intValue()) goto L50;
    L49:
        boolean r112 = true;
    L54:
        r28 = r112;
    L50:
        r112 = false;
        goto L54
    L52:
        if (r22 != ((Integer) getRange().getUpper()).intValue()) goto L50;
    L35:
        if (r34.getReverseLayout() == false) goto L41;
        if (r22 != ((Integer) getRange().getUpper()).intValue()) goto L39;
    L38:
        boolean r113 = true;
    L43:
        r26 = r113;
    L39:
        r113 = false;
        goto L43
    L41:
        if (r22 != ((Integer) getRange().getLower()).intValue()) goto L39;
    L60:
        throw new IllegalArgumentException("Item at position " + r22 + " requires " + r111 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
    L61:
        if (r24 <= 0) goto L65;
        int r36 = r24 - 1;
        int r37 = 0;
    L63:
        if (r37 >= r36) goto L65;
        View[] r38 = this.mSet;
        View r114 = r38[r37];
        r38[r37] = r38[r36];
        r38[r36] = r114;
        r37 = r37 + 1;
        r36 = r36 - 1;
    L65:
        int r115 = r24;
        int r116 = r27;
    L66:
        r19 = r25;
    L71:
        if (r115 < this.mSpanCount) goto L73;
    L80:
        String r210 = TAG;
    L88:
        int r117 = r19;
        if (r115 != 0) goto L117;
        return;
    L117:
        boolean r39 = r21;
        String r211 = r210;
        assignSpans(r30, r31, r115, r116, r16, r34);
        if (r117 <= 0) goto L125;
        if (r115 != r116) goto L125;
        if (this.mIsAutoExpand == false) goto L125;
        if (r39 == false) goto L124;
        this.mSizePerSpan = (this.mTotalSize - ((r115 - 1) * this.mHGap)) / r115;
    L133:
        float[] r40 = this.mWeights;
        int r41 = -1;
        if (r40 != null) goto L136;
    L165:
        boolean r118 = false;
    L166:
        int r42 = 0;
        int r43 = 0;
    L167:
        if (r42 >= r115) goto L192;
        View r44 = this.mSet[r42];
        if (r16 == false) goto L171;
        int r45 = r41;
    L172:
        r34.addChildView(r32, r44, r45);
        int r46 = getSpanSize(r10, r11, r34.getPosition(r44));
        if (r118 == false) goto L178;
        int r47 = this.mSpanIndices[r42];
        int r48 = 0;
        int r119 = 0;
    L175:
        if (r119 >= r46) goto L177;
        r48 = r48 + this.mSpanCols[r119 + r47];
        r119 = r119 + 1;
        goto L175
    L177:
        int r49 = View.MeasureSpec.makeMeasureSpec(Math.max(0, r48), Ints.MAX_POWER_OF_TWO);
    L183:
        VirtualLayoutManager.LayoutParams r50 = (VirtualLayoutManager.LayoutParams) r44.getLayoutParams();
        if (r34.getOrientation() != 1) goto L187;
        r34.measureChildWithMargins(r44, r49, getMainDirSpec(((ViewGroup.MarginLayoutParams) r50).height, this.mTotalSize, View.MeasureSpec.getSize(r49), r50.mAspectRatio));
    L186:
        OrientationHelperEx r120 = r14;
        int r51 = r120.getDecoratedMeasurement(r44);
        if (r51 <= r43) goto L191;
        r43 = r51;
    L191:
        r42 = r42 + 1;
        r14 = r120;
        r41 = -1;
        goto L167
    L187:
        r34.measureChildWithMargins(r44, getMainDirSpec(((ViewGroup.MarginLayoutParams) r50).width, this.mTotalSize, View.MeasureSpec.getSize(r49), r50.mAspectRatio), View.MeasureSpec.getSize(r49));
        goto L186
    L178:
        int r52 = this.mSizePerSpan * r46;
        int r53 = Math.max(0, r46 - 1);
        if (r39 == false) goto L181;
        int r54 = this.mHGap;
    L182:
        r49 = View.MeasureSpec.makeMeasureSpec(r52 + (r53 * r54), Ints.MAX_POWER_OF_TWO);
        goto L183
    L181:
        r54 = this.mVGap;
        goto L182
    L171:
        r45 = 0;
        goto L172
    L192:
        OrientationHelperEx r121 = r14;
        int r55 = getMainDirSpec(r43, this.mTotalSize, 0, Float.NaN);
        int r56 = 0;
    L193:
        if (r56 >= r115) goto L213;
        View r57 = this.mSet[r56];
        if (r121.getDecoratedMeasurement(r57) == r43) goto L212;
        int r58 = getSpanSize(r10, r11, r34.getPosition(r57));
        if (r118 == false) goto L202;
        int r59 = this.mSpanIndices[r56];
        int r60 = 0;
        int r61 = 0;
    L199:
        if (r60 >= r58) goto L201;
        r61 = r61 + this.mSpanCols[r60 + r59];
        r60 = r60 + 1;
        goto L199
    L201:
        int r62 = View.MeasureSpec.makeMeasureSpec(Math.max(0, r61), Ints.MAX_POWER_OF_TWO);
    L208:
        if (r34.getOrientation() != 1) goto L210;
        r34.measureChildWithMargins(r57, r62, r55);
        goto L212
    L210:
        r34.measureChildWithMargins(r57, r55, r62);
        goto L212
    L202:
        int r63 = this.mSizePerSpan * r58;
        int r64 = Math.max(0, r58 - 1);
        if (r39 == false) goto L205;
        int r65 = this.mHGap;
    L206:
        r62 = View.MeasureSpec.makeMeasureSpec(r63 + (r64 * r65), Ints.MAX_POWER_OF_TWO);
        goto L208
    L205:
        r65 = this.mVGap;
    L212:
        r56 = r56 + 1;
        r10 = r30;
        r11 = r31;
        goto L193
    L213:
        if (r26 == false) goto L215;
        boolean r66 = true;
        boolean r67 = r13;
        int r68 = computeStartSpace(r34, r39, !r34.getReverseLayout(), r67);
    L216:
        if (r28 == false) goto L218;
        int r69 = computeEndSpace(r34, r39, r34.getReverseLayout() ^ r66, r67);
    L219:
        r33.mConsumed = (r43 + r68) + r69;
        if (r32.getLayoutDirection() != (-1)) goto L222;
        boolean r70 = true;
    L224:
        if (this.mLayoutWithAnchor == true) goto L234;
        if (r28 == false) goto L227;
        if (r70 == true) goto L234;
    L227:
        if (r26 == false) goto L229;
        if (r70 == false) goto L234;
    L229:
        int r71 = r33.mConsumed;
        if (r39 == false) goto L232;
        int r72 = this.mVGap;
    L233:
        r33.mConsumed = r71 + r72;
        goto L234
    L232:
        r72 = this.mHGap;
    L234:
        if (r39 == false) goto L253;
        if (r32.getLayoutDirection() != (-1)) goto L245;
        int r73 = r32.getOffset() - r69;
        if (this.mLayoutWithAnchor == true) goto L242;
        if (r28 == true) goto L242;
        int r74 = this.mVGap;
    L243:
        int r75 = r73 - r74;
        int r76 = r75 - r43;
        int r77 = r75;
    L244:
        int r78 = 0;
        int r79 = 0;
    L268:
        int r80 = 0;
    L269:
        if (r80 >= r115) goto L296;
        View r122 = this.mSet[r80];
        int r81 = this.mSpanIndices[r80];
        VirtualLayoutManager.LayoutParams r123 = (VirtualLayoutManager.LayoutParams) r122.getLayoutParams();
        if (r39 == false) goto L278;
        if (r118 == false) goto L276;
        int r82 = (r34.getPaddingLeft() + this.mMarginLeft) + this.mPaddingLeft;
        int r83 = 0;
    L274:
        if (r83 >= r81) goto L277;
        r82 = r82 + (this.mSpanCols[r83] + this.mHGap);
        r83 = r83 + 1;
    L277:
        int r84 = r76;
        int r85 = r121.getDecoratedMeasurementInOther(r122) + r82;
        int r86 = r77;
        int r87 = r82;
    L285:
        if (DEBUG == false) goto L287;
        String r88 = r211;
        Log.d(r88, "layout item in position: " + r123.getViewPosition() + " with text " + ((TextView) r122).getText() + " with SpanIndex: " + r81 + " into (" + r87 + ", " + r84 + ", " + r85 + ", " + r86 + " )");
    L288:
        int r124 = r87;
        int r125 = r86;
        String r212 = r88;
        int r213 = r84;
        int r214 = r85;
        layoutChildWithMargin(r122, r87, r84, r85, r125, r34);
        if (r123.isItemRemoved() == true) goto L294;
        if (r123.isItemChanged() == true) goto L294;
    L295:
        r33.mFocusable |= r122.isFocusable();
        r80 = r80 + 1;
        r79 = r124;
        r77 = r125;
        r211 = r212;
        r76 = r213;
        r78 = r214;
    L294:
        r33.mIgnoreConsumed = true;
        goto L295
    L287:
        r88 = r211;
        goto L288
    L276:
        r82 = (((r34.getPaddingLeft() + this.mMarginLeft) + this.mPaddingLeft) + (this.mSizePerSpan * r81)) + (this.mHGap * r81);
        goto L277
    L278:
        if (r118 == false) goto L282;
        int r89 = (r34.getPaddingTop() + this.mMarginTop) + this.mPaddingTop;
        int r90 = 0;
    L280:
        if (r90 >= r81) goto L283;
        r89 = r89 + (this.mSpanCols[r90] + this.mVGap);
        r90 = r90 + 1;
    L283:
        r85 = r78;
        r84 = r89;
        int r215 = r79;
        r86 = r121.getDecoratedMeasurementInOther(r122) + r89;
        r87 = r215;
        goto L285
    L282:
        r89 = (((r34.getPaddingTop() + this.mMarginTop) + this.mPaddingTop) + (this.mSizePerSpan * r81)) + (this.mVGap * r81);
        goto L283
    L296:
        this.mLayoutWithAnchor = false;
        Arrays.fill(this.mSet, null);
        Arrays.fill(this.mSpanIndices, 0);
        Arrays.fill(this.mSpanCols, 0);
        return;
    L242:
        r74 = 0;
        goto L243
    L245:
        int r91 = r32.getOffset() + r68;
        if (this.mLayoutWithAnchor == true) goto L250;
        if (r26 == true) goto L250;
        int r92 = this.mVGap;
    L251:
        int r93 = r92 + r91;
        r77 = r93 + r43;
        r76 = r93;
    L250:
        r92 = 0;
        goto L251
    L253:
        if (r32.getLayoutDirection() != (-1)) goto L261;
        int r94 = r32.getOffset() - r69;
        if (this.mLayoutWithAnchor == true) goto L259;
        if (r28 == true) goto L259;
        int r95 = this.mHGap;
    L260:
        int r96 = r94 - r95;
        int r97 = r96 - r43;
        r76 = 0;
        r77 = 0;
        r79 = r97;
        r78 = r96;
    L259:
        r95 = 0;
        goto L260
    L261:
        int r98 = r32.getOffset() + r68;
        if (this.mLayoutWithAnchor == true) goto L266;
        if (r26 == true) goto L266;
        int r99 = this.mHGap;
    L267:
        r79 = r99 + r98;
        r78 = r79 + r43;
        r76 = 0;
        r77 = 0;
    L266:
        r99 = 0;
        goto L267
    L222:
        r70 = false;
        goto L224
    L218:
        r69 = 0;
        goto L219
    L215:
        r67 = r13;
        r66 = true;
        r68 = 0;
        goto L216
    L136:
        if (r40.length <= 0) goto L165;
        if (r39 == false) goto L140;
        int r100 = this.mTotalSize;
        int r101 = r115 - 1;
        int r102 = this.mHGap;
    L139:
        int r103 = r100 - (r101 * r102);
        if (r117 > 0) goto L143;
    L145:
        int r104 = this.mSpanCount;
    L146:
        int r105 = r103;
        int r106 = 0;
        int r107 = 0;
    L147:
        if (r106 >= r104) goto L157;
        float[] r108 = this.mWeights;
        if (r106 < r108.length) goto L151;
    L155:
        r107 = r107 + 1;
        this.mSpanCols[r106] = -1;
    L156:
        r106 = r106 + 1;
        goto L147
    L151:
        if (Float.isNaN(r108[r106]) == true) goto L155;
        float r109 = this.mWeights[r106];
        if (r109 < 0.0f) goto L155;
        int r126 = (int) ((((r109 * 1.0f) / 100.0f) * r103) + 0.5f);
        this.mSpanCols[r106] = r126;
        r105 = r105 - r126;
        goto L156
    L157:
        if (r107 <= 0) goto L164;
        int r127 = r105 / r107;
        int r128 = 0;
    L159:
        if (r128 >= r104) goto L164;
        int[] r129 = this.mSpanCols;
        if (r129[r128] >= 0) goto L163;
        r129[r128] = r127;
    L163:
        r128 = r128 + 1;
    L164:
        r118 = true;
        goto L166
    L143:
        if (this.mIsAutoExpand == false) goto L145;
        r104 = r115;
        goto L146
    L140:
        r100 = this.mTotalSize;
        r101 = r115 - 1;
        r102 = this.mVGap;
        goto L139
    L124:
        this.mSizePerSpan = (this.mTotalSize - ((r115 - 1) * this.mVGap)) / r115;
    L125:
        if (r16 == true) goto L133;
        if (r117 != 0) goto L133;
        if (r115 != r116) goto L133;
        if (this.mIsAutoExpand == false) goto L133;
        if (r39 == false) goto L132;
        this.mSizePerSpan = (this.mTotalSize - ((r115 - 1) * this.mHGap)) / r115;
        goto L133
    L132:
        this.mSizePerSpan = (this.mTotalSize - ((r115 - 1) * this.mVGap)) / r115;
        goto L133
    L73:
        if (r32.hasMore(r11) == false) goto L80;
        if (r19 <= 0) goto L80;
        int r130 = r32.getCurrentPosition();
        if (isOutOfRange(r130) == true) goto L78;
        int r131 = getSpanSize(r10, r11, r130);
        r210 = TAG;
        if (r131 > this.mSpanCount) goto L114;
        r19 = r19 - r131;
        if (r19 < 0) goto L88;
        View r132 = r32.next(r10);
        if (r132 == null) goto L88;
        if (r26 == false) goto L91;
        r25 = r19;
    L101:
        if (r28 == true) goto L112;
        r116 = r116 + r131;
        this.mSet[r115] = r132;
        r115 = r115 + 1;
        goto L66
    L103:
        if (r34.getReverseLayout() == false) goto L109;
        if (r130 != ((Integer) getRange().getLower()).intValue()) goto L107;
    L106:
        boolean r133 = true;
    L111:
        r28 = r133;
    L112:
        r116 = r116 + r131;
        this.mSet[r115] = r132;
        r115 = r115 + 1;
    L107:
        r133 = false;
        goto L111
    L109:
        if (r130 != ((Integer) getRange().getUpper()).intValue()) goto L107;
    L91:
        if (r34.getReverseLayout() == false) goto L96;
        r25 = r19;
        if (r130 != ((Integer) getRange().getUpper()).intValue()) goto L95;
    L94:
        boolean r134 = true;
    L99:
        r26 = r134;
    L95:
        r134 = false;
        goto L99
    L96:
        r25 = r19;
        if (r130 != ((Integer) getRange().getLower()).intValue()) goto L95;
    L114:
        throw new IllegalArgumentException("Item at position " + r130 + " requires " + r131 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
    L78:
        if (DEBUG == false) goto L80;
        Log.d(TAG, "pos [" + r130 + "] is out of range");
        goto L80
    L67:
        r19 = r110;
    L68:
        r115 = 0;
        r116 = 0;
        r26 = false;
        r28 = false;
        goto L71
    L69:
        r21 = r15;
        goto L68
    L16:
        int r135 = (((r34.getContentHeight() - r34.getPaddingBottom()) - r34.getPaddingTop()) - getVerticalMargin()) - getVerticalPadding();
        this.mTotalSize = r135;
        int r136 = this.mSpanCount;
        this.mSizePerSpan = (int) ((((r135 - ((r136 - 1) * this.mVGap)) * 1.0f) / r136) + 0.5f);
        goto L17
    L12:
        r15 = false;
        goto L14
    L8:
        r16 = false;
        goto L9
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper r10) {
        super.onClear(r10);
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onItemsChanged(LayoutManagerHelper r10) {
        super.onItemsChanged(r10);
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onRangeChange(int r10, int r11) {
        this.mSpanSizeLookup.setStartPosition(r10);
        this.mSpanSizeLookup.invalidateSpanIndexCache();
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

    public void setSpanSizeLookup(SpanSizeLookup r10) {
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

    public GridLayoutHelper(int r10, int r11) {
        this(r10, r11, 0);
    }

    public GridLayoutHelper(int r10, int r11, int r12) {
        this(r10, r11, r12, r12);
    }

    public GridLayoutHelper(int r10, int r11, int r12, int r13) {
        this.mSpanCount = 4;
        this.mSizePerSpan = 0;
        this.mTotalSize = 0;
        this.mIsAutoExpand = true;
        this.mIgnoreExtra = false;
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mVGap = 0;
        this.mHGap = 0;
        this.mWeights = new float[0];
        this.mLayoutWithAnchor = false;
        setSpanCount(r10);
        this.mSpanSizeLookup.setSpanIndexCacheEnabled(true);
        setItemCount(r11);
        setVGap(r12);
        setHGap(r13);
    }
}
