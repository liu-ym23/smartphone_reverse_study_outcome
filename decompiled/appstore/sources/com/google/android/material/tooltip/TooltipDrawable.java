package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.graphics.d;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {

    @StyleRes
    private static final int DEFAULT_STYLE = 0;

    @AttrRes
    private static final int DEFAULT_THEME_ATTR = 0;
    private int arrowSize;

    @NonNull
    private final View.OnLayoutChangeListener attachedViewLayoutChangeListener;

    @NonNull
    private final Context context;

    @NonNull
    private final Rect displayFrame;

    @Nullable
    private final Paint.FontMetrics fontMetrics;
    private float labelOpacity;
    private int layoutMargin;
    private int locationOnScreenX;
    private int minHeight;
    private int minWidth;
    private int padding;

    @Nullable
    private CharSequence text;

    @NonNull
    private final TextDrawableHelper textDrawableHelper;
    private final float tooltipPivotX;
    private float tooltipPivotY;
    private float tooltipScaleX;
    private float tooltipScaleY;

    static {
        DEFAULT_STYLE = R.style.Widget_MaterialComponents_Tooltip;
        DEFAULT_THEME_ATTR = R.attr.tooltipStyle;
    }

    private TooltipDrawable(@NonNull Context r10, AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(r10, r11, r12, r13);
        this.fontMetrics = new Paint.FontMetrics();
        TextDrawableHelper r14 = new TextDrawableHelper(this);
        this.textDrawableHelper = r14;
        this.attachedViewLayoutChangeListener = new AnonymousClass1(this);
        this.displayFrame = new Rect();
        this.tooltipScaleX = 1.0f;
        this.tooltipScaleY = 1.0f;
        this.tooltipPivotX = 0.5f;
        this.tooltipPivotY = 0.5f;
        this.labelOpacity = 1.0f;
        this.context = r10;
        TextPaint r15 = r14.getTextPaint();
        r15.density = r10.getResources().getDisplayMetrics().density;
        r14.getTextPaint().setTextAlign(Paint.Align.CENTER);
    }

    public static /* synthetic */ void access$000(TooltipDrawable r10, View r11) {
        r10.updateLocationOnScreen(r11);
    }

    private float calculatePointerOffset() {
        if ((((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin) >= 0) goto L7;
        int r10 = ((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
    L11:
        return r10;
    L7:
        if ((((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin) <= 0) goto L9;
        r10 = ((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
        goto L11
    L9:
        return 0.0f;
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        Paint.FontMetrics r10 = this.fontMetrics;
        return (r10.descent + r10.ascent) / 2.0f;
    }

    private float calculateTextOriginAndAlignment(@NonNull Rect r10) {
        return r10.centerY() - calculateTextCenterFromBaseline();
    }

    @NonNull
    public static TooltipDrawable create(@NonNull Context r10) {
        return createFromAttributes(r10, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    @NonNull
    public static TooltipDrawable createFromAttributes(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        TooltipDrawable r14 = new TooltipDrawable(r10, r11, r12, r13);
        r14.loadFromAttributes(r11, r12, r13);
        return r14;
    }

    private EdgeTreatment createMarkerEdge() {
        float r10 = -calculatePointerOffset();
        float r11 = ((float) (((double) getBounds().width()) - (((double) this.arrowSize) * Math.sqrt(2.0d)))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.arrowSize), Math.min(Math.max(r10, -r11), r11));
    }

    private void drawText(@NonNull Canvas r12) {
        if (this.text != null) goto L5;
        return;
    L5:
        Rect r10 = getBounds();
        int r11 = (int) calculateTextOriginAndAlignment(r10);
        if (this.textDrawableHelper.getTextAppearance() == null) goto L8;
        this.textDrawableHelper.getTextPaint().drawableState = getState();
        this.textDrawableHelper.updateTextPaintDrawState(this.context);
        this.textDrawableHelper.getTextPaint().setAlpha((int) (this.labelOpacity * 255.0f));
    L8:
        CharSequence r13 = this.text;
        r12.drawText(r13, 0, r13.length(), r10.centerX(), r11, this.textDrawableHelper.getTextPaint());
    }

    private float getTextWidth() {
        CharSequence r10 = this.text;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return this.textDrawableHelper.getTextWidth(r10.toString());
    }

    private void loadFromAttributes(@Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(this.context, r10, R.styleable.Tooltip, r11, r12, new int[0]);
        this.arrowSize = this.context.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
        setText(r13.getText(R.styleable.Tooltip_android_text));
        setTextAppearance(MaterialResources.getTextAppearance(this.context, r13, R.styleable.Tooltip_android_textAppearance));
        int r14 = MaterialColors.getColor(this.context, R.attr.colorOnBackground, TooltipDrawable.class.getCanonicalName());
        int r15 = MaterialColors.layer(d.k(MaterialColors.getColor(this.context, android.R.attr.colorBackground, TooltipDrawable.class.getCanonicalName()), 229), d.k(r14, 153));
        setFillColor(ColorStateList.valueOf(r13.getColor(R.styleable.Tooltip_backgroundTint, r15)));
        setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(this.context, R.attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
        this.padding = r13.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.minWidth = r13.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.minHeight = r13.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.layoutMargin = r13.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        r13.recycle();
    }

    private void updateLocationOnScreen(@NonNull View r10) {
        int[] r11 = new int[2];
        r10.getLocationOnScreen(r11);
        this.locationOnScreenX = r11[0];
        r10.getWindowVisibleDisplayFrame(this.displayFrame);
    }

    public void detachView(@Nullable View r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.removeOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        r10.save();
        float r11 = calculatePointerOffset();
        float r12 = (float) (-((((double) this.arrowSize) * Math.sqrt(2.0d)) - ((double) this.arrowSize)));
        r10.scale(this.tooltipScaleX, this.tooltipScaleY, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.tooltipPivotY));
        r10.translate(r11, r12);
        super.draw(r10);
        drawText(r10);
        r10.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.textDrawableHelper.getTextPaint().getTextSize(), this.minHeight);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.padding * 2) + getTextWidth(), this.minWidth);
    }

    public int getLayoutMargin() {
        return this.layoutMargin;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public int getTextPadding() {
        return this.padding;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r10) {
        super.onBoundsChange(r10);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] r10) {
        return super.onStateChange(r10);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setLayoutMargin(@Px int r10) {
        this.layoutMargin = r10;
        invalidateSelf();
    }

    public void setMinHeight(@Px int r10) {
        this.minHeight = r10;
        invalidateSelf();
    }

    public void setMinWidth(@Px int r10) {
        this.minWidth = r10;
        invalidateSelf();
    }

    public void setRelativeToView(@Nullable View r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        updateLocationOnScreen(r10);
        r10.addOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    public void setRevealFraction(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        this.tooltipPivotY = 1.2f;
        this.tooltipScaleX = r10;
        this.tooltipScaleY = r10;
        this.labelOpacity = AnimationUtils.lerp(0.0f, 1.0f, 0.19f, 1.0f, r10);
        invalidateSelf();
    }

    public void setText(@Nullable CharSequence r10) {
        if (TextUtils.equals(this.text, r10) == true) goto L6;
        this.text = r10;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
        return;
    }

    public void setTextAppearance(@Nullable TextAppearance r10) {
        this.textDrawableHelper.setTextAppearance(r10, this.context);
    }

    public void setTextAppearanceResource(@StyleRes int r10) {
        setTextAppearance(new TextAppearance(this.context, r10));
    }

    public void setTextPadding(@Px int r10) {
        this.padding = r10;
        invalidateSelf();
    }

    public void setTextResource(@StringRes int r10) {
        setText(this.context.getResources().getString(r10));
    }

    @NonNull
    public static TooltipDrawable createFromAttributes(@NonNull Context r10, @Nullable AttributeSet r11) {
        return createFromAttributes(r10, r11, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }
}
