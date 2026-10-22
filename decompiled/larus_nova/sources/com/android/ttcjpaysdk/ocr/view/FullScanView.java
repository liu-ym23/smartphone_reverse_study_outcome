package com.android.ttcjpaysdk.ocr.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.ocr.utils.OCRCodeUtil;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes39.dex */
public class FullScanView extends IScanBoxView {
    private boolean isShowScanBox;
    private boolean isShowScanLine;
    private IScanBoxViewListener listener;
    private int mAnimTime;
    private Drawable mCustomScanLineDrawable;
    private Rect mFramingRect;
    private boolean mIsShowDefaultScanLineDrawable;
    private int mMaskColor;
    private Bitmap mOriginOCRCodeScanLineBitmap;
    private Paint mPaint;
    private Bitmap mScanLineBitmap;
    private int mScanLineColor;
    private int mScanLineMargin;
    private int mScanLineSize;
    private float mScanLineTop;
    private int mTopOffset;
    private ValueAnimator valueAnimator;

    public interface IScanBoxViewListener {
        void onSizeChanged();
    }

    @Override // com.android.ttcjpaysdk.ocr.view.IScanBoxView
    public void showPermissionTip(boolean r100) {
    }

    private void afterInitCustomAttrs() {
        Drawable r100 = this.mCustomScanLineDrawable;
        if (r100 == null) goto L6;
        this.mOriginOCRCodeScanLineBitmap = ((BitmapDrawable) r100).getBitmap();
    L6:
        if (this.mCustomScanLineDrawable == null) goto L8;
    L9:
        this.mScanLineBitmap = this.mOriginOCRCodeScanLineBitmap;
    L10:
        postInvalidate();
        return;
    L8:
        if (this.mIsShowDefaultScanLineDrawable == false) goto L10;
        goto L9
    }

    public FullScanView(Context r100) {
        super(r100);
        this.isShowScanLine = false;
        this.isShowScanBox = false;
        Paint r101 = new Paint();
        this.mPaint = r101;
        r101.setAntiAlias(true);
        this.mMaskColor = ColorProtector.parseColor("#80000000");
        this.mScanLineSize = OCRCodeUtil.dp2px(r100, 1.0f);
        this.mScanLineColor = -1;
        this.mIsShowDefaultScanLineDrawable = false;
        this.mCustomScanLineDrawable = null;
        this.mScanLineBitmap = null;
        this.mAnimTime = 1000;
    }

