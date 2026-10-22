package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes39.dex */
public class FixedSizeDrawable extends Drawable {
    private final RectF bounds;
    private final Matrix matrix;
    private boolean mutated;
    private State state;
    private Drawable wrapped;
    private final RectF wrappedRect;

    public static final class State extends Drawable.ConstantState {
        final int height;
        final int width;
        private final Drawable.ConstantState wrapped;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.wrapped.newDrawable());
        }

        public State(State r100) {
            this(r100.wrapped, r100.width, r100.height);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r100) {
            return new FixedSizeDrawable(this, this.wrapped.newDrawable(r100));
        }

        public State(Drawable.ConstantState r100, int r101, int r102) {
            this.wrapped = r100;
            this.width = r101;
            this.height = r102;
        }
    }

    private void updateMatrix() {
        this.matrix.setRectToRect(this.wrappedRect, this.bounds, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.wrapped.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.wrapped.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.wrapped.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.width;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.wrapped.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.wrapped.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.wrapped.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        this.wrapped = this.wrapped.mutate();
        this.state = new State(this.state);
        this.mutated = true;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        r100.save();
        r100.concat(this.matrix);
        this.wrapped.draw(r100);
        r100.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r100) {
        return this.wrapped.getPadding(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.wrapped.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect r100) {
        super.setBounds(r100);
        this.bounds.set(r100);
        updateMatrix();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r100) {
        this.wrapped.setChangingConfigurations(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.wrapped.setColorFilter(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r100) {
        this.wrapped.setDither(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r100) {
        this.wrapped.setFilterBitmap(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable r100) {
        super.unscheduleSelf(r100);
        this.wrapped.unscheduleSelf(r100);
    }

    public FixedSizeDrawable(State r100, Drawable r101) {
        this.state = (State) Preconditions.checkNotNull(r100);
        this.wrapped = (Drawable) Preconditions.checkNotNull(r101);
        r101.setBounds(0, 0, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
        this.matrix = new Matrix();
        this.wrappedRect = new RectF(0.0f, 0.0f, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
        this.bounds = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable r100, long r101) {
        super.scheduleSelf(r100, r101);
        this.wrapped.scheduleSelf(r100, r101);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int r100, PorterDuff.Mode r101) {
        this.wrapped.setColorFilter(r100, r101);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        return this.wrapped.setVisible(r100, r101);
    }

    public FixedSizeDrawable(Drawable r100, int r101, int r102) {
        this(new State(r100.getConstantState(), r101, r102), r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r100, int r101, int r102, int r103) {
        super.setBounds(r100, r101, r102, r103);
        this.bounds.set(r100, r101, r102, r103);
        updateMatrix();
    }
}
