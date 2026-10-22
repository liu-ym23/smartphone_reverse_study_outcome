package com.baidu.mapapi.search.share;

import com.baidu.mapapi.search.route.PlanNode;

/* loaded from: classes.dex */
public class RouteShareURLOption {
    public RouteShareMode mMode;
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public int mPn = 0;
    public int mCityCode = -1;

    public enum RouteShareMode {
        CAR_ROUTE_SHARE_MODE(0),
        FOOT_ROUTE_SHARE_MODE(1),
        CYCLE_ROUTE_SHARE_MODE(2),
        BUS_ROUTE_SHARE_MODE(3);


        /* renamed from: b, reason: collision with root package name */
        private int f7565b;

        RouteShareMode(int i4) {
            this.f7565b = i4;
        }

        public int getRouteShareMode() {
            return this.f7565b;
        }
    }

    public RouteShareURLOption cityCode(int i4) {
        this.mCityCode = i4;
        return this;
    }

    public RouteShareURLOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public RouteShareMode getmMode() {
        return this.mMode;
    }

    public RouteShareURLOption pn(int i4) {
        this.mPn = i4;
        return this;
    }

    public RouteShareURLOption routMode(RouteShareMode routeShareMode) {
        this.mMode = routeShareMode;
        return this;
    }

    public RouteShareURLOption to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