    private void drawScanLine(Canvas r100) {
        if (this.valueAnimator != null) goto L6;
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, r100.getHeight() - this.mScanLineBitmap.getHeight()});
        this.valueAnimator = r101;
        r101.setDuration(this.mAnimTime);
        this.valueAnimator.setRepeatMode(1);
        this.valueAnimator.setRepeatCount(-1);
        this.valueAnimator.addUpdateListener(new AnonymousClass1(this));
        this.valueAnimator.start();
    L6:
        if (this.mScanLineBitmap == null) goto L8;
        this.mPaint.reset();
        Rect r102 = this.mFramingRect;
        float r103 = r102.left;
        float r104 = this.mScanLineTop;
        r100.drawBitmap(this.mScanLineBitmap, null, new RectF(r103, r104, r102.right, this.mScanLineBitmap.getHeight() + r104), this.mPaint);
        return;
    L8:
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mScanLineColor);
        Rect r105 = this.mFramingRect;
        float r106 = r105.left;
        float r107 = this.mScanLineTop;
        r100.drawRect(r106, r107, r105.right, r107 + this.mScanLineSize, this.mPaint);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("FullScanView#drawScanLine", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FullScanView#drawScanLine", e);
        return;
    L3:
        if (this.mFramingRect != null) goto L5;
        this.mFramingRect = new Rect();     // Catch: Exception -> L11
    L5:
        Rect r101 = this.mFramingRect;     // Catch: Exception -> L11
        r101.left = 0;     // Catch: Exception -> L11
        r101.top = 0;     // Catch: Exception -> L11
        r101.bottom = r100.getHeight();     // Catch: Exception -> L11
        Rect r102 = this.mFramingRect;     // Catch: Exception -> L11
        r102.right = r100.getWidth();     // Catch: Exception -> L11
        if (this.isShowScanBox == true) goto L8;
        return;
    L8:
        if (this.isShowScanLine == false) goto L17;
        drawScanLine(r100);     // Catch: Exception -> L11
        return;
    }

    public void setListener(IScanBoxViewListener r100) {
        this.listener = r100;
    }

    @Override // com.android.ttcjpaysdk.ocr.view.IScanBoxView
    public void showScanBox(boolean r100) {
        this.isShowScanBox = r100;
    }

    @Override // com.android.ttcjpaysdk.ocr.view.IScanBoxView
    public void showScanLine(boolean r100) {
        this.isShowScanLine = r100;
    }

    public FullScanView(Context r100, AttributeSet r101) {
        this(r100);
        initCustomAttrs(r100, r101);
    }

    public static /* synthetic */ float access$002(FullScanView r100, float r101) {
        r100.mScanLineTop = r101;
        return r101;
    }

    private void initCustomAttr(int r100, TypedArray r101) {
        if (r100 != 29) goto L6;
        this.mTopOffset = r101.getDimensionPixelSize(r100, this.mTopOffset);
        return;
    L6:
        if (r100 != 23) goto L9;
        this.mScanLineSize = r101.getDimensionPixelSize(r100, this.mScanLineSize);
        return;
    L9:
        if (r100 != 16) goto L12;
        this.mMaskColor = r101.getColor(r100, this.mMaskColor);
        return;
    L12:
        if (r100 != 21) goto L15;
        this.mScanLineColor = r101.getColor(r100, this.mScanLineColor);
        return;
    L15:
        if (r100 != 22) goto L18;
        this.mScanLineMargin = r101.getDimensionPixelSize(r100, this.mScanLineMargin);
        return;
    L18:
        if (r100 != 12) goto L21;
        this.mIsShowDefaultScanLineDrawable = r101.getBoolean(r100, this.mIsShowDefaultScanLineDrawable);
        return;
    L21:
        if (r100 != 8) goto L23;
        this.mCustomScanLineDrawable = r101.getDrawable(r100);
        return;
    L23:
        if (r100 != 0) goto L33;
        this.mAnimTime = r101.getInteger(r100, this.mAnimTime);
        return;
    }

    public void initCustomAttrs(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.cj_pay_ocr_animTime, R.attr.cj_pay_ocr_barcodeRectHeight, R.attr.cj_pay_ocr_borderColor, R.attr.cj_pay_ocr_borderRadius, R.attr.cj_pay_ocr_borderSize, R.attr.cj_pay_ocr_cornerColor, R.attr.cj_pay_ocr_cornerLength, R.attr.cj_pay_ocr_cornerSize, R.attr.cj_pay_ocr_customScanLineDrawable, R.attr.cj_pay_ocr_isCenterVertical, R.attr.cj_pay_ocr_isOnlyDecodeScanBoxArea, R.attr.cj_pay_ocr_isScanLineReverse, R.attr.cj_pay_ocr_isShowDefaultScanLineDrawable, R.attr.cj_pay_ocr_isShowTipBackground, R.attr.cj_pay_ocr_isShowTipTextAsSingleLine, R.attr.cj_pay_ocr_isTipTextBelowRect, R.attr.cj_pay_ocr_maskColor, R.attr.cj_pay_ocr_ocrCodeTipText, R.attr.cj_pay_ocr_permissionTipText, R.attr.cj_pay_ocr_permissionTipTextSize, R.attr.cj_pay_ocr_rectWidth, R.attr.cj_pay_ocr_scanLineColor, R.attr.cj_pay_ocr_scanLineMargin, R.attr.cj_pay_ocr_scanLineSize, R.attr.cj_pay_ocr_tipBackgroundColor, R.attr.cj_pay_ocr_tipTextColor, R.attr.cj_pay_ocr_tipTextMargin, R.attr.cj_pay_ocr_tipTextSize, R.attr.cj_pay_ocr_toolbarHeight, R.attr.cj_pay_ocr_topOffset});
        int r103 = r102.getIndexCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        initCustomAttr(r102.getIndex(r104), r102);
        r104 = r104 + 1;
        goto L3
    L5:
        r102.recycle();
        afterInitCustomAttrs();
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        IScanBoxViewListener r104 = this.listener;
        if (r104 == null) goto L6;
        r104.onSizeChanged();
        return;
    }
}
