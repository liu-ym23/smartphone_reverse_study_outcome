package com.tmall.wireless.tangram.structure.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.i;
import com.google.common.primitives.Ints;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.card.GridCard;
import com.tmall.wireless.tangram.structure.entitycard.EntityCard;
import com.tmall.wireless.tangram.structure.entitycard.GridEntityCard;
import com.tmall.wireless.tangram.support.CardSupport;
import com.tmall.wireless.tangram.util.ImageUtils;
import com.tmall.wireless.tangram.util.Utils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class GridEntityCardView extends EntityCardView implements ITangramViewLifeCycle {
    private static final String TAG = "GridEntityCardView";
    private ImageView bgImageView;
    private int column;
    private int mHGap;
    private boolean mIgnoreExtra;
    private boolean mIsAutoExpand;
    private int[] mSizePerSpan;
    private int mSpanCount;
    private GridLayoutHelper.SpanSizeLookup mSpanSizeLookup;
    private int mTotalSize;
    private int mVGap;
    private float[] mWeights;

    public static final class DefaultSpanSizeLookup extends GridLayoutHelper.SpanSizeLookup {
        public DefaultSpanSizeLookup() {
        }

        @Override // com.alibaba.android.vlayout.layout.GridLayoutHelper.SpanSizeLookup
        public int getSpanIndex(int r10, int r11) {
            return r10 % r11;
        }

        @Override // com.alibaba.android.vlayout.layout.GridLayoutHelper.SpanSizeLookup
        public int getSpanSize(int r10) {
            return 1;
        }
    }

    public GridEntityCardView(Context r10) {
        this(r10, null);
    }

    private void calculateSizePerSpan(int r11) {
        int r10 = this.mSpanCount;
        int r12 = r11 - ((r10 - 1) * this.mHGap);
        int[] r13 = this.mSizePerSpan;
        if (r13 != null) goto L5;
    L6:
        this.mSizePerSpan = new int[r10];
    L7:
        float[] r14 = this.mWeights;
        int r15 = 0;
        if (r14 == null) goto L29;
        if (r14.length <= 0) goto L29;
        int r16 = r12;
        int r17 = 0;
        int r18 = 0;
    L12:
        if (r17 >= r10) goto L22;
        float[] r19 = this.mWeights;
        if (r17 < r19.length) goto L16;
    L20:
        r18 = r18 + 1;
        this.mSizePerSpan[r17] = -1;
    L21:
        r17 = r17 + 1;
        goto L12
    L16:
        if (Float.isNaN(r19[r17]) == true) goto L20;
        float r20 = this.mWeights[r17];
        if (r20 < 0.0f) goto L20;
        int r21 = (int) ((((r20 * 1.0f) / 100.0f) * r12) + 0.5f);
        this.mSizePerSpan[r17] = r21;
        r16 = r16 - r21;
        goto L21
    L22:
        if (r18 <= 0) goto L32;
        int r110 = (int) (((r16 * 1.0f) / r18) + 0.5f);
    L24:
        if (r15 >= r10) goto L41;
        int[] r22 = this.mSizePerSpan;
        if (r22[r15] >= 0) goto L28;
        r22[r15] = r110;
    L28:
        r15 = r15 + 1;
        goto L24
    L41:
        return;
    L32:
        return;
    L29:
        int r23 = this.mSpanCount;
        if (r15 >= r23) goto L42;
        this.mSizePerSpan[r15] = (int) (((r12 * 1.0f) / r23) + 0.5f);
        r15 = r15 + 1;
        goto L29
    L42:
        return;
    L5:
        if (r13.length == r10) goto L7;
        goto L6
    }

    private int getMainDirSpec(int r10, int r11) {
        if (Float.isNaN(this.mAspectRatio) == true) goto L8;
        float r12 = this.mAspectRatio;
        if (r12 <= 0.0f) goto L8;
        return View.MeasureSpec.makeMeasureSpec((int) (r11 / r12), Ints.MAX_POWER_OF_TWO);
    L8:
        if (r10 >= 0) goto L12;
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    L12:
        return View.MeasureSpec.makeMeasureSpec(r10, Ints.MAX_POWER_OF_TWO);
    }

    @Override // com.tmall.wireless.tangram.structure.view.EntityCardView, com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void cellInited(BaseCell r10) {
        super.cellInited(r10);
        this.column = Utils.getCardColumnCount(r10.optIntParam("type"));
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    @Override // com.tmall.wireless.tangram.structure.view.EntityCardView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        int r10 = getChildCount();
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        ImageView r13 = this.bgImageView;
        int r14 = 0;
        if (r13 != null) goto L5;
    L7:
        int r15 = 0;
    L8:
        if (r15 != 1) goto L10;
        ImageView r16 = this.bgImageView;
        r16.layout(0, 0, r16.getMeasuredWidth(), this.bgImageView.getMeasuredHeight());
    L10:
        int r17 = 0;
        int r23 = 0;
        int r24 = 0;
    L12:
        if (r17 >= (r10 - r15)) goto L20;
        int r25 = r17 + r15;
        int r110 = this.mSpanSizeLookup.getSpanGroupIndex(r17, this.mSpanCount);
        if (r110 == r23) goto L16;
        r11 = getPaddingLeft();
        r12 = r12 + (r24 + this.mVGap);
        r24 = r14;
        r23 = r110;
    L16:
        View r26 = getChildAt(r25);
        VirtualLayoutManager.LayoutParams r111 = (VirtualLayoutManager.LayoutParams) r26.getLayoutParams();
        int r112 = r26.getMeasuredWidth();
        int r113 = r26.getMeasuredHeight();
        int r114 = ((ViewGroup.MarginLayoutParams) r111).leftMargin;
        int r115 = ((ViewGroup.MarginLayoutParams) r111).topMargin;
        r26.layout(r11 + r114, r12 + r115, (r11 + r112) + r114, (r12 + r113) + r115);
        r11 = r11 + (((r112 + this.mHGap) + ((ViewGroup.MarginLayoutParams) r111).leftMargin) + ((ViewGroup.MarginLayoutParams) r111).rightMargin);
        if (r113 <= r24) goto L19;
        r24 = (r113 + ((ViewGroup.MarginLayoutParams) r111).topMargin) + ((ViewGroup.MarginLayoutParams) r111).bottomMargin;
    L19:
        r17 = r17 + 1;
        r14 = 0;
        goto L12
    L20:
        return;
    L5:
        if (indexOfChild(r13) != 0) goto L7;
        r15 = 1;
        goto L8
    }

    @Override // android.view.View
    public void onMeasure(int r19, int r20) {
        super.onMeasure(r19, r20);
        i.e(TAG, "width spec " + View.MeasureSpec.toString(r19));
        i.e(TAG, "height spec " + View.MeasureSpec.toString(r20));
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int r11 = (View.MeasureSpec.getSize(r19) - getPaddingRight()) - getPaddingLeft();
        int r12 = 0;
        if (r10 == null) goto L5;
        int r13 = r10.leftMargin + r10.rightMargin;
    L6:
        int r14 = r11 - r13;
        this.mTotalSize = r14;
        calculateSizePerSpan(r14);
        ImageView r15 = this.bgImageView;
        if (r15 != null) goto L9;
    L11:
        int r16 = 0;
    L12:
        int r17 = getChildCount();
        int r18 = 0;
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
    L14:
        if (r18 >= (r17 - r16)) goto L29;
        int r110 = r18 + r16;
        int r111 = this.mSpanSizeLookup.getSpanGroupIndex(r18, this.mSpanCount);
        if (r111 == r22) goto L18;
        r23 = r12;
        r22 = r111;
    L18:
        View r112 = getChildAt(r110);
        VirtualLayoutManager.LayoutParams r113 = (VirtualLayoutManager.LayoutParams) r112.getLayoutParams();
        int r114 = this.mSpanSizeLookup.getSpanSize(r18);
        int r115 = this.mSpanSizeLookup.getSpanIndex(r18, this.mSpanCount);
        int r116 = r12;
        int r117 = r116;
    L19:
        if (r116 >= r114) goto L21;
        r117 = r117 + this.mSizePerSpan[r116 + r115];
        r116 = r116 + 1;
        goto L19
    L21:
        int r24 = r117 + (Math.max(r12, r114 - 1) * this.mHGap);
        int r118 = View.MeasureSpec.makeMeasureSpec(r24, Ints.MAX_POWER_OF_TWO);
        if (r23 <= 0) goto L24;
        int r119 = View.MeasureSpec.makeMeasureSpec(r23, Ints.MAX_POWER_OF_TWO);
    L25:
        r112.measure(r118, r119);
        i.e(TAG, "child " + r18 + " spanSize " + r114 + " viewSize " + r24 + " " + r112.getMeasuredWidth() + " " + r112.getMeasuredHeight());
        if (r115 != 0) goto L28;
        int r25 = (r112.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r113).topMargin) + ((ViewGroup.MarginLayoutParams) r113).bottomMargin;
        r21 = r21 + (this.mVGap + r25);
        r23 = r25;
    L28:
        r18 = r18 + 1;
        r12 = 0;
        goto L14
    L24:
        r119 = getMainDirSpec(-1, this.mTotalSize);
        goto L25
    L29:
        int r26 = r21 - this.mVGap;
        i.e(TAG, "totalHeight " + r26);
        if (r16 != 1) goto L32;
        this.bgImageView.measure(View.MeasureSpec.makeMeasureSpec((this.mTotalSize + getPaddingLeft()) + getPaddingRight(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((getPaddingTop() + r26) + getPaddingBottom(), Ints.MAX_POWER_OF_TWO));
    L32:
        setMeasuredDimension(View.MeasureSpec.getSize(r19), (r26 + getPaddingTop()) + getPaddingBottom());
        return;
    L9:
        if (indexOfChild(r15) != 0) goto L11;
        r16 = 1;
        goto L12
    L5:
        r13 = 0;
        goto L6
    }

    @Override // com.tmall.wireless.tangram.structure.view.EntityCardView, com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postBindView(BaseCell r10) {
        super.postBindView(r10);
        Style r11 = r10.style;
        if ((r11 instanceof GridEntityCard.GridEntityStyle) == false) goto L29;
        GridEntityCard.GridEntityStyle r12 = (GridEntityCard.GridEntityStyle) r11;
        setItemCount(this.mEntityCard.getCells().size());
        setSpanCount(this.column);
        int r13 = this.column;
        int r14 = r12.column;
        if (r14 <= 0) goto L7;
        setSpanCount(r14);
        r13 = r14;
    L7:
        setSpanSizeLookup(new GridCard.CellSpanSizeLookup(this.mEntityCard.getCells(), r13));
        setVGap(r12.vGap);
        setHGap(r12.hGap);
        setAutoExpand(r12.autoExpand);
        int[] r15 = r12.padding;
        setPadding(r15[3], r15[0], r15[1], r15[2]);
        float[] r16 = r12.cols;
        if (r16 != null) goto L10;
    L12:
        setWeights(null);
    L14:
        if (Float.isNaN(r12.aspectRatio) == true) goto L17;
        setAspectRatio(r12.aspectRatio);
    L17:
        if (TextUtils.isEmpty(r12.bgImgUrl) == false) goto L19;
        return;
    L19:
        if (this.bgImageView != null) goto L21;
        NetworkImageView r17 = ImageUtils.createImageInstance(getContext());
        this.bgImageView = r17;
        r17.setLayoutParams(new VirtualLayoutManager.LayoutParams(-1, -1));
    L21:
        addView(this.bgImageView, 0);
        ServiceManager r18 = r10.serviceManager;
        if (r18 != null) goto L24;
        return;
    L24:
        CardSupport r19 = (CardSupport) r18.getService(CardSupport.class);
        if (r19 == null) goto L27;
        r19.onBindBackgroundView(this.bgImageView, (EntityCard) r10);
        return;
    L27:
        ImageUtils.doLoadImageUrl(this.bgImageView, r10.style.bgImgUrl);
        return;
    L10:
        if (r16.length <= 0) goto L12;
        setWeights(r16);
        goto L14
    }

    @Override // com.tmall.wireless.tangram.structure.view.EntityCardView, com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postUnBindView(BaseCell r10) {
        super.postUnBindView(r10);
        ImageView r11 = this.bgImageView;
        if (r11 == null) goto L6;
        removeView(r11);
        return;
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
        return;
    L10:
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + r10);
    }

    public void setSpanSizeLookup(GridLayoutHelper.SpanSizeLookup r10) {
        if (r10 == null) goto L5;
        this.mSpanSizeLookup = r10;
        r10.setStartPosition(0);
        this.mSpanSizeLookup.setSpanIndexCacheEnabled(true);
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

    public GridEntityCardView(Context r10, AttributeSet r11) {
        this(r10, r11, -1);
    }

    public GridEntityCardView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mSpanCount = 4;
        this.mTotalSize = 0;
        this.mIsAutoExpand = true;
        this.mIgnoreExtra = false;
        this.mVGap = 0;
        this.mHGap = 0;
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        setClipToPadding(false);
        setClipChildren(false);
    }
}
