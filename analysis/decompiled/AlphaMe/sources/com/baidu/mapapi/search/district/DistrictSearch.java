package com.baidu.mapapi.search.district;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.platform.core.district.IDistrictSearch;
import com.baidu.platform.core.district.d;

/* loaded from: classes.dex */
public class DistrictSearch extends b {

    /* renamed from: a, reason: collision with root package name */
    private IDistrictSearch f7360a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7361b = false;

    public DistrictSearch() {
        this.f7360a = null;
        this.f7360a = new d();
    }

    public static DistrictSearch newInstance() {
        BMapManager.init();
        return new DistrictSearch();
    }

    public void destroy() {
        if (this.f7361b) {
            return;
        }
        this.f7361b = true;
        this.f7360a.destroy();
        BMapManager.destroy();
    }

    public boolean searchDistrict(DistrictSearchOption districtSearchOption) {
        String str;
        if (this.f7360a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (districtSearchOption == null || (str = districtSearchOption.mCityName) == null || str.equals("")) {
            throw new IllegalArgumentException("BDMapSDKException: option or city name can not be null or empty.");
        }
        return this.f7360a.searchDistrict(districtSearchOption);
    }

    public void setOnDistrictSearchListener(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        IDistrictSearch iDistrictSearch = this.f7360a;
        if (iDistrictSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (onGetDistricSearchResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        iDistrictSearch.setOnDistrictSearchListener(onGetDistricSearchResultListener);
    }
}
