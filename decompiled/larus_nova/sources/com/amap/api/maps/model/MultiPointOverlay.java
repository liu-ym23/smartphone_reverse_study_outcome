package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class MultiPointOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private MultiPointOverlayOptions options;

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

    public List<MultiPointItem> getItems() {
        MultiPointOverlayOptions r100 = this.options;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getMultiPointItems();
    }

    public void remove() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.removeOverlay(this.overlayName);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public void setEnable(boolean r100) {
        MultiPointOverlayOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.setEnable(r100);
        updateOption();
        return;
    }

    public void setItems(List<MultiPointItem> r100) {
        MultiPointOverlayOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.setMultiPointItems(r100);
        updateOption();
        return;
    }

    public void setAnchor(float r100, float r101) {
        MultiPointOverlayOptions r102 = this.options;
        if (r102 == null) goto L6;
        r102.anchor(r100, r101);
        updateOption();
        return;
    }

    public MultiPointOverlay(IGlOverlayLayer r100, MultiPointOverlayOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.options = r101;
    }
}
