package com.android.ttcjpaysdk.ocr.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.ocr.utils.OCRCodeUtil;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes39.dex */
public class DefaultScanBoxView extends IScanBoxView {
    private boolean isShowPermissionTip;
    private boolean isShowScanBox;
    private boolean isShowScanLine;
    private IScanBoxViewListener listener;
    private int mAnimDelayTime;
    private int mAnimTime;
    private int mBarcodeRectHeight;
    private int mBorderColor;
    private int mBorderRadius;
    private int mBorderSize;
    private int mCornerColor;
    private int mCornerLength;
    private int mCornerLineRadius;
    private int mCornerSize;
    private Drawable mCustomScanLineDrawable;
    private Rect mFramingRect;
    private float mHalfCornerSize;
    private boolean mIsCenterVertical;
    private boolean mIsOnlyDecodeScanBoxArea;
    private boolean mIsScanLineReverse;
    private boolean mIsShowDefaultScanLineDrawable;
    private boolean mIsShowTipBackground;
    private boolean mIsShowTipTextAsSingleLine;
    private boolean mIsTipTextBelowRect;
    private int mMaskColor;
    private int mMoveStepDistance;
    private String mOCRCodeTipText;
    private Bitmap mOriginOCRCodeScanLineBitmap;
    private Paint mPaint;
    private TextPaint mPermissionTipPaint;
    private String mPermissionTipText;
    private int mPermissionTipTextSize;
    private int mRectHeight;
    private int mRectWidth;
    private Bitmap mScanLineBitmap;
    private int mScanLineColor;
    private int mScanLineMargin;
    private int mScanLineSize;
    private float mScanLineTop;
    private int mTipBackgroundColor;
    private int mTipBackgroundRadius;
    private TextPaint mTipPaint;
    private String mTipText;
    private int mTipTextColor;
    private int mTipTextMargin;
    private int mTipTextSize;
    private StaticLayout mTipTextSl;
    private int mToolbarHeight;
    private int mTopOffset;

    public interface IScanBoxViewListener {
        void onSizeChanged();
    }

    private void afterInitCustomAttrs() {
        Drawable r100 = this.mCustomScanLineDrawable;
        if (r100 == null) goto L6;
        this.mOriginOCRCodeScanLineBitmap = ((BitmapDrawable) r100).getBitmap();
    L6:
        if (this.mOriginOCRCodeScanLineBitmap != null) goto L8;
        Bitmap r101 = BitmapFactory.decodeResource(getResources(), R.drawable.cj_pay_ocr_code_default_grid_scan_line);
        this.mOriginOCRCodeScanLineBitmap = r101;
        this.mOriginOCRCodeScanLineBitmap = OCRCodeUtil.makeTintBitmap(r101, this.mScanLineColor);
    L8:
        this.mTopOffset += this.mToolbarHeight;
        this.mHalfCornerSize = (this.mCornerSize * 1.0f) / 2.0f;
        this.mTipPaint.setTextSize(this.mTipTextSize);
        this.mTipPaint.setColor(this.mTipTextColor);
        this.mPermissionTipPaint.setTextSize(this.mPermissionTipTextSize);
        this.mPermissionTipPaint.setColor(this.mTipTextColor);
        setFramingRect();
    }

