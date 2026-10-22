package com.bytedance.amap.model;

import com.amap.api.maps.model.Arc;
import com.bytedance.map.api.model.IArc;

/* JADX INFO: loaded from: classes43.dex */
public class AliArc implements IArc {
    private static final String TAG = "AliArc";
    private Arc mArc;
    private String mId;

    @Override // com.bytedance.map.api.model.IArc
    public int getColor() {
        Arc r100 = this.mArc;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getStrokeColor();
    }

    @Override // com.bytedance.map.api.model.IArc
    public int getWidth() {
        Arc r100 = this.mArc;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return (int) r100.getStrokeWidth();
    }

    @Override // com.bytedance.map.api.model.IArc
    public float getZIndex() {
        Arc r100 = this.mArc;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.getZIndex();
    }

    @Override // com.bytedance.map.api.model.IArc
    public boolean isVisible() {
        Arc r100 = this.mArc;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isVisible();
    }

    @Override // com.bytedance.map.api.model.IArc
    public void remove() {
        Arc r100 = this.mArc;
        if (r100 == null) goto L6;
        r100.remove();
        return;
    }

    @Override // com.bytedance.map.api.model.IArc
    public String getId() {
        return this.mId;
    }

    @Override // com.bytedance.map.api.model.IArc
    public void setColor(int r100) {
        Arc r101 = this.mArc;
        if (r101 == null) goto L6;
        r101.setStrokeColor(r100);
        return;
    }

    @Override // com.bytedance.map.api.model.IArc
    public void setVisible(boolean r100) {
        Arc r101 = this.mArc;
        if (r101 == null) goto L6;
        r101.setVisible(r100);
        return;
    }

    @Override // com.bytedance.map.api.model.IArc
    public void setWidth(int r100) {
        Arc r101 = this.mArc;
        if (r101 == null) goto L6;
        r101.setStrokeWidth(r100);
        return;
    }

    @Override // com.bytedance.map.api.model.IArc
    public void setZIndex(float r100) {
        Arc r101 = this.mArc;
        if (r101 == null) goto L6;
        r101.setZIndex(r100);
        return;
    }

    public AliArc(Arc r100, String r101) {
        this.mArc = r100;
        this.mId = r101;
    }
}
