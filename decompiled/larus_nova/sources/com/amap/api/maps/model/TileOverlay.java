package com.amap.api.maps.model;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes28.dex */
public final class TileOverlay extends BaseOverlay {
    protected WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    protected TileOverlayOptions options;

    public void clearTileCache() {
        callNativeFunction("clearTileCache", null);
    }

    public float getZIndex() {
        return this.options.getZIndex();
    }

    public int hashCode() {
        if (this.options == null) goto L11;
        String r100 = this.overlayName;
        if (r100 != null) goto L7;
        int r101 = 0;
    L9:
        return ((r101 + 31) * 31) + this.options.hashCode();
    L7:
        r101 = r100.hashCode();
        goto L9
    L11:
        return super.hashCode();
    }

    public boolean isVisible() {
        return this.options.isVisible();
    }

    public void remove() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: RemoteException -> L6
        if (r100 == null) goto L11;
        r100.removeOverlay(this.overlayName);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void updateOption() {
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
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L17:
        return false;
    L5:
        if ((r100 instanceof TileOverlay) == false) goto L17;
        TileOverlayOptions r101 = this.options;     // Catch: Throwable -> L15
        if (r101 == null) goto L17;
        if (r101.equals(((TileOverlay) r100).options) == false) goto L20;
        if (this.overlayName.equals(((TileOverlay) r100).overlayName) == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    public void setVisible(boolean r100) {
        this.options.visible(r100);
        updateOption();
    }

    public void setZIndex(float r100) {
        this.options.zIndex(r100);
        updateOption();
    }

    public Object callNativeFunction(String r100, Object[] r101) {
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

    public TileOverlay(IGlOverlayLayer r100, TileOverlayOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.options = r101;
        if (r101 == null) goto L8;
        TileProviderInner r103 = r101.getTileProviderInner();
        if (r103 == null) goto L9;
        r103.init(r100, r102);
        return;
    L9:
        return;
    }
}
