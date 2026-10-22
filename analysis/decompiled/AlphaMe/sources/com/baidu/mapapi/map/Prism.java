package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmPrism;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Prism extends Overlay {

    /* renamed from: g, reason: collision with root package name */
    float f6857g;

    /* renamed from: h, reason: collision with root package name */
    String f6858h;

    /* renamed from: i, reason: collision with root package name */
    int f6859i;

    /* renamed from: j, reason: collision with root package name */
    List<LatLng> f6860j;

    /* renamed from: k, reason: collision with root package name */
    BmGeoElement f6861k;

    /* renamed from: l, reason: collision with root package name */
    int f6862l = -16777216;

    /* renamed from: m, reason: collision with root package name */
    int f6863m = -16711936;

    /* renamed from: n, reason: collision with root package name */
    BitmapDescriptor f6864n;

    /* renamed from: o, reason: collision with root package name */
    BmPrism f6865o;

    public enum AnimateType {
        AnimateSlow,
        AnimateNormal,
        AnimateFast
    }

    public Prism() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.prism;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        Overlay.f(this.f6862l, bundle);
        Overlay.e(this.f6863m, bundle);
        BitmapDescriptor bitmapDescriptor = this.f6864n;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.a());
        }
        List<LatLng> list = this.f6860j;
        if (list != null) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(list.get(0));
            bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
            bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
            Overlay.c(this.f6860j, bundle);
            bundle.putDouble("m_height", this.f6857g);
        }
        return bundle;
    }

    public BitmapDescriptor getCustomSideImage() {
        return this.f6864n;
    }

    public float getHeight() {
        return this.f6857g;
    }

    public List<LatLng> getPoints() {
        return this.f6860j;
    }

    public int getSideFaceColor() {
        return this.f6863m;
    }

    public int getTopFaceColor() {
        return this.f6862l;
    }

    public void setCustomSideImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.f6864n = bitmapDescriptor;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6865o == null || this.f6723f == null) {
            return;
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.f6863m);
        bmSurfaceStyle.a(new BmBitmapResource(this.f6864n.getBitmap()));
        this.f6865o.c(bmSurfaceStyle);
        this.f6723f.b();
    }

    public void setHeight(float f4) {
        this.f6857g = f4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.f6865o;
        if (bmPrism == null || this.f6723f == null) {
            return;
        }
        bmPrism.c(this.f6857g);
        this.f6723f.b();
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() <= 3) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than four");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        int i4 = 0;
        while (i4 < list.size()) {
            int i5 = i4 + 1;
            for (int i6 = i5; i6 < list.size(); i6++) {
                if (list.get(i4) == list.get(i6)) {
                    throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                }
            }
            i4 = i5;
        }
        this.f6860j = list;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.f6865o;
        if (bmPrism == null || this.f6723f == null) {
            return;
        }
        bmPrism.c();
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < this.f6860j.size(); i7++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6860j.get(i7));
            arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
        this.f6861k.a(arrayList);
        this.f6865o.a(this.f6861k);
        this.f6723f.b();
    }

    public void setSideFaceColor(int i4) {
        this.f6863m = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6865o == null || this.f6723f == null) {
            return;
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.f6863m);
        this.f6865o.c(bmSurfaceStyle);
        this.f6723f.b();
    }

    public void setTopFaceColor(int i4) {
        this.f6862l = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6865o == null || this.f6723f == null) {
            return;
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.f6862l);
        this.f6865o.d(bmSurfaceStyle);
        this.f6723f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        if (this.f6865o == null) {
            BmPrism bmPrism = new BmPrism();
            this.f6865o = bmPrism;
            bmPrism.a(this);
            setDrawItem(this.f6865o);
        }
        super.toDrawItem();
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        BmSurfaceStyle bmSurfaceStyle2 = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.f6862l);
        bmSurfaceStyle2.a(this.f6863m);
        if (this.f6864n != null) {
            bmSurfaceStyle2.a(new BmBitmapResource(this.f6864n.getBitmap()));
        }
        this.f6861k = new BmGeoElement();
        String str = this.f6858h;
        if (str != null && str.length() > 0) {
            this.f6861k.a(this.f6858h);
            this.f6861k.a(this.f6859i);
        } else if (this.f6860j != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < this.f6860j.size(); i4++) {
                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6860j.get(i4));
                arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            }
            this.f6861k.a(arrayList);
            this.f6865o.a(this.f6861k);
        }
        float f4 = this.f6857g;
        if (f4 > Property.DEFAULT_FLOAT_VALUE) {
            this.f6865o.c(f4);
        }
        this.f6865o.d(bmSurfaceStyle);
        this.f6865o.c(bmSurfaceStyle2);
        return this.f6865o;
    }
}
