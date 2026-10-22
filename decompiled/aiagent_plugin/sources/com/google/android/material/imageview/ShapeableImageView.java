package com.google.android.material.imageview;

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
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.g.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.m;
import com.google.android.material.shape.n;
import com.google.android.material.shape.q;
import com.google.android.material.theme.a.a;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ShapeableImageView extends AppCompatImageView implements q {
    private static final int DEF_STYLE_RES = 0;
    private static final int UNDEFINED_PADDING = Integer.MIN_VALUE;
    private final Paint borderPaint;
    private int bottomContentPadding;
    private final Paint clearPaint;
    private final RectF destination;
    private int endContentPadding;
    private boolean hasAdjustedPaddingAfterLayoutDirectionResolved;
    private int leftContentPadding;
    private Path maskPath;
    private final RectF maskRect;
    private final Path path;
    private final n pathProvider;
    private int rightContentPadding;
    private MaterialShapeDrawable shadowDrawable;
    private m shapeAppearanceModel;
    private int startContentPadding;
    private ColorStateList strokeColor;
    private float strokeWidth;
    private int topContentPadding;

    class OutlineProvider extends ViewOutlineProvider {
        private final Rect rect;
        final /* synthetic */ ShapeableImageView this$0;

        OutlineProvider(ShapeableImageView r1) {
            this.this$0 = r1;
            this.rect = new Rect();
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r3, Outline r4) {
            if (ShapeableImageView.access$000(this.this$0) != null) goto L6;
            return;
        L6:
            if (ShapeableImageView.access$100(this.this$0) != null) goto L8;
            ShapeableImageView.access$102(this.this$0, new MaterialShapeDrawable(ShapeableImageView.access$000(this.this$0)));
        L8:
            ShapeableImageView.access$200(this.this$0).round(this.rect);
            ShapeableImageView.access$100(this.this$0).setBounds(this.rect);
            ShapeableImageView.access$100(this.this$0).getOutline(r4);
        }
    }

    static /* synthetic */ m access$000(ShapeableImageView r0) {
        return r0.shapeAppearanceModel;
    }

    static /* synthetic */ MaterialShapeDrawable access$100(ShapeableImageView r0) {
        return r0.shadowDrawable;
    }

    static /* synthetic */ MaterialShapeDrawable access$102(ShapeableImageView r0, MaterialShapeDrawable r1) {
        r0.shadowDrawable = r1;
        return r1;
    }

    static /* synthetic */ RectF access$200(ShapeableImageView r0) {
        return r0.destination;
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_ShapeableImageView, "style", "Widget_MaterialComponents_ShapeableImageView");
    }

    public ShapeableImageView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null, 0);
    }

    public ShapeableImageView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public ShapeableImageView(Context r8, AttributeSet r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        int r0 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(r11, r12, r10, r0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12, r10);
        this.pathProvider = n.a();
        this.path = new Path();
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = false;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Paint r2 = new Paint();
        this.clearPaint = r2;
        r2.setAntiAlias(true);
        r2.setColor(-1);
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.destination = new RectF();
        this.maskRect = new RectF();
        this.maskPath = new Path();
        TypedArray r3 = r1.obtainStyledAttributes(r12, R.styleable.ShapeableImageView, r10, r0);
        this.strokeColor = c.a(r1, r3, ZeusTransformUtils.mapRes(R.styleable.ShapeableImageView_strokeColor, "styleable", "ShapeableImageView_strokeColor"));
        this.strokeWidth = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ShapeableImageView_strokeWidth, "styleable", "ShapeableImageView_strokeWidth"), 0);
        int r13 = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ShapeableImageView_contentPadding, "styleable", "ShapeableImageView_contentPadding"), 0);
        this.leftContentPadding = r13;
        this.topContentPadding = r13;
        this.rightContentPadding = r13;
        this.bottomContentPadding = r13;
        this.leftContentPadding = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ShapeableImageView_contentPaddingLeft, "styleable", "ShapeableImageView_contentPaddingLeft"), r13);
        this.topContentPadding = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ShapeableImageView_contentPaddingTop, "styleable", "ShapeableImageView_contentPaddingTop"), r13);
        this.rightContentPadding = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ShapeableImageView_contentPaddingRight, "styleable", "ShapeableImageView_contentPaddingRight"), r13);
        this.bottomContentPadding = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ShapeableImageView_contentPaddingBottom, "styleable", "ShapeableImageView_contentPaddingBottom"), r13);
        this.startContentPadding = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ShapeableImageView_contentPaddingStart, "styleable", "ShapeableImageView_contentPaddingStart"), Integer.MIN_VALUE);
        this.endContentPadding = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ShapeableImageView_contentPaddingEnd, "styleable", "ShapeableImageView_contentPaddingEnd"), Integer.MIN_VALUE);
        r3.recycle();
        Paint r14 = new Paint();
        this.borderPaint = r14;
        r14.setStyle(Paint.Style.STROKE);
        r14.setAntiAlias(true);
        this.shapeAppearanceModel = m.a(r1, r12, r10, r0).a();
        if (Build.VERSION.SDK_INT < 21) goto L6;
        setOutlineProvider(new OutlineProvider(this));
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        if (this.hasAdjustedPaddingAfterLayoutDirectionResolved == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT > 19) goto L8;
    L10:
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = true;
        if (Build.VERSION.SDK_INT >= 21) goto L13;
    L18:
        setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        return;
    L13:
        if (isPaddingRelative() == false) goto L15;
    L16:
        setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        return;
    L15:
        if (isContentPaddingRelative() == false) goto L18;
    L8:
        if (isLayoutDirectionResolved() == true) goto L10;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r3) {
        super.onDraw(r3);
        r3.drawPath(this.maskPath, this.clearPaint);
        drawStroke(r3);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateShapeMask(r1, r2);
    }

    public void setContentPadding(int r6, int r7, int r8, int r9) {
        this.startContentPadding = Integer.MIN_VALUE;
        this.endContentPadding = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.leftContentPadding) + r6, (super.getPaddingTop() - this.topContentPadding) + r7, (super.getPaddingRight() - this.rightContentPadding) + r8, (super.getPaddingBottom() - this.bottomContentPadding) + r9);
        this.leftContentPadding = r6;
        this.topContentPadding = r7;
        this.rightContentPadding = r8;
        this.bottomContentPadding = r9;
    }

    public void setContentPaddingRelative(int r6, int r7, int r8, int r9) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + r6, (super.getPaddingTop() - this.topContentPadding) + r7, (super.getPaddingEnd() - getContentPaddingEnd()) + r8, (super.getPaddingBottom() - this.bottomContentPadding) + r9);
        if (isRtl() == false) goto L5;
        int r0 = r8;
    L6:
        this.leftContentPadding = r0;
        this.topContentPadding = r7;
        if (isRtl() == true) goto L10;
        r6 = r8;
    L10:
        this.rightContentPadding = r6;
        this.bottomContentPadding = r9;
        return;
    L5:
        r0 = r6;
        goto L6
    }

    private boolean isContentPaddingRelative() {
        if (this.startContentPadding == Integer.MIN_VALUE) goto L5;
    L8:
        return true;
    L5:
        if (this.endContentPadding != Integer.MIN_VALUE) goto L8;
        return false;
    }

    public int getContentPaddingBottom() {
        return this.bottomContentPadding;
    }

    public final int getContentPaddingEnd() {
        int r0 = this.endContentPadding;
        if (r0 == Integer.MIN_VALUE) goto L6;
        return r0;
    L6:
        if (isRtl() == false) goto L9;
        return this.leftContentPadding;
    L9:
        return this.rightContentPadding;
    }

    public int getContentPaddingLeft() {
        if (isContentPaddingRelative() == false) goto L15;
        if (isRtl() == false) goto L10;
        int r0 = this.endContentPadding;
        if (r0 == Integer.MIN_VALUE) goto L10;
        return r0;
    L10:
        if (isRtl() == true) goto L15;
        int r1 = this.startContentPadding;
        if (r1 == Integer.MIN_VALUE) goto L15;
        return r1;
    L15:
        return this.leftContentPadding;
    }

    public int getContentPaddingRight() {
        if (isContentPaddingRelative() == false) goto L15;
        if (isRtl() == false) goto L10;
        int r0 = this.startContentPadding;
        if (r0 == Integer.MIN_VALUE) goto L10;
        return r0;
    L10:
        if (isRtl() == true) goto L15;
        int r1 = this.endContentPadding;
        if (r1 == Integer.MIN_VALUE) goto L15;
        return r1;
    L15:
        return this.rightContentPadding;
    }

    public final int getContentPaddingStart() {
        int r0 = this.startContentPadding;
        if (r0 == Integer.MIN_VALUE) goto L6;
        return r0;
    L6:
        if (isRtl() == false) goto L9;
        return this.rightContentPadding;
    L9:
        return this.leftContentPadding;
    }

    public int getContentPaddingTop() {
        return this.topContentPadding;
    }

    private boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L7:
        return false;
    L5:
        if (getLayoutDirection() != 1) goto L7;
        return true;
    }

    @Override // android.view.View
    public void setPadding(int r2, int r3, int r4, int r5) {
        super.setPadding(r2 + getContentPaddingLeft(), r3 + getContentPaddingTop(), r4 + getContentPaddingRight(), r5 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int r2, int r3, int r4, int r5) {
        super.setPaddingRelative(r2 + getContentPaddingStart(), r3 + getContentPaddingTop(), r4 + getContentPaddingEnd(), r5 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // com.google.android.material.shape.q
    public void setShapeAppearanceModel(m r2) {
        this.shapeAppearanceModel = r2;
        MaterialShapeDrawable r0 = this.shadowDrawable;
        if (r0 == null) goto L5;
        r0.setShapeAppearanceModel(r2);
    L5:
        updateShapeMask(getWidth(), getHeight());
        invalidate();
        if (Build.VERSION.SDK_INT < 21) goto L9;
        invalidateOutline();
        return;
    }

    @Override // com.google.android.material.shape.q
    public m getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    private void updateShapeMask(int r6, int r7) {
        this.destination.set(getPaddingLeft(), getPaddingTop(), r6 - getPaddingRight(), r7 - getPaddingBottom());
        this.pathProvider.a(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0.0f, 0.0f, r6, r7);
        this.maskPath.addRect(this.maskRect, Path.Direction.CCW);
    }

    private void drawStroke(Canvas r4) {
        if (this.strokeColor != null) goto L5;
        return;
    L5:
        this.borderPaint.setStrokeWidth(this.strokeWidth);
        int r0 = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
        if (this.strokeWidth <= 0.0f) goto L10;
        if (r0 == 0) goto L11;
        this.borderPaint.setColor(r0);
        r4.drawPath(this.path, this.borderPaint);
        return;
    L11:
        return;
    }

    public void setStrokeColorResource(int r4) {
        setStrokeColor(androidx.appcompat.a.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public void setStrokeWidth(float r2) {
        if (this.strokeWidth == r2) goto L6;
        this.strokeWidth = r2;
        invalidate();
        return;
    }

    public void setStrokeWidthResource(int r2) {
        setStrokeWidth(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(r2));
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public void setStrokeColor(ColorStateList r1) {
        this.strokeColor = r1;
        invalidate();
    }
}
