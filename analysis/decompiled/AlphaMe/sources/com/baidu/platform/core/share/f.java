package com.baidu.platform.core.share;

import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes.dex */
public class f extends com.baidu.platform.base.a implements IShareUrlSearch {

    /* renamed from: g, reason: collision with root package name */
    OnGetShareUrlResultListener f9394g = null;

    @Override // com.baidu.platform.core.share.IShareUrlSearch
    public void destroy() {
        this.f8564c.lock();
        this.f9394g = null;
        this.f8564c.unlock();
    }

    @Override // com.baidu.platform.core.share.IShareUrlSearch
    public boolean requestLocationShareUrl(LocationShareURLOption locationShareURLOption) {
        e eVar = new e();
        eVar.a(SearchType.LOCATION_SEARCH_SHARE);
        return a(new a(locationShareURLOption), this.f9394g, eVar);
    }

    @Override // com.baidu.platform.core.share.IShareUrlSearch
    public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption poiDetailShareURLOption) {
        e eVar = new e();
        eVar.a(SearchType.POI_DETAIL_SHARE);
        return a(new b(poiDetailShareURLOption), this.f9394g, eVar);
    }

    @Override // com.baidu.platform.core.share.IShareUrlSearch
    public boolean requestRouteShareUrl(RouteShareURLOption routeShareURLOption) {
        c cVar = new c();
        cVar.a(SearchType.ROUTE_PLAN_SHARE);
        return a(new d(routeShareURLOption), this.f9394g, cVar);
    }

    @Override // com.baidu.platform.core.share.IShareUrlSearch
    public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        this.f8564c.lock();
        this.f9394g = onGetShareUrlResultListener;
        this.f8564c.unlock();
    }
}
