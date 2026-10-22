package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class NavigateArrow extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private NavigateArrowOptions options;

    public List<LatLng> getPoints() {
        NavigateArrowOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getPoints();
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public int getSideColor() {
        NavigateArrowOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getSideColor();
    L12:
        return 0;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int getTopColor() {
        NavigateArrowOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getTopColor();
    L12:
        return 0;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public float getWidth() {
        NavigateArrowOptions r100 = this.options;     // Catch: Throwable -> L7
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
        NavigateArrowOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getZIndex();
    L12:
        return 0.0f;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public boolean is3DModel() {
        NavigateArrowOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.is3DModel();
    L12:
        return false;
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isVisible() {
        NavigateArrowOptions r100 = this.options;     // Catch: Throwable -> L7
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
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if ((r100 instanceof NavigateArrow) == false) goto L15;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L8:
        if (super.equals(r100) == true) goto L11;
        if (((NavigateArrow) r100).getId() == getId()) goto L11;
        return false;
    L11:
        return true;
    }

    public void set3DModel(boolean r100) {
        NavigateArrowOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.set3DModel(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setPoints(List<LatLng> r100) {
        NavigateArrowOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setPoints(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setSideColor(int r100) {
        NavigateArrowOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.sideColor(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setTopColor(int r100) {
        NavigateArrowOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.topColor(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setVisible(boolean r100) {
        NavigateArrowOptions r101 = this.options;     // Catch: Throwable -> L6
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
        NavigateArrowOptions r101 = this.options;     // Catch: Throwable -> L6
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
        NavigateArrowOptions r101 = this.options;     // Catch: Throwable -> L6
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

    public NavigateArrow(IGlOverlayLayer r100, NavigateArrowOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.options = r101;
    }
}
