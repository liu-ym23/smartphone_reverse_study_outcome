package com.baidu.platform.core.aoi;

import com.baidu.mapapi.search.aoi.AoiSearchOption;
import com.baidu.mapapi.search.aoi.OnGetAoiSearchResultListener;

/* loaded from: classes.dex */
public interface IAoiSearch {
    void destroy();

    boolean searchAoi(AoiSearchOption aoiSearchOption);

    void setOnAoiSearchListener(OnGetAoiSearchResultListener onGetAoiSearchResultListener);
}
