package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes28.dex */
public class GLTFOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private GLTFOverlayOptions mOptions;

    private void updateOption() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(this.overlayName) == true) goto L10;
        if (r100 == null) goto L11;
        r100.updateOption(this.overlayName, this.mOptions);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L10:
        return;
    }

    public int getCurrentAnimationIndex() {
        GLTFOverlayOptions r100 = this.mOptions;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getCurrentAnimationIndex();
    }

    public String getId() {
        return this.overlayName;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public BitmapDescriptor getInfoWindowView() {
        GLTFOverlayOptions r100 = this.mOptions;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getInfoWindowView();
    }

    public LatLng getLatlng() {
        GLTFOverlayOptions r100 = this.mOptions;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getLatLng();
    }

    public GLTFOverlayOptions getOptions() {
        return this.mOptions.clone();
    }

    public float getZIndex() {
        GLTFOverlayOptions r100 = this.mOptions;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.getZIndex();
    }

    public boolean isAnimated() {
        Object r100 = callNativeFunction("isAnimated", null);
        if ((r100 instanceof Boolean) == true) goto L5;
        return false;
    L5:
        return ((Boolean) r100).booleanValue();
    }

    public boolean isClickable() {
        GLTFOverlayOptions r100 = this.mOptions;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isClickable();
    }

    public boolean isDraggable() {
        GLTFOverlayOptions r100 = this.mOptions;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.isDraggable();
    }

    public boolean isInfoWindowShow() {
        GLTFOverlayOptions r100 = this.mOptions;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isInfoWindowShow();
    }

    public void remove() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L6
        if (r100 == null) goto L11;
        r100.removeOverlay(this.overlayName);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void tapClick() {
        GLTFOverlayOptions r100 = this.mOptions;
        if (r100 == null) goto L10;
        r100.tapClick();
    L10:
        callNativeFunction("tapClick", null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setClickable(boolean r100) {
        GLTFOverlayOptions r101 = this.mOptions;
        if (r101 == null) goto L6;
        r101.setClickable(r100);
        return;
    }

    public void setCurrentAnimationIndex(int r100) {
        GLTFOverlayOptions r101 = this.mOptions;
        if (r101 == null) goto L6;
        r101.setCurrentAnimationIndex(r100);
        updateOption();
        return;
    }

    public void setDraggable(boolean r100) {
        GLTFOverlayOptions r101 = this.mOptions;
        if (r101 == null) goto L6;
        r101.setDraggable(r100);
        return;
    }

    public void setInfoWindowView(BitmapDescriptor r100) {
        GLTFOverlayOptions r101 = this.mOptions;
        if (r101 == null) goto L6;
        r101.infoWindowView(r100);
        updateOption();
        return;
    }

    public void setLatLng(LatLng r100) {
        GLTFOverlayOptions r101 = this.mOptions;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.latLng(r100);     // Catch: Exception -> L6
        updateOption();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setZIndex(float r100) {
        GLTFOverlayOptions r101 = this.mOptions;
        if (r101 == null) goto L6;
        r101.setZIndex(r100);
        updateOption();
        return;
    }

    private Object callNativeFunction(String r100, Object[] r101) {
        IGlOverlayLayer r102 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(this.overlayName) == true) goto L8;
        if (r102 == null) goto L8;
        return r102.getNativeProperties(this.overlayName, r100, null);
    L8:
        return null;
    }

    public GLTFOverlay(IGlOverlayLayer r100, GLTFOverlayOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.mOptions = r101;
    }
}
