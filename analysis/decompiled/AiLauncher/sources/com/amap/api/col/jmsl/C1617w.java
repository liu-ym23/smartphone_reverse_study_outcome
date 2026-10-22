package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;
import java.util.List;

/* renamed from: com.amap.api.col.jmsl.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1617w implements IRouteSearchV2 {

    /* renamed from: a, reason: collision with root package name */
    public RouteSearchV2.OnRouteSearchListener f16995a;

    /* renamed from: b, reason: collision with root package name */
    public Context f16996b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f16997c;

    /* renamed from: com.amap.api.col.jmsl.w$a */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteSearchV2.DriveRouteQuery f16998a;

        public a(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
            this.f16998a = driveRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = 101;
            messageObtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            DriveRouteResultV2 driveRouteResultV2CalculateDriveRoute = null;
            try {
                try {
                    driveRouteResultV2CalculateDriveRoute = C1617w.this.calculateDriveRoute(this.f16998a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1617w.this.f16995a;
                bundle.putParcelable("result", driveRouteResultV2CalculateDriveRoute);
                messageObtainMessage.setData(bundle);
                C1617w.this.f16997c.sendMessage(messageObtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.w$b */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteSearchV2.WalkRouteQuery f17000a;

        public b(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
            this.f17000a = walkRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = 102;
            messageObtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            WalkRouteResultV2 walkRouteResultV2CalculateWalkRoute = null;
            try {
                try {
                    walkRouteResultV2CalculateWalkRoute = C1617w.this.calculateWalkRoute(this.f17000a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1617w.this.f16995a;
                bundle.putParcelable("result", walkRouteResultV2CalculateWalkRoute);
                messageObtainMessage.setData(bundle);
                C1617w.this.f16997c.sendMessage(messageObtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.w$c */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteSearchV2.RideRouteQuery f17002a;

        public c(RouteSearchV2.RideRouteQuery rideRouteQuery) {
            this.f17002a = rideRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = 103;
            messageObtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            RideRouteResultV2 rideRouteResultV2CalculateRideRoute = null;
            try {
                try {
                    rideRouteResultV2CalculateRideRoute = C1617w.this.calculateRideRoute(this.f17002a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1617w.this.f16995a;
                bundle.putParcelable("result", rideRouteResultV2CalculateRideRoute);
                messageObtainMessage.setData(bundle);
                C1617w.this.f16997c.sendMessage(messageObtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.w$d */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteSearchV2.BusRouteQuery f17004a;

        public d(RouteSearchV2.BusRouteQuery busRouteQuery) {
            this.f17004a = busRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = 100;
            messageObtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            BusRouteResultV2 busRouteResultV2CalculateBusRoute = null;
            try {
                try {
                    busRouteResultV2CalculateBusRoute = C1617w.this.calculateBusRoute(this.f17004a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1617w.this.f16995a;
                bundle.putParcelable("result", busRouteResultV2CalculateBusRoute);
                messageObtainMessage.setData(bundle);
                C1617w.this.f16997c.sendMessage(messageObtainMessage);
            }
        }
    }

    public C1617w(Context context) throws AMapException {
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16996b = context.getApplicationContext();
        this.f16997c = HandlerC1626y0.a();
        C1631z1.l(this.f16996b, "RouteSearchCoreV2");
    }

    public final boolean b(RouteSearchV2.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public BusRouteResultV2 calculateBusRoute(RouteSearchV2.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            C1559h0.c(this.f16996b);
            if (busRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(busRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            RouteSearchV2.BusRouteQuery busRouteQueryClone = busRouteQuery.m36clone();
            BusRouteResultV2 busRouteResultV2G = new C1557g2(this.f16996b, busRouteQueryClone).g();
            if (busRouteResultV2G != null) {
                busRouteResultV2G.setBusQuery(busRouteQueryClone);
            }
            return busRouteResultV2G;
        } catch (AMapException e10) {
            C1631z1.o(e10, "RouteSearch", "calculateBusRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public void calculateBusRouteAsyn(RouteSearchV2.BusRouteQuery busRouteQuery) {
        try {
            C1535b0.c().b(new d(busRouteQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            C1559h0.c(this.f16996b);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(driveRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            C1542d c1542dB = C1542d.b();
            List<LatLonPoint> passedByPoints = driveRouteQuery.getPassedByPoints();
            c1542dB.getClass();
            if (passedByPoints != null && 16 < passedByPoints.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
            }
            C1542d.b().g(driveRouteQuery.getAvoidpolygons());
            RouteSearchV2.DriveRouteQuery driveRouteQueryClone = driveRouteQuery.m37clone();
            DriveRouteResultV2 driveRouteResultV2G = new B(this.f16996b, driveRouteQueryClone).g();
            if (driveRouteResultV2G != null) {
                driveRouteResultV2G.setDriveQuery(driveRouteQueryClone);
            }
            return driveRouteResultV2G;
        } catch (AMapException e10) {
            C1631z1.o(e10, "RouteSearch", "calculateDriveRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public void calculateDriveRouteAsyn(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        try {
            C1535b0.c().b(new a(driveRouteQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public RideRouteResultV2 calculateRideRoute(RouteSearchV2.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            C1559h0.c(this.f16996b);
            if (rideRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(rideRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            C1542d.b().e(rideRouteQuery.getFromAndTo());
            RouteSearchV2.RideRouteQuery rideRouteQueryClone = rideRouteQuery.m39clone();
            RideRouteResultV2 rideRouteResultV2G = new C(this.f16996b, rideRouteQueryClone).g();
            if (rideRouteResultV2G != null) {
                rideRouteResultV2G.setRideQuery(rideRouteQueryClone);
            }
            return rideRouteResultV2G;
        } catch (AMapException e10) {
            C1631z1.o(e10, "RouteSearch", "calculaterideRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public void calculateRideRouteAsyn(RouteSearchV2.RideRouteQuery rideRouteQuery) {
        try {
            C1535b0.c().b(new c(rideRouteQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public WalkRouteResultV2 calculateWalkRoute(RouteSearchV2.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            C1559h0.c(this.f16996b);
            if (walkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(walkRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            C1542d.b().j(walkRouteQuery.getFromAndTo());
            RouteSearchV2.WalkRouteQuery walkRouteQueryClone = walkRouteQuery.m40clone();
            WalkRouteResultV2 walkRouteResultV2G = new I0(this.f16996b, walkRouteQueryClone).g();
            if (walkRouteResultV2G != null) {
                walkRouteResultV2G.setWalkQuery(walkRouteQueryClone);
            }
            return walkRouteResultV2G;
        } catch (AMapException e10) {
            C1631z1.o(e10, "RouteSearch", "calculateWalkRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public void calculateWalkRouteAsyn(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        try {
            C1535b0.c().b(new b(walkRouteQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener) {
        this.f16995a = onRouteSearchListener;
    }
}
