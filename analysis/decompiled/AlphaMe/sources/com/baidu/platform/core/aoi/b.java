package com.baidu.platform.core.aoi;

import com.baidu.mapapi.search.aoi.AoiSearchOption;
import com.baidu.mapapi.search.aoi.OnGetAoiSearchResultListener;
import com.baidu.platform.base.SearchType;

/* loaded from: classes.dex */
public class b extends com.baidu.platform.base.a implements IAoiSearch {

    /* renamed from: g, reason: collision with root package name */
    private OnGetAoiSearchResultListener f9370g;

    @Override // com.baidu.platform.core.aoi.IAoiSearch
    public void destroy() {
        this.f8564c.lock();
        this.f9370g = null;
        this.f8564c.unlock();
    }

    @Override // com.baidu.platform.core.aoi.IAoiSearch
    public boolean searchAoi(AoiSearchOption aoiSearchOption) {
        a aVar = new a();
        aVar.a(SearchType.AOI_SEARCH);
        return a(new c(aoiSearchOption), this.f9370g, aVar);
    }

    @Override // com.baidu.platform.core.aoi.IAoiSearch
    public void setOnAoiSearchListener(OnGetAoiSearchResultListener onGetAoiSearchResultListener) {
        this.f8564c.lock();
        this.f9370g = onGetAoiSearchResultListener;
        this.f8564c.unlock();
    }
}
