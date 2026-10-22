package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class Polyline extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private PolylineOptions options;

    private void updateOption() {
        monitor-enter(this);     // Catch: Throwable -> L13
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(this.overlayName) == true) goto L7;
        if (r100 == null) goto L7;
        r100.updateOption(this.overlayName, this.options);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        goto L18
    L12:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    }

    public int getColor() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getColor();
    L12:
        return 0;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int getEraseColor() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getEraseColor();
    L12:
        return 0;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public BitmapDescriptor getEraseTexture() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getEraseTexture();
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public boolean getEraseVisible() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getEraseVisible();
    L12:
        return false;
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public float getFootPrintGap() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getFootPrintGap();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public BitmapDescriptor getFootPrintTexture() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getFootPrintTexture();
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public List<LatLng> getPoints() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getPoints();
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public float getPolylineShownRangeBegin() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getPolylineShownRangeBegin();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public float getPolylineShownRangeEnd() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getPolylineShownRangeEnd();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public float getWidth() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
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
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getZIndex();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public boolean isShowPolylineRangeEnable() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.isShowPolylineRangeEnable();
    L12:
        return false;
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isVisible() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.isVisible();
    L12:
        return false;
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public String getId() {
        return this.overlayName;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public float getShownRatio() {
        PolylineOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getShownRatio();
    L12:
        return -1.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return -1.0f;
    }

    public boolean isDottedLine() {
        PolylineOptions r100 = this.options;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isDottedLine();
    }

    public boolean isGeodesic() {
        PolylineOptions r100 = this.options;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isGeodesic() == false) goto L7;
        return true;
    }

    public void remove() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.removeOverlay(this.overlayName);     // Catch: Throwable -> L7
    L5:
        this.overlayName = null;     // Catch: Throwable -> L7
        return;
    L7:
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

    public PolylineOptions getOptions() {
        return this.options;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Polyline) == true) goto L14;
        return false;
    L14:
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    L6:
        if (super.equals(r100) == true) goto L9;
        if (((Polyline) r100).getId() == getId()) goto L9;
        return false;
    L9:
        return true;
    }

    public LatLng getNearestLatLng(LatLng r100) {
        IGlOverlayLayer r101 = this.glOverlayLayerRef.get();
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getNearestLatLng(this.options, r100);
    }

    public void setAboveMaskLayer(boolean r100) {
        PolylineOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.aboveMaskLayer(r100);
        updateOption();
        return;
    }

    public void setColor(int r100) {
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.color(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setCustemTextureIndex(List<Integer> r100) {
        setCustomTextureIndex(r100);
    }

    public void setCustomTexture(BitmapDescriptor r100) {
        PolylineOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.setCustomTexture(r100);
        updateOption();
        return;
    }

    public void setCustomTextureIndex(List<Integer> r100) {
        monitor-enter(this);
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.setCustomTextureIndex(r100);     // Catch: Throwable -> L8
        updateOption();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setCustomTextureList(List<BitmapDescriptor> r100) {
        this.options.setCustomTextureList(r100);     // Catch: Throwable -> L4
        updateOption();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setDottedLine(boolean r100) {
        PolylineOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.setDottedLine(r100);
        updateOption();
        return;
    }

    public void setFootPrintGap(float r100) {
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.setFootPrintGap(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public void setFootPrintTexture(BitmapDescriptor r100) {
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.setFootPrintTexture(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public void setGeodesic(boolean r100) {
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.geodesic(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setOptions(PolylineOptions r100) {
        this.options = r100;
        updateOption();
    }

    public void setPoints(List<LatLng> r100) {
        monitor-enter(this);     // Catch: Throwable -> L11
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.setPoints(r100);     // Catch: Throwable -> L8
        updateOption();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    L17:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public void setShownRatio(float r100) {
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setShownRatio(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setTransparency(float r100) {
        PolylineOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.transparency(r100);
        updateOption();
        return;
    }

    public void setVisible(boolean r100) {
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L6
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

    public void setWidth(float r100) {
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.width(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setZIndex(float r100) {
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L6
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

    public void showPolylineRangeEnabled(boolean r100) {
        PolylineOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.showPolylineRangeEnabled(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public Polyline(IGlOverlayLayer r100, PolylineOptions r101) {
        super("");
        this.glOverlayLayerRef = new WeakReference(r100);
        this.options = r101;
    }

    public void setEraseColor(boolean r100, int r101) {
        PolylineOptions r102 = this.options;     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.setEraseColor(r100, r101);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public void setEraseTexture(boolean r100, BitmapDescriptor r101) {
        PolylineOptions r102 = this.options;     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.setEraseTexture(r100, r101);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public void setPolylineShowRange(float r100, float r101) {
        PolylineOptions r102 = this.options;     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.setPolylineShowRange(r100, r101);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public void setShownRange(float r100, float r101) {
        PolylineOptions r102 = this.options;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.setShownRange(r100, r101);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public Polyline(IGlOverlayLayer r100, PolylineOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.options = r101;
    }
}
