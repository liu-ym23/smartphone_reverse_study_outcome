package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* JADX INFO: loaded from: classes28.dex */
public interface IRoutePOISearch {
    RoutePOISearchQuery getQuery();

    RoutePOISearchResult searchRoutePOI() throws AMapException;

    void searchRoutePOIAsyn();

    void setQuery(RoutePOISearchQuery r100);

    void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener r100);
}
