package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import c.a;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class ShapeableImageView extends AppCompatImageView implements Shapeable {
    private static final int DEF_STYLE_RES = 0;
    private static final int UNDEFINED_PADDING = Integer.MIN_VALUE;
    private final Paint borderPaint;

    @Dimension
    private int bottomContentPadding;
    private final Paint clearPaint;
    private final RectF destination;

    @Dimension
    private int endContentPadding;
    private boolean hasAdjustedPaddingAfterLayoutDirectionResolved;

    @Dimension
    private int leftContentPadding;
    private Path maskPath;
    private final RectF maskRect;
    private final Path path;
    private final ShapeAppearancePathProvider pathProvider;

    @Dimension
    private int rightContentPadding;

    @Nullable
    private MaterialShapeDrawable shadowDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;

    @Dimension
    private int startContentPadding;

    @Nullable
    private ColorStateList strokeColor;

    @Dimension
    private float strokeWidth;

    @Dimension
    private int topContentPadding;

    @TargetApi(21)
    public class OutlineProvider extends ViewOutlineProvider {
        private final Rect rect;
        final /* synthetic */ ShapeableImageView this$0;

        public OutlineProvider(ShapeableImageView r10) {
            this.this$0 = r10;
            this.rect = new Rect();
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            if (ShapeableImageView.access$000(this.this$0) != null) goto L6;
            return;
        L6:
            if (ShapeableImageView.access$100(this.this$0) != null) goto L8;
            ShapeableImageView.access$102(this.this$0, new MaterialShapeDrawable(ShapeableImageView.access$000(this.this$0)));
        L8:
            ShapeableImageView.access$200(this.this$0).round(this.rect);
            ShapeableImageView.access$100(this.this$0).setBounds(this.rect);
            ShapeableImageView.access$100(this.this$0).getOutline(r11);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ShapeableImageView;
    }

    public ShapeableImageView(Context r10) {
        this(r10, null, 0);
    }

    public static /* synthetic */ ShapeAppearanceModel access$000(ShapeableImageView r10) {
        return r10.shapeAppearanceModel;
    }

    public static /* synthetic */ MaterialShapeDrawable access$100(ShapeableImageView r10) {
        return r10.shadowDrawable;
    }

    public static /* synthetic */ MaterialShapeDrawable access$102(ShapeableImageView r10, MaterialShapeDrawable r11) {
        r10.shadowDrawable = r11;
        return r11;
    }

    public static /* synthetic */ RectF access$200(ShapeableImageView r10) {
        return r10.destination;
    }

    private void drawStroke(Canvas r10) {
        if (this.strokeColor != null) goto L5;
        return;
    L5:
        this.borderPaint.setStrokeWidth(this.strokeWidth);
        int r11 = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
        if (this.strokeWidth <= 0.0f) goto L10;
        if (r11 == 0) goto L11;
        this.borderPaint.setColor(r11);
        r10.drawPath(this.path, this.borderPaint);
        return;
    L11:
        return;
    }

    private boolean isContentPaddingRelative() {
        if (this.startContentPadding == Integer.MIN_VALUE) goto L5;
    L8:
        return true;
    L5:
        if (this.endContentPadding != Integer.MIN_VALUE) goto L8;
        return false;
    }

    private boolean isRtl() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void updateShapeMask(int r10, int r11) {
        this.destination.set(getPaddingLeft(), getPaddingTop(), r10 - getPaddingRight(), r11 - getPaddingBottom());
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0.0f, 0.0f, r10, r11);
        this.maskPath.addRect(this.maskRect, Path.Direction.CCW);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.bottomContentPadding;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int r10 = this.endContentPadding;
        if (r10 == Integer.MIN_VALUE) goto L6;
        return r10;
    L6:
        if (isRtl() == false) goto L9;
        return this.leftContentPadding;
    L9:
        return this.rightContentPadding;
    }

    @Dimension
    public int getContentPaddingLeft() {
        if (isContentPaddingRelative() == false) goto L15;
        if (isRtl() == false) goto L10;
        int r10 = this.endContentPadding;
        if (r10 == Integer.MIN_VALUE) goto L10;
        return r10;
    L10:
        if (isRtl() == true) goto L15;
        int r11 = this.startContentPadding;
        if (r11 == Integer.MIN_VALUE) goto L15;
        return r11;
    L15:
        return this.leftContentPadding;
    }

    @Dimension
    public int getContentPaddingRight() {
        if (isContentPaddingRelative() == false) goto L15;
        if (isRtl() == false) goto L10;
        int r10 = this.startContentPadding;
        if (r10 == Integer.MIN_VALUE) goto L10;
        return r10;
    L10:
        if (isRtl() == true) goto L15;
        int r11 = this.endContentPadding;
        if (r11 == Integer.MIN_VALUE) goto L15;
        return r11;
    L15:
        return this.rightContentPadding;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int r10 = this.startContentPadding;
        if (r10 == Integer.MIN_VALUE) goto L6;
        return r10;
    L6:
        if (isRtl() == false) goto L9;
        return this.rightContentPadding;
    L9:
        return this.leftContentPadding;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.topContentPadding;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        r10.drawPath(this.maskPath, this.clearPaint);
        drawStroke(r10);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (this.hasAdjustedPaddingAfterLayoutDirectionResolved == false) goto L6;
        return;
    L6:
        if (isLayoutDirectionResolved() == true) goto L8;
        return;
    L8:
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = true;
        if (isPaddingRelative() == false) goto L11;
    L15:
        setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        return;
    L11:
        if (isContentPaddingRelative() == true) goto L15;
        setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        updateShapeMask(r10, r11);
    }

    public void setContentPadding(@Dimension int r10, @Dimension int r11, @Dimension int r12, @Dimension int r13) {
        this.startContentPadding = Integer.MIN_VALUE;
        this.endContentPadding = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.leftContentPadding) + r10, (super.getPaddingTop() - this.topContentPadding) + r11, (super.getPaddingRight() - this.rightContentPadding) + r12, (super.getPaddingBottom() - this.bottomContentPadding) + r13);
        this.leftContentPadding = r10;
        this.topContentPadding = r11;
        this.rightContentPadding = r12;
        this.bottomContentPadding = r13;
    }

    @RequiresApi(17)
    public void setContentPaddingRelative(@Dimension int r10, @Dimension int r11, @Dimension int r12, @Dimension int r13) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + r10, (super.getPaddingTop() - this.topContentPadding) + r11, (super.getPaddingEnd() - getContentPaddingEnd()) + r12, (super.getPaddingBottom() - this.bottomContentPadding) + r13);
        if (isRtl() == false) goto L5;
        int r14 = r12;
    L6:
        this.leftContentPadding = r14;
        this.topContentPadding = r11;
        if (isRtl() == true) goto L10;
        r10 = r12;
    L10:
        this.rightContentPadding = r10;
        this.bottomContentPadding = r13;
        return;
    L5:
        r14 = r10;
        goto L6
    }

    @Override // android.view.View
    public void setPadding(@Dimension int r10, @Dimension int r11, @Dimension int r12, @Dimension int r13) {
        super.setPadding(r10 + getContentPaddingLeft(), r11 + getContentPaddingTop(), r12 + getContentPaddingRight(), r13 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(@Dimension int r10, @Dimension int r11, @Dimension int r12, @Dimension int r13) {
        super.setPaddingRelative(r10 + getContentPaddingStart(), r11 + getContentPaddingTop(), r12 + getContentPaddingEnd(), r13 + getContentPaddingBottom());
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r10) {
        this.shapeAppearanceModel = r10;
        MaterialShapeDrawable r11 = this.shadowDrawable;
        if (r11 == null) goto L5;
        r11.setShapeAppearanceModel(r10);
    L5:
        updateShapeMask(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList r10) {
        this.strokeColor = r10;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int r10) {
        setStrokeColor(a.a(getContext(), r10));
    }

    public void setStrokeWidth(@Dimension float r10) {
        if (this.strokeWidth == r10) goto L6;
        this.strokeWidth = r10;
        invalidate();
        return;
    }

    public void setStrokeWidthResource(@DimenRes int r10) {
        setStrokeWidth(getResources().getDimensionPixelSize(r10));
    }

    public ShapeableImageView(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ShapeableImageView(Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        this.pathProvider = ShapeAppearancePathProvider.getInstance();
        this.path = new Path();
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = false;
        Context r14 = getContext();
        Paint r15 = new Paint();
        this.clearPaint = r15;
        r15.setAntiAlias(true);
        r15.setColor(-1);
        r15.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.destination = new RectF();
        this.maskRect = new RectF();
        this.maskPath = new Path();
        TypedArray r16 = r14.obtainStyledAttributes(r11, R.styleable.ShapeableImageView, r12, r13);
        this.strokeColor = MaterialResources.getColorStateList(r14, r16, R.styleable.ShapeableImageView_strokeColor);
        this.strokeWidth = r16.getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
        int r17 = r16.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPadding, 0);
        this.leftContentPadding = r17;
        this.topContentPadding = r17;
        this.rightContentPadding = r17;
        this.bottomContentPadding = r17;
        this.leftContentPadding = r16.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingLeft, r17);
        this.topContentPadding = r16.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingTop, r17);
        this.rightContentPadding = r16.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingRight, r17);
        this.bottomContentPadding = r16.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingBottom, r17);
        this.startContentPadding = r16.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.endContentPadding = r16.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        r16.recycle();
        Paint r18 = new Paint();
        this.borderPaint = r18;
        r18.setStyle(Paint.Style.STROKE);
        r18.setAntiAlias(true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(r14, r11, r12, r13).build();
        setOutlineProvider(new OutlineProvider(this));
    }
}
