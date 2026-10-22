package com.baidu.mapapi.search.route;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.platform.core.route.IRoutePlanSearch;
import com.baidu.platform.core.route.k;

/* loaded from: classes.dex */
public class RoutePlanSearch extends b {

    /* renamed from: b, reason: collision with root package name */
    private boolean f7535b = false;

    /* renamed from: a, reason: collision with root package name */
    private IRoutePlanSearch f7534a = new k();

    public static RoutePlanSearch newInstance() {
        BMapManager.init();
        return new RoutePlanSearch();
    }

    public boolean bikingSearch(BikingRoutePlanOption bikingRoutePlanOption) {
        PlanNode planNode;
        if (this.f7534a == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (bikingRoutePlanOption == null || bikingRoutePlanOption.mTo == null || (planNode = bikingRoutePlanOption.mFrom) == null) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option , origin or destination can not be null");
        }
        if (planNode.getLocation() == null && (bikingRoutePlanOption.mFrom.getName() == null || bikingRoutePlanOption.mFrom.getName().length() <= 0 || bikingRoutePlanOption.mFrom.getCity() == null || bikingRoutePlanOption.mFrom.getCity().length() <= 0)) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option , origin is illegal");
        }
        if (bikingRoutePlanOption.mTo.getLocation() != null || (bikingRoutePlanOption.mTo.getName() != null && bikingRoutePlanOption.mTo.getName().length() > 0 && bikingRoutePlanOption.mTo.getCity() != null && bikingRoutePlanOption.mTo.getCity().length() > 0)) {
            return this.f7534a.bikingSearch(bikingRoutePlanOption);
        }
        throw new IllegalArgumentException("BDMapSDKException: route plan option , destination is illegal");
    }

    public void destroy() {
        if (this.f7535b) {
            return;
        }
        this.f7535b = true;
        this.f7534a.destroy();
        BMapManager.destroy();
    }

    public boolean drivingSearch(DrivingRoutePlanOption drivingRoutePlanOption) {
        IRoutePlanSearch iRoutePlanSearch = this.f7534a;
        if (iRoutePlanSearch == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (drivingRoutePlanOption == null || drivingRoutePlanOption.mTo == null || drivingRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option , origin or destination can not be null");
        }
        return iRoutePlanSearch.drivingSearch(drivingRoutePlanOption);
    }

    public boolean masstransitSearch(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        PlanNode planNode;
        if (this.f7534a == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (massTransitRoutePlanOption == null || massTransitRoutePlanOption.mTo == null || (planNode = massTransitRoutePlanOption.mFrom) == null) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option,origin or destination can not be null");
        }
        if (planNode.getLocation() == null && (massTransitRoutePlanOption.mFrom.getName() == null || massTransitRoutePlanOption.mFrom.getCity() == null)) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option,origin is illegal");
        }
        if (massTransitRoutePlanOption.mTo.getLocation() == null && (massTransitRoutePlanOption.mTo.getName() == null || massTransitRoutePlanOption.mTo.getCity() == null)) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option,destination is illegal");
        }
        return this.f7534a.masstransitSearch(massTransitRoutePlanOption);
    }

    public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        IRoutePlanSearch iRoutePlanSearch = this.f7534a;
        if (iRoutePlanSearch == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (onGetRoutePlanResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        iRoutePlanSearch.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
    }

    public boolean transitSearch(TransitRoutePlanOption transitRoutePlanOption) {
        IRoutePlanSearch iRoutePlanSearch = this.f7534a;
        if (iRoutePlanSearch == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (transitRoutePlanOption == null || transitRoutePlanOption.mCityName == null || transitRoutePlanOption.mTo == null || transitRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option,origin or destination or city can not be null");
        }
        return iRoutePlanSearch.transitSearch(transitRoutePlanOption);
    }

    public boolean walkingIndoorSearch(IndoorRoutePlanOption indoorRoutePlanOption) {
        IRoutePlanSearch iRoutePlanSearch = this.f7534a;
        if (iRoutePlanSearch == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (indoorRoutePlanOption == null || indoorRoutePlanOption.mTo == null || indoorRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
        }
        return iRoutePlanSearch.walkingIndoorSearch(indoorRoutePlanOption);
    }

    public boolean walkingIntegralSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        IRoutePlanSearch iRoutePlanSearch = this.f7534a;
        if (iRoutePlanSearch == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (walkingRoutePlanOption == null || walkingRoutePlanOption.mTo == null || walkingRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
        }
        return iRoutePlanSearch.walkingIntegralSearch(walkingRoutePlanOption);
    }

    public boolean walkingSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        IRoutePlanSearch iRoutePlanSearch = this.f7534a;
        if (iRoutePlanSearch == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (walkingRoutePlanOption == null || walkingRoutePlanOption.mTo == null || walkingRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
        }
        return iRoutePlanSearch.walkingSearch(walkingRoutePlanOption);
    }
}
