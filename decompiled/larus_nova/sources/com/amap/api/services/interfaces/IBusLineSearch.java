package com.amap.api.services.interfaces;

import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;

/* JADX INFO: loaded from: classes28.dex */
public interface IBusLineSearch {
    BusLineQuery getQuery();

    BusLineResult searchBusLine() throws AMapException;

    void searchBusLineAsyn();

    void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener r100);

    void setQuery(BusLineQuery r100);
}
