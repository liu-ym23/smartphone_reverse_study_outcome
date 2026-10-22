package com.amap.api.maps.model.amap3dmodeltile;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes28.dex */
public final class AMap3DModelTileOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private AMap3DModelTileOverlayOptions mAMap3DModelTileOverlayOptions;

    private void updateOption() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(this.overlayName) == true) goto L10;
        if (r100 == null) goto L11;
        r100.updateOption(this.overlayName, this.mAMap3DModelTileOverlayOptions);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L10:
        return;
    }

    public float getZIndex() {
        return this.mAMap3DModelTileOverlayOptions.getZIndex();
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

    public boolean visible() {
        return this.mAMap3DModelTileOverlayOptions.visible();
    }

    public void setVisible(boolean r100) {
        this.mAMap3DModelTileOverlayOptions.setVisible(r100);
        updateOption();
    }

    public void setZIndex(float r100) {
        this.mAMap3DModelTileOverlayOptions.setZIndex(r100);
        updateOption();
    }

    public AMap3DModelTileOverlay(IGlOverlayLayer r100, AMap3DModelTileOverlayOptions r101, String r102) {
        super(r102);
        this.glOverlayLayerRef = new WeakReference(r100);
        this.mAMap3DModelTileOverlayOptions = r101;
        if (r101 == null) goto L6;
        r101.getTileProviderInner().init(r100, r102);
        return;
    }
}
