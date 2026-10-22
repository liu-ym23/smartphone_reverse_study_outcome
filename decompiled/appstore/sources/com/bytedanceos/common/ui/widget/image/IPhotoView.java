package com.bytedanceos.common.ui.widget.image;

import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public interface IPhotoView {
    boolean canZoom();

    RectF getDisplayRect();

    float getMaxScale();

    float getMidScale();

    float getMinScale();

    float getScale();

    ImageView.ScaleType getScaleType();

    void setAllowParentInterceptOnEdge(boolean r10);

    void setMaxScale(float r10);

    void setMidScale(float r10);

    void setMinScale(float r10);

    void setOnLongClickListener(View.OnLongClickListener r10);

    void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener r10);

    void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener r10);

    void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener r10);

    void setScaleType(ImageView.ScaleType r10);

    void setZoomable(boolean r10);

    void zoomTo(float r10, float r11, float r12);
}
