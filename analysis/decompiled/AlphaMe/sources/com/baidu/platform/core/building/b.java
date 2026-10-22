package com.baidu.platform.core.building;

import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;
import com.baidu.platform.base.SearchType;

/* loaded from: classes.dex */
public class b extends com.baidu.platform.base.a implements IBuildingSearch {

    /* renamed from: g, reason: collision with root package name */
    private OnGetBuildingSearchResultListener f9372g;

    @Override // com.baidu.platform.core.building.IBuildingSearch
    public void destroy() {
        this.f8564c.lock();
        this.f9372g = null;
        this.f8564c.unlock();
    }

    @Override // com.baidu.platform.core.building.IBuildingSearch
    public boolean searchBuilding(BuildingSearchOption buildingSearchOption) {
        a aVar = new a();
        aVar.a(SearchType.BUILDING_SEARCH);
        return a(new c(buildingSearchOption), this.f9372g, aVar);
    }

    @Override // com.baidu.platform.core.building.IBuildingSearch
    public void setOnBuildingSearchListener(OnGetBuildingSearchResultListener onGetBuildingSearchResultListener) {
        this.f8564c.lock();
        this.f9372g = onGetBuildingSearchResultListener;
        this.f8564c.unlock();
    }
}
