package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.AVectorCrossAttr;

/* JADX INFO: loaded from: classes28.dex */
public class CrossOverlay {
    public static final int UPDATE_TYPE_DATA = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ICrossVectorOverlay f28648a;

    public interface GenerateCrossImageListener {
        void onGenerateComplete(Bitmap r100, int r101);
    }

    public interface OnCrossVectorUpdateListener {
        void onUpdate(int r100, UpdateItem r101);
    }

    public static class UpdateItem {
        public int dataUpdateFlag;

        public UpdateItem() {
            this.dataUpdateFlag = -1;
        }
    }

    public void remove() {
        ICrossVectorOverlay r100 = this.f28648a;
        if (r100 == null) goto L11;
        r100.remove();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void setAttribute(AVectorCrossAttr r100) {
        this.f28648a.setAttribute(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public int setData(byte[] r100) {
        if (r100 == null) goto L13;
        ICrossVectorOverlay r101 = this.f28648a;
        if (r101 == null) goto L14;
        r101.setData(r100);     // Catch: Throwable -> L7
        return 0;
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0;
    L14:
        return 0;
    L13:
        return 0;
    }

    public void setGenerateCrossImageListener(GenerateCrossImageListener r100) {
        ICrossVectorOverlay r101 = this.f28648a;
        if (r101 == null) goto L11;
        r101.setGenerateCrossImageListener(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void setImageMode(boolean r100) {
        ICrossVectorOverlay r101 = this.f28648a;
        if (r101 == null) goto L11;
        r101.setImageMode(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void setOnCrossVectorUpdateListener(OnCrossVectorUpdateListener r100) {
        ICrossVectorOverlay r101 = this.f28648a;
        if (r101 == null) goto L11;
        r101.setOnCrossVectorUpdateListener(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void setVisible(boolean r100) {
        ICrossVectorOverlay r101 = this.f28648a;
        if (r101 == null) goto L11;
        r101.setVisible(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public CrossOverlay(CrossOverlayOptions r100, ICrossVectorOverlay r101) {
        this.f28648a = r101;
    }
}