    private void initTipsSL() {
        if (TextUtils.isEmpty(this.mTipText) == false) goto L5;
        return;
    L5:
        if (this.mIsShowTipTextAsSingleLine == false) goto L7;
        this.mTipTextSl = new StaticLayout(this.mTipText, this.mTipPaint, OCRCodeUtil.getScreenResolution(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        return;
    L7:
        this.mTipTextSl = new StaticLayout(this.mTipText, this.mTipPaint, this.mRectWidth - (this.mTipBackgroundRadius * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
    }

    private void moveScanLine() {
        this.mScanLineTop += this.mMoveStepDistance;
        int r100 = this.mScanLineSize;
        Bitmap r101 = this.mScanLineBitmap;
        if (r101 == null) goto L6;
        r100 = r101.getHeight();
    L6:
        if (this.mIsScanLineReverse == false) goto L12;
        float r102 = this.mScanLineTop;
        float r103 = r100 + r102;
        Rect r104 = this.mFramingRect;
        float r105 = r104.bottom;
        float r106 = this.mHalfCornerSize;
        if (r103 <= (r105 - r106)) goto L10;
    L11:
        this.mMoveStepDistance = -this.mMoveStepDistance;
    L15:
        long r107 = this.mAnimDelayTime;
        Rect r108 = this.mFramingRect;
        postInvalidateDelayed(r107, r108.left, r108.top, r108.right, r108.bottom);
        return;
    L10:
        if (r102 >= (r104.top + r106)) goto L15;
    L12:
        float r109 = this.mScanLineTop + r100;
        Rect r110 = this.mFramingRect;
        float r111 = r110.bottom;
        float r112 = this.mHalfCornerSize;
        if (r109 <= (r111 - r112)) goto L15;
        this.mScanLineTop = (r110.top + r112) + 0.5f;
        goto L15
    }

    private void setFramingRect() {
        if (this.mCustomScanLineDrawable == null) goto L5;
    L6:
        this.mScanLineBitmap = this.mOriginOCRCodeScanLineBitmap;
    L7:
        this.mTipText = this.mOCRCodeTipText;
        int r100 = this.mRectWidth;
        this.mRectHeight = r100;
        this.mAnimDelayTime = (int) (((this.mAnimTime * 1.0f) * this.mMoveStepDistance) / r100);
        initTipsSL();
        if (this.mIsCenterVertical == false) goto L13;
        int r101 = OCRCodeUtil.getScreenResolution(getContext()).y;
        int r102 = this.mToolbarHeight;
        if (r102 != 0) goto L12;
        this.mTopOffset = (r101 - this.mRectHeight) / 2;
        goto L13
    L12:
        this.mTopOffset = ((r101 - this.mRectHeight) / 2) + (r102 / 2);
    L13:
        calFramingRect();
        postInvalidate();
        return;
    L5:
        if (this.mIsShowDefaultScanLineDrawable == false) goto L7;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.ocr.view.IScanBoxView
    public int getTipsLineCount() {
        StaticLayout r100 = this.mTipTextSl;
        if (r100 != null) goto L5;
        return 1;
    L5:
        return r100.getLineCount();
    }

    private void calFramingRect() {
        int r100 = (getWidth() - this.mRectWidth) / 2;
        int r101 = this.mTopOffset;
        Rect r102 = new Rect(r100, r101, this.mRectWidth + r100, this.mRectHeight + r101);
        this.mFramingRect = r102;
        this.mScanLineTop = (r102.top + this.mHalfCornerSize) + 0.5f;
    }

    @Override // com.android.ttcjpaysdk.ocr.view.IScanBoxView
    public Rect getFramingRect() {
        return this.mFramingRect;
    }

    public DefaultScanBoxView(Context r100) {
        super(r100);
        this.mCornerLineRadius = 10;
        this.isShowScanLine = true;
        this.isShowScanBox = false;
        this.isShowPermissionTip = true;
        Paint r101 = new Paint();
        this.mPaint = r101;
        r101.setAntiAlias(true);
        this.mMaskColor = ColorProtector.parseColor("#80000000");
        this.mCornerColor = -1;
        this.mCornerLength = OCRCodeUtil.dp2px(r100, 20.0f);
        this.mCornerSize = OCRCodeUtil.dp2px(r100, 2.0f);
        this.mScanLineSize = OCRCodeUtil.dp2px(r100, 1.0f);
        this.mScanLineColor = -1;
        this.mTopOffset = OCRCodeUtil.dp2px(r100, 90.0f);
        this.mRectWidth = OCRCodeUtil.dp2px(r100, 200.0f);
        this.mBarcodeRectHeight = OCRCodeUtil.dp2px(r100, 140.0f);
        this.mScanLineMargin = 0;
        this.mIsShowDefaultScanLineDrawable = false;
        this.mCustomScanLineDrawable = null;
        this.mScanLineBitmap = null;
        this.mBorderSize = OCRCodeUtil.dp2px(r100, 1.0f);
        this.mBorderRadius = OCRCodeUtil.dp2px(r100, 4.0f);
        this.mBorderColor = ColorProtector.parseColor("#CDFFFFFF");
        this.mAnimTime = 1000;
        this.mIsCenterVertical = false;
        this.mToolbarHeight = 0;
        this.mMoveStepDistance = OCRCodeUtil.dp2px(r100, 2.7f);
        this.mTipText = null;
        this.mPermissionTipText = null;
        this.mTipTextSize = OCRCodeUtil.dp2px(r100, 14.0f);
        this.mPermissionTipTextSize = OCRCodeUtil.dp2px(r100, 14.0f);
        this.mTipTextColor = -1;
        this.mIsTipTextBelowRect = false;
        this.mTipTextMargin = OCRCodeUtil.dp2px(r100, 28.0f);
        this.mIsShowTipTextAsSingleLine = false;
        this.mTipBackgroundColor = ColorProtector.parseColor("#22000000");
        this.mIsShowTipBackground = false;
        this.mIsScanLineReverse = false;
        TextPaint r102 = new TextPaint();
        this.mTipPaint = r102;
        r102.setAntiAlias(true);
        TextPaint r103 = new TextPaint();
        this.mPermissionTipPaint = r103;
        r103.setAntiAlias(true);
        this.mTipBackgroundRadius = OCRCodeUtil.dp2px(r100, 4.0f);
        this.mIsOnlyDecodeScanBoxArea = false;
    }

    private void drawBorderLine(Canvas r100) {
        if (this.mBorderSize <= 0) goto L6;
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mBorderColor);
        this.mPaint.setStrokeWidth(this.mBorderSize);
        RectF r101 = new RectF(this.mFramingRect);
        int r102 = this.mBorderRadius;
        r100.drawRoundRect(r101, r102, r102, this.mPaint);
        return;
    }

    private void drawCornerLine(Canvas r100) {
        if (this.mHalfCornerSize <= 0.0f) goto L6;
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mCornerColor);
        this.mPaint.setStrokeWidth(this.mCornerSize);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        Path r101 = new Path();
        Rect r102 = this.mFramingRect;
        float r103 = r102.left + this.mCornerLength;
        float r104 = this.mHalfCornerSize;
        r101.moveTo(r103 + r104, r102.top + r104);
        Rect r105 = this.mFramingRect;
        float r106 = r105.left;
        float r107 = this.mHalfCornerSize;
        r101.lineTo(r106 + r107, r105.top + r107);
        Rect r108 = this.mFramingRect;
        float r109 = r108.left;
        float r110 = this.mHalfCornerSize;
        r101.lineTo(r109 + r110, (r108.top + this.mCornerLength) + r110);
        this.mPaint.setPathEffect(new CornerPathEffect(this.mCornerLineRadius));
        r100.drawPath(r101, this.mPaint);
        Rect r111 = this.mFramingRect;
        float r112 = r111.right - this.mCornerLength;
        float r113 = this.mHalfCornerSize;
        r101.moveTo(r112 - r113, r111.top + r113);
        Rect r114 = this.mFramingRect;
        float r115 = r114.right;
        float r116 = this.mHalfCornerSize;
        r101.lineTo(r115 - r116, r114.top + r116);
        Rect r117 = this.mFramingRect;
        float r118 = r117.right;
        float r119 = this.mHalfCornerSize;
        r101.lineTo(r118 - r119, (r117.top + this.mCornerLength) + r119);
        r100.drawPath(r101, this.mPaint);
        Rect r120 = this.mFramingRect;
        float r121 = r120.left;
        float r122 = this.mHalfCornerSize;
        r101.moveTo(r121 + r122, (r120.bottom - this.mCornerLength) - r122);
        Rect r123 = this.mFramingRect;
        float r124 = r123.left;
        float r125 = this.mHalfCornerSize;
        r101.lineTo(r124 + r125, r123.bottom - r125);
        Rect r126 = this.mFramingRect;
        float r127 = r126.left + this.mCornerLength;
        float r128 = this.mHalfCornerSize;
        r101.lineTo(r127 + r128, r126.bottom - r128);
        r100.drawPath(r101, this.mPaint);
        Rect r129 = this.mFramingRect;
        float r130 = r129.right - this.mCornerLength;
        float r131 = this.mHalfCornerSize;
        r101.moveTo(r130 - r131, r129.bottom - r131);
        Rect r132 = this.mFramingRect;
        float r133 = r132.right;
        float r134 = this.mHalfCornerSize;
        r101.lineTo(r133 - r134, r132.bottom - r134);
        Rect r135 = this.mFramingRect;
        float r136 = r135.right;
        float r137 = this.mHalfCornerSize;
        r101.lineTo(r136 - r137, (r135.bottom - this.mCornerLength) - r137);
        r100.drawPath(r101, this.mPaint);
        this.mPaint.setPathEffect(new PathEffect());
        return;
    }

    private void drawMask(Canvas r110) {
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        if (this.mMaskColor == 0) goto L6;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mMaskColor);
        float r102 = r100;
        r110.drawRect(0.0f, 0.0f, r102, this.mFramingRect.top, this.mPaint);
        Rect r103 = this.mFramingRect;
        r110.drawRect(0.0f, r103.top, r103.left, r103.bottom + 1, this.mPaint);
        Rect r104 = this.mFramingRect;
        r110.drawRect(r104.right + 1, r104.top, r102, r104.bottom + 1, this.mPaint);
        r110.drawRect(0.0f, this.mFramingRect.bottom + 1, r102, r101, this.mPaint);
        return;
    }

    private void drawMaskRect(Canvas r110) {
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        if (this.mMaskColor == 0) goto L6;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mMaskColor);
        r110.drawRect(0.0f, 0.0f, r100, r101, this.mPaint);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        return;
    }

    private void drawPermissionTipText(Canvas r100) {
        if (TextUtils.isEmpty(this.mPermissionTipText) == false) goto L5;
        return;
    L5:
        if (this.mTipTextSl == null) goto L10;
        this.mPermissionTipPaint.setStyle(Paint.Style.FILL);
        this.mPermissionTipPaint.setTextAlign(Paint.Align.CENTER);
        r100.drawText(this.mPermissionTipText, this.mFramingRect.centerX(), this.mFramingRect.top - this.mTipTextMargin, this.mPermissionTipPaint);
        return;
    }

    private void drawScanBoxRec(Canvas r100) {
        if (this.mMaskColor == 0) goto L6;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(0);
        RectF r101 = new RectF(this.mFramingRect);
        int r102 = this.mBorderRadius;
        r100.drawRoundRect(r101, r102, r102, this.mPaint);
        this.mPaint.setXfermode(null);
        return;
    }

    private void drawScanLine(Canvas r110) {
        if (this.mScanLineBitmap == null) goto L5;
        Rect r100 = this.mFramingRect;
        float r101 = r100.left;
        float r102 = this.mHalfCornerSize;
        int r103 = this.mScanLineMargin;
        float r104 = this.mScanLineTop;
        r110.drawBitmap(this.mScanLineBitmap, null, new RectF((r101 + r102) + r103, r104, (r100.right - r102) - r103, this.mScanLineBitmap.getHeight() + r104), this.mPaint);
        return;
    L5:
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mScanLineColor);
        Rect r105 = this.mFramingRect;
        float r106 = r105.left;
        float r107 = this.mHalfCornerSize;
        int r108 = this.mScanLineMargin;
        float r109 = this.mScanLineTop;
        r110.drawRect((r106 + r107) + r108, r109, (r105.right - r107) - r108, r109 + this.mScanLineSize, this.mPaint);
    }

