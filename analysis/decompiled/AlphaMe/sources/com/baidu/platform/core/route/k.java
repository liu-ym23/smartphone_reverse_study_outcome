package com.baidu.platform.core.route;

import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes.dex */
public class k extends com.baidu.platform.base.a implements IRoutePlanSearch {

    /* renamed from: g, reason: collision with root package name */
    private OnGetRoutePlanResultListener f9389g = null;

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean bikingSearch(BikingRoutePlanOption bikingRoutePlanOption) {
        a aVar = new a();
        aVar.a(SearchType.BIKE_ROUTE);
        return a(new b(bikingRoutePlanOption), this.f9389g, aVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public void destroy() {
        this.f8564c.lock();
        this.f9389g = null;
        this.f8564c.unlock();
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean drivingSearch(DrivingRoutePlanOption drivingRoutePlanOption) {
        c cVar = new c();
        cVar.a(SearchType.DRIVE_ROUTE);
        return a(new d(drivingRoutePlanOption), this.f9389g, cVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean masstransitSearch(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        i iVar = new i();
        iVar.a(SearchType.MASS_TRANSIT_ROUTE);
        return a(new j(massTransitRoutePlanOption), this.f9389g, iVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        this.f8564c.lock();
        this.f9389g = onGetRoutePlanResultListener;
        this.f8564c.unlock();
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean transitSearch(TransitRoutePlanOption transitRoutePlanOption) {
        m mVar = new m();
        mVar.a(SearchType.TRANSIT_ROUTE);
        return a(new n(transitRoutePlanOption), this.f9389g, mVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean walkingIndoorSearch(IndoorRoutePlanOption indoorRoutePlanOption) {
        e eVar = new e();
        eVar.a(SearchType.INDOOR_ROUTE);
        return a(new f(indoorRoutePlanOption), this.f9389g, eVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean walkingIntegralSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        g gVar = new g();
        gVar.a(SearchType.INTEGRAL_ROUTE);
        return a(new h(walkingRoutePlanOption), this.f9389g, gVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean walkingSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        o oVar = new o();
        oVar.a(SearchType.WALK_ROUTE);
        return a(new p(walkingRoutePlanOption), this.f9389g, oVar);
    }
}
