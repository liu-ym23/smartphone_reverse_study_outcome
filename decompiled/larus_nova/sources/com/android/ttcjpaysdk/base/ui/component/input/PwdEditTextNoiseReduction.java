package com.android.ttcjpaysdk.base.ui.component.input;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.animation.LinearInterpolator;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes28.dex */
public class PwdEditTextNoiseReduction extends BasePwdEditText {
    private final int DEFAULT_CURSOR_BLINK_INTERVAL;
    private final int DEFAULT_CURSOR_COLOR;
    private final float DEFAULT_CURSOR_HEIGHT;
    private final float DEFAULT_CURSOR_WIDTH;
    private final int DEFAULT_DOT_COLOR;
    private final float DEFAULT_DOT_RADIUS;
    private final int DEFAULT_PWD_BOX_STYLE_OPT_BASE_COLOR;
    private final int DEFAULT_PWD_BOX_STYLE_OPT_DURATION_MS;
    private final boolean DEFAULT_PWD_BOX_STYLE_OPT_ENABLE;
    private final int DEFAULT_PWD_BOX_STYLE_OPT_GRADIENT_COLOR;
    private final float DEFAULT_PWD_BOX_STYLE_OPT_STROKE_WIDTH;
    private final int DEFAULT_PWD_COUNT;
    private final boolean DEFAULT_SHOW_CURSOR;
    private final int DEFAULT_STROKE_COLOR;
    private final float DEFAULT_STROKE_RADIUS;
    private final int DEFAULT_STROKE_STYLE;
    private final float DEFAULT_STROKE_WIDTH;
    private final int DEFAULT_STYLE;
    private final int STYLE_RECTANGLE;
    private final int STYLE_ROUND_RECTANGLE;
    private float[] boxOffsets;
    private RectF[] boxes;
    private boolean cellFixedWidth;
    private float cellWidth;
    private ValueAnimator cursorAnimator;
    private int cursorBlinkInterval;
    private int cursorColor;
    private float cursorHeight;
    private Paint cursorPaint;
    private boolean cursorVisible;
    private float cursorWidth;
    private Paint digitalPaint;
    private boolean enablePwdBoxStyleOpt;
    private volatile boolean isDrawDotPaint;
    private boolean isShowCursor;
    private volatile boolean isShowPwd;
    private int mCount;
    private int mCurInputCount;
    private int mHeight;
    private int mPreInputCount;
    private int mWidth;
    private int padding;
    private float pwdBoxStyleOptAngle;
    private ValueAnimator pwdBoxStyleOptAnimator;
    private int pwdBoxStyleOptBaseColor;
    private Paint pwdBoxStyleOptBasePaint;
    private int pwdBoxStyleOptDurationMs;
    private int pwdBoxStyleOptGradientColor;
    private final Matrix pwdBoxStyleOptGradientMatrix;
    private Paint pwdBoxStyleOptGradientPaint;
    private float pwdBoxStyleOptLastCy;
    private float pwdBoxStyleOptLastLeft;
    private float pwdBoxStyleOptLastRight;
    private LinearGradient pwdBoxStyleOptLinearGradient;
    private final RectF pwdBoxStyleOptRect;
    private float pwdBoxStyleOptStrokeWidth;
    private int pwdDotColor;
    private Paint pwdDotPaint;
    private float pwdDotRadius;
    private int strokeColor;
    private Paint strokePaint;
    private float strokeRadius;
    private float strokeSpace;
    private Paint.Style strokeStyle;
    private float strokeWidth;
    private int style;

    public static /* synthetic */ void x(PwdEditTextNoiseReduction r100, ValueAnimator r101) {
        r100.lambda$shakeBoxTogether$1(r101);
    }

    public static /* synthetic */ void y(PwdEditTextNoiseReduction r100, ValueAnimator r101) {
        r100.lambda$startPwdBoxStyleOptAnimatorIfNeeded$0(r101);
    }

