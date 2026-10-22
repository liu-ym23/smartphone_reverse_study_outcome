package com.amap.api.services.interfaces;

import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;

/* JADX INFO: loaded from: classes28.dex */
public interface IBusStationSearch {
    BusStationQuery getQuery();

    BusStationResult searchBusStation() throws AMapException;

    void searchBusStationAsyn();

    void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener r100);

    void setQuery(BusStationQuery r100);
}
