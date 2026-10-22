package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.stepos.alphame.awareness.AwarenessDataItem;

/* loaded from: classes.dex */
public abstract class InnerOverlay extends Overlay {

    /* renamed from: a, reason: collision with root package name */
    protected String f8858a;

    /* renamed from: b, reason: collision with root package name */
    protected Bundle f8859b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8860c;
    public AppBaseMap mBaseMap;

    public InnerOverlay() {
        this.mBaseMap = null;
        this.f8858a = null;
        this.f8859b = null;
        this.f8860c = true;
    }

    public boolean IsOverlayShow() {
        AppBaseMap appBaseMap;
        return (this.mLayerID == 0 || (appBaseMap = this.mBaseMap) == null || appBaseMap.GetId() == 0 || !this.mBaseMap.LayersIsShow(this.mLayerID)) ? false : true;
    }

    public void SetMapParam(long j4, AppBaseMap appBaseMap) {
        this.mLayerID = j4;
        this.mBaseMap = appBaseMap;
    }

    public void SetOverlayShow(boolean z4) {
        AppBaseMap appBaseMap;
        if (this.mLayerID == 0 || (appBaseMap = this.mBaseMap) == null || appBaseMap.GetId() == 0) {
            return;
        }
        long jCurrentTimeMillis = k.f9243a ? System.currentTimeMillis() : 0L;
        this.mBaseMap.ShowLayers(this.mLayerID, z4);
        if (k.f9243a) {
            k.a("InnerOverlay", "ShowLayer:" + this.mLayerID + AwarenessDataItem.USERID_SPLITTER + z4 + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms]");
        }
    }

    public void UpdateOverlay() {
        AppBaseMap appBaseMap;
        if (this.mLayerID == 0 || (appBaseMap = this.mBaseMap) == null || appBaseMap.GetId() == 0) {
            return;
        }
        long jCurrentTimeMillis = k.f9243a ? System.currentTimeMillis() : 0L;
        this.mBaseMap.UpdateLayers(this.mLayerID);
        if (k.f9243a) {
            k.a("InnerOverlay", "UpdateLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms]");
        }
    }

    public boolean addedToMapView() {
        AppBaseMap appBaseMap = this.mBaseMap;
        if (appBaseMap != null && appBaseMap.GetId() != 0) {
            long jCurrentTimeMillis = k.f9243a ? System.currentTimeMillis() : 0L;
            this.mLayerID = this.mBaseMap.AddLayer(getUpdateType(), getUpdateTimeInterval(), getLayerTag());
            if (k.f9243a) {
                k.a("InnerOverlay", "AddLayer:" + this.mLayerID + " type:" + this.mType + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms]");
            }
            long j4 = this.mLayerID;
            if (j4 != 0) {
                this.mBaseMap.SetLayersClickable(j4, this.f8860c);
                SetOverlayShow(getDefaultShowStatus());
                return true;
            }
        }
        return false;
    }

    public void clear() {
        long jCurrentTimeMillis = k.f9243a ? System.currentTimeMillis() : 0L;
        if (!TextUtils.isEmpty(this.f8858a)) {
            this.f8858a = null;
            AppBaseMap appBaseMap = this.mBaseMap;
            if (appBaseMap != null) {
                appBaseMap.ClearLayer(this.mLayerID);
            }
        }
        if (k.f9243a) {
            k.a("InnerOverlay", "ClearLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms]");
        }
    }

    public String getData() {
        return this.f8858a;
    }

    public boolean getDefaultShowStatus() {
        return false;
    }

    public String getLayerTag() {
        return "default";
    }

    public Bundle getParam() {
        return this.f8859b;
    }

    public int getType() {
        return this.mType;
    }

    public int getUpdateTimeInterval() {
        return 0;
    }

    public int getUpdateType() {
        return 0;
    }

    public void setClickAble(boolean z4) {
        this.f8860c = z4;
        AppBaseMap appBaseMap = this.mBaseMap;
        if (appBaseMap == null || appBaseMap.GetId() == 0) {
            return;
        }
        long j4 = this.mLayerID;
        if (j4 != 0) {
            this.mBaseMap.SetLayersClickable(j4, z4);
        }
    }

    public void setData(String str) {
        if (str != null) {
            this.f8858a = str;
        }
    }

    public void setFocus(int i4, boolean z4, String str) {
        AppBaseMap appBaseMap = this.mBaseMap;
        if (appBaseMap == null || appBaseMap.GetId() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("uid", str);
        }
        this.mBaseMap.SetFocus(this.mLayerID, i4, z4, bundle);
    }

    public void setParam(Bundle bundle) {
        this.f8859b = bundle;
    }

    public void setType(int i4) {
        this.mType = i4;
    }

    public InnerOverlay(int i4) {
        this.mBaseMap = null;
        this.f8858a = null;
        this.f8859b = null;
        this.f8860c = true;
        setType(i4);
    }

    public void setFocus(int i4, boolean z4) {
        setFocus(i4, z4, null);
    }

    public InnerOverlay(int i4, AppBaseMap appBaseMap) {
        this.mBaseMap = null;
        this.f8858a = null;
        this.f8859b = null;
        this.f8860c = true;
        setType(i4);
        this.mBaseMap = appBaseMap;
    }
}
