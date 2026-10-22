package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

/* JADX INFO: loaded from: classes28.dex */
public interface IDistanceSearch {
    DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery r100) throws AMapException;

    void calculateRouteDistanceAsyn(DistanceSearch.DistanceQuery r100);

    void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener r100);
}
