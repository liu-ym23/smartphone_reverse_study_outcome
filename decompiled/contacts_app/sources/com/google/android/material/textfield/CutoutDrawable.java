package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes2.dex */
class CutoutDrawable extends MaterialShapeDrawable {
    CutoutDrawableState drawableState;

    /* JADX INFO: renamed from: com.google.android.material.textfield.CutoutDrawable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class CutoutDrawableState extends MaterialShapeDrawable.MaterialShapeDrawableState {
        private final RectF cutoutBounds;

        /* synthetic */ CutoutDrawableState(ShapeAppearanceModel r1, RectF r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        /* synthetic */ CutoutDrawableState(CutoutDrawableState r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ RectF access$200(CutoutDrawableState r0) {
            return r0.cutoutBounds;
        }

        private CutoutDrawableState(ShapeAppearanceModel r2, RectF r3) {
            super(r2, null);
            this.cutoutBounds = r3;
        }

        private CutoutDrawableState(CutoutDrawableState r1) {
            super(r1);
            this.cutoutBounds = r1.cutoutBounds;
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            CutoutDrawable r0 = CutoutDrawable.access$400(this);
            r0.invalidateSelf();
            return r0;
        }
    }

    private static class ImplApi14 extends CutoutDrawable {
        private Paint cutoutPaint;
        private int savedLayer;

        ImplApi14(CutoutDrawableState r2) {
            super(r2, null);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas r1) {
            preDraw(r1);
            super.draw(r1);
            postDraw(r1);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable
        protected void drawStrokeShape(Canvas r2) {
            super.drawStrokeShape(r2);
            r2.drawRect(CutoutDrawableState.access$200(this.drawableState), getCutoutPaint());
        }

        private Paint getCutoutPaint() {
            if (this.cutoutPaint != null) goto L6;
            Paint r0 = new Paint(1);
            this.cutoutPaint = r0;
            r0.setStyle(Paint.Style.FILL_AND_STROKE);
            this.cutoutPaint.setColor(-1);
            this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        L6:
            return this.cutoutPaint;
        }

        private void preDraw(Canvas r3) {
            Drawable.Callback r0 = getCallback();
            if (useHardwareLayer(r0) == false) goto L7;
            View r1 = (View) r0;
            if (r1.getLayerType() == 2) goto L9;
            r1.setLayerType(2, null);
            return;
        L9:
            return;
        L7:
            saveCanvasLayer(r3);
        }

        private void saveCanvasLayer(Canvas r7) {
            this.savedLayer = r7.saveLayer(0.0f, 0.0f, r7.getWidth(), r7.getHeight(), null);
        }

        private void postDraw(Canvas r2) {
            if (useHardwareLayer(getCallback()) == true) goto L6;
            r2.restoreToCount(this.savedLayer);
            return;
        }

        private boolean useHardwareLayer(Drawable.Callback r1) {
            return r1 instanceof View;
        }
    }

    private static class ImplApi18 extends CutoutDrawable {
        ImplApi18(CutoutDrawableState r2) {
            super(r2, null);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable
        protected void drawStrokeShape(Canvas r2) {
            if (CutoutDrawableState.access$200(this.drawableState).isEmpty() == false) goto L5;
            super.drawStrokeShape(r2);
            return;
        L5:
            r2.save();
            r2.clipOutRect(CutoutDrawableState.access$200(this.drawableState));
            super.drawStrokeShape(r2);
            r2.restore();
        }
    }

    /* synthetic */ CutoutDrawable(CutoutDrawableState r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ CutoutDrawable access$400(CutoutDrawableState r0) {
        return create(r0);
    }

    static CutoutDrawable create(ShapeAppearanceModel r3) {
        if (r3 != null) goto L7;
        r3 = new ShapeAppearanceModel();
    L7:
        return create(new CutoutDrawableState(r3, new RectF(), null));
    }

    private static CutoutDrawable create(CutoutDrawableState r1) {
        return new ImplApi18(r1);
    }

    private CutoutDrawable(CutoutDrawableState r1) {
        super(r1);
        this.drawableState = r1;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.drawableState = new CutoutDrawableState(this.drawableState, null);
        return this;
    }

    boolean hasCutout() {
        return !CutoutDrawableState.access$200(this.drawableState).isEmpty();
    }

    void setCutout(float r2, float r3, float r4, float r5) {
        if (r2 == CutoutDrawableState.access$200(this.drawableState).left) goto L5;
    L10:
        CutoutDrawableState.access$200(this.drawableState).set(r2, r3, r4, r5);
        invalidateSelf();
        return;
    L5:
        if (r3 != CutoutDrawableState.access$200(this.drawableState).top) goto L10;
        if (r4 != CutoutDrawableState.access$200(this.drawableState).right) goto L10;
        if (r5 != CutoutDrawableState.access$200(this.drawableState).bottom) goto L10;
    }

    void setCutout(RectF r4) {
        setCutout(r4.left, r4.top, r4.right, r4.bottom);
    }

    void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
