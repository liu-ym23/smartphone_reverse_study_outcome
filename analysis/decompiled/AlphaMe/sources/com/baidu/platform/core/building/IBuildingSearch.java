package com.baidu.platform.core.building;

import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;

/* loaded from: classes.dex */
public interface IBuildingSearch {
    void destroy();

    boolean searchBuilding(BuildingSearchOption buildingSearchOption);

    void setOnBuildingSearchListener(OnGetBuildingSearchResultListener onGetBuildingSearchResultListener);
}
