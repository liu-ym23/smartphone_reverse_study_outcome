package com.baidu.mapapi.search.building;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;

/* loaded from: classes.dex */
public class BuildingSearch extends b {

    /* renamed from: b, reason: collision with root package name */
    private boolean f7245b = false;

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.platform.core.building.b f7244a = new com.baidu.platform.core.building.b();

    public static BuildingSearch newInstance() {
        BMapManager.init();
        return new BuildingSearch();
    }

    public void destroy() {
        if (this.f7245b) {
            return;
        }
        this.f7245b = true;
        this.f7244a.destroy();
        BMapManager.destroy();
    }

    public boolean requestBuilding(BuildingSearchOption buildingSearchOption) {
        if (this.f7244a == null) {
            throw new IllegalStateException("BDMapSDKException: BuildingSearch is null, please call newInstance() first.");
        }
        if (buildingSearchOption == null || buildingSearchOption.getLatLng() == null) {
            throw new IllegalStateException("BDMapSDKException: option or location can not be null");
        }
        return this.f7244a.searchBuilding(buildingSearchOption);
    }

    public void setOnGetBuildingSearchResultListener(OnGetBuildingSearchResultListener onGetBuildingSearchResultListener) {
        com.baidu.platform.core.building.b bVar = this.f7244a;
        if (bVar == null) {
            throw new IllegalStateException("BDMapSDKException: BuildingSearch is null, please call newInstance first.");
        }
        if (onGetBuildingSearchResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        bVar.setOnBuildingSearchListener(onGetBuildingSearchResultListener);
    }
}
