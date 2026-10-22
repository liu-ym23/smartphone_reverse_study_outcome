package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;

/* JADX INFO: loaded from: classes28.dex */
public interface IPoiSearch {
    PoiSearch.SearchBound getBound();

    String getLanguage();

    PoiSearch.Query getQuery();

    PoiResult searchPOI() throws AMapException;

    void searchPOIAsyn();

    PoiItem searchPOIId(String r100) throws AMapException;

    void searchPOIIdAsyn(String r100);

    void setBound(PoiSearch.SearchBound r100);

    void setLanguage(String r100);

    void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener r100);

    void setQuery(PoiSearch.Query r100);
}
