package com.baidu.mapapi.search.route;

import java.util.List;

/* loaded from: classes.dex */
public class BikingRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;

    /* renamed from: a, reason: collision with root package name */
    private List<PlanNode> f7452a = null;
    public String mRoadPrefer = "0";
    public int mRidingType = 0;

    public BikingRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public List<PlanNode> getWayPoints() {
        return this.f7452a;
    }

    public BikingRoutePlanOption passBy(List<PlanNode> list) {
        this.f7452a = list;
        return this;
    }

    public BikingRoutePlanOption ridingType(int i4) {
        this.mRidingType = i4;
        return this;
    }

    public BikingRoutePlanOption roadPrefer(String str) {
        this.mRoadPrefer = str;
        return this;
    }

    public BikingRoutePlanOption to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