    public void shakeBoxTogether() {
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{0.0f, -15.0f, 15.0f, 0.0f});
        r100.setDuration(250);
        r100.addUpdateListener(new a(this));
        r100.start();
    }

    private void init() {
        Paint r100 = new Paint(1);
        this.strokePaint = r100;
        r100.setColor(this.strokeColor);
        this.strokePaint.setStrokeWidth(this.strokeWidth);
        this.strokePaint.setStyle(this.strokeStyle);
        int r101 = 0;
    L4:
        if (r101 >= this.mCount) goto L6;
        this.boxes[r101] = new RectF();
        this.boxOffsets[r101] = 0.0f;
        r101 = r101 + 1;
        goto L4
    L6:
        Paint r102 = new Paint(1);
        this.pwdDotPaint = r102;
        r102.setStyle(Paint.Style.FILL);
        this.pwdDotPaint.setColor(this.pwdDotColor);
        Paint r103 = new Paint(1);
        this.digitalPaint = r103;
        r103.setStyle(Paint.Style.FILL);
        this.digitalPaint.setColor(this.pwdDotColor);
        this.digitalPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.digitalPaint.setTextSize(CJPayBasicUtils.dipToPX(getContext(), 32.0f));
        setCursorVisible(false);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.mCount)});
        setMaxLines(1);
        setFocusable(false);
        addTextChangedListener(new AnonymousClass1(this));
        setAccessibilityDelegate(new AnonymousClass2(this));
        Paint r104 = new Paint(1);
        this.pwdBoxStyleOptBasePaint = r104;
        r104.setStyle(Paint.Style.STROKE);
        this.pwdBoxStyleOptBasePaint.setStrokeWidth(this.pwdBoxStyleOptStrokeWidth);
        this.pwdBoxStyleOptBasePaint.setColor(this.pwdBoxStyleOptBaseColor);
        Paint r105 = new Paint(1);
        this.pwdBoxStyleOptGradientPaint = r105;
        r105.setStyle(Paint.Style.STROKE);
        this.pwdBoxStyleOptGradientPaint.setStrokeWidth(this.pwdBoxStyleOptStrokeWidth);
    }

    private void startPwdBoxStyleOptAnimatorIfNeeded() {
        if (this.pwdBoxStyleOptAnimator == null) goto L5;
        return;
    L5:
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        this.pwdBoxStyleOptAnimator = r100;
        r100.setDuration(this.pwdBoxStyleOptDurationMs);
        this.pwdBoxStyleOptAnimator.setRepeatCount(-1);
        this.pwdBoxStyleOptAnimator.setInterpolator(new LinearInterpolator());
        this.pwdBoxStyleOptAnimator.addUpdateListener(new b(this));
        this.pwdBoxStyleOptAnimator.start();
    }

    private void stopPwdBoxStyleOptAnimator() {
        ValueAnimator r100 = this.pwdBoxStyleOptAnimator;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllUpdateListeners();
        this.pwdBoxStyleOptAnimator.cancel();
        this.pwdBoxStyleOptAnimator = null;
    }

    public void release() {
        ValueAnimator r100 = this.cursorAnimator;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        stopPwdBoxStyleOptAnimator();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.enablePwdBoxStyleOpt == false) goto L6;
        startPwdBoxStyleOptAnimatorIfNeeded();
    L6:
        if (this.isShowCursor == true) goto L8;
        return;
    L8:
        if (this.enablePwdBoxStyleOpt == true) goto L12;
        Paint r100 = new Paint();
        this.cursorPaint = r100;
        r100.setColor(this.cursorColor);
        this.cursorPaint.setStrokeWidth(this.cursorWidth);
        this.cursorVisible = true;
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.cursorBlinkInterval);
        this.cursorAnimator = r101;
        r101.setRepeatMode(2);
        this.cursorAnimator.setRepeatCount(-1);
        this.cursorAnimator.addUpdateListener(new AnonymousClass3(this));
        this.cursorAnimator.start();
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.cursorAnimator;
        if (r100 == null) goto L5;
        r100.removeAllUpdateListeners();
        this.cursorAnimator.cancel();
        this.cursorAnimator = null;
    L5:
        stopPwdBoxStyleOptAnimator();
    }

    public PwdEditTextNoiseReduction(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_input_PwdEditTextNoiseReduction_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ int access$000(PwdEditTextNoiseReduction r100) {
        return r100.mPreInputCount;
    }

    public static /* synthetic */ boolean access$200(PwdEditTextNoiseReduction r100) {
        return r100.isShowPwd;
    }

    public static /* synthetic */ int access$300(PwdEditTextNoiseReduction r100) {
        return r100.mCurInputCount;
    }

    public static /* synthetic */ boolean access$400(PwdEditTextNoiseReduction r100) {
        return r100.enablePwdBoxStyleOpt;
    }

    public static /* synthetic */ int access$500(PwdEditTextNoiseReduction r100) {
        return r100.mCount;
    }

    public static /* synthetic */ void access$600(PwdEditTextNoiseReduction r100) {
        r100.stopPwdBoxStyleOptAnimator();
    }

    public static /* synthetic */ void access$700(PwdEditTextNoiseReduction r100) {
        r100.startPwdBoxStyleOptAnimatorIfNeeded();
    }

    private float dp2Px(int r100) {
        return TypedValue.applyDimension(1, r100, INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_input_PwdEditTextNoiseReduction_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()));
    }

    private void drawActiveCellBorder(Canvas r110) {
        if (this.enablePwdBoxStyleOpt == true) goto L5;
        return;
    L5:
        int r100 = this.mCurInputCount;
        if (r100 >= this.mCount) goto L23;
        if (r100 < 0) goto L24;
        RectF r101 = this.boxes[r100];
        if (r101 != null) goto L12;
        return;
    L12:
        float r102 = this.pwdBoxStyleOptStrokeWidth * 0.5f;
        this.pwdBoxStyleOptRect.set(r101.left + r102, r101.top + r102, r101.right - r102, r101.bottom - r102);
        float r103 = Math.max(0.0f, this.strokeRadius - r102);
        this.pwdBoxStyleOptBasePaint.setStrokeWidth(this.pwdBoxStyleOptStrokeWidth);
        this.pwdBoxStyleOptBasePaint.setColor(this.pwdBoxStyleOptBaseColor);
        r110.drawRoundRect(this.pwdBoxStyleOptRect, r103, r103, this.pwdBoxStyleOptBasePaint);
        float r104 = this.pwdBoxStyleOptRect.centerY();
        if (this.pwdBoxStyleOptLinearGradient == null) goto L20;
        RectF r105 = this.pwdBoxStyleOptRect;
        if (r105.left != this.pwdBoxStyleOptLastLeft) goto L20;
        if (r105.right != this.pwdBoxStyleOptLastRight) goto L20;
        if (r104 != this.pwdBoxStyleOptLastCy) goto L20;
    L21:
        float r106 = this.pwdBoxStyleOptRect.centerX();
        this.pwdBoxStyleOptGradientMatrix.reset();
        this.pwdBoxStyleOptGradientMatrix.setRotate(this.pwdBoxStyleOptAngle, r106, r104);
        this.pwdBoxStyleOptLinearGradient.setLocalMatrix(this.pwdBoxStyleOptGradientMatrix);
        this.pwdBoxStyleOptGradientPaint.setStrokeWidth(this.pwdBoxStyleOptStrokeWidth);
        this.pwdBoxStyleOptGradientPaint.setShader(this.pwdBoxStyleOptLinearGradient);
        r110.drawRoundRect(this.pwdBoxStyleOptRect, r103, r103, this.pwdBoxStyleOptGradientPaint);
        this.pwdBoxStyleOptGradientPaint.setShader(null);
        return;
    L20:
        RectF r107 = this.pwdBoxStyleOptRect;
        this.pwdBoxStyleOptLastLeft = r107.left;
        this.pwdBoxStyleOptLastRight = r107.right;
        this.pwdBoxStyleOptLastCy = r104;
        int r108 = this.pwdBoxStyleOptGradientColor & 16777215;
        RectF r109 = this.pwdBoxStyleOptRect;
        this.pwdBoxStyleOptLinearGradient = new LinearGradient(r109.left, r104, r109.right, r104, new int[]{this.pwdBoxStyleOptGradientColor, r108}, null, Shader.TileMode.CLAMP);
        goto L21
    L24:
        return;
    }

    private void drawCursor(Canvas r110) {
        if (this.enablePwdBoxStyleOpt == false) goto L6;
        return;
    L6:
        if (this.isShowCursor == true) goto L9;
        return;
    L9:
        if (this.cursorVisible == false) goto L12;
        float r100 = this.cellWidth;
        float r101 = (((this.strokeSpace + r100) * this.mCurInputCount) + (r100 / 2.0f)) + this.padding;
        getBaseline();
        int r102 = this.mHeight;
        float r103 = this.cursorHeight;
        r110.drawLine(r101, (r102 / 2) - (r103 / 2.0f), r101, (r102 / 2) + (r103 / 2.0f), this.cursorPaint);
        return;
    }

    private void drawPwdDot(Canvas r100) {
        float r101 = this.padding;
        int r102 = 0;
    L3:
        int r103 = this.mCurInputCount;
        if (r102 >= r103) goto L16;
        if (r102 <= 0) goto L8;
        r101 = (r101 + this.cellWidth) + this.strokeSpace;
    L8:
        if (r102 == r103) goto L10;
        r100.drawCircle((this.cellWidth / 2.0f) + r101, this.mHeight / 2, this.pwdDotRadius, this.pwdDotPaint);
    L15:
        r102 = r102 + 1;
        goto L3
    L10:
        if (this.isDrawDotPaint == false) goto L12;
    L13:
        r100.drawCircle((this.cellWidth / 2.0f) + r101, this.mHeight / 2, this.pwdDotRadius, this.pwdDotPaint);
        this.isDrawDotPaint = !this.isShowPwd;
        goto L15
    L12:
        if (this.mCurInputCount >= this.mPreInputCount) goto L15;
    }

    private void drawStroke(Canvas r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mCount) goto L6;
        float r102 = this.padding;
        float r103 = this.cellWidth;
        float r104 = (r102 + (r101 * (this.strokeSpace + r103))) + this.boxOffsets[r101];
        RectF r105 = this.boxes[r101];
        r105.left = r104;
        r105.right = r104 + r103;
        r105.top = 0.0f;
        r105.bottom = this.mHeight;
        float r106 = this.strokeRadius;
        r100.drawRoundRect(r105, r106, r106, this.strokePaint);
        r101 = r101 + 1;
        goto L4
    }

    private /* synthetic */ void lambda$shakeBoxTogether$1(ValueAnimator r100) {
        float r101 = ((Float) r100.getAnimatedValue()).floatValue();
        int r102 = 0;
    L4:
        if (r102 >= this.mCount) goto L6;
        this.boxOffsets[r102] = r101;
        r102 = r102 + 1;
        goto L4
    L6:
        invalidate();
    }

    private /* synthetic */ void lambda$startPwdBoxStyleOptAnimatorIfNeeded$0(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Float) == false) goto L6;
        this.pwdBoxStyleOptAngle = ((Float) r101).floatValue();
        invalidate();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        drawStroke(r100);
        drawActiveCellBorder(r100);
        drawPwdDot(r100);
        drawCursor(r100);
    }

    public void setCellFixedWidth(boolean r100) {
        this.cellFixedWidth = r100;
    }

    public void setCellWidth(float r100) {
        this.cellWidth = r100;
    }

    public void setCursorColor(int r100) {
        this.cursorColor = r100;
        Paint r101 = this.cursorPaint;
        if (r101 == null) goto L5;
        r101.setColor(r100);
    L5:
        invalidate();
    }

    public void setLeftAndRightPwdPadding(int r100) {
        this.padding = r100;
    }

    public void setPwdBoxStyleOptEnabled(boolean r100) {
        this.enablePwdBoxStyleOpt = r100;
        if (r100 == false) goto L7;
        ValueAnimator r101 = this.cursorAnimator;
        if (r101 == null) goto L7;
        r101.removeAllUpdateListeners();
        this.cursorAnimator.cancel();
        this.cursorAnimator = null;
        this.cursorVisible = false;
    L7:
        if (r100 == false) goto L10;
        startPwdBoxStyleOptAnimatorIfNeeded();
        invalidate();
        return;
    }

    public void setPwdDotColor(int r100) {
        this.pwdDotColor = r100;
        Paint r101 = this.pwdDotPaint;
        if (r101 == null) goto L5;
        r101.setColor(r100);
    L5:
        Paint r102 = this.digitalPaint;
        if (r102 == null) goto L8;
        r102.setColor(r100);
    L8:
        invalidate();
    }

    public void setStrokeColor(int r100) {
        this.strokeColor = r100;
        Paint r101 = this.strokePaint;
        if (r101 == null) goto L5;
        r101.setColor(r100);
    L5:
        invalidate();
    }

    public void setStrokeSpace(float r100) {
        this.strokeSpace = r100;
    }

    public PwdEditTextNoiseReduction(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.STYLE_RECTANGLE = 0;
        this.STYLE_ROUND_RECTANGLE = 1;
        this.DEFAULT_STYLE = 0;
        this.DEFAULT_PWD_COUNT = 6;
        this.DEFAULT_STROKE_RADIUS = dp2Px(6);
        this.DEFAULT_STROKE_WIDTH = dp2Px(1);
        this.DEFAULT_STROKE_COLOR = ColorProtector.parseColor("#cecece");
        this.DEFAULT_DOT_COLOR = ColorProtector.parseColor("#2c2f36");
        this.DEFAULT_DOT_RADIUS = dp2Px(6);
        this.DEFAULT_STROKE_STYLE = Paint.Style.FILL.ordinal();
        this.DEFAULT_SHOW_CURSOR = false;
        this.DEFAULT_CURSOR_COLOR = ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED);
        this.DEFAULT_CURSOR_WIDTH = dp2Px(2);
        this.DEFAULT_CURSOR_HEIGHT = dp2Px(20);
        this.DEFAULT_CURSOR_BLINK_INTERVAL = 500;
        this.DEFAULT_PWD_BOX_STYLE_OPT_ENABLE = false;
        this.DEFAULT_PWD_BOX_STYLE_OPT_DURATION_MS = 3800;
        float r102 = dp2Px(1);
        this.DEFAULT_PWD_BOX_STYLE_OPT_STROKE_WIDTH = r102;
        int r103 = ColorProtector.parseColor("#B3467BFB");
        this.DEFAULT_PWD_BOX_STYLE_OPT_BASE_COLOR = r103;
        int r104 = ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_STROKE_RED);
        this.DEFAULT_PWD_BOX_STYLE_OPT_GRADIENT_COLOR = r104;
        this.strokeSpace = dp2Px(8);
        this.isShowPwd = false;
        this.isDrawDotPaint = true;
        this.enablePwdBoxStyleOpt = false;
        this.pwdBoxStyleOptDurationMs = 3800;
        this.pwdBoxStyleOptStrokeWidth = r102;
        this.pwdBoxStyleOptBaseColor = r103;
        this.pwdBoxStyleOptGradientColor = r104;
        this.pwdBoxStyleOptRect = new RectF();
        this.pwdBoxStyleOptGradientMatrix = new Matrix();
        this.pwdBoxStyleOptLastLeft = Float.NaN;
        this.pwdBoxStyleOptLastRight = Float.NaN;
        this.pwdBoxStyleOptLastCy = Float.NaN;
        this.pwdBoxStyleOptAngle = 0.0f;
        this.padding = 0;
        initAttrs(r100, r101);
        init();
    }

    public static /* synthetic */ int access$002(PwdEditTextNoiseReduction r100, int r101) {
        r100.mPreInputCount = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(PwdEditTextNoiseReduction r100, boolean r101) {
        r100.isDrawDotPaint = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(PwdEditTextNoiseReduction r100, int r101) {
        r100.mCurInputCount = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$802(PwdEditTextNoiseReduction r100, boolean r101) {
        r100.cursorVisible = r101;
        return r101;
    }

    private void initAttrs(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayCellSpace, R.attr.CJPayDotColor, R.attr.CJPayDotRadius, R.attr.CJPayIsCursorBlinkInterval, R.attr.CJPayIsCursorColor, R.attr.CJPayIsCursorHeight, R.attr.CJPayIsCursorWidth, R.attr.CJPayIsShowCursor, R.attr.CJPayIsShowPwd, R.attr.CJPayPwdBoxStyleOptBaseColor, R.attr.CJPayPwdBoxStyleOptDuration, R.attr.CJPayPwdBoxStyleOptEnable, R.attr.CJPayPwdBoxStyleOptGradientColor, R.attr.CJPayPwdBoxStyleOptStrokeWidth, R.attr.CJPayPwdCount, R.attr.CJPayPwdEditShapeStyle, R.attr.CJPayStrokeColor, R.attr.CJPayStrokeRadius, R.attr.CJPayStrokeStyle, R.attr.CJPayStrokeWidth});
        this.style = r102.getInt(15, 0);
        this.mCount = r102.getInt(14, 6);
        this.strokeColor = r102.getColor(16, this.DEFAULT_STROKE_COLOR);
        this.strokeWidth = r102.getDimension(19, this.DEFAULT_STROKE_WIDTH);
        this.strokeRadius = r102.getDimension(17, this.DEFAULT_STROKE_RADIUS);
        this.strokeStyle = Paint.Style.values()[r102.getInt(18, this.DEFAULT_STROKE_STYLE)];
        this.pwdDotColor = r102.getColor(1, this.DEFAULT_DOT_COLOR);
        this.pwdDotRadius = r102.getDimension(2, this.DEFAULT_DOT_RADIUS);
        this.isShowPwd = r102.getBoolean(8, false);
        this.isShowCursor = r102.getBoolean(7, false);
        this.cursorColor = r102.getColor(4, this.DEFAULT_CURSOR_COLOR);
        this.cursorWidth = r102.getDimension(6, this.DEFAULT_CURSOR_WIDTH);
        this.cursorHeight = r102.getDimension(5, this.DEFAULT_CURSOR_HEIGHT);
        this.cursorBlinkInterval = r102.getInt(3, 500);
        this.enablePwdBoxStyleOpt = r102.getBoolean(11, false);
        this.pwdBoxStyleOptStrokeWidth = r102.getDimension(13, this.DEFAULT_PWD_BOX_STYLE_OPT_STROKE_WIDTH);
        this.pwdBoxStyleOptBaseColor = r102.getColor(9, this.DEFAULT_PWD_BOX_STYLE_OPT_BASE_COLOR);
        this.pwdBoxStyleOptGradientColor = r102.getColor(12, this.DEFAULT_PWD_BOX_STYLE_OPT_GRADIENT_COLOR);
        this.pwdBoxStyleOptDurationMs = r102.getInt(10, 3800);
        this.isDrawDotPaint = !this.isShowPwd;
        r102.recycle();
        int r103 = this.mCount;
        this.boxes = new RectF[r103];
        this.boxOffsets = new float[r103];
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 66) goto L7;
        return false;
    L7:
        return super.onKeyDown(r100, r101);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.cellFixedWidth == false) goto L6;
        float r102 = this.cellWidth;
        int r103 = this.mCount;
        int r104 = (int) ((((r103 * r102) + this.strokeWidth) + (this.strokeSpace * (r103 - 1))) + (this.padding * 2));
        this.mWidth = r104;
        int r105 = (int) r102;
        this.mHeight = r105;
        setMeasuredDimension(r104, r105);
        return;
    }

    public PwdEditTextNoiseReduction(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.STYLE_RECTANGLE = 0;
        this.STYLE_ROUND_RECTANGLE = 1;
        this.DEFAULT_STYLE = 0;
        this.DEFAULT_PWD_COUNT = 6;
        this.DEFAULT_STROKE_RADIUS = dp2Px(6);
        this.DEFAULT_STROKE_WIDTH = dp2Px(1);
        this.DEFAULT_STROKE_COLOR = ColorProtector.parseColor("#cecece");
        this.DEFAULT_DOT_COLOR = ColorProtector.parseColor("#2c2f36");
        this.DEFAULT_DOT_RADIUS = dp2Px(6);
        this.DEFAULT_STROKE_STYLE = Paint.Style.FILL.ordinal();
        this.DEFAULT_SHOW_CURSOR = false;
        this.DEFAULT_CURSOR_COLOR = ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED);
        this.DEFAULT_CURSOR_WIDTH = dp2Px(2);
        this.DEFAULT_CURSOR_HEIGHT = dp2Px(20);
        this.DEFAULT_CURSOR_BLINK_INTERVAL = 500;
        this.DEFAULT_PWD_BOX_STYLE_OPT_ENABLE = false;
        this.DEFAULT_PWD_BOX_STYLE_OPT_DURATION_MS = 3800;
        float r103 = dp2Px(1);
        this.DEFAULT_PWD_BOX_STYLE_OPT_STROKE_WIDTH = r103;
        int r104 = ColorProtector.parseColor("#B3467BFB");
        this.DEFAULT_PWD_BOX_STYLE_OPT_BASE_COLOR = r104;
        int r105 = ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_STROKE_RED);
        this.DEFAULT_PWD_BOX_STYLE_OPT_GRADIENT_COLOR = r105;
        this.strokeSpace = dp2Px(8);
        this.isShowPwd = false;
        this.isDrawDotPaint = true;
        this.enablePwdBoxStyleOpt = false;
        this.pwdBoxStyleOptDurationMs = 3800;
        this.pwdBoxStyleOptStrokeWidth = r103;
        this.pwdBoxStyleOptBaseColor = r104;
        this.pwdBoxStyleOptGradientColor = r105;
        this.pwdBoxStyleOptRect = new RectF();
        this.pwdBoxStyleOptGradientMatrix = new Matrix();
        this.pwdBoxStyleOptLastLeft = Float.NaN;
        this.pwdBoxStyleOptLastRight = Float.NaN;
        this.pwdBoxStyleOptLastCy = Float.NaN;
        this.pwdBoxStyleOptAngle = 0.0f;
        this.padding = 0;
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.mWidth = r100;
        this.mHeight = r101;
        if (this.cellFixedWidth == true) goto L8;
        int r104 = this.mCount;
        if (r104 <= 1) goto L9;
        this.cellWidth = ((r100 - this.strokeWidth) - (this.strokeSpace * (r104 - 1))) / r104;
        return;
    L9:
        return;
    }
}
