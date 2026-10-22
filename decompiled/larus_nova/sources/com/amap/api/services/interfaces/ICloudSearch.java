package com.amap.api.services.interfaces;

import com.amap.api.services.cloud.CloudSearch;

/* JADX INFO: loaded from: classes28.dex */
public interface ICloudSearch {
    void searchCloudAsyn(CloudSearch.Query r100);

    void searchCloudDetailAsyn(String r100, String r101);

    void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener r100);
}
