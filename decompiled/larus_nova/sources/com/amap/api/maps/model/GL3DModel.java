package com.amap.api.maps.model;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes28.dex */
public class GL3DModel extends BasePointOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private Object object;
    private GL3DModelOptions options;

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isInfoWindowEnable() {
        return true;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setGeoPoint(IPoint r100) {
    }

    public void setZoomLimit(float r100) {
    }

    private void updateOption() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(this.overlayName) == true) goto L10;
        if (r100 == null) goto L11;
        r100.updateOption(this.overlayName, this.options);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L10:
        return;
    }

    public double getAltitude() {
        return this.options.getAltitude();
    L4:
        e = move-exception;
        e.printStackTrace();
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public float getAngle() {
        return this.options.getAngle();
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getId() {
        return this.overlayName;
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public LatLng getPosition() {
        return this.options.getLatLng();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getSnippet() {
        GL3DModelOptions r100 = this.options;     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.getSnippet();
    L12:
        return "";
    L6:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getTitle() {
        GL3DModelOptions r100 = this.options;     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.getTitle();
    L12:
        return "";
    L6:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public int getZIndex() {
        GL3DModelOptions r100 = this.options;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getZIndex();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isVisible() {
        return this.options.isVisible();
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
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

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void showInfoWindow() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(this.overlayName) == true) goto L12;
        if (r100 == null) goto L13;
        r100.showInfoWindow(this.overlayName);     // Catch: Throwable -> L7
        return;
    L13:
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean startAnimation() {
        Object r100 = callNativeFunction("startAnimation", null);
        if ((r100 instanceof Boolean) == true) goto L5;
        return false;
    L5:
        return ((Boolean) r100).booleanValue();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public float getRotateAngle() {
        return getAngle();
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void destroy() {
        remove();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public Object getObject() {
        return this.object;
    }

    public void setAltitude(double r100) {
        this.options.setAltitude(r100);     // Catch: Exception -> L4
        updateOption();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void setAngle(float r100) {
        this.options.angle(r100);     // Catch: Exception -> L4
        updateOption();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setAnimation(Animation r100) {
        callNativeFunction("setAnimation", new Object[]{r100});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public void setModelFixedLength(int r100) {
        this.options.setModelFixedLength(r100);     // Catch: Exception -> L4
        updateOption();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setObject(Object r100) {
        this.object = r100;     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setPosition(LatLng r100) {
        this.options.position(r100);     // Catch: Exception -> L4
        updateOption();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setRotateAngle(float r100) {
        setAngle(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setSnippet(String r100) {
        GL3DModelOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.snippet(r100);
        updateOption();
        return;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setTitle(String r100) {
        GL3DModelOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.title(r100);
        updateOption();
        return;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setVisible(boolean r100) {
        this.options.setVisible(r100);     // Catch: Exception -> L4
        updateOption();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void setZIndex(int r100) {
        GL3DModelOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.setzIndex(r100);
        updateOption();
        return;
    }

    private Object callNativeFunction(String r100, Object[] r101) {
        IGlOverlayLayer r102 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(this.overlayName) == true) goto L7;
        if (r102 == null) goto L12;
        return r102.getNativeProperties(this.overlayName, r100, r101);
    L12:
        return null;
    L7:
        return null;
    L13:
        return null;
    }

    public GL3DModel(IGlOverlayLayer r100, GL3DModelOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.options = r101;
    }
}
