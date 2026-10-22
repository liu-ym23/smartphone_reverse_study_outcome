package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.share.ShareSearch;

/* JADX INFO: loaded from: classes28.dex */
public interface IShareSearch {
    String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery r100) throws AMapException;

    void searchBusRouteShareUrlAsyn(ShareSearch.ShareBusRouteQuery r100);

    String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery r100) throws AMapException;

    void searchDrivingRouteShareUrlAsyn(ShareSearch.ShareDrivingRouteQuery r100);

    String searchLocationShareUrl(LatLonSharePoint r100) throws AMapException;

    void searchLocationShareUrlAsyn(LatLonSharePoint r100);

    String searchNaviShareUrl(ShareSearch.ShareNaviQuery r100) throws AMapException;

    void searchNaviShareUrlAsyn(ShareSearch.ShareNaviQuery r100);

    String searchPoiShareUrl(PoiItem r100) throws AMapException;

    void searchPoiShareUrlAsyn(PoiItem r100);

    String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery r100) throws AMapException;

    void searchWalkRouteShareUrlAsyn(ShareSearch.ShareWalkRouteQuery r100);

    void setOnShareSearchListener(ShareSearch.OnShareSearchListener r100);
}
