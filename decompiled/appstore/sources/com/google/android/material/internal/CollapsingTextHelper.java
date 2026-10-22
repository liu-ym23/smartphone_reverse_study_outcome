package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.e;
import androidx.core.view.ViewCompat;
import androidx.core.view.c;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import p.a;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;

    @NonNull
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE = false;
    private boolean boundsChanged;

    @NonNull
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private float collapsedLetterSpacing;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity;
    private float collapsedTextSize;
    private Typeface collapsedTypeface;

    @NonNull
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private int currentOffsetY;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;

    @NonNull
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private float expandedFirstLineDrawX;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity;
    private float expandedTextSize;

    @Nullable
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private int hyphenationFrequency;
    private boolean isRtl;
    private boolean isRtlTextDirectionHeuristicsEnabled;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private int maxLines;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;

    @Nullable
    private CharSequence text;
    private StaticLayout textLayout;

    @NonNull
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;

    @Nullable
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;

    @NonNull
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    static {
        USE_SCALING_TEXTURE = false;
        DEBUG_DRAW_PAINT = null;
    }

    public CollapsingTextHelper(View r10) {
        this.expandedTextGravity = 16;
        this.collapsedTextGravity = 16;
        this.expandedTextSize = 15.0f;
        this.collapsedTextSize = 15.0f;
        this.isRtlTextDirectionHeuristicsEnabled = true;
        this.maxLines = 1;
        this.lineSpacingAdd = 0.0f;
        this.lineSpacingMultiplier = 1.0f;
        this.hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
        this.view = r10;
        TextPaint r11 = new TextPaint(129);
        this.textPaint = r11;
        this.tmpPaint = new TextPaint(r11);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    private static int blendColors(int r10, int r11, float r12) {
        float r13 = 1.0f - r12;
        return Color.argb((int) ((Color.alpha(r10) * r13) + (Color.alpha(r11) * r12)), (int) ((Color.red(r10) * r13) + (Color.red(r11) * r12)), (int) ((Color.green(r10) * r13) + (Color.green(r11) * r12)), (int) ((Color.blue(r10) * r13) + (Color.blue(r11) * r12)));
    }

    private void calculateBaseOffsets(boolean r13) {
        float r10 = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize, r13);
        CharSequence r11 = this.textToDraw;
        if (r11 == null) goto L7;
        StaticLayout r12 = this.textLayout;
        if (r12 == null) goto L7;
        this.textToDrawCollapsed = TextUtils.ellipsize(r11, this.textPaint, r12.getWidth(), TextUtils.TruncateAt.END);
    L7:
        CharSequence r14 = this.textToDrawCollapsed;
        float r15 = 0.0f;
        if (r14 == null) goto L10;
        float r16 = this.textPaint.measureText(r14, 0, r14.length());
    L11:
        int r17 = c.b(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int r18 = r17 & 112;
        if (r18 == 48) goto L16;
        if (r18 == 80) goto L15;
        this.collapsedDrawY = this.collapsedBounds.centerY() - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
    L17:
        int r19 = r17 & 8388615;
        if (r19 == 1) goto L22;
        if (r19 == 5) goto L21;
        this.collapsedDrawX = this.collapsedBounds.left;
    L23:
        calculateUsingTextSize(this.expandedTextSize, r13);
        StaticLayout r110 = this.textLayout;
        if (r110 == null) goto L26;
        float r111 = r110.getHeight();
    L27:
        CharSequence r20 = this.textToDraw;
        if (r20 == null) goto L30;
        float r21 = this.textPaint.measureText(r20, 0, r20.length());
    L31:
        StaticLayout r22 = this.textLayout;
        if (r22 != null) goto L34;
    L36:
        StaticLayout r23 = this.textLayout;
        if (r23 != null) goto L39;
    L42:
        this.expandedFirstLineDrawX = r15;
        int r24 = c.b(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int r25 = r24 & 112;
        if (r25 == 48) goto L47;
        if (r25 == 80) goto L46;
        this.expandedDrawY = this.expandedBounds.centerY() - (r111 / 2.0f);
    L48:
        int r112 = r24 & 8388615;
        if (r112 == 1) goto L53;
        if (r112 == 5) goto L52;
        this.expandedDrawX = this.expandedBounds.left;
    L54:
        clearTexture();
        setInterpolatedTextSize(r10);
        return;
    L52:
        this.expandedDrawX = this.expandedBounds.right - r21;
        goto L54
    L53:
        this.expandedDrawX = this.expandedBounds.centerX() - (r21 / 2.0f);
        goto L54
    L46:
        this.expandedDrawY = (this.expandedBounds.bottom - r111) + this.textPaint.descent();
        goto L48
    L47:
        this.expandedDrawY = this.expandedBounds.top;
        goto L48
    L39:
        if (this.maxLines <= 1) goto L41;
        r15 = r23.getLineStart(0);
        goto L42
    L41:
        r15 = r23.getLineLeft(0);
        goto L42
    L34:
        if (this.maxLines <= 1) goto L36;
        r21 = r22.getWidth();
        goto L36
    L30:
        r21 = 0.0f;
        goto L31
    L26:
        r111 = 0.0f;
        goto L27
    L21:
        this.collapsedDrawX = this.collapsedBounds.right - r16;
        goto L23
    L22:
        this.collapsedDrawX = this.collapsedBounds.centerX() - (r16 / 2.0f);
        goto L23
    L15:
        this.collapsedDrawY = this.collapsedBounds.bottom + this.textPaint.ascent();
        goto L17
    L16:
        this.collapsedDrawY = this.collapsedBounds.top;
        goto L17
    L10:
        r16 = 0.0f;
        goto L11
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        float r11 = this.fadeModeThresholdFraction;
        if (r10 > r11) goto L7;
        return AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, r11, r10);
    L7:
        return AnimationUtils.lerp(0.0f, 1.0f, r11, 1.0f, r10);
    }

    private float calculateFadeModeThresholdFraction() {
        float r10 = this.fadeModeStartFraction;
        return r10 + ((1.0f - r10) * FADE_MODE_THRESHOLD_FRACTION_RELATIVE);
    }

    private boolean calculateIsRtl(@NonNull CharSequence r10) {
        boolean r11 = isDefaultIsRtl();
        if (this.isRtlTextDirectionHeuristicsEnabled == true) goto L5;
        return r11;
    L5:
        return isTextDirectionHeuristicsIsRtl(r10, r11);
    }

    private void calculateOffsets(float r10) {
        interpolateBounds(r10);
        if (this.fadeModeEnabled == true) goto L5;
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, r10, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, r10, this.positionInterpolator);
        setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, r10, this.textSizeInterpolator));
        float r11 = r10;
    L9:
        TimeInterpolator r12 = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - r10, r12));
        setExpandedTextBlend(lerp(1.0f, 0.0f, r10, r12));
        if (this.collapsedTextColor == this.expandedTextColor) goto L12;
        this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), r11));
    L13:
        float r13 = this.collapsedLetterSpacing;
        float r14 = this.expandedLetterSpacing;
        if (r13 == r14) goto L16;
        this.textPaint.setLetterSpacing(lerp(r14, r13, r10, r12));
    L17:
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, r10, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, r10, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, r10, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), r10));
        if (this.fadeModeEnabled == false) goto L20;
        this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(r10) * 255.0f));
    L20:
        ViewCompat.g0(this.view);
        return;
    L16:
        this.textPaint.setLetterSpacing(r13);
        goto L17
    L12:
        this.textPaint.setColor(getCurrentCollapsedTextColor());
        goto L13
    L5:
        if (r10 >= this.fadeModeThresholdFraction) goto L7;
        this.currentDrawX = this.expandedDrawX;
        this.currentDrawY = this.expandedDrawY;
        setInterpolatedTextSize(this.expandedTextSize);
        r11 = 0.0f;
        goto L9
    L7:
        this.currentDrawX = this.collapsedDrawX;
        this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
        setInterpolatedTextSize(this.collapsedTextSize);
        r11 = 1.0f;
        goto L9
    }

    private void calculateUsingTextSize(float r10) {
        calculateUsingTextSize(r10, false);
    }

    private void clearTexture() {
        Bitmap r10 = this.expandedTitleTexture;
        if (r10 == null) goto L6;
        r10.recycle();
        this.expandedTitleTexture = null;
        return;
    }

    private StaticLayout createStaticLayout(int r10, float r11, boolean r12) {
        StaticLayout r13 = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) r11).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(r12).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(r10).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).build();     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L4
    L7:
        return (StaticLayout) e.g(r13);
    L4:
        e = move-exception;
        Log.e(TAG, e.getCause().getMessage(), e);
        r13 = null;
        goto L7
    }

    private void drawMultilineTransition(@NonNull Canvas r13, float r14, float r15) {
        int r10 = this.textPaint.getAlpha();
        r13.translate(r14, r15);
        float r11 = r10;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * r11));
        this.textLayout.draw(r13);
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * r11));
        int r16 = this.textLayout.getLineBaseline(0);
        CharSequence r12 = this.textToDrawCollapsed;
        float r17 = r16;
        r13.drawText(r12, 0, r12.length(), 0.0f, r17, this.textPaint);
        if (this.fadeModeEnabled == true) goto L9;
        String r18 = this.textToDrawCollapsed.toString().trim();
        if (r18.endsWith(ELLIPSIS_NORMAL) == false) goto L7;
        r18 = r18.substring(0, r18.length() - 1);
    L7:
        String r19 = r18;
        this.textPaint.setAlpha(r10);
        r13.drawText(r19, 0, Math.min(this.textLayout.getLineEnd(0), r19.length()), 0.0f, r17, this.textPaint);
        return;
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture == null) goto L5;
        return;
    L5:
        if (this.expandedBounds.isEmpty() == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.textToDraw) == true) goto L21;
        calculateOffsets(0.0f);
        int r10 = this.textLayout.getWidth();
        int r11 = this.textLayout.getHeight();
        if (r10 <= 0) goto L19;
        if (r11 <= 0) goto L22;
        this.expandedTitleTexture = Bitmap.createBitmap(r10, r11, Bitmap.Config.ARGB_8888);
        Canvas r12 = new Canvas(this.expandedTitleTexture);
        this.textLayout.draw(r12);
        if (this.texturePaint != null) goto L20;
        this.texturePaint = new Paint(3);
        return;
    L20:
        return;
    L22:
        return;
    L19:
        return;
    }

    private float getCollapsedTextLeftBound(int r10, int r11) {
        if (r11 == 17) goto L23;
        if ((r11 & 7) == 1) goto L23;
        if ((r11 & 8388613) == 8388613) goto L18;
        if ((r11 & 5) == 5) goto L18;
        if (this.isRtl == false) goto L16;
        return this.collapsedBounds.right - calculateCollapsedTextWidth();
    L16:
        return this.collapsedBounds.left;
    L18:
        if (this.isRtl == false) goto L21;
        return this.collapsedBounds.left;
    L21:
        return this.collapsedBounds.right - calculateCollapsedTextWidth();
    L23:
        return (r10 / 2.0f) - (calculateCollapsedTextWidth() / 2.0f);
    }

    private float getCollapsedTextRightBound(@NonNull RectF r10, int r11, int r12) {
        if (r12 == 17) goto L23;
        if ((r12 & 7) == 1) goto L23;
        if ((r12 & 8388613) == 8388613) goto L18;
        if ((r12 & 5) == 5) goto L18;
        if (this.isRtl == false) goto L16;
        return this.collapsedBounds.right;
    L16:
        return calculateCollapsedTextWidth() + r10.left;
    L18:
        if (this.isRtl == false) goto L21;
        return r10.left + calculateCollapsedTextWidth();
    L21:
        return this.collapsedBounds.right;
    L23:
        return (r11 / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int[] r11 = this.state;
        if (r11 == null) goto L10;
        return r10.getColorForState(r11, 0);
    L10:
        return r10.getDefaultColor();
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private void getTextPaintCollapsed(@NonNull TextPaint r10) {
        r10.setTextSize(this.collapsedTextSize);
        r10.setTypeface(this.collapsedTypeface);
        r10.setLetterSpacing(this.collapsedLetterSpacing);
    }

    private void getTextPaintExpanded(@NonNull TextPaint r10) {
        r10.setTextSize(this.expandedTextSize);
        r10.setTypeface(this.expandedTypeface);
        r10.setLetterSpacing(this.expandedLetterSpacing);
    }

    private void interpolateBounds(float r10) {
        if (this.fadeModeEnabled == false) goto L9;
        RectF r11 = this.currentBounds;
        if (r10 >= this.fadeModeThresholdFraction) goto L7;
        Rect r12 = this.expandedBounds;
    L8:
        r11.set(r12);
        return;
    L7:
        r12 = this.collapsedBounds;
        goto L8
    L9:
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, r10, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, r10, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, r10, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, r10, this.positionInterpolator);
    }

    private static boolean isClose(float r10, float r11) {
        if (Math.abs(r10 - r11) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isDefaultIsRtl() {
        if (ViewCompat.A(this.view) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isTextDirectionHeuristicsIsRtl(@NonNull CharSequence r10, boolean r11) {
        if (r11 == false) goto L4;
        TextDirectionHeuristicCompat r12 = TextDirectionHeuristicsCompat.f2613d;
    L6:
        return r12.isRtl(r10, 0, r10.length());
    L4:
        r12 = TextDirectionHeuristicsCompat.f2612c;
        goto L6
    }

    private static float lerp(float r10, float r11, float r12, @Nullable TimeInterpolator r13) {
        if (r13 == null) goto L5;
        r12 = r13.getInterpolation(r12);
    L5:
        return AnimationUtils.lerp(r10, r11, r12);
    }

    private static boolean rectEquals(@NonNull Rect r10, int r11, int r12, int r13, int r14) {
        if (r10.left == r11) goto L5;
    L11:
        return false;
    L5:
        if (r10.top != r12) goto L11;
        if (r10.right != r13) goto L11;
        if (r10.bottom != r14) goto L11;
        return true;
    }

    private void setCollapsedTextBlend(float r10) {
        this.collapsedTextBlend = r10;
        ViewCompat.g0(this.view);
    }

    private boolean setCollapsedTypefaceInternal(Typeface r10) {
        CancelableFontCallback r11 = this.collapsedFontCallback;
        if (r11 == null) goto L6;
        r11.cancel();
    L6:
        if (this.collapsedTypeface == r10) goto L9;
        this.collapsedTypeface = r10;
        return true;
    L9:
        return false;
    }

    private void setExpandedTextBlend(float r10) {
        this.expandedTextBlend = r10;
        ViewCompat.g0(this.view);
    }

    private boolean setExpandedTypefaceInternal(Typeface r10) {
        CancelableFontCallback r11 = this.expandedFontCallback;
        if (r11 == null) goto L6;
        r11.cancel();
    L6:
        if (this.expandedTypeface == r10) goto L9;
        this.expandedTypeface = r10;
        return true;
    L9:
        return false;
    }

    private void setInterpolatedTextSize(float r10) {
        calculateUsingTextSize(r10);
        if (USE_SCALING_TEXTURE == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        this.useTexture = r11;
        if (r11 == false) goto L11;
        ensureExpandedTexture();
    L11:
        ViewCompat.g0(this.view);
        return;
    L5:
        if (this.scale == 1.0f) goto L7;
        r11 = true;
        goto L8
    }

    private boolean shouldDrawMultiline() {
        if (this.maxLines > 1) goto L5;
    L11:
        return false;
    L5:
        if (this.isRtl == false) goto L9;
        if (this.fadeModeEnabled == false) goto L11;
    L9:
        if (this.useTexture == true) goto L11;
        return true;
    }

    public float calculateCollapsedTextWidth() {
        if (this.text != null) goto L6;
        return 0.0f;
    L6:
        getTextPaintCollapsed(this.tmpPaint);
        TextPaint r10 = this.tmpPaint;
        CharSequence r11 = this.text;
        return r10.measureText(r11, 0, r11.length());
    }

    public void draw(@NonNull Canvas r10) {
        int r11 = r10.save();
        if (this.textToDraw != null) goto L5;
        return;
    L5:
        if (this.drawTitle == false) goto L35;
        boolean r12 = true;
        if (this.maxLines <= 1) goto L9;
        float r13 = this.textLayout.getLineStart(0);
    L10:
        float r14 = (this.currentDrawX + r13) - (this.expandedFirstLineDrawX * 2.0f);
        this.textPaint.setTextSize(this.currentTextSize);
        float r15 = this.currentDrawX;
        float r16 = this.currentDrawY;
        if (this.useTexture == true) goto L13;
    L15:
        r12 = false;
    L16:
        float r17 = this.scale;
        if (r17 != 1.0f) goto L19;
    L21:
        if (r12 == false) goto L25;
        r10.drawBitmap(this.expandedTitleTexture, r15, r16, this.texturePaint);
        r10.restoreToCount(r11);
        return;
    L25:
        if (shouldDrawMultiline() == true) goto L27;
    L31:
        r10.translate(r15, r16);
        this.textLayout.draw(r10);
    L32:
        r10.restoreToCount(r11);
        return;
    L27:
        if (this.fadeModeEnabled == true) goto L29;
    L30:
        drawMultilineTransition(r10, r14, r16);
        goto L32
    L29:
        if (this.expandedFraction <= this.fadeModeThresholdFraction) goto L31;
    L19:
        if (this.fadeModeEnabled == true) goto L21;
        r10.scale(r17, r17, r15, r16);
        goto L21
    L13:
        if (this.expandedTitleTexture == null) goto L15;
    L9:
        r13 = this.textLayout.getLineLeft(0);
        goto L10
    }

    public void getCollapsedTextActualBounds(@NonNull RectF r10, int r11, int r12) {
        this.isRtl = calculateIsRtl(this.text);
        r10.left = getCollapsedTextLeftBound(r11, r12);
        r10.top = this.collapsedBounds.top;
        r10.right = getCollapsedTextRightBound(r10, r11, r12);
        r10.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface r10 = this.collapsedTypeface;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return Typeface.DEFAULT;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return (-this.tmpPaint.ascent()) + this.tmpPaint.descent();
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface r10 = this.expandedTypeface;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout r10 = this.textLayout;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getLineCount();
    }

    @RequiresApi(23)
    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    @RequiresApi(23)
    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    public final boolean isStateful() {
        ColorStateList r10 = this.collapsedTextColor;
        if (r10 != null) goto L5;
    L6:
        ColorStateList r11 = this.expandedTextColor;
        if (r11 != null) goto L9;
    L11:
        return false;
    L9:
        if (r11.isStateful() == false) goto L11;
    L10:
        return true;
    L5:
        if (r10.isStateful() == true) goto L10;
        goto L6
    }

    public void onBoundsChanged() {
        if (this.collapsedBounds.width() > 0) goto L5;
    L11:
        boolean r10 = false;
    L12:
        this.drawTitle = r10;
        return;
    L5:
        if (this.collapsedBounds.height() <= 0) goto L11;
        if (this.expandedBounds.width() <= 0) goto L11;
        if (this.expandedBounds.height() <= 0) goto L11;
        r10 = true;
        goto L12
    }

    public void recalculate() {
        recalculate(false);
    }

    public void setCollapsedBounds(int r10, int r11, int r12, int r13) {
        if (rectEquals(this.collapsedBounds, r10, r11, r12, r13) == true) goto L6;
        this.collapsedBounds.set(r10, r11, r12, r13);
        this.boundsChanged = true;
        onBoundsChanged();
        return;
    }

    public void setCollapsedTextAppearance(int r10) {
        TextAppearance r11 = new TextAppearance(this.view.getContext(), r10);
        ColorStateList r12 = r11.textColor;
        if (r12 == null) goto L5;
        this.collapsedTextColor = r12;
    L5:
        float r13 = r11.textSize;
        if (r13 == 0.0f) goto L8;
        this.collapsedTextSize = r13;
    L8:
        ColorStateList r14 = r11.shadowColor;
        if (r14 == null) goto L11;
        this.collapsedShadowColor = r14;
    L11:
        this.collapsedShadowDx = r11.shadowDx;
        this.collapsedShadowDy = r11.shadowDy;
        this.collapsedShadowRadius = r11.shadowRadius;
        this.collapsedLetterSpacing = r11.letterSpacing;
        CancelableFontCallback r15 = this.collapsedFontCallback;
        if (r15 == null) goto L14;
        r15.cancel();
    L14:
        this.collapsedFontCallback = new CancelableFontCallback(new AnonymousClass1(this), r11.getFallbackFont());
        r11.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList r10) {
        if (this.collapsedTextColor == r10) goto L6;
        this.collapsedTextColor = r10;
        recalculate();
        return;
    }

    public void setCollapsedTextGravity(int r10) {
        if (this.collapsedTextGravity == r10) goto L6;
        this.collapsedTextGravity = r10;
        recalculate();
        return;
    }

    public void setCollapsedTextSize(float r10) {
        if (this.collapsedTextSize == r10) goto L6;
        this.collapsedTextSize = r10;
        recalculate();
        return;
    }

    public void setCollapsedTypeface(Typeface r10) {
        if (setCollapsedTypefaceInternal(r10) == false) goto L6;
        recalculate();
        return;
    }

    public void setCurrentOffsetY(int r10) {
        this.currentOffsetY = r10;
    }

    public void setExpandedBounds(int r10, int r11, int r12, int r13) {
        if (rectEquals(this.expandedBounds, r10, r11, r12, r13) == true) goto L6;
        this.expandedBounds.set(r10, r11, r12, r13);
        this.boundsChanged = true;
        onBoundsChanged();
        return;
    }

    public void setExpandedTextAppearance(int r10) {
        TextAppearance r11 = new TextAppearance(this.view.getContext(), r10);
        ColorStateList r12 = r11.textColor;
        if (r12 == null) goto L5;
        this.expandedTextColor = r12;
    L5:
        float r13 = r11.textSize;
        if (r13 == 0.0f) goto L8;
        this.expandedTextSize = r13;
    L8:
        ColorStateList r14 = r11.shadowColor;
        if (r14 == null) goto L11;
        this.expandedShadowColor = r14;
    L11:
        this.expandedShadowDx = r11.shadowDx;
        this.expandedShadowDy = r11.shadowDy;
        this.expandedShadowRadius = r11.shadowRadius;
        this.expandedLetterSpacing = r11.letterSpacing;
        CancelableFontCallback r15 = this.expandedFontCallback;
        if (r15 == null) goto L14;
        r15.cancel();
    L14:
        this.expandedFontCallback = new CancelableFontCallback(new AnonymousClass2(this), r11.getFallbackFont());
        r11.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList r10) {
        if (this.expandedTextColor == r10) goto L6;
        this.expandedTextColor = r10;
        recalculate();
        return;
    }

    public void setExpandedTextGravity(int r10) {
        if (this.expandedTextGravity == r10) goto L6;
        this.expandedTextGravity = r10;
        recalculate();
        return;
    }

    public void setExpandedTextSize(float r10) {
        if (this.expandedTextSize == r10) goto L6;
        this.expandedTextSize = r10;
        recalculate();
        return;
    }

    public void setExpandedTypeface(Typeface r10) {
        if (setExpandedTypefaceInternal(r10) == false) goto L6;
        recalculate();
        return;
    }

    public void setExpansionFraction(float r10) {
        float r11 = a.a(r10, 0.0f, 1.0f);
        if (r11 == this.expandedFraction) goto L6;
        this.expandedFraction = r11;
        calculateCurrentOffsets();
        return;
    }

    public void setFadeModeEnabled(boolean r10) {
        this.fadeModeEnabled = r10;
    }

    public void setFadeModeStartFraction(float r10) {
        this.fadeModeStartFraction = r10;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    @RequiresApi(23)
    public void setHyphenationFrequency(int r10) {
        this.hyphenationFrequency = r10;
    }

    @RequiresApi(23)
    public void setLineSpacingAdd(float r10) {
        this.lineSpacingAdd = r10;
    }

    @RequiresApi(23)
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float r10) {
        this.lineSpacingMultiplier = r10;
    }

    public void setMaxLines(int r10) {
        if (r10 == this.maxLines) goto L6;
        this.maxLines = r10;
        clearTexture();
        recalculate();
        return;
    }

    public void setPositionInterpolator(TimeInterpolator r10) {
        this.positionInterpolator = r10;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean r10) {
        this.isRtlTextDirectionHeuristicsEnabled = r10;
    }

    public final boolean setState(int[] r10) {
        this.state = r10;
        if (isStateful() == false) goto L6;
        recalculate();
        return true;
    L6:
        return false;
    }

    public void setText(@Nullable CharSequence r10) {
        if (r10 != null) goto L4;
    L5:
        this.text = r10;
        this.textToDraw = null;
        clearTexture();
        recalculate();
        return;
    L4:
        if (TextUtils.equals(this.text, r10) == false) goto L5;
    }

    public void setTextSizeInterpolator(TimeInterpolator r10) {
        this.textSizeInterpolator = r10;
        recalculate();
    }

    public void setTypefaces(Typeface r10) {
        boolean r11 = setCollapsedTypefaceInternal(r10);
        boolean r12 = setExpandedTypefaceInternal(r10);
        if (r11 == true) goto L5;
        if (r12 == true) goto L5;
        return;
    L5:
        recalculate();
    }

    private void calculateUsingTextSize(float r10, boolean r11) {
        if (this.text != null) goto L5;
        return;
    L5:
        float r12 = this.collapsedBounds.width();
        float r13 = this.expandedBounds.width();
        boolean r14 = false;
        int r15 = 1;
        if (isClose(r10, this.collapsedTextSize) == false) goto L11;
        float r16 = this.collapsedTextSize;
        this.scale = 1.0f;
        Typeface r17 = this.currentTypeface;
        Typeface r18 = this.collapsedTypeface;
        if (r17 == r18) goto L10;
        this.currentTypeface = r18;
        boolean r19 = true;
    L27:
        if (r12 <= 0.0f) goto L38;
        if (this.currentTextSize == r16) goto L31;
    L35:
        r19 = true;
    L36:
        this.currentTextSize = r16;
        this.boundsChanged = false;
        goto L38
    L31:
        if (this.boundsChanged == true) goto L35;
        if (r19 == true) goto L35;
        r19 = false;
    L38:
        if (this.textToDraw == null) goto L40;
        if (r19 == true) goto L40;
        return;
    L40:
        this.textPaint.setTextSize(this.currentTextSize);
        this.textPaint.setTypeface(this.currentTypeface);
        TextPaint r20 = this.textPaint;
        if (this.scale == 1.0f) goto L43;
        r14 = true;
    L43:
        r20.setLinearText(r14);
        this.isRtl = calculateIsRtl(this.text);
        if (shouldDrawMultiline() == false) goto L46;
        r15 = this.maxLines;
    L46:
        StaticLayout r21 = createStaticLayout(r15, r12, this.isRtl);
        this.textLayout = r21;
        this.textToDraw = r21.getText();
        return;
    L10:
        r19 = false;
        goto L27
    L11:
        float r22 = this.expandedTextSize;
        Typeface r23 = this.currentTypeface;
        Typeface r24 = this.expandedTypeface;
        if (r23 == r24) goto L14;
        this.currentTypeface = r24;
        boolean r25 = true;
    L16:
        if (isClose(r10, r22) == false) goto L18;
        this.scale = 1.0f;
    L19:
        float r26 = this.collapsedTextSize / this.expandedTextSize;
        float r27 = r13 * r26;
        if (r11 == false) goto L24;
    L21:
        r12 = r13;
    L22:
        r16 = r22;
        r19 = r25;
        goto L27
    L24:
        if (r27 <= r12) goto L21;
        r12 = Math.min(r12 / r26, r13);
        goto L22
    L18:
        this.scale = r10 / this.expandedTextSize;
        goto L19
    L14:
        r25 = false;
        goto L16
    }

    public void recalculate(boolean r10) {
        if (this.view.getHeight() > 0) goto L5;
    L6:
        if (r10 == false) goto L9;
    L7:
        calculateBaseOffsets(r10);
        calculateCurrentOffsets();
        return;
    L9:
        return;
    L5:
        if (this.view.getWidth() > 0) goto L7;
        goto L6
    }

    public void setCollapsedBounds(@NonNull Rect r10) {
        setCollapsedBounds(r10.left, r10.top, r10.right, r10.bottom);
    }

    public void setExpandedBounds(@NonNull Rect r10) {
        setExpandedBounds(r10.left, r10.top, r10.right, r10.bottom);
    }
}
