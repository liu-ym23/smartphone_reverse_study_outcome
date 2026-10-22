package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes28.dex */
public class HeatMapGridLayer extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private HeatMapGridLayerOptions options;

    public float getZIndex() {
        HeatMapGridLayerOptions r100 = this.options;     // Catch: Throwable -> L7
        if (r100 == null) goto L10;
        return r100.getZIndex();
    L10:
        return 0.0f;
    L11:
        return 0.0f;
    }

    public boolean isVisible() {
        HeatMapGridLayerOptions r100 = this.options;     // Catch: Throwable -> L9
        if (r100 == null) goto L12;
        if (r100.isVisible() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
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

    public void destroy() {
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

    public String getId() {
        return this.overlayName;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public HeatMapGridLayerOptions getOptions() {
        return this.options;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public int hashCode() {
        return super.hashCode();
    L4:
        return 0;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if ((r100 instanceof HeatMapGridLayer) == false) goto L15;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L8:
        if (super.equals(r100) == true) goto L11;
        if (((HeatMapGridLayer) r100).getId().equals(getId()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public void setOptions(HeatMapGridLayerOptions r100) {
        this.options = r100;     // Catch: Throwable -> L4
        updateOption();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setVisible(boolean r100) {
        HeatMapGridLayerOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.visible(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public void setZIndex(float r100) {
        HeatMapGridLayerOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.zIndex(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public HeatMapGridLayer(IGlOverlayLayer r100, HeatMapGridLayerOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.options = r101;
        updateOption();
    }
}
