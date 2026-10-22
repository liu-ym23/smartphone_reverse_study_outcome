package com.baidu.platform.core.district;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.SearchType;

/* loaded from: classes.dex */
public class d extends com.baidu.platform.base.a implements IDistrictSearch {

    /* renamed from: g, reason: collision with root package name */
    private OnGetDistricSearchResultListener f9376g = null;

    @Override // com.baidu.platform.core.district.IDistrictSearch
    public void destroy() {
        this.f8564c.lock();
        this.f9376g = null;
        this.f8564c.unlock();
    }

    @Override // com.baidu.platform.core.district.IDistrictSearch
    public boolean searchDistrict(DistrictSearchOption districtSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.DISTRICT_SEARCH);
        return a(new a(districtSearchOption), this.f9376g, bVar);
    }

    @Override // com.baidu.platform.core.district.IDistrictSearch
    public void setOnDistrictSearchListener(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        this.f8564c.lock();
        this.f9376g = onGetDistricSearchResultListener;
        this.f8564c.unlock();
    }
}
