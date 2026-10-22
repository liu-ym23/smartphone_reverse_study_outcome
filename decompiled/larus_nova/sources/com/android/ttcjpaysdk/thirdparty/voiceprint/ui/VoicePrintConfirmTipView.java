package com.android.ttcjpaysdk.thirdparty.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.thirdparty.voiceprint.common.CommonKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0002\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintConfirmTipView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPaint", "Landroid/graphics/Paint;", "blurPx", "", "cornerPx", "currentGlowState", "glowColor", "iconView", "Landroid/widget/ImageView;", "padPx", "rectF", "Landroid/graphics/RectF;", "textView", "Landroid/widget/TextView;", "applyAlpha", "color", "alphaFraction", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setGlowState", "state", "setText", "text", "", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoicePrintConfirmTipView extends FrameLayout {
    private static final float BLUR_DP = 20.0f;
    public static final Companion Companion = null;
    public static final int GLOW_BLUE = 1;
    private static final int GLOW_INVALID = -1;
    public static final int GLOW_PINK = 2;
    private static final float HEIGHT_DP = 46.0f;
    private static final float ICON_SIZE_DP = 18.0f;
    private static final float ICON_TEXT_GAP_DP = 2.0f;
    private static final float RADIUS_DP = 60.0f;
    private static final float TEXT_SIZE_DP = 15.0f;
    private static final float WIDTH_DP = 190.0f;
    private final Paint bgPaint;
    private final float blurPx;
    private final float cornerPx;
    private int currentGlowState;
    private int glowColor;
    private final ImageView iconView;
    private final int padPx;
    private final RectF rectF;
    private final TextView textView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintConfirmTipView$Companion;", "", "()V", "BLUR_DP", "", "GLOW_BLUE", "", "GLOW_INVALID", "GLOW_PINK", "HEIGHT_DP", "ICON_SIZE_DP", "ICON_TEXT_GAP_DP", "RADIUS_DP", "TEXT_SIZE_DP", "WIDTH_DP", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public VoicePrintConfirmTipView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public VoicePrintConfirmTipView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = this.padPx;
        float r102 = getWidth() - this.padPx;
        float r103 = getHeight() - this.padPx;
        this.rectF.set(r101, r101, r102, r103);
        this.bgPaint.setShadowLayer(this.blurPx, 0.0f, 0.0f, this.glowColor);
        RectF r104 = this.rectF;
        float r105 = this.cornerPx;
        r100.drawRoundRect(r104, r105, r105, this.bgPaint);
        this.bgPaint.clearShadowLayer();
    }

    public final void setGlowState(int r100) {
        if (r100 != this.currentGlowState) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        int r101 = applyAlpha(ColorProtector.parseColor("#4F7DFF"), 0.5f);
    L12:
        this.currentGlowState = r100;
        this.glowColor = r101;
        invalidate();
        return;
    L8:
        if (r100 == 2) goto L10;
        r101 = applyAlpha(ColorProtector.parseColor("#4F7DFF"), 0.5f);
        goto L12
    L10:
        r101 = applyAlpha(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED_WARN), 0.1f);
        goto L12
    }

    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.textView.setText(r100);
    }

    private final int applyAlpha(int r100, float r101) {
        return Color.argb(RangesKt.coerceIn((int) (r101 * 255.0f), 0, 255), Color.red(r100), Color.green(r100), Color.blue(r100));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = ((int) CommonKt.dp2px(this, WIDTH_DP)) + (this.padPx * 2);
        int r103 = ((int) CommonKt.dp2px(this, HEIGHT_DP)) + (this.padPx * 2);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r103, 1073741824));
    }

    public VoicePrintConfirmTipView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.cornerPx = CommonKt.dp2px(this, 60.0f);
        float r103 = CommonKt.dp2px(this, 20.0f);
        this.blurPx = r103;
        int r104 = (int) r103;
        this.padPx = r104;
        this.rectF = new RectF();
        Paint r105 = new Paint(1);
        r105.setColor(-1);
        r105.setStyle(Paint.Style.FILL);
        this.bgPaint = r105;
        this.glowColor = applyAlpha(ColorProtector.parseColor("#4F7DFF"), 0.5f);
        setClipChildren(false);
        setClipToPadding(false);
        setLayerType(1, null);
        setWillNotDraw(false);
        setPadding(r104, r104, r104, r104);
        LinearLayout r106 = new LinearLayout(r100);
        r106.setOrientation(0);
        r106.setGravity(16);
        ImageView r107 = new ImageView(r100);
        r107.setImageResource(R.drawable.ic_microphone_icon);
        r107.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.iconView = r107;
        int r108 = (int) CommonKt.dp2px(this, ICON_SIZE_DP);
        r106.addView(r107, new LinearLayout.LayoutParams(r108, r108));
        TextView r109 = new TextView(r100);
        r109.setTextColor(ContextCompat.getColor(r100, R.color.voice_print_color_161823));
        r109.setTextSize(2, TEXT_SIZE_DP);
        r109.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        r109.setIncludeFontPadding(false);
        r109.setGravity(17);
        this.textView = r109;
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-2, -2);
        r110.setMarginStart((int) CommonKt.dp2px(this, 2.0f));
        r106.addView(r109, r110);
        addView(r106, new FrameLayout.LayoutParams(-2, -2, 17));
        this.currentGlowState = -1;
    }

    public /* synthetic */ VoicePrintConfirmTipView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
