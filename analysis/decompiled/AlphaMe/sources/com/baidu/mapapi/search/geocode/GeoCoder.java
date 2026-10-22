package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.platform.core.geocode.IGeoCoder;
import com.baidu.platform.core.geocode.a;

/* loaded from: classes.dex */
public class GeoCoder extends b {

    /* renamed from: a, reason: collision with root package name */
    private IGeoCoder f7367a = new a();

    /* renamed from: b, reason: collision with root package name */
    private boolean f7368b;

    private GeoCoder() {
    }

    public static GeoCoder newInstance() {
        BMapManager.init();
        return new GeoCoder();
    }

    public void destroy() {
        if (this.f7368b) {
            return;
        }
        this.f7368b = true;
        this.f7367a.destroy();
        BMapManager.destroy();
    }

    public boolean geocode(GeoCodeOption geoCodeOption) {
        IGeoCoder iGeoCoder = this.f7367a;
        if (iGeoCoder == null) {
            throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
        }
        if (geoCodeOption == null || geoCodeOption.mAddress == null || geoCodeOption.mCity == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or address or city can not be null");
        }
        return iGeoCoder.geocode(geoCodeOption);
    }

    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (this.f7367a == null) {
            throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
        }
        if (reverseGeoCodeOption == null || reverseGeoCodeOption.getLocation() == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or mLocation can not be null");
        }
        return this.f7367a.reverseGeoCode(reverseGeoCodeOption);
    }

    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        IGeoCoder iGeoCoder = this.f7367a;
        if (iGeoCoder == null) {
            throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
        }
        if (onGetGeoCoderResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        iGeoCoder.setOnGetGeoCodeResultListener(onGetGeoCoderResultListener);
    }
}
