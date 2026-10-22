package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
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
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE = false;
    private boolean boundsChanged;
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
    private float collapsedTextWidth;
    private Typeface collapsedTypeface;
    private Typeface collapsedTypefaceBold;
    private Typeface collapsedTypefaceDefault;
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentLetterSpacing;
    private int currentOffsetY;
    private int currentShadowColor;
    private float currentShadowDx;
    private float currentShadowDy;
    private float currentShadowRadius;
    private float currentTextSize;
    private Typeface currentTypeface;
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private int expandedLineCount;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity;
    private float expandedTextSize;
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private Typeface expandedTypefaceBold;
    private Typeface expandedTypefaceDefault;
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
    private StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer;
    private CharSequence text;
    private StaticLayout textLayout;
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;
    private TextUtils.TruncateAt titleTextEllipsize;
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    static {
        USE_SCALING_TEXTURE = false;
        DEBUG_DRAW_PAINT = null;
    }

    public CollapsingTextHelper(View r3) {
        this.expandedTextGravity = 16;
        this.collapsedTextGravity = 16;
        this.expandedTextSize = 15.0f;
        this.collapsedTextSize = 15.0f;
        this.titleTextEllipsize = TextUtils.TruncateAt.END;
        this.isRtlTextDirectionHeuristicsEnabled = true;
        this.maxLines = 1;
        this.lineSpacingAdd = 0.0f;
        this.lineSpacingMultiplier = 1.0f;
        this.hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
        this.view = r3;
        TextPaint r0 = new TextPaint(129);
        this.textPaint = r0;
        this.tmpPaint = new TextPaint(r0);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
        maybeUpdateFontWeightAdjustment(r3.getContext().getResources().getConfiguration());
    }

    public void setTextSizeInterpolator(TimeInterpolator r1) {
        this.textSizeInterpolator = r1;
        recalculate();
    }

    public void setPositionInterpolator(TimeInterpolator r1) {
        this.positionInterpolator = r1;
        recalculate();
    }

    public TimeInterpolator getPositionInterpolator() {
        return this.positionInterpolator;
    }

    public void setExpandedTextSize(float r2) {
        if (this.expandedTextSize == r2) goto L6;
        this.expandedTextSize = r2;
        recalculate();
        return;
    }

    public void setCollapsedTextSize(float r2) {
        if (this.collapsedTextSize == r2) goto L6;
        this.collapsedTextSize = r2;
        recalculate();
        return;
    }

    public void setCollapsedTextColor(ColorStateList r2) {
        if (this.collapsedTextColor == r2) goto L6;
        this.collapsedTextColor = r2;
        recalculate();
        return;
    }

    public void setExpandedTextColor(ColorStateList r2) {
        if (this.expandedTextColor == r2) goto L6;
        this.expandedTextColor = r2;
        recalculate();
        return;
    }

    public void setCollapsedAndExpandedTextColor(ColorStateList r2) {
        if (this.collapsedTextColor == r2) goto L5;
    L6:
        this.collapsedTextColor = r2;
        this.expandedTextColor = r2;
        recalculate();
        return;
    L5:
        if (this.expandedTextColor != r2) goto L6;
    }

    public void setExpandedLetterSpacing(float r2) {
        if (this.expandedLetterSpacing == r2) goto L6;
        this.expandedLetterSpacing = r2;
        recalculate();
        return;
    }

    public void setExpandedBounds(int r2, int r3, int r4, int r5) {
        if (rectEquals(this.expandedBounds, r2, r3, r4, r5) == true) goto L6;
        this.expandedBounds.set(r2, r3, r4, r5);
        this.boundsChanged = true;
        return;
    }

    public void setExpandedBounds(Rect r4) {
        setExpandedBounds(r4.left, r4.top, r4.right, r4.bottom);
    }

    public void setCollapsedBounds(int r2, int r3, int r4, int r5) {
        if (rectEquals(this.collapsedBounds, r2, r3, r4, r5) == true) goto L6;
        this.collapsedBounds.set(r2, r3, r4, r5);
        this.boundsChanged = true;
        return;
    }

    public void setCollapsedBounds(Rect r4) {
        setCollapsedBounds(r4.left, r4.top, r4.right, r4.bottom);
    }

    public void getCollapsedTextActualBounds(RectF r3, int r4, int r5) {
        this.isRtl = calculateIsRtl(this.text);
        r3.left = Math.max(getCollapsedTextLeftBound(r4, r5), this.collapsedBounds.left);
        r3.top = this.collapsedBounds.top;
        r3.right = Math.min(getCollapsedTextRightBound(r3, r4, r5), this.collapsedBounds.right);
        r3.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
    }

    private float getCollapsedTextLeftBound(int r3, int r4) {
        if (r4 == 17) goto L23;
        if ((r4 & 7) == 1) goto L23;
        if ((r4 & GravityCompat.END) == 8388613) goto L18;
        if ((r4 & 5) == 5) goto L18;
        if (this.isRtl == false) goto L16;
        return this.collapsedBounds.right - this.collapsedTextWidth;
    L16:
        return this.collapsedBounds.left;
    L18:
        if (this.isRtl == false) goto L21;
        return this.collapsedBounds.left;
    L21:
        return this.collapsedBounds.right - this.collapsedTextWidth;
    L23:
        return (r3 / 2.0f) - (this.collapsedTextWidth / 2.0f);
    }

    private float getCollapsedTextRightBound(RectF r3, int r4, int r5) {
        if (r5 == 17) goto L23;
        if ((r5 & 7) == 1) goto L23;
        if ((r5 & GravityCompat.END) == 8388613) goto L18;
        if ((r5 & 5) == 5) goto L18;
        if (this.isRtl == false) goto L16;
        return this.collapsedBounds.right;
    L16:
        return this.collapsedTextWidth + r3.left;
    L18:
        if (this.isRtl == false) goto L21;
        return r3.left + this.collapsedTextWidth;
    L21:
        return this.collapsedBounds.right;
    L23:
        return (r4 / 2.0f) + (this.collapsedTextWidth / 2.0f);
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextFullHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return (-this.tmpPaint.ascent()) + this.tmpPaint.descent();
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public void setCurrentOffsetY(int r1) {
        this.currentOffsetY = r1;
    }

    public void setFadeModeStartFraction(float r1) {
        this.fadeModeStartFraction = r1;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    private float calculateFadeModeThresholdFraction() {
        float r2 = this.fadeModeStartFraction;
        return r2 + ((1.0f - r2) * 0.5f);
    }

    public void setFadeModeEnabled(boolean r1) {
        this.fadeModeEnabled = r1;
    }

    private void getTextPaintExpanded(TextPaint r2) {
        r2.setTextSize(this.expandedTextSize);
        r2.setTypeface(this.expandedTypeface);
        r2.setLetterSpacing(this.expandedLetterSpacing);
    }

    private void getTextPaintCollapsed(TextPaint r2) {
        r2.setTextSize(this.collapsedTextSize);
        r2.setTypeface(this.collapsedTypeface);
        r2.setLetterSpacing(this.collapsedLetterSpacing);
    }

    public void setExpandedTextGravity(int r2) {
        if (this.expandedTextGravity == r2) goto L6;
        this.expandedTextGravity = r2;
        recalculate();
        return;
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public void setCollapsedTextGravity(int r2) {
        if (this.collapsedTextGravity == r2) goto L6;
        this.collapsedTextGravity = r2;
        recalculate();
        return;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public void setCollapsedTextAppearance(int r4) {
        TextAppearance r0 = new TextAppearance(this.view.getContext(), r4);
        if (r0.getTextColor() == null) goto L6;
        this.collapsedTextColor = r0.getTextColor();
    L6:
        if (r0.getTextSize() == 0.0f) goto L9;
        this.collapsedTextSize = r0.getTextSize();
    L9:
        if (r0.shadowColor == null) goto L11;
        this.collapsedShadowColor = r0.shadowColor;
    L11:
        this.collapsedShadowDx = r0.shadowDx;
        this.collapsedShadowDy = r0.shadowDy;
        this.collapsedShadowRadius = r0.shadowRadius;
        this.collapsedLetterSpacing = r0.letterSpacing;
        CancelableFontCallback r5 = this.collapsedFontCallback;
        if (r5 == null) goto L14;
        r5.cancel();
    L14:
        this.collapsedFontCallback = new CancelableFontCallback(new AnonymousClass1(this), r0.getFallbackFont());
        r0.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setExpandedTextAppearance(int r4) {
        TextAppearance r0 = new TextAppearance(this.view.getContext(), r4);
        if (r0.getTextColor() == null) goto L6;
        this.expandedTextColor = r0.getTextColor();
    L6:
        if (r0.getTextSize() == 0.0f) goto L9;
        this.expandedTextSize = r0.getTextSize();
    L9:
        if (r0.shadowColor == null) goto L11;
        this.expandedShadowColor = r0.shadowColor;
    L11:
        this.expandedShadowDx = r0.shadowDx;
        this.expandedShadowDy = r0.shadowDy;
        this.expandedShadowRadius = r0.shadowRadius;
        this.expandedLetterSpacing = r0.letterSpacing;
        CancelableFontCallback r5 = this.expandedFontCallback;
        if (r5 == null) goto L14;
        r5.cancel();
    L14:
        this.expandedFontCallback = new CancelableFontCallback(new AnonymousClass2(this), r0.getFallbackFont());
        r0.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setTitleTextEllipsize(TextUtils.TruncateAt r1) {
        this.titleTextEllipsize = r1;
        recalculate();
    }

    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.titleTextEllipsize;
    }

    public void setCollapsedTypeface(Typeface r1) {
        if (setCollapsedTypefaceInternal(r1) == false) goto L6;
        recalculate();
        return;
    }

    public void setExpandedTypeface(Typeface r1) {
        if (setExpandedTypefaceInternal(r1) == false) goto L6;
        recalculate();
        return;
    }

    public void setTypefaces(Typeface r2) {
        boolean r0 = setCollapsedTypefaceInternal(r2);
        boolean r3 = setExpandedTypefaceInternal(r2);
        if (r0 == true) goto L5;
        if (r3 == true) goto L5;
        return;
    L5:
        recalculate();
    }

    private boolean setCollapsedTypefaceInternal(Typeface r2) {
        CancelableFontCallback r0 = this.collapsedFontCallback;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (this.collapsedTypefaceDefault == r2) goto L12;
        this.collapsedTypefaceDefault = r2;
        Typeface r3 = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), r2);
        this.collapsedTypefaceBold = r3;
        if (r3 != null) goto L10;
        r3 = this.collapsedTypefaceDefault;
    L10:
        this.collapsedTypeface = r3;
        return true;
    L12:
        return false;
    }

    private boolean setExpandedTypefaceInternal(Typeface r2) {
        CancelableFontCallback r0 = this.expandedFontCallback;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (this.expandedTypefaceDefault == r2) goto L12;
        this.expandedTypefaceDefault = r2;
        Typeface r3 = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), r2);
        this.expandedTypefaceBold = r3;
        if (r3 != null) goto L10;
        r3 = this.expandedTypefaceDefault;
    L10:
        this.expandedTypeface = r3;
        return true;
    L12:
        return false;
    }

    public Typeface getCollapsedTypeface() {
        Typeface r0 = this.collapsedTypeface;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Typeface.DEFAULT;
    }

    public Typeface getExpandedTypeface() {
        Typeface r0 = this.expandedTypeface;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Typeface.DEFAULT;
    }

    public void maybeUpdateFontWeightAdjustment(Configuration r2) {
        Typeface r0 = this.collapsedTypefaceDefault;
        if (r0 == null) goto L5;
        this.collapsedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(r2, r0);
    L5:
        Typeface r1 = this.expandedTypefaceDefault;
        if (r1 == null) goto L8;
        this.expandedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(r2, r1);
    L8:
        Typeface r3 = this.collapsedTypefaceBold;
        if (r3 != null) goto L12;
        r3 = this.collapsedTypefaceDefault;
    L12:
        this.collapsedTypeface = r3;
        Typeface r4 = this.expandedTypefaceBold;
        if (r4 != null) goto L16;
        r4 = this.expandedTypefaceDefault;
    L16:
        this.expandedTypeface = r4;
        recalculate(true);
    }

    public void setExpansionFraction(float r3) {
        float r4 = MathUtils.clamp(r3, 0.0f, 1.0f);
        if (r4 == this.expandedFraction) goto L6;
        this.expandedFraction = r4;
        calculateCurrentOffsets();
        return;
    }

    public final boolean setState(int[] r1) {
        this.state = r1;
        if (isStateful() == false) goto L6;
        recalculate();
        return true;
    L6:
        return false;
    }

    public final boolean isStateful() {
        ColorStateList r0 = this.collapsedTextColor;
        if (r0 != null) goto L5;
    L6:
        ColorStateList r1 = this.expandedTextColor;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.isStateful() == false) goto L11;
    L10:
        return true;
    L5:
        if (r0.isStateful() == true) goto L10;
        goto L6
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean r1) {
        this.isRtlTextDirectionHeuristicsEnabled = r1;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private void calculateOffsets(float r6) {
        interpolateBounds(r6);
        if (this.fadeModeEnabled == true) goto L5;
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, r6, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, r6, this.positionInterpolator);
        setInterpolatedTextSize(r6);
        float r0 = r6;
    L9:
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - r6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        setExpandedTextBlend(lerp(1.0f, 0.0f, r6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (this.collapsedTextColor == this.expandedTextColor) goto L12;
        this.textPaint.setColor(blendARGB(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), r0));
    L13:
        float r1 = this.collapsedLetterSpacing;
        float r2 = this.expandedLetterSpacing;
        if (r1 == r2) goto L16;
        this.textPaint.setLetterSpacing(lerp(r2, r1, r6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
    L17:
        this.currentShadowRadius = lerp(this.expandedShadowRadius, this.collapsedShadowRadius, r6, null);
        this.currentShadowDx = lerp(this.expandedShadowDx, this.collapsedShadowDx, r6, null);
        this.currentShadowDy = lerp(this.expandedShadowDy, this.collapsedShadowDy, r6, null);
        int r3 = blendARGB(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), r6);
        this.currentShadowColor = r3;
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, r3);
        if (this.fadeModeEnabled == false) goto L20;
        this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(r6) * this.textPaint.getAlpha()));
    L20:
        ViewCompat.postInvalidateOnAnimation(this.view);
        return;
    L16:
        this.textPaint.setLetterSpacing(r1);
        goto L17
    L12:
        this.textPaint.setColor(getCurrentCollapsedTextColor());
        goto L13
    L5:
        if (r6 >= this.fadeModeThresholdFraction) goto L7;
        this.currentDrawX = this.expandedDrawX;
        this.currentDrawY = this.expandedDrawY;
        setInterpolatedTextSize(0.0f);
        r0 = 0.0f;
        goto L9
    L7:
        this.currentDrawX = this.collapsedDrawX;
        this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
        setInterpolatedTextSize(1.0f);
        r0 = 1.0f;
        goto L9
    }

    private float calculateFadeModeTextAlpha(float r5) {
        float r0 = this.fadeModeThresholdFraction;
        if (r5 > r0) goto L7;
        return AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, r0, r5);
    L7:
        return AnimationUtils.lerp(0.0f, 1.0f, r0, 1.0f, r5);
    }

    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    private int getCurrentColor(ColorStateList r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        int[] r1 = this.state;
        if (r1 == null) goto L10;
        return r2.getColorForState(r1, 0);
    L10:
        return r2.getDefaultColor();
    }

    private void calculateBaseOffsets(boolean r10) {
        calculateUsingTextSize(1.0f, r10);
        CharSequence r0 = this.textToDraw;
        if (r0 == null) goto L7;
        StaticLayout r1 = this.textLayout;
        if (r1 == null) goto L7;
        this.textToDrawCollapsed = TextUtils.ellipsize(r0, this.textPaint, r1.getWidth(), this.titleTextEllipsize);
    L7:
        CharSequence r2 = this.textToDrawCollapsed;
        float r3 = 0.0f;
        if (r2 == null) goto L10;
        this.collapsedTextWidth = measureTextWidth(this.textPaint, r2);
    L11:
        int r4 = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int r5 = r4 & 112;
        if (r5 == 48) goto L16;
        if (r5 == 80) goto L15;
        this.collapsedDrawY = this.collapsedBounds.centerY() - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
    L17:
        int r6 = r4 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r6 == 1) goto L22;
        if (r6 == 5) goto L21;
        this.collapsedDrawX = this.collapsedBounds.left;
    L23:
        calculateUsingTextSize(0.0f, r10);
        StaticLayout r11 = this.textLayout;
        if (r11 == null) goto L26;
        float r12 = r11.getHeight();
    L27:
        StaticLayout r7 = this.textLayout;
        if (r7 != null) goto L30;
    L32:
        CharSequence r8 = this.textToDraw;
        if (r8 == null) goto L35;
        r3 = measureTextWidth(this.textPaint, r8);
    L35:
        StaticLayout r9 = this.textLayout;
        if (r9 == null) goto L38;
        int r13 = r9.getLineCount();
    L39:
        this.expandedLineCount = r13;
        int r14 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int r15 = r14 & 112;
        if (r15 == 48) goto L44;
        if (r15 == 80) goto L43;
        this.expandedDrawY = this.expandedBounds.centerY() - (r12 / 2.0f);
    L45:
        int r16 = r14 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r16 == 1) goto L50;
        if (r16 == 5) goto L49;
        this.expandedDrawX = this.expandedBounds.left;
    L51:
        clearTexture();
        setInterpolatedTextSize(this.expandedFraction);
        return;
    L49:
        this.expandedDrawX = this.expandedBounds.right - r3;
        goto L51
    L50:
        this.expandedDrawX = this.expandedBounds.centerX() - (r3 / 2.0f);
        goto L51
    L43:
        this.expandedDrawY = (this.expandedBounds.bottom - r12) + this.textPaint.descent();
        goto L45
    L44:
        this.expandedDrawY = this.expandedBounds.top;
        goto L45
    L38:
        r13 = 0;
        goto L39
    L30:
        if (this.maxLines <= 1) goto L32;
        r3 = r7.getWidth();
        goto L35
    L26:
        r12 = 0.0f;
        goto L27
    L21:
        this.collapsedDrawX = this.collapsedBounds.right - this.collapsedTextWidth;
        goto L23
    L22:
        this.collapsedDrawX = this.collapsedBounds.centerX() - (this.collapsedTextWidth / 2.0f);
        goto L23
    L15:
        this.collapsedDrawY = this.collapsedBounds.bottom + this.textPaint.ascent();
        goto L17
    L16:
        this.collapsedDrawY = this.collapsedBounds.top;
        goto L17
    L10:
        this.collapsedTextWidth = 0.0f;
        goto L11
    }

    private float measureTextWidth(TextPaint r2, CharSequence r3) {
        return r2.measureText(r3, 0, r3.length());
    }

    private void interpolateBounds(float r5) {
        if (this.fadeModeEnabled == false) goto L9;
        RectF r0 = this.currentBounds;
        if (r5 >= this.fadeModeThresholdFraction) goto L7;
        Rect r4 = this.expandedBounds;
    L8:
        r0.set(r4);
        return;
    L7:
        r4 = this.collapsedBounds;
        goto L8
    L9:
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, r5, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, r5, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, r5, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, r5, this.positionInterpolator);
    }

    private void setCollapsedTextBlend(float r1) {
        this.collapsedTextBlend = r1;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private void setExpandedTextBlend(float r1) {
        this.expandedTextBlend = r1;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    public void draw(Canvas r8) {
        int r0 = r8.save();
        if (this.textToDraw != null) goto L5;
        return;
    L5:
        if (this.currentBounds.width() > 0.0f) goto L7;
        return;
    L7:
        if (this.currentBounds.height() <= 0.0f) goto L34;
        this.textPaint.setTextSize(this.currentTextSize);
        float r1 = this.currentDrawX;
        float r2 = this.currentDrawY;
        if (this.useTexture == true) goto L11;
    L13:
        boolean r3 = false;
    L14:
        float r5 = this.scale;
        if (r5 != 1.0f) goto L17;
    L19:
        if (r3 == false) goto L23;
        r8.drawBitmap(this.expandedTitleTexture, r1, r2, this.texturePaint);
        r8.restoreToCount(r0);
        return;
    L23:
        if (shouldDrawMultiline() == true) goto L25;
    L29:
        r8.translate(r1, r2);
        this.textLayout.draw(r8);
    L30:
        r8.restoreToCount(r0);
        return;
    L25:
        if (this.fadeModeEnabled == true) goto L27;
    L28:
        drawMultilineTransition(r8, this.currentDrawX - this.textLayout.getLineStart(0), r2);
        goto L30
    L27:
        if (this.expandedFraction <= this.fadeModeThresholdFraction) goto L29;
    L17:
        if (this.fadeModeEnabled == true) goto L19;
        r8.scale(r5, r5, r1, r2);
        goto L19
    L11:
        if (this.expandedTitleTexture == null) goto L13;
        r3 = true;
        goto L14
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

    private void drawMultilineTransition(Canvas r11, float r12, float r13) {
        int r0 = this.textPaint.getAlpha();
        r11.translate(r12, r13);
        if (this.fadeModeEnabled == true) goto L6;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * r0));
        TextPaint r1 = this.textPaint;
        r1.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, r1.getAlpha()));
        this.textLayout.draw(r11);
    L6:
        if (this.fadeModeEnabled == true) goto L8;
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * r0));
    L8:
        TextPaint r2 = this.textPaint;
        r2.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, r2.getAlpha()));
        int r3 = this.textLayout.getLineBaseline(0);
        CharSequence r4 = this.textToDrawCollapsed;
        float r5 = r3;
        r11.drawText(r4, 0, r4.length(), 0.0f, r5, this.textPaint);
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, this.currentShadowColor);
        if (this.fadeModeEnabled == true) goto L15;
        String r6 = this.textToDrawCollapsed.toString().trim();
        if (r6.endsWith("…") == false) goto L13;
        r6 = r6.substring(0, r6.length() - 1);
    L13:
        String r7 = r6;
        this.textPaint.setAlpha(r0);
        r11.drawText(r7, 0, Math.min(this.textLayout.getLineEnd(0), r7.length()), 0.0f, r5, this.textPaint);
        return;
    }

    private boolean calculateIsRtl(CharSequence r3) {
        boolean r0 = isDefaultIsRtl();
        if (this.isRtlTextDirectionHeuristicsEnabled == true) goto L5;
        return r0;
    L5:
        return isTextDirectionHeuristicsIsRtl(r3, r0);
    }

    private boolean isDefaultIsRtl() {
        if (ViewCompat.getLayoutDirection(this.view) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isTextDirectionHeuristicsIsRtl(CharSequence r2, boolean r3) {
        if (r3 == false) goto L4;
        TextDirectionHeuristicCompat r1 = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    L6:
        return r1.isRtl(r2, 0, r2.length());
    L4:
        r1 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        goto L6
    }

    private void setInterpolatedTextSize(float r2) {
        calculateUsingTextSize(r2);
        if (USE_SCALING_TEXTURE == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.useTexture = r3;
        if (r3 == false) goto L11;
        ensureExpandedTexture();
    L11:
        ViewCompat.postInvalidateOnAnimation(this.view);
        return;
    L5:
        if (this.scale == 1.0f) goto L7;
        r3 = true;
        goto L8
    }

    private void calculateUsingTextSize(float r2) {
        calculateUsingTextSize(r2, false);
    }

    private void calculateUsingTextSize(float r11, boolean r12) {
        if (this.text != null) goto L5;
        return;
    L5:
        float r0 = this.collapsedBounds.width();
        float r1 = this.expandedBounds.width();
        if (isClose(r11, 1.0f) == false) goto L8;
        float r13 = this.collapsedTextSize;
        float r14 = this.collapsedLetterSpacing;
        this.scale = 1.0f;
        Typeface r2 = this.collapsedTypeface;
    L19:
        int r4 = 1;
        boolean r5 = false;
        if (r0 <= 0.0f) goto L53;
        if (this.currentTextSize == r13) goto L24;
        boolean r3 = true;
    L26:
        if (this.currentLetterSpacing == r14) goto L28;
        boolean r6 = true;
    L30:
        if (this.currentTypeface == r2) goto L32;
        boolean r7 = true;
    L33:
        StaticLayout r8 = this.textLayout;
        if (r8 != null) goto L36;
    L38:
        boolean r9 = false;
    L39:
        if (r3 == true) goto L47;
        if (r6 == true) goto L47;
        if (r9 == true) goto L47;
        if (r7 == true) goto L47;
        if (this.boundsChanged == true) goto L47;
        boolean r10 = false;
    L48:
        this.currentTextSize = r13;
        this.currentLetterSpacing = r14;
        this.currentTypeface = r2;
        this.boundsChanged = false;
        TextPaint r15 = this.textPaint;
        if (this.scale == 1.0f) goto L51;
        r5 = true;
    L51:
        r15.setLinearText(r5);
        r5 = r10;
    L47:
        r10 = true;
        goto L48
    L36:
        if (r0 == r8.getWidth()) goto L38;
        r9 = true;
        goto L39
    L32:
        r7 = false;
        goto L33
    L28:
        r6 = false;
        goto L30
    L24:
        r3 = false;
    L53:
        if (this.textToDraw == null) goto L55;
        if (r5 == true) goto L55;
        return;
    L55:
        this.textPaint.setTextSize(this.currentTextSize);
        this.textPaint.setTypeface(this.currentTypeface);
        this.textPaint.setLetterSpacing(this.currentLetterSpacing);
        this.isRtl = calculateIsRtl(this.text);
        if (shouldDrawMultiline() == false) goto L58;
        r4 = this.maxLines;
    L58:
        StaticLayout r16 = createStaticLayout(r4, r0, this.isRtl);
        this.textLayout = r16;
        this.textToDraw = r16.getText();
        return;
    L8:
        float r17 = this.expandedTextSize;
        float r18 = this.expandedLetterSpacing;
        Typeface r19 = this.expandedTypeface;
        if (isClose(r11, 0.0f) == false) goto L11;
        this.scale = 1.0f;
    L12:
        float r110 = this.collapsedTextSize / this.expandedTextSize;
        float r20 = r1 * r110;
        if (r12 == false) goto L17;
    L14:
        r0 = r1;
    L15:
        r13 = r17;
        r14 = r18;
        r2 = r19;
        goto L19
    L17:
        if (r20 <= r0) goto L14;
        r0 = Math.min(r0 / r110, r1);
        goto L15
    L11:
        this.scale = lerp(this.expandedTextSize, this.collapsedTextSize, r11, this.textSizeInterpolator) / this.expandedTextSize;
        goto L12
    }

    private StaticLayout createStaticLayout(int r4, float r5, boolean r6) {
        if (r4 != 1) goto L5;
        Layout.Alignment r0 = Layout.Alignment.ALIGN_NORMAL;     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L8
    L6:
        StaticLayout r3 = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) r5).setEllipsize(this.titleTextEllipsize).setIsRtl(r6).setAlignment(r0).setIncludePad(false).setMaxLines(r4).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).setStaticLayoutBuilderConfigurer(this.staticLayoutBuilderConfigurer).build();     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L8
    L11:
        return (StaticLayout) Preconditions.checkNotNull(r3);
    L5:
        r0 = getMultilineTextLayoutAlignment();     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L8
    L8:
        e = move-exception;
        Log.e(TAG, e.getCause().getMessage(), e);
        r3 = null;
        goto L11
    }

    private Layout.Alignment getMultilineTextLayoutAlignment() {
        int r0 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0) & 7;
        if (r0 == 1) goto L17;
        if (r0 == 5) goto L12;
        if (this.isRtl == false) goto L10;
        return Layout.Alignment.ALIGN_OPPOSITE;
    L10:
        return Layout.Alignment.ALIGN_NORMAL;
    L12:
        if (this.isRtl == false) goto L15;
        return Layout.Alignment.ALIGN_NORMAL;
    L15:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L17:
        return Layout.Alignment.ALIGN_CENTER;
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
        int r0 = this.textLayout.getWidth();
        int r1 = this.textLayout.getHeight();
        if (r0 <= 0) goto L19;
        if (r1 <= 0) goto L22;
        this.expandedTitleTexture = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(this.expandedTitleTexture);
        this.textLayout.draw(r2);
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

    public void recalculate() {
        recalculate(false);
    }

    public void recalculate(boolean r2) {
        if (this.view.getHeight() > 0) goto L5;
    L6:
        if (r2 == false) goto L9;
    L7:
        calculateBaseOffsets(r2);
        calculateCurrentOffsets();
        return;
    L9:
        return;
    L5:
        if (this.view.getWidth() > 0) goto L7;
        goto L6
    }

    public void setText(CharSequence r2) {
        if (r2 != null) goto L4;
    L5:
        this.text = r2;
        this.textToDraw = null;
        clearTexture();
        recalculate();
        return;
    L4:
        if (TextUtils.equals(this.text, r2) == false) goto L5;
    }

    public CharSequence getText() {
        return this.text;
    }

    private void clearTexture() {
        Bitmap r0 = this.expandedTitleTexture;
        if (r0 == null) goto L6;
        r0.recycle();
        this.expandedTitleTexture = null;
        return;
    }

    public void setMaxLines(int r2) {
        if (r2 == this.maxLines) goto L6;
        this.maxLines = r2;
        clearTexture();
        recalculate();
        return;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public int getLineCount() {
        StaticLayout r0 = this.textLayout;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getLineCount();
    }

    public int getExpandedLineCount() {
        return this.expandedLineCount;
    }

    public void setLineSpacingAdd(float r1) {
        this.lineSpacingAdd = r1;
    }

    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    public void setLineSpacingMultiplier(float r1) {
        this.lineSpacingMultiplier = r1;
    }

    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    public void setHyphenationFrequency(int r1) {
        this.hyphenationFrequency = r1;
    }

    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public void setStaticLayoutBuilderConfigurer(StaticLayoutBuilderConfigurer r2) {
        if (this.staticLayoutBuilderConfigurer == r2) goto L6;
        this.staticLayoutBuilderConfigurer = r2;
        recalculate(true);
        return;
    }

    private static boolean isClose(float r0, float r1) {
        if (Math.abs(r0 - r1) >= 1.0E-5f) goto L5;
        return true;
    L5:
        return false;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    private static int blendARGB(int r5, int r6, float r7) {
        float r0 = 1.0f - r7;
        return Color.argb(Math.round((Color.alpha(r5) * r0) + (Color.alpha(r6) * r7)), Math.round((Color.red(r5) * r0) + (Color.red(r6) * r7)), Math.round((Color.green(r5) * r0) + (Color.green(r6) * r7)), Math.round((Color.blue(r5) * r0) + (Color.blue(r6) * r7)));
    }

    private static float lerp(float r0, float r1, float r2, TimeInterpolator r3) {
        if (r3 == null) goto L5;
        r2 = r3.getInterpolation(r2);
    L5:
        return AnimationUtils.lerp(r0, r1, r2);
    }

    private static boolean rectEquals(Rect r1, int r2, int r3, int r4, int r5) {
        if (r1.left == r2) goto L5;
    L11:
        return false;
    L5:
        if (r1.top != r3) goto L11;
        if (r1.right != r4) goto L11;
        if (r1.bottom != r5) goto L11;
        return true;
    }
}
