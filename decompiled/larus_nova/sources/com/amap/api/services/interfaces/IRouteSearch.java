package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

/* JADX INFO: loaded from: classes28.dex */
public interface IRouteSearch {
    BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery r100) throws AMapException;

    void calculateBusRouteAsyn(RouteSearch.BusRouteQuery r100);

    DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery r100) throws AMapException;

    void calculateDrivePlanAsyn(RouteSearch.DrivePlanQuery r100);

    DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery r100) throws AMapException;

    void calculateDriveRouteAsyn(RouteSearch.DriveRouteQuery r100);

    RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery r100) throws AMapException;

    void calculateRideRouteAsyn(RouteSearch.RideRouteQuery r100);

    TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery r100) throws AMapException;

    void calculateTruckRouteAsyn(RouteSearch.TruckRouteQuery r100);

    WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery r100) throws AMapException;

    void calculateWalkRouteAsyn(RouteSearch.WalkRouteQuery r100);

    void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener r100);

    void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener r100);

    void setRouteSearchListener(RouteSearch.OnRouteSearchListener r100);
}
