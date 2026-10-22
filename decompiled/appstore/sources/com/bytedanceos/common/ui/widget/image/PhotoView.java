package com.bytedanceos.common.ui.widget.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoView extends ImageView implements IPhotoView {
    private final PhotoViewAttacher mAttacher;
    private ImageView.ScaleType mPendingScaleType;

    public PhotoView(Context r10) {
        this(r10, null);
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public boolean canZoom() {
        return this.mAttacher.canZoom();
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public RectF getDisplayRect() {
        return this.mAttacher.getDisplayRect();
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public float getMaxScale() {
        return this.mAttacher.getMaxScale();
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public float getMidScale() {
        return this.mAttacher.getMidScale();
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public float getMinScale() {
        return this.mAttacher.getMinScale();
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public float getScale() {
        return this.mAttacher.getScale();
    }

    @Override // android.widget.ImageView, com.bytedanceos.common.ui.widget.image.IPhotoView
    public ImageView.ScaleType getScaleType() {
        return this.mAttacher.getScaleType();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.mAttacher.cleanup();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);     // Catch: Exception -> L4
        return;
    L4:
        j.a("onDraw() Canvas: trying to use a recycled bitmap");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        super.onTouchEvent(r10);     // Catch: Exception -> L5
        return false;
    L8:
        return false;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setAllowParentInterceptOnEdge(boolean r10) {
        this.mAttacher.setAllowParentInterceptOnEdge(r10);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r10) {
        super.setImageDrawable(r10);
        PhotoViewAttacher r11 = this.mAttacher;
        if (r11 == null) goto L6;
        r11.update();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r10) {
        super.setImageResource(r10);
        PhotoViewAttacher r11 = this.mAttacher;
        if (r11 == null) goto L6;
        r11.update();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r10) {
        super.setImageURI(r10);
        PhotoViewAttacher r11 = this.mAttacher;
        if (r11 == null) goto L6;
        r11.update();
        return;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setMaxScale(float r10) {
        this.mAttacher.setMaxScale(r10);
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setMidScale(float r10) {
        this.mAttacher.setMidScale(r10);
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setMinScale(float r10) {
        this.mAttacher.setMinScale(r10);
    }

    @Override // android.view.View, com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setOnLongClickListener(View.OnLongClickListener r10) {
        this.mAttacher.setOnLongClickListener(r10);
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener r10) {
        this.mAttacher.setOnMatrixChangeListener(r10);
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener r10) {
        this.mAttacher.setOnPhotoTapListener(r10);
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener r10) {
        this.mAttacher.setOnViewTapListener(r10);
    }

    @Override // android.widget.ImageView, com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setScaleType(ImageView.ScaleType r10) {
        PhotoViewAttacher r11 = this.mAttacher;
        if (r11 == null) goto L5;
        r11.setScaleType(r10);
        return;
    L5:
        this.mPendingScaleType = r10;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setZoomable(boolean r10) {
        this.mAttacher.setZoomable(r10);
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void zoomTo(float r10, float r11, float r12) {
        this.mAttacher.zoomTo(r10, r11, r12);
    }

    public PhotoView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public PhotoView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.mAttacher = new PhotoViewAttacher(this);
        ImageView.ScaleType r13 = this.mPendingScaleType;
        if (r13 == null) goto L6;
        setScaleType(r13);
        this.mPendingScaleType = null;
        return;
    }
}
