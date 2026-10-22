package com.amap.api.maps.model;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class Circle extends BaseOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WeakReference<IGlOverlayLayer> f28646a;
    private CircleOptions options;

    public LatLng getCenter() {
        CircleOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getCenter();
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public int getFillColor() {
        CircleOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getFillColor();
    L12:
        return 0;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public List<BaseHoleOptions> getHoleOptions() {
        CircleOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getHoleOptions();
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public int getStrokeColor() {
        CircleOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getStrokeColor();
    L12:
        return 0;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int getStrokeDottedLineType() {
        CircleOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getStrokeDottedLineType();
    L12:
        return -1;
    L7:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public float getStrokeWidth() {
        CircleOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getStrokeWidth();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public float getZIndex() {
        CircleOptions r100 = this.options;     // Catch: Throwable -> L7
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
        CircleOptions r100 = this.options;     // Catch: Throwable -> L7
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
        IGlOverlayLayer r100 = this.f28646a.get();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(this.overlayName) == true) goto L10;
        if (r100 == null) goto L11;
        r100.updateOption(this.overlayName, this.options);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L10:
        return;
    }

    public String getId() {
        return this.overlayName;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public double getRadius() {
        CircleOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getRadius();
    L12:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        th = move-exception;
        th.printStackTrace();
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public void remove() {
        IGlOverlayLayer r100 = this.f28646a.get();     // Catch: Throwable -> L6
        if (r100 == null) goto L11;
        r100.removeOverlay(this.overlayName);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public int hashCode() {
        return super.hashCode();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public boolean contains(LatLng r100) {
        IGlOverlayLayer r101 = this.f28646a.get();     // Catch: Throwable -> L6
        if (r101 == null) goto L12;
        return r101.IsCircleContainPoint(this.options, r100);
    L12:
        return false;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if ((r100 instanceof Circle) == false) goto L15;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L8:
        if (super.equals(r100) == true) goto L11;
        if (((Circle) r100).getId() == getId()) goto L11;
        return false;
    L11:
        return true;
    }

    public void setCenter(LatLng r100) {
        CircleOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.center(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setFillColor(int r100) {
        CircleOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.fillColor(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setHoleOptions(List<BaseHoleOptions> r100) {
        if (r100 == null) goto L17;
        monitor-enter(r100);     // Catch: Throwable -> L10
        this.options.getHoleOptions().clear();     // Catch: Throwable -> L7
        this.options.addHoles(r100);     // Catch: Throwable -> L7
        updateOption();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
    L18:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void setRadius(double r100) {
        CircleOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.radius(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setStrokeColor(int r100) {
        CircleOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.strokeColor(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setStrokeDottedLineType(int r100) {
        CircleOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setStrokeDottedLineType(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setStrokeWidth(float r100) {
        CircleOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.strokeWidth(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setVisible(boolean r100) {
        CircleOptions r101 = this.options;     // Catch: Throwable -> L6
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
        CircleOptions r101 = this.options;     // Catch: Throwable -> L6
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

    public Circle(IGlOverlayLayer r100, CircleOptions r101, String r102) {
        super(r102);
        this.f28646a = new WeakReference(r100);
        this.options = r101;
    }
}
