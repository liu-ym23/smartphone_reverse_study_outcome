package com.bytedance.android.ui.ec.widget.popup;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes14.dex */
public class BubbleLayout extends LinearLayout {
    public static final int BOTTOM = 3;
    public static float CORNER_RADIUS = 0.0f;
    public static int DEFAULT_HEIGHT = 0;
    public static int DEFAULT_STROKE_WIDTH = 0;
    public static int DEFAULT_WIDTH = 0;
    public static final int LEFT = 1;
    public static int LEG_HALF_BASE = 0;
    public static float MIN_ARROW_DISTANCE = 0.0f;
    public static final int NONE = 4;
    public static int PADDING = 0;
    public static final int RIGHT = 2;
    public static float STROKE_WIDTH;
    public static final int TOP = 0;
    private int mArrowLongSize;
    private int mArrowVerticalSize;
    private int mBgColor;
    private Bitmap mBitmap;
    private final Path mBorderBubbleArrowPath;
    private int mBorderColor;
    private Matrix mBorderMatrix;
    private RectF mBorderRoundRect;
    private int mBorderWidth;
    private float mBubbleArrowOffset;
    private final Path mBubbleArrowPath;
    private int mBubbleOrientation;
    private Canvas mCanvas;
    private Context mContext;
    private Paint mFillPaint;
    private float mHeight;
    private int mHorizontalPadding;
    private float mMeasuredHeight;
    private boolean mNeedPath;
    private boolean mNeedPressFade;
    private final Path mPath;
    private RectF mRoundRect;
    private Boolean mRounderArrow;
    private int mShadowLayerColor;
    private float mShadowLayerYOffset;
    private float mWidth;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BubbleOrientation {
    }

    public static /* synthetic */ void a(ValueAnimator r100) {
        lambda$animFadeOut$1(r100);
    }

