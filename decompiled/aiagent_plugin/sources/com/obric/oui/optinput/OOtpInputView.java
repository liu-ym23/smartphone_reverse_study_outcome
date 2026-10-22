package com.obric.oui.optinput;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: OOtpInputView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OOtpInputView extends View {
    private static final float CIRCLE_RADIUS = 4.0f;
    private static final float CURSOR_HEIGHT_FACTOR = 0.375f;
    private static final float CURSOR_WIDTH = 2.0f;
    public static final a Companion = null;
    private static final long DEFAULT_BLINK_INTERVAL = 500;
    private static final float DEFAULT_CELL_HEIGHT_DP = 48.0f;
    private static final float DEFAULT_CELL_RADIUS_DP = 10.0f;
    private static final float DEFAULT_CELL_SPACING_DP = 12.0f;
    private static final float DEFAULT_CELL_STROKE_DP = 1.0f;
    private static final float DEFAULT_CELL_WIDTH_DP = 42.0f;
    public static final int DEFAULT_CODE_LENGTH = 6;
    private static final float DEFAULT_TEXT_SIZE_SP = 20.0f;
    private static final char EMPTY_CHAR = 0;
    public static final int MAX_CODE_LENGTH = 6;
    public static final int MIN_CODE_LENGTH = 1;
    private float actualCellSpacing;
    private boolean blinkStarted;
    private final Paint boxPaintFill;
    private final Paint boxPaintStroke;
    private int cellBackgroundColor;
    private float cellCenterY;
    private float cellCornerRadius;
    private float cellHeight;
    private final RectF cellRect;
    private float cellSpacing;
    private int cellStrokeColor;
    private float cellStrokeWidth;
    private float cellWidth;
    private float cellsStartX;
    private float cellsTop;
    private char[] codeChars;
    private int codeLength;
    private boolean cursorBlinkOn;
    private final d cursorBlinkRunnable;
    private int cursorColor;
    private float cursorHalfWidth;
    private final Paint cursorPaint;
    private boolean cursorVisible;
    private int inputIndex;
    private b onCodeChangeListener;
    private c onCodeCompleteListener;
    private final char[] oneCharArray;
    private float passwordCircleRadius;
    private boolean passwordMode;
    private float textCenterYOffset;
    private int textColor;
    private final Paint.FontMetrics textFontMetrics;
    private final Paint textPaint;
    private float textSizePx;

    /* JADX INFO: compiled from: OOtpInputView.kt */
    private static final class OtpInputConnection extends BaseInputConnection {
        private final OOtpInputView view;

        public OtpInputConnection(OOtpInputView r3) {
            o.e(r3, "view");
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), false);
            this.view = r3;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence r2, int r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == false) goto L11;
            return true;
        L11:
            this.view.commitTextFromIme$OUI_standardRelease(r4);
            return true;
        L5:
            if (r4.length() == 0) goto L8;
            r0 = false;
            goto L9
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int r2, int r3) {
            if (this.view.handleDeleteFromIme$OUI_standardRelease() == false) goto L6;
            return true;
        L6:
            return super.deleteSurroundingText(r2, r3);
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent r4) {
            o.e(r4, "event");
            if (r4.getAction() != 0) goto L14;
            if (r4.getKeyCode() == 67) goto L7;
            char r0 = (char) r4.getUnicodeChar();
            if (Character.isDigit(r0) == false) goto L14;
            this.view.commitTextFromIme$OUI_standardRelease((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r0), CharSequence.class, "com.obric.aiagent.plugin"));
            return true;
        L7:
            if (this.view.handleDeleteFromIme$OUI_standardRelease() == false) goto L14;
            return true;
        L14:
            return super.sendKeyEvent(r4);
        }
    }

    /* JADX INFO: compiled from: OOtpInputView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OOtpInputView.kt */
    public interface b {
        void a(String r1);
    }

    /* JADX INFO: compiled from: OOtpInputView.kt */
    public interface c {
        void a(String r1);
    }

    /* JADX INFO: compiled from: OOtpInputView.kt */
    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OOtpInputView f35507a;

        d(OOtpInputView r1) {
            this.f35507a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OOtpInputView.access$getBlinkStarted$p(this.f35507a) == true) goto L5;
            return;
        L5:
            OOtpInputView r0 = this.f35507a;
            OOtpInputView.access$setCursorBlinkOn$p(r0, !OOtpInputView.access$getCursorBlinkOn$p(r0));
            this.f35507a.invalidate();
            this.f35507a.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"), 500);
        }
    }

    static {
        Companion = new a(null);
    }

    public OOtpInputView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OOtpInputView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    public /* synthetic */ OOtpInputView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ boolean access$getBlinkStarted$p(OOtpInputView r0) {
        return r0.blinkStarted;
    }

    public static final /* synthetic */ boolean access$getCursorBlinkOn$p(OOtpInputView r0) {
        return r0.cursorBlinkOn;
    }

    public static final /* synthetic */ void access$setCursorBlinkOn$p(OOtpInputView r0, boolean r1) {
        r0.cursorBlinkOn = r1;
    }

    public OOtpInputView(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        super(r14, r15, r13);
        this.codeLength = 6;
        this.codeChars = new char[6];
        Paint r3 = new Paint(1);
        this.boxPaintFill = r3;
        Paint r5 = new Paint(1);
        this.boxPaintStroke = r5;
        Paint r6 = new Paint(1);
        this.textPaint = r6;
        Paint r7 = new Paint(1);
        this.cursorPaint = r7;
        this.cellRect = new RectF();
        this.textFontMetrics = new Paint.FontMetrics();
        this.oneCharArray = new char[1];
        this.cursorBlinkOn = true;
        this.cursorBlinkRunnable = new d(this);
        refreshDimensionCache();
        this.cellWidth = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DEFAULT_CELL_WIDTH_DP);
        this.cellHeight = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DEFAULT_CELL_HEIGHT_DP);
        this.cellSpacing = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12.0f);
        this.cellCornerRadius = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10.0f);
        this.cellStrokeWidth = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DEFAULT_CELL_STROKE_DP);
        this.textSizePx = g.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20.0f);
        this.cellBackgroundColor = androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.oui_advanced_fill_list_item_card, "color", "oui_advanced_fill_list_item_card"));
        this.cellStrokeColor = androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.oui_advanced_fill_list_item_card, "color", "oui_advanced_fill_list_item_card"));
        this.textColor = androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"));
        this.cursorColor = androidx.core.content.a.c(r14, ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, "color", "oui_functional_blue_6"));
        this.passwordMode = false;
        this.cursorVisible = true;
        if (r15 == null) goto L10;
        TypedArray r16 = r14.obtainStyledAttributes(r15, R.styleable.OOtpInputView, r13, 0);
        o.c(r16, "context.obtainStyledAttr…putView, defStyleAttr, 0)");
        applyCodeLengthFromAttribute(r16.getInt(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCodeLength, "styleable", "OOtpInputView_o_otpCodeLength"), 6));     // Catch: Throwable -> L7
        this.cellWidth = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellWidth, "styleable", "OOtpInputView_o_otpCellWidth"), this.cellWidth);     // Catch: Throwable -> L7
        this.cellHeight = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellHeight, "styleable", "OOtpInputView_o_otpCellHeight"), this.cellHeight);     // Catch: Throwable -> L7
        this.cellSpacing = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellSpacing, "styleable", "OOtpInputView_o_otpCellSpacing"), this.cellSpacing);     // Catch: Throwable -> L7
        this.cellCornerRadius = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellCornerRadius, "styleable", "OOtpInputView_o_otpCellCornerRadius"), this.cellCornerRadius);     // Catch: Throwable -> L7
        this.cellStrokeWidth = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellStrokeWidth, "styleable", "OOtpInputView_o_otpCellStrokeWidth"), this.cellStrokeWidth);     // Catch: Throwable -> L7
        this.cellBackgroundColor = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellBackgroundColor, "styleable", "OOtpInputView_o_otpCellBackgroundColor"), this.cellBackgroundColor);     // Catch: Throwable -> L7
        this.cellStrokeColor = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellStrokeColor, "styleable", "OOtpInputView_o_otpCellStrokeColor"), this.cellStrokeColor);     // Catch: Throwable -> L7
        this.textColor = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpTextColor, "styleable", "OOtpInputView_o_otpTextColor"), this.textColor);     // Catch: Throwable -> L7
        this.textSizePx = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpTextSize, "styleable", "OOtpInputView_o_otpTextSize"), this.textSizePx);     // Catch: Throwable -> L7
        this.cursorColor = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCursorColor, "styleable", "OOtpInputView_o_otpCursorColor"), this.cursorColor);     // Catch: Throwable -> L7
        this.passwordMode = r16.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpPasswordMode, "styleable", "OOtpInputView_o_otpPasswordMode"), this.passwordMode);     // Catch: Throwable -> L7
        this.cursorVisible = r16.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCursorVisible, "styleable", "OOtpInputView_o_otpCursorVisible"), this.cursorVisible);     // Catch: Throwable -> L7
        r16.recycle();
    L7:
        th = move-exception;
        r16.recycle();
        throw th;
    L10:
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        r3.setStyle(Paint.Style.FILL);
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeWidth(this.cellStrokeWidth);
        r6.setColor(this.textColor);
        r6.setTextSize(this.textSizePx);
        r6.setTextAlign(Paint.Align.CENTER);
        if (Build.VERSION.SDK_INT < 28) goto L13;
        Typeface r17 = Typeface.create(Typeface.DEFAULT, 400, false);
    L14:
        r6.setTypeface(r17);
        r7.setColor(this.cursorColor);
        r7.setStyle(Paint.Style.FILL);
        updateTextMetrics();
        return;
    L13:
        r17 = Typeface.create(Typeface.DEFAULT, 0);
        goto L14
    }

    public final c getOnCodeCompleteListener() {
        return this.onCodeCompleteListener;
    }

    public final void setOnCodeCompleteListener(c r3) {
        this.onCodeCompleteListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    public final b getOnCodeChangeListener() {
        return this.onCodeChangeListener;
    }

    public final void setOnCodeChangeListener(b r3) {
        this.onCodeChangeListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    public final void setCodeLength(int r6) {
        int r7 = n.a(r6, 1, 6);
        if (r7 != this.codeLength) goto L5;
        return;
    L5:
        this.codeLength = r7;
        char[] r0 = this.codeChars;
        this.codeChars = new char[r7];
        int r8 = Math.min(r0.length, r7);
        int r1 = 0;
    L6:
        if (r1 >= r8) goto L8;
        this.codeChars[r1] = r0[r1];
        r1 = r1 + 1;
        goto L6
    L8:
        this.inputIndex = findFirstEmptyIndex();
        requestLayout();
        invalidate();
    }

    public final int getCodeLength() {
        return this.codeLength;
    }

    public final String getCode() {
        StringBuilder r0 = new StringBuilder(this.codeLength);
        int r1 = this.codeLength;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L7;
        int r3 = r2 + 1;
        char r4 = this.codeChars[r2];
        if (r4 == 0) goto L7;
        r0.append(r4);
        r2 = r3;
    L7:
        String r5 = r0.toString();
        o.c(r5, "builder.toString()");
        return r5;
    }

    public final void setCode(String r5) {
        boolean r0 = true;
        clearInternal(true);
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        if (r0 == false) goto L11;
        invalidate();
        return;
    L11:
        int r3 = 0;
    L13:
        if (r2 >= r5.length()) goto L21;
        char r4 = r5.charAt(r2);
        r2 = r2 + 1;
        if (Character.isDigit(r4) == false) goto L13;
        if (r3 >= this.codeLength) goto L21;
        this.codeChars[r3] = r4;
        r3 = r3 + 1;
    L21:
        this.inputIndex = r3;
        notifyCodeChanged();
        invalidate();
        if (isCodeComplete() == false) goto L31;
        notifyCodeComplete();
        return;
    L31:
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r0 = false;
        goto L8
    }

    public final void clear() {
        clearInternal(false);
    }

    public final void setPasswordMode(boolean r2) {
        if (this.passwordMode != r2) goto L5;
        return;
    L5:
        this.passwordMode = r2;
        invalidate();
        restartInput();
    }

    public final boolean isPasswordMode() {
        return this.passwordMode;
    }

    public final void setCursorVisible(boolean r2) {
        if (this.cursorVisible != r2) goto L5;
        return;
    L5:
        this.cursorVisible = r2;
        if (r2 == true) goto L9;
        stopBlink();
    L11:
        invalidate();
        return;
    L9:
        if (hasFocus() == false) goto L11;
        startBlink();
        goto L11
    }

    public final void setCursorColor(int r2) {
        if (this.cursorColor != r2) goto L5;
        return;
    L5:
        this.cursorColor = r2;
        this.cursorPaint.setColor(r2);
        invalidate();
    }

    public final void setCellSpacing(float r2) {
        if (this.cellSpacing != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.cellSpacing = r2;
        requestLayout();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCellCornerRadius(float r2) {
        if (this.cellCornerRadius != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.cellCornerRadius = r2;
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCellStrokeWidth(float r2) {
        if (this.cellStrokeWidth != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.cellStrokeWidth = r2;
        this.boxPaintStroke.setStrokeWidth(r2);
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCellStrokeColor(int r2) {
        if (this.cellStrokeColor != r2) goto L5;
        return;
    L5:
        this.cellStrokeColor = r2;
        invalidate();
    }

    public final void setCellBackgroundColor(int r2) {
        if (this.cellBackgroundColor != r2) goto L5;
        return;
    L5:
        this.cellBackgroundColor = r2;
        invalidate();
    }

    public final void setTextSizeSp(float r3) {
        float r4 = g.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
        if (this.textSizePx != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.textSizePx = r4;
        this.textPaint.setTextSize(r4);
        updateTextMetrics();
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setTextColor(int r2) {
        if (this.textColor != r2) goto L5;
        return;
    L5:
        this.textColor = r2;
        this.textPaint.setColor(r2);
        invalidate();
    }

    @Override // android.view.View
    public void onMeasure(int r4, int r5) {
        float r0 = this.cellWidth;
        int r1 = this.codeLength;
        setMeasuredDimension(View.resolveSize((int) ((getPaddingLeft() + getPaddingRight()) + ((r0 * r1) + (this.cellSpacing * (r1 - 1)))), r4), View.resolveSize((int) ((getPaddingTop() + getPaddingBottom()) + this.cellHeight), r5));
    }

    @Override // android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        super.onLayout(r4, r5, r6, r7, r8);
        int r9 = ((r7 - r5) - getPaddingLeft()) - getPaddingRight();
        int r10 = ((r8 - r6) - getPaddingTop()) - getPaddingBottom();
        float r11 = this.cellSpacing;
        float r12 = this.cellWidth;
        int r13 = this.codeLength;
        float r14 = r9;
        if (((r13 * r12) + ((r13 - 1) * r11)) <= r14) goto L8;
        if (r13 <= 1) goto L8;
        r11 = (r14 - (r13 * r12)) / (r13 - 1);
        if (r11 >= 0.0f) goto L8;
        r11 = 0.0f;
    L8:
        this.actualCellSpacing = r11;
        this.cellsStartX = getPaddingLeft() + ((r14 - ((r12 * r13) + (r11 * (r13 - 1)))) / CURSOR_WIDTH);
        float r15 = getPaddingTop();
        float r16 = this.cellHeight;
        float r17 = r15 + ((r10 - r16) / CURSOR_WIDTH);
        this.cellsTop = r17;
        this.cellCenterY = r17 + (r16 / CURSOR_WIDTH);
    }

    @Override // android.view.View
    public void onDraw(Canvas r13) {
        o.e(r13, "canvas");
        super.onDraw(r13);
        this.boxPaintFill.setColor(this.cellBackgroundColor);
        this.boxPaintStroke.setColor(this.cellStrokeColor);
        int r0 = this.codeLength;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L16;
        int r4 = r2 + 1;
        float r5 = this.cellsStartX;
        float r7 = this.cellWidth;
        float r6 = r5 + (r2 * (this.actualCellSpacing + r7));
        float r8 = this.cellsTop;
        float r9 = this.cellHeight + r8;
        this.cellRect.set(r6, r8, r7 + r6, r9);
        RectF r10 = this.cellRect;
        float r11 = this.cellCornerRadius;
        r13.drawRoundRect(r10, r11, r11, this.boxPaintFill);
        float r12 = this.cellStrokeWidth;
        if (r12 <= 0.0f) goto L8;
        float r14 = r12 / CURSOR_WIDTH;
        float r3 = n.a(this.cellCornerRadius - r14, 0.0f);
        this.cellRect.inset(r14, r14);
        r13.drawRoundRect(this.cellRect, r3, r3, this.boxPaintStroke);
        float r15 = -r14;
        this.cellRect.inset(r15, r15);
    L8:
        char r16 = this.codeChars[r2];
        if (r16 == 0) goto L14;
        float r17 = this.cellRect.centerX();
        if (this.passwordMode == false) goto L13;
        r13.drawCircle(r17, this.cellCenterY, this.passwordCircleRadius, this.textPaint);
        goto L14
    L13:
        char[] r18 = this.oneCharArray;
        r18[0] = r16;
        r13.drawText(r18, 0, 1, r17, this.cellCenterY + this.textCenterYOffset, this.textPaint);
    L14:
        r2 = r4;
        goto L4
    L16:
        if (shouldDrawCursor() == false) goto L23;
        int r1 = n.a(this.inputIndex, 0, this.codeLength - 1);
        float r19 = this.cellsStartX;
        float r20 = this.cellWidth;
        float r21 = r19 + (r1 * (this.actualCellSpacing + r20));
        float r22 = (r21 + (r20 + r21)) / CURSOR_WIDTH;
        float r23 = this.cellHeight * CURSOR_HEIGHT_FACTOR;
        float r24 = this.cellCenterY;
        float r25 = r23 / CURSOR_WIDTH;
        float r26 = r24 - r25;
        float r27 = r24 + r25;
        float r28 = this.cursorHalfWidth;
        r13.drawRect(r22 - r28, r26, r22 + r28, r27, this.cursorPaint);
        return;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
    }

    private final void refreshDimensionCache() {
        this.passwordCircleRadius = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), CIRCLE_RADIUS);
        this.cursorHalfWidth = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DEFAULT_CELL_STROKE_DP);
    }

    private final boolean shouldDrawCursor() {
        if (isFocused() == true) goto L5;
    L15:
        return false;
    L5:
        if (this.cursorVisible == false) goto L15;
        if (this.cursorBlinkOn == true) goto L11;
        return false;
    L11:
        if (this.inputIndex < this.codeLength) goto L13;
        return false;
    L13:
        return true;
    }

    private final void updateTextMetrics() {
        this.textPaint.getFontMetrics(this.textFontMetrics);
        this.textCenterYOffset = -((this.textFontMetrics.ascent + this.textFontMetrics.descent) / CURSOR_WIDTH);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r2) {
        o.e(r2, "outAttrs");
        if (this.passwordMode == false) goto L5;
        int r0 = 16;
    L6:
        r2.inputType = r0 | 2;
        r2.imeOptions = 268435462;
        r2.initialSelStart = this.inputIndex;
        r2.initialSelEnd = this.inputIndex;
        return (InputConnection) ZeusTransformUtils.preCheckCast(new OtpInputConnection(this), InputConnection.class, "com.obric.aiagent.plugin");
    L5:
        r0 = 0;
        goto L6
    }

    public final void commitTextFromIme$OUI_standardRelease(CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r8, "text");
        if (isCodeComplete() == false) goto L5;
        return;
    L5:
        int r0 = 0;
        boolean r1 = true;
        boolean r2 = false;
    L7:
        if (r0 >= r8.length()) goto L18;
        char r3 = r8.charAt(r0);
        r0 = r0 + 1;
        if (Character.isDigit(r3) == false) goto L7;
        int r4 = this.inputIndex;
        int r5 = this.codeLength;
        if (r4 >= r5) goto L18;
        this.codeChars[r4] = r3;
        int r6 = r4 + 1;
        this.inputIndex = r6;
        if (r6 >= r5) goto L19;
        r2 = true;
    L19:
        if (r1 == false) goto L31;
        notifyCodeChanged();
        invalidate();
        if (isCodeComplete() == false) goto L32;
        notifyCodeComplete();
        return;
    L32:
        return;
    L31:
        return;
    L18:
        r1 = r2;
        goto L19
    }

    public final boolean handleDeleteFromIme$OUI_standardRelease() {
        boolean r0 = deleteLastChar();
        if (r0 == false) goto L5;
        notifyCodeChanged();
        invalidate();
    L5:
        return r0;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r5, KeyEvent r6) {
        o.e(r6, "event");
        if (r5 != 67) goto L8;
        if (handleDeleteFromIme$OUI_standardRelease() == false) goto L8;
        return true;
    L8:
        if (r5 < 7) goto L14;
        if (r5 > 16) goto L14;
        commitTextFromIme$OUI_standardRelease((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf((char) ((r5 - 7) + 48)), CharSequence.class, "com.obric.aiagent.plugin"));
        return true;
    L14:
        if (r5 < 144) goto L20;
        if (r5 > 153) goto L20;
        commitTextFromIme$OUI_standardRelease((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf((char) ((r5 - 144) + 48)), CharSequence.class, "com.obric.aiagent.plugin"));
        return true;
    L20:
        return super.onKeyDown(r5, r6);
    }

    private final boolean deleteLastChar() {
        int r0 = this.inputIndex;
        if (r0 > 0) goto L5;
        return false;
    L5:
        int r1 = n.c(r0 - 1, 0);
        char[] r3 = this.codeChars;
        if (r3[r1] != 0) goto L17;
        if (r1 < 0) goto L15;
    L8:
        int r4 = r1 - 1;
        char[] r5 = this.codeChars;
        if (r5[r1] != 0) goto L10;
        if (r4 < 0) goto L15;
        r1 = r4;
        goto L8
    L10:
        r5[r1] = EMPTY_CHAR;
        this.inputIndex = r1;
        return true;
    L15:
        this.inputIndex = 0;
        return false;
    L17:
        r3[r1] = EMPTY_CHAR;
        this.inputIndex = r1;
        return true;
    }

    private final boolean isCodeComplete() {
        if (this.inputIndex < this.codeLength) goto L5;
        return true;
    L5:
        return false;
    }

    private final void notifyCodeComplete() {
        c r0 = this.onCodeCompleteListener;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(getCode());
    }

    private final void notifyCodeChanged() {
        b r0 = this.onCodeChangeListener;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(getCode());
    }

    private final void clearInternal(boolean r6) {
        int r0 = this.codeLength;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.codeChars[r2] = EMPTY_CHAR;
        r2 = r2 + 1;
        goto L3
    L5:
        this.inputIndex = 0;
        if (r6 == true) goto L10;
        notifyCodeChanged();
        invalidate();
        return;
    }

    private final int findFirstEmptyIndex() {
        int r0 = this.codeLength;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r1 + 1;
        if (this.codeChars[r1] == 0) goto L6;
        r1 = r2;
        goto L3
    L6:
        return r1;
    L9:
        return this.codeLength;
    }

    private final void applyCodeLengthFromAttribute(int r3) {
        int r4 = n.a(r3, 1, 6);
        if (r4 != this.codeLength) goto L5;
        return;
    L5:
        this.codeLength = r4;
        this.codeChars = new char[r4];
        this.inputIndex = 0;
    }

    private final void restartInput() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.restartInput((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r1, int r2, Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        if (r1 == true) goto L5;
        stopBlink();
        hideKeyboard();
    L9:
        invalidate();
        return;
    L5:
        if (this.cursorVisible == false) goto L7;
        startBlink();
    L7:
        showKeyboard();
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        o.e(r3, "event");
        int r0 = r3.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
        performClick();
        return true;
    L6:
        return super.onTouchEvent(r3);
    L9:
        requestFocus();
        showKeyboard();
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    private final void showKeyboard() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.showSoftInput((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 1);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void hideKeyboard() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isFocusable() == false) goto L10;
        if (isFocusableInTouchMode() == false) goto L10;
        if (isInEditMode() == true) goto L10;
        requestFocus();
        showKeyboard();
    L10:
        if (hasFocus() == true) goto L12;
        return;
    L12:
        if (this.cursorVisible == false) goto L16;
        startBlink();
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopBlink();
    }

    private final void startBlink() {
        if (this.blinkStarted == false) goto L5;
        return;
    L5:
        this.blinkStarted = true;
        this.cursorBlinkOn = true;
        removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.cursorBlinkRunnable, Runnable.class, "com.obric.aiagent.plugin"));
        postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this.cursorBlinkRunnable, Runnable.class, "com.obric.aiagent.plugin"), 500);
    }

    private final void stopBlink() {
        this.blinkStarted = false;
        removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.cursorBlinkRunnable, Runnable.class, "com.obric.aiagent.plugin"));
    }
}