    private void drawTipText(Canvas r100) {
        if (TextUtils.isEmpty(this.mTipText) == false) goto L5;
        return;
    L5:
        if (this.mTipTextSl != null) goto L8;
        return;
    L8:
        if (this.mIsTipTextBelowRect == false) goto L20;
        if (this.mIsShowTipBackground == false) goto L15;
        this.mPaint.setColor(this.mTipBackgroundColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (this.mIsShowTipTextAsSingleLine == false) goto L14;
        Rect r101 = new Rect();
        TextPaint r102 = this.mTipPaint;
        String r103 = this.mTipText;
        r102.getTextBounds(r103, 0, r103.length(), r101);
        float r104 = ((r100.getWidth() - r101.width()) / 2) - this.mTipBackgroundRadius;
        RectF r105 = new RectF(r104, (this.mFramingRect.bottom + this.mTipTextMargin) - this.mTipBackgroundRadius, (r101.width() + r104) + (this.mTipBackgroundRadius * 2), ((this.mFramingRect.bottom + this.mTipTextMargin) + this.mTipTextSl.getHeight()) + this.mTipBackgroundRadius);
        int r106 = this.mTipBackgroundRadius;
        r100.drawRoundRect(r105, r106, r106, this.mPaint);
        goto L15
    L14:
        Rect r107 = this.mFramingRect;
        float r108 = r107.left;
        int r109 = r107.bottom;
        int r110 = this.mTipTextMargin;
        RectF r111 = new RectF(r108, (r109 + r110) - this.mTipBackgroundRadius, r107.right, ((r109 + r110) + this.mTipTextSl.getHeight()) + this.mTipBackgroundRadius);
        int r112 = this.mTipBackgroundRadius;
        r100.drawRoundRect(r111, r112, r112, this.mPaint);
    L15:
        r100.save();
        if (this.mIsShowTipTextAsSingleLine == false) goto L18;
        r100.translate(0.0f, this.mFramingRect.bottom + this.mTipTextMargin);
        this.mTipTextSl.draw(r100);
        r100.restore();
        return;
    L18:
        this.mTipPaint.setStyle(Paint.Style.FILL);
        this.mTipPaint.setTextAlign(Paint.Align.CENTER);
        r100.drawText(this.mTipText, this.mFramingRect.centerX(), (this.mFramingRect.bottom + this.mTipTextMargin) + this.mTipTextSl.getHeight(), this.mTipPaint);
        return;
    L20:
        if (this.mIsShowTipBackground == false) goto L25;
        this.mPaint.setColor(this.mTipBackgroundColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (this.mIsShowTipTextAsSingleLine == false) goto L24;
        Rect r113 = new Rect();
        TextPaint r114 = this.mTipPaint;
        String r115 = this.mTipText;
        r114.getTextBounds(r115, 0, r115.length(), r113);
        float r116 = ((r100.getWidth() - r113.width()) / 2) - this.mTipBackgroundRadius;
        float r117 = ((this.mFramingRect.top - this.mTipTextMargin) - this.mTipTextSl.getHeight()) - this.mTipBackgroundRadius;
        float r118 = r113.width() + r116;
        int r119 = this.mTipBackgroundRadius;
        RectF r120 = new RectF(r116, r117, r118 + (r119 * 2), (this.mFramingRect.top - this.mTipTextMargin) + r119);
        int r121 = this.mTipBackgroundRadius;
        r100.drawRoundRect(r120, r121, r121, this.mPaint);
        goto L25
    L24:
        Rect r122 = this.mFramingRect;
        float r123 = r122.left;
        int r124 = (r122.top - this.mTipTextMargin) - this.mTipTextSl.getHeight();
        int r125 = this.mTipBackgroundRadius;
        Rect r126 = this.mFramingRect;
        RectF r127 = new RectF(r123, r124 - r125, r126.right, (r126.top - this.mTipTextMargin) + r125);
        int r128 = this.mTipBackgroundRadius;
        r100.drawRoundRect(r127, r128, r128, this.mPaint);
    L25:
        r100.save();
        if (this.mIsShowTipTextAsSingleLine == false) goto L28;
        r100.translate(0.0f, (this.mFramingRect.top - this.mTipTextMargin) - this.mTipTextSl.getHeight());
    L29:
        this.mTipTextSl.draw(r100);
        r100.restore();
        return;
    L28:
        Rect r129 = this.mFramingRect;
        r100.translate(r129.left + this.mTipBackgroundRadius, (r129.top - this.mTipTextMargin) - this.mTipTextSl.getHeight());
        goto L29
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        if (this.mFramingRect != null) goto L21;
        return;
    L21:
    L18:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DefaultScanBoxView#drawPermissionTipText", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DefaultScanBoxView#drawPermissionTipText", e);
        return;
    L6:
        if (this.isShowScanBox == false) goto L13;
        drawMaskRect(r100);     // Catch: Exception -> L18
        drawScanBoxRec(r100);     // Catch: Exception -> L18
        drawBorderLine(r100);     // Catch: Exception -> L18
        drawCornerLine(r100);     // Catch: Exception -> L18
        if (this.isShowScanLine == false) goto L10;
        drawScanLine(r100);     // Catch: Exception -> L18
    L10:
        drawTipText(r100);     // Catch: Exception -> L18
        if (this.isShowScanLine == false) goto L15;
        moveScanLine();     // Catch: Exception -> L18
    L15:
        if (this.isShowPermissionTip == false) goto L23;
        drawPermissionTipText(r100);     // Catch: Exception -> L18
        return;
    L23:
        return;
    L13:
        drawMask(r100);     // Catch: Exception -> L18
        drawBorderLine(r100);     // Catch: Exception -> L18
        drawCornerLine(r100);     // Catch: Exception -> L18
        drawTipText(r100);     // Catch: Exception -> L18
        goto L15
    }

    public void setListener(IScanBoxViewListener r100) {
        this.listener = r100;
    }

    public void setOCRTipText(String r100) {
        this.mTipText = r100;
        initTipsSL();
    }

    public void setOCRTipTextSize(int r100) {
        this.mTipTextSize = r100;
        this.mTipPaint.setTextSize(r100);
    }

    public void setRectHeight(int r100) {
        this.mRectHeight = r100;
        calFramingRect();
        postInvalidate();
    }

    public void setRectWidth(int r100) {
        this.mRectWidth = r100;
        calFramingRect();
        postInvalidate();
    }

    @Override // com.android.ttcjpaysdk.ocr.view.IScanBoxView
    public void setScanLineBitmap(Bitmap r100) {
        if (r100 == null) goto L5;
        this.mScanLineBitmap = r100;
        return;
    }

    public void setTopOffset(int r100) {
        this.mTopOffset = r100;
        calFramingRect();
        postInvalidate();
    }

    @Override // com.android.ttcjpaysdk.ocr.view.IScanBoxView
    public void showPermissionTip(boolean r100) {
        this.isShowPermissionTip = r100;
    }

    @Override // com.android.ttcjpaysdk.ocr.view.IScanBoxView
    public void showScanBox(boolean r100) {
        this.isShowScanBox = r100;
    }

    @Override // com.android.ttcjpaysdk.ocr.view.IScanBoxView
    public void showScanLine(boolean r100) {
        this.isShowScanLine = r100;
    }

    public DefaultScanBoxView(Context r100, AttributeSet r101) {
        this(r100);
        initCustomAttrs(r100, r101);
    }

    private void initCustomAttr(int r100, TypedArray r101) {
        if (r100 != 29) goto L6;
        this.mTopOffset = r101.getDimensionPixelSize(r100, this.mTopOffset);
        return;
    L6:
        if (r100 != 7) goto L9;
        this.mCornerSize = r101.getDimensionPixelSize(r100, this.mCornerSize);
        return;
    L9:
        if (r100 != 6) goto L12;
        this.mCornerLength = r101.getDimensionPixelSize(r100, this.mCornerLength);
        return;
    L12:
        if (r100 != 23) goto L15;
        this.mScanLineSize = r101.getDimensionPixelSize(r100, this.mScanLineSize);
        return;
    L15:
        if (r100 != 20) goto L18;
        this.mRectWidth = r101.getDimensionPixelSize(r100, this.mRectWidth);
        return;
    L18:
        if (r100 != 16) goto L21;
        this.mMaskColor = r101.getColor(r100, this.mMaskColor);
        return;
    L21:
        if (r100 != 5) goto L24;
        this.mCornerColor = r101.getColor(r100, this.mCornerColor);
        return;
    L24:
        if (r100 != 21) goto L27;
        this.mScanLineColor = r101.getColor(r100, this.mScanLineColor);
        return;
    L27:
        if (r100 != 22) goto L30;
        this.mScanLineMargin = r101.getDimensionPixelSize(r100, this.mScanLineMargin);
        return;
    L30:
        if (r100 != 12) goto L33;
        this.mIsShowDefaultScanLineDrawable = r101.getBoolean(r100, this.mIsShowDefaultScanLineDrawable);
        return;
    L33:
        if (r100 != 8) goto L36;
        this.mCustomScanLineDrawable = r101.getDrawable(r100);
        return;
    L36:
        if (r100 != 4) goto L39;
        this.mBorderSize = r101.getDimensionPixelSize(r100, this.mBorderSize);
        return;
    L39:
        if (r100 != 3) goto L42;
        this.mBorderRadius = r101.getDimensionPixelSize(r100, this.mBorderRadius);
        return;
    L42:
        if (r100 != 2) goto L44;
        this.mBorderColor = r101.getColor(r100, this.mBorderColor);
        return;
    L44:
        if (r100 != 0) goto L47;
        this.mAnimTime = r101.getInteger(r100, this.mAnimTime);
        return;
    L47:
        if (r100 != 9) goto L50;
        this.mIsCenterVertical = r101.getBoolean(r100, this.mIsCenterVertical);
        return;
    L50:
        if (r100 != 28) goto L53;
        this.mToolbarHeight = r101.getDimensionPixelSize(r100, this.mToolbarHeight);
        return;
    L53:
        if (r100 != 1) goto L56;
        this.mBarcodeRectHeight = r101.getDimensionPixelSize(r100, this.mBarcodeRectHeight);
        return;
    L56:
        if (r100 != 17) goto L59;
        this.mOCRCodeTipText = r101.getString(r100);
        return;
    L59:
        if (r100 != 18) goto L62;
        this.mPermissionTipText = r101.getString(r100);
        return;
    L62:
        if (r100 != 19) goto L65;
        this.mPermissionTipTextSize = r101.getDimensionPixelSize(r100, this.mPermissionTipTextSize);
        return;
    L65:
        if (r100 != 27) goto L68;
        this.mTipTextSize = r101.getDimensionPixelSize(r100, this.mTipTextSize);
        return;
    L68:
        if (r100 != 25) goto L71;
        this.mTipTextColor = r101.getColor(r100, this.mTipTextColor);
        return;
    L71:
        if (r100 != 15) goto L74;
        this.mIsTipTextBelowRect = r101.getBoolean(r100, this.mIsTipTextBelowRect);
        return;
    L74:
        if (r100 != 26) goto L77;
        this.mTipTextMargin = r101.getDimensionPixelSize(r100, this.mTipTextMargin);
        return;
    L77:
        if (r100 != 14) goto L80;
        this.mIsShowTipTextAsSingleLine = r101.getBoolean(r100, this.mIsShowTipTextAsSingleLine);
        return;
    L80:
        if (r100 != 13) goto L83;
        this.mIsShowTipBackground = r101.getBoolean(r100, this.mIsShowTipBackground);
        return;
    L83:
        if (r100 != 24) goto L86;
        this.mTipBackgroundColor = r101.getColor(r100, this.mTipBackgroundColor);
        return;
    L86:
        if (r100 != 11) goto L89;
        this.mIsScanLineReverse = r101.getBoolean(r100, this.mIsScanLineReverse);
        return;
    L89:
        if (r100 != 10) goto L121;
        this.mIsOnlyDecodeScanBoxArea = r101.getBoolean(r100, this.mIsOnlyDecodeScanBoxArea);
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

    @Override // com.android.ttcjpaysdk.ocr.view.IScanBoxView
    public void setBorderRadius(int r100, int r101) {
        this.mBorderRadius = r100;
        this.mCornerLineRadius = r101;
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        calFramingRect();
        IScanBoxViewListener r104 = this.listener;
        if (r104 == null) goto L6;
        r104.onSizeChanged();
        return;
    }
}
