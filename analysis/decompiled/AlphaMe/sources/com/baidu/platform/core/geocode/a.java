package com.baidu.platform.core.geocode;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes.dex */
public class a extends com.baidu.platform.base.a implements IGeoCoder {

    /* renamed from: g, reason: collision with root package name */
    OnGetGeoCoderResultListener f9377g = null;

    @Override // com.baidu.platform.core.geocode.IGeoCoder
    public void destroy() {
        this.f8564c.lock();
        this.f9377g = null;
        this.f8564c.unlock();
    }

    @Override // com.baidu.platform.core.geocode.IGeoCoder
    public boolean geocode(GeoCodeOption geoCodeOption) {
        b bVar = new b();
        com.baidu.platform.base.c cVar = new c(geoCodeOption);
        bVar.a(SearchType.GEO_CODER);
        if (geoCodeOption != null) {
            bVar.b(geoCodeOption.getAddress());
        }
        return a(cVar, this.f9377g, bVar);
    }

    @Override // com.baidu.platform.core.geocode.IGeoCoder
    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        d dVar = new d();
        e eVar = new e(reverseGeoCodeOption);
        dVar.a(SearchType.REVERSE_GEO_CODER);
        return a(eVar, this.f9377g, dVar);
    }

    @Override // com.baidu.platform.core.geocode.IGeoCoder
    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        this.f8564c.lock();
        this.f9377g = onGetGeoCoderResultListener;
        this.f8564c.unlock();
    }
}
