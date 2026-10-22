package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\u0014H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/utils/CJPayCursorTextView;", "Landroid/widget/TextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "blinkAnimator", "Landroid/animation/ValueAnimator;", "cursorHeight", "cursorMargin", "cursorPaint", "Landroid/graphics/Paint;", "cursorRadius", "cursorWidth", "isCursorVisible", "", "drawCursor", "", "canvas", "Landroid/graphics/Canvas;", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "setupBlinkAnimator", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCursorTextView extends TextView {
    public static final Companion Companion = null;
    private static final long DEFAULT_BLINK_INTERVAL_MS = 500;
    private static final float DEFAULT_CURSOR_HEIGHT_DP = 24.0f;
    private static final float DEFAULT_CURSOR_MARGIN_DP = 4.0f;
    private static final float DEFAULT_CURSOR_RADIUS_DP = 1.0f;
    private static final float DEFAULT_CURSOR_WIDTH_DP = 2.0f;
    private ValueAnimator blinkAnimator;
    private final int cursorHeight;
    private final int cursorMargin;
    private final Paint cursorPaint;
    private final int cursorRadius;
    private final int cursorWidth;
    private boolean isCursorVisible;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/utils/CJPayCursorTextView$Companion;", "", "()V", "DEFAULT_BLINK_INTERVAL_MS", "", "DEFAULT_CURSOR_HEIGHT_DP", "", "DEFAULT_CURSOR_MARGIN_DP", "DEFAULT_CURSOR_RADIUS_DP", "DEFAULT_CURSOR_WIDTH_DP", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayCursorTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJPayCursorTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void setupBlinkAnimator() {
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r100.setDuration(500);
        r100.setRepeatMode(2);
        r100.setRepeatCount(-1);
        r100.addUpdateListener(new CJPayCursorTextView$setupBlinkAnimator$1$1(this));
        this.blinkAnimator = r100;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        ValueAnimator r100 = this.blinkAnimator;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.blinkAnimator;
        if (r101 == null) goto L8;
        r101.removeAllListeners();
    L8:
        this.blinkAnimator = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ValueAnimator r100 = this.blinkAnimator;
        if (r100 == null) goto L6;
        r100.start();
        return;
    }

    private final void drawCursor(Canvas r110) {
        String r100 = getText().toString();
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        float r102 = (getWidth() - this.cursorWidth) / 2.0f;
    L10:
        float r103 = r102;
        int r104 = getHeight();
        int r105 = this.cursorHeight;
        float r106 = (r104 - r105) / 2.0f;
        int r107 = this.cursorRadius;
        r110.drawRoundRect(r103, r106, r103 + this.cursorWidth, r106 + r105, r107, r107, this.cursorPaint);
        return;
    L9:
        float r108 = getPaint().measureText(r100);
        r102 = this.cursorMargin + (((getWidth() - r108) / 2) + r108);
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.isCursorVisible == false) goto L6;
        drawCursor(r100);
        return;
    }

    public static final /* synthetic */ void access$setCursorVisible$p(CJPayCursorTextView r100, boolean r101) {
        r100.isCursorVisible = r101;
    }

    public CJPayCursorTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.cursorWidth = CJPayBasicExtensionKt.dp(2.0f);
        this.cursorHeight = CJPayBasicExtensionKt.dp(24.0f);
        this.cursorRadius = CJPayBasicExtensionKt.dp(1.0f);
        this.cursorMargin = CJPayBasicExtensionKt.dp(4.0f);
        Paint r103 = new Paint(1);
        r103.setColor(ContextCompat.getColor(r100, R.color.cj_pay_color_red_11));
        r103.setStyle(Paint.Style.FILL);
        this.cursorPaint = r103;
        this.isCursorVisible = true;
        setupBlinkAnimator();
    }

    public /* synthetic */ CJPayCursorTextView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