    private void animFadeOut() {
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.5f});
        r100.setDuration(100);
        r100.start();
        r100.addUpdateListener(new a());
    }

    public static /* synthetic */ void b(ValueAnimator r100) {
        lambda$animFadeIn$0(r100);
    }

    private static /* synthetic */ void lambda$animFadeIn$0(ValueAnimator r100) {
    }

    private static /* synthetic */ void lambda$animFadeOut$1(ValueAnimator r100) {
    }

    public float getBubbleOffset() {
        float r100 = Math.max(this.mBubbleArrowOffset, MIN_ARROW_DISTANCE);
        int r101 = this.mBubbleOrientation;
        if (r101 == 0) goto L13;
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L13;
        return 0.0f;
    L15:
        return Math.min(r100, this.mHeight - MIN_ARROW_DISTANCE);
    L13:
        return Math.min(r100, this.mWidth - MIN_ARROW_DISTANCE);
    }

    public int getHeightWithArrow() {
        return (int) (DEFAULT_HEIGHT + dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f)));
    }

    private void animFadeIn() {
        clearAnimation();
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 1.0f});
        r100.setDuration(100);
        r100.start();
        r100.addUpdateListener(new b());
    }

    public int getHorizontalPadding() {
        return this.mHorizontalPadding;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubbleLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void renderBubbleArrowPath(Context r110) {
        this.mBubbleArrowPath.moveTo(0.0f, 0.0f);
        this.mBubbleArrowPath.lineTo(dip2Px(r110, this.mArrowVerticalSize), -dip2Px(r110, this.mArrowLongSize / 2.0f));
        this.mBubbleArrowPath.lineTo(dip2Px(r110, this.mArrowVerticalSize), dip2Px(r110, this.mArrowLongSize / 2.0f));
        this.mBubbleArrowPath.close();
        this.mBorderBubbleArrowPath.moveTo(0.0f, 0.0f);
        this.mBorderBubbleArrowPath.lineTo((float) (((double) dip2Px(r110, this.mArrowVerticalSize)) + (((double) this.mBorderWidth) * Math.sqrt(2.0d))), (float) (((double) (-dip2Px(r110, this.mArrowLongSize / 2.0f))) - (((double) this.mBorderWidth) * Math.sqrt(2.0d))));
        this.mBorderBubbleArrowPath.lineTo((float) (((double) dip2Px(r110, this.mArrowVerticalSize)) + (((double) this.mBorderWidth) * Math.sqrt(2.0d))), (float) (((double) dip2Px(r110, this.mArrowVerticalSize)) + (((double) this.mBorderWidth) * Math.sqrt(2.0d))));
        this.mBorderBubbleArrowPath.close();
    }

    private void renderRounderBubbleArrowPath(Context r210) {
        Float r100 = Float.valueOf(this.mArrowLongSize / 2.0f);
        this.mBubbleArrowPath.moveTo(dip2Px(r210, this.mArrowVerticalSize), dip2Px(r210, r100.floatValue()));
        this.mBubbleArrowPath.cubicTo(dip2Px(r210, this.mArrowVerticalSize), dip2Px(r210, r100.floatValue() / 2.0f), 0.0f, dip2Px(r210, r100.floatValue() / 4.0f), 0.0f, 0.0f);
        this.mBubbleArrowPath.cubicTo(0.0f, -dip2Px(r210, r100.floatValue() / 4.0f), dip2Px(r210, this.mArrowVerticalSize), -dip2Px(r210, r100.floatValue() / 2.0f), dip2Px(r210, this.mArrowVerticalSize), -dip2Px(r210, r100.floatValue()));
        this.mBubbleArrowPath.close();
        this.mBorderBubbleArrowPath.moveTo(dip2Px(r210, this.mArrowVerticalSize), dip2Px(r210, r100.floatValue()));
        this.mBorderBubbleArrowPath.cubicTo(dip2Px(r210, this.mArrowVerticalSize), dip2Px(r210, r100.floatValue() / 2.0f), 0.0f, dip2Px(r210, (r100.floatValue() * 5.0f) / 16.0f), 0.0f, 0.0f);
        this.mBorderBubbleArrowPath.cubicTo(0.0f, -dip2Px(r210, r100.floatValue() / 4.0f), dip2Px(r210, this.mArrowVerticalSize), -dip2Px(r210, r100.floatValue() / 2.0f), dip2Px(r210, this.mArrowVerticalSize), -dip2Px(r210, r100.floatValue()));
        this.mBorderBubbleArrowPath.close();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r100) {
        if (this.mRounderArrow.booleanValue() == false) goto L5;
        renderRounderBubbleArrowPath(this.mContext);
    L7:
        if (this.mBitmap != null) goto L12;
        Bitmap r101 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.mBitmap = r101;
        if (r101.getDensity() == r100.getDensity()) goto L11;
        this.mBitmap.setDensity(r100.getDensity());
    L11:
        this.mCanvas = new Canvas(this.mBitmap);
    L12:
        Matrix r102 = renderBubbleArrowMatrix(this.mWidth, this.mHeight);
        this.mFillPaint.setColor(this.mBorderColor);
        this.mFillPaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setStrokeWidth(this.mBorderWidth);
        if (this.mNeedPath == false) goto L15;
        this.mPath.reset();
        Path r103 = this.mPath;
        RectF r104 = this.mBorderRoundRect;
        float r105 = CORNER_RADIUS;
        int r106 = this.mBorderWidth;
        r103.addRoundRect(r104, (r106 / 2) + r105, r105 + (r106 / 2), Path.Direction.CW);
        this.mPath.addPath(this.mBorderBubbleArrowPath, this.mBorderMatrix);
        this.mCanvas.drawPath(this.mPath, this.mFillPaint);
    L15:
        this.mFillPaint.setColor(this.mBgColor);
        this.mFillPaint.setStyle(Paint.Style.FILL);
        this.mPath.reset();
        Path r107 = this.mPath;
        RectF r108 = this.mRoundRect;
        float r109 = CORNER_RADIUS;
        r107.addRoundRect(r108, r109, r109, Path.Direction.CW);
        this.mPath.addPath(this.mBubbleArrowPath, r102);
        this.mCanvas.drawPath(this.mPath, this.mFillPaint);
        r100.drawBitmap(this.mBitmap, 0.0f, 0.0f, null);
        return;
    L5:
        renderBubbleArrowPath(this.mContext);
        goto L7
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L13;
        if (r101 == 1) goto L10;
        if (r101 == 3) goto L10;
    L16:
        return super.onTouchEvent(r100);
    L10:
        if (this.mNeedPressFade == false) goto L16;
        animFadeIn();
        goto L16
    L13:
        if (this.mNeedPressFade == false) goto L16;
        animFadeOut();
        goto L16
    }

    public void setArrowLongSize(int r100) {
        this.mArrowLongSize = r100;
    }

    public void setArrowVerticalSize(int r100) {
        this.mArrowVerticalSize = r100;
    }

    public void setBgColor(int r100) {
        this.mBgColor = r100;
    }

    public void setBorderColor(int r100) {
        this.mBorderColor = r100;
    }

    public void setBubbleOrientation(int r100) {
        this.mBubbleOrientation = r100;
    }

    public void setHorizontalPadding(int r100) {
        this.mHorizontalPadding = r100;
    }

    public void setNeedPath(boolean r100) {
        this.mNeedPath = r100;
    }

    public void setNeedPressFade(boolean r100) {
        this.mNeedPressFade = r100;
    }

    public void setShadowLayerColor(int r100) {
        this.mShadowLayerColor = r100;
    }

    public void setShadowLayerYOffset(int r100) {
        this.mShadowLayerYOffset = r100;
    }

    public BubbleLayout(Context r100, Boolean r101) {
        this(r100, r101, null);
    }

    public static float dip2Px(Context r100, float r101) {
        return (r101 * INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubbleLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f;
    }

    private Matrix renderBubbleArrowMatrix(float r110, float r111) {
        float r100 = Math.max(this.mBubbleArrowOffset, MIN_ARROW_DISTANCE);
        float r101 = Math.min(r100, r111 - MIN_ARROW_DISTANCE);
        Matrix r102 = new Matrix();
        this.mBorderMatrix = new Matrix();
        int r103 = this.mBubbleOrientation;
        if (r103 != 0) goto L5;
        r110 = Math.min(r100, r110 - MIN_ARROW_DISTANCE);
        r102.postRotate(90.0f);
        r102.postTranslate(0.0f, dip2Px(this.mContext, this.mShadowLayerYOffset / 2.0f));
        this.mBorderMatrix.postRotate(90.0f);
        Matrix r112 = this.mBorderMatrix;
        int r104 = this.mBorderWidth;
        r112.postTranslate(((r104 * 3) / 2) + r110, r104 + 0.0f);
        setPadding(0, (int) dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f)), 0, 0);
        setGravity(17);
        this.mRoundRect = new RectF(0.0f, (int) dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f)), this.mWidth, this.mHeight);
        this.mFillPaint.setShadowLayer(8.0f, 0.0f, -this.mShadowLayerYOffset, this.mShadowLayerColor);
        r111 = 0.0f;
    L14:
        RectF r105 = this.mRoundRect;
        float r106 = r105.left;
        int r107 = this.mBorderWidth;
        r105.left = r106 + ((r107 * 3) / 2);
        r105.top += (r107 * 3) / 2;
        r105.right += (r107 * 3) / 2;
        r105.bottom += (r107 * 3) / 2;
        RectF r108 = new RectF();
        this.mBorderRoundRect = r108;
        RectF r109 = this.mRoundRect;
        float r113 = r109.left;
        int r114 = this.mBorderWidth;
        r108.left = r113 - (r114 / 2);
        r108.top = r109.top - (r114 / 2);
        r108.right = r109.right + (r114 / 2);
        r108.bottom = r109.bottom + (r114 / 2);
        r102.postTranslate(r110 + ((r114 * 3) / 2), r111 + ((r114 * 3) / 2));
        return r102;
    L5:
        if (r103 == 1) goto L12;
        if (r103 == 2) goto L11;
        if (r103 == 3) goto L10;
        r111 = r101;
    L9:
        r110 = 0.0f;
        goto L14
    L10:
        r110 = Math.min(r100, r110 - MIN_ARROW_DISTANCE);
        r102.postRotate(270.0f);
        r102.postTranslate(0.0f, -dip2Px(this.mContext, this.mShadowLayerYOffset / 2.0f));
        this.mBorderMatrix.postRotate(270.0f);
        Matrix r115 = this.mBorderMatrix;
        int r116 = this.mBorderWidth;
        r115.postTranslate(((r116 * 3) / 2) + r110, (r116 * 2) + r111);
        setPadding(0, 0, 0, (int) dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f)));
        setGravity(17);
        this.mRoundRect = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight - ((int) dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f))));
        this.mFillPaint.setShadowLayer(8.0f, 0.0f, this.mShadowLayerYOffset, this.mShadowLayerColor);
        goto L14
    L11:
        r111 = Math.min(r100, r111 - MIN_ARROW_DISTANCE);
        r102.postRotate(180.0f);
        this.mBorderMatrix.postRotate(180.0f);
        Matrix r117 = this.mBorderMatrix;
        int r118 = this.mBorderWidth;
        r117.postTranslate((r118 * 2) + r110, ((r118 * 3) / 2) + r111);
        setPadding(0, 0, PADDING, 0);
        setGravity(17);
        this.mRoundRect = new RectF(0.0f, 0.0f, this.mWidth - PADDING, this.mHeight);
        goto L14
    L12:
        r111 = Math.min(r100, r111 - MIN_ARROW_DISTANCE);
        setPadding(PADDING, 0, 0, 0);
        setGravity(17);
        Matrix r119 = this.mBorderMatrix;
        int r120 = this.mBorderWidth;
        r119.postTranslate(r120 + 0.0f, ((r120 * 3) / 2) + r111);
        this.mRoundRect = new RectF(PADDING, 0.0f, this.mWidth, this.mHeight);
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = View.MeasureSpec.getMode(r101);
        int r105 = View.MeasureSpec.getSize(r101);
        if (this.mMeasuredHeight != 0.0f) goto L5;
        this.mMeasuredHeight = getMeasuredHeight();
    L5:
        int r106 = (int) (this.mMeasuredHeight + dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f)));
        int r107 = (int) (getMeasuredWidth() + (dip2Px(this.mContext, this.mHorizontalPadding) * 2.0f));
        int r108 = this.mBorderWidth;
        int r109 = r107 + (r108 * 3);
        int r110 = r106 + (r108 * 3);
        if (r102 != Integer.MIN_VALUE) goto L9;
        if (r104 != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(r109, r110);
    L13:
        this.mWidth = getMeasuredWidth() - (this.mBorderWidth * 3);
        this.mHeight = getMeasuredHeight() - (this.mBorderWidth * 3);
        return;
    L9:
        if (r102 != Integer.MIN_VALUE) goto L11;
        setMeasuredDimension(r109, r105);
        goto L13
    L11:
        if (r104 != Integer.MIN_VALUE) goto L13;
        setMeasuredDimension(r103, r110);
        goto L13
    }

    public void setBubbleParams(int r100, float r101) {
        this.mBubbleArrowOffset = r101;
        this.mBubbleOrientation = r100;
    }

    public BubbleLayout(Context r100, Boolean r101, AttributeSet r102) {
        this(r100, r101, r102, 0);
    }

    private void init(Context r100, Boolean r101, AttributeSet r102) {
        this.mContext = r100;
        int r103 = (int) dip2Px(r100, 0.5f);
        this.mBorderWidth = r103;
        if (r103 >= 2) goto L5;
        this.mBorderWidth = 2;
    L5:
        PADDING = (int) dip2Px(r100, 7.0f);
        LEG_HALF_BASE = (int) dip2Px(r100, 6.0f);
        STROKE_WIDTH = 8.0f;
        DEFAULT_STROKE_WIDTH = (int) dip2Px(r100, 8.0f);
        CORNER_RADIUS = dip2Px(r100, 8.0f);
        MIN_ARROW_DISTANCE = PADDING + LEG_HALF_BASE;
        DEFAULT_WIDTH = (int) dip2Px(r100, 50.0f);
        DEFAULT_HEIGHT = (int) dip2Px(r100, 37.0f);
        Paint r104 = new Paint();
        this.mFillPaint = r104;
        r104.setStyle(Paint.Style.FILL);
        this.mFillPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mFillPaint.setAntiAlias(true);
        this.mFillPaint.setStrokeWidth(STROKE_WIDTH);
        this.mFillPaint.setStrokeJoin(Paint.Join.MITER);
        this.mBgColor = ColorProtector.parseColor("#CC000000");
        this.mBorderColor = ColorProtector.parseColor("#1DFFFFFF");
        this.mShadowLayerColor = ColorProtector.parseColor("#40C8C8C8");
        this.mFillPaint.setColor(this.mBgColor);
        this.mRounderArrow = r101;
        setLayerType(1, this.mFillPaint);
        setBackgroundColor(0);
        setClipChildren(false);
    }

    public BubbleLayout(Context r100, Boolean r101, AttributeSet r102, int r103) {
        super(r100, r102, r103);
        this.mFillPaint = null;
        this.mPath = new Path();
        this.mBubbleArrowPath = new Path();
        this.mHorizontalPadding = 4;
        this.mArrowLongSize = 14;
        this.mArrowVerticalSize = 7;
        this.mShadowLayerYOffset = 8.0f;
        this.mBorderBubbleArrowPath = new Path();
        this.mRounderArrow = Boolean.FALSE;
        this.mBubbleArrowOffset = 0.75f;
        this.mBubbleOrientation = 1;
        this.mNeedPath = true;
        init(r100, r101, r102);
    }
}
