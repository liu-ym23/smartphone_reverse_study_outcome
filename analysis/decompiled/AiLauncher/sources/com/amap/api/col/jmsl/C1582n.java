package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import java.util.List;

/* renamed from: com.amap.api.col.jmsl.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1582n implements IRouteSearch {

    /* renamed from: a, reason: collision with root package name */
    public RouteSearch.OnRouteSearchListener f16756a;

    /* renamed from: b, reason: collision with root package name */
    public RouteSearch.OnTruckRouteSearchListener f16757b;

    /* renamed from: c, reason: collision with root package name */
    public RouteSearch.OnRoutePlanSearchListener f16758c;

    /* renamed from: d, reason: collision with root package name */
    public Context f16759d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f16760e;

    /* renamed from: com.amap.api.col.jmsl.n$a */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteSearch.WalkRouteQuery f16761a;

        public a(RouteSearch.WalkRouteQuery walkRouteQuery) {
            this.f16761a = walkRouteQuery;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v5, types: [android.os.Handler] */
        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = 102;
            messageObtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            WalkRouteResult walkRouteResultCalculateWalkRoute = null;
            try {
                try {
                    walkRouteResultCalculateWalkRoute = C1582n.this.calculateWalkRoute(this.f16761a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1582n.this.f16756a;
                bundle.putParcelable("result", walkRouteResultCalculateWalkRoute);
                messageObtainMessage.setData(bundle);
                C1582n.this.f16760e.sendMessage(messageObtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.n$b */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteSearch.BusRouteQuery f16763a;

        public b(RouteSearch.BusRouteQuery busRouteQuery) {
            this.f16763a = busRouteQuery;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v5, types: [android.os.Handler] */
        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = 100;
            messageObtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            BusRouteResult busRouteResultCalculateBusRoute = null;
            try {
                try {
                    busRouteResultCalculateBusRoute = C1582n.this.calculateBusRoute(this.f16763a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1582n.this.f16756a;
                bundle.putParcelable("result", busRouteResultCalculateBusRoute);
                messageObtainMessage.setData(bundle);
                C1582n.this.f16760e.sendMessage(messageObtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.n$c */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteSearch.DriveRouteQuery f16765a;

        public c(RouteSearch.DriveRouteQuery driveRouteQuery) {
            this.f16765a = driveRouteQuery;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v5, types: [android.os.Handler] */
        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = 101;
            messageObtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            DriveRouteResult driveRouteResultCalculateDriveRoute = null;
            try {
                try {
                    driveRouteResultCalculateDriveRoute = C1582n.this.calculateDriveRoute(this.f16765a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1582n.this.f16756a;
                bundle.putParcelable("result", driveRouteResultCalculateDriveRoute);
                messageObtainMessage.setData(bundle);
                C1582n.this.f16760e.sendMessage(messageObtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.n$d */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteSearch.RideRouteQuery f16767a;

        public d(RouteSearch.RideRouteQuery rideRouteQuery) {
            this.f16767a = rideRouteQuery;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v5, types: [android.os.Handler] */
        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = 103;
            messageObtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            RideRouteResult rideRouteResultCalculateRideRoute = null;
            try {
                try {
                    rideRouteResultCalculateRideRoute = C1582n.this.calculateRideRoute(this.f16767a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1582n.this.f16756a;
                bundle.putParcelable("result", rideRouteResultCalculateRideRoute);
                messageObtainMessage.setData(bundle);
                C1582n.this.f16760e.sendMessage(messageObtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.n$e */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteSearch.TruckRouteQuery f16769a;

        public e(RouteSearch.TruckRouteQuery truckRouteQuery) {
            this.f16769a = truckRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = 104;
            messageObtainMessage.arg1 = 17;
            Bundle bundle = new Bundle();
            TruckRouteRestult truckRouteRestultCalculateTruckRoute = null;
            try {
                try {
                    truckRouteRestultCalculateTruckRoute = C1582n.this.calculateTruckRoute(this.f16769a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1582n.this.f16757b;
                bundle.putParcelable("result", truckRouteRestultCalculateTruckRoute);
                messageObtainMessage.setData(bundle);
                C1582n.this.f16760e.sendMessage(messageObtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.n$f */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteSearch.DrivePlanQuery f16771a;

        public f(RouteSearch.DrivePlanQuery drivePlanQuery) {
            this.f16771a = drivePlanQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.what = 105;
            messageObtainMessage.arg1 = 18;
            Bundle bundle = new Bundle();
            DriveRoutePlanResult driveRoutePlanResultCalculateDrivePlan = null;
            try {
                try {
                    driveRoutePlanResultCalculateDrivePlan = C1582n.this.calculateDrivePlan(this.f16771a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                }
            } finally {
                messageObtainMessage.obj = C1582n.this.f16758c;
                bundle.putParcelable("result", driveRoutePlanResultCalculateDrivePlan);
                messageObtainMessage.setData(bundle);
                C1582n.this.f16760e.sendMessage(messageObtainMessage);
            }
        }
    }

    public C1582n(Context context) throws AMapException {
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16759d = context.getApplicationContext();
        this.f16760e = HandlerC1626y0.a();
        C1631z1.l(this.f16759d, "RouteSearchCore");
    }

    public final boolean b(RouteSearch.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            C1559h0.c(this.f16759d);
            if (busRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(busRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            RouteSearch.BusRouteQuery busRouteQueryClone = busRouteQuery.m29clone();
            BusRouteResult busRouteResultG = new Y1(this.f16759d, busRouteQueryClone).g();
            if (busRouteResultG != null) {
                busRouteResultG.setBusQuery(busRouteQueryClone);
            }
            return busRouteResultG;
        } catch (AMapException e10) {
            C1631z1.o(e10, "RouteSearch", "calculateBusRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateBusRouteAsyn(RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            C1535b0.c().b(new b(busRouteQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            C1559h0.c(this.f16759d);
            if (drivePlanQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(drivePlanQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            DriveRoutePlanResult driveRoutePlanResultG = new C1574l(this.f16759d, drivePlanQuery.m30clone()).g();
            if (driveRoutePlanResultG != null) {
                driveRoutePlanResultG.setDrivePlanQuery(drivePlanQuery);
            }
            return driveRoutePlanResultG;
        } catch (AMapException e10) {
            C1631z1.o(e10, "RouteSearch", "calculateDrivePlan");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateDrivePlanAsyn(RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            C1535b0.c().b(new f(drivePlanQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            C1559h0.c(this.f16759d);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(driveRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            C1542d.b().k(driveRouteQuery.getPassedByPoints());
            C1542d.b().g(driveRouteQuery.getAvoidpolygons());
            RouteSearch.DriveRouteQuery driveRouteQueryClone = driveRouteQuery.m31clone();
            DriveRouteResult driveRouteResultG = new C1609u(this.f16759d, driveRouteQueryClone).g();
            if (driveRouteResultG != null) {
                driveRouteResultG.setDriveQuery(driveRouteQueryClone);
            }
            return driveRouteResultG;
        } catch (AMapException e10) {
            C1631z1.o(e10, "RouteSearch", "calculateDriveRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateDriveRouteAsyn(RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            C1535b0.c().b(new c(driveRouteQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            C1559h0.c(this.f16759d);
            if (rideRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(rideRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            C1542d.b().c(rideRouteQuery.getFromAndTo());
            RouteSearch.RideRouteQuery rideRouteQueryClone = rideRouteQuery.m33clone();
            RideRouteResult rideRouteResultG = new C1613v(this.f16759d, rideRouteQueryClone).g();
            if (rideRouteResultG != null) {
                rideRouteResultG.setRideQuery(rideRouteQueryClone);
            }
            return rideRouteResultG;
        } catch (AMapException e10) {
            C1631z1.o(e10, "RouteSearch", "calculaterideRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateRideRouteAsyn(RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            C1535b0.c().b(new d(rideRouteQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            C1559h0.c(this.f16759d);
            if (truckRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(truckRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            C1542d.b().d(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
            C1542d c1542dB = C1542d.b();
            List<LatLonPoint> passedByPoints = truckRouteQuery.getPassedByPoints();
            c1542dB.getClass();
            if (passedByPoints != null && 16 < passedByPoints.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
            }
            RouteSearch.TruckRouteQuery truckRouteQueryClone = truckRouteQuery.m34clone();
            TruckRouteRestult truckRouteRestultG = new C1563i0(this.f16759d, truckRouteQueryClone).g();
            if (truckRouteRestultG != null) {
                truckRouteRestultG.setTruckQuery(truckRouteQueryClone);
            }
            return truckRouteRestultG;
        } catch (AMapException e10) {
            C1631z1.o(e10, "RouteSearch", "calculateDriveRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateTruckRouteAsyn(RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            C1535b0.c().b(new e(truckRouteQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            C1559h0.c(this.f16759d);
            if (walkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(walkRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            C1542d.b().i(walkRouteQuery.getFromAndTo());
            RouteSearch.WalkRouteQuery walkRouteQueryClone = walkRouteQuery.m35clone();
            WalkRouteResult walkRouteResultG = new C1630z0(this.f16759d, walkRouteQueryClone).g();
            if (walkRouteResultG != null) {
                walkRouteResultG.setWalkQuery(walkRouteQueryClone);
            }
            return walkRouteResultG;
        } catch (AMapException e10) {
            C1631z1.o(e10, "RouteSearch", "calculateWalkRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateWalkRouteAsyn(RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            C1535b0.c().b(new a(walkRouteQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.f16758c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.f16757b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.f16756a = onRouteSearchListener;
    }
}
