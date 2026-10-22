package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class Polygon extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private PolygonOptions options;

    public int getFillColor() {
        PolygonOptions r100 = this.options;     // Catch: Throwable -> L7
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
        PolygonOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getHoleOptions();
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public List<LatLng> getPoints() {
        PolygonOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getPoints();
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public int getStrokeColor() {
        PolygonOptions r100 = this.options;     // Catch: Throwable -> L7
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
        PolygonOptions r100 = this.options;     // Catch: Throwable -> L7
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
        PolygonOptions r100 = this.options;     // Catch: Throwable -> L7
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
        PolygonOptions r100 = this.options;     // Catch: Throwable -> L7
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
        PolygonOptions r100 = this.options;     // Catch: Throwable -> L7
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

    public String getId() {
        return this.overlayName;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
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

    public int hashCode() {
        return super.hashCode();
    L5:
        return super.hashCode();
    }

    public boolean contains(LatLng r100) {
        IGlOverlayLayer r101 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L8
        if (r101 == null) goto L7;
        return r101.IsPolygonContainsPoint(this.options, r100);
    L7:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if ((r100 instanceof Polygon) == false) goto L15;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L8:
        if (super.equals(r100) == true) goto L11;
        if (((Polygon) r100).getId() == getId()) goto L11;
        return false;
    L11:
        return true;
    }

    public void setFillColor(int r100) {
        PolygonOptions r101 = this.options;     // Catch: Throwable -> L6
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
        if (r100 == null) goto L9;
    L4:
        this.options.setHoleOptions(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L9:
        r100 = new ArrayList();     // Catch: Throwable -> L6
        goto L4
    }

    public void setPoints(List<LatLng> r100) {
        this.options.setPoints(r100);     // Catch: Throwable -> L4
        updateOption();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setStrokeColor(int r100) {
        PolygonOptions r101 = this.options;     // Catch: Throwable -> L6
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
        PolygonOptions r101 = this.options;     // Catch: Throwable -> L6
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
        this.options.strokeWidth(r100);     // Catch: Throwable -> L4
        updateOption();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setVisible(boolean r100) {
        PolygonOptions r101 = this.options;     // Catch: Throwable -> L6
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
        PolygonOptions r101 = this.options;     // Catch: Throwable -> L6
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

    public Polygon(IGlOverlayLayer r100, PolygonOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.options = r101;
    }
}
