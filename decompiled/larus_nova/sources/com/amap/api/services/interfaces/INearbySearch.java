package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;

/* JADX INFO: loaded from: classes28.dex */
public interface INearbySearch {
    void addNearbyListener(NearbySearch.NearbyListener r100);

    void clearUserInfoAsyn();

    void destroy();

    void removeNearbyListener(NearbySearch.NearbyListener r100);

    NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery r100) throws AMapException;

    void searchNearbyInfoAsyn(NearbySearch.NearbyQuery r100);

    void setUserID(String r100);

    void startUploadNearbyInfoAuto(UploadInfoCallback r100, int r101);

    void stopUploadNearbyInfoAuto();

    void uploadNearbyInfoAsyn(UploadInfo r100);
}
