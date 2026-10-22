package com.android.ttcjpaysdk.thirdparty.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.ui.component.input.BasePwdEditText;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayPwdEditText extends BasePwdEditText {
    public static String CJPayPwdEditTextCusorDefaultColor = "#FE2C55";
    private final int DEFAULT_DOT_COLOR;
    private final float DEFAULT_DOT_RADIUS;
    private final int DEFAULT_PWD_COUNT;
    private final int DEFAULT_STROKE_COLOR;
    private final float DEFAULT_STROKE_RADIUS;
    private final float DEFAULT_STROKE_WIDTH;
    private final int DEFAULT_STYLE;
    private final int STYLE_RECTANGLE;
    private float cellWidth;
    private Paint digitalPaint;
    private float halfStrokeWidth;
    private Paint inputCursor;
    private String inputCursorColor;
    private volatile boolean isDrawDotPaint;
    private volatile boolean isDrawInputCursor;
    private volatile boolean isShowPwd;
    private int mCount;
    private int mCurInputCount;
    private int mHeight;
    private int mPreInputCount;
    private int mWidth;
    private OnTextChangedListener onTextChangedListener;
    private int pwdDotColor;
    private Paint pwdDotPaint;
    private float pwdDotRadius;
    private int strokeColor;
    private Paint strokePaint;
    private float strokeRadius;
    private float strokeWidth;
    private int style;

    public interface OnTextChangedListener {
        void afterTextChanged(Editable r100);

        void beforeTextChanged(CharSequence r100, int r101, int r102, int r103);

        void onTextChanged(CharSequence r100, int r101, int r102, int r103);
    }

    private void init() {
        Paint r100 = new Paint(1);
        this.strokePaint = r100;
        r100.setColor(this.strokeColor);
        this.strokePaint.setStrokeWidth(this.strokeWidth);
        this.strokePaint.setStyle(Paint.Style.STROKE);
        Paint r101 = new Paint(1);
        this.pwdDotPaint = r101;
        r101.setStyle(Paint.Style.FILL);
        this.pwdDotPaint.setColor(this.pwdDotColor);
        Paint r102 = new Paint(1);
        this.digitalPaint = r102;
        r102.setStyle(Paint.Style.STROKE);
        this.digitalPaint.setColor(this.pwdDotColor);
        this.digitalPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.digitalPaint.setTextSize(CJPayBasicUtils.dipToPX(getContext(), 32.0f));
        Paint r103 = new Paint(1);
        this.inputCursor = r103;
        r103.setColor(Color.parseColor(this.inputCursorColor));     // Catch: Exception -> L5
    L7:
        this.digitalPaint.setStyle(Paint.Style.FILL);
        this.halfStrokeWidth = this.strokeWidth / 2.0f;
        setCursorVisible(false);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.mCount)});
        setBackgroundColor(-1);
        setMaxLines(1);
        setFocusable(false);
        addTextChangedListener(new AnonymousClass1(this));
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayPwdEditText#init", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayPwdEditText#init", e);
        this.inputCursor.setColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        goto L7
    }

    public Activity getActivityFromView() {
        Context r100 = getContext();
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L10;
        if ((r100 instanceof Activity) == true) goto L8;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L4
    L8:
        return (Activity) r100;
    L10:
        return null;
    }

    public CJPayPwdEditText(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_view_CJPayPwdEditText_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ OnTextChangedListener access$000(CJPayPwdEditText r100) {
        return r100.onTextChangedListener;
    }

    public static /* synthetic */ int access$100(CJPayPwdEditText r100) {
        return r100.mPreInputCount;
    }

    public static /* synthetic */ boolean access$300(CJPayPwdEditText r100) {
        return r100.isShowPwd;
    }

    public static /* synthetic */ int access$400(CJPayPwdEditText r100) {
        return r100.mCurInputCount;
    }

    public static /* synthetic */ int access$500(CJPayPwdEditText r100) {
        return r100.mCount;
    }

    public static /* synthetic */ BasePwdEditText.OnTextInputListener access$600(CJPayPwdEditText r100) {
        return r100.onTextInputListener;
    }

    public static /* synthetic */ BasePwdEditText.OnTextInputListener access$700(CJPayPwdEditText r100) {
        return r100.onTextInputListener;
    }

    private float dp2Px(int r100) {
        return TypedValue.applyDimension(1, r100, INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_view_CJPayPwdEditText_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()));
    }

    private void drawPwdDot(Canvas r100) {
        int r101 = 1;
    L3:
        int r102 = this.mCurInputCount;
        if (r101 > r102) goto L16;
        if (r101 == r102) goto L7;
        float r103 = this.halfStrokeWidth;
        float r104 = this.cellWidth;
        r100.drawCircle((r103 + (r104 / 2.0f)) + (r104 * (r101 - 1)), this.mHeight / 2, this.pwdDotRadius, this.pwdDotPaint);
    L14:
        r101 = r101 + 1;
        goto L3
    L7:
        if (this.isDrawDotPaint == false) goto L9;
    L12:
        float r105 = this.halfStrokeWidth;
        float r106 = this.cellWidth;
        r100.drawCircle((r105 + (r106 / 2.0f)) + (r106 * (r101 - 1)), this.mHeight / 2, this.pwdDotRadius, this.pwdDotPaint);
        this.isDrawDotPaint = !this.isShowPwd;
        goto L14
    L9:
        if (this.mCurInputCount < this.mPreInputCount) goto L12;
        int r107 = r101 - 1;
        String r108 = getText().subSequence(r107, r101).toString();
        float r109 = this.halfStrokeWidth;
        float r110 = this.cellWidth;
        r100.drawText(r108, (r109 + (r110 / 3.0f)) + (r110 * r107), (this.mHeight / 2) + CJPayBasicUtils.dipToPX(getContext(), 12.0f), this.digitalPaint);
        goto L14
    L16:
        if (this.isDrawInputCursor == true) goto L18;
        return;
    L18:
        if (this.mCurInputCount >= this.mCount) goto L26;
        r100.drawRoundRect(new RectF(((this.halfStrokeWidth + (this.cellWidth / 2.0f)) - CJPayBasicUtils.dipToPX(getContext(), 1.0f)) + (this.cellWidth * this.mCurInputCount), (this.mHeight / 2) - CJPayBasicUtils.dipToPX(getContext(), 10.0f), ((this.halfStrokeWidth + (this.cellWidth / 2.0f)) + CJPayBasicUtils.dipToPX(getContext(), 1.0f)) + (this.cellWidth * this.mCurInputCount), (this.mHeight / 2) + CJPayBasicUtils.dipToPX(getContext(), 10.0f)), CJPayBasicUtils.dipToPX(getContext(), 1.0f), CJPayBasicUtils.dipToPX(getContext(), 1.0f), this.inputCursor);
        return;
    }

    private void drawStroke(Canvas r100) {
        if (this.style != 0) goto L5;
        float r101 = this.halfStrokeWidth;
        r100.drawRect(r101, r101, this.mWidth - r101, this.mHeight - r101, this.strokePaint);
        return;
    L5:
        float r102 = this.halfStrokeWidth;
        RectF r103 = new RectF(r102, r102, this.mWidth - r102, this.mHeight - r102);
        float r104 = this.strokeRadius;
        r100.drawRoundRect(r103, r104, r104, this.strokePaint);
    }

    private void drawVerticalDivder(Canvas r100) {
        int r101 = 1;
        if (this.mCount != 1) goto L6;
        return;
    L6:
        if (r101 >= this.mCount) goto L8;
        float r102 = this.halfStrokeWidth;
        float r103 = this.cellWidth;
        float r104 = r101;
        r100.drawLine((r103 * r104) + r102, r102, r102 + (r103 * r104), this.mHeight - r102, this.strokePaint);
        r101 = r101 + 1;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        drawStroke(r100);
        drawVerticalDivder(r100);
        drawPwdDot(r100);
    }

    public CJPayPwdEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.STYLE_RECTANGLE = 0;
        this.DEFAULT_STYLE = 0;
        this.DEFAULT_PWD_COUNT = 6;
        this.DEFAULT_STROKE_RADIUS = dp2Px(6);
        this.DEFAULT_STROKE_WIDTH = dp2Px(1);
        this.DEFAULT_STROKE_COLOR = ColorProtector.parseColor("#cecece");
        this.DEFAULT_DOT_COLOR = ColorProtector.parseColor("#2c2f36");
        this.DEFAULT_DOT_RADIUS = dp2Px(6);
        this.isShowPwd = false;
        this.isDrawDotPaint = true;
        this.isDrawInputCursor = false;
        this.inputCursorColor = CJPayPwdEditTextCusorDefaultColor;
        initAttrs(r100, r101);
        init();
    }

    public static /* synthetic */ int access$102(CJPayPwdEditText r100, int r101) {
        r100.mPreInputCount = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(CJPayPwdEditText r100, boolean r101) {
        r100.isDrawDotPaint = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(CJPayPwdEditText r100, int r101) {
        r100.mCurInputCount = r101;
        return r101;
    }

    private void initAttrs(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayCellSpace, R.attr.CJPayDotColor, R.attr.CJPayDotRadius, R.attr.CJPayIsCursorBlinkInterval, R.attr.CJPayIsCursorColor, R.attr.CJPayIsCursorHeight, R.attr.CJPayIsCursorWidth, R.attr.CJPayIsShowCursor, R.attr.CJPayIsShowPwd, R.attr.CJPayPwdBoxStyleOptBaseColor, R.attr.CJPayPwdBoxStyleOptDuration, R.attr.CJPayPwdBoxStyleOptEnable, R.attr.CJPayPwdBoxStyleOptGradientColor, R.attr.CJPayPwdBoxStyleOptStrokeWidth, R.attr.CJPayPwdCount, R.attr.CJPayPwdEditShapeStyle, R.attr.CJPayStrokeColor, R.attr.CJPayStrokeRadius, R.attr.CJPayStrokeStyle, R.attr.CJPayStrokeWidth});
        this.style = r102.getInt(15, 0);
        this.mCount = r102.getInt(14, 6);
        this.strokeColor = r102.getColor(16, this.DEFAULT_STROKE_COLOR);
        this.strokeWidth = r102.getDimension(19, this.DEFAULT_STROKE_WIDTH);
        this.strokeRadius = r102.getDimension(17, this.DEFAULT_STROKE_RADIUS);
        this.pwdDotColor = r102.getColor(1, this.DEFAULT_DOT_COLOR);
        this.pwdDotRadius = r102.getDimension(2, this.DEFAULT_DOT_RADIUS);
        this.isShowPwd = r102.getBoolean(8, false);
        this.isDrawDotPaint = !this.isShowPwd;
        r102.recycle();
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 66) goto L7;
        return false;
    L7:
        return super.onKeyDown(r100, r101);
    }

    public CJPayPwdEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.STYLE_RECTANGLE = 0;
        this.DEFAULT_STYLE = 0;
        this.DEFAULT_PWD_COUNT = 6;
        this.DEFAULT_STROKE_RADIUS = dp2Px(6);
        this.DEFAULT_STROKE_WIDTH = dp2Px(1);
        this.DEFAULT_STROKE_COLOR = ColorProtector.parseColor("#cecece");
        this.DEFAULT_DOT_COLOR = ColorProtector.parseColor("#2c2f36");
        this.DEFAULT_DOT_RADIUS = dp2Px(6);
        this.isShowPwd = false;
        this.isDrawDotPaint = true;
        this.isDrawInputCursor = false;
        this.inputCursorColor = CJPayPwdEditTextCusorDefaultColor;
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.mWidth = r100;
        this.mHeight = r101;
        this.cellWidth = (r100 - this.strokeWidth) / this.mCount;
    }
}
