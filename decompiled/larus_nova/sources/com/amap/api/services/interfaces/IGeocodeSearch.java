package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public interface IGeocodeSearch {
    RegeocodeAddress getFromLocation(RegeocodeQuery r100) throws AMapException;

    void getFromLocationAsyn(RegeocodeQuery r100);

    List<GeocodeAddress> getFromLocationName(GeocodeQuery r100) throws AMapException;

    void getFromLocationNameAsyn(GeocodeQuery r100);

    void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener r100);
}
