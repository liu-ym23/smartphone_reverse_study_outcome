package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

/* JADX INFO: loaded from: classes39.dex */
public abstract class InnerOverlay extends Overlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f32997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Bundle f32998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f32999c;
    public AppBaseMap mBaseMap;

    public boolean getDefaultShowStatus() {
        return false;
    }

    public String getLayerTag() {
        return "default";
    }

    public int getUpdateTimeInterval() {
        return 0;
    }

    public int getUpdateType() {
        return 0;
    }

    public boolean IsOverlayShow() {
        if (this.mLayerID == 0) goto L11;
        AppBaseMap r100 = this.mBaseMap;
        if (r100 == null) goto L11;
        if (r100.GetId() == 0) goto L11;
        if (this.mBaseMap.LayersIsShow(this.mLayerID) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public void UpdateOverlay() {
        long r100 = 0;
        if (this.mLayerID == 0) goto L16;
        AppBaseMap r101 = this.mBaseMap;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.GetId() != 0) goto L10;
        return;
    L10:
        if (k.f33351a == false) goto L12;
        r100 = System.currentTimeMillis();
    L12:
        this.mBaseMap.UpdateLayers(this.mLayerID);
        if (k.f33351a == false) goto L18;
        k.a("InnerOverlay", "UpdateLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - r100) + "ms]");
        return;
    L18:
        return;
    }

    public boolean addedToMapView() {
        AppBaseMap r100 = this.mBaseMap;
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (r100.GetId() == 0) goto L18;
        if (k.f33351a == false) goto L10;
        long r101 = System.currentTimeMillis();
    L11:
        this.mLayerID = this.mBaseMap.AddLayer(getUpdateType(), getUpdateTimeInterval(), getLayerTag());
        if (k.f33351a == false) goto L14;
        k.a("InnerOverlay", "AddLayer:" + this.mLayerID + " type:" + this.mType + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - r101) + "ms]");
    L14:
        long r102 = this.mLayerID;
        if (r102 == 0) goto L18;
        this.mBaseMap.SetLayersClickable(r102, this.f32999c);
        SetOverlayShow(getDefaultShowStatus());
        return true;
    L10:
        r101 = 0;
        goto L11
    }

    public void clear() {
        if (k.f33351a == false) goto L5;
        long r100 = System.currentTimeMillis();
    L7:
        if (TextUtils.isEmpty(this.f32997a) == true) goto L12;
        this.f32997a = null;
        AppBaseMap r101 = this.mBaseMap;
        if (r101 == null) goto L12;
        r101.ClearLayer(this.mLayerID);
    L12:
        if (k.f33351a == false) goto L15;
        k.a("InnerOverlay", "ClearLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - r100) + "ms]");
        return;
    L15:
        return;
    L5:
        r100 = 0;
        goto L7
    }

    public InnerOverlay() {
        this.mBaseMap = null;
        this.f32997a = null;
        this.f32998b = null;
        this.f32999c = true;
    }

    public String getData() {
        return this.f32997a;
    }

    public Bundle getParam() {
        return this.f32998b;
    }

    public int getType() {
        return this.mType;
    }

    public InnerOverlay(int r100) {
        this.mBaseMap = null;
        this.f32997a = null;
        this.f32998b = null;
        this.f32999c = true;
        setType(r100);
    }

    public void SetOverlayShow(boolean r100) {
        long r101 = 0;
        if (this.mLayerID == 0) goto L16;
        AppBaseMap r102 = this.mBaseMap;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.GetId() != 0) goto L10;
        return;
    L10:
        if (k.f33351a == false) goto L12;
        r101 = System.currentTimeMillis();
    L12:
        this.mBaseMap.ShowLayers(this.mLayerID, r100);
        if (k.f33351a == false) goto L18;
        k.a("InnerOverlay", "ShowLayer:" + this.mLayerID + ":" + r100 + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - r101) + "ms]");
        return;
    L18:
        return;
    }

    public void setClickAble(boolean r100) {
        this.f32999c = r100;
        AppBaseMap r101 = this.mBaseMap;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.GetId() == 0) goto L13;
        long r102 = this.mLayerID;
        if (r102 == 0) goto L12;
        this.mBaseMap.SetLayersClickable(r102, r100);
        return;
    L12:
        return;
    }

    public void setData(String r100) {
        if (r100 == null) goto L5;
        this.f32997a = r100;
        return;
    }

    public void setParam(Bundle r100) {
        this.f32998b = r100;
    }

    public void setType(int r100) {
        this.mType = r100;
    }

    public InnerOverlay(int r100, AppBaseMap r101) {
        this.mBaseMap = null;
        this.f32997a = null;
        this.f32998b = null;
        this.f32999c = true;
        setType(r100);
        this.mBaseMap = r101;
    }

    public void SetMapParam(long r100, AppBaseMap r101) {
        this.mLayerID = r100;
        this.mBaseMap = r101;
    }

    public void setFocus(int r100, boolean r101) {
        setFocus(r100, r101, null);
    }

    public void setFocus(int r110, boolean r111, String r112) {
        AppBaseMap r100 = this.mBaseMap;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.GetId() == 0) goto L13;
        Bundle r113 = new Bundle();
        if (TextUtils.isEmpty(r112) == true) goto L10;
        r113.putString("uid", r112);
    L10:
        this.mBaseMap.SetFocus(this.mLayerID, r110, r111, r113);
        return;
    }
}
