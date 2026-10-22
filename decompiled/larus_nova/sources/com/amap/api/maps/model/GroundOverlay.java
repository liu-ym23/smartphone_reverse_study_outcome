package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes28.dex */
public final class GroundOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private float high;
    private GroundOverlayOptions options;
    private LatLng point;
    private float width;

    public float getBearing() {
        GroundOverlayOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getBearing();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public LatLngBounds getBounds() {
        GroundOverlayOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getBounds();
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public float getHeight() {
        GroundOverlayOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getHeight();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public LatLng getPosition() {
        GroundOverlayOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getLocation();
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public float getTransparency() {
        GroundOverlayOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getTransparency();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public float getWidth() {
        GroundOverlayOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getWidth();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public float getZIndex() {
        GroundOverlayOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getZIndex();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public boolean isVisible() {
        GroundOverlayOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.isVisible();
    L12:
        return false;
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    private void updateOption() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) == true) goto L7;
        if (r100 == null) goto L8;
        r100.updateOption(this.overlayName, this.options);
        return;
    L8:
        return;
    }

    public void destroy() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.removeOverlay(this.overlayName);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public String getId() {
        return this.overlayName;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void remove() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L11
        if (r100 == null) goto L5;
        r100.removeOverlay(this.overlayName);     // Catch: Throwable -> L11
    L5:
        GroundOverlayOptions r101 = this.options;     // Catch: Throwable -> L11
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.getImage() == null) goto L17;
        this.options.getImage().recycle();     // Catch: Throwable -> L11
        return;
    L17:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if ((r100 instanceof GroundOverlay) == false) goto L15;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L8:
        if (super.equals(r100) == true) goto L11;
        if (((GroundOverlay) r100).getId() == getId()) goto L11;
        return false;
    L11:
        return true;
    }

    public void setBearing(float r100) {
        GroundOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.bearing(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setDimensions(float r100) {
        GroundOverlayOptions r101 = this.options;     // Catch: Throwable -> L12
        if (r101 == null) goto L16;
        LatLng r102 = this.point;     // Catch: Throwable -> L12
        if (r102 != null) goto L8;
        r102 = r101.getLocation();     // Catch: Throwable -> L12
    L8:
        if (r102 != null) goto L10;
        this.width = r100;     // Catch: Throwable -> L12
        return;
    L10:
        this.options.position(r102, r100);     // Catch: Throwable -> L12
        updateOption();     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    public void setImage(BitmapDescriptor r100) {
        GroundOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.image(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setPosition(LatLng r100) {
        GroundOverlayOptions r101 = this.options;     // Catch: Throwable -> L22
        if (r101 == null) goto L26;
        if (r100 == null) goto L27;
        float r102 = this.width;     // Catch: Throwable -> L22
        if (r102 > 0.0f) goto L9;
        r102 = r101.getWidth();     // Catch: Throwable -> L22
    L9:
        float r103 = this.high;     // Catch: Throwable -> L22
        if (r103 > 0.0f) goto L14;
        r103 = this.options.getHeight();     // Catch: Throwable -> L22
    L14:
        if (r102 != 0.0f) goto L17;
        this.point = r100;     // Catch: Throwable -> L22
        return;
    L17:
        if (r103 != 0.0f) goto L19;
        this.options.position(r100, r102);     // Catch: Throwable -> L22
        updateOption();     // Catch: Throwable -> L22
        return;
    L19:
        if (r103 <= 0.0f) goto L30;
        this.options.position(r100, r102, r103);     // Catch: Throwable -> L22
        updateOption();     // Catch: Throwable -> L22
        return;
    L30:
        return;
    L27:
        return;
    L26:
        return;
    L22:
        th = move-exception;
        th.printStackTrace();
    }

    public void setPositionFromBounds(LatLngBounds r100) {
        GroundOverlayOptions r101 = this.options;     // Catch: Throwable -> L7
        if (r101 == null) goto L12;
        if (r100 == null) goto L13;
        r101.positionFromBounds(r100);     // Catch: Throwable -> L7
        updateOption();     // Catch: Throwable -> L7
        return;
    L13:
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public void setTransparency(float r100) {
        GroundOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.transparency(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setVisible(boolean r100) {
        GroundOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.visible(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setZIndex(float r100) {
        GroundOverlayOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.zIndex(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setDimensions(float r100, float r101) {
        GroundOverlayOptions r102 = this.options;     // Catch: Throwable -> L12
        if (r102 == null) goto L16;
        LatLng r103 = this.point;     // Catch: Throwable -> L12
        if (r103 != null) goto L8;
        r103 = r102.getLocation();     // Catch: Throwable -> L12
    L8:
        if (r103 != null) goto L10;
        this.width = r100;     // Catch: Throwable -> L12
        this.high = r101;     // Catch: Throwable -> L12
        return;
    L10:
        GroundOverlayOptions r104 = this.options;     // Catch: Throwable -> L12
        r104.position(r104.getLocation(), r100, r101);     // Catch: Throwable -> L12
        updateOption();     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    public GroundOverlay(IGlOverlayLayer r100, GroundOverlayOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.options = r101;
    }
}
