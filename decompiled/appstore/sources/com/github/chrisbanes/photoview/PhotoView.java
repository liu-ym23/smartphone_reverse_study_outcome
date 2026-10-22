package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f10271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView.ScaleType f10272b;

    public PhotoView(Context r10) {
        this(r10, null);
    }

    private void a() {
        this.f10271a = new c(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType r10 = this.f10272b;
        if (r10 == null) goto L6;
        setScaleType(r10);
        this.f10272b = null;
        return;
    }

    public c getAttacher() {
        return this.f10271a;
    }

    public RectF getDisplayRect() {
        return this.f10271a.D();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f10271a.G();
    }

    public float getMaximumScale() {
        return this.f10271a.J();
    }

    public float getMediumScale() {
        return this.f10271a.K();
    }

    public float getMinimumScale() {
        return this.f10271a.L();
    }

    public float getScale() {
        return this.f10271a.M();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f10271a.N();
    }

    public void setAllowParentInterceptOnEdge(boolean r10) {
        this.f10271a.Q(r10);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int r10, int r11, int r12, int r13) {
        boolean r14 = super.setFrame(r10, r11, r12, r13);
        if (r14 == false) goto L5;
        this.f10271a.d0();
    L5:
        return r14;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r10) {
        super.setImageDrawable(r10);
        c r11 = this.f10271a;
        if (r11 == null) goto L6;
        r11.d0();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r10) {
        super.setImageResource(r10);
        c r11 = this.f10271a;
        if (r11 == null) goto L6;
        r11.d0();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r10) {
        super.setImageURI(r10);
        c r11 = this.f10271a;
        if (r11 == null) goto L6;
        r11.d0();
        return;
    }

    public void setMaximumScale(float r10) {
        this.f10271a.S(r10);
    }

    public void setMediumScale(float r10) {
        this.f10271a.T(r10);
    }

    public void setMinimumScale(float r10) {
        this.f10271a.U(r10);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r10) {
        this.f10271a.setOnClickListener(r10);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r10) {
        this.f10271a.setOnDoubleTapListener(r10);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r10) {
        this.f10271a.setOnLongClickListener(r10);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener r10) {
        this.f10271a.setOnMatrixChangeListener(r10);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener r10) {
        this.f10271a.setOnOutsidePhotoTapListener(r10);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener r10) {
        this.f10271a.setOnPhotoTapListener(r10);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener r10) {
        this.f10271a.setOnScaleChangeListener(r10);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener r10) {
        this.f10271a.setOnSingleFlingListener(r10);
    }

    public void setOnViewDragListener(OnViewDragListener r10) {
        this.f10271a.setOnViewDragListener(r10);
    }

    public void setOnViewTapListener(OnViewTapListener r10) {
        this.f10271a.setOnViewTapListener(r10);
    }

    public void setRotationBy(float r10) {
        this.f10271a.V(r10);
    }

    public void setRotationTo(float r10) {
        this.f10271a.W(r10);
    }

    public void setScale(float r10) {
        this.f10271a.X(r10);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r10) {
        c r11 = this.f10271a;
        if (r11 != null) goto L5;
        this.f10272b = r10;
        return;
    L5:
        r11.a0(r10);
    }

    public void setZoomTransitionDuration(int r10) {
        this.f10271a.b0(r10);
    }

    public void setZoomable(boolean r10) {
        this.f10271a.c0(r10);
    }

    public PhotoView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public PhotoView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        a();
    }
}
