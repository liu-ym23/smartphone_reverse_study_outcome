package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
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

        public State(State r10) {
            this(r10.wrapped, r10.width, r10.height);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.wrapped.newDrawable());
        }

        public State(Drawable.ConstantState r10, int r11, int r12) {
            this.wrapped = r10;
            this.width = r11;
            this.height = r12;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r10) {
            return new FixedSizeDrawable(this, this.wrapped.newDrawable(r10));
        }
    }

    public FixedSizeDrawable(Drawable r10, int r11, int r12) {
        this(new State(r10.getConstantState(), r11, r12), r10);
    }

    private void updateMatrix() {
        this.matrix.setRectToRect(this.wrappedRect, this.bounds, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        r10.save();
        r10.concat(this.matrix);
        this.wrapped.draw(r10);
        r10.restore();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
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
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
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
    public boolean getPadding(@NonNull Rect r10) {
        return this.wrapped.getPadding(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
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
    public void scheduleSelf(@NonNull Runnable r10, long r11) {
        super.scheduleSelf(r10, r11);
        this.wrapped.scheduleSelf(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.wrapped.setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r10, int r11, int r12, int r13) {
        super.setBounds(r10, r11, r12, r13);
        this.bounds.set(r10, r11, r12, r13);
        updateMatrix();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r10) {
        this.wrapped.setChangingConfigurations(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int r10, @NonNull PorterDuff.Mode r11) {
        this.wrapped.setColorFilter(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean r10) {
        this.wrapped.setDither(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r10) {
        this.wrapped.setFilterBitmap(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        return this.wrapped.setVisible(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(@NonNull Runnable r10) {
        super.unscheduleSelf(r10);
        this.wrapped.unscheduleSelf(r10);
    }

    public FixedSizeDrawable(State r10, Drawable r11) {
        this.state = (State) Preconditions.checkNotNull(r10);
        this.wrapped = (Drawable) Preconditions.checkNotNull(r11);
        r11.setBounds(0, 0, r11.getIntrinsicWidth(), r11.getIntrinsicHeight());
        this.matrix = new Matrix();
        this.wrappedRect = new RectF(0.0f, 0.0f, r11.getIntrinsicWidth(), r11.getIntrinsicHeight());
        this.bounds = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.wrapped.setColorFilter(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect r10) {
        super.setBounds(r10);
        this.bounds.set(r10);
        updateMatrix();
    }
}
