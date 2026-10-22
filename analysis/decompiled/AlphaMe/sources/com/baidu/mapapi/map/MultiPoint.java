package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmMultiPoint;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class MultiPoint extends Overlay {

    /* renamed from: g, reason: collision with root package name */
    List<MultiPointItem> f6678g;

    /* renamed from: h, reason: collision with root package name */
    BitmapDescriptor f6679h;

    /* renamed from: i, reason: collision with root package name */
    int f6680i;

    /* renamed from: j, reason: collision with root package name */
    int f6681j;

    /* renamed from: k, reason: collision with root package name */
    float f6682k;

    /* renamed from: l, reason: collision with root package name */
    float f6683l;

    /* renamed from: m, reason: collision with root package name */
    boolean f6684m = true;

    /* renamed from: n, reason: collision with root package name */
    private BmMultiPoint f6685n;

    public MultiPoint() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.multiPoint;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        List<MultiPointItem> list = this.f6678g;
        if (list != null && list.size() > 0) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6678g.get(0).getPoint());
            bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
            bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < this.f6678g.size(); i4++) {
                MultiPointItem multiPointItem = this.f6678g.get(i4);
                if (multiPointItem != null) {
                    arrayList.add(multiPointItem.getPoint());
                }
            }
            Overlay.c(arrayList, bundle);
        }
        BitmapDescriptor bitmapDescriptor = this.f6679h;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.a());
        }
        bundle.putInt("isClickable", this.f6684m ? 1 : 0);
        bundle.putFloat("anchor_x", this.f6682k);
        bundle.putFloat("anchor_y", this.f6683l);
        bundle.putFloat("pointsize_x", this.f6680i);
        bundle.putFloat("pointsize_y", this.f6681j);
        return bundle;
    }

    public void anchor(float f4, float f5) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE || f4 > 1.0f || f5 < Property.DEFAULT_FLOAT_VALUE || f5 > 1.0f) {
            return;
        }
        this.f6682k = f4;
        this.f6683l = f5;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmMultiPoint bmMultiPoint = this.f6685n;
        if (bmMultiPoint == null || this.f6723f == null) {
            return;
        }
        bmMultiPoint.b(this.f6682k);
        this.f6685n.c(this.f6683l);
        this.f6723f.b();
    }

    public float getAnchorX() {
        return this.f6682k;
    }

    public float getAnchorY() {
        return this.f6683l;
    }

    public BitmapDescriptor getIcon() {
        return this.f6679h;
    }

    public MultiPointItem getMultiPointItem(int i4) {
        List<MultiPointItem> list = this.f6678g;
        if (list == null || i4 >= list.size()) {
            return null;
        }
        return this.f6678g.get(i4);
    }

    public List<MultiPointItem> getMultiPointItems() {
        return this.f6678g;
    }

    public int getPointSizeHeight() {
        return this.f6681j;
    }

    public int getPointSizeWidth() {
        return this.f6680i;
    }

    public boolean isClickable() {
        return this.f6684m;
    }

    public void setClickable(boolean z4) {
        this.f6684m = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmMultiPoint bmMultiPoint = this.f6685n;
        if (bmMultiPoint == null || this.f6723f == null) {
            return;
        }
        bmMultiPoint.a(z4);
        this.f6723f.b();
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        this.f6679h = bitmapDescriptor;
        if (this.f6680i == 0) {
            this.f6680i = bitmapDescriptor.getBitmap().getWidth();
        }
        if (this.f6681j == 0) {
            this.f6681j = bitmapDescriptor.getBitmap().getHeight();
        }
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.f6685n == null || this.f6723f == null) {
                return;
            }
            this.f6685n.a(new BmBitmapResource(this.f6679h.getBitmap()));
            this.f6723f.b();
        }
    }

    public void setMultiPointItems(List<MultiPointItem> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
        }
        this.f6678g = list;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmMultiPoint bmMultiPoint = this.f6685n;
        if (bmMultiPoint == null || this.f6723f == null) {
            return;
        }
        bmMultiPoint.c();
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6678g.get(0).getPoint());
        this.f6685n.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        BmGeoElement bmGeoElement = new BmGeoElement();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f6678g.size(); i4++) {
            MultiPointItem multiPointItem = this.f6678g.get(i4);
            if (multiPointItem != null) {
                GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(multiPointItem.getPoint());
                arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
            }
        }
        bmGeoElement.a(arrayList);
        this.f6685n.a(bmGeoElement);
        this.f6723f.b();
    }

    public void setPointSize(int i4, int i5) {
        if (this.f6680i <= 0 || this.f6681j <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
        }
        this.f6680i = i4;
        this.f6681j = i5;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmMultiPoint bmMultiPoint = this.f6685n;
        if (bmMultiPoint == null || this.f6723f == null) {
            return;
        }
        bmMultiPoint.b(this.f6680i);
        this.f6685n.a(this.f6681j);
        this.f6723f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmMultiPoint bmMultiPoint = new BmMultiPoint();
        this.f6685n = bmMultiPoint;
        bmMultiPoint.a(this);
        setDrawItem(this.f6685n);
        super.getDrawItem();
        this.f6685n.b(this.f6682k);
        this.f6685n.c(this.f6683l);
        this.f6685n.b(this.f6680i);
        this.f6685n.a(this.f6681j);
        this.f6685n.a(this.f6684m);
        List<MultiPointItem> list = this.f6678g;
        if (list != null && list.size() > 0) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6678g.get(0).getPoint());
            this.f6685n.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            BmGeoElement bmGeoElement = new BmGeoElement();
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < this.f6678g.size(); i4++) {
                MultiPointItem multiPointItem = this.f6678g.get(i4);
                if (multiPointItem != null) {
                    GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(multiPointItem.getPoint());
                    arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
                }
            }
            bmGeoElement.a(arrayList);
            this.f6685n.a(bmGeoElement);
        }
        if (this.f6679h != null) {
            this.f6685n.a(new BmBitmapResource(this.f6679h.getBitmap()));
        }
        return this.f6685n;
    }
}
