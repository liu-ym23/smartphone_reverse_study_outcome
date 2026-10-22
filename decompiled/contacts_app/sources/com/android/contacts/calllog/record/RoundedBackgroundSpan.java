package com.android.contacts.calllog.record;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.google.android.material.internal.ViewUtils;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoundedBackgroundSpan.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Ba\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0013H\u0002JP\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J \u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0015H\u0002J@\u0010%\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0015H\u0002J2\u0010&\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\tR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/android/contacts/calllog/record/RoundedBackgroundSpan;", "Landroid/text/style/ReplacementSpan;", "mTagStyle", "Landroid/graphics/Paint$Style;", "mTagTextColor", "", "mTagBackgroundColor", "textSizePx", "mRadiusPx", "", "mRightMarginPx", "mTextLeftPadding", "mTextRightPadding", "mRectTopPaddingPx", "mRectBottomPaddingPx", "(Landroid/graphics/Paint$Style;IIIFIIIII)V", "alpha", "mSize", "mTagPaint", "Landroid/graphics/Paint;", "createRect", "Landroid/graphics/RectF;", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, "paint", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", TraceStatsConsts.STATS_KEY_END, "top", "bottom", "drawTagRect", "rect", "drawTagText", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "setAlpha", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RoundedBackgroundSpan extends ReplacementSpan {
    private int alpha;
    private final float mRadiusPx;
    private final int mRectBottomPaddingPx;
    private final int mRectTopPaddingPx;
    private final int mRightMarginPx;
    private int mSize;
    private final int mTagBackgroundColor;
    private final Paint mTagPaint;
    private final Paint.Style mTagStyle;
    private final int mTagTextColor;
    private final int mTextLeftPadding;
    private final int mTextRightPadding;
    private final int textSizePx;

    public RoundedBackgroundSpan(Paint.Style r15, int r16, int r17, int r18, float r19) {
        Intrinsics.checkNotNullParameter(r15, "mTagStyle");
        this(r15, r16, r17, r18, r19, 0, 0, 0, 0, 0, 992, null);
    }

    public RoundedBackgroundSpan(Paint.Style r15, int r16, int r17, int r18, float r19, int r20) {
        Intrinsics.checkNotNullParameter(r15, "mTagStyle");
        this(r15, r16, r17, r18, r19, r20, 0, 0, 0, 0, 960, null);
    }

    public RoundedBackgroundSpan(Paint.Style r15, int r16, int r17, int r18, float r19, int r20, int r21) {
        Intrinsics.checkNotNullParameter(r15, "mTagStyle");
        this(r15, r16, r17, r18, r19, r20, r21, 0, 0, 0, 896, null);
    }

    public RoundedBackgroundSpan(Paint.Style r15, int r16, int r17, int r18, float r19, int r20, int r21, int r22) {
        Intrinsics.checkNotNullParameter(r15, "mTagStyle");
        this(r15, r16, r17, r18, r19, r20, r21, r22, 0, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
    }

    public RoundedBackgroundSpan(Paint.Style r15, int r16, int r17, int r18, float r19, int r20, int r21, int r22, int r23) {
        Intrinsics.checkNotNullParameter(r15, "mTagStyle");
        this(r15, r16, r17, r18, r19, r20, r21, r22, r23, 0, 512, null);
    }

    public /* synthetic */ RoundedBackgroundSpan(Paint.Style r15, int r16, int r17, int r18, float r19, int r20, int r21, int r22, int r23, int r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 32) == 0) goto L5;
        int r9 = 0;
    L7:
        if ((r25 & 64) == 0) goto L9;
        int r10 = 0;
    L11:
        if ((r25 & 128) == 0) goto L13;
        int r11 = 0;
    L15:
        if ((r25 & 256) == 0) goto L17;
        int r12 = 0;
    L19:
        if ((r25 & 512) == 0) goto L21;
        int r13 = 0;
    L22:
        this(r15, r16, r17, r18, r19, r9, r10, r11, r12, r13);
        return;
    L21:
        r13 = r24;
        goto L22
    L17:
        r12 = r23;
        goto L19
    L13:
        r11 = r22;
        goto L15
    L9:
        r10 = r21;
        goto L11
    L5:
        r9 = r20;
        goto L7
    }

    public RoundedBackgroundSpan(Paint.Style r2, int r3, int r4, int r5, float r6, int r7, int r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r2, "mTagStyle");
        this.mTagStyle = r2;
        this.mTagTextColor = r3;
        this.mTagBackgroundColor = r4;
        this.textSizePx = r5;
        this.mRadiusPx = r6;
        this.mRightMarginPx = r7;
        this.mTextLeftPadding = r8;
        this.mTextRightPadding = r9;
        this.mRectTopPaddingPx = r10;
        this.mRectBottomPaddingPx = r11;
        Paint r12 = new Paint();
        this.mTagPaint = r12;
        this.alpha = 255;
        r12.setTextSize(r5);
        r12.setColor(r3);
        r12.setAntiAlias(true);
        r12.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        Intrinsics.checkNotNullParameter(r3, "text");
        this.mSize = ((((int) this.mTagPaint.measureText(r3, r4, r5)) + this.mRightMarginPx) + this.mTextLeftPadding) + this.mTextRightPadding;
        Paint.FontMetrics r7 = this.mTagPaint.getFontMetrics();
        if (r6 == null) goto L6;
        r6.ascent = (int) r7.ascent;
        r6.bottom = (int) r7.bottom;
        r6.descent = (int) r7.descent;
        r6.leading = (int) r7.leading;
        r6.top = (int) r7.top;
    L6:
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r9, CharSequence r10, int r11, int r12, float r13, int r14, int r15, int r16, Paint r17) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        Intrinsics.checkNotNullParameter(r10, "text");
        Intrinsics.checkNotNullParameter(r17, "paint");
        RectF r7 = createRect(r13, r15, r17);
        drawTagRect(r9, r17, r7);
        drawTagText(r9, r10, r11, r12, r13, r15, r7);
    }

    private final RectF createRect(float r6, int r7, Paint r8) {
        Paint.FontMetricsInt r0 = r8.getFontMetricsInt();
        float r9 = r8.getStrokeWidth();
        return new RectF((r6 + r9) + 0.5f, (r0.ascent + r7) + this.mRectTopPaddingPx, (((r6 + this.mSize) + r9) + 0.5f) - this.mRightMarginPx, (r7 + r0.descent) - this.mRectBottomPaddingPx);
    }

    private final void drawTagRect(Canvas r5, Paint r6, RectF r7) {
        int r0 = this.mTagBackgroundColor;
        int r1 = (int) (((r0 >> 24) & 255) * (this.alpha / 255.0f));
        r6.setColor(r0);
        r6.setAntiAlias(true);
        r6.setAlpha(r1);
        r6.setStyle(this.mTagStyle);
        float r4 = this.mRadiusPx;
        r5.drawRoundRect(r7, r4, r4, r6);
    }

    private final void drawTagText(Canvas r4, CharSequence r5, int r6, int r7, float r8, int r9, RectF r10) {
        Paint.FontMetricsInt r11 = this.mTagPaint.getFontMetricsInt();
        float r1 = 2;
        r4.drawText(r5.subSequence(r6, r7).toString(), r8 + ((r10.right - r10.left) / r1), ((r10.bottom - ((r10.bottom - r10.top) / r1)) + ((r11.descent - r11.ascent) / 2.0f)) - r11.descent, this.mTagPaint);
    }

    public final void setAlpha(float r2) {
        this.alpha = (int) (255 * r2);
    }
}
