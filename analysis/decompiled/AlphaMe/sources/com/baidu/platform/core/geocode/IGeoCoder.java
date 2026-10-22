package com.baidu.platform.core.geocode;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;

/* loaded from: classes.dex */
public interface IGeoCoder {
    void destroy();

    boolean geocode(GeoCodeOption geoCodeOption);

    boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption);

    void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener);
}
