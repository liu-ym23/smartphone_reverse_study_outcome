package com.zyql.ai.crop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.zyql.ai.crop.callback.CropBoundsChangeListener;
import com.zyql.ai.crop.callback.OverlayViewChangeListener;
import com.zyql.ai.selector.R;

/* loaded from: classes4.dex */
public class UCropView extends FrameLayout {
    private GestureCropImageView mGestureCropImageView;
    private final OverlayView mViewOverlay;

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setListenersToViews() {
        this.mGestureCropImageView.setCropBoundsChangeListener(new CropBoundsChangeListener() { // from class: com.zyql.ai.crop.view.UCropView.1
            @Override // com.zyql.ai.crop.callback.CropBoundsChangeListener
            public void onCropAspectRatioChanged(float f10) {
                UCropView.this.mViewOverlay.setTargetAspectRatio(f10);
            }
        });
        this.mViewOverlay.setOverlayViewChangeListener(new OverlayViewChangeListener() { // from class: com.zyql.ai.crop.view.UCropView.2
            @Override // com.zyql.ai.crop.callback.OverlayViewChangeListener
            public void onCropRectUpdated(RectF rectF) {
                UCropView.this.mGestureCropImageView.setCropRect(rectF);
            }

            @Override // com.zyql.ai.crop.callback.OverlayViewChangeListener
            public void postTranslate(float f10, float f11) {
                UCropView.this.mGestureCropImageView.postTranslate(f10, f11);
            }
        });
    }

    public GestureCropImageView getCropImageView() {
        return this.mGestureCropImageView;
    }

    public OverlayView getOverlayView() {
        return this.mViewOverlay;
    }

    public void resetCropImageView() {
        removeView(this.mGestureCropImageView);
        this.mGestureCropImageView = new GestureCropImageView(getContext());
        setListenersToViews();
        this.mGestureCropImageView.setCropRect(getOverlayView().getCropViewRect());
        addView(this.mGestureCropImageView, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.ucrop_view, (ViewGroup) this, true);
        this.mGestureCropImageView = (GestureCropImageView) findViewById(R.id.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(R.id.view_overlay);
        this.mViewOverlay = overlayView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView);
        overlayView.processStyledAttributes(typedArrayObtainStyledAttributes);
        this.mGestureCropImageView.processStyledAttributes(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        setListenersToViews();
    }
}
